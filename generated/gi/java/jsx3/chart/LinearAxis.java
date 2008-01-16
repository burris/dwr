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
package jsx3.chart;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * Type of axis that displays a linear range of values.
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class LinearAxis extends jsx3.chart.Axis
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public LinearAxis(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param horizontal whether this axis is horizontal (x), otherwise it's vertical (y)
     * @param primary whether this axis is primary, otherwise it's secondary
     */
    public LinearAxis(String name, boolean horizontal, boolean primary)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new LinearAxis", name, horizontal, primary);
        setInitScript(script);
    }


    /**
     * The minimum number of intervals to show when calculating by auto adjust.
     */
    public static final int MIN_INTERVALS = 5;

    /**
     * The maximum number of intervals to show when calculating by auto adjust.
     */
    public static final int MAX_INTERVALS = 11;


    /**
     * Returns the autoAdjust field, whether to adjust the max/min/interval to the range of the data.
     * @param callback autoAdjust
     */
    @SuppressWarnings("unchecked")
    public void getAutoAdjust(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAutoAdjust");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the autoAdjust field.
     * @param autoAdjust the new value for autoAdjust
     */
    public void setAutoAdjust(boolean autoAdjust)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setAutoAdjust", autoAdjust);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the baseAtZero field, whether to set either the min or max value of this axis to 0 if applicable and if autoAdjust is true.
     * @param callback baseAtZero
     */
    @SuppressWarnings("unchecked")
    public void getBaseAtZero(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getBaseAtZero");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the baseAtZero field.
     * @param baseAtZero the new value for baseAtZero
     */
    public void setBaseAtZero(boolean baseAtZero)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setBaseAtZero", baseAtZero);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the min field, the minimum value displayed by this axis, overrides autoAdjust.
     * @param callback min
     */
    @SuppressWarnings("unchecked")
    public void getMin(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMin");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the min field.
     * @param min the new value for min
     */
    public void setMin(int min)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMin", min);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the max field, the maximum value displayed by this axis, overrides autoAdjust.
     * @param callback max
     */
    @SuppressWarnings("unchecked")
    public void getMax(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMax");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the max field.
     * @param max the new value for max
     */
    public void setMax(int max)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMax", max);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the interval field, the interval between major ticks, overrides autoAdjust.
     * @param callback interval
     */
    @SuppressWarnings("unchecked")
    public void getInterval(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getInterval");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the interval field.
     * @param interval the new value for interval
     */
    public void setInterval(int interval)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setInterval", interval);
        getScriptProxy().addScript(script);
    }

    /**
     * convert a number value to a coordinate between 0 and this.length, if the value is outside of the range of the axis, return the closest value in the range
     * @param value a value displayed along the axis
     * @param callback coordinate along the axis
     */
    @SuppressWarnings("unchecked")
    public void getCoordinateFor(Integer value, Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getCoordinateFor", value);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * same as getCoordinateFor(), but does not clip to bounds of the axis
     * @param value 
     */
    public void getCoordinateForNoClip(int value)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("getCoordinateForNoClip", value);
        getScriptProxy().addScript(script);
    }

}

