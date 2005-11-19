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

import junit.framework.*;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.impl.test.TestCreatedObject;
import uk.ltd.getahead.dwr.create.NewCreator;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.easymock.EasyMock.*;
import java.lang.reflect.Method;

/**
 * @author Bram Smeets
 */
public class DefaultInterfaceProcessorTests extends TestCase {
    private DefaultInterfaceProcessor defaultInterfaceProcessor = new DefaultInterfaceProcessor();

    private CreatorManager creatorManager;

    private AccessControl accessControl;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    protected void setUp() throws Exception {
        super.setUp();

        creatorManager = createMock(CreatorManager.class);
        defaultInterfaceProcessor.setCreatorManager(creatorManager);

        accessControl = createMock(AccessControl.class);
        defaultInterfaceProcessor.setAccessControl(accessControl);

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    public void testHandle() throws Exception {
        request.setPathInfo("/interface/creatorName.js");

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        expectLastCall().andReturn(creator);

        // expect 9 method calls to 'getReasonToNotDisplay' for each method on Object
        expect(accessControl.getReasonToNotDisplay(eq(request), eq(creator), eq("creatorName"), (Method)isA(Method.class)));
        expectLastCall().andReturn(null).times(11);

        replay(creatorManager);
        replay(accessControl);

        defaultInterfaceProcessor.handle(request, response);

        verify(creatorManager);
        verify(accessControl);

        // check the response
        String result = response.getContentAsString();
        assertTrue(result.contains("function creatorName() { }"));
        assertTrue(result.contains("creatorName.hashCode = function(callback)"));
        assertTrue(result.contains("creatorName.getClass = function(callback)"));
        assertTrue(result.contains("creatorName.wait = function(callback)"));
        assertTrue(result.contains("creatorName.wait = function(p0, p1, callback)"));
        assertTrue(result.contains("creatorName.wait = function(p0, callback)"));
        assertTrue(result.contains("creatorName.equals = function(p0, callback)"));
        assertTrue(result.contains("creatorName.notify = function(callback)"));
        assertTrue(result.contains("creatorName.notifyAll = function(callback)"));
        assertTrue(result.contains("creatorName.toString = function(callback)"));
        assertTrue(result.contains("creatorName.testMethodWithServletParameters = function(callback)"));

        // make sure no entry is generated for the reserved javvascript word 'namespace'
        assertFalse(result.contains("creatorName.namespace = function(callback)"));
    }

    public void testHandleWithoutInterface() throws Exception {
        creatorManager.getCreator("");
        expectLastCall().andThrow(new SecurityException());

        replay(creatorManager);
        replay(accessControl);

        try {
            defaultInterfaceProcessor.handle(request, response);
            fail("a security exception was expected");
        } catch(SecurityException e) {
            // do nothing, was expected
        }

        verify(creatorManager);
        verify(accessControl);
    }

    public void testHandleWithReasonsNotToDisplay() throws Exception {
        // make sure not to allow an impossible test
        defaultInterfaceProcessor.setAllowImpossibleTests(false);

        request.setPathInfo("/interface/creatorName.js");

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        expectLastCall().andReturn(creator);

        // expect 9 method calls to 'getReasonToNotDisplay' for each method on Object
        expect(accessControl.getReasonToNotDisplay(eq(request), eq(creator), eq("creatorName"), (Method)isA(Method.class)));
        expectLastCall().andReturn("myReason").times(11);

        replay(creatorManager);
        replay(accessControl);

        defaultInterfaceProcessor.handle(request, response);

        verify(creatorManager);
        verify(accessControl);

        // check the response
        String result = response.getContentAsString();
        assertTrue(result.contains("function creatorName() { }"));
        assertFalse(result.contains("creatorName.hashCode = function(callback)"));
        assertFalse(result.contains("creatorName.getClass = function(callback)"));
        assertFalse(result.contains("creatorName.wait = function(callback)"));
        assertFalse(result.contains("creatorName.wait = function(p0, p1, callback)"));
        assertFalse(result.contains("creatorName.wait = function(p0, callback)"));
        assertFalse(result.contains("creatorName.equals = function(p0, callback)"));
        assertFalse(result.contains("creatorName.notify = function(callback)"));
        assertFalse(result.contains("creatorName.notifyAll = function(callback)"));
        assertFalse(result.contains("creatorName.toString = function(callback)"));
        assertFalse(result.contains("creatorName.testMethodWithServletParameters = function(callback)"));
        assertFalse(result.contains("creatorName.namespace = function(callback)"));
    }
}