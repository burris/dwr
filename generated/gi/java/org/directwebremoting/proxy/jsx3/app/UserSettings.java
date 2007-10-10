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
package org.directwebremoting.proxy.jsx3.app;

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class UserSettings extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public UserSettings(ProxyHelper helper)
    {
        super(helper);
    }
    
    /**
     * The instance initializer.
     * @param objServer the app server.
     * @param intPersistence the persistence code, defaults to <code>PERSIST_INDEFINITE</code>.
     */
    public UserSettings(org.directwebremoting.proxy.jsx3.app.Server objServer, int intPersistence)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final int PERSIST_SESSION = 1;

    /**
     * 
     */
    public static final int PERSIST_INDEFINITE = 2;

    /*
     * Returns a stored setting value.
     * @param strKey the setting key.
     * @return the stored value.
     *
    @SuppressWarnings("unchecked")
    public String get(String strKey, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets a stored setting value.
     * @param strKey the setting key.
     * @param value the value to store.
     */
    public void set(String strKey, String value)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("set(")
              .appendData(strKey)
              .appendScript(",")
              
              .appendData(value)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets a stored setting value.
     * @param strKey the setting key.
     * @param value the value to store.
     */
    public void set(String strKey, int value)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("set(")
              .appendData(strKey)
              .appendScript(",")
              
              .appendData(value)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets a stored setting value.
     * @param strKey the setting key.
     * @param value the value to store.
     */
    public void set(String strKey, boolean value)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("set(")
              .appendData(strKey)
              .appendScript(",")
              
              .appendData(value)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets a stored setting value.
     * @param strKey the setting key.
     * @param value the value to store.
     */
    public void set(String strKey, Object[] value)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("set(")
              .appendData(strKey)
              .appendScript(",")
              
              .appendData(value)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets a stored setting value.
     * @param strKey the setting key.
     * @param value the value to store.
     */
    public void set(String strKey, Object value)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("set(")
              .appendData(strKey)
              .appendScript(",")
              
              .appendData(value)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Removes a stored setting value.
     * @param strKey the key of the setting to remove.
     */
    public void remove(String strKey)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("remove(")
              .appendData(strKey)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Clears all settings of this user settings instance. This implementation deletes the cookie.
     */
    public void clear()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("clear(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Persists the user settings. Any modifications to this user settings instance will be lost if this method 
is not called.
     */
    public void save()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("save(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
 }
