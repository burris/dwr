<?xml version="1.0" ?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:java="http://xml.apache.org/xalan/java"
    xmlns:dwr="xalan://org.directwebremoting.drapgen.xslt.ExtensionFunctions" 
    exclude-result-prefixes="java"
    >
<xsl:output method="text"/>

<xsl:template match="/">
  <xsl:text>/*
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
 */</xsl:text>
 <xsl:apply-templates select="class[not(deprecated)]|interface[not(deprecated)]"/>
</xsl:template>

<xsl:template match="interface">
<xsl:text>
package org.directwebremoting.proxy.</xsl:text><xsl:value-of select="@package"/><xsl:text>;

import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public interface </xsl:text><xsl:value-of select="@shortname"/>
<xsl:if test="superclass[@direct='1']">
  <xsl:text> extends org.directwebremoting.proxy.<xsl:value-of select="superclass[@direct='1']/@name"/></xsl:text>
</xsl:if>
<xsl:text>
{
    </xsl:text>
    <xsl:apply-templates select="field[@static and not(@noProxy) and not(@deprecated)]"/>
    <xsl:text>
}
</xsl:text>
</xsl:template>

<xsl:template match="class">
<xsl:text>
package org.directwebremoting.proxy.</xsl:text><xsl:value-of select="@package"/><xsl:text>;

import java.util.Date;
import java.lang.reflect.Constructor;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class </xsl:text><xsl:value-of select="@shortname"/>
<xsl:if test="superclass[@direct='1']">
  <xsl:text> extends org.directwebremoting.proxy.<xsl:value-of select="superclass[@direct='1']/@name"/></xsl:text>
</xsl:if>
<xsl:text>
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public </xsl:text><xsl:value-of select="@shortname"/><xsl:text>(ProxyHelper helper)
    {
        super(helper);
    }

    </xsl:text>
    <xsl:apply-templates select="field[@static and not(@noProxy) and not(@deprecated)]"/>
    <xsl:apply-templates select="method[not(@inherited) and not(@noProxy) and not(@deprecated)]"/>
    <xsl:text>
}
  </xsl:text>
</xsl:template>

<xsl:template match="field">
    /**
     * <xsl:copy-of select="dwr:trim(text)"/>
     */
    public static final <xsl:value-of select="dwr:normalizeClassname(type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/> = <xsl:value-of select="@value"/>;
</xsl:template>

<xsl:template match="method">
  <xsl:choose>

    <!--
    The simple case when there is no return, so the generated script is fire and
    forget.
    -->
    <xsl:when test="not(return)">
    /**
     * <xsl:copy-of select="dwr:trim(text)"/>
     <xsl:for-each select="param">
     * @param <xsl:value-of select="@name"/><xsl:text> </xsl:text><xsl:value-of select="dwr:trim(@text)"/>
     </xsl:for-each><xsl:if test="return">
     * @return <xsl:value-of select="dwr:trim(return/@text)"/></xsl:if>
     */
    public void <xsl:value-of select="@name"/>(<xsl:for-each select="param">
      <xsl:value-of select="dwr:normalizeClassname(type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>
      <xsl:if test="position() != last()">, </xsl:if>
    </xsl:for-each>)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("<xsl:value-of select="@name"/>(")<xsl:for-each select="param">
              .appendData(<xsl:value-of select="@name"/>)<xsl:if test="position() != last()">
              .appendScript(",")
              </xsl:if>
              </xsl:for-each>
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }
    </xsl:when>

    <!--
    Pseudo fire and forget, where the method returns 'this'.
    Detecting this can be tricky, but for now we are mandating that the name
    starts "set" to distinguish from cases like "createChildNode". This is a bit
    of a nasty rule, but all GI setters return this...
    -->
    <xsl:when test="return/type/@name = ../@name and starts-with(@name, 'set')">
    /**
     * <xsl:copy-of select="dwr:trim(text)"/>
     <xsl:for-each select="param">
     * @param <xsl:value-of select="@name"/><xsl:text> </xsl:text><xsl:value-of select="dwr:trim(@text)"/>
     </xsl:for-each><xsl:if test="return">
     * @return <xsl:value-of select="dwr:trim(return/@text)"/></xsl:if>
     */
    public <xsl:value-of select="dwr:normalizeClassname(return/type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>(<xsl:for-each select="param">
      <xsl:value-of select="dwr:normalizeClassname(type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>
      <xsl:if test="position() != last()">, </xsl:if>
    </xsl:for-each>)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext())
              .appendScript("<xsl:value-of select="@name"/>(")<xsl:for-each select="param">
              .appendData(<xsl:value-of select="@name"/>)<xsl:if test="position() != last()">
              .appendScript(",")
              </xsl:if>
              </xsl:for-each>
              .appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
        return this;
    }
    </xsl:when>

    <!--
    When the return type is itself a proxy, we can postpone the problem of
    getting data from the browser until later.
    TODO: find a better way of detecting proxied classes - we might need to keep
    and external registry and call out to some custom function.
    -->
    <xsl:when test="starts-with(return/type/@name, 'jsx3')">
    /**
     * <xsl:copy-of select="dwr:trim(text)"/>
     <xsl:for-each select="param">
     * @param <xsl:value-of select="@name"/><xsl:text> </xsl:text><xsl:value-of select="dwr:trim(@text)"/>
     </xsl:for-each><xsl:if test="return">
     * @return <xsl:value-of select="dwr:trim(return/@text)"/></xsl:if>
     */
    @SuppressWarnings("unchecked")
    public <xsl:value-of select="dwr:normalizeClassname(return/type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>(<xsl:for-each select="param">
      <xsl:value-of select="dwr:normalizeClassname(type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>
      <xsl:if test="position() != last()">, </xsl:if>
    </xsl:for-each>)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("<xsl:value-of select="@name"/>(<xsl:for-each select="param">\"" + <xsl:value-of select="@name"/> + "\"<xsl:if test="position() != last()">, </xsl:if></xsl:for-each>).");
        try
        {
            Constructor&lt;<xsl:value-of select="dwr:normalizeClassname(return/type/@name)"/>&gt; ctor = <xsl:value-of select="dwr:normalizeClassname(return/type/@name)"/>.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + <xsl:value-of select="dwr:normalizeClassname(return/type/@name)"/>.class.getName());
        }
    }

    <!--
    If the return type has subclasses then we need a second version with an
    extra parameter so we can say something along the lines of "I'm expecting
    getJsxById() to give me a button, get me something that will act like one".
    Note: This is inside the xsl:when clause - if this is a superclass then we
    will get 2 output methods, one with the extra parameter
    -->
    <xsl:if test="dwr:isSuperClass(return/type/@name)">
    /**
     * <xsl:copy-of select="dwr:trim(text)"/>
     <xsl:for-each select="param">
     * @param <xsl:value-of select="@name"/><xsl:text> </xsl:text><xsl:value-of select="dwr:trim(@text)"/>
     </xsl:for-each><xsl:if test="return">
     * @param type The expected return type
     * @return <xsl:value-of select="dwr:trim(return/@text)"/></xsl:if>
     */
    @SuppressWarnings("unchecked")
    public &lt;T&gt; T <xsl:value-of select="@name"/>(<xsl:for-each select="param">
      <xsl:value-of select="dwr:normalizeClassname(type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>
      <xsl:if test="position() != last()">, </xsl:if>
    </xsl:for-each><xsl:if test="count(param) > 0">, </xsl:if>Class&lt;T&gt; returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("<xsl:value-of select="@name"/>(<xsl:for-each select="param">\"" + <xsl:value-of select="@name"/> + "\"<xsl:if test="position() != last()">, </xsl:if></xsl:for-each>).");
        try
        {
            Constructor&lt;T&gt; ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }
    </xsl:if>
    </xsl:when>

    <!--
    When the return type is not a proxy, we will need to call out to the browser
    -->
    <xsl:otherwise>
    /*
     * <xsl:copy-of select="dwr:trim(text)"/>
     <xsl:for-each select="param">
     * @param <xsl:value-of select="@name"/><xsl:text> </xsl:text><xsl:value-of select="dwr:trim(@text)"/>
     </xsl:for-each><xsl:if test="return">
     * @return <xsl:value-of select="dwr:trim(return/@text)"/></xsl:if>
     *
    @SuppressWarnings("unchecked")
    public <xsl:value-of select="dwr:normalizeClassname(return/type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>(<xsl:for-each select="param">
      <xsl:value-of select="dwr:normalizeClassname(type/@name)"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>
      <xsl:if test="position() != last()">, </xsl:if>
    </xsl:for-each><xsl:if test="count(param) > 0">, </xsl:if>Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map&lt;String, Callback&gt; callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */
    </xsl:otherwise>
  </xsl:choose>
</xsl:template>

</xsl:stylesheet>
