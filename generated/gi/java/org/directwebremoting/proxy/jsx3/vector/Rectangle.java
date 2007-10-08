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

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Rectangle extends org.directwebremoting.proxy.jsx3.vector.Shape
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Rectangle(ProxyHelper helper)
    {
        super(helper);
    }

    
    /**
     * Clips this rectangle to the bounds of obj.
     * @param obj any object that has <code>getLeft()</code>, etc methods.
     */
    public void clipToBox(org.directwebremoting.proxy.jsx3.gui.Block obj)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("clipToBox(")
              .appendData(obj)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Clips this rectangle to the bounds of obj.
     * @param obj any object that has <code>getLeft()</code>, etc methods.
     */
    public void clipToBox(org.directwebremoting.proxy.jsx3.html.BlockTag obj)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("clipToBox(")
              .appendData(obj)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Clips this rectangle to the bounds of {l1, t1, w1, h1}.
     * @param l1 
     * @param t1 
     * @param w1 
     * @param h1 
     */
    public void clipTo(int l1, int t1, int w1, int h1)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("clipTo(")
              .appendData(l1)
              .appendScript(",")
              
              .appendData(t1)
              .appendScript(",")
              
              .appendData(w1)
              .appendScript(",")
              
              .appendData(h1)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Returns the fill of this shape.
     */
    public void getFill()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getFill(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
     * Returns the stroke of this shape.
     */
    public void getStroke()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getStroke(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
     * @param type The expected return type
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
     * @param type The expected return type
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
     * @param type The expected return type
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
     * @param type The expected return type
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
     * Sets the fill of this shape, other fills may be present as children of this instance.
     * @param fill the fill value.
     */
    public void setFill(org.directwebremoting.proxy.jsx3.vector.Fill fill)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setFill(")
              .appendData(fill)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the path field.
     * @param path the new value for path
     */
    public void setPath(String path)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setPath(")
              .appendData(path)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the stroke of this shape, other strokes may be present as children of this instance.
     * @param stroke the stroke value.
     */
    public void setStroke(org.directwebremoting.proxy.jsx3.vector.Stroke stroke)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setStroke(")
              .appendData(stroke)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the rotation field.
     * @return rotation
     *
    @SuppressWarnings("unchecked")
    public int getRotation(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the tooltip, the text that is displayed on mouse over.
     */
    public void getToolTip()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getToolTip(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the rotation field, an angle between 0 and 360.
     * @param rotation the new value for rotation
     */
    public void setRotation(int rotation)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setRotation(")
              .appendData(rotation)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the tooltip, the text that is displayed on mouse over.
     * @param title 
     */
    public void setToolTip(String title)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setToolTip(")
              .appendData(title)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the bgcolor field.
     * @return bgcolor
     *
    @SuppressWarnings("unchecked")
    public String getBackgroundColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the dimensions in an array of four int values
     * @return [left,top,width,height]
     *
    @SuppressWarnings("unchecked")
    public Object[] getDimensions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the height field.
     * @return height
     *
    @SuppressWarnings("unchecked")
    public int getHeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the left field.
     * @return left
     *
    @SuppressWarnings("unchecked")
    public int getLeft(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the margin field, as set by setMargin().
     * @return margin
     *
    @SuppressWarnings("unchecked")
    public String getMargin(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * parses the margin field into an array of four int values
     * @return [top,right,bottom,left]
     *
    @SuppressWarnings("unchecked")
    public Object[] getMarginDimensions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the padding field, as set by setPadding().
     * @return padding
     *
    @SuppressWarnings("unchecked")
    public String getPadding(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * parses the padding field into an array of four int values
     * @return [top,right,bottom,left]
     *
    @SuppressWarnings("unchecked")
    public Object[] getPaddingDimensions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the position field.
     * @return position
     *
    @SuppressWarnings("unchecked")
    public String getPosition(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the top field.
     * @return top
     *
    @SuppressWarnings("unchecked")
    public int getTop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the width field.
     * @return width
     *
    @SuppressWarnings("unchecked")
    public int getWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the zIndex field.
     * @return zIndex
     *
    @SuppressWarnings("unchecked")
    public int getZIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the bgcolor field.
     * @param bgcolor the new value for bgcolor
     */
    public void setBackgroundColor(String bgcolor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setBackgroundColor(")
              .appendData(bgcolor)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets all four dimensions at once.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
     */
    public void setDimensions(int left, int top, int width, int height)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setDimensions(")
              .appendData(left)
              .appendScript(",")
              
              .appendData(top)
              .appendScript(",")
              
              .appendData(width)
              .appendScript(",")
              
              .appendData(height)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the height field.
     * @param height the new value for height
     */
    public void setHeight(int height)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setHeight(")
              .appendData(height)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the left field.
     * @param left the new value for left
     */
    public void setLeft(int left)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setLeft(")
              .appendData(left)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the margin field, can be a single value or four values separated by space that correspond to top, right, bottom, and left.
     * @param margin the new value for margin
     */
    public void setMargin(String margin)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setMargin(")
              .appendData(margin)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the padding field, can be a single value or four values separated by space that correspond to top, right, bottom, and left.
     * @param padding the new value for padding
     */
    public void setPadding(String padding)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setPadding(")
              .appendData(padding)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the position field, can be 'absolute' or 'relative'.
     * @param position the new value for position
     */
    public void setPosition(String position)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setPosition(")
              .appendData(position)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the top field.
     * @param top the new value for top
     */
    public void setTop(int top)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setTop(")
              .appendData(top)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the width field.
     * @param width the new value for width
     */
    public void setWidth(int width)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setWidth(")
              .appendData(width)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the zIndex field.
     * @param zIndex the new value for zIndex
     */
    public void setZIndex(int zIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setZIndex(")
              .appendData(zIndex)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sdds a child to the list of this tag's children; may be vetoed by onAppendChild().
     * @param child the child to add, must not already have a parent
     */
    public void appendChild(org.directwebremoting.proxy.jsx3.html.Tag child)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("appendChild(")
              .appendData(child)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the children tags.
     * @return children
     *
    @SuppressWarnings("unchecked")
    public Object[] getChildren(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the cssClass field.
     * @return cssClass
     *
    @SuppressWarnings("unchecked")
    public String getClassName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the first child tag of type type.
     * @param type the fully-qualified class name or the class constructor function.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.html.Tag getFirstChildOfType(String type)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + type + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.html.Tag> ctor = org.directwebremoting.proxy.jsx3.html.Tag.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.html.Tag.class.getName());
        }
    }

    
    
    /**
     * Returns the first child tag of type type.
     * @param type the fully-qualified class name or the class constructor function.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChildOfType(String type, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + type + "\").");
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
     * Returns the id field.
     * @return id
     *
    @SuppressWarnings("unchecked")
    public String getId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the parent tag.
     * @return parent
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.html.Tag getParent()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.html.Tag> ctor = org.directwebremoting.proxy.jsx3.html.Tag.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.html.Tag.class.getName());
        }
    }

    
    
    /**
     * Returns the parent tag.
     * @param type The expected return type
     * @return parent
     */
    @SuppressWarnings("unchecked")
    public <T> T getParent(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
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
     * Returns an attribute of this HTML element.
     * @param strName the name of the attribute.
     * @return the value of the attribute.
     *
    @SuppressWarnings("unchecked")
    public String getProperty(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns a style of this HTML element.
     * @param strName the name of the style.
     * @return the value of the style.
     *
    @SuppressWarnings("unchecked")
    public String getStyle(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the namespace of this HTML element.
     * @return the tag name
     *
    @SuppressWarnings("unchecked")
    public String getTagNS(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the name of this HTML element, such as "table" or "div".
     * @return the tag name
     *
    @SuppressWarnings("unchecked")
    public String getTagName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Called before appending a child.
     * @param child 
     * @return <code>true</code> to allow the append, <code>false</code> to veto.
     *
    @SuppressWarnings("unchecked")
    public boolean onAppendChild(org.directwebremoting.proxy.jsx3.html.Tag child, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Called before removing a child.
     * @param child 
     * @return <code>true</code> to allow the removal, <code>false</code> to veto.
     *
    @SuppressWarnings("unchecked")
    public boolean onRemoveChild(org.directwebremoting.proxy.jsx3.html.Tag child, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Serializes this HTML element to an HTML string using various overridable methods in this class.
This method is only available in the VML version of this class.
     * @return this tag serialized to HTML.
     *
    @SuppressWarnings("unchecked")
    public String paint(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Prepares this HTML element for insertion into the live browser DOM and returns the underlying native HTML element.
This method is only available in the SVG version of this class.
     * @return the native browser html element.
     *
    @SuppressWarnings("unchecked")
    public String paintDom(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * This method is called on each HTML tag before it is painted to screen. Methods in subclasses of this class that
override this method should begin with a call to jsxsuper().
     */
    public void paintUpdate()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("paintUpdate(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Releases all bi-directional references between this instance and its children.
     */
    public void release()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("release(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Removes a child from the list of this tag's children; may be vetoed by onRemoveChild().
     * @param child the child to remove, must exist in the list of children
     */
    public void removeChild(org.directwebremoting.proxy.jsx3.html.Tag child)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("removeChild(")
              .appendData(child)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Removes all the children of this tag.
     */
    public void removeChildren()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("removeChildren(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Removes any number of properties from this HTML element.
     * @param strName the names of the attributes.
     */
    public void removeProperty(String strName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("removeProperty(")
              .appendData(strName)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Removes any number of styles from this HTML element.
     * @param strName the names of the styles.
     */
    public void removeStyle(String strName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("removeStyle(")
              .appendData(strName)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Replaces a child of this tag.
     * @param child the new child.
     * @param oldChild the child to replace.
     */
    public void replaceChild(org.directwebremoting.proxy.jsx3.html.Tag child, org.directwebremoting.proxy.jsx3.html.Tag oldChild)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("replaceChild(")
              .appendData(child)
              .appendScript(",")
              
              .appendData(oldChild)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the cssClass field, the HTML 'class' attribute.
     * @param cssClass the new value for cssClass
     */
    public void setClassName(String cssClass)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setClassName(")
              .appendData(cssClass)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the extraStyles field, this string is prepended as-is to the generated value for the style attribute of the tag.
     * @param extraStyles the new value for extraStyles
     */
    public void setExtraStyles(String extraStyles)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setExtraStyles(")
              .appendData(extraStyles)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the id field.
     * @param id the new value for id
     */
    public void setId(String id)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setId(")
              .appendData(id)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets an attribute of this HTML element. This method may be called with a variable number of arguments, which are
interpreted as name/value pairs, i.e.: tag.setProperty(n1, p1, n2, p2);.
     * @param strName the name of the attribute.
     * @param strValue the value of the attribute. If <code>null</code>, the attribute is removed.
     */
    public void setProperty(String strName, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setProperty(")
              .appendData(strName)
              .appendScript(",")
              
              .appendData(strValue)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets a style of this HTML element. This method may be called with a variable number of arguments, which are
interpreted as name/value pairs, i.e.: tag.setStyle(n1, s1, n2, s2);.
     * @param strName the name of the style.
     * @param strValue the value of the style.
     */
    public void setStyle(String strName, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setStyle(")
              .appendData(strName)
              .appendScript(",")
              
              .appendData(strValue)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String toString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
 }
