package uk.ltd.getahead.dwr;

/**
 * An implementation of Converter for Strings.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: StringConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class StringConverter implements Converter
{
    /* (non-Javadoc)
     * @see com.mgrover.dwr.Coercer#getCoerceToClass()
     */
    public Class getConversionClass()
    {
        return String.class;
    }

    /* (non-Javadoc)
     * @see com.mgrover.dwr.Coercer#coerce(java.lang.String)
     */
    public Object convertTo(String data)
    {
        return data;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object)
     */
    public String convertFrom(Object data)
    {
        return data.toString();
    }
}
