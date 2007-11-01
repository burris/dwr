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
public class Matrix extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Matrix(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     */
    public Matrix(String strName)
    {
        super((ProxyHelper) null);
    }

    /**
     * 50
     */
    public static final int AUTO_SCROLL_INTERVAL = 50;

    /**
     * jsx:///images/matrix/select.gif
     */
    public static final String SELECTION_BG = "jsx:///images/matrix/select.gif";

    /**
     * jsx:///images/matrix/insert_before.gif
     */
    public static final String INSERT_BEFORE_IMG = null;

    /**
     * jsx:///images/matrix/append.gif
     */
    public static final String APPEND_IMG = null;

    /**
     * font-weight:bold
     */
    public static final String FOCUS_STYLE = "font-weight:bold";

    /**
     * jsx:///images/matrix/minus.gif (default)
     */
    public static final String ICON_MINUS = "jsx:///images/matrix/minus.gif";

    /**
     * jsx:///images/matrix/plus.gif (default)
     */
    public static final String ICON_PLUS = "jsx:///images/matrix/plus.gif";

    /**
     * jsx:///images/matrix/file.gif (default)
     */
    public static final String ICON = "jsx:///images/matrix/file.gif";

    /**
     * ascending
     */
    public static final String SORT_ASCENDING = "ascending";

    /**
     * descending
     */
    public static final String SORT_DESCENDING = "descending";

    /**
     * jsx:///images/matrix/sort_desc.gif (default)
     */
    public static final String SORT_DESCENDING_IMG = null;

    /**
     * jsx:///images/matrix/sort_asc.gif (default)
     */
    public static final String SORT_ASCENDING_IMG = null;

    /**
     * 4. minimum width of a column when minimized (set Display to 'none' to completely hide a column)
     */
    public static final int MINIMUM_COLUMN_WIDTH = 8;

    /**
     * 20
     */
    public static final int DEFAULT_HEADER_HEIGHT = 20;

    /**
     * 0
     */
    public static final int AUTOROW_NONE = 0;

    /**
     * 1
     */
    public static final int AUTOROW_LAST_ROW = 1;

    /**
     * 2
     */
    public static final int AUTOROW_FIRST_ROW = 2;

    /**
     * jsxpaintpage. Event to subscribe to each time a page of content is about to be painted on-screen
     */
    public static final String ON_PAINT_PAGE = "jsxpaintpage";

    /**
     * Default. All data is painted at once with the outer container.
     */
    public static final int PAGING_OFF = 0;

    /**
     * The outer container is first painted and then the entirety of the data is painted during a second pass
     */
    public static final int PAGING_2PASS = 1;

    /**
     * The outer container is first painted. Chunked sets of data are painted on-screen during repeated passes until
      all data is painted
     */
    public static final int PAGING_CHUNKED = 2;

    /**
     * The outer container is first painted. The first and last panels are painted during a second pass. As the user
      scrolls, relevant panels are added and unused panels are collected. (NOTE: Requires that row height be fixed.)
     */
    public static final int PAGING_PAGED = 3;

    /**
     * The outer container is painted along with any rows which are immediate children of the rendering context and those
      descendant rows that have an open path to the context node. All other rows will be fetched when the state for
      their on-screen parent row is toggled to open.
     */
    public static final int PAGING_STEPPED = 4;

    /**
     * 0
     */
    public static final int SELECTION_UNSELECTABLE = 0;

    /**
     * 1 (default)
     */
    public static final int SELECTION_ROW = 1;

    /**
     * 2
     */
    public static final int SELECTION_MULTI_ROW = 2;

    /**
     * 20
     */
    public static final int DEFAULT_ROW_HEIGHT = 20;

    /**
     * 18. number of panels allowed on-screen before destroying the panel most distant from the current panel index
     */
    public static final int DEFAULT_PANEL_POOL_COUNT = 5;

    /**
     * 50. number of rows in a given panel
     */
    public static final int DEFAULT_ROWS_PER_PANEL = 50;

    /**
     * 250. number of milliseconds between the time a new panel is added and the reaper checks for content exceeding Matrix.DEFAULT_PANEL_POOL_COUNT
     */
    public static final int DEFAULT_REAPER_INTERVAL = 250;

    /**
     * 3. number of panels in the paint queue. As new panels are added to the queue to be painted, older, less-relevant panels in the queue are removed
     */
    public static final int DEFAULT_PANEL_QUEUE_SIZE = 3;

    /**
     * 
     */
    public static final String DEFAULTXSLURL = null;

    /*
     * Returns the DHTML, used for this object's on-screen VIEW
     * @return DHTML
     *
    @SuppressWarnings("unchecked")
    public String paint(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Ends any existing edit session and hides the active mask. This is a carryover method from grid.
     */
    public void resetMask()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("resetMask(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Paints only the data rows.  Call for quick repainting of the data rows when only the source data
    has changed. Does not recalculate and reprofile the box profile and resulting XSLT. Retains scroll position when possible.
     */
    public void repaintData()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("repaintData(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Repaints the header row for improved runtime efficiency. For example, a minor text change to a label in a header row shouldn't repaint the entirety of the instance
     */
    public void repaintHead()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("repaintHead(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sorts according to the current sort path. If no sort direction is specified, the value will be toggled.
     * @param intSortDir <code>jsx3.gui.Matrix.SORT_ASCENDING</code> or <code>jsx3.gui.Matrix.SORT_DESCENDING</code>.
     */
    public void doSort(String intSortDir)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("doSort(").appendData(intSortDir).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the name of the CDF attribute to sort on. If no value is set an empty string is returned by default.
     *
    @SuppressWarnings("unchecked")
    public String getSortPath(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the name of the CDF attribute to sort on. The records in the data source of this matrix are sorted
    on this attribute before being painted to screen.
     * @param strAttr 
     */
    public void setSortPath(String strAttr)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSortPath(").appendData(strAttr).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the data type to be used for sorting this list. This value is either the one explicitly set with
    setSortType() or the data type of the current sort.
     * @return <code>jsx3.gui.Matrix.Column.TYPE_TEXT</code> or <code>jsx3.gui.Matrix.Column.TYPE_NUMBER</code>
     *
    @SuppressWarnings("unchecked")
    public String getSortType(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the data type for the list. This explicit value will override any column data type if set. If it is not set
    the data type specific to the sort column is used for sorting.
     * @param DATATYPE data type for this column's data; ; valid types include: jsx3.gui.Matrix.Column.TYPE_TEXT and jsx3.gui.Matrix.Column.TYPE_NUMBER
     */
    public void setSortType(String DATATYPE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSortType(").appendData(DATATYPE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the direction (jsx3.gui.Matrix.SORT_ASCENDING or jsx3.gui.Matrix.SORT_DESCENDING) for the sorted column; if no direction specified, ascending is returned
     * @return one of: jsx3.gui.Matrix.SORT_ASCENDING or jsx3.gui.Matrix.SORT_DESCENDING
     *
    @SuppressWarnings("unchecked")
    public String getSortDirection(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the direction (ascending or descending) for the sorted column.
     * @param intSortDir one of: jsx3.gui.Matrix.SORT_ASCENDING or jsx3.gui.Matrix.SORT_DESCENDING
     */
    public void setSortDirection(String intSortDir)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSortDirection(").appendData(intSortDir).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether the list will render with sortable columns. If null or jsx3.Boolean.TRUE, the instance is sortable.
     *
    @SuppressWarnings("unchecked")
    public int getCanSort(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether the list will render with sortable columns.
     * @param SORT one of <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     */
    public void setCanSort(int SORT)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCanSort(").appendData(SORT).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Instance override
     * @param objChild the child to adopt
     * @param bRepaint if <code>true</code> or <code>null</code>, the object being adopted will be added to
    the parent's view via the parent's <code>paintChild()</code> method.
    This parameter is made available for those situations where a loop is executing and multiple
    objects are being adopted.  As view operations are the most CPU intensive, passing <code>false</code>
    while looping through a collection of child objects to adopt will improve performance. After the
    last child is adopted, simply call <code>repaint()</code> on the parent to immediately synchronize the view.
     * @param bForce if true, the adoption is forced, even if the parent/child don't accept such adoptions (<code>onSetChild()</code> and <code>onSetParent()</code> will still be called)
     */
    public void adoptChild(org.directwebremoting.proxy.jsx3.app.Model objChild, boolean bRepaint, boolean bForce)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("adoptChild(").appendData(objChild).appendScript(",")

        .appendData(bRepaint).appendScript(",")

        .appendData(bForce).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Assigns objMoveChild as the previousSibling of objPrecedeChild
     * @param objMoveChild the one being moved
     * @param objPrecedeChild the one to insert before
     * @param bRepaint if <code>false</code> the repaint will be suppressed
     */
    public void insertBefore(org.directwebremoting.proxy.jsx3.app.Model objMoveChild, org.directwebremoting.proxy.jsx3.app.Model objPrecedeChild, boolean bRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("insertBefore(").appendData(objMoveChild).appendScript(",")

        .appendData(objPrecedeChild).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether the column children can be reordered via user interaction. If no value is supplied
    the isntance will allow child columns to be reordered.
     * @return one of: jsx3.Boolean.TRUE or jsx3.Boolean.FALSE
     *
    @SuppressWarnings("unchecked")
    public int getCanReorder(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether the columns in the list can be re-ordered via user interaction with the VIEW
     * @param REORDER one of: jsx3.Boolean.TRUE or jsx3.Boolean.FALSE
     */
    public void setCanReorder(int REORDER)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCanReorder(").appendData(REORDER).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Applies focus to the on-screen row that corresponds to the element in the CDF source document identified by
    strCdfId. Note that since only cells can receive focus, this method will apply focus to the
    first cell child in the row.
     * @param strCdfId jsxid property for CDF record
     */
    public void focusRowById(String strCdfId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("focusRowById(").appendData(strCdfId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Applies focus to the on-screen cell that corresponds to the intersection of the element in the CDF source
    document identified by strCdfId, and the first column mapped to strAttName.
     * @param strCdfId jsxid property for CDF record
     * @param strAttName attribute name on the CDF record. For example, <code>jsxtext</code>
     */
    public void focusCellById(String strCdfId, String strAttName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("focusCellById(").appendData(strCdfId).appendScript(",")

        .appendData(strAttName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Applies focus to the on-screen cell that corresponds to the intersection of
    the element in the CDF source document identified by strCdfId, and the cell at the given index.
     * @param strCdfId jsxid property for CDF record
     * @param intCellIndex zero-based index of cell (on-screen).
     */
    public void focusCellByIndex(String strCdfId, int intCellIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("focusCellByIndex(").appendData(strCdfId).appendScript(",")

        .appendData(intCellIndex).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS string to apply to a Row/Cell when it has focus
     * @param strDefault The default value to use if null (Matrix.FOCUS_STYLE)
     *
    @SuppressWarnings("unchecked")
    public String getFocusStyle(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS string to apply to a Row/Cell when it has focus. NOTE: Passing
    styles that affect position, left, top, width, height, border, background-image, padding, and margin
    (those reserved by the class) can have undesired effects.
     * @param strCSS Valid CSS. For example: font-weight:bold;color:orange;
     */
    public void setFocusStyle(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFocusStyle(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes the focus style from whichever cell is designated to have focus context. Once focus context
    is applied to the active cell in a matrix, the focus style will continue to be applied to
    the active cell until another cell is set as the active cell or the Matrix is repainted via
    a call to repaint or repaintData.
     * @param strId 
     */
    public void resetFocusContext(String strId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("resetFocusContext(").appendData(strId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Evaluates the JavaScript code in the jsxexecute attribute of one CDF record of this list.
     * @param strRecordId the jsxid of the CDF record to execute.
     */
    public void executeRecord(String strRecordId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("executeRecord(").appendData(strRecordId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS string to apply to a Row/Cell when it has focus
     * @param strDefault The default value to use if null (Matrix.SELECTION_BG)
     *
    @SuppressWarnings("unchecked")
    public String getSelectionBG(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the URL for the image to use (as the repeating background image) to denote selection.
     * @param strURL 
     */
    public void setSelectionBG(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSelectionBG(").appendData(strURL).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the collection of selected records.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.List getSelectedNodes()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getSelectedNodes().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.List> ctor = org.directwebremoting.proxy.jsx3.util.List.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.List.class.getName());
        }
    }

    /*
     * Returns the jsxid(s) for the selected record(s). Equivalent to this.getValue() except that the return value is always an Array.
     * @return JavaScript array of stings
     *
    @SuppressWarnings("unchecked")
    public Object[] getSelectedIds(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Selects a CDF record of this list. The item will be highlighted in the view and the CDF data will be updated
    accordingly. If this list is a multi-select list then this selection will be added to any previous selection.
     * @param strRecordId the jsxid of the record to select.
     */
    public void selectRecord(String strRecordId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("selectRecord(").appendData(strRecordId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Deselects a CDF record within the Matrix. Both the view and the data model (CDF) will be updated
     * @param strRecordId the jsxid of the record to deselect.
     */
    public void deselectRecord(String strRecordId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("deselectRecord(").appendData(strRecordId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Deselects all selected CDF records.
     */
    public void deselectAllRecords()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("deselectAllRecords(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns an object array of name/value pairs representing the current auto row session. When the session is committed, this
    object will be converted into a CDF Record for the instance.
     *
    @SuppressWarnings("unchecked")
    public Object getAutoRowSession(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Commits any active autorow session.
     * @param objEvent If passed, Allows Model Event to fire.
     * @param intCellIndex Focus will be applied to the autorow cell at this index (zero-based)
     */
    public void commitAutoRowSession(org.directwebremoting.proxy.jsx3.gui.Event objEvent, int intCellIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("commitAutoRowSession(").appendData(objEvent).appendScript(",")

        .appendData(intCellIndex).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Toggles the open/closed state for a node in the Matrix
     * @param strRecordId the 'jsxid' attribute on the given CDF record to toggle
     * @param bOpen if null, the open state will be toggled
     */
    public void toggleItem(String strRecordId, boolean bOpen)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("toggleItem(").appendData(strRecordId).appendScript(",")

        .appendData(bOpen).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Reveals a record by toggling parent nodes open (if rendering hierarcally) and scrolling the record into view.
     * @param strRecordId the id of the record to reveal
     */
    public void revealRecord(String strRecordId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("revealRecord(").appendData(strRecordId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether or not this column can be resized by the user. If not set, the column will be assumed resizable
     *
    @SuppressWarnings("unchecked")
    public int getResizable(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not this column can be resized by the user. If not set, the column will be assumed resizable. Note that if the parent Matrix
    is set as NOT resizable, this setting is ignored and no child columns can be resized
     * @param RESIZE 
     */
    public void setResizable(int RESIZE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setResizable(").appendData(RESIZE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether or not an 'auto append' row will be rendered, allowing the user to automatically add new rows to the instance.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getAutoRow(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not an 'auto append' row will be rendered, allowing the user to automatically add new rows to the instance. Note
    that if the rendering model is hierarchical or the paging model is jsx3.gui.Matrix.PAGING_PAGED, the auto row
    feature is disabled.  The CSS style for the auto row (a TR element) can be modified via the XSL Parameters palette, via the XSL
    parameter, jsx_autorow_style
     * @param intBoolean jsx3.Boolean.TRUE if the column widths should be adjusted to fully fit within the viewport
     */
    public void setAutoRow(int intBoolean)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAutoRow(").appendData(intBoolean).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the HTML element that represents the intersection of the row identified
    by strCdfId and the first column mapped to the named CDF attribute, strAttName.
     * @param strCdfId jsxid property for CDF record
     * @param strAttName attribute name on the CDF record. For example, <code>jsxtext</code>
     *
    @SuppressWarnings("unchecked")
    public String getContentElement(String strCdfId, String strAttName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Removes the XML source document stored under the XML ID of this object from the server cache.
     * @param objServer the server owning the cache to modify. This is a required argument only if
    <code>this.getServer()</code> does not returns a server instance.
     */
    public void resetXmlCacheData(org.directwebremoting.proxy.jsx3.app.Server objServer)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("resetXmlCacheData(").appendData(objServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLId(\"" + strXMLId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /*
     * Updates the view of this object by calling paint() and replacing the current view with the
    returned HTML. This method has no effect if this object is not currently displayed.
     * @return the result of calling <code>paint()</code> or <code>null</code> if this object is not displayed.
     *
    @SuppressWarnings("unchecked")
    public String repaint(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the XML string of this object. Setting this value to the string serialization of an XML document is one
    way of specifying the source XML document of this object.
     * @param strXML <code>null</code> or a well-formed serialized XML element.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable setXMLString(String strXML)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLString(\"" + strXML + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
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
        ProxyHelper child = getProxyHelper().getChildHelper("setXMLURL(\"" + strXMLURL + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /*
     * Returns an array of all jsxid attributes in the source CDF in the order they would appear if painted on-screen
     *
    @SuppressWarnings("unchecked")
    public Object[] getSortedIds(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the selection model. If no selection type is specified, the instance will employ single row selection (SELECTION_ROW)
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getSelectionModel(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the selection model
     * @param intType one of Matrix: .SELECTION_UNSELECTABLE, .SELECTION_ROW, .SELECTION_MULTI_ROW
     */
    public void setSelectionModel(int intType)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSelectionModel(").appendData(intType).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the row height
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getRowHeight(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the on-screen row height. If row height is null, the default row height will be used (Matrix.DEFAULT_ROW_HEIGHT).
    If row height is 0, the row height is flexible and the row's height will expand to fit the content.
     * @param intHeight height in pixels
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
    Typically property updates that affect the browser-specific box model (such as padding) are repainted
    immediately to keep the box model abstraction in synch with the native view. However, the repaint can be
    suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
     */
    public void setRowHeight(int intHeight, boolean bSuppressRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRowHeight(").appendData(intHeight).appendScript(",")

        .appendData(bSuppressRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the number of rows each panel should contain.  If null, the default value will be used: jsx3.gui.Matrix.DEFAULT_ROWS_PER_PANEL
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getRowsPerPanel(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the number of rows each panel should contain.
     * @param intCount 
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
     */
    public void setRowsPerPanel(int intCount, boolean bSuppressRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRowsPerPanel(").appendData(intCount).appendScript(",")

        .appendData(bSuppressRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Sets the number of panels that are allowed in the queue waiting to be painted. If null, the default value will be used: jsx3.gui.Matrix.DEFAULT_PANEL_QUEUE_SIZE
    Note that this is different from the number of painted panels allowed on screen (e.g., getPanelPoolSize()).
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getPanelQueueSize(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the number of panels that are allowed in the queue waiting to be painted. Can be tuned up or down to optimize performance given the amount of data, connection speed, etc
     * @param intCount 
     */
    public void setPanelQueueSize(int intCount)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPanelQueueSize(").appendData(intCount).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the the number of milliseconds to wait before checking for inactive panels to garbage collect.  If null, the default value will be used: jsx3.gui.Matrix.DEFAULT_REAPER_INTERVAL
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getReaperInterval(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the the number of milliseconds to wait before checking for inactive panels to garbage collect.
     * @param intInterval number of milliseconds
     */
    public void setReaperInterval(int intInterval)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setReaperInterval(").appendData(intInterval).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the number panels (a panel contains a collection of rows--getRowsPerPanel()) that should be part of the pool.  If a panel count greater
    than this value exists, the panels furthest away (as calculated by the scroll position) from the active panel will be destroyed. If this value is null,
    the value defined by the constant, Matrix.DEFAULT_PANEL_POOL_COUNT, will be used.
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getPanelPoolSize(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the number panels (a panel contains a collection of rows--getRowsPerPanel()) that should be part of the pool.
     * @param intCount 
     */
    public void setPanelPoolSize(int intCount)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPanelPoolSize(").appendData(intCount).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns how data should be painted on-screen.  If no value is specified, Matrix.PAGING_OFF will be applied. Note that the rendering model limits the available paging models:

        Matrix.PAGING_OFF: Paint everthing to screen at once (container and data) (rendering model: all)
        
    Matrix.PAGING_2PASS: Paint outer container and then perform a second pass to paint the data.  (rendering model: deep, shallow)
        
    Matrix.PAGING_CHUNKED: Paint outer container and then perform repeated paints until all data has been painted, regardless of scroll position.  (rendering model: deep, shallow)
        
    Matrix.PAGING_PAGED: Paint outer container. Paint First and last panels during second pass.  Paint relevant panels when user scrolls to a given position. Discard excess panels. (rendering model: deep, shallow)
        
    Matrix.PAGING_STEPPED: Paint root nodes and any open descendants. Paint others as they are toggled open. (rendering model: hierarchical)
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getPagingModel(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets how data should be painted on-screen.  If no value is specified, Matrix.PAGING_OFF will be applied.
     * @param intModel one of: Matrix. PAGING_OFF, PAGING_2PASS, PAGING_CHUNKED, PAGING_PAGED, PAGING_STEPPED
     */
    public void setPagingModel(int intModel)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setPagingModel(").appendData(intModel).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the height of the header row in pixels. If this value is not set (null), the list will render with
    the default value of jsx3.gui.Matrix.DEFAULT_HEADER_HEIGHT.
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getHeaderHeight(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the height of the header row in pixels. Set to zero (0) to hide the header row and only render the body rows.
     * @param intHeight 
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
    Typically property updates that affect the browser-specific box model (such as height) are repainted
    immediately to keep the box model abstraction in sync with the native view. However, the repaint can be
    suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
     */
    public void setHeaderHeight(int intHeight, boolean bSuppressRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHeaderHeight(").appendData(intHeight).appendScript(",")

        .appendData(bSuppressRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the info label to display when scrolling a paged instance, in order to show the scroll position.
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public int getScrollInfoLabel(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the standard info label to display when scrolling to show the scroll position.  If no label is supplied
    an appropriate localized value will be used. Set to an empty string to suppress any label from displaying.
     * @param strLabel valid HTML/Text.  Set to an empty string to suppress any label from displaying.
    <br/>Wildcards are as follows:
    <ul><li><b>{0}</b> The index position of the first visible on-screen row</li>
    <li><b>{1}</b> The index position of the last visible on-screen row</li>
    <li><b>{2}</b> Total count of all records in the list</li></ul>
     */
    public void setScrollInfoLabel(String strLabel)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setScrollInfoLabel(").appendData(strLabel).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the horizontal scroll position of the list.
     * @return a non-negative number
     *
    @SuppressWarnings("unchecked")
    public int getScrollLeft(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the horizontal scroll position.
     * @param intScrollLeft a non-negative number
     */
    public void setScrollLeft(int intScrollLeft)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setScrollLeft(").appendData(intScrollLeft).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the vertical scroll position.
     * @return a non-negative number
     *
    @SuppressWarnings("unchecked")
    public int getScrollTop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the vertical scroll position.
     * @param intScrollTop a non-negative number
     * @param objGUI 
     */
    public void setScrollTop(int intScrollTop, String objGUI)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setScrollTop(").appendData(intScrollTop).appendScript(",")

        .appendData(objGUI).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Updates the scroll height and scroll position of the vertical scrollbar. When a Matrix instance has
    a display property of none (or is contained by an ancestor with a display of none) and the Matrix is repainted (repaint/repaintData),
    the browser will misreport how large the content actually is.  When the Matrix is then restored the scrollbars will be disabled.
    By calling this method after the view has been restored (i.e., when display is set to block), the scrollbars will reflect the accurate height.
     */
    public void synchronizeVScroller()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("synchronizeVScroller(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether or not the column widths should be adjusted (decremented) such that all columns fit within the viewport.
    If null or jsx3.Boolean.FALSE, scale width will not be used and the column widths will render
    fully, displaying a horizontal scrollbar when necessary. In such a case, all wildcard columns (e.g., *) will be resolved to the value,
    jsx3.gui.Matrix.Column.DEFAULT_WIDTH.
     *
    @SuppressWarnings("unchecked")
    public int getScaleWidth(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not the column widths should be adjusted such that all columns visually display within the viewport.
    Defaults to jsx3.Boolean.FALSE if not set, meaning a horizontal scrollbar will appear if the aggregate column widths
    exceed the available width of the viewport.
     * @param intBoolean One of: <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     */
    public void setScaleWidth(int intBoolean)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setScaleWidth(").appendData(intBoolean).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * inserts DHTML (as string) into IE's on-screen DOM as a child of the object's on-screen VIEW
     * @param objJSX direct child whose generated VIEW will be directly inserted into the DOM to provide more efficient screen updates as repaint is costly for large applications
     * @param bGroup 
     */
    public void paintChild(org.directwebremoting.proxy.jsx3.app.Model objJSX, boolean bGroup)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("paintChild(").appendData(objJSX).appendScript(",")

        .appendData(bGroup).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns CSS property value(s) for a border (border: solid 1px #000000)
     *
    @SuppressWarnings("unchecked")
    public String getHeaderBorder(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets CSS property value(s) for a border on the header row (border: solid 1px #000000). Updates both model and view.
     * @param strCSS valid CSS property value for a border (border: solid 1px #000000)
     */
    public void setHeaderBorder(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHeaderBorder(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns CSS property value(s) for a border (border: solid 1px #000000)
     *
    @SuppressWarnings("unchecked")
    public String getBodyBorder(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets CSS property value(s) for a border (border: solid 1px #000000). Updates MODEL and VIEW (unless repaint is suppressed).
     * @param strCSS valid CSS property value for a border (border: solid 1px #000000)
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
    Typically property updates that affect the browser-specific box model (such as borders) are repainted
    immediately to keep the box model abstraction in synch with the native view. However, the repaint can be
    suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Block setBodyBorder(String strCSS, boolean bSuppressRepaint)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setBodyBorder(\"" + strCSS + "\", \"" + bSuppressRepaint + "\").");
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
     * Sets CSS property value(s) for a border (border: solid 1px #000000). Updates MODEL and VIEW (unless repaint is suppressed).
     * @param strCSS valid CSS property value for a border (border: solid 1px #000000)
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
    Typically property updates that affect the browser-specific box model (such as borders) are repainted
    immediately to keep the box model abstraction in synch with the native view. However, the repaint can be
    suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
     * @param returnType The expected return type
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public <T> T setBodyBorder(String strCSS, boolean bSuppressRepaint, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setBodyBorder(\"" + strCSS + "\", \"" + bSuppressRepaint + "\").");
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
     * Returns an array of selected values (or empty array) if the selection model is Matrix.SELECTION_MULTI_ROW. Returns a string (or null)
    for the other selection models
     *
    @SuppressWarnings("unchecked")
    public String getValue(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * 
     * @return <code>jsx3.gui.Form.STATEINVALID</code> or <code>jsx3.gui.Form.STATEVALID</code>.
     *
    @SuppressWarnings("unchecked")
    public int doValidate(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the rendering model (how rows will be painted on-screen). If not set, the instance will render deep, meaning all descendants
    of the rendering context will be painted on-screen.
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public String getRenderingModel(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the rendering model (how rows will be painted on-screen).
     * @param MODEL one of: shallow, deep, or hierarchical
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
     */
    public void setRenderingModel(String MODEL, boolean bSuppressRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRenderingModel(").appendData(MODEL).appendScript(",")

        .appendData(bSuppressRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the jsxid of the CDF record that will serve as the origin when rendering the data on-screen. If not set, the
    id, jsxroot, (which is the id for the root node, <data>) will be used.
     * @param strDefault The default value to use if null
     *
    @SuppressWarnings("unchecked")
    public String getRenderingContext(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the jsxid of the CDF record that will serve as the origin when rendering the data on-screen.
     * @param strJsxId jsxid property for the CDF record to use as the contextual root when rendering data on-screen.
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
     */
    public void setRenderingContext(String strJsxId, boolean bSuppressRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRenderingContext(").appendData(strJsxId).appendScript(",")

        .appendData(bSuppressRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether or not to supress display of the horizontal scrollbar. When not set, the scrollbar will display as needed.
     * @param strDefault The default value to use if null
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getSuppressHScroller(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not to supress display of the horizontal scrollbar. Updates both model and view
     * @param intTrueFalse <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     */
    public void setSuppressHScroller(int intTrueFalse)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSuppressHScroller(").appendData(intTrueFalse).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether or not to supress display of the vertical scrollbar. When not set, the scrollbar will display as needed.
     * @param strDefault The default value to use if null
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getSuppressVScroller(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not to supress display of the vertical scrollbar. Updates both model and view.
     * @param intTrueFalse <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
    Typically property updates that affect the browser-specific box model (such as rendering the vertical scrollbar) are repainted
    immediately to keep the box model abstraction in synch with the native view. However, the repaint can be
    suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
     */
    public void setSuppressVScroller(int intTrueFalse, boolean bSuppressRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSuppressVScroller(").appendData(intTrueFalse).appendScript(",")

        .appendData(bSuppressRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the zero-based index of the on-screen column(s), to the left of which will be fixed and cannot be reordered.  For example, if this value
    is set to 1, the first column can never be reordered and will always remain the first column.  If this value is set to 2,
    the first two columns will be fixed.  Setting this value to 0 is effectively the same as setting it to null
     * @param strDefault The default value to use if null
     * @return positive integer
     *
    @SuppressWarnings("unchecked")
    public int getFixedColumnIndex(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the zero-based index of the on-screen column(s), to the left of which will be fixed and cannot be reordered.
     * @param intIndex positive integer
     */
    public void setFixedColumnIndex(int intIndex)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setFixedColumnIndex(").appendData(intIndex).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether or not to render the navigation controls that are applied to the first column when rendering model is hierarchical.  When not set the navigators are rendered.
     * @param strDefault The default value to use if null
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getRenderNavigators(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not to render the navigation controls on the first column when being rendered in hierarchical mode.
     * @param intTrueFalse <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
    Typically property updates that affect the browser-specific box model (such as rendering the navigational controls) are repainted
    immediately to keep the box model abstraction in synch with the native view. However, the repaint can be
    suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
     */
    public void setRenderNavigators(int intTrueFalse, boolean bSuppressRepaint)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRenderNavigators(").appendData(intTrueFalse).appendScript(",")

        .appendData(bSuppressRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the icon to use for those CDF records that do not explicitly specify an icon via the jsximg attribute
     * @param strDefault The default value to use if null
     * @return URL for icon to use. If null, <code>jsx3.gui.Matrix.ICON</code> will be applied when rendered.
     *
    @SuppressWarnings("unchecked")
    public String getIcon(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the icon to use for those CDF records that do not explicitly specify an icon via the jsximg attribute
     * @param strURL URL for icon to use
     */
    public void setIcon(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setIcon(").appendData(strURL).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the icon to use when the given tree node is in an open state.
     * @param strDefault The default value to use if null
     * @return URL for icon. If null, <code>jsx3.gui.Matrix.ICON_MINUS</code> will be applied when rendered.
     *
    @SuppressWarnings("unchecked")
    public String getIconMinus(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the icon to use when the given tree node is in an open state.
     * @param strURL URL (preferably relative)
     */
    public void setIconMinus(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setIconMinus(").appendData(strURL).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the icon to use when the given tree node is in a closed state.
     * @param strDefault The default value to use if null
     * @return URL for icon to use. If null, <code>jsx3.gui.Matrix.ICON_PLUS</code> will be applied when rendered.
     *
    @SuppressWarnings("unchecked")
    public String getIconPlus(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the icon to use when the given tree node is in a closed state.
     * @param strURL URL (preferably relative)
     */
    public void setIconPlus(String strURL)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setIconPlus(").appendData(strURL).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
        ProxyHelper child = getProxyHelper().getChildHelper("deleteRecord(\"" + strRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("deleteRecord(\"" + strRecordId + "\", \"" + bRedraw + "\").");
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
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecordProperty(\"" + strRecordId + "\", \"" + strPropName + "\", \"" + strPropValue + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.CDF> ctor = org.directwebremoting.proxy.jsx3.xml.CDF.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.CDF.class.getName());
        }
    }

    /**
     * Updates the on-screen cell to reflect the value in the CDF document to which the cell is mapped.
     * @param strRecordId <code>jsxid</code> value for the record node (according to the CDF) corresponding to the on-screen row to update
     * @param objColumn Column instance to update. Any sibling Columns that map to the same named attribute as <b>objColumn</b>
    (e.g., <code>[objColumn].getPath()</code>) as well as all sibling Columns that are triggered by the named attribute
    (e.g., <code>[objColumn].getTriggers()</code>) will also be redrawn.
     * @param bSuppressTriggers if true, no other sibling Columns will be updated, even if they share a common path or designate the path as one of their triggers.
     */
    public void redrawCell(String strRecordId, org.directwebremoting.proxy.jsx3.gui.Matrix.Column objColumn, boolean bSuppressTriggers)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("redrawCell(").appendData(strRecordId).appendScript(",")

        .appendData(objColumn).appendScript(",")

        .appendData(bSuppressTriggers).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Updates the on-screen cell to reflect the value in the CDF document to which the cell is mapped.
     * @param strRecordId The <code>jsxid</code> value for the record node (according to the CDF) corresponding to the on-screen row to update
     * @param strAttName Named attribute on the CDF record. All Column children that map to this named attribute
    (e.g., <code>[objColumn].getPath()</code>) as well as all Column children that are triggered by the named attribute
    (e.g., <code>[objColumn].getTriggers()</code>) will be redrawn.
     */
    public void redrawMappedCells(String strRecordId, String strAttName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("redrawMappedCells(").appendData(strRecordId).appendScript(",")

        .appendData(strAttName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Matrix implementation.
     * @param strRecordId <code>jsxid</code> value for the record node (according to the CDF) to redraw
     * @param intAction <code>jsx3.xml.CDF.INSERT</code>, <code>jsx3.xml.CDF.INSERTBEFORE</code>, <code>jsx3.xml.CDF.DELETE</code>, or <code>jsx3.xml.CDF.UPDATE</code>.
     * @param bRecurse if != false, any necessary recursion for flattened inserts will be automatically handled
     */
    public void redrawRecord(String strRecordId, int intAction, boolean bRecurse)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("redrawRecord(").appendData(strRecordId).appendScript(",")

        .appendData(intAction).appendScript(",")

        .appendData(bRecurse).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the value of this matrix. Deselects all existing selections. Scrolls the first record into view.
     * @param strId jsxid attribute for the CDF record(s) to select
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Matrix setValue(String strId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets the value of this matrix. Deselects all existing selections. Scrolls the first record into view.
     * @param strId jsxid attribute for the CDF record(s) to select
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Matrix setValue(Object[] strId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
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
        ProxyHelper child = getProxyHelper().getChildHelper("doKeyBinding(\"" + fctCallback + "\", \"" + strKeys + "\").");
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

    /**
     * Resets the validation state of this control.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form doReset()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("doReset().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /*
     * Returns the background color of this control when it is disabled.
     * @return valid CSS property value, (i.e., red, #ff0000)
     *
    @SuppressWarnings("unchecked")
    public String getDisabledBackgroundColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the font color to use when this control is disabled.
     * @return valid CSS property value, (i.e., red, #ff0000)
     *
    @SuppressWarnings("unchecked")
    public String getDisabledColor(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the state for the form field control. If no enabled state is set, this method returns
    STATEENABLED.
     * @return <code>STATEDISABLED</code> or <code>STATEENABLED</code>.
     *
    @SuppressWarnings("unchecked")
    public int getEnabled(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the key binding that when keyed will fire the execute event for this control.
     * @return plus-delimited (e.g.,'+') key sequence such as ctrl+s or ctrl+shift+alt+h or shift+a, etc
     *
    @SuppressWarnings("unchecked")
    public String getKeyBinding(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether or not this control is required. If the required property has never been set, this method returns
    OPTIONAL.
     * @return <code>REQUIRED</code> or <code>OPTIONAL</code>.
     *
    @SuppressWarnings("unchecked")
    public int getRequired(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the validation state of this control. If the validationState property has never been set, this method returns
    STATEVALID.
     * @return <code>STATEINVALID</code> or <code>STATEVALID</code>.
     *
    @SuppressWarnings("unchecked")
    public int getValidationState(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the background color of this form control when it is disabled.
     * @param strColor valid CSS property value, (i.e., red, #ff0000)
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Form setDisabledBackgroundColor(String strColor)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setDisabledBackgroundColor(\"" + strColor + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setDisabledColor(\"" + strColor + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        script.appendData(getProxyHelper().getContext()).appendScript("setEnabled(").appendData(intEnabled).appendScript(",")

        .appendData(bRepaint).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setKeyBinding(\"" + strSequence + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setRequired(\"" + required + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setValidationState(\"" + intState + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Form> ctor = org.directwebremoting.proxy.jsx3.gui.Form.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Form.class.getName());
        }
    }

    /**
     * Resets the XML source document stored in the server cache under the XML ID of this object to an empty CDF
    document.
     */
    public void clearXmlData()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("clearXmlData(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether this object removes its XML and XSL source documents from the cache of its server when it
    is destroyed.
     * @return <code>CLEANUPRESOURCES</code> or <code>SHARERESOURCES</code>.
     *
    @SuppressWarnings("unchecked")
    public int getShareResources(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

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
        ProxyHelper child = getProxyHelper().getChildHelper("getXML().");
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
    public <T> T getXML(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXML().");
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
     * Returns the XML ID of this object.
     * @return the XML ID.
     *
    @SuppressWarnings("unchecked")
    public String getXMLId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the XML string of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXMLString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the list of XML transformers of this object.
     *
    @SuppressWarnings("unchecked")
    public Object[] getXMLTransformers(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the XML URL of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXMLURL(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the XSL ID of this object.
     *
    @SuppressWarnings("unchecked")
    public String getXSLId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns a map containing all the parameters to pass to the XSL stylesheet during transformation.
     *
    @SuppressWarnings("unchecked")
    public Object getXSLParams(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether the XML data source of this object is loaded asynchronously.
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int getXmlAsync(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether this object is bound to the XML document stored in the data cache.
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int getXmlBind(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

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
        script.appendData(getProxyHelper().getContext()).appendScript("onXmlBinding(").appendData(objEvent).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes a parameter from the list of parameters to pass to the XSL stylesheet during transformation.
     * @param strName the name of the XSL parameter to remove.
     * @return this object.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Cacheable removeXSLParam(String strName)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeXSLParam(\"" + strName + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("removeXSLParams().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        script.appendData(getProxyHelper().getContext()).appendScript("resetCacheData(").appendData(objServer).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setShareResources(\"" + intShare + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setSourceXML(\"" + objDoc + "\", \"" + objCache + "\").");
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
        ProxyHelper child = getProxyHelper().getChildHelper("setSourceXML(\"" + objDoc + "\", \"" + objCache + "\").");
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
        script.appendData(getProxyHelper().getContext()).appendScript("setXMLTransformers(").appendData(arrTrans).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setXSLParam(\"" + strName + "\", \"" + strValue + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("setXmlAsync(\"" + bAsync + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Cacheable> ctor = org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.Cacheable.class.getName());
        }
    }

    /*
     * Sets whether this object is bound to the XML document stored in the data cache. If this object is bound to the
    cache, then the onXmlBinding() method of this object is called any time the document stored in
    the cache under the XML Id of this object changes.
     * @param bBind 
     * @return <code>0</code> or <code>1</code>.
     *
    @SuppressWarnings("unchecked")
    public int setXmlBind( bBind, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

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
        ProxyHelper child = getProxyHelper().getChildHelper("adoptRecord(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("adoptRecord(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").");
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
        ProxyHelper child = getProxyHelper().getChildHelper("adoptRecordBefore(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("adoptRecordBefore(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").");
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
        script.appendData(getProxyHelper().getContext()).appendScript("convertProperties(").appendData(objProps).appendScript(",")

        .appendData(arrProps).appendScript(",")

        .appendData(bUnion).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
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
        script.appendData(getProxyHelper().getContext()).appendScript("deleteRecordProperty(").appendData(strRecordId).appendScript(",")

        .appendData(strPropName).appendScript(",")

        .appendData(bRedraw).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns an object containing the attributes of a particular CDF record as property/value pairs. The object returned by this
    method is a copy of the underlying data. Therefore, updates to this object will not affect the underlying data.

    The following two lines of code evaluate to the same value:

    objCDF.getRecord(strId).propName;
    objCDF.getRecordNode(strId).getAttribute("propName");
     * @param strRecordId the <code>jsxid</code> attribute of the data record to return.
     * @return the object representation of a CDF node or <code>null</code> if no such record found.
     *
    @SuppressWarnings("unchecked")
    public Object getRecord(String strRecordId, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

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
        ProxyHelper child = getProxyHelper().getChildHelper("getRecordNode(\"" + strRecordId + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("getRecordNode(\"" + strRecordId + "\").");
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
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecord(\"" + objRecord + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecord(\"" + objRecord + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").");
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
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecordBefore(\"" + objRecord + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
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
        ProxyHelper child = getProxyHelper().getChildHelper("insertRecordBefore(\"" + objRecord + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").");
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
        script.appendData(getProxyHelper().getContext()).appendScript("insertRecordNode(").appendData(objRecordNode).appendScript(",")

        .appendData(strParentRecordId).appendScript(",")

        .appendData(bRedraw).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Publishes a model event. This method both evaluates any registered event script for the given event type
    and publishes the event through the EventDispatcher interface. This method ensures that any
    registered event script is executed in isolation to prevent most side effects.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @param objContext JavaScript object array with name/value pairs that provide a local
    variable stack for the execution of the event script. This argument is also passed as the <code>context</code>
    property of the event object that is published through the <code>EventDispatcher</code> interface.
     * @return the result of evaluating the event script or <code>null</code> if not event script is registered
     *
    @SuppressWarnings("unchecked")
    public Object doEvent(String strType, Object objContext, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object supports programmatic drag, meanining it will allow any contained item to be
    dragged and dropped on another container supporting drop.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanDrag(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether this object can be the target of a drop event.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanDrop(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object can be moved around the screen (this is not the same as drag/drop).
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanMove(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns whether is object can be spyglassed.
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getCanSpy(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the event script registered for the given event type. This script could have been set by the
    setEvent() method or during component deserialization.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return the JavaScript event script
     *
    @SuppressWarnings("unchecked")
    public String getEvent(String strType, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the associative array containing all the registered event script of this object. This method returns
    the instance field itself and not a copy.
     * @return an associative array mapping event type to event script
     *
    @SuppressWarnings("unchecked")
    public Object getEvents(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the name of the jsx3.gui.Menu instance to display (as a context menu) when a user
    clicks on this object with the right button.
     *
    @SuppressWarnings("unchecked")
    public String getMenu(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns true if there is a event script registered for the given event type.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return the JavaScript event script
     *
    @SuppressWarnings("unchecked")
    public String hasEvent(String strType, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Registers a hot key with this JSX model node. All keydown events that bubble up to this object
    will be checked against the hot key. If an event matches, the callback function will execute and the event
    bubble will be canceled.

    If the four parameters vntKey, bShift, bControl, and bAlt
    match a previously registered hot key, the previous hot key is clobbered by the new one. Only one hot key callback
    function (the most recently registered) will be executed by a single keydown event.
     * @param vntCallback either a function, or the name of a method bound to this object.
    When a keydown event bubbles up to this object that matches the hot key created by this method, this function
    is called on this object. If this function returns <code>false</code> then this hot key will not cancel the
    key event. This parameter can also be an instance of <code>HotKey</code>, in which case all
    other parameters are ignored.
     * @param vntKey if this parameter is a String, the hot key matches that key (the keycode to match is
    determined by <code>HotKey.keyDownCharToCode()</code>). If it is an integer, the hot key will match that
    keycode value.
     * @param bShift if not <code>null</code> the shift key state of the keydown event must match this value
    to invoke the hot key.
     * @param bControl if not <code>null</code> the control key state of the keydown event must match this value
    to invoke the hot key.
     * @param bAlt if not <code>null</code> the alt key state of the keydown event must match this value
    to invoke the hot key.
     * @return the registered hot key.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.HotKey registerHotKey(String vntCallback, int vntKey, boolean bShift, boolean bControl, boolean bAlt)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("registerHotKey(\"" + vntCallback + "\", \"" + vntKey + "\", \"" + bShift + "\", \"" + bControl + "\", \"" + bAlt + "\").");
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

    /**
     * Removes an event script registered for the given model event type.
     * @param strType the event type, one of the model event types defined as static fields in this class
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvent(String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeEvent(\"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Removes all events scripts registered with this object.
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvents()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("removeEvents().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object supports programmatic drag, meanining it will allow any contained item to be dragged/dropped.
    Implementing classes can decide whether to consult this value or ignore it.
     * @param bDrag <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrag(int bDrag)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanDrag(\"" + bDrag + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether this object can be the target of a drop event. Implementing classes can decide whether to consult
    this value or ignore it.
     * @param bDrop <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrop(int bDrop)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanDrop(\"" + bDrop + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object can be moved around the screen (this is not the same as drag/drop). Implementing classes
    can decide whether to consult this value or ignore it.
     * @param bMovable <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanMove(int bMovable)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanMove(\"" + bMovable + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets whether is object can be spyglassed. Implementing classes can decide whether to consult
    this value or ignore it.
     * @param bSpy <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setCanSpy(int bSpy)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setCanSpy(\"" + bSpy + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Programmatically sets an event of this instance. Sets the script that will execute when this object publishes
    a model event. The script value will be saved in the serialization file of a component. Not all classes that
    implement this interface will publish events of every type. Consult the documentation of a class for a
    description of the events it publishes.

    For programmatic registering of event handlers when persistence in a serialization file is not required,
    consider using jsx3.util.EventDispatcher.subscribe() instead of this method. Whenever a model
    event is published, it is published using the EventDispatcher interface as well as by executing
    any registered event script.
     * @param strScript the actual JavaScript code that will execute when the given event is published.
    For example: <code>obj.setEvent("alert('hello.');", jsx3.gui.Interactive.EXECUTE);</code>
     * @param strType the event type. Must be one of the model event types defined as static fields in this class
     * @return reference to this
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setEvent(String strScript, String strType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setEvent(\"" + strScript + "\", \"" + strType + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets the name of the jsx3.gui.Menu instance to display when a user
    clicks on this object with the right button. The name is a pointer by-name to a JSX object in the same server.
     * @param strMenu name or id (jsxname or jsxid) of the context menu
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Interactive setMenu(String strMenu)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("setMenu(\"" + strMenu + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
        }
    }

    /**
     * Sets the CSS definition to apply to an HTML element when a spyglass is shown for that element
     * @param strCSS valid CSS. For example, text-decoration:underline;color:red;
     */
    public void setSpyStyles(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSpyStyles(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * called by 'window.setTimeout()' to display the spyglass hover for a given object;
     * @param strHTML HTML/text to display in the spyglass; as the spyglass does not define a height/width, this content will
         have improved layout if it specifies a preferred width in its in-line-style or referenced-css rule.
     * @param intLeft use an integer to specify an on-screen location; otherwise, use a <code>jsx3.gui.Event</code> instance to have the system automatically calculate the x/y position.
     * @param intTop use an integer if <code>intLeft</code> also uses an integer. Otherwise, use null.
     */
    public void showSpy(String strHTML, int intLeft, int intTop)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("showSpy(").appendData(strHTML).appendScript(",")

        .appendData(intLeft).appendScript(",")

        .appendData(intTop).appendScript(");");
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

    /**
     * @author Joe Walker [joe at getahead dot org]
     * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
     */
    public interface BlockMask extends org.directwebremoting.proxy.jsx3.gui.Matrix.EditMask
    {

    }

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

    /**
     * @author Joe Walker [joe at getahead dot org]
     * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
     */
    public class Column extends org.directwebremoting.proxy.jsx3.gui.Block
    {
        /**
         * All reverse ajax proxies need context to work from
         * @param helper The store of the context for the current action
         */
        public Column(ProxyHelper helper)
        {
            super(helper);
        }

        /**
         * instance initializer
         * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
         */
        public Column(String strName)
        {
            super((ProxyHelper) null);
        }

        /**
         * 100
         */
        public static final int DEFAULT_WIDTH = 100;

        /**
         * text (default)
         */
        public static final String TYPE_TEXT = "text";

        /**
         * number
         */
        public static final String TYPE_NUMBER = "number";

        /**
         * top
         */
        public static final String DEFAULT_VALIGN = "top";

        /*
         * Gets the user-defined XSL template (xsl:template) that will override the defualt template defined by Column.TEMPLATES.default.
         * @param strDefault xsl:template
         *
        @SuppressWarnings("unchecked")
        public String getValueTemplate(String strDefault, Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the user-defined XSL template (xsl:template) that will override the defualt template defined by Column.DEFAULT_VALUE_TEMPLATE.
        The path wildcard is as follows:

            
              {0} this will be replaced with the result of [instance].getPath(). For example: jsxtext
         * @param TEMPLATE Either a valid xsl:template or a named system template, including: @default, @empty, @unescape, and @image
         */
        public void setValueTemplate(String TEMPLATE)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setValueTemplate(").appendData(TEMPLATE).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Gets whether or not this column can be resized by the user. If not set, the column will be assumed resizable
         */
        @SuppressWarnings("unchecked")
        public Boolean getResizable()
        {
            ProxyHelper child = getProxyHelper().getChildHelper("getResizable().");
            try
            {
                Constructor<Boolean> ctor = Boolean.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + Boolean.class.getName());
            }
        }

        /**
         * Sets whether or not this column can be resized by the user. If not set, the column will be assumed resizable. Note that if the parent Matrix
        is set as NOT resizable, this setting is ignored and no child columns can be resized. Note that the header row is immediately repainted to reflect the change.
         * @param RESIZE 
         */
        public void setResizable(Boolean RESIZE)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setResizable(").appendData(RESIZE).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns one or more named attributes. When one of these attributes is updated by another column's edit mask iterface,
        this column will called to repaint to reflect the updated value
         * @return Comma-delimited attribute list
         *
        @SuppressWarnings("unchecked")
        public String getTriggers(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets one or more named attributes. When one of these attributes is updated by another column's edit mask iterface,
        this column will called to repaint to reflect the updated value
         * @param strTriggers Comma-delimited attribute list. For example: <code>jsxtext, ssn, phone</code>.
         */
        public void setTriggers(String strTriggers)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setTriggers(").appendData(strTriggers).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the selection path for this column of data. Returns 'jsxid' if no path specified
         * @return selection path
         *
        @SuppressWarnings("unchecked")
        public String getPath(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the selection path for this column of data.
         * @param strPath The name of the attribute For example <code>jsxtext</code>
         * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
        Typically property updates that affect the XSLT (such as path) require that the XSLT be regenerated.
        However, the repaint can be suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
         */
        public void setPath(String strPath, boolean bSuppressRepaint)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setPath(").appendData(strPath).appendScript(",")

            .appendData(bSuppressRepaint).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the CDF attribute to use to sort on this column. If the sort path has not been set explicitly, this method
        returns the value of this.getPath(). The data source of the matrix containing this column is
        sorted on this attribute when the matrix is sorted on this column.
         *
        @SuppressWarnings("unchecked")
        public String getSortPath(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the CDF attribute to use to sort on this column.
         * @param strPath 
         */
        public void setSortPath(String strPath)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setSortPath(").appendData(strPath).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the data type for this column of data (affects sorting if this column is used for sorting the data); valid types include: jsx3.gui.Matrix.Column.TYPE_TEXT and jsx3.gui.Matrix.Column.TYPE_NUMBER
         * @return data type for this column's data
         *
        @SuppressWarnings("unchecked")
        public String getDataType(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the data type for this column of data (affects sorting if this column is used for sorting the data); returns ref to self
         * @param DATATYPE one of: jsx3.gui.Matrix.Column.TYPE_TEXT, jsx3.gui.Matrix.Column.TYPE_NUMBER
         */
        public void setDataType(String DATATYPE)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setDataType(").appendData(DATATYPE).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the data type for this column of data (affects sorting if this column is used for sorting the data).
         * @return one of: jsx3.gui.Matrix.Column.TYPE_TEXT, jsx3.gui.Matrix.Column.TYPE_NUMBER
         *
        @SuppressWarnings("unchecked")
        public String getSortDataType(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the data type for this column of data (affects sorting if this column is used for sorting the data); returns ref to self
         * @param DATATYPE data type for this column's data. valid types include: jsx3.gui.Matrix.Column.TYPE_TEXT and jsx3.gui.Matrix.Column.TYPE_NUMBER
         */
        public void setSortDataType(String DATATYPE)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setSortDataType(").appendData(DATATYPE).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Returns whether the parent list/grid can be sorted on this column. If no value is provided, the column is assumed sortable unless
        the parent control explicitly specifies that no column should sort.
         */
        @SuppressWarnings("unchecked")
        public Boolean getCanSort()
        {
            ProxyHelper child = getProxyHelper().getChildHelper("getCanSort().");
            try
            {
                Constructor<Boolean> ctor = Boolean.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + Boolean.class.getName());
            }
        }

        /**
         * Sets whether the parnet list/grid can be sorted on this column. Note that the header row is immediately repainted to reflect the change.
         * @param SORT 
         */
        public void setCanSort(Boolean SORT)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCanSort(").appendData(SORT).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Sets the identifier for which of the default column formatters should be implemented. A function literal can also be passed.
         * @param handler including @unescape, @lookup, @message,  @datetime, @date, @time, and @number. For example: <code>@unescape</code>.
        <p><b>- or -</b></p>
        Function literal with the signature, <code>function(element,cdfkey, matrix, column, rownumber,server)</code>. For example:
        <p><pre>
        function(element, cdfkey, matrix, column, rownumber, server) {
        var mf = new jsx3.util.MessageFormat("{0,number,currency}");
        element.innerHTML = mf.format(element.innerHTML);
        };
        </pre></p>
         */
        public void setFormatHandler(String handler)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setFormatHandler(").appendData(handler).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Sets the identifier for which of the default column formatters should be implemented. A function literal can also be passed.
         * @param handler including @unescape, @lookup, @message,  @datetime, @date, @time, and @number. For example: <code>@unescape</code>.
        <p><b>- or -</b></p>
        Function literal with the signature, <code>function(element,cdfkey, matrix, column, rownumber,server)</code>. For example:
        <p><pre>
        function(element, cdfkey, matrix, column, rownumber, server) {
        var mf = new jsx3.util.MessageFormat("{0,number,currency}");
        element.innerHTML = mf.format(element.innerHTML);
        };
        </pre></p>
         */
        public void setFormatHandler(org.directwebremoting.proxy.CodeBlock handler)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setFormatHandler(").appendData(handler).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Sets the identifier for which of the default column formatters should be implemented. A function literal can also be passed.
         * @param handler including @unescape, @lookup, @message,  @datetime, @date, @time, and @number. For example: <code>@unescape</code>.
        <p><b>- or -</b></p>
        Function literal with the signature, <code>function(element,cdfkey, matrix, column, rownumber,server)</code>. For example:
        <p><pre>
        function(element, cdfkey, matrix, column, rownumber, server) {
        var mf = new jsx3.util.MessageFormat("{0,number,currency}");
        element.innerHTML = mf.format(element.innerHTML);
        };
        </pre></p>
         */
        public void setFormatHandler(org.directwebremoting.proxy.jsx3.gui.Matrix.ColumnFormat handler)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setFormatHandler(").appendData(handler).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Gets the named object that will handle the reformatting of a given column's data cells. This object should
        implment the interface, jsx3.gui.Matrix.ColumnFormat, or adhere to its APIs.
        Can also return the function literal
         * @return named object or function literal
         *
        @SuppressWarnings("unchecked")
        public String getFormatHandler(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns the DHTML, used for this object's on-screen VIEW
         * @return DHTML
         *
        @SuppressWarnings("unchecked")
        public String paint(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Updates the view of this object by calling paint() and replacing the current view with the
        returned HTML. This method has no effect if this object is not currently displayed.
         * @return the result of calling <code>paint()</code> or <code>null</code> if this object is not displayed.
         *
        @SuppressWarnings("unchecked")
        public String repaint(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the Width on the column.  Immediately updates MODEL and VIEW. Note that if a wilcard is used without Scale Width, it will be replaced
        with the value of jsx3.gui.Matrix.Column.DEFAULT_WIDTH
         * @param vntWidth Can be a valid number (pixel units are implied), a Percent, or a Wildcard.  For example: 100, 25%, *
         */
        public org.directwebremoting.proxy.jsx3.gui.Matrix.Column setWidth(String vntWidth)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setWidth(").appendData(vntWidth).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
            return this;
        }

        /**
         * Sets the Width on the column.  Immediately updates MODEL and VIEW. Note that if a wilcard is used without Scale Width, it will be replaced
        with the value of jsx3.gui.Matrix.Column.DEFAULT_WIDTH
         * @param vntWidth Can be a valid number (pixel units are implied), a Percent, or a Wildcard.  For example: 100, 25%, *
         */
        public org.directwebremoting.proxy.jsx3.gui.Matrix.Column setWidth(int vntWidth)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setWidth(").appendData(vntWidth).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
            return this;
        }

        /**
         * Sets the display for the object. Note that although the framework uses CSS to apply this setting,
        the actual values that get set are determined by the system. Only those values listed for the parameter,
        DISPLAY, are supported as inputs to this function. Calling this method will cause the underlying XSLT
        for the Matrix parent to be regenerated.
         * @param DISPLAY one of <code>jsx3.gui.Block.DISPLAYNONE</code> and <code>jsx3.gui.Block.DISPLAYBLOCK</code>
         * @param bRepaint if <code>true</code>, the view of this object is immediately updated.
         * @return this object
         */
        public org.directwebremoting.proxy.jsx3.gui.Matrix.Column setDisplay(String DISPLAY, boolean bRepaint)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setDisplay(").appendData(DISPLAY).appendScript(",")

            .appendData(bRepaint).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
            return this;
        }

        /*
         * Returns the zero-based index for ths column in relation to its siblings.  This is different from getChildIndex in that
        it corresponds to the position of this column as rendered on-screen, meaning if a child of a lesser index is not
        displayed (e.g., display = none), the value returned from this method will be less than what would be returned by getChildIndex.
        Returns null if this object is not displayed.
         *
        @SuppressWarnings("unchecked")
        public int getDisplayIndex(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns CSS property value for the data cell background-color.
         *
        @SuppressWarnings("unchecked")
        public String getCellBackgroundColor(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets CSS property value for the data cell background-color. Call repaint on the parent instance to update the view.
         * @param strColor valid CSS property value, (e.g., red, #ff0000, rgb(255,0,0))
         */
        public void setCellBackgroundColor(String strColor)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellBackgroundColor(").appendData(strColor).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns CSS property value for the data cell border.
         *
        @SuppressWarnings("unchecked")
        public String getCellBorder(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets CSS property value(s) for a border for the data cells. Updates MODEL and VIEW (unless repaint is suppressed).
         * @param strCSS valid CSS property value for border. For example: <code>solid 1px red;solid 0px;solid 0px;solid 1px white</code>
         * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
        Typically property updates that affect the browser-specific box model (such as borders) are repainted
        immediately to keep the box model abstraction in synch with the native view. However, the repaint can be
        suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
         */
        public void setCellBorder(String strCSS, boolean bSuppressRepaint)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellBorder(").appendData(strCSS).appendScript(",")

            .appendData(bSuppressRepaint).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns CSS property value for the data cell color.
         *
        @SuppressWarnings("unchecked")
        public String getCellColor(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets CSS property value for the data cell color. Call repaint on the parent instance to update the view.
         * @param strColor valid CSS property value, (e.g., red, #ffffff, rgb(255,0,0))
         */
        public void setCellColor(String strColor)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellColor(").appendData(strColor).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns CSS property value for the data cell cursor.
         *
        @SuppressWarnings("unchecked")
        public String getCellCursor(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets CSS property value for the data cell cursor. Call repaint on the parent instance to update the view.
         * @param strCursor CSS property value, (e.g., default, wait, col-resize)
         */
        public void setCellCursor(String strCursor)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellCursor(").appendData(strCursor).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the CSS property value for the data cell font-family.
         *
        @SuppressWarnings("unchecked")
        public String getCellFontName(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the CSS property value for the data cell font-family. Call repaint on the parent instance to update the view.
         * @param strFontName valid CSS font-family property value (e.g., Arial, Courier)
         */
        public void setCellFontName(String strFontName)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellFontName(").appendData(strFontName).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the CSS property value for the data cell font-size.
         *
        @SuppressWarnings("unchecked")
        public int getCellFontSize(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the CSS property value for the data cell font-size. Call repaint on the parent instance to update the view.
         * @param intPixelSize font-size (in pixels)
         */
        public void setCellFontSize(int intPixelSize)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellFontSize(").appendData(intPixelSize).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the CSS property value for the data cell font-weight.
         *
        @SuppressWarnings("unchecked")
        public String getCellFontWeight(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the CSS property value for the data cell font-weight. Call repaint on the parent instance to update the view.
         * @param FONTWEIGHT one of: <code>jsx3.gui.Block.FONTBOLD</code>, <code>jsx3.gui.Block.FONTNORMAL</code>
         */
        public void setCellFontWeight(String FONTWEIGHT)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellFontWeight(").appendData(FONTWEIGHT).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the CSS property value for the data cell padding.
         *
        @SuppressWarnings("unchecked")
        public String getCellPadding(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the CSS property value for the data cell padding. Updates MODEL and VIEW (unless repaint is suppressed).
         * @param strCSS valid CSS property value for padding. For example: <code>8 4 8 4</code>
         * @param bSuppressRepaint Pass <code>true</code> to stop the default repaint from occurring.
        Typically property updates that affect the browser-specific box model (such as padding) are repainted
        immediately to keep the box model abstraction in synch with the native view. However, the repaint can be
        suppressed to avoid unnecessary reparsing of the XSLT during repeated property updates.
         */
        public void setCellPadding(String strCSS, boolean bSuppressRepaint)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellPadding(").appendData(strCSS).appendScript(",")

            .appendData(bSuppressRepaint).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the CSS property value for the data cell text-align.
         *
        @SuppressWarnings("unchecked")
        public String getCellTextAlign(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the CSS property value for the data cell text-align. Call repaint on the parent instance to update the view.
         * @param ALIGN one of: <code>jsx3.gui.Block.ALIGNLEFT</code>, <code>jsx3.gui.Block.ALIGNRIGHT</code>, <code>jsx3.gui.Block.ALIGNCENTER</code>
         */
        public void setCellTextAlign(String ALIGN)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellTextAlign(").appendData(ALIGN).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the CSS property value for the data cell vertical-align. If no value is provided, the data cells render top-aligned.
         *
        @SuppressWarnings("unchecked")
        public String getCellVAlign(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets  the CSS property value for the data cell vertical-align. Call repaint on the parent instance to update the view.
         * @param VALIGN valid CSS value for vertical-align style.
         */
        public void setCellVAlign(String VALIGN)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellVAlign(").appendData(VALIGN).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns whether or not the data cellc will support text-wrapping. If no value is specified, the text will not wrap
         * @param strDefault The default value to use if null
         *
        @SuppressWarnings("unchecked")
        public int getCellWrap(String strDefault, Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets whether or not the data cellc will support text-wrapping. If no value is
        specified, the text will not wrap. Call repaint to update the VIEW
         * @param WRAP <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         */
        public void setCellWrap(int WRAP)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setCellWrap(").appendData(WRAP).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Sets property value(s) for a border for the header cell (solid 1px #000000). Updates are applied immediately
         * @param strCSS valid CSS property value for a border (border: solid 1px #000000) or GI shorthand notation for border
         */
        public void setBorder(String strCSS)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setBorder(").appendData(strCSS).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Sets CSS property value(s) for a padding for the header cell. Updates are applied immediately.
         * @param strCSS valid CSS property value for padding. For example: <code>8 4 8 4</code>
         */
        public void setPadding(String strCSS)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setPadding(").appendData(strCSS).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Gets whether or not the header cell will support text-wrapping. If not specified, the cell will be painted with no wrapping.
         * @param strDefault The default value to use if null
         */
        @SuppressWarnings("unchecked")
        public Boolean getWrap(String strDefault)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("getWrap(\"" + strDefault + "\").");
            try
            {
                Constructor<Boolean> ctor = Boolean.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + Boolean.class.getName());
            }
        }

        /**
         * Sets whether or not the header cell will support text-wrapping. Repaints the header to immediately reflect this change.
         * @param WRAP 
         */
        public void setWrap(Boolean WRAP)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setWrap(").appendData(WRAP).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /*
         * Returns the CSS property value for the header cell vertical-align. If no value is provided, the header cell render top-aligned.
         *
        @SuppressWarnings("unchecked")
        public String getVAlign(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Sets the CSS property value for the header cell vertical-align. Repaints the header to immediately reflect this change.
         * @param VALIGN valid CSS value for vertical-align style.
         */
        public void setVAlign(String VALIGN)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setVAlign(").appendData(VALIGN).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * Sets the text/HTML for the control to be displayed on-screen.
         * @param strText text/HTML
         * @param bRepaint if <code>true</code>, the view of this object is immediately updated, obviating the need to call <code>repaint()</code>.
         */
        public org.directwebremoting.proxy.jsx3.gui.Matrix.Column setText(String strText, boolean bRepaint)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setText(").appendData(strText).appendScript(",")

            .appendData(bRepaint).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
            return this;
        }

        /*
         * Publishes a model event. This method both evaluates any registered event script for the given event type
        and publishes the event through the EventDispatcher interface. This method ensures that any
        registered event script is executed in isolation to prevent most side effects.
         * @param strType the event type, one of the model event types defined as static fields in this class
         * @param objContext JavaScript object array with name/value pairs that provide a local
        variable stack for the execution of the event script. This argument is also passed as the <code>context</code>
        property of the event object that is published through the <code>EventDispatcher</code> interface.
         * @return the result of evaluating the event script or <code>null</code> if not event script is registered
         *
        @SuppressWarnings("unchecked")
        public Object doEvent(String strType, Object objContext, Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns whether is object supports programmatic drag, meanining it will allow any contained item to be
        dragged and dropped on another container supporting drop.
         * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         *
        @SuppressWarnings("unchecked")
        public int getCanDrag(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns whether this object can be the target of a drop event.
         * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         *
        @SuppressWarnings("unchecked")
        public int getCanDrop(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns whether is object can be moved around the screen (this is not the same as drag/drop).
         * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         *
        @SuppressWarnings("unchecked")
        public int getCanMove(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns whether is object can be spyglassed.
         * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         *
        @SuppressWarnings("unchecked")
        public int getCanSpy(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns the event script registered for the given event type. This script could have been set by the
        setEvent() method or during component deserialization.
         * @param strType the event type, one of the model event types defined as static fields in this class
         * @return the JavaScript event script
         *
        @SuppressWarnings("unchecked")
        public String getEvent(String strType, Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns the associative array containing all the registered event script of this object. This method returns
        the instance field itself and not a copy.
         * @return an associative array mapping event type to event script
         *
        @SuppressWarnings("unchecked")
        public Object getEvents(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns the name of the jsx3.gui.Menu instance to display (as a context menu) when a user
        clicks on this object with the right button.
         *
        @SuppressWarnings("unchecked")
        public String getMenu(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /*
         * Returns true if there is a event script registered for the given event type.
         * @param strType the event type, one of the model event types defined as static fields in this class
         * @return the JavaScript event script
         *
        @SuppressWarnings("unchecked")
        public String hasEvent(String strType, Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Registers a hot key with this JSX model node. All keydown events that bubble up to this object
        will be checked against the hot key. If an event matches, the callback function will execute and the event
        bubble will be canceled.

        If the four parameters vntKey, bShift, bControl, and bAlt
        match a previously registered hot key, the previous hot key is clobbered by the new one. Only one hot key callback
        function (the most recently registered) will be executed by a single keydown event.
         * @param vntCallback either a function, or the name of a method bound to this object.
        When a keydown event bubbles up to this object that matches the hot key created by this method, this function
        is called on this object. If this function returns <code>false</code> then this hot key will not cancel the
        key event. This parameter can also be an instance of <code>HotKey</code>, in which case all
        other parameters are ignored.
         * @param vntKey if this parameter is a String, the hot key matches that key (the keycode to match is
        determined by <code>HotKey.keyDownCharToCode()</code>). If it is an integer, the hot key will match that
        keycode value.
         * @param bShift if not <code>null</code> the shift key state of the keydown event must match this value
        to invoke the hot key.
         * @param bControl if not <code>null</code> the control key state of the keydown event must match this value
        to invoke the hot key.
         * @param bAlt if not <code>null</code> the alt key state of the keydown event must match this value
        to invoke the hot key.
         * @return the registered hot key.
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.HotKey registerHotKey(String vntCallback, int vntKey, boolean bShift, boolean bControl, boolean bAlt)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("registerHotKey(\"" + vntCallback + "\", \"" + vntKey + "\", \"" + bShift + "\", \"" + bControl + "\", \"" + bAlt + "\").");
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

        /**
         * Removes an event script registered for the given model event type.
         * @param strType the event type, one of the model event types defined as static fields in this class
         * @return this object
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvent(String strType)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("removeEvent(\"" + strType + "\").");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
            }
        }

        /**
         * Removes all events scripts registered with this object.
         * @return this object
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Interactive removeEvents()
        {
            ProxyHelper child = getProxyHelper().getChildHelper("removeEvents().");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
            }
        }

        /**
         * Sets whether is object supports programmatic drag, meanining it will allow any contained item to be dragged/dropped.
        Implementing classes can decide whether to consult this value or ignore it.
         * @param bDrag <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         * @return this object
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrag(int bDrag)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("setCanDrag(\"" + bDrag + "\").");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
            }
        }

        /**
         * Sets whether this object can be the target of a drop event. Implementing classes can decide whether to consult
        this value or ignore it.
         * @param bDrop <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         * @return this object
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Interactive setCanDrop(int bDrop)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("setCanDrop(\"" + bDrop + "\").");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
            }
        }

        /**
         * Sets whether is object can be moved around the screen (this is not the same as drag/drop). Implementing classes
        can decide whether to consult this value or ignore it.
         * @param bMovable <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         * @return this object
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Interactive setCanMove(int bMovable)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("setCanMove(\"" + bMovable + "\").");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
            }
        }

        /**
         * Sets whether is object can be spyglassed. Implementing classes can decide whether to consult
        this value or ignore it.
         * @param bSpy <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
         * @return this object
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Interactive setCanSpy(int bSpy)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("setCanSpy(\"" + bSpy + "\").");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
            }
        }

        /**
         * Programmatically sets an event of this instance. Sets the script that will execute when this object publishes
        a model event. The script value will be saved in the serialization file of a component. Not all classes that
        implement this interface will publish events of every type. Consult the documentation of a class for a
        description of the events it publishes.

        For programmatic registering of event handlers when persistence in a serialization file is not required,
        consider using jsx3.util.EventDispatcher.subscribe() instead of this method. Whenever a model
        event is published, it is published using the EventDispatcher interface as well as by executing
        any registered event script.
         * @param strScript the actual JavaScript code that will execute when the given event is published.
        For example: <code>obj.setEvent("alert('hello.');", jsx3.gui.Interactive.EXECUTE);</code>
         * @param strType the event type. Must be one of the model event types defined as static fields in this class
         * @return reference to this
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Interactive setEvent(String strScript, String strType)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("setEvent(\"" + strScript + "\", \"" + strType + "\").");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
            }
        }

        /**
         * Sets the name of the jsx3.gui.Menu instance to display when a user
        clicks on this object with the right button. The name is a pointer by-name to a JSX object in the same server.
         * @param strMenu name or id (jsxname or jsxid) of the context menu
         * @return this object
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Interactive setMenu(String strMenu)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("setMenu(\"" + strMenu + "\").");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Interactive> ctor = org.directwebremoting.proxy.jsx3.gui.Interactive.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Interactive.class.getName());
            }
        }

        /**
         * Sets the CSS definition to apply to an HTML element when a spyglass is shown for that element
         * @param strCSS valid CSS. For example, text-decoration:underline;color:red;
         */
        public void setSpyStyles(String strCSS)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("setSpyStyles(").appendData(strCSS).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

        /**
         * called by 'window.setTimeout()' to display the spyglass hover for a given object;
         * @param strHTML HTML/text to display in the spyglass; as the spyglass does not define a height/width, this content will
             have improved layout if it specifies a preferred width in its in-line-style or referenced-css rule.
         * @param intLeft use an integer to specify an on-screen location; otherwise, use a <code>jsx3.gui.Event</code> instance to have the system automatically calculate the x/y position.
         * @param intTop use an integer if <code>intLeft</code> also uses an integer. Otherwise, use null.
         */
        public void showSpy(String strHTML, int intLeft, int intTop)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("showSpy(").appendData(strHTML).appendScript(",")

            .appendData(intLeft).appendScript(",")

            .appendData(intTop).appendScript(");");
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

    }

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

    /**
     * @author Joe Walker [joe at getahead dot org]
     * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
     */
    public class ColumnFormat extends org.directwebremoting.proxy.jsx3.lang.Object
    {
        /**
         * All reverse ajax proxies need context to work from
         * @param helper The store of the context for the current action
         */
        public ColumnFormat(ProxyHelper helper)
        {
            super(helper);
        }

        /**
         * Returns a column formatter for a string key. The key may be one of the following:


              @unescape Ð 

              @unescape_all Ð 

              @lookup Ð 

              @datetime[,(short|medium|long|full,format)] Ð 

              @date[,(short|medium|long|full,format)] Ð 

              @time[,(short|medium|long|full,format)] Ð 

              @number[,(integer|percent|currency,format)] Ð 

              @message,format
               Ð
         * @param strKey 
         * @param objColumn 
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.gui.Matrix.ColumnFormat getInstance(String strKey, org.directwebremoting.proxy.jsx3.gui.Matrix.Column objColumn)
        {
            ProxyHelper child = getProxyHelper().getChildHelper("getInstance(\"" + strKey + "\", \"" + objColumn + "\").");
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.gui.Matrix.ColumnFormat> ctor = org.directwebremoting.proxy.jsx3.gui.Matrix.ColumnFormat.class.getConstructor(ProxyHelper.class);
                return ctor.newInstance(child);
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Matrix.ColumnFormat.class.getName());
            }
        }

        /*
         * Classes that implement this interface must provide this method to allow for browser-specific or similar type 'switch'. If
        false is returned, the formatter will not even attempt to iterate
         * @return true if the formatter should be called to iterate and format
         *
        @SuppressWarnings("unchecked")
        public boolean validate(Callback callback)
        {
            String key = // Generate some id
            ScriptSession session = WebContext.get().getScriptSession();
            Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
            calbackMap.put(key, callback);
            session.addAttribute(CALLBACK_KEY, callbackMap);
        }
        */

        /**
         * Formats the Matrix cell, a native DIV element.
         * @param objDiv on-screen DIV element to be formatted. Note that this DIV is contained within a TD
         * @param strCDFKey CDF record id for the record in the data model bound to the affected on-screen row
         * @param objMatrix matrix instance
         * @param objMatrixColumn matrix column instance
         * @param intRowNumber row number for row containing this cell (1-based)
         * @param objServer server instance. Useful for querying locale (for localized output)
         */
        public void format(String objDiv, String strCDFKey, org.directwebremoting.proxy.jsx3.gui.Matrix objMatrix, org.directwebremoting.proxy.jsx3.gui.Matrix.Column objMatrixColumn, int intRowNumber, org.directwebremoting.proxy.jsx3.app.Server objServer)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendData(getProxyHelper().getContext()).appendScript("format(").appendData(objDiv).appendScript(",")

            .appendData(strCDFKey).appendScript(",")

            .appendData(objMatrix).appendScript(",")

            .appendData(objMatrixColumn).appendScript(",")

            .appendData(intRowNumber).appendScript(",")

            .appendData(objServer).appendScript(");");
            getProxyHelper().getScriptProxy().addScript(script);
        }

    }

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

    /**
     * @author Joe Walker [joe at getahead dot org]
     * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
     */
    public interface EditMask
    {

    }
}
