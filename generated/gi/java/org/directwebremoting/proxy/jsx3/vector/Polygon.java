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
public class Polygon extends org.directwebremoting.proxy.jsx3.vector.Shape
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Polygon(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param left left position (in pixels) of the object relative to its parent container
     * @param top top position (in pixels) of the object relative to its parent container
     * @param points the list of points comprising the polygon
     */
    public Polygon(int left, int top, String points)
    {
        super((ProxyHelper) null);
    }

    /**
     * Sets the polygon points as an array of point objects or strings.
     * @param points an array of strings or objects to stringify as "x y"
     */
    public void setPoints(Object[] points)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPoints(").appendData(points).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the polygon points as an array of coordinates.
     * @param points an array of alternating x and y coordinates
     */
    public void setPointsAsNumberArray(Object[] points)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPointsAsNumberArray(").appendData(points).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the points as a string.
     * @param points a string in the form "x1 y1 x2 y2 ..."
     */
    public void setPointsAsString(String points)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPointsAsString(").appendData(points).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
