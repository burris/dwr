package hu.argol.tabloid.dwr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.jxpath.JXPathContext;

import uk.ltd.getahead.dwr.ExecutionContext;

public class UserManager 
{
	private static final String USERLIST = "userlist";
	
	public ListValue getUsers(int dPage, int dMax, String dOrder, boolean dAsc, String filter)
	{		
		/*
		 * getCount & getList retrieve relevant info for ListValue creation.
		 * The data are now in the context (DataContextListener created & put the User list in the context), 
		 * but could be anywhere (session, database, etc)
		 */
        
		int count = getCount(filter);
		List list = getList(dPage, dMax, dOrder, dAsc, filter);
		
        /*
         * ListValue object creation 
         */
		
		ListValue lv =  ListValue.create(list, dPage, dMax, dOrder, dAsc, filter, count);
		
		return lv;
	}
	
	/*
	 * count the number of item in the filtered userlist
	 */
	
	private int getCount(String filter)
	{
		List list = getFilteredList(filter);
		return list.size();
	}
	
	/*
	 * return a sublist of the filtered and sorted userlist
	 */
	
    private List getList(int page, int max, final String order, final boolean asc, String filter)
    {
    	List list = getFilteredList(filter);

    	sortList(list, order, asc);
	    
	    // from max and page you can get the 'from' and the 'to' for sublist
	    int from = (page -1) * max;
	    int to = from + max;
	    if(to>list.size()) to = list.size();
	    
	    return list.subList(from,to);	
    }
    
    /*
     * sort list
     * use jakarta commons collection & beanutils
     */
    private void sortList(List list, final String order, final boolean asc)
    {
        final ComparableComparator cc = ComparableComparator.getInstance();

        // sort list by order 
        
	    Collections.sort(list,new Comparator()
	    {
	        	public int compare(Object o0, Object o1)
                {
	        	    try
	        	    {
	        	        Object v0 = PropertyUtils.getSimpleProperty(o0,order);
	        	        Object v1 = PropertyUtils.getSimpleProperty(o1,order);
	        	        
	        	        if(asc) return cc.compare(v0,v1);
	        	        else return -cc.compare(v0,v1);
	        	    }
	        	    catch(Exception e)
	        	    {
	        	        return 0;
	        	    }
                }
	       });   	
    }
    
    /*
     * get the user list from the contex, filter it with the filter (not very sophisticated, but good enought)
     * use jakarta commons jxpath
     */
    
    private List getFilteredList(String filter)
    {
    	List _list = (List) ExecutionContext.get().getServletContext(). getAttribute(USERLIST);
		if(_list==null) return new ArrayList();
		
		
		if(filter !=null && !filter.equals("")) 
		{
			Iterator iter = JXPathContext.newContext(_list).iterate(".["+filter+"]");
			List result = new ArrayList();
			while(iter.hasNext())
			{
				result.add(iter.next());
			}
			return result;		
		}

		return _list;
    }
}
