package uk.ltd.getahead.dwr.convert;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.ScriptSetup;

/**
 * An implementation of Converter for Arrays.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: StringConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class ArrayConverter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#init(uk.ltd.getahead.dwr.Configuration)
     */
    public void init(ConverterManager newConfig)
    {
        this.converterManager = newConfig;
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

        if (data.startsWith("["))
        {
            data = data.substring(1);
        }
        if (data.endsWith("]"))
        {
            data = data.substring(0, data.length() - 1);
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
                Object output = converterManager.convertTo(componentType, token);
                Array.set(array, i, output);
            }

            return array;
        }
        catch (Exception ex)
        {
            throw new ConversionException(ex);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object, java.util.Map)
     */
    public ScriptSetup convertFrom(Object data, Map converted, String varname) throws ConversionException
    {
        if (!data.getClass().isArray())
        {
            throw new ConversionException("Class: " + data.getClass() + " is not an array type");
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("var " + varname + " = new Array();");

        int size = Array.getLength(data);
        for (int i = 0; i < size; i++)
        {
            ScriptSetup nested = converterManager.convertFrom(Array.get(data, i), converted);

            buffer.append(nested.initCode);
            buffer.append(varname + "[");
            buffer.append(i);
            buffer.append("] = ");
            buffer.append(nested.assignCode);
            buffer.append(";");
        }

        ScriptSetup ss = new ScriptSetup();
        ss.initCode = buffer.toString();
        ss.assignCode = varname;
        ss.isValueType = false;
        return ss;
    }

    private ConverterManager converterManager;
}
