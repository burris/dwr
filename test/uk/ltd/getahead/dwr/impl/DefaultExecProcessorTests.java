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

import javax.servlet.http.HttpServletRequest;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilter;
import uk.ltd.getahead.dwr.AjaxFilterChain;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.create.NewCreator;
import uk.ltd.getahead.dwr.impl.test.TestCreatedObject;
import uk.ltd.getahead.dwr.impl.test.TestWebContextFactory;
import uk.ltd.getahead.dwr.servlet.DefaultExecProcessor;

public class DefaultExecProcessorTests extends TestCase
{
    private DefaultExecProcessor defaultExecProcessor = new DefaultExecProcessor();

    private CreatorManager creatorManager;

    private AccessControl accessControl;

    private ConverterManager converterManager;

    private AjaxFilterManager ajaxFilterManager;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    protected void setUp() throws Exception
    {
        super.setUp();

        creatorManager = (CreatorManager) EasyMock.createMock(CreatorManager.class);
        defaultExecProcessor.setCreatorManager(creatorManager);

        accessControl = (AccessControl) EasyMock.createMock(AccessControl.class);
        defaultExecProcessor.setAccessControl(accessControl);

        converterManager = (ConverterManager) EasyMock.createMock(ConverterManager.class);
        defaultExecProcessor.setConverterManager(converterManager);

        ajaxFilterManager = (AjaxFilterManager) EasyMock.createMock(AjaxFilterManager.class);
        defaultExecProcessor.setAjaxFilterManager(ajaxFilterManager);

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    public void testHandleWithoutQuery() throws Exception
    {
        EasyMock.replay(creatorManager);
        EasyMock.replay(accessControl);
        EasyMock.replay(converterManager);

        defaultExecProcessor.handle(request, response);

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);
        EasyMock.verify(converterManager);

        assertEquals(500, response.getStatus());
        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("alert('") != -1);
    }

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
        builder.set(request, response, null, null, null);
        TestWebContextFactory.setWebContextBuilder(builder);

        defaultExecProcessor.handle(request, response);

        EasyMock.verify(creatorManager);
        EasyMock.verify(accessControl);
        EasyMock.verify(converterManager);
        EasyMock.verify(ajaxFilterManager);

        assertEquals(200, response.getStatus());
        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("<script type='text/javascript'>") != -1);
        assertTrue(result.indexOf("window.parent.DWREngine._handleResponse('1',") != -1);
        assertTrue(result.indexOf("window.parent.DWREngine._handleResponse('2',") != -1);
        assertTrue(result.indexOf("</script>") != -1);
    }
}
