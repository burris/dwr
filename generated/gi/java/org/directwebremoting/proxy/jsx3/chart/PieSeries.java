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
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class PieSeries extends org.directwebremoting.proxy.jsx3.chart.Series
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public PieSeries(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param seriesName the name of the Series, will be displayed in the Legend for most chart types
     */
    public PieSeries(String name, String seriesName)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the totalAngle field, overrides per-chart setting in PieChart.
     * @return totalAngle
     *
    @SuppressWarnings("unchecked")
    public int getTotalAngle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the totalAngle field.
     * @param totalAngle the new value for totalAngle
     */
    public void setTotalAngle(int totalAngle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTotalAngle(").appendData(totalAngle).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the startAngle field, overrides per-chart setting in PieChart.
     * @return startAngle
     *
    @SuppressWarnings("unchecked")
    public int getStartAngle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the startAngle field.
     * @param startAngle the new value for startAngle
     */
    public void setStartAngle(int startAngle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStartAngle(").appendData(startAngle).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the field field, the attribute of the data provider to use as values for this series.
     * @return field
     *
    @SuppressWarnings("unchecked")
    public String getField(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the field field.
     * @param field the new value for field
     */
    public void setField(String field)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setField(").appendData(field).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the value of a data point in this series for the given record.
     * @param record the <record/> node
     *
    @SuppressWarnings("unchecked")
    public int getValue(org.directwebremoting.proxy.jsx3.xml.Entity record, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the colors field, overrides per-chart setting in PieChart.
     * @return colors
     *
    @SuppressWarnings("unchecked")
    public Object[] getColors(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the colors field.
     * @param colors the new value for colors
     */
    public void setColors(Object[] colors)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColors(").appendData(colors).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelPlacement field, where to place the optional ChartLabel child.
     * @return labelPlacement
     *
    @SuppressWarnings("unchecked")
    public String getLabelPlacement(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelPlacement field.
     * @param labelPlacement the new value for labelPlacement
     */
    public void setLabelPlacement(String labelPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelPlacement(").appendData(labelPlacement).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelOffset field, the pixel offset of the optional ChartLabel child.
     * @return labelOffset
     *
    @SuppressWarnings("unchecked")
    public int getLabelOffset(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelOffset field.
     * @param labelOffset the new value for labelOffset
     */
    public void setLabelOffset(int labelOffset)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelOffset(").appendData(labelOffset).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * The default tooltip function for this type of series.
     * @param series 
     * @param record 
     * @param percent 
     *
    @SuppressWarnings("unchecked")
    public String tooltip(org.directwebremoting.proxy.jsx3.chart.Series series, org.directwebremoting.proxy.jsx3.xml.Entity record,  percent, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

}
