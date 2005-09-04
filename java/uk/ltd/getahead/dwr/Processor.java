package uk.ltd.getahead.dwr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the main processor that handles all the requests to DWR.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface Processor
{
    /**
     * @param allowImpossibleTests The allowImpossibleTests to set.
     */
    void setAllowImpossibleTests(boolean allowImpossibleTests);

    /**
     * @param scriptCompressed The scriptCompressed to set.
     */
    void setScriptCompressed(boolean scriptCompressed);

    /**
     * The equivalent of doGet and doPost
     * @param req The browsers request
     * @param resp The response channel
     * @throws IOException If an i/o error occurs
     * @throws ServletException For other processing errors
     */
    void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
