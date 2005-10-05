package uk.ltd.getahead.testdwr;

import java.lang.reflect.Method;

import uk.ltd.getahead.dwr.AjaxFilter;
import uk.ltd.getahead.dwr.AjaxFilterChain;

/**
 * An example filter that uses a fairly random event to define it's security
 * policy: If the current system time (in milliseconds) is even then the call
 * is allowed, otherwise it is denied.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class RandomSecurityAjaxFilter implements AjaxFilter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AjaxFilter#doFilter(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], uk.ltd.getahead.dwr.AjaxFilterChain)
     */
    public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception
    {
        if (System.currentTimeMillis() % 2 == 1)
        {
            return chain.doFilter(obj, method, params);
        }
        else
        {
            throw new SecurityException("Wrong time. Try again later"); //$NON-NLS-1$
        }
    }
}
