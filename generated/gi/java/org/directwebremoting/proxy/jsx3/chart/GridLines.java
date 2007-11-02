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
public class GridLines extends org.directwebremoting.proxy.jsx3.chart.ChartComponent
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public GridLines(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param left left position (in pixels) of the object relative to its parent container
     * @param top top position (in pixels) of the object relative to its parent container
     * @param width width (in pixels) of the chart
     * @param height height (in pixels) of the chart
     */
    public GridLines(String name, int left, int top, int width, int height)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the horizontalAbove field, whether to draw the horizontal lines and fills above the vertical ones.
     * @return horizontalAbove
     *
    @SuppressWarnings("unchecked")
    public boolean getHorizontalAbove(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the horizontalAbove field.
     * @param horizontalAbove the new value for horizontalAbove
     */
    public void setHorizontalAbove(boolean horizontalAbove)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHorizontalAbove(").appendData(horizontalAbove).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the inForeground field, whether to draw this legend on top of the data series (or below).
     * @return inForeground
     *
    @SuppressWarnings("unchecked")
    public boolean getInForeground(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the inForeground field.
     * @param inForeground the new value for inForeground
     */
    public void setInForeground(boolean inForeground)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setInForeground(").appendData(inForeground).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the borderStroke field, string representation of the stroke used to outline the grid lines.
     * @return borderStroke
     *
    @SuppressWarnings("unchecked")
    public String getBorderStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the borderStroke field.
     * @param borderStroke the new value for borderStroke
     */
    public void setBorderStroke(String borderStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBorderStroke(").appendData(borderStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the fillV field, array of string representations of vector fills used to fill in areas between vertical major ticks; if the length of the array is greater than one, the areas alternate through the list of fills.
     * @return fillV
     *
    @SuppressWarnings("unchecked")
    public Object[] getFillV(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the fillV field.
     * @param fillV the new value for fillV
     */
    public void setFillV(Object[] fillV)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFillV(").appendData(fillV).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the strokeMajorV field, array of string representations of VectorStroke's used to draw the vertical major ticks; if the length of the array is greater than one, the ticks alternate through the list of strokes.
     * @return strokeMajorV
     *
    @SuppressWarnings("unchecked")
    public Object[] getStrokeMajorV(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the strokeMajorV field.
     * @param strokeMajorV the new value for strokeMajorV
     */
    public void setStrokeMajorV(Object[] strokeMajorV)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStrokeMajorV(").appendData(strokeMajorV).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the strokeMinorV field, array of string representations of VectorStroke's used to draw the vertical minor ticks; if the length of the array is greater than one, the ticks alternate through the list of strokes.
     * @return strokeMinorV
     *
    @SuppressWarnings("unchecked")
    public Object[] getStrokeMinorV(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the strokeMinorV field.
     * @param strokeMinorV the new value for strokeMinorV
     */
    public void setStrokeMinorV(Object[] strokeMinorV)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStrokeMinorV(").appendData(strokeMinorV).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the fillH field, array of string representations of vector fills used to fill in areas between horizontal major ticks; if the length of the array is greater than one, the areas alternate through the list of fills.
     * @return fillH
     *
    @SuppressWarnings("unchecked")
    public Object[] getFillH(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the fillH field.
     * @param fillH the new value for fillH
     */
    public void setFillH(Object[] fillH)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFillH(").appendData(fillH).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the strokeMajorH field, array of string representations of VectorStroke's used to draw the horizontal major ticks; if the length of the array is greater than one, the ticks alternate through the list of strokes.
     * @return strokeMajorH
     *
    @SuppressWarnings("unchecked")
    public Object[] getStrokeMajorH(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the strokeMajorH field.
     * @param strokeMajorH the new value for strokeMajorH
     */
    public void setStrokeMajorH(Object[] strokeMajorH)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStrokeMajorH(").appendData(strokeMajorH).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the strokeMinorH field, array of string representations of VectorStroke's used to draw the horizontal minor ticks; if the length of the array is greater than one, the ticks alternate through the list of strokes.
     * @return strokeMinorH
     *
    @SuppressWarnings("unchecked")
    public Object[] getStrokeMinorH(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the strokeMinorH field.
     * @param strokeMinorH the new value for strokeMinorH
     */
    public void setStrokeMinorH(Object[] strokeMinorH)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStrokeMinorH(").appendData(strokeMinorH).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the x (horizontal) axis used to determine where to draw tick lines.
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
     * Returns the x (horizontal) axis used to determine where to draw tick lines.
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
     * Returns the y (vertical) axis used to determine where to draw tick lines.
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
     * Returns the y (vertical) axis used to determine where to draw tick lines.
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

}
