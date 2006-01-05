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

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.TypeHintContext;

/**
 * @author Bram Smeets
 */
public class SignatureParserTests extends TestCase
{
    private SignatureParser parser;

    private ConverterManager converterManager;

    protected void setUp() throws Exception
    {
        super.setUp();

        converterManager = (ConverterManager) EasyMock.createMock(ConverterManager.class);

        parser = new SignatureParser(converterManager);
    }

    /**
     * @throws Exception
     */
    public void testParseEmptyString() throws Exception
    {
        EasyMock.replay(converterManager);

        parser.parse("");

        EasyMock.verify(converterManager);
    }

    /**
     * 
     */
    public void testParse1()
    {
        //TypeHintContext thc = new TypeHintContext((Method) EasyMock.isA(Method.class), EasyMock.eq(0));
        converterManager.setExtraTypeInfo((TypeHintContext)EasyMock.isA(TypeHintContext.class), (Class)EasyMock.eq(Integer.class));

        EasyMock.replay(converterManager);

        parser.parse("import java.util.*;\n" + "  import uk.ltd.getahead.dwr.impl.test.SignatureTestsObject;\n"
            + "  public void SignatureTestsObject.setLotteryResults(List<Integer> nos);");

        EasyMock.verify(converterManager);
    }

    /**
     * 
     */
    public void testParse2()
    {
        EasyMock.replay(converterManager);

        parser.parse("import java.util.List;\n" + "   SignatureTestsObject.setLotteryResults(List<Integer>);");

        EasyMock.verify(converterManager);
    }
}
