package uk.ltd.getahead.dwr;

/**
 * A base class for all AllowedClasses
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface AllowedClass extends Comparable
{
    /**
     * Get the name by which this class is known to the system
     * @return The name of this allowed class
     */
    public String getName();

    /**
     * Accessor for the <code>java.lang.Class</code> that this AllowedClass
     * allows access to.
     * @return The type of this allowed class
     */
    public Class getType();
    
    /**
     * Accessor for the/an instance of this AllowedClass.
     * @return the instance to use
     * @throws InstantiationException If for some reason the object can not be created
     */
    public Object getInstance() throws InstantiationException;
}

