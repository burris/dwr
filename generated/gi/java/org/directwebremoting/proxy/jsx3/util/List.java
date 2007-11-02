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

package org.directwebremoting.proxy.jsx3.util;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class List extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public List(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer. Creates a new list. If a is a number, the list is initialized with
    that size. If a is an array or list, the contents of a are copied into the new list.
     * @param a 
     * @param bLive 
     */
    public List(int a, boolean bLive)
    {
        super((ProxyHelper) null);
    }

    /**
     * If a is already an instance of this class, this method returns a.
    If a is an array, this method returns a new List instance backed by a.
     * @param a 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List wrap(Object[] a)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("wrap(\"" + a + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    /**
     * If a is already an instance of this class, this method returns a.
    If a is an array, this method returns a new List instance backed by a.
     * @param a 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List wrap(org.directwebremoting.proxy.jsx3.util.List a)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("wrap(\"" + a + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public int size(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * 
     * @param intIndex 
     *
    @SuppressWarnings("unchecked")
    public Object get(int intIndex, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * 
     * @param intIndex 
     * @param objElm 
     */
    public void set(int intIndex, Object objElm)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("set(").appendData(intIndex).appendScript(",")

        .appendData(objElm).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Iterator iterator()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("iterator().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Iterator> ctor = org.directwebremoting.proxy.jsx3.util.Iterator.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Iterator.class.getName());
        }
    }

    /**
     * Removes all elements from this list.
     */
    public void clear()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("clear(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the index of the first occurrence of objElm in this list. Comparisons are performed with
    strict equals (===).
     * @param objElm the item to find
     * @param intStartAt 
     * @return the index of the found object or <code>-1</code> if not found.
     *
    @SuppressWarnings("unchecked")
    public int indexOf(Object objElm, int intStartAt, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the index of the last occurrence of objElm in this list. Comparisons are performed with
    strict equals (===).
     * @param objElm the item to find
     * @param intStartAt 
     * @return the index of the found object or -1 if not found
     *
    @SuppressWarnings("unchecked")
    public int lastIndexOf(Object objElm, int intStartAt, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * 
     * @param objElm the item to find
     *
    @SuppressWarnings("unchecked")
    public boolean contains(Object objElm, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Removes the first occurrence of objElm in this list.
     * @param objElm the object to remove
     * @return the removed object or null if no object was removed
     *
    @SuppressWarnings("unchecked")
    public  remove(Object objElm, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Removes a single or a range of elements from this list.
     * @param intStart 
     * @param intEnd 
     * @return the removed object or null if no object was removed
     *
    @SuppressWarnings("unchecked")
    public Object removeAt(int intStart, int intEnd, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * 
     * @param objElm 
     * @param intAt 
     */
    public void add(Object objElm, int intAt)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("add(").appendData(objElm).appendScript(",")

        .appendData(intAt).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param a 
     * @param intAt 
     */
    public void addAll(Object[] a, int intAt)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("addAll(").appendData(a).appendScript(",")

        .appendData(intAt).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param a 
     * @param intAt 
     */
    public void addAll(org.directwebremoting.proxy.jsx3.util.List a, int intAt)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("addAll(").appendData(a).appendScript(",")

        .appendData(intAt).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns a section of this list as another list. The returned section is a copy of this list and is not affected
    by subsequent changes to this list.
     * @param intStart 
     * @param intEnd 
     *
    @SuppressWarnings("unchecked")
    public List slice(int intStart, int intEnd, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sorts this list.
     * @param fctComparator 
     */
    public void sort(org.directwebremoting.proxy.CodeBlock fctComparator)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("sort(").appendData(fctComparator).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns a copy of this list as an array.
     * @param bLive if true, then the returned array is the actual backing array of this list.
     *
    @SuppressWarnings("unchecked")
    public Object[] toArray(boolean bLive, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Creates a new list with the filtered contents of this list. The fctFilter parameter defines
    the filtering function.
     * @param fctFilter a function that is called once for each item in this array and returns true if the item
    should be included in the filtered list. The signature of this function is
    <code>function(item : Object) : boolean</code>.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List filter(org.directwebremoting.proxy.CodeBlock fctFilter)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("filter(\"" + fctFilter + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    /**
     * Creates a new list with the mapped contents of this array. The fctMapper parameter defines
    the mapping function.

    This method has four modes corresponding to the four possible values for {bExpand, bObject}:


          {false, false} (default) Ð the filtering function takes an item in this list and returns
    a single object value which will take the place of the item in the mapped result.

          {true, false} Ð the filtering function takes an item in this list and returns
    a single object value or an array of values, all of which will be inserted into the mapped result at the index
    of the item.

          {false, true} Ð the filtering function takes an item in this list and returns an array with
    exactly two values, which become a name/value pair in the mapped result.

          {true, true} Ð the filtering function takes an item in this list and returns an array with
    zero or an even number of items, which become name/value pairs in the mapped result.
     * @param fctMapper a function that is called once for each item in this array and returns the mapped
    value. The signature of this function depends on the values for the <code>bExpand</code> and
    <code>bObject</code> parameters.
     * @param bExpand if <code>true</code>, the resulting mapped array or object may any number of values
    corresponding to each item in this list. Otherwise, it will have exactly one value for each item in this list.
     * @param bObject if <code>true</code>, this array is mapped to an object with property name/value pairs.
    Otherwise this array is mapped to another array.
     * @return a list if the <code>bObject</code> parameter is <code>null</code> or
    <code>false</code>, otherwise an <code>Object</code>.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List map(org.directwebremoting.proxy.CodeBlock fctMapper, boolean bExpand, boolean bObject)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("map(\"" + fctMapper + "\", \"" + bExpand + "\", \"" + bObject + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

}
