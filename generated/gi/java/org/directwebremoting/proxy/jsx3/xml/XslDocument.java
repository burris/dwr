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

}
