package uk.ltd.getahead.dwr.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import uk.ltd.getahead.dwr.Creator;
import uk.ltd.getahead.dwr.CreatorManager;
import uk.ltd.getahead.dwr.Messages;
import uk.ltd.getahead.dwr.util.Logger;

/**
 * A class to manage the types of creators and the instansiated creators.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class DefaultCreatorManager implements CreatorManager
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#setDebug(boolean)
     */
    public void setDebug(boolean debug)
    {
        this.debug = debug;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#isDebug()
     */
    public boolean isDebug()
    {
        return debug;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#addCreatorType(java.lang.String, java.lang.Class)
     */
    public void addCreatorType(String typename, Class clazz)
    {
        if (!Creator.class.isAssignableFrom(clazz))
        {
            throw new IllegalArgumentException(Messages.getString("DefaultCreatorManager.CreatorNotAssignable", clazz.getName(), Creator.class.getName())); //$NON-NLS-1$
        }

        creatorTypes.put(typename, clazz);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#addCreator(java.lang.String, java.lang.String, org.w3c.dom.Element)
     */
    public void addCreator(String type, String javascript, Map params) throws InstantiationException, IllegalAccessException, IllegalArgumentException
    {
        Class clazz = (Class) creatorTypes.get(type);

        Creator creator = (Creator) clazz.newInstance();

        // Initialize the creator with the parameters that we know of.
        creator.init(params);

        // Check that we don't have this one already
        Creator other = (Creator) creators.get(javascript);
        if (other != null)
        {
            throw new IllegalArgumentException(Messages.getString("DefaultCreatorManager.DuplicateName", javascript, other.getType().getName(), type)); //$NON-NLS-1$
        }

        creators.put(javascript, creator);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#getCreatorNames()
     */
    public Collection getCreatorNames() throws SecurityException
    {
        if (!debug)
        {
            throw new SecurityException();
        }

        return Collections.unmodifiableSet(creators.keySet());
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#getCreator(java.lang.String)
     */
    public Creator getCreator(String name)
    {
        Creator creator = (Creator) creators.get(name);
        if (creator == null)
        {
            StringBuffer buffer = new StringBuffer("Names of known classes are: "); //$NON-NLS-1$
            for (Iterator it = creators.keySet().iterator(); it.hasNext();)
            {
                String key = (String) it.next();
                buffer.append(key);
                buffer.append(' ');
            }

            log.warn(buffer.toString());
            throw new SecurityException(Messages.getString("DefaultCreatorManager.MissingName", name)); //$NON-NLS-1$
        }

        return creator;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#addIncludeRule(java.lang.String, java.lang.String)
     */
    public void addIncludeRule(String type, String method)
    {
        Policy policy = getPolicy(type);

        // If the policy for the given type is defaultAllow then we need to go
        // to default disallow mode, and check that the are not rules applied
        if (policy.defaultAllow == true)
        {
            if (policy.rules.size() > 0)
            {
                throw new IllegalArgumentException(Messages.getString("DefaultCreatorManager.MixedIncludesAndExcludes", type)); //$NON-NLS-1$
            }

            policy.defaultAllow = false;
        }

        // Add the rule to this policy
        policy.rules.add(method);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#addExcludeRule(java.lang.String, java.lang.String)
     */
    public void addExcludeRule(String type, String method)
    {
        Policy policy = getPolicy(type);

        // If the policy for the given type is defaultAllow then we need to go
        // to default disallow mode, and check that the are not rules applied
        if (policy.defaultAllow == false)
        {
            if (policy.rules.size() > 0)
            {
                throw new IllegalArgumentException(Messages.getString("DefaultCreatorManager.MixedIncludesAndExcludes", type)); //$NON-NLS-1$
            }

            policy.defaultAllow = true;
        }

        // Add the rule to this policy
        policy.rules.add(method);
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.CreatorManager#isExecutable(java.lang.String, java.lang.String)
     */
    public boolean isExecutable(String type, String method)
    {
        Policy policy = (Policy) policyMap.get(type);
        if (policy == null)
        {
            return true;
        }

        // Find a match for this method in the policy rules
        String match = null;
        for (Iterator it = policy.rules.iterator(); it.hasNext() && match == null;)
        {
            String test = (String) it.next();

            // If at some point we wish to do regex matching on rules, here is
            // the place to do it.
            if (method.equals(test))
            {
                match = test;
            }
        }

        // There may be a more optimized if statement here, but I value code
        // clarity over performance.

        if (policy.defaultAllow && match != null)
        {
            // We are in default allow mode so the rules are exclusions and we
            // have a match, so this method is excluded.
            //log.debug("method excluded for creator " + type + " due to defaultAllow=" + policy.defaultAllow + " and rule: " + match); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return false;
        }

        if (!policy.defaultAllow && match == null)
        {
            // We are in default deny mode so the rules are inclusions and we
            // do not have a match, so this method is excluded.
            //log.debug("method excluded for creator " + type + " due to defaultAllow=" + policy.defaultAllow + " and rule: " + match); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return false;
        }

        return true;
    }

    /**
     * Find the policy for the given type and create one if none exists.
     * @param type The name of the creator
     * @return The policy for the given Creator
     */
    private Policy getPolicy(String type)
    {
        Policy policy = (Policy) policyMap.get(type);
        if (policy == null)
        {
            policy = new Policy();
            policyMap.put(type, policy);
        }

        return policy;
    }

    /**
     * A map of Creators to policies
     */
    private Map policyMap = new HashMap();

    /**
     * A struct that contains a method access policy for a Creator
     */
    class Policy
    {
        boolean defaultAllow = true;
        List rules = new ArrayList();
    }

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(DefaultCreatorManager.class);

    /**
     * The list of the available creators
     */
    private Map creatorTypes = new HashMap();

    /**
     * The list of the configured creators
     */
    private Map creators = new HashMap();

    /**
     * Are we in debug mode?
     */
    private boolean debug;
}
