// engine.js
var iframe;
var callback;
var preHook;
var postHook;
var req;

var errorHandler = function(data)
{
    alert(data);
};

function dwrSetErrorHandler(handler)
{
    errorHandler = handler;
}

function dwrPreHook(handler)
{
    preHook = handler;
}

function dwrPostHook(handler)
{
    postHook = handler;
}

function dwrHandleResponse(data)
{
    if (iframe != null)
    {
        iframe.parentNode.removeChild(iframe);
        iframe = null;
    }

    callback(data);
    callback = null;

    if (postHook != null)
    {
        postHook();
    }
}

function dwrHandleError(reason)
{
    if (iframe != null)
    {
        iframe.parentNode.removeChild(iframe);
        iframe = null;
    }

    if (postHook != null)
    {
        postHook();
    }

    if (errorHandler != null)
    {
        errorHandler(reason);
    }
}

function dwrExecute(func, classname, methodname, vararg_params)
{
    if (iframe != null)
    {
        alert('Warning previous call did not complete, old results may be lost.');
    }

    if (preHook != null)
    {

        preHook();
    }

    callback = func;

    var argdata = '';
    for (var i=3; i<dwrExecute.arguments.length; i++)
    {
        argdata = argdata + '&param' + (i-3) + '=' + dwrExecute.arguments[i];
    }

    // Warning: if you can see EL-like expressions on the next line, don't be fooled into thinking it is EL.
    // Check the source in DWRServlet for the hack. Maybe we will do something more EL like in the future.
    // If you can't see the ${...} then you are probably looking at the processed source
    var url = '${request.contextPath}${request.servletPath}/exec?class='+classname+'&method='+methodname+argdata;

    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
        req.onreadystatechange = dwrStateChange;
        req.open("GET", url+'&xml=true', true);
        req.send(null);
    }
    /*
    The IE version appears to cache replies.
    else if (window.ActiveXObject)
    {
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req)
        {
            req.onreadystatechange = dwrStateChange;
            req.open("GET", url+'&xml=true', true);
            req.send();
        }
        else
        {
            alert("Creation of Microsoft.XMLHTTP failed. Aborting.");
        }
    }
    */
    else
    {
        iframe = document.createElement('iframe');
        iframe.setAttribute('id', 'dwr-iframe');
        iframe.setAttribute('style', 'width:0px; height:0px; border:0px;');
        iframe.setAttribute('src', url);
        document.body.appendChild(iframe);
    }
}

function dwrStateChange()
{
    if (req.readyState == 4)
    {
        if (req.status == 200)
        {
            dwrHandleResponse(req.responseText)
        }
        else
        {
            dwrHandleError(req.statusText)
        }
    }
}

