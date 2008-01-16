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
package jsx3.html;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * Represents an HTML element that occupies a rectangle of the screen.

This class is available only when the Charting add-in is enabled.
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class BlockTag extends jsx3.html.Tag
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public BlockTag(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
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
        super((Context) null, (String) null, (ScriptProxy) null);
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("new BlockTag", strTagNS, strTagName, left, top, width, height);
        setInitScript(script);
    }



    /**
     * Returns the left field.
     * @param callback left
     */
    @SuppressWarnings("unchecked")
    public void getLeft(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getLeft");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the left field.
     * @param left the new value for left
     */
    public void setLeft(int left)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setLeft", left);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the top field.
     * @param callback top
     */
    @SuppressWarnings("unchecked")
    public void getTop(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTop");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the top field.
     * @param top the new value for top
     */
    public void setTop(int top)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setTop", top);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the width field.
     * @param callback width
     */
    @SuppressWarnings("unchecked")
    public void getWidth(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getWidth");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the width field.
     * @param width the new value for width
     */
    public void setWidth(int width)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setWidth", width);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the height field.
     * @param callback height
     */
    @SuppressWarnings("unchecked")
    public void getHeight(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getHeight");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the height field.
     * @param height the new value for height
     */
    public void setHeight(int height)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setHeight", height);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the margin field, as set by setMargin().
     * @param callback margin
     */
    @SuppressWarnings("unchecked")
    public void getMargin(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMargin");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the margin field, can be a single value or four values separated by space that correspond to top, right, bottom, and left.
     * @param margin the new value for margin
     */
    public void setMargin(String margin)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setMargin", margin);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the padding field, as set by setPadding().
     * @param callback padding
     */
    @SuppressWarnings("unchecked")
    public void getPadding(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPadding");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the padding field, can be a single value or four values separated by space that correspond to top, right, bottom, and left.
     * @param padding the new value for padding
     */
    public void setPadding(String padding)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setPadding", padding);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the position field.
     * @param callback position
     */
    @SuppressWarnings("unchecked")
    public void getPosition(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPosition");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the position field, can be 'absolute' or 'relative'.
     * @param position the new value for position
     */
    public void setPosition(String position)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setPosition", position);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the zIndex field.
     * @param callback zIndex
     */
    @SuppressWarnings("unchecked")
    public void getZIndex(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getZIndex");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the zIndex field.
     * @param zIndex the new value for zIndex
     */
    public void setZIndex(int zIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setZIndex", zIndex);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the bgcolor field.
     * @param callback bgcolor
     */
    @SuppressWarnings("unchecked")
    public void getBackgroundColor(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getBackgroundColor");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the bgcolor field.
     * @param bgcolor the new value for bgcolor
     */
    public void setBackgroundColor(String bgcolor)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setBackgroundColor", bgcolor);
        getScriptProxy().addScript(script);
    }

    /**
     * parses the margin field into an array of four int values
     * @param callback [top,right,bottom,left]
     */
    @SuppressWarnings("unchecked")
    public void getMarginDimensions(Callback<Object[]> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object[].class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getMarginDimensions");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * parses the padding field into an array of four int values
     * @param callback [top,right,bottom,left]
     */
    @SuppressWarnings("unchecked")
    public void getPaddingDimensions(Callback<Object[]> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object[].class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getPaddingDimensions");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the dimensions in an array of four int values
     * @param callback [left,top,width,height]
     */
    @SuppressWarnings("unchecked")
    public void getDimensions(Callback<Object[]> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Object[].class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getDimensions");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

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
        script.appendCall("setDimensions", left, top, width, height);
        getScriptProxy().addScript(script);
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
        script.appendCall("setDimensions", left, top, width, height);
        getScriptProxy().addScript(script);
    }

}

