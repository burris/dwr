package org.directwebremoting.dwrp;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.extend.ScriptConduit;
import org.directwebremoting.util.Continuation;

/**
 * Implementaion of ScriptConduit that just resumes a continuation.
 */
public class ResumeContinuationScriptConduit extends ScriptConduit
{
    /**
     * @param continuation Our Jetty Continuation wrapper
     */
    public ResumeContinuationScriptConduit(Continuation continuation)
    {
        super(RANK_PROCEDURAL);
        this.continuation = continuation;
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.ScriptConduit#addScript(org.directwebremoting.ScriptBuffer)
     */
    @Override
    public boolean addScript(ScriptBuffer script)
    {
        try
        {
            continuation.resume();
        }
        catch (Exception ex)
        {
            log.warn("Exception in continuation.resume()", ex);
        }

        // never actually handle the script!
        return false;
    }

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(ResumeContinuationScriptConduit.class);

    /**
     * The Jetty continuation
     */
    private final Continuation continuation;
}