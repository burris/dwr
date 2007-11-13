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
public class Request extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Request(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param id <span style="text-decoration:line-through;">If the call will be asynchronous, assigns a unique identifier.</span>
     */
    public Request(String id)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Request", id);
        setInitScript(script);
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
        String extension = "abort().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Request> ctor = org.directwebremoting.proxy.jsx3.net.Request.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.Request.class.getName());
        }
    }

    /**
     * Gets the value of all the HTTP headers.
     */
    @SuppressWarnings("unchecked")
    public void getAllResponseHeaders(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAllResponseHeaders");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Gets the value of a specific HTTP response header.
     * @param strName the name for the response header to retrieve.
     */
    @SuppressWarnings("unchecked")
    public void getResponseHeader(String strName, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getResponseHeader", strName);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Gets the HTTP response line status (e.g. "OK").
     */
    @SuppressWarnings("unchecked")
    public void getStatusText(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getStatusText");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Gets the HTTP response code (e.g. 200, 404, 500, etc).
     */
    @SuppressWarnings("unchecked")
    public void getStatus(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getStatus");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Gets the content of the response as string.
     */
    @SuppressWarnings("unchecked")
    public void getResponseText(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getResponseText");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Gets the content of the response as an XML document. If the response is not a valid XML document,
    null is returned.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getResponseXML()
    {
        String extension = "getResponseXML().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Document> ctor = org.directwebremoting.proxy.jsx3.xml.Document.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Document.class.getName());
        }
    }

    /**
     * Gets the content of the response as an XML document. If the response is not a valid XML document,
    null is returned.
     * @param returnType The expected return type
     */
    @SuppressWarnings("unchecked")
    public <T> T getResponseXML(Class<T> returnType)
    {
        String extension = "getResponseXML().";
        try
        {
            Constructor<T> ctor = returnType.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        script.appendCall("setRequestHeader", strName, strValue);
        getScriptProxy().addScript(script);
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
        String extension = "open(\"" + strMethod + "\", \"" + strURL + "\", \"" + bAsync + "\", \"" + strUser + "\", \"" + strPass + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Request> ctor = org.directwebremoting.proxy.jsx3.net.Request.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "open(\"" + strMethod + "\", \"" + strURL + "\", \"" + bAsync + "\", \"" + strUser + "\", \"" + strPass + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Request> ctor = org.directwebremoting.proxy.jsx3.net.Request.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.Request.class.getName());
        }
    }

    /**
     * Gets the URL passed when opening this request.
     */
    @SuppressWarnings("unchecked")
    public void getURL(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getURL");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

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
        String extension = "send(\"" + strContent + "\", \"" + intTimeout + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Request> ctor = org.directwebremoting.proxy.jsx3.net.Request.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.Request.class.getName());
        }
    }

    /**
     * Publishes an event to all subscribed objects.
     * @param objEvent the event, should have at least a field 'subject' that is the event id, another common field is 'target' (target will default to this instance)
     * @param callback the number of listeners to which the event was broadcast
     */
    @SuppressWarnings("unchecked")
    public void publish(Object objEvent, Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = publish", objEvent);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

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
        script.appendCall("subscribe", strEventId, objHandler, objFunction);
        getScriptProxy().addScript(script);
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
        script.appendCall("unsubscribe", strEventId, objHandler);
        getScriptProxy().addScript(script);
    }

    /**
     * Unsubscribes all subscribed objects to a type of event published by this object.
     * @param strEventId the event type
     */
    public void unsubscribeAll(String strEventId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("unsubscribeAll", strEventId);
        getScriptProxy().addScript(script);
    }

}
