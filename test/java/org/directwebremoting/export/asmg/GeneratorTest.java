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
package org.directwebremoting.export.asmg;

import org.getahead.dwrdemo.asmg.Generator;

import junit.framework.TestCase;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class GeneratorTest extends TestCase
{
    /*
     * Test method for 'org.directwebremoting.export.asmg.Generator.generateAntiSpamMailto(String)'
     */
    public void testGenerateAntiSpamMailto()
    {
        assertEquals(generator.generateAntiSpamMailto("the helpdesk", "support@example.com"), result1);
        assertEquals(generator.generateAntiSpamMailto("Fred Nowhere", "fred@nowhere.com"), result2);

        try
        {
            generator.generateAntiSpamMailto("Fred Nowhere", "fred at nowhere.com");
            fail();
        }
        catch (IllegalArgumentException ex)
        {
            // Expected
        }
    }

    private Generator generator = new Generator();

    private String result1 = "Contact us using:\n" +
            "<script type='text/javascript'>\n" +
            "var a = 'support@example.com';\n" +
            "document.write(\"<a href='mail\" + \"to:\" + a + \"'>\" + a + \"</a>\");\n" +
            "</script>\n" +
            "<noscript>[support at example.com]</noscript>\n";

    private String result2 = "Contact us using:\n" +
            "<script type='text/javascript'>\n" +
            "var a = 'fred@nowhere.com';\n" +
            "document.write(\"<a href='mail\" + \"to:\" + a + \"'>\" + a + \"</a>\");\n" +
            "</script>\n" +
            "<noscript>[fred at nowhere.com]</noscript>\n";
}
