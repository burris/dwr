// engine.js
var preHook;
var postHook;
var calls = new Object();
var errorHandler;

function Call(callback)
{
    this.callback = callback;
}

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

function dwrHandleResponse(id, reply)
{
    var call = calls[id];
    if (call == null)
    {
        var known = "";
        for (call in calls)
        {
            known += call + "\n";
        }
        alert("Internal Error: Call with id='"+id+"' unknown.\nI do know about the following:\n"+known);
        return;
    }

    if (call.iframe != null)
    {
        call.iframe.parentNode.removeChild(call.iframe);
    }

    if (call.callback == null)
    {
        if (reply != null)
        {
            alert("Missing callback for reply "+reply);
        }
    }
    else
    {
        call.callback(reply);
    }

    if (postHook != null)
    {
        postHook();
    }

    calls[id] = undefined;
}

function dwrHandleError(id, reason)
{
    var call = calls[id];
    if (call == null)
    {
        alert("Internal Error: Call with id="+id+" unknown.");
        return;
    }

    if (call.iframe != null)
    {
        call.iframe.parentNode.removeChild(call.iframe);
    }

    if (postHook != null)
    {
        postHook();
    }

    if (errorHandler != null)
    {
        errorHandler(reason);
    }
    else
    {
        alert(reason);
    }

    calls[id] = undefined;
}

function dwrGetID()
{
    var random = Math.floor(Math.random() * 10001);
    return (random + "_" + new Date().getTime()).toString();
}

function dwrExecute(func, classname, methodname, vararg_params)
{
    var call = new Call(func);
    call.id = dwrGetID();
    calls[call.id] = call;

    if (preHook != null)
    {
        preHook();
    }

    if (func != null && typeof func != "function")
    {
        alert("Supplied callback function is neither null nor a function: "+func);
        return;
    }

    call.callback = func;

    var argdata = '';
    for (var i=3; i<dwrExecute.arguments.length; i++)
    {
        argdata = argdata + '&param' + (i-3) + '=' + dwrExecute.arguments[i];
    }

    // Warning: if you can see EL-like (${...}) expressions on the next line, don't be fooled into thinking it is EL.
    // Check the source in DWRServlet for the hack. Maybe we will do something more EL like in the future.
    // If you can't see the ${...} then you are probably looking at the processed source
    call.url = '${request.contextPath}${request.servletPath}/exec?class='+classname+'&method='+methodname+argdata+'&id='+call.id;

    if (window.XMLHttpRequest)
    {
        call.req = new XMLHttpRequest();
        call.req.onreadystatechange = function() { dwrStateChange(call); };
        call.req.open("GET", call.url+'&xml=true', true);
        call.req.send(null);
    }
    /*
    The IE version appears to cache replies.
    else if (window.ActiveXObject)
    {
        // I've seen code that asks for the following:
        // call.req = new ActiveXObject("Msxml2.XMLHTTP");
        // followed by the version that we are using, in try/catch blocks
        // but try/catch isn't supported by all browsers so we ignore for the mo
        call.req = new ActiveXObject("Microsoft.XMLHTTP");
        if (call.req)
        {
            call.req.onreadystatechange = dwrStateChange;
            call.req.open("GET", call.url+'&xml=true', true);
            call.req.send();
        }
        else
        {
            alert("Creation of Microsoft.XMLHTTP failed. Aborting.");
        }
    }
    */
    else
    {
        call.iframe = document.createElement('iframe');
        call.iframe.setAttribute('id', 'dwr-iframe');
        call.iframe.setAttribute('style', 'width:0px; height:0px; border:0px;');
        call.iframe.setAttribute('src', call.url);
        document.body.appendChild(call.iframe);
    }
}

function dwrStateChange(call)
{
    if (call.req.readyState == 4)
    {
        eval(call.req.responseText);
    }
}
