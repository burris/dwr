package uk.ltd.getahead.dwr;

import javax.servlet.http.HttpSession;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class SessionAllowedClass implements AllowedClass
{
    /**
     * @param clazz
     * @param name 
     */
    public SessionAllowedClass(Class clazz, String name)
    {
        this.clazz = clazz;
        this.name = name;
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
        return clazz;
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.AllowedClass#getInstance()
     */
    public Object getInstance() throws InstantiationException
    {
        HttpSession session = ExecutionContext.getExecutionContext().getSession();
        Object reply = session.getAttribute(name);

        if (reply == null)
        {
            try
            {
                reply = clazz.newInstance();
            }
            catch (IllegalAccessException ex)
            {
                throw new InstantiationException("Illegal Access to default constructor");
            }
            
            session.setAttribute(name, reply);
        }

        return reply;
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

    private Class clazz;
    private String name;
}
