/*
 * Copyright 2005 Joe Walker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ltd.getahead.dwr.convert;

import uk.ltd.getahead.dwr.ConversionException;
import uk.ltd.getahead.dwr.Converter;
import uk.ltd.getahead.dwr.InboundContext;
import uk.ltd.getahead.dwr.InboundVariable;
import uk.ltd.getahead.dwr.Messages;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.compat.BaseV20Converter;
import uk.ltd.getahead.dwr.util.JavascriptUtil;
import uk.ltd.getahead.dwr.util.LocalUtil;

/**
 * Converter for all primitive types
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class PrimitiveConverter extends BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertInbound(java.lang.Class, java.util.List, uk.ltd.getahead.dwr.InboundVariable, uk.ltd.getahead.dwr.InboundContext)
     */
    public Object convertInbound(Class paramType, InboundVariable iv, InboundContext inctx) throws ConversionException
    {
        String value = iv.getValue();
        value = LocalUtil.decode(value.trim());

        try
        {
            return LocalUtil.simpleConvert(value, paramType);
        }
        catch (NumberFormatException ex)
        {
            throw new ConversionException(Messages.getString("PrimitiveConverter.FormatError", value, paramType.getName()), ex); //$NON-NLS-1$
        }
        catch (IllegalArgumentException ex)
        {
            throw new ConversionException(Messages.getString("PrimitiveConverter.TypeNotPrimitive", paramType.getName()), ex); //$NON-NLS-1$
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertOutbound(java.lang.Object, java.lang.String, uk.ltd.getahead.dwr.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object object, OutboundContext outctx)
    {
        Class paramType = object.getClass();

        if (object.equals(Boolean.TRUE))
        {
            return new OutboundVariable("", "true"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else if (object.equals(Boolean.FALSE))
        {
            return new OutboundVariable("", "false"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else if (paramType == Character.class)
        {
            // Treat characters as strings
            return new OutboundVariable("", '\"' + jsutil.escapeJavaScript(object.toString()) + '\"'); //$NON-NLS-1$
        }
        else
        {
            // We just use the default toString for all numbers
            return new OutboundVariable("", object.toString()); //$NON-NLS-1$
        }
    }

    /**
     * The means by which we strip comments
     */
    private JavascriptUtil jsutil = new JavascriptUtil();
}
