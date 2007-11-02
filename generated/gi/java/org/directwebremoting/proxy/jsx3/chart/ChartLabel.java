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
public class ChartLabel extends org.directwebremoting.proxy.jsx3.chart.ChartComponent
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public ChartLabel(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param text text to display in the label
     */
    public ChartLabel(String name, String text)
    {
        super((ProxyHelper) null);
    }

    /**
     * the default preferred width
     */
    public static final int DEFAULT_WIDTH = 100;

    /**
     * non-rotated angle
     */
    public static final int ROTATION_NORMAL = 0;

    /**
     * angle for one-quarter clockwise rotation
     */
    public static final int ROTATION_CW = 90;

    /**
     * angle for one-quarter counter-clockwise rotation
     */
    public static final int ROTATION_CCW = 270;

    /*
     * Returns the preferredWidth field.
     * @return preferredWidth
     *
    @SuppressWarnings("unchecked")
    public int getPreferredWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the preferredWidth field.
     * @param preferredWidth the new value for preferredWidth
     */
    public void setPreferredWidth(int preferredWidth)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPreferredWidth(").appendData(preferredWidth).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the preferredHeight field.
     * @return preferredHeight
     *
    @SuppressWarnings("unchecked")
    public int getPreferredHeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the preferredHeight field.
     * @param preferredHeight the new value for preferredHeight
     */
    public void setPreferredHeight(int preferredHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPreferredHeight(").appendData(preferredHeight).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the alpha field, the opacity of the background fill.
     * @return alpha
     *
    @SuppressWarnings("unchecked")
    public float getAlpha(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the alpha field.
     * @param alpha the new value for alpha
     */
    public void setAlpha(float alpha)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAlpha(").appendData(alpha).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the borderStroke field, string representation of the VectorStroke used to outline the background.
     * @return borderStroke
     *
    @SuppressWarnings("unchecked")
    public String getBorderStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the borderStroke field.
     * @param borderStroke the new value for borderStroke
     */
    public void setBorderStroke(String borderStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBorderStroke(").appendData(borderStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelRotation field.
     * @return labelRotation
     *
    @SuppressWarnings("unchecked")
    public int getLabelRotation(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelRotation field.
     * @param labelRotation the new value for labelRotation, one of {0, 90, 270}
     */
    public void setLabelRotation(int labelRotation)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelRotation(").appendData(labelRotation).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * whether this label is display at 90 or -90 degrees
     *
    @SuppressWarnings("unchecked")
    public boolean isRotated(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

}
