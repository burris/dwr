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
package uk.ltd.getahead.dwr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.Configurator;
import uk.ltd.getahead.dwr.Constants;
import uk.ltd.getahead.dwr.Container;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.DebugPageGenerator;
import uk.ltd.getahead.dwr.Marshaller;
import uk.ltd.getahead.dwr.Remoter;
import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.WebContextFactory;
import uk.ltd.getahead.dwr.dwrp.ConverterManager;
import uk.ltd.getahead.dwr.dwrp.DefaultConverterManager;
import uk.ltd.getahead.dwr.dwrp.DwrpMarshaller;
import uk.ltd.getahead.dwr.impl.DefaultAccessControl;
import uk.ltd.getahead.dwr.impl.DefaultAjaxFilterManager;
import uk.ltd.getahead.dwr.impl.DefaultContainer;
import uk.ltd.getahead.dwr.impl.DefaultCreatorManager;
import uk.ltd.getahead.dwr.impl.DefaultDebugPageGenerator;
import uk.ltd.getahead.dwr.impl.DefaultRemoter;
import uk.ltd.getahead.dwr.impl.DefaultWebContextBuilder;
import uk.ltd.getahead.dwr.impl.DwrXmlConfigurator;
import uk.ltd.getahead.dwr.util.Logger;
import uk.ltd.getahead.dwr.util.ServletLoggingOutput;

/**
 * An abstraction of all the common servlet operations that are required to host
 * a DWR service that depends on the servlet spec.
 * It would be good to have a base class for all servlet operations, however
 * lack of MI prevents us from doing this.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ServletHelper
{
    /**
     * Accessor for the Container.
     * This is kind of a setter execpt that it has 2 side effects, one to cache
     * the Processor and WebContextBuilder for later use, the other to initalize
     * the WebContextFactory.
     * @param aContainer The new IoC container
     */
    public void initContainer(Container aContainer)
    {
        this.container = aContainer;

        // Cached to save looking them up
        webContextBuilder = (WebContextBuilder) aContainer.getBean(WebContextBuilder.class.getName());

        // Now we have set the implementations we can set the WebContext up
        WebContextFactory.setWebContextBuilder(webContextBuilder);
    }

    /**
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void initDefaultContainer() throws InstantiationException, IllegalAccessException
    {
        // Load the factory with implementation information
        DefaultContainer defaultContainer = new DefaultContainer();

        defaultContainer.addParameter(AccessControl.class.getName(), DefaultAccessControl.class.getName());
        defaultContainer.addParameter(ConverterManager.class.getName(), DefaultConverterManager.class.getName());
        defaultContainer.addParameter(CreatorManager.class.getName(), DefaultCreatorManager.class.getName());
        defaultContainer.addParameter(UrlProcessor.class.getName(), UrlProcessor.class.getName());
        defaultContainer.addParameter(WebContextBuilder.class.getName(), DefaultWebContextBuilder.class.getName());
        defaultContainer.addParameter(AjaxFilterManager.class.getName(), DefaultAjaxFilterManager.class.getName());
        defaultContainer.addParameter(Remoter.class.getName(), DefaultRemoter.class.getName());
        defaultContainer.addParameter(DebugPageGenerator.class.getName(), DefaultDebugPageGenerator.class.getName());
        defaultContainer.addParameter(Marshaller.class.getName(), DwrpMarshaller.class.getName());

        defaultContainer.addParameter("debug", "false"); //$NON-NLS-1$ //$NON-NLS-2$
        defaultContainer.addParameter("allowImpossibleTests", "false"); //$NON-NLS-1$ //$NON-NLS-2$
        defaultContainer.addParameter("scriptCompressed", "true"); //$NON-NLS-1$ //$NON-NLS-2$

        Enumeration en = servletConfig.getInitParameterNames();
        while (en.hasMoreElements())
        {
            String name = (String) en.nextElement();
            String value = servletConfig.getInitParameter(name);
            defaultContainer.addParameter(name, value);
        }
        defaultContainer.configurationFinished();

        initContainer(defaultContainer);
    }

    /**
     * Accessor for the Container
     * @return the container
     */
    public Container getContainer()
    {
        return container;
    }

    /**
     * Accessor for ServletConfig
     * @param servletConfig The new ServletConfig
     */
    public void setServletConfig(ServletConfig servletConfig)
    {
        this.servletConfig = servletConfig;
        this.servletContext = servletConfig.getServletContext();
    }

    /**
     * Accessor for ServletConfig
     * @return the ServletConfig
     */
    public ServletConfig getServletConfig()
    {
        return servletConfig;
    }

    /**
     * Accessor for ServletContext
     * @return the servletContext
     */
    public ServletContext getServletContext()
    {
        return servletContext;
    }

    /**
     * Do we prefix the list of Configurators with a default to read the system
     * dwr.xml file?
     * @param includeDefaultConfig the includeDefaultConfig to set
     */
    public void setIncludeDefaultConfig(boolean includeDefaultConfig)
    {
        this.includeDefaultConfig = includeDefaultConfig;
    }

    /**
     * Do we prefix the list of Configurators with a default to read the system
     * dwr.xml file?
     * @return The current includeDefaultConfig status
     */
    public boolean isIncludeDefaultConfig()
    {
        return includeDefaultConfig;
    }

    /**
     * Call <code>ServletLoggingOutput.setExecutionContext()</code> and
     * <code>ServletLoggingOutput.setLevel()</code>
     * @param servlet The HttpServlet to push log messages to
     */
    public void setServletLoggingOutput(HttpServlet servlet)
    {
        ServletLoggingOutput.setExecutionContext(servlet);
        String logLevel = servletConfig.getInitParameter(INIT_LOGLEVEL);
        if (logLevel != null)
        {
            ServletLoggingOutput.setLevel(logLevel);
        }
    }

    /**
     * Match for <code>setServletLoggingOutput()</code> that calls
     * <code>ServletLoggingOutput.unsetExecutionContext()</code>
     */
    public void unsetServletLoggingOutput()
    {
        ServletLoggingOutput.unsetExecutionContext();
    }

    /**
     * Proxy to <code>WebContextBuilder.set()</code>.
     * @param request The HTTP request
     * @param response The HTTP response
     */
    public void initWebContextBuilder(HttpServletRequest request, HttpServletResponse response)
    {
        // And we lace it with the context so far to help init go smoothly
        webContextBuilder.set(request, response, servletConfig, servletContext, container);
    }

    /**
     * Proxy to <code>WebContextBuilder.unset()</code>.
     */
    public void deinitWebContextBuilder()
    {
        webContextBuilder.unset();
    }

    /**
     * Accessor for the list of Configurators the we configure ourselves using
     * @param configurators New list of configurators
     */
    public void setConfigurators(List configurators)
    {
        this.configurators = configurators;
    }

    /**
     * Accessor for the list of Configurators the we configure ourselves using
     * @return the list of configurators
     */
    public List getConfigurators()
    {
        return configurators;
    }

    /**
     * Add the system configurator to the start of the list of configurators
     * @throws SAXException If the config file parse fails
     * @throws ParserConfigurationException If the config file parse fails
     * @throws IOException If the config file read fails
     */
    public void addSystemConfigurator() throws IOException, ParserConfigurationException, SAXException
    {
        if (configurators == null)
        {
            configurators = new ArrayList();
        }

        // Do we need to include the default system configuration?
        if (includeDefaultConfig)
        {
            DwrXmlConfigurator system = new DwrXmlConfigurator();
            system.setClassResourceName(Constants.FILE_DWR_XML);
            configurators.add(0, system);
        }
    }

    /**
     * Add configurators from init params to the end of the list of
     * configurators.
     * @return true if any Configurators were read
     * @throws SAXException If the config file parse fails
     * @throws ParserConfigurationException If the config file parse fails
     * @throws IOException If the config file read fails
     */
    public boolean addConfiguratorsFromInitParams() throws IOException, ParserConfigurationException, SAXException
    {
        if (configurators == null)
        {
            configurators = new ArrayList();
        }

        Enumeration en = servletConfig.getInitParameterNames();
        boolean foundConfig = false;
        while (en.hasMoreElements())
        {
            String name = (String) en.nextElement();
            if (name.startsWith(INIT_CONFIG))
            {
                foundConfig = true;

                // if the init param starts with "config" then try to load it
                String configFile = servletConfig.getInitParameter(name);

                DwrXmlConfigurator local = new DwrXmlConfigurator();
                local.setServletResourceName(configFile);
                configurators.add(local);
            }
        }

        return foundConfig;
    }

    /**
     * Add the default web-app level configurator to the end of the list of
     * configurators.
     * @throws SAXException If the config file parse fails
     * @throws ParserConfigurationException If the config file parse fails
     * @throws IOException If the config file read fails
     */
    public void addDefaultDwrXmlConfigurator() throws IOException, ParserConfigurationException, SAXException
    {
        if (configurators == null)
        {
            configurators = new ArrayList();
        }

        String skip = servletConfig.getInitParameter(INIT_SKIP_DEFAULT);
        if (!Boolean.valueOf(skip).booleanValue())
        {
            DwrXmlConfigurator local = new DwrXmlConfigurator();
            local.setServletResourceName(Constants.DEFAULT_DWR_XML);
            configurators.add(local);
        }
    }

    /**
     * Allow all the configurators to have a go at the container in turn
     */
    public void configure()
    {
        // Allow all the configurators to have a go
        for (Iterator it = configurators.iterator(); it.hasNext();)
        {
            Configurator configurator = (Configurator) it.next();

            log.debug("** Adding config from " + configurator); //$NON-NLS-1$
            configurator.configure(container);
        }
    }

    /**
     * 
     */
    public void debugConfig()
    {
        if (log.isDebugEnabled())
        {
            // Container level debug
            log.debug("Container"); //$NON-NLS-1$
            log.debug("  Type: " + container.getClass().getName()); //$NON-NLS-1$
            Collection beanNames = container.getBeanNames();
            for (Iterator it = beanNames.iterator(); it.hasNext();)
            {
                String name = (String) it.next();
                Object object = container.getBean(name);

                if (object instanceof String)
                {
                    log.debug("  Param: " + name + " = " + object + " (" + object.getClass().getName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                }
                else
                {
                    log.debug("  Bean: " + name + " = " + object + " (" + object.getClass().getName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                }
            }

            // AccessControl debugging
            AccessControl accessControl = (AccessControl) container.getBean(AccessControl.class.getName());
            log.debug("AccessControl"); //$NON-NLS-1$
            log.debug("  Type: " + accessControl.getClass().getName()); //$NON-NLS-1$

            // AjaxFilterManager debugging
            AjaxFilterManager ajaxFilterManager = (AjaxFilterManager) container.getBean(AjaxFilterManager.class.getName());
            log.debug("AjaxFilterManager"); //$NON-NLS-1$
            log.debug("  Type: " + ajaxFilterManager.getClass().getName()); //$NON-NLS-1$

            // ConverterManager debugging
            ConverterManager converterManager = (ConverterManager) container.getBean(ConverterManager.class.getName());
            log.debug("ConverterManager"); //$NON-NLS-1$
            log.debug("  Type: " + converterManager.getClass().getName()); //$NON-NLS-1$

            // CreatorManager debugging
            CreatorManager creatorManager = (CreatorManager) container.getBean(CreatorManager.class.getName());
            log.debug("CreatorManager"); //$NON-NLS-1$
            log.debug("  Type: " + creatorManager.getClass().getName()); //$NON-NLS-1$
            Collection creatorNames = creatorManager.getCreatorNames();
            for (Iterator it = creatorNames.iterator(); it.hasNext();)
            {
                String creatorName = (String) it.next();
                Creator creator = creatorManager.getCreator(creatorName);
                log.debug("  Creator: " + creatorName + " = " + creator + " (" + creator.getClass().getName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            }
        }
    }

    /**
     * Process a GET or POST request from a web browser.
     * @param request The HTTP request
     * @param response The HTTP response
     * @throws IOException From <code>processor.handle()</code>
     */
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        processor.handle(request, response);
    }

    /**
     * The list of classes that configurate DWR
     */
    private List configurators = new ArrayList();

    /**
     * Do we prefix the list of Configurators with a default to read the system
     * dwr.xml file?
     */
    private boolean includeDefaultConfig = true;

    /**
     * The processor will actually handle the http requests
     */
    protected UrlProcessor processor = new UrlProcessor();

    /**
     * The WebContext that keeps http objects local to a thread
     */
    protected WebContextBuilder webContextBuilder;

    /**
     * The IoC container
     */
    protected Container container;

    /**
     * The fake ServletConfig
     */
    private ServletConfig servletConfig;

    /**
     * The real ServletContext which we fixh out of Spring internals
     */
    protected ServletContext servletContext;

    /**
     * Init parameter: Set a dwr.xml config file.
     * This is only a prefix since we might have more than 1 config file.
     */
    protected static final String INIT_CONFIG = "config"; //$NON-NLS-1$

    /**
     * Init parameter: Skip reading the default config file if none are specified.
     */
    protected static final String INIT_SKIP_DEFAULT = "skipDefaultConfig"; //$NON-NLS-1$

    /**
     * Init parameter: If we are doing Servlet.log logging, to what level?
     */
    protected static final String INIT_LOGLEVEL = "logLevel"; //$NON-NLS-1$

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(ServletHelper.class);
}
