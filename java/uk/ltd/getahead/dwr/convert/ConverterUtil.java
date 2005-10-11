package uk.ltd.getahead.dwr.convert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.util.JavascriptUtil;
import uk.ltd.getahead.dwr.util.LocalUtil;

/**
 * A collection of utilities that are useful to more than one Converter
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ConverterUtil
{
    /**
     * Generate an array declaration for a list of Outbound variables
     * @param ov The OutboundVariable to declare
     * @param ovs The list of contents of this array
     */
    public static void addListInit(OutboundVariable ov, List ovs)
    {
        // First we output all the init code
        StringBuffer buffer = new StringBuffer();
        for (Iterator it = ovs.iterator(); it.hasNext();)
        {
            OutboundVariable nested = (OutboundVariable) it.next();
            buffer.append(nested.getInitCode());
        }
    
        // If we have an array which contains itself we need declare it later
        // so we collect the positions at which the array contains itself
        List recurse = new ArrayList();
    
        String assignCode = ov.getAssignCode();
    
        // Declare the non-recursive parts to the list
        buffer.append("var "); //$NON-NLS-1$
        buffer.append(assignCode);
        buffer.append("=["); //$NON-NLS-1$
        boolean first = true;
        int i = 0;
        for (Iterator it = ovs.iterator(); it.hasNext();)
        {
            OutboundVariable nested = (OutboundVariable) it.next();
    
            if (nested.getAssignCode() == assignCode)
            {
                recurse.add(new Integer(i));
            }
            else
            {
                if (!first)
                {
                    buffer.append(',');
                }
    
                buffer.append(nested.getAssignCode());
                first = false;
            }
    
            i++;
        }
        buffer.append("];\r\n"); //$NON-NLS-1$
    
        // And now the recursive parts
        if (!recurse.isEmpty())
        {
            for (Iterator it = recurse.iterator(); it.hasNext();)
            {
                Integer loop = (Integer) it.next();
                buffer.append(assignCode);
                buffer.append('[');
                buffer.append(loop);
                buffer.append("]="); //$NON-NLS-1$
                buffer.append(assignCode);
                buffer.append(';'); //$NON-NLS-1$
            }
            buffer.append("\r\n"); //$NON-NLS-1$
        }
    
        ov.setInitCode(buffer.toString());
    }

    /**
     * Generate an map declaration for a map of Outbound variables
     * @param ov The OutboundVariable to declare
     * @param ovs The map of the converted contents
     */
    public static void addMapInit(OutboundVariable ov, Map ovs)
    {
        String varname = ov.getAssignCode();

        StringBuffer buffer = new StringBuffer();

        // Make sure the nested things are declared
        for (Iterator it = ovs.values().iterator(); it.hasNext();)
        {
            OutboundVariable nested = (OutboundVariable) it.next();
            buffer.append(nested.getInitCode());
        }

        // First loop through is for the stuff we can embed
        buffer.append("var "); //$NON-NLS-1$
        buffer.append(varname);
        buffer.append("={"); //$NON-NLS-1$

        // And now declare our stuff
        boolean first = true;
        for (Iterator it = ovs.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            String name = (String) entry.getKey();
            OutboundVariable nested = (OutboundVariable) entry.getValue();

            String assignCode = nested.getAssignCode();

            // The compact JSON style syntax is only any good for simple names
            // and when we are not recursive
            if (LocalUtil.isSimpleName(name) && !assignCode.equals(varname))
            {
                if (!first)
                {
                    buffer.append(',');
                }

                buffer.append(name);
                buffer.append(':');
                buffer.append(assignCode);

                // we don't need to do this one the hard way
                it.remove();

                first = false;
            }
        }
        buffer.append("};"); //$NON-NLS-1$

        // The next loop through is for everything that will not embed
        for (Iterator it = ovs.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            String name = (String) entry.getKey();
            OutboundVariable nested = (OutboundVariable) entry.getValue();

//            buffer.append(varname);
//            buffer.append('.');
//            buffer.append(name);
//            buffer.append('=');
//            buffer.append(nested.getAssignCode());
//            buffer.append(';');

            buffer.append(varname);
            buffer.append("['"); //$NON-NLS-1$
            buffer.append(name);
            buffer.append("']="); //$NON-NLS-1$
            buffer.append(nested.getAssignCode());
            buffer.append(';');
        }

        buffer.append("\r\n"); //$NON-NLS-1$

        ov.setInitCode(buffer.toString());
    }

    /**
     * Generate a string declaration from a Java string. This includes deciding
     * to inline the string if it is too short, or splitting it up if it is too
     * long.
     * @param output The Java string to convert
     * @param outctx The conversion context.
     * @return The converted OutboundVariable
     */
    public static OutboundVariable addStringInit(String output, OutboundContext outctx)
    {
        String escaped = jsutil.escapeJavaScript(output);

        // For short strings inline them
        if (escaped.length() < INLINE_LENGTH)
        {
            return new OutboundVariable("", '\"' + escaped + '\"'); //$NON-NLS-1$
        }

        // For medium length strings do it in a separate variable
        if (escaped.length() < WRAP_LENGTH)
        {
            OutboundVariable ov = outctx.createOutboundVariable(output);
            String varname = ov.getAssignCode();
            ov.setInitCode("var " + varname + "=\"" + escaped + "\";\r\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return ov;
        }

        // For very long strings chop up the init into several parts
        OutboundVariable ov = outctx.createOutboundVariable(output);
        String varname = ov.getAssignCode();

        StringBuffer initBody = new StringBuffer();
        StringBuffer initEnd = new StringBuffer();

        initEnd.append("var "); //$NON-NLS-1$
        initEnd.append(varname);
        initEnd.append('=');

        int start = 0;
        while (start < escaped.length())
        {
            String tempvar = outctx.getNextVariableName();

            boolean last = false;
            int end = start + WRAP_LENGTH;
            if (end > escaped.length())
            {
                last = true;
                end = escaped.length();
            }

            // If the last char is a \ then there is a chance of breaking
            // an escape so we increment until the last char in not a \
            // There is a potential bug here where the input string contains
            // only escaped slashes (\\) in which case we will end up not
            // breaking the string. Since this whole thing is a workaround
            // and the solution is complex we are going to pass on it now.
            while (!last && escaped.charAt(end - 1) == '\\' && end < escaped.length())
            {
                end++;
            }

            initBody.append("var "); //$NON-NLS-1$
            initBody.append(tempvar);
            initBody.append("=\""); //$NON-NLS-1$
            initBody.append(escaped.substring(start, end));
            initBody.append("\";\r\n"); //$NON-NLS-1$

            initEnd.append(tempvar);
            if (!last)
            {
                initEnd.append('+');
            }

            start = end;
        }

        initEnd.append(";\r\n"); //$NON-NLS-1$
        initBody.append(initEnd.toString());

        ov.setInitCode(initBody.toString());
        return ov;
    }

    /**
     * The length at which we stop inlining strings
     */
    private static final int INLINE_LENGTH = 20;

    /**
     * Strings longer than this are chopped up into smaller strings
     */
    private static final int WRAP_LENGTH = 128;

    /**
     * The means by which we strip comments
     */
    private static JavascriptUtil jsutil = new JavascriptUtil();
}
