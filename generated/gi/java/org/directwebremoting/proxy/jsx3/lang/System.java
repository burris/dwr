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
public class System extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public System(ProxyHelper helper)
    {
        super(helper);
    }

    
    /*
     * Returns a system property as specified by a JSS file loaded by the JSX runtime or an addin.
     * @param strKey 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getProperty(String strKey, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * If the locale has been explicitly set with setLocale(), that locale is returned. Otherwise the
locale is determined by introspecting the browser. If all else fails the default locale, en_US, is returned.
     */
    public void getLocale()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getLocale(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the system-wide locale. This in turn affects all applications running under the JSX system.
     * @param objLocale 
     */
    public void setLocale(String objLocale)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setLocale(")
              .appendData(objLocale)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * 
     */
    public void reloadLocalizedResources()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("reloadLocalizedResources(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * 
     * @param strKey 
     * @param strTokens 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getMessage(String strKey, Object strTokens, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the version number of General Interface.
     * @return <code>"3.1.0"</code>, etc.
     *
    @SuppressWarnings("unchecked")
    public String getVersion(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
 }
