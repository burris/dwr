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
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class DatePicker extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public DatePicker(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param intLeft either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param intTop either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param intWidth either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param intHeight either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     */
    public DatePicker(String strName, int intLeft, int intTop, int intWidth, int intHeight)
    {
        super((ProxyHelper) null);
    }

    /**
     * Shows the calendar for this date picker and places focus within the calendar as though the user had clicked
    on the show calendar button. The calendar hides automatically when focus leaves the calendar.
     */
    public void focusCalendar()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("focusCalendar(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the jsxformat field
     * @return jsxformat
     *
    @SuppressWarnings("unchecked")
    public String getFormat(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the format of this date picker. The format should conform to the syntax of jsx3.util.DatePicker.
    The provided format may also be an integer, in which case it is intepreted as one of of the fields of
    DatePicker - SHORT, MEDIUM, LONG, or FULL - and
    the displayed format will be localized accordingly.
     * @param jsxformat the new format.
     */
    public void setFormat(String jsxformat)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFormat(").appendData(jsxformat).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the format of this date picker. The format should conform to the syntax of jsx3.util.DatePicker.
    The provided format may also be an integer, in which case it is intepreted as one of of the fields of
    DatePicker - SHORT, MEDIUM, LONG, or FULL - and
    the displayed format will be localized accordingly.
     * @param jsxformat the new format.
     */
    public void setFormat(int jsxformat)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFormat(").appendData(jsxformat).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the jsxfirstweekday field
     * @return jsxfirstweekday
     *
    @SuppressWarnings("unchecked")
    public int getFirstDayOfWeek(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the jsxfirstweekday field
     * @param jsxfirstweekday the new value for jsxfirstweekday
     */
    public void setFirstDayOfWeek(int jsxfirstweekday)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFirstDayOfWeek(").appendData(jsxfirstweekday).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the current value of this form field as a JavaScript Date object.
     *
    @SuppressWarnings("unchecked")
    public Date getDate(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the value of this form field (the string displayed in the text box).
     *
    @SuppressWarnings("unchecked")
    public String getValue(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * set the value of this form field
     * @param date may be null to clear the value of the form field
     */
    public void setDate(Date date)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDate(").appendData(date).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * 
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

    /**
     * Sets the value of this control.
     * @param vntValue string/int value for the component
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setValue(int vntValue)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setValue(\"" + vntValue + "\").");
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
