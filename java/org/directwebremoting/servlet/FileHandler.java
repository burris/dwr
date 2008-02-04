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
package org.directwebremoting.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.extend.DwrConstants;
import org.directwebremoting.extend.Handler;
import org.directwebremoting.util.JavascriptUtil;
import org.directwebremoting.util.LocalUtil;
import org.directwebremoting.util.MimeConstants;

/**
 * Basically a file servlet component that does some <b>very limited</b>
 * EL type processing on the file. See the source for the cheat.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class FileHandler extends CachingFileHandler implements Handler
{
    /* (non-Javadoc)
     * @see org.directwebremoting.servlet.CachingFileHandler#generate(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected String generate(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        StringBuffer buffer = new StringBuffer();

        String resource = DwrConstants.PACKAGE + filePath;
        InputStream raw = getClass().getResourceAsStream(resource);
        if (raw == null)
        {
            throw new IOException("Failed to find resource: " + resource);
        }

        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new InputStreamReader(raw));
            while (true)
            {
                String line = in.readLine();
                if (line == null)
                {
                    break;
                }

                Map<String, String> replace = getSearchReplacePairs();
                if (replace != null)
                {
                    for (Map.Entry<String, String> entry : replace.entrySet())
                    {
                        String search = entry.getKey();
                        if (line.contains(search))
                        {
                            line = line.replace(search, entry.getValue());
                        }
                    }
                }

                buffer.append(line);
                buffer.append('\n');
            }
        }
        finally
        {
            LocalUtil.close(in);
        }

        String output = buffer.toString();

        if (getMimeType().equals(MimeConstants.MIME_JS) && scriptCompressed)
        {
            output = JavascriptUtil.compress(output, compressionLevel);
        }

        return output;
    }

    /**
     * Mostly when we send a file out, we don't change anything so the default
     * set of search and replaces is empty.
     * Engine.js can override this with strings to customize the output
     * @return a map of search (key) and replace (value) strings
     */
    public Map<String, String> getSearchReplacePairs()
    {
        return null;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    /**
     * To what level do we compress scripts?
     * @param scriptCompressed The scriptCompressed to set.
     */
    public void setScriptCompressed(boolean scriptCompressed)
    {
        this.scriptCompressed = scriptCompressed;
    }

    /**
     * @param compressionLevel The compressionLevel to set.
     */
    public void setCompressionLevel(int compressionLevel)
    {
        this.compressionLevel = compressionLevel;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return filePath;
    }

    /**
     * The file filePath and resource filePath (minus org.directwebremoting) to read from
     */
    private String filePath;

    /**
     * How much do we compression javascript by?
     */
    protected int compressionLevel = JavascriptUtil.LEVEL_DEBUGGABLE;

    /**
     * Do we retain comments and unneeded spaces in Javascript code?
     */
    private boolean scriptCompressed = false;
}
