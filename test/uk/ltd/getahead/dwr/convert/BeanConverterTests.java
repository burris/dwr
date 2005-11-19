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

import static org.easymock.EasyMock.*;
import junit.framework.TestCase;

import uk.ltd.getahead.dwr.*;
import uk.ltd.getahead.dwr.convert.test.MyBeanImpl;

/**
 * The tests for the <code>BeanConverter</code> class.
 *
 * @see BeanConverter
 *
 * @author Bram Smeets
 */
public class BeanConverterTests extends TestCase {
    private BeanConverter converter = new BeanConverter();
    private ConverterManager manager;

    protected void setUp() throws Exception {
        manager = createMock(ConverterManager.class);
        converter.setConverterManager(manager);
    }

    public void testSetImplementation() throws Exception {
        try {
            converter.setImplementation("UnknownClass");
            fail("a class not found exception was expected");
        } catch (ClassNotFoundException e) {
            // do nothing, was expected
        }

        converter.setImplementation(MyBeanImpl.class.getName());
        assertEquals(MyBeanImpl.class, converter.getInstanceType());
    }

    public void testConvertInboundWithNull() throws Exception {
        InboundVariable var = new InboundVariable(null, null, "null");

        Object result = converter.convertInbound(null, var, null);
        assertNull(result);
    }

    public void testConvertInboundWithInvalidArguments() throws Exception {
        // test with missing map start in the variable value
        InboundVariable var = new InboundVariable(null, null, "value");
        try {
            converter.convertInbound(null, var, null);
        } catch (IllegalArgumentException e) {
            // do nothing, was expected
        }

        // test with missing map end in the variable value
        var = new InboundVariable(null, null, "{ value");
        try {
            converter.convertInbound(null, var, null);
        } catch (IllegalArgumentException e) {
            // do nothing, was expected
        }
    }

    public void testConvertInbound() throws Exception {
        // also test with an instance type
        InboundContext ctx = new InboundContext();
        InboundVariable var = new InboundVariable(null, "type", "{ property: bla }");
        converter.setInstanceType(MyBeanImpl.class);

        expect(manager.convertInbound(eq(String.class), (InboundVariable)isA(InboundVariable.class), eq(ctx))).andReturn("bla");
        replay(manager);

        Object result = converter.convertInbound(Object.class, var, ctx);
        assertNotNull(result);
        assertTrue(result instanceof MyBeanImpl);
        MyBeanImpl bean = (MyBeanImpl) result;
        assertEquals("bla", bean.getProperty());

        verify(manager);
    }

    public void testConvertInboundExceptions() throws Exception {
        try {
            converter.convertInbound(null, null, null);
            fail("a null pointer exception was expected");
        } catch(NullPointerException e) {
            // do nothing, was expected
        }

        InboundVariable var = new InboundVariable(null, null, null);
        try {
            converter.convertInbound(null, var, null);
            fail("a null pointer exception was expected");
        } catch(NullPointerException e) {
            // do nothing, was expected
        }

        var = new InboundVariable(null, null, "value");
        try {
            converter.convertInbound(null, var, null);
            fail("an illegal argument exception was expected");
        } catch(IllegalArgumentException e) {
            // do nothing, was expected
        }

        var = new InboundVariable(null, null, "{ value }");
        try {
            converter.convertInbound(null, var, null);
            fail("a conversion exception was expected");
        } catch(ConversionException e) {
            // do nothing, was expected
        }

        try {
            converter.convertInbound(Object.class, var, null);
            fail("a conversion exception was expected");
        } catch(ConversionException e) {
            // do nothing, was expected
        }

        InboundContext ctx = new InboundContext();
        // TODO: this is an error due to a null pointer exception in hashcode of InboundVariable. This should be fixed!
        try {
            converter.convertInbound(Object.class, var, ctx);
            fail("a conversion exception was expected");
        } catch(ConversionException e) {
            // do nothing, was expected
        }

        var = new InboundVariable(null, "type", "{ value }");
        try {
            converter.convertInbound(Object.class, var, ctx);
            fail("a conversion exception was expected");
        } catch(ConversionException e) {
            // do nothing, was expected
        }

        var = new InboundVariable(null, "type", "{ value: , }");
        Object result = converter.convertInbound(Object.class, var, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Object);

        var = new InboundVariable(null, "type", "{ value: , }");
        result = converter.convertInbound(Object.class, var, ctx);
        assertNotNull(result);
        assertTrue(result instanceof Object);
    }

    public void testConvertOutbound() throws Exception {
        OutboundContext ctx = new OutboundContext();

        expect(manager.convertOutbound("bla", ctx)).andReturn(new OutboundVariable());
        replay(manager);

        MyBeanImpl bean = new MyBeanImpl();
        bean.setProperty("bla");
        OutboundVariable result = converter.convertOutbound(bean, ctx);
        assertNotNull(result);
        assertEquals("s0", result.getAssignCode());
        assertTrue(result.getInitCode().startsWith("var s0={property:"));

        verify(manager);
    }

    public void testConvertOutboundWithInclusionsAndExclusions() throws Exception {
        converter.setInclude("bla, getSomething");
        try {
            converter.setExclude("bla");
            fail("an illegal argument exception was expected");
        } catch (Exception e) {
            // do nothing, was expected
        }
    }

    public void testConvertOutboundWithExclusionsAndInclusions() throws Exception {
        converter.setExclude("bla, getSomething");
        try {
            converter.setInclude("bla");
            fail("an illegal argument exception was expected");
        } catch (Exception e) {
            // do nothing, was expected
        }
    }

    public void testConvertOutboundWithInclusions() throws Exception {
        OutboundContext ctx = new OutboundContext();

        converter.setInclude("property, getSomething");

        expect(manager.convertOutbound("bla", ctx)).andReturn(new OutboundVariable());
        replay(manager);

        MyBeanImpl bean = new MyBeanImpl();
        bean.setProperty("bla");
        OutboundVariable result = converter.convertOutbound(bean, ctx);
        assertNotNull(result);
        assertEquals("s0", result.getAssignCode());
        assertTrue(result.getInitCode().startsWith("var s0={property:"));

        verify(manager);
    }

    public void testConvertOutboundWithExclusions() throws Exception {
        OutboundContext ctx = new OutboundContext();

        converter.setExclude("property, getSomething");

        replay(manager);

        MyBeanImpl bean = new MyBeanImpl();
        bean.setProperty("bla");
        OutboundVariable result = converter.convertOutbound(bean, ctx);
        assertNotNull(result);
        assertEquals("s0", result.getAssignCode());
        assertTrue(result.getInitCode().startsWith("var s0={};"));

        verify(manager);
    }

    public void testConvertOutboundExceptions() throws Exception {
        try {
            converter.convertOutbound(null, null);
            fail("a null pointer exception was expected");
        } catch(NullPointerException e) {
            // do nothing, was expected
        }

        OutboundContext ctx = new OutboundContext();

        try {
            converter.convertOutbound(null, ctx);
            fail("a null pointer exception was expected");
        } catch(NullPointerException e) {
            // do nothing, was expected
        }

        OutboundVariable result = converter.convertOutbound(new Object(), ctx);
        assertNotNull(result);
        assertEquals("s1", result.getAssignCode());
        assertTrue(result.getInitCode().startsWith("var s1={};"));
    }
}