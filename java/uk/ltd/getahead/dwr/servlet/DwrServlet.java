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
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ltd.getahead.dwr.AccessControl;
import uk.ltd.getahead.dwr.AjaxFilterManager;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.WebContextBuilder;
import uk.ltd.getahead.dwr.impl.DefaultContainer;
import uk.ltd.getahead.dwr.util.Logger;
import uk.ltd.getahead.dwr.util.ServletLoggingOutput;

/**
 * This is the main servlet that handles all the requests to DWR.
 * <p>It is on the large side because it can't use technologies like JSPs etc
 * since it all needs to be deployed in a single jar file, and while it might be
 * possible to integrate Velocity or similar I think simplicity is more
 * important, and there are only 2 real pages both script heavy in this servlet
 * anyway.</p>
 * <p>There are 5 things to do, in the order that you come across them:</p>
 * <ul>
 * <li>The index test page that points at the classes</li>
 * <li>The class test page that lets you execute methods</li>
 * <li>The interface javascript that uses the engine to send requests</li>
 * <li>The engine javascript to form the iframe request and process replies</li>
 * <li>The exec 'page' that executes the method and returns data to the iframe</li>
 * </ul>
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DwrServlet extends HttpServlet
{
    /**
     * @param config
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void setupContainer(ServletConfig config) throws InstantiationException, IllegalAccessException
    {
        // Load the factory with implementation information
        DefaultContainer container = new DefaultContainer();
        container.addParameter(AccessControl.class.getName(), "uk.ltd.getahead.dwr.impl.DefaultAccessControl"); //$NON-NLS-1$
        container.addParameter(ConverterManager.class.getName(), "uk.ltd.getahead.dwr.impl.DefaultConverterManager"); //$NON-NLS-1$
        container.addParameter(CreatorManager.class.getName(), "uk.ltd.getahead.dwr.impl.DefaultCreatorManager"); //$NON-NLS-1$
        container.addParameter(Processor.class.getName(), "uk.ltd.getahead.dwr.impl.DefaultProcessor"); //$NON-NLS-1$
        container.addParameter(WebContextBuilder.class.getName(), "uk.ltd.getahead.dwr.impl.DefaultWebContextBuilder"); //$NON-NLS-1$
        container.addParameter(AjaxFilterManager.class.getName(), "uk.ltd.getahead.dwr.impl.DefaultAjaxFilterManager"); //$NON-NLS-1$

        container.addParameter("index", "uk.ltd.getahead.dwr.impl.DefaultIndexProcessor"); //$NON-NLS-1$ //$NON-NLS-2$
        container.addParameter("test", "uk.ltd.getahead.dwr.impl.DefaultTestProcessor"); //$NON-NLS-1$ //$NON-NLS-2$
        container.addParameter("interface", "uk.ltd.getahead.dwr.impl.DefaultInterfaceProcessor"); //$NON-NLS-1$ //$NON-NLS-2$
        container.addParameter("exec", "uk.ltd.getahead.dwr.impl.DefaultExecProcessor"); //$NON-NLS-1$ //$NON-NLS-2$
        container.addParameter("file", "uk.ltd.getahead.dwr.impl.FileProcessor"); //$NON-NLS-1$ //$NON-NLS-2$

        container.addParameter("debug", "false"); //$NON-NLS-1$ //$NON-NLS-2$
        container.addParameter("allowImpossibleTests", "false"); //$NON-NLS-1$ //$NON-NLS-2$

        container.addParameter("scriptCompressed", "true"); //$NON-NLS-1$ //$NON-NLS-2$

        Enumeration en = config.getInitParameterNames();
        while (en.hasMoreElements())
        {
            String name = (String) en.nextElement();
            String value = config.getInitParameter(name);
            container.addParameter(name, value);
        }
        container.configurationFinished();

        servletHelper.initContainer(container);
    }

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
     public void init(ServletConfig config) throws ServletException
     {
         try
         {
             super.init(config);

             servletHelper.setServletConfig(config);
             servletHelper.setServletContext(config.getServletContext());
             servletHelper.setServletLoggingOutput(this);

             setupContainer(config);

             servletHelper.initWebContextBuilder(null, null);

             // Load the configurators
             servletHelper.addSystemConfigurator();
             boolean foundConfig = servletHelper.addConfiguratorsFromInitParams();
             if (!foundConfig)
             {
                 servletHelper.addDefaultDwrXmlConfigurator();
             }

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

             ServletLoggingOutput.unsetExecutionContext();
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
             servletHelper.setServletLoggingOutput(this);
             servletHelper.handle(request, response);
         }
         finally
         {
             servletHelper.deinitWebContextBuilder();
             servletHelper.unsetServletLoggingOutput();
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
     private static final Logger log = Logger.getLogger(DwrServlet.class);
}
