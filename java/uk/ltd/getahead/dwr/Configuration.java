package uk.ltd.getahead.dwr;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * The Configuration class has responsibility for reading all config data from
 * web.xml and dwr.xml
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Configuration
{
    /**
     * Examine the current configuration
     * @param config
     * @throws ServletException 
     */
    public Configuration(ServletConfig config) throws ServletException
    {
        // The Javascript reserved words array so we don't generate illegal javascript
        if (reserved == null)
        {
            reserved = new TreeSet();
            reserved.addAll(Arrays.asList(RESERVED_ARRAY));
        }

        // Are we in debug mode?
        String debugStr = config.getInitParameter("debug");
        debug = Boolean.valueOf(debugStr).booleanValue();

        readXMLConfiguration(config);
    }

    /**
     * @param config
     * @throws FactoryConfigurationError
     * @throws ServletException
     */
    void readXMLConfiguration(ServletConfig config) throws FactoryConfigurationError, ServletException
    {
        try
        {
            InputStream in = config.getServletContext().getResourceAsStream("WEB-INF/dwr.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setEntityResolver(new DTDEntityResolver());
            Document doc = db.parse(in);

            Element root = doc.getDocumentElement();
            NodeList rootChildren = root.getChildNodes();
            for (int i=0; i<rootChildren.getLength(); i++)
            {
                Node node = rootChildren.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element child = (Element) node;

                    if (child.getNodeName().equals("new"))
                    {
                        String id = child.getAttribute("id");
                        String className = child.getAttribute("class");

                        Class clazz = Class.forName(className);
                        allowed.put(id, new NewAllowedClass(clazz, id));
                    }
                    else if (child.getNodeName().equals("session"))
                    {
                        String id = child.getAttribute("id");
                        String className = child.getAttribute("class");

                        Class clazz = Class.forName(className);
                        allowed.put(id, new SessionAllowedClass(clazz, id));
                    }
                    else if (child.getNodeName().equals("spring"))
                    {
                        String id = child.getAttribute("id");
                        String beanName = child.getAttribute("beanName");

                        allowed.put(id, new SpringAllowedClass(id, beanName));
                    }
                }
            }
        }
        catch (MalformedURLException ex)
        {
            throw new ServletException("Mising 'dwr.xml' file");
        }
        catch (ParserConfigurationException ex)
        {
            ex.printStackTrace();
            throw new ServletException("Parser configuration error", ex);
        }
        catch (SAXException ex)
        {
            ex.printStackTrace();
            throw new ServletException("Parse error reading from dwr.xml", ex);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            throw new ServletException("IO Error reading from dwr.xml", ex);
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new ServletException("Class not found", ex);
        }
    }

    /**
     * Are we in debug mode?
     * @return true if the debug switch is on in web.xml
     */
    public boolean isDebugMode()
    {
        return debug;
    }

    /**
     * Dig around in the complete list of known allowed classes.
     * This method could be seen as a security risk because it could allow an
     * attacker to find out extra information about your system so it is only
     * available if debug is turned on.
     * @return Loop over all the known allowed classes
     */
    protected Iterator getAllowedNames()
    {
        if (!debug)
        {
            throw new SecurityException();
        }

        return allowed.values().iterator();
    }

    /**
     * Find an <code>AllowedClass</code> by name
     * @param name The name to lookup against
     * @return The found AllowedClass instance, or null if none was found.
     */
    public AllowedClass getAllowedClass(String name)
    {
        return (AllowedClass) allowed.get(name);
    }

    /**
     * Check to see if the given word is reserved or a bad idea in any known
     * version of JavaScript.
     * @param name The word to check
     * @return false if the word is not reserved
     */
    public boolean isReservedWord(String name)
    {
        return reserved.contains(name);
    }

    /**
     * The exec properties
     */
    private Map allowed = new TreeMap();

    /**
     * Are we in debug mode?
     */
    private boolean debug = false;

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
}
