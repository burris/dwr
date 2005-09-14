package uk.ltd.getahead.dwr;

/**
 * This is the main processor that handles all the requests to DWR.
 * TODO: get rid of this interface
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface Processor extends Handler
{
    /**
     * Do we allow impossible tests for debug purposes
     * @param allowImpossibleTests The allowImpossibleTests to set.
     */
    void setAllowImpossibleTests(boolean allowImpossibleTests);

    /**
     * To what level do we compress scripts?
     * @param scriptCompressed The scriptCompressed to set.
     */
    void setScriptCompressed(boolean scriptCompressed);
}
