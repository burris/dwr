package uk.ltd.getahead.dwr;

/**
 * An interface for converting types from a string to some other type.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface Converter
{
    /**
     * If we are a compound converter that farms out part of the conversion
     * to other converters then you farm the conversion out via a configuration.
     * @param config The confiuration object
     */
    public void init(Configuration config);

    /**
     * Attempt to coerce the data from a string to an Object
     * @param paramType The type to convert to
     * @param data The data to convert
     * @return The convered data, or null if the conversion was not possible
     * @throws ConversionException If the conversion failed for some reason
     */
    public Object convertTo(Class paramType, String data) throws ConversionException;

    /**
     * Attempt to coerce the data from an Object to a string
     * @param data The data to convert
     * @return The convered data, or null if the conversion was not possible
     * @throws ConversionException If the conversion failed for some reason
     */
    public ScriptSetup convertFrom(Object data) throws ConversionException;

    /**
     * A simple data container for 2 strings that comprise information about
     * how a Java object has been converted into Javascript
     */
    public class ScriptSetup
    {
        /**
         * Default ctor that leaves blank (not null) members
         */
        public ScriptSetup()
        {
        }

        /**
         * Default ctor that leaves blank (not null) members
         * @param initCode the init script
         * @param assignCode the access for the inited code
         */
        public ScriptSetup(String initCode, String assignCode)
        {
            this.initCode = initCode;
            this.assignCode = assignCode;
        }

        /**
         * The code to be executed to initialize any variables
         */
        public String initCode = "";

        /**
         * The code to be executed to get the value of the initialized data
         */
        public String assignCode = "";
    }
}
