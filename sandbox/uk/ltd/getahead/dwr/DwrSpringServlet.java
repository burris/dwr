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

package uk.ltd.getahead.dwr;

import uk.ltd.getahead.dwr.spring.SpringContainer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.Enumeration;

/**
 * The servlet that handles all calls to DWR. <br>
 * It retrieves its configuration from the Spring IoC container.
 *
 * <p>For more information on configuring the configuration in a Spring application
 * context see {@link uk.ltd.getahead.dwr.spring.DwrConfiguration}.</p>
 *
 * @see uk.ltd.getahead.dwr.spring.DwrConfiguration
 *
 * @author Bram Smeets
 */
public class DwrSpringServlet extends AbstractDWRServlet {
    /**
     * Gets a proxy to the configuration in the Spring container. <br>
     *
     * @param config the servlet configuration to use to obtain the Spring container
     * @return the spring container
     * @throws ServletException in case instatiation of the spring container fails
     *
     * @see SpringContainer
     */
    protected Container getContainer(ServletConfig config) throws ServletException {
        // create a spring container that retrieves the configuration from spring context
        return new SpringContainer(config.getServletContext());
    }

    /**
     * Performs additional configuration. <br>
     * It is implemented to still use any XML-based configurations specified as
     * init parameters.
     *
     * @param config the servlet configuration to obtain the init parameters from
     * @param configuration the current DWR configuration
     * @throws ServletException in case the additional configuration fails
     */
    protected void configure(ServletConfig config, Configuration configuration)
    throws ServletException {
        // perform any additional configuration
        Enumeration en = config.getInitParameterNames();

        // Loop through the ones that do exist
        while (en.hasMoreElements())
        {
            String name = (String) en.nextElement();
            if (name.startsWith(INIT_CONFIG))
            {
                // if the init param starts with "config" then try to load it
                String configFile = config.getInitParameter(name);
                readFile(configFile, configuration);
            }
        }
    }
}