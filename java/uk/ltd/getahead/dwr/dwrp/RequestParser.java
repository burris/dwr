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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import uk.ltd.getahead.dwr.MarshallException;
import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;
import uk.ltd.getahead.dwr.util.LocalUtil;
import uk.ltd.getahead.dwr.util.Logger;
import uk.ltd.getahead.dwr.util.Messages;

/**
 * A utility class that abstracts the job of converting an inbound request into
 * a Calls object that stores the real work to be done.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class RequestParser
{
    /**
     * Parse an inbound request into a Calls object
     * @param req The original browser's request
     * @return A parsed set of calls
     * @throws MarshallException If reading from the request body stream fails
     */
    public CallsWithContext parseRequest(HttpServletRequest req) throws MarshallException
    {
        try
        {
            if (req.getMethod().equals("GET")) //$NON-NLS-1$
            {
                return parseParameters(parseGet(req));
            }
            else
            {
                return parseParameters(parsePost(req));
            }
        }
        catch (IOException ex)
        {
            throw new MarshallException(ex);
        }
    }

    /**
     * Parse an HTTP POST request to fill out the scriptName, methodName and
     * paramList properties. This method should not fail unless it will not
     * be possible to return any sort of error to the user. Failure cases should
     * be handled by the <code>checkParams()</code> method.
     * @param req The original browser's request
     * @return The equivalent of HttpServletRequest.getParameterMap() for now
     * @throws IOException If reading from the request body stream fails
     */
    private Map parsePost(HttpServletRequest req) throws IOException
    {
        Map paramMap = new HashMap();

        // I've had reports of data loss in Tomcat 5.0 that relate to this bug
        //   http://issues.apache.org/bugzilla/show_bug.cgi?id=27447
        // See mails to users@dwr.dev.java.net:
        //   Subject: "Tomcat 5.x read-ahead problem"
        //   From: CAKALIC, JAMES P [AG-Contractor/1000]
        // It would be more normal to do the following:
        // BufferedReader in = req.getReader();
        BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));

        while (true)
        {
            String line = in.readLine();

            if (line == null)
            {
                break;
            }

            if (line.indexOf('&') != -1)
            {
                // If there are any &s then this must be iframe post and all the
                // parameters have got dumped on one line, split with &
                log.debug("Using iframe POST mode"); //$NON-NLS-1$
                StringTokenizer st = new StringTokenizer(line, "&"); //$NON-NLS-1$
                while (st.hasMoreTokens())
                {
                    String part = st.nextToken();
                    part = LocalUtil.decode(part);

                    parsePostLine(part, paramMap);
                }
            }
            else
            {
                // Horay, this is a normal one!
                parsePostLine(line, paramMap);
            }
        }

        // If there is only 1 param then this must be a broken Safari. All
        // the parameters have got dumped on one line split with \n
        // See: http://bugzilla.opendarwin.org/show_bug.cgi?id=3565
        //      https://dwr.dev.java.net/issues/show_bug.cgi?id=93
        //      http://jira.atlassian.com/browse/JRA-8354
        //      http://developer.apple.com/internet/safari/uamatrix.html
        if (paramMap.size() == 1)
        {
            log.debug("Using Broken Safari POST mode"); //$NON-NLS-1$

            // This looks like a broken Mac where the line endings are confused

            // Iterators insist that we call hasNext() before we start
            Iterator it = paramMap.keySet().iterator();
            if (!it.hasNext())
            {
                throw new IllegalStateException("No entries in non empty map!"); //$NON-NLS-1$
            }

            // So get the first
            String key = (String) it.next();
            String value = (String) paramMap.get(key);
            String line = key + ConversionConstants.INBOUND_DECL_SEPARATOR + value;

            StringTokenizer st = new StringTokenizer(line, "\n"); //$NON-NLS-1$
            while (st.hasMoreTokens())
            {
                String part = st.nextToken();
                part = LocalUtil.decode(part);

                parsePostLine(part, paramMap);
            }
        }

        return paramMap;
    }

    /**
     * Sort out a single line in a POST request
     * @param line The line to parse
     * @param paramMap The map to add parsed parameters to
     */
    private void parsePostLine(String line, Map paramMap)
    {
        if (line.length() == 0)
        {
            return;
        }

        int sep = line.indexOf(ConversionConstants.INBOUND_DECL_SEPARATOR);
        if (sep == -1)
        {
            log.warn("Missing separator in POST line: " + line); //$NON-NLS-1$
        }
        else
        {
            String key = line.substring(0, sep);
            String value = line.substring(sep  + ConversionConstants.INBOUND_DECL_SEPARATOR.length());

            paramMap.put(key, value);
        }
    }

    /**
     * Parse an HTTP GET request to fill out the scriptName, methodName and
     * paramList properties. This method should not fail unless it will not
     * be possible to return any sort of error to the user. Failure cases should
     * be handled by the <code>checkParams()</code> method.
     * @param req The original browser's request
     * @return Simply HttpRequest.getParameterMap() for now
     * @throws IOException If the parsing fails
     */
    private Map parseGet(HttpServletRequest req) throws IOException
    {
        Map convertedMap = new HashMap();
        Map paramMap = req.getParameterMap();

        for (Iterator it = paramMap.keySet().iterator(); it.hasNext();)
        {
            String key = (String) it.next();
            String[] array = (String[]) paramMap.get(key);

            if (array.length == 1)
            {
                convertedMap.put(key, array[0]);
            }
            else
            {
                throw new IOException(Messages.getString("ExecuteQuery.MultiValues", key)); //$NON-NLS-1$
            }
        }

        return convertedMap;
    }

    /**
     * Fish out the important parameters
     * @param paramMap The string/string map to convert
     * @return The call details the methods we are calling
     * @throws IOException If the parsing of input parameter fails
     */
    private CallsWithContext parseParameters(Map paramMap) throws IOException
    {
        CallsWithContext calls = new CallsWithContext();

        // Work out how many calls are in this packet
        String callStr = (String) paramMap.remove(ConversionConstants.INBOUND_CALL_COUNT);
        int callCount;
        try
        {
            callCount = Integer.parseInt(callStr);
        }
        catch (NumberFormatException ex)
        {
            throw new IOException(Messages.getString("ExecuteQuery.BadCallCount", callStr)); //$NON-NLS-1$
        }

        // Extract the ids, scriptnames and methodnames
        for (int callNum = 0; callNum < callCount; callNum++)
        {
            CallWithContext call = new CallWithContext();
            calls.addCall(call);

            String prefix = ConversionConstants.INBOUND_CALLNUM_PREFIX + callNum + ConversionConstants.INBOUND_CALLNUM_SUFFIX;

            // The special values
            call.setId((String) paramMap.remove(prefix + ConversionConstants.INBOUND_KEY_ID));
            call.setScriptName((String) paramMap.remove(prefix + ConversionConstants.INBOUND_KEY_SCRIPTNAME));
            call.setMethodName((String) paramMap.remove(prefix + ConversionConstants.INBOUND_KEY_METHODNAME));

            // Look for parameters to this method
            for (Iterator it = paramMap.entrySet().iterator(); it.hasNext();)
            {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();

                if (key.startsWith(prefix))
                {
                    String data = (String) entry.getValue();
                    String[] split = LocalUtil.splitInbound(data);

                    String value = split[LocalUtil.INBOUND_INDEX_VALUE];
                    String type = split[LocalUtil.INBOUND_INDEX_TYPE];
                    call.getInboundContext().createInboundVariable(callNum, key, type, value);
                    it.remove();
                }
            }
        }

        paramMap.remove(ConversionConstants.INBOUND_KEY_HTTP_SESSIONID);
        // Maybe we should check the value of this against the cookie value

        String scriptSessionId = (String) paramMap.remove(ConversionConstants.INBOUND_KEY_SCRIPT_SESSIONID);

        WebContext webContext = WebContextFactory.get();
        webContext.setScriptSessionId(scriptSessionId);

        // Remaining parameters get put into the request for later consumption
        if (paramMap.size() != 0)
        {
            HttpServletRequest request = webContext.getHttpServletRequest();

            for (Iterator it = paramMap.entrySet().iterator(); it.hasNext();)
            {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();

                request.setAttribute(key, value);
                log.debug("Moved param to request: " + key + "=" + value); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        return calls;
    }

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(RequestParser.class);
}
