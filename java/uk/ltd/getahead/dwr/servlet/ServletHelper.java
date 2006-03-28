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
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.Configurator;
import uk.ltd.getahead.dwr.Container;
import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.DebugPageGenerator;
import uk.ltd.getahead.dwr.Remoter;
import uk.ltd.getahead.dwr.ScriptSessionManager;
import uk.ltd.getahead.dwr.ServerLoadMonitor;
import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.dwrp.ConverterManager;
import uk.ltd.getahead.dwr.dwrp.DefaultConverterManager;
import uk.ltd.getahead.dwr.dwrp.DwrpHtmlJsMarshaller;
import uk.ltd.getahead.dwr.dwrp.DwrpPlainJsMarshaller;
import uk.ltd.getahead.dwr.impl.DefaultAccessControl;
import uk.ltd.getahead.dwr.impl.DefaultAjaxFilterManager;
import uk.ltd.getahead.dwr.impl.DefaultContainer;
import uk.ltd.getahead.dwr.impl.DefaultCreatorManager;
import uk.ltd.getahead.dwr.impl.DefaultDebugPageGenerator;
import uk.ltd.getahead.dwr.impl.DefaultRemoter;
import uk.ltd.getahead.dwr.impl.DefaultScriptSessionManager;
import uk.ltd.getahead.dwr.impl.DefaultServerLoadMonitor;
import uk.ltd.getahead.dwr.impl.DefaultWebContextBuilder;
import uk.ltd.getahead.dwr.impl.DwrXmlConfigurator;
import uk.ltd.getahead.dwr.util.Logger;

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
     * Take a DefaultContainer and setup the default beans
     * @param defaultContainer The container to configure
     * @throws InstantiationException If we can't instantiate a bean
     * @throws IllegalAccessException If we have access problems creating a bean
     */
    public static void configureDefaults(DefaultContainer defaultContainer) throws InstantiationException, IllegalAccessException
    {
        defaultContainer.addParameter(AccessControl.class.getName(), DefaultAccessControl.class.getName());
        defaultContainer.addParameter(ConverterManager.class.getName(), DefaultConverterManager.class.getName());
        defaultContainer.addParameter(CreatorManager.class.getName(), DefaultCreatorManager.class.getName());
        defaultContainer.addParameter(UrlProcessor.class.getName(), UrlProcessor.class.getName());
        defaultContainer.addParameter(WebContextBuilder.class.getName(), DefaultWebContextBuilder.class.getName());
        defaultContainer.addParameter(AjaxFilterManager.class.getName(), DefaultAjaxFilterManager.class.getName());
        defaultContainer.addParameter(Remoter.class.getName(), DefaultRemoter.class.getName());
        defaultContainer.addParameter(DebugPageGenerator.class.getName(), DefaultDebugPageGenerator.class.getName());
        defaultContainer.addParameter(DwrpHtmlJsMarshaller.class.getName(), DwrpHtmlJsMarshaller.class.getName());
        defaultContainer.addParameter(DwrpPlainJsMarshaller.class.getName(), DwrpPlainJsMarshaller.class.getName());
        defaultContainer.addParameter(ScriptSessionManager.class.getName(), DefaultScriptSessionManager.class.getName());
        defaultContainer.addParameter(ServerLoadMonitor.class.getName(), DefaultServerLoadMonitor.class.getName());

        defaultContainer.addParameter("debug", "false"); //$NON-NLS-1$ //$NON-NLS-2$
        defaultContainer.addParameter("allowImpossibleTests", "false"); //$NON-NLS-1$ //$NON-NLS-2$
        defaultContainer.addParameter("scriptCompressed", "true"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * Take a DefaultContainer and setup the default beans
     * @param defaultContainer The container to configure
     * @param servletConfig The servlet configuration (null to ignore)
     * @throws InstantiationException If we can't instantiate a bean
     * @throws IllegalAccessException If we have access problems creating a bean
     */
    public static void configureFromServletConfig(DefaultContainer defaultContainer, ServletConfig servletConfig) throws InstantiationException, IllegalAccessException
    {
        Enumeration en = servletConfig.getInitParameterNames();
        while (en.hasMoreElements())
        {
            String name = (String) en.nextElement();
            String value = servletConfig.getInitParameter(name);
            defaultContainer.addParameter(name, value);
        }
    }

    /**
     * Add configurators from init params to the end of the list of
     * configurators.
     * @param container The container to configure
     * @param servletConfig The source of init parameters
     * @return true if any Configurators were read
     * @throws SAXException If the config file parse fails
     * @throws ParserConfigurationException If the config file parse fails
     * @throws IOException If the config file read fails
     */
    public static boolean configureUsingInitParams(Container container, ServletConfig servletConfig) throws IOException, ParserConfigurationException, SAXException
    {
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
                local.configure(container);
            }
        }

        return foundConfig;
    }

    /**
     * Allow all the configurators to have a go at the container in turn
     * @param container The container to configure
     * @param configurators A list of configurators to run against the container
     */
    public static void configure(Container container, List configurators)
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
     * Create a bunch of debug information about a container
     * @param container The container to print debug information about
     */
    public static void debugConfig(Container container)
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
