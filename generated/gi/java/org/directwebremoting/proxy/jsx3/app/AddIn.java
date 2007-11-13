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
public class AddIn extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public AddIn(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * 
     */
    public static final String PROTOTYPES_DIR = "prototypes/";

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getId(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getId");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
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
     * 
     */
    @SuppressWarnings("unchecked")
    public void getDescription(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDescription");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getVersion(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getVersion");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getKey(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Settings getSettings()
    {
        String extension = "getSettings().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Settings> ctor = org.directwebremoting.proxy.jsx3.app.Settings.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Settings.class.getName());
        }
    }

    /**
     * 
     * @param strURI 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolveURI(String strURI)
    {
        String extension = "resolveURI(\"" + strURI + "\").";
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
    public org.directwebremoting.proxy.jsx3.net.URI resolveURI(org.directwebremoting.proxy.jsx3.net.URI strURI)
    {
        String extension = "resolveURI(\"" + strURI + "\").";
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
    public void getUriPrefix(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getUriPrefix");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param strURI 
     * @param bRel 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativizeURI(String strURI, boolean bRel)
    {
        String extension = "relativizeURI(\"" + strURI + "\", \"" + bRel + "\").";
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
     * @param bRel 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativizeURI(org.directwebremoting.proxy.jsx3.net.URI strURI, boolean bRel)
    {
        String extension = "relativizeURI(\"" + strURI + "\", \"" + bRel + "\").";
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
