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
public class CategoryAxis extends org.directwebremoting.proxy.jsx3.chart.Axis
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public CategoryAxis(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param horizontal whether this axis is horizontal (x), otherwise it's vertical (y)
     * @param primary whether this axis is primary, otherwise it's secondary
     */
    public CategoryAxis(String name, boolean horizontal, boolean primary)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String TICKS_ALIGNED = "aligned";

    /**
     * 
     */
    public static final String TICKS_BETWEEN = "between";

    /*
     * Returns the tickAlignment field, if 'between' then the midpoint of the category is between two major ticks, otherwise if 'aligned' then the midpoint of the category is aligned with a major tick.
     * @return tickAlignment, one of {'aligned','between'}
     *
    @SuppressWarnings("unchecked")
    public String getTickAlignment(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the tickAlignment field.
     * @param tickAlignment the new value for tickAlignment, one of {'aligned','between'}
     */
    public void setTickAlignment(String tickAlignment)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTickAlignment(").appendData(tickAlignment).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the categoryField field, the attribute of records from the data provider that contains the category name (this value can still be transformed by Axis's 'labelFunction' field).
     * @return categoryField
     *
    @SuppressWarnings("unchecked")
    public String getCategoryField(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the categoryField field.
     * @param categoryField the new value for categoryField
     */
    public void setCategoryField(String categoryField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCategoryField(").appendData(categoryField).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the paddingLow field, the number of category widths to pad the beginning of the axis with.
     * @return paddingLow
     *
    @SuppressWarnings("unchecked")
    public float getPaddingLow(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the paddingLow field.
     * @param paddingLow the new value for paddingLow
     */
    public void setPaddingLow(float paddingLow)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPaddingLow(").appendData(paddingLow).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the paddingHigh field, the number of category widths to pad the end of the axis with.
     * @return paddingHigh
     *
    @SuppressWarnings("unchecked")
    public float getPaddingHigh(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the paddingHigh field.
     * @param paddingHigh the new value for paddingHigh
     */
    public void setPaddingHigh(float paddingHigh)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPaddingHigh(").appendData(paddingHigh).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
