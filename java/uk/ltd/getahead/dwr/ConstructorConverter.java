package uk.ltd.getahead.dwr;

import java.lang.reflect.Constructor;

/**
 * An implementation of Converter for anything with a string constructor.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: ConstructorConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class ConstructorConverter implements Converter
{
    /**
     * A type that can be converted using a single string constructor
     * @param type The convertion class
     */
    public ConstructorConverter(Class type)
    {
        try
        {
            this.type = type;
            converter = type.getConstructor(new Class[] { String.class });
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException(ex.toString());
        }
    }

    /* (non-Javadoc)
     * @see com.mgrover.dwr.Coercer#getCoerceToClass()
     */
    public Class getConversionClass()
    {
        return type;
    }

    /* (non-Javadoc)
     * @see com.mgrover.dwr.Coercer#coerce(java.lang.String)
     */
    public Object convertTo(String data)
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

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object)
     */
    public String convertFrom(Object data)
    {
        return data.toString();
    }

    private Class type = null;
    private Constructor converter = null;
}
