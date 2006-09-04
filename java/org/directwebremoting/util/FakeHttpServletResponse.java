/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.directwebremoting.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Mock implementation of the HttpServletResponse interface.
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class FakeHttpServletResponse implements HttpServletResponse
{
    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#setCharacterEncoding(java.lang.String)
     */
    public void setCharacterEncoding(String characterEncoding)
    {
        this.characterEncoding = characterEncoding;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#getCharacterEncoding()
     */
    public String getCharacterEncoding()
    {
        return characterEncoding;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#getOutputStream()
     */
    public ServletOutputStream getOutputStream()
    {
        return outputStream;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#getWriter()
     */
    public PrintWriter getWriter() throws UnsupportedEncodingException
    {
        if (writer == null)
        {
            Writer targetWriter = (characterEncoding != null ? new OutputStreamWriter(content, characterEncoding) : new OutputStreamWriter(content));
            writer = new PrintWriter(targetWriter);
        }

        return writer;
    }

    /**
     * @return
     */
    public byte[] getContentAsByteArray()
    {
        flushBuffer();
        return content.toByteArray();
    }

    /**
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getContentAsString() throws UnsupportedEncodingException
    {
        flushBuffer();
        return (characterEncoding != null) ? content.toString(characterEncoding) : content.toString();
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#setContentLength(int)
     */
    public void setContentLength(int contentLength)
    {
        this.contentLength = contentLength;
    }

    /**
     * @return
     */
    public int getContentLength()
    {
        return contentLength;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#setContentType(java.lang.String)
     */
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
        if (contentType != null)
        {
            int charsetIndex = contentType.toLowerCase().indexOf(CHARSET_PREFIX);

            if (charsetIndex != -1)
            {
                String encoding = contentType.substring(charsetIndex + CHARSET_PREFIX.length());
                setCharacterEncoding(encoding);
            }
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#getContentType()
     */
    public String getContentType()
    {
        return contentType;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#setBufferSize(int)
     */
    public void setBufferSize(int bufferSize)
    {
        this.bufferSize = bufferSize;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#getBufferSize()
     */
    public int getBufferSize()
    {
        return bufferSize;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#flushBuffer()
     */
    public void flushBuffer()
    {
        if (writer != null)
        {
            writer.flush();
        }

        if (outputStream != null)
        {
            try
            {
                outputStream.flush();
            }
            catch (IOException ex)
            {
                throw new IllegalStateException("Could not flush OutputStream: " + ex.getMessage());
            }
        }

        committed = true;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#resetBuffer()
     */
    public void resetBuffer()
    {
        if (committed)
        {
            throw new IllegalStateException("Cannot reset buffer - response is already committed");
        }

        content.reset();
    }

    /**
     * @param committed
     */
    public void setCommitted(boolean committed)
    {
        this.committed = committed;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#isCommitted()
     */
    public boolean isCommitted()
    {
        return committed;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#reset()
     */
    public void reset()
    {
        resetBuffer();

        characterEncoding = null;
        contentLength = 0;
        contentType = null;
        locale = null;
        cookies.clear();
        headers.clear();
        status = HttpServletResponse.SC_OK;
        errorMessage = null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#setLocale(java.util.Locale)
     */
    public void setLocale(Locale locale)
    {
        this.locale = locale;
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletResponse#getLocale()
     */
    public Locale getLocale()
    {
        return locale;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#addCookie(javax.servlet.http.Cookie)
     */
    public void addCookie(Cookie cookie)
    {
        cookies.add(cookie);
    }

    /**
     * @return
     */
    public Cookie[] getCookies()
    {
        return (Cookie[]) cookies.toArray(new Cookie[cookies.size()]);
    }

    public Cookie getCookie(String name)
    {
        for (Iterator it = cookies.iterator(); it.hasNext();)
        {
            Cookie cookie = (Cookie) it.next();
            if (name.equals(cookie.getName()))
            {
                return cookie;
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#containsHeader(java.lang.String)
     */
    public boolean containsHeader(String name)
    {
        return headers.containsKey(name);
    }

    /**
     * @return
     */
    public Set getHeaderNames()
    {
        return headers.keySet();
    }

    public Object getHeader(String name)
    {
        return headers.get(name);
    }

    public List getHeaders(String name)
    {
        Object value = headers.get(name);
        if (value instanceof List)
        {
            return (List) value;
        }
        else if (value != null)
        {
            return Collections.singletonList(value);
        }
        else
        {
            return Collections.EMPTY_LIST;
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#encodeURL(java.lang.String)
     */
    public String encodeURL(String url)
    {
        return url;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#encodeRedirectURL(java.lang.String)
     */
    public String encodeRedirectURL(String url)
    {
        return url;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#encodeUrl(java.lang.String)
     */
    public String encodeUrl(String url)
    {
        return url;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#encodeRedirectUrl(java.lang.String)
     */
    public String encodeRedirectUrl(String url)
    {
        return url;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#sendError(int, java.lang.String)
     */
    public void sendError(int newStatus, String newErrorMessage) throws IOException
    {
        if (committed)
        {
            throw new IllegalStateException("Cannot set error status - response is already committed");
        }
        this.status = newStatus;
        this.errorMessage = newErrorMessage;
        committed = true;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#sendError(int)
     */
    public void sendError(int newStatus) throws IOException
    {
        if (committed)
        {
            throw new IllegalStateException("Cannot set error status - response is already committed");
        }
        this.status = newStatus;
        committed = true;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#sendRedirect(java.lang.String)
     */
    public void sendRedirect(String url) throws IOException
    {
        if (committed)
        {
            throw new IllegalStateException("Cannot send redirect - response is already committed");
        }

        redirectedUrl = url;
        committed = true;
    }

    public String getRedirectedUrl()
    {
        return redirectedUrl;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#setDateHeader(java.lang.String, long)
     */
    public void setDateHeader(String name, long value)
    {
        headers.put(name, new Long(value));
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#addDateHeader(java.lang.String, long)
     */
    public void addDateHeader(String name, long value)
    {
        doAddHeader(name, new Long(value));
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#setHeader(java.lang.String, java.lang.String)
     */
    public void setHeader(String name, String value)
    {
        headers.put(name, value);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#addHeader(java.lang.String, java.lang.String)
     */
    public void addHeader(String name, String value)
    {
        doAddHeader(name, value);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#setIntHeader(java.lang.String, int)
     */
    public void setIntHeader(String name, int value)
    {
        headers.put(name, new Integer(value));
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#addIntHeader(java.lang.String, int)
     */
    public void addIntHeader(String name, int value)
    {
        doAddHeader(name, new Integer(value));
    }

    /**
     * @param name
     * @param value
     */
    private void doAddHeader(String name, Object value)
    {
        Object oldValue = headers.get(name);
        if (oldValue instanceof List)
        {
            List list = (List) oldValue;
            list.add(value);
        }
        else if (oldValue != null)
        {
            List list = new LinkedList();
            list.add(oldValue);
            list.add(value);
            headers.put(name, list);
        }
        else
        {
            headers.put(name, value);
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#setStatus(int)
     */
    public void setStatus(int status)
    {
        this.status = status;
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServletResponse#setStatus(int, java.lang.String)
     */
    public void setStatus(int status, String errorMessage)
    {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public int getStatus()
    {
        return status;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    //---------------------------------------------------------------------
    // Methods for FakeRequestDispatcher
    //---------------------------------------------------------------------

    public void setForwardedUrl(String forwardedUrl)
    {
        this.forwardedUrl = forwardedUrl;
    }

    public String getForwardedUrl()
    {
        return forwardedUrl;
    }

    public void setIncludedUrl(String includedUrl)
    {
        this.includedUrl = includedUrl;
    }

    public String getIncludedUrl()
    {
        return includedUrl;
    }

    public static final int DEFAULT_SERVER_PORT = 80;

    private static final String CHARSET_PREFIX = "charset=";

    private String characterEncoding = "ISO-8859-1";

    private final ByteArrayOutputStream content = new ByteArrayOutputStream();

    private final DelegatingServletOutputStream outputStream = new DelegatingServletOutputStream(this.content);

    private PrintWriter writer;

    private int contentLength = 0;

    private String contentType;

    private int bufferSize = 4096;

    private boolean committed;

    private Locale locale = Locale.getDefault();

    private final List cookies = new ArrayList();

    private final Map headers = new HashMap();

    private int status = HttpServletResponse.SC_OK;

    private String errorMessage;

    private String redirectedUrl;

    private String forwardedUrl;

    private String includedUrl;
}
