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

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * Shared functionality between BarSeries and ColumnSeries.
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class BCSeries extends jsx3.chart.Series
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public BCSeries(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param seriesName the name of the Series, will be displayed in the Legend for most chart types
     */
    public BCSeries(String name, String seriesName)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new BCSeries", name, seriesName);
        setInitScript(script);
    }



    /**
     * Returns the x-coordinate of a data point in this series for the given record.
     * @param record the <record/> node
     */
    @SuppressWarnings("unchecked")
    public void getXValue(jsx3.xml.Node record, org.directwebremoting.proxy.Callback<Integer> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXValue", record);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the y-coordinate of a data point in this series for the given record.
     * @param record the <record/> node
     */
    @SuppressWarnings("unchecked")
    public void getYValue(jsx3.xml.Node record, org.directwebremoting.proxy.Callback<Integer> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getYValue", record);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the minimum value (x or y) of a data point in this series for the given record.
     * @param record the <record/> node
     */
    @SuppressWarnings("unchecked")
    public void getMinValue(jsx3.xml.Node record, org.directwebremoting.proxy.Callback<Integer> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMinValue", record);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the xField field.
     * @param callback xField
     */
    @SuppressWarnings("unchecked")
    public void getXField(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXField");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the xField field.
     * @param xField the new value for xField
     */
    public void setXField(String xField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setXField", xField);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the yField field.
     * @param callback yField
     */
    @SuppressWarnings("unchecked")
    public void getYField(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getYField");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the yField field.
     * @param yField the new value for yField
     */
    public void setYField(String yField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setYField", yField);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the minField field.
     * @param callback minField
     */
    @SuppressWarnings("unchecked")
    public void getMinField(org.directwebremoting.proxy.Callback<String> callback)
    {
        String key = org.directwebremoting.extend.CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMinField");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the minField field.
     * @param minField the new value for minField
     */
    public void setMinField(String minField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMinField", minField);
        getScriptProxy().addScript(script);
    }

}

