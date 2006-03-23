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

import uk.ltd.getahead.dwr.ScriptConduit;
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
        boolean handledDirectly = false;

        // First we try to add the script to an existing conduit
        synchronized (conduits)
        {
            if (conduits.size() > 0)
            {
                ScriptConduit conduit = (ScriptConduit) conduits.get(0);
                conduit.addScript(script);

                handledDirectly = true;
            }
        }

        // But if that doesn't work we dump it to a list for later
        if (!handledDirectly)
        {
            synchronized (scripts)
            {
                scripts.add(script);
            }
        }
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

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#addScriptConduit(uk.ltd.getahead.dwr.ScriptConduit)
     */
    public void addScriptConduit(ScriptConduit conduit)
    {
        checkNotInvalidated();

        // If there are any outstanding scripts, dump them to the new conduit
        synchronized (scripts)
        {
            for (Iterator it = scripts.iterator(); it.hasNext();)
            {
                String script = (String) it.next();
                conduit.addScript(script);
            }

            scripts.clear();
        }

        // And add the conduit into the list
        synchronized (conduits)
        {
            conduits.add(conduit);
        }
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.ScriptSession#removeScriptConduit(uk.ltd.getahead.dwr.ScriptConduit)
     */
    public void removeScriptConduit(ScriptConduit conduit)
    {
        checkNotInvalidated();

        synchronized (conduits)
        {
            conduits.remove(conduit);
        }
    }

    /**
     * The script conduits that we can use to transfer data to the browser
     */
    protected final List conduits = new ArrayList();

    /**
     * The list of waiting scripts
     */
    protected final List scripts = new ArrayList();

    /**
     * What is our page session id?
     */
    protected String id = null;

    /**
     * When we we created?
     */
    protected long creationTime = 0L;

    /**
     * When the the web page that we represent last contact us using DWR?
     */
    protected long lastAccessedTime = 0L;

    /**
     * Have we been made invalid?
     */
    protected boolean invalidated = false;

    /**
     * The server side attributes for this page
     */
    protected Map attributes = new HashMap();

    /**
     * The session manager that collects sessions together
     */
    protected DefaultScriptSessionManager manager;
}
