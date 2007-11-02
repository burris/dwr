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
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Block extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Block(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * Returns the vector canvas on which this control paints itself. If no canvas has already been created, then
    createVector() is called to create it.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Tag getCanvas()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getCanvas().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Tag> ctor = org.directwebremoting.proxy.jsx3.vector.Tag.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Tag.class.getName());
        }
    }

    /**
     * Returns the vector canvas on which this control paints itself. If no canvas has already been created, then
    createVector() is called to create it.
     */
    @SuppressWarnings("unchecked")
    public <T> T getCanvas(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getCanvas().");
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
     * Creates the vector tag tree that will render this GUI control. Subclasses of this class should override this
    method to specify the manner in which they render.

    The basic template for a method overriding this method is:

    CustomVector.prototype.createVector = function() {
    var objCanvas = this.jsxsuper();
    // modify objCanvas, add children, etc.
    return objCanvas;
    };

    This method should do the work of creating and updating the vector tree to the state when it is ready to be
    rendered on screen, but without calling updateVector() directly.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Tag createVector()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createVector().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Tag> ctor = org.directwebremoting.proxy.jsx3.vector.Tag.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Tag.class.getName());
        }
    }

    /**
     * Creates the vector tag tree that will render this GUI control. Subclasses of this class should override this
    method to specify the manner in which they render.

    The basic template for a method overriding this method is:

    CustomVector.prototype.createVector = function() {
    var objCanvas = this.jsxsuper();
    // modify objCanvas, add children, etc.
    return objCanvas;
    };

    This method should do the work of creating and updating the vector tree to the state when it is ready to be
    rendered on screen, but without calling updateVector() directly.
     */
    @SuppressWarnings("unchecked")
    public <T> T createVector(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createVector().");
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
     * Updates the pre-existing vector tree of this control on, for example, a resize or repaint event. Methods
    overriding this method should return true if the update is successful or false to
    force the vector tree to be completely recreated with createVector().

    The basic template for a method overriding this method is:

    CustomVector.prototype.updateVector = function(objVector) {
    this.jsxsuper(objVector);
    // modify objCanvas, modify children, etc.
    return true;
    };
     * @param objVector the root of the vector render tree.
     * @return <code>true</code> if the tree could be updated inline or <code>false</code> if it must be
    recreated by calling <code>createVector()</code>.
     *
    @SuppressWarnings("unchecked")
    public boolean updateVector(org.directwebremoting.proxy.jsx3.vector.Tag objVector, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Instantiates and returns a new instance of jsx3.vector.Canvas. The implementation of
    createVector() in this class calls this method to create the base vector tag. This method may be
    overridden to provide a base tag of another type that Canvas.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Tag createCanvas()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createCanvas().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Tag> ctor = org.directwebremoting.proxy.jsx3.vector.Tag.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Tag.class.getName());
        }
    }

    /**
     * Instantiates and returns a new instance of jsx3.vector.Canvas. The implementation of
    createVector() in this class calls this method to create the base vector tag. This method may be
    overridden to provide a base tag of another type that Canvas.
     */
    @SuppressWarnings("unchecked")
    public <T> T createCanvas(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createCanvas().");
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
     * Renders a cross-platform vector event handler. When an event of type strEvtType bubbles up to the
    HTML element rendered by objElm, the instance method of this object whose name is
    strMethod will be called with two parameters: the browser event wrapped in an instance of
    jsx3.gui.Event, and the native HTMLElement that defined the event handler.
     * @param strEvtType the event type, one of <code>jsx3.gui.Event.CLICK</code>, etc.
     * @param strMethod the instance method to call on this object when the event is received.
     * @param objElm the HTML element to which to add the event handler.
     */
    public void paintEventHandler(String strEvtType, String strMethod, org.directwebremoting.proxy.jsx3.vector.Tag objElm)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("paintEventHandler(").appendData(strEvtType).appendScript(",")

        .appendData(strMethod).appendScript(",")

        .appendData(objElm).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
