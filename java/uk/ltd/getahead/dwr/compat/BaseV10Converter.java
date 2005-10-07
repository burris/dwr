package uk.ltd.getahead.dwr.compat;

import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;

/**
 * A way to migrate from the DWRv1.x Converter style to something in the future.
 * Inheriting from this is advised to help with forwards compatibility.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public abstract class BaseV10Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertOutbound(java.lang.Object, uk.ltd.getahead.dwr.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object data, OutboundContext outctx) throws ConversionException
    {
        OutboundVariable ov = outctx.createOutboundVariable(data);
        ov.setInitCode(convertOutbound(data, ov.getAssignCode(), outctx));
        return ov;
    }

    /**
     * @see Converter#convertOutbound(Object, OutboundContext)
     * @param varname The name of the variable to declare
     * @param data The data to convert
     * @param outctx Objects already converted and the results
     * @return The OutboundVariable that represents the data to convert
     * @throws ConversionException If the conversion failed for some reason
     */
    public abstract String convertOutbound(Object data, String varname, OutboundContext outctx) throws ConversionException;
}
