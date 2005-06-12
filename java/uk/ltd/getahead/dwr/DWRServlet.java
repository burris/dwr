package uk.ltd.getahead.dwr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class DWRServlet extends HttpServlet
{
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);

        // How much logging do we do?
        String logLevel = config.getInitParameter(INIT_LOGLEVEL);
        if (logLevel != null)
        {
            ServletLoggingOutput.setLevel(logLevel);
        }

        // Maybe we want to override the ExecutionContext
        // This code is un-documented, and experimental. We'll keep it if it
        // turns out to be useful.
        String execCxName = config.getInitParameter(INIT_EXEC_CONTEXT);
        if (execCxName != null)
        {
            try
            {
                ExecutionContext.setImplementation(execCxName);
            }
            catch (Exception ex)
            {
                log.fatal("Invalid executionContext parameter", ex); //$NON-NLS-1$
                throw new ServletException(Messages.getString("DWRServlet.ExecutionContextInit", execCxName, ex)); //$NON-NLS-1$
            }
        }

        // Setup the creator manager
        String creatorMgrName = config.getInitParameter(INIT_CREATOR);
        if (creatorMgrName == null)
        {
            creatorMgrName = INIT_DEFAULT_CREATOR;
        }

        CreatorManager creatorManager;
        try
        {
            Class creatorMgrClass = Class.forName(creatorMgrName);
            creatorManager = (CreatorManager) creatorMgrClass.newInstance();
        }
        catch (Exception ex)
        {
            log.fatal("Failed to create the creator manager", ex); //$NON-NLS-1$
            throw new ServletException(Messages.getString("DWRServlet.CreatorManagerInit", creatorMgrName, ex)); //$NON-NLS-1$
        }

        // Setup the converter manager
        String converterMgrName = config.getInitParameter(INIT_CONVERTER);
        if (converterMgrName == null)
        {
            converterMgrName = INIT_DEFAULT_CONVERTER;
        }

        ConverterManager converterManager;
        try
        {
            Class converterMgrClass = Class.forName(converterMgrName);
            converterManager = (ConverterManager) converterMgrClass.newInstance();
        }
        catch (Exception ex)
        {
            log.fatal("Failed to create the converter manager", ex); //$NON-NLS-1$
            throw new ServletException(Messages.getString("DWRServlet.ConverterManagerInit", converterMgrName, ex)); //$NON-NLS-1$
        }

        // Are we in debug mode?
        String debugStr = config.getInitParameter(INIT_DEBUG);
        boolean debug = Boolean.valueOf(debugStr).booleanValue();
        creatorManager.setDebug(debug);

        Configuration configuration = new Configuration();
        configuration.setConverterManager(converterManager);
        configuration.setCreatorManager(creatorManager);

        dwrEngine = new DwrEngine();
        dwrEngine.setConfiguration(configuration);

        // Load the system config file
        InputStream in = getClass().getResourceAsStream(FILE_DWR_XML);
        try
        {
            configuration.addConfig(in);
        }
        catch (Exception ex)
        {
            throw new ServletException(Messages.getString("DWRServlet.ConfigError", FILE_DWR_XML), ex); //$NON-NLS-1$
        }

        // Find all the init params
        Enumeration en = config.getInitParameterNames();

        boolean foundConfig = false;

        // Loop through the ones that do exist
        while (en.hasMoreElements())
        {
            String name = (String) en.nextElement();
            if (name.startsWith(INIT_CONFIG))
            {
                foundConfig = true;

                // if the init param starts with "config" then try to load it
                String configFile = config.getInitParameter(name);
                readFile(configFile);
            }
        }

        // If there are none then use the default name
        if (!foundConfig)
        {
            readFile(DEFAULT_DWR_XML);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try
        {
            ExecutionContext.setExecutionContext(req, resp, getServletConfig(), getServletContext());
            ServletLoggingOutput.setExecutionContext(this);

            dwrEngine.handle(req, resp);
        }
        finally
        {
            ExecutionContext.unset();
            ServletLoggingOutput.unsetExecutionContext();
        }
    }

    /**
     * Load a DWR config file.
     * @param configFile the config file to read
     * @throws ServletException If the extra checking of the config file fails
     */
    protected void readFile(String configFile) throws ServletException
    {
        try
        {
            InputStream in = getServletContext().getResourceAsStream(configFile);
            if (in == null)
            {
                throw new ServletException(Messages.getString("DWRServlet.MissingFile", configFile)); //$NON-NLS-1$
            }

            dwrEngine.getConfiguration().addConfig(in);
        }
        catch (Exception ex)
        {
            throw new ServletException(Messages.getString("DWRServlet.ConfigError", configFile), ex); //$NON-NLS-1$
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        log.error("Warning: DWRServlet has not been designed for use in collections."); //$NON-NLS-1$
        return super.hashCode();
    }

    protected static final String FILE_DWR_XML = "dwr.xml"; //$NON-NLS-1$

    protected static final String INIT_CONFIG = "config"; //$NON-NLS-1$

    protected static final String INIT_DEBUG = "debug"; //$NON-NLS-1$

    protected static final String INIT_LOGLEVEL = "logLevel"; //$NON-NLS-1$

    protected static final String INIT_EXEC_CONTEXT = "executionContext"; //$NON-NLS-1$

    protected static final String INIT_CONVERTER = "converterManager"; //$NON-NLS-1$

    protected static final String INIT_CREATOR = "creatorManager"; //$NON-NLS-1$

    protected static final String INIT_DEFAULT_CONVERTER = "uk.ltd.getahead.dwr.impl.DefaultConverterManager"; //$NON-NLS-1$

    protected static final String INIT_DEFAULT_CREATOR = "uk.ltd.getahead.dwr.impl.DefaultCreatorManager"; //$NON-NLS-1$

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DWRServlet.class);

    /**
     * The default dwr.xml file path
     */
    protected static final String DEFAULT_DWR_XML = "/WEB-INF/dwr.xml"; //$NON-NLS-1$

    /** The dwr engine to be used by this servlet. */
    private DwrEngine dwrEngine;
}
