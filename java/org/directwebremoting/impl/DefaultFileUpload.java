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
package org.directwebremoting.impl;

import java.io.InputStream;

import org.directwebremoting.io.FileUpload;

/**
 * The default implementation of the {@link FileUpload} interface.
 * @author Lance Semmens [uklance at gmail dot com]
 */
public class DefaultFileUpload implements FileUpload
{
    /**
     * A ctor for the 3 things browsers tell us about the uploaded file
     * @param name The remote source filename
     * @param mimeType The mime type passed in by the browser
     * @param inputStream A means by which the data can be read
     */
    public DefaultFileUpload(String name, String mimeType, InputStream inputStream)
    {
        this.name = name;
        this.mimeType = mimeType;
        this.inputStream = inputStream;
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.export.FileUpload#getContentType()
     */
    public String getMimeType()
    {
        return mimeType;
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.export.FileUpload#getInputStream()
     */
    public InputStream getInputStream()
    {
        return inputStream;
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.export.FileUpload#getName()
     */
    public String getName()
    {
        return name;
    }

    /**
     * The remote source filename
     */
    private String name;

    /**
     * The mime type passed in by the browser
     */
    private String mimeType;

    /**
     * A means by which the data can be read
     */
    private InputStream inputStream;
}
