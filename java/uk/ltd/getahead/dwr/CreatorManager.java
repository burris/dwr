package uk.ltd.getahead.dwr;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.w3c.dom.Element;

import uk.ltd.getahead.dwr.util.Log;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class CreatorManager
{
    /**
     * Simple ctor
     * @param debug Are we in debug mode
     */
    public CreatorManager(boolean debug)
    {
        this.debug = debug;
    }

    /**
     * In init mode, add a new type of creator
     * @param typename The name of the new creator type
     * @param clazz The class that we create
     */
    protected void addCreatorType(String typename, Class clazz)
    {
        creatorTypes.put(typename, clazz);
    }

    /**
     * @param type
     * @param javascript
     * @param allower
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    protected void addCreator(String type, String javascript, Element allower) throws InstantiationException, IllegalAccessException, IllegalArgumentException
    {
        Class clazz = (Class) creatorTypes.get(type);

        Creator creator = (Creator) clazz.newInstance();
        creator.init(allower);

        creators.put(javascript, creator);
    }

    /**
     * Get a list of the javascript names of the allowed creators.
     * This method could be seen as a security risk because it could allow an
     * attacker to find out extra information about your system so it is only
     * available if debug is turned on.
     * @return Loop over all the known allowed classes
     */
    protected Collection getCreatorNames()
    {
        if (!debug)
        {
            throw new SecurityException();
        }

        return Collections.unmodifiableSet(creators.keySet());
    }

    /**
     * Find an <code>Creator</code> by name
     * @param name The name to lookup against
     * @return The found Creator instance, or null if none was found.
     */
    public Creator getCreator(String name)
    {
        Creator creator = (Creator) creators.get(name);
        if (creator == null)
        {
            StringBuffer buffer = new StringBuffer("Names of known classes are: ");
            for (Iterator it = creators.keySet().iterator(); it.hasNext();)
            {
                String key = (String) it.next();
                buffer.append(key);
                buffer.append(" ");
            }
            Log.warn(buffer.toString());
            throw new SecurityException("No class by name: "+name);
        }

        return creator;
    }

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
