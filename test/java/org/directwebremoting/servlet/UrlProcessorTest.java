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
package org.directwebremoting.servlet;

import static org.junit.Assert.*;

import org.directwebremoting.servlet.UrlProcessor;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * @author Bram Smeets
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class UrlProcessorTest
{
    private UrlProcessor processor;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    @Before
    public void setUp() throws Exception
    {
        processor = new UrlProcessor();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void rootRedirection() throws Exception
    {
        request.setPathInfo(null);
        request.setServletPath("/");
        processor.handle(request, response);
        assertEquals("//index.html", response.getRedirectedUrl());
    }

    @Test
    public void doIndex() throws Exception
    {
        request.setPathInfo("/index.html");
        // processor.handle(request, response);

        EasyMock.replay(processor);
        processor.handle(request, response);
        EasyMock.verify(processor);
    }

    @Test
    public void doTest() throws Exception
    {
        // test to see if we get a 403 in case the creator manager is not in debug mode
        request.setPathInfo("/test/index.html");
        // processor.handle(request, response);

        EasyMock.replay(processor);
        processor.handle(request, response);
        EasyMock.verify(processor);
    }

    @Test
    public void getEngineFile() throws Exception
    {
        request.setPathInfo("/engine.js");
        EasyMock.replay(processor);
        processor.handle(request, response);

        EasyMock.verify(processor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function DWREngine()") != -1);
    }

    @Test
    public void getUtilFile() throws Exception
    {
        request.setPathInfo("/util.js");
        EasyMock.replay(processor);

        processor.handle(request, response);
        EasyMock.verify(processor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function DWRUtil()") != -1);
    }

    @Test
    public void getDeprecatedFile() throws Exception
    {
        request.setPathInfo("/deprecated.js");
        EasyMock.replay(processor);

        processor.handle(request, response);
        EasyMock.verify(processor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function") != -1);
    }

    @Test
    public void doInterface() throws Exception
    {
        request.setPathInfo("/interface/testCreatorName.js");
        // processor.handle(request, response);
        EasyMock.replay(processor);

        processor.handle(request, response);
        EasyMock.verify(processor);
    }

    @Test
    public void doExec() throws Exception
    {
        request.setPathInfo("/exec/testCreatorName.doTest");
        // processor.handle(request, response);
        EasyMock.replay(processor);

        processor.handle(request, response);
        EasyMock.verify(processor);

        String result = response.getContentAsString();
        assertNotNull(result);
    }

    @Test
    public void testNonExitingRequest() throws Exception
    {
        request.setPathInfo("/nonExistingPath");
        EasyMock.replay(processor);

        processor.handle(request, response);
        EasyMock.verify(processor);

        assertEquals(404, response.getStatus());
    }
}
