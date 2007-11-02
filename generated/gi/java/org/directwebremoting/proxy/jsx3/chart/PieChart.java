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

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class PieChart extends org.directwebremoting.proxy.jsx3.chart.RadialChart
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public PieChart(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param left left position (in pixels) of the chart relative to its parent container
     * @param top top position (in pixels) of the chart relative to its parent container
     * @param width width (in pixels) of the chart
     * @param height height (in pixels) of the chart
     */
    public PieChart(String name, int left, int top, int width, int height)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the innerRadius field, the radius as the hole in the middle of the pie as a ratio of the entire radius.
     * @return innerRadius
     *
    @SuppressWarnings("unchecked")
    public float getInnerRadius(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the innerRadius field.
     * @param innerRadius the new value for innerRadius, between 0.0 and 1.0
     */
    public void setInnerRadius(float innerRadius)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setInnerRadius(").appendData(innerRadius).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the seriesPadding field, the amount of padding between rings in a doughnut chart as a ratio of the width of a ring.
     * @return seriesPadding
     *
    @SuppressWarnings("unchecked")
    public float getSeriesPadding(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the seriesPadding field.
     * @param seriesPadding the new value for seriesPadding, positive value, not too big
     */
    public void setSeriesPadding(float seriesPadding)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSeriesPadding(").appendData(seriesPadding).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the totalAngle field, the total angle used for each series; may be overridden on a series-by-series basis by jsx3.chart.PieSeries.totalAngle.
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
     * @param totalAngle the new value for totalAngle, between 0 and 360
     */
    public void setTotalAngle(int totalAngle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTotalAngle(").appendData(totalAngle).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the startAngle field, the start angle of the first slice in each series; 0 points upwards and increasing values go clockwise; may be overridden on a series-by-series basis by jsx3.chart.PieSeries.startAngle.
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
     * @param startAngle the new value for startAngle, between 0 and 360
     */
    public void setStartAngle(int startAngle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStartAngle(").appendData(startAngle).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the categoryField field, the attribute of a record that contains the category name value; necessary because there is no CategoryAxis to define this in a radial chart.
     * @return categoryField
     *
    @SuppressWarnings("unchecked")
    public String getCategoryField(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the categoryField field.
     * @param categoryField the new value for categoryField
     */
    public void setCategoryField(String categoryField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCategoryField(").appendData(categoryField).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the colors field, an array of string representations of a vector fill, to color in the slices of all the data series; may be overridden by jsx3.chart.PieSeries.colors for an individual series..
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
     * Returns the colorFunction field, a function that defines how to color in the slices of each data series in this chart, with the signature function(record, index) : jsx3.vector.Fill; may be overridden by jsx3.chart.PieSeries.colorFunction for an individual series..
     * @return colorFunction
     *
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.CodeBlock getColorFunction(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the colorFunction field.
     * @param colorFunction the new value for colorFunction, should eval to a function with the signature function(record, index) : jsx3.vector.Fill
     */
    public void setColorFunction(String colorFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColorFunction(").appendData(colorFunction).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the seriesStroke field, string representation of a VectorStroke to outline the slices of all the series with; may be overridden by jsx3.chart.PieSeries.stroke for an individual series..
     * @return seriesStroke
     *
    @SuppressWarnings("unchecked")
    public String getSeriesStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the seriesStroke field.
     * @param seriesStroke the new value for seriesStroke
     */
    public void setSeriesStroke(String seriesStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSeriesStroke(").appendData(seriesStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * default coloring scheme for pie series, simply converts the default coloring scheme for series into a coloring scheme for categories
     * @param record 
     * @param index the index of the record in the data provider
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Fill defaultColoring(org.directwebremoting.proxy.jsx3.xml.Entity record, int index)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("defaultColoring(\"" + record + "\", \"" + index + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Fill> ctor = org.directwebremoting.proxy.jsx3.vector.Fill.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Fill.class.getName());
        }
    }

}
