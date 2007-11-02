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

import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class ChartComponent extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public ChartComponent(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     */
    public ChartComponent(String name)
    {
        super((ProxyHelper) null);
    }

    /**
     * Returns the chart of which this component is a part.
     * @return this if this is a chart, or the first ancestor that is a chart
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.Chart getChart()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChart().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.Chart> ctor = org.directwebremoting.proxy.jsx3.chart.Chart.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.Chart.class.getName());
        }
    }

    /**
     * Returns the chart of which this component is a part.
     * @param returnType The expected return type
     * @return this if this is a chart, or the first ancestor that is a chart
     */
    @SuppressWarnings("unchecked")
    public <T> T getChart(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChart().");
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
