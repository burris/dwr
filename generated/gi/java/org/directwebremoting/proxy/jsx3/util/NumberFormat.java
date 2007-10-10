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
public class NumberFormat extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public NumberFormat(ProxyHelper helper)
    {
        super(helper);
    }
    
    /**
     * 
     * @param strFormat 
     * @param objLocale 
     */
    public NumberFormat(String strFormat, org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        super((ProxyHelper) null);
    }

    /**
     * Returns an integer number format appropriate for objLocale.
     * @param objLocale the locale for which to return a format. If this parameter is not provided,
  the default system locale is used.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.NumberFormat getIntegerInstance(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getIntegerInstance(\"" + objLocale + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.NumberFormat> ctor = org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.NumberFormat getNumberInstance(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getNumberInstance(\"" + objLocale + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.NumberFormat> ctor = org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.NumberFormat getCurrencyInstance(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getCurrencyInstance(\"" + objLocale + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.NumberFormat> ctor = org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.NumberFormat getPercentInstance(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPercentInstance(\"" + objLocale + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.NumberFormat> ctor = org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.NumberFormat.class.getName());
        }
    }

    
    
    /**
     * 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Locale getLocale()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLocale().");
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

    
    
    /**
     * 
     * @param objLocale 
     */
    public void setLocale(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setLocale(")
              .appendData(objLocale)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * 
     * @param number 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String format(String number, Callback callback)
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
     * @param number 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String format(Object number, Callback callback)
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
     * @param number 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String format(int number, Callback callback)
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
    
 }
