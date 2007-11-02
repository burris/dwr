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

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class LayoutGrid extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public LayoutGrid(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     */
    public LayoutGrid(String strName)
    {
        super((ProxyHelper) null);
    }

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public String getCols(Callback callback)
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
     * @param strCols 
     * @param bRepaint 
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.LayoutGrid setCols(String strCols, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCols(").appendData(strCols).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public String getRows(Callback callback)
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
     * @param strRows 
     * @param bRepaint 
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.LayoutGrid setRows(String strRows, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRows(").appendData(strRows).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

}
