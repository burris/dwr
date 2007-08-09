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
package org.directwebremoting.extend;

import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptBuffer.StringWrapper;

/**
 * A simple utility class to extract a {@link String} from a {@link ScriptBuffer}.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ScriptBufferUtil
{
    /**
     * Ensure we can't be created
     */
    private ScriptBufferUtil()
    {
    }

    /**
     * Return a string ready for output.
     * @param buffer The source of the script data
     * @param converterManager How we convert script variable to Javascript
     * @return Some Javascript to be eval()ed by a browser.
     * @throws MarshallException If an error happens during parameter marshalling
     */
    public static String createOutput(ScriptBuffer buffer, ConverterManager converterManager) throws MarshallException
    {
        OutboundContext context = new OutboundContext();
        List<Object> ovs = new ArrayList<Object>();

        // First convert everything
        for (Object element : buffer.getParts())
        {
            if (element instanceof StringWrapper)
            {
                ovs.add(element);
            }
            else
            {
                OutboundVariable ov = converterManager.convertOutbound(element, context);
                ovs.add(ov);
            }
        }

        // At this point ovs has a 1-1 mapping from the parts to the buffer
        // It can contain one of 2 types, an OutboundVariable that has been
        // converted or a string (StringWrapper) that does not need conversion

        StringBuffer output = new StringBuffer();

        // First we look for the declaration code
        for (Object element : ovs)
        {
            if (element instanceof OutboundVariable)
            {
                OutboundVariable ov = (OutboundVariable) element;
                output.append(ov.getDeclareCode());
            }
            else
            {
                // StringWrappers do not need declaring
            }
        }

        // Then we look for the construction code
        for (Object element : ovs)
        {
            if (element instanceof OutboundVariable)
            {
                OutboundVariable ov = (OutboundVariable) element;
                output.append(ov.getBuildCode());
            }
            else
            {
                // StringWrappers do not need building
            }
        }

        // Then we output everything else
        for (Object element : ovs)
        {
            if (element instanceof OutboundVariable)
            {
                OutboundVariable ov = (OutboundVariable) element;
                output.append(ov.getAssignCode());
            }
            else
            {
                StringWrapper str = (StringWrapper) element;
                output.append(str.toString());
            }
        }

        return output.toString();
    }
}
