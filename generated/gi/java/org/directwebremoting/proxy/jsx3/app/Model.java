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

package org.directwebremoting.proxy.jsx3.app;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Model extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Model(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strName a unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param strInstanceOf 
     */
    public Model(String strName, String strInstanceOf)
    {
        super((ProxyHelper) null);
    }

    /**
     * Persistance value fora child that is temporarily part of the DOM tree and will not be persisted.
     */
    public static final int PERSISTNONE = 0;

    /**
     * Normal persistance value for a child that will be persisted.
     */
    public static final int PERSISTEMBED = 1;

    /**
     * Persistance value for a child that exists in an external serialization file and is referenced by URI.
     */
    public static final int PERSISTREF = 2;

    /**
     * Persistance value for a child that exists in an external serialization file and is referenced by URI. The
    loading of a child with this persistence value will happen asynchronously after the file that references it is
    loaded.
     */
    public static final int PERSISTREFASYNC = 3;

    /**
     * The normal load type for a DOM branch. The DOM branch deserializes and paints with its parent.
     */
    public static final int LT_NORMAL = 0;

    /**
     * Load type indicating that the DOM branch will paint after its parent paints and the call stack resets.
     */
    public static final int LT_SLEEP_PAINT = 1;

    /**
     * Load type indicating that the DOM branch will deserialize and paint after its parent deserializes and the
    call stack resets.
     */
    public static final int LT_SLEEP_DESER = 2;

    /**
     * Load type indicating that the DOM branch will deserialize after its parent deserializes and the call stack
    resets and will paint after its parent paints and the call stack resets.
     */
    public static final int LT_SLEEP_PD = 3;

    /**
     * Load type indicating that the DOM branch will paint as needed when it becomes visible. It is left to
    subclasses of Model to implement this functionality.
     */
    public static final int LT_SHOW_PAINT = 4;

    /**
     * Load type indicating that the DOM branch will deserialize and paint as needed when it becomes visible.
    It is left to subclasses of Model to implement this functionality.
     */
    public static final int LT_SHOW_DESER = 5;

    /**
     * Minimum supported version for serialization files
     */
    public static final String CURRENT_VERSION = "urn:tibco.com/v3.0";

    /**
     * Minimum supported version CIF formatted serialization files
     */
    public static final String CIF_VERSION = "http://xsd.tns.tibco.com/gi/cif/2006";

    /**
     * The number of milliseconds before asynchronous component loads time out.
     */
    public static final int ASYNC_LOAD_TIMEOUT = 60000;

    /**
     * Returns the child DOM node of this node at the given index or with the given name. If a name is supplied, the
    children are searched in order and the first matching child is returned.
     * @param vntIndexOrName either the integer index or the string name of the child.
     * @return the child at the given index or with the given name, or <code>null</code> if no such
    child exists.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getChild(int vntIndexOrName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChild(\"" + vntIndexOrName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the child DOM node of this node at the given index or with the given name. If a name is supplied, the
    children are searched in order and the first matching child is returned.
     * @param vntIndexOrName either the integer index or the string name of the child.
     * @param returnType The expected return type
     * @return the child at the given index or with the given name, or <code>null</code> if no such
    child exists.
     */
    @SuppressWarnings("unchecked")
    public <T> T getChild(int vntIndexOrName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChild(\"" + vntIndexOrName + "\").");
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
     * Returns the child DOM node of this node at the given index or with the given name. If a name is supplied, the
    children are searched in order and the first matching child is returned.
     * @param vntIndexOrName either the integer index or the string name of the child.
     * @return the child at the given index or with the given name, or <code>null</code> if no such
    child exists.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getChild(String vntIndexOrName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChild(\"" + vntIndexOrName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the child DOM node of this node at the given index or with the given name. If a name is supplied, the
    children are searched in order and the first matching child is returned.
     * @param vntIndexOrName either the integer index or the string name of the child.
     * @param returnType The expected return type
     * @return the child at the given index or with the given name, or <code>null</code> if no such
    child exists.
     */
    @SuppressWarnings("unchecked")
    public <T> T getChild(String vntIndexOrName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChild(\"" + vntIndexOrName + "\").");
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
     * Returns the first child.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getFirstChild()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChild().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the first child.
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChild(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChild().");
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
     * Returns the last child.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getLastChild()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLastChild().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the last child.
     */
    @SuppressWarnings("unchecked")
    public <T> T getLastChild(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLastChild().");
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
     * Returns the next sibling.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getNextSibling()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getNextSibling().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the next sibling.
     */
    @SuppressWarnings("unchecked")
    public <T> T getNextSibling(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getNextSibling().");
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
     * Returns the previous sibling.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getPreviousSibling()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPreviousSibling().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the previous sibling.
     */
    @SuppressWarnings("unchecked")
    public <T> T getPreviousSibling(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPreviousSibling().");
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
     * Returns an array containing all the child DOM nodes of this object. The return value is the original array rather
    than a copy and should not be modified.
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
     * Returns the persistence bit for this model object.
     * @return one of <code>PERSISTNONE</code>, <code>PERSISTEMBED</code>, <code>PERSISTREF</code>,
    <code>PERSISTREFASYNC</code>.
     *
    @SuppressWarnings("unchecked")
    public int getPersistence(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the persistence bit for this model object.
     * @param intPersist one of <code>PERSISTNONE</code>, <code>PERSISTEMBED</code>, <code>PERSISTREF</code>,
    <code>PERSISTREFASYNC</code>.
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.app.Model setPersistence(int intPersist)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPersistence(").appendData(intPersist).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Appends a child DOM node to this parent DOM node. If the child already has a parent, adoptChild()
    should be used instead to ensure that the child is removed from its current parent.
     * @param objChild the root node of a DOM fragment.
     * @param intPersist defines how the child will be persisted/serialized. The valid values are the four
    persistence values defined as static fields in this class.
     * @param strSourceURL the path to the serialization file where the child exists. This parameter is only
    relevant if the given <code>intPersist</code> is <code>PERSISTREF</code> or <code>PERSISTREFASYNC</code>.
     * @param strNS the namespace of the child to append. This parameter is normally not required but is useful
    when sharing DOM nodes between servers with different namespaces.
     * @return this object or <code>false</code> if the set was vetoed
     */
    public org.directwebremoting.proxy.jsx3.app.Model setChild(org.directwebremoting.proxy.jsx3.app.Model objChild, int intPersist, String strSourceURL, String strNS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setChild(").appendData(objChild).appendScript(",")

        .appendData(intPersist).appendScript(",")

        .appendData(strSourceURL).appendScript(",")

        .appendData(strNS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Appends a child DOM node to this parent DOM node. If the child already has a parent, adoptChild()
    should be used instead to ensure that the child is removed from its current parent.
     * @param objChild the root node of a DOM fragment.
     * @param intPersist defines how the child will be persisted/serialized. The valid values are the four
    persistence values defined as static fields in this class.
     * @param strSourceURL the path to the serialization file where the child exists. This parameter is only
    relevant if the given <code>intPersist</code> is <code>PERSISTREF</code> or <code>PERSISTREFASYNC</code>.
     * @param strNS the namespace of the child to append. This parameter is normally not required but is useful
    when sharing DOM nodes between servers with different namespaces.
     * @return this object or <code>false</code> if the set was vetoed
     */
    public org.directwebremoting.proxy.jsx3.app.Model setChild(org.directwebremoting.proxy.jsx3.app.Model objChild, int intPersist, org.directwebremoting.proxy.jsx3.net.URI strSourceURL, String strNS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setChild(").appendData(objChild).appendScript(",")

        .appendData(intPersist).appendScript(",")

        .appendData(strSourceURL).appendScript(",")

        .appendData(strNS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Hook that allows for a prospective parent DOM node to veto the adoption of a child.
     * @param objChild 
     * @return true to allow the set, false to veto
     *
    @SuppressWarnings("unchecked")
    public boolean onSetChild(Object objChild, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Hook that allows for a prospective child DOM node to veto its adoption by a parent. This method is only called if
    the prospective parent has not already vetoed the adoption in the onSetChild() method.
     * @param objParent 
     * @return true to allow the set, false to veto
     *
    @SuppressWarnings("unchecked")
    public boolean onSetParent(Object objParent, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Hook that notifies this model object that one of its children has been removed. This hook exists simply to allow
    this object to perform cleanup/re-render, and does not provide a veto mechanism. This method is called after
    the child has been removed from the model (this.getChildren() does not contain objChild)
    and after the child has been removed from the view (objChild.getRendered() is also null).

    This method is only called if the child is being removed from the DOM but this object (the parent) is not
    being removed. Therefore, this hook cannot be relied upon for garbage collection.

    If removeChildren() is called on this object, this hook is called exactly once after all children
    have been removed. In that case, the first parameter to this method will be the array of children and the
    second parameter will be null.

    In general a method overriding this method should begin by calling jsxsuper.
     * @param objChild the child that was removed
     * @param intIndex the index of the removed child
     */
    public void onRemoveChild(org.directwebremoting.proxy.jsx3.app.Model objChild, int intIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onRemoveChild(").appendData(objChild).appendScript(",")

        .appendData(intIndex).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Hook that notifies this model object that one of its children has been removed. This hook exists simply to allow
    this object to perform cleanup/re-render, and does not provide a veto mechanism. This method is called after
    the child has been removed from the model (this.getChildren() does not contain objChild)
    and after the child has been removed from the view (objChild.getRendered() is also null).

    This method is only called if the child is being removed from the DOM but this object (the parent) is not
    being removed. Therefore, this hook cannot be relied upon for garbage collection.

    If removeChildren() is called on this object, this hook is called exactly once after all children
    have been removed. In that case, the first parameter to this method will be the array of children and the
    second parameter will be null.

    In general a method overriding this method should begin by calling jsxsuper.
     * @param objChild the child that was removed
     * @param intIndex the index of the removed child
     */
    public void onRemoveChild(Object[] objChild, int intIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onRemoveChild(").appendData(objChild).appendScript(",")

        .appendData(intIndex).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes a DOM child from this object. This method removes the on-screen DHTML of the removed object. The removed
    child will be completely derefenced from the DOM and will be prepped for garbage collection. If a DOM child must
    continue to exist after removing it from this parent, adoptChild() should be used instead of this
    method.
     * @param vntItem either the index of the child to remove or the child itself.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model removeChild(int vntItem)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChild(\"" + vntItem + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Removes a DOM child from this object. This method removes the on-screen DHTML of the removed object. The removed
    child will be completely derefenced from the DOM and will be prepped for garbage collection. If a DOM child must
    continue to exist after removing it from this parent, adoptChild() should be used instead of this
    method.
     * @param vntItem either the index of the child to remove or the child itself.
     * @param returnType The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T removeChild(int vntItem, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChild(\"" + vntItem + "\").");
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
     * Removes a DOM child from this object. This method removes the on-screen DHTML of the removed object. The removed
    child will be completely derefenced from the DOM and will be prepped for garbage collection. If a DOM child must
    continue to exist after removing it from this parent, adoptChild() should be used instead of this
    method.
     * @param vntItem either the index of the child to remove or the child itself.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model removeChild(org.directwebremoting.proxy.jsx3.app.Model vntItem)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChild(\"" + vntItem + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Removes a DOM child from this object. This method removes the on-screen DHTML of the removed object. The removed
    child will be completely derefenced from the DOM and will be prepped for garbage collection. If a DOM child must
    continue to exist after removing it from this parent, adoptChild() should be used instead of this
    method.
     * @param vntItem either the index of the child to remove or the child itself.
     * @param returnType The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T removeChild(org.directwebremoting.proxy.jsx3.app.Model vntItem, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChild(\"" + vntItem + "\").");
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
     * Removes some or all children of this object.
     * @param arrChildren the children to remove. If this parameter is not provided then all
    children are removed.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model removeChildren(Object[] arrChildren)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChildren(\"" + arrChildren + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Removes some or all children of this object.
     * @param arrChildren the children to remove. If this parameter is not provided then all
    children are removed.
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T removeChildren(Object[] arrChildren, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChildren(\"" + arrChildren + "\").");
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
     * Returns an object reference to the server that owns this object. This method returns null if this
    object is part of a DOM fragment. Until an object is added to a DOM tree by passing it as the parameter to
    setChild(), the object will be a DOM fragment.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Server getServer()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getServer().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Server> ctor = org.directwebremoting.proxy.jsx3.app.Server.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Server.class.getName());
        }
    }

    /**
     * Appends a DOM node to this object after removing the node from its former parent reference. If the node to append
    does not already have a DOM parent, setChild() should be used instead of this method.
     * @param objChild the child to adopt
     * @param bRepaint if <code>true</code> or <code>null</code>, the object being adopted will be added to
    the parent's view via the parent's <code>paintChild()</code> method.
    This parameter is made available for those situations where a loop is executing and multiple
    objects are being adopted.  As view operations are the most CPU intensive, passing <code>false</code>
    while looping through a collection of child objects to adopt will improve performance. After the
    last child is adopted, simply call <code>repaint()</code> on the parent to immediately synchronize the view.
     * @param bForce if true, the adoption is forced, even if the parent/child don't accept such adoptions (<code>onSetChild()</code> and <code>onSetParent()</code> will still be called)
     */
    public void adoptChild(org.directwebremoting.proxy.jsx3.app.Model objChild, boolean bRepaint, boolean bForce)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("adoptChild(").appendData(objChild).appendScript(",")

        .appendData(bRepaint).appendScript(",")

        .appendData(bForce).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Assigns objMoveChild as the previousSibling of objPrecedeChild
     * @param objMoveChild the one being moved. Can belong to this object, another object, or can be a GUI fragment
     * @param objPrecedeChild the one to insert before
     * @param bRepaint if <code>false</code> the repaint will be suppressed (useful for multiple obejct updates
    that would lead to unnecessary updates to the VIEW)
     * @return true if successful
     *
    @SuppressWarnings("unchecked")
    public boolean insertBefore(org.directwebremoting.proxy.jsx3.app.Model objMoveChild, org.directwebremoting.proxy.jsx3.app.Model objPrecedeChild, boolean bRepaint, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Called when the server owning this DOM node changes.
     * @param objNewServer 
     * @param objOldServer 
     */
    public void onChangeServer(org.directwebremoting.proxy.jsx3.app.Server objNewServer, org.directwebremoting.proxy.jsx3.app.Server objOldServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onChangeServer(").appendData(objNewServer).appendScript(",")

        .appendData(objOldServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Creates and returns an exact replica of the object. The clone will be appended as a new child node of this
    object's parent node.
     * @param intPersist the persistance value of the clone.
     * @param intMode <code>0</code> for insert as the last child of the parent of this object and paint,
    <code>1</code> for insert as the last child of this parent of this object and do not paint, or <code>2</code>
    for load as a fragment.
     * @return the clone.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model doClone(int intPersist, int intMode)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("doClone(\"" + intPersist + "\", \"" + intMode + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Creates and returns an exact replica of the object. The clone will be appended as a new child node of this
    object's parent node.
     * @param intPersist the persistance value of the clone.
     * @param intMode <code>0</code> for insert as the last child of the parent of this object and paint,
    <code>1</code> for insert as the last child of this parent of this object and do not paint, or <code>2</code>
    for load as a fragment.
     * @param returnType The expected return type
     * @return the clone.
     */
    @SuppressWarnings("unchecked")
    public <T> T doClone(int intPersist, int intMode, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("doClone(\"" + intPersist + "\", \"" + intMode + "\").");
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
     * Finds the first descendant of this DOM node with a the given name.
     * @param strName the name to query on.
     * @param bDepthFirst specifies whether to do a depth first or breadth first search.
     * @param bChildOnly if <code>true</code>, only search the children of this DOM node.
     * @return the descendant with the given name or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getDescendantOfName(String strName, boolean bDepthFirst, boolean bChildOnly)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDescendantOfName(\"" + strName + "\", \"" + bDepthFirst + "\", \"" + bChildOnly + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Finds the first descendant of this DOM node with a the given name.
     * @param strName the name to query on.
     * @param bDepthFirst specifies whether to do a depth first or breadth first search.
     * @param bChildOnly if <code>true</code>, only search the children of this DOM node.
     * @param returnType The expected return type
     * @return the descendant with the given name or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getDescendantOfName(String strName, boolean bDepthFirst, boolean bChildOnly, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDescendantOfName(\"" + strName + "\", \"" + bDepthFirst + "\", \"" + bChildOnly + "\").");
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
     * Finds the first child of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bExact if <code>true</code> then only return objects whose class is exactly <code>strType</code>
    (rather than returning subclasses too).
     * @return the child of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getFirstChildOfType(String strType, boolean bExact)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + strType + "\", \"" + bExact + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Finds the first child of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bExact if <code>true</code> then only return objects whose class is exactly <code>strType</code>
    (rather than returning subclasses too).
     * @param returnType The expected return type
     * @return the child of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChildOfType(String strType, boolean bExact, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + strType + "\", \"" + bExact + "\").");
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
     * Finds the first child of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bExact if <code>true</code> then only return objects whose class is exactly <code>strType</code>
    (rather than returning subclasses too).
     * @return the child of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getFirstChildOfType(org.directwebremoting.proxy.CodeBlock strType, boolean bExact)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + strType + "\", \"" + bExact + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Finds the first child of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bExact if <code>true</code> then only return objects whose class is exactly <code>strType</code>
    (rather than returning subclasses too).
     * @param returnType The expected return type
     * @return the child of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChildOfType(org.directwebremoting.proxy.CodeBlock strType, boolean bExact, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + strType + "\", \"" + bExact + "\").");
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
     * Finds the first child of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bExact if <code>true</code> then only return objects whose class is exactly <code>strType</code>
    (rather than returning subclasses too).
     * @return the child of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getFirstChildOfType(Class strType, boolean bExact)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + strType + "\", \"" + bExact + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Finds the first child of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bExact if <code>true</code> then only return objects whose class is exactly <code>strType</code>
    (rather than returning subclasses too).
     * @param returnType The expected return type
     * @return the child of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChildOfType(Class strType, boolean bExact, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + strType + "\", \"" + bExact + "\").");
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
     * Finds all descendants of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bShallow if <code>true</code>, only search direct children, not all descendants.
     * @return an array of matching descendants
     *
    @SuppressWarnings("unchecked")
    public Object[] getDescendantsOfType(String strType, boolean bShallow, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Finds all descendants of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bShallow if <code>true</code>, only search direct children, not all descendants.
     * @return an array of matching descendants
     *
    @SuppressWarnings("unchecked")
    public Object[] getDescendantsOfType(org.directwebremoting.proxy.CodeBlock strType, boolean bShallow, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Finds all descendants of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param bShallow if <code>true</code>, only search direct children, not all descendants.
     * @return an array of matching descendants
     *
    @SuppressWarnings("unchecked")
    public Object[] getDescendantsOfType(Class strType, boolean bShallow, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Finds all DOM nodes descending from this DOM node that pass the given test function. Results are guaranteed to be
    returned in order according to the search order used.
     * @param fctTest test function, takes a single <code>jsx3.app.Model</code> parameter and returns
    <code>true</code> if the node matches.
     * @param bDepthFirst specifies whether to do a depth first or breadth first search.
     * @param bMultiple if <code>true</code>, return an array of matches, otherwise just the first match.
     * @param bShallow if <code>true</code>, only search direct children.
     * @param bIncludeSelf if <code>true</code>, include this node in the search.
     * @return the match (bMultiple = false) or matches (bMultiple = true).
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model findDescendants(org.directwebremoting.proxy.CodeBlock fctTest, boolean bDepthFirst, boolean bMultiple, boolean bShallow, boolean bIncludeSelf)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("findDescendants(\"" + fctTest + "\", \"" + bDepthFirst + "\", \"" + bMultiple + "\", \"" + bShallow + "\", \"" + bIncludeSelf + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Finds all DOM nodes descending from this DOM node that pass the given test function. Results are guaranteed to be
    returned in order according to the search order used.
     * @param fctTest test function, takes a single <code>jsx3.app.Model</code> parameter and returns
    <code>true</code> if the node matches.
     * @param bDepthFirst specifies whether to do a depth first or breadth first search.
     * @param bMultiple if <code>true</code>, return an array of matches, otherwise just the first match.
     * @param bShallow if <code>true</code>, only search direct children.
     * @param bIncludeSelf if <code>true</code>, include this node in the search.
     * @param returnType The expected return type
     * @return the match (bMultiple = false) or matches (bMultiple = true).
     */
    @SuppressWarnings("unchecked")
    public <T> T findDescendants(org.directwebremoting.proxy.CodeBlock fctTest, boolean bDepthFirst, boolean bMultiple, boolean bShallow, boolean bIncludeSelf, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("findDescendants(\"" + fctTest + "\", \"" + bDepthFirst + "\", \"" + bMultiple + "\", \"" + bShallow + "\", \"" + bIncludeSelf + "\").");
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
     * The finalizer method. This method provides a hook for subclasses of this class to perform custom logic
    when an instance of this class is removed from the DOM. Methods that override this method should begin with
    a call to jsxsuper().

    Note that this method is called after this object has been removed from the DOM tree. Therefore
    this.getParent() and this.getServer() will return null. Use the
    objParent parameter for access to the DOM tree.
     * @param objParent reference to the former parent
     */
    public void onDestroy(org.directwebremoting.proxy.jsx3.app.Model objParent)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onDestroy(").appendData(objParent).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the custom JSX-generated id for the object (i.e., _jsx2384098324509823049).
     * @return JSX id
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

    /*
     * Returns the zero-based index for this DOM node in relation to its siblings.
     * @return the index or <code>-1</code> if this object does not have a parent.
     *
    @SuppressWarnings("unchecked")
    public int getChildIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the custom developer-defined name of this object.
     *
    @SuppressWarnings("unchecked")
    public String getName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the custom developer-defined name of this object.
     * @param strName a name unique among all DOM nodes currently loaded in the application.
     */
    public void setName(String strName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setName(").appendData(strName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the help ID of this object.
     *
    @SuppressWarnings("unchecked")
    public String getHelpId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the help ID of this object.
     * @param strId 
     */
    public void setHelpId(String strId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHelpId(").appendData(strId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the load type of this DOM node and the descending branch. The load type determines how this DOM branch
    deserializes and paints in relation to its parent DOM node.
     * @return <code>LT_NORMAL</code>, <code>LT_SLEEP_PAINT</code>, <code>LT_SLEEP_DESER</code>,
    <code>LT_SLEEP_PD</code>, <code>LT_SHOW_PAINT</code>, or <code>LT_SHOW_DESER</code>.
     *
    @SuppressWarnings("unchecked")
    public int getLoadType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the load type of this DOM node and the descending branch.
     * @param intLoadType <code>LT_NORMAL</code>, <code>LT_SLEEP_PAINT</code>, <code>LT_SLEEP_DESER</code>,
    <code>LT_SLEEP_PD</code>, <code>LT_SHOW_PAINT</code>, or <code>LT_SHOW_DESER</code>.
     */
    public void setLoadType(int intLoadType)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLoadType(").appendData(intLoadType).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the parent DOM node of this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getParent()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the parent DOM node of this object.
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

    /**
     * Returns the first ancestor of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @return the first ancestor of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getAncestorOfType(String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfType(\"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the first ancestor of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param returnType The expected return type
     * @return the first ancestor of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAncestorOfType(String strType, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfType(\"" + strType + "\").");
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
     * Returns the first ancestor of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @return the first ancestor of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getAncestorOfType(org.directwebremoting.proxy.CodeBlock strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfType(\"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the first ancestor of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param returnType The expected return type
     * @return the first ancestor of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAncestorOfType(org.directwebremoting.proxy.CodeBlock strType, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfType(\"" + strType + "\").");
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
     * Returns the first ancestor of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @return the first ancestor of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getAncestorOfType(Class strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfType(\"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the first ancestor of the given type.
     * @param strType the fully-qualified class name, class constructor function,
    or <code>jsx3.Class</code> instance.
     * @param returnType The expected return type
     * @return the first ancestor of the given type or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAncestorOfType(Class strType, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfType(\"" + strType + "\").");
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
     * Returns the first ancestor with the given name.
     * @param strName the name to query on.
     * @return the first ancestor with the given name or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getAncestorOfName(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfName(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the first ancestor with the given name.
     * @param strName the name to query on.
     * @param returnType The expected return type
     * @return the first ancestor with the given name or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAncestorOfName(String strName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAncestorOfName(\"" + strName + "\").");
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
     * Returns the first ancestor passing the given test function.
     * @param fctTest test function, takes a single <code>jsx3.app.Model</code> parameter and returns
    <code>true</code> if the node matches.
     * @param bIncludeSelf if <code>true</code>, include this object in the search
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model findAncestor(org.directwebremoting.proxy.CodeBlock fctTest, boolean bIncludeSelf)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("findAncestor(\"" + fctTest + "\", \"" + bIncludeSelf + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Returns the first ancestor passing the given test function.
     * @param fctTest test function, takes a single <code>jsx3.app.Model</code> parameter and returns
    <code>true</code> if the node matches.
     * @param bIncludeSelf if <code>true</code>, include this object in the search
     */
    @SuppressWarnings("unchecked")
    public <T> T findAncestor(org.directwebremoting.proxy.CodeBlock fctTest, boolean bIncludeSelf, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("findAncestor(\"" + fctTest + "\", \"" + bIncludeSelf + "\").");
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
     * Returns this object serialized as XML by calling toString() on the result of toXMLDoc()
    called on this object.
     * @param objProperties name-value pairs that affect the serialization. See
    <code>toXMLDoc()</code> for a description.
     * @return this object serialized as an XML string.
     *
    @SuppressWarnings("unchecked")
    public String toXML(Object objProperties, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Serializes this object as an XML document.

    The objProperties parameter may include the following keys:

    onafter {String} - the value of the onAfterDeserialize element
    onbefore {String} - the value of the onBeforeDeserialize element
    name {String} - the value of the name element
    icon {String} - the value of the icon element
    description {String} - the value of the description element
    children {boolean} - if true the children of this object, rather than this object, are
         serialized
    persistall {boolean} - if true all descendants with persistence PERSISTNONE are included in the
         serialization
     * @param objProperties name-value pairs that affect the serialization. See above for
    valid names and how they affect serialization.
     * @return this object serialized as an XML document.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document toXMLDoc(Object objProperties)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("toXMLDoc(\"" + objProperties + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Document> ctor = org.directwebremoting.proxy.jsx3.xml.Document.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Document.class.getName());
        }
    }

    /**
     * Serializes this object as an XML document.

    The objProperties parameter may include the following keys:

    onafter {String} - the value of the onAfterDeserialize element
    onbefore {String} - the value of the onBeforeDeserialize element
    name {String} - the value of the name element
    icon {String} - the value of the icon element
    description {String} - the value of the description element
    children {boolean} - if true the children of this object, rather than this object, are
         serialized
    persistall {boolean} - if true all descendants with persistence PERSISTNONE are included in the
         serialization
     * @param objProperties name-value pairs that affect the serialization. See above for
    valid names and how they affect serialization.
     * @param returnType The expected return type
     * @return this object serialized as an XML document.
     */
    @SuppressWarnings("unchecked")
    public <T> T toXMLDoc(Object objProperties, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("toXMLDoc(\"" + objProperties + "\").");
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
     * Returns the namespace that distinguishes this object's server (owner) from other server instances. The namespace
    is set when this object is bound to a DOM tree.
     * @return the namespace of the server that owns this object instance.
     *
    @SuppressWarnings("unchecked")
    public String getNS(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the URI resolver for this DOM node. This method returns the server of this object unless this node
    or its ancestor was loaded into the DOM with an explicit URI resolver.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URIResolver getUriResolver()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getUriResolver().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URIResolver> ctor = org.directwebremoting.proxy.jsx3.net.URIResolver.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URIResolver.class.getName());
        }
    }

    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
    This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
    relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     * @return the deserialized object. A serialization file may specify more than one root
    object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model load(String strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
    This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
    relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     * @param returnType The expected return type
     * @return the deserialized object. A serialization file may specify more than one root
    object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public <T> T load(String strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
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
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
    This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
    relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     * @return the deserialized object. A serialization file may specify more than one root
    object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model load(org.directwebremoting.proxy.jsx3.net.URI strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
    This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
    relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     * @param returnType The expected return type
     * @return the deserialized object. A serialization file may specify more than one root
    object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public <T> T load(org.directwebremoting.proxy.jsx3.net.URI strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
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
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strXML the XML content of a JSX serialization file.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver 
     * @return the deserialized object. A serialization file may specify more than one root
    object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model loadXML(String strXML, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadXML(\"" + strXML + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strXML the XML content of a JSX serialization file.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver 
     * @param returnType The expected return type
     * @return the deserialized object. A serialization file may specify more than one root
    object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public <T> T loadXML(String strXML, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadXML(\"" + strXML + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
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
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strXML the XML content of a JSX serialization file.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver 
     * @return the deserialized object. A serialization file may specify more than one root
    object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model loadXML(org.directwebremoting.proxy.jsx3.xml.Document strXML, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadXML(\"" + strXML + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Deserializes a JSX serialization file and appends the deserialized objects as children of this DOM node.
     * @param strXML the XML content of a JSX serialization file.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objResolver 
     * @param returnType The expected return type
     * @return the deserialized object. A serialization file may specify more than one root
    object, in which case this method returns the first deserialized object.
     */
    @SuppressWarnings("unchecked")
    public <T> T loadXML(org.directwebremoting.proxy.jsx3.xml.Document strXML, boolean bRepaint, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadXML(\"" + strXML + "\", \"" + bRepaint + "\", \"" + objResolver + "\").");
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
     * Loads a component file and caches the document in an XML cache. If the component file already exists in the cache
    then it is loaded from the cache. All component files loaded as a result of this call (referenced files) are also
    cached. This method is a useful replacement for load() when the same URL will be loaded multiple
    times in one application.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
    This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objCache the cache to store the component XML documents in. If not provided, the cache
    of the server of this model object is used.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
    relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     */
    public void loadAndCache(String strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.app.Cache objCache, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("loadAndCache(").appendData(strURL).appendScript(",")

        .appendData(bRepaint).appendScript(",")

        .appendData(objCache).appendScript(",")

        .appendData(objResolver).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Loads a component file and caches the document in an XML cache. If the component file already exists in the cache
    then it is loaded from the cache. All component files loaded as a result of this call (referenced files) are also
    cached. This method is a useful replacement for load() when the same URL will be loaded multiple
    times in one application.
     * @param strURL URL (either relative or absolute) of the serialization file to deserialize.
    This URL is resolved relative to <code>objResolver</code>, if provided, or the URI resolver of this DOM node.
     * @param bRepaint if <code>true</code> or <code>null</code> the deserialized objects will be
    added to the parent's view via the parent object's <code>paintChild()</code> method.
     * @param objCache the cache to store the component XML documents in. If not provided, the cache
    of the server of this model object is used.
     * @param objResolver If this parameter is provided, <code>strURL</code> is resolved
    relative to it. Additionally, this resolver is stored as the URI resolver for this DOM node and its descendants.
     */
    public void loadAndCache(org.directwebremoting.proxy.jsx3.net.URI strURL, boolean bRepaint, org.directwebremoting.proxy.jsx3.app.Cache objCache, org.directwebremoting.proxy.jsx3.net.URIResolver objResolver)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("loadAndCache(").appendData(strURL).appendScript(",")

        .appendData(bRepaint).appendScript(",")

        .appendData(objCache).appendScript(",")

        .appendData(objResolver).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns one of the meta data values stored at the top of the serialization file that this object was loaded from.
     * @param strKey the name of the meta data field, one of the keys in <code>META_FIELDS</code>.
     * @return the meta data value or empty string.
     *
    @SuppressWarnings("unchecked")
    public String getMetaValue(String strKey, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * setS one of the meta data values stored at the top of a component's serialization file.
     * @param strKey the name of the meta data field, one of the keys in <code>META_FIELDS</code>
     * @param strValue the new value of the meta data field.
     */
    public void setMetaValue(String strKey, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMetaValue(").appendData(strKey).appendScript(",")

        .appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Called during deserialization of this object. This method provides a hook for initializing
    an object during deserialization since init() is not called. Called after this object has been instantiated but
    before its fields and children have been assembled. This method is called before this object is attached to the
    DOM, therefore getParent(), getServer(), getXML(), etc. return null.
     * @param objParent the parent of this object once it is attached to the DOM.
     * @param objServer the server that this DOM object will attach to.
     */
    public void onBeforeAssemble(org.directwebremoting.proxy.jsx3.app.Model objParent, org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onBeforeAssemble(").appendData(objParent).appendScript(",")

        .appendData(objServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Called during deserialization of this object. This method provides a hook for initializing
    an object during deserialization since init() is not called. Called after this object has been instantiated and
    after its fields and children have been assembled.This method is called before this object is attached to the
    DOM, therefore getParent(), getServer(), getXML(), etc. return null.
     * @param objParent the parent of this object once it is attached to the DOM.
     * @param objServer the server that this DOM object will attach to.
     */
    public void onAfterAssemble(org.directwebremoting.proxy.jsx3.app.Model objParent, org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onAfterAssemble(").appendData(objParent).appendScript(",")

        .appendData(objServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Called during deserialization of this object. This method provides a hook for initializing
    an object during deserialization since init() is not called. Called after this object has been
    instantiated and after it has been attached to the DOM. Methods overriding this method should usually finish
    with a call to jsxsuper().

    When a new branch is attached to the DOM, this method is executed on each node in the branch. The order is
    reverse-breadth-first meaning that child nodes are notified from oldest to youngest and before the parent node.

    This implementation of this method executes the on-after-deserialize script of this object.
     */
    public void onAfterAttach()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onAfterAttach(").appendScript(");");
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
