package uk.ltd.getahead.dwr.convert;

import java.lang.reflect.Constructor;

import uk.ltd.getahead.dwr.Configuration;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.lang.StringEscapeUtils;

/**
 * An implementation of Converter for anything with a string constructor.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: ConstructorConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class ConstructorConverter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#init(uk.ltd.getahead.dwr.Configuration)
     */
    public void init(Configuration config)
    {
    }
    
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertTo(java.lang.Class, java.lang.String)
     */
    public Object convertTo(Class paramType, String data)
    {
        try
        {
            Constructor converter = paramType.getConstructor(new Class[] { String.class });
            return converter.newInstance(new Object[] { data });
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException(ex.toString());
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object)
     */
    public ScriptSetup convertFrom(Object data)
    {
        return new ScriptSetup("", "\"" + StringEscapeUtils.escapeJavaScript(data.toString()) + "\"");
    }
}
