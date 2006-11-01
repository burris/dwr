
function init() {
  var prop;
  for (prop in window) {
    if (prop.match(/test/) && typeof window[prop] == "function" && prop != "testEquals") {
      dwr.util.addOptions("buttons", [ prop ], function(data) {
        return "<button onclick='dwr.util.setValue(\"output\", \"\"); " + prop + "()'>" + prop.substring(4) + "</button>";
        // return "<input name='submit' type='image' src='imagebutton.png' onclick='dwr.util.setValue(\"output\", \"\"); " + prop + "()' />";
      });
    }
  }
}

function success(message) {
  var output = $('output').innerHTML + "<br/>\n" + message;
  dwr.util.setValue('output', output);
}

function failure(message) {
  alert(message);
}

function testAsyncNesting() {
  Test.slowStringParam("AsyncNesting-2", 100, function(data1) {
    success(data1);
    Test.slowStringParam("AsyncNesting-End", 200, function(data2) {
      success(data2);
    });
    success("AsyncNesting-3");
  });
  success("AsyncNesting-1");
}

function testSyncNesting() {
  dwr.engine.setAsync(false);
  Test.slowStringParam("SyncNesting-1", 100, function(data1) {
    success(data1);
    Test.slowStringParam("SyncNesting-2", 100, function(data2) {
      success(data2);
    });
    success("SyncNesting-3");
  });
  success("SyncNesting-End");
  dwr.engine.setAsync(true); 
}

function testSyncInCallMetaData() {
  Test.slowStringParam("SyncInCallMetaData-1", 100, {
    async:false,
    callback:function(data) {
      success(data);
    }
  });
  success("SyncInCallMetaData-End");
}

function testAsyncInCallMetaData() {
  Test.slowStringParam("AsyncInCallMetaData-End", 100, {
    async:true,
    callback:function(data) {
      success(data);
    }
  });
  success("AsyncInCallMetaData-1");
}

function testDefaultAsyncInCallMetaData() {
  Test.slowStringParam("DefaultAsyncInCallMetaData-End", 100, {
    callback:function(data) {
      success(data);
    }
  });
  success("DefaultAsyncInCallMetaData-1");
}
