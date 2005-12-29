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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ltd.getahead.dwr.util.Logger;

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
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);

        try
        {
            servletHelper.setServletConfig(config);
            servletHelper.setServletLoggingOutput(this);

            servletHelper.initDefaultContainer();
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
            servletHelper.unsetServletLoggingOutput();
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
