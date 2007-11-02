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

package org.directwebremoting.proxy.jsx3.util;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class MessageFormat extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public MessageFormat(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strFormat the format pattern.
     * @param objLocale the locale of the format. The locale affects how numbers and dates are
    formatted. If this parameter is omitted, the system locale is used.
     */
    public MessageFormat(String strFormat, org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        super((ProxyHelper) null);
    }

    /**
     * Returns the locale of this message format.
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
     * Sets the locale of this message format.
     * @param objLocale 
     */
    public void setLocale(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLocale(").appendData(objLocale).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Formats a collection of objects according to this message format.
     * @param args the argument objects. Replacement tokens of the pattern of this format
    will be replaced by these arguments.
     * @return the string resulting from the pattern and arguments.
     *
    @SuppressWarnings("unchecked")
    public String format(Object args, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Formats a collection of objects according to this message format.
     * @param args the argument objects. Replacement tokens of the pattern of this format
    will be replaced by these arguments.
     * @return the string resulting from the pattern and arguments.
     *
    @SuppressWarnings("unchecked")
    public String format(Object[] args, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

}
