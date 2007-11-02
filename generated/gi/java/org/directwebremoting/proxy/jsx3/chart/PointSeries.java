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
     * The instance initializer.
     * @param name the GI name of the instance
     * @param seriesName the name of the Series, will be displayed in the Legend for most chart types
     */
    public PointSeries(String name, String seriesName)
    {
        super((ProxyHelper) null);
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
        script.appendData(getProxyHelper().getContext()).appendScript("setMagnitude(").appendData(magnitude).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * The default tooltip function for this type of series.
     * @param series 
     * @param record 
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

}
