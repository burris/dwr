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
package org.directwebremoting.proxy.jsx3.xml;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.CallbackHelper;
import org.directwebremoting.proxy.Callback;
import org.directwebremoting.proxy.ScriptProxy;
import org.directwebremoting.proxy.io.Context;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public interface CDF
{

    /**
     * 
     */
    public static final int DELETE = 0;

    /**
     * 
     */
    public static final int INSERT = 1;

    /**
     * 
     */
    public static final int UPDATE = 2;

    /**
     * 
     */
    public static final int INSERTBEFORE = 3;

    /**
     * 
     */
    public static final String ELEM_ROOT = "data";

    /**
     * 
     */
    public static final String ELEM_RECORD = "record";

    /**
     * 
     */
    public static final String ATTR_ID = "jsxid";

    /**
     * 
     */
    public static final String ATTR_TEXT = "jsxtext";

    /**
     * 
     */
    public static final String ATTR_EXECUTE = "jsxexecute";

    /**
     * 
     */
    public static final String ATTR_DISABLED = "jsxdisabled";

    /**
     * 
     */
    public static final String ATTR_SELECTED = "jsxselected";

    /**
     * 
     */
    public static final String ATTR_UNSELECTABLE = "jsxunselectable";

    /**
     * 
     */
    public static final String ATTR_IMG = "jsximg";

    /**
     * 
     */
    public static final String ATTR_TIP = "jsxtip";

    /**
     * 
     */
    public static final String ATTR_KEYCODE = "jsxkeycode";

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
    public class Document extends org.directwebremoting.proxy.jsx3.xml.Document
    {
        /**
         * All reverse ajax proxies need context to work from
         * @param scriptProxy The place we are writing scripts to
         * @param context The script that got us to where we are now
         */
        public Document(Context context, String extension, ScriptProxy scriptProxy)
        {
            super(context, extension, scriptProxy);
        }

        /**
         * No-op.
         * @param strRecordId the <code>jsxid</code> attribute of the data record to redraw.
         * @param intAction <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>.
         */
        public void redrawRecord(String strRecordId, int intAction)
        {
            ScriptBuffer script = new ScriptBuffer();
            script.appendCall("redrawRecord", strRecordId, intAction);
            getScriptProxy().addScript(script);
        }

        /**
         * Creates a new XML document that represents an empty CDF document. The XML source of the new document
        is <data jsxid="jsxroot"/>.
         * @return the newly created document.
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.xml.CDF.Document newDocument()
        {
            String extension = "newDocument().";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.CDF.Document> ctor = org.directwebremoting.proxy.jsx3.xml.CDF.Document.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.CDF.Document.class.getName());
            }
        }

        /**
         * 
         * @param objXML 
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.xml.CDF.Document wrap(org.directwebremoting.proxy.jsx3.xml.Document objXML)
        {
            String extension = "wrap(\"" + objXML + "\").";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.CDF.Document> ctor = org.directwebremoting.proxy.jsx3.xml.CDF.Document.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.CDF.Document.class.getName());
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
         * @return the adopted record.
         */
        @SuppressWarnings("unchecked")
        public org.directwebremoting.proxy.jsx3.xml.Entity adoptRecord(String strSourceId, String strRecordId, String strParentRecordId, boolean bRedraw)
        {
            String extension = "adoptRecord(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "adoptRecord(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<T> ctor = returnType.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "adoptRecordBefore(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "adoptRecordBefore(\"" + strSourceId + "\", \"" + strRecordId + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<T> ctor = returnType.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            script.appendCall("convertProperties", objProps, arrProps, bUnion);
            getScriptProxy().addScript(script);
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
            String extension = "deleteRecord(\"" + strRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "deleteRecord(\"" + strRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<T> ctor = returnType.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            script.appendCall("deleteRecordProperty", strRecordId, strPropName, bRedraw);
            getScriptProxy().addScript(script);
        }

        /**
         * Returns an object containing the attributes of a particular CDF record as property/value pairs. The object returned by this
        method is a copy of the underlying data. Therefore, updates to this object will not affect the underlying data.

        The following two lines of code evaluate to the same value:

        objCDF.getRecord(strId).propName;
        objCDF.getRecordNode(strId).getAttribute("propName");
         * @param strRecordId the <code>jsxid</code> attribute of the data record to return.
         * @param callback the object representation of a CDF node or <code>null</code> if no such record found.
         */
        @SuppressWarnings("unchecked")
        public void getRecord(String strRecordId, Callback<Object> callback)
        {
            String key = CallbackHelper.saveCallback(callback, Object.class);

            ScriptBuffer script = new ScriptBuffer();
            script.appendCall("var reply = getRecord", strRecordId);
            script.appendCall("__System.activateCallback", key, "reply");
            getScriptProxy().addScript(script);
        }

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
            String extension = "getRecordNode(\"" + strRecordId + "\").";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "getRecordNode(\"" + strRecordId + "\").";
            try
            {
                Constructor<T> ctor = returnType.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "insertRecord(\"" + objRecord + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "insertRecord(\"" + objRecord + "\", \"" + strParentRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<T> ctor = returnType.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "insertRecordBefore(\"" + objRecord + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.Entity> ctor = org.directwebremoting.proxy.jsx3.xml.Entity.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            String extension = "insertRecordBefore(\"" + objRecord + "\", \"" + strSiblingRecordId + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<T> ctor = returnType.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
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
            script.appendCall("insertRecordNode", objRecordNode, strParentRecordId, bRedraw);
            getScriptProxy().addScript(script);
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
            String extension = "insertRecordProperty(\"" + strRecordId + "\", \"" + strPropName + "\", \"" + strPropValue + "\", \"" + bRedraw + "\").";
            try
            {
                Constructor<org.directwebremoting.proxy.jsx3.xml.CDF> ctor = org.directwebremoting.proxy.jsx3.xml.CDF.class.getConstructor(Context.class, String.class, ScriptProxy.class);
                return ctor.newInstance(this, extension, getScriptProxy());
            }
            catch (Exception ex)
            {
                throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.xml.CDF.class.getName());
            }
        }

    }
}
