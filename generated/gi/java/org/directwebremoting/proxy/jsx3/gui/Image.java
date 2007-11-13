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
package org.directwebremoting.proxy.jsx3.gui;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Image extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Image(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getRenderedWidth(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getRenderedWidth");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void getRenderedHeight(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getRenderedHeight");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the URI of this image.
     */
    @SuppressWarnings("unchecked")
    public void getSrc(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getSrc");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the URI of this image. The URI can be absolute or relative from the content base of the server that
    owns this object.
     * @param srcSrc 
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Image setSrc(String srcSrc)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setSrc", srcSrc);
        getScriptProxy().addScript(script);
        return this;
    }

}
