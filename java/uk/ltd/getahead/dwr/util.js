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
                if (typeof reply == "object" && reply instanceof HTMLElement)
                {
                    td.appendChild(reply);
                }
                else
                {
                    var text = document.createTextNode(reply);
                    td.appendChild(text);
                }
            }
        }

        frag.appendChild(tr);
    }

    var tbody = document.getElementById(tbodyID);
    tbody.appendChild(frag);
}

function getValue(id)
{
    var ele = document.getElementById(id);
    if (ele == null)
    {
        alert("Element id: "+id+" not found.");
        return;
    }

    if (ele instanceof HTMLInputElement)
    {
        return ele.value;
    }
    else if (ele instanceof HTMLSpanElement || ele instanceof HTMLDivElement)
    {
        return ele.innerHTML;
    }
    else
    {
        alert("Not sure how to getValue from a " + ele);
    }
}

function setValue(id, val)
{
    var ele = document.getElementById(id);
    if (ele == null)
    {
        alert("Element id: "+id+" not found.");
        return;
    }

    if (ele instanceof HTMLInputElement)
    {
        ele.value = val;
    }
    else if (ele instanceof HTMLSpanElement || ele instanceof HTMLDivElement)
    {
        ele.innerHTML = val;
    }
    else
    {
        alert("Not sure how to setValue on a " + ele);
    }
}
