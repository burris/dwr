package uk.ltd.getahead.dwr.convert;

import uk.ltd.getahead.dwr.Configuration;
import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.lang.StringEscapeUtils;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class PrimitiveConverter implements Converter
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
    public Object convertTo(Class paramType, String object) throws ConversionException
    {
        try
        {
            if (paramType == Boolean.TYPE || paramType == Boolean.class)
            {
                return new Boolean(object.trim());
            }
            else if (paramType == Byte.TYPE || paramType == Byte.class)
            {
                if (object.length() == 0)
                {
                    byte b = 0;
                    return new Byte(b);
                }
                return new Byte(object.trim());
            }
            else if (paramType == Short.TYPE || paramType == Short.class)
            {
                if (object.length() == 0)
                {
                    short s = 0;
                    return new Short(s);
                }
                return new Short(object.trim());
            }
            else if (paramType == Character.TYPE || paramType == Character.class)
            {
                if (object.length() == 1)
                {
                    return new Character(object.charAt(0));
                }
                else
                {
                    throw new ConversionException("Can't convert string to single char: '" + object + "'");
                }
            }
            else if (paramType == Integer.TYPE || paramType == Integer.class)
            {
                if (object.length() == 0)
                {
                    return new Integer(0);
                }
                return new Integer(object.trim());
            }
            else if (paramType == Long.TYPE || paramType == Long.class)
            {
                if (object.length() == 0)
                {
                    return new Long(0);
                }
                return new Long(object.trim());
            }
            else if (paramType == Float.TYPE || paramType == Float.class)
            {
                if (object.length() == 0)
                {
                    return new Float(0);
                }
                return new Float(object.trim());
            }
            else if (paramType == Double.TYPE || paramType == Double.class)
            {
                if (object.length() == 0)
                {
                    return new Double(0);
                }
                return new Double(object.trim());
            }

            throw new ConversionException("Non-primitive paramType: "+paramType.getName());
        }
        catch (NumberFormatException ex)
        {
            throw new ConversionException("Format error: "+ex.getMessage(), ex);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object)
     */
    public ScriptSetup convertFrom(Object object)
    {
        Class paramType = object.getClass();

        if (object.equals(Boolean.TRUE))
        {
            return new ScriptSetup("", "true");
        }
        else if (object.equals(Boolean.FALSE))
        {
            return new ScriptSetup("", "false");
        }
        else if (paramType == Character.class)
        {
            // Treat characters as strings
            return new ScriptSetup("", "\"" + StringEscapeUtils.escapeJavaScript(object.toString()) + "\"");
        }
        else
        {
            // We just use the default toString for all numbers
            return new ScriptSetup("", object.toString());
        }
    }
}
