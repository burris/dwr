package uk.ltd.getahead.dwr.compat;

import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.ConverterManager;

/**
 * A way to migrate from the DWRv2.0 Converter style to something in the future.
 * Inheriting from this is advised to help with forwards compatibility.
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
