package uk.ltd.getahead.dwr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import uk.ltd.getahead.dwr.util.LocalUtil;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ConverterManager
{
    /**
     * 
     */
    public ConverterManager()
    {
    }

    /**
     * @param id
     * @param clazz
     */
    public void addConverterType(String id, Class clazz)
    {
        converterTypes.put(id, clazz);
    }

    /**
     * @param match
     * @param type
     * @throws IllegalArgumentException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void addConverter(String match, String type) throws IllegalArgumentException, InstantiationException, IllegalAccessException
    {
        Class clazz = (Class) converterTypes.get(type);
        if (clazz == null)
        {
            throw new IllegalArgumentException("Unknown converter called: "+type);
        }

        Converter converter = (Converter) clazz.newInstance();
        converter.init(this);

        converters.put(match, converter);
    }

    /**
     * Check if we can coerce the given type
     * @param paramType The type to check
     * @return true iff <code>paramType</code> is coercable
     */
    public boolean isConvertable(Class paramType)
    {
        try
        {
            Converter converter = getConverter(paramType);
            return converter != null;
        }
        catch (ConversionException ex)
        {
            return false;
        }
    }

    /**
     * Convert an object into a Javavscript representation of the same
     * This method is for use by top level objects i.e. DWRServlet
     * @param object The object to convert
     * @return A Javascript string version of the object
     * @throws ConversionException If the conversion failed for some reason
     */
    public ScriptSetup convertFrom(Object object) throws ConversionException
    {
        Map converted = createConversionContext();
        return convertFrom(object, converted);
    }

    /**
     * Convert an object into a Javavscript representation of the same.
     * This method is for use by converters wishing to recurse into some object.
     * @param object The object to convert
     * @param converted The list of converted objects so far
     * @return A Javascript string version of the object
     * @throws ConversionException If the conversion failed for some reason
     */
    public ScriptSetup convertFrom(Object object, Map converted) throws ConversionException
    {
        ScriptSetup ss = (ScriptSetup) converted.get(object);

        if (ss != null)
        {
            // So the object as been converted already, we just need to refer to it.
            return new ScriptSetup("", ss.assignCode);
        }
        else
        {
            Converter converter = getConverter(object);
            if (converter == null)
            {
                throw new ConversionException("No converter found for " + object.getClass().getName());
            }

            String varName = getNextVariableName(converted);

            ss = converter.convertFrom(object, converted, varName);
            if (ss == null)
            {
                throw new IllegalStateException("null ScriptSetup from " + converter.getClass().getName() + " given " + object);
            }

            // Save this for another time if it is not a value type
            if (!ss.isValueType)
            {
                converted.put(object, ss);
            }
        }

        return ss;
    }

    /**
     * Convert an object from being a string into an object of some type
     * @param paramType The type that you want the object to be
     * @param object The string version of the object
     * @return The coerced object or null if the object could not be coerced
     * @throws ConversionException If the conversion failed for some reason
     */
    public Object convertTo(Class paramType, String object) throws ConversionException
    {
        Converter converter = getConverter(paramType);
        return converter.convertTo(paramType, object);
    }

    /**
     * Like <code>getConverter(object.getClass());</code> except that since the
     * object can be null we check for that fist and then do a lookup against
     * the <code>Void.TYPE</code> converter
     * @param object The object to find a converter for
     * @return The converter for the given type
     * @throws ConversionException If the converter can not be found
     */
    private Converter getConverter(Object object) throws ConversionException
    {
        if (object == null)
        {
            return getConverter(Void.TYPE);
        }

        return getConverter(object.getClass());
    }

    /**
     * @param paramType The type to find a converter for
     * @return The converter for the given type
     * @throws ConversionException If the converter can not be found
     */
    private Converter getConverter(Class paramType) throws ConversionException
    {
        String lookup = paramType.getName();

        // We first check for exact matches using instanceof
        for (Iterator it = converters.keySet().iterator(); it.hasNext(); )
        {
            String name = (String) it.next();
            try
            {
                Class clazz = Class.forName(name);

                if (LocalUtil.isEquivalent(clazz, paramType) || clazz.isAssignableFrom(paramType))
                {
                    return (Converter) converters.get(name);
                }
            }
            catch (Exception ex)
            {
                // Do nothing, having * in the classname is legitimate
            }
        }

        while (true)
        {
            // Can we find a converter using wildcards?
            Converter converter = (Converter) converters.get(lookup+".*");
            if (converter != null)
            {
                return converter;
            }
            else
            {
                converter = (Converter) converters.get(lookup+"*");
            }

            // Stop looking if we've found one or if the name is now empty
            if (converter != null || lookup.length() == 0)
            {
                break;
            }

            // Strip of the component after the last .
            int lastdot = lookup.lastIndexOf('.');
            if (lastdot == -1)
            {
                // Cope with arrays
                if (lookup.startsWith("["))
                {
                    lastdot = 2;
                }
                else
                {
                    // bail if no more dots and not an array
                    break;
                }
            }
            lookup = lookup.substring(0, lastdot);
        }

        throw new ConversionException("No converter found for " + paramType.getName());
    }

    /**
     * Create a ConversionContext which stores context information about a set
     * of conversions from Java to Javascript.
     * @return A new conversion context
     */
    private Map createConversionContext()
    {
        Map converted = new HashMap();
        converted.put(VAR_COUNT_KEY, new Integer(0));

        return converted;
    }

    /**
     * Create a new variable name to keep everything we declare separate
     * @param converted The map of converted variables so far.
     * @return A new unique variable name
     */
    private String getNextVariableName(Map converted)
    {
        Integer varCount = (Integer) converted.get(VAR_COUNT_KEY);
        String varName = "obj" + varCount;
        converted.put(VAR_COUNT_KEY, new Integer(varCount.intValue() + 1));

        return varName;
    }

    /**
     * The list of the available converters
     */
    private Map converterTypes = new HashMap();

    /**
     * The list of the configured converters
     */
    private Map converters = new HashMap();

    /**
     * This is the key we use in the map of converted objects so we can
     * generate unique variable names.
     */
    private static final Object VAR_COUNT_KEY = new Object();
}
