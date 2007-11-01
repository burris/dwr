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

package org.directwebremoting.proxy.jsx3.xml;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class XslDocument extends org.directwebremoting.proxy.jsx3.xml.Document
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public XslDocument(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * 
     * @param strName 
     * @param objValue 
     */
    public void setParam(String strName, Object objValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setParam(").appendData(strName).appendScript(",")

        .appendData(objValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param objParams 
     */
    public void setParams(Object objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setParams(").appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    public void reset()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("reset(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param objXML 
     */
    public void transform(org.directwebremoting.proxy.jsx3.xml.Entity objXML)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("transform(").appendData(objXML).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param objXML 
     */
    public void transformToObject(org.directwebremoting.proxy.jsx3.xml.Entity objXML)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("transformToObject(").appendData(objXML).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param objXML 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.XslDocument wrap(org.directwebremoting.proxy.jsx3.xml.Document objXML)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("wrap(\"" + objXML + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.XslDocument> ctor = org.directwebremoting.proxy.jsx3.xml.XslDocument.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.XslDocument.class.getName());
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
    @Override
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
    @Override
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
    @Override
    public void unsubscribeAll(String strEventId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("unsubscribeAll(").appendData(strEventId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
