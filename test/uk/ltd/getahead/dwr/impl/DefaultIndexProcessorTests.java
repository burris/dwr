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

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.create.NewCreator;
import uk.ltd.getahead.dwr.impl.test.TestCreatedObject;
import uk.ltd.getahead.dwr.servlet.DefaultIndexProcessor;

public class DefaultIndexProcessorTests extends TestCase
{
    private DefaultIndexProcessor defaultIndexProcessor = new DefaultIndexProcessor();

    private CreatorManager creatorManager;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    protected void setUp() throws Exception
    {
        super.setUp();

        creatorManager = (CreatorManager) EasyMock.createMock(CreatorManager.class);
        defaultIndexProcessor.setCreatorManager(creatorManager);

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    public void testHandleWithoutDebug() throws Exception
    {
        creatorManager.isDebug();
        EasyMock.expectLastCall().andReturn(Boolean.FALSE);

        EasyMock.replay(creatorManager);

        defaultIndexProcessor.handle(request, response);

        EasyMock.verify(creatorManager);

        assertEquals(403, response.getStatus());
    }

    public void testHandle() throws Exception
    {
        creatorManager.isDebug();
        EasyMock.expectLastCall().andReturn(Boolean.TRUE);

        creatorManager.getCreatorNames();
        ArrayList names = new ArrayList();
        names.add("creatorName");
        EasyMock.expectLastCall().andReturn(names);

        creatorManager.getCreator("creatorName");
        NewCreator creator = new NewCreator();
        creator.setClass(TestCreatedObject.class.getName());
        EasyMock.expectLastCall().andReturn(creator);

        EasyMock.replay(creatorManager);

        defaultIndexProcessor.handle(request, response);

        EasyMock.verify(creatorManager);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("creatorName") != -1);
        assertTrue(result.indexOf(TestCreatedObject.class.getName()) != -1);
    }
}
