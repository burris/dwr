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
public class Painted extends org.directwebremoting.proxy.jsx3.app.Model
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Painted(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     */
    public Painted(String strName)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the absolute positioning of the object's on-screen view in relation to JSXROOT (whose left/top is 0/0).
           Returns information as a JavaScript object with properties, L, T, W, H
           of @objRoot is null, the on-screen view for JSXROOT is used as the object reference
     * @param objRoot object reference to IE DOM object (i.e., div, span, etc); if null is passed, the first div child of JSXROOT's on-screen representation will be used
     * @param objGUI object reference to item to get absolute position for&#8212;as opposed to this instance (useful for determining placement of html objects contained by JSX objects, but not part of the actual JSX DOM)
     * @return JScript object with properties: L, T, W, H (corresponding to left, top width, height)
     *
    @SuppressWarnings("unchecked")
    public Object getAbsolutePosition(String objRoot, String objGUI, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * assigns a dynamic property to one of this object's properties
           returns reference to self to facilitate method chaining;
     * @param strName property on this GUI object that will now use a dynamic property (e.g., 'jsxleft','jsxtop','jsxheight',etc.);
     * @param strValue name of a dynamic style, whose value will be used
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Painted setDynamicProperty(String strName, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDynamicProperty(").appendData(strName).appendScript(",")

        .appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the value of the dynamic property @strPropName; if not found, returns null
     * @param strName property on this GUI object that will now use a dynamic property (e.g., 'jsxleft','jsxtop','jsxheight',etc.);
     * @return value of the property
     *
    @SuppressWarnings("unchecked")
    public String getDynamicProperty(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets a property on the object that when the object is rendered on-screen, the HTML tag will be assigned the given name/value pair as a tag attribute
     * @param strName the name of the property/attribute
     * @param strValue the value for the property; may not contain double-quotes; escape via jsx3.util.strEscapeHTML if necessary or use combinations of single-quotes and escaped single-quotes
     * @return this object (this)
     */
    public org.directwebremoting.proxy.jsx3.gui.Painted setAttribute(String strName, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAttribute(").appendData(strName).appendScript(",")

        .appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns value for the custom attribute with the given name; returns null if no attribute found
     * @param strName the name of the property/attribute
     *
    @SuppressWarnings("unchecked")
    public String getAttribute(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns handle to the JavaScript Object Array containing all events for the JSX GUI object;
           NOTE: This object will contain zero or more JavaScript Objects with the following Properties: script, type, system
     *
    @SuppressWarnings("unchecked")
    public Object getAttributes(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * removes the specific custom property bound to this object; returns a reference to self (this) to facilitate method chaining
     * @param strName the name of the custom property to remove
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Painted removeAttribute(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttribute(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Painted> ctor = org.directwebremoting.proxy.jsx3.gui.Painted.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Painted.class.getName());
        }
    }

    /**
     * removes the specific custom property bound to this object; returns a reference to self (this) to facilitate method chaining
     * @param strName the name of the custom property to remove
     * @param returnType The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T removeAttribute(String strName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttribute(\"" + strName + "\").");
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
     * removes all events bound to this object; NOTE: The object must still be painted/repainted for its corresponding on-screen view to be likewise updated; returns a reference to self (this) to facilitate method chaining
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Painted removeAttributes()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttributes().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Painted> ctor = org.directwebremoting.proxy.jsx3.gui.Painted.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Painted.class.getName());
        }
    }

    /**
     * removes all events bound to this object; NOTE: The object must still be painted/repainted for its corresponding on-screen view to be likewise updated; returns a reference to self (this) to facilitate method chaining
     * @param returnType The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T removeAttributes(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttributes().");
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
     * gives focus to the on-screen VIEW for the element; returns a handle to the html/dhtml element as exposed by the native browser
     *
    @SuppressWarnings("unchecked")
    public String focus(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns handle/reference to the JSX GUI Object's on-screen counterpart—basically a handle to a DHTML object such as a DIV, SPAN, etc
     * @param objGUI either the HTML document containing the rendered object or an HTML element in that document.
    This argument is optional but improves the efficiency of this method if provided.
     * @return IE DHTML object
     *
    @SuppressWarnings("unchecked")
    public String getRendered(Object objGUI, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns handle/reference to the JSX GUI Object's on-screen counterpart—basically a handle to a DHTML object such as a DIV, SPAN, etc
     * @param objGUI either the HTML document containing the rendered object or an HTML element in that document.
    This argument is optional but improves the efficiency of this method if provided.
     * @return IE DHTML object
     *
    @SuppressWarnings("unchecked")
    public String getRendered(org.directwebremoting.proxy.jsx3.gui.Event objGUI, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Updates the view of this object by calling paint() and replacing the current view with the
    returned HTML. This method has no effect if this object is not currently displayed.
     * @return the result of calling <code>paint()</code> or <code>null</code> if this object is not displayed.
     *
    @SuppressWarnings("unchecked")
    public String repaint(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the DHTML, used for this object's on-screen VIEW
     * @return DHTML
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
     * A hook that subclasses of Painted may override in order to perform additional manipulation of the HTML DOM
    created by the paint method. The order of steps follows. All steps occur in a single browser thread so that
    the screen does not update between steps 2 and 3.

    The paint() method of this object is called.
    The result of the paint() method is inserted into the HTML DOM.
    The onAfterPaint() method of this object is called, passing in the newly inserted root HTML element.
     * @param objGUI the rendered HTML element representing this object.
     */
    public void onAfterPaint(String objGUI)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onAfterPaint(").appendData(objGUI).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Paints a child of this object without repainting this entire object. The child is inserted into the view of
    this object as the last child object, regardless of its actual position relative to other children. This method
    has no effect if this object is not currently painted.
     * @param objChild the child object to paint.
     * @param bGroup <code>true</code> if this method is being called iteratively over a collection of
    children. This parameter will only be <code>false</code> on the final call in the iteration.
     * @param objGUI 
     * @param bCascadeOnly 
     */
    public void paintChild(org.directwebremoting.proxy.jsx3.gui.Painted objChild, boolean bGroup, String objGUI, boolean bCascadeOnly)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("paintChild(").appendData(objChild).appendScript(",")

        .appendData(bGroup).appendScript(",")

        .appendData(objGUI).appendScript(",")

        .appendData(bCascadeOnly).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Iterates through children and returns concatenation of paint() method for all children.
     * @param c the children to paint. If not provided <code>this.getChildren()</code> is used.
     * @return DHTML
     *
    @SuppressWarnings("unchecked")
    public String paintChildren(Object[] c, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Removes the box model abstraction for a given object and its descendants. This effectively resets the box profiler, so dimensions can be recalculated as if the object was just broought into the visual DOM.
     * @param properties Will designate by name, those properties that should be updated on the object's VIEW (without requiring the MODEL to repaint), including one or more of the following: padding, margin, border
     */
    public void recalcBox(Object[] properties)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("recalcBox(").appendData(properties).appendScript(");");
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
    @Override
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
    @Override
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
    @Override
    public void unsubscribeAll(String strEventId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("unsubscribeAll(").appendData(strEventId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
