package uk.ltd.getahead.dwr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import uk.ltd.getahead.dwr.util.LocalUtil;

/**
 * The Configuration class has responsibility for reading all config data from
 * web.xml and dwr.xml
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Configuration
{
    /**
     * Examine the current configuration
     * @param debug Are we in debug mode?
     */
    public Configuration(boolean debug)
    {
        // The Javascript reserved words array so we don't generate illegal javascript
        if (reserved == null)
        {
            reserved = new TreeSet();
            reserved.addAll(Arrays.asList(RESERVED_ARRAY));
        }

        this.debug = debug;
    }

    /**
     * @param in The InputStream to parse from
     * @throws FactoryConfigurationError
     * @throws SAXException 
     */
    public void addConfig(InputStream in) throws SAXException
    {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setEntityResolver(new DTDEntityResolver());
            Document doc = db.parse(in);

            addConfig(doc);
        }
        catch (ParserConfigurationException ex)
        {
            throw new SAXException("Parser exception", ex);
        }
        catch (IOException ex)
        {
            throw new SAXException("IO Error reading from dwr.xml", ex);
        }
    }

    /**
     * @param doc
     * @throws SAXException
     */
    public void addConfig(Document doc) throws SAXException
    {
        Element root = doc.getDocumentElement();
        NodeList rootChildren = root.getChildNodes();
        for (int i=0; i<rootChildren.getLength(); i++)
        {
            Node node = rootChildren.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element child = (Element) node;

                if (child.getNodeName().equals("init"))
                {
                    loadInits(child);
                }
                else if (child.getNodeName().equals("allow"))
                {
                    loadAllows(child);
                }
            }
        }
    }

    /**
     * @param child
     * @throws SAXException
     */
    private void loadInits(Element child) throws SAXException
    {
        NodeList inits = child.getChildNodes();
        for (int j=0; j<inits.getLength(); j++)
        {
            if (inits.item(j).getNodeType() == Node.ELEMENT_NODE)
            {
                Element initer = (Element) inits.item(j);

                if (initer.getNodeName().equals("creator"))
                {
                    loadCreator(initer);
                }
                else if (initer.getNodeName().equals("converter"))
                {
                    loadConverter(initer);
                }
            }
        }
    }

    /**
     * @param initer
     * @throws SAXException
     */
    private void loadCreator(Element initer) throws SAXException
    {
        String id = initer.getAttribute("id");
        String classname = initer.getAttribute("class");

        try
        {
            Class clazz = Class.forName(classname);
            creatorTypes.put(id, clazz);
        }
        catch (ClassNotFoundException ex)
        {
            throw new SAXException("Failed to find class: "+classname+", for creator with id="+id, ex);
        }
    }

    /**
     * @param initer
     * @throws SAXException
     */
    private void loadConverter(Element initer) throws SAXException
    {
        String id = initer.getAttribute("id");
        String classname = initer.getAttribute("class");

        try
        {
            Class clazz = Class.forName(classname);
            converterTypes.put(id, clazz);
        }
        catch (ClassNotFoundException ex)
        {
            throw new SAXException("Failed to find class: " + classname + ", for converter with id=" + id, ex);
        }
    }

    /**
     * @param child
     * @throws SAXException 
     */
    private void loadAllows(Element child) throws SAXException
    {
        NodeList allows = child.getChildNodes();
        for (int j=0; j<allows.getLength(); j++)
        {
            if (allows.item(j).getNodeType() == Node.ELEMENT_NODE)
            {
                Element allower = (Element) allows.item(j);
                if (allower.getNodeName().equals("create"))
                {
                    loadCreate(allower);
                }
                else if (allower.getNodeName().equals("convert"))
                {
                    loadConvert(allower);
                }
            }
        }
    }

    /**
     * @param allower
     * @throws SAXException 
     */
    private void loadConvert(Element allower) throws SAXException
    {
        String match = allower.getAttribute("match");
        String type = allower.getAttribute("converter");
        Class clazz = (Class) converterTypes.get(type);
        if (clazz == null)
        {
            throw new SAXException("Unknown converter called: "+type);
        }

        try
        {
            Converter converter = (Converter) clazz.newInstance();
            converter.init(this);

            converters.put(match, converter);
        }
        catch (Exception ex)
        {
            throw new SAXException("Error instansiating: "+clazz.getName(), ex);
        }
    }

    /**
     * @param allower
     * @throws SAXException
     */
    private void loadCreate(Element allower) throws SAXException
    {
        String type = allower.getAttribute("creator");
        String javascript = allower.getAttribute("javascript");
        Class clazz = (Class) creatorTypes.get(type);

        try
        {
            Creator creator = (Creator) clazz.newInstance();
            creator.init(allower);

            creators.put(javascript, creator);
        }
        catch (Exception ex)
        {
            throw new SAXException("Error instansiating: "+clazz.getName(), ex);
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
     * Get a list of the javascript names of the allowed creators.
     * This method could be seen as a security risk because it could allow an
     * attacker to find out extra information about your system so it is only
     * available if debug is turned on.
     * @return Loop over all the known allowed classes
     */
    protected Collection getCreatorNames()
    {
        if (!debug)
        {
            throw new SecurityException();
        }

        return Collections.unmodifiableSet(creators.keySet());
    }

    /**
     * Find an <code>Creator</code> by name
     * @param name The name to lookup against
     * @return The found Creator instance, or null if none was found.
     */
    public Creator getCreator(String name)
    {
        return (Creator) creators.get(name);
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
     * Check if we can coerce the given type
     * @param paramType The type to check
     * @return true iff <code>paramType</code> is coercable
     */
    public boolean isConvertable(Class paramType)
    {
        return getConverter(paramType) != null;
    }

    /**
     * Convert an object into a Javavscript representation of the same
     * @param object The object to convert
     * @return A Javascript string version of the object
     * @throws ConversionException If the conversion failed for some reason
     */
    public Converter.ScriptSetup convertFrom(Object object) throws ConversionException
    {
        Converter converter = getConverter(object);
        if (converter == null)
        {
            return null;
        }

        return converter.convertFrom(object);
    }

    /**
     * Convert an object from being a string into an object of some type
     * @param paramType The type that you want the object to be
     * @param object The string version of the object
     * @return The coerced object or null if the object could not be coerced
     * @throws ConversionException If the conversion failed for some reason
     */
    public Object convertTo(Class paramType, String object) throws ConversionException
    {
        Converter converter = getConverter(paramType);

        if (converter == null)
        {
            return null;
        }

        return converter.convertTo(paramType, object);
    }

    /**
     * Like <code>getConverter(object.getClass());</code> except that since the
     * object can be null we check for that fist and then do a lookup against
     * the <code>Void.TYPE</code> converter
     * @param object The object to find a converter for
     * @return The converter for the given type
     */
    private Converter getConverter(Object object)
    {
        if (object == null)
        {
            return getConverter(Void.TYPE);
        }

        return getConverter(object.getClass());
    }

    /**
     * @param paramType The type to find a converter for
     * @return The converter for the given type
     */
    public Converter getConverter(Class paramType)
    {
        String lookup = paramType.getName();

        // We first check for exact matches using instanceof
        Converter converter = null;
        for (Iterator it = converters.keySet().iterator(); it.hasNext(); )
        {
            String name = (String) it.next();
            try
            {
                Class clazz = Class.forName(name);

                if (LocalUtil.isEquivalent(clazz, paramType) || clazz.isAssignableFrom(paramType))
                {
                    converter = (Converter) converters.get(name);
                }
            }
            catch (Exception ex)
            {
                // Do nothing, having * in the classname is legitimate
            }
        }

        while (converter == null)
        {
            // Strip of the component after the last .
            int lastdot = lookup.lastIndexOf('.');
            if (lastdot == -1)
            {
                // Cope with arrays
                if (lookup.startsWith("["))
                {
                    lastdot = 2;
                }
                else
                {
                    // bail if no more dots and not an array
                    break;
                }
            }
            lookup = lookup.substring(0, lastdot);

            converter = (Converter) converters.get(lookup+".*");
            if (converter == null)
            {
                converter = (Converter) converters.get(lookup+"*");
            }
        }

        return converter;
    }

    /**
     * The list of the available creators
     */
    private Map creatorTypes = new HashMap();

    /**
     * The list of the available converters
     */
    private Map converterTypes = new HashMap();

    /**
     * The list of the configured creators
     */
    private Map creators = new HashMap();

    /**
     * The list of the configured converters
     */
    private Map converters = new HashMap();

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
