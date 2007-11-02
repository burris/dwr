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
public class TextBox extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public TextBox(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param vntLeft either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntTop either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntWidth either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntHeight either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param strValue this value to appear in the textbox/textarea. This value will be set as the defaultValue for the text box when it is initialized; if edits are made by the user, these edits can be accessed via [object].getValue(); if the initial value is needed, use [object].getDefaultValue();
     * @param TYPE one of two valid types: jsx3.gui.TextBox.TYPETEXT, jsx3.gui.TextBox.TYPETEXTAREA. If null is passed, jsx3.gui.TextBox.DEFAULTTYPE is used
     */
    public TextBox(String strName, int vntLeft, int vntTop, int vntWidth, int vntHeight, String strValue, String TYPE)
    {
        super((ProxyHelper) null);
    }

    /**
     * texbox type 0
     */
    public static final int TYPETEXT = 0;

    /**
     * text area type 1
     */
    public static final int TYPETEXTAREA = 1;

    /**
     * password type 2
     */
    public static final int TYPEPASSWORD = 2;

    /**
     * wrap text (default)
     */
    public static final int WRAPYES = 1;

    /**
     * no wrap
     */
    public static final int WRAPNO = 0;

    /**
     * none
     */
    public static final String OVERFLOWNORMAL = "";

    /**
     * as needed by content
     */
    public static final String OVERFLOWAUTO = "auto";

    /**
     * persistent scrollbars
     */
    public static final String OVERFLOWSCROLL = "scroll";

    /**
     * CSS color property
     */
    public static final String DEFAULTBACKGROUNDCOLOR = "#ffffff";

    /**
     * none
     */
    public static final String VALIDATIONNONE = "none";

    /**
     * us ssn
     */
    public static final String VALIDATIONSSN = "ssn";

    /**
     * telephone
     */
    public static final String VALIDATIONPHONE = "phone";

    /**
     * email
     */
    public static final String VALIDATIONEMAIL = "email";

    /**
     * numbers only
     */
    public static final String VALIDATIONNUMBER = "number";

    /**
     * letter
     */
    public static final String VALIDATIONLETTER = "letter";

    /**
     * uszip
     */
    public static final String VALIDATIONUSZIP = "uszip";

    /**
     * jsx30textbox
     */
    public static final String DEFAULTCLASSNAME = "jsx30textbox";

    /*
     * if TYPE for the object is jsx3.gui.TextBox.TYPETEXT, and this returns a positive integer, the maxlen property for the textbox will be set to this value; returns null if no value found
     * @return positive integer
     *
    @SuppressWarnings("unchecked")
    public int getMaxLength(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * if TYPE for the object is jsx3.gui.TextBox.TYPETEXT, setting this to a positive integer affects the maxlen property for the textbox;
         returns a reference to self to facilitate method chaining
     * @param intMaxLength positive integer, maxlen for the number of characters accepted by the textbox
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.TextBox setMaxLength(int intMaxLength)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMaxLength(").appendData(intMaxLength).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the type of TextBox. Default: jsx3.gui.TextBox.TYPETEXT
     * @return one of: jsx3.gui.TextBox.TYPETEXT, jsx3.gui.TextBox.TYPETEXTAREA, jsx3.gui.TextBox.TYPEPASSWORD
     *
    @SuppressWarnings("unchecked")
    public int getType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the type of jsx3.gui.TextBox
         returns a reference to self to facilitate method chaining
     * @param TYPE one of: jsx3.gui.TextBox.TYPETEXT, jsx3.gui.TextBox.TYPETEXTAREA, jsx3.gui.TextBox.TYPEPASSWORD
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.TextBox setType(int TYPE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setType(").appendData(TYPE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * logically tries to determine the value for the text box by 1) checking for value of on-screen VIEW; 2) checking for 'value' property for in-memory MODEL 3) checking getDefaultValue() for value when object was first initialized. Default: [empty string]
     * @return value for object
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

    /*
     * Returns value of textbox object when it was first initialized. Default: [empty string]
     * @return default value for object
     *
    @SuppressWarnings("unchecked")
    public String getDefaultValue(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * updates value property for both on-screen VIEW (if object is painted) and in-memory MODEL;
           returns a reference to self to facilitate method chaining
     * @param strValue value for the textbox/textarea
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.TextBox setValue(String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * set during object initialization; useful for tracking edits/updates to an object by doing a string comparison between getValue() and getDefaultValue();
           returns a reference to self to facilitate method chaining
     * @param strValue default value for the textbox/textarea
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.TextBox setDefaultValue(String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDefaultValue(").appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the text-wrapping/ word-breaking property for object if object type is jsx3.gui.TextBox.TYPETEXTAREA. Default: jsx3.gui.TextBox.WRAPYES
     * @return one of: jsx3.gui.TextBox.WRAPYES jsx3.gui.TextBox.WRAPNO
     *
    @SuppressWarnings("unchecked")
    public String getWrap(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the text-wrapping/ word-breaking property for object if object type is jsx3.gui.TextBox.TYPETEXTAREA.
     * @param bWrap one of: jsx3.gui.TextBox.WRAPYES jsx3.gui.TextBox.WRAPNO
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.TextBox setWrap(boolean bWrap)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setWrap(").appendData(bWrap).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the ID (CONSTANT) for one of the pre-canned regular expression filters that can be used to validate the user's response. Default: jsx3.gui.TextBox.VALIDATIONNONE
     * @return one of: jsx3.gui.TextBox.VALIDATIONNONE, jsx3.gui.TextBox.VALIDATIONSSN, jsx3.gui.TextBox.VALIDATIONPHONE, jsx3.gui.TextBox.VALIDATIONEMAIL, jsx3.gui.TextBox.VALIDATIONNUMBER, jsx3.gui.TextBox.VALIDATIONLETTER, jsx3.gui.TextBox.VALIDATIONUSZIP
     *
    @SuppressWarnings("unchecked")
    public String getValidationType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * when set, applies one of the pre-canned regular expression filters that can be used to validate the user's response;
           returns a reference to self to facilitate method chaining.
     * @param VALIDATIONTYPE one of: jsx3.gui.TextBox.VALIDATIONNONE, jsx3.gui.TextBox.VALIDATIONSSN, jsx3.gui.TextBox.VALIDATIONPHONE, jsx3.gui.TextBox.VALIDATIONEMAIL, jsx3.gui.TextBox.VALIDATIONNUMBER, jsx3.gui.TextBox.VALIDATIONLETTER, jsx3.gui.TextBox.VALIDATIONUSZIP
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.TextBox setValidationType(String VALIDATIONTYPE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValidationType(").appendData(VALIDATIONTYPE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the custom validation expression (a regular expression pattern to match). If this method returns
    a valid regular expression (as a string), it will be applied instead of the pre-canned regular expression. Default: null
    returned by the method, getValidationType; null is returned if the expression is not found
     * @return valid regular expression such as ^\d{3}-\d{2}-\d{4}$
     *
    @SuppressWarnings("unchecked")
    public String getValidationExpression(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the custom validation expression (a regular expression pattern to match).
             returns a reference to self to facilitate method chaining.
     * @param strValidationExpression valid regular expression such as ^\d{3}-\d{2}-\d{4}$
             If null is passed custom value is removed and [object].getValidationType() is used instead
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.TextBox setValidationExpression(String strValidationExpression)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValidationExpression(").appendData(strValidationExpression).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * validates form field, ensuring it contains the correct data set
     * @return true if field contains a valid value given @VALIDATIONTYPE
     *
    @SuppressWarnings("unchecked")
    public boolean doValidate(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * call to designate an error or alert the user's attention to the textbox on-screen. Causes the textbox to 'flash/blink'
     */
    public void beep()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("beep(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
