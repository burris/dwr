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

import java.lang.reflect.Method;

import uk.ltd.getahead.dwr.MarshallException;
import uk.ltd.getahead.dwr.compat.BaseV20Converter;
import uk.ltd.getahead.dwr.dwrp.Converter;
import uk.ltd.getahead.dwr.dwrp.InboundContext;
import uk.ltd.getahead.dwr.dwrp.InboundVariable;
import uk.ltd.getahead.dwr.dwrp.OutboundContext;
import uk.ltd.getahead.dwr.dwrp.OutboundVariable;
import uk.ltd.getahead.dwr.util.LocalUtil;
import uk.ltd.getahead.dwr.util.Messages;

/**
 * Converter for all primitive types
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class EnumConverter extends BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertInbound(java.lang.Class, java.util.List, uk.ltd.getahead.dwr.InboundVariable, uk.ltd.getahead.dwr.InboundContext)
     */
    public Object convertInbound(Class paramType, InboundVariable iv, InboundContext inctx) throws MarshallException
    {
        String value = LocalUtil.decode(iv.getValue());

        Object[] values;
        try
        {
            Method getter = paramType.getMethod("values", new Class[0]); //$NON-NLS-1$
            values = (Object[]) getter.invoke(paramType, null);
        }
        catch (NoSuchMethodException ex)
        {
            // We would like to have done: if (!paramType.isEnum())
            // But this catch block has the same effect
            throw new MarshallException(Messages.getString("EnumConverter.TypeNotEnum", paramType)); //$NON-NLS-1$
        }
        catch (Exception ex)
        {
            throw new MarshallException(Messages.getString("EnumConverter.ReflectionError", paramType), ex); //$NON-NLS-1$
        }

        for (int i = 0; i < values.length; i++)
        {
            Object en = values[i];
            if (value.equals(en.toString()))
            {
                return en;
            }
        }

        throw new MarshallException(Messages.getString("EnumConverter.NoMatch", value, paramType)); //$NON-NLS-1$
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertOutbound(java.lang.Object, uk.ltd.getahead.dwr.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object object, OutboundContext outctx)
    {
        return new OutboundVariable("", '\'' + object.toString() + '\''); //$NON-NLS-1$
    }
}
