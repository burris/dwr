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
public class TextLine extends org.directwebremoting.proxy.jsx3.vector.Shape
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public TextLine(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param x1 
     * @param y1 
     * @param x2 
     * @param y2 
     * @param text the text to display on the text path
     */
    public TextLine(int x1, int y1, int x2, int y2, String text)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the text field.
     * @return text
     *
    @SuppressWarnings("unchecked")
    public String getText(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the text field, the text to display on the text path.
     * @param text the new value for text
     */
    public void setText(String text)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setText(").appendData(text).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the color field.
     * @return color
     *
    @SuppressWarnings("unchecked")
    public String getColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the fontFamily field.
     * @return fontFamily
     *
    @SuppressWarnings("unchecked")
    public String getFontFamily(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the fontsize field.
     * @return fontsize
     *
    @SuppressWarnings("unchecked")
    public String getFontSize(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the fontStyle field.
     * @return fontStyle
     *
    @SuppressWarnings("unchecked")
    public String getFontStyle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the fontWeight field.
     * @return fontWeight
     *
    @SuppressWarnings("unchecked")
    public String getFontWeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the textAlign field.
     * @return textAlign
     *
    @SuppressWarnings("unchecked")
    public String getTextAlign(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the textDecoration field.
     * @return textDecoration
     *
    @SuppressWarnings("unchecked")
    public String getTextDecoration(Callback callback)
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
    public void setColor(String color)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColor(").appendData(color).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontFamily field.
     * @param fontFamily the new value for fontFamily
     */
    public void setFontFamily(String fontFamily)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFontFamily(").appendData(fontFamily).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontsize field.
     * @param fontSize the new value for fontsize
     */
    public void setFontSize(int fontSize)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFontSize(").appendData(fontSize).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontStyle field.
     * @param fontStyle the new value for fontStyle
     */
    public void setFontStyle(String fontStyle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFontStyle(").appendData(fontStyle).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontWeight field.
     * @param fontWeight the new value for fontWeight
     */
    public void setFontWeight(String fontWeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFontWeight(").appendData(fontWeight).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the textAlign field.
     * @param textAlign the new value for textAlign
     */
    public void setTextAlign(String textAlign)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTextAlign(").appendData(textAlign).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the textDecoration field.
     * @param textDecoration the new value for textDecoration
     */
    public void setTextDecoration(String textDecoration)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTextDecoration(").appendData(textDecoration).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
