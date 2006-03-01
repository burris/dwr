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
package uk.ltd.getahead.dwr;

/**
 * The heart of DWR is a system to generate content from some requests.
 * This interface generates scripts and executes remote calls.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface DebugPageGenerator
{
    /**
     * Generate some HTML that represents an index page
     * @param contextPath The context to the webapp in which DWR is embedded
     * @param servletPath The path to DWR from within the current webapp
     * @return An index page in HTML
     * @throws SecurityException If the pages are not accessible
     */
    HttpResponse generateIndexPage(String contextPath, String servletPath) throws SecurityException;

    /**
     * Generate some HTML that represents a test page
     * @param contextPath The context to the webapp in which DWR is embedded
     * @param servletPath The path to DWR from within the current webapp
     * @param scriptName The script to generate for
     * @return A test page in HTML
     * @throws SecurityException If the pages are not accessible
     */
    HttpResponse generateTestPage(String contextPath, String servletPath, String scriptName) throws SecurityException;
}
