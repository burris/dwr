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

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * The tests for the <code>DateConverter</code> class.
 *
 * @see DateConverter
 *
 * @author Bram Smeets
 */
public class DateConverterTests extends TestCase
{
    private DateConverter converter = new DateConverter();

    private static final DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * @throws Exception
     */
    public void testConvertOutbound() throws Exception
    {
        OutboundContext ctx = new OutboundContext();

        OutboundVariable result = converter.convertOutbound(format.parse("01-01-2005"), ctx);

        assertNotNull(result);
        assertEquals("new Date(1104534000000)", result.getAssignCode());
        assertEquals("", result.getInitCode());

        // try to convert a non-date object
        try
        {
            converter.convertOutbound("01-01-2005", ctx);
            fail("a conversion exception was expected");
        }
        catch (ConversionException e)
        {
            // do nothing, was expected
        }
    }

    /**
     * @throws Exception
     */
    public void testConvertInbound() throws Exception
    {
        InboundContext ctx = new InboundContext();
        InboundVariable iv = new InboundVariable(ctx, null, "type", "null");

        Object result = converter.convertInbound(Date.class, iv, ctx);
        assertNull(result);

        iv = new InboundVariable(ctx, null, "type", "1104534000000");
        result = converter.convertInbound(Date.class, iv, ctx);

        assertNotNull(result);
        assertTrue(result instanceof Date);
        assertEquals(format.parse("01-01-2005"), result);

        result = converter.convertInbound(java.sql.Date.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof java.sql.Date);

        result = converter.convertInbound(Time.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Time);

        result = converter.convertInbound(Timestamp.class, iv, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Timestamp);

        // try to convert a non-supported type
        try
        {
            converter.convertInbound(String.class, iv, ctx);
            fail("a conversion exception was expected");
        }
        catch (ConversionException e)
        {
            // do nothing, was expected
        }
    }
}
