package uk.ltd.getahead.dwr;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Maintain a list of the classes that we allow DWR to remote to.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class AccessList
{
    /**
     * Designed for use from a servlet init-parameter
     * @param allowStr
     * @throws ClassNotFoundException
     */
    public AccessList(String allowStr) throws ClassNotFoundException
    {
        if (allowStr == null)
        {
            throw new NullPointerException("allowed");
        }

        // replace all the commas, tabs and new lines with spaces.
        StringTokenizer st = new StringTokenizer(allowStr, ", \t\n\r\f");
        while (st.hasMoreElements())
        {
            String allow = st.nextToken().trim();            
            if (allow.length() > 0)
            {
                Class clazz = Class.forName(allow);
                allowed.add(clazz);
            }
        }
    }

    /**
     * TODO: Workout a way to ensure that this is only called in debug mode.
     * @return Loop over all the known allowed classes
     */
    protected Iterator iterator()
    {
        return allowed.iterator();
    }

    /**
     * Is the given class on the list of classes we are allowed to access
     * @param allow The class in question
     * @return true if access is allowed to <code>allow</code>
     */
    protected boolean isAllowed(Class allow)
    {
        return allowed.contains(allow);
    }

    /**
     * The exec properties
     */
    private Set allowed = new TreeSet(new Comparator()
    {
        public int compare(Object o1, Object o2)
        {
            if (o1 == null && o2 == null)
            {
                return 0;
            }

            if (o1 == null)
            {
                return 1;
            }

            if (o2 == null)
            {
                return -1;
            }

            Class c1 = (Class) o1;
            Class c2 = (Class) o2;

            return c1.getName().compareTo(c2.getName());
        }
    });
}
