function clearChildNodes(id)
{
    var elem = document.getElementById(id);
    while (elem.childNodes.length > 0)
    {
        elem.removeChild(elem.firstChild);
    }
}

function drawTable(tbodyID, dataArray, textFuncs)
{
    // assure bug-free redraw in Geck engine by
    // letting window show cleared table
    if (navigator.product && navigator.product == "Gecko")
    {
        setTimeout(function() { drawTableInner(tbodyID, dataArray, textFuncs); }, 0);
    }
    else
    {
        drawTableInner(tbodyID, dataArray, textFuncs);
    }
}

function drawTableInner(tbodyID, dataArray, textFuncs)
{
    var frag = document.createDocumentFragment();

    // loop through data source
    for (var i = 0; i < dataArray.length; i++)
    {
        var tr = document.createElement("tr");

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
                if (isHTMLElement(reply))
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

    var tbody = document.getElementById(tbodyID);
    tbody.appendChild(frag);
}

function setEnabled(id, state)
{
    var ele = document.getElementById(id);
    if (ele == null)
    {
        alert("Element id: "+id+" not found.");
        return;
    }

    // If we want to get funky and disable divs and spans by changing the font
    // colour or something then we might want to check the element type before
    // we make assumptions, but in the mean time ...
    // if (isHTMLInputElement(ele)) { ...

    ele.disabled = !state;
    ele.readonly = !state;
    if (is_ie)
    {
        if (state)
        {
            ele.style.backgroundColor = "White";
        }
        else
        {
            // This is WRONG but the hack will do for now.
            ele.style.backgroundColor = "Scrollbar";
        }
    }
}

var agt = navigator.userAgent.toLowerCase();
var is_major = parseInt(navigator.appVersion);
var is_minor = parseFloat(navigator.appVersion);

var is_nav = ((agt.indexOf('mozilla') != -1) && (agt.indexOf('spoofer') == -1)
             && (agt.indexOf('compatible') == -1) && (agt.indexOf('opera') == -1)
             && (agt.indexOf('webtv') == -1) && (agt.indexOf('hotjava') == -1));

var is_nav4up = (is_nav && (is_major >= 4));
var is_nav6up = (is_nav && (is_major >= 5));
var is_gecko = (agt.indexOf('gecko') != -1);

var is_ie     = ((agt.indexOf("msie") != -1) && (agt.indexOf("opera") == -1));
var is_ie3    = (is_ie && (is_major < 4));
var is_ie4    = (is_ie && (is_major == 4) && (agt.indexOf("msie 4")!=-1) );
var is_ie4up  = (is_ie && (is_major >= 4));
var is_ie5    = (is_ie && (is_major == 4) && (agt.indexOf("msie 5.0")!=-1) );
var is_ie5_5  = (is_ie && (is_major == 4) && (agt.indexOf("msie 5.5") !=-1));
var is_ie5up  = (is_ie && !is_ie3 && !is_ie4);
var is_ie5_5up =(is_ie && !is_ie3 && !is_ie4 && !is_ie5);
var is_ie6    = (is_ie && (is_major == 4) && (agt.indexOf("msie 6.")!=-1) );
var is_ie6up  = (is_ie && !is_ie3 && !is_ie4 && !is_ie5 && !is_ie5_5);

function isHTMLElement(ele)
{
    // There must be a better way
    if (is_gecko)
    {
        return typeof ele == "object" && ele instanceof HTMLElement;
    }
    else
    {
        // assume it is an html element if has an outerhtml property
        return typeof ele == "object" && ele.nodeName != null;
    }
}

function isHTMLInputElement(ele)
{
    // There must be a better way
    if (is_gecko)
    {
        return typeof ele == "object" && ele instanceof HTMLInputElement;
    }
    else
    {
        // assume it is an input element if it can take focus
        // we might use disabled, since that is used in setEnabled
        return typeof ele == "object" && ele.nodeName.toLowerCase() == "input";
    }
}

function isHTMLSelectElement(ele)
{
    // There must be a better way
    if (is_gecko)
    {
        return typeof ele == "object" && ele instanceof HTMLSelectElement;
    }
    else
    {
        // assume it is an input element if it has options
        return typeof ele == "object" && ele.options;
    }
}

function setValue(id, val)
{
    if (val == null)
    {
        val = "";
    }

    var ele = document.getElementById(id);
    if (ele == null)
    {
        alert("Element id: "+id+" not found.");
        return;
    }

    if (isHTMLSelectElement(ele))
    {
        // search through the values
        var found  = false;
        for (var i = 0; i < ele.options.length; i++)
        {
            if (ele.options[i].value == val)
            {
                ele.options[i].selected = true;
                found = true;
            }
            else
            {
                ele.options[i].selected = false;
            }
        }

        // If that fails then try searching through the visible text
        if (found)
        {
            return;
        }

        for (var i = 0; i < ele.options.length; i++)
        {
            if (ele.options[i].text == val)
            {
                ele.options[i].selected = true;
                break;
            }
        }

        return;
    }

    if (isHTMLInputElement(ele))
    {
        switch (ele.type)
        {
        case "check-box":
        case "radio":
            ele.checked = (val == true);
            return;

        case "hidden":
        case "text":
        case "textarea":
            ele.value = val;
            return;

        default:
            alert("Not sure how to setValue on a input element of type " + ele.type);
            ele.value = val;
            return;
        }
    }

    if (isHTMLElement(ele))
    {
        try
        {
            ele.innerHTML = val;
            return;
        }
        catch (ex)
        {
            return;
        }
    }

    alert("Not sure how to setValue on a " + ele);
    ele.innerHTML = val;
}

function getValue(id)
{
    var ele = document.getElementById(id);

    if (ele == null)
    {
        alert("Element id: "+id+" not found.");
        return;
    }

    if (isHTMLSelectElement(ele))
    {
        // This is a bit of a scam because it assumes single select
        // but I'm not sure how we should treat multi-select.
        for (var i = 0; i < ele.options.length; i++)
        {
            if (ele.options[i].selected == true)
            {
                return ele.options[i].value;
            }
        }

        return "";
    }

    if (isHTMLInputElement(ele))
    {
        switch (ele.type)
        {
        case "check-box":
        case "radio":
            return ele.checked;

        case "hidden":
        case "text":
        case "textarea":
            return ele.value;

        default:
            alert("Not sure how to setValue on a input element of type " + ele.type);
            return ele.value;
        }
    }

    if (isHTMLElement(ele))
    {
        return ele.innerHTML;
    }

    alert("Not sure how to getValue from a " + ele);
    return ele.innerHTML;
}

function setValues(map)
{
    for (var property in map)
    {
        var value = map[property];
        setValue(property, value);
    }
}

function fillList(id, data)
{
    var ele = document.getElementById(id);
    ele.options.length = 0;
    for (var i = 0; i < data.length; i++)
    {
        var opt = new Option(data[i]);
        ele.options[ele.options.length] = opt;
    }
}

function fillList(id, data, valueprop, textprop)
{
    var ele = document.getElementById(id);
    ele.options.length = 0;
    for (var i = 0; i < data.length; i++)
    {
        var opt = new Option(data[i][textprop], data[i][valueprop]);
        ele.options[ele.options.length] = opt;
    }
}

function callOnLoad(load)
{
    if (window.addEventListener)
    {
        window.addEventListener("load", load, false);
    }
    else if (window.attachEvent)
    {
        window.attachEvent("onload", load);
    }
    else if (document.getElementById)
    {
        window.onload = load;
    }
}
