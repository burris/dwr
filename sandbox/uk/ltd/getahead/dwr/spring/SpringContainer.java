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

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import uk.ltd.getahead.dwr.Configuration;
import uk.ltd.getahead.dwr.Container;
import uk.ltd.getahead.dwr.Processor;
import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * A <code>Container</code> implementation that looks up all beans from the
 * configuration specified in a Spring context.
 * It loads the configuration from a Spring web application context.
 * @author Bram Smeets
 */
public class SpringContainer implements Container
{
    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(SpringContainer.class);

    /**
     * The id to lookup the dwr configuration in the spring application context.
     */
    private static final String SPRING_CONFIGURATION_ID = "dwrConfiguration"; //$NON-NLS-1$

    /**
     * The configuration for DWR which is retrieved from the spring application context.
     */
    private DwrConfiguration configuration;

    /**
     * Creates the spring container.
     *
     * @param servletContext the servlet context to use to obtain the application context
     */
    public SpringContainer(ServletContext servletContext)
    {
        init(servletContext);
    }

    /**
     * Gets the part of the configuration as requested by the dwr servlet.
     *
     * @param id the class name of the requested component
     * @return the requested part of the configuration
     */
    public Object getBean(String id)
    {
        // return the appropriate bean from the configuration
        if (Configuration.class.getName().equals(id))
        {
            return configuration;
        }
        else if (WebContextBuilder.class.getName().equals(id))
        {
            return configuration.getWebContextBuilder();
        }
        else if (Processor.class.getName().equals(id))
        {
            return configuration.getProcessor();
        }
        else
        {
            throw new IllegalArgumentException("An unknown bean id was requested: " + id); //$NON-NLS-1$
        }
    }

    /**
     * Initializes the spring container.
     * @param servletContext The servlet context from which we can get the
     * WebApplicationContext
     */
    private void init(ServletContext servletContext)
    {
        // retrieve the required web application context
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        // try to get the configuration by id
        try
        {
            configuration = (DwrConfiguration) context.getBean(SPRING_CONFIGURATION_ID, DwrConfiguration.class);
        }
        catch (BeanNotOfRequiredTypeException e)
        {
            log.info("A bean was found for id '" + SPRING_CONFIGURATION_ID + "', but was not of type: " + DwrConfiguration.class.getName()); //$NON-NLS-1$ //$NON-NLS-2$
        }
        catch (NoSuchBeanDefinitionException e)
        {
            // do nothing, continue to try and load using the class
        }

        // in case the configuration has not been found yet, try to load it with the class
        if (configuration == null)
        {
            // retrieve all spring configurations by class
            Map configurations = context.getBeansOfType(DwrConfiguration.class);
            if (configurations.size() == 1)
            {
                configuration = (DwrConfiguration) configurations.get(configurations.keySet().iterator().next());
            }
            else if (configurations.size() > 1)
            {
                throw new IllegalArgumentException("More than one spring configuration bean was found for class: " + DwrConfiguration.class.getName()); //$NON-NLS-1$
            }
            else
            {
                throw new IllegalArgumentException("No spring configuration bean was found for either id: '" + SPRING_CONFIGURATION_ID + "', or class: " + DwrConfiguration.class.getName()); //$NON-NLS-1$ //$NON-NLS-2$ 
            }
        }
    }
}
