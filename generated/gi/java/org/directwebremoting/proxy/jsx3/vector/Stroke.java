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

package org.directwebremoting.proxy.jsx3.vector;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Stroke extends org.directwebremoting.proxy.jsx3.html.Tag
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Stroke(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param color the color value, as a hex String or 24-bit integer value, defaults to 0x000000
     * @param width the width of the stroke, in pixels, defaults to 1
     * @param alpha the opacity value, valid values are between 0 and 1, defaults to 1
     */
    public Stroke(int color, int width, float alpha)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the color field.
     * @return color
     *
    @SuppressWarnings("unchecked")
    public int getColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the color field, as a CSS hex string.
     *
    @SuppressWarnings("unchecked")
    public String getColorHtml(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the color field.
     * @param color the new value for color
     */
    public void setColor(int color)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColor(").appendData(color).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the color field.
     * @param color the new value for color
     */
    public void setColor(String color)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColor(").appendData(color).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the width field.
     * @return width
     *
    @SuppressWarnings("unchecked")
    public int getWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the width field.
     * @param width the new value for width
     */
    public void setWidth(int width)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setWidth(").appendData(width).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the alpha field.
     * @return alpha
     *
    @SuppressWarnings("unchecked")
    public float getAlpha(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the alpha field.
     * @param alpha the new value for alpha
     */
    public void setAlpha(float alpha)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAlpha(").appendData(alpha).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * parses a VectorStroke from a string representation, that format is "color width alpha"
     * @param v the string representation
     * @return null if v is empty, v if v is already a VectorStroke, or otherwise a new VectorStroke created by parsing the string according to the format specified above
     *
    @SuppressWarnings("unchecked")
    public VectorStroke valueOf(String v, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

}
