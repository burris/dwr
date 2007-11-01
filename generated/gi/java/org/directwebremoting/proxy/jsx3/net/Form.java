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
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Form extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Form(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strMethod form method, METHOD_GET (default) or METHOD_POST
     * @param strAction the URL to submit to
     * @param bMultipart if true the form can support file upload
     */
    public Form(String strMethod, String strAction, boolean bMultipart)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String METHOD_GET = "get";

    /**
     * 
     */
    public static final String METHOD_POST = "post";

    /**
     * Event type published when a file has been chosen through user interaction. The event has properties field and value.
     */
    public static final String EVENT_FILE_SELECTED = "file";

    /**
     * Event type published when the response has loaded.
     */
    public static final String EVENT_ON_RESPONSE = "response";

    /**
     * Event type published when a security error occurs trying to access the response.
     */
    public static final String EVENT_ON_ERROR = "error";

    /**
     * Event type published when the response is still not ready after the specified timeout period.
     */
    public static final String EVENT_ON_TIMEOUT = "timeout";

    /**
     * Creates a new form and initialize it from the HTML representation of a form.
     * @param strFragment the html fragment containing a <form/> tag.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.Form newFromFragment(String strFragment)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("newFromFragment(\"" + strFragment + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.Form> ctor = org.directwebremoting.proxy.jsx3.net.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.Form.class.getName());
        }
    }

    /*
     * Returns the method of this form.
     * @return <code>METHOD_GET</code> or <code>METHOD_POST</code>.
     *
    @SuppressWarnings("unchecked")
    public String getMethod(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the method of this form.
     * @param method <code>METHOD_GET</code> or <code>METHOD_POST</code>.
     */
    public void setMethod(String method)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMethod(").appendData(method).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the action of this form, the URL that this form is submitted to.
     * @return action
     *
    @SuppressWarnings("unchecked")
    public String getAction(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the action of this form.
     * @param action 
     */
    public void setAction(String action)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAction(").appendData(action).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether this form is multipart. Only multipart forms may upload files.
     *
    @SuppressWarnings("unchecked")
    public boolean getMultipart(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether this form is multipart.
     * @param multipart 
     */
    public void setMultipart(boolean multipart)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMultipart(").appendData(multipart).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the value of a field in this form.
     * @param strName the name of the form field to query.
     * @return the field value or <code>null</code> if no such field exists.
     *
    @SuppressWarnings("unchecked")
    public String getField(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the names of all fields in this form.
     *
    @SuppressWarnings("unchecked")
    public Object[] getFields(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the value of a field in this form.
     * @param strName the name of the form field to set.
     * @param strValue the new value of form field.
     * @param bConcat if true, will append <code>" " + strValue</code> to the existing value. The space is
    only inserted if the existing value is not empty.
     */
    public void setField(String strName, String strValue, boolean bConcat)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setField(").appendData(strName).appendScript(",")

        .appendData(strValue).appendScript(",")

        .appendData(bConcat).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes a field from this form.
     * @param strName the name of the form field to remove.
     */
    public void removeField(String strName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("removeField(").appendData(strName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Adds a file upload field to this form.
     * @param strName the name of the new field.
     */
    public void addFileUploadField(String strName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("addFileUploadField(").appendData(strName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Invokes the operating system file browser to choose a file for a file upload field. This method is not
    supported in browsers other than Microsoft Internet Explorer.
     * @param strFieldName the name of the file upload field.
     */
    public void promptForFile(String strFieldName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("promptForFile(").appendData(strFieldName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Stops polling for a response.
     */
    public void abort()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("abort(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sends the form. Sending the form is always asynchronous. Once a form has been sent it may not be reused.
     * @param intPollInterval milliseconds between checking for a response. If not provided, the default value is 1/4 sec.
     * @param intTimeout total milliseconds before timeout. If not provided, the default value is 30 sec.
     */
    public void send(int intPollInterval, int intTimeout)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("send(").appendData(intPollInterval).appendScript(",")

        .appendData(intTimeout).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the content of the response as a string.
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
     * Returns the content of the response as an XML document.
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
     * Returns the content of the response as an XML document.
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
     * Destroys the form and the hidden IFRAME. This method should be called after receiving an onResponse, onError, or 
    onTimeout event for proper garbage collection.
     */
    public void destroy()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("destroy(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Reveals the IFRAME containing this form for debugging purposes. Dimensions of the revealed form may be provided
    or a default position and dimensions will be used.
     * @param l pixels from the left side of the HTML page that the IFRAME will be displayed.
     * @param t pixels from the top of the HTML page that the IFRAME will be displayed.
     * @param w width of the revealed IFRAME, in pixels.
     * @param h height of the revealed IFRAME, in pixels.
     */
    public void reveal(int l, int t, int w, int h)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("reveal(").appendData(l).appendScript(",")

        .appendData(t).appendScript(",")

        .appendData(w).appendScript(",")

        .appendData(h).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Hides the IFRAME containing this form after it has been shown by calling reveal().
     */
    public void conceal()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("conceal(").appendScript(");");
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
