package uk.ltd.getahead.dwr;


/**
 * An interface for converting types from a string to some other type.
 */
public interface Coercer
{
    /**
     * What class does this coercer convert to
     * @return The destination type
     */
    public Class getCoerceToClass();

    /**
     * Attempt to coerce the data
     * @param data The data to convert
     * @return The convered data, or null if the conversion was not possible
     */
    public Object coerce(String data);
}