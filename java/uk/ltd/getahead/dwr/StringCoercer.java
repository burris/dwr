package uk.ltd.getahead.dwr;

/**
 * .
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id$
 */
public class StringCoercer implements Coercer
{
    /* (non-Javadoc)
     * @see com.mgrover.dwr.Coercer#getCoerceToClass()
     */
    public Class getCoerceToClass()
    {
        return String.class;
    }

    /* (non-Javadoc)
     * @see com.mgrover.dwr.Coercer#coerce(java.lang.String)
     */
    public Object coerce(String data)
    {
        return data;
    }
}
