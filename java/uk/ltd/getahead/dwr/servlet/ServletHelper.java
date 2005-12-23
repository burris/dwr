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
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import uk.ltd.getahead.dwr.Configurator;
import uk.ltd.getahead.dwr.Constants;
import uk.ltd.getahead.dwr.Container;
import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.WebContextFactory;
import uk.ltd.getahead.dwr.impl.DwrXmlConfigurator;
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
        processor = (Processor) aContainer.getBean(Processor.class.getName());
        webContextBuilder = (WebContextBuilder) aContainer.getBean(WebContextBuilder.class.getName());

        // Now we have set the implementations we can set the WebContext up
        WebContextFactory.setWebContextBuilder(webContextBuilder);
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
     * @param servletContext The new ServletContext
     */
    public void setServletContext(ServletContext servletContext)
    {
        this.servletContext = servletContext;
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
            system.setClassResourceName(Constants.DEFAULT_DWR_XML);
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
            configurator.configure(container);
        }
    }

    /**
     * Process a GET or POST request from a web browser.
     * @param request The HTTP request
     * @param response The HTTP response
     * @throws IOException From <code>processor.handle()</code>
     * @throws ServletException From <code>processor.handle()</code>
     */
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
    protected Processor processor;

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
}
