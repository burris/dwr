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
package uk.ltd.getahead.dwr.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import uk.ltd.getahead.dwr.ScriptSession;
import uk.ltd.getahead.dwr.ScriptSessionManager;

/**
 * A default implmentation of ScriptSessionManager.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultScriptSessionManager implements ScriptSessionManager
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSessionManager#getScriptSession(java.lang.String, java.lang.String)
     */
    public ScriptSession getScriptSession(String page, String id)
    {
        DefaultScriptSession session;
        boolean created = false;

        synchronized (allSessions)
        {
            session = (DefaultScriptSession) allSessions.get(id);    
            if (session == null)
            {
                session = new DefaultScriptSession(id, this);
                created = true;

                allSessions.put(id, session);
            }
        }

        // I've kept this separate to avoid deadlock issues, is there a risk
        // of something being in one map but not the other?
        if (created)
        {
            synchronized (pageSessions)
            {
                pageSessions.put(id, session);
            }
        }

        return session;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSessionManager#getScriptSessionsByPage(java.lang.String)
     */
    public Iterator getScriptSessionsByPage(String page)
    {
        synchronized (pageSessions)
        {
            return Collections.unmodifiableCollection(pageSessions.values()).iterator();
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSessionManager#getAllScriptSessions()
     */
    public Iterator getAllScriptSessions()
    {
        synchronized (allSessions)
        {
            return Collections.unmodifiableCollection(allSessions.values()).iterator();
        }
    }

    /**
     * Remove the given session from the list of sessions that we manage, and
     * leave it for the GC vultures to pluck.
     * @param session The session to get rid of
     */
    protected void invalidate(ScriptSession session)
    {
        // Can we think of a reason why we need to sync both together?
        // It feels like a deadlock risk to do so
        synchronized (allSessions)
        {
            allSessions.remove(session.getId());
        }

        synchronized (pageSessions)
        {
            pageSessions.remove(session.getId());
        }
    }

    /**
     * Do a check on all the known sessions to see if and have timeout and need
     * removing.
     */
    protected void checkTimeouts()
    {
        long now = System.currentTimeMillis();
        List timeouts = new ArrayList();

        synchronized (allSessions)
        {
            for (Iterator it = allSessions.values().iterator(); it.hasNext();)
            {
                DefaultScriptSession session = (DefaultScriptSession) it.next();

                long age = now - session.getLastAccessedTime();
                if (age > scriptSessionTimeout)
                {
                    timeouts.add(session);
                }
            }
        }

        for (Iterator it = timeouts.iterator(); it.hasNext();)
        {
            DefaultScriptSession session = (DefaultScriptSession) it.next();
            session.invalidate();
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSessionManager#getScriptSessionTimeout()
     */
    public long getScriptSessionTimeout()
    {
        return scriptSessionTimeout;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSessionManager#setScriptSessionTimeout(int)
     */
    public void setScriptSessionTimeout(long timeout)
    {
        this.scriptSessionTimeout = timeout;
    }

    private long scriptSessionTimeout = DEFAULT_TIMEOUT_MILLIS;

    /**
     * The map of all the known sessions
     */
    private Map allSessions = new HashMap();

    /**
     * The map of pages that have sessions
     */
    private Map pageSessions = new HashMap();
}
