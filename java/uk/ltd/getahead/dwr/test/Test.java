package uk.ltd.getahead.dwr.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import uk.ltd.getahead.dwr.ExecutionContext;

/**
 * .
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id$
 */
public class Test
{
    /**
     * @return string
     */
    public String getServerInfo()
    {
        String info = ExecutionContext.getExecutionContext().getServletContext().getServerInfo();
        return "server info: " + info;
    }

    /**
     * @return string
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

    /**
     * @param test
     * @return string
     */
    public String stringParam(String test)
    {
        return "Test.stringParam(String) says hello, "+test;
    }

    /**
     * @param test1
     * @param test2
     * @return string
     */
    public String stringStringParam(String test1, String test2)
    {
        return "Test.stringParam(String, String) says hello, "+test1+" "+test2;
    }

    /**
     * @param test
     * @return string
     */
    public String intParam(int test)
    {
        return "Test.intParam(int) says hello, #"+test;
    }

    /**
     * @return string
     */
    public String delete()
    {
        return "You can't touch me";
    }

    /**
     * @return string
     */
    protected String protectedMethod()
    {
        privateMethod();
        return "You can't touch me";
    }

    /**
     * @return string
     */
    private String privateMethod()
    {
        return "You can't touch me";
    }

    /**
     * @return string
     */
    public static String staticMethod()
    {
        return "static Test.staticMethod() says hello.";
    }

    /**
     * @param x
     * @return string
     */
    public static String dangerOverride(String x)
    {
        return "static Test.dangerOverride("+x+") says hello.";
    }

    /**
     * @return string
     */
    public static String dangerOverride()
    {
        return "static Test.dangerOverride() says hello.";
    }
}
