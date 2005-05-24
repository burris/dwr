package uk.ltd.getahead.dwr;

import java.util.Collection;
import java.util.Map;

/**
 * A class to manage the types of creators and the instansiated creators.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface CreatorManager
{
    /**
     * Debug mode allows access to the list of creator names
     * @param debug Are we in debug mode
     * @see CreatorManager#getCreatorNames()
     */
    public void setDebug(boolean debug);

    /**
     * Debug mode allows access to the list of creator names
     * @return Are we in debug mode
     * @see CreatorManager#getCreatorNames()
     */
    public boolean isDebug();

    /**
     * In init mode, add a new type of creator
     * @param typename The name of the new creator type
     * @param clazz The class that we create
     */
    public void addCreatorType(String typename, Class clazz);

    /**
     * Add a new creator
     * @param type The class to use as a creator
     * @param javascript The name for it in Javascript
     * @param params The extra parameters to allow the creator to configure itself
     * @throws InstantiationException If reflection based creation fails
     * @throws IllegalAccessException If reflection based creation fails
     * @throws IllegalArgumentException If we have a duplicate name
     */
    public void addCreator(String type, String javascript, Map params) throws InstantiationException, IllegalAccessException, IllegalArgumentException;

    /**
     * Get a list of the javascript names of the allowed creators.
     * This method could be seen as a security risk because it could allow an
     * attacker to find out extra information about your system so it is only
     * available if debug is turned on.
     * @return Loop over all the known allowed classes
     * @throws SecurityException If we are not in debug mode
     * @see CreatorManager#setDebug(boolean)
     */
    public Collection getCreatorNames() throws SecurityException;

    /**
     * Find an <code>Creator</code> by name
     * @param name The name to lookup against
     * @return The found Creator instance, or null if none was found.
     * @throws SecurityException If the Creator is not known
     */
    public Creator getCreator(String name) throws SecurityException;

    /**
     * Add an include rule.
     * Each creator can have either a list of inclusions or a list of exclusions
     * but not both. If a creator has a list of inclusions then the default
     * policy is to deny any method that is not specifically included. If the
     * creator has a list of exclusions then the default policy is to allow
     * any method not listed.
     * If there are no included or excluded rules then the default policy is to
     * allow all methods
     * @param type The name of the creator
     * @param method The method name.
     */
    public void addIncludeRule(String type, String method);

    /**
     * Add an exclude rule.
     * @param type The name of the creator
     * @param method The method name.
     * @see CreatorManager#addIncludeRule(String, String)
     */
    public void addExcludeRule(String type, String method);

    /**
     * @param type The name of the creator
     * @param method The method name.
     * @return true if the method is allowed by the rules in addIncludeRule()
     * @see CreatorManager#addIncludeRule(String, String)
     */
    public boolean isExecutable(String type, String method);
}
