package uk.ltd.getahead.dwr;

import java.lang.reflect.Method;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class SpringAllowedClass implements AllowedClass
{
    /**
     * @param name 
     * @param bean 
     */
    public SpringAllowedClass(String name, String bean)
    {
        this.name = name;
        this.bean = bean;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AllowedClass#getName()
     */
    public String getName()
    {
        return name;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AllowedClass#getType()
     */
    public Class getType()
    {
        if (clazz == null)
        {
            try
            {
                clazz = getInstance().getClass();
            }
            catch (InstantiationException ex)
            {
                ex.printStackTrace();
                return Object.class;
            }
        }

        return clazz;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AllowedClass#getInstance()
     */
    public Object getInstance() throws InstantiationException
    {
        if (factory == null)
        {
            throw new InstantiationException("No spring XmlBeanFactory set");
        }

        try
        {
            Method creator = factory.getClass().getMethod("getBean", new Class[] { String.class });
            Object reply = creator.invoke(factory, new Object[] { bean });
            return reply;
        }
        catch (RuntimeException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new InstantiationException(ex.toString());
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object arg0)
    {
        if (!(arg0 instanceof AllowedClass))
        {
            throw new ClassCastException();
        }
        
        AllowedClass that = (AllowedClass) arg0;

        return getName().compareTo(that.getName());
    }

    /**
     * @param factory The factory to set.
     */
    public static void setXmlBeanFactory(Object factory)
    {
        SpringAllowedClass.factory = factory;
    }

    private static Object factory = null;
    private Class clazz;
    private String bean;
    private String name;
}
