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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.util.logging.Logger;

/**
 * @author Bram Smeets
 */
public class DwrControllerTests extends AbstractDependencyInjectionSpringContextTests {

    /** Create a category for the log4j logging facility. */
    private static final Logger log = Logger.getLogger(DwrControllerTests.class.getName());

    private DwrController controller;

    protected String[] getConfigLocations() {
        return new String[] { "/uk/ltd/getahead/dwr/spring/spring-configuration.xml" };
    }

    protected void onSetUp() throws Exception {
        controller = (DwrController) applicationContext.getBean("dwrController");
    }

    /**
	 * Subclasses can invoke this to get a context key for the given location.
	 * This doesn't affect the applicationContext instance variable in this class.
	 * Dependency Injection cannot be applied from such contexts.
	 */
	protected ConfigurableApplicationContext loadContextLocations(String[] locations) {
		if (logger.isInfoEnabled()) {
			logger.info("Loading my own config for: " + StringUtils.arrayToCommaDelimitedString(locations));
		}
		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setConfigLocations(locations);
        ctx.setServletContext(new MockServletContext());
        ctx.refresh();
        return ctx;
    }

    public void test() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();


        try {
            controller.handleRequestInternal(request, response);
        } catch (Exception e) {
            // TODO: what is this? SHould not be /WEB-INF/dwr.xml?
        }
    }
}