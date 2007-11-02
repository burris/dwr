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

import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class CartesianChart extends org.directwebremoting.proxy.jsx3.chart.Chart
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public CartesianChart(ProxyHelper helper)
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
    public CartesianChart(String name, int left, int top, int width, int height)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the array of children GridLines instances.
     * @return gridLines
     *
    @SuppressWarnings("unchecked")
    public Object[] getGridLines(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the primary x axis, if any.
     * @return primaryXAxis
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.Axis getPrimaryXAxis()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPrimaryXAxis().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.Axis> ctor = org.directwebremoting.proxy.jsx3.chart.Axis.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.Axis.class.getName());
        }
    }

    /**
     * Returns the primary x axis, if any.
     * @param returnType The expected return type
     * @return primaryXAxis
     */
    @SuppressWarnings("unchecked")
    public <T> T getPrimaryXAxis(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPrimaryXAxis().");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Returns the primary y axis, if any.
     * @return primaryYAxis
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.Axis getPrimaryYAxis()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPrimaryYAxis().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.Axis> ctor = org.directwebremoting.proxy.jsx3.chart.Axis.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.Axis.class.getName());
        }
    }

    /**
     * Returns the primary y axis, if any.
     * @param returnType The expected return type
     * @return primaryYAxis
     */
    @SuppressWarnings("unchecked")
    public <T> T getPrimaryYAxis(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPrimaryYAxis().");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /*
     * Returns the range for axis, delegates to getXRange() or getYRange().
     * @param axis 
     * @return [min,max] or null if no range can be found
     *
    @SuppressWarnings("unchecked")
    public Object[] getRangeForAxis(org.directwebremoting.proxy.jsx3.chart.Axis axis, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the range of x values in the data provider, subclasses must implement.
     * @param series the series to consider
     * @return [min,max] or null if no range can be found
     *
    @SuppressWarnings("unchecked")
    public Object[] getXRange(Object[] series, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the range of y values in the data provider, subclasses must implement.
     * @param series the series to consider
     * @return [min,max] or null if no range can be found
     *
    @SuppressWarnings("unchecked")
    public Object[] getYRange(Object[] series, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

}
