package uk.ltd.getahead.dwr.convert;

import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.ConverterManager;

/**
 * A way to migrate from the old Converter style to the new
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public abstract class BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#init(uk.ltd.getahead.dwr.DefaultConfiguration)
     */
    public void setConverterManager(ConverterManager config)
    {
    }
}
