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
public class Dialog extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Dialog(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param vntWidth width in pixels
     * @param vntHeight height in pixels
     * @param strTitle if != null,  will be set as the text property on the child captionbar
     */
    public Dialog(String strName, int vntWidth, int vntHeight, String strTitle)
    {
        super((ProxyHelper) null);
    }

    /**
     * Enum value for the windowState property of instances of this class indicating a minimized dialog.
     */
    public static final int MINIMIZED = 0;

    /**
     * Enum value for the windowState property of instances of this class indicating a maximized dialog.
     */
    public static final int MAXIMIZED = 1;

    /**
     * #e8e8f5 (default)
     */
    public static final String DEFAULTBACKGROUNDCOLOR = "#e8e8f5";

    /**
     * Enum value for the resizable property of instances of this class indicating a non-resizable dialog.
     */
    public static final int FIXED = 0;

    /**
     * Enum value for the resizable property of instances of this class indicating a resizable dialog.
     */
    public static final int RESIZABLE = 1;

    /**
     * Enum value for the modal property of instances of this class indicating a modal dialog.
     */
    public static final int MODAL = 1;

    /**
     * Enum value for the modal property of instances of this class indicating a non-modal dialog.
     */
    public static final int NONMODAL = 0;

    /**
     * typically called by minimize/windowshade jsx3.gui.ToolbarButton in the dialog box's caption bar; toggles the window's state between full-size and window-shaded (where only the dialog's caption bar is visible); or fully minimized to the application task bar if one exists
     * @param STATE if != null, window state is set to fullsize (jsx3.gui.Dialog.MAXIMIZED) and window-shade (jsx3.gui.Dialog.MINIMIZED); if no value is passed, the state is toggled
     */
    public void doToggleState(int STATE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("doToggleState(").appendData(STATE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Applies focus to the caption bar if the dialog has one; otherwise the dialog is given focus.
     * @param bTimeout 
     */
    public void focus(boolean bTimeout)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("focus(").appendData(bTimeout).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether this dialog instance is the front-most dialog among all open dialogs
     *
    @SuppressWarnings("unchecked")
    public boolean isFront(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns object handle to the jsx3.gui.ToolbarButton instance that resides in the application (this.getServer()) task bar and is associated with this dialog instance; returns null if none found
     * @param objTaskBar specify the task bar to search in
     * @return or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.ToolbarButton getTaskButton(org.directwebremoting.proxy.jsx3.gui.WindowBar objTaskBar)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getTaskButton(\"" + objTaskBar + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.ToolbarButton> ctor = org.directwebremoting.proxy.jsx3.gui.ToolbarButton.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.ToolbarButton.class.getName());
        }
    }

    /**
     * Ensures that HTML content is added to the correct VIEW element given the unique complexities of a the jsx3.gui.Dialog class
     * @param objJSX JSX GUI object that is already part of the dialog's MODEL, but not yet a part of its VIEW
     * @param bGroup 
     */
    public void paintChild(org.directwebremoting.proxy.jsx3.app.Model objJSX, boolean bGroup)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("paintChild(").appendData(objJSX).appendScript(",")

        .appendData(bGroup).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * removes the dialog box from the JSX DOM and removes its on-screen VIEW from the browser DOM
     */
    public void doClose()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("doClose(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns state of the window (full-size / window-shaded). Default: jsx3.gui.Dialog.MAXIMIZED
     * @return one of: jsx3.gui.Dialog.MAXIMIZED or jsx3.gui.Dialog.MINIMIZED
     *
    @SuppressWarnings("unchecked")
    public int getWindowState(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets state of the window (full-size / window-shaded); returns ref to self for method chaining
     * @param STATE one of: jsx3.gui.Dialog.MAXIMIZED or jsx3.gui.Dialog.MINIMIZED
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Dialog setWindowState(int STATE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setWindowState(").appendData(STATE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns numeric multiplier for the dialog's z-index. If a dialog box needs to always be on top of other dialog box instances, this multiplier can be increased to assure the appropriate zIndex.  For example, a value of 5 would mean that this dialog box would be stacked on top of all dialog boxes with a alwaysOnTop multiplier less than 5. Default: 1
     * @return integer
     *
    @SuppressWarnings("unchecked")
    public int getZMultiplier(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets numeric multiplier for the dialog's z-index. If a dialog box needs to always be on top of other dialog box instances, this multiplier can be increased to assure the appropriate zIndex.  For example, a value of 5 would mean that this dialog box would be stacked on top of all dialog boxes with a alwaysOnTop multiplier less than 5
     * @param intMultiplier integer; zero is allowed, but is not recommended; passing null is equivalent to passing 1
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Dialog setZMultiplier(int intMultiplier)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setZMultiplier(").appendData(intMultiplier).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns whether a dialog displays as modal or not. Modal dialogs mask the rest of the container with an semi-transparent mask that blocks mouse interaction. Modal dialogs do not show up in the task bar. Default: jsx3.gui.Dialog.NONMODAL
     * @return one of: jsx3.gui.Dialog.NONMODAL or jsx3.gui.Dialog.MODAL
     *
    @SuppressWarnings("unchecked")
    public int getModal(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether a dialog displays as modal or not. Modal dialogs mask the rest of the container with an semi-transparent mask that blocks mouse interaction. Modal dialogs do not show up in the task bar.
     * @param intModal one of: jsx3.gui.Dialog.NONMODAL or jsx3.gui.Dialog.MODAL
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Dialog setModal(int intModal)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setModal(").appendData(intModal).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the absolute positioning of the object's on-screen view (specifically, the dialog box, not its modal container if there is one) in relation to JSXROOT (whose left/top is 0/0).
           Returns information as a JavaScript object with properties, L, T, W, H
           of @objRoot is null, the on-screen view for JSXROOT is used as the object reference
     * @param objRoot object reference to IE DOM object (i.e., div, span, etc); if null is passed, the first div child of JSXROOT's on-screen representation will be used
     * @return JScript object with properties: L, T, W, H (corresponding to left, top width, height)
     *
    @SuppressWarnings("unchecked")
    public Object getAbsolutePosition(String objRoot, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Toggles the state of the dialog between 'maximized' and its 'initial state'
     * @param objTBB toolbarbutton instance on the dialog to toggle the image/tip text for
     */
    public void doMaximize(org.directwebremoting.proxy.jsx3.gui.ToolbarButton objTBB)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("doMaximize(").appendData(objTBB).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether the dialog can be resized or not. Default: jsx3.gui.Dialog.RESIZABLE
     * @return one of: jsx3.gui.Dialog.RESIZABLE jsx3.gui.Dialog.FIXED
     *
    @SuppressWarnings("unchecked")
    public int getResize(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether the dialog box's on-screen view can be resized; returns reference to self to facilitate method chaining
     * @param RESIZE one of: jsx3.gui.Dialog.RESIZABLE jsx3.gui.Dialog.FIXED
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Dialog setResize(int RESIZE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setResize(").appendData(RESIZE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets resize parameters such as min width, max width, etc for the dialog; returns reference to self to facilitate method chaining
     * @param RESIZE one of: jsx3.gui.Dialog.RESIZABLE jsx3.gui.Dialog.FIXED
     * @param intMinX min width for the dialog when being resized
     * @param intMinY min height for the dialog when being resized
     * @param intMaxX max width for the dialog when being resized
     * @param intMaxY max heightfor the dialog when being resized
     * @param strAfterResizeFunction 
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Dialog setResizeParameters(int RESIZE, int intMinX, int intMinY, int intMaxX, int intMaxY, String strAfterResizeFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setResizeParameters(").appendData(RESIZE).appendScript(",")

        .appendData(intMinX).appendScript(",")

        .appendData(intMinY).appendScript(",")

        .appendData(intMaxX).appendScript(",")

        .appendData(intMaxY).appendScript(",")

        .appendData(strAfterResizeFunction).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns an object handle to the jsx3.gui.WindowBar instance associated with the jsx3.gui.Dialog instance
     * @return jsx3.gui.WindowBar instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.WindowBar getCaptionBar()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getCaptionBar().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.WindowBar> ctor = org.directwebremoting.proxy.jsx3.gui.WindowBar.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.WindowBar.class.getName());
        }
    }

    /**
     * Removes the box model abstraction for a given object and its descendants. This effectively resets the box profiler, so dimensions can be recalculated as if the object was just broought into the visual DOM.
     */
    public void recalcBox()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("recalcBox(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the HTML, used for this object's on-screen VIEW
     *
    @SuppressWarnings("unchecked")
    public String paint(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Implements necessary method for the Alerts interface.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block getAlertsParent()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAlertsParent().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    /**
     * Implements necessary method for the Alerts interface.
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAlertsParent(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAlertsParent().");
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
     * Modifies the top and left properties of this dialog in order to fit it within its parent container.
    This method ensures that at least a certain amount of the dialog shows on the East, South, and West edges
    of the server and that the entire dialog shows on the North edge.

    This method is called by default after the user moves a dialog with the mouse. If an AFTER_MOVE
    model event is specified, then this method is not called automatically and must be called explicitly by the
    model event.
     * @param arg if <code>true</code>, this dialog will be placed entirely within its container,
    with a certain amount of padding, and this dialog will be resized if necessary. If this argument is an array,
    it is taken as the N-E-S-W minimum pixels to show after constraining the position of the dialog. A
    <code>null</code> value for any dimension means that the entire dimension should be shown. A negative value
    means the number of pixels less than the size of the dialog in that dimension.
     */
    public void constrainPosition(boolean arg)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("constrainPosition(").appendData(arg).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Modifies the top and left properties of this dialog in order to fit it within its parent container.
    This method ensures that at least a certain amount of the dialog shows on the East, South, and West edges
    of the server and that the entire dialog shows on the North edge.

    This method is called by default after the user moves a dialog with the mouse. If an AFTER_MOVE
    model event is specified, then this method is not called automatically and must be called explicitly by the
    model event.
     * @param arg if <code>true</code>, this dialog will be placed entirely within its container,
    with a certain amount of padding, and this dialog will be resized if necessary. If this argument is an array,
    it is taken as the N-E-S-W minimum pixels to show after constraining the position of the dialog. A
    <code>null</code> value for any dimension means that the entire dimension should be shown. A negative value
    means the number of pixels less than the size of the dialog in that dimension.
     */
    public void constrainPosition(Object[] arg)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("constrainPosition(").appendData(arg).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * alerts the user's attention to the dialog box by making its caption bar 'flash' on-screen (as it typical with a windows modal dialog)
     */
    public void beep()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("beep(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * show an alert dialog
     * @param strTitle the title of the dialog
     * @param strMessage the message to display
     * @param fctOnOk callback function on pressing ok button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param strOk the text of the ok button, can be false to remove button from display
     * @param objParams argument to configureAlert()
     */
    public void alert(String strTitle, String strMessage, org.directwebremoting.proxy.CodeBlock fctOnOk, String strOk, String objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("alert(").appendData(strTitle).appendScript(",")

        .appendData(strMessage).appendScript(",")

        .appendData(fctOnOk).appendScript(",")

        .appendData(strOk).appendScript(",")

        .appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * configure the dialog
     * @param objDialog the dialog
     * @param objParams may include fields 'width', 'height', 'noTitle', and 'nonModal'.
     */
    public void configureAlert(String objDialog, Object objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("configureAlert(").appendData(objDialog).appendScript(",")

        .appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * show a confirm alert
     * @param strTitle the title of the dialog
     * @param strMessage the message to display
     * @param fctOnOk callback function on pressing ok button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param fctOnCancel callback function on pressing cancel button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param strOk the text of the ok button
     * @param strCancel the text of the cancel button
     * @param intBtnDefault the bold button that receives return key, 1:ok, 2:cancel, 3:no
     * @param fctOnNo callback function on pressing no button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param strNo the text of the no button
     * @param objParams argument to configureAlert()
     */
    public void confirm(String strTitle, String strMessage, org.directwebremoting.proxy.CodeBlock fctOnOk, org.directwebremoting.proxy.CodeBlock fctOnCancel, String strOk, String strCancel, int intBtnDefault, org.directwebremoting.proxy.CodeBlock fctOnNo,
            String strNo, String objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("confirm(").appendData(strTitle).appendScript(",")

        .appendData(strMessage).appendScript(",")

        .appendData(fctOnOk).appendScript(",")

        .appendData(fctOnCancel).appendScript(",")

        .appendData(strOk).appendScript(",")

        .appendData(strCancel).appendScript(",")

        .appendData(intBtnDefault).appendScript(",")

        .appendData(fctOnNo).appendScript(",")

        .appendData(strNo).appendScript(",")

        .appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * show a text box input prompt
     * @param strTitle the title of the dialog
     * @param strMessage the message to display
     * @param fctOnOk callback function on pressing ok button, receives the dialog as an argument, and the value of the text input as a second argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param fctOnCancel callback function on pressing cancel button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param strOk the text of the ok button
     * @param strCancel the text of the cancel button
     * @param objParams argument to configureAlert()
     */
    public void prompt(String strTitle, String strMessage, org.directwebremoting.proxy.CodeBlock fctOnOk, org.directwebremoting.proxy.CodeBlock fctOnCancel, String strOk, String strCancel, String objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("prompt(").appendData(strTitle).appendScript(",")

        .appendData(strMessage).appendScript(",")

        .appendData(fctOnOk).appendScript(",")

        .appendData(fctOnCancel).appendScript(",")

        .appendData(strOk).appendScript(",")

        .appendData(strCancel).appendScript(",")

        .appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Publishes a model event. This method both evaluates any registered event script for the given event type
    and publishes the event through the EventDispatcher interface. This method ensures that any
    registered event script is executed in isolation to prevent most side effects.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @param objContext JavaScript object array with name/value pairs that provide a local
    variable stack for the execution of the event script. This argument is also passed as the <code>context</code>
    property of the event object that is published through the <code>EventDispatcher</code> interface.
     * @return the result of evaluating the event script or <code>null</code> if not event script is registered
     *
    @SuppressWarnings("unchecked")
    public Object doEvent(String strType, Object objContext, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object supports programmatic drag, meanining it will allow any contained item to be
    dragged and dropped on another container supporting drop.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanDrag(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether this object can be the target of a drop event.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanDrop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object can be moved around the screen (this is not the same as drag/drop).
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanMove(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object can be spyglassed.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanSpy(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the event script registered for the given event type. This script could have been set by the
    setEvent() method or during component deserialization.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return the JavaScript event script
     *
    @SuppressWarnings("unchecked")
    public String getEvent(String strType, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the associative array containing all the registered event script of this object. This method returns
    the instance field itself and not a copy.
     * @return an associative array mapping event type to event script
     *
    @SuppressWarnings("unchecked")
    public Object getEvents(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the name of the jsx3.gui.Menu instance to display (as a context menu) when a user
    clicks on this object with the right button.
     *
    @SuppressWarnings("unchecked")
    public String getMenu(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns true if there is a event script registered for the given event type.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return the JavaScript event script
     *
    @SuppressWarnings("unchecked")
    public String hasEvent(String strType, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Registers a hot key with this JSX model node. All keydown events that bubble up to this object
    will be checked against the hot key. If an event matches, the callback function will execute and the event
    bubble will be canceled.

    If the four parameters vntKey, bShift, bControl, and bAlt
    match a previously registered hot key, the previous hot key is clobbered by the new one. Only one hot key callback
    function (the most recently registered) will be executed by a single keydown event.
     * @param vntCallback either a function, or the name of a method bound to this object.
    When a keydown event bubbles up to this object that matches the hot key created by this method, this function
    is called on this object. If this function returns <code>false</code> then this hot key will not cancel the
    key event. This parameter can also be an instance of <code>HotKey</code>, in which case all
    other parameters are ignored.
     * @param vntKey if this parameter is a String, the hot key matches that key (the keycode to match is
    determined by <code>HotKey.keyDownCharToCode()</code>). If it is an integer, the hot key will match that
    keycode value.
     * @param bShift if not <code>null</code> the shift key state of the keydown event must match this value
    to invoke the hot key.
     * @param bControl if not <code>null</code> the control key state of the keydown event must match this value
    to invoke the hot key.
     * @param bAlt if not <code>null</code> the alt key state of the keydown event must match this value
    to invoke the hot key.
     * @return the registered hot key.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.HotKey registerHotKey(String vntCallback, int vntKey, boolean bShift, boolean bControl, boolean bAlt)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("registerHotKey(\"" + vntCallback + "\", \"" + vntKey + "\", \"" + bShift + "\", \"" + bControl + "\", \"" + bAlt + "\").");
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
     * Removes an event script registered for the given model event type.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvent(String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeEvent(\"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Removes all events scripts registered with this object.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvents()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeEvents().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object supports programmatic drag, meanining it will allow any contained item to be dragged/dropped.
    Implementing classes can decide whether to consult this value or ignore it.
     * @param bDrag <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrag(int bDrag)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanDrag(\"" + bDrag + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether this object can be the target of a drop event. Implementing classes can decide whether to consult
    this value or ignore it.
     * @param bDrop <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrop(int bDrop)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanDrop(\"" + bDrop + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object can be moved around the screen (this is not the same as drag/drop). Implementing classes
    can decide whether to consult this value or ignore it.
     * @param bMovable <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanMove(int bMovable)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanMove(\"" + bMovable + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object can be spyglassed. Implementing classes can decide whether to consult
    this value or ignore it.
     * @param bSpy <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanSpy(int bSpy)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanSpy(\"" + bSpy + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Programmatically sets an event of this instance. Sets the script that will execute when this object publishes
    a model event. The script value will be saved in the serialization file of a component. Not all classes that
    implement this interface will publish events of every type. Consult the documentation of a class for a
    description of the events it publishes.

    For programmatic registering of event handlers when persistence in a serialization file is not required,
    consider using jsx3.util.EventDispatcher.subscribe() instead of this method. Whenever a model
    event is published, it is published using the EventDispatcher interface as well as by executing
    any registered event script.
     * @param strScript the actual JavaScript code that will execute when the given event is published.
    For example: <code>obj.setEvent("alert('hello.');", jsx3.gui.Interactive.EXECUTE);</code>
     * @param strType the event type. Must be one of the model event types defined as static fields in this class
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setEvent(String strScript, String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setEvent(\"" + strScript + "\", \"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets the name of the jsx3.gui.Menu instance to display when a user
    clicks on this object with the right button. The name is a pointer by-name to a JSX object in the same server.
     * @param strMenu name or id (jsxname or jsxid) of the context menu
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setMenu(String strMenu)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setMenu(\"" + strMenu + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets the CSS definition to apply to an HTML element when a spyglass is shown for that element
     * @param strCSS valid CSS. For example, text-decoration:underline;color:red;
     */
    public void setSpyStyles(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSpyStyles(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * called by 'window.setTimeout()' to display the spyglass hover for a given object;
     * @param strHTML HTML/text to display in the spyglass; as the spyglass does not define a height/width, this content will
         have improved layout if it specifies a preferred width in its in-line-style or referenced-css rule.
     * @param intLeft use an integer to specify an on-screen location; otherwise, use a <code>jsx3.gui.Event</code> instance to have the system automatically calculate the x/y position.
     * @param intTop use an integer if <code>intLeft</code> also uses an integer. Otherwise, use null.
     */
    public void showSpy(String strHTML, int intLeft, int intTop)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("showSpy(").appendData(strHTML).appendScript(",")

        .appendData(intLeft).appendScript(",")

        .appendData(intTop).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Publishes an event to all subscribed objects.
     * @param objEvent the event, should have at least a field 'subject' that is the event id, another common field is 'target' (target will default to this instance)
     * @return the number of listeners to which the event was broadcast
     *
    @SuppressWarnings("unchecked")
    public int publish(Object objEvent, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Subscribes an object or function to a type of event published by this object.

    As of version 3.4 a string value for objHandler is deprecated.
     * @param strEventId the event type(s).
     * @param objHandler if an object, the instance to notify of events (objFunction is required); if a string, the JSX id of the instance to notify of events (objFunction is required), must exist in the same Server; if a function, the function to call to notify of events (objFunction ignored)
     * @param objFunction if objHandler is a string or object then the function to call on that instance. either a function or a string that is the name of a method of the instance
     */
    public void subscribe(String strEventId, Object objHandler, org.directwebremoting.proxy.CodeBlock objFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("subscribe(").appendData(strEventId).appendScript(",")

        .appendData(objHandler).appendScript(",")

        .appendData(objFunction).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Unsubscribe an object or function from an event published by this object.

    As of version 3.4 a string value for objHandler is deprecated.
     * @param strEventId the event type(s).
     * @param objHandler the value of objHandler passed to subscribe
     */
    public void unsubscribe(String strEventId, Object objHandler)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("unsubscribe(").appendData(strEventId).appendScript(",")

        .appendData(objHandler).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Unsubscribes all subscribed objects to a type of event published by this object.
     * @param strEventId the event type
     */
    public void unsubscribeAll(String strEventId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("unsubscribeAll(").appendData(strEventId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
