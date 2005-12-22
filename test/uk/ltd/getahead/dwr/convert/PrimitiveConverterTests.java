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

/**
 * The tests for the <code>PrimitiveConverter</code> class.
 *
 * @see PrimitiveConverter
 *
 * @author Bram Smeets
 */
public class PrimitiveConverterTests extends TestCase
{
    private PrimitiveConverter converter = new PrimitiveConverter();

    /**
     * @throws Exception
     */
    public void testConvertOutbound() throws Exception
    {
        OutboundContext ctx = new OutboundContext();

        OutboundVariable result = converter.convertOutbound("varName", ctx);

        assertNotNull(result);
        assertEquals("varName", result.getAssignCode());
        assertEquals("", result.getInitCode());
    }

    /**
     * @throws Exception
     */
    public void testConvertInbound() throws Exception
    {
        InboundContext ctx = new InboundContext();
        InboundVariable iv = new InboundVariable(ctx, "type", "true");

        Object result = converter.convertInbound(Boolean.class, iv, ctx);
        assertNotNull(result);
        assertEquals(true, ((Boolean) result).booleanValue());

        iv = new InboundVariable(ctx, "type", "8");
        result = converter.convertInbound(Byte.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Byte);
        assertEquals(new Byte("8"), result);

        iv = new InboundVariable(ctx, "type", "");
        result = converter.convertInbound(Byte.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Byte);
        assertEquals(new Byte("0"), result);

        iv = new InboundVariable(ctx, "type", "5");
        result = converter.convertInbound(Short.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Short);
        assertEquals(new Short("5"), result);

        iv = new InboundVariable(ctx, "type", "t");
        result = converter.convertInbound(Character.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Character);
        assertEquals('t', ((Character) result).charValue());

        iv = new InboundVariable(ctx, "type", "2");
        result = converter.convertInbound(Integer.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Integer);
        assertEquals(2, ((Integer) result).intValue());

        iv = new InboundVariable(ctx, "type", "2");
        result = converter.convertInbound(Long.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Long);
        assertEquals(new Long(2), result);

        iv = new InboundVariable(ctx, "type", "2");
        result = converter.convertInbound(Float.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Float);
        assertEquals(new Float(2), result);

        iv = new InboundVariable(ctx, "type", "2");
        result = converter.convertInbound(Double.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Double);
        assertEquals(new Double(2), result);

        iv = new InboundVariable(ctx, "type", "2");
        result = converter.convertInbound(String.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof String);
        assertEquals("2", result);
    }
}
