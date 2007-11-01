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
public class Axis extends org.directwebremoting.proxy.jsx3.chart.ChartComponent
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Axis(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param name the GI name of the instance
     * @param horizontal whether this axis is horizontal (x), otherwise it's vertical (y)
     * @param primary whether this axis is primary, otherwise it's secondary
     */
    public Axis(String name, boolean horizontal, boolean primary)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String TICK_INSIDE = "inside";

    /**
     * 
     */
    public static final String TICK_OUTSIDE = "outside";

    /**
     * 
     */
    public static final String TICK_CROSS = "cross";

    /**
     * 
     */
    public static final String TICK_NONE = "none";

    /**
     * 
     */
    public static final String LABEL_HIGH = "high";

    /**
     * 
     */
    public static final String LABEL_LOW = "low";

    /**
     * 
     */
    public static final String LABEL_AXIS = "axis";

    /*
     * formats labels as a percent, ie "50%"
     * @param v 
     *
    @SuppressWarnings("unchecked")
    public String percent(int v, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * formats labels in scientific notation, ie "5e2"
     * @param v 
     * @param signif 
     *
    @SuppressWarnings("unchecked")
    public String scientific(int v, int signif, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the horizontal field, whether this is an x axis, otherwise it is a y axis.
     * @return horizontal
     *
    @SuppressWarnings("unchecked")
    public boolean getHorizontal(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the horizontal field.
     * @param horizontal the new value for horizontal
     */
    public void setHorizontal(boolean horizontal)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHorizontal(").appendData(horizontal).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the showAxis field, whether to show the line along the axis.
     * @return showAxis
     *
    @SuppressWarnings("unchecked")
    public boolean getShowAxis(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the showAxis field.
     * @param showAxis the new value for showAxis
     */
    public void setShowAxis(boolean showAxis)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setShowAxis(").appendData(showAxis).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelFunction field.
     * @return labelFunction
     *
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.CodeBlock getLabelFunction(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelFunction field, allows for formatting and transformation of a major tick label; should eval to a function with the signature function(object) : string.
     * @param labelFunction the new value for labelFunction
     */
    public void setLabelFunction(String labelFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelFunction(").appendData(labelFunction).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the axisStroke field, string representation of the VectorStroke used to draw the line of the axis.
     * @return axisStroke
     *
    @SuppressWarnings("unchecked")
    public String getAxisStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the axisStroke field.
     * @param axisStroke the new value for axisStroke
     */
    public void setAxisStroke(String axisStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAxisStroke(").appendData(axisStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the showLabels field, whether to show major tick labels.
     * @return showLabels
     *
    @SuppressWarnings("unchecked")
    public boolean getShowLabels(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the showLabels field.
     * @param showLabels the new value for showLabels
     */
    public void setShowLabels(boolean showLabels)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setShowLabels(").appendData(showLabels).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelGap field, the pixel gap between the tick lines and the labels.
     * @return labelGap
     *
    @SuppressWarnings("unchecked")
    public int getLabelGap(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelGap field.
     * @param labelGap the new value for labelGap
     */
    public void setLabelGap(int labelGap)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelGap(").appendData(labelGap).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelPlacement field, checks for invalid values.
     * @param labelPlacement the new value for labelPlacement, one of {'axis','high','low'}
     */
    public void setLabelPlacement(String labelPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelPlacement(").appendData(labelPlacement).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the tickLength field, the length in pixels of the major tick (if tickPlacement is "cross" the length will actually be twice this.
     * @return tickLength
     *
    @SuppressWarnings("unchecked")
    public int getTickLength(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the tickLength field.
     * @param tickLength the new value for tickLength
     */
    public void setTickLength(int tickLength)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTickLength(").appendData(tickLength).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the tickPlacement field, where to place the major ticks.
     * @return tickPlacement, one of {'none','inside','outside','cross'}
     *
    @SuppressWarnings("unchecked")
    public String getTickPlacement(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the tickPlacement field.
     * @param tickPlacement the new value for tickPlacement, one of {'none','inside','outside','cross'}
     */
    public void setTickPlacement(String tickPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTickPlacement(").appendData(tickPlacement).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the tickStroke field, string representation of VectorStroke used to draw major ticks.
     * @return tickStroke
     *
    @SuppressWarnings("unchecked")
    public String getTickStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the tickStroke field.
     * @param tickStroke the new value for tickStroke
     */
    public void setTickStroke(String tickStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTickStroke(").appendData(tickStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minorTickDivisions field, number of minor tick divisions between major ticks; the number of minor ticks drawn will be this number minus 1.
     * @return minorTickDivisions
     *
    @SuppressWarnings("unchecked")
    public int getMinorTickDivisions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minorTickDivisions field.
     * @param minorTickDivisions the new value for minorTickDivisions
     */
    public void setMinorTickDivisions(int minorTickDivisions)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinorTickDivisions(").appendData(minorTickDivisions).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minorTickLength field, the length in pixels of the minor tick (if tickPlacement is "cross" the length will actually be twice this.
     * @return minorTickLength
     *
    @SuppressWarnings("unchecked")
    public int getMinorTickLength(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minorTickLength field.
     * @param minorTickLength the new value for minorTickLength
     */
    public void setMinorTickLength(int minorTickLength)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinorTickLength(").appendData(minorTickLength).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minorTickPlacement field, where to place the minor ticks.
     * @return minorTickPlacement, one of {'none','inside','outside','cross'}
     *
    @SuppressWarnings("unchecked")
    public String getMinorTickPlacement(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minorTickPlacement field.
     * @param minorTickPlacement the new value for minorTickPlacement, one of {'none','inside','outside','cross'}
     */
    public void setMinorTickPlacement(String minorTickPlacement)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinorTickPlacement(").appendData(minorTickPlacement).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the minorTickStroke field, string representation of VectorStroke used to draw minor ticks.
     * @return minorTickStroke
     *
    @SuppressWarnings("unchecked")
    public String getMinorTickStroke(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the minorTickStroke field.
     * @param minorTickStroke the new value for minorTickStroke
     */
    public void setMinorTickStroke(String minorTickStroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMinorTickStroke(").appendData(minorTickStroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the labelClass field, the CSS class used to render major tick labels.
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
     * Returns the labelStyle field, the CSS style attribute used to render major tick labels.
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
     * Returns the labelColor field, the RGB color value of the label font; note that this is the only way to set the color of the text, using a CSS style attribute will have no effect.
     * @return labelColor
     *
    @SuppressWarnings("unchecked")
    public String getLabelColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the labelColor field.
     * @param labelColor the new value for labelColor
     */
    public void setLabelColor(String labelColor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelColor(").appendData(labelColor).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the labelColor field.
     * @param labelColor the new value for labelColor
     */
    public void setLabelColor(int labelColor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLabelColor(").appendData(labelColor).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the display width, the maximum amount of space perpendicular to the axis and outside of the data area that the ticks and labels may occupy (doesn't include area given to axis title).
     * @return displayWidth
     *
    @SuppressWarnings("unchecked")
    public int getDisplayWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the displayWidth field.
     * @param displayWidth the new value for displayWidth
     */
    public void setDisplayWidth(int displayWidth)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDisplayWidth(").appendData(displayWidth).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the optional jsx3.chart.ChartLabel child.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.ChartLabel getAxisTitle()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAxisTitle().");
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

    /**
     * Returns the opposing axis.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.chart.Axis getOpposingAxis()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOpposingAxis().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.chart.Axis> ctor = org.directwebremoting.proxy.jsx3.chart.Axis.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.chart.Axis.class.getName());
        }
    }

    /**
     * Returns the opposing axis.
     */
    @SuppressWarnings("unchecked")
    public <T> T getOpposingAxis(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOpposingAxis().");
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

    /*
     * Publishes a model event. This method both evaluates any registered event script for the given event type
    and publishes the event through the EventDispatcher interface. This method ensures that any
    registered event script is executed in isolation to prevent most side effects.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @param objContext JavaScript object array with name/value pairs that provide a local
    variable stack for the execution of the event script. This argument is also passed as the <code>context</code>
    property of the event object that is published through the <code>EventDispatcher</code> interface.
     * @return the result of evaluating the event script or <code>null</code> if not event script is registered
     *
    @SuppressWarnings("unchecked")
    public Object doEvent(String strType, Object objContext, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object supports programmatic drag, meanining it will allow any contained item to be
    dragged and dropped on another container supporting drop.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanDrag(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether this object can be the target of a drop event.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanDrop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object can be moved around the screen (this is not the same as drag/drop).
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanMove(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object can be spyglassed.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanSpy(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the event script registered for the given event type. This script could have been set by the
    setEvent() method or during component deserialization.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return the JavaScript event script
     *
    @SuppressWarnings("unchecked")
    public String getEvent(String strType, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the associative array containing all the registered event script of this object. This method returns
    the instance field itself and not a copy.
     * @return an associative array mapping event type to event script
     *
    @SuppressWarnings("unchecked")
    public Object getEvents(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the name of the jsx3.gui.Menu instance to display (as a context menu) when a user
    clicks on this object with the right button.
     *
    @SuppressWarnings("unchecked")
    public String getMenu(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns true if there is a event script registered for the given event type.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return the JavaScript event script
     *
    @SuppressWarnings("unchecked")
    public String hasEvent(String strType, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Registers a hot key with this JSX model node. All keydown events that bubble up to this object
    will be checked against the hot key. If an event matches, the callback function will execute and the event
    bubble will be canceled.

    If the four parameters vntKey, bShift, bControl, and bAlt
    match a previously registered hot key, the previous hot key is clobbered by the new one. Only one hot key callback
    function (the most recently registered) will be executed by a single keydown event.
     * @param vntCallback either a function, or the name of a method bound to this object.
    When a keydown event bubbles up to this object that matches the hot key created by this method, this function
    is called on this object. If this function returns <code>false</code> then this hot key will not cancel the
    key event. This parameter can also be an instance of <code>HotKey</code>, in which case all
    other parameters are ignored.
     * @param vntKey if this parameter is a String, the hot key matches that key (the keycode to match is
    determined by <code>HotKey.keyDownCharToCode()</code>). If it is an integer, the hot key will match that
    keycode value.
     * @param bShift if not <code>null</code> the shift key state of the keydown event must match this value
    to invoke the hot key.
     * @param bControl if not <code>null</code> the control key state of the keydown event must match this value
    to invoke the hot key.
     * @param bAlt if not <code>null</code> the alt key state of the keydown event must match this value
    to invoke the hot key.
     * @return the registered hot key.
     */
    @Override
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.HotKey registerHotKey(String vntCallback, int vntKey, boolean bShift, boolean bControl, boolean bAlt)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("registerHotKey(\"" + vntCallback + "\", \"" + vntKey + "\", \"" + bShift + "\", \"" + bControl + "\", \"" + bAlt + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.HotKey> ctor = org.directwebremoting.proxy.jsx3.gui.HotKey.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.HotKey.class.getName());
        }
    }

    /**
     * Removes an event script registered for the given model event type.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return this object
     */
    @Override
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvent(String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeEvent(\"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Removes all events scripts registered with this object.
     * @return this object
     */
    @Override
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvents()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeEvents().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object supports programmatic drag, meanining it will allow any contained item to be dragged/dropped.
    Implementing classes can decide whether to consult this value or ignore it.
     * @param bDrag <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrag(int bDrag)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanDrag(\"" + bDrag + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether this object can be the target of a drop event. Implementing classes can decide whether to consult
    this value or ignore it.
     * @param bDrop <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrop(int bDrop)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanDrop(\"" + bDrop + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object can be moved around the screen (this is not the same as drag/drop). Implementing classes
    can decide whether to consult this value or ignore it.
     * @param bMovable <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanMove(int bMovable)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanMove(\"" + bMovable + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object can be spyglassed. Implementing classes can decide whether to consult
    this value or ignore it.
     * @param bSpy <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanSpy(int bSpy)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanSpy(\"" + bSpy + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Programmatically sets an event of this instance. Sets the script that will execute when this object publishes
    a model event. The script value will be saved in the serialization file of a component. Not all classes that
    implement this interface will publish events of every type. Consult the documentation of a class for a
    description of the events it publishes.

    For programmatic registering of event handlers when persistence in a serialization file is not required,
    consider using jsx3.util.EventDispatcher.subscribe() instead of this method. Whenever a model
    event is published, it is published using the EventDispatcher interface as well as by executing
    any registered event script.
     * @param strScript the actual JavaScript code that will execute when the given event is published.
    For example: <code>obj.setEvent("alert('hello.');", jsx3.gui.Interactive.EXECUTE);</code>
     * @param strType the event type. Must be one of the model event types defined as static fields in this class
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setEvent(String strScript, String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setEvent(\"" + strScript + "\", \"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets the name of the jsx3.gui.Menu instance to display when a user
    clicks on this object with the right button. The name is a pointer by-name to a JSX object in the same server.
     * @param strMenu name or id (jsxname or jsxid) of the context menu
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setMenu(String strMenu)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setMenu(\"" + strMenu + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets the CSS definition to apply to an HTML element when a spyglass is shown for that element
     * @param strCSS valid CSS. For example, text-decoration:underline;color:red;
     */
    public void setSpyStyles(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSpyStyles(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * called by 'window.setTimeout()' to display the spyglass hover for a given object;
     * @param strHTML HTML/text to display in the spyglass; as the spyglass does not define a height/width, this content will
         have improved layout if it specifies a preferred width in its in-line-style or referenced-css rule.
     * @param intLeft use an integer to specify an on-screen location; otherwise, use a <code>jsx3.gui.Event</code> instance to have the system automatically calculate the x/y position.
     * @param intTop use an integer if <code>intLeft</code> also uses an integer. Otherwise, use null.
     */
    public void showSpy(String strHTML, int intLeft, int intTop)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("showSpy(").appendData(strHTML).appendScript(",")

        .appendData(intLeft).appendScript(",")

        .appendData(intTop).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Publishes an event to all subscribed objects.
     * @param objEvent the event, should have at least a field 'subject' that is the event id, another common field is 'target' (target will default to this instance)
     * @return the number of listeners to which the event was broadcast
     *
    @SuppressWarnings("unchecked")
    public int publish(Object objEvent, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Subscribes an object or function to a type of event published by this object.

    As of version 3.4 a string value for objHandler is deprecated.
     * @param strEventId the event type(s).
     * @param objHandler if an object, the instance to notify of events (objFunction is required); if a string, the JSX id of the instance to notify of events (objFunction is required), must exist in the same Server; if a function, the function to call to notify of events (objFunction ignored)
     * @param objFunction if objHandler is a string or object then the function to call on that instance. either a function or a string that is the name of a method of the instance
     */
    public void subscribe(String strEventId, Object objHandler, org.directwebremoting.proxy.CodeBlock objFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("subscribe(").appendData(strEventId).appendScript(",")

        .appendData(objHandler).appendScript(",")

        .appendData(objFunction).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Unsubscribe an object or function from an event published by this object.

    As of version 3.4 a string value for objHandler is deprecated.
     * @param strEventId the event type(s).
     * @param objHandler the value of objHandler passed to subscribe
     */
    public void unsubscribe(String strEventId, Object objHandler)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("unsubscribe(").appendData(strEventId).appendScript(",")

        .appendData(objHandler).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Unsubscribes all subscribed objects to a type of event published by this object.
     * @param strEventId the event type
     */
    public void unsubscribeAll(String strEventId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("unsubscribeAll(").appendData(strEventId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
