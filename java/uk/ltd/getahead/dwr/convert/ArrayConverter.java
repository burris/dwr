package uk.ltd.getahead.dwr.convert;

import java.lang.reflect.Array;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.Configuration;
import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;

/**
 * An implementation of Converter for Strings.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: StringConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class ArrayConverter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#init(uk.ltd.getahead.dwr.Configuration)
     */
    public void init(Configuration newConfig)
    {
        this.config = newConfig;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertTo(java.lang.Class, java.lang.String)
     */
    public Object convertTo(Class paramType, String data) throws ConversionException
    {
        if (!paramType.isArray())
        {
            throw new ConversionException("Class: " + paramType + " is not an array type");
        }

        try
        {
            StringTokenizer st = new StringTokenizer(data, ",");
            int size = st.countTokens();

            Class componentType = paramType.getComponentType();
            //componentType = LocalUtil.getNonPrimitiveType(componentType);
            Object array = Array.newInstance(componentType, size);
            for (int i = 0; i < size; i++)
            {
                String token = st.nextToken();
                Object converted = config.convertTo(componentType, token);
                Array.set(array, i, converted);
            }

            return array;
        }
        catch (Exception ex)
        {
            throw new ConversionException(ex);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object)
     */
    public ScriptSetup convertFrom(Object data) throws ConversionException
    {
        ScriptSetup ss = new ScriptSetup();

        if (!data.getClass().isArray())
        {
            throw new ConversionException("Class: " + data.getClass() + " is not an array type");
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("var dwrArray = new Array();");

        int size = Array.getLength(data);
        for (int i = 0; i < size; i++)
        {
            ScriptSetup converted = config.convertFrom(Array.get(data, i));

            buffer.append(converted.initCode);
            buffer.append("dwrArray[");
            buffer.append(i);
            buffer.append("] = ");
            buffer.append(converted.assignCode);
            buffer.append(";");
        }

        ss.initCode = buffer.toString();
        ss.assignCode = "dwrArray";

        return ss;
    }

    private Configuration config;
}
