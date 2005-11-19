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

package uk.ltd.getahead.dwr.convert;

import junit.framework.TestCase;
import uk.ltd.getahead.dwr.*;

import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * The tests for the <code>BigNumberConverter</code> class.
 *
 * @see BigNumberConverter
 *
 * @author Bram Smeets
 */
public class BigNumberConverterTests extends TestCase {
    private BigNumberConverter converter = new BigNumberConverter();

    public void testConvertOutbound() throws Exception {
        OutboundContext ctx = new OutboundContext();

        OutboundVariable result = converter.convertOutbound(new BigInteger("23"), ctx);

        assertNotNull(result);
        assertEquals("23", result.getAssignCode());
        assertEquals("", result.getInitCode());
    }

    public void testConvertInboundBigInteger() throws Exception {
        InboundContext ctx = new InboundContext();
        InboundVariable iv = new InboundVariable(ctx, "type", "23");

        Object result = converter.convertInbound(BigInteger.class, iv, ctx);

        assertNotNull(result);
        assertTrue(result instanceof BigInteger);
        assertEquals(new BigInteger("23"), result);
    }

    public void testConvertInboundBigDecimal() throws Exception {
        InboundContext ctx = new InboundContext();
        InboundVariable iv = new InboundVariable(ctx, "type", "23");

        Object result = converter.convertInbound(BigDecimal.class, iv, ctx);

        assertNotNull(result);
        assertTrue(result instanceof BigDecimal);
        assertEquals(new BigDecimal("23"), result);
    }

    public void testConvertInboundNotANumber() throws Exception {
        InboundContext ctx = new InboundContext();
        InboundVariable iv = new InboundVariable(ctx, "type", "a23");

        try {
            converter.convertInbound(BigDecimal.class, iv, ctx);
            fail("a conversion exception was expected");
        } catch (ConversionException e) {
            // do nothing, was expected
        }
    }

    public void testConvertInboundNotAPrimitive() throws Exception {
        InboundContext ctx = new InboundContext();
        InboundVariable iv = new InboundVariable(ctx, "type", "23");

        try {
            converter.convertInbound(String.class, iv, ctx);
            fail("a conversion exception was expected");
        } catch (ConversionException e) {
            // do nothing, was expected
        }
    }
}