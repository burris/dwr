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
import static org.easymock.EasyMock.*;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.impl.test.TestCreatedObject;
import uk.ltd.getahead.dwr.create.NewCreator;

import java.lang.reflect.Method;

public class DefaultTestProcessorTests extends TestCase {
    private DefaultTestProcessor defaultTestProcessor = new DefaultTestProcessor();

    private CreatorManager creatorManager;
    private AccessControl accessControl;
    private ConverterManager converterManager;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    protected void setUp() throws Exception {
        super.setUp();

        creatorManager = createMock(CreatorManager.class);
        defaultTestProcessor.setCreatorManager(creatorManager);

        accessControl = createMock(AccessControl.class);
        defaultTestProcessor.setAccessControl(accessControl);

        converterManager = createMock(ConverterManager.class);
        defaultTestProcessor.setConverterManager(converterManager);

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    public void testHandleInNonDebug() throws Exception {
        creatorManager.isDebug();
        expectLastCall().andReturn(false);

        replay(creatorManager);
        replay(accessControl);
        replay(converterManager);

        defaultTestProcessor.handle(request, response);

        verify(creatorManager);
        verify(accessControl);
        verify(converterManager);

        assertEquals(403, response.getStatus());
    }

    public void testHandle() throws Exception {
        request.setPathInfo("/test/creatorName");

        creatorManager.isDebug();
        expectLastCall().andReturn(true);

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        expectLastCall().andReturn(creator);

        expect(accessControl.getReasonToNotDisplay(eq(request), eq(creator), eq("creatorName"), (Method)isA(Method.class)));
        expectLastCall().andReturn(null).times(11);

        converterManager.isConvertable((Class)anyObject());
        expectLastCall().andReturn(true).times(19);

        expect(accessControl.getReasonToNotExecute(eq(request), eq(creator), eq("creatorName"), (Method)isA(Method.class)));
        expectLastCall().andReturn(null).times(10);

        replay(creatorManager);
        replay(accessControl);
        replay(converterManager);

        defaultTestProcessor.handle(request, response);

        verify(creatorManager);
        verify(accessControl);
        verify(converterManager);

        assertEquals(200, response.getStatus());
        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("testMethodWithServletParameters(") != -1);
        assertTrue(result.indexOf("hashCode(") != -1);
        assertTrue(result.indexOf("getClass(") != -1);
        assertTrue(result.indexOf("wait(") != -1);
        assertTrue(result.indexOf("equals(") != -1);
        assertTrue(result.indexOf("notify(") != -1);
        assertTrue(result.indexOf("notifyAll(") != -1);
        assertTrue(result.indexOf("toString(") != -1);
    }
}