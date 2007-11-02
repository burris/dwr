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
public class Series extends org.directwebremoting.proxy.jsx3.chart.ChartComponent
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Series(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param seriesName the name of the Series, will be displayed in the Legend for most chart types
     */
    public Series(String name, String seriesName)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the seriesName field.
     * @return seriesName
     *
    @SuppressWarnings("unchecked")
    public String getSeriesName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the seriesName field, this name is usually displayed in a legend or as a label.
     * @param seriesName the new value for seriesName
     */
    public void setSeriesName(String seriesName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSeriesName(").appendData(seriesName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the function used to render tooltips for each area drawn by this series.
     * @param tooltipFunction evals to a function with the signature function(series,record) : string
     */
    public void setTooltipFunction(String tooltipFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTooltipFunction(").appendData(tooltipFunction).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the function used to render tooltips for each area drawn by this series.
     * @return function(series,record) : string
     *
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.CodeBlock getTooltipFunction(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the stroke field.
     * @return stroke
     *
    @SuppressWarnings("unchecked")
    public String getStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the stroke field, string representation of a VectorStroke.
     * @param stroke the new value for stroke
     */
    public void setStroke(String stroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStroke(").appendData(stroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the fill field.
     * @return fill
     *
    @SuppressWarnings("unchecked")
    public String getFill(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the fill field, string representation of a vector fill.
     * @param fill the new value for fill
     */
    public void setFill(String fill)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFill(").appendData(fill).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the fillGradient field.
     * @return fillGradient
     *
    @SuppressWarnings("unchecked")
    public String getFillGradient(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the fillGradient field, string representation of a vector fill gradient.
     * @param fillGradient the new value for fillGradient
     */
    public void setFillGradient(String fillGradient)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFillGradient(").appendData(fillGradient).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the x axis that this series is plotted against.
     * @return the x axis
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.Axis getXAxis()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXAxis().");
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
     * Returns the x axis that this series is plotted against.
     * @param returnType The expected return type
     * @return the x axis
     */
    @SuppressWarnings("unchecked")
    public <T> T getXAxis(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXAxis().");
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
     * Returns the y axis that this series is plotted against.
     * @return the y axis
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.Axis getYAxis()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getYAxis().");
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
     * Returns the y axis that this series is plotted against.
     * @param returnType The expected return type
     * @return the y axis
     */
    @SuppressWarnings("unchecked")
    public <T> T getYAxis(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getYAxis().");
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
     * Returns the colorFunction field.
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
     * @param colorFunction the new value for colorFunction
     */
    public void setColorFunction(String colorFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColorFunction(").appendData(colorFunction).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the optional jsx3.chart.ChartLabel child of this series.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.ChartLabel getLabel()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLabel().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.ChartLabel> ctor = org.directwebremoting.proxy.jsx3.chart.ChartLabel.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.ChartLabel.class.getName());
        }
    }

}
