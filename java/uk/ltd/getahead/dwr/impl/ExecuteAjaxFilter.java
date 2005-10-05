package uk.ltd.getahead.dwr.impl;

import java.lang.reflect.Method;

import uk.ltd.getahead.dwr.AjaxFilter;
import uk.ltd.getahead.dwr.AjaxFilterChain;

/**
 * The last element in a filter chain actually executes the method.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ExecuteAjaxFilter implements AjaxFilter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AjaxFilter#doFilter(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], uk.ltd.getahead.dwr.AjaxFilterChain)
     */
    public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception
    {
        return method.invoke(obj, params);
    }
}
