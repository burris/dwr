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

package uk.ltd.getahead.dwr.spring;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;

import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.servlet.UrlProcessor;

/**
 * @author Bram Smeets
 */
public class DwrSpringServletTests extends TestCase {
    private DwrSpringServlet servlet = new DwrSpringServlet();

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private MockServletConfig config;
    private MockServletContext context;

    /**
     * 
     */
    protected void setUp() throws Exception {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        context = new MockServletContext();
        config = new MockServletConfig(context);
    }

    /**
     * @throws Exception
     */
    public void testDoPost() throws Exception {
        BeanFactory factory = (BeanFactory) EasyMock.createMock(BeanFactory.class);

        UrlProcessor processor = (UrlProcessor) EasyMock.createMock(UrlProcessor.class);
        WebContextBuilder builder = (WebContextBuilder) EasyMock.createMock(WebContextBuilder.class);

        EasyMock.expect(factory.getBean("uk.ltd.getahead.dwr.servlet.UrlProcessor")).andReturn(processor);
        EasyMock.expect(factory.getBean("uk.ltd.getahead.dwr.WebContextBuilder")).andReturn(builder);

        processor.handle(request, response);

        EasyMock.replay(factory);
        EasyMock.replay(processor);

        servlet.setIncludeDefaultConfig(false);

        servlet.setBeanFactory(factory);

        servlet.init(config);

        servlet.doPost(request, response);

        EasyMock.verify(factory);
        EasyMock.verify(processor);
    }
}