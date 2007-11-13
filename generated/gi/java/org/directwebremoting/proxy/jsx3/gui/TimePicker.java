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
import java.util.Date;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class TimePicker extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public TimePicker(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param intLeft either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param intTop either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param intHeight either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     */
    public TimePicker(String strName, int intLeft, int intTop, int intHeight)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new TimePicker", strName, intLeft, intTop, intHeight);
        setInitScript(script);
    }

    /**
     * Returns whether this time picker shows the second input field.
     * @param callback 0 or 1.
     */
    @SuppressWarnings("unchecked")
    public void getShowSeconds(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getShowSeconds");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether this time picker shows the millisecond input field. The millisecond input field will only
    display if both this and showSeconds are true.
     * @param callback 0 or 1.
     */
    @SuppressWarnings("unchecked")
    public void getShowMillis(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getShowMillis");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether this time picker displays with a 24-hour clock. The default value depends on the default
    locale.
     * @param callback 0 or 1.
     */
    @SuppressWarnings("unchecked")
    public void is24Hour(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = is24Hour");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets whether this time picker shows the second input field.
     * @param bShow 
     */
    public void setShowSeconds(boolean bShow)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setShowSeconds", bShow);
        getScriptProxy().addScript(script);
    }

    /**
     * Sets whether this time picker shows the millisecond input field.
     * @param bShow 
     */
    public void setShowMillis(boolean bShow)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setShowMillis", bShow);
        getScriptProxy().addScript(script);
    }

    /**
     * Sets whether this time picker uses a 24-hour clock.
     * @param b24Hour may be <code>null</code> to use the locale default value.
     */
    public void set24Hour(boolean b24Hour)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("set24Hour", b24Hour);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the hour (0-23) of the time value of this time picker.
     */
    @SuppressWarnings("unchecked")
    public void getHours(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getHours");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the hour value of this time picker. This method updates the view immediately.
     * @param intHours 0-23.
     */
    public void setHours(int intHours)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setHours", intHours);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the minute (0-60) of the time value of this time picker.
     */
    @SuppressWarnings("unchecked")
    public void getMinutes(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMinutes");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the minute value of this time picker. This method updates the view immediately.
     * @param intMinutes 0-59.
     */
    public void setMinutes(int intMinutes)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMinutes", intMinutes);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the second (0-60) of the time value of this time picker.
     */
    @SuppressWarnings("unchecked")
    public void getSeconds(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getSeconds");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the second value of this time picker. This method updates the view immediately.
     * @param intSeconds 0-59.
     */
    public void setSeconds(int intSeconds)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setSeconds", intSeconds);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the millisecond (0-999) of the time value of this time picker.
     */
    @SuppressWarnings("unchecked")
    public void getMilliseconds(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMilliseconds");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the millisecond value of this time picker. This method updates the view immediately.
     * @param intMillis 0-999.
     */
    public void setMilliseconds(int intMillis)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMilliseconds", intMillis);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns a date with the time of day set to the value of this time picker. This method either returns the
    objDate parameter with the time of day set in local time or, if objDate is not provided,
    it returns a new date (the current day) with the time of day set.
     * @param objDate the date on which to set the time of day. This parameter is optional.
     */
    @SuppressWarnings("unchecked")
    public void getDate(Date objDate, Callback<Date> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Date.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDate", objDate);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the value of this time picker in local time. This method updates the view immediately.
     * @param objDate the date whose time of day information to use for setting the value of this time picker.
    If this parameter is null, the current time value is cleared.
     */
    public void setDate(Date objDate)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setDate", objDate);
        getScriptProxy().addScript(script);
    }

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
        String extension = "doKeyBinding(\"" + fctCallback + "\", \"" + strKeys + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.HotKey> ctor = org.directwebremoting.proxy.jsx3.gui.HotKey.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "doReset().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Abstract method that must be implemented by any class that implements the Form interface.
     * @param callback <code>STATEINVALID</code> or <code>STATEVALID</code>.
     */
    @SuppressWarnings("unchecked")
    public void doValidate(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = doValidate");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the background color of this control when it is disabled.
     * @param callback valid CSS property value, (i.e., red, #ff0000)
     */
    @SuppressWarnings("unchecked")
    public void getDisabledBackgroundColor(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDisabledBackgroundColor");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the font color to use when this control is disabled.
     * @param callback valid CSS property value, (i.e., red, #ff0000)
     */
    @SuppressWarnings("unchecked")
    public void getDisabledColor(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDisabledColor");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the state for the form field control. If no enabled state is set, this method returns
    STATEENABLED.
     * @param callback <code>STATEDISABLED</code> or <code>STATEENABLED</code>.
     */
    @SuppressWarnings("unchecked")
    public void getEnabled(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getEnabled");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the key binding that when keyed will fire the execute event for this control.
     * @param callback plus-delimited (e.g.,'+') key sequence such as ctrl+s or ctrl+shift+alt+h or shift+a, etc
     */
    @SuppressWarnings("unchecked")
    public void getKeyBinding(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getKeyBinding");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether or not this control is required. If the required property has never been set, this method returns
    OPTIONAL.
     * @param callback <code>REQUIRED</code> or <code>OPTIONAL</code>.
     */
    @SuppressWarnings("unchecked")
    public void getRequired(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getRequired");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the validation state of this control. If the validationState property has never been set, this method returns
    STATEVALID.
     * @param callback <code>STATEINVALID</code> or <code>STATEVALID</code>.
     */
    @SuppressWarnings("unchecked")
    public void getValidationState(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getValidationState");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the value of this control.
     */
    @SuppressWarnings("unchecked")
    public void getValue(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getValue");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the background color of this form control when it is disabled.
     * @param strColor valid CSS property value, (i.e., red, #ff0000)
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setDisabledBackgroundColor(String strColor)
    {
        String extension = "setDisabledBackgroundColor(\"" + strColor + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "setDisabledColor(\"" + strColor + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        script.appendCall("setEnabled", intEnabled, bRepaint);
        getScriptProxy().addScript(script);
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
        String extension = "setKeyBinding(\"" + strSequence + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "setRequired(\"" + required + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "setValidationState(\"" + intState + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets the value of this control.
     * @param vntValue string/int value for the component
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setValue(int vntValue)
    {
        String extension = "setValue(\"" + vntValue + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

}
