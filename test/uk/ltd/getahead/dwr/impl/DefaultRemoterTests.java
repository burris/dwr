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
import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.springframework.mock.web.MockHttpServletRequest;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilter;
import uk.ltd.getahead.dwr.AjaxFilterChain;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.Calls;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.HttpResponse;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.create.NewCreator;
import uk.ltd.getahead.dwr.impl.test.TestCreatedObject;
import uk.ltd.getahead.dwr.impl.test.TestWebContextFactory;
import uk.ltd.getahead.dwr.servlet.RequestParser;
import uk.ltd.getahead.dwr.servlet.ServletHttpRequest;

/**
 * @author
 */
public class DefaultRemoterTests extends TestCase
{
    private DefaultRemoter defaultRemoter = new DefaultRemoter();

    private CreatorManager creatorManager;

    private AccessControl accessControl;

    private ConverterManager converterManager;

    private AjaxFilterManager ajaxFilterManager;

    private MockHttpServletRequest request;

    private RequestParser requestParser = new RequestParser();

    protected void setUp() throws Exception
    {
        super.setUp();

        creatorManager = (CreatorManager) EasyMock.createMock(CreatorManager.class);
        defaultRemoter.setCreatorManager(creatorManager);

        accessControl = (AccessControl) EasyMock.createMock(AccessControl.class);
        defaultRemoter.setAccessControl(accessControl);

        converterManager = (ConverterManager) EasyMock.createMock(ConverterManager.class);
        defaultRemoter.setConverterManager(converterManager);

        ajaxFilterManager = (AjaxFilterManager) EasyMock.createMock(AjaxFilterManager.class);
        defaultRemoter.setAjaxFilterManager(ajaxFilterManager);

        request = new MockHttpServletRequest();
    }

    /**
     * @throws Exception
     */
    public void testHandle() throws Exception
    {
        request.setPathInfo("/exec/dataManager.doTest");
        request.setMethod("POST");
        request.setContent(("callCount=2\n" + "c0-id=1\nc0-scriptName=creatorName\nc0-methodName=toString\n"
            + "c1-id=2\nc1-scriptName=creatorName\nc1-methodName=hashCode").getBytes());

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        EasyMock.expectLastCall().andReturn(creator).times(4);

        EasyMock.expect(accessControl.getReasonToNotExecute((Creator) EasyMock.eq(creator), (String) EasyMock.eq("creatorName"), (Method) EasyMock.isA(Method.class)));
        EasyMock.expectLastCall().andReturn(null).times(2);

        EasyMock.expect(converterManager.convertOutbound(EasyMock.isA(Object.class), (OutboundContext) EasyMock.isA(OutboundContext.class)));
        EasyMock.expectLastCall().andReturn(new OutboundVariable()).times(2);

        // TODO: this should not be neccessary!
        ArrayList filters = new ArrayList();
        filters.add(new AjaxFilter()
        {
            public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception
            {
                return new Object();
            }
        });
        filters.add(new AjaxFilter()
        {
            public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception
            {
                return new Object();
            }
        });
        EasyMock.expect(ajaxFilterManager.getAjaxFilters("creatorName")).andReturn(filters.iterator()).atLeastOnce();

        EasyMock.replay(creatorManager);
        EasyMock.replay(accessControl);
        EasyMock.replay(converterManager);
        EasyMock.replay(ajaxFilterManager);

        DefaultWebContextBuilder builder = new DefaultWebContextBuilder();
        builder.set(request, null, null, null, null);
        TestWebContextFactory.setWebContextBuilder(builder);

        Calls calls = requestParser.parseRequest(new ServletHttpRequest(request));
        HttpResponse response = defaultRemoter.execute(calls);

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);
        EasyMock.verify(converterManager);
        EasyMock.verify(ajaxFilterManager);

        String result = new String(response.getBody());
        assertNotNull(result);
        assertTrue(result.indexOf("<script type='text/javascript'>") != -1);
        assertTrue(result.indexOf("window.parent.DWREngine._handleResponse('1',") != -1);
        assertTrue(result.indexOf("window.parent.DWREngine._handleResponse('2',") != -1);
        assertTrue(result.indexOf("</script>") != -1);
    }

    /**
     * @throws Exception
     */
    public void testHandle2() throws Exception
    {
        request.setPathInfo("/interface/creatorName.js");

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        EasyMock.expectLastCall().andReturn(creator);

        // expect 9 method calls to 'getReasonToNotDisplay' for each method on Object
        EasyMock.expect(accessControl.getReasonToNotDisplay((Creator) EasyMock.eq(creator), (String) EasyMock.eq("creatorName"), (Method) EasyMock.isA(Method.class)));
        EasyMock.expectLastCall().andReturn(null).times(11);

        EasyMock.replay(creatorManager);
        EasyMock.replay(accessControl);

        HttpResponse response = defaultRemoter.generateInterfaceScript("creatorName", "/path");

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);

        // check the response
        String result = new String(response.getBody());
        assertTrue(result.indexOf("function creatorName() { }") != -1);
        assertTrue(result.indexOf("creatorName.hashCode = function(") != -1);
        assertTrue(result.indexOf("creatorName.getClass = function(") != -1);
        assertTrue(result.indexOf("creatorName.wait = function(") != -1);
        assertTrue(result.indexOf("creatorName.wait = function(") != -1);
        assertTrue(result.indexOf("creatorName.wait = function(") != -1);
        assertTrue(result.indexOf("creatorName.equals = function(") != -1);
        assertTrue(result.indexOf("creatorName.notify = function(") != -1);
        assertTrue(result.indexOf("creatorName.notifyAll = function(") != -1);
        assertTrue(result.indexOf("creatorName.toString = function(") != -1);
        assertTrue(result.indexOf("creatorName.testMethodWithServletParameters = function(") != -1);

        // make sure no entry is generated for the reserved javvascript word 'namespace'
        assertFalse(result.indexOf("creatorName.namespace = function(") != -1);
    }

    /**
     * @throws Exception
     */
    public void testHandleWithoutInterface() throws Exception
    {
        request.setMethod("GET");

        creatorManager.getCreator("");
        EasyMock.expectLastCall().andThrow(new SecurityException());

        EasyMock.replay(creatorManager);
        EasyMock.replay(accessControl);

        try
        {
            Calls calls = requestParser.parseRequest(new ServletHttpRequest(request));
            defaultRemoter.execute(calls);
            fail("a security exception was expected");
        }
        catch (SecurityException e)
        {
            // do nothing, was expected
        }

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);
    }

    /**
     * @throws Exception
     */
    public void testHandleWithReasonsNotToDisplay() throws Exception
    {
        request.setMethod("GET");
        
        // make sure not to allow an impossible test
        defaultRemoter.setAllowImpossibleTests(false);

        request.setPathInfo("/interface/creatorName.js");

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        EasyMock.expectLastCall().andReturn(creator);

        // expect 9 method calls to 'getReasonToNotDisplay' for each method on Object
        EasyMock.expect(accessControl.getReasonToNotDisplay((Creator) EasyMock.eq(creator), (String) EasyMock.eq("creatorName"), (Method) EasyMock.isA(Method.class)));
        EasyMock.expectLastCall().andReturn("myReason").times(11);

        EasyMock.replay(creatorManager);
        EasyMock.replay(accessControl);

        Calls calls = requestParser.parseRequest(new ServletHttpRequest(request));
        HttpResponse response = defaultRemoter.execute(calls);

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);

        // check the response
        String result = new String(response.getBody());
        assertTrue(result.indexOf("function creatorName() { }") != -1);
        assertFalse(result.indexOf("creatorName.hashCode = function(callback)") != -1);
        assertFalse(result.indexOf("creatorName.getClass = function(callback)") != -1);
        assertFalse(result.indexOf("creatorName.wait = function(callback)") != -1);
        assertFalse(result.indexOf("creatorName.wait = function(p0, p1, callback)") != -1);
        assertFalse(result.indexOf("creatorName.wait = function(p0, callback)") != -1);
        assertFalse(result.indexOf("creatorName.equals = function(p0, callback)") != -1);
        assertFalse(result.indexOf("creatorName.notify = function(callback)") != -1);
        assertFalse(result.indexOf("creatorName.notifyAll = function(callback)") != -1);
        assertFalse(result.indexOf("creatorName.toString = function(callback)") != -1);
        assertFalse(result.indexOf("creatorName.testMethodWithServletParameters = function(callback)") != -1);
        assertFalse(result.indexOf("creatorName.namespace = function(callback)") != -1);
    }
}
