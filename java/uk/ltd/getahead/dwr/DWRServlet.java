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
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ltd.getahead.dwr.lang.StringEscapeUtils;

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
        configuration = new Configuration(config);
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
                doEngine(req, resp);
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
        }
    }

    /**
     * @param req
     * @param resp
     * @throws IOException
     */
    private void doIndex(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>DWR Test Index</title></head>");
        out.println("<body>");
        out.println("<h2>Classes known to DWR:</h2>");

        for (Iterator it = configuration.getAllowedNames(); it.hasNext();)
        {
            AllowedClass allow = (AllowedClass) it.next();
            out.println("<li><a href='"+req.getContextPath()+req.getServletPath()+"/test/"+allow.getName()+"'>"+allow.getName()+"</a> ("+allow.getType().getName()+")</li>");
        }

        out.println("</body></html>");
        out.flush();
    }

    /**
     * @param req
     * @param resp
     * @throws IOException
     */
    private void doTest(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String pathinfo = req.getPathInfo();
        pathinfo = LocalUtil.replace(pathinfo, "/test/", "");
        pathinfo = LocalUtil.replace(pathinfo, "/", "");

        String classname = pathinfo;
        AllowedClass allow = configuration.getAllowedClass(classname);
        if (allow == null)
        {
            throw new SecurityException("No class by name: "+classname);
        }

        String name = allow.getName();
        Method[] methods = allow.getType().getDeclaredMethods();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("  <title>DWR Test</title>");
        out.println("  <script type='text/javascript' src='"+getInterfaceURL(req, allow)+"'></script>");
        out.println("  <script type='text/javascript' src='"+getEngineURL(req)+"'></script>");
        out.println("  <style>");
        out.println("    input.itext { font-size: smaller; background: #E4E4E4; border: 0; }");
        out.println("    input.ibutton { font-size: xx-small; border: 1px outset; margin: 0px; padding: 0px; }");
        out.println("    span.reply { background: #ffffdd; }");
        out.println("  </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("");
        out.println("<h2>Methods For: "+allow.getName()+" ("+allow.getType().getName()+")</h2>");
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

            String onclick = name+"."+method.getName()+"(reply"+i;
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
                if (!ConverterManager.isCoercable(paramTypes[j]))
                {
                    out.println("<span style='font-size: smaller; color: red;'>(Warning: "+paramTypes[j].getName()+" is not marshallable yet)</span>");
                }
            }

            out.println("</li>");
        }

        out.println("");
        out.println("</ul></p>");

        out.println("<h2>Other Links</h2>");
        out.println("<ul>");
        out.println("<li>Back to <a href='"+req.getContextPath()+req.getServletPath()+"'>class index</a>.</li>");
        out.println("<li>The Javascript <a href='"+getInterfaceURL(req, allow)+"'>interface</a> definition corresponding to your Java classes</li>");
        out.println("<li>The Javascript <a href='"+getEngineURL(req)+"'>engine</a> Marshalls calls to the server. Used by the interface script. This is the same for all classes.</li>");
        out.println("</ul>");

        out.println("</body></html>");
        out.flush();
    }

    /**
     * @param req
     * @param resp
     * @throws IOException
     */
    private void doInterface(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String pathinfo = req.getPathInfo();
        pathinfo = LocalUtil.replace(pathinfo, "/interface/", "");
        pathinfo = LocalUtil.replace(pathinfo, ".js", "");
        AllowedClass allow = configuration.getAllowedClass(pathinfo);
        if (allow == null)
        {
            throw new SecurityException("No class by name: "+pathinfo);
        }

        //resp.setContentType("text/javascript");
        PrintWriter out = resp.getWriter();
        out.println();
        out.println("// Methods for: "+allow.getType().getName());

        out.println();
        out.println(allow.getName()+" = new Object();");

        Method[] methods = allow.getType().getDeclaredMethods();
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
            out.print(allow.getName()+"."+method.getName()+" = function(callback");
            Class[] paramTypes = method.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                out.print(", p"+j);
            }
            out.println(")");
            out.println("{");

            out.print("    dwrExecute(callback, '"+allow.getName()+"', '"+method.getName()+"'");
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
     * @param req
     * @param resp
     * @throws IOException
     */
    private void doEngine(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/javascript");

        if (scriptCache == null)
        {
            StringBuffer buffer = new StringBuffer();

            InputStream raw = getClass().getResourceAsStream("engine.js");
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

            scriptCache = buffer.toString();
        }

        PrintWriter out = resp.getWriter();
        out.println(scriptCache);
        out.flush();
    }

    /**
     * @param req
     * @param resp
     */
    private void doExec(HttpServletRequest req, HttpServletResponse resp)
    {
        boolean xml = isXMLHttpRequest(req);

        try
        {
            String className = req.getParameter("class");
            AllowedClass allow = configuration.getAllowedClass(className);
            if (allow == null)
            {
                throw new SecurityException("No class by name: "+className);
            }

            String methodName = req.getParameter("method");
            if (methodName == null)
            {
                log("Missing method parameter in url: "+req.getRequestURL()+"?"+req.getQueryString());
                doError(req, resp, HttpServletResponse.SC_BAD_REQUEST, "Missing method parameter");
                return;
            }

            List params = new ArrayList();
            while (true)
            {
                String param = req.getParameter("param" + params.size());
                if (param == null || param.equals("undefined"))
                {
                    break;
                }
                params.add(param);
            }

            // Get a list of the available matching methods with the coerced
            // parameters that we will use to call it if we choose to use that
            // method.
            List available = new ArrayList();
            List coerced = new ArrayList();
            Method[] methods = allow.getType().getMethods();
            methods:
            for (int i = 0; i < methods.length; i++)
            {
                // Check method name and access
                Method method = methods[i];
                if (method.getName().equals(methodName))
                {
                    // Check number of parameters
                    if (method.getParameterTypes().length == params.size())
                    {
                        Object[] converted = new Object[params.size()];

                        // Check parameter types
                        params:
                        for (int j = 0; j < method.getParameterTypes().length; j++)
                        {
                            Class paramType = method.getParameterTypes()[j];
                            String param = (String) params.get(j);
                            converted[j] = ConverterManager.convertTo(paramType, param);
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

            // Check we have something to call
            if (available.size() == 0)
            {
                StringBuffer allParams = new StringBuffer();
                for (Iterator it = params.iterator(); it.hasNext();)
                {
                    allParams.append(it.next());
                    if (it.hasNext())
                    {
                        allParams.append(", ");
                    }
                }

                log("Missing method " + allow.getType().getName() + "." + methodName + "("+allParams+") in url: "+req.getRequestURL()+"?"+req.getQueryString());
                doError(req, resp, HttpServletResponse.SC_NOT_FOUND, "Missing method: "+allow.getType().getName()+"."+methodName+"("+allParams+");");
                return;
            }

            // At the moment we are just going to take the first match, for a
            // later increment we might pack the best implementation
            if (available.size() > 1)
            {
                log("Warning multiple matching methods. Using first match.");
            }

            Method method = (Method) available.get(0);

            // Create an instance if the method is not static
            Object object = null;
            if (!Modifier.isStatic(method.getModifiers()))
            {
                object = allow.getInstance();
            }

            // Parameters
            Object[] converted = (Object[]) coerced.get(0);

            // Execute
            log("Executing: "+method.toString());
            Object reply = method.invoke(object, converted);

            doReply(req, resp, reply, xml);
        }
        catch (Exception ex)
        {
            doError(req, resp, ex, xml);
        }
    }

    /**
     * @param req
     * @param resp
     * @param ex
     * @param xml
     */
    private void doError(HttpServletRequest req, HttpServletResponse resp, Throwable ex, boolean xml)
    {
        if (ex instanceof InvocationTargetException)
        {
            InvocationTargetException itex = (InvocationTargetException) ex;
            doError(req, resp, itex.getTargetException(), xml);
        }
        else
        {
            ex.printStackTrace();
            doError(req, resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Exception: "+ex);
        }
    }

    /**
     * @param req
     * @param resp
     * @param reason
     * @param message
     */
    private void doError(HttpServletRequest req, HttpServletResponse resp, int reason, String message)
    {
        boolean xml = isXMLHttpRequest(req);

        try
        {
            PrintWriter out = resp.getWriter();
            resp.setStatus(reason);

            if (xml)
            {
                resp.setContentType("text/xml");
                out.println(message);
            }
            else
            {
                resp.setContentType("text/html");
                String output = StringEscapeUtils.escapeJavaScript(message);
                out.println("<script type='text/javascript'>window.parent.dwrHandleError('"+output+"')</script>");
            }

            out.flush();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return;
        }
    }

    /**
     * @param req
     * @param resp
     * @param reply
     * @param xml
     * @throws IOException
     */
    private void doReply(HttpServletRequest req, HttpServletResponse resp, Object reply, boolean xml) throws IOException
    {
        PrintWriter out = resp.getWriter();

        String output = null;
        if (reply != null)
        {
            output = StringEscapeUtils.escapeJavaScript(reply.toString());
        }

        if (xml)
        {
            resp.setContentType("text/xml");

            // Set standard HTTP/1.1 no-cache headers.
            resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

            // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
            resp.addHeader("Cache-Control", "post-check=0, pre-check=0");

            // Set standard HTTP/1.0 no-cache header.
            resp.setHeader("Pragma", "no-cache");

            // Set to expire far in the past. Prevents caching at the proxy server
            resp.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");

            if (reply == null)
            {
                out.println("");
            }
            else
            {
                out.println(output);
            }
        }
        else
        {
            resp.setContentType("text/html");

            out.println("<html><head><title>DWR Exec Reply</title></head><body>");
            out.println("<script type='text/javascript'>window.parent.dwrHandleResponse('" + output + "')</script>");

            if (configuration.isDebugMode())
            {
                out.println("This resulted from the query: [<span style='color:#800; font-family:monospace;'>"+req.getQueryString()+"</span>]</p>");
                out.println("<p>If you can see this then it is likely that debug is on or that something is broken. An attempt has been made to passed the reply to dwrHandleResponse() in the parent window which should delete this iframe is debug is off.</p>");
            }

            out.println("</body></html>");
        }

        out.flush();
    }

    /**
     * @param req
     * @return Is the request using XMLHttpRequest
     */
    private boolean isXMLHttpRequest(HttpServletRequest req)
    {
        return Boolean.valueOf(req.getParameter("xml")).booleanValue();
    }

    /**
     * @param req
     * @param allow
     * @return A URL linked to the interface Javascript for a given class
     */
    private String getInterfaceURL(HttpServletRequest req, AllowedClass allow)
    {
        return req.getContextPath() + req.getServletPath() + "/interface/" + allow.getName() + ".js";
    }

    /**
     * @param req
     * @return A URL linked to the engine Javascript
     */
    private String getEngineURL(HttpServletRequest req)
    {
        return req.getContextPath() + req.getServletPath() + "/engine.js";
    }

    /**
     * We cache the script output for speed
     */
    private String scriptCache = null;

    /**
     * The local configuration settings
     */
    private Configuration configuration = null;
}
