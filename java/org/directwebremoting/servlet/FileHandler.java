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
package org.directwebremoting.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.extend.DwrConstants;
import org.directwebremoting.extend.Handler;
import org.directwebremoting.util.JavascriptUtil;
import org.directwebremoting.util.LocalUtil;
import org.directwebremoting.util.MimeConstants;

/**
 * Basically a file servlet component that does some <b>very limited</b>
 * EL type processing on the file. See the source for the cheat.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class FileHandler implements Handler
{
    /* (non-Javadoc)
     * @see org.directwebremoting.Handler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if (isUpToDate(request))
        {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return;
        }

        String output;

        synchronized (scriptCache)
        {
            output = scriptCache.get(filePath);
            if (output == null)
            {
                StringBuffer buffer = new StringBuffer();

                String resource = DwrConstants.PACKAGE + filePath;
                InputStream raw = getClass().getResourceAsStream(resource);
                if (raw == null)
                {
                    throw new IOException("Failed to find resource: " + resource);
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(raw));
                while (true)
                {
                    String line = in.readLine();
                    if (line == null)
                    {
                        break;
                    }

                    Map<String, String> replace = getSearchReplacePairs();
                    if (replace != null)
                    {
                        for (Map.Entry<String, String> entry : replace.entrySet())
                        {
                            String search = entry.getKey();
                            if (line.contains(search))
                            {
                                line = LocalUtil.replace(line, search, entry.getValue());
                            }
                        }
                    }

                    buffer.append(line);
                    buffer.append('\n');
                }

                output = buffer.toString();

                if (mimeType.equals(MimeConstants.MIME_JS) && scriptCompressed)
                {
                    output = JavascriptUtil.compress(output, compressionLevel);
                }

                scriptCache.put(filePath, output);
            }
        }

        response.setContentType(mimeType);
        response.setDateHeader(HttpConstants.HEADER_LAST_MODIFIED, CONTAINER_START_TIME);
        response.setHeader(HttpConstants.HEADER_ETAG, ETAG);

        PrintWriter out = response.getWriter();
        out.println(output);
    }

    /**
     * Mostly when we send a file out, we don't change anything so the default
     * set of search and replaces is empty.
     * Engine.js can override this with strings to customize the output
     * @return a map of search (key) and replace (value) strings
     */
    public Map<String, String> getSearchReplacePairs()
    {
        return null;
    }

    /**
     * Do we need to send the content for this file
     * @param req The HTTP request
     * @return true iff the ETags and If-Modified-Since headers say we have not changed
     */
    private boolean isUpToDate(HttpServletRequest req)
    {
        if (ignoreLastModified)
        {
            return false;
        }

        long modifiedSince = -1;
        try
        {
            // HACK: Websphere appears to get confused sometimes
            modifiedSince = req.getDateHeader(HttpConstants.HEADER_IF_MODIFIED);
        }
        catch (RuntimeException ex)
        {
            // TODO: Check for "length" and re-parse
            // Normally clients send If-Modified-Since in rfc-complaint form
            // ("If-Modified-Since: Tue, 13 Mar 2007 13:11:09 GMT") some proxies
            // or browsers add length to this header so it comes like
            // ("If-Modified-Since: Tue, 13 Mar 2007 13:11:09 GMT; length=35946")
            // Servlet spec says container can throw IllegalArgumentException
            // if header value can not be parsed as http-date.
            // We might want to check for "; length=" and then do our own parsing
            // See: http://getahead.org/bugs/browse/DWR-20
            // And: http://www-1.ibm.com/support/docview.wss?uid=swg1PK20062
        }

        if (modifiedSince != -1)
        {
            // Browsers are only accurate to the second
            modifiedSince -= modifiedSince % 1000;
        }
        String givenEtag = req.getHeader(HttpConstants.HEADER_IF_NONE);

        // Deal with missing etags
        if (givenEtag == null)
        {
            // There is no ETag, just go with If-Modified-Since
            if (modifiedSince > CONTAINER_START_TIME)
            {
                if (log.isDebugEnabled())
                {
                    log.debug("Sending 304 for " + filePath + " If-Modified-Since=" + modifiedSince + ", Last-Modified=" + CONTAINER_START_TIME);
                }
                return true;
            }

            // There are no modified settings, carry on
            return false;
        }

        // Deal with missing If-Modified-Since
        if (modifiedSince == -1)
        {
            if (!ETAG.equals(givenEtag))
            {
                // There is an ETag, but no If-Modified-Since
                if (log.isDebugEnabled())
                {
                    log.debug("Sending 304 for " + filePath + " Old ETag=" + givenEtag + ", New ETag=" + ETAG);
                }
                return true;
            }

            // There are no modified settings, carry on
            return false;
        }

        // Do both values indicate that we are in-date?
        if (ETAG.equals(givenEtag) && modifiedSince <= CONTAINER_START_TIME)
        {
            if (log.isDebugEnabled())
            {
                log.debug("Sending 304 for " + filePath);
            }
            return true;
        }

        return false;
    }

    /**
     * @param ignoreLastModified The ignoreLastModified to set.
     */
    public void setIgnoreLastModified(boolean ignoreLastModified)
    {
        this.ignoreLastModified = ignoreLastModified;
    }

    /**
     * Alter the session cookie name from the default JSESSIONID.
     * @param sessionCookieName the sessionCookieName to set
     */
    public void setSessionCookieName(String sessionCookieName)
    {
        this.sessionCookieName = sessionCookieName;
    }

    /**
     * To what level do we compress scripts?
     * @param scriptCompressed The scriptCompressed to set.
     */
    public void setScriptCompressed(boolean scriptCompressed)
    {
        this.scriptCompressed = scriptCompressed;
    }

    /**
     * @param compressionLevel The compressionLevel to set.
     */
    public void setCompressionLevel(int compressionLevel)
    {
        this.compressionLevel = compressionLevel;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    /**
     * The mime type to send the output under
     * @param mimeType the mimeType to set
     */
    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    /**
     * Sometimes with proxies, you need to close the stream all the time to
     * make the flush work. A value of -1 indicated that we do not do early
     * closing after writes.
     * @param maxWaitAfterWrite the maxWaitAfterWrite to set
     */
    public void setMaxWaitAfterWrite(int maxWaitAfterWrite)
    {
        this.maxWaitAfterWrite = maxWaitAfterWrite;
    }

    /**
     * Do we ignore all the Last-Modified/ETags blathering?
     */
    protected boolean ignoreLastModified = false;

    /**
     * Sometimes with proxies, you need to close the stream all the time to
     * make the flush work. A value of -1 indicated that we do not do early
     * closing after writes.
     * See also: org.directwebremoting.dwrp.PollHandler.maxWaitAfterWrite
     */
    protected int maxWaitAfterWrite = -1;

    /**
     * The session cookie name
     */
    protected String sessionCookieName = "JSESSIONID";

    /**
     * How much do we compression javascript by?
     */
    protected int compressionLevel = JavascriptUtil.LEVEL_DEBUGGABLE;

    /**
     * Do we retain comments and unneeded spaces in Javascript code?
     */
    private boolean scriptCompressed = false;

    /**
     * The page id length
     */
    protected int pageIdLength = 16;

    /**
     * We cache the script output for speed
     */
    protected final Map<String, String> scriptCache = new HashMap<String, String>();

    /**
     * The file filePath and resource filePath (minus org.directwebremoting) to read from
     */
    private String filePath;

    /**
     * The mime type to send the output under
     */
    private String mimeType;

    /**
     * The time on the script files
     */
    private static final long CONTAINER_START_TIME;

    /**
     * The ETAG (=time for us) on the script files
     */
    private static final String ETAG;

    /**
     * Initialize the container start time
     */
    static
    {
        // Browsers are only accurate to the second
        long now = System.currentTimeMillis();
        CONTAINER_START_TIME = now - (now % 1000);

        ETAG = "\"" + CONTAINER_START_TIME + '\"';
    }

    /**
     * Does engine.js do GETs for Safari
     */
    protected static final String PARAM_SCRIPT_ALLOWGET = "${allowGetForSafariButMakeForgeryEasier}";

    /**
     * Do we force polling with XHR on IE to prevent clicking
     */
    protected static final String PARAM_SCRIPT_POLLXHR = "${pollWithXhr}";

    /**
     * The page id parameter that goes in engine.js
     */
    protected static final String PARAM_SCRIPT_SESSIONID = "${scriptSessionId}";

    /**
     * Under what cookie name is the session id stored?
     */
    protected static final String PARAM_SCRIPT_COOKIENAME = "${sessionCookieName}";

    /**
     * What is the replacement field we use to tell engine.js what we are using
     * for script tag hack protection
     */
    protected static final String PARAM_SCRIPT_TAG_PROTECTION = "${scriptTagProtection}";

    /**
     * What is the replacement field we use to tell engine.js what we are using
     * for script tag hack protection
     */
    protected static final String PARAM_DEFAULT_PATH = "${defaultPath}";

    /**
     * The log stream
     */
    private static final Log log = LogFactory.getLog(FileHandler.class);
}
