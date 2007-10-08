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

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Heavyweight extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Heavyweight(ProxyHelper helper)
    {
        super(helper);
    }

    
    /**
     * 32000
     */
    public static final int DEFAULTZINDEX = 32000;

    /**
     * Returns the instance of the heavyweight object with the given ID; to get the on-screen HTML instance call: jsx3.gui.Heavyweight.GO([id]).getRendered()
     * @param strId unique ID for the heavyweight instance
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight GO(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("GO(\"" + strId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Heavyweight> ctor = org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getName());
        }
    }

    
    
    /**
     * Sets the text/HTML for the control to be displayed on-screen; returns reference to self to facilitate method chaining;
     * @param bDisplay true if null; if true, the heavyweight container is positioned and displayed immediately; if false, the container is painted on-screen, but its CSS 'visibility' property is set to 'hidden', allowing the developer to adjust as needed (via 2-pass, etc) before actually displaying;
     */
    public void show(boolean bDisplay)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("show(")
              .appendData(bDisplay)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * can be called if show() has been called; resets the ratio (width/total) of the VIEW to be that of [object].getRatio()
     */
    public void applyRatio()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("applyRatio(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * can be called if show() has been called; allows an existing HW window to re-apply its rules (used for complex layouts requiring a multi-pass)
     * @param strAxis character (string) representing whether the rule is for the X or Y axis. Remember to capitalize!
     * @param intSize 
     */
    public void applyRules(String strAxis, int intSize)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("applyRules(")
              .appendData(strAxis)
              .appendScript(",")
              
              .appendData(intSize)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * destorys the on-screen VIEW for the HW container; Hide() only affects the VIEW; this is not the same as setting visibility to "hidden", which doesn't actually destroy the VIEW
     */
    public void hide()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("hide(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * destroy's the on-screen VIEW for the HW container AND removes any reference to the instance from the hash; Destroy() affects the MODEL and the VIEW
     */
    public void destroy()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("destroy(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns handle/reference to the Heavyweight Object's on-screen counterpart—basically a handle to a DHTML SPAN;
     * @param objGUI optional argument improves efficiency if provided.
     * @return Browser-Native DHTML object
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
     * Returns handle/reference to the Heavyweight Object's on-screen counterpart—basically a handle to a DHTML SPAN;
     * @param objGUI optional argument improves efficiency if provided.
     * @return Browser-Native DHTML object
     *
    @SuppressWarnings("unchecked")
    public String getRendered(String objGUI, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns handle/reference to the Heavyweight Object's on-screen counterpart—basically a handle to a DHTML SPAN;
     * @param objGUI optional argument improves efficiency if provided.
     * @return Browser-Native DHTML object
     *
    @SuppressWarnings("unchecked")
    public String getRendered(HTMLDocument objGUI, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the unique id for this heavyweight instance
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the HTML content to display inside the HW instance on-screen
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getHTML(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the HTML content to display inside the HW instance on-screen; returns ref to self
     * @param strHTML HTML
     * @param bRepaint 
     * @return this
     */
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight setHTML(String strHTML, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setHTML(")
              .appendData(strHTML)
              .appendScript(",")
              
              .appendData(bRepaint)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /*
     * Returns an object reference to the Browser Element parent to be used; if none specified, the browser BODY will be used
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getDomParent(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets an object reference to the Browser Element parent to be used; if none specified, the browser BODY will be used.
Note that this method must be called before setting any point rules for the hW instance, so those functions know the true origin from which to calculate left/top positions; returns ref to self
     * @param objGUI HTML element in the browser
     * @return this
     */
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight setDomParent(String objGUI)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setDomParent(")
              .appendData(objGUI)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /*
     * Returns the ratio (a decimal between .01 and .99) to multiply the "Rise + Run" by. When applied by the 'show'
command during a double-pass, a width to height ratio can be established to provide a consistent L&F for
the text content.  For example, a value of .8 would mean that the width of the heavyweight container would
represent 80% and the height would represent 20% of the total perimiter
     * @return 
     *
    @SuppressWarnings("unchecked")
    public int getRatio(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the ratio (a decimal between .01 and .99) to multiply the "Rise + Run" by. When applied by the 'show' command during a double-pass, a width to height ratio can be established to provide a consistent L&F for the text content.  For example, a value of .8 would mean that the width of the heavyweight container would represent 80% and the height would represent 20% of the total perimiter;
           returns a ref to self
     * @param vntRatio any value between .01 and .99
     * @return this
     */
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight setRatio(int vntRatio)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setRatio(")
              .appendData(vntRatio)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /*
     * Returns the overflow property for CONTENTS of the HW container; it is assumed that anytime a perfect fit cannot occur that the content will have its overflow property set to 'auto' unless specified otherwise
     * @return [jsx3.gui.Block.OVERFLOWSCROLL, jsx3.gui.Block.OVERFLOWHIDDEN, jsx3.gui.Block.OVERFLOWEXPAND]
     *
    @SuppressWarnings("unchecked")
    public String getOverflow(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the overflow property for CONTENTS of the HW container; it is assumed that anytime a perfect fit cannot occur that the content will have its overflow property set to 'auto' unless specified otherwise
           returns reference to self to facilitate method chaining;
     * @param strOverflow [jsx3.gui.Block.OVERFLOWSCROLL, jsx3.gui.Block.OVERFLOWHIDDEN, jsx3.gui.Block.OVERFLOWEXPAND]
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight setOverflow(String strOverflow)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setOverflow(")
              .appendData(strOverflow)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /**
     * if the HW instance has an on-screen VIEW, this method can be used to toggle its visibility; it has no effect on the MODEL; it is most commonly used when "[object].show(false);" is called, allowing the developer to manually adjust layout before actually showing the HW instance.
           returns a ref to self for method chaining
     * @param strVisibility [jsx3.gui.Block.VISIBILITYVISIBLE, jsx3.gui.Block.VISIBILITYHIDDEN]
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight setVisibility(String strVisibility)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setVisibility(")
              .appendData(strVisibility)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /*
     * Returns the z-index property; assumes jsx3.gui.Heavyweight.DEFAULTZINDEX if none supplied
     * @return 
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
     * Sets the CSS z-index for the object; if null, is passed, jsx3.gui.Heavyweight.DEFAULTZINDEX will be used as the default value
     * @param intZIndex z-index value
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight setZIndex(int intZIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setZIndex(")
              .appendData(intZIndex)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /*
     * Returns the CSS width property (in pixels); if this value is set, it is assumed that the Heavyweight container will not have its width lessened to fit on-screen.
     * @return width (in pixels)
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
     * Sets the CSS width property (in pixels); if this value is set, it is assumed that the Heavyweight container will not have its width lessened to fit on-screen.
     * @param intWidth width (in pixels)
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight setWidth(int intWidth)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setWidth(")
              .appendData(intWidth)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /*
     * Returns the CSS height property (in pixels); if this value is set, it is assumed that the Heavyweight container will not have its height lessened to fit on-screen.
     * @return height (in pixels)
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
     * Sets the CSS height property (in pixels); if this value is set, it is assumed that the Heavyweight container will not have its height lessened to fit on-screen.
           returns reference to self to facilitate method chaining;
     * @param intHeight height (in pixels)
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight setHeight(int intHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setHeight(")
              .appendData(intHeight)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /**
     * adds a POSITION RULE ruleset (X value) (a simple structure/hash) to the array of position rules; Note that POSITION RULE objects are used by the show() method to determine the best possible location for a heavyweight item
     * @param objAnchor Either an event, or an on-screen HTML element
     * @param strAnchorPoint REQUIRED if @objAnchor is an HTML element; when used, defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on @objAnchor) that the heavyweight item will try to position itself
     * @param strPoint Defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on the Heavyweight instance) that the heavyweight item will try to position itself
     * @param intOff offset (in pixels) by which to nudge the horizontal placement of the HW instance before displaying (useful for submenus, for example, where their left has a -10px offset to overlay the parent menu item)
     * @return this object (this)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight addXRule(Object objAnchor, String strAnchorPoint, String strPoint, int intOff)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("addXRule(\"" + objAnchor + "\", \"" + strAnchorPoint + "\", \"" + strPoint + "\", \"" + intOff + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Heavyweight> ctor = org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getName());
        }
    }

    
    
    /**
     * adds a POSITION RULE ruleset (X value) (a simple structure/hash) to the array of position rules; Note that POSITION RULE objects are used by the show() method to determine the best possible location for a heavyweight item
     * @param objAnchor Either an event, or an on-screen HTML element
     * @param strAnchorPoint REQUIRED if @objAnchor is an HTML element; when used, defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on @objAnchor) that the heavyweight item will try to position itself
     * @param strPoint Defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on the Heavyweight instance) that the heavyweight item will try to position itself
     * @param intOff offset (in pixels) by which to nudge the horizontal placement of the HW instance before displaying (useful for submenus, for example, where their left has a -10px offset to overlay the parent menu item)
     * @return this object (this)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight addXRule(org.directwebremoting.proxy.jsx3.gui.Event objAnchor, String strAnchorPoint, String strPoint, int intOff)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("addXRule(\"" + objAnchor + "\", \"" + strAnchorPoint + "\", \"" + strPoint + "\", \"" + intOff + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Heavyweight> ctor = org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getName());
        }
    }

    
    
    /**
     * adds a POSITION RULE ruleset (Y value) (a simple structure/hash) to the array of position rules; Note that POSITION RULE objects are used by the show() method to determine the best possible location for a heavyweight item
     * @param objAnchor Either an event or an on-screen HTML element
     * @param strAnchorPoint REQUIRED if @objAnchor is an HTML element; when used, defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on @objAnchor) that the heavyweight item will try to position itself
     * @param strPoint Defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on the Heavyweight instance) that the heavyweight item will try to position itself
     * @param intOff offset (in pixels) by which to nudge the vertical placement of the HW instance before displaying (useful for submenus, for example, where their left has a -10px offset to overlay the parent menu item)
     * @return this object (this)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight addYRule(Object objAnchor, String strAnchorPoint, String strPoint, int intOff)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("addYRule(\"" + objAnchor + "\", \"" + strAnchorPoint + "\", \"" + strPoint + "\", \"" + intOff + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Heavyweight> ctor = org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getName());
        }
    }

    
    
    /**
     * adds a POSITION RULE ruleset (Y value) (a simple structure/hash) to the array of position rules; Note that POSITION RULE objects are used by the show() method to determine the best possible location for a heavyweight item
     * @param objAnchor Either an event or an on-screen HTML element
     * @param strAnchorPoint REQUIRED if @objAnchor is an HTML element; when used, defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on @objAnchor) that the heavyweight item will try to position itself
     * @param strPoint Defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on the Heavyweight instance) that the heavyweight item will try to position itself
     * @param intOff offset (in pixels) by which to nudge the vertical placement of the HW instance before displaying (useful for submenus, for example, where their left has a -10px offset to overlay the parent menu item)
     * @return this object (this)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight addYRule(org.directwebremoting.proxy.jsx3.gui.Event objAnchor, String strAnchorPoint, String strPoint, int intOff)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("addYRule(\"" + objAnchor + "\", \"" + strAnchorPoint + "\", \"" + strPoint + "\", \"" + intOff + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Heavyweight> ctor = org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getName());
        }
    }

    
    
    /**
     * adds a POSITION RULE ruleset (a simple structure/hash) to the array of position rules; Note that POSITION RULE objects are used by the show() method to determine the best possible location for a heavyweight item
     * @param intPixel left position (in pixels) for the anchorpoint the heavyweight instance will try to layout in context of
     * @param strPoint Defines one of  the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O). Note that it
           is from this point (on the Heavyweight instance) that the heavyweight item will try to position itself
     * @param intOff offset (in pixels) by which to nudge the vertical placement of the HW instance before displaying (useful for submenus, for example, where their left has a -10px offset to overlay the parent menu item)
     * @param strAxis character (string) representing whether the rule is for the X or Y axis. Remember to capitalize!
     * @return this object (this)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Heavyweight addRule(int intPixel, String strPoint, int intOff, String strAxis)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("addRule(\"" + intPixel + "\", \"" + strPoint + "\", \"" + intOff + "\", \"" + strAxis + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Heavyweight> ctor = org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Heavyweight.class.getName());
        }
    }

    
    
    /*
     * Returns a POSITION RULE object at the given index; Note that POSITION RULE objects are JavaScript objects that implement the following 3 properties: _pixel (the on-screen point around which to pivot/place), _offset (amount to nudge the placement), _point (compass direction)
     * @param intIndex the index (in rank order of execution) of the POSITION RULEing rule set to apply (it is assumed that at least one POSITION RULE ruleset exists)
     * @param strAxis character (string) representing whether the rule is for the X or Y axis. Remember to capitalize!
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getPositionRule(int intIndex, String strAxis, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns a JavaScript object array (hash).  This hash contains the Y rules and the X rules for positioning the object
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object getPositionRules(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns a JavaScript object with properties:  X,Y (Left and Top); relating to the 4 primary (N, S, E, W), 4 secondary (NE, SE, SW, NW), and origin (O) compass positions for O
     * @param objGUI GUI object in the browser DOM (typically an HTML element such as a DIV or SPAN) for which to provide the X,Y for
     * @param strPoint a character denoting one of the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O)
     */
    public void getPoint(String objGUI, String strPoint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getPoint(")
              .appendData(objGUI)
              .appendScript(",")
              
              .appendData(strPoint)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Returns a JavaScript object with properties:  X,Y (Left and Top); relating to the 4 primary (N, S, E, W), 4 secondary (NE, SE, SW, NW), and origin (O) compass positions for O
     * @param objGUI GUI object in the browser DOM (typically an HTML element such as a DIV or SPAN) for which to provide the X,Y for
     * @param strPoint a character denoting one of the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O)
     */
    public void getPoint(org.directwebremoting.proxy.jsx3.gui.Block objGUI, String strPoint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getPoint(")
              .appendData(objGUI)
              .appendScript(",")
              
              .appendData(strPoint)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Returns a JavaScript object with properties:  X,Y (Left and Top); relating to the 4 primary (N, S, E, W), 4 secondary (NE, SE, SW, NW), and origin (O) compass positions for O
     * @param objGUI GUI object in the browser DOM (typically an HTML element such as a DIV or SPAN) for which to provide the X,Y for
     * @param strPoint a character denoting one of the valid 9 compass points: 4 primary: (N, S, E, W); 4 secondary: (NE, SE, SW, NW); and origin: (O)
     */
    public void getPoint(int objGUI, String strPoint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getPoint(")
              .appendData(objGUI)
              .appendScript(",")
              
              .appendData(strPoint)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * converts the object to a string representation more useful than the default implementation provided by the native JS engine
     * @return object profile as a string
     *
    @SuppressWarnings("unchecked")
    public String toString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
 }
