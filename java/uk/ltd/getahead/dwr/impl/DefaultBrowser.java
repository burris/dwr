package uk.ltd.getahead.dwr.impl;

import java.util.ArrayList;
import java.util.List;

import uk.ltd.getahead.dwr.Browser;
import uk.ltd.getahead.dwr.ClientScript;

/**
 * @author
 */
public class DefaultBrowser implements Browser
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Browser#isValid()
     */
    public boolean isValid()
    {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Browser#addScript(uk.ltd.getahead.dwr.ClientScript)
     */
    public void addScript(ClientScript script)
    {
        synchronized (scripts)
        {
            scripts.add(script);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Browser#removeScript(uk.ltd.getahead.dwr.ClientScript)
     */
    public boolean removeScript(ClientScript script)
    {
        synchronized (scripts)
        {
            return scripts.remove(script);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Browser#removeAllScripts()
     */
    public List removeAllScripts()
    {
        List copy = new ArrayList();

        synchronized (scripts)
        {
            copy.addAll(scripts);
            scripts.clear();
        }

        return copy;
    }

    /**
     * The list of waiting scripts
     */
    private List scripts = new ArrayList();
}
