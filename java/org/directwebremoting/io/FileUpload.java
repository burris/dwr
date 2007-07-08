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
package org.directwebremoting.io;

import java.io.InputStream;

/**
 * One of the 2 ways you can receive uploaded files from a DWR enabled page is
 * to expose a method with a {@link FileUpload} parameter.
 * The other is to expose a method with an {@link InputStream} parameter.
 * @author Lance Semmens [uklance at gmail dot com]
 */
public interface FileUpload
{
    /**
     * Returns the content type passed by the browser or null if not defined. 
     * @return The content type passed by the browser or null if not defined.
     */
    public String getMimeType();

    /**
     * Returns an InputStream that can be used to retrieve the contents of the file. 
     * @return An InputStream that can be used to retrieve the contents of the file.
     */
    public InputStream getInputStream();

    /**
     * Returns the original filename in the client's file-system, as provided by
     * the browser (or other client software). 
     * In most cases, this will be the base file name, without path information.
     * However, some clients, such as the Opera browser, do include path
     * information.
     * @return The original filename in the client's file-system.
     */
    public String getName();
}
