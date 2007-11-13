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
public class Locale extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Locale(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param strLanguage the lowercase two letter ISO-639 language code.
     * @param strCountry the uppercase two letter ISO-3166 country code.
     */
    public Locale(String strLanguage, String strCountry)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Locale", strLanguage, strCountry);
        setInitScript(script);
    }

    /**
     * Returns the lowercase two letter ISO-639 language code.
     */
    @SuppressWarnings("unchecked")
    public void getLanguage(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLanguage");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the uppercase two letter ISO-3166 country code.
     */
    @SuppressWarnings("unchecked")
    public void getCountry(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getCountry");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the language of this locale, localized for objLocale.
     * @param objLocale the locale in which to format the language. If this parameter is not 
    provided, the system locale is used.
     */
    @SuppressWarnings("unchecked")
    public void getDisplayLanguage(org.directwebremoting.proxy.jsx3.util.Locale objLocale, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDisplayLanguage", objLocale);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the country of this locale, localized for objLocale.
     * @param objLocale the locale in which to format the country. If this parameter is not 
    provided, the system locale is used.
     */
    @SuppressWarnings("unchecked")
    public void getDisplayCountry(org.directwebremoting.proxy.jsx3.util.Locale objLocale, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDisplayCountry", objLocale);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the language and country of this locale, localized for objLocale.
     * @param objLocale the locale in which to format the language and country. If this parameter is not 
    provided, the system locale is used.
     */
    @SuppressWarnings("unchecked")
    public void getDisplayName(org.directwebremoting.proxy.jsx3.util.Locale objLocale, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDisplayName", objLocale);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns a locale instance represented by strKey.
     * @param strKey the locale key, <code>ll_CC</code>, where <code>ll</code> is the two letter language 
    code and <code>CC</code> is the two letter country code.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Locale valueOf(String strKey)
    {
        String extension = "valueOf(\"" + strKey + "\").";
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

}
