package uk.ltd.getahead.dwr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.SAXException;

import uk.ltd.getahead.dwr.Converter.ScriptSetup;
import uk.ltd.getahead.dwr.lang.StringEscapeUtils;
import uk.ltd.getahead.dwr.util.LocalUtil;
import uk.ltd.getahead.dwr.util.Log;

/**
 * This is the main servlet that handles all the requests to DWR.
 * <p>It is on the large side because it can't use technologies like JSPs etc
 * since it all needs to be deployed in a single jar file, and while it might be
 * possible to integrate Velocity or similar I think simplicity is more
 * important, and there are only 2 real pages both script heavy in this servlet
 * anyway.</p>
 * <p>There are 5 things to do, in the order that you come across them:
 * <li>The index test page that points at the classes</li>
 * <li>The class test page that lets you execute methods</li>
 * <li>The interface javascript that uses the engine to send requests</li>
 * <li>The engine javascript to form the iframe request and process replies</li>
 * <li>The exec 'page' that executes the method and returns data to the iframe</li>
 * </p>
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DWRServlet extends HttpServlet
{
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);

        // Are we in debug mode?
        String debugStr = config.getInitParameter("debug");
        boolean debug = Boolean.valueOf(debugStr).booleanValue();

        configuration = new Configuration(debug);

        // How much logging do we do?
        String logLevel = config.getInitParameter("logLevel");
        if (logLevel != null)
        {
            Log.setLevel(logLevel);
        }

        try
        {
            // Load the system config file
            InputStream in = getClass().getResourceAsStream("dwr.xml");
            configuration.addConfig(in);

            // Find all the init params
            Enumeration en = config.getInitParameterNames();

            // If there are none then use the default name
            if (!en.hasMoreElements())
            {
                in = config.getServletContext().getResourceAsStream("WEB-INF/dwr.xml");
                configuration.addConfig(in);
            }

            // Loop through the ones that do exist
            while (en.hasMoreElements())
            {
                String name = (String) en.nextElement();
                if (name.startsWith("config"))
                {
                    // if the init param starts with "config" then try to load it
                    String configFile = config.getInitParameter(name);
                    in = config.getServletContext().getResourceAsStream(configFile);
                    configuration.addConfig(in);
                }
            }
        }
        catch (SAXException ex)
        {
            Log.fatal("Failed to parse dwr.xml", ex);
            throw new ServletException("Parse error reading from dwr.xml", ex);
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        doPost(req, resp);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try
        {
            ExecutionContext.setExecutionContext(req, resp, getServletConfig());
            Log.setExecutionContext(this);
    
            String pathinfo = req.getPathInfo();
            if (pathinfo == null || pathinfo.length() == 0 || pathinfo.equals("/"))
            {
                if (configuration.isDebugMode())
                {
                    doIndex(req, resp);
                }
                else
                {
                    log("Failed attempt to access index page outside of debug mode. Set the debug init-parameter to true to enable.");
                    resp.sendError(HttpServletResponse.SC_FORBIDDEN);
                }
            }
            else if (pathinfo != null && pathinfo.startsWith("/test/"))
            {
                if (configuration.isDebugMode())
                {
                    doTest(req, resp);
                }
                else
                {
                    log("Failed attempt to access test pages outside of debug mode. Set the debug init-parameter to true to enable.");
                    resp.sendError(HttpServletResponse.SC_FORBIDDEN);
                }
            }
            else if (pathinfo != null && pathinfo.equalsIgnoreCase("/engine.js"))
            {
                doFile(req, resp, "engine.js");
            }
            else if (pathinfo != null && pathinfo.equalsIgnoreCase("/util.js"))
            {
                doFile(req, resp, "util.js");
            }
            else if (pathinfo != null && pathinfo.startsWith("/interface/"))
            {
                doInterface(req, resp);
            }
            else if (pathinfo != null && pathinfo.startsWith("/exec"))
            {
                doExec(req, resp);
            }
            else
            {
                log("Page not found. In debug/test mode try viewing /[WEB-APP]/dwr/");
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        finally
        {
            ExecutionContext.unset();
            Log.unsetExecutionContext();
        }
    }

    /**
     * @param req The browsers request
     * @param resp The response channel
     * @throws IOException If writing to the output fails
     */
    private void doIndex(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>DWR Test Index</title></head>");
        out.println("<body>");
        out.println("<h2>Classes known to DWR:</h2>");

        for (Iterator it = configuration.getCreatorNames().iterator(); it.hasNext();)
        {
            String name = (String) it.next();
            Creator creator = configuration.getCreator(name);
            out.println("<li><a href='"+req.getContextPath()+req.getServletPath()+"/test/"+name+"'>"+name+"</a> ("+creator.getType().getName()+")</li>");
        }

        out.println("</body></html>");
        out.flush();
    }

    /**
     * @param req The browsers request
     * @param resp The response channel
     * @throws IOException If writing to the output fails
     */
    private void doTest(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String scriptname = req.getPathInfo();
        scriptname = LocalUtil.replace(scriptname, "/test/", "");
        scriptname = LocalUtil.replace(scriptname, "/", "");

        Creator creator = configuration.getCreator(scriptname);
        if (creator == null)
        {
            throw new SecurityException("No class by name: "+scriptname);
        }

        Method[] methods = creator.getType().getDeclaredMethods();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("  <title>DWR Test</title>");
        out.println("  <script type='text/javascript' src='"+getInterfaceURL(req, scriptname)+"'></script>");
        out.println("  <script type='text/javascript' src='"+getEngineURL(req)+"'></script>");
        out.println("  <style>");
        out.println("    input.itext { font-size: smaller; background: #E4E4E4; border: 0; }");
        out.println("    input.ibutton { font-size: xx-small; border: 1px outset; margin: 0px; padding: 0px; }");
        out.println("    span.reply { background: #ffffdd; }");
        out.println("  </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("");
        out.println("<h2>Methods For: "+scriptname+" ("+creator.getType().getName()+")</h2>");
        out.println("<p>Replies from DWR are shown with a yellow background.<br/>There are "+methods.length+" declared methods:<ul>");

        for (int i = 0; i < methods.length; i++)
        {
            Method method = methods[i];

            // Is it public
            if (!Modifier.isPublic(method.getModifiers()))
            {
                out.println("");
                out.println("<li style='color: #888;'>  "+method.getName()+"() is not available because it is not public.</li>");
                continue;
            }

            // Is it on the list of banned names
            if (configuration.isReservedWord(method.getName()))
            {
                out.println("");
                out.println("<li style='color: #888;'>"+method.getName()+"() is not available because it is a reserved word.</li>");
                continue;
            }

            out.println("");
            out.println("<li>");
            out.println("  "+method.getName()+"(");

            Class[] paramTypes = method.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                out.print("    <input class='itext' type='text' size='10' id='p"+i+j+"' title='input id=p"+i+j+"\r\nData will be converted to: "+paramTypes[j].getName()+"'/>");
                out.println(j == paramTypes.length - 1 ? "" : ", ");
            }
            out.println("  );");

            String onclick = scriptname+"."+method.getName()+"(reply"+i;
            for (int j = 0; j < paramTypes.length; j++)
            {
                onclick += ",document.getElementById(\"p"+i+j+"\").value";
            }
            onclick += ");";

            out.print("  <input class='ibutton' type='button' onclick='" + onclick + "' value='Execute'  title='onclick=" + onclick + "\r\nWhere reply" + i + " is a callback function (view source for more).'/>");

            out.println("  <script type='text/javascript'>");
            out.println("    var reply"+i+" = function(data)");
            out.println("    {");
            out.println("      document.getElementById('d"+i+"').innerHTML = data;");
            out.println("    }");
            out.println("  </script>");
            out.println("  <span id='d"+i+"' class='reply'></span>");

            // Print a warning if this method is overloaded
            boolean overridden = false;
            for (int j = 0; j < methods.length; j++)
            {
                if (j != i && methods[j].getName().equals(method.getName()))
                {
                    overridden = true;
                }
            }
            if (overridden)
            {
                out.println("<span style='font-size: smaller; color: red;'>(Warning: overridden methods are not recommended)</span>");
            }

            // Print a warning if the method uses un-marshallable types
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (!configuration.isConvertable(paramTypes[j]))
                {
                    out.println("<span style='font-size: smaller; color: red;'>(Warning: "+paramTypes[j].getName()+" param not marshallable)</span>");
                }
            }
            if (!configuration.isConvertable(method.getReturnType()))
            {
                out.println("<span style='font-size: smaller; color: red;'>(Warning: "+method.getReturnType().getName()+" return type not marshallable)</span>");
            }

            out.println("</li>");
        }

        out.println("");
        out.println("</ul></p>");

        out.println("<h2>Other Links</h2>");
        out.println("<ul>");
        out.println("<li>Back to <a href='"+req.getContextPath()+req.getServletPath()+"'>class index</a>.</li>");
        out.println("<li>The Javascript <a href='"+getInterfaceURL(req, scriptname)+"'>interface</a> definition corresponding to your Java classes</li>");
        out.println("<li>The Javascript <a href='"+getEngineURL(req)+"'>engine</a> Marshalls calls to the server. Used by the interface script. This is the same for all classes.</li>");
        out.println("</ul>");

        out.println("</body></html>");
        out.flush();
    }

    /**
     * @param req The browsers request
     * @param resp The response channel
     * @throws IOException If writing to the output fails
     */
    private void doInterface(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String pathinfo = req.getPathInfo();
        pathinfo = LocalUtil.replace(pathinfo, "/interface/", "");
        pathinfo = LocalUtil.replace(pathinfo, ".js", "");
        Creator creator = configuration.getCreator(pathinfo);
        if (creator == null)
        {
            throw new SecurityException("No class by name: "+pathinfo);
        }

        //resp.setContentType("text/javascript");
        PrintWriter out = resp.getWriter();
        out.println();
        out.println("// Methods for: "+creator.getType().getName());

        out.println();
        out.println(pathinfo+" = new Object();");

        Method[] methods = creator.getType().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            Method method = methods[i];

            // Is it public
            if (!Modifier.isPublic(method.getModifiers()))
            {
                continue;
            }

            // Is it on the list of banned names
            if (configuration.isReservedWord(method.getName()))
            {
                continue;
            }

            if (i != 0)
            {
                out.print("\n");
            }
            out.print(pathinfo+"."+method.getName()+" = function(callback");
            Class[] paramTypes = method.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                out.print(", p"+j);
            }
            out.println(")");
            out.println("{");

            out.print("    dwrExecute(callback, '"+pathinfo+"', '"+method.getName()+"'");
            for (int j = 0; j < paramTypes.length; j++)
            {
                out.print(", p"+j);
            }
            out.println(");");

            out.println("}");
        }

        out.flush();
    }

    /**
     * Basically a file servlet component that does some <b>very limitted</b>
     * EL type processing on the file.
     * @param req The browsers request
     * @param resp The response channel
     * @param path The path to search for, process and output
     * @throws IOException If writing to the output fails
     */
    private void doFile(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException
    {
        resp.setContentType("text/javascript");

        String output = (String) scriptCache.get(path);
        if (output == null)
        {
            StringBuffer buffer = new StringBuffer();

            InputStream raw = getClass().getResourceAsStream(path);
            BufferedReader in = new BufferedReader(new InputStreamReader(raw));
            while (true)
            {
                String line = in.readLine();
                if (line == null)
                {
                    break;
                }

                line = LocalUtil.replace(line, "${request.contextPath}", req.getContextPath());
                line = LocalUtil.replace(line, "${request.servletPath}", req.getServletPath());

                buffer.append(line);
                buffer.append("\n");
            }

            output = buffer.toString();
            scriptCache.put(path, output);
        }

        PrintWriter out = resp.getWriter();
        out.println(output);
        out.flush();
    }

    /**
     * @param req The browsers request
     * @param resp The response channel
     */
    private void doExec(HttpServletRequest req, HttpServletResponse resp)
    {
        boolean xml = isXMLHttpRequest(req);
        String id = req.getParameter("id");

        try
        {
            String className = req.getParameter("class");
            Creator creator = configuration.getCreator(className);
            if (creator == null)
            {
                throw new SecurityException("No class by name: "+className);
            }

            String methodName = req.getParameter("method");
            if (methodName == null)
            {
                Log.warn("Missing method parameter in url: "+req.getRequestURL()+"?"+req.getQueryString());
                doError(resp, id, "Missing method parameter", xml);
                return;
            }

            List paramList = new ArrayList();
            while (true)
            {
                String param = req.getParameter("param" + paramList.size());
                if (param == null || param.equals("undefined"))
                {
                    break;
                }
                paramList.add(param);
            }

            // Get a list of the available matching methods with the coerced
            // parameters that we will use to call it if we choose to use that
            // method.
            List available = new ArrayList();
            List coerced = new ArrayList();
            Method[] methods = creator.getType().getMethods();
            methods:
            for (int i = 0; i < methods.length; i++)
            {
                // Check method name and access
                Method method = methods[i];
                if (method.getName().equals(methodName))
                {
                    // Check number of parameters
                    if (method.getParameterTypes().length == paramList.size())
                    {
                        Object[] converted = new Object[paramList.size()];

                        // Check parameter types
                        params:
                        for (int j = 0; j < method.getParameterTypes().length; j++)
                        {
                            Class paramType = method.getParameterTypes()[j];
                            String param = (String) paramList.get(j);
                            converted[j] = configuration.convertTo(paramType, param);
                            if (converted[j] == null)
                            {
                                break methods;
                            }
                        }

                        available.add(method);
                        coerced.add(converted);
                    }
                }
            }

            // Pick a method to call
            if (available.size() > 1)
            {
                Log.warn("Warning multiple matching methods. Using first match.");
            }

            Method method = null;
            Object[] params = null;

            // At the moment we are just going to take the first match, for a
            // later increment we might pack the best implementation
            if (!available.isEmpty())
            {
                method = (Method) available.get(0);
                params = (Object[]) coerced.get(0);
            }

            // Complain if there is nothing to call
            if (method == null)
            {
                StringBuffer allParams = new StringBuffer();
                for (Iterator it = paramList.iterator(); it.hasNext();)
                {
                    allParams.append(it.next());
                    if (it.hasNext())
                    {
                        allParams.append(", ");
                    }
                }

                Log.warn("Missing method " + creator.getType().getName() + "." + methodName + "("+allParams+") in url: "+req.getRequestURL()+"?"+req.getQueryString());
                doError(resp, id, "Missing method: "+creator.getType().getName()+"."+methodName+"("+allParams+");", xml);
                return;
            }

            // Create an instance
            Object object = creator.getInstance();

            // Execute
            Log.info("Executing: "+method.toString());
            Object reply = method.invoke(object, params);

            doReply(resp, id, reply, xml);
        }
        catch (Exception ex)
        {
            doError(req, resp, id, ex, xml);
        }
    }

    /**
     * @param req The browsers request
     * @param resp The response channel
     * @param id The id of the call supplied by the browser
     * @param ex The exception to report to the user
     * @param xml Are we in XMLHttpRequest mode?
     */
    private void doError(HttpServletRequest req, HttpServletResponse resp, String id, Throwable ex, boolean xml)
    {
        if (ex instanceof InvocationTargetException)
        {
            InvocationTargetException itex = (InvocationTargetException) ex;
            doError(req, resp, id, itex.getTargetException(), xml);
        }
        else
        {
            Log.warn("Error for call: "+id, ex);
            doError(resp, id, ex.toString(), xml);
        }
    }

    /**
     * @param resp The response channel
     * @param id The id of the call supplied by the browser
     * @param message The HTTP error message
     * @param xml Are we in XMLHttpRequest mode?
     */
    private void doError(HttpServletResponse resp, String id, String message, boolean xml)
    {
        Log.warn("Erroring: id[" + id + "] message[" + message + "] xml[" + xml + "]");

        try
        {
            PrintWriter out = resp.getWriter();
            String output = StringEscapeUtils.escapeJavaScript(message);

            if (xml)
            {
                resp.setContentType("text/xml");

                out.println("dwrHandleError(\"" + id + "\", \"" + output + "\");");
            }
            else
            {
                resp.setContentType("text/html");

                out.println("<script type='text/javascript'>");
                out.println("window.parent.dwrHandleError(\""+id+"\", '"+output+"')");
                out.println("</script>");
            }

            out.flush();
        }
        catch (IOException ex)
        {
            Log.error("IO error: "+id, ex);
            return;
        }
    }

    /**
     * @param resp The response channel
     * @param id The id of the call supplied by the browser
     * @param reply The object to send to Javascript land
     * @param xml Are we in XMLHttpRequest mode?
     * @throws IOException If writing to the output fails
     * @throws ConversionException If the conversion failed for some reason
     */
    private void doReply(HttpServletResponse resp, String id, Object reply, boolean xml) throws IOException, ConversionException
    {
        PrintWriter out = resp.getWriter();

        ScriptSetup ss = configuration.convertFrom(reply);
        Log.info("Returning: id[" + id + "] init[" + ss.initCode + "] assign[" + ss.assignCode + "] xml[" + xml + "]");

        // Set standard HTTP/1.1 no-cache headers.
        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        resp.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        resp.setHeader("Pragma", "no-cache");
        // Set to expire far in the past. Prevents caching at the proxy server
        resp.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");

        if (xml)
        {
            resp.setContentType("text/xml");

            out.println(ss.initCode);
            out.println("var reply = " + ss.assignCode + ";");
            out.println("dwrHandleResponse(\"" + id + "\", reply);");
        }
        else
        {
            resp.setContentType("text/html");

            out.println("<html><head><title>DWR Exec Reply</title></head><body>");
            out.println("<script type='text/javascript'>");
            out.println(ss.initCode);
            out.println("var reply = " + ss.assignCode + ";");
            out.println("window.parent.dwrHandleResponse(\"" + id + "\", reply);");
            out.println("</script>");
            out.println("</body></html>");
        }

        out.flush();
    }

    /**
     * @param req The browsers request
     * @return Is the request using XMLHttpRequest
     */
    private boolean isXMLHttpRequest(HttpServletRequest req)
    {
        return Boolean.valueOf(req.getParameter("xml")).booleanValue();
    }

    /**
     * @param req The browsers request
     * @param scriptname The name of the object in Javascript land
     * @return A URL linked to the interface Javascript for a given class
     */
    private String getInterfaceURL(HttpServletRequest req, String scriptname)
    {
        return req.getContextPath() + req.getServletPath() + "/interface/" + scriptname + ".js";
    }

    /**
     * @param req The browsers request
     * @return A URL linked to the engine Javascript
     */
    private String getEngineURL(HttpServletRequest req)
    {
        return req.getContextPath() + req.getServletPath() + "/engine.js";
    }

    /**
     * We cache the script output for speed
     */
    private Map scriptCache = new HashMap();

    /**
     * The local configuration settings
     */
    private Configuration configuration = null;
}
