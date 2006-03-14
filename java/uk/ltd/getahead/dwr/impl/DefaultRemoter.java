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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilter;
import uk.ltd.getahead.dwr.AjaxFilterChain;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.Call;
import uk.ltd.getahead.dwr.Calls;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.HtmlConstants;
import uk.ltd.getahead.dwr.HttpResponse;
import uk.ltd.getahead.dwr.Remoter;
import uk.ltd.getahead.dwr.Replies;
import uk.ltd.getahead.dwr.Reply;
import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;
import uk.ltd.getahead.dwr.util.JavascriptUtil;
import uk.ltd.getahead.dwr.util.LocalUtil;
import uk.ltd.getahead.dwr.util.Logger;

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
        String actualPath = path;
        if (overridePath != null)
        {
            actualPath = overridePath;
        }

        Creator creator = creatorManager.getCreator(scriptName);
        StringBuffer buffer = new StringBuffer();

        buffer.append('\n');
        buffer.append("function " + scriptName + "() { }\n"); //$NON-NLS-1$ //$NON-NLS-2$
        buffer.append(scriptName + "._path = '" + actualPath + "';\n"); //$NON-NLS-1$ //$NON-NLS-2$

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

        // Officially we should use HtmlConstants.MIME_JS, but if we cheat and
        // use HtmlConstants.MIME_PLAIN then it will be easier to read in a
        // browser window, and will still work just fine.
        return new DefaultHttpResponse(buffer.toString(), HtmlConstants.MIME_PLAIN);
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

        buffer.append("  DWREngine._execute(" + scriptName + "._path, '" + scriptName + "', '" + methodName + "\', "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
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
    public Replies execute(Calls calls)
    {
        Replies replies = new Replies();
        replies.setXhrMode(calls.isXhrMode());

        for (int callNum = 0; callNum < calls.getCallCount(); callNum++)
        {
            Call call = calls.getCall(callNum);

            try
            {
                Method method = call.getMethod();

                // Get a list of the available matching methods with the coerced
                // parameters that we will use to call it if we choose to use that
                // method.
                Creator creator = creatorManager.getCreator(call.getScriptName());

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
                    buffer.append(". "); //$NON-NLS-1$

                    // It would be good to debug the params but it's not easy
                    //buffer.append("Call params ("); //$NON-NLS-1$
                    //for (int j = 0; j < inctx.getParameterCount(callNum); j++)
                    //{
                    //    if (j != 0)
                    //    {
                    //        buffer.append(", "); //$NON-NLS-1$
                    //    }
                    //    InboundVariable param = inctx.getParameter(callNum, j);
                    //    buffer.append(param.toString());
                    //}
                    //buffer.append(") "); //$NON-NLS-1$

                    buffer.append("id="); //$NON-NLS-1$
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
                Object reply = chain.doFilter(object, method, call.getParameters());
                replies.addReply(new Reply(call.getId(), reply));
            }
            catch (InvocationTargetException ex)
            {
                log.warn("Method execution failed: ", ex.getTargetException()); //$NON-NLS-1$
                replies.addReply(new Reply(call.getId(), null, ex.getTargetException()));
            }
            catch (Exception ex)
            {
                log.warn("Method execution failed: ", ex); //$NON-NLS-1$
                replies.addReply(new Reply(call.getId(), null, ex));
            }
        }

        return replies;
    }

    /**
     * Accessor for the CreatorManager that we configure
     * @param creatorManager The new ConverterManager
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
