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

import junit.framework.TestCase;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import uk.ltd.getahead.dwr.*;

import static org.easymock.EasyMock.*;

/**
 * @author Bram Smeets
 */
public class DefaultProcessorTests extends TestCase {
    private DefaultProcessor processor;

    private Processor mockProcessor;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    protected void setUp() throws Exception {
        super.setUp();

        processor = new DefaultProcessor();

        mockProcessor = createMock(Processor.class);
        processor.setExec(mockProcessor);
        processor.setIndex(mockProcessor);
        processor.setInterface(mockProcessor);
        processor.setTest(mockProcessor);
        processor.setFile(new FileProcessor());

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    public void testRootRedirection() throws Exception {
        request.setPathInfo(null);
        request.setServletPath("/");

        processor.handle(request, response);

        assertEquals("//index.html", response.getRedirectedUrl());
    }

    public void testDoIndex() throws Exception {
        request.setPathInfo("/index.html");

        mockProcessor.handle(request, response);

        replay(mockProcessor);

        processor.handle(request, response);

        verify(mockProcessor);
    }

    public void testDoTest() throws Exception {
        // test to see if we get a 403 in case the creator manager is not in debug mode
        request.setPathInfo("/test/index.html");

        mockProcessor.handle(request, response);

        replay(mockProcessor);

        processor.handle(request, response);

        verify(mockProcessor);
    }

    public void testGetEngineFile() throws Exception {
        request.setPathInfo("/engine.js");

        replay(mockProcessor);
        
        processor.handle(request, response);

        verify(mockProcessor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function DWREngine()") != -1);
    }

    public void testGetUtilFile() throws Exception {
        request.setPathInfo("/util.js");

        replay(mockProcessor);

        processor.handle(request, response);

        verify(mockProcessor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function DWRUtil()") != -1);
    }

    public void testGetDeprecatedFile() throws Exception {
        request.setPathInfo("/deprecated.js");

        replay(mockProcessor);

        processor.handle(request, response);

        verify(mockProcessor);

        String result = response.getContentAsString();
        assertNotNull(result);
        assertTrue(result.indexOf("function") != -1);
    }

    public void testDoInterface() throws Exception {
        request.setPathInfo("/interface/testCreatorName.js");

        mockProcessor.handle(request, response);

        replay(mockProcessor);

        processor.handle(request, response);

        verify(mockProcessor);
    }

    public void testDoExec() throws Exception {
        request.setPathInfo("/exec/testCreatorName.doTest");

        mockProcessor.handle(request, response);

        replay(mockProcessor);

        processor.handle(request, response);

        verify(mockProcessor);

        String result = response.getContentAsString();
        assertNotNull(result);
    }

    public void testNonExitingRequest() throws Exception {
        request.setPathInfo("/nonExistingPath");

        replay(mockProcessor);

        processor.handle(request, response);

        verify(mockProcessor);

        assertEquals(404, response.getStatus());
    }
}