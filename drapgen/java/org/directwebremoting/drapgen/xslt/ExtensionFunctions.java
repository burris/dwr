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
package org.directwebremoting.drapgen.xslt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.directwebremoting.drapgen.Generate;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ExtensionFunctions
{
    public static String trim(String source)
    {
        return source.trim();
    }

    public static boolean isSuperClass(String className)
    {
        return Generate.sources.get(className).isSuperClass();
    }

    /**
     * @param original
     * @return
     */
    public static String normalizeClassname(String original)
    {
        for (String[] swap : swaps)
        {
            Pattern pattern = Pattern.compile(swap[SEARCH], Pattern.UNIX_LINES);
            Matcher matcher = pattern.matcher(original);
            if (matcher.find())
            {
                return matcher.replaceAll(swap[REPLACE]);
            }
        }

        return original;
    }

    private static final int SEARCH = 0;
    private static final int REPLACE = 1;
    private static final String[][] swaps = new String[][]
    {
        { "^Number$", "int" },
        { "^jsx3\\.lang\\.Class$", "Class" },
        { "^Array$", "Object[]" },
        { "^Function$", "org.directwebremoting.proxy.CodeBlock" },
        { "^jsx3\\.app\\.Properties$", "java.util.Properties" },
        { "^jsx3\\.lang\\.Exception$", "Exception" },
        { "^jsx3\\.Boolean$", "Boolean" },
        { "^HTMLElement$", "String" },
        { "^jsx3\\.lang\\.IllegalArgumentException$", "IllegalArgumentException" },
        { "^jsx3\\.(.*)$", "org.directwebremoting.proxy.jsx3.$1" },
    };

    /*
    <xsl:template name="normalizeClassname2">
      <xsl:param name="class"/>
      <xsl:choose>
        <xsl:when test="$class = 'Number'">
          <xsl:value-of select="'int'"/>
        </xsl:when>
        <xsl:when test="$class = 'jsx3.lang.Class'">
          <xsl:value-of select="'Class'"/>
        </xsl:when>
        <xsl:when test="$class = 'Array'">
          <xsl:value-of select="'Object[]'"/>
        </xsl:when>
        <xsl:when test="$class = 'Function'">
          <xsl:value-of select="'String'"/>
        </xsl:when>
        <xsl:when test="$class = 'jsx3.lang.Exception'">
          <xsl:value-of select="'Exception'"/>
        </xsl:when>
        <xsl:when test="$class = 'jsx3.Boolean'">
          <xsl:value-of select="'Boolean'"/>
        </xsl:when>
        <xsl:when test="$class = 'HTMLElement'">
          <xsl:value-of select="'String'"/>
        </xsl:when>
        <xsl:when test="$class = 'jsx3.lang.IllegalArgumentException'">
          <xsl:value-of select="'IllegalArgumentException'"/>
        </xsl:when>
        <xsl:when test="starts-with($class, 'jsx3.')">
          <xsl:value-of select="concat('org.directwebremoting.proxy.', $class)"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$class"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>
     */
}
