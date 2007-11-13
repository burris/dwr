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
public class Splitter extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Splitter(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param ORIENTATION constant; either jsx3.gui.Splitter.ORIENTATIONH or jsx3.gui.Splitter.ORIENTATIONV; if none provided the default (horizontal layout) or vertical (stacked) layout)
     */
    public Splitter(String strName, int ORIENTATION)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Splitter", strName, ORIENTATION);
        setInitScript(script);
    }

    /**
     * 
     */
    public static final int ORIENTATIONH = 0;

    /**
     * 
     */
    public static final int ORIENTATIONV = 1;

    /**
     * Returns a valid percentage (e.g., 100.00%  23.567%) that will be applied to the on-screen element as its CSS width/height percentage
     */
    @SuppressWarnings("unchecked")
    public void getSubcontainer1Pct(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getSubcontainer1Pct");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets a valid percentage (e.g., 100.00%  23.567%) that will be applied to the on-screen element as its CSS width/height percentage
     * @param strSubcontainerPct valid CSS width property as a percentage (e.g., 34.56%)
     * @param bView false if null; if true the view is updated automatically without a repaint
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Splitter setSubcontainer1Pct(String strSubcontainerPct, boolean bView)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setSubcontainer1Pct", strSubcontainerPct, bView);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns a valid integer representing the minimum size in pixels for the container; the default minimum is 1
     */
    @SuppressWarnings("unchecked")
    public void getSubcontainer1Min(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getSubcontainer1Min");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the minimum size in pixels for the container; the default minimum is 1;
           returns reference to self to facilitate method chaining
     * @param intMin integer value represnting the minimum size in pixels for the container
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Splitter setSubcontainer1Min(int intMin)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setSubcontainer1Min", intMin);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns a valid integer representing the minimum size in pixels for the container; the default minimum is 8
     */
    @SuppressWarnings("unchecked")
    public void getSubcontainer2Min(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getSubcontainer2Min");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the minimum size in pixels for the container; the default minimum is 8;
           returns reference to self to facilitate method chaining
     * @param intMin integer value represnting the minimum size in pixels for the container
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Splitter setSubcontainer2Min(int intMin)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setSubcontainer2Min", intMin);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * *Returns whether the splitter layout is top-over (--) or side-by-side (|).
     */
    @SuppressWarnings("unchecked")
    public void getOrientation(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getOrientation");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether the splitter layout is top-over (--) or side-by-side (|);
         returns reference to self to facilitate method chaining
     * @param ORIENTATION constant; either jsx3.gui.Splitter.ORIENTATIONH or jsx3.gui.Splitter.ORIENTATIONV
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Splitter setOrientation(int ORIENTATION)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setOrientation", ORIENTATION);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns the URL for the image to use for the splitter handle when the splitter is rendered top over bottom (--).  When not set, Splitter.VSPLITIMAGE will be used when painted on-screen.
     */
    @SuppressWarnings("unchecked")
    public void getVSplitImage(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getVSplitImage");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the URL for the image to use for the splitter handle when the splitter is rendered top over bottom (--).
     * @param strURL valid URL. If no background image is wanted, pass an empty string. The resize bar for a top-over-bottom orientation is 8 pixels hight with a variable width; the image will be placed at background position, 'center center', and will not repeat.
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Splitter setVSplitImage(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setVSplitImage", strURL);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns the URL for the image to use for the splitter handle when the splitter is rendered side by side ( | ). When not set, Splitter.HSPLITIMAGE will be used when painted on-screen.
     */
    @SuppressWarnings("unchecked")
    public void getHSplitImage(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getHSplitImage");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the URL for the image to use for the splitter handle when the splitter is rendered side by side ( | ).
     * @param strURL valid URL. If no background image is wanted, pass an empty string. The resize bar for a side-by-side orientation is 8 pixels wide with a variable height; the image will be placed at background position, 'center center', and will not repeat.
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Splitter setHSplitImage(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setHSplitImage", strURL);
        getScriptProxy().addScript(script);
        return this;
    }

}
