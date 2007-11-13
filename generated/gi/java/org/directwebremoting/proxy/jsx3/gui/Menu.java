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
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Menu extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Menu(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }

    /**
     * The instance initializer.
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     * @param strText text for the menu (the persistent on-screen anchor that one would click to expand the menu); if the menu is only used as a context menu, this can be left null and the display property for the menu should be set to null
     */
    public Menu(String strName, String strText)
    {
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new Menu", strName, strText);
        setInitScript(script);
    }

    /**
     * background-image:url(JSX/images/menu/bg.gif);backround-repeat:repeat-y; (default)
     */
    public static final String DEFAULTBACKGROUND = "background-image:url(";

    /**
     * #ffffff (default)
     */
    public static final String DEFAULTBACKGROUNDCOLOR = "#ffffff";

    /**
     * 
     */
    public static final String DEFAULTXSLURL = null;

    /**
     * 
     */
    public static final int DEFAULTCONTEXTLEFTOFFSET = 10;

    /**
     * Returns url for 16x16 pixel image (preferably a gif with a transparent background); returns null if no image specified or an empty string
     * @param callback valid URL
     */
    @SuppressWarnings("unchecked")
    public void getImage(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getImage");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets url for 16x16 pixel image (preferably a gif with a transparent background);
         returns a reference to self to facilitate method chaining
     * @param strURL valid URL
     * @return this object
     */
    public org.directwebremoting.proxy.jsx3.gui.Menu setImage(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setImage", strURL);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * disables a menu item with the given id; this ID is the jsxid attribute on the record adhereing to the JSX Common Data Format (CDF);
     * @param strRecordId the jsxid property on the record node corresponding to the menu item to be disabled
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Menu disableItem(String strRecordId)
    {
        String extension = "disableItem(\"" + strRecordId + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Menu> ctor = org.directwebremoting.proxy.jsx3.gui.Menu.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Menu.class.getName());
        }
    }

    /**
     * enables a menu item with the given id by removing its 'jsxselected'; this ID is the jsxid attribute on the record adhereing to the JSX Common Data Format (CDF);
     * @param strRecordId the jsxid property on the record node corresponding to the menu item to be enabled
     * @param bEnabled if false then disable the item
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Menu enableItem(String strRecordId, boolean bEnabled)
    {
        String extension = "enableItem(\"" + strRecordId + "\", \"" + bEnabled + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Menu> ctor = org.directwebremoting.proxy.jsx3.gui.Menu.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Menu.class.getName());
        }
    }

    /**
     * Returns whether a record is enabled.
     * @param strRecordId the jsxid property on the record node to query
     */
    @SuppressWarnings("unchecked")
    public void isItemEnabled(String strRecordId, Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isItemEnabled", strRecordId);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * flags a a menu item as being selected; if the menu item is part of a group (e.g., when the record node has an attribute called 'jsxgroupname'), all other menu
           items belonging to that group will be deselected
     * @param strRecordId the jsxid property on the record node corresponding to the menu item to be selected
     * @param bSelected if false then deselect the item
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Menu selectItem(String strRecordId, boolean bSelected)
    {
        String extension = "selectItem(\"" + strRecordId + "\", \"" + bSelected + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Menu> ctor = org.directwebremoting.proxy.jsx3.gui.Menu.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Menu.class.getName());
        }
    }

    /**
     * flags a a menu item as being unselected (the default state)
     * @param strRecordId the jsxid property on the record node corresponding to the menu item to be deselected
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Menu deselectItem(String strRecordId)
    {
        String extension = "deselectItem(\"" + strRecordId + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Menu> ctor = org.directwebremoting.proxy.jsx3.gui.Menu.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Menu.class.getName());
        }
    }

    /**
     * Returns whether a record is selected.
     * @param strRecordId the jsxid property on the record node to query.
     */
    @SuppressWarnings("unchecked")
    public void isItemSelected(String strRecordId, Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isItemSelected", strRecordId);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the JSX GUI object that owns (contains) the context item (a CDF record) being acted upon.  For example, when a context menu is shown by right-clicking on a list tree, a ref to the tree/list is persisted as this value.
     */
    public void getContextParent()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("getContextParent");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the CDF record ID for the context item being acted upon.  For example, when a context menu is shown by right-clicking on a row in a list or a node in a tree, the CDF record ID corresponding to the clicked item is persisted as this value.
     */
    public void getContextRecordId()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("getContextRecordId");
        getScriptProxy().addScript(script);
    }

    /**
     * Executes the specific jsxexecute code for the menu record. This method also fires
    EXECUTE event for this menu but only under the deprecated 3.0 model event protocol.
     * @param strRecordId id for the record whose code will be fire/execute
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Menu executeRecord(String strRecordId)
    {
        String extension = "executeRecord(\"" + strRecordId + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Menu> ctor = org.directwebremoting.proxy.jsx3.gui.Menu.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Menu.class.getName());
        }
    }

    /**
     * resets the cached DHTML content; hides any open menu; when the menu is next expanded (repainted), the update will be relected
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Menu redrawRecord()
    {
        String extension = "redrawRecord().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Menu> ctor = org.directwebremoting.proxy.jsx3.gui.Menu.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Menu.class.getName());
        }
    }

    /**
     * Returns the jsxid value in the CDF for the menu item last executed; returns null if unavailable
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
     * Sets the validation state for the menu and returns the validation state.
     * @param callback jsx3.gui.Form.STATEVALID
     */
    @SuppressWarnings("unchecked")
    public void doValidate(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = doValidate");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether this menu renders a visual divider on its left side.
     * @param callback <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>.
     */
    @SuppressWarnings("unchecked")
    public void getDivider(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDivider");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets whether this menu renders a visual divider on its left side. The divider is useful for
    visually separating this menu from the next menu to the left.
     * @param intDivider <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>.
     * @param bRecalc 
     * @return this objectt.
     */
    public org.directwebremoting.proxy.jsx3.gui.Menu setDivider(int intDivider, boolean bRecalc)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setDivider", intDivider, bRecalc);
        getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Resets the XML source document stored in the server cache under the XML ID of this object to an empty CDF
    document.
     */
    public void clearXmlData()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("clearXmlData");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether this object removes its XML and XSL source documents from the cache of its server when it
    is destroyed.
     * @param callback <code>CLEANUPRESOURCES</code> or <code>SHARERESOURCES</code>.
     */
    @SuppressWarnings("unchecked")
    public void getShareResources(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getShareResources");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
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
    public org.directwebremoting.proxy.jsx3.xml.Document getXML()
    {
        String extension = "getXML().";
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
     * @param returnType The expected return type
     */
    @SuppressWarnings("unchecked")
    public <T> T getXML(Class<T> returnType)
    {
        String extension = "getXML().";
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
     * Returns the XML ID of this object.
     * @param callback the XML ID.
     */
    @SuppressWarnings("unchecked")
    public void getXMLId(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXMLId");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the XML string of this object.
     */
    @SuppressWarnings("unchecked")
    public void getXMLString(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXMLString");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the list of XML transformers of this object.
     */
    @SuppressWarnings("unchecked")
    public void getXMLTransformers(Callback<Object[]> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object[].class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXMLTransformers");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the XML URL of this object.
     */
    @SuppressWarnings("unchecked")
    public void getXMLURL(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXMLURL");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

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
        String extension = "getXSL().";
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
        String extension = "getXSL().";
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
     * Returns the XSL ID of this object.
     */
    @SuppressWarnings("unchecked")
    public void getXSLId(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXSLId");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns a map containing all the parameters to pass to the XSL stylesheet during transformation.
     */
    @SuppressWarnings("unchecked")
    public void getXSLParams(Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXSLParams");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether the XML data source of this object is loaded asynchronously.
     * @param callback <code>0</code> or <code>1</code>.
     */
    @SuppressWarnings("unchecked")
    public void getXmlAsync(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXmlAsync");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether this object is bound to the XML document stored in the data cache.
     * @param callback <code>0</code> or <code>1</code>.
     */
    @SuppressWarnings("unchecked")
    public void getXmlBind(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getXmlBind");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

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
        script.appendCall("onXmlBinding", objEvent);
        getScriptProxy().addScript(script);
    }

    /**
     * Removes a parameter from the list of parameters to pass to the XSL stylesheet during transformation.
     * @param strName the name of the XSL parameter to remove.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable removeXSLParam(String strName)
    {
        String extension = "removeXSLParam(\"" + strName + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "removeXSLParams().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        script.appendCall("resetCacheData", objServer);
        getScriptProxy().addScript(script);
    }

    /**
     * Removes the XML source document stored under the XML ID of this object from the server cache.
     * @param objServer the server owning the cache to modify. This is a required argument only if
    <code>this.getServer()</code> does not returns a server instance.
     */
    public void resetXmlCacheData(org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("resetXmlCacheData", objServer);
        getScriptProxy().addScript(script);
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
        String extension = "setShareResources(\"" + intShare + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "setSourceXML(\"" + objDoc + "\", \"" + objCache + "\").";
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
        String extension = "setSourceXML(\"" + objDoc + "\", \"" + objCache + "\").";
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
     * Sets the XML ID of this object. This value is the key under which the XML source document of this object is
    saved in the cache of the server owning this object. The developer may specify either a unique or shared value.
    If no value is specified, a unique id is generated.
     * @param strXMLId 
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXMLId(String strXMLId)
    {
        String extension = "setXMLId(\"" + strXMLId + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "setXMLString(\"" + strXML + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        script.appendCall("setXMLTransformers", arrTrans);
        getScriptProxy().addScript(script);
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
        String extension = "setXMLURL(\"" + strXMLURL + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "setXSLParam(\"" + strName + "\", \"" + strValue + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
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
        String extension = "setXmlAsync(\"" + bAsync + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /**
     * Sets whether this object is bound to the XML document stored in the data cache. If this object is bound to the
    cache, then the onXmlBinding() method of this object is called any time the document stored in
    the cache under the XML Id of this object changes.
     * @param bBind need to run jsx build
     * @param callback <code>0</code> or <code>1</code>.
     */
    @SuppressWarnings("unchecked")
    public void setXmlBind(boolean bBind, Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = setXmlBind", bBind);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Transfers a CDF record from another object to this object. If no XML data source exists
    yet for this object, an empty one is created before adding the new record. This method always updates the
    on-screen view of both the source and destination objects.

    This method fails quietly if any of the following conditions apply:

    there is no object with id equal to strSourceId
        
    there is no record in the source object with jsxid equal to strRecordId
        

          strParentRecordId is specified and there is no record in this object with
    jsxid equal to strParentRecordId
        
    the this object already has a record with jsxid equal to the record to adopt
     * @param strSourceId <span style="text-decoration: line-through;">either the id of the source object or the</span> source object itself.
     * @param strRecordId the <code>jsxid</code> attribute of the data record in the source object to transfer.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided, the adopted record will be added as a child of this record. Otherwise, the adopted record will
    be added to the root <code>data</code> element.
     * @param bRedraw forces suppression of the insert event
     * @return the adopted record.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity adoptRecord(String strSourceId, String strRecordId, String strParentRecordId, boolean bRedraw)
    {
        String extension = "adoptRecord(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").";
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
     * Transfers a CDF record from another object to this object. If no XML data source exists
    yet for this object, an empty one is created before adding the new record. This method always updates the
    on-screen view of both the source and destination objects.

    This method fails quietly if any of the following conditions apply:

    there is no object with id equal to strSourceId
        
    there is no record in the source object with jsxid equal to strRecordId
        

          strParentRecordId is specified and there is no record in this object with
    jsxid equal to strParentRecordId
        
    the this object already has a record with jsxid equal to the record to adopt
     * @param strSourceId <span style="text-decoration: line-through;">either the id of the source object or the</span> source object itself.
     * @param strRecordId the <code>jsxid</code> attribute of the data record in the source object to transfer.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided, the adopted record will be added as a child of this record. Otherwise, the adopted record will
    be added to the root <code>data</code> element.
     * @param bRedraw forces suppression of the insert event
     * @param returnType The expected return type
     * @return the adopted record.
     */
    @SuppressWarnings("unchecked")
    public <T> T adoptRecord(String strSourceId, String strRecordId, String strParentRecordId, boolean bRedraw, Class<T> returnType)
    {
        String extension = "adoptRecord(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").";
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
     * Equivalent to adoptRecord, except that the to-be relationship is as a previousSibling to the CDF record identified by the parameter, strSiblingRecordId

    This method fails quietly if any of the following conditions apply:

    there is no record with a jsxid equal to strSourceId
        
    there is no record in the source object with a jsxid equal to strRecordId
        

          strSiblingRecordId is specified and there is no record in this object with a
    jsxid equal to strParentRecordId
        
    this object already has a record with jsxid equal to the record to adopt
     * @param strSourceId <span style="text-decoration: line-through;">either the id of the source object or the</span> source object itself.
     * @param strRecordId the <code>jsxid</code> attribute of the data record in the source object to transfer.
     * @param strSiblingRecordId the unique <code>jsxid</code> of an existing record in front of
    which the record identified by strSourceId will be placed
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted record.
     * @return the adopted record.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity adoptRecordBefore(String strSourceId, String strRecordId, String strSiblingRecordId, boolean bRedraw)
    {
        String extension = "adoptRecordBefore(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").";
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
     * Equivalent to adoptRecord, except that the to-be relationship is as a previousSibling to the CDF record identified by the parameter, strSiblingRecordId

    This method fails quietly if any of the following conditions apply:

    there is no record with a jsxid equal to strSourceId
        
    there is no record in the source object with a jsxid equal to strRecordId
        

          strSiblingRecordId is specified and there is no record in this object with a
    jsxid equal to strParentRecordId
        
    this object already has a record with jsxid equal to the record to adopt
     * @param strSourceId <span style="text-decoration: line-through;">either the id of the source object or the</span> source object itself.
     * @param strRecordId the <code>jsxid</code> attribute of the data record in the source object to transfer.
     * @param strSiblingRecordId the unique <code>jsxid</code> of an existing record in front of
    which the record identified by strSourceId will be placed
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted record.
     * @param returnType The expected return type
     * @return the adopted record.
     */
    @SuppressWarnings("unchecked")
    public <T> T adoptRecordBefore(String strSourceId, String strRecordId, String strSiblingRecordId, boolean bRedraw, Class<T> returnType)
    {
        String extension = "adoptRecordBefore(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").";
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
     * Converts all attributes in this CDF document that are property keys of the form {key} to
    the value of the property.
     * @param objProps the properties repository to query.
     * @param arrProps if provided, these attributes are converted rather than the default set of
    attributes.
     * @param bUnion if <code>true</code>, <code>arrProps</code> is combined with the default set of
    attributes and those attributes are converted.
     */
    public void convertProperties(java.util.Properties objProps, Object[] arrProps, boolean bUnion)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("convertProperties", objProps, arrProps, bUnion);
        getScriptProxy().addScript(script);
    }

    /**
     * Removes a record from the XML data source of this object.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to remove.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted record.
     * @return the record removed from the data source or <code>null</code> if no such record found.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity deleteRecord(String strRecordId, boolean bRedraw)
    {
        String extension = "deleteRecord(\"" + strRecordId + "\", \"" + bRedraw + "\").";
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
     * Removes a record from the XML data source of this object.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to remove.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted record.
     * @param returnType The expected return type
     * @return the record removed from the data source or <code>null</code> if no such record found.
     */
    @SuppressWarnings("unchecked")
    public <T> T deleteRecord(String strRecordId, boolean bRedraw, Class<T> returnType)
    {
        String extension = "deleteRecord(\"" + strRecordId + "\", \"" + bRedraw + "\").";
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
     * Removes a specific property from a record. If no such record exists in the XML document, this method fails quietly.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to modify.
     * @param strPropName the name of the property to remove from the record.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the deleted property.
     */
    public void deleteRecordProperty(String strRecordId, String strPropName, boolean bRedraw)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("deleteRecordProperty", strRecordId, strPropName, bRedraw);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns an object containing the attributes of a particular CDF record as property/value pairs. The object returned by this
    method is a copy of the underlying data. Therefore, updates to this object will not affect the underlying data.

    The following two lines of code evaluate to the same value:

    objCDF.getRecord(strId).propName;
    objCDF.getRecordNode(strId).getAttribute("propName");
     * @param strRecordId the <code>jsxid</code> attribute of the data record to return.
     * @param callback the object representation of a CDF node or <code>null</code> if no such record found.
     */
    @SuppressWarnings("unchecked")
    public void getRecord(String strRecordId, Callback<Object> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getRecord", strRecordId);
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns a record from the XML data source of this object. This returned value is a handle to the record and
    not a clone. Therefore, any updates made to the returned value with update the XML document of this object.
    To reflect such changes in the on-screen view of this object, call
    redrawRecord(strRecordId, jsx3.xml.CDF.UPDATE); on this object.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to return.
     * @return the record node or <code>null</code> if none exists with a <code>jsxid</code>
    attribute equal to <code>strRecordId</code>.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity getRecordNode(String strRecordId)
    {
        String extension = "getRecordNode(\"" + strRecordId + "\").";
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
     * Returns a record from the XML data source of this object. This returned value is a handle to the record and
    not a clone. Therefore, any updates made to the returned value with update the XML document of this object.
    To reflect such changes in the on-screen view of this object, call
    redrawRecord(strRecordId, jsx3.xml.CDF.UPDATE); on this object.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to return.
     * @param returnType The expected return type
     * @return the record node or <code>null</code> if none exists with a <code>jsxid</code>
    attribute equal to <code>strRecordId</code>.
     */
    @SuppressWarnings("unchecked")
    public <T> T getRecordNode(String strRecordId, Class<T> returnType)
    {
        String extension = "getRecordNode(\"" + strRecordId + "\").";
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
     * Inserts a new record into the XML data source of this object. If no XML data source exists
    yet for this object, an empty one is created before adding the new record.
    If a record already exists with an id equal to the jsxid property of objRecord,
    the operation is treated as an update, meaning the existing record is completely removed and a new record with
    the given jsxid is inserted.
     * @param objRecord a JavaScript object containing property/value pairs that define the
    attributes of the XML entity to create. Note that most classes that implement this interface require that all
    records have an attribute named <code>jsxid</code> that is unique across all records in the XML document.
    All property values will be treated as strings. Additionally, the following 3 characters are escaped:
    <code>" &gt; &lt;</code>.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided and a record exists with a matching <code>jsxid</code> attribute, the new record will be added as a child of
    this record. Otherwise, the new record will be added to the root <code>data</code> element. However, if a
    record already exists with a <code>jsxid</code> attribute equal to the <code>jsxid</code> property of
    <code>objRecord</code>, this parameter will be ignored. In this case <code>adoptRecord()</code> must be called
    to change the parent of the record.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     * @return the newly created or updated entity.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity insertRecord(Object objRecord, String strParentRecordId, boolean bRedraw)
    {
        String extension = "insertRecord(\"" + objRecord + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").";
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
     * Inserts a new record into the XML data source of this object. If no XML data source exists
    yet for this object, an empty one is created before adding the new record.
    If a record already exists with an id equal to the jsxid property of objRecord,
    the operation is treated as an update, meaning the existing record is completely removed and a new record with
    the given jsxid is inserted.
     * @param objRecord a JavaScript object containing property/value pairs that define the
    attributes of the XML entity to create. Note that most classes that implement this interface require that all
    records have an attribute named <code>jsxid</code> that is unique across all records in the XML document.
    All property values will be treated as strings. Additionally, the following 3 characters are escaped:
    <code>" &gt; &lt;</code>.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided and a record exists with a matching <code>jsxid</code> attribute, the new record will be added as a child of
    this record. Otherwise, the new record will be added to the root <code>data</code> element. However, if a
    record already exists with a <code>jsxid</code> attribute equal to the <code>jsxid</code> property of
    <code>objRecord</code>, this parameter will be ignored. In this case <code>adoptRecord()</code> must be called
    to change the parent of the record.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     * @param returnType The expected return type
     * @return the newly created or updated entity.
     */
    @SuppressWarnings("unchecked")
    public <T> T insertRecord(Object objRecord, String strParentRecordId, boolean bRedraw, Class<T> returnType)
    {
        String extension = "insertRecord(\"" + objRecord + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").";
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
     * Creates a new CDF record and inserts it into the CDF data source of this object, before the record identified by strSiblingRecordId.

    This method fails quietly if any of the following conditions apply:

    there is no existing record with a jsxid equal to strSiblingRecordId
        
    there is an existing record with jsxid equal to objRecord.jsxid
     * @param objRecord a JavaScript object containing property/value pairs that define the
    attributes of the XML entity to create. Note that most classes that implement this interface require that all
    records have an attribute named <code>jsxid</code> that is unique across all records in the XML document.
    All property values will be treated as strings. Additionally, the following 3 characters are escaped:
    <code>" &gt; &lt;</code>.
     * @param strSiblingRecordId the unique <code>jsxid</code> of an existing record before which the new record will be inserted.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     * @return the newly created entity.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Entity insertRecordBefore(Object objRecord, String strSiblingRecordId, boolean bRedraw)
    {
        String extension = "insertRecordBefore(\"" + objRecord + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").";
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
     * Creates a new CDF record and inserts it into the CDF data source of this object, before the record identified by strSiblingRecordId.

    This method fails quietly if any of the following conditions apply:

    there is no existing record with a jsxid equal to strSiblingRecordId
        
    there is an existing record with jsxid equal to objRecord.jsxid
     * @param objRecord a JavaScript object containing property/value pairs that define the
    attributes of the XML entity to create. Note that most classes that implement this interface require that all
    records have an attribute named <code>jsxid</code> that is unique across all records in the XML document.
    All property values will be treated as strings. Additionally, the following 3 characters are escaped:
    <code>" &gt; &lt;</code>.
     * @param strSiblingRecordId the unique <code>jsxid</code> of an existing record before which the new record will be inserted.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     * @param returnType The expected return type
     * @return the newly created entity.
     */
    @SuppressWarnings("unchecked")
    public <T> T insertRecordBefore(Object objRecord, String strSiblingRecordId, boolean bRedraw, Class<T> returnType)
    {
        String extension = "insertRecordBefore(\"" + objRecord + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").";
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
     * Inserts a new record into the XML data source of this object. This method is the same as
    insertRecord() except that its first parameter is of type jsx3.xml.Entity rather than
    Object.
     * @param objRecordNode an XML element of name <code>record</code>. Note that most classes that
    implement this interface require that all records have an attribute named <code>jsxid</code> that is unique
    across all records in the XML document.
     * @param strParentRecordId the unique <code>jsxid</code> of an existing record. If this optional parameter
    is provided and a record exists with a matching <code>jsxid</code> attribute, the new record will be added as a child of
    this record. Otherwise, the new record will be added to the root <code>data</code> element.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the additional record.
     */
    public void insertRecordNode(org.directwebremoting.proxy.jsx3.xml.Entity objRecordNode, String strParentRecordId, boolean bRedraw)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("insertRecordNode", objRecordNode, strParentRecordId, bRedraw);
        getScriptProxy().addScript(script);
    }

    /**
     * Inserts a new property into an existing record with jsxid equal to strRecordId.
    If the property already exists, the existing property value will be updated. If no such record exists
    in the XML document, this method fails quietly.
     * @param strRecordId the <code>jsxid</code> attribute of the data record to modify.
     * @param strPropName the name of the property to insert into the record.
     * @param strPropValue the value of the property to insert.
     * @param bRedraw if <code>true</code> or <code>null</code>, the on-screen view of this object is
    immediately updated to reflect the inserted property.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.CDF insertRecordProperty(String strRecordId, String strPropName, String strPropValue, boolean bRedraw)
    {
        String extension = "insertRecordProperty(\"" + strRecordId + "\", \"" + strPropName + "\", \"" + strPropValue + "\", \"" + bRedraw + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.CDF> ctor = org.directwebremoting.proxy.jsx3.xml.CDF.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.CDF.class.getName());
        }
    }

    /**
     * Binds the given key sequence to a callback function. Any object that has a key binding (specified with
    setKeyBinding()) will call this method when painted to register the key sequence with an appropriate
    ancestor of this form control. Any key down event that bubbles up to the ancestor without being intercepted
    and matches the given key sequence will invoke the given callback function.

    As of 3.2: The hot key will be registered with the first ancestor found that is either a
    jsx3.gui.Window, a jsx3.gui.Dialog, or the root block of a jsx3.app.Server.
     * @param fctCallback JavaScript function to execute when the given sequence is keyed by the user.
     * @param strKeys a plus-delimited ('+') key sequence such as <code>ctrl+s</code> or
    <code>ctrl+shift+alt+h</code> or <code>shift+a</code>, etc. Any combination of shift, ctrl, and alt are
    supported, including none. Also supported as the final token are <code>enter</code>, <code>esc</code>,
    <code>tab</code>, <code>del</code>, and <code>space</code>. To specify the final token as a key code, the
    last token can be the key code contained in brackets, <code>[13]</code>.
     * @return the registered hot key.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.HotKey doKeyBinding(org.directwebremoting.proxy.CodeBlock fctCallback, String strKeys)
    {
        String extension = "doKeyBinding(\"" + fctCallback + "\", \"" + strKeys + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.HotKey> ctor = org.directwebremoting.proxy.jsx3.gui.HotKey.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.HotKey.class.getName());
        }
    }

    /**
     * Resets the validation state of this control.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form doReset()
    {
        String extension = "doReset().";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Returns the background color of this control when it is disabled.
     * @param callback valid CSS property value, (i.e., red, #ff0000)
     */
    @SuppressWarnings("unchecked")
    public void getDisabledBackgroundColor(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDisabledBackgroundColor");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the font color to use when this control is disabled.
     * @param callback valid CSS property value, (i.e., red, #ff0000)
     */
    @SuppressWarnings("unchecked")
    public void getDisabledColor(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDisabledColor");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the state for the form field control. If no enabled state is set, this method returns
    STATEENABLED.
     * @param callback <code>STATEDISABLED</code> or <code>STATEENABLED</code>.
     */
    @SuppressWarnings("unchecked")
    public void getEnabled(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getEnabled");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the key binding that when keyed will fire the execute event for this control.
     * @param callback plus-delimited (e.g.,'+') key sequence such as ctrl+s or ctrl+shift+alt+h or shift+a, etc
     */
    @SuppressWarnings("unchecked")
    public void getKeyBinding(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getKeyBinding");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns whether or not this control is required. If the required property has never been set, this method returns
    OPTIONAL.
     * @param callback <code>REQUIRED</code> or <code>OPTIONAL</code>.
     */
    @SuppressWarnings("unchecked")
    public void getRequired(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getRequired");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the validation state of this control. If the validationState property has never been set, this method returns
    STATEVALID.
     * @param callback <code>STATEINVALID</code> or <code>STATEVALID</code>.
     */
    @SuppressWarnings("unchecked")
    public void getValidationState(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getValidationState");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the background color of this form control when it is disabled.
     * @param strColor valid CSS property value, (i.e., red, #ff0000)
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setDisabledBackgroundColor(String strColor)
    {
        String extension = "setDisabledBackgroundColor(\"" + strColor + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets the font color to use when this control is disabled.
     * @param strColor valid CSS property value, (i.e., red, #ff0000)
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setDisabledColor(String strColor)
    {
        String extension = "setDisabledColor(\"" + strColor + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets whether this control is enabled. Disabled controls do not respond to user interaction.
     * @param intEnabled <code>STATEDISABLED</code> or <code>STATEENABLED</code>. <code>null</code> is
    equivalent to <code>STATEENABLED</code>.
     * @param bRepaint if <code>true</code> this control is immediately repainted to reflect the new setting.
     */
    public void setEnabled(int intEnabled, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setEnabled", intEnabled, bRepaint);
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the key binding that when keyed will fire the bound execute (jsx3.gui.Interactive.EXECUTE)
    event for this control.
     * @param strSequence plus-delimited (e.g.,'+') key sequence such as ctrl+s or ctrl+shift+alt+h or shift+a, etc
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setKeyBinding(String strSequence)
    {
        String extension = "setKeyBinding(\"" + strSequence + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets whether or not this control is required.
     * @param required {int} <code>REQUIRED</code> or <code>OPTIONAL</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setRequired(int required)
    {
        String extension = "setRequired(\"" + required + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets the validation state of this control. The validation state of a control is not serialized.
     * @param intState <code>STATEINVALID</code> or <code>STATEVALID</code>.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setValidationState(int intState)
    {
        String extension = "setValidationState(\"" + intState + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Sets the value of this control.
     * @param vntValue string/int value for the component
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setValue(int vntValue)
    {
        String extension = "setValue(\"" + vntValue + "\").";
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(Context.class, String.class, ScriptProxy.class);
            return ctor.newInstance(this, extension, getScriptProxy());
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

}
