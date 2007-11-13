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
public class Entity extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Entity(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer. If an error occurs while instantiating this entity, this method sets the error
    property of this entity and returns quietly.
     * @param objEntity the browser native entity instance to wrap.
     */
    public Entity(Object objEntity)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Entity", objEntity);
        setInitScript(script);
    }

    /**
     * The node type for an element node.
     */
    public static final int TYPEELEMENT = 1;

    /**
     * The node type for an attribute node.
     */
    public static final int TYPEATTRIBUTE = 2;

    /**
     * The node type for a text node.
     */
    public static final int TYPETEXT = 3;

    /**
     * The node type for a character data node.
     */
    public static final int TYPECDATA = 4;

    /**
     * The node type for a comment node.
     */
    public static final int TYPECOMMENT = 8;

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
        String extension = "createNode(\"" + intType + "\", \"" + strNodeName + "\", \"" + strNS + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     * @param returnType The expected return type
     * @return reference to the new node wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public <T> T createNode(int intType, String strNodeName, String strNS, Class<T> returnType)
    {
        String extension = "createNode(\"" + intType + "\", \"" + strNodeName + "\", \"" + strNS + "\").";
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
     * Creates a new node that is an exact clone of this node. If an error occurs while
    cloning this XML entity, this method sets the error property of this entity and returns quietly.
     * @param bDeep if true, all descendants of this object will also be cloned and returned
     * @return newly cloned MSXML Node object wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity cloneNode(boolean bDeep)
    {
        String extension = "cloneNode(\"" + bDeep + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     * @param returnType The expected return type
     * @return newly cloned MSXML Node object wrapped in a jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public <T> T cloneNode(boolean bDeep, Class<T> returnType)
    {
        String extension = "cloneNode(\"" + bDeep + "\").";
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
     * Appends the objEntity parameter as a child of this entity. If an error occurs while
    appending to this XML entity, this method sets the error property of this entity and returns quietly.
     * @param objEntity jsx3.xml.Entity instance that will be bound as a child to this jsx3.xml.Entity instance
     * @return reference to self
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity appendChild(org.directwebremoting.proxy.jsx3.xml.Entity objEntity)
    {
        String extension = "appendChild(\"" + objEntity + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     * @param returnType The expected return type
     * @return reference to self
     */
    @SuppressWarnings("unchecked")
    public <T> T appendChild(org.directwebremoting.proxy.jsx3.xml.Entity objEntity, Class<T> returnType)
    {
        String extension = "appendChild(\"" + objEntity + "\").";
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
     * inserts the jsx3.xml.Entity instance, @objEntityNew immediately before the existing child @objEntityRef and returns a handle to @objEntityNew; requires that both parameters be of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if all conditions are not met
     * @param objEntityNew jsx3.xml.Entity object (the new one to add)
     * @param objEntityRef jsx3.xml.Entity object (the reference node in front of which to insert the new node)
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity insertBefore(org.directwebremoting.proxy.jsx3.xml.Entity objEntityNew, org.directwebremoting.proxy.jsx3.xml.Entity objEntityRef)
    {
        String extension = "insertBefore(\"" + objEntityNew + "\", \"" + objEntityRef + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T insertBefore(org.directwebremoting.proxy.jsx3.xml.Entity objEntityNew, org.directwebremoting.proxy.jsx3.xml.Entity objEntityRef, Class<T> returnType)
    {
        String extension = "insertBefore(\"" + objEntityNew + "\", \"" + objEntityRef + "\").";
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
     * replaces the child @objEntityOld with @objEntityNew and returns a handle to @objEntityOld; requires that both child entities be of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if all conditions are not met
     * @param objEntityNew jsx3.xml.Entity object (the new one to add)
     * @param objEntityOld jsx3.xml.Entity object (the old one to remove)
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity replaceNode(org.directwebremoting.proxy.jsx3.xml.Entity objEntityNew, org.directwebremoting.proxy.jsx3.xml.Entity objEntityOld)
    {
        String extension = "replaceNode(\"" + objEntityNew + "\", \"" + objEntityOld + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T replaceNode(org.directwebremoting.proxy.jsx3.xml.Entity objEntityNew, org.directwebremoting.proxy.jsx3.xml.Entity objEntityOld, Class<T> returnType)
    {
        String extension = "replaceNode(\"" + objEntityNew + "\", \"" + objEntityOld + "\").";
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
     * Sets the @strValue of the named @strAttribute and binds as child of this
     * @param strName name of the attribute
     * @param strValue value of the attribute, if null then remove the attribute
     * @return reference to this
     */
    public org.directwebremoting.proxy.jsx3.xml.Entity setAttribute(String strName, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setAttribute", strName, strValue);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns the value for the named attribute strName.
     * @param strName the name of the attribute.
     * @param callback the attribute value or <code>undefined</code> if the attribute does not exist.
     */
    @SuppressWarnings("unchecked")
    public void getAttribute(String strName, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAttribute", strName);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns an object reference (a jsx3.xml.Entity instance) to the child attribute with the name, @strName.
    This method should only be called on an instance of type TYPEELEMENT.
     * @param strName name of the attribute
     * @return jsx3.xml.Entity instance referencing a single attribute node object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getAttributeNode(String strName)
    {
        String extension = "getAttributeNode(\"" + strName + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance referencing a single attribute node object
     */
    @SuppressWarnings("unchecked")
    public <T> T getAttributeNode(String strName, Class<T> returnType)
    {
        String extension = "getAttributeNode(\"" + strName + "\").";
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
     * Sets the attribute object as a child of the element; if transferring an attribute from one element to another, this call must be preceded with removeAttributeNode on the previous owner
     * @param objAtt jsx3.xml.Entity instance of type jsx3.xml.Entity.TYPEATTRIBUTE;
     * @return reference to this
     */
    public org.directwebremoting.proxy.jsx3.xml.Entity setAttributeNode(org.directwebremoting.proxy.jsx3.xml.Entity objAtt)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setAttributeNode", objAtt);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns handle to a jsx3.util.List instance of all children; note that this collection will always be empty (length = 0) for all types except for jsx3.xml.Entity.TYPEELEMENT
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List getAttributes()
    {
        String extension = "getAttributes().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    /**
     * Returns the names of all the attributes of this node. Iterating over the attribute names is more performant than
    using the getAttributes() method.
     */
    @SuppressWarnings("unchecked")
    public void getAttributeNames(Callback<Object[]> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object[].class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getAttributeNames");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns reference to the document element (root) wrapped in jsx3.xml.Entity instance
     * @return jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getRootNode()
    {
        String extension = "getRootNode().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Returns reference to the document element (root) wrapped in jsx3.xml.Entity instance
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance
     */
    @SuppressWarnings("unchecked")
    public <T> T getRootNode(Class<T> returnType)
    {
        String extension = "getRootNode().";
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
     * Returns the parent node as a jsx3.xml.Entity instance; if this node is the root node of the document, null is returned
     * @return parent node or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getParent()
    {
        String extension = "getParent().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Returns the parent node as a jsx3.xml.Entity instance; if this node is the root node of the document, null is returned
     * @param returnType The expected return type
     * @return parent node or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getParent(Class<T> returnType)
    {
        String extension = "getParent().";
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
     * Returns an iterator that iterates over the child nodes of this node. Note that the iterator grants access to
    only one child node at a time; once next() is called, the value returned by the previous call to
    next() is no longer valid. This method is more performant than getChildNodes().
     * @param bIncludeText if <code>true</code> then the returned iterator will include the child text nodes
    of this node.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Iterator getChildIterator(boolean bIncludeText)
    {
        String extension = "getChildIterator(\"" + bIncludeText + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Iterator> ctor = org.directwebremoting.proxy.jsx3.util.Iterator.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List getChildNodes(boolean bIncludeText)
    {
        String extension = "getChildNodes(\"" + bIncludeText + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
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
        String extension = "removeChild(\"" + objChildEntity + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Removes the specified child (@objChildEntity) from the list of children and returns it; returns null if @objChildEntity is not actually a child
     * @param objChildEntity jsx3.xml.Entity object that is a direct child of this jsx3.xml.Entity instance
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T removeChild(org.directwebremoting.proxy.jsx3.xml.Entity objChildEntity, Class<T> returnType)
    {
        String extension = "removeChild(\"" + objChildEntity + "\").";
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
     * Removes all descendant entities of this node
     */
    public void removeChildren()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("removeChildren");
        getScriptProxy().addScript(script);
    }

    /**
     * Removes the specified attribute by the given name (can only be called for nodes of type jsx3.xml.Entity.TYPELEMENT)
     * @param strAttName the name of the attribute to remove
     */
    public void removeAttribute(String strAttName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("removeAttribute", strAttName);
        getScriptProxy().addScript(script);
    }

    /**
     * removes the attribute object as a child of the element;
     * @param objAtt jsx3.xml.Entity instance of type jsx3.xml.Entity.TYPEATTRIBUTE;
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity removeAttributeNode(org.directwebremoting.proxy.jsx3.xml.Entity objAtt)
    {
        String extension = "removeAttributeNode(\"" + objAtt + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * removes the attribute object as a child of the element;
     * @param objAtt jsx3.xml.Entity instance of type jsx3.xml.Entity.TYPEATTRIBUTE;
     * @param returnType The expected return type
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public <T> T removeAttributeNode(org.directwebremoting.proxy.jsx3.xml.Entity objAtt, Class<T> returnType)
    {
        String extension = "removeAttributeNode(\"" + objAtt + "\").";
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
     * Returns one of: jsx3.xml.Entity.TYPEELEMENT, jsx3.xml.Entity.TYPEATTRIBUTE, jsx3.xml.Entity.TYPETEXT, jsx3.xml.Entity.TYPECDATA
     */
    @SuppressWarnings("unchecked")
    public void getNodeType(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getNodeType");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the name of the node as string (assuming this jsx3.xml.Entity instance is of type jsx3.xml.Entity.TYPEELEMENT or jsx3.xml.Entity.TYPEATTRIBUTE). The other TYPES return "#cdata-section" and "#text" respectively
     */
    @SuppressWarnings("unchecked")
    public void getNodeName(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getNodeName");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the value (as string) for URI (universal resource identifier) of the namespace for the given node; returns an empty string if no namespace exists
     */
    @SuppressWarnings("unchecked")
    public void getNamespaceURI(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getNamespaceURI");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
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
        String extension = "selectSingleNode(\"" + strQuery + "\", \"" + strNS + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T selectSingleNode(String strQuery, String strNS, Class<T> returnType)
    {
        String extension = "selectSingleNode(\"" + strQuery + "\", \"" + strNS + "\").";
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
     * Returns a single node selected by an XPath query executed on this node, or null if none is selected.
     * @param strQuery an XPath query such as: <code>//somenode[@id='12']/somechild</code>.
     * @param strNS the selection namespace to use just for this query. This parameter is an optional
    shortcut for calling <code>setSelectionNamespaces()</code> on the owning document. The format of this parameter
    as a string is <code>"xmlns:ns1='uri1' xmlns:ns2='uri2'"</code> or as an object is <code>{'uri1':'ns1',
    'uri2':'ns2'}</code>.
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity selectSingleNode(String strQuery, Object strNS)
    {
        String extension = "selectSingleNode(\"" + strQuery + "\", \"" + strNS + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T selectSingleNode(String strQuery, Object strNS, Class<T> returnType)
    {
        String extension = "selectSingleNode(\"" + strQuery + "\", \"" + strNS + "\").";
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
     * Returns a list of nodes selected by an XPath query executed on this node.
     * @param strQuery an XPath query such as: <code>//somenode[@id='12']/somechild</code>.
     * @param strNS the selection namespace to use just for this query. This parameter is an optional
    shortcut for calling <code>setSelectionNamespaces()</code> on the owning document. The format of this parameter
    as a string is <code>"xmlns:ns1='uri1' xmlns:ns2='uri2'"</code> or as an object is <code>{'uri1':'ns1',
    'uri2':'ns2'}</code>.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List selectNodes(String strQuery, String strNS)
    {
        String extension = "selectNodes(\"" + strQuery + "\", \"" + strNS + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    /**
     * Returns a list of nodes selected by an XPath query executed on this node.
     * @param strQuery an XPath query such as: <code>//somenode[@id='12']/somechild</code>.
     * @param strNS the selection namespace to use just for this query. This parameter is an optional
    shortcut for calling <code>setSelectionNamespaces()</code> on the owning document. The format of this parameter
    as a string is <code>"xmlns:ns1='uri1' xmlns:ns2='uri2'"</code> or as an object is <code>{'uri1':'ns1',
    'uri2':'ns2'}</code>.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List selectNodes(String strQuery, Object strNS)
    {
        String extension = "selectNodes(\"" + strQuery + "\", \"" + strNS + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
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
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Iterator selectNodeIterator(String strQuery, String strNS)
    {
        String extension = "selectNodeIterator(\"" + strQuery + "\", \"" + strNS + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Iterator> ctor = org.directwebremoting.proxy.jsx3.util.Iterator.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Iterator.class.getName());
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
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Iterator selectNodeIterator(String strQuery, Object strNS)
    {
        String extension = "selectNodeIterator(\"" + strQuery + "\", \"" + strNS + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Iterator> ctor = org.directwebremoting.proxy.jsx3.util.Iterator.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Iterator.class.getName());
        }
    }

    /**
     * Returns the right-hand side of a namespace qualified name. For example, "Price" will be returned for the
    element <USD:Price>
     */
    @SuppressWarnings("unchecked")
    public void getBaseName(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getBaseName");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the left-hand side of a namespace qualified name. For example, "USD" will be returned for the
    element <USD:Price>
     */
    @SuppressWarnings("unchecked")
    public void getPrefix(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPrefix");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Contains the text content of the node, including the concatenated text contained by all descendant entities
     */
    @SuppressWarnings("unchecked")
    public void getValue(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getValue");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * sets the text value for this entity; returns a handle to this jsx3.xml.Entity instance
     * @param strValue value to set for this entity
     * @return self
     */
    public org.directwebremoting.proxy.jsx3.xml.Entity setValue(String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setValue", strValue);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Returns the native browser XML node wrapped by this entity.
     */
    @SuppressWarnings("unchecked")
    public void getNative(Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getNative");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the first child element of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if both conditions are not met
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getFirstChild()
    {
        String extension = "getFirstChild().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Returns the first child element of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if both conditions are not met
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChild(Class<T> returnType)
    {
        String extension = "getFirstChild().";
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
     * Returns the last child element of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if both conditions are not met
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getLastChild()
    {
        String extension = "getLastChild().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Returns the last child element of type jsx3.xml.Entity.TYPEELEMENT; requires that this object also be of TYPEELEMENT; returns null if both conditions are not met
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getLastChild(Class<T> returnType)
    {
        String extension = "getLastChild().";
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
     * Returns the previous sibling if this node and the referenced sibling are of type jsx3.xml.Entity.TYPEELEMENT; returns null if condition is not met
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getPreviousSibling()
    {
        String extension = "getPreviousSibling().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Returns the previous sibling if this node and the referenced sibling are of type jsx3.xml.Entity.TYPEELEMENT; returns null if condition is not met
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getPreviousSibling(Class<T> returnType)
    {
        String extension = "getPreviousSibling().";
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
     * Returns the next sibling if this node and the referenced sibling are of type jsx3.xml.Entity.TYPEELEMENT; returns null if condition is not met
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getNextSibling()
    {
        String extension = "getNextSibling().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Entity.class.getName());
        }
    }

    /**
     * Returns the next sibling if this node and the referenced sibling are of type jsx3.xml.Entity.TYPEELEMENT; returns null if condition is not met
     * @param returnType The expected return type
     * @return jsx3.xml.Entity instance or null
     */
    @SuppressWarnings("unchecked")
    public <T> T getNextSibling(Class<T> returnType)
    {
        String extension = "getNextSibling().";
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
     * performs an XSLT transformation, using @objEntityFilter as the XSLT filter for the transformation; returns
         results of the transformation as a string (of text/html/xml/etc)
     * @param objEntityFilter jsx3.xml.Entity instance containing the XSLT document to transform 'this' jsx3.xml.Entity instance with
     * @param objParams JavaScript object array of name/value pairs; if passed, the transformation will use a
         paramaterized stylesheet to perform the transformation
     * @param bObject if <code>true</code> this method returns a document instead of a string.
     * @param callback the result of the transformation
     */
    @SuppressWarnings("unchecked")
    public void transformNode(org.directwebremoting.proxy.jsx3.xml.Entity objEntityFilter, Object objParams, boolean bObject, Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = transformNode", objEntityFilter, objParams, bObject);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns an error object (a plain JavaScript object) with two properties that the developer can query for:

    code Ð an integer error code, 0 for no error.
    description Ð a text description of the error that occurred.
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

    /**
     * Returns the document that owns this entity.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getOwnerDocument()
    {
        String extension = "getOwnerDocument().";
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
     * Returns the document that owns this entity.
     * @param returnType The expected return type
     */
    @SuppressWarnings("unchecked")
    public <T> T getOwnerDocument(Class<T> returnType)
    {
        String extension = "getOwnerDocument().";
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

}
