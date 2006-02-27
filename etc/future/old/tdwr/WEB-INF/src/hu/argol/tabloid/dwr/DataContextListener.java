package hu.argol.tabloid.dwr;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DataContextListener implements ServletContextListener 
{

	public void contextInitialized(ServletContextEvent ev) 
	{		
		try 
		{
			String path = ev.getServletContext().getRealPath("/WEB-INF/data/users.csv");
			
			File file = new File(path);
			if(file.exists() && file.isFile())
			{
				FileReader fr = new FileReader(file);
			    BufferedReader br = new BufferedReader(fr);
			    
			    List list = new ArrayList();

			    String line = null;
			    int id = 1;
			    while((line = br.readLine())!=null)
			    {
			    	String data[] = line.split(";");
			    	if(data.length == 3)
			    	{
				    	User user = new User();
				    	
				        user.setId(id++);
				        user.setLastName(data[0]);
				        user.setFirstName(data[1]);
				        user.setEmail(data[2]);
				        
				        list.add(user);
			    	}
			    }
				
			    br.close();
			    fr.close();
			    
			    ev.getServletContext().setAttribute("userlist",list);	
			}
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}		
	}

	public void contextDestroyed(ServletContextEvent ev) 
	{		
	    try 
		{
			ev.getServletContext().removeAttribute("userlist");
			
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}		
	}
}
