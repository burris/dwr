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

import junit.framework.TestCase;

import org.directwebremoting.servlet.UrlProcessor;
import org.easymock.EasyMock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


/**
 * @author Bram Smeets
 */
public class UrlProcessorTests extends TestCase
{
    private UrlProcessor processor;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        processor = new UrlProcessor();

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    /**
     * @throws Exception
     */
    public void testRootRedirection() throws Exception
    {
        request.setPathInfo(null);
        request.setServletPath("/");

        processor.handle(request, response);

        assertEquals("//index.html", response.getRedirectedUrl());
    }

    /**
     * @throws Exception
     */
    public void testDoIndex() throws Exception
    {
        request.setPathInfo("/index.html");

//        processor.handle(request, response);

        EasyMock.replay(processor);

        processor.handle(request, response);

        EasyMock.verify(processor);
    }

    /**
     * @throws Exception
     */
    public void testDoTest() throws Exception
    {
        // test to see if we get a 403 in case the creator manager is not in debug mode
        request.setPathInfo("/test/index.html");

//        processor.handle(request, response);

        EasyMock.replay(processor);

        processor.handle(request, response);

        EasyMock.verify(processor);
    }

    /**
     * @throws Exception
     */
    public void testGetEngineFile() throws Exception
    {
        request.setPathInfo("/engine.js");

        EasyMock.replay(processor);

        processor.handle(request, response);

        EasyMock.verify(processor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function DWREngine()") != -1);
    }

    /**
     * @throws Exception
     */
    public void testGetUtilFile() throws Exception
    {
        request.setPathInfo("/util.js");

        EasyMock.replay(processor);

        processor.handle(request, response);

        EasyMock.verify(processor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function DWRUtil()") != -1);
    }

    /**
     * @throws Exception
     */
    public void testGetDeprecatedFile() throws Exception
    {
        request.setPathInfo("/deprecated.js");

        EasyMock.replay(processor);

        processor.handle(request, response);

        EasyMock.verify(processor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function") != -1);
    }

    /**
     * @throws Exception
     */
    public void testDoInterface() throws Exception
    {
        request.setPathInfo("/interface/testCreatorName.js");

//        processor.handle(request, response);

        EasyMock.replay(processor);

        processor.handle(request, response);

        EasyMock.verify(processor);
    }

    /**
     * @throws Exception
     */
    public void testDoExec() throws Exception
    {
        request.setPathInfo("/exec/testCreatorName.doTest");

//        processor.handle(request, response);

        EasyMock.replay(processor);

        processor.handle(request, response);

        EasyMock.verify(processor);

        String result = response.getContentAsString();
        assertNotNull(result);
    }

    /**
     * @throws Exception
     */
    public void testNonExitingRequest() throws Exception
    {
        request.setPathInfo("/nonExistingPath");

        EasyMock.replay(processor);

        processor.handle(request, response);

        EasyMock.verify(processor);

        assertEquals(404, response.getStatus());
    }
}
