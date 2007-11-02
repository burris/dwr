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

package org.directwebremoting.proxy.jsx3.app;

import java.lang.reflect.Constructor;
import java.util.Date;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Server extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Server(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * Sets environment variables used by this class (the controller for the JSX architecture)
     * @param strAppPath URL (either relative or absolute) for the application to load
     * @param objGUI the browser element (body, div, span, td, etc) into which the GI application should load
     * @param bPaint false if null; if true, the application VIEW will immediately be generated.
     * @param objEnv 
     */
    public Server(String strAppPath, String objGUI, boolean bPaint, Object objEnv)
    {
        super((ProxyHelper) null);
    }

    /**
     * The subject of an event that jsx3.app.Server publishes when an instance of this class
    is created. The target of the event object is the initialized server.
     */
    public static final String INITED = "inited";

    /**
     * The subject of an event that instances of this class publish when a context help hot key is pressed
    in the context of a DOM node that has a help ID. The event has the following fields:
    
     
          target - the server publishing the event.
     
          model - the DOM node that received the key event.
     
          helpid - the help ID of the nearest ancestor of model that defines a help ID.
     */
    public static final String HELP = "help";

    /*
     * Returns the value of an environment setting of this server. Valid keys correspond to deployment options and are
    (case-insensitive):

    VERSION
    APPPATH
    ABSPATH
    CAPTION
    MODE
    SYSTEM
    NAMESPACE
    CANCELERROR
    CANCELRIGHTCLICK
    BODYHOTKEYS
    WIDTH
    HEIGHT
    LEFT
    TOP
    POSITION
    OVERFLOW
    UNICODE
    EVENTSVERS
     * @param strEnvKey the key of the environment value to return
     *
    @SuppressWarnings("unchecked")
    public String getEnv(String strEnvKey, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the settings of this server/project per config.xml
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Settings getSettings()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getSettings().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Settings> ctor = org.directwebremoting.proxy.jsx3.app.Settings.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Settings.class.getName());
        }
    }

    /**
     * Returns handle to a descendant taskbar belonging to this server instance (this is where JSXDialog instances will try to minimize to if it exists); returns null if none found;
           if no taskbar is found, dialogs are not minimized, but are 'window shaded'Ñlike a Mac used to do
     * @param objJSX if null, this.JSXROOT is assumed; otherwise the object in the DOM from which to start looking for a descendant taskbar (a jsx3.gui.WindowBar instance)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.WindowBar getTaskBar(org.directwebremoting.proxy.jsx3.app.Model objJSX)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getTaskBar(\"" + objJSX + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.WindowBar> ctor = org.directwebremoting.proxy.jsx3.gui.WindowBar.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.WindowBar.class.getName());
        }
    }

    /**
     * call to shut down a server instance and free up resources used by the server (cache,dom,etc)
     */
    public void destroy()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("destroy(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Paints this application and its default component into the application view port on the host HTML page. The
    system class loader calls this method once all the required resources of the application have loaded. The
    order of actions taken by this method is:

    Load the default component file
    Execute the onload script for the application
    Paint the default component in the view port
     * @param objXML the pre-loaded default component document.
     */
    public void paint(org.directwebremoting.proxy.jsx3.xml.Document objXML)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("paint(").appendData(objXML).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * set all four dimensions for a jsx3.Server instance, allowing the developer to adjust the width/height/left/width for the server. Must be called during/after the onload event for the server instance as it affects the VIEW for the server.  Updates the absolutely positioned element that contains JSXROOT.
     * @param left the new left value or a JavaScript array containing all four new values (in pixels)
     * @param top the new top value (in pixels)
     * @param width the new width value (in pixels)
     * @param height the new height value (in pixels)
     */
    public void setDimensions(int left, int top, int width, int height)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * set all four dimensions for a jsx3.Server instance, allowing the developer to adjust the width/height/left/width for the server. Must be called during/after the onload event for the server instance as it affects the VIEW for the server.  Updates the absolutely positioned element that contains JSXROOT.
     * @param left the new left value or a JavaScript array containing all four new values (in pixels)
     * @param top the new top value (in pixels)
     * @param width the new width value (in pixels)
     * @param height the new height value (in pixels)
     */
    public void setDimensions(Object[] left, int top, int width, int height)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDimensions(").appendData(left).appendScript(",")

        .appendData(top).appendScript(",")

        .appendData(width).appendScript(",")

        .appendData(height).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Loads an external resource into this server instance. What this method does depends on the strType
    parameter.

    
          script - Loads a JavaScript file asynchronously into the memory space of the page hosting this
      application; returns null.
    
          css - Loads a CSS file asynchronously into the memory space of the page hosting this
      application; returns null.
    
          xml or xsl - Loads an XML file synchronously into the XML cache of this
      application; returns the loaded jsx3.xml.Document instance.
    
          jss or ljss - Loads a dynamic properties file or localized properties bundle
      synchronously into this application; returns null.
    
          services - Loads and parses a mapping rules file synchronously; returns a new instance of
      jsx3.net.Service.
     * @param strSrc the path to the resource.
     * @param strId the unique identifier of the resource. A resource loaded by this method may clobber
    a previously loaded resource of the same type and id.
     * @param strType the type of include, one of: <code>css</code>, <code>jss</code>, <code>xml</code>,
    <code>xsl</code>, <code>script</code> (for JavaScript), <code>services</code> (for mapping rules),
    or <code>ljss</code>.
     * @param bReload if <code>true</code>, a JavaScript or CSS file is reloaded from the remote server
    without checking the local browser cache. Other types of resources are not affected by this parameter.
     * @return the return type depends on the <code>strType</code>
    parameter. See the method description.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document loadInclude(String strSrc, String strId, String strType, String bReload)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadInclude(\"" + strSrc + "\", \"" + strId + "\", \"" + strType + "\", \"" + bReload + "\").");
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
     * Loads an external resource into this server instance. What this method does depends on the strType
    parameter.

    
          script - Loads a JavaScript file asynchronously into the memory space of the page hosting this
      application; returns null.
    
          css - Loads a CSS file asynchronously into the memory space of the page hosting this
      application; returns null.
    
          xml or xsl - Loads an XML file synchronously into the XML cache of this
      application; returns the loaded jsx3.xml.Document instance.
    
          jss or ljss - Loads a dynamic properties file or localized properties bundle
      synchronously into this application; returns null.
    
          services - Loads and parses a mapping rules file synchronously; returns a new instance of
      jsx3.net.Service.
     * @param strSrc the path to the resource.
     * @param strId the unique identifier of the resource. A resource loaded by this method may clobber
    a previously loaded resource of the same type and id.
     * @param strType the type of include, one of: <code>css</code>, <code>jss</code>, <code>xml</code>,
    <code>xsl</code>, <code>script</code> (for JavaScript), <code>services</code> (for mapping rules),
    or <code>ljss</code>.
     * @param bReload if <code>true</code>, a JavaScript or CSS file is reloaded from the remote server
    without checking the local browser cache. Other types of resources are not affected by this parameter.
     * @param returnType The expected return type
     * @return the return type depends on the <code>strType</code>
    parameter. See the method description.
     */
    @SuppressWarnings("unchecked")
    public <T> T loadInclude(String strSrc, String strId, String strType, String bReload, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadInclude(\"" + strSrc + "\", \"" + strId + "\", \"" + strType + "\", \"" + bReload + "\").");
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
     * Loads an external resource into this server instance. What this method does depends on the strType
    parameter.

    
          script - Loads a JavaScript file asynchronously into the memory space of the page hosting this
      application; returns null.
    
          css - Loads a CSS file asynchronously into the memory space of the page hosting this
      application; returns null.
    
          xml or xsl - Loads an XML file synchronously into the XML cache of this
      application; returns the loaded jsx3.xml.Document instance.
    
          jss or ljss - Loads a dynamic properties file or localized properties bundle
      synchronously into this application; returns null.
    
          services - Loads and parses a mapping rules file synchronously; returns a new instance of
      jsx3.net.Service.
     * @param strSrc the path to the resource.
     * @param strId the unique identifier of the resource. A resource loaded by this method may clobber
    a previously loaded resource of the same type and id.
     * @param strType the type of include, one of: <code>css</code>, <code>jss</code>, <code>xml</code>,
    <code>xsl</code>, <code>script</code> (for JavaScript), <code>services</code> (for mapping rules),
    or <code>ljss</code>.
     * @param bReload if <code>true</code>, a JavaScript or CSS file is reloaded from the remote server
    without checking the local browser cache. Other types of resources are not affected by this parameter.
     * @return the return type depends on the <code>strType</code>
    parameter. See the method description.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document loadInclude(org.directwebremoting.proxy.jsx3.net.URI strSrc, String strId, String strType, String bReload)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadInclude(\"" + strSrc + "\", \"" + strId + "\", \"" + strType + "\", \"" + bReload + "\").");
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
     * Loads an external resource into this server instance. What this method does depends on the strType
    parameter.

    
          script - Loads a JavaScript file asynchronously into the memory space of the page hosting this
      application; returns null.
    
          css - Loads a CSS file asynchronously into the memory space of the page hosting this
      application; returns null.
    
          xml or xsl - Loads an XML file synchronously into the XML cache of this
      application; returns the loaded jsx3.xml.Document instance.
    
          jss or ljss - Loads a dynamic properties file or localized properties bundle
      synchronously into this application; returns null.
    
          services - Loads and parses a mapping rules file synchronously; returns a new instance of
      jsx3.net.Service.
     * @param strSrc the path to the resource.
     * @param strId the unique identifier of the resource. A resource loaded by this method may clobber
    a previously loaded resource of the same type and id.
     * @param strType the type of include, one of: <code>css</code>, <code>jss</code>, <code>xml</code>,
    <code>xsl</code>, <code>script</code> (for JavaScript), <code>services</code> (for mapping rules),
    or <code>ljss</code>.
     * @param bReload if <code>true</code>, a JavaScript or CSS file is reloaded from the remote server
    without checking the local browser cache. Other types of resources are not affected by this parameter.
     * @param returnType The expected return type
     * @return the return type depends on the <code>strType</code>
    parameter. See the method description.
     */
    @SuppressWarnings("unchecked")
    public <T> T loadInclude(org.directwebremoting.proxy.jsx3.net.URI strSrc, String strId, String strType, String bReload, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadInclude(\"" + strSrc + "\", \"" + strId + "\", \"" + strType + "\", \"" + bReload + "\").");
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
     * Removes a loaded JavaScript or CSS resource from the browser DOM.
     * @param strId the id used when loading the resource.
     */
    public void unloadInclude(String strId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("unloadInclude(").appendData(strId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Loads an application resource. This method looks up a resource registered with this application by its id.
    The resource must be registered in the config.xml file of this application.
     * @param strId unique identifier for the resource (its unique id as an application resource file).
     * @return the return type depends on the type of resource.
    See the documentation for <code>loadInclude()</code> for more information.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document loadResource(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadResource(\"" + strId + "\").");
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
     * Loads an application resource. This method looks up a resource registered with this application by its id.
    The resource must be registered in the config.xml file of this application.
     * @param strId unique identifier for the resource (its unique id as an application resource file).
     * @param returnType The expected return type
     * @return the return type depends on the type of resource.
    See the documentation for <code>loadInclude()</code> for more information.
     */
    @SuppressWarnings("unchecked")
    public <T> T loadResource(String strId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadResource(\"" + strId + "\").");
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
     * updates a single dynamic style property; dynamic properties are used by jsx3.gui.Block objects that extend the astract class, jsx3.gui.Block;
     * @param strPropName id for this dynamic property among all properties
     * @param vntValue value of the property; if null, the property with the name, @strPropName will be removed
     */
    public void setDynamicProperty(String strPropName, String vntValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setDynamicProperty(").appendData(strPropName).appendScript(",")

        .appendData(vntValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the value of the dynamic property @strPropName
     * @param strPropName id for this dynamic property among all properties
     * @param strToken if present tokens such as {0}, {1}, {n} will be replaced with the nth element of this vararg array
     * @return value of the property
     *
    @SuppressWarnings("unchecked")
    public String getDynamicProperty(String strPropName, String strToken, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets a Cookie with the given name and value
     * @param name name of the cookie
     * @param value value of the cookie
     * @param expires valid jscript date object. for example: new Date("11:59:59 12-31-2004")
     * @param path path where the cookie is valid (default: path of calling document)
     * @param domain domain where the cookie is valid (default: domain of calling document)
     * @param secure valid jscript date object. for example: new Date("11:59:59 12-31-2004")
     * @param bRaw 
     */
    public void setCookie(String name, String value, Date expires, String path, String domain, boolean secure, boolean bRaw)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCookie(").appendData(name).appendScript(",")

        .appendData(value).appendScript(",")

        .appendData(expires).appendScript(",")

        .appendData(path).appendScript(",")

        .appendData(domain).appendScript(",")

        .appendData(secure).appendScript(",")

        .appendData(bRaw).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the value for the Cookie with the given @name
     * @param name name of the cookie
     * @param bRaw 
     *
    @SuppressWarnings("unchecked")
    public String getCookie(String name, boolean bRaw, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * delete a cookie
     * @param name name of the cookie
     * @param path path where the cookie is valid (default: path of calling document)
     * @param domain domain where the cookie is valid (default: domain of calling document)
     */
    public void deleteCookie(String name, String path, String domain)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("deleteCookie(").appendData(name).appendScript(",")

        .appendData(path).appendScript(",")

        .appendData(domain).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the root block for this server (JSXROOT)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block getRootBlock()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRootBlock().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    /**
     * Returns the root block for this server (JSXROOT)
     */
    @SuppressWarnings("unchecked")
    public <T> T getRootBlock(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getRootBlock().");
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
     * To implement jsx3.gui.Alerts interface.
     * @return the root block.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getAlertsParent()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAlertsParent().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * To implement jsx3.gui.Alerts interface.
     * @param returnType The expected return type
     * @return the root block.
     */
    @SuppressWarnings("unchecked")
    public <T> T getAlertsParent(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAlertsParent().");
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
     * Returns the body block for this server (JSXBODY)
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block getBodyBlock()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getBodyBlock().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Block> ctor = org.directwebremoting.proxy.jsx3.gui.Block.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Block.class.getName());
        }
    }

    /**
     * Returns the body block for this server (JSXBODY)
     */
    @SuppressWarnings("unchecked")
    public <T> T getBodyBlock(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getBodyBlock().");
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
     * Returns the list of objects that are children of the body object. These are the root objects
    in a serialization file and the root nodes in the Component Hierarchy palette.
     *
    @SuppressWarnings("unchecked")
    public Object[] getRootObjects(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the XML/XSL cache for this server
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Cache getCache()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getCache().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Cache> ctor = org.directwebremoting.proxy.jsx3.app.Cache.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Cache.class.getName());
        }
    }

    /**
     * Returns the DOM for this server
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.DOM getDOM()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDOM().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.DOM> ctor = org.directwebremoting.proxy.jsx3.app.DOM.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.DOM.class.getName());
        }
    }

    /**
     * Looks up a DOM node owned by this server by id or by name.
     * @param strId either the id (_jsxid) of the object or its name (jsxname)
     * @return the JSX object or null if none found
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getJSX(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getJSX(\"" + strId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Looks up a DOM node owned by this server by id or by name.
     * @param strId either the id (_jsxid) of the object or its name (jsxname)
     * @param returnType The expected return type
     * @return the JSX object or null if none found
     */
    @SuppressWarnings("unchecked")
    public <T> T getJSX(String strId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getJSX(\"" + strId + "\").");
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
     * Looks up a DOM node owned by this server by name. If more than one such objects exist, only one is returned.
     * @param strId the name (jsxname) of the object
     * @return the JSX object or null if none found
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getJSXByName(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getJSXByName(\"" + strId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Looks up a DOM node owned by this server by name. If more than one such objects exist, only one is returned.
     * @param strId the name (jsxname) of the object
     * @param returnType The expected return type
     * @return the JSX object or null if none found
     */
    @SuppressWarnings("unchecked")
    public <T> T getJSXByName(String strId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getJSXByName(\"" + strId + "\").");
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
     * Looks up a DOM node owned by this server by id.
     * @param strId the id (_jsxid) of the object
     * @return the JSX object or null if none found
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.app.Model getJSXById(String strId)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getJSXById(\"" + strId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.app.Model> ctor = org.directwebremoting.proxy.jsx3.app.Model.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.app.Model.class.getName());
        }
    }

    /**
     * Looks up a DOM node owned by this server by id.
     * @param strId the id (_jsxid) of the object
     * @param returnType The expected return type
     * @return the JSX object or null if none found
     */
    @SuppressWarnings("unchecked")
    public <T> T getJSXById(String strId, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getJSXById(\"" + strId + "\").");
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
     * Creates a new jsx3.gui.Window instance for this server. A branch of the DOM of this application can be placed
    in this window in order to distribute the application across multiple browser windows.
     * @param strName the unique name of the window to create
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Window createAppWindow(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("createAppWindow(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Window> ctor = org.directwebremoting.proxy.jsx3.gui.Window.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Window.class.getName());
        }
    }

    /**
     * Loads a new jsx3.gui.Window instance from a component file.
     * @param strSource either an XML document containing the window to load or the URL of the
    component to load.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Window loadAppWindow(org.directwebremoting.proxy.jsx3.xml.Entity strSource)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadAppWindow(\"" + strSource + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Window> ctor = org.directwebremoting.proxy.jsx3.gui.Window.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Window.class.getName());
        }
    }

    /**
     * Loads a new jsx3.gui.Window instance from a component file.
     * @param strSource either an XML document containing the window to load or the URL of the
    component to load.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Window loadAppWindow(String strSource)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("loadAppWindow(\"" + strSource + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Window> ctor = org.directwebremoting.proxy.jsx3.gui.Window.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Window.class.getName());
        }
    }

    /**
     * Retrieves a previously created jsx3.gui.Window instance.
     * @param strName the unique name of the window to retrieve
     * @return the window instance or <code>null</code> if no such window exists.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Window getAppWindow(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getAppWindow(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Window> ctor = org.directwebremoting.proxy.jsx3.gui.Window.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Window.class.getName());
        }
    }

    /*
     * Returns the browser document object containing a particular JSX object. This method inspects whether the
    JSX object is a descendent of the root block of this server or one of its jsx3.gui.Window roots.
     * @param objJSX 
     * @return document object
     *
    @SuppressWarnings("unchecked")
    public HTMLDocument getDocumentOf(org.directwebremoting.proxy.jsx3.app.Model objJSX, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the browser DOM object where a particulat JSX object renders. This method inspects the main root of
    this server as well as all of its jsx3.gui.Window roots.
     * @param objJSX 
     * @return DOM object
     *
    @SuppressWarnings("unchecked")
    public String getRenderedOf(org.directwebremoting.proxy.jsx3.app.Model objJSX, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Resolves a URI that is referenced from a file in this server. This method takes into account the changes in
    resource addressing between 3.1 and 3.2. For version 3.1, the URI is resolved as any URI in the system, using
    jsx3.resolveURI(). In version 3.2, the URI is taken as relative to the application folder. In
    particular, a relative URI will be resolved to a base of the application folder, an absolute URI will be
    unaffected.
     * @param strURI the URI to resolve.
     * @return the resolved URI.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolveURI(String strURI)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("resolveURI(\"" + strURI + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /**
     * Resolves a URI that is referenced from a file in this server. This method takes into account the changes in
    resource addressing between 3.1 and 3.2. For version 3.1, the URI is resolved as any URI in the system, using
    jsx3.resolveURI(). In version 3.2, the URI is taken as relative to the application folder. In
    particular, a relative URI will be resolved to a base of the application folder, an absolute URI will be
    unaffected.
     * @param strURI the URI to resolve.
     * @return the resolved URI.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI resolveURI(org.directwebremoting.proxy.jsx3.net.URI strURI)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("resolveURI(\"" + strURI + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public String getUriPrefix(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * 
     * @param strURI the URI to relativize.
     * @param bRel 
     * @return the relativized URI.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativizeURI(String strURI, boolean bRel)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("relativizeURI(\"" + strURI + "\", \"" + bRel + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /**
     * 
     * @param strURI the URI to relativize.
     * @param bRel 
     * @return the relativized URI.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.net.URI relativizeURI(org.directwebremoting.proxy.jsx3.net.URI strURI, boolean bRel)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("relativizeURI(\"" + strURI + "\", \"" + bRel + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.net.URI> ctor = org.directwebremoting.proxy.jsx3.net.URI.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.net.URI.class.getName());
        }
    }

    /**
     * Returns the current locale of this server. If the locale has been set explicitly with setLocale(),
    that locale is returned. Otherwise, getDefaultLocale() is consulted, and finally the system-wide
    locale.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Locale getLocale()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getLocale().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Locale> ctor = org.directwebremoting.proxy.jsx3.util.Locale.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Locale.class.getName());
        }
    }

    /**
     * Sets the locale of this server.
     * @param objLocale 
     */
    public void setLocale(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLocale(").appendData(objLocale).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the default locale of this server. This is configured with the default_locale configuration
    setting.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.Locale getDefaultLocale()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDefaultLocale().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.Locale> ctor = org.directwebremoting.proxy.jsx3.util.Locale.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.Locale.class.getName());
        }
    }

    /**
     * Reloads all resource files that are localized. This method should be called after calling
    setLocale() for the server to render properly in the new locale.
     */
    public void reloadLocalizedResources()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("reloadLocalizedResources(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Invokes context-sensitive help as though the user had pressed the help hot key in the context of the DOM node
    objJSX.
     * @param objJSX 
     */
    public void invokeHelp(org.directwebremoting.proxy.jsx3.app.Model objJSX)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("invokeHelp(").appendData(objJSX).appendScript(");");
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

    /**
     * show an alert dialog
     * @param strTitle the title of the dialog
     * @param strMessage the message to display
     * @param fctOnOk callback function on pressing ok button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param strOk the text of the ok button, can be false to remove button from display
     * @param objParams argument to configureAlert()
     */
    public void alert(String strTitle, String strMessage, org.directwebremoting.proxy.CodeBlock fctOnOk, String strOk, String objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("alert(").appendData(strTitle).appendScript(",")

        .appendData(strMessage).appendScript(",")

        .appendData(fctOnOk).appendScript(",")

        .appendData(strOk).appendScript(",")

        .appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * configure the dialog
     * @param objDialog the dialog
     * @param objParams may include fields 'width', 'height', 'noTitle', and 'nonModal'.
     */
    public void configureAlert(String objDialog, Object objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("configureAlert(").appendData(objDialog).appendScript(",")

        .appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * show a confirm alert
     * @param strTitle the title of the dialog
     * @param strMessage the message to display
     * @param fctOnOk callback function on pressing ok button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param fctOnCancel callback function on pressing cancel button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param strOk the text of the ok button
     * @param strCancel the text of the cancel button
     * @param intBtnDefault the bold button that receives return key, 1:ok, 2:cancel, 3:no
     * @param fctOnNo callback function on pressing no button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param strNo the text of the no button
     * @param objParams argument to configureAlert()
     */
    public void confirm(String strTitle, String strMessage, org.directwebremoting.proxy.CodeBlock fctOnOk, org.directwebremoting.proxy.CodeBlock fctOnCancel, String strOk, String strCancel, int intBtnDefault, org.directwebremoting.proxy.CodeBlock fctOnNo,
            String strNo, String objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("confirm(").appendData(strTitle).appendScript(",")

        .appendData(strMessage).appendScript(",")

        .appendData(fctOnOk).appendScript(",")

        .appendData(fctOnCancel).appendScript(",")

        .appendData(strOk).appendScript(",")

        .appendData(strCancel).appendScript(",")

        .appendData(intBtnDefault).appendScript(",")

        .appendData(fctOnNo).appendScript(",")

        .appendData(strNo).appendScript(",")

        .appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * show a text box input prompt
     * @param strTitle the title of the dialog
     * @param strMessage the message to display
     * @param fctOnOk callback function on pressing ok button, receives the dialog as an argument, and the value of the text input as a second argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param fctOnCancel callback function on pressing cancel button, receives the dialog as an argument; if null the dialog will close itself; if defined must explicitly close the dialog
     * @param strOk the text of the ok button
     * @param strCancel the text of the cancel button
     * @param objParams argument to configureAlert()
     */
    public void prompt(String strTitle, String strMessage, org.directwebremoting.proxy.CodeBlock fctOnOk, org.directwebremoting.proxy.CodeBlock fctOnCancel, String strOk, String strCancel, String objParams)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("prompt(").appendData(strTitle).appendScript(",")

        .appendData(strMessage).appendScript(",")

        .appendData(fctOnOk).appendScript(",")

        .appendData(fctOnCancel).appendScript(",")

        .appendData(strOk).appendScript(",")

        .appendData(strCancel).appendScript(",")

        .appendData(objParams).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

}
