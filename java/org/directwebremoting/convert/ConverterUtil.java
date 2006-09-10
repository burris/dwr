/*
 * Copyright 2005 Joe Walker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.directwebremoting.convert;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.directwebremoting.Container;
import org.directwebremoting.OutboundContext;
import org.directwebremoting.OutboundVariable;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.util.JavascriptUtil;
import org.directwebremoting.util.LocalUtil;
import org.directwebremoting.util.Logger;

/**
 * A collection of utilities that are useful to more than one Converter
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ConverterUtil
{
    /**
     * Prevent instansiation.
     */
    private ConverterUtil()
    {
    }

    /**
     * Generate an array declaration for a list of Outbound variables
     * @param ov The OutboundVariable to declare
     * @param ovs The list of contents of this array
     * @param outctx A collection of objects already converted and the results
     */
    public static void addListInit(OutboundVariable ov, List ovs, OutboundContext outctx)
    {
        if (ovs.size() == 0)
        {
            ov.setInitCode("");
            ov.setAssignCode("[]");
            ov.setRecursive(false);
            return;
        }

        StringBuffer buffer = new StringBuffer();
        String init = getInitCodes(ovs);

        String nonRecursiveListAssignCodes = extractNonRecursiveListAssignCodes(ovs);

        if (entriesRemain(ovs))
        {
            ov.setInitCode("");
            ov.setAssignCode("[" + nonRecursiveListAssignCodes + "]");
            ov.setRecursive(false);
            return;
        }
        else
        {
            String assignCode = outctx.getNextVariableName();

            if (init.length() == 0)
            {
                // Declare ourselves so recurrsion works
                buffer.append("var ");
                buffer.append(assignCode);
                buffer.append("=[");
                buffer.append(nonRecursiveListAssignCodes);
                buffer.append("];");
            }
            else
            {
                // Declare ourselves so recurrsion works
                buffer.append("var ");
                buffer.append(assignCode);
                buffer.append("=[];");

                // First we output all the init code
                buffer.append(init);

                buffer.append(assignCode);
                buffer.append('=');
                buffer.append(assignCode);
                buffer.append(".concat([");
                buffer.append(nonRecursiveListAssignCodes);
                buffer.append("]);");
            }

            // And now the recursive parts
            exportRemainingListAssignCodes(buffer, ov, ovs);

            ov.setInitCode(buffer.toString());
            ov.setAssignCode(assignCode);
            ov.setRecursive(true);
        }
    }

    /**
     * Have we removed all of the entries from the list?
     * @param ovs The list to check for remaining entries
     * @return true if entries remain
     */
    private static boolean entriesRemain(List ovs)
    {
        for (Iterator iter = ovs.iterator(); iter.hasNext();)
        {
            Object ov = iter.next();
            if (ov != null)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Declare the non-recursive parts to the list
     * @param ovs The list of contents of this array
     * @return The amalgamated init code we are creating
     */
    private static String extractNonRecursiveListAssignCodes(List ovs)
    {
        StringBuffer buffer = new StringBuffer();

        boolean first = true;
        for (int i = 0; i < ovs.size(); i++)
        {
            OutboundVariable ov = (OutboundVariable) ovs.get(i);

            if (!first)
            {
                buffer.append(',');
            }

            if (ov.isRecursive())
            {
                // We'll fill it in later
                buffer.append("null");
            }
            else
            {
                ovs.set(i, null);
                buffer.append(ov.getAssignCode());
            }

            first = false;
        }

        return buffer.toString();
    }

    /**
     * Define the remaining variables
     * @param buffer The output buffer that we add to.
     * @param ov The OutboundVariable to declare
     * @param ovs The list of contents of this array
     */
    private static void exportRemainingListAssignCodes(StringBuffer buffer, OutboundVariable ov, List ovs)
    {
        String varname = ov.getAssignCode();

        for (int i = 0; i < ovs.size(); i++)
        {
            OutboundVariable nested = (OutboundVariable) ovs.get(i);

            if (nested != null)
            {
                buffer.append(varname);
                buffer.append('[');
                buffer.append(i);
                buffer.append("]=");
                buffer.append(nested.getAssignCode());
                buffer.append(';');
            }
        }
        buffer.append("\r\n");
    }

    /**
     * Generate an map declaration for a map of Outbound variables
     * @param ov The OutboundVariable to declare
     * @param ovs The map of the converted contents
     * @param scriptClassName The object name or null for pure(ish) json
     * @param outctx A collection of objects already converted and the results
     */
    public static void addMapInit(OutboundVariable ov, Map ovs, String scriptClassName, OutboundContext outctx)
    {
        if (ovs.size() == 0)
        {
            ov.setInitCode("");
            ov.setAssignCode("{}");
            ov.setRecursive(false);
            return;
        }

        // If there is no init code, there is no recursion so we can go into
        // compact JSON mode
        String init = getInitCodes(ovs.values());
        if (init.length() == 0 && (scriptClassName == null || scriptClassName.equals("")))
        {
            String nonRecursiveMapAssignCodes = extractNonRecursiveMapAssignCodes(ovs);

            if (ovs.size() == 0)
            {
                ov.setInitCode("");
                ov.setAssignCode("{" + nonRecursiveMapAssignCodes + "}");
                ov.setRecursive(false);
            }
            else
            {
                String assignCode = outctx.getNextVariableName();

                ov.setInitCode("var " + assignCode + "={" + nonRecursiveMapAssignCodes + "};" + exportRemainingMapAssignCodes(ov, ovs));
                ov.setAssignCode(assignCode);
                ov.setRecursive(true);
            }
        }
        else
        {
            if (scriptClassName == null || scriptClassName.equals(""))
            {
                String assignCode = outctx.getNextVariableName();

                ov.setInitCode("var " + assignCode + "={};" + init  + exportRemainingMapAssignCodes(ov, ovs));
                ov.setAssignCode(assignCode);
                ov.setRecursive(true);
            }
            else
            {
                String assignCode = outctx.getNextVariableName();

                ov.setInitCode("var " + assignCode + "=new " + scriptClassName + "();" + init + exportRemainingMapAssignCodes(ov, ovs));
                ov.setAssignCode(assignCode);
                ov.setRecursive(true);
            }
        }
    }

    /**
     * Declare the non-recursive parts to the map
     * @param ovs The list of contents of this array
     * @return The amalgamated init code we are creating
     */
    private static String extractNonRecursiveMapAssignCodes(Map ovs)
    {
        StringBuffer buffer = new StringBuffer();

        boolean first = true;
        for (Iterator it = ovs.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            String name = (String) entry.getKey();
            OutboundVariable nested = (OutboundVariable) entry.getValue();

            String innerAssignCode = nested.getAssignCode();

            if (!nested.isRecursive())
            {
                if (!first)
                {
                    buffer.append(',');
                }

                // The compact JSON style syntax is only any good for simple names
                // and when we are not recursive
                if (LocalUtil.isSimpleName(name))
                {
                    buffer.append(name);
                    buffer.append(':');
                    buffer.append(innerAssignCode);
                }
                else
                {
                    buffer.append('\'');
                    buffer.append(name);
                    buffer.append("\':");
                    buffer.append(innerAssignCode);
                }

                // we don't need to do this one the hard way
                it.remove();
                first = false;
            }
        }

        return buffer.toString();
    }

    /**
     * Define the remaining variables
     * @param ov The OutboundVariable to declare
     * @param ovs The list of contents of this array
     * @return The created assign code string
     */
    private static String exportRemainingMapAssignCodes(OutboundVariable ov, Map ovs)
    {
        StringBuffer buffer = new StringBuffer();
        String varname = ov.getAssignCode();

        // The next loop through is for everything that will not embed
        for (Iterator it = ovs.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            String name = (String) entry.getKey();
            OutboundVariable nested = (OutboundVariable) entry.getValue();

            String assignCode = nested.getAssignCode();

            // The semi-compact syntax is only any good for simple names
            // I dont thing we need this check:  && !ov.isRecursive()
            if (LocalUtil.isSimpleName(name))
            {
                buffer.append(varname);
                buffer.append('.');
                buffer.append(name);
                buffer.append('=');
                buffer.append(assignCode);
                buffer.append(';');
            }
            else
            {
                buffer.append(varname);
                buffer.append("['");
                buffer.append(name);
                buffer.append("']=");
                buffer.append(assignCode);
                buffer.append(';');
            }
        }
        buffer.append("\r\n");

        return buffer.toString();
    }

    /**
     * Grab all the init codes together
     * @param ovs The set of variables to marshall
     * @return An init string
     */
    private static String getInitCodes(Collection ovs)
    {
        StringBuffer init = new StringBuffer();

        // Make sure the nested things are declared
        for (Iterator it = ovs.iterator(); it.hasNext();)
        {
            OutboundVariable nested = (OutboundVariable) it.next();
            init.append(nested.getInitCode());
        }

        return init.toString();
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
        String escaped = JavascriptUtil.escapeJavaScript(output);

        // For short strings inline them
        if (escaped.length() < stringInlineLength)
        {
            return new OutboundVariable("", '\"' + escaped + '\"');
        }

        // For medium length strings do it in a separate variable
        if (escaped.length() < stringWrapLength)
        {
            String assignCode = outctx.getNextVariableName();
            OutboundVariable ov = new OutboundVariable("var " + assignCode + "=\"" + escaped + "\";\r\n", assignCode);
            outctx.put(output, ov);
            return ov;
        }

        String assignCode = outctx.getNextVariableName();
        OutboundVariable ov = new OutboundVariable();
        ov.setAssignCode(assignCode);
        outctx.put(output, ov);

        // For very long strings chop up the init into several parts
        StringBuffer initBody = new StringBuffer();
        StringBuffer initEnd = new StringBuffer();

        initEnd.append("var ");
        initEnd.append(assignCode);
        initEnd.append('=');

        int start = 0;
        while (start < escaped.length())
        {
            String tempvar = outctx.getNextVariableName();

            int end = start + stringWrapLength;
            if (end >= escaped.length())
            {
                end = escaped.length();
            }

            // If the last char is a \ then there is a chance of breaking
            // an escape so we increment until the last char is not a \
            // There is a potential bug here where the input string contains
            // only escaped slashes (\\) in which case we will end up not
            // breaking the string. Since this whole thing is a workaround
            // and the solution is complex we are going to pass on it now.
            while (end < escaped.length() && escaped.charAt(end - 1) == '\\')
            {
                end++;
            }

            // If there is a '\' followed by a 'u' in the last 4 chars then
            // we've probably broken a unicode escape
            if (escaped.charAt(end - 5) == '\\' && escaped.charAt(end - 4) == 'u')
            {
                end += 1;
            }
            if (escaped.charAt(end - 4) == '\\' && escaped.charAt(end - 3) == 'u')
            {
                end += 2;
            }
            if (escaped.charAt(end - 3) == '\\' && escaped.charAt(end - 2) == 'u')
            {
                end += 3;
            }
            if (escaped.charAt(end - 2) == '\\' && escaped.charAt(end - 1) == 'u')
            {
                end += 4;
            }

            initBody.append("var ");
            initBody.append(tempvar);
            initBody.append("=\"");
            initBody.append(escaped.substring(start, end));
            initBody.append("\";\r\n");

            initEnd.append(tempvar);
            if (end < escaped.length())
            {
                initEnd.append('+');
            }

            start = end;
        }

        initEnd.append(";\r\n");
        initBody.append(initEnd.toString());

        ov.setInitCode(initBody.toString());
        return ov;
    }

    /**
     * The length at which we stop inlining strings
     */
    private static int stringInlineLength = 20;

    /**
     * Strings longer than this are chopped up into smaller strings
     */
    private static int stringWrapLength = 16384;

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(ConverterUtil.class);

    /**
     * 
     */
    static
    {
        Container container = WebContextFactory.get().getContainer();

        String stringWrapLengthStr = (String) container.getBean("stringWrapLength");
        if (stringWrapLengthStr != null)
        {
            try
            {
                stringWrapLength = Integer.parseInt(stringWrapLengthStr);
            }
            catch (NumberFormatException ex)
            {
                log.warn("Error converting stringWrapLength setting to an integer: '" + stringWrapLengthStr + "'", ex);
            }            
        }

        String stringInlineLengthStr = (String) container.getBean("stringInlineLength");
        if (stringInlineLengthStr != null)
        {
            try
            {
                stringInlineLength = Integer.parseInt(stringInlineLengthStr);
            }
            catch (NumberFormatException ex)
            {
                log.warn("Error converting stringInlineLength setting to a integer: '" + stringInlineLengthStr + "'", ex);
            }            
        }
    }
}
