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

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import uk.ltd.getahead.dwr.servlet.ServletHelper;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * The servlet that handles all calls to DWR.<br>
 * It retrieves its configuration from the Spring IoC container.
 * @author Bram Smeets
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DwrSpringServlet extends HttpServlet implements BeanFactoryAware
{
    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        SpringContainer container = new SpringContainer();
        container.setBeanFactory(beanFactory);

        servletHelper.initContainer(container);
    }

    /**
     * Setter for use by the Spring IoC container to tell us what Configurators
     * exist for us to configure ourselves.
     * @param configurators
     */
    public void setConfigurators(List configurators)
    {
        servletHelper.setConfigurators(configurators);
    }

    /**
     * Do we prefix the list of Configurators with a default to read the system
     * dwr.xml file?
     * @param includeDefaultConfig the includeDefaultConfig to set
     */
    public void setIncludeDefaultConfig(boolean includeDefaultConfig)
    {
        servletHelper.setIncludeDefaultConfig(includeDefaultConfig);
    }

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);

        try
        {
            servletHelper.setServletConfig(config);
            servletHelper.initWebContextBuilder(null, null);

            servletHelper.addSystemConfigurator();

            servletHelper.addConfiguratorsFromInitParams();
            servletHelper.configure();
        }
        catch (Exception ex)
        {
            log.fatal("init failed", ex); //$NON-NLS-1$
            throw new ServletException(ex);
        }
        finally
        {
            servletHelper.deinitWebContextBuilder();
        }
    }

    /* (non-Javadoc)
    * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        doPost(req, resp);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            servletHelper.initWebContextBuilder(request, response);
            servletHelper.handle(request, response);
        }
        finally
        {
            servletHelper.deinitWebContextBuilder();
        }
    }

    /**
     * We'd like to inherit from this but the broken servlet spec and lack of
     * multiple inheritance prevents us.
     */
    private ServletHelper servletHelper = new ServletHelper();

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DwrSpringServlet.class);
}
