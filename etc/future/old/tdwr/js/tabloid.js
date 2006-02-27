
function Tabloid(){}

/*
*	listvalue: contains data needed to generate tabloid
*	id: id of the <th>, will be replaced by up,down or sortable
*	fname: name of the update function 
*	name: name of the field (ex: firstName, lastName in the case of User object)
*	display: text to be shown in the <th>
*/

Tabloid.drawHeader = function(listvalue,id,fname,name,display)
{
	DWRUtil.removeAllRows(id);
	
	var sortable = "sortable";
	if( (name == listvalue.order) && listvalue.asc) sortable="down";
    else if((name == listvalue.order) && !listvalue.asc) sortable="up";

	var th = document.getElementById(id);
	var className = "class";
	if(DWRUtil._isIE) className = "className"; // ie.. no comment
	th.setAttribute(className, sortable);	

	var a = document.createElement("a");
	a.setAttribute("href","#");
	
	var generate = "return ";
	generate += fname;
	generate += "(";
	generate += listvalue.page;
	generate += ",";
	generate += listvalue.max;
	generate += ",\"";
	generate += name;
	generate += "\",";
	generate += !listvalue.asc;
	generate += ",\"";
	generate += listvalue.filter;
	generate += "\")";

	a.setAttribute("onclick",generate);
	a.innerHTML = display;
	th.appendChild(a);

}

/*
* 	draw info span: something like "82 items found, displaying 1 to 20" 
*	listvalue: contains data needed to generate tabloid
*	id: id of the <span>
*/

Tabloid.drawInfo = function(listvalue,id)
{
	DWRUtil.removeAllRows(id);
	
	var generate =  "";
	
	generate += listvalue.itemNumber;
	generate += "&nbsp;items found, displaying&nbsp;";
    generate += listvalue.pageFirstItem;		
    generate += "&nbsp;to&nbsp;"; 		
    generate += listvalue.pageLastItem;
    
    $(id).innerHTML = generate;
}

/*
* draw pages link span, something like "[First/Prev] 1,2,3,4,5,6,7,8,9,10,11 [Next/Last]"
*	listvalue: contains data needed to generate tabloid
*	id: id of the <span>
*	fname: name of the update function 
*/

Tabloid.drawPages = function(listvalue,id,fname)
{
	DWRUtil.removeAllRows(id);
	var span = $(id)
	
	if(listvalue.page<2)
    {
    	var text = document.createTextNode("[First/Prev] ");
    	span.appendChild(text);
    }
    else
    {
    	var text = document.createTextNode("[");
    	span.appendChild(text);
    
    	var a = document.createElement("a");
		a.setAttribute("href","#");	
		  		
    	var generate =  "return ";
		generate += fname;
		generate += "(1,";
		generate += listvalue.max;
		generate += ",\"";
		generate += listvalue.order;
		generate += "\",";
		generate += listvalue.asc;
		generate += ",\"";
		generate += listvalue.filter;
		generate += "\")";
		
		a.setAttribute("onclick",generate);
		a.innerHTML = "First"; 
		
		span.appendChild(a);
		
		var text = document.createTextNode("/");
    	span.appendChild(text);
		  
		a = document.createElement("a");
		a.setAttribute("href","#");	
		
		generate =  "return ";
		generate += fname;
		generate += "(";
		generate += listvalue.page-1;
		generate += ",";
		generate += listvalue.max;
		generate += ",\"";
		generate += listvalue.order;
		generate += "\",";
		generate += listvalue.asc;
		generate += ",\"";
		generate += listvalue.filter;
		generate += "\")";  
		
		a.setAttribute("onclick",generate);  
		a.innerHTML = "Prev";     
		
		span.appendChild(a);
		
		text = document.createTextNode("] ");
    	span.appendChild(text);
		
	}  
	
	page = listvalue.page;
	pageNumber = listvalue.pageNumber; 
	fromPage = 1;
	toPage = pageNumber;
        
	if(listvalue.pageNumber>1)
	{
		diff = 5;
            
		if(page> pageNumber-5 & pageNumber>6) diff = 10 - (pageNumber-page);
            
		fromPage = page-diff;
		if(fromPage<1) fromPage = 1;
        
		toPage = fromPage+10;
		if(toPage>pageNumber) toPage = pageNumber;
	}
        
	for(i = fromPage; i< toPage+1; i++)
	{
		if(i==page) 
		{
			var strong = document.createElement("strong");	
			var text = document.createTextNode(i);
			strong.appendChild(text);
    		span.appendChild(strong);
		}
		else
		{
			var a = document.createElement("a");
			a.setAttribute("href","#");	
			
			var generate = "return ";
			generate += fname;
			generate += "(";
			generate += i;
			generate += ",";
			generate += listvalue.max;
			generate += ",\"";
			generate += listvalue.order;
			generate += "\",";
			generate += listvalue.asc;
			generate += ",\"";
			generate += listvalue.filter;
			generate += "\")";
			
			a.setAttribute("onclick",generate);  
			a.setAttribute("title","Go to page "+i);  
			a.innerHTML = i;     
		
			span.appendChild(a);	
		}
            
		if(i!=toPage) 
		{	
			var text = document.createTextNode(",");
    		span.appendChild(text);
		}
	}
        
	if(page == pageNumber)
	{
		var text = document.createTextNode(" [Next/Last]");
    	span.appendChild(text);
	}
	else
	{
	    var text = document.createTextNode(" [");
    	span.appendChild(text);
    	
		var a = document.createElement("a");
		a.setAttribute("href","#");	
			
		var generate = "return ";
		generate += fname;
		generate += "(";
		generate += page+1;
		generate += ",";
		generate += listvalue.max;
		generate += ",\"";
		generate += listvalue.order;
		generate += "\",";
		generate += listvalue.asc;
		generate += ",\"";
		generate += listvalue.filter;
		generate += "\")";
			
		a.setAttribute("onclick",generate);  
		a.innerHTML = "Next";     
		
		span.appendChild(a);
		
		text = document.createTextNode("/");
    	span.appendChild(text);
		
		var a = document.createElement("a");
		a.setAttribute("href","#");	
			
		generate = "return ";
		generate += fname;
		generate += "(";
		generate += pageNumber;
		generate += ",";
		generate += listvalue.max;
		generate += ",\"";
		generate += listvalue.order;
		generate += "\",";
		generate += listvalue.asc;
		generate += ",\"";
		generate += listvalue.filter;
		generate += "\")";
			
		a.setAttribute("onclick",generate);   
		a.innerHTML = "Last";     
		
		span.appendChild(a);
		
		text = document.createTextNode("]");
    	span.appendChild(text);

	}
}

/************************************************
* stolen DWRUtil function with even and odd row *
*************************************************/

Tabloid.drawTable = function(tbodyID, dataArray, textFuncs, alternate)
{
    // assure bug-free redraw in Geck engine by
    // letting window show cleared table
    if (navigator.product && navigator.product == "Gecko")
    {
        setTimeout(function() { Tabloid.drawTableInner(tbodyID, dataArray, textFuncs, alternate); }, 0);
    }
    else
    {
        Tabloid.drawTableInner(tbodyID, dataArray, textFuncs, alternate);
    }
}

Tabloid.drawTableInner = function(tbodyID, dataArray, textFuncs, alternate)
{
	var className = "class";
	if(DWRUtil._isIE) className = "className"; // ie.. no comment

    var frag = document.createDocumentFragment();

    // loop through data source
    for (var i = 0; i < dataArray.length; i++)
    {
        var tr = document.createElement("tr");
        
        if(alternate)
        {
        	if(i%2==0) tr.setAttribute(className,"even");
        	else tr.setAttribute(className,"odd");
        }

        for (var j = 0; j < textFuncs.length; j++)
        {
            var td = document.createElement("td");
            tr.appendChild(td);

            var func = textFuncs[j];
            if (typeof func == "string" || func instanceof String)
            {
                var text = document.createTextNode(func);
                td.appendChild(text);
            }
            else
            {
                var reply = func(dataArray[i]);
                if (DWRUtil.isHTMLElement(reply))
                {
                    td.appendChild(reply);
                }
                else
                {
                    td.innerHTML = reply;
                    //var text = document.createTextNode(reply);
                    //td.appendChild(text);
                }
            }
        }

        frag.appendChild(tr);
    }

    var tbody = $(tbodyID);
    tbody.appendChild(frag);
}
