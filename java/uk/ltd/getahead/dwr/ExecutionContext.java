package uk.ltd.getahead.dwr;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class to enable us to access servlet parameters.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ExecutionContext
{
    /**
     * @param request
     * @param response
     * @param config
     */
    public ExecutionContext(HttpServletRequest request, HttpServletResponse response, ServletConfig config)
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
        return request.getSession(true);
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

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ServletConfig config;

    private static ThreadLocal user = new ThreadLocal();

    /**
     * @return The current ExecutionContext
     */
    public static ExecutionContext getExecutionContext()
    {
        return (ExecutionContext) user.get();
    }

    /**
     * @param request
     * @param response
     * @param config
     */
    protected static void setExecutionContext(HttpServletRequest request, HttpServletResponse response, ServletConfig config)
    {
        user.set(new ExecutionContext(request, response, config));
    }

    /**
     * Unset the current ExecutionContext
     */
    protected static void unset()
    {
        user.set(null);
    }
}
