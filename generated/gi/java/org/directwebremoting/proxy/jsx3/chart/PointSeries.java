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

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class PointSeries extends org.directwebremoting.proxy.jsx3.chart.PlotSeries
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public PointSeries(ProxyHelper helper)
    {
        super(helper);
    }

    
    /**
     * 
     */
    public static final int DEFAULT_MAGNITUDE = 4;

    /*
     * Returns the magnitude field, the magnitude value to use for each data point in this series.
     * @return magnitude
     *
    @SuppressWarnings("unchecked")
    public int getMagnitude(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the magnitude field.
     * @param magnitude the new value for magnitude
     */
    public void setMagnitude(int magnitude)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setMagnitude(")
              .appendData(magnitude)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * The default tooltip function for this type of series.
     * @param series 
     * @param record 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String tooltip(org.directwebremoting.proxy.jsx3.chart.Series series, org.directwebremoting.proxy.jsx3.xml.Entity record, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
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
    
    /*
     * Returns the x-coordinate of a data point in this series for the given record.
     * @param record the <record/> node
     * @return 
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
    
    /*
     * Returns the y-coordinate of a data point in this series for the given record.
     * @param record the <record/> node
     * @return 
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
    
    /**
     * Sets the renderer field.
     * @param renderer the new value for renderer
     */
    public void setRenderer(String renderer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setRenderer(")
              .appendData(renderer)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the xField field.
     * @param xField the new value for xField
     */
    public void setXField(String xField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setXField(")
              .appendData(xField)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the yField field.
     * @param yField the new value for yField
     */
    public void setYField(String yField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setYField(")
              .appendData(yField)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
    
    /*
     * Returns the index of this series in the list of chart's series.
     * @return index, -1 if not found
     *
    @SuppressWarnings("unchecked")
    public int getIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the optional jsx3.chart.ChartLabel child of this series.
     * @return 
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
     * @param type The expected return type
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
     * @param type The expected return type
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
    
    /**
     * Sets the colorFunction field.
     * @param colorFunction the new value for colorFunction
     */
    public void setColorFunction(String colorFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setColorFunction(")
              .appendData(colorFunction)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the fill field, string representation of a vector fill.
     * @param fill the new value for fill
     */
    public void setFill(String fill)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setFill(")
              .appendData(fill)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the fillGradient field, string representation of a vector fill gradient.
     * @param fillGradient the new value for fillGradient
     */
    public void setFillGradient(String fillGradient)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setFillGradient(")
              .appendData(fillGradient)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the seriesName field, this name is usually displayed in a legend or as a label.
     * @param seriesName the new value for seriesName
     */
    public void setSeriesName(String seriesName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setSeriesName(")
              .appendData(seriesName)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the stroke field, string representation of a VectorStroke.
     * @param stroke the new value for stroke
     */
    public void setStroke(String stroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setStroke(")
              .appendData(stroke)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the function used to render tooltips for each area drawn by this series.
     * @param tooltipFunction evals to a function with the signature function(series,record) : string
     */
    public void setTooltipFunction(String tooltipFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setTooltipFunction(")
              .appendData(tooltipFunction)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Returns the chart of which this component is a part.
     * @return this if this is a chart, or the first ancestor that is a chart
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.Chart getChart()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChart().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.Chart> ctor = org.directwebremoting.proxy.jsx3.chart.Chart.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.Chart.class.getName());
        }
    }

    
    
    /**
     * Returns the chart of which this component is a part.
     * @param type The expected return type
     * @return this if this is a chart, or the first ancestor that is a chart
     */
    @SuppressWarnings("unchecked")
    public <T> T getChart(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChart().");
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
     * Returns valid CSS property value for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
     * @return valid CSS property for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
     *
    @SuppressWarnings("unchecked")
    public String getBackground(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @return valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     *
    @SuppressWarnings("unchecked")
    public String getBackgroundColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns CSS property value(s) for a border (border: solid 1px #000000)
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getBorder(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns CSS text to override the standard instance properties on the painted object.
     * @return CSS text
     *
    @SuppressWarnings("unchecked")
    public String getCSSOverride(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the named CSS rule(s) to apply to the painted object.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getClassName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @return valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     *
    @SuppressWarnings("unchecked")
    public String getColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns valid CSS property value, (e.g., default,wait,col-resize); if no value or an empty string, null is returned
     * @return valid CSS property value, (e.g., default,wait,col-resize)
     *
    @SuppressWarnings("unchecked")
    public String getCursor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the dimensions in an array of four int values
     * @return [left,top,width,height]
     *
    @SuppressWarnings("unchecked")
    public Object[] getDimensions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the CSS display for the object; one of jsx3.gui.Block.DISPLAYNONE (display:none;) and jsx3.gui.Block.DISPLAYBLOCK (display:;)
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getDisplay(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the CSS font-family for the object
     * @return valid CSS font-family property value
     *
    @SuppressWarnings("unchecked")
    public String getFontName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the CSS font-size for the object
     * @return font-size (in pixels)
     *
    @SuppressWarnings("unchecked")
    public int getFontSize(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the CSS font-weight for the object ("bold" or "normal")
     * @return [jsx3.gui.Block.FONTBOLD. jsx3.gui.Block.FONTNORMAL]
     *
    @SuppressWarnings("unchecked")
    public String getFontWeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the height property of this object.
     * @return height.
     *
    @SuppressWarnings("unchecked")
    public int getHeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the left property of this object.
     * @return left.
     *
    @SuppressWarnings("unchecked")
    public int getLeft(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns CSS property value(s) for a margin (margin:4px;)
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getMargin(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the overflow property for the object, that defines how its on-screen view will behave when its contents are larger than its specified width and/or height
     * @return [jsx3.gui.Block.OVERFLOWSCROLL, jsx3.gui.Block.OVERFLOWHIDDEN, jsx3.gui.Block.OVERFLOWEXPAND]
     *
    @SuppressWarnings("unchecked")
    public int getOverflow(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns CSS property value(s) for a padding (padding:4px;)
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getPadding(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns if the instance is relatively positioned on-screen; returns one of: jsx3.gui.Block.ABSOLUTE jsx3.gui.Block.RELATIVE
     * @return 
     *
    @SuppressWarnings("unchecked")
    public int getRelativePosition(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns HTML tag name to use when rendering the object on-screen (span is the default); if the property is null,
         jsx3.gui.Block.DEFAULTTAGNAME is used;
     * @return valid HTML tag name
     *
    @SuppressWarnings("unchecked")
    public String getTagName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the text/HTML for the control to be displayed on-screen; returns an empty string if null; since the text
is rendered on-screen as browser-native HTML, the equivalent of an empty tag (e.g., <span\>) would be an
enclosing tag with an empty string (no content): <span></span>.  To return null would be equivalent to
<span>null</span>, which is not the same as <span/>
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getText(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the CSS text-align property for the object; if no property value exists, jsx3.gui.Block.ALIGNLEFT is returned by default
     * @return one of: jsx3.gui.Block.ALIGNLEFT, jsx3.gui.Block.ALIGNRIGHT, jsx3.gui.Block.ALIGNCENTER
     *
    @SuppressWarnings("unchecked")
    public String getTextAlign(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the tooltip text to display when the object is hovered over.  Returns an empty string if null.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getTip(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the top property of this object.
     * @return top.
     *
    @SuppressWarnings("unchecked")
    public int getTop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the visibility property for the object
     * @return [jsx3.gui.Block.VISIBILITYVISIBLE, jsx3.gui.Block.VISIBILITYHIDDEN]
     *
    @SuppressWarnings("unchecked")
    public String getVisibility(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the width property of this object.
     * @return width.
     *
    @SuppressWarnings("unchecked")
    public int getWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the CSS z-index property
     * @return 
     *
    @SuppressWarnings("unchecked")
    public int getZIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * removes the "blocking" mask inside the block to stop user interactions with existing content
     */
    public void hideMask()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("hideMask(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the DHTML, used for this object's on-screen VIEW
     * @param strData Text/HTML markup that will replace value of getText() during paint&#8212;typically passed by subclass, JSXBlockX after it performs an XML/XSL merge to acquire its data; for memory management purposes, the data is not set via setText() and, instead, is passed as a temporary input parameter, as the object's MODEL would contain the text for no reason
     * @return DHTML
     *
    @SuppressWarnings("unchecked")
    public String paint(String strData, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets valid CSS property value for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
           returns reference to self to facilitate method chaining;
     * @param strBG valid CSS property value for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setBackground(String strBG)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setBackground(\"" + strBG + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets valid CSS property value for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
           returns reference to self to facilitate method chaining;
     * @param strBG valid CSS property value for the background such as:  background-image:url(x.gif);  or background-image:url(x.gif);background-repeat:no-repeat;
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setBackground(String strBG, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setBackground(\"" + strBG + "\").");
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
     * Sets valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0));
           returns reference to self to facilitate method chaining;
     * @param strColor valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setBackgroundColor(String strColor, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setBackgroundColor(\"" + strColor + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0));
           returns reference to self to facilitate method chaining;
     * @param strColor valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setBackgroundColor(String strColor, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setBackgroundColor(\"" + strColor + "\", \"" + bRepaint + "\").");
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
     * Sets CSS property value(s) for a border (border: solid 1px #000000). Properties can be strung
together as in: border:solid 1px #989885;border-left-width:0px;
     * @param strCSS valid CSS property value for a border (border: solid 1px #000000)
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setBorder(String strCSS, boolean bRecalc)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setBorder(\"" + strCSS + "\", \"" + bRecalc + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets CSS property value(s) for a border (border: solid 1px #000000). Properties can be strung
together as in: border:solid 1px #989885;border-left-width:0px;
     * @param strCSS valid CSS property value for a border (border: solid 1px #000000)
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setBorder(String strCSS, boolean bRecalc, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setBorder(\"" + strCSS + "\", \"" + bRecalc + "\").");
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
     * Sets CSS text to override the standard instance properties on the painted object. Convenience method for extending this object. CSS properties affecting layout, including border-width, padding, margin, width, and height
are strongly discouraged, as they may interfere with the framework's internal box models.
Since some controls are composited from multiple HTML elements, some styles may not cascade to nested elements.
Instance Properties are the preferred method for applying styles.
     * @param strCSS CSS text.  Fore example, <code>color:red;background-color:orange;</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setCSSOverride(String strCSS)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCSSOverride(\"" + strCSS + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets CSS text to override the standard instance properties on the painted object. Convenience method for extending this object. CSS properties affecting layout, including border-width, padding, margin, width, and height
are strongly discouraged, as they may interfere with the framework's internal box models.
Since some controls are composited from multiple HTML elements, some styles may not cascade to nested elements.
Instance Properties are the preferred method for applying styles.
     * @param strCSS CSS text.  Fore example, <code>color:red;background-color:orange;</code>
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setCSSOverride(String strCSS, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCSSOverride(\"" + strCSS + "\").");
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
     * Sets the named CSS rule(s) to apply to the painted object. Rules that specify border-width, padding, margin, width, and height are strongly discouraged.
Multiple rules may be specified, delimited with a space.  For example, label emphasis.
Since some controls are composited from multiple HTML elements, some rule styles may not cascade to nested elements.
Dynamic Properties are the preferred method for applying global styles.
     * @param strClassName CSS property name without the leading "."
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setClassName(String strClassName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setClassName(\"" + strClassName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the named CSS rule(s) to apply to the painted object. Rules that specify border-width, padding, margin, width, and height are strongly discouraged.
Multiple rules may be specified, delimited with a space.  For example, label emphasis.
Since some controls are composited from multiple HTML elements, some rule styles may not cascade to nested elements.
Dynamic Properties are the preferred method for applying global styles.
     * @param strClassName CSS property name without the leading "."
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setClassName(String strClassName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setClassName(\"" + strClassName + "\").");
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
     * Sets valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0));
           returns reference to self to facilitate method chaining;
     * @param strColor valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setColor(String strColor, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setColor(\"" + strColor + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0));
           returns reference to self to facilitate method chaining;
     * @param strColor valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setColor(String strColor, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setColor(\"" + strColor + "\", \"" + bRepaint + "\").");
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
     * Sets valid CSS property value, (e.g., default,wait,col-resize)
     * @param strCursor valid CSS property value, (e.g., default,wait,col-resize)
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setCursor(String strCursor, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCursor(\"" + strCursor + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets valid CSS property value, (e.g., default,wait,col-resize)
     * @param strCursor valid CSS property value, (e.g., default,wait,col-resize)
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T setCursor(String strCursor, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCursor(\"" + strCursor + "\", \"" + bRepaint + "\").");
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
     * Set one to four dimensions at once. This operation is more efficient than calling more than one of
setLeft, setTop, etc. Any argument can be null to indicate not to update it.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     * @param bRepaint whether to update the display of this object immediately. If <code>left</code> is
   an <code>Array</code> then this parameter is the second parameter passed to this method.
     */
    public void setDimensions(int left, int top, int width, int height, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setDimensions(")
              .appendData(left)
              .appendScript(",")
              
              .appendData(top)
              .appendScript(",")
              
              .appendData(width)
              .appendScript(",")
              
              .appendData(height)
              .appendScript(",")
              
              .appendData(bRepaint)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the display for the object. Note that although the framework uses CSS to apply this setting, the actual values that get set are determined by the system.
Only those parameters listed for @DISPLAY are supported as inputs to this function.
     * @param intDisplay one of jsx3.gui.Block.DISPLAYNONE (display:none;) and jsx3.gui.Block.DISPLAYBLOCK (display:;)
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setDisplay(String intDisplay, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setDisplay(\"" + intDisplay + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the display for the object. Note that although the framework uses CSS to apply this setting, the actual values that get set are determined by the system.
Only those parameters listed for @DISPLAY are supported as inputs to this function.
     * @param intDisplay one of jsx3.gui.Block.DISPLAYNONE (display:none;) and jsx3.gui.Block.DISPLAYBLOCK (display:;)
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setDisplay(String intDisplay, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setDisplay(\"" + intDisplay + "\", \"" + bRepaint + "\").");
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
     * Sets the CSS font-family for the object;
           returns reference to self to facilitate method chaining;
     * @param strFontName valid CSS font-family property value
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setFontName(String strFontName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setFontName(\"" + strFontName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the CSS font-family for the object;
           returns reference to self to facilitate method chaining;
     * @param strFontName valid CSS font-family property value
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setFontName(String strFontName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setFontName(\"" + strFontName + "\").");
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
     * Sets the CSS font-size for the object;
           returns reference to self to facilitate method chaining;
     * @param intPixelSize font-size (in pixels)
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setFontSize(int intPixelSize)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setFontSize(\"" + intPixelSize + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the CSS font-size for the object;
           returns reference to self to facilitate method chaining;
     * @param intPixelSize font-size (in pixels)
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setFontSize(int intPixelSize, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setFontSize(\"" + intPixelSize + "\").");
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
     * Sets the CSS font-weight for the object ("bold" or "normal");
           returns reference to self to facilitate method chaining;
     * @param FONTWEIGHT [jsx3.gui.Block.FONTBOLD. jsx3.gui.Block.FONTNORMAL]
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setFontWeight(String FONTWEIGHT)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setFontWeight(\"" + FONTWEIGHT + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the CSS font-weight for the object ("bold" or "normal");
           returns reference to self to facilitate method chaining;
     * @param FONTWEIGHT [jsx3.gui.Block.FONTBOLD. jsx3.gui.Block.FONTNORMAL]
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setFontWeight(String FONTWEIGHT, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setFontWeight(\"" + FONTWEIGHT + "\").");
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
     * Sets the height property of this object.
     * @param vntHeight the height as a non-negative integer or non-negative percentage. For example: 45%, 12.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setHeight(int vntHeight, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setHeight(\"" + vntHeight + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the height property of this object.
     * @param vntHeight the height as a non-negative integer or non-negative percentage. For example: 45%, 12.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T setHeight(int vntHeight, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setHeight(\"" + vntHeight + "\", \"" + bRepaint + "\").");
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
     * Sets IE tab index for setting the tabIndex property for the on-screen DHTML for the object;
           returns reference to self to facilitate method chaining;
     * @param intIndex any value in the valid range of -32767 to 32767
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setIndex(int intIndex, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setIndex(\"" + intIndex + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets IE tab index for setting the tabIndex property for the on-screen DHTML for the object;
           returns reference to self to facilitate method chaining;
     * @param intIndex any value in the valid range of -32767 to 32767
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setIndex(int intIndex, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setIndex(\"" + intIndex + "\", \"" + bRepaint + "\").");
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
     * Sets the left property of this object. The left property specifies the horizontal offset of this object
from its parent and only applies if this object is absolutely positioned.
     * @param vntLeft the left value. Only numeric values and percentages are supported. For example: 25, -10, 20%.
     * @param bRepaint if @vntLeft is in integer (a number with no modifier) and @bRepaint is true, the object's on-screen VIEW is immediately updated to match its MODEL, obviating the need to call '[object].repaint()'
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setLeft(int vntLeft, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setLeft(\"" + vntLeft + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the left property of this object. The left property specifies the horizontal offset of this object
from its parent and only applies if this object is absolutely positioned.
     * @param vntLeft the left value. Only numeric values and percentages are supported. For example: 25, -10, 20%.
     * @param bRepaint if @vntLeft is in integer (a number with no modifier) and @bRepaint is true, the object's on-screen VIEW is immediately updated to match its MODEL, obviating the need to call '[object].repaint()'
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T setLeft(int vntLeft, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setLeft(\"" + vntLeft + "\", \"" + bRepaint + "\").");
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
     * Sets CSS property value for margin.
     * @param strCSS The preferred method to set margin is by moving clockwise, beginning with the <b>north</b>
compass position, <b>without</b> the pixel designation.  For example, to specify a top margin of 8 pixels, use <code>8 0 0 0</code>. CSS syntax is
supported, but requires that pixels be designated.  For example, using <code>margin:5px;margin-left:10px;</code>, is equivalent to
<code>5 5 5 10</code>.
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setMargin(String strCSS, boolean bRecalc)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setMargin(\"" + strCSS + "\", \"" + bRecalc + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets CSS property value for margin.
     * @param strCSS The preferred method to set margin is by moving clockwise, beginning with the <b>north</b>
compass position, <b>without</b> the pixel designation.  For example, to specify a top margin of 8 pixels, use <code>8 0 0 0</code>. CSS syntax is
supported, but requires that pixels be designated.  For example, using <code>margin:5px;margin-left:10px;</code>, is equivalent to
<code>5 5 5 10</code>.
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setMargin(String strCSS, boolean bRecalc, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setMargin(\"" + strCSS + "\", \"" + bRecalc + "\").");
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
     * Sets the overflow property for the object, that defines how its on-screen view will behave when its contents are larger than its specified width and/or height;
           returns reference to self to facilitate method chaining;
     * @param OVERFLOW [jsx3.gui.Block.OVERFLOWSCROLL, jsx3.gui.Block.OVERFLOWHIDDEN, jsx3.gui.Block.OVERFLOWEXPAND]
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setOverflow(int OVERFLOW)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setOverflow(\"" + OVERFLOW + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the overflow property for the object, that defines how its on-screen view will behave when its contents are larger than its specified width and/or height;
           returns reference to self to facilitate method chaining;
     * @param OVERFLOW [jsx3.gui.Block.OVERFLOWSCROLL, jsx3.gui.Block.OVERFLOWHIDDEN, jsx3.gui.Block.OVERFLOWEXPAND]
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setOverflow(int OVERFLOW, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setOverflow(\"" + OVERFLOW + "\").");
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
     * Sets the CSS property value for padding an object.
     * @param strCSS The preferred method to set padding is by moving clockwise, beginning with the <b>north</b>
compass position, <b>without</b> the pixel designation.  For example, to specify a top padding of 8 pixels, use <code>8 0 0 0</code>. CSS syntax is
supported, but requires that pixels be designated.  For example, using <code>padding:5px;padding-left:10px;</code>, is equivalent to
<code>5 5 5 10</code>.
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setPadding(String strCSS, boolean bRecalc)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setPadding(\"" + strCSS + "\", \"" + bRecalc + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the CSS property value for padding an object.
     * @param strCSS The preferred method to set padding is by moving clockwise, beginning with the <b>north</b>
compass position, <b>without</b> the pixel designation.  For example, to specify a top padding of 8 pixels, use <code>8 0 0 0</code>. CSS syntax is
supported, but requires that pixels be designated.  For example, using <code>padding:5px;padding-left:10px;</code>, is equivalent to
<code>5 5 5 10</code>.
     * @param bRecalc if true, the VIEW will be updated with requiring a repaint
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setPadding(String strCSS, boolean bRecalc, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setPadding(\"" + strCSS + "\", \"" + bRecalc + "\").");
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
     * Sets if the jsx3.gui.Block instance is relatively positioned on-screen;
           returns reference to self to facilitate method chaining;
     * @param intRelative jsx3.gui.Block.RELATIVE will be applied to the view if null. One of: jsx3.gui.Block.RELATIVE jsx3.gui.Block.ABSOLUTE
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setRelativePosition(int intRelative, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setRelativePosition(\"" + intRelative + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets if the jsx3.gui.Block instance is relatively positioned on-screen;
           returns reference to self to facilitate method chaining;
     * @param intRelative jsx3.gui.Block.RELATIVE will be applied to the view if null. One of: jsx3.gui.Block.RELATIVE jsx3.gui.Block.ABSOLUTE
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setRelativePosition(int intRelative, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setRelativePosition(\"" + intRelative + "\", \"" + bRepaint + "\").");
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
     * Sets HTML tag name to use when rendering the object on-screen (jsx3.gui.Block.DEFAULTTAGNAME is the default);
           returns reference to self to facilitate method chaining;
     * @param strTagName valid HTML tag name (span, div, form, ol, ul, li, etc); if null is passed, the getter will use jsx3.gui.Block.DEFAULTTAGNAME
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setTagName(String strTagName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setTagName(\"" + strTagName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets HTML tag name to use when rendering the object on-screen (jsx3.gui.Block.DEFAULTTAGNAME is the default);
           returns reference to self to facilitate method chaining;
     * @param strTagName valid HTML tag name (span, div, form, ol, ul, li, etc); if null is passed, the getter will use jsx3.gui.Block.DEFAULTTAGNAME
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setTagName(String strTagName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setTagName(\"" + strTagName + "\").");
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
     * Sets the text/HTML for the control to be displayed on-screen;
           returns reference to self to facilitate method chaining;
     * @param strText text/HTML
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setText(String strText, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setText(\"" + strText + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the text/HTML for the control to be displayed on-screen;
           returns reference to self to facilitate method chaining;
     * @param strText text/HTML
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T setText(String strText, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setText(\"" + strText + "\", \"" + bRepaint + "\").");
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
     * Sets the CSS text-align property for the object;
           returns reference to self to facilitate method chaining;
     * @param ALIGN one of: jsx3.gui.Block.ALIGNLEFT, jsx3.gui.Block.ALIGNRIGHT, jsx3.gui.Block.ALIGNCENTER
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setTextAlign(String ALIGN)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setTextAlign(\"" + ALIGN + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the CSS text-align property for the object;
           returns reference to self to facilitate method chaining;
     * @param ALIGN one of: jsx3.gui.Block.ALIGNLEFT, jsx3.gui.Block.ALIGNRIGHT, jsx3.gui.Block.ALIGNCENTER
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T setTextAlign(String ALIGN, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setTextAlign(\"" + ALIGN + "\").");
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
     * Sets the tooltip text to display when the object is hovered over. Updates Model and View.
Returns reference to self to facilitate method chaining;
     * @param strTip text/HTML
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setTip(String strTip)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setTip(\"" + strTip + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the tooltip text to display when the object is hovered over. Updates Model and View.
Returns reference to self to facilitate method chaining;
     * @param strTip text/HTML
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setTip(String strTip, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setTip(\"" + strTip + "\").");
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
     * Sets the top property of this object. The top property specifies the vertical offset of this object
from its parent and only applies if this object is absolutely positioned.
     * @param vntTop the top value. Only numeric values and percentages are supported. For example: 25, -10, 20%.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setTop(int vntTop, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setTop(\"" + vntTop + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the top property of this object. The top property specifies the vertical offset of this object
from its parent and only applies if this object is absolutely positioned.
     * @param vntTop the top value. Only numeric values and percentages are supported. For example: 25, -10, 20%.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T setTop(int vntTop, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setTop(\"" + vntTop + "\", \"" + bRepaint + "\").");
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
     * Sets the CSS visibility property the object
     * @param VISIBILITY [jsx3.gui.Block.VISIBILITYVISIBLE, jsx3.gui.Block.VISIBILITYHIDDEN]
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setVisibility(String VISIBILITY, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setVisibility(\"" + VISIBILITY + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the CSS visibility property the object
     * @param VISIBILITY [jsx3.gui.Block.VISIBILITYVISIBLE, jsx3.gui.Block.VISIBILITYHIDDEN]
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T setVisibility(String VISIBILITY, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setVisibility(\"" + VISIBILITY + "\", \"" + bRepaint + "\").");
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
     * Sets the width property of this object.
JOE: Note vntWidth can be an integer also.
     * @param vntWidth the width as non-negative integer or non-negative percentage. For example: 45%, 12.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setWidth(int vntWidth, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setWidth(\"" + vntWidth + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the width property of this object.
JOE: Note vntWidth can be an integer also.
     * @param vntWidth the width as non-negative integer or non-negative percentage. For example: 45%, 12.
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T setWidth(int vntWidth, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setWidth(\"" + vntWidth + "\", \"" + bRepaint + "\").");
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
     * Sets the CSS z-index for the object
     * @param intZIndex z-index value
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setZIndex(int intZIndex, boolean bRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setZIndex(\"" + intZIndex + "\", \"" + bRepaint + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    
    
    /**
     * Sets the CSS z-index for the object
     * @param intZIndex z-index value
     * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T setZIndex(int intZIndex, boolean bRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setZIndex(\"" + intZIndex + "\", \"" + bRepaint + "\").");
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
     * displays a "blocking mask" inside the block to stop user interactions with content within the block. Applies only to Blocks. Use only on blocks with no padding (padding:0px)
     * @param strMessage text/message to display in the blocking mask to tell the user it is disabled
     */
    public void showMask(String strMessage)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("showMask(")
              .appendData(strMessage)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Publishes a model event. This method both evaluates any registered event script for the given event type
and publishes the event through the EventDispatcher interface. This method ensures that any
registered event script is executed in isolation to prevent most side effects.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @param objContext JavaScript object array with name/value pairs that provide a local
   variable stack for the execution of the event script. This argument is also passed as the <code>context</code>
   property of the event object that is published through the <code>EventDispatcher</code> interface.
     * @return the result of evaluating the event script or <code>null</code> if not event script is registered
     *
    @SuppressWarnings("unchecked")
    public Object doEvent(String strType, Object objContext, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns whether is object supports programmatic drag, meanining it will allow any contained item to be
dragged and dropped on another container supporting drop.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanDrag(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns whether this object can be the target of a drop event.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanDrop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns whether is object can be moved around the screen (this is not the same as drag/drop).
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanMove(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns whether is object can be spyglassed.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanSpy(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the event script registered for the given event type. This script could have been set by the
setEvent() method or during component deserialization.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return the JavaScript event script
     *
    @SuppressWarnings("unchecked")
    public String getEvent(String strType, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the associative array containing all the registered event script of this object. This method returns
the instance field itself and not a copy.
     * @return an associative array mapping event type to event script
     *
    @SuppressWarnings("unchecked")
    public Object getEvents(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the name of the jsx3.gui.Menu instance to display (as a context menu) when a user
clicks on this object with the right button.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getMenu(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns true if there is a event script registered for the given event type.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return the JavaScript event script
     *
    @SuppressWarnings("unchecked")
    public String hasEvent(String strType, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Registers a hot key with this JSX model node. All keydown events that bubble up to this object
will be checked against the hot key. If an event matches, the callback function will execute and the event
bubble will be canceled.

If the four parameters vntKey, bShift, bControl, and bAlt
match a previously registered hot key, the previous hot key is clobbered by the new one. Only one hot key callback
function (the most recently registered) will be executed by a single keydown event.
     * @param vntCallback either a function, or the name of a method bound to this object.
   When a keydown event bubbles up to this object that matches the hot key created by this method, this function
   is called on this object. If this function returns <code>false</code> then this hot key will not cancel the
   key event. This parameter can also be an instance of <code>HotKey</code>, in which case all
   other parameters are ignored.
     * @param vntKey if this parameter is a String, the hot key matches that key (the keycode to match is
   determined by <code>HotKey.keyDownCharToCode()</code>). If it is an integer, the hot key will match that
   keycode value.
     * @param bShift if not <code>null</code> the shift key state of the keydown event must match this value
   to invoke the hot key.
     * @param bControl if not <code>null</code> the control key state of the keydown event must match this value
   to invoke the hot key.
     * @param bAlt if not <code>null</code> the alt key state of the keydown event must match this value
   to invoke the hot key.
     * @return the registered hot key.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.HotKey registerHotKey(String vntCallback, int vntKey, boolean bShift, boolean bControl, boolean bAlt)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("registerHotKey(\"" + vntCallback + "\", \"" + vntKey + "\", \"" + bShift + "\", \"" + bControl + "\", \"" + bAlt + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.HotKey> ctor = org.directwebremoting.proxy.jsx3.gui.HotKey.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.HotKey.class.getName());
        }
    }

    
    
    /**
     * Removes an event script registered for the given model event type.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvent(String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeEvent(\"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    
    
    /**
     * Removes all events scripts registered with this object.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvents()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeEvents().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    
    
    /**
     * Sets whether is object supports programmatic drag, meanining it will allow any contained item to be dragged/dropped.
Implementing classes can decide whether to consult this value or ignore it.
     * @param bDrag <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrag(int bDrag)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanDrag(\"" + bDrag + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    
    
    /**
     * Sets whether this object can be the target of a drop event. Implementing classes can decide whether to consult
this value or ignore it.
     * @param bDrop <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrop(int bDrop)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanDrop(\"" + bDrop + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    
    
    /**
     * Sets whether is object can be moved around the screen (this is not the same as drag/drop). Implementing classes
can decide whether to consult this value or ignore it.
     * @param bMovable <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanMove(int bMovable)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanMove(\"" + bMovable + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    
    
    /**
     * Sets whether is object can be spyglassed. Implementing classes can decide whether to consult
this value or ignore it.
     * @param bSpy <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanSpy(int bSpy)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanSpy(\"" + bSpy + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    
    
    /**
     * Programmatically sets an event of this instance. Sets the script that will execute when this object publishes
a model event. The script value will be saved in the serialization file of a component. Not all classes that
implement this interface will publish events of every type. Consult the documentation of a class for a
description of the events it publishes.

For programmatic registering of event handlers when persistence in a serialization file is not required,
consider using jsx3.util.EventDispatcher.subscribe() instead of this method. Whenever a model
event is published, it is published using the EventDispatcher interface as well as by executing
any registered event script.
     * @param strScript the actual JavaScript code that will execute when the given event is published.
   For example: <code>obj.setEvent("alert('hello.');", jsx3.gui.Interactive.EXECUTE);</code>
     * @param strType the event type. Must be one of the model event types defined as static fields in this class
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setEvent(String strScript, String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setEvent(\"" + strScript + "\", \"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    
    
    /**
     * Sets the name of the jsx3.gui.Menu instance to display when a user
clicks on this object with the right button. The name is a pointer by-name to a JSX object in the same server.
     * @param strMenu name or id (jsxname or jsxid) of the context menu
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setMenu(String strMenu)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setMenu(\"" + strMenu + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    
    
    /**
     * Sets the CSS definition to apply to an HTML element when a spyglass is shown for that element
     * @param strCSS valid CSS. For example, text-decoration:underline;color:red;
     */
    public void setSpyStyles(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setSpyStyles(")
              .appendData(strCSS)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * called by 'window.setTimeout()' to display the spyglass hover for a given object;
     * @param strHTML HTML/text to display in the spyglass; as the spyglass does not define a height/width, this content will
         have improved layout if it specifies a preferred width in its in-line-style or referenced-css rule.
     * @param intLeft use an integer to specify an on-screen location; otherwise, use a <code>jsx3.gui.Event</code> instance to have the system automatically calculate the x/y position.
     * @param intTop use an integer if <code>intLeft</code> also uses an integer. Otherwise, use null.
     */
    public void showSpy(String strHTML, int intLeft, int intTop)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("showSpy(")
              .appendData(strHTML)
              .appendScript(",")
              
              .appendData(intLeft)
              .appendScript(",")
              
              .appendData(intTop)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * gives focus to the on-screen VIEW for the element; returns a handle to the html/dhtml element as exposed by the native browser
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String focus(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the absolute positioning of the object's on-screen view in relation to JSXROOT (whose left/top is 0/0).
           Returns information as a JavaScript object with properties, L, T, W, H
           of @objRoot is null, the on-screen view for JSXROOT is used as the object reference
     * @param objRoot object reference to IE DOM object (i.e., div, span, etc); if null is passed, the first div child of JSXROOT's on-screen representation will be used
     * @param objGUI object reference to item to get absolute position for&#8212;as opposed to this instance (useful for determining placement of html objects contained by JSX objects, but not part of the actual JSX DOM)
     * @return JScript object with properties: L, T, W, H (corresponding to left, top width, height)
     *
    @SuppressWarnings("unchecked")
    public Object getAbsolutePosition(String objRoot, String objGUI, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns value for the custom attribute with the given name; returns null if no attribute found
     * @param strName the name of the property/attribute
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getAttribute(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns handle to the JavaScript Object Array containing all events for the JSX GUI object;
           NOTE: This object will contain zero or more JavaScript Objects with the following Properties: script, type, system
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object getAttributes(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the value of the dynamic property @strPropName; if not found, returns null
     * @param strName property on this GUI object that will now use a dynamic property (e.g., 'jsxleft','jsxtop','jsxheight',etc.);
     * @return value of the property
     *
    @SuppressWarnings("unchecked")
    public String getDynamicProperty(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns handle/reference to the JSX GUI Object's on-screen counterpart—basically a handle to a DHTML object such as a DIV, SPAN, etc
     * @param objGUI either the HTML document containing the rendered object or an HTML element in that document.
  This argument is optional but improves the efficiency of this method if provided.
     * @return IE DHTML object
     *
    @SuppressWarnings("unchecked")
    public String getRendered(Object objGUI, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * A hook that subclasses of Painted may override in order to perform additional manipulation of the HTML DOM
created by the paint method. The order of steps follows. All steps occur in a single browser thread so that
the screen does not update between steps 2 and 3.

  The paint() method of this object is called.
  The result of the paint() method is inserted into the HTML DOM.
  The onAfterPaint() method of this object is called, passing in the newly inserted root HTML element.
     * @param objGUI the rendered HTML element representing this object.
     */
    public void onAfterPaint(String objGUI)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onAfterPaint(")
              .appendData(objGUI)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Paints a child of this object without repainting this entire object. The child is inserted into the view of
this object as the last child object, regardless of its actual position relative to other children. This method
has no effect if this object is not currently painted.
     * @param objChild the child object to paint.
     * @param bGroup <code>true</code> if this method is being called iteratively over a collection of
  children. This parameter will only be <code>false</code> on the final call in the iteration.
     * @param objGUI 
     * @param bCascadeOnly 
     */
    public void paintChild(org.directwebremoting.proxy.jsx3.gui.Painted objChild, boolean bGroup, String objGUI, boolean bCascadeOnly)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("paintChild(")
              .appendData(objChild)
              .appendScript(",")
              
              .appendData(bGroup)
              .appendScript(",")
              
              .appendData(objGUI)
              .appendScript(",")
              
              .appendData(bCascadeOnly)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Iterates through children and returns concatenation of paint() method for all children.
     * @param c the children to paint. If not provided <code>this.getChildren()</code> is used.
     * @return DHTML
     *
    @SuppressWarnings("unchecked")
    public String paintChildren(Object[] c, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Removes the box model abstraction for a given object and its descendants. This effectively resets the box profiler, so dimensions can be recalculated as if the object was just broought into the visual DOM.
     * @param properties Will designate by name, those properties that should be updated on the object's VIEW (without requiring the MODEL to repaint), including one or more of the following: padding, margin, border
     */
    public void recalcBox(Object[] properties)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("recalcBox(")
              .appendData(properties)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * removes the specific custom property bound to this object; returns a reference to self (this) to facilitate method chaining
     * @param strName the name of the custom property to remove
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Painted removeAttribute(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttribute(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Painted> ctor = org.directwebremoting.proxy.jsx3.gui.Painted.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Painted.class.getName());
        }
    }

    
    
    /**
     * removes the specific custom property bound to this object; returns a reference to self (this) to facilitate method chaining
     * @param strName the name of the custom property to remove
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T removeAttribute(String strName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttribute(\"" + strName + "\").");
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
     * removes all events bound to this object; NOTE: The object must still be painted/repainted for its corresponding on-screen view to be likewise updated; returns a reference to self (this) to facilitate method chaining
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Painted removeAttributes()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttributes().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Painted> ctor = org.directwebremoting.proxy.jsx3.gui.Painted.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Painted.class.getName());
        }
    }

    
    
    /**
     * removes all events bound to this object; NOTE: The object must still be painted/repainted for its corresponding on-screen view to be likewise updated; returns a reference to self (this) to facilitate method chaining
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T removeAttributes(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttributes().");
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
     * Updates the view of this object by calling paint() and replacing the current view with the
returned HTML. This method has no effect if this object is not currently displayed.
     * @return the result of calling <code>paint()</code> or <code>null</code> if this object is not displayed.
     *
    @SuppressWarnings("unchecked")
    public String repaint(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets a property on the object that when the object is rendered on-screen, the HTML tag will be assigned the given name/value pair as a tag attribute
     * @param strName the name of the property/attribute
     * @param strValue the value for the property; may not contain double-quotes; escape via jsx3.util.strEscapeHTML if necessary or use combinations of single-quotes and escaped single-quotes
     * @return this object (this)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Painted setAttribute(String strName, String strValue)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setAttribute(\"" + strName + "\", \"" + strValue + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Painted> ctor = org.directwebremoting.proxy.jsx3.gui.Painted.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Painted.class.getName());
        }
    }

    
    
    /**
     * Sets a property on the object that when the object is rendered on-screen, the HTML tag will be assigned the given name/value pair as a tag attribute
     * @param strName the name of the property/attribute
     * @param strValue the value for the property; may not contain double-quotes; escape via jsx3.util.strEscapeHTML if necessary or use combinations of single-quotes and escaped single-quotes
     * @param type The expected return type
     * @return this object (this)
     */
    @SuppressWarnings("unchecked")
    public <T> T setAttribute(String strName, String strValue, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setAttribute(\"" + strName + "\", \"" + strValue + "\").");
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
     * assigns a dynamic property to one of this object's properties
           returns reference to self to facilitate method chaining;
     * @param strName property on this GUI object that will now use a dynamic property (e.g., 'jsxleft','jsxtop','jsxheight',etc.);
     * @param strValue name of a dynamic style, whose value will be used
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Painted setDynamicProperty(String strName, String strValue)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setDynamicProperty(\"" + strName + "\", \"" + strValue + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Painted> ctor = org.directwebremoting.proxy.jsx3.gui.Painted.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Painted.class.getName());
        }
    }

    
    
    /**
     * assigns a dynamic property to one of this object's properties
           returns reference to self to facilitate method chaining;
     * @param strName property on this GUI object that will now use a dynamic property (e.g., 'jsxleft','jsxtop','jsxheight',etc.);
     * @param strValue name of a dynamic style, whose value will be used
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setDynamicProperty(String strName, String strValue, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setDynamicProperty(\"" + strName + "\", \"" + strValue + "\").");
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
     * Appends a DOM node to this object after removing the node from its former parent reference. If the node to append
does not already have a DOM parent, setChild() should be used instead of this method.
     * @param objChild the child to adopt
     * @param bRepaint if <code>true</code> or <code>null</code>, the object being adopted will be added to
   the parent's view via the parent's <code>paintChild()</code> method.
   This parameter is made available for those situations where a loop is executing and multiple
   objects are being adopted.  As view operations are the most CPU intensive, passing <code>false</code>
   while looping through a collection of child objects to adopt will improve performance. After the
   last child is adopted, simply call <code>repaint()</code> on the parent to immediately synchronize the view.
     * @param bForce if true, the adoption is forced, even if the parent/child don't accept such adoptions (<code>onSetChild()</code> and <code>onSetParent()</code> will still be called)
     */
    public void adoptChild(org.directwebremoting.proxy.jsx3.app.Model objChild, boolean bRepaint, boolean bForce)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("adoptChild(")
              .appendData(objChild)
              .appendScript(",")
              
              .appendData(bRepaint)
              .appendScript(",")
              
              .appendData(bForce)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Creates and returns an exact replica of the object. The clone will be appended as a new child node of this
object's parent node.
     * @param intPersist the persistance value of the clone.
     * @param intMode <code>0</code> for insert as the last child of the parent of this object and paint,
    <code>1</code> for insert as the last child of this parent of this object and do not paint, or <code>2</code>
    for load as a fragment.
     * @return the clone.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model doClone(int intPersist, int intMode)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("doClone(\"" + intPersist + "\", \"" + intMode + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Creates and returns an exact replica of the object. The clone will be appended as a new child node of this
object's parent node.
     * @param intPersist the persistance value of the clone.
     * @param intMode <code>0</code> for insert as the last child of the parent of this object and paint,
    <code>1</code> for insert as the last child of this parent of this object and do not paint, or <code>2</code>
    for load as a fragment.
     * @param type The expected return type
     * @return the clone.
     */
    @SuppressWarnings("unchecked")
    public <T> T doClone(int intPersist, int intMode, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("doClone(\"" + intPersist + "\", \"" + intMode + "\").");
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
     * Returns the first ancestor passing the given test function.
     * @param fctTest test function, takes a single <code>jsx3.app.Model</code> parameter and returns
   <code>true</code> if the node matches.
     * @param bIncludeSelf if <code>true</code>, include this object in the search
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model findAncestor(org.directwebremoting.proxy.CodeBlock fctTest, boolean bIncludeSelf)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("findAncestor(\"" + fctTest + "\", \"" + bIncludeSelf + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the first ancestor passing the given test function.
     * @param fctTest test function, takes a single <code>jsx3.app.Model</code> parameter and returns
   <code>true</code> if the node matches.
     * @param bIncludeSelf if <code>true</code>, include this object in the search
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T findAncestor(org.directwebremoting.proxy.CodeBlock fctTest, boolean bIncludeSelf, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("findAncestor(\"" + fctTest + "\", \"" + bIncludeSelf + "\").");
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
     * Finds all DOM nodes descending from this DOM node that pass the given test function. Results are guaranteed to be
returned in order according to the search order used.
     * @param fctTest test function, takes a single <code>jsx3.app.Model</code> parameter and returns
   <code>true</code> if the node matches.
     * @param bDepthFirst specifies whether to do a depth first or breadth first search.
     * @param bMultiple if <code>true</code>, return an array of matches, otherwise just the first match.
     * @param bShallow if <code>true</code>, only search direct children.
     * @param bIncludeSelf if <code>true</code>, include this node in the search.
     * @return the match (bMultiple = false) or matches (bMultiple = true).
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model findDescendants(org.directwebremoting.proxy.CodeBlock fctTest, boolean bDepthFirst, boolean bMultiple, boolean bShallow, boolean bIncludeSelf)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("findDescendants(\"" + fctTest + "\", \"" + bDepthFirst + "\", \"" + bMultiple + "\", \"" + bShallow + "\", \"" + bIncludeSelf + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Finds all DOM nodes descending from this DOM node that pass the given test function. Results are guaranteed to be
returned in order according to the search order used.
     * @param fctTest test function, takes a single <code>jsx3.app.Model</code> parameter and returns
   <code>true</code> if the node matches.
     * @param bDepthFirst specifies whether to do a depth first or breadth first search.
     * @param bMultiple if <code>true</code>, return an array of matches, otherwise just the first match.
     * @param bShallow if <code>true</code>, only search direct children.
     * @param bIncludeSelf if <code>true</code>, include this node in the search.
     * @param type The expected return type
     * @return the match (bMultiple = false) or matches (bMultiple = true).
     */
    @SuppressWarnings("unchecked")
    public <T> T findDescendants(org.directwebremoting.proxy.CodeBlock fctTest, boolean bDepthFirst, boolean bMultiple, boolean bShallow, boolean bIncludeSelf, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("findDescendants(\"" + fctTest + "\", \"" + bDepthFirst + "\", \"" + bMultiple + "\", \"" + bShallow + "\", \"" + bIncludeSelf + "\").");
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
     * Returns the first ancestor with the given name.
     * @param strName the name to query on.
     * @return the first ancestor with the given name or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getAncestorOfName(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfName(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the first ancestor with the given name.
     * @param strName the name to query on.
     * @param type The expected return type
     * @return the first ancestor with the given name or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAncestorOfName(String strName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfName(\"" + strName + "\").");
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
     * Returns the first ancestor of the given type.
     * @param strType the fully-qualified class name, class constructor function,
   or <code>jsx3.Class</code> instance.
     * @return the first ancestor of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getAncestorOfType(String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfType(\"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the first ancestor of the given type.
     * @param strType the fully-qualified class name, class constructor function,
   or <code>jsx3.Class</code> instance.
     * @param type The expected return type
     * @return the first ancestor of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAncestorOfType(String strType, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfType(\"" + strType + "\").");
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
     * Returns the child DOM node of this node at the given index or with the given name. If a name is supplied, the
children are searched in order and the first matching child is returned.
     * @param vntIndexOrName either the integer index or the string name of the child.
     * @return the child at the given index or with the given name, or <code>null</code> if no such
    child exists.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getChild(int vntIndexOrName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChild(\"" + vntIndexOrName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the child DOM node of this node at the given index or with the given name. If a name is supplied, the
children are searched in order and the first matching child is returned.
     * @param vntIndexOrName either the integer index or the string name of the child.
     * @param type The expected return type
     * @return the child at the given index or with the given name, or <code>null</code> if no such
    child exists.
     */
    @SuppressWarnings("unchecked")
    public <T> T getChild(int vntIndexOrName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChild(\"" + vntIndexOrName + "\").");
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
     * Returns the zero-based index for this DOM node in relation to its siblings.
     * @return the index or <code>-1</code> if this object does not have a parent.
     *
    @SuppressWarnings("unchecked")
    public int getChildIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns an array containing all the child DOM nodes of this object. The return value is the original array rather
than a copy and should not be modified.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object[] getChildren(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Finds the first descendant of this DOM node with a the given name.
     * @param strName the name to query on.
     * @param bDepthFirst specifies whether to do a depth first or breadth first search.
     * @param bChildOnly if <code>true</code>, only search the children of this DOM node.
     * @return the descendant with the given name or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getDescendantOfName(String strName, boolean bDepthFirst, boolean bChildOnly)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDescendantOfName(\"" + strName + "\", \"" + bDepthFirst + "\", \"" + bChildOnly + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Finds the first descendant of this DOM node with a the given name.
     * @param strName the name to query on.
     * @param bDepthFirst specifies whether to do a depth first or breadth first search.
     * @param bChildOnly if <code>true</code>, only search the children of this DOM node.
     * @param type The expected return type
     * @return the descendant with the given name or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getDescendantOfName(String strName, boolean bDepthFirst, boolean bChildOnly, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDescendantOfName(\"" + strName + "\", \"" + bDepthFirst + "\", \"" + bChildOnly + "\").");
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
     * Finds all descendants of the given type.
     * @param strType the fully-qualified class name, class constructor function,
   or <code>jsx3.Class</code> instance.
     * @param bShallow if <code>true</code>, only search direct children, not all descendants.
     * @return an array of matching descendants
     *
    @SuppressWarnings("unchecked")
    public Object[] getDescendantsOfType(String strType, boolean bShallow, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the first child.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getFirstChild()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChild().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the first child.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChild(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChild().");
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
     * Finds the first child of the given type.
     * @param strType the fully-qualified class name, class constructor function,
   or <code>jsx3.Class</code> instance.
     * @param bExact if <code>true</code> then only return objects whose class is exactly <code>strType</code>
   (rather than returning subclasses too).
     * @return the child of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getFirstChildOfType(String strType, boolean bExact)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + strType + "\", \"" + bExact + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Finds the first child of the given type.
     * @param strType the fully-qualified class name, class constructor function,
   or <code>jsx3.Class</code> instance.
     * @param bExact if <code>true</code> then only return objects whose class is exactly <code>strType</code>
   (rather than returning subclasses too).
     * @param type The expected return type
     * @return the child of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChildOfType(String strType, boolean bExact, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + strType + "\", \"" + bExact + "\").");
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
     * Returns the help ID of this object.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getHelpId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the custom JSX-generated id for the object (i.e., _jsx2384098324509823049).
     * @return JSX id
     *
    @SuppressWarnings("unchecked")
    public String getId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the last child.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getLastChild()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLastChild().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the last child.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getLastChild(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLastChild().");
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
     * Returns the load type of this DOM node and the descending branch. The load type determines how this DOM branch
deserializes and paints in relation to its parent DOM node.
     * @return <code>LT_NORMAL</code>, <code>LT_SLEEP_PAINT</code>, <code>LT_SLEEP_DESER</code>,
   <code>LT_SLEEP_PD</code>, <code>LT_SHOW_PAINT</code>, or <code>LT_SHOW_DESER</code>.
     *
    @SuppressWarnings("unchecked")
    public int getLoadType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns one of the meta data values stored at the top of the serialization file that this object was loaded from.
     * @param strKey the name of the meta data field, one of the keys in <code>META_FIELDS</code>.
     * @return the meta data value or empty string.
     *
    @SuppressWarnings("unchecked")
    public String getMetaValue(String strKey, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the namespace that distinguishes this object's server (owner) from other server instances. The namespace
is set when this object is bound to a DOM tree.
     * @return the namespace of the server that owns this object instance.
     *
    @SuppressWarnings("unchecked")
    public String getNS(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the custom developer-defined name of this object.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the next sibling.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getNextSibling()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getNextSibling().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the next sibling.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getNextSibling(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getNextSibling().");
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
     * Returns the parent DOM node of this object.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getParent()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the parent DOM node of this object.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getParent(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
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
     * Returns the persistence bit for this model object.
     * @return one of <code>PERSISTNONE</code>, <code>PERSISTEMBED</code>, <code>PERSISTREF</code>,
   <code>PERSISTREFASYNC</code>.
     *
    @SuppressWarnings("unchecked")
    public int getPersistence(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the previous sibling.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getPreviousSibling()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPreviousSibling().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Returns the previous sibling.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getPreviousSibling(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPreviousSibling().");
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
     * Returns an object reference to the server that owns this object. This method returns null if this
object is part of a DOM fragment. Until an object is added to a DOM tree by passing it as the parameter to
setChild(), the object will be a DOM fragment.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Server getServer()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getServer().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Server> ctor = org.directwebremoting.proxy.jsx3.app.Server.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Server.class.getName());
        }
    }

    
    
    /**
     * Returns the URI resolver for this DOM node. This method returns the server of this object unless this node
or its ancestor was loaded into the DOM with an explicit URI resolver.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URIResolver getUriResolver()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getUriResolver().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URIResolver> ctor = org.directwebremoting.proxy.jsx3.net.URIResolver.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URIResolver.class.getName());
        }
    }

    
    
    /*
     * Assigns objMoveChild as the previousSibling of objPrecedeChild
     * @param objMoveChild the one being moved. Can belong to this object, another object, or can be a GUI fragment
     * @param objPrecedeChild the one to insert before
     * @param bRepaint if <code>false</code> the repaint will be suppressed (useful for multiple obejct updates
   that would lead to unnecessary updates to the VIEW)
     * @return true if successful
     *
    @SuppressWarnings("unchecked")
    public boolean insertBefore(org.directwebremoting.proxy.jsx3.app.Model objMoveChild, org.directwebremoting.proxy.jsx3.app.Model objPrecedeChild, boolean bRepaint, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
   This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
   added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
   relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     * @return the deserialized object. A serialization file may specify more than one root
   object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model load(String strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
   This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
   added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
   relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     * @param type The expected return type
     * @return the deserialized object. A serialization file may specify more than one root
   object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public <T> T load(String strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
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
     * Loads a component file and caches the document in an XML cache. If the component file already exists in the cache
then it is loaded from the cache. All component files loaded as a result of this call (referenced files) are also
cached. This method is a useful replacement for load() when the same URL will be loaded multiple
times in one application.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
   This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
   added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objCache the cache to store the component XML documents in. If not provided, the cache
   of the server of this model object is used.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
   relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     */
    public void loadAndCache(String strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.app.Cache objCache, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("loadAndCache(")
              .appendData(strURL)
              .appendScript(",")
              
              .appendData(bRepaint)
              .appendScript(",")
              
              .appendData(objCache)
              .appendScript(",")
              
              .appendData(objResolver)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strXML the XML content of a JSX serialization file.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
   added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver 
     * @return the deserialized object. A serialization file may specify more than one root
   object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model loadXML(String strXML, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadXML(\"" + strXML + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strXML the XML content of a JSX serialization file.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
   added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver 
     * @param type The expected return type
     * @return the deserialized object. A serialization file may specify more than one root
   object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public <T> T loadXML(String strXML, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadXML(\"" + strXML + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
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
     * Called during deserialization of this object. This method provides a hook for initializing
an object during deserialization since init() is not called. Called after this object has been instantiated and
after its fields and children have been assembled.This method is called before this object is attached to the
DOM, therefore getParent(), getServer(), getXML(), etc. return null.
     * @param objParent the parent of this object once it is attached to the DOM.
     * @param objServer the server that this DOM object will attach to.
     */
    public void onAfterAssemble(org.directwebremoting.proxy.jsx3.app.Model objParent, org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onAfterAssemble(")
              .appendData(objParent)
              .appendScript(",")
              
              .appendData(objServer)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Called during deserialization of this object. This method provides a hook for initializing
an object during deserialization since init() is not called. Called after this object has been
instantiated and after it has been attached to the DOM. Methods overriding this method should usually finish
with a call to jsxsuper().

When a new branch is attached to the DOM, this method is executed on each node in the branch. The order is
reverse-breadth-first meaning that child nodes are notified from oldest to youngest and before the parent node.

This implementation of this method executes the on-after-deserialize script of this object.
     */
    public void onAfterAttach()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onAfterAttach(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Called during deserialization of this object. This method provides a hook for initializing
an object during deserialization since init() is not called. Called after this object has been instantiated but
before its fields and children have been assembled. This method is called before this object is attached to the
DOM, therefore getParent(), getServer(), getXML(), etc. return null.
     * @param objParent the parent of this object once it is attached to the DOM.
     * @param objServer the server that this DOM object will attach to.
     */
    public void onBeforeAssemble(org.directwebremoting.proxy.jsx3.app.Model objParent, org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onBeforeAssemble(")
              .appendData(objParent)
              .appendScript(",")
              
              .appendData(objServer)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Called when the server owning this DOM node changes.
     * @param objNewServer 
     * @param objOldServer 
     */
    public void onChangeServer(org.directwebremoting.proxy.jsx3.app.Server objNewServer, org.directwebremoting.proxy.jsx3.app.Server objOldServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onChangeServer(")
              .appendData(objNewServer)
              .appendScript(",")
              
              .appendData(objOldServer)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * The finalizer method. This method provides a hook for subclasses of this class to perform custom logic
when an instance of this class is removed from the DOM. Methods that override this method should begin with
a call to jsxsuper().

Note that this method is called after this object has been removed from the DOM tree. Therefore
this.getParent() and this.getServer() will return null. Use the
objParent parameter for access to the DOM tree.
     * @param objParent reference to the former parent
     */
    public void onDestroy(org.directwebremoting.proxy.jsx3.app.Model objParent)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onDestroy(")
              .appendData(objParent)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Hook that notifies this model object that one of its children has been removed. This hook exists simply to allow
this object to perform cleanup/re-render, and does not provide a veto mechanism. This method is called after
the child has been removed from the model (this.getChildren() does not contain objChild)
and after the child has been removed from the view (objChild.getRendered() is also null).

This method is only called if the child is being removed from the DOM but this object (the parent) is not
being removed. Therefore, this hook cannot be relied upon for garbage collection.

If removeChildren() is called on this object, this hook is called exactly once after all children
have been removed. In that case, the first parameter to this method will be the array of children and the
second parameter will be null.

In general a method overriding this method should begin by calling jsxsuper.
     * @param objChild the child that was removed
     * @param intIndex the index of the removed child
     */
    public void onRemoveChild(org.directwebremoting.proxy.jsx3.app.Model objChild, int intIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onRemoveChild(")
              .appendData(objChild)
              .appendScript(",")
              
              .appendData(intIndex)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Hook that allows for a prospective parent DOM node to veto the adoption of a child.
     * @param objChild 
     * @return true to allow the set, false to veto
     *
    @SuppressWarnings("unchecked")
    public boolean onSetChild(Object objChild, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Hook that allows for a prospective child DOM node to veto its adoption by a parent. This method is only called if
the prospective parent has not already vetoed the adoption in the onSetChild() method.
     * @param objParent 
     * @return true to allow the set, false to veto
     *
    @SuppressWarnings("unchecked")
    public boolean onSetParent(Object objParent, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Removes a DOM child from this object. This method removes the on-screen DHTML of the removed object. The removed
child will be completely derefenced from the DOM and will be prepped for garbage collection. If a DOM child must
continue to exist after removing it from this parent, adoptChild() should be used instead of this
method.
     * @param vntItem either the index of the child to remove or the child itself.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model removeChild(int vntItem)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChild(\"" + vntItem + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Removes a DOM child from this object. This method removes the on-screen DHTML of the removed object. The removed
child will be completely derefenced from the DOM and will be prepped for garbage collection. If a DOM child must
continue to exist after removing it from this parent, adoptChild() should be used instead of this
method.
     * @param vntItem either the index of the child to remove or the child itself.
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T removeChild(int vntItem, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChild(\"" + vntItem + "\").");
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
     * Removes some or all children of this object.
     * @param arrChildren the children to remove. If this parameter is not provided then all
  children are removed.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model removeChildren(Object[] arrChildren)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChildren(\"" + arrChildren + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Removes some or all children of this object.
     * @param arrChildren the children to remove. If this parameter is not provided then all
  children are removed.
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T removeChildren(Object[] arrChildren, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChildren(\"" + arrChildren + "\").");
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
     * Appends a child DOM node to this parent DOM node. If the child already has a parent, adoptChild()
should be used instead to ensure that the child is removed from its current parent.
     * @param objChild the root node of a DOM fragment.
     * @param intPersist defines how the child will be persisted/serialized. The valid values are the four
   persistence values defined as static fields in this class.
     * @param strSourceURL the path to the serialization file where the child exists. This parameter is only
   relevant if the given <code>intPersist</code> is <code>PERSISTREF</code> or <code>PERSISTREFASYNC</code>.
     * @param strNS the namespace of the child to append. This parameter is normally not required but is useful
   when sharing DOM nodes between servers with different namespaces.
     * @return this object or <code>false</code> if the set was vetoed
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model setChild(org.directwebremoting.proxy.jsx3.app.Model objChild, int intPersist, String strSourceURL, String strNS)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setChild(\"" + objChild + "\", \"" + intPersist + "\", \"" + strSourceURL + "\", \"" + strNS + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Appends a child DOM node to this parent DOM node. If the child already has a parent, adoptChild()
should be used instead to ensure that the child is removed from its current parent.
     * @param objChild the root node of a DOM fragment.
     * @param intPersist defines how the child will be persisted/serialized. The valid values are the four
   persistence values defined as static fields in this class.
     * @param strSourceURL the path to the serialization file where the child exists. This parameter is only
   relevant if the given <code>intPersist</code> is <code>PERSISTREF</code> or <code>PERSISTREFASYNC</code>.
     * @param strNS the namespace of the child to append. This parameter is normally not required but is useful
   when sharing DOM nodes between servers with different namespaces.
     * @param type The expected return type
     * @return this object or <code>false</code> if the set was vetoed
     */
    @SuppressWarnings("unchecked")
    public <T> T setChild(org.directwebremoting.proxy.jsx3.app.Model objChild, int intPersist, String strSourceURL, String strNS, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setChild(\"" + objChild + "\", \"" + intPersist + "\", \"" + strSourceURL + "\", \"" + strNS + "\").");
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
     * Sets the help ID of this object.
     * @param strId 
     */
    public void setHelpId(String strId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setHelpId(")
              .appendData(strId)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the load type of this DOM node and the descending branch.
     * @param intLoadType <code>LT_NORMAL</code>, <code>LT_SLEEP_PAINT</code>, <code>LT_SLEEP_DESER</code>,
   <code>LT_SLEEP_PD</code>, <code>LT_SHOW_PAINT</code>, or <code>LT_SHOW_DESER</code>.
     */
    public void setLoadType(int intLoadType)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setLoadType(")
              .appendData(intLoadType)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * setS one of the meta data values stored at the top of a component's serialization file.
     * @param strKey the name of the meta data field, one of the keys in <code>META_FIELDS</code>
     * @param strValue the new value of the meta data field.
     */
    public void setMetaValue(String strKey, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setMetaValue(")
              .appendData(strKey)
              .appendScript(",")
              
              .appendData(strValue)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the custom developer-defined name of this object.
     * @param strName a name unique among all DOM nodes currently loaded in the application.
     */
    public void setName(String strName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setName(")
              .appendData(strName)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the persistence bit for this model object.
     * @param intPersist one of <code>PERSISTNONE</code>, <code>PERSISTEMBED</code>, <code>PERSISTREF</code>,
   <code>PERSISTREFASYNC</code>.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model setPersistence(int intPersist)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setPersistence(\"" + intPersist + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    
    
    /**
     * Sets the persistence bit for this model object.
     * @param intPersist one of <code>PERSISTNONE</code>, <code>PERSISTEMBED</code>, <code>PERSISTREF</code>,
   <code>PERSISTREFASYNC</code>.
     * @param type The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setPersistence(int intPersist, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setPersistence(\"" + intPersist + "\").");
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
     * Returns a string representation of this object.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String toString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns this object serialized as XML by calling toString() on the result of toXMLDoc()
called on this object.
     * @param objProperties name-value pairs that affect the serialization. See
  <code>toXMLDoc()</code> for a description.
     * @return this object serialized as an XML string.
     *
    @SuppressWarnings("unchecked")
    public String toXML(Object objProperties, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Serializes this object as an XML document.

The objProperties parameter may include the following keys:

  onafter {String} - the value of the onAfterDeserialize element
  onbefore {String} - the value of the onBeforeDeserialize element
  name {String} - the value of the name element
  icon {String} - the value of the icon element
  description {String} - the value of the description element
  children {boolean} - if true the children of this object, rather than this object, are
         serialized
  persistall {boolean} - if true all descendants with persistence PERSISTNONE are included in the
         serialization
     * @param objProperties name-value pairs that affect the serialization. See above for
  valid names and how they affect serialization.
     * @return this object serialized as an XML document.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document toXMLDoc(Object objProperties)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("toXMLDoc(\"" + objProperties + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Document> ctor = org.directwebremoting.proxy.jsx3.xml.Document.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Document.class.getName());
        }
    }

    
    
    /**
     * Serializes this object as an XML document.

The objProperties parameter may include the following keys:

  onafter {String} - the value of the onAfterDeserialize element
  onbefore {String} - the value of the onBeforeDeserialize element
  name {String} - the value of the name element
  icon {String} - the value of the icon element
  description {String} - the value of the description element
  children {boolean} - if true the children of this object, rather than this object, are
         serialized
  persistall {boolean} - if true all descendants with persistence PERSISTNONE are included in the
         serialization
     * @param objProperties name-value pairs that affect the serialization. See above for
  valid names and how they affect serialization.
     * @param type The expected return type
     * @return this object serialized as an XML document.
     */
    @SuppressWarnings("unchecked")
    public <T> T toXMLDoc(Object objProperties, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("toXMLDoc(\"" + objProperties + "\").");
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
     * Publishes an event to all subscribed objects.
     * @param objEvent the event, should have at least a field 'subject' that is the event id, another common field is 'target' (target will default to this instance)
     * @return the number of listeners to which the event was broadcast
     *
    @SuppressWarnings("unchecked")
    public int publish(Object objEvent, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Subscribes an object or function to a type of event published by this object.

As of version 3.4 a string value for objHandler is deprecated.
     * @param strEventId the event type(s).
     * @param objHandler if an object, the instance to notify of events (objFunction is required); if a string, the JSX id of the instance to notify of events (objFunction is required), must exist in the same Server; if a function, the function to call to notify of events (objFunction ignored)
     * @param objFunction if objHandler is a string or object then the function to call on that instance. either a function or a string that is the name of a method of the instance
     */
    public void subscribe(String strEventId, Object objHandler, org.directwebremoting.proxy.CodeBlock objFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("subscribe(")
              .appendData(strEventId)
              .appendScript(",")
              
              .appendData(objHandler)
              .appendScript(",")
              
              .appendData(objFunction)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Unsubscribe an object or function from an event published by this object.

As of version 3.4 a string value for objHandler is deprecated.
     * @param strEventId the event type(s).
     * @param objHandler the value of objHandler passed to subscribe
     */
    public void unsubscribe(String strEventId, Object objHandler)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("unsubscribe(")
              .appendData(strEventId)
              .appendScript(",")
              
              .appendData(objHandler)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Unsubscribes all subscribed objects to a type of event published by this object.
     * @param strEventId the event type
     */
    public void unsubscribeAll(String strEventId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("unsubscribeAll(")
              .appendData(strEventId)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
 }
