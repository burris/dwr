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
package org.directwebremoting.webwork;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.servlet.PathConstants;
import org.directwebremoting.util.MimeConstants;

/**
 * A DWR-WW integration specific <code>UrlProcessor</code> that knows how to
 * solve the request for <code>DWRActionUtil.js</code> file.
 * For more configuration details see {@link org.directwebremoting.servlet.UrlProcessor UrlProcessor}.
 * 
 * @author <a href='mailto:the_mindstorm[at]evolva[dot]ro'>Alexandru Popescu</a>
 * @see org.directwebremoting.servlet.UrlProcessor
 */
public class UrlProcessor extends org.directwebremoting.servlet.UrlProcessor
{
    /**
     * Handle servlet requests aimed at DWR
     * @param request The servlet request
     * @param response The servlet response
     * @throws IOException If there are IO issues
     */
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try 
        {
            String pathInfo = request.getPathInfo();
            String servletPath = request.getServletPath();
            String contextPath = request.getContextPath();
    
            if (this.nullPathInfoWorkaround && pathInfo == null)
            {
                pathInfo = request.getServletPath();
                servletPath = PathConstants.PATH_ROOT;
                log.debug("Default servlet suspected. pathInfo=" + pathInfo + "; contextPath=" + contextPath + "; servletPath=" + servletPath);
            }
    
            if (DWRACTION_JS.equals(pathInfo)) {
                doFile(request, response, DWRACTION_JS, MimeConstants.MIME_JS, false);
            }
            else {
                super.handle(request, response);
            }
        }
        catch(Exception ex) 
        {
            handleException(request, response, ex);
        }
    }
    
    private static final String DWRACTION_JS = "/webwork/DWRActionUtil.js"; 
}
