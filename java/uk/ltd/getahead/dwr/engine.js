// engine.js
var dwrPreHook;
var dwrPostHook;
var dwrCalls = new Object();
var dwrErrorHandler;

function dwrSetErrorHandler(handler)
{
    dwrErrorHandler = handler;
}

function dwrSetPreHook(handler)
{
    dwrPreHook = handler;
}

function dwrSetPostHook(handler)
{
    dwrPostHook = handler;
}

function dwrHandleResponse(id, reply)
{
    var call = dwrCalls[id];
    if (call == null)
    {
        var known = "";
        for (call in dwrCalls)
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

    if (dwrPostHook != null)
    {
        dwrPostHook();
    }

    dwrCalls[id] = undefined;
}

function dwrHandleError(id, reason)
{
    var call = dwrCalls[id];
    if (call == null)
    {
        alert("Internal Error: Call with id="+id+" unknown.");
        return;
    }

    if (call.iframe != null)
    {
        call.iframe.parentNode.removeChild(call.iframe);
    }

    if (dwrPostHook != null)
    {
        dwrPostHook();
    }

    if (dwrErrorHandler != null)
    {
        dwrErrorHandler(reason);
    }
    else
    {
        alert(reason);
    }

    dwrCalls[id] = undefined;
}

function dwrGetID()
{
    var random = Math.floor(Math.random() * 10001);
    return (random + "_" + new Date().getTime()).toString();
}

function dwrExecute(func, classname, methodname, vararg_params)
{
    var call = new Object();
    call.callback = func
    call.id = dwrGetID();
    dwrCalls[call.id] = call;

    if (dwrPreHook != null)
    {
        dwrPreHook();
    }

    if (func != null && typeof func != "function" && typeof func != "object")
    {
        alert("Supplied callback function is neither null nor a function: "+func);
        return;
    }

    call.callback = func;

    var argdata = '';
    for (var i=3; i<dwrExecute.arguments.length; i++)
    {
        var marshall = dwrMarshall(dwrExecute.arguments[i]);
        argdata = argdata + '&param' + (i-3) + '=' + marshall;
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

function dwrMarshall(data)
{
    if (data == null)
    {
        return 
    }

    switch (typeof data)
    {
    case "boolean":
        return data;

    case "number":
        return data;

    case "string":
        return encodeURIComponent(data);

    case "object":
        if (data instanceof Boolean)
        {
            return data;
        }
        else if (data instanceof Number)
        {
            return data;
        }
        else if (data instanceof String)
        {
            return encodeURIComponent(data);
        }
        else if (data instanceof Date)
        {
            return "[ " + data.getUTCFullYear() + ", " + data.getUTCMonth() + ", " + data.getUTCDate() + ", " + data.getUTCHours() + ", " + data.getUTCMinutes() + ", " + data.getUTCSeconds() + ", " + data.getUTCMilliseconds() + "]";
        }
        else if (data instanceof Array)
        {
            var reply = "["
            for (var i = 0; i < data.length; i++)
            {
                if (i != 0)
                {
                    reply += ",";
                }

                var marshalled = dwrMarshall(data[i]).toString();
                marshalled = marshalled.replace(/,/, "%2c");
                marshalled = marshalled.replace(/\[/, "%5b");
                marshalled = marshalled.replace(/\]/, "%5d");
                reply += marshalled;
            }
            reply += "]";
            return reply;
        }
        else
        {
             // treat anything else as an associative array (map)
            var reply = "{"
            for (element in data)
            {
                var marshalled = dwrMarshall(data[element]).toString();

                reply += element;
                reply += ":";
                reply += marshalled;
                reply += ", ";
            }
            reply.substring(0, reply.length - 2);
            reply += "}";
            return reply;
        }

    default:
        return data;
    }

    return data;
}

function dwrStateChange(call)
{
    if (call.req.readyState == 4)
    {
        if (call.req.status == 200)
        {
            eval(call.req.responseText);
        }
        else
        {
            dwrHandleError(call.id, call.req.responseText);
        }
    }
}
