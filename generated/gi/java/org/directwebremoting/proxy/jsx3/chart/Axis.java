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
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Axis extends org.directwebremoting.proxy.jsx3.chart.ChartComponent
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Axis(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param horizontal whether this axis is horizontal (x), otherwise it's vertical (y)
     * @param primary whether this axis is primary, otherwise it's secondary
     */
    public Axis(String name, boolean horizontal, boolean primary)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Axis", name, horizontal, primary);
        setInitScript(script);
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

    /**
     * formats labels as a percent, ie "50%"
     * @param v 
     */
    @SuppressWarnings("unchecked")
    public void percent(int v, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = percent", v);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * formats labels in scientific notation, ie "5e2"
     * @param v 
     * @param signif 
     */
    @SuppressWarnings("unchecked")
    public void scientific(int v, int signif, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = scientific", v, signif);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the horizontal field, whether this is an x axis, otherwise it is a y axis.
     * @param callback horizontal
     */
    @SuppressWarnings("unchecked")
    public void getHorizontal(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getHorizontal");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the horizontal field.
     * @param horizontal the new value for horizontal
     */
    public void setHorizontal(boolean horizontal)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setHorizontal", horizontal);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the showAxis field, whether to show the line along the axis.
     * @param callback showAxis
     */
    @SuppressWarnings("unchecked")
    public void getShowAxis(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getShowAxis");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the showAxis field.
     * @param showAxis the new value for showAxis
     */
    public void setShowAxis(boolean showAxis)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setShowAxis", showAxis);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelFunction field.
     * @param callback labelFunction
     */
    @SuppressWarnings("unchecked")
    public void getLabelFunction(Callback<org.directwebremoting.proxy.CodeBlock> callback)
    {
        String key = CallbackHelper.saveCallback(callback, org.directwebremoting.proxy.CodeBlock.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelFunction");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelFunction field, allows for formatting and transformation of a major tick label; should eval to a function with the signature function(object) : string.
     * @param labelFunction the new value for labelFunction
     */
    public void setLabelFunction(String labelFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelFunction", labelFunction);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the axisStroke field, string representation of the VectorStroke used to draw the line of the axis.
     * @param callback axisStroke
     */
    @SuppressWarnings("unchecked")
    public void getAxisStroke(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAxisStroke");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the axisStroke field.
     * @param axisStroke the new value for axisStroke
     */
    public void setAxisStroke(String axisStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setAxisStroke", axisStroke);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the showLabels field, whether to show major tick labels.
     * @param callback showLabels
     */
    @SuppressWarnings("unchecked")
    public void getShowLabels(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getShowLabels");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the showLabels field.
     * @param showLabels the new value for showLabels
     */
    public void setShowLabels(boolean showLabels)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setShowLabels", showLabels);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelGap field, the pixel gap between the tick lines and the labels.
     * @param callback labelGap
     */
    @SuppressWarnings("unchecked")
    public void getLabelGap(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelGap");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelGap field.
     * @param labelGap the new value for labelGap
     */
    public void setLabelGap(int labelGap)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelGap", labelGap);
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelPlacement field, checks for invalid values.
     * @param labelPlacement the new value for labelPlacement, one of {'axis','high','low'}
     */
    public void setLabelPlacement(String labelPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelPlacement", labelPlacement);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the tickLength field, the length in pixels of the major tick (if tickPlacement is "cross" the length will actually be twice this.
     * @param callback tickLength
     */
    @SuppressWarnings("unchecked")
    public void getTickLength(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTickLength");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the tickLength field.
     * @param tickLength the new value for tickLength
     */
    public void setTickLength(int tickLength)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setTickLength", tickLength);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the tickPlacement field, where to place the major ticks.
     * @param callback tickPlacement, one of {'none','inside','outside','cross'}
     */
    @SuppressWarnings("unchecked")
    public void getTickPlacement(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTickPlacement");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the tickPlacement field.
     * @param tickPlacement the new value for tickPlacement, one of {'none','inside','outside','cross'}
     */
    public void setTickPlacement(String tickPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setTickPlacement", tickPlacement);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the tickStroke field, string representation of VectorStroke used to draw major ticks.
     * @param callback tickStroke
     */
    @SuppressWarnings("unchecked")
    public void getTickStroke(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTickStroke");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the tickStroke field.
     * @param tickStroke the new value for tickStroke
     */
    public void setTickStroke(String tickStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setTickStroke", tickStroke);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the minorTickDivisions field, number of minor tick divisions between major ticks; the number of minor ticks drawn will be this number minus 1.
     * @param callback minorTickDivisions
     */
    @SuppressWarnings("unchecked")
    public void getMinorTickDivisions(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMinorTickDivisions");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the minorTickDivisions field.
     * @param minorTickDivisions the new value for minorTickDivisions
     */
    public void setMinorTickDivisions(int minorTickDivisions)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMinorTickDivisions", minorTickDivisions);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the minorTickLength field, the length in pixels of the minor tick (if tickPlacement is "cross" the length will actually be twice this.
     * @param callback minorTickLength
     */
    @SuppressWarnings("unchecked")
    public void getMinorTickLength(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMinorTickLength");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the minorTickLength field.
     * @param minorTickLength the new value for minorTickLength
     */
    public void setMinorTickLength(int minorTickLength)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMinorTickLength", minorTickLength);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the minorTickPlacement field, where to place the minor ticks.
     * @param callback minorTickPlacement, one of {'none','inside','outside','cross'}
     */
    @SuppressWarnings("unchecked")
    public void getMinorTickPlacement(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMinorTickPlacement");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the minorTickPlacement field.
     * @param minorTickPlacement the new value for minorTickPlacement, one of {'none','inside','outside','cross'}
     */
    public void setMinorTickPlacement(String minorTickPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMinorTickPlacement", minorTickPlacement);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the minorTickStroke field, string representation of VectorStroke used to draw minor ticks.
     * @param callback minorTickStroke
     */
    @SuppressWarnings("unchecked")
    public void getMinorTickStroke(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMinorTickStroke");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the minorTickStroke field.
     * @param minorTickStroke the new value for minorTickStroke
     */
    public void setMinorTickStroke(String minorTickStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMinorTickStroke", minorTickStroke);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelClass field, the CSS class used to render major tick labels.
     * @param callback labelClass
     */
    @SuppressWarnings("unchecked")
    public void getLabelClass(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelClass");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelClass field.
     * @param labelClass the new value for labelClass
     */
    public void setLabelClass(String labelClass)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelClass", labelClass);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelStyle field, the CSS style attribute used to render major tick labels.
     * @param callback labelStyle
     */
    @SuppressWarnings("unchecked")
    public void getLabelStyle(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelStyle");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelStyle field.
     * @param labelStyle the new value for labelStyle
     */
    public void setLabelStyle(String labelStyle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelStyle", labelStyle);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelColor field, the RGB color value of the label font; note that this is the only way to set the color of the text, using a CSS style attribute will have no effect.
     * @param callback labelColor
     */
    @SuppressWarnings("unchecked")
    public void getLabelColor(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelColor");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelColor field.
     * @param labelColor the new value for labelColor
     */
    public void setLabelColor(String labelColor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelColor", labelColor);
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelColor field.
     * @param labelColor the new value for labelColor
     */
    public void setLabelColor(int labelColor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelColor", labelColor);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the display width, the maximum amount of space perpendicular to the axis and outside of the data area that the ticks and labels may occupy (doesn't include area given to axis title).
     * @param callback displayWidth
     */
    @SuppressWarnings("unchecked")
    public void getDisplayWidth(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDisplayWidth");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the displayWidth field.
     * @param displayWidth the new value for displayWidth
     */
    public void setDisplayWidth(int displayWidth)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setDisplayWidth", displayWidth);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the optional jsx3.chart.ChartLabel child.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.ChartLabel getAxisTitle()
    {
        String extension = "getAxisTitle().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.ChartLabel> ctor = org.directwebremoting.proxy.jsx3.chart.ChartLabel.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "getOpposingAxis().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.Axis> ctor = org.directwebremoting.proxy.jsx3.chart.Axis.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.Axis.class.getName());
        }
    }

    /**
     * Returns the opposing axis.
     * @param returnType The expected return type
     */
    @SuppressWarnings("unchecked")
    public <T> T getOpposingAxis(Class<T> returnType)
    {
        String extension = "getOpposingAxis().";
        try
        {
            Constructor<T> ctor = returnType.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

}
