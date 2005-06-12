package uk.ltd.getahead.dwr;

import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.lang.reflect.Method;

import uk.ltd.getahead.dwr.util.SourceUtil;
import uk.ltd.getahead.dwr.util.LocalUtil;
import uk.ltd.getahead.dwr.util.Logger;
import uk.ltd.getahead.dwr.lang.StringEscapeUtils;

/**
 * This is the main class which handles all DWR requests. <br>
 * It can be used by any MVC technology that wants to incorporate DWR
 * capabilities.
 *
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 * @author Bram Smeets
 */
public class DwrEngine {
    /**
     * Gets the current configuration of this engine.
     *
     * @return the current configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the current configuration of this engine.
     *
     * @param configuration the current configuration
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Handles a request to the dwr engine. <br>
     * It either executes one of these actions depending on the path info.
     *
     * @param req  the request to handle
     * @param resp the response to handle
     *
     * @throws IOException in case handling of the request failed due to an I/O
     *                     exception
     */
    public void handle(HttpServletRequest req, HttpServletResponse resp)
    throws IOException
    {
        String pathinfo = req.getPathInfo();
        if (pathinfo == null || pathinfo.length() == 0 || pathinfo.equals(PATH_ROOT))
        {
            // Create a debug mode only index page to all the available classes
            doIndex(req, resp);
        }
        else if (pathinfo != null && pathinfo.startsWith(PATH_TEST))
        {
            // Create a debug mode only test page for a single available class
            doTest(req, resp);
        }
        else if (pathinfo != null && pathinfo.equalsIgnoreCase('/' + FILE_ENGINE))
        {
            getFile(resp, FILE_ENGINE, MIME_JS);
        }
        else if (pathinfo != null && pathinfo.equalsIgnoreCase('/' + FILE_UTIL))
        {
            getFile(resp, FILE_UTIL, MIME_JS);
        }
        else if (pathinfo != null && pathinfo.equalsIgnoreCase('/' + FILE_JSCP))
        {
            getFile(resp, FILE_JSCP, MIME_JS);
        }
        else if (pathinfo != null && pathinfo.startsWith(PATH_INTERFACE))
        {
            // Create some javascript interface code
            doInterface(req, resp);
        }
        else if (pathinfo != null && pathinfo.startsWith(PATH_EXEC))
        {
            doExec(req, resp);
        }
        else
        {
            log.warn("Page not found. In debug/test mode try viewing /[WEB-APP]/dwr/"); //$NON-NLS-1$
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    /**
     * Gets the file at the specified path. <br>
     * It gets the script relative to the current class.
     *
     * @param response the response to write the file content to
     * @param file     the file to get as string
     * @param mimeType the mime type of the file to get
     * 
     * @throws IOException in case an I/O error occurs, ie. not finding the
     *                     requested file
     */
    protected void getFile(HttpServletResponse response,
                        String file,
                        String mimeType)
    throws IOException {
        response.setContentType(mimeType);

        synchronized (scriptCache)
        {
            String output = (String) scriptCache.get(file);
            if (output == null)
            {
                // get the script from the dwr engine
                InputStream raw = DwrEngine.class.getResourceAsStream(file);
                output = FileCopyUtils.copyToString(new BufferedReader(new InputStreamReader(raw)));

                if (mimeType.equals(MIME_JS) && compress)
                {
                    output = SourceUtil.compress(output);
                }

                scriptCache.put(file, output);
            }

            PrintWriter out = response.getWriter();
            out.println(output);
            out.flush();
        }
    }

    /**
     * Generates the javascript code for the requested script.
     *
     * @param req  the request to handle
     * @param resp the response to handle
     *
     * @throws IOException in case handling of the request failed due to an I/O
     *                     exception
     */
    protected void doInterface(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
        String scriptname = req.getPathInfo();
        scriptname = LocalUtil.replace(scriptname, PATH_INTERFACE, BLANK);
        scriptname = LocalUtil.replace(scriptname, EXTENSION_JS, BLANK);
        Creator creator = configuration.getCreatorManager().getCreator(scriptname);

        //resp.setContentType("text/javascript");
        PrintWriter out = resp.getWriter();
        out.println();

        out.println("function " + scriptname + "() { }"); //$NON-NLS-1$ //$NON-NLS-2$
        out.println();

        Method[] methods = creator.getType().getMethods();
        for (int i = 0; i < methods.length; i++)
        {
            Method method = methods[i];
            String methodName = method.getName();

            String reason = Factory.getDoorman().getReasonToNotExecute(req, creator, scriptname, method);
            if (reason != null && !allowImpossibleTests)
            {
                continue;
            }

            // Is it on the list of banned names
            if (configuration.isReservedWord(methodName))
            {
                continue;
            }

            if (i != 0)
            {
                out.print('\n');
            }
            out.print(scriptname + '.' + methodName + " = function("); //$NON-NLS-1$
            Class[] paramTypes = method.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (!isAutoFilled(paramTypes[j]))
                {
                    out.print("p" + j + ", "); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
            out.println("callback)"); //$NON-NLS-1$
            out.println('{');

            String path = req.getContextPath() + req.getServletPath();

            out.print("    DWREngine._execute('" + path + "', '" + scriptname + "', '" + methodName + "\', "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (isAutoFilled(paramTypes[j]))
                {
                    out.print("false, "); //$NON-NLS-1$
                }
                else
                {
                    out.print("p" + j + ", "); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
            out.println("callback);"); //$NON-NLS-1$

            out.println('}');
        }

        out.flush();
    }

    /**
     * Executes a DWR query.
     *
     * @param req  the request to handle
     * @param resp the response to handle
     *
     * @throws IOException in case handling of the request failed due to an I/O
     *                     exception
     */
    protected void doExec(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
        ExecuteQuery eq = new ExecuteQuery(req, configuration.getCreatorManager(), configuration.getConverterManager());

        if (eq.isFailingBrowser())
        {
            resp.setContentType(MIME_HTML);

            PrintWriter out = resp.getWriter();
            out.println("//<script type='text/javascript'>"); //$NON-NLS-1$
            out.println("alert('Your browser sent a request that could not be understood.\\nIf you understand how Javascript works in your browser, please help us fix the problem.\\nSee the mailing lists at http://www.getahead.ltd.uk/dwr/ for more information.');"); //$NON-NLS-1$
            out.println("//</script>"); //$NON-NLS-1$
            out.flush();
            return;
        }

        Call[] calls = eq.execute();

        for (int i = 0; i < calls.length; i++)
        {
            Call call = calls[i];
            if (call.getThrowable() != null)
            {
                log.warn("Erroring: id[" + call.getId() + "] message[" + call.getThrowable().getMessage() + ']', call.getThrowable()); //$NON-NLS-1$ //$NON-NLS-2$
            }
            else
            {
                log.debug("Returning: id[" + call.getId() + "] init[" + call.getReply().getInitCode() + "] assign[" + call.getReply().getAssignCode() + "] xml[" + eq.isXmlMode() + ']'); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            }
        }

        // We build the answer up in a StringBuffer because that makes is easier
        // to debug, and because that's only what the compiler does anyway.
        StringBuffer buffer = new StringBuffer();

        // if we are in html (iframe mode) we need to direct script to the parent
        String prefix = eq.isXmlMode() ? "" : "window.parent."; //$NON-NLS-1$ //$NON-NLS-2$

        // iframe mode starts as HTML, so get into script mode
        if (!eq.isXmlMode())
        {
            buffer.append("<script type='text/javascript'>\n"); //$NON-NLS-1$
        }

        for (int i = 0; i < calls.length; i++)
        {
            Call call = calls[i];
            if (call.getThrowable() != null)
            {
                String output = StringEscapeUtils.escapeJavaScript(call.getThrowable().getMessage());

                buffer.append(prefix);
                buffer.append("DWREngine._handleError('"); //$NON-NLS-1$
                buffer.append(call.getId());
                buffer.append("', '"); //$NON-NLS-1$
                buffer.append(output);
                buffer.append("');\n"); //$NON-NLS-1$
            }
            else
            {
                buffer.append(call.getReply().getInitCode());
                buffer.append('\n');

                buffer.append(prefix);
                buffer.append("DWREngine._handleResponse('"); //$NON-NLS-1$
                buffer.append(call.getId());
                buffer.append("', "); //$NON-NLS-1$
                buffer.append(call.getReply().getAssignCode());
                buffer.append(");\n"); //$NON-NLS-1$
            }
        }

        // iframe mode needs to get out of script mode
        if (!eq.isXmlMode())
        {
            buffer.append("</script>\n"); //$NON-NLS-1$
        }

        String reply = buffer.toString();
        log.debug(reply);

        // LocalUtil.addNoCacheHeaders(resp);
        resp.setContentType(eq.isXmlMode() ? MIME_XML : MIME_HTML);
        PrintWriter out = resp.getWriter();
        out.print(reply);
        out.flush();
    }

    /**
     * Gets the index page. <br>
     * This only works if the creator manager is in debug mode.
     *
     * @param req  the request to handle
     * @param resp the response to handle
     *
     * @throws IOException in case handling of the request failed due to an I/O
     *                     exception
     */
    protected void doIndex(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
        if (!configuration.getCreatorManager().isDebug())
        {
            log.warn("Failed attempt to access index page outside of debug mode. Set the debug init-parameter to true to enable."); //$NON-NLS-1$
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        resp.setContentType(MIME_HTML);

        PrintWriter out = resp.getWriter();

        out.println("<html>"); //$NON-NLS-1$
        out.println("<head><title>DWR Test Index</title></head>"); //$NON-NLS-1$
        out.println("<body>"); //$NON-NLS-1$

        out.println("<h2>Classes known to DWR:</h2>"); //$NON-NLS-1$
        out.println("<ul>"); //$NON-NLS-1$
        for (Iterator it = configuration.getCreatorManager().getCreatorNames().iterator(); it.hasNext();)
        {
            String name = (String) it.next();
            Creator creator = configuration.getCreatorManager().getCreator(name);
            out.println("<li><a href='" + req.getContextPath() + req.getServletPath() + PATH_TEST + name + "'>" + name + "</a> (" + creator.getType().getName() + ")</li>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
        }
        out.println("</ul>"); //$NON-NLS-1$

        out.println("<h2>Other Links</h2>"); //$NON-NLS-1$
        out.println("<ul>"); //$NON-NLS-1$
        out.println("<li>Up to <a href='" + req.getContextPath() + "/'>top level of web app</a>.</li>"); //$NON-NLS-1$ //$NON-NLS-2$
        out.println("</ul>"); //$NON-NLS-1$

        out.println("</body></html>"); //$NON-NLS-1$
        out.flush();
    }

    /**
     * Handles a request for the debug pages. <br>
     * This only works if the creator manager is in debug mode.
     * 
     * @param req  the request to handle
     * @param resp the response to handle
     *
     * @throws IOException in case handling of the request failed due to an I/O
     *                     exception
     */
    protected void doTest(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
        if (!configuration.getCreatorManager().isDebug())
        {
            log.warn("Failed attempt to access test pages outside of debug mode. Set the debug init-parameter to true to enable."); //$NON-NLS-1$
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        String scriptname = req.getPathInfo();
        scriptname = LocalUtil.replace(scriptname, PATH_TEST, BLANK);
        scriptname = LocalUtil.replace(scriptname, PATH_ROOT, BLANK);

        Creator creator = configuration.getCreatorManager().getCreator(scriptname);

        Method[] methods = creator.getType().getMethods();

        resp.setContentType(MIME_HTML);
        PrintWriter out = resp.getWriter();

        String interfaceURL = req.getContextPath() + req.getServletPath() + PATH_INTERFACE + scriptname + EXTENSION_JS;
        String engineURL = req.getContextPath() + req.getServletPath() + '/' + FILE_ENGINE;
        String utilURL = req.getContextPath() + req.getServletPath() + '/' + FILE_UTIL;

        out.println("<html>"); //$NON-NLS-1$
        out.println("<head>"); //$NON-NLS-1$
        out.println("  <title>DWR Test</title>"); //$NON-NLS-1$
        out.println("  <script type='text/javascript' src='" + interfaceURL + "'></script>"); //$NON-NLS-1$ //$NON-NLS-2$
        out.println("  <script type='text/javascript' src='" + engineURL + "'></script>"); //$NON-NLS-1$ //$NON-NLS-2$
        out.println("  <script type='text/javascript' src='" + utilURL + "'></script>"); //$NON-NLS-1$ //$NON-NLS-2$
        out.println("  <style>"); //$NON-NLS-1$
        out.println("    input.itext { font-size: smaller; background: #E4E4E4; border: 0; }"); //$NON-NLS-1$
        out.println("    input.ibutton { font-size: xx-small; border: 1px outset; margin: 0px; padding: 0px; }"); //$NON-NLS-1$
        out.println("    span.reply { background: #ffffdd; }"); //$NON-NLS-1$
        out.println("  </style>"); //$NON-NLS-1$
        out.println("</head>"); //$NON-NLS-1$
        out.println("<body>"); //$NON-NLS-1$
        out.println(BLANK);

        out.println("<h2>Methods For: " + scriptname + " (" + creator.getType().getName() + ")</h2>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        out.println("<p>To use this class in your javascript you will need the following script includes:</p>"); //$NON-NLS-1$
        out.println("<pre>"); //$NON-NLS-1$
        out.println("  &lt;script type='text/javascript' src='<a href='" + interfaceURL + "'>" + interfaceURL + "</a>'&gt;&lt;/script&gt;"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        out.println("  &lt;script type='text/javascript' src='<a href='" + engineURL + "'>" + engineURL + "</a>'&gt;&lt;/script&gt;"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        out.println("</pre>"); //$NON-NLS-1$

        out.println("<p>In addition there is an optional utility script:</p>"); //$NON-NLS-1$
        out.println("<pre>"); //$NON-NLS-1$
        out.println("  &lt;script type='text/javascript' src='<a href='" + utilURL + "'>" + utilURL + "</a>'&gt;&lt;/script&gt;"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        out.println("</pre>"); //$NON-NLS-1$

        out.println("<p>Replies from DWR are shown with a yellow background.<br/>"); //$NON-NLS-1$
        out.println("The inputs are evaluated as Javascript so strings must be quoted before execution.</p>"); //$NON-NLS-1$

        out.println("<p>There are " + methods.length + " declared methods:</p><ul>"); //$NON-NLS-1$ //$NON-NLS-2$

        for (int i = 0; i < methods.length; i++)
        {
            Method method = methods[i];
            String methodName = method.getName();

            String reason = Factory.getDoorman().getReasonToNotExecute(req, creator, scriptname, method);
            if (reason != null)
            {
                out.println(BLANK);
                out.println("<li style='color: #A88;'>  " + methodName + "() is not available: " + reason + "</li>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                if (!allowImpossibleTests)
                {
                    continue;
                }
            }

            // Is it on the list of banned names
            if (configuration.isReservedWord(methodName))
            {
                out.println(BLANK);
                out.println("<li style='color: #88A;'>" + methodName + "() is not available because it is a reserved word.</li>"); //$NON-NLS-1$ //$NON-NLS-2$
                continue;
            }

            out.println(BLANK);
            out.println("<li>"); //$NON-NLS-1$
            out.println("  " + methodName + '('); //$NON-NLS-1$

            Class[] paramTypes = method.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                Class paramType = paramTypes[j];

                // The special type that we handle transparently
                if (isAutoFilled(paramType))
                {
                    out.print("AUTO"); //$NON-NLS-1$
                }
                else
                {
                    String value = BLANK; //$NON-NLS-1$
                    if (paramType == String.class)
                    {
                        value = "\"\""; //$NON-NLS-1$
                    }
                    else if (paramType == Boolean.class || paramType == Boolean.TYPE)
                    {
                        value = "true"; //$NON-NLS-1$
                    }
                    else if (paramType == Integer.class || paramType == Integer.TYPE ||
                             paramType == Short.class || paramType == Short.TYPE ||
                             paramType == Long.class || paramType == Long.TYPE ||
                             paramType == Byte.class || paramType == Byte.TYPE)
                    {
                        value = "0"; //$NON-NLS-1$
                    }
                    else if (paramType == Float.class || paramType == Float.TYPE ||
                             paramType == Double.class || paramType == Double.TYPE)
                    {
                        value = "0.0"; //$NON-NLS-1$
                    }
                    else if (paramType.isArray() || Collection.class.isAssignableFrom(paramType))
                    {
                        value = "[]"; //$NON-NLS-1$
                    }
                    else if (Map.class.isAssignableFrom(paramType))
                    {
                        value = "{}"; //$NON-NLS-1$
                    }

                    out.print("    <input class='itext' type='text' size='10' value='" + value + "' id='p" + i + j + "' title='Will be converted to: " + paramType.getName() + "'/>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                }

                out.println(j == paramTypes.length - 1 ? BLANK : ", "); //$NON-NLS-1$
            }
            out.println("  );"); //$NON-NLS-1$

            String onclick = scriptname + '.' + methodName + "(reply" + i; //$NON-NLS-1$
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (!isAutoFilled(paramTypes[j]))
                {
                    onclick += ",eval(document.getElementById(\"p" + i + j + "\").value)"; //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
            onclick += ");"; //$NON-NLS-1$

            out.print("  <input class='ibutton' type='button' onclick='" + onclick + "' value='Execute'  title='Calls " + scriptname + '.' + methodName + "(). View source for details.'/>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

            out.println("  <script type='text/javascript'>"); //$NON-NLS-1$
            out.println("    var reply" + i + " = function(data)"); //$NON-NLS-1$ //$NON-NLS-2$
            out.println("    {"); //$NON-NLS-1$
            out.println("      DWRUtil.setValue('d" + i + "', DWRUtil.toDescriptiveString(data));"); //$NON-NLS-1$ //$NON-NLS-2$
            out.println("    }"); //$NON-NLS-1$
            out.println("  </script>"); //$NON-NLS-1$
            out.println("  <span id='d" + i + "' class='reply'></span>"); //$NON-NLS-1$ //$NON-NLS-2$

            // Print a warning if this method is overloaded
            boolean overridden = false;
            for (int j = 0; j < methods.length; j++)
            {
                if (j != i && methods[j].getName().equals(methodName))
                {
                    overridden = true;
                }
            }
            if (overridden)
            {
                out.println("<br/><span style='font-size: smaller; color: red;'>(Warning: overridden methods are not recommended. See <a href='#overriddenMethod'>below</a>)</span>"); //$NON-NLS-1$
            }

            // Print a warning if the method uses un-marshallable types
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (!configuration.getConverterManager().isConvertable(paramTypes[j]))
                {
                    out.println("<br/><span style='font-size: smaller; color: red;'>(Warning: " + paramTypes[j].getName() + " param not marshallable. See <a href='#paramNotMarshallable'>below</a>)</span>"); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }

            if (!configuration.getConverterManager().isConvertable(method.getReturnType()))
            {
                out.println("<br/><span style='font-size: smaller; color: red;'>(Warning: " + method.getReturnType().getName() + " return type not marshallable. See <a href='#returnNotMarshallable'>below</a>)</span>"); //$NON-NLS-1$ //$NON-NLS-2$
            }

            out.println("</li>"); //$NON-NLS-1$
        }

        out.println(BLANK);
        out.println("</ul>"); //$NON-NLS-1$

        out.println("<h2>Other Links</h2>"); //$NON-NLS-1$
        out.println("<ul>"); //$NON-NLS-1$
        out.println("<li>Back to <a href='" + req.getContextPath() + req.getServletPath() + "'>class index</a>.</li>"); //$NON-NLS-1$ //$NON-NLS-2$
        out.println("<li>Up to <a href='" + req.getContextPath() + "/'>top level of web app</a>.</li>"); //$NON-NLS-1$ //$NON-NLS-2$
        out.println("</ul>"); //$NON-NLS-1$

        synchronized (scriptCache)
        {
            String output = (String) scriptCache.get(FILE_HELP);
            if (output == null)
            {
                StringBuffer buffer = new StringBuffer();

                InputStream raw = getClass().getResourceAsStream(FILE_HELP);
                if (raw == null)
                {
                    log.error(Messages.getString("DWREngine.MissingHelp", FILE_HELP)); //$NON-NLS-1$
                    output = "<p>Failed to read help text from resource file. Check dwr.jar is built to include html files.</p>"; //$NON-NLS-1$
                }
                else
                {
                    BufferedReader in = new BufferedReader(new InputStreamReader(raw));
                    while (true)
                    {
                        String line = in.readLine();
                        if (line == null)
                        {
                            break;
                        }

                        buffer.append(line);
                        buffer.append('\n');
                    }

                    output = buffer.toString();
                }

                scriptCache.put(FILE_HELP, output);
            }

            out.println(output);
        }

        out.println("</body></html>"); //$NON-NLS-1$
        out.flush();
    }

    /**
     * Is this class one that we auto fill, so the user can ignore?
     * @param paramType The type to test
     * @return true if the type is a Servlet type
     */
    protected static boolean isAutoFilled(Class paramType)
    {
        return paramType == HttpServletRequest.class ||
               paramType == HttpServletResponse.class ||
               paramType == ServletConfig.class ||
               paramType == ServletContext.class ||
               paramType == HttpSession.class;
    }

    protected static final String FILE_UTIL = "util.js"; //$NON-NLS-1$

    protected static final String FILE_ENGINE = "engine.js"; //$NON-NLS-1$

    protected static final String FILE_JSCP = "jscp.js"; //$NON-NLS-1$

    protected static final String FILE_HELP = "help.html"; //$NON-NLS-1$

    protected static final String EXTENSION_JS = ".js"; //$NON-NLS-1$

    protected static final String PATH_EXEC = "/exec"; //$NON-NLS-1$

    protected static final String PATH_INTERFACE = "/interface/"; //$NON-NLS-1$

    protected static final String PATH_ROOT = "/"; //$NON-NLS-1$

    protected static final String PATH_TEST = "/test/"; //$NON-NLS-1$

    /*
     * If we need to do more advanced char processing then we should consider
     * adding "; charset=utf-8" to the end of these 3 strings and altering the
     * marshalling to assume utf-8, which it currently does not.
     */
    protected static final String MIME_XML = "text/xml"; //$NON-NLS-1$

    protected static final String MIME_JS = "text/javascript"; //$NON-NLS-1$

    protected static final String MIME_HTML = "text/html"; //$NON-NLS-1$

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DwrEngine.class);

    /**
     * Empty string
     */
    protected static final String BLANK = ""; //$NON-NLS-1$

    /**
     * We cache the script output for speed
     */
    private final Map scriptCache = new HashMap();

    /**
     * Do we retain comments and unneeded spaces in Javascript code?
     */
    private boolean compress = true;

    /**
     * This helps us test that access rules are being followed
     */
    private boolean allowImpossibleTests = false;

    /** The configuration of the dwr engine. */
    private Configuration configuration;
}
