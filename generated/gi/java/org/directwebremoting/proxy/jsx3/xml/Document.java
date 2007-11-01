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
public class Document extends org.directwebremoting.proxy.jsx3.xml.Entity
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Document(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer. If an error occurs while instantiating the native browser XML document class,
    this method sets the error property of this document and returns quietly.
     * @param objDoc the native browser document object (optional).
     */
    public Document(Object objDoc)
    {
        super((ProxyHelper) null);
    }

    /**
     * Event type published when an asynchronous load operation has completed successfully.
     */
    public static final String ON_RESPONSE = "response";

    /**
     * Event type published when an error occurs during the asynchronous loading of a document.
     */
    public static final String ON_ERROR = "error";

    /**
     * Event type published when an asynchronous load times out before loading.
     */
    public static final String ON_TIMEOUT = "timeout";

    /**
     * Namespace to use when querying against the namespace axis in firefox
     */
    public static final String SEARCHABLE_NAMESPACE = "http://xsd.tns.tibco.com/gi/cxf/2006";

    /**
     * Prefix to use when querying against the namespace axis in firefox
     */
    public static final String SEARCHABLE_PREFIX = "jsx_xmlns";

    /**
     * Loads an XML document at the URL specified by the strURL parameter. If an error occurs while
    loading the XML document, this method sets the error property of this document and returns quietly. If this
    document loads synchronously, the results of the load will be available immediately after the call to this
    method. Otherwise, this document publishes events through the EventDispatcher interface to notify
    the client that loading has completed.
     * @param strURL either a relative or absolute URL pointing to an XML document to load.
     * @param intTimeout the number of milliseconds to wait before timing out. This parameter is only relevant
    if this document is loading XML asynchronously. A zero or <code>null</code> value will cause this operation
    to wait forever.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document load(String strURL, int intTimeout)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + intTimeout + "\").");
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
     * Loads an XML document at the URL specified by the strURL parameter. If an error occurs while
    loading the XML document, this method sets the error property of this document and returns quietly. If this
    document loads synchronously, the results of the load will be available immediately after the call to this
    method. Otherwise, this document publishes events through the EventDispatcher interface to notify
    the client that loading has completed.
     * @param strURL either a relative or absolute URL pointing to an XML document to load.
     * @param intTimeout the number of milliseconds to wait before timing out. This parameter is only relevant
    if this document is loading XML asynchronously. A zero or <code>null</code> value will cause this operation
    to wait forever.
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T load(String strURL, int intTimeout, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + intTimeout + "\").");
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
     * Loads an XML document at the URL specified by the strURL parameter. If an error occurs while
    loading the XML document, this method sets the error property of this document and returns quietly. If this
    document loads synchronously, the results of the load will be available immediately after the call to this
    method. Otherwise, this document publishes events through the EventDispatcher interface to notify
    the client that loading has completed.
     * @param strURL either a relative or absolute URL pointing to an XML document to load.
     * @param intTimeout the number of milliseconds to wait before timing out. This parameter is only relevant
    if this document is loading XML asynchronously. A zero or <code>null</code> value will cause this operation
    to wait forever.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document load(org.directwebremoting.proxy.jsx3.net.URI strURL, int intTimeout)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + intTimeout + "\").");
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
     * Loads an XML document at the URL specified by the strURL parameter. If an error occurs while
    loading the XML document, this method sets the error property of this document and returns quietly. If this
    document loads synchronously, the results of the load will be available immediately after the call to this
    method. Otherwise, this document publishes events through the EventDispatcher interface to notify
    the client that loading has completed.
     * @param strURL either a relative or absolute URL pointing to an XML document to load.
     * @param intTimeout the number of milliseconds to wait before timing out. This parameter is only relevant
    if this document is loading XML asynchronously. A zero or <code>null</code> value will cause this operation
    to wait forever.
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T load(org.directwebremoting.proxy.jsx3.net.URI strURL, int intTimeout, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("load(\"" + strURL + "\", \"" + intTimeout + "\").");
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
     * Loads an XML document from a string containing the XML source. If an error occurs while
    loading the XML document, this method sets the error property of this document and returns quietly. Loading
    an XML document from a string always happens synchronously regardless of the value of the async
    property of this document.
     * @param strXML an XML document as string. Note that if this document contains an encoding attribute in
    its initial declaration (such as encoding="UTF-8") it must correspond to the encoding of the actual string,
    <code>strXML</code>. If, for example, <code>strXML</code> is in unicode format, explicitly passing the UTF-8
    encoding attribute will cause the load to fail, as the byte order will cause the parser to look for the
    UTF-16 attribute.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document loadXML(String strXML)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadXML(\"" + strXML + "\").");
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
     * Loads an XML document from a string containing the XML source. If an error occurs while
    loading the XML document, this method sets the error property of this document and returns quietly. Loading
    an XML document from a string always happens synchronously regardless of the value of the async
    property of this document.
     * @param strXML an XML document as string. Note that if this document contains an encoding attribute in
    its initial declaration (such as encoding="UTF-8") it must correspond to the encoding of the actual string,
    <code>strXML</code>. If, for example, <code>strXML</code> is in unicode format, explicitly passing the UTF-8
    encoding attribute will cause the load to fail, as the byte order will cause the parser to look for the
    UTF-16 attribute.
     * @param returnType The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T loadXML(String strXML, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadXML(\"" + strXML + "\").");
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
     * 
     *
    @SuppressWarnings("unchecked")
    public String getSourceURL(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether or not the parser should validate the XML content during the initial parse. The default setting is false;
     *
    @SuppressWarnings("unchecked")
    public boolean getValidateOnParse(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not the parser should validate the XML content during the initial parse.
     * @param bValidate 
     */
    public void setValidateOnParse(boolean bValidate)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValidateOnParse(").appendData(bValidate).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether or not the parser should resolve externally referenced entities. The default setting is false;
     *
    @SuppressWarnings("unchecked")
    public boolean getResolveExternals(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not the parser should resolve externally referenced entities.
     * @param bResolve 
     */
    public void setResolveExternals(boolean bResolve)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setResolveExternals(").appendData(bResolve).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public String getXmlVersion(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public String getXmlEncoding(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public boolean getXmlStandalone(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Creates a new node that is an exact clone of this node; returns the newly cloned node wrapped in a jsx3.xml.Entity instance
     * @return newly cloned MSXML Node object wrapped in a jsx3.xml.Document instance
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document cloneDocument()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("cloneDocument().");
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
     * Creates a new node that is an exact clone of this node; returns the newly cloned node wrapped in a jsx3.xml.Entity instance
     * @param returnType The expected return type
     * @return newly cloned MSXML Node object wrapped in a jsx3.xml.Document instance
     */
    @SuppressWarnings("unchecked")
    public <T> T cloneDocument(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("cloneDocument().");
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
     * 
     * @param strVersion 
     * @param strEncoding 
     * @param bStandalone 
     */
    public void serialize(boolean strVersion, boolean strEncoding, boolean bStandalone)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("serialize(").appendData(strVersion).appendScript(",")

        .appendData(strEncoding).appendScript(",")

        .appendData(bStandalone).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param strVersion 
     * @param strEncoding 
     * @param bStandalone 
     */
    public void serialize(boolean strVersion, String strEncoding, boolean bStandalone)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("serialize(").appendData(strVersion).appendScript(",")

        .appendData(strEncoding).appendScript(",")

        .appendData(bStandalone).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param strVersion 
     * @param strEncoding 
     * @param bStandalone 
     */
    public void serialize(String strVersion, boolean strEncoding, boolean bStandalone)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("serialize(").appendData(strVersion).appendScript(",")

        .appendData(strEncoding).appendScript(",")

        .appendData(bStandalone).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * 
     * @param strVersion 
     * @param strEncoding 
     * @param bStandalone 
     */
    public void serialize(String strVersion, String strEncoding, boolean bStandalone)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("serialize(").appendData(strVersion).appendScript(",")

        .appendData(strEncoding).appendScript(",")

        .appendData(bStandalone).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Creates a new root node on an empty document.
    Usage:

    var objDoc = new jsx3.xml.Document();
    objDoc.createDocumentElement("myRoot");
     * @param strNodeName node name for the root node
     * @param strNSURI namespace (optional). For example, "http:/someURN.com/". Note that if this parameter is used, @strNodeName can be optionally prefixed (i.e., abc:myRoot) to create an explicit namespace prefix.
     * @return reference to the new node wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity createDocumentElement(String strNodeName, String strNSURI)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createDocumentElement(\"" + strNodeName + "\", \"" + strNSURI + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Creates a new root node on an empty document.
    Usage:

    var objDoc = new jsx3.xml.Document();
    objDoc.createDocumentElement("myRoot");
     * @param strNodeName node name for the root node
     * @param strNSURI namespace (optional). For example, "http:/someURN.com/". Note that if this parameter is used, @strNodeName can be optionally prefixed (i.e., abc:myRoot) to create an explicit namespace prefix.
     * @param returnType The expected return type
     * @return reference to the new node wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public <T> T createDocumentElement(String strNodeName, String strNSURI, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createDocumentElement(\"" + strNodeName + "\", \"" + strNSURI + "\").");
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
     * Creates a processing instruction node that containing the target and data information. Note that you cannot specify a namespace with this method.
    Usage:

    [document].createProcessingInstruction("xml","version=\"1.0\" encoding=\"UTF-8\"");
    [document].createDocumentElement("myRoot");
     * @param strTarget String that specifies the target part of the processing instruction. This supplies the nodeName property of the new object.
     * @param strData String that specifies the rest of the processing instruction preceding the closing ?> characters. This supplies the nodeValue property for the new object.
     */
    public void createProcessingInstruction(String strTarget, String strData)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("createProcessingInstruction(").appendData(strTarget).appendScript(",")

        .appendData(strData).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets whether this document loads asynchronously. The default is to load synchronously. If this document loads
    asynchronously, it publishes the events ON_RESPONSE, ON_ERROR, and
    ON_TIMEOUT to notify the client that loading has finished.
     * @param bAsync if <code>true</code> the document loads asynchronously.
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.xml.Document setAsync(boolean bAsync)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAsync(").appendData(bAsync).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns whether this document loads asynchronously.
     * @param strName 
     *
    @SuppressWarnings("unchecked")
    public boolean getAsync( strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the selection language to use for selection queries (i.e., selectSingleNode/selectNodes); The default is XSLPattern;
     * @param strLanguage one of the strings: <code>XSLPattern</code>, <code>XPath</code>
     * @return reference to this
     */
    public org.directwebremoting.proxy.jsx3.xml.Document setSelectionLanguage(String strLanguage)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSelectionLanguage(").appendData(strLanguage).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Gets the selection language to use for selection queries (i.e., selectSingleNode/selectNodes); The default is XSLPattern;
     *
    @SuppressWarnings("unchecked")
    public String getSelectionLanguage(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets a list of namespace prefixes and their associated URIs. This allows any code to generically prefix name-space qualified nodes and still get the correct selection result
     * @param declaration Relevant selection namespace(s) in Object format. For example: <code>{some_uri:"jsx1",some_other_uri,"jsx2"}</code>
                             or in String format. For example: <code>"xmlns:jsx1='some_uri' xmlns:jsx2='some_other_uri'"</code>
     * @return reference to this
     */
    public org.directwebremoting.proxy.jsx3.xml.Document setSelectionNamespaces(Object declaration)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSelectionNamespaces(").appendData(declaration).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets a list of namespace prefixes and their associated URIs. This allows any code to generically prefix name-space qualified nodes and still get the correct selection result
     * @param declaration Relevant selection namespace(s) in Object format. For example: <code>{some_uri:"jsx1",some_other_uri,"jsx2"}</code>
                             or in String format. For example: <code>"xmlns:jsx1='some_uri' xmlns:jsx2='some_other_uri'"</code>
     * @return reference to this
     */
    public org.directwebremoting.proxy.jsx3.xml.Document setSelectionNamespaces(String declaration)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSelectionNamespaces(").appendData(declaration).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Gets a list of namespace prefixes and their associated URIs. This allows any code to generically prefix name-space qualified nodes and still get the correct selection result
     * @param strName 
     *
    @SuppressWarnings("unchecked")
    public String getSelectionNamespaces( strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * The Firefox implementation of the XSLT specification does not implement a searchable namespace axis. To overcome this limitation,
    this method can be called to create a searchable equivalent that is part of the attribute axis. After XML content has been loaded, call this method before
    calling any other methods on the Document instance in order to ensure proper functioning of subsequent calls. The document
    can then be queried, using valid XPath syntax to discover the declared namespaces. However, instead of using namespace::xsd, the
    relevant query would be attribute::jsx_xmlns:xsd, where jsx_xmlns:xsd would resolve to the
    universal name, {http://xsd.tns.tibco.com/gi/cxf/2006}:xsd. Following this call with getDeclaredNamespaces
    is useful to resolve the prefix actually used, providing a reverse-lookup to resolve the actual prefix being used.
    For example, assume objMap is the return object when calling getDeclaredNamespaces. In such a case, the following
    query can be used to locate the URI for a given namespace prefix, even though Firefox does not support such a construct:


    var objMap = someDoc.getDeclaredNamespaces();
    var myXpathQuery = "ancestor-or-self::*[attribute::" +
    objMap[jsx3.xml.Document.SEARCHABLE_NAMESPACE] +  ":xsd]/attribute::" +
    objMap[jsx3.xml.Document.SEARCHABLE_NAMESPACE] + ":xsd";
    var objNode = someNode.selectSingleNode(myXpathQuery,objMap);
     * @return prefix used to represent the xmlns.  By default the return will be <b>jsx_xmlns</b>. However, if this prefix is
    already being used by the document instance (i.e., <code>xmlns:jsx_xmlns="?"</code>), the prefix will be
    incremented as follows: jsx_xmlns0, jsx_xmlns1, jsx_xmlns2, etc, until a unique prefix is found.
     *
    @SuppressWarnings("unchecked")
    public String createNamespaceAxis(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns a map of all implemented namespaces in the following format: {some_uri:"jsx1",some_other_uri,"jsx2",another_uri:"jsx3"}.

    The returned object map can then be used to resolve the qualified name (QName) for the nodes in a given query via a reverse lookup.
    For example:

    //open an XML Document (just use one of the sample prototypes that ships with Builder)
    var objXML = new jsx3.xml.Document();
    objXML.load("GI_Builder/prototypes/Block/Text.xml");
    //get an object map of all known selection namespaces
    var objMap = objXML.getDeclaredNamespaces();
    //construct a qualified query (Note that all nodes in a GI serialization file belong to the namespace, 'urn:tibco.com/v3.0')
    var myQualifiedQuery = "//" + objMap["urn:tibco.com/v3.0"] + ":object";
    //query the document for the given node.
    var objNode = objXML.selectSingleNode(myQualifiedQuery,objMap);
    //alert the return
    alert(objNode);
     * @param objMap Optional. should follow the format <code>{prefix1:1,prefix2:1}</code>. If passed, the returned Object will resolve to any matched prefix, while using arbitrary sequential prefixes (jsx1, jsx2, etc) for all other uris.
     *
    @SuppressWarnings("unchecked")
    public Object getDeclaredNamespaces(Object objMap, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the native XML parser
     *
    @SuppressWarnings("unchecked")
    public Object getNativeDocument(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

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
