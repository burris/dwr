package uk.ltd.getahead.dwr;

/**
 * Various utilities, mostly to make up for JDK 1.4 functionallity that is not
 * in JDK 1.3
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class LocalUtil
{
    /**
     * Prevent instansiation
     */
    private LocalUtil()
    {
    }

    /**
     * Replacement for String#replaceAll(String, String) in JDK 1.4+
     * @param text source text
     * @param repl the stuff to get rid of
     * @param with the stuff to replace it with
     * @return replaced text or null if any args are null
     */
    public static String replace(String text, String repl, String with)
    {
        if (text == null || repl == null || with == null || repl.length() == 0)
        {
            return text;
        }
    
        StringBuffer buf = new StringBuffer(text.length());
        int searchFrom = 0;
        while (true)
        {
            int foundAt = text.indexOf(repl, searchFrom);
            if (foundAt == -1)
            {
                break;
            }
    
            buf.append(text.substring(searchFrom, foundAt)).append(with);
            searchFrom = foundAt + repl.length();
        }
        buf.append(text.substring(searchFrom));
    
        return buf.toString();
    }

    /**
     * Escape a string to make it Javascript friendly.
     * i.e replace ', " and \ with escaped versions of themselves
     * @param input The string to be escaped
     * @return An escapsed version of the string
     */
    protected static String escape(String input)
    {
        input = replace(input, "\'", "\\\\'");
        input = replace(input, "\"", "\\\\\"");
        input = replace(input, "\\", "\\\\\\");
        input = replace(input, "\t", "\\\\t");
        input = replace(input, "\r", "\\\\r");
        input = replace(input, "\n", "\\\\n");
        input = replace(input, "\f", "\\\\f");
    
        return input;
    }

    /**
     * Return a short class name without the package component.
     * @param clazz  The class to simplfy the name of
     * @return A short version of the class name
     */
    protected static String getShortClassName(Class clazz)
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
}
