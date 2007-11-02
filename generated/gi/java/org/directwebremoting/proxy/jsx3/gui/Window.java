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
public class Window extends org.directwebremoting.proxy.jsx3.app.Model
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Window(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strName a unique name for this window.
     */
    public Window(String strName)
    {
        super((ProxyHelper) null);
    }

    /**
     * Event subject: published after this window has successfully opened.
     */
    public static final String DID_OPEN = "open";

    /**
     * Event subject: published just before this window will close.
     */
    public static final String WILL_CLOSE = "close";

    /**
     * Event subject: published after this window has received focus.
     */
    public static final String DID_FOCUS = "focus";

    /**
     * Event subject: published after this window has been resized via user interaction.
     */
    public static final String DID_RESIZE = "resize";

    /**
     * Event subject: published after this window's parent has closed.
     */
    public static final String PARENT_DID_CLOSE = "pclose";

    /*
     * Opens the browser window of this window instance. Depending on security settings and popup blockers, 
    this method may or may not actually open a window. The only safe way to determine whether the window 
    successfully opened is to register for the DID_OPEN event.
     * @return <code>true</code> if the window successfully opened (probably).
     *
    @SuppressWarnings("unchecked")
    public boolean open(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Closes the browser window of this window instance.
     * @return <code>true</code> if the window successfully closed or <code>false</code> if it didn't close
    because of JavaScript security constraints or user interaction.
     *
    @SuppressWarnings("unchecked")
    public boolean close(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Focuses the browser window of this window instance.
     */
    public void focus()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("focus(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether the browser window of this window instance is open.
     * @return <code>true</code> if the window is open.
     *
    @SuppressWarnings("unchecked")
    public boolean isOpen(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether the parent application window of this window instance is open.
     * @return <code>true</code> if the parent window is open.
     *
    @SuppressWarnings("unchecked")
    public boolean isParentOpen(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Moves the browser window of this window instance to a position on the screen. The arguments specify the 
    offset from the parent application window. If the parent window is no longer open, this window will be moved 
    relative to the upper-left corner of the screen.
     * @param intOffsetLeft the left offset from the parent window.
     * @param intOffsetTop the top offset from the parent window.
     */
    public void moveTo(int intOffsetLeft, int intOffsetTop)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("moveTo(").appendData(intOffsetLeft).appendScript(",")

        .appendData(intOffsetTop).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Ensures that this window is at least partially visible on the computer screen.
     */
    public void constrainToScreen()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("constrainToScreen(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the current x-coordinate screen position of this browser window relative to the parent application window.
    If the parent window is no longer open, this method returns the position relative to the upper-left
    corner of the screen.
     *
    @SuppressWarnings("unchecked")
    public int getOffsetLeft(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the current y-coordinate screen position of this browser window relative to the parent application window.
    If the parent window is no longer open, this method returns the position relative to the upper-left
    corner of the screen.
     *
    @SuppressWarnings("unchecked")
    public int getOffsetTop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the first DOM child of this window object. If no child exists, this method creates a root block, adds it
    to the DOM, and returns it. A window will only render its first DOM child.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block getRootBlock()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRootBlock().");
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
     * Returns the first DOM child of this window object. If no child exists, this method creates a root block, adds it
    to the DOM, and returns it. A window will only render its first DOM child.
     */
    @SuppressWarnings("unchecked")
    public <T> T getRootBlock(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRootBlock().");
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
     * Repaints the root block of this window.
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
     * Returns the inner (visible) width of this window. This does not include the border and padding that the
    browser may render around the window content.
     *
    @SuppressWarnings("unchecked")
    public int getWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the inner (visible) width of this window. If the window is currently open, the window will be resized
    immediately.
     * @param intWidth the inner width of the window in pixels.
     */
    public void setWidth(int intWidth)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setWidth(").appendData(intWidth).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the inner (visible) height of this window. This does not include the border and padding that the
    browser may render around the window content.
     *
    @SuppressWarnings("unchecked")
    public int getHeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the inner (visible) height of this window. If the window is currently open, the window will be resized
    immediately.
     * @param intHeight the inner height of the window in pixels.
     */
    public void setHeight(int intHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHeight(").appendData(intHeight).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether this window is resizable via user interaction. The value returned by this method will reflect
    the last value passed to setResizable() and therefore may not truly reflect the current state of the
    browser window.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>.
     *
    @SuppressWarnings("unchecked")
    public int isResizable(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether this window is resizable via user interaction. This method will not affect a currently-open window.
     * @param bResizable 
     */
    public void setResizable(boolean bResizable)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setResizable(").appendData(bResizable).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether this window will show scroll bars if the content outgrows the window. The value returned by
    this method will reflect the last value passed to setScrollable() and therefore may not truly
    reflect the current state of the browser window.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>.
     *
    @SuppressWarnings("unchecked")
    public int isScrollable(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether this window will show scroll bars if the content outgrows the window. This method will not affect a
    currently-open window.
     * @param bScrollable 
     */
    public void setScrollable(boolean bScrollable)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setScrollable(").appendData(bScrollable).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether this window is "dependent." Dependent windows close automatically when their parents close. If
    a window is not dependent, it will stay open after the parent window closes. Note that the parent window contains
    all the JavaScript code and so it is very likely that interacting with a window after the parent has closed
    will raise errors.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>.
     *
    @SuppressWarnings("unchecked")
    public int isDependent(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether this window is "dependent." This method not affect a currently-open window.
     * @param bDependent 
     */
    public void setDependent(boolean bDependent)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDependent(").appendData(bDependent).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the title of this window.
     *
    @SuppressWarnings("unchecked")
    public String getTitle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the title of the window. The title is displayed in the title bar of the browser window. If the window is
    currently open, the title will be updated immediately.
     * @param strTitle the title of the window.
     */
    public void setTitle(String strTitle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTitle(").appendData(strTitle).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
