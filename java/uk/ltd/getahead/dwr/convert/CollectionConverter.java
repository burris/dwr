package uk.ltd.getahead.dwr.convert;

import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.Configuration;
import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;

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
    public void init(Configuration newConfig)
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

            Collection col = (Collection) paramType.newInstance();
            for (int i = 0; i < size; i++)
            {
                String token = st.nextToken();
                Object converted = config.convertTo(String.class, token);
                col.add(converted);
            }

            return col;
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

        Collection col = (Collection) data;

        StringBuffer buffer = new StringBuffer();
        buffer.append("var dwrCol = new Array();");

        int i = 0;
        for (Iterator it = col.iterator(); it.hasNext();)
        {
            Object element = it.next();

            ScriptSetup converted = config.convertFrom(element);

            buffer.append(converted.initCode);
            buffer.append("dwrCol[");
            buffer.append(i);
            buffer.append("] = ");
            buffer.append(converted.assignCode);
            buffer.append(";");

            i++;
        }

        ss.initCode = buffer.toString();
        ss.assignCode = "dwrCol";

        return ss;
    }

    private Configuration config;
}
