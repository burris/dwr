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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.Configurator;
import uk.ltd.getahead.dwr.Container;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.StartupState;
import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.WebContextFactory;
import uk.ltd.getahead.dwr.servlet.Processor;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DwrController extends AbstractController implements BeanNameAware, InitializingBean, BeanFactoryAware
{
    /* (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception
    {
        try
        {
            servletContext = getWebApplicationContext().getServletContext();

            // Now we have set the implementations we can set the WebContext up
            WebContextFactory.setWebContextBuilder(webContextBuilder);

            // And we lace it with the context so far to help init go smoothly
            webContextBuilder.set(null, null, servletConfig, getServletContext(), container);

            StartupState startupState = new StartupState();
            startupState.setAccessControl((AccessControl) container.getBean(AccessControl.class.getName()));
            startupState.setAjaxFilterManager((AjaxFilterManager) container.getBean(AjaxFilterManager.class.getName()));
            startupState.setConverterManager((ConverterManager) container.getBean(ConverterManager.class.getName()));
            startupState.setCreatorManager((CreatorManager) container.getBean(CreatorManager.class.getName()));
            startupState.setProcessor((Processor) container.getBean(Processor.class.getName()));
            startupState.setWebContextBuilder((WebContextBuilder) container.getBean(WebContextBuilder.class.getName()));

            for (Iterator it = configurators.iterator(); it.hasNext();)
            {
                Configurator configurator = (Configurator) it.next();
                configurator.configure(startupState);
            }
        }
        catch (Exception ex)
        {
            log.fatal("init failed", ex); //$NON-NLS-1$

            if (ex instanceof ServletException)
            {
                throw ex;
            }
            throw new ServletException(ex);
        }
        finally
        {
            if (webContextBuilder != null)
            {
                webContextBuilder.unset();
            }
        }
    }

    /**
     * Setter for use by the Spring IoC container to tell us what Configurators
     * exist for us to configure ourselves.
     * @param configurators
     */
    public void setConfigurators(List configurators)
    {
        this.configurators = configurators;
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        try
        {
            webContextBuilder.set(request, response, servletConfig, getServletContext(), container);
            getWebApplicationContext().getServletContext();

            processor.handle(request, response);
        }
        finally
        {
            webContextBuilder.unset();
        }

        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
     */
    public void setBeanName(final String name)
    {
        this.servletConfig = new ServletConfig()
        {
            public String getServletName()
            {
                return name;
            }

            public ServletContext getServletContext()
            {
                return servletContext;
            }

            public String getInitParameter(String paramName)
            {
                return null;
            }

            public Enumeration getInitParameterNames()
            {
                return new Enumeration()
                {                
                    public Object nextElement()
                    {
                        return null;
                    }

                    public boolean hasMoreElements()
                    {
                        return false;
                    }
                };
            }            
        };
    }

    /**
     * @param webContextBuilder The builder to set.
     */
    public void setWebContextBuilder(WebContextBuilder webContextBuilder)
    {
        this.webContextBuilder = webContextBuilder;
    }

    /**
     * @param processor The processor to set.
     */
    public void setProcessor(Processor processor)
    {
        this.processor = processor;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        SpringContainer springContainer = new SpringContainer();
        springContainer.setBeanFactory(beanFactory);

        this.container = springContainer;
    }

    /**
     * The list of classes that configurate DWR
     */
    private List configurators = new ArrayList();

    /**
     * The processor will actually handle the http requests
     */
    protected Processor processor;

    /**
     * The WebContext that keeps http objects local to a thread
     */
    protected WebContextBuilder webContextBuilder;

    /**
     * The wrapper for a Spring IoC container
     */
    private Container container;

    /**
     * The fake ServletConfig
     */
    private ServletConfig servletConfig;

    /**
     * The real ServletContext which we fixh out of Spring internals
     */
    protected ServletContext servletContext;

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DwrController.class);
}
