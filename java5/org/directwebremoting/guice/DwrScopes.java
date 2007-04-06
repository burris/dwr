/*
 * Copyright 2007 Tim Peierls
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.directwebremoting.guice;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import static org.directwebremoting.guice.DwrGuiceUtil.getServletContext;

/**
 * Scopes available to DWR applications.
 * @author Tim Peierls [tim at peierls dot net]
 */
public class DwrScopes 
{
    /**
     * HTTP request scope
     */
    public static final Scope REQUEST = new Scope() 
    {
        public <T> Provider<T> scope(Key<T> key, final Provider<T> creator) 
        {
            final String name = key.toString();
            return new Provider<T>() 
            {
                public T get() {
                    WebContext webcx = WebContextFactory.get();
                    HttpServletRequest request = webcx.getHttpServletRequest();
                    synchronized (request) {
                        @SuppressWarnings("unchecked")
                        T t = (T) request.getAttribute(name);
                        if (t == null) 
                        {
                            t = creator.get();
                            request.setAttribute(name, t);
                        }
                        return t;
                    }
                }

                public String toString() 
                {
                    return creator.toString() + "/Request";
                }
            };
        }

        public String toString() 
        {
            return "DwrScopes.REQUEST";
        }
    };

    /**
     * DWR script session scope
     */
    public static final Scope SCRIPT = new Scope() 
    {
        public <T> Provider<T> scope(Key<T> key, final Provider<T> creator) {
            final String name = key.toString();
            return new Provider<T>() {
                public T get() 
                {
                    WebContext webcx = WebContextFactory.get();
                    ScriptSession session = webcx.getScriptSession();
                    synchronized (session) 
                    {
                        @SuppressWarnings("unchecked")
                        T t = (T) session.getAttribute(name);
                        if (t == null) 
                        {
                            t = creator.get();
                            session.setAttribute(name, t);
                        }
                        return t;
                    }
                }
                public String toString() 
                {
                    return creator.toString() + "/ScriptSession";
                }
            };
        }

        public String toString() 
        {
            return "DwrScopes.SCRIPT";
        }
    };

    /**
     * HTTP session scope
     */
    public static final Scope SESSION = new Scope() 
    {
        public <T> Provider<T> scope(Key<T> key, final Provider<T> creator) {
            final String name = key.toString();
            return new Provider<T>() 
            {
                public T get() 
                {
                    WebContext webcx = WebContextFactory.get();
                    HttpSession session = webcx.getSession();
                    synchronized (session) 
                    {
                        @SuppressWarnings("unchecked")
                        T t = (T) session.getAttribute(name);
                        if (t == null) 
                        {
                            t = creator.get();
                            session.setAttribute(name, t);
                        }
                        return t;
                    }
                }
                public String toString() 
                {
                    return creator.toString() + "/Session";
                }
            };
        }

        public String toString() 
        {
            return "DwrScopes.SESSION";
        }
    };

    /**
     * Application scope: objects in this scope <em>are</em> initialized on
     * DWR servlet startup, and Closeable objects in this scope are closed 
     * on DWR servlet shutdown.
     */
    public static final Scope APPLICATION = new ApplicationScope(false);

    /**
     * Global application scope: like application scope, but objects in 
     * this scope are <em>not</em> initialized on servlet startup or closed 
     * on servlet shutdown.
     */
    public static final Scope GLOBAL = new ApplicationScope(true);
    
    
    static class ApplicationScope implements Scope
    {
        ApplicationScope(boolean global)
        {
            this.global = global;
        }
        
        public <T> Provider<T> scope(Key<T> key, final Provider<T> creator) {
            final String name = key.toString();
            return new Provider<T>() 
            {
                public T get() 
                {
                    ServletContext servletContext = getServletContext();
                    synchronized (servletContext) 
                    {
                        @SuppressWarnings("unchecked")
                        T t = (T) servletContext.getAttribute(name);
                        if (t == null) 
                        {
                            t = creator.get();
                            servletContext.setAttribute(name, t);
                        }
                        return t;
                    }
                }
                public String toString() 
                {
                    String result = creator.toString() + "/Application";
                    if (!global)
                    {
                        result = result + APPLICATION_SCOPE_MARKER;
                    }
                    return result;
                }
            };
        }

        public String toString() 
        {
            return global ? "DwrScopes.GLOBAL" : "DwrScopes.APPLICATION" ;
        }
        
        private final boolean global;
    };
    
    static <T> boolean hasApplicationScope(Provider<T> provider)
    {
        return provider.toString().endsWith(APPLICATION_SCOPE_MARKER);
    }
    
    private static final String APPLICATION_SCOPE_MARKER = "[DWR_GUICE_APPLICATION_SCOPE]";
    

    private DwrScopes() { /* uninstantiable */ }
}
