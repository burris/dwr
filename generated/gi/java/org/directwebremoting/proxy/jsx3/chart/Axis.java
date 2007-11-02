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
public class Axis extends org.directwebremoting.proxy.jsx3.chart.ChartComponent
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Axis(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param horizontal whether this axis is horizontal (x), otherwise it's vertical (y)
     * @param primary whether this axis is primary, otherwise it's secondary
     */
    public Axis(String name, boolean horizontal, boolean primary)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String TICK_INSIDE = "inside";

    /**
     * 
     */
    public static final String TICK_OUTSIDE = "outside";

    /**
     * 
     */
    public static final String TICK_CROSS = "cross";

    /**
     * 
     */
    public static final String TICK_NONE = "none";

    /**
     * 
     */
    public static final String LABEL_HIGH = "high";

    /**
     * 
     */
    public static final String LABEL_LOW = "low";

    /**
     * 
     */
    public static final String LABEL_AXIS = "axis";

    /*
     * formats labels as a percent, ie "50%"
     * @param v 
     *
    @SuppressWarnings("unchecked")
    public String percent(int v, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * formats labels in scientific notation, ie "5e2"
     * @param v 
     * @param signif 
     *
    @SuppressWarnings("unchecked")
    public String scientific(int v, int signif, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the horizontal field, whether this is an x axis, otherwise it is a y axis.
     * @return horizontal
     *
    @SuppressWarnings("unchecked")
    public boolean getHorizontal(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the horizontal field.
     * @param horizontal the new value for horizontal
     */
    public void setHorizontal(boolean horizontal)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHorizontal(").appendData(horizontal).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the showAxis field, whether to show the line along the axis.
     * @return showAxis
     *
    @SuppressWarnings("unchecked")
    public boolean getShowAxis(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the showAxis field.
     * @param showAxis the new value for showAxis
     */
    public void setShowAxis(boolean showAxis)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setShowAxis(").appendData(showAxis).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelFunction field.
     * @return labelFunction
     *
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.CodeBlock getLabelFunction(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelFunction field, allows for formatting and transformation of a major tick label; should eval to a function with the signature function(object) : string.
     * @param labelFunction the new value for labelFunction
     */
    public void setLabelFunction(String labelFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelFunction(").appendData(labelFunction).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the axisStroke field, string representation of the VectorStroke used to draw the line of the axis.
     * @return axisStroke
     *
    @SuppressWarnings("unchecked")
    public String getAxisStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the axisStroke field.
     * @param axisStroke the new value for axisStroke
     */
    public void setAxisStroke(String axisStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAxisStroke(").appendData(axisStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the showLabels field, whether to show major tick labels.
     * @return showLabels
     *
    @SuppressWarnings("unchecked")
    public boolean getShowLabels(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the showLabels field.
     * @param showLabels the new value for showLabels
     */
    public void setShowLabels(boolean showLabels)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setShowLabels(").appendData(showLabels).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelGap field, the pixel gap between the tick lines and the labels.
     * @return labelGap
     *
    @SuppressWarnings("unchecked")
    public int getLabelGap(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelGap field.
     * @param labelGap the new value for labelGap
     */
    public void setLabelGap(int labelGap)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelGap(").appendData(labelGap).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelPlacement field, checks for invalid values.
     * @param labelPlacement the new value for labelPlacement, one of {'axis','high','low'}
     */
    public void setLabelPlacement(String labelPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelPlacement(").appendData(labelPlacement).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the tickLength field, the length in pixels of the major tick (if tickPlacement is "cross" the length will actually be twice this.
     * @return tickLength
     *
    @SuppressWarnings("unchecked")
    public int getTickLength(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the tickLength field.
     * @param tickLength the new value for tickLength
     */
    public void setTickLength(int tickLength)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTickLength(").appendData(tickLength).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the tickPlacement field, where to place the major ticks.
     * @return tickPlacement, one of {'none','inside','outside','cross'}
     *
    @SuppressWarnings("unchecked")
    public String getTickPlacement(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the tickPlacement field.
     * @param tickPlacement the new value for tickPlacement, one of {'none','inside','outside','cross'}
     */
    public void setTickPlacement(String tickPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTickPlacement(").appendData(tickPlacement).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the tickStroke field, string representation of VectorStroke used to draw major ticks.
     * @return tickStroke
     *
    @SuppressWarnings("unchecked")
    public String getTickStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the tickStroke field.
     * @param tickStroke the new value for tickStroke
     */
    public void setTickStroke(String tickStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTickStroke(").appendData(tickStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minorTickDivisions field, number of minor tick divisions between major ticks; the number of minor ticks drawn will be this number minus 1.
     * @return minorTickDivisions
     *
    @SuppressWarnings("unchecked")
    public int getMinorTickDivisions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minorTickDivisions field.
     * @param minorTickDivisions the new value for minorTickDivisions
     */
    public void setMinorTickDivisions(int minorTickDivisions)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinorTickDivisions(").appendData(minorTickDivisions).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minorTickLength field, the length in pixels of the minor tick (if tickPlacement is "cross" the length will actually be twice this.
     * @return minorTickLength
     *
    @SuppressWarnings("unchecked")
    public int getMinorTickLength(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minorTickLength field.
     * @param minorTickLength the new value for minorTickLength
     */
    public void setMinorTickLength(int minorTickLength)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinorTickLength(").appendData(minorTickLength).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minorTickPlacement field, where to place the minor ticks.
     * @return minorTickPlacement, one of {'none','inside','outside','cross'}
     *
    @SuppressWarnings("unchecked")
    public String getMinorTickPlacement(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minorTickPlacement field.
     * @param minorTickPlacement the new value for minorTickPlacement, one of {'none','inside','outside','cross'}
     */
    public void setMinorTickPlacement(String minorTickPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinorTickPlacement(").appendData(minorTickPlacement).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minorTickStroke field, string representation of VectorStroke used to draw minor ticks.
     * @return minorTickStroke
     *
    @SuppressWarnings("unchecked")
    public String getMinorTickStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minorTickStroke field.
     * @param minorTickStroke the new value for minorTickStroke
     */
    public void setMinorTickStroke(String minorTickStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinorTickStroke(").appendData(minorTickStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelClass field, the CSS class used to render major tick labels.
     * @return labelClass
     *
    @SuppressWarnings("unchecked")
    public String getLabelClass(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelClass field.
     * @param labelClass the new value for labelClass
     */
    public void setLabelClass(String labelClass)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelClass(").appendData(labelClass).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelStyle field, the CSS style attribute used to render major tick labels.
     * @return labelStyle
     *
    @SuppressWarnings("unchecked")
    public String getLabelStyle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelStyle field.
     * @param labelStyle the new value for labelStyle
     */
    public void setLabelStyle(String labelStyle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelStyle(").appendData(labelStyle).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelColor field, the RGB color value of the label font; note that this is the only way to set the color of the text, using a CSS style attribute will have no effect.
     * @return labelColor
     *
    @SuppressWarnings("unchecked")
    public String getLabelColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelColor field.
     * @param labelColor the new value for labelColor
     */
    public void setLabelColor(String labelColor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelColor(").appendData(labelColor).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelColor field.
     * @param labelColor the new value for labelColor
     */
    public void setLabelColor(int labelColor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelColor(").appendData(labelColor).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the display width, the maximum amount of space perpendicular to the axis and outside of the data area that the ticks and labels may occupy (doesn't include area given to axis title).
     * @return displayWidth
     *
    @SuppressWarnings("unchecked")
    public int getDisplayWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the displayWidth field.
     * @param displayWidth the new value for displayWidth
     */
    public void setDisplayWidth(int displayWidth)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDisplayWidth(").appendData(displayWidth).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the optional jsx3.chart.ChartLabel child.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.ChartLabel getAxisTitle()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAxisTitle().");
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

    /**
     * Returns the opposing axis.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.Axis getOpposingAxis()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOpposingAxis().");
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
     * Returns the opposing axis.
     */
    @SuppressWarnings("unchecked")
    public <T> T getOpposingAxis(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOpposingAxis().");
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
