package uk.ltd.getahead.dwr.test;

/**
 * Methods to help unit test DWR.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id$
 */
public class Test
{
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
     * @return nest
     */
    public TestBean[] getNestingTest()
    {
        TestBean a = new TestBean(0, "!\"$%^&*()_", null);
        TestBean b = new TestBean(0, "!\"$%^&*()_", a);
        TestBean c = new TestBean(0, "!\"$%^&*()_", b);
        TestBean d = new TestBean(0, "!\"$%^&*()_", c);

        TestBean[] reply = new TestBean[]
        {
            a,
            c,
            d,
            d,
        };

        return reply;
    }

    /**
     * @param param1
     * @param param2
     * @return string
     */
    public String stringStringParam(String param1, String param2)
    {
        return "param1='"+param1+"' param2='"+param2+"'";
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
    public String dangerOverride(String x)
    {
        return "Test.dangerOverride("+x+") says hello.";
    }

    /**
     * @return string
     */
    public String dangerOverride()
    {
        return "Test.dangerOverride() says hello.";
    }
}
