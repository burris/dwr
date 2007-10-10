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
package org.directwebremoting.proxy.jsx3.net;

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Request extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Request(ProxyHelper helper)
    {
        super(helper);
    }
    
    /**
     * The instance initializer.
     * @param id <span style="text-decoration:line-through;">If the call will be asynchronous, assigns a unique identifier.</span>
     */
    public Request(String id)
    {
        super((ProxyHelper) null);
    }

    /**
     * Event type published when the response has loaded.
     */
    public static final String EVENT_ON_RESPONSE = "response";

    /**
     * Event type published when the server has not responded after the specified timeout period.
     */
    public static final String EVENT_ON_TIMEOUT = "timeout";

    /**
     * Aborts the request.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.Request abort()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("abort().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Request> ctor = org.directwebremoting.proxy.jsx3.net.Request.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.Request.class.getName());
        }
    }

    
    
    /*
     * Gets the value of all the HTTP headers.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getAllResponseHeaders(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Gets the value of a specific HTTP response header.
     * @param strName the name for the response header to retrieve.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getResponseHeader(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Gets the HTTP response line status (e.g. "OK").
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getStatusText(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Gets the HTTP response code (e.g. 200, 404, 500, etc).
     * @return 
     *
    @SuppressWarnings("unchecked")
    public int getStatus(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Gets the content of the response as string.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getResponseText(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Gets the content of the response as an XML document. If the response is not a valid XML document,
null is returned.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getResponseXML()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getResponseXML().");
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
     * Gets the content of the response as an XML document. If the response is not a valid XML document,
null is returned.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getResponseXML(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getResponseXML().");
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
     * Sets the value of a specific HTTP request header. The open() method should be called before calling
this method.
     * @param strName the name for the request header to send to the server with the request content.
     * @param strValue the value for the request header to send to the server with the request content.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.net.Request setRequestHeader(String strName, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setRequestHeader(")
              .appendData(strName)
              .appendScript(",")
              
              .appendData(strValue)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    
    /**
     * Initializes the request, and specifies the method, URL, and authentication information for the request.
     * @param strMethod The HTTP method used to open the connection. Valid values include: GET, POST, or PUT.
     * @param strURL The requested URL. This can be either an absolute URL, such as "http://www.TIBCO.com", or a relative URL, such as "../MyPath/MyFile".
     * @param bAsync whether to issue the request asynchronously, if true this class will use the EventDispatcher interface to publish an event on response or timeout.
     * @param strUser The name of the user for authentication. If this parameter is null ("") or missing and the site requires authentication, the native HTTP control will display a logon window.
     * @param strPass The password for authentication. This parameter is ignored if the user parameter is null ("") or missing.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.Request open(String strMethod, String strURL, boolean bAsync, String strUser, String strPass)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("open(\"" + strMethod + "\", \"" + strURL + "\", \"" + bAsync + "\", \"" + strUser + "\", \"" + strPass + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Request> ctor = org.directwebremoting.proxy.jsx3.net.Request.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.Request.class.getName());
        }
    }

    
    
    /**
     * Initializes the request, and specifies the method, URL, and authentication information for the request.
     * @param strMethod The HTTP method used to open the connection. Valid values include: GET, POST, or PUT.
     * @param strURL The requested URL. This can be either an absolute URL, such as "http://www.TIBCO.com", or a relative URL, such as "../MyPath/MyFile".
     * @param bAsync whether to issue the request asynchronously, if true this class will use the EventDispatcher interface to publish an event on response or timeout.
     * @param strUser The name of the user for authentication. If this parameter is null ("") or missing and the site requires authentication, the native HTTP control will display a logon window.
     * @param strPass The password for authentication. This parameter is ignored if the user parameter is null ("") or missing.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.Request open(String strMethod, org.directwebremoting.proxy.jsx3.net.URI strURL, boolean bAsync, String strUser, String strPass)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("open(\"" + strMethod + "\", \"" + strURL + "\", \"" + bAsync + "\", \"" + strUser + "\", \"" + strPass + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Request> ctor = org.directwebremoting.proxy.jsx3.net.Request.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.Request.class.getName());
        }
    }

    
    
    /*
     * Gets the URL passed when opening this request.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getURL(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sends the request.
     * @param strContent The content to send for a POST request.
     * @param intTimeout the number milliseconds to wait before publishing a timeout event. This only applies
   to asynchronous requests. If used, subscribe to the <code>jsx3.net.Request.EVENT_ON_TIMEOUT</code> event to
   be notified of a timeout.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.Request send(String strContent, int intTimeout)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("send(\"" + strContent + "\", \"" + intTimeout + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Request> ctor = org.directwebremoting.proxy.jsx3.net.Request.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.Request.class.getName());
        }
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
