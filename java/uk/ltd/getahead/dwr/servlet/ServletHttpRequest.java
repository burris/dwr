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
