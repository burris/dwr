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
public class LineChart extends org.directwebremoting.proxy.jsx3.chart.CartesianChart
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public LineChart(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param left left position (in pixels) of the chart relative to its parent container
     * @param top top position (in pixels) of the chart relative to its parent container
     * @param width width (in pixels) of the chart
     * @param height height (in pixels) of the chart
     */
    public LineChart(String name, int left, int top, int width, int height)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String TYPE_OVERLAY = "overlay";

    /**
     * 
     */
    public static final String TYPE_STACKED = "stacked";

    /**
     * 
     */
    public static final String TYPE_STACKED100 = "stacked100";

    /*
     * Returns the type field, one of {'overlay','stacked','stacked100'}.
     * @return type
     *
    @SuppressWarnings("unchecked")
    public String getType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the type field.
     * @param type the new value for type, one of {'overlay','stacked','stacked100'}
     */
    public void setType(String type)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setType(").appendData(type).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
