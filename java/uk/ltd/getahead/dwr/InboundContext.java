package uk.ltd.getahead.dwr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * We need to keep track of what is going on while converting inbound data.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public final class InboundContext
{
    /**
     * @param scriptName The name of the creator to Javascript
     * @param methodName The name of the method (without brackets)
     */
    public InboundContext(String scriptName, String methodName)
    {
        this.scriptName = scriptName;
        this.methodName = methodName;
    }

    /**
     * Create an inbound variable.
     * Usually called by a query parser to setup a list of known variables.
     * This method also check so see if the new variable is a parameter and if
     * it is it updates the count of parameters
     * @param callNum The call number to work on
     * @param key The name of the variable
     * @param type The javascript type of the variable
     * @param value The value of the variable
     */
    public void createInboundVariable(int callNum, String key, String type, String value)
    {
        InboundVariable cte = new InboundVariable(this, type, value);

        variables.put(key, cte);

        String paramPrefix = ConversionConstants.INBOUND_CALLNUM_PREFIX + callNum + 
                             ConversionConstants.INBOUND_CALLNUM_SUFFIX +
                             ConversionConstants.INBOUND_KEY_PARAM;

        if (key.startsWith(paramPrefix))
        {
            int i = Integer.parseInt(key.substring(paramPrefix.length())) + 1;
            if (i > paramCount )
            {
                paramCount = i;
            }
        }
    }

    /**
     * Internal method to allow entries to resolve references
     * @param name The name of the variable to lookup
     * @return The found variable
     */
    protected InboundVariable getInboundVariable(String name)
    {
        return (InboundVariable) variables.get(name);
    }

    /**
     * Clear the list of converted objects.
     * If the conversion attempt for a given method failed, we may want to try
     * another so we will need to ditch the list of converted objects because
     * the next method could well have different parameter types.
     */
    public void clearConverted()
    {
        converted.clear();
    }

    /**
     * Add to the (temporary) list of converted objects
     * @param iv The converted object
     * @param bean The converted version
     */
    public void addConverted(InboundVariable iv, Object bean)
    {
        converted.put(iv, bean);
    }

    /**
     * Check to see if the conversion has already been done
     * @param iv The inbound data to check
     * @return The converted data or null if it has not been converted
     */
    public Object getConverted(InboundVariable iv)
    {
        return converted.get(iv);
    }

    /**
     * How many parameters are there?
     * @return The parameter count
     */
    protected int getParameterCount()
    {
        return paramCount;
    }

    /**
     * Get a parameter by index
     * @param callNum The call number to work on
     * @param index The parameter index
     * @return The found parameter
     */
    protected InboundVariable getParameter(int callNum, int index)
    {
        String key = ConversionConstants.INBOUND_CALLNUM_PREFIX + callNum + 
                     ConversionConstants.INBOUND_CALLNUM_SUFFIX +
                     ConversionConstants.INBOUND_KEY_PARAM + index;

        return (InboundVariable) variables.get(key);
    }

    /**
     * A debug method so people can get a list of all the variable names
     * @return an iterator over the known variable names
     */
    protected Iterator getInboundVariableNames()
    {
        return variables.keySet().iterator();
    }

    /**
     * @return Returns the methodName.
     */
    public String getMethodName()
    {
        return methodName;
    }

    /**
     * @return Returns the scriptName.
     */
    public String getScriptName()
    {
        return scriptName;
    }

    /**
     * The script name that we are converting for.
     * This is relevant because extra parameter info is logged against scripts
     * and methods.
     */
    private String scriptName;

    /**
     * The method name that we are converting for.
     * This is relevant because extra parameter info is logged against scripts
     * and methods.
     */
    private String methodName;

    /**
     * How many params are there?.
     * To be more accurate, return one less than the highest numbered parameter
     * that we have come across.
     */
    private int paramCount = 0;

    /**
     * A map of all the inbound variables
     */
    private final Map variables = new HashMap();

    /**
     * A map of all the variables converted.
     */
    private final Map converted = new HashMap();
}
