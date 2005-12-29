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

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import uk.ltd.getahead.dwr.servlet.ServletHelper;
import uk.ltd.getahead.dwr.util.FakeServletConfig;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * A Spring Controller that handles DWR requests using a ServletHelper
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DwrController extends AbstractController implements BeanNameAware, InitializingBean, BeanFactoryAware
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
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception
    {
        try
        {
            ServletContext servletContext = getWebApplicationContext().getServletContext();

            servletHelper.setServletConfig(new FakeServletConfig(name, servletContext));
            servletHelper.initWebContextBuilder(null, null);

            servletHelper.addSystemConfigurator();
            servletHelper.configure();
        }
        catch (Exception ex)
        {
            log.fatal("init failed", ex); //$NON-NLS-1$
            throw ex;
        }
        finally
        {
            servletHelper.deinitWebContextBuilder();
        }
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
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

        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
     */
    public void setBeanName(final String name)
    {
        this.name = name;
    }

    /**
     * How is this deployed in Spring
     */
    private String name;

    /**
     * We'd like to inherit from this but the broken servlet spec and lack of
     * multiple inheritance prevents us.
     */
    private ServletHelper servletHelper = new ServletHelper();

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DwrController.class);
}
