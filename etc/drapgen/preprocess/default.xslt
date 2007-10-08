<?xml version="1.0" ?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:java="http://xml.apache.org/xalan/java"
    xmlns:dwr="xalan://org.directwebremoting.drapgen.xslt.ExtensionFunctions" 
    exclude-result-prefixes="java"
    >
<xsl:output method="xml"/>

  <xsl:template match="*">
    <xsl:copy>
      <xsl:copy-of select="@*"/>
      <xsl:apply-templates/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="method[param[count(type) > 1]]">
    <!--
    <xsl:comment>copy</xsl:comment>
    <xsl:copy>
      <xsl:copy-of select="@*"/>
      <xsl:apply-templates/>
    </xsl:copy>
    <xsl:comment>recurse</xsl:comment>
    -->
    <xsl:call-template name="recurseOverTypesInParam">
      <xsl:with-param name="method" select="."/>
    </xsl:call-template>

  </xsl:template>

  <xsl:template name="recurseOverTypesInParam">
    <xsl:param name="method"/>
    <xsl:param name="param-number" select="1"/>
    <xsl:param name="type-list"></xsl:param>
    <xsl:variable name="param-count" select="count($method//param)"/>
    <xsl:variable name="is-last" select="$param-number = $param-count"/>
    <!-- for all types in param($param-number) -->
    <xsl:for-each select="$method//param[$param-number]/type">
      <!-- add the current param to the stack -->
      <xsl:variable name="next-type-list">
        <xsl:value-of select="$type-list"/>
        <xsl:value-of select="position()"/>
      </xsl:variable>
      <!-- if we are on the last param -->
      <xsl:if test="$is-last">
        <!-- print next-type-list -->
        <xsl:element name="method">
          <!--<xsl:attribute name="typeList"><xsl:value-of select="$next-type-list"/></xsl:attribute>-->
          <xsl:copy-of select="$method/@*"/>
          <xsl:call-template name="outputParamElements">
            <xsl:with-param name="method" select="$method"/>
            <xsl:with-param name="type-list" select="$next-type-list"/>
          </xsl:call-template>
          <xsl:copy-of select="../../return"/>
          <xsl:copy-of select="../../text"/>
        </xsl:element>
      </xsl:if>
      <!-- if we are NOT on the last param -->
      <xsl:if test="not($is-last)">
        <!-- continue recursing -->
        <xsl:call-template name="recurseOverTypesInParam">
          <xsl:with-param name="method" select="$method"/>
          <xsl:with-param name="param-number" select="$param-number + 1"/>
          <xsl:with-param name="type-list" select="$next-type-list"/>
        </xsl:call-template>
      </xsl:if>
    </xsl:for-each>
  </xsl:template>

  <xsl:template name="outputParamElements">
    <xsl:param name="method"/>
    <xsl:param name="type-list"/>
    <xsl:param name="output-param" select="1"/>
    <!-- Pick off the first character in the list -->
    <xsl:variable name="type-number" select="number(substring($type-list, 1, 1))"/>
    <!-- Output a param element with a type element for this position -->
    <xsl:element name="param">
      <!--<xsl:attribute name="paramsFrom"><xsl:value-of select="$output-param"/></xsl:attribute>-->
      <xsl:variable name="selected-param" select="$method/param[$output-param]"/>
      <xsl:copy-of select="$selected-param/@*"/>
      <xsl:element name="type">
        <!--<xsl:attribute name="typesFrom"><xsl:value-of select="$type-number"/></xsl:attribute>-->
        <xsl:variable name="selected-type" select="$selected-param/type[$type-number]"/>
        <xsl:copy-of select="$selected-type/@*"/>
      </xsl:element>
    </xsl:element>
    <!-- If there are more positions, recurse -->
    <xsl:variable name="remaining-type-list"><xsl:value-of select="substring($type-list, 2)"/></xsl:variable>
    <xsl:if test="string-length($remaining-type-list) != 0">
      <xsl:call-template name="outputParamElements">
        <xsl:with-param name="method" select="$method"/>
        <xsl:with-param name="type-list" select="$remaining-type-list"/>
        <xsl:with-param name="output-param" select="$output-param + 1"/>
      </xsl:call-template>
    </xsl:if>
  </xsl:template>

</xsl:stylesheet>
