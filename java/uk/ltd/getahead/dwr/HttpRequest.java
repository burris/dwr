package uk.ltd.getahead.dwr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * A simple interface containing all the information that DWR needs to get
 * information out of the HttpServletRequest.
 * This interface could well grow over time as DWR needs to get more information
 * however every attempt will be made to keep things backwards compatable.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface HttpRequest
{
    /**
     * Returns the HTTP method with which this request was made.
     * Usually one of GET, POST, PUT or DELETE
     * @return a String specifying the name of the method
     */
    public String getMethod();

    /**
     * Retrieves the body of the request as binary data using an
     * {@link InputStream}.
     * @return an {@link InputStream} object containing the body of the request
     * @exception IOException If an input or output exception occurred
     */
    public InputStream getInputStream() throws IOException;

    /**
     * Returns a java.util.Map of the parameters of this request.
     * Parameters are contained in the query string or posted form data.
     * @return an immutable java.util.Map containing parameter names as
     * keys and parameter values as map values. The keys in the parameter
     * map are of type String. The values in the parameter map are of type
     * String array.
     */
    public Map/*<String, String[]>*/ getParameters();
}
