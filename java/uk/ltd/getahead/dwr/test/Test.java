package uk.ltd.getahead.dwr.test;

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
    public String noParam()
    {
        return "Test.noParam() says hello";
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
     * @return string
     */
    public String proxy()
    {
        return stringParam("proxy");
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
