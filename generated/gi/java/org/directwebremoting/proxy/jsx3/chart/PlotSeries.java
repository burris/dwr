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
public class PlotSeries extends org.directwebremoting.proxy.jsx3.chart.Series
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public PlotSeries(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param seriesName the name of the Series, will be displayed in the Legend for most chart types
     */
    public PlotSeries(String name, String seriesName)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the x-coordinate of a data point in this series for the given record.
     * @param record the <record/> node
     *
    @SuppressWarnings("unchecked")
    public int getXValue(org.directwebremoting.proxy.jsx3.xml.Entity record, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the y-coordinate of a data point in this series for the given record.
     * @param record the <record/> node
     *
    @SuppressWarnings("unchecked")
    public int getYValue(org.directwebremoting.proxy.jsx3.xml.Entity record, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the xField field.
     * @return xField
     *
    @SuppressWarnings("unchecked")
    public String getXField(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the xField field.
     * @param xField the new value for xField
     */
    public void setXField(String xField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setXField(").appendData(xField).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the yField field.
     * @return yField
     *
    @SuppressWarnings("unchecked")
    public String getYField(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the yField field.
     * @param yField the new value for yField
     */
    public void setYField(String yField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setYField(").appendData(yField).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the renderer field.
     * @return renderer
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.PointRenderer getRenderer()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRenderer().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.PointRenderer> ctor = org.directwebremoting.proxy.jsx3.chart.PointRenderer.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.PointRenderer.class.getName());
        }
    }

    /**
     * Sets the renderer field.
     * @param renderer the new value for renderer
     */
    public void setRenderer(String renderer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRenderer(").appendData(renderer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the renderer used for the legend.
     * @return the same renderer as used to draw the points
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.PointRenderer getLegendRenderer()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLegendRenderer().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.PointRenderer> ctor = org.directwebremoting.proxy.jsx3.chart.PointRenderer.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.PointRenderer.class.getName());
        }
    }

}
