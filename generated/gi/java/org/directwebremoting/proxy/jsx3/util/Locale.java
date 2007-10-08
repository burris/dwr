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

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Locale extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Locale(ProxyHelper helper)
    {
        super(helper);
    }

    
    /*
     * Returns the lowercase two letter ISO-639 language code.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getLanguage(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the uppercase two letter ISO-3166 country code.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getCountry(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the language of this locale, localized for objLocale.
     * @param objLocale the locale in which to format the language. If this parameter is not 
  provided, the system locale is used.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getDisplayLanguage(org.directwebremoting.proxy.jsx3.util.Locale objLocale, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the country of this locale, localized for objLocale.
     * @param objLocale the locale in which to format the country. If this parameter is not 
  provided, the system locale is used.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getDisplayCountry(org.directwebremoting.proxy.jsx3.util.Locale objLocale, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the language and country of this locale, localized for objLocale.
     * @param objLocale the locale in which to format the language and country. If this parameter is not 
  provided, the system locale is used.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getDisplayName(org.directwebremoting.proxy.jsx3.util.Locale objLocale, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns true if obj is equal to this locale.
     * @param obj 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj, Callback callback)
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
     * @return 
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
    
    /**
     * Returns a locale instance represented by strKey.
     * @param strKey the locale key, <code>ll_CC</code>, where <code>ll</code> is the two letter language 
  code and <code>CC</code> is the two letter country code.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Locale valueOf(String strKey)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("valueOf(\"" + strKey + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Locale> ctor = org.directwebremoting.proxy.jsx3.util.Locale.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Locale.class.getName());
        }
    }

    
    
 }
