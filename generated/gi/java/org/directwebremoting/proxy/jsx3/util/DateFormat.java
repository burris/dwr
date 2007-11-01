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
public class DateFormat extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public DateFormat(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer. Instances of this class are immutable.
     * @param strFormat the date format.
     * @param objLocale the locale with which to format and parse dates. If this parameter is not
    provided the default system locale is used.
     */
    public DateFormat(String strFormat, org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        super((ProxyHelper) null);
    }

    /**
     * Type for a short localized date or time format.
     */
    public static final int SHORT = 1;

    /**
     * Type for a medium-length localized date or time format.
     */
    public static final int MEDIUM = 2;

    /**
     * Type for a long localized date or time format.
     */
    public static final int LONG = 3;

    /**
     * Type for a full-length localized date or time format.
     */
    public static final int FULL = 4;

    /**
     * Returns a date format localized for a particular locale.
     * @param intType <code>SHORT</code>, <code>MEDIUM</code>, <code>LONG</code>, or <code>FULL</code>
     * @param objLocale the locale for which to return a format. If this parameter is not provided,
    the default system locale is used.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.DateFormat getDateInstance(int intType, org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDateInstance(\"" + intType + "\", \"" + objLocale + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.DateFormat> ctor = org.directwebremoting.proxy.jsx3.util.DateFormat.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.DateFormat.class.getName());
        }
    }

    /**
     * Returns a time format localized for a particular locale.
     * @param intType <code>SHORT</code>, <code>MEDIUM</code>, <code>LONG</code>, or <code>FULL</code>
     * @param objLocale the locale for which to return a format. If this parameter is not provided,
    the default system locale is used.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.DateFormat getTimeInstance(int intType, org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getTimeInstance(\"" + intType + "\", \"" + objLocale + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.DateFormat> ctor = org.directwebremoting.proxy.jsx3.util.DateFormat.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.DateFormat.class.getName());
        }
    }

    /**
     * Returns a date and time format localized for a particular locale.
     * @param intDateType <code>SHORT</code>, <code>MEDIUM</code>, <code>LONG</code>, or <code>FULL</code>
     * @param intTimeType <code>SHORT</code>, <code>MEDIUM</code>, <code>LONG</code>, or <code>FULL</code>
     * @param objLocale the locale for which to return a format. If this parameter is not provided,
    the default system locale is used.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.util.DateFormat getDateTimeInstance(int intDateType, int intTimeType, org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getDateTimeInstance(\"" + intDateType + "\", \"" + intTimeType + "\", \"" + objLocale + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.util.DateFormat> ctor = org.directwebremoting.proxy.jsx3.util.DateFormat.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.util.DateFormat.class.getName());
        }
    }

    /**
     * 
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
     * 
     * @param objLocale 
     */
    public void setLocale(org.directwebremoting.proxy.jsx3.util.Locale objLocale)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setLocale(").appendData(objLocale).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the timezone offset of this date format. This is the difference between GMT and the local time of this
    date format, in minutes. For example, Pacific Standard Time is -480 (-08h * 60). If the timezone offset has been
    set explicitly with setTimeZoneOffset(), that value is returned.

    Since the timezone offset may change over the year for Daylight Savings Time, this method takes a
    Date argument, objDate. All dates are created with the timezone offset of the host
    browser's timezone, adjusted for Daylight Savings Time. Therefore, if the timezone offset of this date format
    has not been set explicitly, the timezone offset is determined from the objDate parameter, or, if
    that is not provided, from the current time.
     * @param objDate the date for which to return the timezone offset.
     * @return the timezone offset in minutes.
     *
    @SuppressWarnings("unchecked")
    public int getTimeZoneOffset(Date objDate, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the timezone offset of this date format. The default value is the value for the local time.
     * @param intMinutes the timezone offset in minutes.
     */
    public void setTimeZoneOffset(int intMinutes)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setTimeZoneOffset(").appendData(intMinutes).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Formats a date according to this date format.
     * @param objDate the date to format.
     * @return the formatted date.
     *
    @SuppressWarnings("unchecked")
    public String format(int objDate, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Formats a date according to this date format.
     * @param objDate the date to format.
     * @return the formatted date.
     *
    @SuppressWarnings("unchecked")
    public String format(Object objDate, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Formats a date according to this date format.
     * @param objDate the date to format.
     * @return the formatted date.
     *
    @SuppressWarnings("unchecked")
    public String format(Date objDate, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Parses a string according to this date format and returns the resulting date. If strDate does
    not conform to this date format, an exception is thrown.

    The default date for the purposes of this method is 1-Jan-1970 12:00AM, local time. If any date fields
    are omitted from this format, the date returned by this method will inherit those fields from the default date.
     * @param strDate the string to parse.
     * @return the parsed date.
     *
    @SuppressWarnings("unchecked")
    public Date parse(String strDate, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the format passed to the constructor.
     *
    @SuppressWarnings("unchecked")
    public String getFormat(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns a string representation of this date format.
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

}
