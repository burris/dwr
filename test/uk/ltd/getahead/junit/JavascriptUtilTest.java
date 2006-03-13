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
package uk.ltd.getahead.junit;

import junit.framework.TestCase;
import uk.ltd.getahead.dwr.util.JavascriptUtil;

/**
 * JUnit
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class JavascriptUtilTest extends TestCase
{
    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.compress(String, int)'
     */
    public void testCompress()
    {
        assertEquals(JavascriptUtil.compress(" aaa \n aa \n", JavascriptUtil.COMPRESS_TRIM_LINES), "aaa\naa\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.compress("//aaa//bbbb\nxx //aaa\n", JavascriptUtil.COMPRESS_STRIP_SL_COMMENTS), "\nxx \n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.compress("a/*\n*/a\n", JavascriptUtil.COMPRESS_STRIP_ML_COMMENTS), "a \na\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.compress("a\n\na\n", JavascriptUtil.COMPRESS_STRIP_BLANKLINES), "a\na\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.compress("a\nb\n", JavascriptUtil.COMPRESS_REMOVE_NEWLINES), "a b \n"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.stripSpaces(String)'
     */
    public void testStripSpaces()
    {
        assertEquals(JavascriptUtil.trimLines("\n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.trimLines(null), null);

        assertEquals(JavascriptUtil.trimLines("a a\n"), "a a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.trimLines("aaa\n"), "aaa\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.trimLines(" a a \n"), "a a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.trimLines(" aaa \n"), "aaa\n"); //$NON-NLS-1$ //$NON-NLS-2$

        assertEquals(JavascriptUtil.trimLines(" aaa \n aa \n"), "aaa\naa\n"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.stripSingleLineComments(String)'
     */
    public void testStripSingleLineComments()
    {
        assertEquals(JavascriptUtil.stripSingleLineComments("\n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripSingleLineComments(null), null);

        assertEquals(JavascriptUtil.stripSingleLineComments("a\n"), "a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripSingleLineComments("/a\n"), "/a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripSingleLineComments("/a/a\n"), "/a/a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripSingleLineComments("/ /\n"), "/ /\n"); //$NON-NLS-1$ //$NON-NLS-2$

        assertEquals(JavascriptUtil.stripSingleLineComments("//\n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripSingleLineComments("//aaa\n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripSingleLineComments("//aaa\naaa\n"), "\naaa\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripSingleLineComments("//aaa//bbbb\naaa\n"), "\naaa\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripSingleLineComments("//aaa//bbbb\nxx //aaa\n"), "\nxx \n"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.stripMultiLineComments(String)'
     */
    public void testStripMultiLineComments()
    {
        assertEquals(JavascriptUtil.stripMultiLineComments("\n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripMultiLineComments(null), null);

        assertEquals(JavascriptUtil.stripMultiLineComments("a\n"), "a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripMultiLineComments("/a\n"), "/a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripMultiLineComments("/a*a\n"), "/a*a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripMultiLineComments("/ */ *\n"), "/ */ *\n"); //$NON-NLS-1$ //$NON-NLS-2$

        assertEquals(JavascriptUtil.stripMultiLineComments("/**/\n"), " \n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripMultiLineComments("/***/\n"), " \n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripMultiLineComments("/*a*/\n"), " \n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripMultiLineComments("a/**/a\n"), "a a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripMultiLineComments("a/*\n*/a\n"), "a \na\n"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**.
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.stripBlankLines(String)'
     */
    public void testStripBlankLines()
    {
        assertEquals(JavascriptUtil.stripBlankLines("\n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripBlankLines("\n\n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripBlankLines(null), null);

        assertEquals(JavascriptUtil.stripBlankLines("a\n"), "a\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripBlankLines("a\na\n"), "a\na\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripBlankLines(" \n \n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripBlankLines(" \n\t\n#\n"), "#\n"); //$NON-NLS-1$ //$NON-NLS-2$

        assertEquals(JavascriptUtil.stripBlankLines("\n\n\n"), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripBlankLines("a\n\na\n"), "a\na\n"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.stripNewlines(String)'
     */
    public void testStripNewlines()
    {
        assertEquals(JavascriptUtil.stripNewlines(""), "\n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripNewlines("\n"), " \n"); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(JavascriptUtil.stripNewlines(null), null);

        assertEquals(JavascriptUtil.stripNewlines("a\nb\n"), "a b \n"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.shrinkVariableNames(String)'
     */
    public void testShrinkVariableNames()
    {

    }

    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.escapeJavaScript(String)'
     */
    public void testEscapeJavaScript()
    {

    }

    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.unescapeJavaScript(String)'
     */
    public void testUnescapeJavaScript()
    {

    }

    /**
     * Test method for 'uk.ltd.getahead.dwr.util.JavascriptUtil.isReservedWord(String)'
     */
    public void testIsReservedWord()
    {

    }
}
