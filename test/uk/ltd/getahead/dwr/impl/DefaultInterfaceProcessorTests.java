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

import javax.servlet.http.HttpServletRequest;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.create.NewCreator;
import uk.ltd.getahead.dwr.impl.test.TestCreatedObject;
import uk.ltd.getahead.dwr.servlet.DefaultInterfaceProcessor;

/**
 * @author Bram Smeets
 */
public class DefaultInterfaceProcessorTests extends TestCase
{
    private DefaultInterfaceProcessor defaultInterfaceProcessor = new DefaultInterfaceProcessor();

    private CreatorManager creatorManager;

    private AccessControl accessControl;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    protected void setUp() throws Exception
    {
        super.setUp();

        creatorManager = (CreatorManager) EasyMock.createMock(CreatorManager.class);
        defaultInterfaceProcessor.setCreatorManager(creatorManager);

        accessControl = (AccessControl) EasyMock.createMock(AccessControl.class);
        defaultInterfaceProcessor.setAccessControl(accessControl);

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    public void testHandle() throws Exception
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

        defaultInterfaceProcessor.handle(request, response);

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);

        // check the response
        String result = response.getContentAsString();
        assertTrue(result.indexOf("function creatorName() { }") != -1);
        assertTrue(result.indexOf("creatorName.hashCode = function(callback)") != -1);
        assertTrue(result.indexOf("creatorName.getClass = function(callback)") != -1);
        assertTrue(result.indexOf("creatorName.wait = function(callback)") != -1);
        assertTrue(result.indexOf("creatorName.wait = function(p0, p1, callback)") != -1);
        assertTrue(result.indexOf("creatorName.wait = function(p0, callback)") != -1);
        assertTrue(result.indexOf("creatorName.equals = function(p0, callback)") != -1);
        assertTrue(result.indexOf("creatorName.notify = function(callback)") != -1);
        assertTrue(result.indexOf("creatorName.notifyAll = function(callback)") != -1);
        assertTrue(result.indexOf("creatorName.toString = function(callback)") != -1);
        assertTrue(result.indexOf("creatorName.testMethodWithServletParameters = function(callback)") != -1);

        // make sure no entry is generated for the reserved javvascript word 'namespace'
        assertFalse(result.indexOf("creatorName.namespace = function(callback)") != -1);
    }

    public void testHandleWithoutInterface() throws Exception
    {
        creatorManager.getCreator("");
        EasyMock.expectLastCall().andThrow(new SecurityException());

        EasyMock.replay(creatorManager);
        EasyMock.replay(accessControl);

        try
        {
            defaultInterfaceProcessor.handle(request, response);
            fail("a security exception was expected");
        }
        catch (SecurityException e)
        {
            // do nothing, was expected
        }

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);
    }

    public void testHandleWithReasonsNotToDisplay() throws Exception
    {
        // make sure not to allow an impossible test
        defaultInterfaceProcessor.setAllowImpossibleTests(false);

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

        defaultInterfaceProcessor.handle(request, response);

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);

        // check the response
        String result = response.getContentAsString();
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
