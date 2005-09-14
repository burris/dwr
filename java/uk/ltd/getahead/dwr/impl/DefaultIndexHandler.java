package uk.ltd.getahead.dwr.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.Handler;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultIndexHandler implements Handler
{
    /**
     * Create a debug mode only index page to all the available classes
     * @param req The browsers request
     * @param resp The response channel
     * @throws IOException If writing to the output fails
     */
    public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        if (!creatorManager.isDebug())
        {
            log.warn("Failed attempt to access index page outside of debug mode. Set the debug init-parameter to true to enable."); //$NON-NLS-1$
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        resp.setContentType(HtmlConstants.MIME_HTML);

        PrintWriter out = resp.getWriter();

        out.println("<html>"); //$NON-NLS-1$
        out.println("<head><title>DWR Test Index</title></head>"); //$NON-NLS-1$
        out.println("<body>"); //$NON-NLS-1$

        out.println("<h2>Classes known to DWR:</h2>"); //$NON-NLS-1$
        out.println("<ul>"); //$NON-NLS-1$
        for (Iterator it = creatorManager.getCreatorNames().iterator(); it.hasNext();)
        {
            String name = (String) it.next();
            Creator creator = creatorManager.getCreator(name);
            out.println("<li><a href='" + HtmlConstants.PATH_TEST + name + "'>" + name + "</a> (" + creator.getType().getName() + ")</li>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
        }
        out.println("</ul>"); //$NON-NLS-1$

        out.println("<h2>Other Links</h2>"); //$NON-NLS-1$
        out.println("<ul>"); //$NON-NLS-1$
        out.println("<li>Up to <a href='" + req.getContextPath() + "/'>top level of web app</a>.</li>"); //$NON-NLS-1$ //$NON-NLS-2$
        out.println("</ul>"); //$NON-NLS-1$

        out.println("</body></html>"); //$NON-NLS-1$
        out.flush();
    }

    /**
     * Accessor for the DefaultCreatorManager that we configure
     * @param creatorManager The new DefaultConverterManager
     */
    public void setCreatorManager(CreatorManager creatorManager)
    {
        this.creatorManager = creatorManager;
    }

    /**
     * How we create new beans
     */
    protected CreatorManager creatorManager = null;

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DefaultIndexHandler.class);
}
