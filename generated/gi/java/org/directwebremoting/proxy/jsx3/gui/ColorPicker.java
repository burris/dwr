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

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class ColorPicker extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public ColorPicker(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strName 
     * @param vntLeft 
     * @param vntTop 
     * @param vntWidth 
     * @param vntHeight 
     */
    public ColorPicker(String strName, int vntLeft, int vntTop, int vntWidth, int vntHeight)
    {
        super((ProxyHelper) null);
    }

    /**
     * The default rendered width of this control if no width is specified.
     */
    public static final int DEFAULT_WIDTH = 324;

    /**
     * The default rendered height of this control if no height is specified.
     */
    public static final int DEFAULT_HEIGHT = 300;

    /**
     * Value for the axis property indicating a hue axis.
     */
    public static final int HUE = 1;

    /**
     * Value for the axis property indicating a saturation axis.
     */
    public static final int SATURATION = 2;

    /**
     * Value for the axis property indicating a brightness axis.
     */
    public static final int BRIGHTNESS = 3;

    /*
     * Returns the RGB value of the currently selected color as an integer. The return value is
    a 24-bit number of the form 0xRRGGBB.
     *
    @SuppressWarnings("unchecked")
    public int getValue(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the RGB value of this color picker.
     * @param strValue the supported formats are: RGB integer value as number or string and HTML hex
    code, <code>"#000000"</code>.
     */
    public void setValue(int strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the RGB value of this color picker.
     * @param strValue the supported formats are: RGB integer value as number or string and HTML hex
    code, <code>"#000000"</code>.
     */
    public void setValue(String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * 
     * @return always <code>jsx3.gui.Form.STATEVALID</code>.
     *
    @SuppressWarnings("unchecked")
    public int doValidate(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the RGB value of the currently selected color as an integer. The return value is 
    a 24-bit number of the form 0xRRGGBB.
     *
    @SuppressWarnings("unchecked")
    public int getRGB(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the currently selected color by RGB. The view is updated to reflect the change in value.
     * @param rgb a 24-bit integer of the form <code>0xRRGGBB</code>.
     */
    public void setRGB(int rgb)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRGB(").appendData(rgb).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * 
     * @return <code>HUE</code>, <code>SATURATION</code>, or <code>BRIGHTNESS</code>.
     *
    @SuppressWarnings("unchecked")
    public int getAxis(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the color axis shown on the right side of the control. The other two axes are displayed in a box on the
    left side.
     * @param intAxis <code>HUE</code>, <code>SATURATION</code>, or <code>BRIGHTNESS</code>.
     */
    public org.directwebremoting.proxy.jsx3.gui.ColorPicker setAxis(int intAxis)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAxis(").appendData(intAxis).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets the currently selected color by HSB components.
     * @param h The hue component, <code>[0.0, 1.0]</code>.
     * @param s The saturation component, <code>[0.0, 1.0]</code>.
     * @param b The brightness component, <code>[0.0, 1.0]</code>.
     */
    public void setHSB(float h, float s, float b)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHSB(").appendData(h).appendScript(",")

        .appendData(s).appendScript(",")

        .appendData(b).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Converts HSB color components to RGB components.
     * @param h The hue component, [0.0, 1.0].
     * @param s The saturation component, [0.0, 1.0].
     * @param l The brightness component, [0.0, 1.0].
     * @return <code>[r, g, b]</code>. Each component is an integer [0, 255].
     *
    @SuppressWarnings("unchecked")
    public Object[] HSBtoRGB(float h, float s, float l, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Converts RGB color components to HSB components.
     * @param r The red component, <code>[0, 255]</code>. If only one parameter is passed, this parameter
    may be a 24-bit integer of the form <code>0xRRGGBB</code>.
     * @param g The green component, <code>[0, 255]</code>.
     * @param b The blue component, <code>[0, 255]</code>.
     * @return <code>[h, s, b]</code>. Each component is a float <code>[0.0, 1.0]</code>.
     *
    @SuppressWarnings("unchecked")
    public Object[] RGBtoHSB(int r, int g, int b, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Binds the given key sequence to a callback function. Any object that has a key binding (specified with
    setKeyBinding()) will call this method when painted to register the key sequence with an appropriate
    ancestor of this form control. Any key down event that bubbles up to the ancestor without being intercepted
    and matches the given key sequence will invoke the given callback function.

    As of 3.2: The hot key will be registered with the first ancestor found that is either a
    jsx3.gui.Window, a jsx3.gui.Dialog, or the root block of a jsx3.app.Server.
     * @param fctCallback JavaScript function to execute when the given sequence is keyed by the user.
     * @param strKeys a plus-delimited ('+') key sequence such as <code>ctrl+s</code> or
    <code>ctrl+shift+alt+h</code> or <code>shift+a</code>, etc. Any combination of shift, ctrl, and alt are
    supported, including none. Also supported as the final token are <code>enter</code>, <code>esc</code>,
    <code>tab</code>, <code>del</code>, and <code>space</code>. To specify the final token as a key code, the
    last token can be the key code contained in brackets, <code>[13]</code>.
     * @return the registered hot key.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.HotKey doKeyBinding(org.directwebremoting.proxy.CodeBlock fctCallback, String strKeys)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("doKeyBinding(\"" + fctCallback + "\", \"" + strKeys + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.HotKey> ctor = org.directwebremoting.proxy.jsx3.gui.HotKey.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.HotKey.class.getName());
        }
    }

    /**
     * Resets the validation state of this control.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form doReset()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("doReset().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /*
     * Returns the background color of this control when it is disabled.
     * @return valid CSS property value, (i.e., red, #ff0000)
     *
    @SuppressWarnings("unchecked")
    public String getDisabledBackgroundColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the font color to use when this control is disabled.
     * @return valid CSS property value, (i.e., red, #ff0000)
     *
    @SuppressWarnings("unchecked")
    public String getDisabledColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the state for the form field control. If no enabled state is set, this method returns
    STATEENABLED.
     * @return <code>STATEDISABLED</code> or <code>STATEENABLED</code>.
     *
    @SuppressWarnings("unchecked")
    public int getEnabled(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the key binding that when keyed will fire the execute event for this control.
     * @return plus-delimited (e.g.,'+') key sequence such as ctrl+s or ctrl+shift+alt+h or shift+a, etc
     *
    @SuppressWarnings("unchecked")
    public String getKeyBinding(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether or not this control is required. If the required property has never been set, this method returns
    OPTIONAL.
     * @return <code>REQUIRED</code> or <code>OPTIONAL</code>.
     *
    @SuppressWarnings("unchecked")
    public int getRequired(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the validation state of this control. If the validationState property has never been set, this method returns
    STATEVALID.
     * @return <code>STATEINVALID</code> or <code>STATEVALID</code>.
     *
    @SuppressWarnings("unchecked")
    public int getValidationState(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the background color of this form control when it is disabled.
     * @param strColor valid CSS property value, (i.e., red, #ff0000)
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setDisabledBackgroundColor(String strColor)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setDisabledBackgroundColor(\"" + strColor + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets the font color to use when this control is disabled.
     * @param strColor valid CSS property value, (i.e., red, #ff0000)
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setDisabledColor(String strColor)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setDisabledColor(\"" + strColor + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets whether this control is enabled. Disabled controls do not respond to user interaction.
     * @param intEnabled <code>STATEDISABLED</code> or <code>STATEENABLED</code>. <code>null</code> is
    equivalent to <code>STATEENABLED</code>.
     * @param bRepaint if <code>true</code> this control is immediately repainted to reflect the new setting.
     */
    public void setEnabled(int intEnabled, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setEnabled(").appendData(intEnabled).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the key binding that when keyed will fire the bound execute (jsx3.gui.Interactive.EXECUTE)
    event for this control.
     * @param strSequence plus-delimited (e.g.,'+') key sequence such as ctrl+s or ctrl+shift+alt+h or shift+a, etc
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setKeyBinding(String strSequence)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setKeyBinding(\"" + strSequence + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets whether or not this control is required.
     * @param required {int} <code>REQUIRED</code> or <code>OPTIONAL</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setRequired(int required)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setRequired(\"" + required + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets the validation state of this control. The validation state of a control is not serialized.
     * @param intState <code>STATEINVALID</code> or <code>STATEVALID</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setValidationState(int intState)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setValidationState(\"" + intState + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

}
