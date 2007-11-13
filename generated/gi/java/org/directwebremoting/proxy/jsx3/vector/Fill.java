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
public class Fill extends org.directwebremoting.proxy.jsx3.html.Tag
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Fill(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param color the color value, as a hex String or 24-bit integer value, defaults to 0x000000
     * @param alpha the opacity value, valid values are between 0 and 1, defaults to 1
     */
    public Fill(int color, float alpha)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Fill", color, alpha);
        setInitScript(script);
    }

    /**
     * Returns the color field, as previously set in the constructor or with setColor().
     */
    public void getColor()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("getColor");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the color field, as a CSS hex string.
     */
    @SuppressWarnings("unchecked")
    public void getColorHtml(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getColorHtml");
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

    /**
     * Sets the color field.
     * @param color the new value for color
     */
    public void setColor(int color)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setColor", color);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the alpha field, as previously set in the constructor or with setAlpha().
     * @param callback alpha
     */
    @SuppressWarnings("unchecked")
    public void getAlpha(Callback<Float> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Float.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAlpha");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the alpha field, valid values are between 0 (transparent) and 1 (opaque)..
     * @param alpha the new value for alpha
     */
    public void setAlpha(float alpha)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setAlpha", alpha);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the type field, as set with setType().
     * @param callback type
     */
    @SuppressWarnings("unchecked")
    public void getType(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getType");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the type field, valid values are enumerated in the VML specification, though only 'solid', 'gradient', and 'gradientradial' are truly supported by this class.
     * @param type the new value for type
     */
    public void setType(String type)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setType", type);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the color2 field, as set with setColor2().
     */
    public void getColor2()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("getColor2");
        getScriptProxy().addScript(script);
    }

    /**
     * ? getColor2Html() {String} gets the color2 field, as a CSS hex string
     */
    public void getColor2Html()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("getColor2Html");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the color2 field.
     * @param color2 the new value for color2
     */
    public void setColor2(String color2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setColor2", color2);
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the color2 field.
     * @param color2 the new value for color2
     */
    public void setColor2(int color2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setColor2", color2);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the alpha2 field, as set with setAlpha2().
     * @param callback alpha2
     */
    @SuppressWarnings("unchecked")
    public void getAlpha2(Callback<Float> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Float.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAlpha2");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the alpha2 field, valid values are between 0 (transparent) and 1 (opaque)..
     * @param alpha2 the new value for alpha2
     */
    public void setAlpha2(float alpha2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setAlpha2", alpha2);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the angle field (the angle along which the gradient goes), as set with setAngle().
     * @param callback angle
     */
    @SuppressWarnings("unchecked")
    public void getAngle(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAngle");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the angle field, valid values are between 0 and 360. 0 is the vector pointing rightward.
     * @param angle the new value for angle
     */
    public void setAngle(int angle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setAngle", angle);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the colors field, as set with setColors().
     * @param callback colors
     */
    @SuppressWarnings("unchecked")
    public void getColors(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getColors");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the colors field, see the documentation for <fill> in the VML documentation.
     * @param colors the new value for colors
     */
    public void setColors(String colors)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setColors", colors);
        getScriptProxy().addScript(script);
    }

    /**
     * Parses a vector fill from its string representation. The format is "color alpha".
     * @param v the string representation of a fill.
     * @return <code>null</code> if <code>v</code> is empty, <code>v</code> if <code>v</code>
    is already a vector fill, or otherwise a new vector fill created by parsing the string according to the
    format specified above.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Fill valueOf(String v)
    {
        String extension = "valueOf(\"" + v + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Fill> ctor = org.directwebremoting.proxy.jsx3.vector.Fill.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Fill.class.getName());
        }
    }

    /**
     * Parses a vector fill from its string representation. The format is "color alpha".
     * @param v the string representation of a fill.
     * @return <code>null</code> if <code>v</code> is empty, <code>v</code> if <code>v</code>
    is already a vector fill, or otherwise a new vector fill created by parsing the string according to the
    format specified above.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Fill valueOf(org.directwebremoting.proxy.jsx3.vector.Fill v)
    {
        String extension = "valueOf(\"" + v + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Fill> ctor = org.directwebremoting.proxy.jsx3.vector.Fill.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Fill.class.getName());
        }
    }

}
