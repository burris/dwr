/*
 * Copyright 2005 Joe Walker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ltd.getahead.dwr.dwrp;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.Calls;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.MarshallException;
import uk.ltd.getahead.dwr.Marshaller;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.Replies;
import uk.ltd.getahead.dwr.Reply;
import uk.ltd.getahead.dwr.ScriptConduit;
import uk.ltd.getahead.dwr.ScriptSession;
import uk.ltd.getahead.dwr.WebContextFactory;
import uk.ltd.getahead.dwr.util.JavascriptUtil;
import uk.ltd.getahead.dwr.util.Logger;
import uk.ltd.getahead.dwr.util.Messages;
import uk.ltd.getahead.dwr.util.MimeConstants;
import uk.ltd.getahead.dwr.util.TypeHintContext;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DwrpPlainJsMarshaller implements Marshaller
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Marshaller#marshallInbound(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public Calls marshallInbound(HttpServletRequest request, HttpServletResponse response) throws MarshallException, IOException
    {
        response.setContentType(getOutboundMimeType());
        PrintWriter out = response.getWriter();
        request.setAttribute(ATTRIBUTE_REQUEST, out);

        out.print(getOutboundScriptPrefix());

        // Are there any outstanding reverse-ajax scripts to be passed on?
        DirectScriptConduit conduit = new DirectScriptConduit(out, response);
        request.setAttribute(ATTRIBUTE_CONDUIT, conduit);

        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        scriptSession.addScriptConduit(conduit);

        RequestParser requestParser = new RequestParser();
        CallsWithContext calls = requestParser.parseRequest(request);

        // Debug the environment
        if (log.isDebugEnabled() && calls.getCallCount() > 0)
        {
            // We can just use 0 because they are all shared
            InboundContext inctx = calls.getCallWithContext(0).getInboundContext();
            StringBuffer buffer = new StringBuffer();

            for (Iterator it = inctx.getInboundVariableNames(); it.hasNext();)
            {
                String key = (String) it.next();
                InboundVariable value = inctx.getInboundVariable(key);
                if (key.startsWith(ConversionConstants.INBOUND_CALLNUM_PREFIX) &&
                    key.indexOf(ConversionConstants.INBOUND_CALLNUM_SUFFIX + ConversionConstants.INBOUND_KEY_ENV) != -1)
                {
                    buffer.append(key + '=' + value.toString() + ", "); //$NON-NLS-1$
                }
            }

            if (buffer.length() > 0)
            {
                log.debug("Environment:  " + buffer.toString()); //$NON-NLS-1$
            }
        }

        for (int callNum = 0; callNum < calls.getCallCount(); callNum++)
        {
            CallWithContext call = calls.getCallWithContext(callNum);
            InboundContext inctx = call.getInboundContext();


            // Get a list of the available matching methods with the coerced
            // parameters that we will use to call it if we choose to use
            // that method.
            Creator creator = creatorManager.getCreator(call.getScriptName());

            // Which method are we using?
            Method method = findMethod(call);
            call.setMethod(method);
            if (method == null)
            {
                String name = call.getScriptName() + '.' + call.getMethodName();
                throw new IllegalArgumentException(Messages.getString("DefaultRemoter.UnknownMethod", name)); //$NON-NLS-1$
            }

            // Check this method is accessible
            String reason = accessControl.getReasonToNotExecute(creator, call.getScriptName(), method);
            if (reason != null)
            {
                throw new SecurityException(Messages.getString("ExecuteQuery.AccessDenied")); //$NON-NLS-1$
            }

            // Convert all the parameters to the correct types
            Object[] params = new Object[method.getParameterTypes().length];
            for (int j = 0; j < method.getParameterTypes().length; j++)
            {
                Class paramType = method.getParameterTypes()[j];
                InboundVariable param = inctx.getParameter(callNum, j);
                TypeHintContext incc = new TypeHintContext(method, j);

                params[j] = converterManager.convertInbound(paramType, param, inctx, incc);
            }

            call.setParameters(params);
        }

        return calls;
    }

    /**
     * Find the method the best matches the method name and parameters
     * @param call The function call we are going to make
     * @return A matching method, or null if one was not found.
     */
    private Method findMethod(CallWithContext call)
    {
        if (call.getScriptName() == null)
        {
            throw new IllegalArgumentException(Messages.getString("DefaultRemoter.MissingClassParam")); //$NON-NLS-1$
        }

        if (call.getMethodName() == null)
        {
            throw new IllegalArgumentException(Messages.getString("DefaultRemoter.MissingMethodParam")); //$NON-NLS-1$
        }

        Creator creator = creatorManager.getCreator(call.getScriptName());
        Method[] methods = creator.getType().getMethods();
        List available = new ArrayList();

        methods:
        for (int i = 0; i < methods.length; i++)
        {
            // Check method name and access
            if (methods[i].getName().equals(call.getMethodName()))
            {
                // Check number of parameters
                if (methods[i].getParameterTypes().length == call.getInboundContext().getParameterCount())
                {
                    // Clear the previous conversion attempts (the param types
                    // will probably be different)
                    call.getInboundContext().clearConverted();

                    // Check parameter types
                    for (int j = 0; j < methods[i].getParameterTypes().length; j++)
                    {
                        Class paramType = methods[i].getParameterTypes()[j];
                        if (!converterManager.isConvertable(paramType))
                        {
                            // Give up with this method and try the next
                            continue methods;
                        }
                    }

                    available.add(methods[i]);
                }
            }
        }

        // Pick a method to call
        if (available.size() > 1)
        {
            log.warn("Warning multiple matching methods. Using first match."); //$NON-NLS-1$
        }

        if (available.isEmpty())
        {
            String name = call.getScriptName() + '.' + call.getMethodName();
            throw new IllegalArgumentException(Messages.getString("DefaultRemoter.UnknownMethod", name)); //$NON-NLS-1$
        }

        // At the moment we are just going to take the first match, for a
        // later increment we might pick the best implementation
        return (Method) available.get(0);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Marshaller#marshallOutbound(uk.ltd.getahead.dwr.Replies, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void marshallOutbound(Replies replies, HttpServletRequest request, HttpServletResponse response) throws MarshallException, IOException
    {
        // We build the answer up in a StringBuffer because that makes is easier
        // to debug, and because that's only what the compiler does anyway.
        PrintWriter out = (PrintWriter) request.getAttribute(ATTRIBUTE_REQUEST);
        DirectScriptConduit conduit = (DirectScriptConduit) request.getAttribute(ATTRIBUTE_CONDUIT);

        synchronized (out)
        {
            out.print(getOutboundScriptPrefix());
            response.flushBuffer();
        }

        // if we are in html (iframe mode) we need to direct script to the parent
        String prefix = getOutboundLinePrefix();

        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();

        OutboundContext converted = new OutboundContext();
        for (int i = 0; i < replies.getReplyCount(); i++)
        {
            Reply reply = replies.getReply(i);

            // The existance of a throwable indicates that something went wrong
            if (reply.getThrowable() != null)
            {
                Throwable ex = reply.getThrowable();
                OutboundVariable ov = convertException(ex, converted);

                synchronized (out)
                {
                    out.print(ov.getInitCode());
                    out.print(prefix);
                    out.print("DWREngine._handleServerError('"); //$NON-NLS-1$
                    out.print(reply.getId());
                    out.print("', "); //$NON-NLS-1$
                    out.print(ov.getAssignCode());
                    out.print(");\n"); //$NON-NLS-1$
                    response.flushBuffer();
                }

                log.warn("--Erroring: id[" + reply.getId() + "] message[" + ex.toString() + ']'); //$NON-NLS-1$ //$NON-NLS-2$
            }
            else
            {
                Object data = reply.getReply();
                OutboundVariable ov = converterManager.convertOutbound(data, converted);

                synchronized (out)
                {
                    out.print(ov.getInitCode());
                    out.print(prefix);
                    out.print("DWREngine._handleResponse('"); //$NON-NLS-1$
                    out.print(reply.getId());
                    out.print("', "); //$NON-NLS-1$
                    out.print(ov.getAssignCode());
                    out.print(");\n"); //$NON-NLS-1$
                    response.flushBuffer();
                }
            }
        }

        scriptSession.removeScriptConduit(conduit);
        out.print(getOutboundScriptSuffix());

        // log.debug(replyString);
    }

    /**
     * iframe mode starts as HTML, so get into script mode
     * @return A script prefix
     */
    protected String getOutboundMimeType()
    {
        return MimeConstants.MIME_PLAIN;
    }

    /**
     * iframe mode starts as HTML, so get into script mode
     * @return A script prefix
     */
    protected String getOutboundScriptPrefix()
    {
        return ""; //$NON-NLS-1$
    }

    /**
     * iframe mode needs to get out of script mode
     * @return A script suffix
     */
    protected String getOutboundScriptSuffix()
    {
        return ""; //$NON-NLS-1$
    }

    /**
     * Do we need to prefix variable declarations to be visible to another frame
     * @return A declaration prefix
     */
    protected String getOutboundLinePrefix()
    {
        return ""; //$NON-NLS-1$
    }

    /**
     * Convert an exception into an outbound variable
     * @param th The exception to be converted
     * @param converted The conversion context
     * @return A new outbound exception
     */
    private OutboundVariable convertException(Throwable th, OutboundContext converted)
    {
        try
        {
            if (converterManager.isConvertable(th.getClass()))
            {
                return converterManager.convertOutbound(th, converted);
            }
        }
        catch (MarshallException ex)
        {
            log.warn("Exception while converting. Exception to be converted: " + th, ex); //$NON-NLS-1$
        }

        // So we will have to create one for ourselves
        OutboundVariable ov = new OutboundVariable();
        String varName = converted.getNextVariableName();
        ov.setAssignCode(varName);
        ov.setInitCode("var " + varName + " = \"" + JavascriptUtil.escapeJavaScript(th.getMessage()) + "\";"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        return ov;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Marshaller#isConvertable(java.lang.Class)
     */
    public boolean isConvertable(Class paramType)
    {
        return converterManager.isConvertable(paramType);
    }

    /**
     * Accessor for the DefaultCreatorManager that we configure
     * @param converterManager The new DefaultConverterManager
     */
    public void setConverterManager(ConverterManager converterManager)
    {
        this.converterManager = converterManager;
    }

    /**
     * Accessor for the DefaultCreatorManager that we configure
     * @param creatorManager The new DefaultConverterManager
     */
    public void setCreatorManager(CreatorManager creatorManager)
    {
        this.creatorManager = creatorManager;
    }

    /**
     * Accessor for the security manager
     * @param accessControl The accessControl to set.
     */
    public void setAccessControl(AccessControl accessControl)
    {
        this.accessControl = accessControl;
    }

    /**
     * A ScriptConduit that works with the parent Marshaller
     */
    private static class DirectScriptConduit implements ScriptConduit
    {
        /**
         * Simple ctor
         * @param out The stream to write to
         * @param response The response to flush on write complete
         */
        private DirectScriptConduit(PrintWriter out, HttpServletResponse response)
        {
            this.out = out;
            this.response = response;
        }

        /* (non-Javadoc)
         * @see uk.ltd.getahead.dwr.ScriptConduit#addScript(java.lang.String)
         */
        public void addScript(String script)
        {
            synchronized (out)
            {
                out.print(script);
                out.print('\n');
 
                try
                {
                    response.flushBuffer();
                }
                catch (IOException ex)
                {
                    log.warn("Ignoring IOException while writing script: " + ex.getMessage()); //$NON-NLS-1$
                }
            }
        }

        private PrintWriter out;
        private HttpServletResponse response;
    }

    /**
     * How we convert parameters
     */
    protected ConverterManager converterManager = null;

    /**
     * How we create new beans
     */
    protected CreatorManager creatorManager = null;

    /**
     * The security manager
     */
    protected AccessControl accessControl = null;

    /**
     * How we stash away the request
     */
    protected String ATTRIBUTE_REQUEST = "uk.ltd.getahead.dwr.dwrp.request"; //$NON-NLS-1$

    /**
     * How we stash away the conduit
     */
    protected String ATTRIBUTE_CONDUIT = "uk.ltd.getahead.dwr.dwrp.conduit"; //$NON-NLS-1$

    /**
     * The log stream
     */
    protected static final Logger log = Logger.getLogger(DwrpPlainJsMarshaller.class);
}
