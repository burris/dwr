package uk.ltd.getahead.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{

    public static Test suite()
    {
        TestSuite suite = new TestSuite("Test for uk.ltd.getahead.junit");
        //$JUnit-BEGIN$
        suite.addTestSuite(JavascriptUtilTest.class);
        //$JUnit-END$
        return suite;
    }

}

