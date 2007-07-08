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
package org.directwebremoting.convert;

import java.io.InputStream;

import org.directwebremoting.extend.Converter;
import org.directwebremoting.extend.FormField;
import org.directwebremoting.extend.InboundContext;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.MarshallException;
import org.directwebremoting.extend.OutboundContext;
import org.directwebremoting.extend.OutboundVariable;
import org.directwebremoting.impl.DefaultFileUpload;
import org.directwebremoting.io.FileUpload;
import org.directwebremoting.util.Messages;

/**
 * The FileConverter can only convert inbound files, convertOutbound is not
 * supported. 
 * Files come from an &lt;input type=&quot;file&quot;/&gt; on the client.
 * @author Lance Semmens [uklance at gmail dot com]
 */
public class FileConverter extends BaseV20Converter implements Converter
{
    /* (non-Javadoc)
     * @see org.directwebremoting.extend.Converter#convertInbound(java.lang.Class, org.directwebremoting.extend.InboundVariable, org.directwebremoting.extend.InboundContext)
     */
    public Object convertInbound(Class<?> paramType, InboundVariable data, InboundContext inctx) throws MarshallException
    {
        if (data.isFile())
        {
            FormField formField = data.getFormField();
            if (paramType == FileUpload.class)
            {
                return new DefaultFileUpload(formField.getName(), formField.getMimeType(), formField.getInputStream());
            }
            else if (paramType == InputStream.class)
            {
                return formField.getInputStream();
            }
        }
        throw new MarshallException(paramType, Messages.getString("MarshallException.FileFailure", paramType));
    }

    /**
     * Outbound conversion is not supported for files
     * @see org.directwebremoting.extend.Converter#convertOutbound(java.lang.Object, org.directwebremoting.extend.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object data, OutboundContext outctx) throws MarshallException
    {
        Class<?> paramType = data == null ? null : data.getClass();
        throw new MarshallException(paramType, Messages.getString("MarshallException.OutboundNotSupported", paramType));
    }
}
