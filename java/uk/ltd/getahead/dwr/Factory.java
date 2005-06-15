package uk.ltd.getahead.dwr;

import uk.ltd.getahead.dwr.util.Logger;

/**
 * Factory is like a mini-IoC container for DWR.
 * At least it is an IoC container by interface (check: no params that have
 * anything to do with DWR), but it is hard coded specifically for DWR. If we
 * want to make more of it we can later, but this is certainly not going to
 * become a full blown IoC container.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Factory
{
    /**
     * Set the class that should be used to implement the given interface
     * @param interfaceName The interface to implement
     * @param implName The new implementation
     * @throws ClassNotFoundException If <code>impl</code> could not be found.
     * @throws IllegalAccessException If <code>impl</code> could not be created.
     * @throws InstantiationException If <code>impl</code> could not be created. 
     */
    public void setImplementation(String interfaceName, String implName) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        Class iface = Class.forName(interfaceName);
        Class impl = Class.forName(implName);

        if (iface == CreatorManager.class)
        {
            creatorManager = (CreatorManager) impl.newInstance();
        }
        else if (iface == ConverterManager.class)
        {
            converterManager = (ConverterManager) impl.newInstance();
        }
        else if (iface == AccessControl.class)
        {
            accessControl = (AccessControl) impl.newInstance();
        }
        else if (iface == DWRProcessor.class)
        {
            processor = (DWRProcessor) impl.newInstance();
        }
        else if (iface == ExecutionContext.class)
        {
            executionContext = (ExecutionContext) impl.newInstance();
        }
    }

    /**
     * Called to indicate that we finished called setImplementation.
     * @see Factory#setImplementation(String, String)
     */
    public void configurationFinished()
    {
        // So supply defaults for any implementations that have not been
        // configured
        try
        {
            if (creatorManager == null)
            {
                setImplementation(CreatorManager.class.getName(), "uk.ltd.getahead.dwr.impl.DefaultCreatorManager"); //$NON-NLS-1$
            }

            if (converterManager == null)
            {
                setImplementation(ConverterManager.class.getName(), "uk.ltd.getahead.dwr.impl.DefaultConverterManager"); //$NON-NLS-1$
            }

            if (processor == null)
            {
                setImplementation(DWRProcessor.class.getName(), "uk.ltd.getahead.dwr.DWRProcessor"); //$NON-NLS-1$
            }

            if (executionContext == null)
            {
                setImplementation(ExecutionContext.class.getName(), "uk.ltd.getahead.dwr.ExecutionContext"); //$NON-NLS-1$
            }

            if (accessControl == null)
            {
                setImplementation(AccessControl.class.getName(), "uk.ltd.getahead.dwr.AccessControl"); //$NON-NLS-1$
            }

            if (configuration == null)
            {
                setImplementation(Configuration.class.getName(), "uk.ltd.getahead.dwr.Configuration"); //$NON-NLS-1$
            }
        }
        catch (Exception ex)
        {
            log.fatal("Internal error setting defaults", ex); //$NON-NLS-1$
            throw new IllegalStateException(ex.getMessage());
        }

        // And wire them together
        ExecutionContext.setImplementation(executionContext.getClass());

        processor.setConverterManager(converterManager);
        processor.setCreatorManager(creatorManager);
        processor.setAccessControl(accessControl);

        configuration.setConverterManager(converterManager);
        configuration.setCreatorManager(creatorManager);
        configuration.setAccessControl(accessControl);
    }

    /**
     * Get an instance of a bean of a given type.
     * @param type The type to get an instance of
     * @return The object of the given type
     */
    public Object getBean(Class type)
    {
        if (type == CreatorManager.class)
        {
            return creatorManager;
        }
        else if (type == ConverterManager.class)
        {
            return converterManager;
        }
        else if (type == AccessControl.class)
        {
            return accessControl;
        }
        else if (type == DWRProcessor.class)
        {
            return processor;
        }
        else if (type == ExecutionContext.class)
        {
            return executionContext;
        }
        else if (type == Configuration.class)
        {
            return configuration;
        }

        throw new IllegalArgumentException("Factory can't create a " + type.getName()); //$NON-NLS-1$
    }

    /**
     * How we create new beans
     */
    protected CreatorManager creatorManager = null;

    /**
     * How we convert parameters
     */
    protected ConverterManager converterManager = null;

    /**
     * The security manager
     */
    protected AccessControl accessControl = null;

    /**
     * The thing that actually does the work
     */
    private DWRProcessor processor = null;

    /**
     * Container for the HTTP objects for deep thread access
     */
    private ExecutionContext executionContext = null;

    /**
     * The dwr.xml parser
     */
    private Configuration configuration = new Configuration();

    /**
     * The log stream
     */
    private static final Logger log = Logger.getLogger(Factory.class);
}
