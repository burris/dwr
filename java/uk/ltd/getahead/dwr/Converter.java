package uk.ltd.getahead.dwr;

/**
 * An interface for converting types from a string to some other type.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface Converter
{
    /**
     * What class does this coercer convert to
     * @return The destination type
     */
    public Class getConversionClass();

    /**
     * Attempt to coerce the data from a string to an Object
     * @param data The data to convert
     * @return The convered data, or null if the conversion was not possible
     */
    public Object convertTo(String data);

    /**
     * Attempt to coerce the data from an Object to a string
     * @param data The data to convert
     * @return The convered data, or null if the conversion was not possible
     */
    public String convertFrom(Object data);
}
