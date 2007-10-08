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
public class Fill extends org.directwebremoting.proxy.jsx3.html.Tag
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Fill(ProxyHelper helper)
    {
        super(helper);
    }

    
    /**
     * Returns the color field, as previously set in the constructor or with setColor().
     */
    public void getColor()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getColor(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the color field, as a CSS hex string.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getColorHtml(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the color field.
     * @param color the new value for color
     */
    public void setColor(String color)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setColor(")
              .appendData(color)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the color field.
     * @param color the new value for color
     */
    public void setColor(int color)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setColor(")
              .appendData(color)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the alpha field, as previously set in the constructor or with setAlpha().
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
     * Sets the alpha field, valid values are between 0 (transparent) and 1 (opaque)..
     * @param alpha the new value for alpha
     */
    public void setAlpha(float alpha)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setAlpha(")
              .appendData(alpha)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the type field, as set with setType().
     * @return type
     *
    @SuppressWarnings("unchecked")
    public String getType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the type field, valid values are enumerated in the VML specification, though only 'solid', 'gradient', and 'gradientradial' are truly supported by this class.
     * @param type the new value for type
     */
    public void setType(String type)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setType(")
              .appendData(type)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Returns the color2 field, as set with setColor2().
     */
    public void getColor2()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getColor2(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * ? getColor2Html() {String} gets the color2 field, as a CSS hex string
     */
    public void getColor2Html()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("getColor2Html(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the color2 field.
     * @param color2 the new value for color2
     */
    public void setColor2(String color2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setColor2(")
              .appendData(color2)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the color2 field.
     * @param color2 the new value for color2
     */
    public void setColor2(int color2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setColor2(")
              .appendData(color2)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the alpha2 field, as set with setAlpha2().
     * @return alpha2
     *
    @SuppressWarnings("unchecked")
    public float getAlpha2(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the alpha2 field, valid values are between 0 (transparent) and 1 (opaque)..
     * @param alpha2 the new value for alpha2
     */
    public void setAlpha2(float alpha2)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setAlpha2(")
              .appendData(alpha2)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the angle field (the angle along which the gradient goes), as set with setAngle().
     * @return angle
     *
    @SuppressWarnings("unchecked")
    public int getAngle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the angle field, valid values are between 0 and 360. 0 is the vector pointing rightward.
     * @param angle the new value for angle
     */
    public void setAngle(int angle)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setAngle(")
              .appendData(angle)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the colors field, as set with setColors().
     * @return colors
     *
    @SuppressWarnings("unchecked")
    public String getColors(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets the colors field, see the documentation for <fill> in the VML documentation.
     * @param colors the new value for colors
     */
    public void setColors(String colors)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setColors(")
              .appendData(colors)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Parses a vector fill from its string representation. The format is "color alpha".
     * @param v the string representation of a fill.
     * @return <code>null</code> if <code>v</code> is empty, <code>v</code> if <code>v</code>
    is already a vector fill, or otherwise a new vector fill created by parsing the string according to the
    format specified above.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Fill valueOf(String v)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("valueOf(\"" + v + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Fill> ctor = org.directwebremoting.proxy.jsx3.vector.Fill.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Fill.class.getName());
        }
    }

    
    
    /**
     * Parses a vector fill from its string representation. The format is "color alpha".
     * @param v the string representation of a fill.
     * @return <code>null</code> if <code>v</code> is empty, <code>v</code> if <code>v</code>
    is already a vector fill, or otherwise a new vector fill created by parsing the string according to the
    format specified above.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.vector.Fill valueOf(org.directwebremoting.proxy.jsx3.vector.Fill v)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("valueOf(\"" + v + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.vector.Fill> ctor = org.directwebremoting.proxy.jsx3.vector.Fill.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.vector.Fill.class.getName());
        }
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
