package uk.ltd.getahead.dwr;

import java.util.Iterator;

/**
 * A class that manages the various <code>AjaxFilter</code>s and what classes
 * they are registered against.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface AjaxFilterManager
{
    /**
     * Retrieve the global and class-based AjaxFilters for a given class.
     * @param scriptname The scriptname to use to filter the class-based filters
     * @return An iterator over the available filters.
     */
    Iterator getAjaxFilters(String scriptname);

    /**
     * Add a global AjaxFilter
     * @param filter The new global AjaxFilter
     */
    void addAjaxFilter(AjaxFilter filter);

    /**
     * Add a class based AjaxFilter
     * @param filter The new AjaxFilter
     * @param scriptname The scriptname to filter against
     */
    void addAjaxFilter(AjaxFilter filter, String scriptname);
}
