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
public class LinearAxis extends org.directwebremoting.proxy.jsx3.chart.Axis
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public LinearAxis(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param horizontal whether this axis is horizontal (x), otherwise it's vertical (y)
     * @param primary whether this axis is primary, otherwise it's secondary
     */
    public LinearAxis(String name, boolean horizontal, boolean primary)
    {
        super((ProxyHelper) null);
    }

    /**
     * The minimum number of intervals to show when calculating by auto adjust.
     */
    public static final int MIN_INTERVALS = 5;

    /**
     * The maximum number of intervals to show when calculating by auto adjust.
     */
    public static final int MAX_INTERVALS = 11;

    /*
     * Returns the autoAdjust field, whether to adjust the max/min/interval to the range of the data.
     * @return autoAdjust
     *
    @SuppressWarnings("unchecked")
    public boolean getAutoAdjust(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the autoAdjust field.
     * @param autoAdjust the new value for autoAdjust
     */
    public void setAutoAdjust(boolean autoAdjust)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAutoAdjust(").appendData(autoAdjust).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the baseAtZero field, whether to set either the min or max value of this axis to 0 if applicable and if autoAdjust is true.
     * @return baseAtZero
     *
    @SuppressWarnings("unchecked")
    public boolean getBaseAtZero(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the baseAtZero field.
     * @param baseAtZero the new value for baseAtZero
     */
    public void setBaseAtZero(boolean baseAtZero)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBaseAtZero(").appendData(baseAtZero).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the min field, the minimum value displayed by this axis, overrides autoAdjust.
     * @return min
     *
    @SuppressWarnings("unchecked")
    public int getMin(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the min field.
     * @param min the new value for min
     */
    public void setMin(int min)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMin(").appendData(min).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the max field, the maximum value displayed by this axis, overrides autoAdjust.
     * @return max
     *
    @SuppressWarnings("unchecked")
    public int getMax(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the max field.
     * @param max the new value for max
     */
    public void setMax(int max)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMax(").appendData(max).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the interval field, the interval between major ticks, overrides autoAdjust.
     * @return interval
     *
    @SuppressWarnings("unchecked")
    public int getInterval(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the interval field.
     * @param interval the new value for interval
     */
    public void setInterval(int interval)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setInterval(").appendData(interval).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * convert a number value to a coordinate between 0 and this.length, if the value is outside of the range of the axis, return the closest value in the range
     * @param value a value displayed along the axis
     * @return coordinate along the axis
     *
    @SuppressWarnings("unchecked")
    public int getCoordinateFor(int value, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * same as getCoordinateFor(), but does not clip to bounds of the axis
     * @param value 
     */
    public void getCoordinateForNoClip(int value)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("getCoordinateForNoClip(").appendData(value).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
