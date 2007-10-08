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

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class DOM extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public DOM(ProxyHelper helper)
    {
        super(helper);
    }

    
    /**
     * 0
     */
    public static final int TYPEADD = 0;

    /**
     * 1
     */
    public static final int TYPEREMOVE = 1;

    /**
     * 2
     */
    public static final int TYPEREARRANGE = 2;

    /*
     * Creates a new unique system id.
     * @param strNameSpace the application namespace for which to generate the id.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String newId(String strNameSpace, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * The instance finalizer.
     */
    public void destroy()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("destroy(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Looks up a DOM object contained in this DOM by id or name.
     * @param strId either the id of the object to return or its name.
     * @return the matching DOM object or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model get(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("get(\"" + strId + "\").");
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
     * Looks up a DOM object contained in this DOM by id or name.
     * @param strId either the id of the object to return or its name.
     * @param type The expected return type
     * @return the matching DOM object or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String strId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("get(\"" + strId + "\").");
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
     * Looks up a DOM object contained in this DOM by name. It is left to the developer to specify unique names for
all DOM nodes that must be accessed in this manner. If more than one DOM nodes exist with a name of
strName the behavior of this method is undefined.
     * @param strName the name of the object to return.
     * @return the matching DOM object or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getByName(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getByName(\"" + strName + "\").");
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
     * Looks up a DOM object contained in this DOM by name. It is left to the developer to specify unique names for
all DOM nodes that must be accessed in this manner. If more than one DOM nodes exist with a name of
strName the behavior of this method is undefined.
     * @param strName the name of the object to return.
     * @param type The expected return type
     * @return the matching DOM object or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getByName(String strName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getByName(\"" + strName + "\").");
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
     * Returns all the DOM nodes in this DOM with a name of strName. The name index keeps a bucket of
DOM nodes for each unique name. Therefore, this method performs efficiently.
     * @param strName the name of the objects to return.
     * @return an array of the matching DOM nodes. This return value should not be mutated as
  that will effect the internal functioning of this DOM.
     *
    @SuppressWarnings("unchecked")
    public Object[] getAllByName(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Looks up a DOM object contained in this DOM by id.
     * @param strId the id of the object to return.
     * @return the matching DOM object or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getById(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getById(\"" + strId + "\").");
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
     * Looks up a DOM object contained in this DOM by id.
     * @param strId the id of the object to return.
     * @param type The expected return type
     * @return the matching DOM object or <code>null</code> if none found.
     */
    @SuppressWarnings("unchecked")
    public <T> T getById(String strId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getById(\"" + strId + "\").");
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
     * Adds a JSX object to this DOM and indexes it by its id and name.
     * @param objJSX 
     */
    public void add(org.directwebremoting.proxy.jsx3.app.Model objJSX)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("add(")
              .appendData(objJSX)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Removes a JSX object from this DOM and removes it from the indices.
     * @param objJSX 
     */
    public void remove(org.directwebremoting.proxy.jsx3.app.Model objJSX)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("remove(")
              .appendData(objJSX)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * A method that must be called after changing the name of a contained DOM node. This method updates the name
index appropriately.
     * @param objJSX 
     * @param oldName the name before it was changed
     */
    public void onNameChange(org.directwebremoting.proxy.jsx3.app.Model objJSX, String oldName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onNameChange(")
              .appendData(objJSX)
              .appendScript(",")
              
              .appendData(oldName)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * called when a change to the JSX DOM occurs for this server instance (adopt, load, delete, etc); publishes an event object (javascript object) with the following named properties: subject (jsx3.app.DOM.EVENT_CHANGE); type (jsx3.app.DOM.TYPEADD | jsx3.app.DOM.TYPEREMOVE); parentId (id of JSX parent); jsxId (id of element added or removed)
     * @param TYPE one of: jsx3.app.DOM.TYPEADD, jsx3.app.DOM.TYPEREMOVE
     * @param JSXPARENTID id of dom parent
     * @param JSXID id of dom element either added or removed
     */
    public void onChange(int TYPE, String JSXPARENTID, String JSXID)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("onChange(")
              .appendData(TYPE)
              .appendScript(",")
              
              .appendData(JSXPARENTID)
              .appendScript(",")
              
              .appendData(JSXID)
              .appendScript(");");
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
        script.appendData(getProxyHelper().getContext())
              .appendScript("subscribe(")
              .appendData(strEventId)
              .appendScript(",")
              
              .appendData(objHandler)
              .appendScript(",")
              
              .appendData(objFunction)
              .appendScript(");");
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
        script.appendData(getProxyHelper().getContext())
              .appendScript("unsubscribe(")
              .appendData(strEventId)
              .appendScript(",")
              
              .appendData(objHandler)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Unsubscribes all subscribed objects to a type of event published by this object.
     * @param strEventId the event type
     */
    public void unsubscribeAll(String strEventId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("unsubscribeAll(")
              .appendData(strEventId)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
 }
