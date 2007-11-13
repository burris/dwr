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
public class PieSeries extends org.directwebremoting.proxy.jsx3.chart.Series
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public PieSeries(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param seriesName the name of the Series, will be displayed in the Legend for most chart types
     */
    public PieSeries(String name, String seriesName)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new PieSeries", name, seriesName);
        setInitScript(script);
    }

    /**
     * Returns the totalAngle field, overrides per-chart setting in PieChart.
     * @param callback totalAngle
     */
    @SuppressWarnings("unchecked")
    public void getTotalAngle(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTotalAngle");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the totalAngle field.
     * @param totalAngle the new value for totalAngle
     */
    public void setTotalAngle(int totalAngle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setTotalAngle", totalAngle);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the startAngle field, overrides per-chart setting in PieChart.
     * @param callback startAngle
     */
    @SuppressWarnings("unchecked")
    public void getStartAngle(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getStartAngle");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the startAngle field.
     * @param startAngle the new value for startAngle
     */
    public void setStartAngle(int startAngle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setStartAngle", startAngle);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the field field, the attribute of the data provider to use as values for this series.
     * @param callback field
     */
    @SuppressWarnings("unchecked")
    public void getField(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getField");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the field field.
     * @param field the new value for field
     */
    public void setField(String field)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setField", field);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the value of a data point in this series for the given record.
     * @param record the <record/> node
     */
    @SuppressWarnings("unchecked")
    public void getValue(org.directwebremoting.proxy.jsx3.xml.Entity record, Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getValue", record);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the colors field, overrides per-chart setting in PieChart.
     * @param callback colors
     */
    @SuppressWarnings("unchecked")
    public void getColors(Callback<Object[]> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object[].class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getColors");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the colors field.
     * @param colors the new value for colors
     */
    public void setColors(Object[] colors)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setColors", colors);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelPlacement field, where to place the optional ChartLabel child.
     * @param callback labelPlacement
     */
    @SuppressWarnings("unchecked")
    public void getLabelPlacement(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelPlacement");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelPlacement field.
     * @param labelPlacement the new value for labelPlacement
     */
    public void setLabelPlacement(String labelPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelPlacement", labelPlacement);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelOffset field, the pixel offset of the optional ChartLabel child.
     * @param callback labelOffset
     */
    @SuppressWarnings("unchecked")
    public void getLabelOffset(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelOffset");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelOffset field.
     * @param labelOffset the new value for labelOffset
     */
    public void setLabelOffset(int labelOffset)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelOffset", labelOffset);
        getScriptProxy().addScript(script);
    }

    /**
     * The default tooltip function for this type of series.
     * @param series 
     * @param record 
     * @param percent 
     */
    @SuppressWarnings("unchecked")
    public void tooltip(org.directwebremoting.proxy.jsx3.chart.Series series, org.directwebremoting.proxy.jsx3.xml.Entity record, Object percent, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = tooltip", series, record, percent);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

}
