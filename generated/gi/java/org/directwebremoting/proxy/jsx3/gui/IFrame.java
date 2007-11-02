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
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class IFrame extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public IFrame(ProxyHelper helper)
    {
        super(helper);
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

    /*
     * Returns the native iframe object of this iframe. Depending on browser security settings and the URL of this
    iframe, the native iframe object may not be available. In this case, this method returns null.
     *
    @SuppressWarnings("unchecked")
    public String getIFrame(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the native document object of this iframe. Depending on browser security settings and the URL of this
    iframe, the native document object may not be available. In this case, this method returns null.
     *
    @SuppressWarnings("unchecked")
    public HTMLDocument getContentDocument(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the URI of this iframe.
     *
    @SuppressWarnings("unchecked")
    public String getSrc(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the URI of this iframe. The URI can be absolute or relative from the content base of the server that
    owns this object. If this iframe is rendered on screen, its location is updated immediately.
     * @param srcSrc 
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.IFrame setSrc(String srcSrc)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSrc(").appendData(srcSrc).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the scroll mode of this iframe.
     *
    @SuppressWarnings("unchecked")
    public int getScrolling(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the scroll mode of this iframe.
     * @param intScrolling one of <code>SCROLLYES</code>, <code>SCROLLNO</code>, or <code>SCROLLAUTO</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.IFrame setScrolling(int intScrolling)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setScrolling(").appendData(intScrolling).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

}
