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
package org.directwebremoting.util;

import javax.servlet.http.HttpServlet;

/**
 * An implementation of LoggingOutput that sends stuff to the Servlet.log
 * stream.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 * @deprecated Servlet Log output is not supported as of 2.1
 */
@SuppressWarnings({"unused", "UnusedDeclaration"})
@Deprecated
public class ServletLoggingOutput
{
    /**
     * Associate a servlet with this thread for logging purposes.
     * @param servlet The servlet to use for logging in this thread
     * @deprecated Servlet Log output is not supported as of 2.1
     */
    @Deprecated
    public static void setExecutionContext(HttpServlet servlet)
    {
    }

    /**
     * Remove the servlet from this thread for logging purposes
     * @deprecated Servlet Log output is not supported as of 2.1
     */
    @Deprecated
    public static void unsetExecutionContext()
    {
    }

    /**
     * String version of setLevel.
     * @param logLevel One of FATAL, ERROR, WARN, INFO, DEBUG
     * @deprecated Servlet Log output is not supported as of 2.1
     */
    @Deprecated
    public static void setLevel(String logLevel)
    {
    }

    /**
     * @param level The logging level to set.
     * @deprecated Servlet Log output is not supported as of 2.1
     */
    @Deprecated
    public static void setLevel(int level)
    {
    }

    /**
     * @return Returns the logging level.
     * @deprecated Servlet Log output is not supported as of 2.1
     */
    @Deprecated
    public static int getLevel()
    {
        // The default used to be LoggingOutput.LEVEL_WARN;
        return 3;
    }
}
