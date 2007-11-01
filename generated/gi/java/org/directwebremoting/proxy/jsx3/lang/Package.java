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

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Package extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Package(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * Defines a new package so that it is available for introspection.

    It is not an error if the namespace object already exists prior to calling this method. Any members defined
    by fctBody are simply added to the pre-existing namespace. Then, all members, whether defined
    before the call to this method or with the call to this method, are made introspectable.

    This method may be called more than once with the same strName without causing an error. The
    package is simply redefined. Only the members that are defined in the namespace object after the last call to
    this method will be available for introspection.

    It is an error if, after fctBody is executed, any two members of the namespace object equal the
    same function object. This is know as method aliasing, which can be a useful technique in JavaScript. Any
    method aliasing within the namespace object must occur after the call to this method. Therefore, method aliasing
    will cause an error if this package is redefined later.
     * @param strName the full package name
     * @param fctBody the function that defines the body of the package. This function takes one argument 
    which is the package "namespace".
     */
    public void definePackage(String strName, org.directwebremoting.proxy.CodeBlock fctBody)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("definePackage(").appendData(strName).appendScript(",")

        .appendData(fctBody).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the defined package with name equal to strName.
     * @param strName the full name of the package to retrieve
     * @return the package or <code>null</code> if none matches
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.lang.Package forName(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("forName(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.lang.Package> ctor = org.directwebremoting.proxy.jsx3.lang.Package.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.lang.Package.class.getName());
        }
    }

    /*
     * Returns a list of all defined packages.
     *
    @SuppressWarnings("unchecked")
    public Object[] getPackages(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the fully-qualified name of this class.
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
     * Returns the namespace of this package. The namespace is the JavaScript object, descending from
    window, that references this package by its property jsxpackage.
     *
    @SuppressWarnings("unchecked")
    public Object getNamespace(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns an array of all the classes defined in this package.
     *
    @SuppressWarnings("unchecked")
    public Object[] getClasses(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the array of static methods defined for this package.
     * @return an array of jsx3.Method instances
     *
    @SuppressWarnings("unchecked")
    public Object[] getStaticMethods(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the static method defined in this package with name strMethodName.
     * @param strMethodName the name of the method to find
     * @return the method or null if none found matching <code>strMethodName</code>
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.lang.Method getStaticMethod(String strMethodName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getStaticMethod(\"" + strMethodName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.lang.Method> ctor = org.directwebremoting.proxy.jsx3.lang.Method.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.lang.Method.class.getName());
        }
    }

    /*
     * Returns the array of static fields defined for this package.
     * @return an array of String names
     *
    @SuppressWarnings("unchecked")
    public Object[] getStaticFieldNames(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public String toString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

}
