package uk.ltd.getahead.dwr;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ltd.getahead.dwr.util.SwallowingHttpServletResponse;

/**
 * Class to enable us to access servlet parameters.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public final class ExecutionContext
{
    /**
     * Prevent instansiation outside of setExecutionContext()
     * @param request The incoming http request
     * @param response The outgoing http reply
     * @param config The servlet configuration
     * @see ExecutionContext#setExecutionContext(HttpServletRequest, HttpServletResponse, ServletConfig)
     */
    private ExecutionContext(HttpServletRequest request, HttpServletResponse response, ServletConfig config)
    {
        this.request = request;
        this.response = response;
        this.config = config;
    }

    /**
     * @return Returns the http session.
     */
    public HttpSession getSession()
    {
        return request.getSession();
    }

    /**
     * @param create 
     * @return Returns the http session.
     */
    public HttpSession getSession(boolean create)
    {
        return request.getSession(create);
    }

    /**
     * @return Returns the config.
     */
    public ServletConfig getServletConfig()
    {
        return config;
    }

    /**
     * @return Returns the context.
     */
    public ServletContext getServletContext()
    {
        return getSession().getServletContext();
    }

    /**
     * @return Returns the request.
     */
    public HttpServletRequest getHttpServletRequest()
    {
        return request;
    }

    /**
     * @return Returns the response.
     */
    public HttpServletResponse getHttpServletResponse()
    {
        return response;
    }

    /**
     * Forward a request to a given URL and catch the data written to it
     * @param url The URL to forward to
     * @return The text that results from forwarding to the given URL
     * @throws IOException 
     * @throws ServletException 
     */
    public String forwardToString(final String url) throws ServletException, IOException
    {
        final StringWriter sout = new StringWriter();
        final StringBuffer buffer = sout.getBuffer();

        HttpServletResponse fakeResponse = new SwallowingHttpServletResponse(getHttpServletResponse(), sout, url);

        getServletContext().getRequestDispatcher(url).forward(getHttpServletRequest(), fakeResponse);

        return buffer.toString();
    }

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ServletConfig config;

    private static ThreadLocal user = new ThreadLocal();

    /**
     * @return The current ExecutionContext
     * @deprecated Use ExecutionContext.get();
     * @see ExecutionContext#get()
     */
    public static ExecutionContext getExecutionContext()
    {
        return get();
    }

    /**
     * Accessor for the current ExecutionContext.
     * @return The current ExecutionContext
     */
    public static ExecutionContext get()
    {
        return (ExecutionContext) user.get();
    }

    /**
     * Make the current thread know what the current request is
     * @param request The incoming http request
     * @param response The outgoing http reply
     * @param config The servlet configuration
     * @see ExecutionContext#unset()
     */
    protected static void setExecutionContext(HttpServletRequest request, HttpServletResponse response, ServletConfig config)
    {
        user.set(new ExecutionContext(request, response, config));
    }

    /**
     * Unset the current ExecutionContext
     * @see ExecutionContext#setExecutionContext(HttpServletRequest, HttpServletResponse, ServletConfig)
     */
    protected static void unset()
    {
        user.set(null);
    }
}
