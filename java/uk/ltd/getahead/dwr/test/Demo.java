package uk.ltd.getahead.dwr.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import uk.ltd.getahead.dwr.ExecutionContext;

/**
 * Examples for the demo pages.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Demo
{
    /**
     * If you change this you should change list.html at the same time.
     * @param big do you want the numbers to be big?
     * @return an array of numbers
     */
    public int[] getNumbers(boolean big)
    {
        if (big)
        {
            return new int[] { 1000, 2000, 3000, 4000 };
        }
        else
        {
            return new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        }
    }

    /**
     * Get information about the host server.
     * @return string host information
     */
    public String getServerInfo()
    {
        return ExecutionContext.getExecutionContext().getServletContext().getServerInfo();
    }

    /**
     * Get information about the use of this page.
     * @return string click information.
     */
    public String getClicks()
    {
        HttpSession session = ExecutionContext.getExecutionContext().getSession();
        ServletContext context = ExecutionContext.getExecutionContext().getServletContext();

        Integer contextClicks = (Integer) context.getAttribute("contextClicks");
        Integer sessionClicks = (Integer) session.getAttribute("sessionClicks");

        if (contextClicks == null)
        {
            contextClicks = new Integer(0);
        }

        if (sessionClicks == null)
        {
            sessionClicks = new Integer(0);
        }

        contextClicks = new Integer(contextClicks.intValue() + 1);
        sessionClicks = new Integer(sessionClicks.intValue() + 1);

        context.setAttribute("contextClicks", contextClicks);
        session.setAttribute("sessionClicks", sessionClicks);

        return "getClicks() has been clicked "+sessionClicks+" times this session and "+contextClicks+" times since the last deployment";
    }

}
