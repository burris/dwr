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
     * @param objParams 
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
     * @param objXML 
     */
    public void transform(org.directwebremoting.proxy.jsx3.xml.Entity objXML)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("transform(")
              .appendData(objXML)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * 
     * @param objXML 
     */
    public void transformToObject(org.directwebremoting.proxy.jsx3.xml.Entity objXML)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("transformToObject(")
              .appendData(objXML)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * 
     * @param objXML 
     * @return 
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
     * @param type The expected return type
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
     * @param type The expected return type
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
        script.appendData(getProxyHelper().getContext())
              .appendScript("createProcessingInstruction(")
              .appendData(strTarget)
              .appendScript(",")
              
              .appendData(strData)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns whether this document loads asynchronously.
     * @param strName 
     * @return 
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
     * @return 
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
     * @return 
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
     * Returns whether or not the parser should resolve externally referenced entities. The default setting is false;
     * @return 
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
    
    /*
     * Gets the selection language to use for selection queries (i.e., selectSingleNode/selectNodes); The default is XSLPattern;
     * @return 
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
    
    /*
     * Gets a list of namespace prefixes and their associated URIs. This allows any code to generically prefix name-space qualified nodes and still get the correct selection result
     * @param strName 
     * @return 
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
     * 
     * @return 
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
     * @return 
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
    
    /*
     * 
     * @return 
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
     * @return 
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
    
    /*
     * 
     * @return 
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
     * @param type The expected return type
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
     * @param type The expected return type
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
    
    /**
     * 
     * @param strVersion 
     * @param strEncoding 
     * @param bStandalone 
     */
    public void serialize(boolean strVersion, boolean strEncoding, boolean bStandalone)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("serialize(")
              .appendData(strVersion)
              .appendScript(",")
              
              .appendData(strEncoding)
              .appendScript(",")
              
              .appendData(bStandalone)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets whether this document loads asynchronously. The default is to load synchronously. If this document loads
asynchronously, it publishes the events ON_RESPONSE, ON_ERROR, and
ON_TIMEOUT to notify the client that loading has finished.
     * @param bAsync if <code>true</code> the document loads asynchronously.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document setAsync(boolean bAsync)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setAsync(\"" + bAsync + "\").");
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
     * Sets whether this document loads asynchronously. The default is to load synchronously. If this document loads
asynchronously, it publishes the events ON_RESPONSE, ON_ERROR, and
ON_TIMEOUT to notify the client that loading has finished.
     * @param bAsync if <code>true</code> the document loads asynchronously.
     * @param type The expected return type
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public <T> T setAsync(boolean bAsync, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setAsync(\"" + bAsync + "\").");
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
     * Sets whether or not the parser should resolve externally referenced entities.
     * @param bResolve 
     */
    public void setResolveExternals(boolean bResolve)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setResolveExternals(")
              .appendData(bResolve)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * Sets the selection language to use for selection queries (i.e., selectSingleNode/selectNodes); The default is XSLPattern;
     * @param strLanguage one of the strings: <code>XSLPattern</code>, <code>XPath</code>
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document setSelectionLanguage(String strLanguage)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setSelectionLanguage(\"" + strLanguage + "\").");
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
     * Sets the selection language to use for selection queries (i.e., selectSingleNode/selectNodes); The default is XSLPattern;
     * @param strLanguage one of the strings: <code>XSLPattern</code>, <code>XPath</code>
     * @param type The expected return type
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public <T> T setSelectionLanguage(String strLanguage, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setSelectionLanguage(\"" + strLanguage + "\").");
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
     * Sets a list of namespace prefixes and their associated URIs. This allows any code to generically prefix name-space qualified nodes and still get the correct selection result
     * @param declaration Relevant selection namespace(s) in Object format. For example: <code>{some_uri:"jsx1",some_other_uri,"jsx2"}</code>
                             or in String format. For example: <code>"xmlns:jsx1='some_uri' xmlns:jsx2='some_other_uri'"</code>
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document setSelectionNamespaces(Object declaration)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setSelectionNamespaces(\"" + declaration + "\").");
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
     * Sets a list of namespace prefixes and their associated URIs. This allows any code to generically prefix name-space qualified nodes and still get the correct selection result
     * @param declaration Relevant selection namespace(s) in Object format. For example: <code>{some_uri:"jsx1",some_other_uri,"jsx2"}</code>
                             or in String format. For example: <code>"xmlns:jsx1='some_uri' xmlns:jsx2='some_other_uri'"</code>
     * @param type The expected return type
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public <T> T setSelectionNamespaces(Object declaration, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setSelectionNamespaces(\"" + declaration + "\").");
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
     * Sets whether or not the parser should validate the XML content during the initial parse.
     * @param bValidate 
     */
    public void setValidateOnParse(boolean bValidate)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setValidateOnParse(")
              .appendData(bValidate)
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
    
    /**
     * Appends the objEntity parameter as a child of this entity. If an error occurs while
appending to this XML entity, this method sets the error property of this entity and returns quietly.
     * @param objEntity jsx3.xml.Entity instance that will be bound as a child to this jsx3.xml.Entity instance
     * @return reference to self
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity appendChild(org.directwebremoting.proxy.jsx3.xml.Entity objEntity)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("appendChild(\"" + objEntity + "\").");
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
     * Appends the objEntity parameter as a child of this entity. If an error occurs while
appending to this XML entity, this method sets the error property of this entity and returns quietly.
     * @param objEntity jsx3.xml.Entity instance that will be bound as a child to this jsx3.xml.Entity instance
     * @param type The expected return type
     * @return reference to self
     */
    @SuppressWarnings("unchecked")
    public <T> T appendChild(org.directwebremoting.proxy.jsx3.xml.Entity objEntity, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("appendChild(\"" + objEntity + "\").");
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
     * Creates a new node that is an exact clone of this node. If an error occurs while
cloning this XML entity, this method sets the error property of this entity and returns quietly.
     * @param bDeep if true, all descendants of this object will also be cloned and returned
     * @return newly cloned MSXML Node object wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity cloneNode(boolean bDeep)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("cloneNode(\"" + bDeep + "\").");
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
     * Creates a new node that is an exact clone of this node. If an error occurs while
cloning this XML entity, this method sets the error property of this entity and returns quietly.
     * @param bDeep if true, all descendants of this object will also be cloned and returned
     * @param type The expected return type
     * @return newly cloned MSXML Node object wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public <T> T cloneNode(boolean bDeep, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("cloneNode(\"" + bDeep + "\").");
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
     * Creates a new node and returns as jsx3.xml.Entity instance
     * @param intType Four types are supported: jsx3.xml.Entity.TYPEELEMENT, jsx3.xml.Entity.TYPEATTRIBUTE, jsx3.xml.Entity.TYPETEXT, jsx3.xml.Entity.TYPECDATA. Note: only nodes of TYPEELEMENT and TYPEATTRIBUTE will pay attention to the @strNodeName property; if not of this TYPE, pass an empty string
     * @param strNodeName node name for the node to add as a child
     * @param strNS namespace URI for the node being created, if it is preceded by a URI.
           So, for example, if 'strName' is "xsi:string", then the 'strNS'
           value should be the namespace associated with the xsi prefix
     * @return reference to the new node wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity createNode(int intType, String strNodeName, String strNS)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createNode(\"" + intType + "\", \"" + strNodeName + "\", \"" + strNS + "\").");
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
     * Creates a new node and returns as jsx3.xml.Entity instance
     * @param intType Four types are supported: jsx3.xml.Entity.TYPEELEMENT, jsx3.xml.Entity.TYPEATTRIBUTE, jsx3.xml.Entity.TYPETEXT, jsx3.xml.Entity.TYPECDATA. Note: only nodes of TYPEELEMENT and TYPEATTRIBUTE will pay attention to the @strNodeName property; if not of this TYPE, pass an empty string
     * @param strNodeName node name for the node to add as a child
     * @param strNS namespace URI for the node being created, if it is preceded by a URI.
           So, for example, if 'strName' is "xsi:string", then the 'strNS'
           value should be the namespace associated with the xsi prefix
     * @param type The expected return type
     * @return reference to the new node wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public <T> T createNode(int intType, String strNodeName, String strNS, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createNode(\"" + intType + "\", \"" + strNodeName + "\", \"" + strNS + "\").");
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
     * Tests the equivalency of two jsx3.xml.Entity instances as they wrap and can therefore point to the same native entity, causing a standard "==" comparison to fail
     * @param objEntity jsx3.xml.Entity object
     * @return true or false
     *
    @SuppressWarnings("unchecked")
    public boolean equals(org.directwebremoting.proxy.jsx3.xml.Entity objEntity, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the value for the named attribute strName.
     * @param strName the name of the attribute.
     * @return the attribute value or <code>undefined</code> if the attribute does not exist.
     *
    @SuppressWarnings("unchecked")
    public String getAttribute(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the names of all the attributes of this node. Iterating over the attribute names is more performant than
using the getAttributes() method.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object[] getAttributeNames(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns an object reference (a jsx3.xml.Entity instance) to the child attribute with the name, @strName.
This method should only be called on an instance of type TYPEELEMENT.
     * @param strName name of the attribute
     * @return jsx3.xml.Entity instance referencing a single attribute node object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getAttributeNode(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAttributeNode(\"" + strName + "\").");
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
     * Returns an object reference (a jsx3.xml.Entity instance) to the child attribute with the name, @strName.
This method should only be called on an instance of type TYPEELEMENT.
     * @param strName name of the attribute
     * @param type The expected return type
     * @return jsx3.xml.Entity instance referencing a single attribute node object
     */
    @SuppressWarnings("unchecked")
    public <T> T getAttributeNode(String strName, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAttributeNode(\"" + strName + "\").");
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
     * Returns handle to a jsx3.util.List instance of all children; note that this collection will always be empty (length = 0) for all types except for jsx3.xml.Entity.TYPEELEMENT
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List getAttributes()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAttributes().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    
    
    /*
     * Returns the right-hand side of a namespace qualified name. For example, "Price" will be returned for the
element <USD:Price>
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getBaseName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns an iterator that iterates over the child nodes of this node. Note that the iterator grants access to
only one child node at a time; once next() is called, the value returned by the previous call to
next() is no longer valid. This method is more performant than getChildNodes().
     * @param bIncludeText if <code>true</code> then the returned iterator will include the child text nodes
  of this node.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Iterator getChildIterator(boolean bIncludeText)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChildIterator(\"" + bIncludeText + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Iterator> ctor = org.directwebremoting.proxy.jsx3.util.Iterator.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Iterator.class.getName());
        }
    }

    
    
    /**
     * Returns the child nodes of this entity. By default this method only returns the child nodes that are elements.
Text and CDATA children will be returned if bIncludeText is true.
     * @param bIncludeText if <code>true</code>, text and cdata children are returned with element children.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List getChildNodes(boolean bIncludeText)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getChildNodes(\"" + bIncludeText + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
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
    
    /**
     * Returns the first child element of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if both conditions are not met
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getFirstChild()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChild().");
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
     * Returns the first child element of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if both conditions are not met
     * @param type The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChild(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChild().");
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
     * Returns the last child element of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if both conditions are not met
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getLastChild()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLastChild().");
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
     * Returns the last child element of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if both conditions are not met
     * @param type The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getLastChild(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLastChild().");
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
     * Returns the value (as string) for URI (universal resource identifier) of the namespace for the given node; returns an empty string if no namespace exists
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getNamespaceURI(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns the native browser XML node wrapped by this entity.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public Object getNative(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the next sibling if this node and the referenced sibling are of type jsx3.xml.Entity.TYPEELEMENT; returns null if condition is not met
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getNextSibling()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getNextSibling().");
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
     * Returns the next sibling if this node and the referenced sibling are of type jsx3.xml.Entity.TYPEELEMENT; returns null if condition is not met
     * @param type The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getNextSibling(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getNextSibling().");
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
     * Returns the name of the node as string (assuming this jsx3.xml.Entity instance is of type jsx3.xml.Entity.TYPEELEMENT or jsx3.xml.Entity.TYPEATTRIBUTE). The other TYPES return "#cdata-section" and "#text" respectively
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getNodeName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns one of: jsx3.xml.Entity.TYPEELEMENT, jsx3.xml.Entity.TYPEATTRIBUTE, jsx3.xml.Entity.TYPETEXT, jsx3.xml.Entity.TYPECDATA
     * @return 
     *
    @SuppressWarnings("unchecked")
    public int getNodeType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the document that owns this entity.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getOwnerDocument()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOwnerDocument().");
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
     * Returns the document that owns this entity.
     * @param type The expected return type
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getOwnerDocument(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getOwnerDocument().");
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
     * Returns the parent node as a jsx3.xml.Entity instance; if this node is the root node of the document, null is returned
     * @return parent node or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getParent()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
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
     * Returns the parent node as a jsx3.xml.Entity instance; if this node is the root node of the document, null is returned
     * @param type The expected return type
     * @return parent node or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getParent(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
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
     * Returns the left-hand side of a namespace qualified name. For example, "USD" will be returned for the
element <USD:Price>
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getPrefix(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Returns the previous sibling if this node and the referenced sibling are of type jsx3.xml.Entity.TYPEELEMENT; returns null if condition is not met
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getPreviousSibling()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPreviousSibling().");
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
     * Returns the previous sibling if this node and the referenced sibling are of type jsx3.xml.Entity.TYPEELEMENT; returns null if condition is not met
     * @param type The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getPreviousSibling(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getPreviousSibling().");
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
     * Returns reference to the document element (root) wrapped in jsx3.xml.Entity instance
     * @return jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getRootNode()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRootNode().");
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
     * Returns reference to the document element (root) wrapped in jsx3.xml.Entity instance
     * @param type The expected return type
     * @return jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public <T> T getRootNode(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRootNode().");
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
     * Contains the text content of the node, including the concatenated text contained by all descendant entities
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String getValue(Callback callback)
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
    
    /**
     * inserts the jsx3.xml.Entity instance, @objEntityNew immediately before the existing child @objEntityRef and returns a handle to @objEntityNew; requires that both parameters be of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if all conditions are not met
     * @param objEntityNew jsx3.xml.Entity object (the new one to add)
     * @param objEntityRef jsx3.xml.Entity object (the reference node in front of which to insert the new node)
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity insertBefore(org.directwebremoting.proxy.jsx3.xml.Entity objEntityNew, org.directwebremoting.proxy.jsx3.xml.Entity objEntityRef)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("insertBefore(\"" + objEntityNew + "\", \"" + objEntityRef + "\").");
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
     * inserts the jsx3.xml.Entity instance, @objEntityNew immediately before the existing child @objEntityRef and returns a handle to @objEntityNew; requires that both parameters be of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if all conditions are not met
     * @param objEntityNew jsx3.xml.Entity object (the new one to add)
     * @param objEntityRef jsx3.xml.Entity object (the reference node in front of which to insert the new node)
     * @param type The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T insertBefore(org.directwebremoting.proxy.jsx3.xml.Entity objEntityNew, org.directwebremoting.proxy.jsx3.xml.Entity objEntityRef, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("insertBefore(\"" + objEntityNew + "\", \"" + objEntityRef + "\").");
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
     * Removes the specified attribute by the given name (can only be called for nodes of type jsx3.xml.Entity.TYPELEMENT)
     * @param strAttName the name of the attribute to remove
     */
    public void removeAttribute(String strAttName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("removeAttribute(")
              .appendData(strAttName)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * removes the attribute object as a child of the element;
     * @param objAtt jsx3.xml.Entity instance of type jsx3.xml.Entity.TYPEATTRIBUTE;
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity removeAttributeNode(org.directwebremoting.proxy.jsx3.xml.Entity objAtt)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttributeNode(\"" + objAtt + "\").");
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
     * removes the attribute object as a child of the element;
     * @param objAtt jsx3.xml.Entity instance of type jsx3.xml.Entity.TYPEATTRIBUTE;
     * @param type The expected return type
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public <T> T removeAttributeNode(org.directwebremoting.proxy.jsx3.xml.Entity objAtt, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeAttributeNode(\"" + objAtt + "\").");
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
     * Removes the specified child (@objChildEntity) from the list of children and returns it; returns null if @objChildEntity is not actually a child
     * @param objChildEntity jsx3.xml.Entity object that is a direct child of this jsx3.xml.Entity instance
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity removeChild(org.directwebremoting.proxy.jsx3.xml.Entity objChildEntity)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChild(\"" + objChildEntity + "\").");
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
     * Removes the specified child (@objChildEntity) from the list of children and returns it; returns null if @objChildEntity is not actually a child
     * @param objChildEntity jsx3.xml.Entity object that is a direct child of this jsx3.xml.Entity instance
     * @param type The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T removeChild(org.directwebremoting.proxy.jsx3.xml.Entity objChildEntity, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeChild(\"" + objChildEntity + "\").");
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
     * Removes all descendant entities of this node
     */
    public void removeChildren()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("removeChildren(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /**
     * replaces the child @objEntityOld with @objEntityNew and returns a handle to @objEntityOld; requires that both child entities be of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if all conditions are not met
     * @param objEntityNew jsx3.xml.Entity object (the new one to add)
     * @param objEntityOld jsx3.xml.Entity object (the old one to remove)
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity replaceNode(org.directwebremoting.proxy.jsx3.xml.Entity objEntityNew, org.directwebremoting.proxy.jsx3.xml.Entity objEntityOld)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("replaceNode(\"" + objEntityNew + "\", \"" + objEntityOld + "\").");
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
     * replaces the child @objEntityOld with @objEntityNew and returns a handle to @objEntityOld; requires that both child entities be of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if all conditions are not met
     * @param objEntityNew jsx3.xml.Entity object (the new one to add)
     * @param objEntityOld jsx3.xml.Entity object (the old one to remove)
     * @param type The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T replaceNode(org.directwebremoting.proxy.jsx3.xml.Entity objEntityNew, org.directwebremoting.proxy.jsx3.xml.Entity objEntityOld, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("replaceNode(\"" + objEntityNew + "\", \"" + objEntityOld + "\").");
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
     * Returns an iterator that iterates over the the result of an XPath query. Note that the iterator grants access to
only one child node at a time; once next() is called, the value returned by the previous call to
next() is no longer valid. This method is more performant than selectNodes().
     * @param strQuery an XPath query such as: <code>//somenode[@id='12']/somechild</code>.
     * @param strNS the selection namespace to use just for this query. This parameter is an optional
   shortcut for calling <code>setSelectionNamespaces()</code> on the owning document. The format of this parameter
   as a string is <code>"xmlns:ns1='uri1' xmlns:ns2='uri2'"</code> or as an object is <code>{'uri1':'ns1',
   'uri2':'ns2'}</code>.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Iterator selectNodeIterator(String strQuery, String strNS)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("selectNodeIterator(\"" + strQuery + "\", \"" + strNS + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Iterator> ctor = org.directwebremoting.proxy.jsx3.util.Iterator.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Iterator.class.getName());
        }
    }

    
    
    /**
     * Returns a list of nodes selected by an XPath query executed on this node.
     * @param strQuery an XPath query such as: <code>//somenode[@id='12']/somechild</code>.
     * @param strNS the selection namespace to use just for this query. This parameter is an optional
   shortcut for calling <code>setSelectionNamespaces()</code> on the owning document. The format of this parameter
   as a string is <code>"xmlns:ns1='uri1' xmlns:ns2='uri2'"</code> or as an object is <code>{'uri1':'ns1',
   'uri2':'ns2'}</code>.
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List selectNodes(String strQuery, String strNS)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("selectNodes(\"" + strQuery + "\", \"" + strNS + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    
    
    /**
     * Returns a single node selected by an XPath query executed on this node, or null if none is selected.
     * @param strQuery an XPath query such as: <code>//somenode[@id='12']/somechild</code>.
     * @param strNS the selection namespace to use just for this query. This parameter is an optional
   shortcut for calling <code>setSelectionNamespaces()</code> on the owning document. The format of this parameter
   as a string is <code>"xmlns:ns1='uri1' xmlns:ns2='uri2'"</code> or as an object is <code>{'uri1':'ns1',
   'uri2':'ns2'}</code>.
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity selectSingleNode(String strQuery, String strNS)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("selectSingleNode(\"" + strQuery + "\", \"" + strNS + "\").");
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
     * Returns a single node selected by an XPath query executed on this node, or null if none is selected.
     * @param strQuery an XPath query such as: <code>//somenode[@id='12']/somechild</code>.
     * @param strNS the selection namespace to use just for this query. This parameter is an optional
   shortcut for calling <code>setSelectionNamespaces()</code> on the owning document. The format of this parameter
   as a string is <code>"xmlns:ns1='uri1' xmlns:ns2='uri2'"</code> or as an object is <code>{'uri1':'ns1',
   'uri2':'ns2'}</code>.
     * @param type The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T selectSingleNode(String strQuery, String strNS, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("selectSingleNode(\"" + strQuery + "\", \"" + strNS + "\").");
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
     * Sets the @strValue of the named @strAttribute and binds as child of this
     * @param strName name of the attribute
     * @param strValue value of the attribute, if null then remove the attribute
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity setAttribute(String strName, String strValue)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setAttribute(\"" + strName + "\", \"" + strValue + "\").");
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
     * Sets the @strValue of the named @strAttribute and binds as child of this
     * @param strName name of the attribute
     * @param strValue value of the attribute, if null then remove the attribute
     * @param type The expected return type
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public <T> T setAttribute(String strName, String strValue, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setAttribute(\"" + strName + "\", \"" + strValue + "\").");
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
     * Sets the attribute object as a child of the element; if transferring an attribute from one element to another, this call must be preceded with removeAttributeNode on the previous owner
     * @param objAtt jsx3.xml.Entity instance of type jsx3.xml.Entity.TYPEATTRIBUTE;
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity setAttributeNode(org.directwebremoting.proxy.jsx3.xml.Entity objAtt)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setAttributeNode(\"" + objAtt + "\").");
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
     * Sets the attribute object as a child of the element; if transferring an attribute from one element to another, this call must be preceded with removeAttributeNode on the previous owner
     * @param objAtt jsx3.xml.Entity instance of type jsx3.xml.Entity.TYPEATTRIBUTE;
     * @param type The expected return type
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public <T> T setAttributeNode(org.directwebremoting.proxy.jsx3.xml.Entity objAtt, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setAttributeNode(\"" + objAtt + "\").");
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
     * sets the text value for this entity; returns a handle to this jsx3.xml.Entity instance
     * @param strValue value to set for this entity
     * @return self
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity setValue(String strValue)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setValue(\"" + strValue + "\").");
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
     * sets the text value for this entity; returns a handle to this jsx3.xml.Entity instance
     * @param strValue value to set for this entity
     * @param type The expected return type
     * @return self
     */
    @SuppressWarnings("unchecked")
    public <T> T setValue(String strValue, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setValue(\"" + strValue + "\").");
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
     * Returns the XML (as String) for this node and any descendants. For an attribute this would be the
         attribute name and value (i.e., name="value")
     * @return 
     *
    @SuppressWarnings("unchecked")
    public String toString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * performs an XSLT transformation, using @objEntityFilter as the XSLT filter for the transformation; returns
         results of the transformation as a string (of text/html/xml/etc)
     * @param objEntityFilter jsx3.xml.Entity instance containing the XSLT document to transform 'this' jsx3.xml.Entity instance with
     * @param objParams JavaScript object array of name/value pairs; if passed, the transformation will use a
         paramaterized stylesheet to perform the transformation
     * @param bObject if <code>true</code> this method returns a document instead of a string.
     * @return the result of the transformation
     *
    @SuppressWarnings("unchecked")
    public String transformNode(org.directwebremoting.proxy.jsx3.xml.Entity objEntityFilter, Object objParams, boolean bObject, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
 }
