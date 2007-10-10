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
public class AddIn extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public AddIn(ProxyHelper helper)
    {
        super(helper);
    }
    
    /**
     * 
     */
    public static final String PROTOTYPES_DIR = "prototypes/";

    /*
     * 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getId(Callback callback)
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
     * 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getDescription(Callback callback)
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
    public String getVersion(Callback callback)
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
    public String getKey(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Settings getSettings()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getSettings().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Settings> ctor = org.directwebremoting.proxy.jsx3.app.Settings.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Settings.class.getName());
        }
    }

    
    
    /**
     * 
     * @param strURI 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolveURI(String strURI)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("resolveURI(\"" + strURI + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    
    
    /**
     * 
     * @param strURI 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolveURI(org.directwebremoting.proxy.jsx3.net.URI strURI)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("resolveURI(\"" + strURI + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    
    
    /*
     * 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getUriPrefix(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * 
     * @param strURI 
     * @param bRel 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativizeURI(String strURI, boolean bRel)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("relativizeURI(\"" + strURI + "\", \"" + bRel + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    
    
    /**
     * 
     * @param strURI 
     * @param bRel 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativizeURI(org.directwebremoting.proxy.jsx3.net.URI strURI, boolean bRel)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("relativizeURI(\"" + strURI + "\", \"" + bRel + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    
    
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
