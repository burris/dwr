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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import uk.ltd.getahead.dwr.ScriptSession;

/**
 * An implementation of ScriptSession.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultScriptSession implements ScriptSession
{
    /**
     * Simple constructor
     * @param id The new unique identifier for this session
     * @param manager The manager that created us
     */
    protected DefaultScriptSession(String id, DefaultScriptSessionManager manager)
    {
        this.id = id;
        this.manager = manager;
        this.creationTime = System.currentTimeMillis();
        this.lastAccessedTime = creationTime;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#getAttribute(java.lang.String)
     */
    public Object getAttribute(String name)
    {
        checkNotInvalidated();
        return attributes.get(name);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#setAttribute(java.lang.String, java.lang.Object)
     */
    public void setAttribute(String name, Object value)
    {
        checkNotInvalidated();
        attributes.put(name, value);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#removeAttribute(java.lang.String)
     */
    public void removeAttribute(String name)
    {
        checkNotInvalidated();
        attributes.remove(name);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#getAttributeNames()
     */
    public Iterator getAttributeNames()
    {
        checkNotInvalidated();
        return attributes.keySet().iterator();
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#invalidate()
     */
    public void invalidate()
    {
        invalidated = true;
        manager.invalidate(this);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#getId()
     */
    public String getId()
    {
        return id;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#getCreationTime()
     */
    public long getCreationTime()
    {
        checkNotInvalidated();
        return creationTime;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#getLastAccessedTime()
     */
    public long getLastAccessedTime()
    {
        checkNotInvalidated();
        return lastAccessedTime;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Browser#addScript(java.lang.String)
     */
    public void addScript(String script)
    {
        checkNotInvalidated();
        synchronized (scripts)
        {
            scripts.add(script);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Browser#removeAllScripts()
     */
    public List removeAllScripts()
    {
        checkNotInvalidated();
        List copy = new ArrayList();

        synchronized (scripts)
        {
            copy.addAll(scripts);
            scripts.clear();
        }

        return copy;
    }

    /**
     * Called whenever a browser accesses this data using DWR
     */
    protected void updateLastAccessedTime()
    {
        lastAccessedTime = System.currentTimeMillis();
    }

    /**
     * Check that we are still valid and throw an IllegalStateException if not.
     * At the same time set the lastAccessedTime flag.
     * @throws IllegalStateException If this object has become invalid
     */
    private void checkNotInvalidated()
    {
        long now = System.currentTimeMillis();
        long age = now - lastAccessedTime;
        if (age > manager.getScriptSessionTimeout())
        {
            invalidate();
        }

        if (invalidated)
        {
            throw new IllegalStateException("ScriptSession has been invalidated."); //$NON-NLS-1$
        }
    }

    /**
     * The list of waiting scripts
     */
    private final List scripts = new ArrayList();

    /**
     * What is our page session id?
     */
    private String id = null;

    /**
     * When we we created?
     */
    private long creationTime = 0L;

    /**
     * When the the web page that we represent last contact us using DWR?
     */
    private long lastAccessedTime = 0L;

    /**
     * Have we been made invalid?
     */
    private boolean invalidated = false;

    /**
     * The server side attributes for this page
     */
    private Map attributes = new HashMap();

    /**
     * The session manager that collects sessions together
     */
    private DefaultScriptSessionManager manager;
}
