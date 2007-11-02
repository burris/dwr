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
public class StackGroup extends org.directwebremoting.proxy.jsx3.gui.LayoutGrid
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public StackGroup(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     */
    public StackGroup(String strName)
    {
        super((ProxyHelper) null);
    }

    /**
     * 0 : top-over (--) layout (default)
     */
    public static final int ORIENTATIONV = 0;

    /**
     * 1 : side-by-side (|) layout
     */
    public static final int ORIENTATIONH = 1;

    /**
     * 27 (default)
     */
    public static final int DEFAULTBARSIZE = 27;

    /*
     * Returns the size of the handle common to all child stack instances (in pixels). Default: jsx3.gui.StackGroup.DEFAULTBARSIZE
     * @return size in pixels
     *
    @SuppressWarnings("unchecked")
    public int getBarSize(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the size of the handle for the child stack instances;
           returns reference to self to facilitate method chaining
     * @param intBarSize size (in pixels)
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.StackGroup setBarSize(int intBarSize)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBarSize(").appendData(intBarSize).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns zero-based index for the tab that is active per its placement in the child JScript array
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

}
