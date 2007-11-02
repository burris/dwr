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
public class Tree extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Tree(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param strId this value should correspond to the jsxid for the 'record' node is the selected node for the tree
     */
    public Tree(String strName, String strId)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String DEFAULTXSLURL = null;

    /**
     * JSX/images/tree/minus.gif (default)
     */
    public static final String ICONMINUS = "jsx:///images/tree/minus.gif";

    /**
     * JSX/images/tree/plus.gif (default)
     */
    public static final String ICONPLUS = "jsx:///images/tree/plus.gif";

    /**
     * JSX/images/tree/file.gif (default)
     */
    public static final String ICON = "jsx:///images/tree/file.gif";

    /**
     * JSX/images/tree/select.gif (default)
     */
    public static final String SELECTEDIMAGE = null;

    /**
     * jsx:///images/matrix/insert_before.gif
     */
    public static final String INSERT_BEFORE_IMG = null;

    /**
     * jsx:///images/matrix/append.gif
     */
    public static final String APPEND_IMG = null;

    /**
     * #8CAEDF (default)
     */
    public static final String BORDERCOLOR = "#8CAEDF";

    /**
     * #ffffff (default)
     */
    public static final String DEFAULTBACKGROUNDCOLOR = "#ffffff";

    /**
     * &nbsp; (default)
     */
    public static final String DEFAULTNODATAMSG = "&#160;";

    /**
     * Enum value for the multiSelect property indicating a multi-select tree.
     */
    public static final int MULTI = 1;

    /**
     * Enum value for the multiSelect property indicating a single-select tree.
     */
    public static final int SINGLE = 0;

    /**
     * Returns XSLT for the Tree, prioritizing the acquisition in the following order: 1) check cache; 2) check jsxxsl; 3) check jsxxslurl; 4) use default
     * @return jsx3.xml.Document instance containing valid XSL stylesheet
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getXSL()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXSL().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Document> ctor = org.directwebremoting.proxy.jsx3.xml.Document.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Document.class.getName());
        }
    }

    /**
     * Returns XSLT for the Tree, prioritizing the acquisition in the following order: 1) check cache; 2) check jsxxsl; 3) check jsxxslurl; 4) use default
     * @param returnType The expected return type
     * @return jsx3.xml.Document instance containing valid XSL stylesheet
     */
    @SuppressWarnings("unchecked")
    public <T> T getXSL(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXSL().");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /*
     * validates the Tree; if the Tree is set to 'required', a selection must be made to pass validation. Otherwise, a Tree will always pass validation
     * @return one of: jsx3.gui.Form.STATEINVALID or jsx3.gui.Form.STATEVALID
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
     * Selects a record in the tree.  This method updates the model, datamodel, and view.
     * @param strRecordId id for the record that will be the selected item, may be null to deselect all records
     * @param bReveal 
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tree setValue(String strRecordId, boolean bReveal)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strRecordId).appendScript(",")

        .appendData(bReveal).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Selects a record in the tree.  This method updates the model, datamodel, and view.
     * @param strRecordId id for the record that will be the selected item, may be null to deselect all records
     * @param bReveal 
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tree setValue(Object[] strRecordId, boolean bReveal)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strRecordId).appendScript(",")

        .appendData(bReveal).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Reveals a record by toggling parent nodes as necessary and scrolling any containing blocks within the tree.
     * @param strRecordId the id of the record to reveal
     * @param objJSX if provided, reveal the record up to this visual block; useful if the tree is set
    to <code>overflow:expand</code> and the containing block is set to <code>overflow:scroll</code>.
     */
    public void revealRecord(String strRecordId, org.directwebremoting.proxy.jsx3.gui.Block objJSX)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("revealRecord(").appendData(strRecordId).appendScript(",")

        .appendData(objJSX).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the jsxid attribute for the selected CDF record/records.
     * @return if single-select the jsxid of the selected record or <code>null</code> if none
    selected; if multi-select an array of the selected record ids.
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
     * Returns whether this tree is multi- (Tree.MULTI) or single-select (Tree.SINGLE).
     *
    @SuppressWarnings("unchecked")
    public int getMultiSelect(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether this tree is multi- (Tree.MULTI) or single-select (Tree.SINGLE).
     * @param intMulti <code>Tree.MULTI</code> or <code>Tree.SINGLE</code>
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tree setMultiSelect(int intMulti)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMultiSelect(").appendData(intMulti).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * if @strRecordId equals the id of the selected option (this.getValue()), only the text property will update;
           returns a ref to self to facilitate method chaining
     * @param strRecordId id for the record that will be 'redrawn' on-screen
     * @param ACTION One of the following two values: jsx3.xml.CDF.INSERT, jsx3.xml.CDF.DELETE
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Tree redrawRecord(String strRecordId, int ACTION)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("redrawRecord(\"" + strRecordId + "\", \"" + ACTION + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Tree> ctor = org.directwebremoting.proxy.jsx3.gui.Tree.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Tree.class.getName());
        }
    }

    /*
     * Returns whether or not the tree should paint its root node or paint the direct child nodes to the VIEW without rendering their containing root. Default: jsx3.Boolean.TRUE
     * @return one of jsx3.Boolean.TRUE or jsx3.Boolean.FALSE
     *
    @SuppressWarnings("unchecked")
    public int getRoot(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not the tree should paint its root node or paint the direct child nodes to the VIEW without rendering their containing root;
     * @param bBoolean one of jsx3.Boolean.TRUE or jsx3.Boolean.FALSE
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tree setRoot(int bBoolean)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRoot(").appendData(bBoolean).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the Icon to use for items in the tree. Default: jsx3.gui.Tree.ICON
     *
    @SuppressWarnings("unchecked")
    public String getIcon(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the Icon to use for items in the tree; returns a ref to self
     * @param strURL URL for icon to use
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tree setIcon(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setIcon(").appendData(strURL).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the Icon to use when a node is in an open state. Default: jsx3.gui.Tree.ICONMINUS
     * @return URL for icon to use when given tree node is toggled to closed; if null, value is reset to use URL referenced by jsx3.gui.Tree.ICONBOOKCLOSED
     *
    @SuppressWarnings("unchecked")
    public String getIconMinus(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the Icon to use when a node is in an open state.
     * @param strURL URL for icon to use when given tree node is toggled to closed; if null, value is reset to use URL referenced by jsx3.gui.Tree.ICONBOOKCLOSED
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tree setIconMinus(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setIconMinus(").appendData(strURL).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the Icon to use when the given tree node is in an closed state. Default: jsx3.gui.Tree.ICONPLUS
     * @return URL for icon to use
     *
    @SuppressWarnings("unchecked")
    public String getIconPlus(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the Icon to use when the given tree node is in an closed state
     * @param strURL URL for icon to use when given tree node is toggled to open; if null, value is reset to use URL referenced by jsx3.gui.Tree.ICONBOOKOPEN
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tree setIconPlus(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setIconPlus(").appendData(strURL).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * toggles the open/closed state for a node on the tree; updates both MODEL and VIEW; if the tree is not yet
         painted and the open state for a node needs to be set, call: [tree instance].insertRecordProperty(@strId,@strPropName,@strPropValue,false);
         if there is a VIEW for the item, the 'ontoggle' event will be fired; if the developer has bound an ontoggle script
         (e.g., [treeinstance].setEvent("var a=1;",jsx3.gui.Interactive.TOGGLE);), this script will have contextual access to the variables:
         objGUI: object reference to the on-screen DHTML object for the node just toggled; objRECORD: object reference for the node
         in the XML Cache; strID: The jsxid property(as a string) for the node object; bOPEN: whether to item was toggled open (true) or closed (false).
         Returns a reference to self to facilitate method chaining
     * @param strRecordId unique id for the given record (the 'jsxid' attribute on the given record node)
     * @param bOpen if null, the open state will be toggled; otherwise, true will expand the node to display its childre; false, vice versa
     * @param bBook false if null; if true, the system wants to force the VIEW to make the item a book
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Tree toggleItem(String strRecordId, boolean bOpen, boolean bBook)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("toggleItem(\"" + strRecordId + "\", \"" + bOpen + "\", \"" + bBook + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Tree> ctor = org.directwebremoting.proxy.jsx3.gui.Tree.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Tree.class.getName());
        }
    }

    /**
     * Executes any bound code for the record with id strRecordId. This method only invokes the
    EXECUTE model event for this tree under the deprecated 3.0 model event protocol.
     * @param strRecordId <code>jsxid</code> value for the record node (according to the CDF) to execute
     */
    public void executeRecord(String strRecordId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("executeRecord(").appendData(strRecordId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the text/HTML to display on-screen when the xml/xsl transformation for this object results in a null or empty result set
     * @return text/HTML
     *
    @SuppressWarnings("unchecked")
    public String getNoDataMessage(Callback callback)
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
     * Resets the XML source document stored in the server cache under the XML ID of this object to an empty CDF
    document.
     */
    public void clearXmlData()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("clearXmlData(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether this object removes its XML and XSL source documents from the cache of its server when it
    is destroyed.
     * @return <code>CLEANUPRESOURCES</code> or <code>SHARERESOURCES</code>.
     *
    @SuppressWarnings("unchecked")
    public int getShareResources(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the XML source document of this object. The XML document is determined by the following steps:

    If an XML document exists in the server cache under an ID equal to the XML ID of this object, that
    document is returned.
    If the XML string of this object is not empty, a new document is created by parsing this string.
    If the XML URL of this object is not empty, a new document is created by parsing the file at the location
    specified by the URL resolved against the server owning this object.
    Otherwise, an empty CDF document is returned.

    If a new document is created for this object (any of the steps listed above except for the first one), the
    following actions are also taken:

    If creating the document resulted in an error (XML parsing error, file not found error, etc) the offending
    document is returned immediately.
    Otherwise, setSourceXML is called on this object, passing in the created document.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getXML()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXML().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Document> ctor = org.directwebremoting.proxy.jsx3.xml.Document.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Document.class.getName());
        }
    }

    /**
     * Returns the XML source document of this object. The XML document is determined by the following steps:

    If an XML document exists in the server cache under an ID equal to the XML ID of this object, that
    document is returned.
    If the XML string of this object is not empty, a new document is created by parsing this string.
    If the XML URL of this object is not empty, a new document is created by parsing the file at the location
    specified by the URL resolved against the server owning this object.
    Otherwise, an empty CDF document is returned.

    If a new document is created for this object (any of the steps listed above except for the first one), the
    following actions are also taken:

    If creating the document resulted in an error (XML parsing error, file not found error, etc) the offending
    document is returned immediately.
    Otherwise, setSourceXML is called on this object, passing in the created document.
     */
    @SuppressWarnings("unchecked")
    public <T> T getXML(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXML().");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /*
     * Returns the XML ID of this object.
     * @return the XML ID.
     *
    @SuppressWarnings("unchecked")
    public String getXMLId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the XML string of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXMLString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the list of XML transformers of this object.
     *
    @SuppressWarnings("unchecked")
    public Object[] getXMLTransformers(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the XML URL of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXMLURL(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the XSL ID of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXSLId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns a map containing all the parameters to pass to the XSL stylesheet during transformation.
     *
    @SuppressWarnings("unchecked")
    public Object getXSLParams(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether the XML data source of this object is loaded asynchronously.
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int getXmlAsync(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether this object is bound to the XML document stored in the data cache.
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int getXmlBind(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * This method is called in two situations:

    When the datasource of this object finishes loading (success, error, or timeout), if the
      xmlAsync property of this object is true, its datasource is specified as an
       XML URL, and the first time doTransform() was called the datasource was still loading.
    Any time the value stored in the server XML cache under the key equal to the XML Id of this object
      changes, if the xmlBind property of this object is true.

    Any methods overriding this method should begin with a call to jsxsupermix().
     * @param objEvent the event published by the cache.
     */
    public void onXmlBinding(Object objEvent)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onXmlBinding(").appendData(objEvent).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes a parameter from the list of parameters to pass to the XSL stylesheet during transformation.
     * @param strName the name of the XSL parameter to remove.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable removeXSLParam(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeXSLParam(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Removes all parameters from the list of parameters to pass to the XSL stylesheet during transformation.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable removeXSLParams()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeXSLParams().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Removes the XML and XSL source documents from the server cache.
     * @param objServer the server owning the cache to modify. This is a required argument only if
    <code>this.getServer()</code> does not returns a server instance.
     */
    public void resetCacheData(org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("resetCacheData(").appendData(objServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes the XML source document stored under the XML ID of this object from the server cache.
     * @param objServer the server owning the cache to modify. This is a required argument only if
    <code>this.getServer()</code> does not returns a server instance.
     */
    public void resetXmlCacheData(org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("resetXmlCacheData(").appendData(objServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets whether this object removes its XML and XSL source documents from the cache of its server when it
    is destroyed.
     * @param intShare <code>CLEANUPRESOURCES</code> or <code>SHARERESOURCES</code>. <code>CLEANUPRESOURCES</code>
    is the default value if the property is <code>null</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setShareResources(int intShare)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setShareResources(\"" + intShare + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets the source document of this object as though objDoc were retrieved from the XML URL or XML
    string of this object. This method executes the following steps:

    The document is transformed serially by each XML transformers of this object.
    The XML document is saved in the server cache under the XML ID of this object.
    If this object is an instance of jsx3.xml.CDF and the root node is a <data> element
    and its jsxassignids attribute is equal to 1, all <record> elements without a
    jsxid attribute are assigned a unique jsxid.
    If this object is an instance of jsx3.xml.CDF, convertProperties() is called
    on this object.
     * @param objDoc 
     * @param objCache 
     * @return the document stored in the server cache as the data source of this object. If
    transformers were run, this value will not be equal to the <code>objDoc</code> parameter.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document setSourceXML(org.directwebremoting.proxy.jsx3.xml.Document objDoc, org.directwebremoting.proxy.jsx3.app.Cache objCache)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setSourceXML(\"" + objDoc + "\", \"" + objCache + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Document> ctor = org.directwebremoting.proxy.jsx3.xml.Document.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Document.class.getName());
        }
    }

    /**
     * Sets the source document of this object as though objDoc were retrieved from the XML URL or XML
    string of this object. This method executes the following steps:

    The document is transformed serially by each XML transformers of this object.
    The XML document is saved in the server cache under the XML ID of this object.
    If this object is an instance of jsx3.xml.CDF and the root node is a <data> element
    and its jsxassignids attribute is equal to 1, all <record> elements without a
    jsxid attribute are assigned a unique jsxid.
    If this object is an instance of jsx3.xml.CDF, convertProperties() is called
    on this object.
     * @param objDoc 
     * @param objCache 
     * @param returnType The expected return type
     * @return the document stored in the server cache as the data source of this object. If
    transformers were run, this value will not be equal to the <code>objDoc</code> parameter.
     */
    @SuppressWarnings("unchecked")
    public <T> T setSourceXML(org.directwebremoting.proxy.jsx3.xml.Document objDoc, org.directwebremoting.proxy.jsx3.app.Cache objCache, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setSourceXML(\"" + objDoc + "\", \"" + objCache + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Sets the XML ID of this object. This value is the key under which the XML source document of this object is
    saved in the cache of the server owning this object. The developer may specify either a unique or shared value.
    If no value is specified, a unique id is generated.
     * @param strXMLId 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXMLId(String strXMLId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLId(\"" + strXMLId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets the XML string of this object. Setting this value to the string serialization of an XML document is one
    way of specifying the source XML document of this object.
     * @param strXML <code>null</code> or a well-formed serialized XML element.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXMLString(String strXML)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLString(\"" + strXML + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets the list of XML transformers of this object. The XML source document of this object is transformed
    serially by each of these transformers before it is placed in the XML cache.

    Each transformer is either the URI of an XSLT document (which will be resolved against the
    the server of this object) or the cache id of a XSLT document in the XML cache of the server
    of this object. When any transformer is loaded from a URI it is placed in the server cache under the id
    equal to its resolved URI. Any transformer that does not correspond to a valid XSLT document will be skipped
    without throwing an error.
     * @param arrTrans 
     */
    public void setXMLTransformers(Object[] arrTrans)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setXMLTransformers(").appendData(arrTrans).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the XML URL of this object. Settings this value to the URI of an XML document is one way of specifying the
    source XML document of this object.
     * @param strXMLURL <code>null</code> or a URI that when resolved against the server owning this object
    specifies a valid XML document.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXMLURL(String strXMLURL)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLURL(\"" + strXMLURL + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Adds a name/value pair to the list of parameters to pass to the XSL stylesheet during transformation. If
    strValue is null the parameter is removed.
     * @param strName the name of the XSL parameter to add.
     * @param strValue the value of the XSL parameter to add.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXSLParam(String strName, String strValue)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXSLParam(\"" + strName + "\", \"" + strValue + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets whether the XML data source of this object is loaded asynchronously. This setting only applies to
    data sources loaded from an XML URL.
     * @param bAsync 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXmlAsync(boolean bAsync)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXmlAsync(\"" + bAsync + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /*
     * Sets whether this object is bound to the XML document stored in the data cache. If this object is bound to the
    cache, then the onXmlBinding() method of this object is called any time the document stored in
    the cache under the XML Id of this object changes.
     * @param bBind 
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int setXmlBind( bBind, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Transfers a CDF record from another object to this object. If no XML data source exists
    yet for this object, an empty one is created before adding the new record. This method always updates the
    on-screen view of both the source and destination objects.

    This method fails quietly if any of the following conditions apply:

    there is no object with id equal to strSourceId
        
    there is no record in the source object with jsxid equal to strRecordId
        

          strParentRecordId is specified and there is no record in this object with
    jsxid equal to strParentRecordId
        
    the this object already has a record with jsxid equal to the record to adopt
     * @param strSourceId <span style="text-decoration: line-through;">either the id of the source object or the</span> source object itself.
     * @param strRecordId the <code>jsxid</code> attribute of the data record in the source object to transfer.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided, the adopted record will be added as a child of this record. Otherwise, the adopted record will
    be added to the root <code>data</code> element.
     * @param bRedraw forces suppression of the insert event
     * @return the adopted record.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity adoptRecord(String strSourceId, String strRecordId, String strParentRecordId, boolean bRedraw)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("adoptRecord(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Transfers a CDF record from another object to this object. If no XML data source exists
    yet for this object, an empty one is created before adding the new record. This method always updates the
    on-screen view of both the source and destination objects.

    This method fails quietly if any of the following conditions apply:

    there is no object with id equal to strSourceId
        
    there is no record in the source object with jsxid equal to strRecordId
        

          strParentRecordId is specified and there is no record in this object with
    jsxid equal to strParentRecordId
        
    the this object already has a record with jsxid equal to the record to adopt
     * @param strSourceId <span style="text-decoration: line-through;">either the id of the source object or the</span> source object itself.
     * @param strRecordId the <code>jsxid</code> attribute of the data record in the source object to transfer.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided, the adopted record will be added as a child of this record. Otherwise, the adopted record will
    be added to the root <code>data</code> element.
     * @param bRedraw forces suppression of the insert event
     * @param returnType The expected return type
     * @return the adopted record.
     */
    @SuppressWarnings("unchecked")
    public <T> T adoptRecord(String strSourceId, String strRecordId, String strParentRecordId, boolean bRedraw, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("adoptRecord(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Equivalent to adoptRecord, except that the to-be relationship is as a previousSibling to the CDF record identified by the parameter, strSiblingRecordId

    This method fails quietly if any of the following conditions apply:

    there is no record with a jsxid equal to strSourceId
        
    there is no record in the source object with a jsxid equal to strRecordId
        

          strSiblingRecordId is specified and there is no record in this object with a
    jsxid equal to strParentRecordId
        
    this object already has a record with jsxid equal to the record to adopt
     * @param strSourceId <span style="text-decoration: line-through;">either the id of the source object or the</span> source object itself.
     * @param strRecordId the <code>jsxid</code> attribute of the data record in the source object to transfer.
     * @param strSiblingRecordId the unique <code>jsxid</code> of an existing record in front of
    which the record identified by strSourceId will be placed
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted record.
     * @return the adopted record.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity adoptRecordBefore(String strSourceId, String strRecordId, String strSiblingRecordId, boolean bRedraw)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("adoptRecordBefore(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Equivalent to adoptRecord, except that the to-be relationship is as a previousSibling to the CDF record identified by the parameter, strSiblingRecordId

    This method fails quietly if any of the following conditions apply:

    there is no record with a jsxid equal to strSourceId
        
    there is no record in the source object with a jsxid equal to strRecordId
        

          strSiblingRecordId is specified and there is no record in this object with a
    jsxid equal to strParentRecordId
        
    this object already has a record with jsxid equal to the record to adopt
     * @param strSourceId <span style="text-decoration: line-through;">either the id of the source object or the</span> source object itself.
     * @param strRecordId the <code>jsxid</code> attribute of the data record in the source object to transfer.
     * @param strSiblingRecordId the unique <code>jsxid</code> of an existing record in front of
    which the record identified by strSourceId will be placed
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted record.
     * @param returnType The expected return type
     * @return the adopted record.
     */
    @SuppressWarnings("unchecked")
    public <T> T adoptRecordBefore(String strSourceId, String strRecordId, String strSiblingRecordId, boolean bRedraw, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("adoptRecordBefore(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Converts all attributes in this CDF document that are property keys of the form {key} to
    the value of the property.
     * @param objProps the properties repository to query.
     * @param arrProps if provided, these attributes are converted rather than the default set of
    attributes.
     * @param bUnion if <code>true</code>, <code>arrProps</code> is combined with the default set of
    attributes and those attributes are converted.
     */
    public void convertProperties(java.util.Properties objProps, Object[] arrProps, boolean bUnion)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("convertProperties(").appendData(objProps).appendScript(",")

        .appendData(arrProps).appendScript(",")

        .appendData(bUnion).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes a record from the XML data source of this object.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to remove.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted record.
     * @return the record removed from the data source or <code>null</code> if no such record found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity deleteRecord(String strRecordId, boolean bRedraw)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("deleteRecord(\"" + strRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Removes a record from the XML data source of this object.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to remove.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted record.
     * @param returnType The expected return type
     * @return the record removed from the data source or <code>null</code> if no such record found.
     */
    @SuppressWarnings("unchecked")
    public <T> T deleteRecord(String strRecordId, boolean bRedraw, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("deleteRecord(\"" + strRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Removes a specific property from a record. If no such record exists in the XML document, this method fails quietly.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to modify.
     * @param strPropName the name of the property to remove from the record.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted property.
     */
    public void deleteRecordProperty(String strRecordId, String strPropName, boolean bRedraw)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("deleteRecordProperty(").appendData(strRecordId).appendScript(",")

        .appendData(strPropName).appendScript(",")

        .appendData(bRedraw).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns an object containing the attributes of a particular CDF record as property/value pairs. The object returned by this
    method is a copy of the underlying data. Therefore, updates to this object will not affect the underlying data.

    The following two lines of code evaluate to the same value:

    objCDF.getRecord(strId).propName;
    objCDF.getRecordNode(strId).getAttribute("propName");
     * @param strRecordId the <code>jsxid</code> attribute of the data record to return.
     * @return the object representation of a CDF node or <code>null</code> if no such record found.
     *
    @SuppressWarnings("unchecked")
    public Object getRecord(String strRecordId, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns a record from the XML data source of this object. This returned value is a handle to the record and
    not a clone. Therefore, any updates made to the returned value with update the XML document of this object.
    To reflect such changes in the on-screen view of this object, call
    redrawRecord(strRecordId, jsx3.xml.CDF.UPDATE); on this object.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to return.
     * @return the record node or <code>null</code> if none exists with a <code>jsxid</code>
    attribute equal to <code>strRecordId</code>.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getRecordNode(String strRecordId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRecordNode(\"" + strRecordId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Returns a record from the XML data source of this object. This returned value is a handle to the record and
    not a clone. Therefore, any updates made to the returned value with update the XML document of this object.
    To reflect such changes in the on-screen view of this object, call
    redrawRecord(strRecordId, jsx3.xml.CDF.UPDATE); on this object.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to return.
     * @param returnType The expected return type
     * @return the record node or <code>null</code> if none exists with a <code>jsxid</code>
    attribute equal to <code>strRecordId</code>.
     */
    @SuppressWarnings("unchecked")
    public <T> T getRecordNode(String strRecordId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRecordNode(\"" + strRecordId + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Inserts a new record into the XML data source of this object. If no XML data source exists
    yet for this object, an empty one is created before adding the new record.
    If a record already exists with an id equal to the jsxid property of objRecord,
    the operation is treated as an update, meaning the existing record is completely removed and a new record with
    the given jsxid is inserted.
     * @param objRecord a JavaScript object containing property/value pairs that define the
    attributes of the XML entity to create. Note that most classes that implement this interface require that all
    records have an attribute named <code>jsxid</code> that is unique across all records in the XML document.
    All property values will be treated as strings. Additionally, the following 3 characters are escaped:
    <code>" &gt; &lt;</code>.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided and a record exists with a matching <code>jsxid</code> attribute, the new record will be added as a child of
    this record. Otherwise, the new record will be added to the root <code>data</code> element. However, if a
    record already exists with a <code>jsxid</code> attribute equal to the <code>jsxid</code> property of
    <code>objRecord</code>, this parameter will be ignored. In this case <code>adoptRecord()</code> must be called
    to change the parent of the record.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     * @return the newly created or updated entity.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity insertRecord(Object objRecord, String strParentRecordId, boolean bRedraw)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecord(\"" + objRecord + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Inserts a new record into the XML data source of this object. If no XML data source exists
    yet for this object, an empty one is created before adding the new record.
    If a record already exists with an id equal to the jsxid property of objRecord,
    the operation is treated as an update, meaning the existing record is completely removed and a new record with
    the given jsxid is inserted.
     * @param objRecord a JavaScript object containing property/value pairs that define the
    attributes of the XML entity to create. Note that most classes that implement this interface require that all
    records have an attribute named <code>jsxid</code> that is unique across all records in the XML document.
    All property values will be treated as strings. Additionally, the following 3 characters are escaped:
    <code>" &gt; &lt;</code>.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided and a record exists with a matching <code>jsxid</code> attribute, the new record will be added as a child of
    this record. Otherwise, the new record will be added to the root <code>data</code> element. However, if a
    record already exists with a <code>jsxid</code> attribute equal to the <code>jsxid</code> property of
    <code>objRecord</code>, this parameter will be ignored. In this case <code>adoptRecord()</code> must be called
    to change the parent of the record.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     * @param returnType The expected return type
     * @return the newly created or updated entity.
     */
    @SuppressWarnings("unchecked")
    public <T> T insertRecord(Object objRecord, String strParentRecordId, boolean bRedraw, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecord(\"" + objRecord + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Creates a new CDF record and inserts it into the CDF data source of this object, before the record identified by strSiblingRecordId.

    This method fails quietly if any of the following conditions apply:

    there is no existing record with a jsxid equal to strSiblingRecordId
        
    there is an existing record with jsxid equal to objRecord.jsxid
     * @param objRecord a JavaScript object containing property/value pairs that define the
    attributes of the XML entity to create. Note that most classes that implement this interface require that all
    records have an attribute named <code>jsxid</code> that is unique across all records in the XML document.
    All property values will be treated as strings. Additionally, the following 3 characters are escaped:
    <code>" &gt; &lt;</code>.
     * @param strSiblingRecordId the unique <code>jsxid</code> of an existing record before which the new record will be inserted.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     * @return the newly created entity.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity insertRecordBefore(Object objRecord, String strSiblingRecordId, boolean bRedraw)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecordBefore(\"" + objRecord + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Creates a new CDF record and inserts it into the CDF data source of this object, before the record identified by strSiblingRecordId.

    This method fails quietly if any of the following conditions apply:

    there is no existing record with a jsxid equal to strSiblingRecordId
        
    there is an existing record with jsxid equal to objRecord.jsxid
     * @param objRecord a JavaScript object containing property/value pairs that define the
    attributes of the XML entity to create. Note that most classes that implement this interface require that all
    records have an attribute named <code>jsxid</code> that is unique across all records in the XML document.
    All property values will be treated as strings. Additionally, the following 3 characters are escaped:
    <code>" &gt; &lt;</code>.
     * @param strSiblingRecordId the unique <code>jsxid</code> of an existing record before which the new record will be inserted.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     * @param returnType The expected return type
     * @return the newly created entity.
     */
    @SuppressWarnings("unchecked")
    public <T> T insertRecordBefore(Object objRecord, String strSiblingRecordId, boolean bRedraw, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecordBefore(\"" + objRecord + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Inserts a new record into the XML data source of this object. This method is the same as
    insertRecord() except that its first parameter is of type jsx3.xml.Entity rather than
    Object.
     * @param objRecordNode an XML element of name <code>record</code>. Note that most classes that
    implement this interface require that all records have an attribute named <code>jsxid</code> that is unique
    across all records in the XML document.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided and a record exists with a matching <code>jsxid</code> attribute, the new record will be added as a child of
    this record. Otherwise, the new record will be added to the root <code>data</code> element.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     */
    public void insertRecordNode(org.directwebremoting.proxy.jsx3.xml.Entity objRecordNode, String strParentRecordId, boolean bRedraw)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("insertRecordNode(").appendData(objRecordNode).appendScript(",")

        .appendData(strParentRecordId).appendScript(",")

        .appendData(bRedraw).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Inserts a new property into an existing record with jsxid equal to strRecordId.
    If the property already exists, the existing property value will be updated. If no such record exists
    in the XML document, this method fails quietly.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to modify.
     * @param strPropName the name of the property to insert into the record.
     * @param strPropValue the value of the property to insert.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the inserted property.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.CDF insertRecordProperty(String strRecordId, String strPropName, String strPropValue, boolean bRedraw)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecordProperty(\"" + strRecordId + "\", \"" + strPropName + "\", \"" + strPropValue + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.CDF> ctor = org.directwebremoting.proxy.jsx3.xml.CDF.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.CDF.class.getName());
        }
    }

}
