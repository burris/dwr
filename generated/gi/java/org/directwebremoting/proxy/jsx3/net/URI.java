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
public class URI extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public URI(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * Instance initializer.
     * @param strURI uri
     */
    public URI(String strURI)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new URI", strURI);
        setInitScript(script);
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
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI fromParts(String scheme, String userInfo, String host, int port, String path, String query, String fragment)
    {
        String extension = "fromParts(\"" + scheme + "\", \"" + userInfo + "\", \"" + host + "\", \"" + port + "\", \"" + path + "\", \"" + query + "\", \"" + fragment + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /**
     * Normalizes this URI's path.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI normalize()
    {
        String extension = "normalize().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /**
     * Resolves the given URI against this URI.
     * @param uri 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolve(String uri)
    {
        String extension = "resolve(\"" + uri + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /**
     * Resolves the given URI against this URI.
     * @param uri 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolve(org.directwebremoting.proxy.jsx3.net.URI uri)
    {
        String extension = "resolve(\"" + uri + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativize(String uri)
    {
        String extension = "relativize(\"" + uri + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativize(org.directwebremoting.proxy.jsx3.net.URI uri)
    {
        String extension = "relativize(\"" + uri + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getAuthority(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAuthority");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getFragment(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getFragment");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getHost(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getHost");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getPath(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPath");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getPort(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPort");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getQuery(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getQuery");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Searches the query part for the value of a parameter. Parameters are specified as name value pairs delimited by
    '&' like: name1=value1&name2=value2&... If a parameter is specified without a following '='
    this method will return boolean true.
     * @param strParam 
     */
    @SuppressWarnings("unchecked")
    public void getQueryParam(String strParam, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getQueryParam", strParam);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getQueryParams(Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getQueryParams");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getScheme(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getScheme");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getSchemeSpecificPart(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getSchemeSpecificPart");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getUserInfo(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getUserInfo");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void isAbsolute(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isAbsolute");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void isOpaque(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isOpaque");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param strURI 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI valueOf(String strURI)
    {
        String extension = "valueOf(\"" + strURI + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /**
     * 
     * @param strURI 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI valueOf(org.directwebremoting.proxy.jsx3.net.URI strURI)
    {
        String extension = "valueOf(\"" + strURI + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

}
