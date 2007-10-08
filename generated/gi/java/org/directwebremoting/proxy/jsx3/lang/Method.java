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
package org.directwebremoting.proxy.jsx3.lang;

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Method extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Method(ProxyHelper helper)
    {
        super(helper);
    }

    
    /*
     * Returns the name of the method. The name of the method is determined when the class is defined.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the number of parameters that this method takes (as declared in the JavaScript source).
     * @return 
     *
    @SuppressWarnings("unchecked")
    public int getArity(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the names of parameters that this method takes (as declared in the JavaScript source).
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object[] getParameterNames(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the name of a parameter that this method takes (as declared in the JavaScript source).
     * @param intIndex the index of the parameter name to return
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getParameterName(int intIndex, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the class that defined this method.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public Class getDeclaringClass()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDeclaringClass().");
        try
        {
            Constructor<Class> ctor = Class.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + Class.class.getName());
        }
    }

    
    
    /*
     * Returns whether the definer of this class (returned by getDeclaringClass()) is in fact
   a package.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public boolean isPackageMethod(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns true if this method is static (is a class method).
     * @return 
     *
    @SuppressWarnings("unchecked")
    public boolean isStatic(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns true if this method is abstract. Abstract methods will throw an Exception if they are
   invoked.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public boolean isAbstract(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the native JavaScript function of this method.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.CodeBlock getFunction(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Calls apply on the native function.
     * @param thisArg this argument to pass to <code>Function.apply()</code>
     * @param argArray argument array to pass to <code>Function.apply()</code>
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object apply(Object thisArg, Object[] argArray, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Calls call on the native function.
     * @param arg arguments to pass to <code>Function.call()</code>, supports up to 11 arguments (this+10)
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object call(Object arg, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Creates a new abstract method.
     * @param paramNames the names of the parameters that the abtract method will take
     * @return 
     *
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.CodeBlock newAbstract(String paramNames, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
 }
