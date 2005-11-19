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

package uk.ltd.getahead.dwr.impl;

import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

import uk.ltd.getahead.dwr.ConverterManager;

import java.lang.reflect.Method;

/**
 * @author Bram Smeets
 */
public class SignatureParserTests extends TestCase {
    private SignatureParser parser;

    private ConverterManager converterManager;

    protected void setUp() throws Exception {
        super.setUp();

        converterManager = createMock(ConverterManager.class);

        parser = new SignatureParser(converterManager);
    }

    public void testParseEmptyString() throws Exception {
        replay(converterManager);

        parser.parse("");

        verify(converterManager);
    }

    public void testParse1() {
        converterManager.setExtraTypeInfo((Method)isA(Method.class), eq(0), eq(0), eq(Integer.class));

        replay(converterManager);

        parser.parse("import java.util.*;\n" +
                "  import uk.ltd.getahead.dwr.impl.test.SignatureTestsObject;\n" +
                "  public void SignatureTestsObject.setLotteryResults(List<Integer> nos);");

        verify(converterManager);
    }

     public void testParse2() {
        replay(converterManager);

        parser.parse("import java.util.List;\n" +
               "   SignatureTestsObject.setLotteryResults(List<Integer>);");

        verify(converterManager);
    }
}