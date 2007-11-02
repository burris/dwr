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

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class TabbedPane extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public TabbedPane(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     */
    public TabbedPane(String strName)
    {
        super((ProxyHelper) null);
    }

    /**
     * 50
     */
    public static final int AUTO_SCROLL_INTERVAL = 50;

    /**
     * jsx:///images/tab/l.png
     */
    public static final String LSCROLLER = null;

    /**
     * jsx:///images/tab/r.png
     */
    public static final String RSCROLLER = null;

    /**
     * 20 (default)
     */
    public static final int DEFAULTTABHEIGHT = 20;

    /*
     * Returns the zero-based child index of the active child tab.
     *
    @SuppressWarnings("unchecked")
    public int getSelectedIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the active tab of this tabbed pane. Pass either the zero-based child index of the tab to activate or
    the tab itself.
     * @param intIndex 
     * @param bRepaint if <code>true</code>, immediately updates the view to reflect the new active tab.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.TabbedPane setSelectedIndex(int intIndex, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSelectedIndex(").appendData(intIndex).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets the active tab of this tabbed pane. Pass either the zero-based child index of the tab to activate or
    the tab itself.
     * @param intIndex 
     * @param bRepaint if <code>true</code>, immediately updates the view to reflect the new active tab.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.TabbedPane setSelectedIndex(org.directwebremoting.proxy.jsx3.gui.Tab intIndex, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSelectedIndex(").appendData(intIndex).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the CSS height property (in pixels) for child tabs
     * @return height (in pixels)
     *
    @SuppressWarnings("unchecked")
    public int getTabHeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS height property for the object (in pixels) for child tabs;
           returns reference to self to facilitate method chaining
     * @param intTabHeight height (in pixels)
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.TabbedPane setTabHeight(int intTabHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTabHeight(").appendData(intTabHeight).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * whether or not to show the tabs of the tabbed pane. if false then only the content of each tab is drawn.
     */
    public void getShowTabs()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("getShowTabs(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * whether or not to show the tabs of the tabbed pane. if false then only the content of each tab is drawn.
     * @param intShowTabs 
     */
    public void setShowTabs(int intShowTabs)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setShowTabs(").appendData(intShowTabs).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
