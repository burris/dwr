package hu.argol.tabloid.dwr;

import java.util.List;


public class ListValue
{
    List values;
    int page;
    int max;
    int count;
    int itemNumber;
    int pageNumber;
    String order;
    boolean asc;
    String filter;
    boolean last;
    boolean first;  
    int pageFirstItem;
    int pageLastItem;
    
    // user create
    private ListValue(){}
    
    public int getPageFirstItem()
    {
        return pageFirstItem;
    }

    public int getPageLastItem()
    {
        return pageLastItem;
    }

    public boolean isAsc()
    {
        return asc;
    }
    
	public String getFilter() 
	{
		return filter;
	}
	
    public int getMax()
    {
        return max;
    }
    
    public String getOrder()
    {
        return order;
    }
    
    public int getPage()
    {
        return page;
    }

    public List getValues()
    {
        return values;
    }
    
    public int getCount()
    {
        return count;
    }

    public int getItemNumber()
    {
        return itemNumber;
    }
    
    public int getPageNumber()
    {
        return pageNumber;
    }
    
    public boolean isFirst()
    {
        return first;
    }
    
    public boolean isLast()
    {
        return last;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("page:");
        sb.append(page);      
        sb.append(";max=");
        sb.append(max);      
        sb.append(";count=");
        sb.append(count) ;     
        sb.append(";itemNumber=");
        sb.append(itemNumber);       
        sb.append(";order=");
        sb.append(order);       
        
        return sb.toString();
    }
    
    /*
     * don't ask;) 
     */
    
    public static ListValue create(List values, int page, int max, String order, boolean asc, String filter, int itemNumber)
    {
	    if(max<1) max = 1;
	    if(page < 1) page = 1;
	    if(itemNumber < 1) itemNumber = 1;

	    int pageNumber = itemNumber / max + 1;
	    if(itemNumber % max == 0) pageNumber--;
	    if(page>pageNumber) page = pageNumber;	    
	    
	    int first = (page-1) * max + 1;	    
	    int last = first + max - 1;
	    
	    if(last>itemNumber) last = itemNumber;	
	    if(first>last) first = last-max;
	   
        
        ListValue lv = new ListValue();
        lv.asc = asc;
        lv.first = (page == 1);
        lv.pageFirstItem = first;
        lv.last = (page == pageNumber);
        lv.pageLastItem = last;
        lv.pageNumber = pageNumber;
        lv.page = page;
        lv.itemNumber = itemNumber;
        lv.max = max;
        lv.order = order;
        lv.values = values;
        lv.count = values.size();
        lv.filter = filter;
        
        return lv;
    }
}
