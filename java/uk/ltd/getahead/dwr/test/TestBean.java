package uk.ltd.getahead.dwr.test;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class TestBean
{
    /**
     * @return Returns the integer.
     */
    public int getInteger()
    {
        return integer;
    }

    /**
     * @param integer The integer to set.
     */
    public void setInteger(int integer)
    {
        this.integer = integer;
    }

    /**
     * @return Returns the string.
     */
    public String getString()
    {
        return string;
    }

    /**
     * @param string The string to set.
     */
    public void setString(String string)
    {
        this.string = string;
    }

    private String string = "Default initial value";
    private int integer = 42;
}

