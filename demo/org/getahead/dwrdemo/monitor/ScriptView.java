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

import org.directwebremoting.ScriptSession;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class ScriptView
{
    /**
     * @param page
     * @param scriptSession
     */
    public ScriptView(String page, ScriptSession scriptSession)
    {
        this.page = page;
        this.scriptSession = scriptSession;
    }

    /**
     * @return the scriptSession
     */
    ScriptSession getScriptSession()
    {
        return scriptSession;
    }

    /**
     * @return the id
     */
    public int getClientId()
    {
        return clientId;
    }

    /**
     * @return the page
     */
    public String getPage()
    {
        return page;
    }

    /**
     * @return the verified
     */
    public boolean isVerified()
    {
        return verified;
    }

    /**
     * @param verified the verified to set
     */
    public void setVerified(boolean verified)
    {
        this.verified = verified;
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

        ScriptView that = (ScriptView) obj;

        return this.scriptSession.getId().equals(that.scriptSession.getId());
    }

    /**
     * @return
     */
    private static int nextClientId()
    {
        synchronized (ScriptView.class)
        {
            return nextClientId++;
        }
    }

    private boolean verified = true;

    private int clientId = nextClientId();

    private static int nextClientId = 0;

    private String page;

    private ScriptSession scriptSession;
}
