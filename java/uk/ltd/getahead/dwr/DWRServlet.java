package uk.ltd.getahead.dwr;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        // The Javascript reserved words array so we don't generate illegal javascript
        if (reserved == null)
        {
            reserved = new TreeSet();
            reserved.addAll(Arrays.asList(RESERVED_ARRAY));
        }

        try
        {
            // Which classes are we allowed to communicate with?
            String allowStr = config.getInitParameter("allowed");
            if (allowStr == null)
            {
                throw new ServletException("Mising 'allowed' init-parameter");
            }
            String[] allowArray = allowStr.split(" ");
            for (int i = 0; i < allowArray.length; i++)
            {
                Class clazz = Class.forName(allowArray[i]);
                allowed.add(clazz);
            }

            // Are we in debug mode?
            String debugStr = config.getInitParameter("debug");
            debug = Boolean.valueOf(debugStr).booleanValue();
        }
        catch (Exception ex)
        {
            throw new ServletException(ex);
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
            String pathinfo = req.getPathInfo();
            if (pathinfo == null || pathinfo.length() == 0 || pathinfo.equals("/"))
            {
                doIndex(req, resp);
            }
            else if (pathinfo != null && pathinfo.matches("/engine.*"))
            {
                doEngine(req, resp);
            }
            else if (pathinfo != null && pathinfo.matches("/.*/test.*"))
            {
                doTest(req, resp);
            }
            else if (pathinfo != null && pathinfo.matches("/.*/interface.*"))
            {
                doInterface(req, resp);
            }
            else if (pathinfo != null && pathinfo.matches("/.*/exec.*"))
            {
                doExec(req, resp);
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        catch (ClassNotFoundException ex)
        {
            throw new ServletException(ex);
        }
        catch (IllegalAccessException ex)
        {
            throw new ServletException(ex);
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

        for (Iterator it = allowed.iterator(); it.hasNext();)
        {
            Class allow = (Class) it.next();
            out.println("<li><a href='"+req.getContextPath()+req.getServletPath()+"/"+allow.getName()+"/test'>"+allow.getName()+"</a></li>");
        }

        out.println("</body></html>");
        out.flush();
    }

    /**
     * @param req
     * @param resp
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    private void doTest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, IllegalAccessException
    {
        Class allow = getClass(req);
        String name = getShortClassName(allow);

        Method[] methods = allow.getDeclaredMethods();

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
        out.println("  </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("");
        out.println("<h2>Methods For: "+allow.getName()+"</h2>");
        out.println("<p>Of the "+methods.length+" declared methods, the following are usable:<ul>");

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
            if (reserved.contains(method.getName()))
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
                out.print("    <input class='itext' type='text' size='10' id='p"+i+j+"' title='"+paramTypes[j].getName()+"'/>");
                out.println(j == paramTypes.length - 1 ? "" : ", ");
            }
            out.println("  );");

            out.print("  <input class='ibutton' type='button' onclick='"+name+"."+method.getName()+"(");
            out.print("reply"+i);
            for (int j = 0; j < paramTypes.length; j++)
            {
                out.print(", document.getElementById(\"p"+i+j+"\").value");
            }
            out.println(");' value='Execute'/>");

            out.println("  <script type='text/javascript'>");
            out.println("    var reply"+i+" = function(data)");
            out.println("    {");
            out.println("      document.getElementById('d"+i+"').innerHTML = data;");
            out.println("    }");
            out.println("  </script>");
            out.println("  <span id='d"+i+"'></span>");

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
                Object coercer = coercers.get(paramTypes[j]);
                if (!paramTypes[j].isPrimitive() && coercer == null)
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
     * @throws IllegalAccessException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    private void doInterface(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, IllegalAccessException
    {
        //resp.setContentType("text/javascript");

        PrintWriter out = resp.getWriter();

        Class allow = getClass(req);
        String name = getShortClassName(allow);

        out.println();
        out.println("// Methods for: "+allow.getName());

        out.println();
        out.println(name+" = new Object();");

        Method[] methods = allow.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            Method method = methods[i];

            // Is it public
            if (!Modifier.isPublic(method.getModifiers()))
            {
                continue;
            }

            // Is it on the list of banned names
            if (reserved.contains(method.getName()))
            {
                continue;
            }

            if (i != 0)
            {
                out.print("\n");
            }
            out.print(name+"."+method.getName()+" = function(callback");
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
        //resp.setContentType("text/javascript");

        PrintWriter out = resp.getWriter();

        out.println();
        out.println("// engine.js");
        out.println("var iframe;");
        out.println("var callback;");
        out.println("var preHook;");
        out.println("var postHook;");
        out.println("");
        out.println("var errorHandler = function(data)");
        out.println("{");
        out.println("    alert(data);");
        out.println("};");
        out.println("");
        out.println("function dwrSetErrorHandler(handler)");
        out.println("{");
        out.println("    errorHandler = handler;");
        out.println("}");
        out.println("");
        out.println("function dwrPreHook(handler)");
        out.println("{");
        out.println("    preHook = handler;");
        out.println("}");
        out.println("");
        out.println("function dwrPostHook(handler)");
        out.println("{");
        out.println("    postHook = handler;");
        out.println("}");
        out.println("");
        out.println("function dwrHandleResponse(data)");
        out.println("{");
        if (!debug)
        {
            out.println("    iframe.parentNode.removeChild(iframe);");
        }
        out.println("    iframe = null;");
        out.println("    callback(data);");
        out.println("    callback = null;");
        out.println("");
        out.println("    if (postHook != null)");
        out.println("    {");
        out.println("        postHook();");
        out.println("    }");
        out.println("}");
        out.println("");
        out.println("function dwrHandleError(reason)");
        out.println("{");
        if (!debug)
        {
            out.println("    iframe.parentNode.removeChild(iframe);");
        }
        out.println("    iframe = null;");
        out.println("");
        out.println("    if (postHook != null)");
        out.println("    {");
        out.println("        postHook();");
        out.println("    }");
        out.println("");
        out.println("    if (errorHandler != null);");
        out.println("    {");
        out.println("        errorHandler(reason);");
        out.println("    }");
        out.println("}");
        out.println("");
        out.println("function dwrExecute(func, classname, methodname, vararg_params)");
        out.println("{");
        out.println("    if (iframe != null)");
        out.println("    {");
        out.println("        alert('Warning previous call did not complete, old results may be lost.');");
        out.println("    }");
        out.println("");
        out.println("    if (preHook != null)");
        out.println("    {");
        out.println("        preHook();");
        out.println("    }");
        out.println("");
        out.println("    callback = func;");
        out.println("");
        out.println("    var argdata = '';");
        out.println("    for (var i=3; i<dwrExecute.arguments.length; i++)");
        out.println("    {");
        out.println("        argdata = argdata + '&param' + (i-3) + '=' + dwrExecute.arguments[i];");
        out.println("    }");
        out.println("");
        out.println("    iframe = document.createElement('iframe');");
        out.println("    iframe.setAttribute('id', 'dwr-iframe');");
        if (debug)
        {
            out.println("    iframe.setAttribute('style', 'width:100%; height:100px; border: solid 1px black;');");
        }
        else
        {
            out.println("    iframe.setAttribute('style', 'width:0px; height:0px; border:0px;');");
        }
        out.println("    iframe.setAttribute('src', '"+req.getContextPath()+req.getServletPath()+"/'+classname+'/exec?method='+methodname+argdata);");
        out.println("    document.body.appendChild(iframe);");
        out.println("}");
        out.println("");

        out.flush();
    }

    /**
     * @param req
     * @param resp
     */
    private void doExec(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            Class clazz = getClass(req);

            String methodName = req.getParameter("method");
            if (methodName == null)
            {
                doError(resp, HttpServletResponse.SC_BAD_REQUEST, "Missing method parameter");
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
            Method[] methods = clazz.getMethods();
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
                            converted[j] = coerce(paramType, param);
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

                doError(resp, HttpServletResponse.SC_NOT_FOUND, "Missing method: "+clazz.getName()+"."+methodName+"("+allParams+");");
                return;
            }

            // At the moment we are just going to take the first match, for a
            // later increment we might pack the best implementation
            if (available.size() > 1)
            {
                log("Warning multiple matching methods. Using first match.");
            }
            Method method = (Method) available.get(0);
            Object[] converted = (Object[]) coerced.get(0);
            log("Executing: "+method.toString());

            // Execute
            Object object = clazz.newInstance();
            Object reply = method.invoke(object, converted);

            doReply(req, resp, reply);
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
            doError(resp, HttpServletResponse.SC_FORBIDDEN, getClassName(req));
        }
        catch (IllegalArgumentException ex)
        {
            ex.printStackTrace();
            doError(resp, HttpServletResponse.SC_BAD_REQUEST, "Missing class parameter");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            doError(resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Exception: "+ex);
        }
    }

    /**
     * @param req
     * @param resp
     * @param reply
     * @throws IOException
     */
    private void doReply(HttpServletRequest req, HttpServletResponse resp, Object reply) throws IOException
    {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("  <title>DWR Exec Reply</title>");
        out.println("</head>");
        out.println("<body>");

        if (reply == null)
        {
            out.println("<script type='text/javascript'>window.parent.dwrHandleResponse()</script>");
            out.println("<p>The called function returned void or null.<br/>");
        }
        else
        {
            out.println("<script type='text/javascript'>window.parent.dwrHandleResponse('"+reply+"')</script>");
            out.println("<p>The called function returned: [<span style='color:#800; font-family:monospace;'>"+reply+"</span>]<br/>");
        }

        out.println("This resulted from the query: [<span style='color:#800; font-family:monospace;'>"+req.getQueryString()+"</span>]</p>");
        out.println("<p>If you can see this then it is likely that debug is on or that something is broken. An attempt has been made to passed the reply to dwrHandleResponse() in the parent window which should delete this iframe is debug is off.</p>");

        out.println("</body>");
        out.println("</html>");

        out.flush();
    }

    /**
     * @param resp
     * @param reason
     * @param message
     */
    private void doError(HttpServletResponse resp, int reason, String message)
    {
        try
        {
            resp.setStatus(reason);
            resp.setContentType("text/html");

            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>window.parent.dwrHandleError('"+message+"')</script>");
            out.flush();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return;
        }
    }

    /**
     * Get the current classname from a request
     * @param req
     * @return The specified classname
     */
    private String getClassName(HttpServletRequest req)
    {
        String pathinfo = req.getPathInfo();
        String[] parts = pathinfo.split("/");
        return parts[1];
    }

    /**
     * Get the current class from a request
     * @param req
     * @return The specified class
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    private Class getClass(HttpServletRequest req) throws ClassNotFoundException, IllegalAccessException
    {
        String classname = getClassName(req);
        if (classname == null)
        {
            throw new IllegalArgumentException();
        }

        Class clazz = Class.forName(classname);

        if (!allowed.contains(clazz))
        {
            throw new IllegalAccessException();
        }

        return clazz;
    }

    /**
     * @param req
     * @param allow
     * @return A URL linked to the interface Javascript for a given class
     */
    private String getInterfaceURL(HttpServletRequest req, Class allow)
    {
        return req.getContextPath()+req.getServletPath()+"/"+allow.getName()+"/interface.js";
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
     * Return a short class name without the package component.
     */
    public static String getShortClassName(Class clazz)
    {
        if (clazz == null)
        {
            throw new NullPointerException("The class must not be null");
        }

        String name = clazz.getName();

        // Inner classes have $ in them. Strip out.
        name = name.replace('$', '.');

        int lastDot = name.lastIndexOf('.');
        return name.substring(lastDot+1);
    }

    /**
     *
     */
    private static Map coercers = new HashMap();
    private static Coercer[] ALL = new Coercer[]
    {
        new ConstructorCoercer(Boolean.class),
        new ConstructorCoercer(Byte.class),
        new ConstructorCoercer(Short.class),
        new ConstructorCoercer(Integer.class),
        new ConstructorCoercer(Long.class),
        new ConstructorCoercer(Float.class),
        new ConstructorCoercer(Double.class),
        new StringCoercer(),
    };

    static
    {
        for (int i = 0; i < ALL.length; i++)
        {
            Class coerceToClass = ALL[i].getCoerceToClass();

            List options = (List) coercers.get(coerceToClass);
            if (options == null)
            {
                options = new ArrayList();
                coercers.put(coerceToClass, options);
            }

            options.add(ALL[i]);
        }
    }

    /**
     * @param paramType
     * @param object
     * @return The coerced object or null if the object could not be coerced
     */
    private Object coerce(Class paramType, String object)
    {
        if (paramType.isPrimitive())
        {
            try
            {
                if (paramType == Boolean.TYPE)
                {
                    return new Boolean(object);
                }
                else if (paramType == Byte.TYPE)
                {
                    if (object.length() == 0)
                    {
                        byte b = 0;
                        return new Byte(b);
                    }
                    return new Byte(object);
                }
                else if (paramType == Short.TYPE)
                {
                    if (object.length() == 0)
                    {
                        short s = 0;
                        return new Short(s);
                    }
                    return new Short(object);
                }
                else if (paramType == Character.TYPE)
                {
                    if (object.length() == 1)
                    {
                        return new Character(object.charAt(0));
                    }
                    else
                    {
                        return null;
                    }
                }
                else if (paramType == Integer.TYPE)
                {
                    if (object.length() == 0)
                    {
                        return new Integer(0);
                    }
                    return new Integer(object);
                }
                else if (paramType == Long.TYPE)
                {
                    if (object.length() == 0)
                    {
                        return new Long(0);
                    }
                    return new Long(object);
                }
                else if (paramType == Float.TYPE)
                {
                    if (object.length() == 0)
                    {
                        return new Float(0);
                    }
                    return new Float(object);
                }
                else if (paramType == Double.TYPE)
                {
                    if (object.length() == 0)
                    {
                        return new Double(0);
                    }
                    return new Double(object);
                }

                return null;
            }
            catch (NumberFormatException ex)
            {
                return null;
            }
        }
        else
        {
            List options = (List) coercers.get(paramType);
            if (options != null)
            {
                for (Iterator ir = options.iterator(); ir.hasNext();)
                {
                    Coercer coercer = (Coercer) ir.next();
                    Object reply = coercer.coerce(object);
                    if (reply != null)
                    {
                        return reply;
                    }
                }
            }

            return null;
        }
    }

    private static SortedSet reserved = null;
    private static String[] RESERVED_ARRAY =  new String[]
    {
        // Reserved and used at ECMAScript 4
        "as", "break", "case", "catch", "class", "const", "continue", "default",
        "delete", "do", "else", "export", "extends", "false", "finally", "for",
        "function", "if", "import", "in", "instanceof", "is", "namespace",
        "new", "null", "package", "private", "public", "return", "super",
        "switch", "this", "throw", "true", "try", "typeof", "use", "var",
        "void", "while", "with",
        // Reserved for future use at ECMAScript 4
        "abstract", "debugger", "enum", "goto", "implements", "interface",
        "native", "protected", "synchronized", "throws", "transient",
        "volatile",
        // Reserved in ECMAScript 3, unreserved at 4 best to avoid anyway
        "boolean", "byte", "char", "double", "final", "float", "int", "long",
        "short", "static",
        // I have seen the folowing list as 'best avoided for function names'
        // but it seems way to all encompassing, so I'm not going to include it
        /*
        "alert", "anchor", "area", "arguments", "array", "assign", "blur",
        "boolean", "button", "callee", "caller", "captureevents", "checkbox",
        "clearinterval", "cleartimeout", "close", "closed", "confirm",
        "constructor", "date", "defaultstatus", "document", "element", "escape",
        "eval", "fileupload", "find", "focus", "form", "frame", "frames",
        "getclass", "hidden", "history", "home", "image", "infinity",
        "innerheight", "isfinite", "innerwidth", "isnan", "java", "javaarray",
        "javaclass", "javaobject", "javapackage", "length", "link", "location",
        "locationbar", "math", "menubar", "mimetype", "moveby", "moveto",
        "name", "nan", "navigate", "navigator", "netscape", "number", "object",
        "onblur", "onerror", "onfocus", "onload", "onunload", "open", "opener",
        "option", "outerheight", "outerwidth", "packages", "pagexoffset",
        "pageyoffset", "parent", "parsefloat", "parseint", "password",
        "personalbar", "plugin", "print", "prompt", "prototype", "radio", "ref",
        "regexp", "releaseevents", "reset", "resizeby", "resizeto",
        "routeevent", "scroll", "scrollbars", "scrollby", "scrollto", "select",
        "self", "setinterval", "settimeout", "status", "statusbar", "stop",
        "string", "submit", "sun", "taint",  "text", "textarea", "toolbar",
        "top", "tostring", "unescape", "untaint", "unwatch", "valueof", "watch",
        "window",
        */
    };

    /**
     * The exec properties
     */
    private Set allowed = new HashSet();

    /**
     * Are we in debug mode?
     */
    private boolean debug = false;
}
