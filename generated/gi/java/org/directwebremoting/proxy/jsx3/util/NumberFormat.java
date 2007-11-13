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
package org.directwebremoting.proxy.jsx3.util;

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
public class NumberFormat extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public NumberFormat(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * 
     * @param strFormat 
     * @param objLocale 
     */
    public NumberFormat(String strFormat, org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new NumberFormat", strFormat, objLocale);
        setInitScript(script);
    }

    /**
     * Returns an integer number format appropriate for objLocale.
     * @param objLocale the locale for which to return a format. If this parameter is not provided,
    the default system locale is used.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.NumberFormat getIntegerInstance(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        String extension = "getIntegerInstance(\"" + objLocale + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.NumberFormat> ctor = org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getName());
        }
    }

    /**
     * Returns a general number format appropriate for objLocale.
     * @param objLocale the locale for which to return a format. If this parameter is not provided,
    the default system locale is used.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.NumberFormat getNumberInstance(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        String extension = "getNumberInstance(\"" + objLocale + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.NumberFormat> ctor = org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getName());
        }
    }

    /**
     * Returns a currency number format appropriate for objLocale.
     * @param objLocale the locale for which to return a format. If this parameter is not provided,
    the default system locale is used.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.NumberFormat getCurrencyInstance(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        String extension = "getCurrencyInstance(\"" + objLocale + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.NumberFormat> ctor = org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getName());
        }
    }

    /**
     * Returns a percent number format appropriate for objLocale.
     * @param objLocale the locale for which to return a format. If this parameter is not provided,
    the default system locale is used.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.NumberFormat getPercentInstance(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        String extension = "getPercentInstance(\"" + objLocale + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.NumberFormat> ctor = org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getName());
        }
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Locale getLocale()
    {
        String extension = "getLocale().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Locale> ctor = org.directwebremoting.proxy.jsx3.util.Locale.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Locale.class.getName());
        }
    }

    /**
     * 
     * @param objLocale 
     */
    public void setLocale(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLocale", objLocale);
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param number 
     */
    @SuppressWarnings("unchecked")
    public void format(String number, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = format", number);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param number 
     */
    @SuppressWarnings("unchecked")
    public void format(Object number, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = format", number);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param number 
     */
    @SuppressWarnings("unchecked")
    public void format(int number, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = format", number);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

}
