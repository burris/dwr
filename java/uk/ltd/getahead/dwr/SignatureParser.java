package uk.ltd.getahead.dwr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import uk.ltd.getahead.dwr.util.Logger;

/**
 * A parser for type info in a dwr.xml signature.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class SignatureParser
{
    /**
     * @param converterManager
     */
    public SignatureParser(ConverterManager converterManager)
    {
        this.converterManager = converterManager;
        packageImports.add("java.lang"); //$NON-NLS-1$
    }

    /**
     * Parse some text and add it into the converter manager.
     * @param sigtext The text to parse
     */
    public void parse(String sigtext)
    {
        try
        {
            String process = stripComments(sigtext);
    
            process = process.replace('\n', ' ');
            process = process.replace('\r', ' ');
            process = process.replace('\t', ' ');
    
            StringTokenizer st = new StringTokenizer(process, ";"); //$NON-NLS-1$
            while (st.hasMoreTokens())
            {
                String line = st.nextToken();
                line = line.trim();
                if (line.length() == 0)
                {
                    continue;
                }
    
                if (line.startsWith("import ")) //$NON-NLS-1$
                {
                    parseImportLine(line);
                }
                else
                {
                    parseDeclarationLine(line);
                }
            }
        }
        catch (Exception ex)
        {
            log.error("Unexpected Error", ex); //$NON-NLS-1$
        }
    }

    /**
     * Parse a single import line
     * @param line The import statement
     */
    private void parseImportLine(String line)
    {
        String shortcut = line.substring(7, line.length());
        shortcut = shortcut.trim();
        
        if (line.endsWith(".*")) //$NON-NLS-1$
        {
            shortcut = shortcut.substring(0, shortcut.length() - 2);
            packageImports.add(shortcut);
        }
        else
        {
            int lastDot = line.lastIndexOf('.');
            if (lastDot == -1)
            {
                log.error("Missing . from import statement: " + line); //$NON-NLS-1$
                return;
            }
            
            String leaf = line.substring(lastDot + 1);
            classImports.put(leaf, shortcut);
        }
    }

    /**
     * Parse a single declaration line.
     * Where line is defined as being everything in between 2 ; chars.
     * @param line The line to parse
     */
    private void parseDeclarationLine(String line)
    {
        int openBrace = line.indexOf('(');
        int closeBrace = line.indexOf(')');

        if (openBrace == -1)
        {
            log.error("Missing ( in declaration: " + line); //$NON-NLS-1$
            return;
        }

        if (closeBrace == -1)
        {
            log.error("Missing ) in declaration: " + line); //$NON-NLS-1$
            return;
        }

        if (openBrace > closeBrace)
        {
            log.error("( Must come before ) in declaration: " + line); //$NON-NLS-1$
            return;
        }

        // Class name and method name come before the opening (
        String classMethod = line.substring(0, openBrace).trim();

        Method method = findMethod(classMethod);
        if (method == null)
        {
            // Assume debug has already be done.
            return;
        }

        // Now we need to get a list of all the parameters
        String paramDecl = line.substring(openBrace + 1, closeBrace);
        String[] paramNames = split(paramDecl);
        for (int i = 0; i < paramNames.length; i++)
        {
            String[] genericList = getGenericParameterTypeList(paramNames[i]);
            for (int j = 0; j < genericList.length; j++)
            {
                String type = genericList[j].trim();
                Class clazz = findClass(type);

                if (clazz != null)
                {
                    converterManager.setExtraTypeInfo(method, i, j, clazz);
                }
            }
        }
    }

    /**
     * Lookup a class acording to the import rules
     * @param type The name of the class to find
     * @return The found class, or null if it does not exist
     */
    private Class findClass(String type)
    {
        Class reply = null;

        try
        {
            String full = (String) classImports.get(type);
            if (full == null)
            {
                full = type;
            }

            reply = Class.forName(full);
            return reply;
        }
        catch (Exception ex)
        {
            log.debug("Trying to find class in package imports"); //$NON-NLS-1$
        }

        for (Iterator it = packageImports.iterator(); it.hasNext();)
        {
            String pkg = (String) it.next();
            String lookup = pkg + "." + type; //$NON-NLS-1$
            
            try
            {
                reply = Class.forName(lookup);
                return reply;
            }
            catch (Exception ex)
            {
                log.debug("Not found: " + lookup); //$NON-NLS-1$
            }
        }

        log.error("Failed to find class: " + type); //$NON-NLS-1$
        return null;
    }

    /**
     * Convert a parameter like "Map&lt;Integer, URL&gt;" into an array,
     * something like [Integer, URL]. 
     * @param paramName The parameter declaration string
     * @return The array of generic types as strings
     */
    private String[] getGenericParameterTypeList(String paramName)
    {
        int openGeneric = paramName.indexOf('<');
        if (openGeneric == -1)
        {
            log.debug("No < in paramter declaration: " + paramName); //$NON-NLS-1$
            return new String[0];
        }

        int closeGeneric = paramName.lastIndexOf('>');
        if (closeGeneric == -1)
        {
            log.error("Missing > in generic declaration: " + paramName); //$NON-NLS-1$
            return new String[0];
        }

        String generics = paramName.substring(openGeneric + 1, closeGeneric);
        StringTokenizer st = new StringTokenizer(generics, ","); //$NON-NLS-1$
        String[] types = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens())
        {
            String param = st.nextToken();
            types[i++] = param;
        }

        return types;
    }

    /**
     * Find a method from the declaration string
     * @param classMethod The declaration that comes before the (
     * @return The found method, or null if one was not found.
     */
    private Method findMethod(String classMethod)
    {
        // If there is a return type then it must be before the last space.
        int lastSpace = classMethod.lastIndexOf(' ');
        if (lastSpace >= 0)
        {
            classMethod = classMethod.substring(lastSpace, classMethod.length() - 1);
        }

        // The method name comes after the last .
        int lastDot = classMethod.lastIndexOf('.');
        if (lastDot == -1)
        {
            log.error("Missing . to separate class name and method: " + classMethod); //$NON-NLS-1$
            return null;
        }

        String className = classMethod.substring(0, lastDot);
        String methodName = classMethod.substring(lastDot + 1);

        Class clazz = findClass(className);
        if (clazz == null)
        {
            return null;
        }

        Method method = null;
        Method[] methods = clazz.getMethods();
        for (int j = 0; j < methods.length; j++)
        {
            Method test = methods[j];
            if (test.getName().equals(methodName))
            {
                if (method == null)
                {
                    method = test;
                }
                else
                {
                    log.warn("Setting extra type info to overloaded methods may fail with <parameter .../>"); //$NON-NLS-1$
                }
            }
        }

        if (method == null)
        {
            log.error("Unable to find method called: " + methodName + " on type: " + clazz.getName()); //$NON-NLS-1$ //$NON-NLS-2$
        }

        return method;
    }

    /**
     * Chop a parameter declaration string into separate parameters
     * @param paramDecl The full set of parameter declarations
     * @return An array of found parameters
     */
    private String[] split(String paramDecl)
    {
        List params = new ArrayList();

        boolean inGeneric = false;
        int start = 0;
        for (int i = 0; i < paramDecl.length(); i++)
        {
            char c = paramDecl.charAt(i);
            if (c == '<')
            {
                if (inGeneric)
                {
                    log.error("Found < while parsing generic section: " + paramDecl); //$NON-NLS-1$
                    break;
                }

                inGeneric = true;
            }

            if (c == '>')
            {
                if (!inGeneric)
                {
                    log.error("Found > while not parsing generic section: " + paramDecl); //$NON-NLS-1$
                    break;
                }

                inGeneric = false;
            }

            if (!inGeneric && c == ',')
            {
                // This is the start of a new parameter
                String param = paramDecl.substring(start, i);
                params.add(param);
                start = i  + 1;
            }
        }

        // An add in the bit at the end:
        String param = paramDecl.substring(start, paramDecl.length());
        params.add(param);

        return (String[]) params.toArray(new String[params.size()]);
    }

    /**
     * Remove all the single and multi-line comments from a block of text
     * @param text The text to remove comments from
     * @return The comment free text
     */
    public static String stripComments(String text)
    {
        String reply = stripMultiLineComments(text);
        reply = stripSingleLineComments(reply);
        return reply;
    }

    /**
     * Remove all the single-line comments from a block of text
     * @param text The text to remove single-line comments from
     * @return The single-line comment free text
     */
    public static String stripSingleLineComments(String text)
    {
        try
        {
            StringBuffer output = new StringBuffer();

            // First we strip multi line comments. I think this is important:
            BufferedReader in = new BufferedReader(new StringReader(text));
            while (true)
            {
                String line = in.readLine();
                if (line == null)
                {
                    break;
                }

                int cstart = line.indexOf(COMMENT_SL_START);
                if (cstart >= 0)
                {
                    line = line.substring(0, cstart);
                }

                output.append(line);
                output.append('\n');
            }

            return output.toString();
        }
        catch (IOException ex)
        {
            log.error("IOExecption unexpected.", ex); //$NON-NLS-1$
            throw new IllegalArgumentException("IOExecption unexpected."); //$NON-NLS-1$
        }
    }

    /**
     * Remove all the multi-line comments from a block of text
     * @param text The text to remove multi-line comments from
     * @return The multi-line comment free text
     */
    public static String stripMultiLineComments(String text)
    {
        try
        {
            StringBuffer output = new StringBuffer();

            // Comment rules:
            /*/           This is still a comment
            /* /* */      // Comments do not nest
            // /* */      This is in a comment
            /* // */      // The second // is needed to make this a comment.

            // First we strip multi line comments. I think this is important:
            boolean inMultiLine = false;
            BufferedReader in = new BufferedReader(new StringReader(text));
            while (true)
            {
                String line = in.readLine();
                if (line == null)
                {
                    break;
                }

                if (!inMultiLine)
                {
                    // We are not in a multi-line comment, check for a start
                    int cstart = line.indexOf(COMMENT_ML_START);
                    if (cstart >= 0)
                    {
                        // This could be a MLC on one line ...
                        int cend = line.indexOf(COMMENT_ML_END, cstart + COMMENT_ML_START.length());
                        if (cend >= 0)
                        {
                            // A comment that starts and ends on one line
                            // BUG: you can have more than 1 multi-line comment on a line
                            line = line.substring(0, cstart) + SPACE + line.substring(cend);
                        }
                        else
                        {
                            // A real multi-line comment 
                            inMultiLine = true;
                            line = line.substring(0, cstart) + SPACE;
                        }
                    }
                    else
                    {
                        // We are not in a multi line comment and we havn't
                        // started one so we are going to ignore closing
                        // comments even if they exist.
                    }
                }
                else
                {
                    // We are in a multi-line comment, check for the end
                    int cend = line.indexOf(COMMENT_ML_END);
                    if (cend >= 0)
                    {
                        // End of comment
                        line = line.substring(cend + COMMENT_ML_END.length());
                        inMultiLine = false;
                    }
                    else
                    {
                        // The comment continues
                        line = SPACE;
                    }
                }

                output.append(line);
                output.append('\n');
            }

            return output.toString();
        }
        catch (IOException ex)
        {
            log.error("IOExecption unexpected.", ex); //$NON-NLS-1$
            throw new IllegalArgumentException("IOExecption unexpected."); //$NON-NLS-1$
        }
    }

    private static final String SPACE = " "; //$NON-NLS-1$

    private static final String COMMENT_ML_START = "/*"; //$NON-NLS-1$

    private static final String COMMENT_ML_END = "*/"; //$NON-NLS-1$

    private static final String COMMENT_SL_START = "//"; //$NON-NLS-1$

    private Map classImports = new HashMap();
    
    private List packageImports = new ArrayList();

    /**
     * Having understood the extra type info we add it in here.
     */
    private ConverterManager converterManager;

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(SignatureParser.class);
}
