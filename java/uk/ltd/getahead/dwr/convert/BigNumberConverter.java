package uk.ltd.getahead.dwr.convert;

import java.math.BigDecimal;
import java.math.BigInteger;

import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.InboundContext;
import uk.ltd.getahead.dwr.InboundVariable;
import uk.ltd.getahead.dwr.Messages;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.compat.BaseV20Converter;

/**
 * Converter for all primitive types
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class BigNumberConverter extends BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertInbound(java.lang.Class, java.util.List, uk.ltd.getahead.dwr.InboundVariable, uk.ltd.getahead.dwr.InboundContext)
     */
    public Object convertInbound(Class paramType, InboundVariable iv, InboundContext inctx) throws ConversionException
    {
        String value = iv.getValue();
        try
        {
            if (paramType == BigDecimal.class)
            {
                return new BigDecimal(value.trim());
            }

            if (paramType == BigInteger.class)
            {
                return new BigInteger(value.trim());
            }

            throw new ConversionException(Messages.getString("BigNumberConverter.NonPrimitive", paramType.getName())); //$NON-NLS-1$
        }
        catch (NumberFormatException ex)
        {
            throw new ConversionException(Messages.getString("BigNumberConverter.FormatError", value, paramType.getName()), ex); //$NON-NLS-1$
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertOutbound(java.lang.Object, uk.ltd.getahead.dwr.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object object, OutboundContext outctx)
    {
        return new OutboundVariable("", object.toString()); //$NON-NLS-1$
    }
}
