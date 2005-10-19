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

import uk.ltd.getahead.dwr.*;
import uk.ltd.getahead.dwr.util.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * A <code>Container</code> implementation that looks up all beans from the
 * configuration specified in a Spring context.
 * It loads the configuration from a Spring web application context.
 * @author Bram Smeets
 */
public class SpringContainer implements Container {
    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(SpringContainer.class);

    /**
     * The id to lookup the dwr configuration in the spring application context.
     */
    private static final String SPRING_CONFIGURATION_ID = "dwrConfiguration";

    /**
     * The configuration for DWR which is retrieved from the spring application context.
     */
    private DwrConfiguration configuration;

    /**
     * Creates the spring container.
     *
     * @param servletContext the servlet context to use to obtain the application context
     */
    public SpringContainer(ServletContext servletContext) {
        init(servletContext);
    }

    /**
     * Gets the part of the configuration as requested by the dwr servlet.
     *
     * @param id the class name of the requested component
     * @return the requested part of the configuration
     */
    public Object getBean(String id) {
        // return the appropriate bean from the configuration
        if(Configuration.class.getName().equals(id)) {
            return configuration;
        } else if(WebContextBuilder.class.getName().equals(id)) {
            return configuration.getWebContextBuilder();
        } else if(Processor.class.getName().equals(id)) {
            return configuration.getProcessor();
        } else {
            throw new SpringConfigurationException("An unknown bean id was requested: " + id);
        }
    }

    /** Initializes the spring container. */
    private void init(ServletContext servletContext) {
        // retrieve the required web application context
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        
        // try to get the configuration by id
        try {
            configuration = (DwrConfiguration) context.getBean(SPRING_CONFIGURATION_ID, DwrConfiguration.class);
        } catch (BeanNotOfRequiredTypeException e) {
            log.info("A bean was found for id '" + SPRING_CONFIGURATION_ID + "', but was not of type: " +
                    DwrConfiguration.class.getName());
        } catch (NoSuchBeanDefinitionException e) {
            // do nothing, continue to try and load using the class
        }

        // in case the configuration has not been found yet, try to load it with the class
        if(configuration == null) {
            // retrieve all spring configurations by class
            Map configurations = context.getBeansOfType(DwrConfiguration.class);
            if(configurations.size() == 1) {
                configuration = (DwrConfiguration) configurations.get(configurations.keySet().iterator().next());
            } else if(configurations.size() > 1) {
                throw new SpringConfigurationException("More than one spring configuration bean was found for class: " +
                        DwrConfiguration.class.getName());
            } else {
                throw new SpringConfigurationException("No spring configuration bean was found for either id: '" +
                        SPRING_CONFIGURATION_ID + "', or class: " + DwrConfiguration.class.getName());
            }
        }
    }
}