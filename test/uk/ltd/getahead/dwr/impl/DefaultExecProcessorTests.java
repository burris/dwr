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
import uk.ltd.getahead.dwr.*;
import uk.ltd.getahead.dwr.impl.test.TestWebContextFactory;
import uk.ltd.getahead.dwr.impl.test.TestCreatedObject;
import uk.ltd.getahead.dwr.create.NewCreator;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class DefaultExecProcessorTests extends TestCase {
    private DefaultExecProcessor defaultExecProcessor = new DefaultExecProcessor();

    private CreatorManager creatorManager;
    private AccessControl accessControl;
    private ConverterManager converterManager;
    private AjaxFilterManager ajaxFilterManager;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    protected void setUp() throws Exception {
        super.setUp();

        creatorManager = createMock(CreatorManager.class);
        defaultExecProcessor.setCreatorManager(creatorManager);

        accessControl = createMock(AccessControl.class);
        defaultExecProcessor.setAccessControl(accessControl);

        converterManager = createMock(ConverterManager.class);
        defaultExecProcessor.setConverterManager(converterManager);

        ajaxFilterManager = createMock(AjaxFilterManager.class);
        defaultExecProcessor.setAjaxFilterManager(ajaxFilterManager);

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    public void testHandleWithoutQuery() throws Exception {
        replay(creatorManager);
        replay(accessControl);
        replay(converterManager);

        defaultExecProcessor.handle(request, response);

        verify(creatorManager);
        verify(accessControl);
        verify(converterManager);

        assertEquals(500, response.getStatus());
        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("alert('") != -1);
    }

    public void testHandle() throws Exception {
        request.setPathInfo("/exec/dataManager.doTest");
        request.setMethod("POST");
        request.setContent(("callCount=2\n" +
                "c0-id=1\nc0-scriptName=creatorName\nc0-methodName=toString\n" +
                "c1-id=2\nc1-scriptName=creatorName\nc1-methodName=hashCode").getBytes());

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        expectLastCall().andReturn(creator).times(4);

        expect(accessControl.getReasonToNotExecute(eq(request), eq(creator), eq("creatorName"), (Method)isA(Method.class)));
        expectLastCall().andReturn(null).times(2);

        expect(converterManager.convertOutbound(isA(Object.class), (OutboundContext)isA(OutboundContext.class)));
        expectLastCall().andReturn(new OutboundVariable()).times(2);

        // TODO: this should not be neccessary!
        ArrayList filters = new ArrayList();
        filters.add(new AjaxFilter() {
            public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception {
                return new Object();
            }
        });
        filters.add(new AjaxFilter() {
            public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception {
                return new Object();
            }
        });
        expect(ajaxFilterManager.getAjaxFilters("creatorName")).andReturn(filters.iterator()).atLeastOnce();

        replay(creatorManager);
        replay(accessControl);
        replay(converterManager);
        replay(ajaxFilterManager);

        DefaultWebContextBuilder builder = new DefaultWebContextBuilder();
        builder.set(request, response, null, null, null);
        TestWebContextFactory.setWebContextBuilder(builder);

        defaultExecProcessor.handle(request, response);

        verify(creatorManager);
        verify(accessControl);
        verify(converterManager);
        verify(ajaxFilterManager);

        assertEquals(200, response.getStatus());
        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("<script type='text/javascript'>") != -1);
        assertTrue(result.indexOf("window.parent.DWREngine._handleResponse('1',") != -1);
        assertTrue(result.indexOf("window.parent.DWREngine._handleResponse('2',") != -1);
        assertTrue(result.indexOf("</script>") != -1);
    }
}