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
public class Tab extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Tab(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param strText text to display within the given tab; if null, jsx3.gui.Tab.DEFAULTTEXT is used
     * @param vntWidth one of: 1) the width as an integer representing a fixed pixel width for the tab (e.g., 80) ; 2) the width as a percentage representing this tab's width as a percentage of how wide the entire tabbed pane should be (e.g., "25%"); 3) no value (null) to designate that this tab should be just large engough to contain the value of the parameter, @strText;
     * @param strHexActiveColor valid css property for defining the color to use when the tab is active (i.e., red, #ff0000, etc)
     * @param strHexInactiveColor valid css property for defining the color to use when the tab is inactive (i.e., red, #ff0000, etc)
     */
    public Tab(String strName, String strText, int vntWidth, String strHexActiveColor, String strHexInactiveColor)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String DEFAULTBEVELIMAGE = null;

    /**
     * #e8e8f5
     */
    public static final String DEFAULTACTIVECOLOR = "#e8e8f5";

    /**
     * #d8d8e5
     */
    public static final String DEFAULTINACTIVECOLOR = "#d8d8e5";

    /**
     * 
     */
    public static final String ACTIVEBEVEL = null;

    /**
     * 
     */
    public static final String INACTIVEBEVEL = null;

    /**
     * #e8e8f5
     */
    public static final String CHILDBGCOLOR = "#e8e8f5";

    /**
     * 0 : disabled
     */
    public static final int STATEDISABLED = 0;

    /**
     * 1 : enabled (default)
     */
    public static final int STATEENABLED = 1;

    /*
     * Returns background image that will underlay each tab to provide an outset-type border. Default: jsx3.gui.Tab.DEFAULTBEVELIMAGE
     * @return valid url (typically relative) to point to an image that can be used as a bacground image for the tab
     *
    @SuppressWarnings("unchecked")
    public String getBevel(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets background image that will underlay each tab to provide an outset-type border; if this value is not set or null is passed, the default background image for the jsx3.gui.Tab class will be use the contant value, jsx3.gui.Tab.DEFAULTBEVELIMAGE;
     * @param strURL valid url (typically relative) to point to an image that can be used as a bacground image for the tab
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tab setBevel(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBevel(").appendData(strURL).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Brings this tab and its associated pane forward in the stack among all sibling tabs.
     */
    public void doShow()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("doShow(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns valid CSS property value, (e.g., red, #ffffff) when tab is active. Default: jsx3.gui.Tab.DEFAULTACTIVECOLOR
     * @return valid CSS property value, (e.g., red, #ffffff)
     *
    @SuppressWarnings("unchecked")
    public String getActiveColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets valid CSS property value, (e.g., red, #ffffff) when tab is active;
     * @param strActiveColor valid CSS property value, (e.g., red, #ffffff)
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tab setActiveColor(String strActiveColor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setActiveColor(").appendData(strActiveColor).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns valid CSS property value, (e.g., red, #ffffff) when tab is inactive (not selected tab in the group). Default: jsx3.gui.Tab.DEFAULTINACTIVECOLOR
     * @return valid CSS property value, (e.g., red, #ffffff)
     *
    @SuppressWarnings("unchecked")
    public String getInactiveColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets valid CSS property value, (e.g., red, #ffffff) when tab is inactive (not selected tab in the group);
     * @param strInactiveColor valid CSS property value, (e.g., red, #ffffff)
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tab setInactiveColor(String strInactiveColor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setInactiveColor(").appendData(strInactiveColor).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the state for the tab control. Default: jsx3.gui.Tab.STATEENABLED
     * @return one of: jsx3.gui.Tab.STATEDISABLED, jsx3.gui.Tab.STATEENABLED
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

    /**
     * Sets the enabled state for the tab control; returns reference to self to facilitate method chaining
     * @param STATE one of: jsx3.gui.Tab.STATEDISABLED, jsx3.gui.Tab.STATEENABLED
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Tab setEnabled(int STATE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setEnabled(").appendData(STATE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns the child of this tab that will be painted as the content of this tab. This implementation returns the
    first child of this stack.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getContentChild()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getContentChild().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the child of this tab that will be painted as the content of this tab. This implementation returns the
    first child of this stack.
     */
    @SuppressWarnings("unchecked")
    public <T> T getContentChild(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getContentChild().");
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

}
