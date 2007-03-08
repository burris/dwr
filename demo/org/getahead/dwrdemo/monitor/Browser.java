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
package org.getahead.dwrdemo.monitor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Browser
{
    /**
     * @param httpSessionId
     */
    public Browser(String httpSessionId)
    {
        this.httpSessionId = httpSessionId;
    }

    /**
     * @return the httpSessionId
     */
    public String getHttpSessionId()
    {
        return httpSessionId;
    }

    /**
     * @param userAgent the userAgent to set
     */
    void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent()
    {
        return userAgent;
    }

    /**
     * @return the scriptViews
     */
    public Map getScriptViews()
    {
        return scriptViews;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress()
    {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (obj == this)
        {
            return true;
        }

        if (!this.getClass().equals(obj.getClass()))
        {
            return false;
        }

        Browser that = (Browser) obj;

        return this.httpSessionId.equals(that.httpSessionId);
    }

    /**
     * 
     */
    private String ipAddress;

    /**
     * 
     */
    private String httpSessionId;

    /**
     * 
     */
    private String userAgent;

    /**
     * 
     */
    private Map scriptViews = new HashMap();
}
