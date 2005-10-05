package uk.ltd.getahead.testdwr;

import java.lang.reflect.Method;

import uk.ltd.getahead.dwr.AjaxFilter;
import uk.ltd.getahead.dwr.AjaxFilterChain;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * An example filter that does some logging of Ajax calls
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Logging2AjaxFilter implements AjaxFilter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AjaxFilter#doFilter(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], uk.ltd.getahead.dwr.AjaxFilterChain)
     */
    public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception
    {
        log.debug("L2: About to execute: " + method.getName() + "() on " + obj); //$NON-NLS-1$ //$NON-NLS-2$
        Object reply = chain.doFilter(obj, method, params);
        log.debug("L2: - Executed: " + method.getName() + "() giving " + reply); //$NON-NLS-1$ //$NON-NLS-2$
        return reply;
    }
    
    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(Logging2AjaxFilter.class);
}
