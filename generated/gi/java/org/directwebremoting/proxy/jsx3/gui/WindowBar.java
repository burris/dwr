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
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class WindowBar extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public WindowBar(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param TYPE one of: jsx3.gui.WindowBar.TYPECAPTION, jsx3.gui.WindowBar.TYPETOOL, jsx3.gui.WindowBar.TYPEMENU, jsx3.gui.WindowBar.TYPETASK
     */
    public WindowBar(String strName, int TYPE)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new WindowBar", strName, TYPE);
        setInitScript(script);
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

    /**
     * Returns the type of the window bar; one of: jsx3.gui.WindowBar.TYPECAPTION, jsx3.gui.WindowBar.TYPETOOL, jsx3.gui.WindowBar.TYPEMENU, jsx3.gui.WindowBar.TYPETASK
     * @param callback one of: jsx3.gui.WindowBar.TYPECAPTION, jsx3.gui.WindowBar.TYPETOOL, jsx3.gui.WindowBar.TYPEMENU, jsx3.gui.WindowBar.TYPETASK
     */
    @SuppressWarnings("unchecked")
    public void getType(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getType");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the type of the window bar;
           returns reference to self to facilitate method chaining;
     * @param TYPE one of: jsx3.gui.WindowBar.TYPECAPTION, jsx3.gui.WindowBar.TYPETOOL, jsx3.gui.WindowBar.TYPEMENU, jsx3.gui.WindowBar.TYPETASK
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.WindowBar setType(int TYPE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setType", TYPE);
        getScriptProxy().addScript(script);
        return this;
    }

}
