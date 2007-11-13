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
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Method extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Method(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * Returns the name of the method. The name of the method is determined when the class is defined.
     */
    @SuppressWarnings("unchecked")
    public void getName(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getName");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the number of parameters that this method takes (as declared in the JavaScript source).
     */
    @SuppressWarnings("unchecked")
    public void getArity(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getArity");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the names of parameters that this method takes (as declared in the JavaScript source).
     */
    @SuppressWarnings("unchecked")
    public void getParameterNames(Callback<Object[]> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object[].class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getParameterNames");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the name of a parameter that this method takes (as declared in the JavaScript source).
     * @param intIndex the index of the parameter name to return
     */
    @SuppressWarnings("unchecked")
    public void getParameterName(int intIndex, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getParameterName", intIndex);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the class that defined this method.
     */
    @SuppressWarnings("unchecked")
    public Class getDeclaringClass()
    {
        String extension = "getDeclaringClass().";
        try
        {
            Constructor<Class> ctor = Class.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + Class.class.getName());
        }
    }

    /**
     * Returns whether the definer of this class (returned by getDeclaringClass()) is in fact
    a package.
     */
    @SuppressWarnings("unchecked")
    public void isPackageMethod(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isPackageMethod");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if this method is static (is a class method).
     */
    @SuppressWarnings("unchecked")
    public void isStatic(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isStatic");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if this method is abstract. Abstract methods will throw an Exception if they are
    invoked.
     */
    @SuppressWarnings("unchecked")
    public void isAbstract(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isAbstract");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the native JavaScript function of this method.
     */
    @SuppressWarnings("unchecked")
    public void getFunction(Callback<org.directwebremoting.proxy.CodeBlock> callback)
    {
        String key = CallbackHelper.saveCallback(callback, org.directwebremoting.proxy.CodeBlock.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getFunction");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Calls apply on the native function.
     * @param thisArg this argument to pass to <code>Function.apply()</code>
     * @param argArray argument array to pass to <code>Function.apply()</code>
     */
    @SuppressWarnings("unchecked")
    public void apply(Object thisArg, Object[] argArray, Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = apply", thisArg, argArray);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Calls call on the native function.
     * @param arg arguments to pass to <code>Function.call()</code>, supports up to 11 arguments (this+10)
     */
    @SuppressWarnings("unchecked")
    public void call(Object arg, Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = call", arg);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Creates a new abstract method.
     * @param paramNames the names of the parameters that the abtract method will take
     */
    @SuppressWarnings("unchecked")
    public void newAbstract(String paramNames, Callback<org.directwebremoting.proxy.CodeBlock> callback)
    {
        String key = CallbackHelper.saveCallback(callback, org.directwebremoting.proxy.CodeBlock.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = newAbstract", paramNames);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

}
