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
package uk.ltd.getahead.dwr.dwrp;

import uk.ltd.getahead.dwr.util.MimeConstants;

/**
 * A version of the Plain Javascript Marshaller that uses iframe syntax
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DwrpHtmlJsMarshaller extends DwrpPlainJsMarshaller
{
    /**
     * iframe mode starts as HTML, so get into script mode
     * @return A script prefix
     */
    protected String getOutboundMimeType()
    {
        return MimeConstants.MIME_HTML;
    }

    /**
     * iframe mode starts as HTML, so get into script mode
     * @return A script prefix
     */
    protected String getOutboundScriptPrefix()
    {
        return "<script type='text/javascript'>\n"; //$NON-NLS-1$
    }

    /**
     * iframe mode needs to get out of script mode
     * @return A script suffix
     */
    protected String getOutboundScriptSuffix()
    {
        return "</script>\n"; //$NON-NLS-1$
    }

    /**
     * Do we need to prefix variable declarations to be visible to another frame
     * @return A declaration prefix
     */
    protected String getOutboundLinePrefix()
    {
        return "window.parent."; //$NON-NLS-1$
    }
}
