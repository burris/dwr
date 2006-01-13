package uk.ltd.getahead.dwr.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import uk.ltd.getahead.dwr.Call;
import uk.ltd.getahead.dwr.Calls;
import uk.ltd.getahead.dwr.ConversionConstants;
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
     * @throws IOException If reading from the request body stream fails
     */
    public Calls parseRequest(HttpServletRequest req) throws IOException
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

        if (in == null)
        {
            // it is not a post message
            throw new RuntimeException(Messages.getString("ExecuteQuery.ErrorNullPost")); //$NON-NLS-1$
        }

        while (true)
        {
            String line = in.readLine();

            if (line == null)
            {
                break;
            }

            // If there are any &s then this must be iframe post and all the
            // parameters have got dumped on one line.
            if (line.indexOf('&') == -1)
            {
                parsePostLine(line, paramMap);
            }
            else
            {
                log.debug("Using iframe POST mode"); //$NON-NLS-1$
                StringTokenizer st = new StringTokenizer(line, "&"); //$NON-NLS-1$
                while (st.hasMoreTokens())
                {
                    String part = st.nextToken();
                    part = LocalUtil.decode(part);

                    parsePostLine(part, paramMap);
                }
            }
        }

        // Safari gets confused so we need some special treatment
        // See: http://bugzilla.opendarwin.org/show_bug.cgi?id=3565
        //      https://dwr.dev.java.net/issues/show_bug.cgi?id=93
        //      http://jira.atlassian.com/browse/JRA-8354
        //      http://developer.apple.com/internet/safari/uamatrix.html
        String params = req.getParameter("isBrokenSafari2"); //$NON-NLS-1$
        if (params != null && params.length() > 0)
        {
            StringTokenizer st = new StringTokenizer(params, "\n"); //$NON-NLS-1$
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
     * @return Simply HttpServletRequest.getParameterMap() for now
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
    private Calls parseParameters(Map paramMap) throws IOException
    {
        Calls calls = new Calls();

        // XML mode is common to all calls
        calls.setXhrMode(Boolean.valueOf((String) paramMap.remove(ConversionConstants.INBOUND_KEY_XMLMODE)).booleanValue());

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
            Call call = new Call();
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

        if (paramMap.size() != 0)
        {
            log.warn("Entries left over in parameter map"); //$NON-NLS-1$
        }

        return calls;
    }

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(RequestParser.class);
}
