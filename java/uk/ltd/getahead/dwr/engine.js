// engine.js

/**
 * Declare a constructor function to which we can add real functions.
 * @constructor
 */
function DWREngine()
{
}

/**
 * Constants to pick the XMLHttpRequest remoting method.
 * For example:
 * <code>DWREngine.setMethod(DWREngine.XMLHttpRequest);</code>
 * @see DWREngine.setMethod() 
 * @see DWREngine.IFrame
 */
DWREngine.XMLHttpRequest = 1;

/**
 * Constants to pick the iframe remoting method.
 * For example:
 * <code>DWREngine.setMethod(DWREngine.IFrame);</code>
 * @see DWREngine.setMethod()
 * @see DWREngine.XMLHttpRequest
 */
DWREngine.IFrame = 2;

/**
 * The default error handler displays an alert box, but that is not correct
 * for all applications, so this method allows you to set an alternative
 * error handler.
 * The default error handler is DWREngine.defaultMessageHandler so you can
 * change the error handler back to the original.
 * @param handler A function to call with single an error parameter on failure
 * @see DWREngine.defaultMessageHandler()
 */
DWREngine.setErrorHandler = function(handler)
{
    DWREngine._errorHandler = handler;
}

/**
 * The default warning handler displays an alert box, but that is not correct
 * for all applications, so this method allows you to set an alternative
 * warning handler.
 * The default warning handler is DWREngine.defaultMessageHandler so you can
 * change the warning handler back to the original.
 * @param handler A function to call with single an warning parameter on failure
 * @see DWREngine.defaultMessageHandler()
 */
DWREngine.setWarningHandler = function(handler)
{
    DWREngine._warningHandler = handler;
}

/**
 * The Pre-Hook is called before any DWR remoting is done.
 * Pre hooks can be useful for displaying "please wait" messages.
 * @param handler A function to call with no params before remoting
 * @see DWREngine.setPostHook()
 */
DWREngine.setPreHook = function(handler)
{
    DWREngine._preHook = handler;
}

/**
 * The Post-Hook is called after any DWR remoting is done.
 * Pre hooks can be useful for removing "please wait" messages.
 * @param handler A function to call with no params after remoting
 * @see DWREngine.setPreHook()
 */
DWREngine.setPostHook = function(handler)
{
    DWREngine._postHook = handler;
}

/**
 * Set the preferred remoting method.
 * setMethod does not guarantee that the selected method will be used, just that
 * we will try that method first.
 * @param newmethod One of DWREngine.XMLHttpRequest or DWREngine.IFrame
 */
DWREngine.setMethod = function(newmethod)
{
    if (newmethod != DWREngine.XMLHttpRequest && newmethod != DWREngine.IFrame)
    {
        DWREngine._warningHandler("Remoting method must be one of DWREngine.XMLHttpRequest or DWREngine.IFrame");
        throw newmethod;
    }

    DWREngine._method = newmethod;
}

/**
 * Which HTTP verb do we use so send results?
 * Must be one of "GET" or "POST".
 * @param verb the new HTTP verb.
 */
DWREngine.setVerb = function(verb)
{
    if (verb != "GET" && verb != "POST")
    {
        DWREngine._warningHandler("Remoting verb must be one of GET or POST");
        throw newmethod;
    }

    DWREngine._verb = verb;
}

/**
 * Do we attempt to ensure that remote calls happen in the order in which they
 * were sent? (Default: false)
 * Warning: Setting this to true will significantly slow down you application
 * @param ordered true or false
 */
DWREngine.setOrdered = function(ordered)
{
    DWREngine._ordered = ordered;
}

/**
 * The default message handler.
 * Useful in calls to setErrorHandler() or setWarningHandler() to allow you to
 * get the default back.
 * @param message The message to display to the user somehow
 */
DWREngine.defaultMessageHandler = function(message)
{
    if (typeof message == "object" && message.name == "Error" && message.description)
    {
        alert("Error: " + message.description);
    }
    else
    {
        alert(message);
    }
}

/**
 * You can group several remote calls together using a batch.
 * This saves on round trips to the server so there is much less latency involved.
 * @see DWREngine.endBatch()
 */
DWREngine.beginBatch = function()
{
    // Setup a batch
    DWREngine._batch = {};
    DWREngine._batch.map = {};
    DWREngine._batch.paramCount = 0;
    DWREngine._batch.map.callCount = 0;

    DWREngine._batches[DWREngine._batches.length] = DWREngine._batch;
}

/**
 * We are finished grouping a set of remote calls together, now go and execute
 * them all.
 */
DWREngine.endBatch = function()
{
    // if (call.id == DWREngine._nowServingNumber)
    // {
        DWREngine._sendData(DWREngine._batch);
    // }

    DWREngine._batch = null;
}

//==============================================================================
// Only private stuff below here
//==============================================================================

/**
 * A function to call if something fails.
 * @private
 */
DWREngine._errorHandler = DWREngine.defaultMessageHandler;

/**
 * A function to call to alert the user to some breakage.
 * @private
 */
DWREngine._warningHandler = DWREngine.defaultMessageHandler;

/**
 * A function to be called before requests are marshalled. Can be null.
 * @private
 */
DWREngine._preHook = null;

/**
 * A function to be called after replies are received. Can be null.
 * @private
 */
DWREngine._postHook = null;

/**
 * A map of all the known current batches
 * @private
 */
DWREngine._batches = new Array();

/**
 * A map of all the known current batches
 * @private
 */
DWREngine._callbacks = {};

/**
 * What is the default remoting method
 * @private
 */
DWREngine._method = DWREngine.XMLHttpRequest;

/**
 * What is the default remoting verb (ie GET or POST)
 * @private
 */
DWREngine._verb = "POST";

/**
 * Do we attempt to ensure that remote calls happen in the order in which they
 * were sent?
 * @private
 */
DWREngine._ordered = false;

/**
 * The current batch (if we are in batch mode)
 * @private
 */
DWREngine._batch = null;

/**
 * Each reply made to the server can be forced to happen in turn. This variable
 * tracks which we are currently executing.
 * @private
 */
//DWREngine._nowServingNumber = 0;

/**
 * Called when the replies are received.
 * This method is called by Javascript that is emitted by server
 * @param id The identifier of the call that we are handling a response for
 * @param reply The data to pass to the callback function
 * @private
 */
DWREngine._handleResponse = function(id, reply)
{
    var func = DWREngine._callbacks[id];

    // For some bizarre reason when the above fails on IE5 the following
    // sometimes works.
    if (func == null)
    {
        for (test in DWREngine._callbacks)
        {
            if (test == id)
            {
                func = DWREngine._callbacks[test];
            }
        }
    }

    // Clear this callback out of the list - we don't need it any more
    DWREngine._callbacks[id] = null;

    if (func != null)
    {
        // Error handlers inside here indicate an error that is nothing to do
        // with DWR so we handle them differently.
        try
        {
            func(reply);
        }
        catch (ex)
        {
            if (DWREngine._errorHandler != null)
            {
                DWREngine._errorHandler(ex);
            }
        }
    }
    else
    {
        if (reply != null)
        {
            for (test in DWREngine._calls)
            {
                known += test + "\n";
            }

            if (DWREngine._warningHandler != null)
            {
                DWREngine._warningHandler("Internal Error: Call with id='"+id+"' unknown.\nI do know about the following:\n"+known);
            }
        }
    }
}

/**
 * Called when errors are received.
 * This method is called by Javascript that is emitted by server
 * @private
 */
DWREngine._handleError = function(id, reason)
{
    if (DWREngine._errorHandler != null)
    {
        DWREngine._errorHandler(reason);
    }
}

/**
 * Call right at the end of a batch being executed to clear up
 * @param batch The batch to tidy up after
 * @private
 */
DWREngine._finalize = function(batch)
{
    if (batch.iframe != null)
    {
        batch.iframe.parentNode.removeChild(batch.iframe);
    }

    if (batch.form != null)
    {
        batch.form.parentNode.removeChild(batch.form);
    }

    if (DWREngine._postHook != null)
    {
        DWREngine._postHook();
    }

    // TODO: There must be a better way???
    for (var i = 0; i < DWREngine._batches.length; i++)
    {
        if (DWREngine._batches[i] == batch)
        {
            DWREngine._batches[i] = null;
        }
    }

    // DWREngine._nowServingNumber++;
    // if (DWREngine._nowServingNumber < DWREngine._batches.length)
    // {
    //     DWREngine._sendData(DWREngine._batches[DWREngine._nowServingNumber]);
    // }
}

/**
 * Send a request to the server
 * This method is called by Javascript that is emitted by server
 * @param func The callback function to which any returned data should be passed
 *             if this is null, any returned data will be ignored
 * @param path The part of the URL after the host and before the exec bit
 *             without leading or trailing /s
 * @param scriptName The class to execute
 * @param methodName The method on said class to execute
 * @param vararg_params The parameters to pass to the above class
 * @private
 */
DWREngine._execute = function(func, path, scriptName, methodName, vararg_params)
{
    var singleShot = false;
    if (DWREngine._batch == null)
    {
        DWREngine.beginBatch();
        singleShot = true;
    }

    // All the paths MUST be to the same servlet
    if (DWREngine._batch.path == undefined)
    {
        DWREngine._batch.path = path;
    }
    else
    {
        if (DWREngine._batch.path != path)
        {
            if (DWREngine._errorHandler != null)
            {
                DWREngine._errorHandler("Can't batch requests to multiple DWR Servlets.");
            }

            return;
        }
    }

    // Check on the function
    if (func != null && typeof func != "function" && typeof func != "object")
    {
        if (DWREngine._warningHandler != null)
        {
            DWREngine._warningHandler("Supplied callback function is neither null nor a function: " + func);
        }

        throw func;
    }

    // Get a unique ID for this call
    // var random = Math.floor(Math.random() * 10001);
    // var id = (random + "_" + new Date().getTime()).toString();
    // var id = DWREngine._batches.length;
    var id = idbase++;

    DWREngine._callbacks[id] = func

    var prefix = "c" + DWREngine._batch.map.callCount + "-";

    DWREngine._batch.map[prefix + "scriptName"] = scriptName;
    DWREngine._batch.map[prefix + "methodName"] = methodName;
    DWREngine._batch.map[prefix + "id"] = id;

    // Serialize the parameters into batch.map
    DWREngine._addSerializeFunctions();
    for (var i = 4; i < arguments.length; i++)
    {
        DWREngine._serializeAll(DWREngine._batch, [], arguments[i], prefix + "param" + (i - 4));
    }
    DWREngine._removeSerializeFunctions();

    // Now we have finished remembering the call, we incr the call count
    DWREngine._batch.map.callCount++;

    if (singleShot)
    {
        DWREngine.endBatch();
    }
}
var idbase = 0;
/**
 * Actually send the block of data in the batch object.
 * @param batch Block of data about the calls we are making on the server
 * @private
 */
DWREngine._sendData = function(batch)
{
    // Actually make the call
    if (DWREngine._preHook != null)
    {
        DWREngine._preHook();
    }

    // Get setup for XMLHttpRequest if possible
    if (DWREngine._method == DWREngine.XMLHttpRequest)
    {
        if (window.XMLHttpRequest)
        {
            batch.req = new XMLHttpRequest();
        }
        // IE5 for the mac claims to support window.ActiveXObject, but throws an error when it's used
        else if (window.ActiveXObject && !(navigator.userAgent.indexOf('Mac') >= 0 && navigator.userAgent.indexOf("MSIE") >= 0))
        {
            batch.req = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }    

    // A quick string to help people that use web log analysers
    var statsInfo;
    if (batch.map.callCount == 1)
    {
        statsInfo = batch.map["c0-scriptName"] + "." + batch.map["c0-methodName"];
    }
    else
    {
        statsInfo = "Multiple." + batch.length;
    }

    var query = "";
    var prop;

    if (batch.req)
    {
        batch.map.xml = true;

        // Proceed using XMLHttpRequest
        batch.req.onreadystatechange = function() { DWREngine._stateChange(batch); };

        if (DWREngine._verb == "GET" || navigator.userAgent.indexOf('Mac') >= 0)
        {
            for (prop in batch.map)
            {
                query += prop + "=" + batch.map[prop] + "&";
            }
            query = query.substring(0, query.length - 1);

            batch.req.open("GET", batch.path + "/exec/" + statsInfo + "?" + query);
            batch.req.send(null);
        }
        else
        {
            for (prop in batch.map)
            {
                query += prop + "=" + batch.map[prop] + "\n";
            }

            batch.req.open("POST", batch.path + "/exec/" + statsInfo, true);
            batch.req.send(query);
        }
    }
    else
    {
        batch.map.xml = false;

        // Proceed using iframe
        for (prop in batch.map)
        {
            query += prop + "=" + batch.map[prop] + "&";
        }
        query = query.substring(0, query.length - 1);

        var div = document.createElement('div');
        div.innerHTML = "<iframe id='dwr-iframe' name='dwr-iframetarget'></iframe>";
        document.body.appendChild(div);
        batch.iframe = document.getElementById('dwr-iframe');
        batch.iframe.setAttribute('style', 'width:0px; height:0px; border:0px;');

        if (DWREngine._verb == "GET")
        {
            batch.iframe.setAttribute('src', batch.path + "/exec/" + statsInfo + "?" + query);
            document.body.appendChild(batch.iframe);
        }
        else
        {
            batch.form = document.createElement('form');
            batch.form.setAttribute('id', 'dwr-form');
            batch.form.setAttribute('action', batch.path + "/exec" + statsInfo);
            batch.form.setAttribute('target', 'dwr-iframetarget');
            batch.form.target='dwr-iframetarget';
            batch.form.setAttribute('method', 'post');
            for (prop in batch.map)
            {
                var formInput = document.createElement('input');
                formInput.setAttribute('type', 'hidden');
                formInput.setAttribute('name', prop);
                formInput.setAttribute('value', batch.map[prop]);
                batch.form.appendChild(formInput);
            }

            document.body.appendChild(batch.form);
            batch.form.submit();
        }
    }
}

/**
 * Called by XMLHttpRequest to indicate that something has happened
 * @private
 */
DWREngine._stateChange = function(batch)
{
    if (batch.req.readyState == 4)
    {
        try
        {
            if (batch.req.status && batch.req.status == 200)
            {
                eval(batch.req.responseText);
            }
            else
            {
                if (DWREngine._errorHandler != null)
                {
                    DWREngine._errorHandler(batch.req.responseText);
                }
            }
        }
        catch (ex)
        {
            if (DWREngine._errorHandler != null)
            {
                DWREngine._errorHandler(ex);
            }
        }
    }

    DWREngine._finalize(batch);
}

/**
 * Hack a polymorphic dwrSerialize() function on all basic types. Yeulch
 * @see DWREngine._addSerializeFunctions
 * @private
 */
DWREngine._addSerializeFunctions = function()
{
    Object.prototype.dwrSerialize = DWREngine._serializeObject;
    Array.prototype.dwrSerialize = DWREngine._serializeArray;
    Boolean.prototype.dwrSerialize = DWREngine._serializeBoolean;
    Number.prototype.dwrSerialize = DWREngine._serializeNumber;
    String.prototype.dwrSerialize = DWREngine._serializeString;
    Date.prototype.dwrSerialize = DWREngine._serializeDate;
}

/**
 * Remove the hacked polymorphic dwrSerialize() function on all basic types.
 * @see DWREngine._removeSerializeFunctions
 * @private
 */
DWREngine._removeSerializeFunctions = function()
{
    delete Object.prototype.dwrSerialize;
    delete Array.prototype.dwrSerialize;
    delete Boolean.prototype.dwrSerialize;
    delete Number.prototype.dwrSerialize;
    delete String.prototype.dwrSerialize;
    delete Date.prototype.dwrSerialize;
}

/**
 * Marshall a data item
 * @param batch A map of variables to how they have been marshalled
 * @param referto An array of already marshalled variables to prevent recurrsion
 * @param data The data to be marshalled
 * @param name The name of the data being marshalled
 * @private
 */
DWREngine._serializeAll = function(batch, referto, data, name)
{
    if (data == null)
    {
        batch.map[name] = "null:null";
        return;
    }

    switch (typeof data)
    {
    case "boolean":
        batch.map[name] = "boolean:" + data;
        break;

    case "number":
        batch.map[name] = "number:" + data;
        break;

    case "string":
        batch.map[name] = "string:" + encodeURIComponent(data);
        break;

    case "object":
        if (data.dwrSerialize)
        {
            batch.map[name] = data.dwrSerialize(batch, referto, data, name);
        }
        else
        {
            if (DWREngine._warningHandler != null)
            {
                DWREngine._warningHandler("Object without dwrSerialize: " + typeof data + ", attempting default converter.");
            }
            batch.map[name] = "default:" + data;
        }
        break;

    case "function":
        // We just ignore functions.
        break;

    default:
        if (DWREngine._warningHandler != null)
        {
            DWREngine._warningHandler("Unexpected type: " + typeof data + ", attempting default converter.");
        }
        batch.map[name] = "default:" + data;
        break;
    }
}

/**
 * This is for the types that can recurse so we need to check that we've not
 * marshalled this object before.
 * We'd like to do:
 *   var lookup = referto[data];
 * However hashmaps in Javascript appear to use the hash values of the *string*
 * versions of the objects used as keys so all objects count as the same thing.
 * So we need to have referto as an array and go through it sequentially
 * checking for equality with data
 * @private
 */
DWREngine._lookup = function(referto, data, name)
{
    var lookup;
    for (var i = 0; i < referto.length; i++)
    {
        if (referto[i].data === data)
        {
            lookup = referto[i];
            break;
        }
    }

    if (lookup != null)
    {
        return "reference:" + lookup.name;
    }

    referto.push({ data:data, name:name });
    return null;
}

/**
 * Marshall an object
 * @private
 * @see DWREngine._serializeAll()
 */
DWREngine._serializeObject = function(batch, referto, data, name)
{
    var ref = DWREngine._lookup(referto, this, name);
    if (ref != null)
    {
        return ref;
    }

    // treat objects as an associative arrays
    var reply = "Object:{"
    var element;
    for (element in this)
    {
        if (element != "dwrSerialize")
        {
            batch.paramCount++;
            var childName = "c" + DWREngine._batch.map.callCount + "-e" + batch.paramCount;
            DWREngine._serializeAll(batch, referto, this[element], childName);

            reply += encodeURIComponent(element);
            reply += ":reference:";
            reply += childName;
            reply += ", ";
        }
    }
    reply = reply.substring(0, reply.length - 2);
    reply += "}";

    return reply;
}

/**
 * Marshall an array
 * @private
 * @see DWREngine._serializeAll()
 */
DWREngine._serializeArray = function(batch, referto, data, name)
{
    var ref = DWREngine._lookup(referto, this, name);
    if (ref != null)
    {
        return ref;
    }

    var reply = "Array:["
    for (var i = 0; i < this.length; i++)
    {
        if (i != 0)
        {
            reply += ",";
        }

        batch.paramCount++;
        var childName = "c" + DWREngine._batch.map.callCount + "-e" + batch.paramCount;
        DWREngine._serializeAll(batch, referto, this[i], childName);
        reply += "reference:";
        reply += childName;
    }
    reply += "]";

    return reply;
}

/**
 * Marshall a Boolean
 * @private
 * @see DWREngine._serializeAll()
 */
DWREngine._serializeBoolean = function(batch, referto, data, name)
{
    return "Boolean:" + this;
}

/**
 * Marshall a Number
 * @private
 * @see DWREngine._serializeAll()
 */
DWREngine._serializeNumber = function(batch, referto, data, name)
{
    return "Number:" + this;
}

/**
 * Marshall a String
 * @private
 * @see DWREngine._serializeAll()
 */
DWREngine._serializeString = function(batch, referto, data, name)
{
    return "String:" + encodeURIComponent(this);
}

/**
 * Marshall a Date
 * @private
 * @see DWREngine._serializeAll()
 */
DWREngine._serializeDate = function(batch, referto, data, name)
{
    return "Date:[ " +
        this.getUTCFullYear() + ", " +
        this.getUTCMonth() + ", " +
        this.getUTCDate() + ", " +
        this.getUTCHours() + ", " +
        this.getUTCMinutes() + ", " +
        this.getUTCSeconds() + ", " +
        this.getUTCMilliseconds() + "]";
}

/**
 * Convert an XML string into a DOC object.
 * @param xml The xml string
 * @return a DOM version of the xml string 
 * @private
 */
DWREngine._unserializeDocument = function(xml)
{
    var parser = new DOMParser();
    var dom = parser.parseFromString(xml, "text/xml");

    if (!dom.documentElement || dom.documentElement.tagName == "parsererror")
    {
        var message = dom.documentElement.firstChild.data;
        message += "\n" + dom.documentElement.firstChild.nextSibling.firstChild.data;
        throw message;
    }

    return dom;
}

/**
 * @deprecated
 * The error handler function
 */
function dwrSetErrorHandler(handler)
{
    dwrDeprecated();
    DWREngine.setErrorHandler(handler);
}

/**
 * @deprecated
 * A pre execute hook
 */
function dwrSetPreHook(handler)
{
    dwrDeprecated();
    DWREngine.setPreHook(handler);
}

/**
 * @deprecated
 * A post execute hook
 */
function dwrSetPostHook(handler)
{
    dwrDeprecated();
    DWREngine.setPostHook(handler);
}

/**
 * Inform the users that the function they just called is deprecated.
 * @private
 */
function dwrDeprecated()
{
    if (DWREngine._warningHandler != null)
    {
        DWREngine._warningHandler("dwrXxx() functions are deprecated. Please convert to DWREngine.xxx()");
    }
}
