package uk.ltd.getahead.dwr.create;

import java.lang.reflect.Method;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import uk.ltd.getahead.dwr.Creator;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class SpringCreator implements Creator
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.create.Creator#init(org.w3c.dom.Element)
     */
    public void init(Element config) throws SAXException
    {
        this.beanname = config.getAttribute("beanName");
    }

    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Creator#getType()
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
     * @see uk.ltd.getahead.dwr.Creator#getInstance()
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
            Object reply = creator.invoke(factory, new Object[] { beanname });
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

    /**
     * @param factory The factory to set.
     */
    public static void setXmlBeanFactory(Object factory)
    {
        SpringCreator.factory = factory;
    }

    private static Object factory = null;
    private Class clazz;
    private String beanname;
}
