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
public class CoercerManager
{
    /**
     * Prevent Instansiation
     */
    private CoercerManager()
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

        return CoercerManager.coercers.containsKey(paramType);
    }

    /**
     * Convert an object from being a string into an object of some type
     * @param paramType The type that you want the object to be
     * @param object The string version of the object
     * @return The coerced object or null if the object could not be coerced
     */
    protected static Object coerce(Class paramType, String object)
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
                    Coercer coercer = (Coercer) ir.next();
                    Object reply = coercer.coerce(object);
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
    private static Coercer[] ALL = new Coercer[]
    {
        new ConstructorCoercer(Boolean.class),
        new ConstructorCoercer(Byte.class),
        new ConstructorCoercer(Short.class),
        new ConstructorCoercer(Integer.class),
        new ConstructorCoercer(Long.class),
        new ConstructorCoercer(Float.class),
        new ConstructorCoercer(Double.class),
        new StringCoercer(),
    };

    /**
     * Copy the array into the map for fast lookup
     */
    static
    {
        for (int i = 0; i < ALL.length; i++)
        {
            Class coerceToClass = ALL[i].getCoerceToClass();

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

