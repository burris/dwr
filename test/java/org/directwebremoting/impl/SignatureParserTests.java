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
package org.directwebremoting.impl;

import junit.framework.TestCase;

import org.directwebremoting.extend.ConverterManager;
import org.directwebremoting.extend.CreatorManager;
import org.directwebremoting.extend.TypeHintContext;
import org.directwebremoting.impl.SignatureParser;
import org.easymock.EasyMock;


/**
 * @author Bram Smeets
 */
public class SignatureParserTests extends TestCase
{
    private SignatureParser parser;

    private ConverterManager converterManager;

    private CreatorManager creatorManager;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        converterManager = EasyMock.createMock(ConverterManager.class);
        creatorManager = EasyMock.createMock(CreatorManager.class);

        parser = new SignatureParser(converterManager, creatorManager);
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
        converterManager.setExtraTypeInfo((TypeHintContext) EasyMock.isA(TypeHintContext.class), EasyMock.eq(Integer.class));

        EasyMock.replay(converterManager);

        parser.parse("import java.util.*;\n" + "  import org.directwebremoting.impl.test.SignatureTestsObject;\n"
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
