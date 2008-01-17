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
package jsx3.gui;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * Renders an IFrame.
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class IFrame extends jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public IFrame(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }


    /**
     * 
     */
    public static final int SCROLLYES = 1;

    /**
     * 
     */
    public static final int SCROLLNO = 2;

    /**
     * 
     */
    public static final int SCROLLAUTO = 3;


    /**
     * Returns the native iframe object of this iframe. Depending on browser security settings and the URL of this
iframe, the native iframe object may not be available. In this case, this method returns null.
     */
    @SuppressWarnings("unchecked")
    public void getIFrame(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getIFrame");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the native document object of this iframe. Depending on browser security settings and the URL of this
iframe, the native document object may not be available. In this case, this method returns null.
     */
    @SuppressWarnings("unchecked")
    public void getContentDocument(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getContentDocument");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the URI of this iframe.
     */
    @SuppressWarnings("unchecked")
    public void getSrc(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getSrc");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the URI of this iframe. The URI can be absolute or relative from the content base of the server that
owns this object. If this iframe is rendered on screen, its location is updated immediately.
     * @param srcSrc 
     * @return this object.
     */
    public jsx3.gui.IFrame setSrc(String srcSrc)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setSrc", srcSrc);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns the scroll mode of this iframe.
     */
    @SuppressWarnings("unchecked")
    public void getScrolling(org.directwebremoting.proxy.Callback<Integer> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getScrolling");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the scroll mode of this iframe.
     * @param intScrolling one of <code>SCROLLYES</code>, <code>SCROLLNO</code>, or <code>SCROLLAUTO</code>.
     * @return this object.
     */
    public jsx3.gui.IFrame setScrolling(int intScrolling)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setScrolling", intScrolling);
        getScriptProxy().addScript(script);
        return this;
    }

}

