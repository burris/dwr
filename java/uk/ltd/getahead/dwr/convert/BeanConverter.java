package uk.ltd.getahead.dwr.convert;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.ConverterManager;
import uk.ltd.getahead.dwr.ScriptSetup;
import uk.ltd.getahead.dwr.util.Log;

/**
 * Convert a Javascript associative array into a JavaBean
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class BeanConverter implements Converter
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
        if (data.startsWith("{"))
        {
            data = data.substring(1);
        }
        if (data.endsWith("}"))
        {
            data = data.substring(0, data.length() - 1);
        }

        try
        {
            StringTokenizer st = new StringTokenizer(data, ",");
            int size = st.countTokens();

            Object array = paramType.newInstance();
            BeanInfo info = Introspector.getBeanInfo(paramType);
            PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
            Map props = new HashMap();
            for (int i = 0; i < descriptors.length; i++)
            {
                String key = descriptors[i].getName();
                props.put(key, descriptors[i]);
            }

            for (int i = 0; i < size; i++)
            {
                String token = st.nextToken();

                if (token.trim().length() == 0)
                {
                    continue;
                }

                int colonpos = token.indexOf(":");

                if (colonpos == -1)
                {
                    throw new ConversionException("Missing ':' in object description: " + token);
                }

                String key = token.substring(0, colonpos).trim();
                String value = token.substring(colonpos + 1).trim();

                PropertyDescriptor descriptor = (PropertyDescriptor) props.get(key);
                if (descriptor == null)
                {
                    Log.warn("No setter for " + key);
                    StringBuffer all = new StringBuffer();
                    for (Iterator it = props.keySet().iterator(); it.hasNext();)
                    {
                        all.append(it.next());
                        all.append(" ");
                    }
                    Log.warn("Setters exist for "  + all);
                }
                else
                {
                    Class propType = descriptor.getPropertyType();

                    Object output = config.convertTo(propType, value);
                    descriptor.getWriteMethod().invoke(array, new Object[] { output });
                }
            }

            return array;
        }
        catch (ConversionException ex)
        {
            throw ex;
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
        StringBuffer buffer = new StringBuffer();
        buffer.append("var " + varname + " = new Object();");

        try
        {
            BeanInfo info = Introspector.getBeanInfo(data.getClass());
            PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
            for (int i = 0; i < descriptors.length; i++)
            {
                PropertyDescriptor descriptor = descriptors[i];
                String name = descriptor.getName();

                // We don't marshall getClass()
                if (!name.equals("class"))
                {
                    try
                    {
                        Method getter = descriptor.getReadMethod();
                        Object value = getter.invoke(data, new Object[0]);

                        ScriptSetup nested = config.convertFrom(value, converted);

                        buffer.append(nested.initCode);
                        buffer.append(varname);
                        buffer.append(".");
                        buffer.append(name);
                        buffer.append(" = ");
                        buffer.append(nested.assignCode);
                        buffer.append(";");
                    }
                    catch (Exception ex)
                    {
                        buffer.append("alert('Failed to marshall: " + name + ". " + ex + "');");
                    }
                }
            }
        }
        catch (IntrospectionException ex)
        {
            throw new ConversionException(ex);
        }

        ScriptSetup ss = new ScriptSetup();
        ss.initCode = buffer.toString();
        ss.assignCode = varname;
        ss.isValueType = false;
        return ss;
    }

    /**
     * To forward marshalling requests
     */
    private ConverterManager config;
}
