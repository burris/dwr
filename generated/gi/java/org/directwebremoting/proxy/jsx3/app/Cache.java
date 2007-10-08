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
public class Cache extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Cache(ProxyHelper helper)
    {
        super(helper);
    }

    
    /**
     * Event action.
     */
    public static final String REMOVE = "remove";

    /**
     * Event action.
     */
    public static final String ADD = "add";

    /**
     * Event subject and action.
     */
    public static final String CHANGE = "change";

    /**
     * The number of milliseconds before asynchronous document loads time out.
     */
    public static final int ASYNC_TIMEOUT = 60000;

    /**
     * 
     */
    public static final String XSDNS = "http://xsd.tns.tibco.com/gi/cache";

    /**
     * Removes the document stored in this cache under id strId.
     * @param strId 
     * @return the remove document, if any.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document clearById(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("clearById(\"" + strId + "\").");
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
     * Removes the document stored in this cache under id strId.
     * @param strId 
     * @param type The expected return type
     * @return the remove document, if any.
     */
    @SuppressWarnings("unchecked")
    public <T> T clearById(String strId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("clearById(\"" + strId + "\").");
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
     * Removes all documents placed in this cache before intTimestamp.
     * @param intTimestamp epoch seconds or a date object.
     * @return the ids of the removed documents.
     *
    @SuppressWarnings("unchecked")
    public Object[] clearByTimestamp(int intTimestamp, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Removes all documents placed in this cache before intTimestamp.
     * @param intTimestamp epoch seconds or a date object.
     * @return the ids of the removed documents.
     *
    @SuppressWarnings("unchecked")
    public Object[] clearByTimestamp(Date intTimestamp, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the document stored in this cache under id strId.
     * @param strId 
     * @return the stored document or <code>null</code> if none exists.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getDocument(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDocument(\"" + strId + "\").");
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
     * Returns the document stored in this cache under id strId.
     * @param strId 
     * @param type The expected return type
     * @return the stored document or <code>null</code> if none exists.
     */
    @SuppressWarnings("unchecked")
    public <T> T getDocument(String strId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDocument(\"" + strId + "\").");
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
     * Retrieves a document from this cache or, if this cache contains no such document, loads the document
synchronously and returns it.
     * @param strURL the URI of the document.
     * @param strId the id under which the document is/will be stored. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance if a new document is opened.
     * @return the document retrieved from the cache or loaded.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getOrOpenDocument(String strURL, String strId, Class objClass)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOrOpenDocument(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Retrieves a document from this cache or, if this cache contains no such document, loads the document
synchronously and returns it.
     * @param strURL the URI of the document.
     * @param strId the id under which the document is/will be stored. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance if a new document is opened.
     * @param type The expected return type
     * @return the document retrieved from the cache or loaded.
     */
    @SuppressWarnings("unchecked")
    public <T> T getOrOpenDocument(String strURL, String strId, Class objClass, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOrOpenDocument(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Retrieves a document from this cache or, if this cache contains no such document, loads the document
synchronously and returns it.
     * @param strURL the URI of the document.
     * @param strId the id under which the document is/will be stored. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance if a new document is opened.
     * @return the document retrieved from the cache or loaded.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getOrOpenDocument(org.directwebremoting.proxy.jsx3.net.URI strURL, String strId, Class objClass)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOrOpenDocument(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Retrieves a document from this cache or, if this cache contains no such document, loads the document
synchronously and returns it.
     * @param strURL the URI of the document.
     * @param strId the id under which the document is/will be stored. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance if a new document is opened.
     * @param type The expected return type
     * @return the document retrieved from the cache or loaded.
     */
    @SuppressWarnings("unchecked")
    public <T> T getOrOpenDocument(org.directwebremoting.proxy.jsx3.net.URI strURL, String strId, Class objClass, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOrOpenDocument(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Synchronously loads an xml document, stores it in this cache, and returns the loaded document.
     * @param strURL url (relative or absolute) the URI of the document to open.
     * @param strId the id under which to store the document. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance.
     * @return the loaded document object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document openDocument(String strURL, String strId, Class objClass)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("openDocument(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Synchronously loads an xml document, stores it in this cache, and returns the loaded document.
     * @param strURL url (relative or absolute) the URI of the document to open.
     * @param strId the id under which to store the document. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance.
     * @param type The expected return type
     * @return the loaded document object.
     */
    @SuppressWarnings("unchecked")
    public <T> T openDocument(String strURL, String strId, Class objClass, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("openDocument(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Synchronously loads an xml document, stores it in this cache, and returns the loaded document.
     * @param strURL url (relative or absolute) the URI of the document to open.
     * @param strId the id under which to store the document. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance.
     * @return the loaded document object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document openDocument(org.directwebremoting.proxy.jsx3.net.URI strURL, String strId, Class objClass)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("openDocument(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Synchronously loads an xml document, stores it in this cache, and returns the loaded document.
     * @param strURL url (relative or absolute) the URI of the document to open.
     * @param strId the id under which to store the document. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance.
     * @param type The expected return type
     * @return the loaded document object.
     */
    @SuppressWarnings("unchecked")
    public <T> T openDocument(org.directwebremoting.proxy.jsx3.net.URI strURL, String strId, Class objClass, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("openDocument(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Asynchronously loads an xml document and stores it in this cache.
     * @param strURL url (relative or absolute) the URI of the document to open.
     * @param strId the id under which to store the document. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance.
     * @return the document retrieved from the cache or a placeholder document if the document
   is in the process of loading asynchronously.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getOrOpenAsync(String strURL, String strId, Class objClass)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOrOpenAsync(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Asynchronously loads an xml document and stores it in this cache.
     * @param strURL url (relative or absolute) the URI of the document to open.
     * @param strId the id under which to store the document. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance.
     * @param type The expected return type
     * @return the document retrieved from the cache or a placeholder document if the document
   is in the process of loading asynchronously.
     */
    @SuppressWarnings("unchecked")
    public <T> T getOrOpenAsync(String strURL, String strId, Class objClass, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOrOpenAsync(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Asynchronously loads an xml document and stores it in this cache.
     * @param strURL url (relative or absolute) the URI of the document to open.
     * @param strId the id under which to store the document. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance.
     * @return the document retrieved from the cache or a placeholder document if the document
   is in the process of loading asynchronously.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getOrOpenAsync(org.directwebremoting.proxy.jsx3.net.URI strURL, String strId, Class objClass)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOrOpenAsync(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Asynchronously loads an xml document and stores it in this cache.
     * @param strURL url (relative or absolute) the URI of the document to open.
     * @param strId the id under which to store the document. If this parameter is not provided, the
   <code>strURL</code> parameter is used as the id.
     * @param objClass <code>jsx3.xml.Document</code> (default value) or one of its subclasses. The
   class with which to instantiate the new document instance.
     * @param type The expected return type
     * @return the document retrieved from the cache or a placeholder document if the document
   is in the process of loading asynchronously.
     */
    @SuppressWarnings("unchecked")
    public <T> T getOrOpenAsync(org.directwebremoting.proxy.jsx3.net.URI strURL, String strId, Class objClass, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOrOpenAsync(\"" + strURL + "\", \"" + strId + "\", \"" + objClass + "\").");
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
     * Stores the document objDocument in this cache under id strId. If a document already
exists in this cache under strId then that document is removed from the cache.
     * @param strId the id under which to store <code>objDocument</code>.
     * @param objDocument 
     */
    public void setDocument(String strId, org.directwebremoting.proxy.jsx3.xml.Document objDocument)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setDocument(")
              .appendData(strId)
              .appendScript(",")
              
              .appendData(objDocument)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns the timestamp from when the document stored under id strId was stored in this cache.
     * @param strId the id under which the document is stored.
     * @return the timestamp as an integer (epoch seconds) or <code>null</code> if no such document exists
   in this cache.
     *
    @SuppressWarnings("unchecked")
    public int getTimestamp(String strId, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns a list of all the keys in this cache instance.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object[] keys(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Removes all references to documents contained in this cache. This cache is no longer usable after calling this
method.
     */
    public void destroy()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("destroy(")
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
