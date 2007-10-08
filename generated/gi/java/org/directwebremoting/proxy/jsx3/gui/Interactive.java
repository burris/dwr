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
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public interface Interactive
{
    
    /**
     * 
     */
    public static final String JSXBLUR = "jsxblur";

    /**
     * 
     */
    public static final String JSXCHANGE = "jsxchange";

    /**
     * 
     */
    public static final String JSXCLICK = "jsxclick";

    /**
     * 
     */
    public static final String JSXDOUBLECLICK = "jsxdblclick";

    /**
     * 
     */
    public static final String JSXFOCUS = "jsxfocus";

    /**
     * 
     */
    public static final String JSXKEYDOWN = "jsxkeydown";

    /**
     * 
     */
    public static final String JSXKEYPRESS = "jsxkeypress";

    /**
     * 
     */
    public static final String JSXKEYUP = "jsxkeyup";

    /**
     * 
     */
    public static final String JSXLOAD = "jsxload";

    /**
     * 
     */
    public static final String JSXMOUSEDOWN = "jsxmousedown";

    /**
     * 
     */
    public static final String JSXMOUSEOUT = "jsxmouseout";

    /**
     * 
     */
    public static final String JSXMOUSEOVER = "jsxmouseover";

    /**
     * 
     */
    public static final String JSXMOUSEUP = "jsxmouseup";

    /**
     * 
     */
    public static final String JSXMOUSEWHEEL = "jsxmousewheel";

    /**
     * 
     */
    public static final String FOCUS_STYLE = "text-decoration:underline";

    /**
     * 
     */
    public static final String ADOPT = "jsxadopt";

    /**
     * 
     */
    public static final String AFTER_APPEND = "jsxafterappend";

    /**
     * 
     */
    public static final String AFTER_COMMIT = "jsxaftercommit";

    /**
     * 
     */
    public static final String AFTER_EDIT = "jsxafteredit";

    /**
     * 
     */
    public static final String AFTER_MOVE = "jsxaftermove";

    /**
     * 
     */
    public static final String AFTER_REORDER = "jsxafterreorder";

    /**
     * 
     */
    public static final String AFTER_RESIZE = "jsxafterresize";

    /**
     * 
     */
    public static final String AFTER_RESIZE_VIEW = "jsxafterresizeview";

    /**
     * 
     */
    public static final String AFTER_SORT = "jsxaftersort";

    /**
     * 
     */
    public static final String BEFORE_APPEND = "jsxbeforeappend";

    /**
     * 
     */
    public static final String BEFORE_DROP = "jsxbeforedrop";

    /**
     * 
     */
    public static final String BEFORE_EDIT = "jsxbeforeedit";

    /**
     * 
     */
    public static final String BEFORE_MOVE = "jsxbeforemove";

    /**
     * 
     */
    public static final String BEFORE_RESIZE = "jsxbeforeresize";

    /**
     * 
     */
    public static final String BEFORE_SELECT = "jsxbeforeselect";

    /**
     * 
     */
    public static final String BEFORE_SORT = "jsxbeforesort";

    /**
     * 
     */
    public static final String CANCEL_DROP = "jsxcanceldrop";

    /**
     * 
     */
    public static final String CHANGE = "jsxchange";

    /**
     * 
     */
    public static final String CTRL_DROP = "jsxctrldrop";

    /**
     * 
     */
    public static final String DESTROY = "jsxdestroy";

    /**
     * 
     */
    public static final String DATA = "jsxdata";

    /**
     * 
     */
    public static final String DRAG = "jsxdrag";

    /**
     * 
     */
    public static final String DROP = "jsxdrop";

    /**
     * 
     */
    public static final String EXECUTE = "jsxexecute";

    /**
     * 
     */
    public static final String HIDE = "jsxhide";

    /**
     * 
     */
    public static final String INCR_CHANGE = "jsxincchange";

    /**
     * 
     */
    public static final String INPUT = "jsxinput";

    /**
     * 
     */
    public static final String MENU = "jsxmenu";

    /**
     * 
     */
    public static final String SCROLL = "jsxscroll";

    /**
     * 
     */
    public static final String SELECT = "jsxselect";

    /**
     * 
     */
    public static final String SHOW = "jsxshow";

    /**
     * 
     */
    public static final String SPYGLASS = "jsxspy";

    /**
     * 
     */
    public static final String TOGGLE = "jsxtoggle";


}
