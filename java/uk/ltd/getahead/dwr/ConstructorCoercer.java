package uk.ltd.getahead.dwr;

import java.lang.reflect.Constructor;

/**
 * .
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id$
 */
public class ConstructorCoercer implements Coercer
{
    /**
     * @param coerceTo
     */
    public ConstructorCoercer(Class coerceTo)
    {
        try
        {
            converter = coerceTo.getConstructor(new Class[] { String.class });
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException(ex.toString());
        }
    }

    /* (non-Javadoc)
     * @see com.mgrover.dwr.Coercer#getCoerceToClass()
     */
    public Class getCoerceToClass()
    {
        return Integer.class;
    }

    /* (non-Javadoc)
     * @see com.mgrover.dwr.Coercer#coerce(java.lang.String)
     */
    public Object coerce(String data)
    {
        try
        {
            return converter.newInstance(new Object[] { data });
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    private Constructor converter = null;
}
