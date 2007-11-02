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
public class PlotChart extends org.directwebremoting.proxy.jsx3.chart.CartesianChart
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public PlotChart(ProxyHelper helper)
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
    public PlotChart(String name, int left, int top, int width, int height)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String MAG_RADIUS = "radius";

    /**
     * 
     */
    public static final String MAG_DIAMETER = "diameter";

    /**
     * 
     */
    public static final String MAG_AREA = "area";

    /**
     * 
     */
    public static final int DEFAULT_MAX_POINT_RADIUS = 30;

    /*
     * Returns the maxPointRadius field, limit the radius of points on this chart to this value.
     * @return maxPointRadius
     *
    @SuppressWarnings("unchecked")
    public int getMaxPointRadius(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the maxPointRadius field.
     * @param maxPointRadius the new value for maxPointRadius
     */
    public void setMaxPointRadius(int maxPointRadius)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMaxPointRadius(").appendData(maxPointRadius).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the magnitudeMethod field; the magnitude method defines how the magnitude value of a record in a bubble series is converted to a radius for the rendered point; a value of "radius" means that the magnitude will equal the radius of the point, "diameter" means that the magnitude will equal the diameter (2 * radius), and "area" means that the area of the point will be proportional to the magnitude.
     * @return magnitudeMethod, one of {"radius","diameter","area"}
     *
    @SuppressWarnings("unchecked")
    public String getMagnitudeMethod(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the magnitudeMethod field, one of {"radius","diameter","area"}.
     * @param magnitudeMethod the new value for magnitudeMethod
     */
    public void setMagnitudeMethod(String magnitudeMethod)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMagnitudeMethod(").appendData(magnitudeMethod).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
