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
package org.directwebremoting.proxy.jsx3.net;

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class URI extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public URI(ProxyHelper helper)
    {
        super(helper);
    }
    
    /**
     * Instance initializer.
     * @param strURI uri
     */
    public URI(String strURI)
    {
        super((ProxyHelper) null);
    }

    /**
     * This method can be called with either 3 or 7 arguments. If it is called with 3 arguments, the signature is
URI.fromParts(scheme, schemeSpecificPath, fragment).
     * @param scheme the URI scheme, may be <code>null</code>
     * @param userInfo the URI user-information, may be <code>null</code>; <b>or the scheme-specific part if called with 3 arguments</b>
     * @param host the URI host, may be <code>null</code>; <b>or the URI fragment if called with 3 arguments</b>, may be <code>null</code>
     * @param port the URI port, may be <code>null</code>
     * @param path the URI path
     * @param query the URI query, may be <code>null</code>
     * @param fragment the URI fragment, may be <code>null</code>
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI fromParts(String scheme, String userInfo, String host, int port, String path, String query, String fragment)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("fromParts(\"" + scheme + "\", \"" + userInfo + "\", \"" + host + "\", \"" + port + "\", \"" + path + "\", \"" + query + "\", \"" + fragment + "\").");
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
     * Normalizes this URI's path.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI normalize()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("normalize().");
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
     * Resolves the given URI against this URI.
     * @param uri 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolve(String uri)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("resolve(\"" + uri + "\").");
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
     * Resolves the given URI against this URI.
     * @param uri 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolve(org.directwebremoting.proxy.jsx3.net.URI uri)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("resolve(\"" + uri + "\").");
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
     * Relativizes the given URI against this URI.

The returned URI is computed as follows:

 If this URI or uri is opaque, or their schemes are not equal or their authorities are not
   equal, uri is returned.
 Otherwise, a new URI is constructed with the query and fragment of uri and a path equal to:
   
     If the common path prefix of this URI and uri is just "" or
        "/", the path of uri
            
     Otherwise, the last segment of this path is removed and the path is computed by removing any common
        path prefix between the two paths, prepending a ".." for every segment remaining in this path, and
        appending the remaining path of uri.
     * @param uri 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativize(String uri)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("relativize(\"" + uri + "\").");
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
     * Relativizes the given URI against this URI.

The returned URI is computed as follows:

 If this URI or uri is opaque, or their schemes are not equal or their authorities are not
   equal, uri is returned.
 Otherwise, a new URI is constructed with the query and fragment of uri and a path equal to:
   
     If the common path prefix of this URI and uri is just "" or
        "/", the path of uri
            
     Otherwise, the last segment of this path is removed and the path is computed by removing any common
        path prefix between the two paths, prepending a ".." for every segment remaining in this path, and
        appending the remaining path of uri.
     * @param uri 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativize(org.directwebremoting.proxy.jsx3.net.URI uri)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("relativize(\"" + uri + "\").");
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
    public String getAuthority(Callback callback)
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
    public String getFragment(Callback callback)
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
    public String getHost(Callback callback)
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
    public String getPath(Callback callback)
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
    public int getPort(Callback callback)
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
    public String getQuery(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Searches the query part for the value of a parameter. Parameters are specified as name value pairs delimited by
'&' like: name1=value1&name2=value2&... If a parameter is specified without a following '='
this method will return boolean true.
     * @param strParam 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getQueryParam(String strParam, Callback callback)
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
    public Object getQueryParams(Callback callback)
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
    public String getScheme(Callback callback)
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
    public String getSchemeSpecificPart(Callback callback)
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
    public String getUserInfo(Callback callback)
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
    public boolean isAbsolute(Callback callback)
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
    public boolean isOpaque(Callback callback)
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
     * 
     * @param strURI 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI valueOf(String strURI)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("valueOf(\"" + strURI + "\").");
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
    public org.directwebremoting.proxy.jsx3.net.URI valueOf(org.directwebremoting.proxy.jsx3.net.URI strURI)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("valueOf(\"" + strURI + "\").");
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

    
    
 }
