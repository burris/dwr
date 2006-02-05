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
