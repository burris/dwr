package uk.ltd.getahead.dwr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Manage the various possible Coercers.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ConverterManager
{
    /**
     * Prevent Instansiation
     */
    private ConverterManager()
    {
    }

    /**
     * Check if we can coerce the given type
     * @param paramType The type to check
     * @return true iff <code>paramType</code> is coercable
     */
    protected static boolean isCoercable(Class paramType)
    {
        if (paramType.isPrimitive())
        {
            return true;
        }

        return ConverterManager.coercers.containsKey(paramType);
    }

    /**
     * Convert an object from being a string into an object of some type
     * @param paramType The type that you want the object to be
     * @param object The string version of the object
     * @return The coerced object or null if the object could not be coerced
     */
    protected static Object convertTo(Class paramType, String object)
    {
        if (paramType.isPrimitive())
        {
            try
            {
                if (paramType == Boolean.TYPE)
                {
                    return new Boolean(object);
                }
                else if (paramType == Byte.TYPE)
                {
                    if (object.length() == 0)
                    {
                        byte b = 0;
                        return new Byte(b);
                    }
                    return new Byte(object);
                }
                else if (paramType == Short.TYPE)
                {
                    if (object.length() == 0)
                    {
                        short s = 0;
                        return new Short(s);
                    }
                    return new Short(object);
                }
                else if (paramType == Character.TYPE)
                {
                    if (object.length() == 1)
                    {
                        return new Character(object.charAt(0));
                    }
                    else
                    {
                        return null;
                    }
                }
                else if (paramType == Integer.TYPE)
                {
                    if (object.length() == 0)
                    {
                        return new Integer(0);
                    }
                    return new Integer(object);
                }
                else if (paramType == Long.TYPE)
                {
                    if (object.length() == 0)
                    {
                        return new Long(0);
                    }
                    return new Long(object);
                }
                else if (paramType == Float.TYPE)
                {
                    if (object.length() == 0)
                    {
                        return new Float(0);
                    }
                    return new Float(object);
                }
                else if (paramType == Double.TYPE)
                {
                    if (object.length() == 0)
                    {
                        return new Double(0);
                    }
                    return new Double(object);
                }
    
                return null;
            }
            catch (NumberFormatException ex)
            {
                return null;
            }
        }
        else
        {
            List options = (List) coercers.get(paramType);
            if (options != null)
            {
                for (Iterator ir = options.iterator(); ir.hasNext();)
                {
                    Converter coercer = (Converter) ir.next();
                    Object reply = coercer.convertTo(object);
                    if (reply != null)
                    {
                        return reply;
                    }
                }
            }
    
            return null;
        }
    }

    /**
     * A map of all the converters
     */
    private static Map coercers = new HashMap();
    private static Converter[] ALL = new Converter[]
    {
        new ConstructorConverter(Boolean.class),
        new ConstructorConverter(Byte.class),
        new ConstructorConverter(Short.class),
        new ConstructorConverter(Integer.class),
        new ConstructorConverter(Long.class),
        new ConstructorConverter(Float.class),
        new ConstructorConverter(Double.class),
        new StringConverter(),
    };

    /**
     * Copy the array into the map for fast lookup
     */
    static
    {
        for (int i = 0; i < ALL.length; i++)
        {
            Class coerceToClass = ALL[i].getConversionClass();

            List options = (List) coercers.get(coerceToClass);
            if (options == null)
            {
                options = new ArrayList();
                coercers.put(coerceToClass, options);
            }

            options.add(ALL[i]);
        }
    }
}

