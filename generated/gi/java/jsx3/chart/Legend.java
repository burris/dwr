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

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * Chart component that renders a simple legend. A legend may contain a list of series or a list of
categories, depending on the type of chart.
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Legend extends jsx3.chart.ChartComponent
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Legend(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     */
    public Legend(String name)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Legend", name);
        setInitScript(script);
    }


    /**
     * the default width
     */
    public static final int DEFAULT_WIDTH = 100;

    /**
     * the default height
     */
    public static final int DEFAULT_HEIGHT = 100;


    /**
     * Returns the boxHeight field, the diameter of the box that shows the fill of each series or category.
     * @param callback boxHeight
     */
    @SuppressWarnings("unchecked")
    public void getBoxHeight(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getBoxHeight");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the boxHeight field.
     * @param boxHeight the new value for boxHeight
     */
    public void setBoxHeight(int boxHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setBoxHeight", boxHeight);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the lineHeight field, the vertical space taken for each legend entry.
     * @param callback lineHeight
     */
    @SuppressWarnings("unchecked")
    public void getLineHeight(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLineHeight");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the lineHeight field.
     * @param lineHeight the new value for lineHeight
     */
    public void setLineHeight(int lineHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLineHeight", lineHeight);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelClass field, the CSS class name applied to the name of each series or category.
     * @param callback labelClass
     */
    @SuppressWarnings("unchecked")
    public void getLabelClass(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelClass");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelClass field.
     * @param labelClass the new value for labelClass
     */
    public void setLabelClass(String labelClass)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelClass", labelClass);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the labelStyle field, a CSS style attribute applied to the name of each series or category, ie "font-family: Arial; font-size: 10px;".
     * @param callback labelStyle
     */
    @SuppressWarnings("unchecked")
    public void getLabelStyle(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLabelStyle");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelStyle field.
     * @param labelStyle the new value for labelStyle
     */
    public void setLabelStyle(String labelStyle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLabelStyle", labelStyle);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the backgroundFill field, a string representation of the vector fill used to color in the background of the legend.
     * @param callback backgroundFill
     */
    @SuppressWarnings("unchecked")
    public void getBackgroundFill(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getBackgroundFill");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the backgroundFill field.
     * @param backgroundFill the new value for backgroundFill
     */
    public void setBackgroundFill(String backgroundFill)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setBackgroundFill", backgroundFill);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the backgroundStroke field, a string representation of the VectorStroke used to outline the legend.
     * @param callback backgroundStroke
     */
    @SuppressWarnings("unchecked")
    public void getBackgroundStroke(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getBackgroundStroke");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the backgroundStroke field.
     * @param backgroundStroke the new value for backgroundStroke
     */
    public void setBackgroundStroke(String backgroundStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setBackgroundStroke", backgroundStroke);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the preferredWidth field, the width that this component would like to have, though its true size is dictated by the container component.
     * @param callback preferredWidth
     */
    @SuppressWarnings("unchecked")
    public void getPreferredWidth(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPreferredWidth");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the preferredWidth field.
     * @param preferredWidth the new value for preferredWidth
     */
    public void setPreferredWidth(int preferredWidth)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setPreferredWidth", preferredWidth);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the preferredHeight field, the height that this component would like to have, though its true size is dictated by the container component.
     * @param callback preferredHeight
     */
    @SuppressWarnings("unchecked")
    public void getPreferredHeight(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPreferredHeight");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the preferredHeight field.
     * @param preferredHeight the new value for preferredHeight
     */
    public void setPreferredHeight(int preferredHeight)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setPreferredHeight", preferredHeight);
        getScriptProxy().addScript(script);
    }

    /**
     * Find the first jsx3.chart.ChartLabel child
     */
    @SuppressWarnings("unchecked")
    public jsx3.chart.ChartLabel getLegendTitle()
    {
        String extension = "getLegendTitle().";
        try
        {
            Constructor<jsx3.chart.ChartLabel> ctor = jsx3.chart.ChartLabel.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + jsx3.chart.ChartLabel.class.getName());
        }
    }


}

