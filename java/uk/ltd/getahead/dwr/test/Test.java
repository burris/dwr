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
     * @param test1
     * @param test2
     * @return string
     */
    public String stringStringParam(String test1, String test2)
    {
        return "Test.stringParam(String, String) says hello, "+test1+" "+test2;
    }

    /**
     * 
     */
    public void voidParam()
    {
    }

    /**
     * @param test
     * @return string
     */
    public boolean booleanParam(boolean test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public byte byteParam(byte test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public char charParam(char test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public short shortParam(short test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public int intParam(int test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public long longParam(long test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public float floatParam(float test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public double doubleParam(double test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public String stringParam(String test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public boolean[] booleanArrayParam(boolean[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public char[] charArrayParam(char[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public byte[] byteArrayParam(byte[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public short[] shortArrayParam(short[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public int[] intArrayParam(int[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public long[] longArrayParam(long[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public float[] floatArrayParam(float[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public double[] doubleArrayParam(double[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public String[] stringArrayParam(String[] test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public TestBean testBeanParam(TestBean test)
    {
        return test;
    }

    /**
     * @param test
     * @return string
     */
    public TestBean[] testBeanArrayParam(TestBean[] test)
    {
        return test;
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
