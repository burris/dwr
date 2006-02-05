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
package uk.ltd.getahead.dwr.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilter;
import uk.ltd.getahead.dwr.AjaxFilterChain;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.Call;
import uk.ltd.getahead.dwr.Calls;
import uk.ltd.getahead.dwr.ClientScript;
import uk.ltd.getahead.dwr.ConversionConstants;
import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.HttpResponse;
import uk.ltd.getahead.dwr.InboundContext;
import uk.ltd.getahead.dwr.InboundVariable;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.Remoter;
import uk.ltd.getahead.dwr.TypeHintContext;
import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;
import uk.ltd.getahead.dwr.servlet.HtmlConstants;
import uk.ltd.getahead.dwr.util.JavascriptUtil;
import uk.ltd.getahead.dwr.util.LocalUtil;
import uk.ltd.getahead.dwr.util.Logger;
import uk.ltd.getahead.dwr.util.Messages;

/**
 * In implementation of Remoter that delegates requests to a set of Modules
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultRemoter implements Remoter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Remoter#generateInterfaceScript(java.lang.String, java.lang.String)
     */
    public HttpResponse generateInterfaceScript(String scriptName, String path) throws SecurityException
    {
        if (overridePath != null)
        {
            path = overridePath;
        }

        Creator creator = creatorManager.getCreator(scriptName);
        StringBuffer buffer = new StringBuffer();

        buffer.append('\n');
        buffer.append("function " + scriptName + "() { }\n"); //$NON-NLS-1$ //$NON-NLS-2$
        buffer.append(scriptName + "._path = '" + path + "';\n"); //$NON-NLS-1$ //$NON-NLS-2$

        Method[] methods = creator.getType().getMethods();
        for (int i = 0; i < methods.length; i++)
        {
            Method method = methods[i];
            String methodName = method.getName();

            // We don't need to check accessControl.getReasonToNotExecute()
            // because the checks are made by the doExec method, but we do check
            // if we can display it
            String reason = accessControl.getReasonToNotDisplay(creator, scriptName, method);
            if (reason != null && !allowImpossibleTests)
            {
                continue;
            }

            // Is it on the list of banned names
            if (JavascriptUtil.isReservedWord(methodName))
            {
                continue;
            }

            // Check to see if the creator is reloadable
            // If it is, then do not cache the generated Javascript
            String script;
            if (!creator.isCacheable()) 
            {
                script = getMethodJS(scriptName, method);
            }
            else
            {
                String key = scriptName + "." + method.getName(); //$NON-NLS-1$

                // For optimal performance we might synchronize on methodCache however
                // since performance isn't a big issue we are prepared to cope with
                // the off chance that getMethodJS() may be run more than once.
                script = (String) methodCache.get(key);
                if (script == null)
                {
                    script = getMethodJS(scriptName, method);
                    methodCache.put(key, script);
                }
            }

            buffer.append(script);
        }

        HttpResponse reply = new HttpResponse();
        reply.setBody(buffer.toString());
        //reply.setMimeType(HtmlConstants.MIME_JS);
        reply.setMimeType(HtmlConstants.MIME_PLAIN);

        return reply;
    }

    /**
     * Generates Javascript for a given Java method
     * @param scriptName  Name of the Javascript file, sans ".js" suffix
     * @param method Target method
     * @return Javascript implementing the DWR call for the target method
     */
    private String getMethodJS(String scriptName, Method method)
    {
        StringBuffer buffer = new StringBuffer();

        String methodName = method.getName();
        buffer.append(scriptName + '.' + methodName + " = function(\n"); //$NON-NLS-1$
        Class[] paramTypes = method.getParameterTypes();
        for (int j = 0; j < paramTypes.length; j++)
        {
            if (!LocalUtil.isServletClass(paramTypes[j]))
            {
                buffer.append("p" + j + ", "); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        buffer.append("callback) {\n"); //$NON-NLS-1$

        buffer.append("    DWREngine._execute(" + scriptName + "._path, '" + scriptName + "', '" + methodName + "\', "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        for (int j = 0; j < paramTypes.length; j++)
        {
            if (LocalUtil.isServletClass(paramTypes[j]))
            {
                buffer.append("false, "); //$NON-NLS-1$
            }
            else
            {
                buffer.append("p" + j + ", "); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        buffer.append("callback);\n"); //$NON-NLS-1$
        buffer.append("}\n"); //$NON-NLS-1$

        return buffer.toString();
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Remoter#execute(uk.ltd.getahead.dwr.servlet.Calls)
     */
    public HttpResponse execute(Calls calls)
    {
        callMethods(calls);
        return generateOutput(calls);
    }

    /**
     * Use reflection to call the various methods
     * @param calls The methods to call
     */
    private void callMethods(Calls calls)
    {
        // Debug the environment
        if (log.isDebugEnabled() && calls.getCallCount() > 0)
        {
            // We can just use 0 because they are all shared
            InboundContext inctx = calls.getCall(0).getInboundContext();
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

        // Since we are passing all the responses back in one script, there is
        // only one outbound context.
        OutboundContext converted = new OutboundContext();

        for (int callNum = 0; callNum < calls.getCallCount(); callNum++)
        {
            Call call = calls.getCall(callNum);
            InboundContext inctx = call.getInboundContext();

            try
            {
                // Get a list of the available matching methods with the coerced
                // parameters that we will use to call it if we choose to use that
                // method.
                Creator creator = creatorManager.getCreator(call.getScriptName());

                // Which method are we using?
                Method method = findMethod(call);
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
                    try
                    {
                        Class paramType = method.getParameterTypes()[j];
                        InboundVariable param = inctx.getParameter(callNum, j);
                        TypeHintContext incc = new TypeHintContext(method, j);

                        params[j] = converterManager.convertInbound(paramType, param, inctx, incc);
                    }
                    catch (ConversionException ex)
                    {
                        throw new ConversionException(Messages.getString("DefaultRemoter.ConversionError", call.getScriptName(), call.getMethodName(), ex.getMessage())); //$NON-NLS-1$
                    }
                }

                // Get ourselves an object to execute a method on unless the
                // method is static
                Object object = null;
                String scope = creator.getScope();
                boolean create = false;

                if (!Modifier.isStatic(method.getModifiers()))
                {
                    WebContext webcx = WebContextFactory.get();

                    // Check the various scopes to see if it is there
                    if (scope.equals(Creator.APPLICATION))
                    {
                        object = webcx.getServletContext().getAttribute(call.getScriptName());
                    }
                    else if (scope.equals(Creator.SESSION))
                    {
                        object = webcx.getSession().getAttribute(call.getScriptName());
                    }
                    else if (scope.equals(Creator.REQUEST))
                    {
                        object = webcx.getHttpServletRequest().getAttribute(call.getScriptName());
                    }
                    // Creator.PAGE scope means we create one every time anyway

                    // If we don't have an object the call the creator
                    if (object == null)
                    {
                        create = true;
                        object = creator.getInstance();
                    }

                    // We might need to remember it for next time
                    if (scope.equals(Creator.APPLICATION))
                    {
                        webcx.getServletContext().setAttribute(call.getScriptName(), object);
                    }
                    else if (scope.equals(Creator.SESSION))
                    {
                        webcx.getSession().setAttribute(call.getScriptName(), object);
                    }
                    else if (scope.equals(Creator.REQUEST))
                    {
                        webcx.getHttpServletRequest().setAttribute(call.getScriptName(), object);
                    }
                    // Creator.PAGE scope means we create one every time anyway
                }

                // Some debug
                log.info("Exec[" + callNum + "]: " + call.getScriptName() + "." + call.getMethodName() + "()"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                if (log.isDebugEnabled())
                {
                    StringBuffer buffer = new StringBuffer();

                    if (create)
                    {
                        buffer.append("--Object created, "); //$NON-NLS-1$
                        if (!scope.equals(Creator.PAGE))
                        {
                            buffer.append(" stored in "); //$NON-NLS-1$
                            buffer.append(scope);
                        }
                        else
                        {
                            buffer.append(" not stored"); //$NON-NLS-1$
                        }
                    }
                    else
                    {
                        buffer.append("--Object found in "); //$NON-NLS-1$
                        buffer.append(scope);
                    }

                    buffer.append(". Call params ("); //$NON-NLS-1$
                    for (int j = 0; j < inctx.getParameterCount(callNum); j++)
                    {
                        if (j != 0)
                        {
                            buffer.append(", "); //$NON-NLS-1$
                        }
                        InboundVariable param = inctx.getParameter(callNum, j);
                        buffer.append(param.toString());
                    }
                    buffer.append(") id="); //$NON-NLS-1$
                    buffer.append(call.getId());

                    buffer.append(". Using ("); //$NON-NLS-1$
                    buffer.append(calls.isXhrMode() ? "XHR" : "IFrame"); //$NON-NLS-1$ //$NON-NLS-2$
                    buffer.append(")"); //$NON-NLS-1$

                    log.debug(buffer.toString());
                }

                // Execute the filter chain method.toString()
                final Iterator it = ajaxFilterManager.getAjaxFilters(call.getScriptName());
                AjaxFilterChain chain = new AjaxFilterChain()
                {
                    public Object doFilter(Object obj, Method meth, Object[] p) throws Exception
                    {
                        AjaxFilter next = (AjaxFilter) it.next();
                        return next.doFilter(obj, meth, p, this);
                    }
                };
                Object reply = chain.doFilter(object, method, params);

                OutboundVariable ov = converterManager.convertOutbound(reply, converted);
                call.setReply(ov);
            }
            catch (InvocationTargetException ex)
            {
                log.warn("Method execution failed: ", ex.getTargetException()); //$NON-NLS-1$
                call.setThrowable(convertException(converted, ex.getTargetException()));
            }
            catch (Throwable ex)
            {
                log.warn("Method execution failed: ", ex); //$NON-NLS-1$
                call.setThrowable(convertException(converted, ex));
            }
        }
    }

    /**
     * The calls have been executed, now convert the output
     * @param calls The call data to convert
     * @return An HTML page
     */
    private HttpResponse generateOutput(Calls calls)
    {
        for (int i = 0; i < calls.getCallCount(); i++)
        {
            Call call = calls.getCall(i);
            if (call.getThrowable() != null)
            {
                log.warn("--Erroring: id[" + call.getId() + "] message[" + call.getThrowable().toString() + ']'); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        // We build the answer up in a StringBuffer because that makes is easier
        // to debug, and because that's only what the compiler does anyway.
        StringBuffer buffer = new StringBuffer();

        // if we are in html (iframe mode) we need to direct script to the parent
        String prefix = calls.isXhrMode() ? "" : "window.parent."; //$NON-NLS-1$ //$NON-NLS-2$

        // iframe mode starts as HTML, so get into script mode
        if (!calls.isXhrMode())
        {
            buffer.append("<script type='text/javascript'>\n"); //$NON-NLS-1$
        }

        // Are there any outstanding reverse-ajax scripts to be passed on? 
        List scripts = WebContextFactory.get().getBrowser().removeAllScripts();
        for (Iterator it = scripts.iterator(); it.hasNext();)
        {
            ClientScript script = (ClientScript) it.next();
            buffer.append(script);
            buffer.append('\n');
        }

        // Now pass on the executed method responses
        for (int i = 0; i < calls.getCallCount(); i++)
        {
            Call call = calls.getCall(i);
            if (call.getThrowable() != null)
            {
                OutboundVariable ov = call.getThrowable();

                buffer.append(ov.getInitCode());
                //buffer.append('\n');
                buffer.append(prefix);
                buffer.append("DWREngine._handleServerError('"); //$NON-NLS-1$
                buffer.append(call.getId());
                buffer.append("', "); //$NON-NLS-1$
                buffer.append(ov.getAssignCode());
                buffer.append(");\n"); //$NON-NLS-1$
            }
            else
            {
                OutboundVariable ov = call.getReply();

                buffer.append(ov.getInitCode());
                //buffer.append('\n');
                buffer.append(prefix);
                buffer.append("DWREngine._handleResponse('"); //$NON-NLS-1$
                buffer.append(call.getId());
                buffer.append("', "); //$NON-NLS-1$
                buffer.append(ov.getAssignCode());
                buffer.append(");\n"); //$NON-NLS-1$
            }
        }

        // iframe mode needs to get out of script mode
        if (!calls.isXhrMode())
        {
            buffer.append("</script>\n"); //$NON-NLS-1$
        }

        final String replyString = buffer.toString();
        log.debug(replyString);

        HttpResponse reply = new HttpResponse();
        reply.setBody(replyString);
        reply.setMimeType(calls.isXhrMode() ? HtmlConstants.MIME_PLAIN : HtmlConstants.MIME_HTML);
        return reply;
    }

    /**
     * Find the method the best matches the method name and parameters
     * @param call The function call we are going to make
     * @return A matching method, or null if one was not found.
     */
    private Method findMethod(Call call)
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
                            break methods;
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

        // At the moment we are just going to take the first match, for a
        // later increment we might pack the best implementation
        if (available.isEmpty())
        {
            return null;
        }

        return (Method) available.get(0);
    }

    /**
     * Convert an exception into an outbound variable
     * @param converted The conversion context
     * @param th The exception to be converted
     * @return A new outbound exception
     */
    private OutboundVariable convertException(OutboundContext converted, Throwable th)
    {
        try
        {
            if (converterManager.isConvertable(th.getClass()))
            {
                return converterManager.convertOutbound(th, converted);
            }
        }
        catch (ConversionException ex)
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
     * @return The ConverterManager
     */
    public ConverterManager getConverterManager()
    {
        return converterManager;
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
     * Accessor for the AjaxFilterManager
     * @param ajaxFilterManager The AjaxFilterManager to set.
     */
    public void setAjaxFilterManager(AjaxFilterManager ajaxFilterManager)
    {
        this.ajaxFilterManager = ajaxFilterManager;
    }

    /**
     * If we need to override the default path
     * @param overridePath The new override path
     */
    public void setOverridePath(String overridePath)
    {
        this.overridePath = overridePath;
    }

    /**
     * Do we allow impossible tests for debug purposes
     * @param allowImpossibleTests The allowImpossibleTests to set.
     */
    public void setAllowImpossibleTests(boolean allowImpossibleTests)
    {
        this.allowImpossibleTests = allowImpossibleTests;
    }
    
    /**
     * What AjaxFilters apply to which Ajax calls?
     */
    private AjaxFilterManager ajaxFilterManager = null;

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
     * If we need to override the default path
     */
    private String overridePath = null;

    /**
     * This helps us test that access rules are being followed
     */
    private boolean allowImpossibleTests = false;

    /**
     * Generated Javascript cache
     */
    private Map methodCache = new HashMap();

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DefaultRemoter.class);
}
