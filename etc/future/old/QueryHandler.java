package uk.ltd.getahead.dwr;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This interface is somewhat similar to Servlet except that doGet and doPost
 * are merged, init is replaced by our own mini-IoC initer, and most importantly
 * it is configured internally rather than requiring the user to add lots of
 * stuff to WEB-INF/web.xml.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface QueryHandler
{
    /**
     * The equivalent of doGet and doPost
     * @param req The browsers request
     * @param resp The response channel
     * @throws IOException
     */
    public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}

