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
package jsx3.app;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * A class that represents a JSX add-in. The JSX system creates an instance of this class for every add-in that 
is loaded.
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class AddIn extends jsx3.lang.Object
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
    public void getId(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getId");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getName(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getName");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getDescription(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDescription");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getVersion(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getVersion");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getKey(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public jsx3.app.Settings getSettings()
    {
        String extension = "getSettings().";
        try
        {
            java.lang.reflect.Constructor<jsx3.app.Settings> ctor = jsx3.app.Settings.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + jsx3.app.Settings.class.getName());
        }
    }


    /**
     * 
     * @param strURI 
     */
    @SuppressWarnings("unchecked")
    public void resolveURI(java.net.URI strURI, org.directwebremoting.proxy.Callback<java.net.URI> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, java.net.URI.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = resolveURI", strURI);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param strURI 
     */
    @SuppressWarnings("unchecked")
    public void resolveURI(String strURI, org.directwebremoting.proxy.Callback<java.net.URI> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, java.net.URI.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = resolveURI", strURI);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getUriPrefix(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

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
    public void relativizeURI(String strURI, boolean bRel, org.directwebremoting.proxy.Callback<java.net.URI> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, java.net.URI.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = relativizeURI", strURI, bRel);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param strURI 
     * @param bRel 
     */
    @SuppressWarnings("unchecked")
    public void relativizeURI(java.net.URI strURI, boolean bRel, org.directwebremoting.proxy.Callback<java.net.URI> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, java.net.URI.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = relativizeURI", strURI, bRel);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

}

