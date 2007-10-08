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

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class HotKey extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public HotKey(ProxyHelper helper)
    {
        super(helper);
    }

    
    /**
     * Event type published just after a hot key is invoked.
     */
    public static final String WAS_INVOKED = "invoked";

    /**
     * 
     * @param strKey 
     * @param fctCallback 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.HotKey valueOf(String strKey, org.directwebremoting.proxy.CodeBlock fctCallback)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("valueOf(\"" + strKey + "\", \"" + fctCallback + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.HotKey> ctor = org.directwebremoting.proxy.jsx3.gui.HotKey.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.HotKey.class.getName());
        }
    }

    
    
    /*
     * Returns the keycode that this hot key responds to.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public int getKeyCode(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns whether this hot key should be invoked for the keydown event objEvent.
     * @param objEvent 
     * @return 
     *
    @SuppressWarnings("unchecked")
    public boolean isMatch(org.directwebremoting.proxy.jsx3.gui.Event objEvent, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Invokes this hot key by executing its callback function. This hot key also publishes a WAS_INVOKED
event through the event dispatcher interface.
     * @param objThis 
     * @param arrArgs 
     * @return this method returns whatever value was returned by the hot key callback function.
     *
    @SuppressWarnings("unchecked")
    public Object invoke(Object objThis, Object[] arrArgs, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /*
     * Returns whether this hot key is enabled.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public boolean isEnabled(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Sets whether this hot key is enabled. Hot keys may be turned off temporarily by sending false to 
this method.
     * @param bEnabled 
     */
    public void setEnabled(boolean bEnabled)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("setEnabled(")
              .appendData(bEnabled)
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * Returns whether this hot key had been destoyed.
     * @return 
     *
    @SuppressWarnings("unchecked")
    public boolean isDestroyed(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    
    /**
     * Destroys this hot key. Once a hot key is destroyed it cannot be invoked again.
     */
    public void destroy()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("destroy(")
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    
    /*
     * 
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
     * Converts the string representation of a keyboard key to an integer keycode. This keycode will match the keycode
value of a jsx3.gui.Event of type keydown. 

The following string representations are supported:

  alpha numeric characters: A-Z, a-z, 0-9
        
  the punctuation keys in the string: ";,./'[]\-=`"
        
  functions keys: F1-F15
        
  special keys: enter, esc, tab, del, space, 
    backspace, up, down, left, right, 
    insert, home, end, pgup, pgdn.
     * @param strChar the string representation of a key.
     * @return the keycode.
     *
    @SuppressWarnings("unchecked")
    public int keyDownCharToCode(String strChar, Callback callback)
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
    
 }
