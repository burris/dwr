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

package org.directwebremoting.proxy.jsx3.gui;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class BlockX extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public BlockX(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param vntLeft either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntTop either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntWidth either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     * @param vntHeight either a number (i.e, 12, 30, etc) or a number and a unit value (i.e., "25%", "36pt", etc); if a number is passed, pixels will be the assumed unit when painted to screen
     */
    public BlockX(String strName, int vntLeft, int vntTop, int vntWidth, int vntHeight)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the XSL string of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXSLString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the XSL string of this object.
     * @param strXSL 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXSLString(String strXSL)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXSLString(\"" + strXSL + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /*
     * Returns the XSL URL of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXSLURL(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the XSL URL of this object.
     * @param strXSLURL 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXSLURL(String strXSLURL)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXSLURL(\"" + strXSLURL + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Resets the XML source document stored in the server cache under the XML ID of this object to an empty CDF
    document.
     */
    public void clearXmlData()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("clearXmlData(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether this object removes its XML and XSL source documents from the cache of its server when it
    is destroyed.
     * @return <code>CLEANUPRESOURCES</code> or <code>SHARERESOURCES</code>.
     *
    @SuppressWarnings("unchecked")
    public int getShareResources(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the XML source document of this object. The XML document is determined by the following steps:

    If an XML document exists in the server cache under an ID equal to the XML ID of this object, that
    document is returned.
    If the XML string of this object is not empty, a new document is created by parsing this string.
    If the XML URL of this object is not empty, a new document is created by parsing the file at the location
    specified by the URL resolved against the server owning this object.
    Otherwise, an empty CDF document is returned.

    If a new document is created for this object (any of the steps listed above except for the first one), the
    following actions are also taken:

    If creating the document resulted in an error (XML parsing error, file not found error, etc) the offending
    document is returned immediately.
    Otherwise, setSourceXML is called on this object, passing in the created document.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getXML()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXML().");
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
     * Returns the XML source document of this object. The XML document is determined by the following steps:

    If an XML document exists in the server cache under an ID equal to the XML ID of this object, that
    document is returned.
    If the XML string of this object is not empty, a new document is created by parsing this string.
    If the XML URL of this object is not empty, a new document is created by parsing the file at the location
    specified by the URL resolved against the server owning this object.
    Otherwise, an empty CDF document is returned.

    If a new document is created for this object (any of the steps listed above except for the first one), the
    following actions are also taken:

    If creating the document resulted in an error (XML parsing error, file not found error, etc) the offending
    document is returned immediately.
    Otherwise, setSourceXML is called on this object, passing in the created document.
     */
    @SuppressWarnings("unchecked")
    public <T> T getXML(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXML().");
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
     * Returns the XML ID of this object.
     * @return the XML ID.
     *
    @SuppressWarnings("unchecked")
    public String getXMLId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the XML string of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXMLString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the list of XML transformers of this object.
     *
    @SuppressWarnings("unchecked")
    public Object[] getXMLTransformers(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the XML URL of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXMLURL(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the XSL source document of this object. The XSL document is determined by the following steps:

    If an XSL document exists in the server cache under an ID equal to the XSL ID of this object, that
    document is returned.
    (Deprecated) If the XSL string of this object is not null, a new document is created by parsing this string.
    (Deprecated) If the XSL URL of this object is not null, a new document is created by parsing the file at the location
    specified by the URL resolved against the server owning this object.
    Otherwise, the default stylesheet (Cacheable.DEFAULTSTYLESHEET) is returned.
     * @return the XSL source document.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getXSL()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXSL().");
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
     * Returns the XSL source document of this object. The XSL document is determined by the following steps:

    If an XSL document exists in the server cache under an ID equal to the XSL ID of this object, that
    document is returned.
    (Deprecated) If the XSL string of this object is not null, a new document is created by parsing this string.
    (Deprecated) If the XSL URL of this object is not null, a new document is created by parsing the file at the location
    specified by the URL resolved against the server owning this object.
    Otherwise, the default stylesheet (Cacheable.DEFAULTSTYLESHEET) is returned.
     * @param returnType The expected return type
     * @return the XSL source document.
     */
    @SuppressWarnings("unchecked")
    public <T> T getXSL(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXSL().");
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
     * Returns the XSL ID of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXSLId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns a map containing all the parameters to pass to the XSL stylesheet during transformation.
     *
    @SuppressWarnings("unchecked")
    public Object getXSLParams(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether the XML data source of this object is loaded asynchronously.
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int getXmlAsync(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether this object is bound to the XML document stored in the data cache.
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int getXmlBind(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * This method is called in two situations:

    When the datasource of this object finishes loading (success, error, or timeout), if the
      xmlAsync property of this object is true, its datasource is specified as an
       XML URL, and the first time doTransform() was called the datasource was still loading.
    Any time the value stored in the server XML cache under the key equal to the XML Id of this object
      changes, if the xmlBind property of this object is true.

    Any methods overriding this method should begin with a call to jsxsupermix().
     * @param objEvent the event published by the cache.
     */
    public void onXmlBinding(Object objEvent)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("onXmlBinding(").appendData(objEvent).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes a parameter from the list of parameters to pass to the XSL stylesheet during transformation.
     * @param strName the name of the XSL parameter to remove.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable removeXSLParam(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeXSLParam(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Removes all parameters from the list of parameters to pass to the XSL stylesheet during transformation.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable removeXSLParams()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeXSLParams().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Removes the XML and XSL source documents from the server cache.
     * @param objServer the server owning the cache to modify. This is a required argument only if
    <code>this.getServer()</code> does not returns a server instance.
     */
    public void resetCacheData(org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("resetCacheData(").appendData(objServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes the XML source document stored under the XML ID of this object from the server cache.
     * @param objServer the server owning the cache to modify. This is a required argument only if
    <code>this.getServer()</code> does not returns a server instance.
     */
    public void resetXmlCacheData(org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("resetXmlCacheData(").appendData(objServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets whether this object removes its XML and XSL source documents from the cache of its server when it
    is destroyed.
     * @param intShare <code>CLEANUPRESOURCES</code> or <code>SHARERESOURCES</code>. <code>CLEANUPRESOURCES</code>
    is the default value if the property is <code>null</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setShareResources(int intShare)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setShareResources(\"" + intShare + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets the source document of this object as though objDoc were retrieved from the XML URL or XML
    string of this object. This method executes the following steps:

    The document is transformed serially by each XML transformers of this object.
    The XML document is saved in the server cache under the XML ID of this object.
    If this object is an instance of jsx3.xml.CDF and the root node is a <data> element
    and its jsxassignids attribute is equal to 1, all <record> elements without a
    jsxid attribute are assigned a unique jsxid.
    If this object is an instance of jsx3.xml.CDF, convertProperties() is called
    on this object.
     * @param objDoc 
     * @param objCache 
     * @return the document stored in the server cache as the data source of this object. If
    transformers were run, this value will not be equal to the <code>objDoc</code> parameter.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document setSourceXML(org.directwebremoting.proxy.jsx3.xml.Document objDoc, org.directwebremoting.proxy.jsx3.app.Cache objCache)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setSourceXML(\"" + objDoc + "\", \"" + objCache + "\").");
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
     * Sets the source document of this object as though objDoc were retrieved from the XML URL or XML
    string of this object. This method executes the following steps:

    The document is transformed serially by each XML transformers of this object.
    The XML document is saved in the server cache under the XML ID of this object.
    If this object is an instance of jsx3.xml.CDF and the root node is a <data> element
    and its jsxassignids attribute is equal to 1, all <record> elements without a
    jsxid attribute are assigned a unique jsxid.
    If this object is an instance of jsx3.xml.CDF, convertProperties() is called
    on this object.
     * @param objDoc 
     * @param objCache 
     * @param returnType The expected return type
     * @return the document stored in the server cache as the data source of this object. If
    transformers were run, this value will not be equal to the <code>objDoc</code> parameter.
     */
    @SuppressWarnings("unchecked")
    public <T> T setSourceXML(org.directwebremoting.proxy.jsx3.xml.Document objDoc, org.directwebremoting.proxy.jsx3.app.Cache objCache, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setSourceXML(\"" + objDoc + "\", \"" + objCache + "\").");
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
     * Sets the XML ID of this object. This value is the key under which the XML source document of this object is
    saved in the cache of the server owning this object. The developer may specify either a unique or shared value.
    If no value is specified, a unique id is generated.
     * @param strXMLId 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXMLId(String strXMLId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLId(\"" + strXMLId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets the XML string of this object. Setting this value to the string serialization of an XML document is one
    way of specifying the source XML document of this object.
     * @param strXML <code>null</code> or a well-formed serialized XML element.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXMLString(String strXML)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLString(\"" + strXML + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets the list of XML transformers of this object. The XML source document of this object is transformed
    serially by each of these transformers before it is placed in the XML cache.

    Each transformer is either the URI of an XSLT document (which will be resolved against the
    the server of this object) or the cache id of a XSLT document in the XML cache of the server
    of this object. When any transformer is loaded from a URI it is placed in the server cache under the id
    equal to its resolved URI. Any transformer that does not correspond to a valid XSLT document will be skipped
    without throwing an error.
     * @param arrTrans 
     */
    public void setXMLTransformers(Object[] arrTrans)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setXMLTransformers(").appendData(arrTrans).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the XML URL of this object. Settings this value to the URI of an XML document is one way of specifying the
    source XML document of this object.
     * @param strXMLURL <code>null</code> or a URI that when resolved against the server owning this object
    specifies a valid XML document.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXMLURL(String strXMLURL)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLURL(\"" + strXMLURL + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Adds a name/value pair to the list of parameters to pass to the XSL stylesheet during transformation. If
    strValue is null the parameter is removed.
     * @param strName the name of the XSL parameter to add.
     * @param strValue the value of the XSL parameter to add.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXSLParam(String strName, String strValue)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXSLParam(\"" + strName + "\", \"" + strValue + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets whether the XML data source of this object is loaded asynchronously. This setting only applies to
    data sources loaded from an XML URL.
     * @param bAsync 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXmlAsync(boolean bAsync)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXmlAsync(\"" + bAsync + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /*
     * Sets whether this object is bound to the XML document stored in the data cache. If this object is bound to the
    cache, then the onXmlBinding() method of this object is called any time the document stored in
    the cache under the XML Id of this object changes.
     * @param bBind 
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int setXmlBind( bBind, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

}
