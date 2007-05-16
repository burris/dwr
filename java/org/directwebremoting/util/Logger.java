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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A very quick and dirty logging implementation.
 * <code>java.util.logging</code> is out because we work with JDK 1.3 and we
 * don't want to force users to import log4j or commons-logging.
 * Don't use this outside of DWR - it's just a quick hack to keep things simple.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 * @deprecated Use Commons Logging directly rather than this proxy
 */
@Deprecated
public final class Logger
{
    /**
     * @param base The class to log against
     * @return A new logger
     * @deprecated Use Commons Logging directly rather than this proxy
     */
    @Deprecated
    public static Logger getLogger(Class<?> base)
    {
        return new Logger(base);
    }

    /**
     * Prevent instansiation
     * @param base The class to log against
     */
    private Logger(Class<?> base)
    {
        log = LogFactory.getLog(base);
    }

    /**
     * Logger a debug message
     * @param message The text to log
     */
    public void debug(String message)
    {
        log.debug(message);
    }

    /**
     * Logger an info message
     * @param message The text to log
     */
    public void info(String message)
    {
        log.info(message);
    }

    /**
     * Logger a warning message
     * @param message The text to log
     */
    public void warn(String message)
    {
        log.warn(message);
    }

    /**
     * Logger a warning message
     * @param message The text to log
     * @param th An optional stack trace
     */
    public void warn(String message, Throwable th)
    {
        log.warn(message, th);
    }

    /**
     * Logger an error message
     * @param message The text to log
     */
    public void error(String message)
    {
        log.error(message);
    }

    /**
     * Logger an error message
     * @param message The text to log
     * @param th An optional stack trace
     */
    public void error(String message, Throwable th)
    {
        log.error(message, th);
    }

    /**
     * Logger a fatal error message
     * @param message The text to log
     */
    public void fatal(String message)
    {
        log.fatal(message);
    }

    /**
     * Logger a fatal error message
     * @param message The text to log
     * @param th An optional stack trace
     */
    public void fatal(String message, Throwable th)
    {
        log.fatal(message, th);
    }

    /**
     * Save CPU time when we are not debugging
     * @return true if debugging is enabled
     */
    public boolean isDebugEnabled()
    {
        return log.isDebugEnabled();
    }

    private final Log log;
}
