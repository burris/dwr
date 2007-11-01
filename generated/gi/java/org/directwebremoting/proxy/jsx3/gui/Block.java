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
public class Block extends org.directwebremoting.proxy.jsx3.gui.Painted
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
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param vntLeft either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntTop either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntWidth either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntHeight either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param strHTML Text/HTML markup to place in the jsx3.gui.Block instance
     */
    public Block(String strName, int vntLeft, int vntTop, int vntWidth, int vntHeight, String strHTML)
    {
        super((ProxyHelper) null);
    }

    /**
     * 1
     */
    public static final int OVERFLOWSCROLL = 1;

    /**
     * 2
     */
    public static final int OVERFLOWHIDDEN = 2;

    /**
     * 3 (default)
     */
    public static final int OVERFLOWEXPAND = 3;

    /**
     * Verdana
     */
    public static final String DEFAULTFONTNAME = "Verdana";

    /**
     * 10
     */
    public static final int DEFAULTFONTSIZE = 10;

    /**
     * #000000
     */
    public static final String DEFAULTCOLOR = "#000000";

    /**
     * &#160;
     */
    public static final String DEFAULTTEXT = "&#160;";

    /**
     * jsx30block
     */
    public static final String DEFAULTCLASSNAME = "jsx30block";

    /**
     * span
     */
    public static final String DEFAULTTAGNAME = "span";

    /**
     * bold
     */
    public static final String FONTBOLD = "bold";

    /**
     * normal (default)
     */
    public static final String FONTNORMAL = "normal";

    /**
     * [empty string] (default)
     */
    public static final String DISPLAYBLOCK = "";

    /**
     * none
     */
    public static final String DISPLAYNONE = "none";

    /**
     * [empty string] (default)
     */
    public static final String VISIBILITYVISIBLE = "";

    /**
     * hidden
     */
    public static final String VISIBILITYHIDDEN = "hidden";

    /**
     * left (default)
     */
    public static final String ALIGNLEFT = "left";

    /**
     * center
     */
    public static final String ALIGNCENTER = "center";

    /**
     * right
     */
    public static final String ALIGNRIGHT = "right";

    /**
     * 0
     */
    public static final int ABSOLUTE = 0;

    /**
     * 1 (default)
     */
    public static final int RELATIVE = 1;

    /**
     * JSX/images/spc.gif
     */
    public static final String SPACE = null;

    /*
     * Returns valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @return valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     *
    @SuppressWarnings("unchecked")
    public String getBackgroundColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0));
           returns reference to self to facilitate method chaining;
     * @param strColor valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setBackgroundColor(String strColor, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBackgroundColor(").appendData(strColor).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns valid CSS property value for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
     * @return valid CSS property for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
     *
    @SuppressWarnings("unchecked")
    public String getBackground(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets valid CSS property value for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
           returns reference to self to facilitate method chaining;
     * @param strBG valid CSS property value for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setBackground(String strBG)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBackground(").appendData(strBG).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns CSS property value(s) for a border (border: solid 1px #000000)
     *
    @SuppressWarnings("unchecked")
    public String getBorder(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets CSS property value(s) for a border (border: solid 1px #000000). Properties can be strung
    together as in: border:solid 1px #989885;border-left-width:0px;
     * @param strCSS valid CSS property value for a border (border: solid 1px #000000)
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setBorder(String strCSS, boolean bRecalc)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBorder(").appendData(strCSS).appendScript(",")

        .appendData(bRecalc).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @return valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     *
    @SuppressWarnings("unchecked")
    public String getColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0));
           returns reference to self to facilitate method chaining;
     * @param strColor valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setColor(String strColor, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColor(").appendData(strColor).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns valid CSS property value, (e.g., default,wait,col-resize); if no value or an empty string, null is returned
     * @return valid CSS property value, (e.g., default,wait,col-resize)
     *
    @SuppressWarnings("unchecked")
    public String getCursor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets valid CSS property value, (e.g., default,wait,col-resize)
     * @param strCursor valid CSS property value, (e.g., default,wait,col-resize)
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setCursor(String strCursor, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCursor(").appendData(strCursor).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns CSS text to override the standard instance properties on the painted object.
     * @return CSS text
     *
    @SuppressWarnings("unchecked")
    public String getCSSOverride(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets CSS text to override the standard instance properties on the painted object. Convenience method for extending this object. CSS properties affecting layout, including border-width, padding, margin, width, and height
    are strongly discouraged, as they may interfere with the framework's internal box models.
    Since some controls are composited from multiple HTML elements, some styles may not cascade to nested elements.
    Instance Properties are the preferred method for applying styles.
     * @param strCSS CSS text.  Fore example, <code>color:red;background-color:orange;</code>
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setCSSOverride(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCSSOverride(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the named CSS rule(s) to apply to the painted object.
     *
    @SuppressWarnings("unchecked")
    public String getClassName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the named CSS rule(s) to apply to the painted object. Rules that specify border-width, padding, margin, width, and height are strongly discouraged.
    Multiple rules may be specified, delimited with a space.  For example, label emphasis.
    Since some controls are composited from multiple HTML elements, some rule styles may not cascade to nested elements.
    Dynamic Properties are the preferred method for applying global styles.
     * @param strClassName CSS property name without the leading "."
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setClassName(String strClassName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setClassName(").appendData(strClassName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the CSS display for the object; one of jsx3.gui.Block.DISPLAYNONE (display:none;) and jsx3.gui.Block.DISPLAYBLOCK (display:;)
     *
    @SuppressWarnings("unchecked")
    public String getDisplay(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the display for the object. Note that although the framework uses CSS to apply this setting, the actual values that get set are determined by the system.
    Only those parameters listed for @DISPLAY are supported as inputs to this function.
     * @param intDisplay one of jsx3.gui.Block.DISPLAYNONE (display:none;) and jsx3.gui.Block.DISPLAYBLOCK (display:;)
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setDisplay(String intDisplay, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDisplay(").appendData(intDisplay).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the CSS font-family for the object
     * @return valid CSS font-family property value
     *
    @SuppressWarnings("unchecked")
    public String getFontName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS font-family for the object;
           returns reference to self to facilitate method chaining;
     * @param strFontName valid CSS font-family property value
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setFontName(String strFontName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFontName(").appendData(strFontName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the CSS font-size for the object
     * @return font-size (in pixels)
     *
    @SuppressWarnings("unchecked")
    public int getFontSize(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS font-size for the object;
           returns reference to self to facilitate method chaining;
     * @param intPixelSize font-size (in pixels)
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setFontSize(int intPixelSize)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFontSize(").appendData(intPixelSize).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the CSS font-weight for the object ("bold" or "normal")
     * @return [jsx3.gui.Block.FONTBOLD. jsx3.gui.Block.FONTNORMAL]
     *
    @SuppressWarnings("unchecked")
    public String getFontWeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS font-weight for the object ("bold" or "normal");
           returns reference to self to facilitate method chaining;
     * @param FONTWEIGHT [jsx3.gui.Block.FONTBOLD. jsx3.gui.Block.FONTNORMAL]
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setFontWeight(String FONTWEIGHT)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFontWeight(").appendData(FONTWEIGHT).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the height property of this object.
     * @return height.
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
     * Sets the height property of this object.
     * @param vntHeight the height as a non-negative integer or non-negative percentage. For example: 45%, 12.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setHeight(int vntHeight, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHeight(").appendData(vntHeight).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets the height property of this object.
     * @param vntHeight the height as a non-negative integer or non-negative percentage. For example: 45%, 12.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setHeight(String vntHeight, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHeight(").appendData(vntHeight).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns IE tab index for setting the tabIndex property for the on-screen DHTML for the object
     *
    @SuppressWarnings("unchecked")
    public int getIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets IE tab index for setting the tabIndex property for the on-screen DHTML for the object;
           returns reference to self to facilitate method chaining;
     * @param intIndex any value in the valid range of -32767 to 32767
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setIndex(int intIndex, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setIndex(").appendData(intIndex).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the left property of this object.
     * @return left.
     *
    @SuppressWarnings("unchecked")
    public int getLeft(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the left property of this object. The left property specifies the horizontal offset of this object
    from its parent and only applies if this object is absolutely positioned.
     * @param vntLeft the left value. Only numeric values and percentages are supported. For example: 25, -10, 20%.
     * @param bRepaint if @vntLeft is in integer (a number with no modifier) and @bRepaint is true, the object's on-screen VIEW is immediately updated to match its MODEL, obviating the need to call '[object].repaint()'
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setLeft(int vntLeft, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLeft(").appendData(vntLeft).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets the left property of this object. The left property specifies the horizontal offset of this object
    from its parent and only applies if this object is absolutely positioned.
     * @param vntLeft the left value. Only numeric values and percentages are supported. For example: 25, -10, 20%.
     * @param bRepaint if @vntLeft is in integer (a number with no modifier) and @bRepaint is true, the object's on-screen VIEW is immediately updated to match its MODEL, obviating the need to call '[object].repaint()'
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setLeft(String vntLeft, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLeft(").appendData(vntLeft).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, int top, int width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, int top, int width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, int top, String width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, int top, String width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, String top, int width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, String top, int width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, String top, String width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, String top, String width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(String left, int top, int width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(String left, int top, int width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(String left, int top, String width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(String left, int top, String width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(String left, String top, int width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(String left, String top, int width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(String left, String top, String width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(String left, String top, String width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(Object[] left, int top, int width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(Object[] left, int top, int width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(Object[] left, int top, String width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(Object[] left, int top, String width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(Object[] left, String top, int width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(Object[] left, String top, int width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(Object[] left, String top, String width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
    setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
    an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(Object[] left, String top, String width, String height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the dimensions in an array of four int values
     * @return [left,top,width,height]
     *
    @SuppressWarnings("unchecked")
    public Object[] getDimensions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns CSS property value(s) for a margin (margin:4px;)
     *
    @SuppressWarnings("unchecked")
    public String getMargin(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets CSS property value for margin.
     * @param strCSS The preferred method to set margin is by moving clockwise, beginning with the <b>north</b>
    compass position, <b>without</b> the pixel designation.  For example, to specify a top margin of 8 pixels, use <code>8 0 0 0</code>. CSS syntax is
    supported, but requires that pixels be designated.  For example, using <code>margin:5px;margin-left:10px;</code>, is equivalent to
    <code>5 5 5 10</code>.
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setMargin(String strCSS, boolean bRecalc)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMargin(").appendData(strCSS).appendScript(",")

        .appendData(bRecalc).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the overflow property for the object, that defines how its on-screen view will behave when its contents are larger than its specified width and/or height
     * @return [jsx3.gui.Block.OVERFLOWSCROLL, jsx3.gui.Block.OVERFLOWHIDDEN, jsx3.gui.Block.OVERFLOWEXPAND]
     *
    @SuppressWarnings("unchecked")
    public int getOverflow(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the overflow property for the object, that defines how its on-screen view will behave when its contents are larger than its specified width and/or height;
           returns reference to self to facilitate method chaining;
     * @param OVERFLOW [jsx3.gui.Block.OVERFLOWSCROLL, jsx3.gui.Block.OVERFLOWHIDDEN, jsx3.gui.Block.OVERFLOWEXPAND]
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setOverflow(int OVERFLOW)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setOverflow(").appendData(OVERFLOW).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns CSS property value(s) for a padding (padding:4px;)
     *
    @SuppressWarnings("unchecked")
    public String getPadding(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS property value for padding an object.
     * @param strCSS The preferred method to set padding is by moving clockwise, beginning with the <b>north</b>
    compass position, <b>without</b> the pixel designation.  For example, to specify a top padding of 8 pixels, use <code>8 0 0 0</code>. CSS syntax is
    supported, but requires that pixels be designated.  For example, using <code>padding:5px;padding-left:10px;</code>, is equivalent to
    <code>5 5 5 10</code>.
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setPadding(String strCSS, boolean bRecalc)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPadding(").appendData(strCSS).appendScript(",")

        .appendData(bRecalc).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns if the instance is relatively positioned on-screen; returns one of: jsx3.gui.Block.ABSOLUTE jsx3.gui.Block.RELATIVE
     *
    @SuppressWarnings("unchecked")
    public int getRelativePosition(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets if the jsx3.gui.Block instance is relatively positioned on-screen;
           returns reference to self to facilitate method chaining;
     * @param intRelative jsx3.gui.Block.RELATIVE will be applied to the view if null. One of: jsx3.gui.Block.RELATIVE jsx3.gui.Block.ABSOLUTE
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setRelativePosition(int intRelative, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRelativePosition(").appendData(intRelative).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns HTML tag name to use when rendering the object on-screen (span is the default); if the property is null,
         jsx3.gui.Block.DEFAULTTAGNAME is used;
     * @return valid HTML tag name
     *
    @SuppressWarnings("unchecked")
    public String getTagName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets HTML tag name to use when rendering the object on-screen (jsx3.gui.Block.DEFAULTTAGNAME is the default);
           returns reference to self to facilitate method chaining;
     * @param strTagName valid HTML tag name (span, div, form, ol, ul, li, etc); if null is passed, the getter will use jsx3.gui.Block.DEFAULTTAGNAME
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setTagName(String strTagName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTagName(").appendData(strTagName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the text/HTML for the control to be displayed on-screen; returns an empty string if null; since the text
    is rendered on-screen as browser-native HTML, the equivalent of an empty tag (e.g., <span\>) would be an
    enclosing tag with an empty string (no content): <span></span>.  To return null would be equivalent to
    <span>null</span>, which is not the same as <span/>
     *
    @SuppressWarnings("unchecked")
    public String getText(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the text/HTML for the control to be displayed on-screen;
           returns reference to self to facilitate method chaining;
     * @param strText text/HTML
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setText(String strText, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setText(").appendData(strText).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the CSS text-align property for the object; if no property value exists, jsx3.gui.Block.ALIGNLEFT is returned by default
     * @return one of: jsx3.gui.Block.ALIGNLEFT, jsx3.gui.Block.ALIGNRIGHT, jsx3.gui.Block.ALIGNCENTER
     *
    @SuppressWarnings("unchecked")
    public String getTextAlign(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS text-align property for the object;
           returns reference to self to facilitate method chaining;
     * @param ALIGN one of: jsx3.gui.Block.ALIGNLEFT, jsx3.gui.Block.ALIGNRIGHT, jsx3.gui.Block.ALIGNCENTER
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setTextAlign(String ALIGN)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTextAlign(").appendData(ALIGN).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the tooltip text to display when the object is hovered over.  Returns an empty string if null.
     *
    @SuppressWarnings("unchecked")
    public String getTip(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the tooltip text to display when the object is hovered over. Updates Model and View.
    Returns reference to self to facilitate method chaining;
     * @param strTip text/HTML
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setTip(String strTip)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTip(").appendData(strTip).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the top property of this object.
     * @return top.
     *
    @SuppressWarnings("unchecked")
    public int getTop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the top property of this object. The top property specifies the vertical offset of this object
    from its parent and only applies if this object is absolutely positioned.
     * @param vntTop the top value. Only numeric values and percentages are supported. For example: 25, -10, 20%.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setTop(int vntTop, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTop(").appendData(vntTop).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets the top property of this object. The top property specifies the vertical offset of this object
    from its parent and only applies if this object is absolutely positioned.
     * @param vntTop the top value. Only numeric values and percentages are supported. For example: 25, -10, 20%.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setTop(String vntTop, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTop(").appendData(vntTop).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the visibility property for the object
     * @return [jsx3.gui.Block.VISIBILITYVISIBLE, jsx3.gui.Block.VISIBILITYHIDDEN]
     *
    @SuppressWarnings("unchecked")
    public String getVisibility(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS visibility property the object
     * @param VISIBILITY [jsx3.gui.Block.VISIBILITYVISIBLE, jsx3.gui.Block.VISIBILITYHIDDEN]
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setVisibility(String VISIBILITY, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setVisibility(").appendData(VISIBILITY).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the width property of this object.
     * @return width.
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
     * Sets the width property of this object.
    JOE: Note vntWidth can be an integer also.
     * @param vntWidth the width as non-negative integer or non-negative percentage. For example: 45%, 12.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setWidth(int vntWidth, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setWidth(").appendData(vntWidth).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets the width property of this object.
    JOE: Note vntWidth can be an integer also.
     * @param vntWidth the width as non-negative integer or non-negative percentage. For example: 45%, 12.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setWidth(String vntWidth, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setWidth(").appendData(vntWidth).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the CSS z-index property
     *
    @SuppressWarnings("unchecked")
    public int getZIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS z-index for the object
     * @param intZIndex z-index value
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Block setZIndex(int intZIndex, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setZIndex(").appendData(intZIndex).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the DHTML, used for this object's on-screen VIEW
     * @param strData Text/HTML markup that will replace value of getText() during paint&#8212;typically passed by subclass, JSXBlockX after it performs an XML/XSL merge to acquire its data; for memory management purposes, the data is not set via setText() and, instead, is passed as a temporary input parameter, as the object's MODEL would contain the text for no reason
     * @return DHTML
     *
    @SuppressWarnings("unchecked")
    public String paint(String strData, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * displays a "blocking mask" inside the block to stop user interactions with content within the block. Applies only to Blocks. Use only on blocks with no padding (padding:0px)
     * @param strMessage text/message to display in the blocking mask to tell the user it is disabled
     */
    public void showMask(String strMessage)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("showMask(").appendData(strMessage).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * removes the "blocking" mask inside the block to stop user interactions with existing content
     */
    public void hideMask()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("hideMask(").appendScript(");");
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
