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
package jsx3.html;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * Represents an HTML element that defines font styles.

This class is available only when the Charting add-in is enabled.
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class FontTag extends jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public FontTag(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }



    /**
     * Returns the fontFamily field.
     * @param callback fontFamily
     */
    @SuppressWarnings("unchecked")
    public void getFontFamily(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getFontFamily");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontFamily field.
     * @param fontFamily the new value for fontFamily
     */
    public void setFontFamily(String fontFamily)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setFontFamily", fontFamily);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the fontsize field.
     * @param callback fontsize
     */
    @SuppressWarnings("unchecked")
    public void getFontSize(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getFontSize");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontsize field.
     * @param fontSize the new value for fontsize
     */
    public void setFontSize(int fontSize)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setFontSize", fontSize);
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontsize field.
     * @param fontSize the new value for fontsize
     */
    public void setFontSize(String fontSize)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setFontSize", fontSize);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the fontStyle field.
     * @param callback fontStyle
     */
    @SuppressWarnings("unchecked")
    public void getFontStyle(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getFontStyle");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontStyle field.
     * @param fontStyle the new value for fontStyle
     */
    public void setFontStyle(String fontStyle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setFontStyle", fontStyle);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the fontWeight field.
     * @param callback fontWeight
     */
    @SuppressWarnings("unchecked")
    public void getFontWeight(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getFontWeight");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the fontWeight field.
     * @param fontWeight the new value for fontWeight
     */
    public void setFontWeight(String fontWeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setFontWeight", fontWeight);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the textAlign field.
     * @param callback textAlign
     */
    @SuppressWarnings("unchecked")
    public void getTextAlign(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTextAlign");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the textAlign field.
     * @param textAlign the new value for textAlign
     */
    public void setTextAlign(String textAlign)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setTextAlign", textAlign);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the textDecoration field.
     * @param callback textDecoration
     */
    @SuppressWarnings("unchecked")
    public void getTextDecoration(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTextDecoration");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the textDecoration field.
     * @param textDecoration the new value for textDecoration
     */
    public void setTextDecoration(String textDecoration)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setTextDecoration", textDecoration);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the color field.
     * @param callback color
     */
    @SuppressWarnings("unchecked")
    public void getColor(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getColor");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the color field.
     * @param color the new value for color
     */
    public void setColor(String color)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setColor", color);
        getScriptProxy().addScript(script);
    }

}

