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
public class LogarithmicAxis extends org.directwebremoting.proxy.jsx3.chart.Axis
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public LogarithmicAxis(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param horizontal whether this axis is horizontal (x), otherwise it's vertical (y)
     * @param primary whether this axis is primary, otherwise it's secondary
     */
    public LogarithmicAxis(String name, boolean horizontal, boolean primary)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the autoAdjust field.
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
     * Returns the baseAtZero field, whether or not to set the minimum value to base^0, otherwise will choose an appropriate value for the data range.
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
     * Returns the showNegativeValues field.
     * @return showNegativeValues
     *
    @SuppressWarnings("unchecked")
    public boolean getShowNegativeValues(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the showNegativeValues field.
     * @param showNegativeValues the new value for showNegativeValues
     */
    public void setShowNegativeValues(boolean showNegativeValues)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setShowNegativeValues(").appendData(showNegativeValues).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minExponent field, the range of values displayed will begin at base^minExpronent.
     * @return minExponent
     *
    @SuppressWarnings("unchecked")
    public int getMinExponent(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minExponent field.
     * @param minExponent the new value for minExponent
     */
    public void setMinExponent(int minExponent)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinExponent(").appendData(minExponent).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the maxExponent field, the range of values displayed will end at base^maxExponent.
     * @return maxExponent
     *
    @SuppressWarnings("unchecked")
    public int getMaxExponent(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the maxExponent field.
     * @param maxExponent the new value for maxExponent
     */
    public void setMaxExponent(int maxExponent)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMaxExponent(").appendData(maxExponent).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the base field.
     * @return base
     *
    @SuppressWarnings("unchecked")
    public int getBase(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the base field.
     * @param base the new value for base
     */
    public void setBase(int base)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBase(").appendData(base).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the majorDivisions field, the number of major tick line divisions to place between the values base^n and base^(n+1). A good value can be base-1, though the default value is 1..
     * @return majorDivisions
     *
    @SuppressWarnings("unchecked")
    public int getMajorDivisions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the majorDivisions field.
     * @param majorDivisions the new value for majorDivisions
     */
    public void setMajorDivisions(int majorDivisions)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMajorDivisions(").appendData(majorDivisions).appendScript(");");
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
