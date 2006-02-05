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
package uk.ltd.getahead.dwr.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import uk.ltd.getahead.dwr.HttpRequest;

/**
 * A implementation of HttpRequest that uses an HttpServletRequest
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ServletHttpRequest implements HttpRequest
{
    /**
     * Default ctor
     * @param proxy The HttpServletRequest to proxy requests to
     */
    public ServletHttpRequest(HttpServletRequest proxy)
    {
        this.proxy = proxy;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.HttpRequest#getMethod()
     */
    public String getMethod()
    {
        return proxy.getMethod();
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.HttpRequest#getInputStream()
     */
    public InputStream getInputStream() throws IOException
    {
        return proxy.getInputStream();
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.HttpRequest#getParameters()
     */
    public Map getParameters()
    {
        return proxy.getParameterMap();
    }

    /**
     * What we proxy our requests to
     */
    private HttpServletRequest proxy = null;
}
