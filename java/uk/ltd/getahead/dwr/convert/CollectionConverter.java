package uk.ltd.getahead.dwr.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.ScriptSetup;

/**
 * An implementation of Converter for Collections of Strings.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: StringConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class CollectionConverter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#init(uk.ltd.getahead.dwr.Configuration)
     */
    public void init(ConverterManager newConfig)
    {
        this.config = newConfig;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertTo(java.lang.Class, java.lang.String)
     */
    public Object convertTo(Class paramType, String data) throws ConversionException
    {
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

            Collection col;
            if (Iterator.class.isAssignableFrom(paramType))
            {
                col = new ArrayList();
            }
            else if (Collection.class.isAssignableFrom(paramType))
            {
                col = (Collection) paramType.newInstance();
            }
            else
            {
                throw new ConversionException("Can't convert javascript arrays to " + paramType);
            }

            for (int i = 0; i < size; i++)
            {
                String token = st.nextToken();
                Object output = config.convertTo(String.class, token);
                col.add(output);
            }

            return col;
        }
        catch (Exception ex)
        {
            throw new ConversionException(ex);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object, Map)
     */
    public ScriptSetup convertFrom(Object data, Map converted, String varname) throws ConversionException
    {
        Iterator it = null;
        if (data instanceof Collection)
        {
            Collection col = (Collection) data;
            it = col.iterator();
        }
        else if (data instanceof Iterator)
        {
            it = (Iterator) data;
        }
        else
        {
            throw new ConversionException("Can't convert " + data.getClass().getName() + " to a javscript array.");
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("var " + varname + " = new Array();");

        int i = 0;
        while (it.hasNext())
        {
            Object element = it.next();

            ScriptSetup nested = config.convertFrom(element, converted);

            buffer.append(nested.initCode);
            buffer.append(varname);
            buffer.append("[");
            buffer.append(i);
            buffer.append("] = ");
            buffer.append(nested.assignCode);
            buffer.append(";");

            i++;
        }

        ScriptSetup ss = new ScriptSetup();
        ss.initCode = buffer.toString();
        ss.assignCode = varname;
        ss.isValueType = false;
        return ss;
    }

    /**
     * For nested conversions
     */
    private ConverterManager config;
}
