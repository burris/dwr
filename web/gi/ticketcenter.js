
function giLoaded() {
  dwr.engine.setActiveReverseAjax(true);
  deselect();
}

function giUnloaded() {
  cancelHandling();
}

function updateCallers(callers, now) {
  // Some tweaks so GI redraws everything without needing further explanation
  // We copy the id to jsxid, and ensure that the fields for the checkboxes are
  // 0 or 1 rather than true or false. We also check that any handled caller
  // is still around and has not hung up
  var caller;
  var handlingIdFound = false;
  for (var i = 0; i < callers.length; i++) {
    caller = callers[i];
    caller.timePlain = now - caller.callStarted;
    caller.time = 10000 * Math.round(caller.timePlain / 10000);
    caller.jsxid = caller.id;
    caller.handled = caller.handled ? "JSXAPPS/ticketcenter/images/configure.png" : "";
    caller.supervisorAlert = caller.supervisorAlert ? "JSXAPPS/ticketcenter/images/irkickflash.png" : "";
    callerCache[caller.id] = caller;
    if (!caller.name) caller.name = "?";
    if (caller.id == handlingId) {
      caller.handled = "JSXAPPS/ticketcenter/images/next.png";
      handlingIdFound = true;
    }
  }

  // Convert the data into a CDF document and post to GI
  var cdf = dwr.gi.toCdfDocument(callers, "jsxroot");
  ticketcenter.getCache().setDocument("callers", cdf);
  ticketcenter.getJSXByName('listCallers').repaint();

  // Work out what to do if the caller we're working on has hung up
  if (!handlingIdFound && handlingId != null) {
    alert("It appears that this caller has hung up. Please select another.");
    deselect();
  }
}

var handlingId = null;
var callerCache = {};

function completeHandling() {
  var caller = callerCache[handlingId];
  fillInCaller(caller);
  CallCenter.completeHandling(handlingId, caller, function(data) {
    if (data && data != "") alert(data);
    else deselect();
  });
}

function cancelHandling() {
  CallCenter.cancelHandling(handlingId, function(data) {
    if (data && data != "") alert(data);
    deselect();
  });
}

function alertSupervisor() {
  var caller = callerCache[handlingId];
  fillInCaller(caller);
  CallCenter.alertSupervisor(handlingId, caller, function(data) {
    if (data && data != "") alert(data);
    deselect();
  });
}

function fillInCaller(caller) {
  caller.name = ticketcenter.getJSXByName('textName').getValue();
  caller.address = ticketcenter.getJSXByName('textAddress').getValue();
  caller.notes = ticketcenter.getJSXByName('textNotes').getValue();
}

function beginHandling() {
  if (handlingId != null) {
    alert("Please finish handling the current call before selecting another");
    return;
  }
  var id = getSelectedId();
  CallCenter.beginHandling(id, function(reply) {
    if (reply && reply.length != 0) {
      alert(reply);
    }
    else {
      var caller = callerCache[id];
      if (caller == null) {
        alert("It appears that this caller has hung up. Please select another.");
      }
      else {
        handlingId = id;
        ticketcenter.getJSXByName('textPhone').setValue(caller.phoneNumber);
        ticketcenter.getJSXByName('textName').setValue(caller.name);
        ticketcenter.getJSXByName('textAddress').setValue(caller.address);
        ticketcenter.getJSXByName('textNotes').setValue(caller.notes);
        setFormEnabled(true);
        ticketcenter.getJSXByName('layoutForm').setBackgroundColor("#000");
      }
    }
  });
}

function deselect() {
  handlingId = null;
  forEach(fields, function(field) {
    field.setValue("");
  });
  setFormEnabled(false);
  ticketcenter.getJSXByName('layoutForm').setBackgroundColor("#EEE");
}

function getSelectedId() {
  var listCallers = ticketcenter.getJSXByName('listCallers');
  var selectedNode = listCallers.getSelectedNodes().get(0);
  return selectedNode.getAttribute('jsxid');
}

function setFormEnabled(enabled) {
  forEach(elements, function(field) {
    field.setEnabled(enabled, true);
  });
}

var fields = [ "textPhone", "textName", "textAddress", "textNotes" ];
var elements = [ "textPhone", "textName", "textAddress", "textPayment", "textNotes", "selectEvent", "selectPaymentType", "buttonBook", "buttonSupervisor", "buttonCancel" ];

function forEach(array, action) {
  for (var i = 0; i < array.length; i++) {
    action(ticketcenter.getJSXByName(array[i]));
  }  
}
