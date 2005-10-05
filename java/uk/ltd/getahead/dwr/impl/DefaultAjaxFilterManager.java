package uk.ltd.getahead.dwr.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import uk.ltd.getahead.dwr.AjaxFilter;
import uk.ltd.getahead.dwr.AjaxFilterManager;

/**
 * The default implementation of AjaxFilterManager
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultAjaxFilterManager implements AjaxFilterManager
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AjaxFilterManager#getAjaxFilters(java.lang.Class)
     */
    public Iterator getAjaxFilters(String scriptname)
    {
        // PERFORMANCE: we could probably cache the results of these if we wanted to
        List reply = new ArrayList();

        reply.addAll(global);

        List classBased = (List) classBasedMap.get(scriptname);
        if (classBased != null)
        {
            reply.addAll(classBased);
        }

        reply.add(executor);

        return Collections.unmodifiableList(reply).iterator();
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AjaxFilterManager#addAjaxFilter(uk.ltd.getahead.dwr.AjaxFilter)
     */
    public void addAjaxFilter(AjaxFilter filter)
    {
        global.add(filter);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AjaxFilterManager#addAjaxFilter(uk.ltd.getahead.dwr.AjaxFilter, java.lang.Class)
     */
    public void addAjaxFilter(AjaxFilter filter, String scriptname)
    {
        List classBased = (List) classBasedMap.get(scriptname);
        if (classBased == null)
        {
            classBased = new ArrayList();
            classBasedMap.put(scriptname, classBased);
        }

        classBased.add(filter);
    }

    private AjaxFilter executor = new ExecuteAjaxFilter();
    private List global = new ArrayList();
    private Map classBasedMap = new HashMap();
}
