package uk.ltd.getahead.dwr.convert;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.Configuration;
import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.util.LocalUtil;
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
    public void init(Configuration newConfig)
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

                    Object converted = config.convertTo(propType, value);
                    descriptor.getWriteMethod().invoke(array, new Object[] { converted });
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
     * @see uk.ltd.getahead.dwr.Converter#convertFrom(java.lang.Object)
     */
    public ScriptSetup convertFrom(Object data) throws ConversionException
    {
        ScriptSetup ss = new ScriptSetup();

        StringBuffer buffer = new StringBuffer();
        buffer.append("var dwrObject = new Object();");

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

                        ScriptSetup converted = config.convertFrom(value);

                        buffer.append(converted.initCode);
                        buffer.append("dwrObject.");
                        buffer.append(name);
                        buffer.append(" = ");
                        buffer.append(converted.assignCode);
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

        ss.initCode = buffer.toString();
        ss.assignCode = "dwrObject";

        return ss;
    }

    private Configuration config;

    /**
     * @param name 
     * @param obj 
     * @return string
     */
    public String debugBean(String name, Object obj)
    {
        List reply = new ArrayList();
        debugbeanInternal(name, obj, reply, 0);

        StringBuffer debug = new StringBuffer("from debugger: "+this+"\n");
        for (Iterator it = reply.iterator(); it.hasNext();)
        {
            String line = (String) it.next();
            debug.append(line);
            debug.append("\n");
        }

        return debug.toString();
    }

    /**
     * 
     */
    public void clearDebugCache()
    {
        beanIndex = 0;
        visited.clear();
    }

    /**
     * @param object
     * @param valueIfNull
     * @return Short version of the class name
     */
    private static String getShortClassName(Object object, String valueIfNull)
    {
        if (object == null)
        {
            return valueIfNull;
        }
        char[] chars = object.getClass().getName().toCharArray();
        int lastDot = 0;
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == '.')
            {
                lastDot = i + 1;
            }
            else if (chars[i] == '$')
            { // handle inner classes
                chars[i] = '.';
            }
        }
        return new String(chars, lastDot, chars.length - lastDot);
    }

    /**
     * @param name 
     * @param obj 
     * @param reply 
     * @param depth 
     */
    private void debugbeanInternal(String name, Object obj, List reply, int depth)
    {
        try
        {
            String type = " ("+getShortClassName(obj, "null")+")";

            if (obj == null)
            {
                reply.add(getName(name)+" = null");
            }
            else if (obj instanceof String)
            {
                String str = (String) obj;
                if (str.indexOf(' ') > 80 && str.indexOf(';') < 80)
                {
                    str = LocalUtil.replace(str, ";", "; ");
                }
                reply.add(getName(name)+" = "+obj);
            }
            else if (obj instanceof Date || obj instanceof Double ||
                    obj instanceof Float || obj instanceof Long ||
                    obj instanceof Integer || obj instanceof Short ||
                    obj instanceof Character || obj instanceof Boolean ||
                    obj instanceof StringBuffer)
            {
                reply.add(getName(name)+" = "+obj+type);
            }
            else if (obj instanceof String[])
            {
                String[] array = (String[]) obj;
                for (int i = 0; i < array.length; i++)
                {
                    debugbeanInternal(getName(name)+"["+i+"]", array[i], reply, depth+1);
                }
            }
            else
            {
	            Integer doneIndex = (Integer) visited.get(obj);
	            if (doneIndex != null)
	            {
	                reply.add(getName(name)+" = see ID:"+doneIndex+type);
	            }
	            else
	            {
			        int thisIndex = beanIndex++;
			        visited.put(obj, new Integer(thisIndex));
			        reply.add(getName(name)+" = ID:"+thisIndex+type);
			
			        if (depth > MAX_DEPTH)
			        {
			            reply.add(getName(name)+" = [too deep]"+type);
			        }
                    else if (thisIndex > MAX_OBJECTS)
                    {
                        reply.add(getName(name)+" = [too many objects]"+type);
                    }
			        else if (obj instanceof Object[])
			        {
			            Object[] array = (Object[]) obj;
			            for (int i = 0; i < array.length; i++)
			            {
			                debugbeanInternal(getName(name)+"["+i+"]", array[i], reply, depth+1);
			            }
			        }
			        else if (obj instanceof Collection)
			        {
                        Collection col = (Collection) obj;
			            int i = 0;
                        for (Iterator it = col.iterator(); it.hasNext();)
                        {
                            Object element = it.next();
                            debugbeanInternal(getName(name)+"["+i+"]", element, reply, depth+1);
                            i++;
                        }
			        }
			        else if (obj instanceof Enumeration)
			        {
			            Enumeration en = (Enumeration) obj;
			            int i = 0;
			            while (en.hasMoreElements())
			            {
			                Object element = en.nextElement();
			                debugbeanInternal(getName(name)+"["+i+"]", element, reply, depth+1);
			                i++;
			            }
			        }
			        else if (obj instanceof Iterator)
			        {
			            Iterator it = (Iterator) obj;
			            int i = 0;
			            while (it.hasNext())
			            {
			                Object element = it.next();
			                debugbeanInternal(getName(name)+"["+i+"]", element, reply, depth+1);
			                i++;
			            }
			        }
			        else if (obj instanceof Map)
			        {
			            Map map = (Map) obj;
                        for (Iterator it = map.keySet().iterator(); it.hasNext();)
                        {
                            Object key = it.next();
                            Object value = map.get(key);
                            debugbeanInternal(getName(name)+"["+key+"]", value, reply, depth+1);
                        }
			        }
			        else
			        {
			            int replySize = reply.size();
			
			            Class clazz = obj.getClass();
                        Method[] methods = clazz.getMethods();
                        for (int i = 0; i < methods.length; i++)
                        {
                            Method method = methods[i];
			                String methodName = method.getName();

			                if (methodName.startsWith("get")
			                    && method.getParameterTypes().length == 0
			                    && !methodName.equals("getClass")
			                    && !methodName.equals("getAvailableLocales")
			                    && !methodName.equals("getISOLanguages")
			                    && !methodName.equals("getISOCountries")
			                    && methodName.indexOf("Stream") == -1)
			                {
			                    try
			                    {
			                        Object response = method.invoke(obj, new Object[0]);
			                        String subname = Introspector.decapitalize(method.getName().substring(3));
			                        debugbeanInternal(getName(name)+"."+getName(subname), response, reply, depth+1);
			                    }
			                    catch (Exception ex)
			                    {
			                        // reply.add(getName(name)+"=[error]");
			                    }
			                }
			            }
			
			            if (reply.size() == replySize)
			            {
			                reply.add(getName(name)+" = [no properties]");
			            }
			        }
	            }
            }
        }
        catch (Exception ex)
        {
            reply.add(getName(name)+" = "+ex);
            return;
        }
    }

    /**
     * @param base 
     * @return string
     */
    private static String getName(String base)
    {
        if (base == null)
        {
            base = "";
        }

        if (base.toLowerCase().startsWith("get"))
        {
            base = base.substring(3);
        }

        base = Introspector.decapitalize(base);

        return base;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "BeanConverter["+hashCode()+":"+beanIndex+"/"+visited.size()+"]";
    }

    /**
     * 
     */
    private static final int MAX_DEPTH = 4;

    /**
     * 
     */
    private static final int MAX_OBJECTS = 256;

    /**
     * 
     */
    private int beanIndex = 0;

    /**
     * The beans that we've seen so far
     */
    private Map visited = new HashMap();
}
