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

import org.directwebremoting.convert.BeanConverter;
import org.directwebremoting.convert.StringConverter;
import org.directwebremoting.dwrp.DefaultConverterManager;
import org.directwebremoting.extend.Converter;
import org.directwebremoting.extend.InboundContext;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.MarshallException;

import junit.framework.TestCase;

/**
 * @author Bram Smeets
 */
public class DefaultConverterManagerTests extends TestCase
{
    private DefaultConverterManager manager = new DefaultConverterManager();

    public void testAddConverterType()
    {
        try
        {
            manager.addConverterType(null, null);
            fail("a null pointer exception was expected");
        }
        catch (NullPointerException e)
        {
            // do nothing, was expected
        }

        try
        {
            manager.addConverterType(null, Converter.class.getName());
            fail("an illegal argument exception was expected");
        }
        catch (IllegalArgumentException e)
        {
            // do nothing, was expected
        }

        manager.addConverterType(null, BeanConverter.class.getName());
    }

    public void testAddConverter() throws Exception
    {
        manager.addConverter(null, null);

        manager.addConverter(null, null, null);
    }

    public void testConvertInbound() throws Exception
    {
        try
        {
            manager.convertInbound(null, null, null, null);
            fail("a null pointer exception was expected");
        }
        catch (NullPointerException e)
        {
            // do nothing, was expected
        }

        InboundContext ctx = new InboundContext();
        try
        {
            manager.convertInbound(null, null, ctx, null);
            fail("a null pointer exception was expected");
        }
        catch (NullPointerException e)
        {
            // do nothing, was expected
        }

        try
        {
            manager.convertInbound(String.class, null, ctx, null);
            fail("a conversion exception was expected");
        }
        catch (MarshallException e)
        {
            // do nothing, was expected
        }

        manager.addConverter("java.lang.String", new StringConverter());
        try
        {
            manager.convertInbound(String.class, null, ctx, null);
            fail("a null pointer exception was expected");
        }
        catch (NullPointerException e)
        {
            // do nothing, was expected
        }

        InboundVariable var = new InboundVariable(ctx, "e_1", "string", "bla");
        manager.convertInbound(String.class, var, ctx, null);
    }

    public void testConvertOutbound() throws Exception
    {
        manager.convertOutbound(null, null);
    }
}
