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
public class Legend extends org.directwebremoting.proxy.jsx3.chart.ChartComponent
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Legend(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     */
    public Legend(String name)
    {
        super((ProxyHelper) null);
    }

    /**
     * the default width
     */
    public static final int DEFAULT_WIDTH = 100;

    /**
     * the default height
     */
    public static final int DEFAULT_HEIGHT = 100;

    /*
     * Returns the boxHeight field, the diameter of the box that shows the fill of each series or category.
     * @return boxHeight
     *
    @SuppressWarnings("unchecked")
    public int getBoxHeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the boxHeight field.
     * @param boxHeight the new value for boxHeight
     */
    public void setBoxHeight(int boxHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBoxHeight(").appendData(boxHeight).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the lineHeight field, the vertical space taken for each legend entry.
     * @return lineHeight
     *
    @SuppressWarnings("unchecked")
    public int getLineHeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the lineHeight field.
     * @param lineHeight the new value for lineHeight
     */
    public void setLineHeight(int lineHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLineHeight(").appendData(lineHeight).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelClass field, the CSS class name applied to the name of each series or category.
     * @return labelClass
     *
    @SuppressWarnings("unchecked")
    public String getLabelClass(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelClass field.
     * @param labelClass the new value for labelClass
     */
    public void setLabelClass(String labelClass)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelClass(").appendData(labelClass).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelStyle field, a CSS style attribute applied to the name of each series or category, ie "font-family: Arial; font-size: 10px;".
     * @return labelStyle
     *
    @SuppressWarnings("unchecked")
    public String getLabelStyle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelStyle field.
     * @param labelStyle the new value for labelStyle
     */
    public void setLabelStyle(String labelStyle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelStyle(").appendData(labelStyle).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the backgroundFill field, a string representation of the vector fill used to color in the background of the legend.
     * @return backgroundFill
     *
    @SuppressWarnings("unchecked")
    public String getBackgroundFill(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the backgroundFill field.
     * @param backgroundFill the new value for backgroundFill
     */
    public void setBackgroundFill(String backgroundFill)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBackgroundFill(").appendData(backgroundFill).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the backgroundStroke field, a string representation of the VectorStroke used to outline the legend.
     * @return backgroundStroke
     *
    @SuppressWarnings("unchecked")
    public String getBackgroundStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the backgroundStroke field.
     * @param backgroundStroke the new value for backgroundStroke
     */
    public void setBackgroundStroke(String backgroundStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBackgroundStroke(").appendData(backgroundStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the preferredWidth field, the width that this component would like to have, though its true size is dictated by the container component.
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
     * Returns the preferredHeight field, the height that this component would like to have, though its true size is dictated by the container component.
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

    /**
     * Find the first jsx3.chart.ChartLabel child
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.ChartLabel getLegendTitle()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLegendTitle().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.ChartLabel> ctor = org.directwebremoting.proxy.jsx3.chart.ChartLabel.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.ChartLabel.class.getName());
        }
    }

}
