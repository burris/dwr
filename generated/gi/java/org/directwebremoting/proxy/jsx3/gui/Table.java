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
public class Table extends org.directwebremoting.proxy.jsx3.gui.Block
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Table(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * instance initializer
     * @param strName unique name distinguishing this object from all other JSX GUI objects in the JSX application
     */
    public Table(String strName)
    {
        super((ProxyHelper) null);
    }

    /**
     * 
     */
    public static final String DEFAULTXSLURL = null;

    /**
     * text (default)
     */
    public static final String TYPE_TEXT = "text";

    /**
     * number
     */
    public static final String TYPE_NUMBER = "number";

    /**
     * jsx:///images/table/select.gif
     */
    public static final String SELECTION_BG = "jsx:///images/table/select.gif";

    /**
     * Enum value for the multiSelect property indicating an unselectable table.
     */
    public static final int SELECTION_UNSELECTABLE = 0;

    /**
     * Enum value for the multiSelect property indicating a multi-select table.
     */
    public static final int SELECTION_ROW = 1;

    /**
     * Enum value for the multiSelect property indicating a single-select table.
     */
    public static final int SELECTION_MULTI_ROW = 2;

    /**
     * ascending
     */
    public static final String SORT_ASCENDING = "ascending";

    /**
     * descending
     */
    public static final String SORT_DESCENDING = "descending";

    /**
     * jsx:///images/table/sort_desc.gif (default)
     */
    public static final String SORT_DESCENDING_IMG = null;

    /**
     * jsx:///images/table/sort_asc.gif (default)
     */
    public static final String SORT_ASCENDING_IMG = null;

    /**
     * 20
     */
    public static final int DEFAULT_HEADER_HEIGHT = 20;

    /*
     * validates the Table; if the Table is set to 'required', a selection must be made to pass validation. Otherwise, a Table will always pass validation
     * @return one of: jsx3.gui.Form.STATEINVALID or jsx3.gui.Form.STATEVALID
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
     * Returns an array of selected values (or empty array) if the selection model is Table.SELECTION_MULTI_ROW. Returns a string (or null)
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

    /**
     * Sets the value of this table. Deselects all existing selections. Scrolls the first record into view.
     * @param strId jsxid attribute for the CDF record(s) to select
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Table setValue(String strId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /**
     * Sets the value of this table. Deselects all existing selections. Scrolls the first record into view.
     * @param strId jsxid attribute for the CDF record(s) to select
     * @return this object.
     */
    public org.directwebremoting.proxy.jsx3.gui.Table setValue(Object[] strId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValue(").appendData(strId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }

    /*
     * Returns the on-screen cell that represents the intersection of the row identified
    by strCdfId and the first cell mapped to the named CDF attribute, strAttName.
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
     * Applies focus to the on-screen row indentified by the CDF record id that generated it
     * @param strCdfId jsxid property for the corresponding CDF record
     */
    public void focusRowById(String strCdfId)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("focusRowById(").appendData(strCdfId).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

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
     * @param intType one of Table: .SELECTION_UNSELECTABLE, .SELECTION_ROW, .SELECTION_MULTI_ROW
     */
    public void setSelectionModel(int intType)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSelectionModel(").appendData(intType).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS string to apply to a Row/Cell when it has focus
     * @param strDefault The default value to use if null (Table.SELECTION_BG)
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
     * Deselects a CDF record within the Table. Both the view and the data model (CDF) will be updated
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

    /**
     * Sorts according to the current sort path. If no sort direction is specified, the sort direction will be toggled.
     * @param intSortDir <code>jsx3.gui.Table.SORT_ASCENDING</code> or <code>jsx3.gui.Table.SORT_DESCENDING</code>.
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
     * Sets the name of the CDF attribute to sort on. The records in the data source of this table are sorted
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
     * Returns the data type to be used for sorting this list.
     * @return <code>jsx3.gui.Table.TYPE_TEXT</code> or <code>jsx3.gui.Table.TYPE_NUMBER</code>
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
     * Sets the data type for the list.
     * @param DATATYPE data type for this column's data. Valid types include: jsx3.gui.Table.TYPE_TEXT and jsx3.gui.Table.TYPE_NUMBER
     */
    public void setSortType(String DATATYPE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSortType(").appendData(DATATYPE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the direction (jsx3.gui.Table.SORT_ASCENDING or jsx3.gui.Table.SORT_DESCENDING) for the sorted column; if no direction specified, ascending is returned
     * @return one of: jsx3.gui.Table.SORT_ASCENDING or jsx3.gui.Table.SORT_DESCENDING
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
     * @param intSortDir one of: jsx3.gui.Table.SORT_ASCENDING or jsx3.gui.Table.SORT_DESCENDING
     */
    public void setSortDirection(String intSortDir)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setSortDirection(").appendData(intSortDir).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether the table is sortable. If null or jsx3.Boolean.TRUE, the instance is sortable.
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
     * Sets whether the table is sortable.
     * @param SORT one of <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     */
    public void setCanSort(int SORT)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCanSort(").appendData(SORT).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * This method implements redraw support by repainting the entire control.
     * @param strRecordId 
     * @param ACTION 
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.gui.Table redrawRecord(String strRecordId, String ACTION)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("redrawRecord(\"" + strRecordId + "\", \"" + ACTION + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.gui.Table> ctor = org.directwebremoting.proxy.jsx3.gui.Table.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.gui.Table.class.getName());
        }
    }

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
     * Paints only the header row.  Call for quick repainting of the header row and not the data rows.
     */
    public void repaintHead()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("repaintHead(").appendScript(");");
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

    /*
     * Returns the CSS style for the HTML row containing the column headers.
     * @param strDefault 
     *
    @SuppressWarnings("unchecked")
    public String getHeaderStyle(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS style properties for the HTML row containing the column headers. Multiple properties are supported.
    For example: background-image:url(JSXAPPS/myproject/images/bg.gif);font-family:Arial;.
    The following CSS properties (those affecting layout and position) are not allowed: width, height,
    left, top, position, overflow, border, padding, margin.
     * @param strCSS 
     */
    public void setHeaderStyle(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHeaderStyle(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS rule for the HTML row containing the column headers.
     * @param strDefault 
     *
    @SuppressWarnings("unchecked")
    public String getHeaderClass(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS rule for the HTML row containing the column headers.  Multiple rules are supported.
    For example: boldText titleText.
    The following CSS properties (those affecting layout and position) are not allowed for the rule: width, height,
    left, top, position, overflow, border, padding, margin.
     * @param strRuleName 
     */
    public void setHeaderClass(String strRuleName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setHeaderClass(").appendData(strRuleName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS properties for the HTML row elements(s) containing the table data.
     *
    @SuppressWarnings("unchecked")
    public String getRowStyle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS properties for the HTML row element(s) containing the table data. Every row will
    apply the properties defined by this value, unless an alternate row style is used, in which case, the properties are alternated
    between this value and the value applied by setAlternateRowStyle.  Multiple properties are supported.
    For example: background-color:white;font-family:Arial;.
     * @param strCSS 
     */
    public void setRowStyle(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRowStyle(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS properties for the HTML row element(s) containing the alternating table data rows.
     * @param strDefault 
     *
    @SuppressWarnings("unchecked")
    public String getAlternateRowStyle(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS properties for the HTML row element(s) containing the alternating table data rows. Multiple properties are supported.
    For example: background-color:red;font-family:Arial;.
     * @param strCSS 
     */
    public void setAlternateRowStyle(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAlternateRowStyle(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS properties that will be inlined on every HTML cell in the body of the table.
     *
    @SuppressWarnings("unchecked")
    public String getCellStyle(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS properties that will be inlined on every HTML cell in the body of the table. Multiple properties are supported.
    For example: text-align:right;background-color:#eeeeee;border-bottom:solid 1px #aeaeae;.
     * @param strCSS 
     */
    public void setCellStyle(String strCSS)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCellStyle(").appendData(strCSS).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS rule for the HTML row element(s) containing the table data.
     *
    @SuppressWarnings("unchecked")
    public String getRowClass(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS rule for the HTML row element(s) containing the table data. Every row will
    apply the rule defined by this value, unless an alternate row rule is used, in which case, the rule (classname) is alternated
    between this value and the value applied by setAlternateRowClass.  Multiple rules are supported.
    For example: bodyText normalText.
     * @param strRuleName 
     */
    public void setRowClass(String strRuleName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setRowClass(").appendData(strRuleName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS rule for the HTML row element(s) containing the alternating table data rows.
     * @param strDefault 
     *
    @SuppressWarnings("unchecked")
    public String getAlternateRowClass(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS rule for the HTML row element(s) containing the alternating table data rows. Multiple rules are supported.
    For example: bodyText, normalText.
     * @param strRuleName 
     */
    public void setAlternateRowClass(String strRuleName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setAlternateRowClass(").appendData(strRuleName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the CSS rule that will be applied to every HTML cell in the body of the table.
     *
    @SuppressWarnings("unchecked")
    public String getCellClass(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the CSS rule that will be applied to every HTML cell in the body of the table.
    Multiple rules are supported.  For example: boldText titleText.
     * @param strRuleName 
     */
    public void setCellClass(String strRuleName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setCellClass(").appendData(strRuleName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns whether or not the table's data cells support text-wrapping and expand vertically to display their wrapped content. If this
    property is not set, the cell content will not wrap.
     * @param strDefault 
     * @return <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     *
    @SuppressWarnings("unchecked")
    public int getWrap(String strDefault, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets whether or not the table's data cells support text-wrapping and expand vertically to display their wrapped content.
     * @param WRAP <code>jsx3.Boolean.TRUE</code> or <code>jsx3.Boolean.FALSE</code>
     */
    public void setWrap(int WRAP)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setWrap(").appendData(WRAP).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the text/HTML to display on-screen when the xml/xsl transformation for this object results in a null or empty result set
     * @return text/HTML
     *
    @SuppressWarnings("unchecked")
    public String getNoDataMessage(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns XSLT for the Table, prioritizing the acquisition in the following order: 1) check cache; 2) check jsxxsl; 3) check jsxxslurl; 4) use default
     * @return jsx3.xml.Document instance containing valid XSL stylesheet
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.Document getXSL()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXSL().");
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
     * Returns XSLT for the Table, prioritizing the acquisition in the following order: 1) check cache; 2) check jsxxsl; 3) check jsxxslurl; 4) use default
     * @param returnType The expected return type
     * @return jsx3.xml.Document instance containing valid XSL stylesheet
     */
    @SuppressWarnings("unchecked")
    public <T> T getXSL(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getXSL().");
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
     * Gets the user-defined XSL template (xsl:template) that will override the defualt template defined by Table.DEFAULT_CELL_VALUE_TEMPLATE.
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
     * Sets the user-defined XSL template that will override the defualt template defined by Table.DEFAULT_CELL_VALUE_TEMPLATE.
    The template must resolve to a valid XSL Template when parsed.  The template should match on a record (match="record").  The template
    will be passed a single XSL param (xsl:param) named attname.
     * @param TEMPLATE valid xsl:template
     */
    public void setValueTemplate(String TEMPLATE)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setValueTemplate(").appendData(TEMPLATE).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns a clone of the CDF document used internally to define the Columns (text, order, mapped attributes, etc).
    The order of the records in this document reflects the order of the columns in the Table.  If the column profile document defined
    by getColumnProfile is not a valid XML document, an empty CDF Document will be returned instead.
    Note that if you make changes to the Document returned by this method, those
    changes will only be reflected by calling  setColumnProfile (to update the model),
    followed by a call to repaint (to update the view).
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.xml.CDF.Document getColumnProfileDocument()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getColumnProfileDocument().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.xml.CDF.Document> ctor = org.directwebremoting.proxy.jsx3.xml.CDF.Document.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.CDF.Document.class.getName());
        }
    }

    /*
     * Returns the string of XML in CDF format representing the Column Profile Document.
     *
    @SuppressWarnings("unchecked")
    public String getColumnProfile(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets a string of XML (in CDF format) or an actual jsx3.xml.CDF.Document instance representing the Column Profile Document.
    Each record in this document defines the profile for a column in the Table.  The following attributes are supported on each record:

    jsxid: The unique ID for the record (REQUIRED).
    jsxtext: HTML or text content to use as the column label.
    jsxwidth: The width of the column (pixel units are implied). For example: 300, or 25%.
    jsxpath: The name of the attribute to which this column maps (REQUIRED).
    jsxpathtype: The data type for the attribute. One of: text (default) or number.


      For example:

    <data jsxid="jsxroot">
    <record jsxid="a1" jsxtext="&lt;b&gt;Column 1&lt;/b&gt;" jsxpath="jsxtext"/>
    <record jsxid="a2" jsxtext="Column 2" jsxwidth="100" jsxpath="value" jsxpathtype="number"/>
    </data>
     * @param objCDF 
     */
    public void setColumnProfile(String objCDF)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColumnProfile(").appendData(objCDF).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets a string of XML (in CDF format) or an actual jsx3.xml.CDF.Document instance representing the Column Profile Document.
    Each record in this document defines the profile for a column in the Table.  The following attributes are supported on each record:

    jsxid: The unique ID for the record (REQUIRED).
    jsxtext: HTML or text content to use as the column label.
    jsxwidth: The width of the column (pixel units are implied). For example: 300, or 25%.
    jsxpath: The name of the attribute to which this column maps (REQUIRED).
    jsxpathtype: The data type for the attribute. One of: text (default) or number.


      For example:

    <data jsxid="jsxroot">
    <record jsxid="a1" jsxtext="&lt;b&gt;Column 1&lt;/b&gt;" jsxpath="jsxtext"/>
    <record jsxid="a2" jsxtext="Column 2" jsxwidth="100" jsxpath="value" jsxpathtype="number"/>
    </data>
     * @param objCDF 
     */
    public void setColumnProfile(org.directwebremoting.proxy.jsx3.xml.CDF.Document objCDF)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setColumnProfile(").appendData(objCDF).appendScript(");");
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
     * Returns the height of the header row in pixels. If this value is not set (null), the list will render with
    the default value of jsx3.gui.Table.DEFAULT_HEADER_HEIGHT.
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
