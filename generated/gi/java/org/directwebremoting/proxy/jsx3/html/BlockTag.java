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

package org.directwebremoting.proxy.jsx3.html;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class BlockTag extends org.directwebremoting.proxy.jsx3.html.Tag
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public BlockTag(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strTagNS 
     * @param strTagName 
     * @param left left position (in pixels) of the object relative to its parent container
     * @param top top position (in pixels) of the object relative to its parent container
     * @param width width (in pixels) of the object
     * @param height height (in pixels) of the object
     */
    public BlockTag(String strTagNS, String strTagName, int left, int top, int width, int height)
    {
        super((ProxyHelper) null);
    }

    /*
     * Returns the left field.
     * @return left
     *
    @SuppressWarnings("unchecked")
    public int getLeft(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the left field.
     * @param left the new value for left
     */
    public void setLeft(int left)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLeft(").appendData(left).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the top field.
     * @return top
     *
    @SuppressWarnings("unchecked")
    public int getTop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the top field.
     * @param top the new value for top
     */
    public void setTop(int top)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTop(").appendData(top).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the width field.
     * @return width
     *
    @SuppressWarnings("unchecked")
    public int getWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the width field.
     * @param width the new value for width
     */
    public void setWidth(int width)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setWidth(").appendData(width).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the height field.
     * @return height
     *
    @SuppressWarnings("unchecked")
    public int getHeight(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the height field.
     * @param height the new value for height
     */
    public void setHeight(int height)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHeight(").appendData(height).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the margin field, as set by setMargin().
     * @return margin
     *
    @SuppressWarnings("unchecked")
    public String getMargin(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the margin field, can be a single value or four values separated by space that correspond to top, right, bottom, and left.
     * @param margin the new value for margin
     */
    public void setMargin(String margin)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setMargin(").appendData(margin).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the padding field, as set by setPadding().
     * @return padding
     *
    @SuppressWarnings("unchecked")
    public String getPadding(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the padding field, can be a single value or four values separated by space that correspond to top, right, bottom, and left.
     * @param padding the new value for padding
     */
    public void setPadding(String padding)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPadding(").appendData(padding).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the position field.
     * @return position
     *
    @SuppressWarnings("unchecked")
    public String getPosition(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the position field, can be 'absolute' or 'relative'.
     * @param position the new value for position
     */
    public void setPosition(String position)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPosition(").appendData(position).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the zIndex field.
     * @return zIndex
     *
    @SuppressWarnings("unchecked")
    public int getZIndex(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the zIndex field.
     * @param zIndex the new value for zIndex
     */
    public void setZIndex(int zIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setZIndex(").appendData(zIndex).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the bgcolor field.
     * @return bgcolor
     *
    @SuppressWarnings("unchecked")
    public String getBackgroundColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the bgcolor field.
     * @param bgcolor the new value for bgcolor
     */
    public void setBackgroundColor(String bgcolor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setBackgroundColor(").appendData(bgcolor).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * parses the margin field into an array of four int values
     * @return [top,right,bottom,left]
     *
    @SuppressWarnings("unchecked")
    public Object[] getMarginDimensions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * parses the padding field into an array of four int values
     * @return [top,right,bottom,left]
     *
    @SuppressWarnings("unchecked")
    public Object[] getPaddingDimensions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the dimensions in an array of four int values
     * @return [left,top,width,height]
     *
    @SuppressWarnings("unchecked")
    public Object[] getDimensions(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets all four dimensions at once.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
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
     * Sets all four dimensions at once.
     * @param left the new left value or an array containing all four new values
     * @param top the new top value
     * @param width the new width value
     * @param height the new height value
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

}
