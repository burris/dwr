package uk.ltd.getahead.dwr;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ConversionException extends Exception
{
    /**
     * 
     */
    public ConversionException()
    {
    }

    /**
     * @param message
     */
    public ConversionException(String message)
    {
        super(message);
    }

    /**
     * @param message
     * @param ex 
     */
    public ConversionException(String message, Throwable ex)
    {
        super(message);
        this.ex = ex;
    }

    /**
     * @param ex
     */
    public ConversionException(Throwable ex)
    {
        super(ex.getMessage());
        this.ex = ex;
    }

    /**
     * @return The cause of this exception (if any)
     */
    public Throwable getCause()
    {
        return ex;
    }

    private Throwable ex;
}
