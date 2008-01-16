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
package jsx3.gui;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * Native browser event wrapper.
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Event extends jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param scriptProxy The place we are writing scripts to
     * @param context The script that got us to where we are now
     */
    public Event(Context context, String extension, ScriptProxy scriptProxy)
    {
        super(context, extension, scriptProxy);
    }


    /**
     * The browser native event type beforeunload.
     */
    public static final String BEFOREUNLOAD = "beforeunload";

    /**
     * The browser native event type blur.
     */
    public static final String BLUR = "blur";

    /**
     * The browser native event type change.
     */
    public static final String CHANGE = "change";

    /**
     * The browser native event type click.
     */
    public static final String CLICK = "click";

    /**
     * The browser native event type dblclick.
     */
    public static final String DOUBLECLICK = "dblclick";

    /**
     * The browser native event type error.
     */
    public static final String ERROR = "error";

    /**
     * The browser native event type focus.
     */
    public static final String FOCUS = "focus";

    /**
     * The browser native event type keydown.
     */
    public static final String KEYDOWN = "keydown";

    /**
     * The browser native event type keypress.
     */
    public static final String KEYPRESS = "keypress";

    /**
     * The browser native event type keyup.
     */
    public static final String KEYUP = "keyup";

    /**
     * The browser native event type load.
     */
    public static final String LOAD = "load";

    /**
     * The browser native event type mousedown.
     */
    public static final String MOUSEDOWN = "mousedown";

    /**
     * The browser native event type mousemove.
     */
    public static final String MOUSEMOVE = "mousemove";

    /**
     * The browser native event type mouseout.
     */
    public static final String MOUSEOUT = "mouseout";

    /**
     * The browser native event type mouseover.
     */
    public static final String MOUSEOVER = "mouseover";

    /**
     * The browser native event type mouseup.
     */
    public static final String MOUSEUP = "mouseup";

    /**
     * The browser native event type mousewheel.
     */
    public static final String MOUSEWHEEL = "mousewheel";

    /**
     * The browser native event type unload.
     */
    public static final String UNLOAD = "unload";

    /**
     * The browser native event type resize.
     */
    public static final String RESIZE = "resize";

    /**
     * The browser native key code for the Alt key.
     */
    public static final int KEY_ALT = 18;

    /**
     * The browser native key code for the down arrow key.
     */
    public static final int KEY_ARROW_DOWN = 40;

    /**
     * The browser native key code for the left arrow key.
     */
    public static final int KEY_ARROW_LEFT = 37;

    /**
     * The browser native key code for the right arrow key.
     */
    public static final int KEY_ARROW_RIGHT = 39;

    /**
     * The browser native key code for the up arrow key.
     */
    public static final int KEY_ARROW_UP = 38;

    /**
     * The browser native key code for the Backspace key.
     */
    public static final int KEY_BACKSPACE = 8;

    /**
     * The browser native key code for the Ctrl key.
     */
    public static final int KEY_CONTROL = 17;

    /**
     * The browser native key code for the Delete key.
     */
    public static final int KEY_DELETE = 46;

    /**
     * The browser native key code for the End key.
     */
    public static final int KEY_END = 35;

    /**
     * The browser native key code for the Enter key.
     */
    public static final int KEY_ENTER = 13;

    /**
     * The browser native key code for the Esc key.
     */
    public static final int KEY_ESCAPE = 27;

    /**
     * The browser native key code for the Home key.
     */
    public static final int KEY_HOME = 36;

    /**
     * The browser native key code for the Insert key.
     */
    public static final int KEY_INSERT = 45;

    /**
     * The browser native key code for the Meta key.
     */
    public static final int KEY_META = 224;

    /**
     * The browser native key code for the Page Down key.
     */
    public static final int KEY_PAGE_DOWN = 34;

    /**
     * The browser native key code for the Page Up key.
     */
    public static final int KEY_PAGE_UP = 33;

    /**
     * The browser native key code for the Shift key.
     */
    public static final int KEY_SHIFT = 16;

    /**
     * The browser native key code for the space bar key.
     */
    public static final int KEY_SPACE = 32;

    /**
     * The browser native key code for the Tab key.
     */
    public static final int KEY_TAB = 9;

    /**
     * The browser native key code for the 0 key.
     */
    public static final int KEY_0 = 48;

    /**
     * The browser native key code for the 9 key.
     */
    public static final int KEY_9 = 57;

    /**
     * The browser native key code for the A key.
     */
    public static final int KEY_A = 65;

    /**
     * The browser native key code for the Z key.
     */
    public static final int KEY_Z = 90;

    /**
     * The browser native key code for the number pad 0 key.
     */
    public static final int KEY_NP0 = 96;

    /**
     * The browser native key code for the number pad 9 key.
     */
    public static final int KEY_NP9 = 105;

    /**
     * The browser native key code for the number pad division (/) key.
     */
    public static final int KEY_NPDIV = 111;

    /**
     * The browser native key code for the number pad multiply (*) key.
     */
    public static final int KEY_NPMUL = 106;

    /**
     * The browser native key code for the number pad subtract (-) key.
     */
    public static final int KEY_NPSUB = 109;

    /**
     * The browser native key code for the number pad addition (+) key.
     */
    public static final int KEY_NPADD = 107;

    /**
     * The browser native key code for the number pad decimal (.) key.
     */
    public static final int KEY_NPDEC = 110;

    /**
     * The browser native key code for the F1 key.
     */
    public static final int KEY_F1 = 112;

    /**
     * The browser native key code for the F15 key.
     */
    public static final int KEY_F15 = 126;


    /**
     * Subscribes an event handler to events of type strEventId that bubble all the way up to the browser window.
     * @param strEventId the event type, e.g. <code>jsx3.gui.Event.CLICK</code>.
     * @param objHandler 
     * @param objFunction 
     */
    public void subscribe(String strEventId, String objHandler, String objFunction)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("subscribe", strEventId, objHandler, objFunction);
        getScriptProxy().addScript(script);
    }

    /**
     * Unsubscribes an event handler from events of type strEventId that bubble all the way up to the browser window.
     * @param strEventId the event type, e.g. <code>jsx3.gui.Event.CLICK</code>.
     * @param objHandler 
     */
    public void unsubscribe(String strEventId, String objHandler)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("unsubscribe", strEventId, objHandler);
        getScriptProxy().addScript(script);
    }

    /**
     * Unsubscribes all event handlers from a events of type strEventId that bubble all the way up to the browser window.
     * @param strEventId the event type, e.g. <code>jsx3.gui.Event.CLICK</code>.
     */
    public void unsubscribeAll(String strEventId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("unsubscribeAll", strEventId);
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the type of event, e.g. mousedown, click, etc.
     * @param callback event type
     */
    @SuppressWarnings("unchecked")
    public void getType(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getType");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns handle to the HTML element acted upon (click, mousedown, etc).
     * @param callback HTML object
     */
    @SuppressWarnings("unchecked")
    public void srcElement(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = srcElement");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns handle to the HTML element that was moused over (onmouseover).
     * @param callback HTML object
     */
    @SuppressWarnings("unchecked")
    public void toElement(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = toElement");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns handle to the HTML element that was moused away from (onmouseout).
     * @param callback HTML object
     */
    @SuppressWarnings("unchecked")
    public void fromElement(Callback<String> callback)
    {
        String key = CallbackHelper.saveCallback(callback, String.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = fromElement");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns integer representing the key code of the key just pressed/keyed-down.
     * @param callback keycode
     */
    @SuppressWarnings("unchecked")
    public void keyCode(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = keyCode");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the clientX property for the event (where it occurred on-screen).
     * @param callback pixel position
     */
    @SuppressWarnings("unchecked")
    public void clientX(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = clientX");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the clientY property for the event (where it occurred on-screen).
     * @param callback pixel position
     */
    @SuppressWarnings("unchecked")
    public void clientY(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = clientY");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the actual position in the browser from the left edge for where the event occurred.
     * @param callback pixel position
     */
    @SuppressWarnings("unchecked")
    public void getTrueX(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTrueX");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns the actual position in the browser from the top edge for where the event occurred.
     * @param callback pixel position
     */
    @SuppressWarnings("unchecked")
    public void getTrueY(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = getTrueY");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the shift key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void shiftKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = shiftKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true the ctrl key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void ctrlKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = ctrlKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the alt key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void altKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = altKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the enter key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void enterKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = enterKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the space bar was pressed.
     */
    @SuppressWarnings("unchecked")
    public void spaceKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = spaceKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the tab key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void tabKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = tabKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the right-arrow key was pressed
     */
    @SuppressWarnings("unchecked")
    public void rightArrow(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = rightArrow");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the left-arrow key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void leftArrow(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = leftArrow");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the up-arrow key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void upArrow(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = upArrow");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the down-arrow key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void downArrow(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = downArrow");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the delete key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void deleteKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = deleteKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the backspace key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void backspaceKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = backspaceKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the insert key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void insertKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = insertKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the home key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void homeKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = homeKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the end key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void endKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = endKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the page-up key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void pageUpKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = pageUpKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the page-down key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void pageDownKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = pageDownKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the escape key was pressed.
     */
    @SuppressWarnings("unchecked")
    public void escapeKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = escapeKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Cancels event bubbling for the event.
     */
    public void cancelBubble()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("cancelBubble");
        getScriptProxy().addScript(script);
    }

    /**
     * Cancels the return value for the event.
     */
    public void cancelReturn()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("cancelReturn");
        getScriptProxy().addScript(script);
    }

    /**
     * Cancels the key from firing by setting the keyCode to 0 (zero) for the event.
     */
    public void cancelKey()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("cancelKey");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the left-mouse-button was clicked.
     */
    @SuppressWarnings("unchecked")
    public void leftButton(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = leftButton");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns true if the right-mouse-button was clicked.
     */
    @SuppressWarnings("unchecked")
    public void rightButton(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = rightButton");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Returns integer designating the mouse button clicked/moused-down/moused-up; 1 (left), 2 (right), and as supported.
     */
    @SuppressWarnings("unchecked")
    public void button(Callback<Integer> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Integer.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = button");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Sets the the return value for the event.
     * @param strReturn string message to set on the returnValue for the event
     */
    public void setReturn(String strReturn)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("setReturn", strReturn);
        getScriptProxy().addScript(script);
    }

    /**
     * Whether one of the four arrow keys was pressed.
     */
    @SuppressWarnings("unchecked")
    public void isArrowKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isArrowKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

    /**
     * Whether one of the 15 function keys was pressed.
     */
    @SuppressWarnings("unchecked")
    public void isFunctionKey(Callback<Boolean> callback)
    {
        String key = CallbackHelper.saveCallback(callback, Boolean.class);

        ScriptBuffer script = new ScriptBuffer();
        script.appendCall("var reply = isFunctionKey");
        script.appendCall("__System.activateCallback", key, "reply");
        getScriptProxy().addScript(script);
    }

}

