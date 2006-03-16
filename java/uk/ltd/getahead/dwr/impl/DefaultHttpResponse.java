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
package uk.ltd.getahead.dwr.impl;

import java.io.UnsupportedEncodingException;

import uk.ltd.getahead.dwr.HttpResponse;
import uk.ltd.getahead.dwr.dwrp.DwrpHtmlJsMarshaller;

/**
 * A simple class to encapsulate an HTTP response.
 * Currently all we need is a body and a mime type, however in the future there
 * may be other things we need to add.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultHttpResponse implements HttpResponse
{
    /**
     * Simple constructor for a byte array-based body.
     * @param body The response boody
     * @param mimeType The mimetype of the body
     */
    public DefaultHttpResponse(byte[] body, String mimeType)
    {
        this.body = body;
        this.mimeType = mimeType;
    }

    /**
     * Simple constructor for a string-based body.
     * Note the charset issues in this constructor:
     * {@link DefaultHttpResponse#DefaultHttpResponse(String, String, String)}
     * @param body The response boody
     * @param mimeType The mimetype of the body
     */
    public DefaultHttpResponse(String body, String mimeType)
    {
        this.body = body.getBytes();
        this.mimeType = mimeType;
    }

    /**
     * Constructor that allows us to specify a body character encoding.
     * If we are starting to worry about body character encodings then see also
     * {@link DwrpHtmlJsMarshaller#marshallOutbound(uk.ltd.getahead.dwr.Replies)}
     * which makes the same assumptions as the default string body constructor.
     * @param body The response boody
     * @param encoding The encoding to use in exporting bytes
     * @param mimeType The mimetype of the body
     * @throws UnsupportedEncodingException If the encoding is unsupported
     */
    public DefaultHttpResponse(String body, String encoding, String mimeType) throws UnsupportedEncodingException
    {
        this.body = body.getBytes(encoding);
        this.mimeType = mimeType;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.HttpResponse#getBody()
     */
    public byte[] getBody()
    {
        return body;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.HttpResponse#getMimeType()
     */
    public String getMimeType()
    {
        return mimeType;
    }

    /**
     * The data in the HTTP response
     */
    private byte[] body;

    /**
     * The MimeType of the body
     */
    private String mimeType;
}
