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
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Template extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Template(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param objXSL 
     */
    public Template(org.directwebremoting.proxy.jsx3.xml.Document objXSL)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Template", objXSL);
        setInitScript(script);
    }

    /**
     * 
     * @param strName 
     * @param objValue 
     */
    public void setParam(String strName, Object objValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setParam", strName, objValue);
        getScriptProxy().addScript(script);
    }

    /**
     * 
     */
    public void reset()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("reset");
        getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param objParams JavaScript object array of name/value pairs. If this parameter is
    not empty, the transformation will use a paramaterized stylesheet to perform the transformation.
     */
    public void setParams(Object objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setParams", objParams);
        getScriptProxy().addScript(script);
    }

    /**
     * Performs an XSLT merge. If an error occurs while performing the transform, this method sets the error
    property of this processor and returns null.
     * @param objXML 
     * @param bObject 
     * @param callback the result of the transformation
     */
    @SuppressWarnings("unchecked")
    public void transform(org.directwebremoting.proxy.jsx3.xml.Entity objXML, boolean bObject, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = transform", objXML, bObject);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Performs an XSLT merge. If an error occurs while performing the transform, this method sets the error
    property of this processor and returns null.
     * @param objXML 
     * @return if a valid result tree is formed as a result of the transformation
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document transformToObject(org.directwebremoting.proxy.jsx3.xml.Entity objXML)
    {
        String extension = "transformToObject(\"" + objXML + "\").";
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
     * Performs an XSLT merge. If an error occurs while performing the transform, this method sets the error
    property of this processor and returns null.
     * @param objXML 
     * @param returnType The expected return type
     * @return if a valid result tree is formed as a result of the transformation
     */
    @SuppressWarnings("unchecked")
    public <T> T transformToObject(org.directwebremoting.proxy.jsx3.xml.Entity objXML, Class<T> returnType)
    {
        String extension = "transformToObject(\"" + objXML + "\").";
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
     * Returns an error object (a plain JavaScript object) with two properties that the developer can query for:

    code � an integer error code, 0 for no error.
    description � a text description of the error that occurred.
     */
    @SuppressWarnings("unchecked")
    public void getError(Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getError");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the last operation on this XML entity caused an error.
     */
    @SuppressWarnings("unchecked")
    public void hasError(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = hasError");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

}
