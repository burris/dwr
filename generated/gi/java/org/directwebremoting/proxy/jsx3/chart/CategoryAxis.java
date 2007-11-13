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
package org.directwebremoting.proxy.jsx3.chart;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class CategoryAxis extends org.directwebremoting.proxy.jsx3.chart.Axis
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public CategoryAxis(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param horizontal whether this axis is horizontal (x), otherwise it's vertical (y)
     * @param primary whether this axis is primary, otherwise it's secondary
     */
    public CategoryAxis(String name, boolean horizontal, boolean primary)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new CategoryAxis", name, horizontal, primary);
        setInitScript(script);
    }

    /**
     * 
     */
    public static final String TICKS_ALIGNED = "aligned";

    /**
     * 
     */
    public static final String TICKS_BETWEEN = "between";

    /**
     * Returns the tickAlignment field, if 'between' then the midpoint of the category is between two major ticks, otherwise if 'aligned' then the midpoint of the category is aligned with a major tick.
     * @param callback tickAlignment, one of {'aligned','between'}
     */
    @SuppressWarnings("unchecked")
    public void getTickAlignment(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTickAlignment");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the tickAlignment field.
     * @param tickAlignment the new value for tickAlignment, one of {'aligned','between'}
     */
    public void setTickAlignment(String tickAlignment)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setTickAlignment", tickAlignment);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the categoryField field, the attribute of records from the data provider that contains the category name (this value can still be transformed by Axis's 'labelFunction' field).
     * @param callback categoryField
     */
    @SuppressWarnings("unchecked")
    public void getCategoryField(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getCategoryField");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the categoryField field.
     * @param categoryField the new value for categoryField
     */
    public void setCategoryField(String categoryField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setCategoryField", categoryField);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the paddingLow field, the number of category widths to pad the beginning of the axis with.
     * @param callback paddingLow
     */
    @SuppressWarnings("unchecked")
    public void getPaddingLow(Callback<Float> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Float.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPaddingLow");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the paddingLow field.
     * @param paddingLow the new value for paddingLow
     */
    public void setPaddingLow(float paddingLow)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setPaddingLow", paddingLow);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the paddingHigh field, the number of category widths to pad the end of the axis with.
     * @param callback paddingHigh
     */
    @SuppressWarnings("unchecked")
    public void getPaddingHigh(Callback<Float> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Float.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPaddingHigh");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the paddingHigh field.
     * @param paddingHigh the new value for paddingHigh
     */
    public void setPaddingHigh(float paddingHigh)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setPaddingHigh", paddingHigh);
        getScriptProxy().addScript(script);
    }

}
