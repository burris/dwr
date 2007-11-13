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
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class List extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public List(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer. Creates a new list. If a is a number, the list is initialized with
    that size. If a is an array or list, the contents of a are copied into the new list.
     * @param a 
     * @param bLive 
     */
    public List(int a, boolean bLive)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new List", a, bLive);
        setInitScript(script);
    }

    /**
     * If a is already an instance of this class, this method returns a.
    If a is an array, this method returns a new List instance backed by a.
     * @param a 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List wrap(Object[] a)
    {
        String extension = "wrap(\"" + a + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "wrap(\"" + a + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void size(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = size");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param intIndex 
     */
    @SuppressWarnings("unchecked")
    public void get(int intIndex, Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = get", intIndex);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param intIndex 
     * @param objElm 
     */
    public void set(int intIndex, Object objElm)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("set", intIndex, objElm);
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Iterator iterator()
    {
        String extension = "iterator().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Iterator> ctor = org.directwebremoting.proxy.jsx3.util.Iterator.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        script.appendCall("clear");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the index of the first occurrence of objElm in this list. Comparisons are performed with
    strict equals (===).
     * @param objElm the item to find
     * @param intStartAt 
     * @param callback the index of the found object or <code>-1</code> if not found.
     */
    @SuppressWarnings("unchecked")
    public void indexOf(Object objElm, int intStartAt, Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = indexOf", objElm, intStartAt);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the index of the last occurrence of objElm in this list. Comparisons are performed with
    strict equals (===).
     * @param objElm the item to find
     * @param intStartAt 
     * @param callback the index of the found object or -1 if not found
     */
    @SuppressWarnings("unchecked")
    public void lastIndexOf(Object objElm, int intStartAt, Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = lastIndexOf", objElm, intStartAt);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param objElm the item to find
     */
    @SuppressWarnings("unchecked")
    public void contains(Object objElm, Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = contains", objElm);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Removes the first occurrence of objElm in this list.
     * @param objElm the object to remove
     * @param callback the removed object or null if no object was removed
     */
    @SuppressWarnings("unchecked")
    public void remove(Object objElm, Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = remove", objElm);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Removes a single or a range of elements from this list.
     * @param intStart 
     * @param intEnd 
     * @param callback the removed object or null if no object was removed
     */
    @SuppressWarnings("unchecked")
    public void removeAt(int intStart, int intEnd, Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = removeAt", intStart, intEnd);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param objElm 
     * @param intAt 
     */
    public void add(Object objElm, int intAt)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("add", objElm, intAt);
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param a 
     * @param intAt 
     */
    public void addAll(Object[] a, int intAt)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("addAll", a, intAt);
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param a 
     * @param intAt 
     */
    public void addAll(org.directwebremoting.proxy.jsx3.util.List a, int intAt)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("addAll", a, intAt);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns a section of this list as another list. The returned section is a copy of this list and is not affected
    by subsequent changes to this list.
     * @param intStart 
     * @param intEnd 
     */
    @SuppressWarnings("unchecked")
    public void slice(int intStart, int intEnd, Callback<List> callback)
    {
        String key = CallbackHelper.saveCallback(callback, List.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = slice", intStart, intEnd);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sorts this list.
     * @param fctComparator 
     */
    public void sort(org.directwebremoting.proxy.CodeBlock fctComparator)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("sort", fctComparator);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns a copy of this list as an array.
     * @param bLive if true, then the returned array is the actual backing array of this list.
     */
    @SuppressWarnings("unchecked")
    public void toArray(boolean bLive, Callback<Object[]> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object[].class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = toArray", bLive);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

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
        String extension = "filter(\"" + fctFilter + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "map(\"" + fctMapper + "\", \"" + bExpand + "\", \"" + bObject + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

}
