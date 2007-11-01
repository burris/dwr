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

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Shape extends org.directwebremoting.proxy.jsx3.vector.Tag
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Shape(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strTagName 
     * @param left left position (in pixels) of the object relative to its parent container
     * @param top top position (in pixels) of the object relative to its parent container
     * @param width width (in pixels) of the object
     * @param height height (in pixels) of the object
     */
    public Shape(String strTagName, int left, int top, int width, int height)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the path field.
     * @return path
     *
    @SuppressWarnings("unchecked")
    public String getPath(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the path field.
     * @param path the new value for path
     */
    public void setPath(String path)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPath(").appendData(path).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param x 
     * @param y 
     * @param bRel 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Shape pathMoveTo(int x, int y, boolean bRel)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("pathMoveTo(\"" + x + "\", \"" + y + "\", \"" + bRel + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Shape> ctor = org.directwebremoting.proxy.jsx3.vector.Shape.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Shape.class.getName());
        }
    }

    /**
     * 
     * @param x 
     * @param y 
     * @param bRel 
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T pathMoveTo(int x, int y, boolean bRel, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("pathMoveTo(\"" + x + "\", \"" + y + "\", \"" + bRel + "\").");
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

    /**
     * 
     * @param x 
     * @param y 
     * @param bRel 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Shape pathLineTo(int x, int y, boolean bRel)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("pathLineTo(\"" + x + "\", \"" + y + "\", \"" + bRel + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Shape> ctor = org.directwebremoting.proxy.jsx3.vector.Shape.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Shape.class.getName());
        }
    }

    /**
     * 
     * @param x 
     * @param y 
     * @param bRel 
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T pathLineTo(int x, int y, boolean bRel, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("pathLineTo(\"" + x + "\", \"" + y + "\", \"" + bRel + "\").");
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

    /**
     * 
     * @param cx 
     * @param cy 
     * @param rx 
     * @param ry 
     * @param x1 
     * @param y1 
     * @param x2 
     * @param y2 
     * @param bCW 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Shape pathArcTo(int cx, int cy, int rx, int ry, int x1, int y1, int x2, int y2, boolean bCW)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("pathArcTo(\"" + cx + "\", \"" + cy + "\", \"" + rx + "\", \"" + ry + "\", \"" + x1 + "\", \"" + y1 + "\", \"" + x2 + "\", \"" + y2 + "\", \"" + bCW + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Shape> ctor = org.directwebremoting.proxy.jsx3.vector.Shape.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Shape.class.getName());
        }
    }

    /**
     * 
     * @param cx 
     * @param cy 
     * @param rx 
     * @param ry 
     * @param x1 
     * @param y1 
     * @param x2 
     * @param y2 
     * @param bCW 
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T pathArcTo(int cx, int cy, int rx, int ry, int x1, int y1, int x2, int y2, boolean bCW, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("pathArcTo(\"" + cx + "\", \"" + cy + "\", \"" + rx + "\", \"" + ry + "\", \"" + x1 + "\", \"" + y1 + "\", \"" + x2 + "\", \"" + y2 + "\", \"" + bCW + "\").");
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

    /**
     * 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Shape pathClose()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("pathClose().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Shape> ctor = org.directwebremoting.proxy.jsx3.vector.Shape.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Shape.class.getName());
        }
    }

    /**
     * 
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T pathClose(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("pathClose().");
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

    /**
     * Sets the fill of this shape, other fills may be present as children of this instance.
     * @param fill the fill value.
     */
    public void setFill(org.directwebremoting.proxy.jsx3.vector.Fill fill)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFill(").appendData(fill).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the stroke of this shape, other strokes may be present as children of this instance.
     * @param stroke the stroke value.
     */
    public void setStroke(org.directwebremoting.proxy.jsx3.vector.Stroke stroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStroke(").appendData(stroke).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the fill of this shape.
     */
    public void getFill()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("getFill(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the stroke of this shape.
     */
    public void getStroke()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("getStroke(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
