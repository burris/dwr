package uk.ltd.getahead.dwr.util;

import javax.servlet.http.HttpServlet;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Log
{
    /**
     * Prevent instansiation
     */
    private Log()
    {
    }

    /**
     * Associate a servlet with this thread for logging purposes.
     * @param servlet The servlet to use for logging in this thread
     */
    public static void setExecutionContext(HttpServlet servlet)
    {
        servlets.set(servlet);
    }

    /**
     * Remove the servlet from this thread for logging purposes
     */
    public static void unsetExecutionContext()
    {
        servlets.set(null);
    }

    /**
     * Log a warning message
     * @param message The text to log
     */
    public static void warn(String message)
    {
        warn(message, null);
    }

    /**
     * Log a warning message
     * @param message The text to log
     * @param th An optional stack trace
     */
    public static void warn(String message, Throwable th)
    {
        HttpServlet servlet = (HttpServlet) servlets.get();
        if (servlet != null)
        {
            servlet.log(message, th);
        }
        else
        {
            if (message != null)
            {
                System.out.println(message);
            }

            if (th != null)
            {
                th.printStackTrace();
            }
        }
    }

    /**
     * The container for all known threads
     */
    private static final ThreadLocal servlets = new ThreadLocal();
}
