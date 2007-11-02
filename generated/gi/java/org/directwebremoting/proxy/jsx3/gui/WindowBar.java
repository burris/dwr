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
public class WindowBar extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public WindowBar(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param TYPE one of: jsx3.gui.WindowBar.TYPECAPTION, jsx3.gui.WindowBar.TYPETOOL, jsx3.gui.WindowBar.TYPEMENU, jsx3.gui.WindowBar.TYPETASK
     */
    public WindowBar(String strName, int TYPE)
    {
        super((ProxyHelper) null);
    }

    /**
     * 26 (default)
     */
    public static final int DEFAULTHEIGHT = 26;

    /**
     * The default background pattern
     */
    public static final String DEFAULTBACKGROUND = null;

    /**
     * #c8c8d5 (default)
     */
    public static final String DEFAULTBG = "#c8c8d5";

    /**
     * #ffffff (default)
     */
    public static final String DEFAULTBGCAPTION = "#aaaacb";

    /**
     * jsx3.gui.Block.FONTBOLD (default)
     */
    public static final String DEFAULTFONTWEIGHT = Block.FONTBOLD;

    /**
     * 11 (default)
     */
    public static final int DEFAULTFONTSIZE = 11;

    /**
     * 0 (default)
     */
    public static final int TYPECAPTION = 0;

    /**
     * 1
     */
    public static final int TYPETOOL = 1;

    /**
     * 2
     */
    public static final int TYPEMENU = 2;

    /**
     * 3
     */
    public static final int TYPETASK = 3;

    /*
     * Returns the type of the window bar; one of: jsx3.gui.WindowBar.TYPECAPTION, jsx3.gui.WindowBar.TYPETOOL, jsx3.gui.WindowBar.TYPEMENU, jsx3.gui.WindowBar.TYPETASK
     * @return one of: jsx3.gui.WindowBar.TYPECAPTION, jsx3.gui.WindowBar.TYPETOOL, jsx3.gui.WindowBar.TYPEMENU, jsx3.gui.WindowBar.TYPETASK
     *
    @SuppressWarnings("unchecked")
    public int getType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the type of the window bar;
           returns reference to self to facilitate method chaining;
     * @param TYPE one of: jsx3.gui.WindowBar.TYPECAPTION, jsx3.gui.WindowBar.TYPETOOL, jsx3.gui.WindowBar.TYPEMENU, jsx3.gui.WindowBar.TYPETASK
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.WindowBar setType(int TYPE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setType(").appendData(TYPE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

}
