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
import uk.ltd.getahead.dwr.InboundContext;
import uk.ltd.getahead.dwr.InboundVariable;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;

/**
 * The tests for the <code>ObjectConverter</code> class.
 * @see ObjectConverter
 * @author Bram Smeets
 */
public class ObjectConverterTests extends TestCase
{
    private ObjectConverter converter = new ObjectConverter();

    /**
     * @throws Exception
     */
    public void testConvertOutbound() throws Exception
    {
        OutboundContext ctx = new OutboundContext();

        OutboundVariable result = converter.convertOutbound(this, ctx);

        assertNotNull(result);
        assertEquals("s0", result.getAssignCode());
        assertTrue(result.getInitCode().startsWith("var s0={};"));
    }

    /**
     * @throws Exception
     */
    public void testConvertInbound() throws Exception
    {
        InboundContext ctx = new InboundContext();
        InboundVariable iv = new InboundVariable(ctx, null, "type", "{ value : value }");

        Object result = converter.convertInbound(String.class, iv, ctx);

        assertNotNull(result);
    }
}
