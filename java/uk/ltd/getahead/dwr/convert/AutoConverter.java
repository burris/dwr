package uk.ltd.getahead.dwr.convert;

import java.lang.reflect.Method;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.Configuration;
import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;

/**
 * An implementation of Converter for Strings.
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id: StringConverter.java,v 1.2 2004/11/04 15:54:07 joe_walker Exp $
 */
public class AutoConverter implements Converter
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
    public Object convertTo(Class paramType, String data) throws ConversionException
    {
        try
        {
            Object object = paramType.newInstance();

            for (StringTokenizer st = new StringTokenizer(data); st.hasMoreTokens();)
            {
                String token = st.nextToken();
                int equalspos = token.indexOf("=");
                String ldata = token.substring(0, equalspos);
                String rdata = token.substring(equalspos);

                String setter = "set" + ldata.substring(0, 1).toUpperCase() + ldata.substring(1);

                Method method = paramType.getMethod(setter, new Class[] { String.class });
                method.invoke(object, new Object[] { rdata });
            }

            return object;
        }
        catch (Exception ex)
        {
            throw new ConversionException(ex);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object)
     */
    public ScriptSetup convertFrom(Object data)
    {
        return new ScriptSetup("", data.toString());
    }
}
