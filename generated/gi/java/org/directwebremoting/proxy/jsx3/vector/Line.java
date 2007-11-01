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

package org.directwebremoting.proxy.jsx3.vector;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Line extends org.directwebremoting.proxy.jsx3.vector.Shape
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Line(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param left left position (in pixels) of the object relative to its parent container
     * @param top top position (in pixels) of the object relative to its parent container
     * @param x1 the x coordinate of the starting point
     * @param y1 the y coordinate of the starting point
     * @param x2 the x coordinate of the ending point
     * @param y2 the y coordinate of the ending point
     */
    public Line(int left, int top, int x1, int y1, int x2, int y2)
    {
        super((ProxyHelper) null);
    }

    /**
     * Sets all the coordinates at once.
     * @param x1 the x coordinate of the starting point
     * @param y1 the y coordinate of the starting point
     * @param x2 the x coordinate of the ending point
     * @param y2 the y coordinate of the ending point
     */
    public void setPoints(int x1, int y1, int x2, int y2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPoints(").appendData(x1).appendScript(",")

        .appendData(y1).appendScript(",")

        .appendData(x2).appendScript(",")

        .appendData(y2).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the x1 field.
     * @return x1
     *
    @SuppressWarnings("unchecked")
    public int getX1(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the x1 field.
     * @param x1 the new value for x1
     */
    public void setX1(int x1)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setX1(").appendData(x1).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the y1 field.
     * @return y1
     *
    @SuppressWarnings("unchecked")
    public int getY1(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the y1 field.
     * @param y1 the new value for y1
     */
    public void setY1(int y1)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setY1(").appendData(y1).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the x2 field.
     * @return x2
     *
    @SuppressWarnings("unchecked")
    public int getX2(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the x2 field.
     * @param x2 the new value for x2
     */
    public void setX2(int x2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setX2(").appendData(x2).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the y2 field.
     * @return y2
     *
    @SuppressWarnings("unchecked")
    public int getY2(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the y2 field.
     * @param y2 the new value for y2
     */
    public void setY2(int y2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setY2(").appendData(y2).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
