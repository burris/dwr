package uk.ltd.getahead.dwr;

/**
 * When something goes wrong with executing an exec request.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ExecutionException extends Exception
{
    /**
     * Construct a ExecutionException with a description message
     * @param message error description
     */
    public ExecutionException(String message)
    {
        super(message);
    }

    /**
     * Construct a ExecutionException with a description message and exception
     * @param message error description
     * @param cause error stack trace
     */
    public ExecutionException(String message, Throwable cause)
    {
        super(message);
        this.cause = cause;
    }

    /**
     * @return The cause of this exception (if any)
     */
    public Throwable getCause()
    {
        return cause;
    }

    /**
     * Stored exception cause
     */
    private Throwable cause;
}

