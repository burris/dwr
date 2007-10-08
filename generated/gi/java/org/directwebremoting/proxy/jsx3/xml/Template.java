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

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Template extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Template(ProxyHelper helper)
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
        script.appendData(getProxyHelper().getContext())
              .appendScript("setParam(")
              .appendData(strName)
              .appendScript(",")
              
              .appendData(objValue)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * 
     */
    public void reset()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("reset(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * 
     * @param objParams JavaScript object array of name/value pairs. If this parameter is
   not empty, the transformation will use a paramaterized stylesheet to perform the transformation.
     */
    public void setParams(Object objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setParams(")
              .appendData(objParams)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Performs an XSLT merge. If an error occurs while performing the transform, this method sets the error
property of this processor and returns null.
     * @param objXML 
     * @param bObject 
     * @return the result of the transformation
     *
    @SuppressWarnings("unchecked")
    public String transform(org.directwebremoting.proxy.jsx3.xml.Entity objXML, boolean bObject, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Performs an XSLT merge. If an error occurs while performing the transform, this method sets the error
property of this processor and returns null.
     * @param objXML 
     * @return if a valid result tree is formed as a result of the transformation
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document transformToObject(org.directwebremoting.proxy.jsx3.xml.Entity objXML)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("transformToObject(\"" + objXML + "\").");
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
     * Performs an XSLT merge. If an error occurs while performing the transform, this method sets the error
property of this processor and returns null.
     * @param objXML 
     * @param type The expected return type
     * @return if a valid result tree is formed as a result of the transformation
     */
    @SuppressWarnings("unchecked")
    public <T> T transformToObject(org.directwebremoting.proxy.jsx3.xml.Entity objXML, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("transformToObject(\"" + objXML + "\").");
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
     * Returns an error object (a plain JavaScript object) with two properties that the developer can query for:

code Ð an integer error code, 0 for no error.
description Ð a text description of the error that occurred.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object getError(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns true if the last operation on this XML entity caused an error.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public boolean hasError(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
 }
