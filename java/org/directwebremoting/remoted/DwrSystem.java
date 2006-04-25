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
package org.directwebremoting.remoted;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.Container;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerLoadMonitor;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.ScriptSession.AddScriptListener;
import org.directwebremoting.util.ContinuationUtil;
import org.directwebremoting.util.LocalUtil;
import org.directwebremoting.util.Logger;

/**
 * A collection of system level actions that can be called remotely.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DwrSystem
{
    /**
     * The polling system needs to be able to wait for something to happen
     * @return How long should the client wait until it next polls
     */
    public int poll()
    {
        WebContext context = WebContextFactory.get();
        Container container = context.getContainer();

        ServerLoadMonitor monitor = (ServerLoadMonitor) container.getBean(ServerLoadMonitor.class.getName());

        // The comet part of a poll request
        try
        {
            long sleepTime = monitor.timeWithinPoll();
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException ex)
        {
            log.warn("Interupted", ex); //$NON-NLS-1$
        }

        return monitor.timeToNextPoll();
    }

    /**
     * The polling system needs to be able to wait for something to happen
     */
    public void pollWait()
    {
        WebContext context = WebContextFactory.get();
        Container container = context.getContainer();

        final ScriptSession scriptSession = context.getScriptSession();
        ServerLoadMonitor monitor = (ServerLoadMonitor) container.getBean(ServerLoadMonitor.class.getName());
        long sleepTime = monitor.timeWithinPoll();

        synchronized (scriptSession.getScriptLock())
        {
            // Don't wait if there are queued scripts
            if (scriptSession.getQueuedScripts() > 0)
            {
                return;
            }

            // If this is Jetty then we can use Continuations
            HttpServletRequest request = context.getHttpServletRequest();

            boolean useSleep = true;
            final Object continuation = request.getAttribute("org.mortbay.jetty.ajax.Continuation"); //$NON-NLS-1$
            if (continuation != null)
            {
                useSleep = false;

                try
                {
                    // create a listener 
                    AddScriptListener listener = (AddScriptListener) getObject.invoke(continuation, new Object[0]);
                    if (listener == null)
                    {
                        listener = new AddScriptListener()
                        {
                            public void scriptAdded()
                            {
                                try
                                {
                                    // continuation.resume();
                                    resumeMethod.invoke(continuation, new Object[0]);
                                    scriptSession.removeAddScriptListener(this);
                                }
                                catch (Exception ex)
                                {
                                    log.warn("Exception in continuation.resume()", ex); //$NON-NLS-1$
                                }
                            }
                        };
                        setObject.invoke(continuation, new Object[] { listener });
                    }
                    scriptSession.addAddScriptListener(listener);

                    // continuation.suspend(sleepTime);
                    // NB. May throw a Runtime exception that must propogate to the container!
                    suspendMethod.invoke(continuation, new Object[] { new Long(sleepTime) });
                }
                catch (InvocationTargetException ex)
                {
                    ContinuationUtil.rethrowIfContinuation(ex.getTargetException());

                    log.warn("Error in Reflection", ex.getTargetException()); //$NON-NLS-1$
                    useSleep = true;
                }
                catch (Exception ex)
                {
                    log.warn("Exception", ex); //$NON-NLS-1$
                    useSleep = true;
                }
            }

            if (useSleep)
            {
                // create a listener // TODO avoid the expense of creation and registration
                AddScriptListener listener = new AddScriptListener()
                {
                    public void scriptAdded()
                    {
                        try
                        {
                            synchronized(scriptSession.getScriptLock())
                            {
                                scriptSession.getScriptLock().notifyAll();
                            }
                        }
                        catch (Exception ex)
                        {
                            log.warn("Failed to notify all ScriptSession users", ex); //$NON-NLS-1$
                        }
                    }
                };
                scriptSession.addAddScriptListener(listener);

                // The comet part of a poll request
                try
                {
                    scriptSession.getScriptLock().wait(sleepTime);
                }
                catch (InterruptedException ex)
                {
                    log.warn("Interupted", ex); //$NON-NLS-1$
                }
                finally
                {
                    scriptSession.removeAddScriptListener(listener);
                }
            }
        }
    }

    /**
     * Jetty code used by reflection to allow it to run outside of Jetty
     */
    protected static Class continuationClass;

    /**
     * How we suspend the continuation
     */
    protected static Method suspendMethod;
    
    /**
     * How we resume the continuation
     */
    protected static Method resumeMethod;

    /**
     * How we get the associated continuation object
     */
    protected static Method getObject;

    /**
     * How we set the associated continuation object
     */
    protected static Method setObject;

    /**
     * The log stream
     */
    protected static final Logger log = Logger.getLogger(DwrSystem.class);

    /**
     * Can we use Jetty?
     */
    static
    {
        try
        {
            continuationClass = LocalUtil.classForName("org.mortbay.util.ajax.Continuation"); //$NON-NLS-1$
            suspendMethod = continuationClass.getMethod("suspend", new Class[] { Long.TYPE }); //$NON-NLS-1$
            resumeMethod = continuationClass.getMethod("resume", new Class[] {}); //$NON-NLS-1$
            getObject = continuationClass.getMethod("getObject", new Class[] {}); //$NON-NLS-1$
            setObject = continuationClass.getMethod("setObject", new Class[] { Object.class }); //$NON-NLS-1$
        }
        catch (Exception ex)
        {
            log.debug("No Jetty ContuniationSupport class, using standard Servlet API"); //$NON-NLS-1$
        }
    }
}
