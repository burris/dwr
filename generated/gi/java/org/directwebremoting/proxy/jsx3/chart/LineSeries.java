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
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class LineSeries extends org.directwebremoting.proxy.jsx3.chart.Series
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public LineSeries(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param seriesName the name of the Series, will be displayed in the Legend for most chart types
     */
    public LineSeries(String name, String seriesName)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String FORM_SEGMENT = "segment";

    /**
     * 
     */
    public static final String FORM_STEP = "step";

    /**
     * 
     */
    public static final String FORM_REVSTEP = "reverseStep";

    /**
     * 
     */
    public static final String FORM_HORIZONTAL = "horizontal";

    /**
     * 
     */
    public static final String FORM_VERTICAL = "vertical";

    /*
     * Returns the xField field.
     * @return xField
     *
    @SuppressWarnings("unchecked")
    public String getXField(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the xField field.
     * @param xField the new value for xField
     */
    public void setXField(String xField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setXField(").appendData(xField).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the yField field.
     * @return yField
     *
    @SuppressWarnings("unchecked")
    public String getYField(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the yField field.
     * @param yField the new value for yField
     */
    public void setYField(String yField)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setYField(").appendData(yField).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the form field.
     * @return form
     *
    @SuppressWarnings("unchecked")
    public String getForm(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the form field, checks for valid value.
     * @param form the new value for form, one of {'segment','step','reverseStep','horizontal','vertical'}
     */
    public void setForm(String form)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setForm(").appendData(form).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the interpolateValues field.
     * @return interpolateValues
     *
    @SuppressWarnings("unchecked")
    public boolean getInterpolateValues(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the interpolateValues field.
     * @param interpolateValues the new value for interpolateValues
     */
    public void setInterpolateValues(boolean interpolateValues)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setInterpolateValues(").appendData(interpolateValues).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the pointRadius field.
     * @return pointRadius
     *
    @SuppressWarnings("unchecked")
    public int getPointRadius(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the pointRadius field.
     * @param pointRadius the new value for pointRadius
     */
    public void setPointRadius(int pointRadius)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPointRadius(").appendData(pointRadius).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the pointRenderer field.
     * @return pointRenderer
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.PointRenderer getPointRenderer()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPointRenderer().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.PointRenderer> ctor = org.directwebremoting.proxy.jsx3.chart.PointRenderer.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.PointRenderer.class.getName());
        }
    }

    /**
     * Sets the pointRenderer field, should eval to an object that implements the renderer interface.
     * @param pointRenderer the new value for pointRenderer, as a string
     */
    public void setPointRenderer(String pointRenderer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPointRenderer(").appendData(pointRenderer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the pointFill field.
     * @return pointFill
     *
    @SuppressWarnings("unchecked")
    public String getPointFill(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the pointFill field.
     * @param pointFill the new value for pointFill
     */
    public void setPointFill(String pointFill)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPointFill(").appendData(pointFill).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the pointStroke field.
     * @return pointStroke
     *
    @SuppressWarnings("unchecked")
    public String getPointStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the pointStroke field.
     * @param pointStroke the new value for pointStroke
     */
    public void setPointStroke(String pointStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPointStroke(").appendData(pointStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the pointGradient field.
     * @return pointGradient
     *
    @SuppressWarnings("unchecked")
    public String getPointGradient(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the pointGradient field.
     * @param pointGradient the new value for pointGradient
     */
    public void setPointGradient(String pointGradient)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPointGradient(").appendData(pointGradient).appendScript(");");
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
