
function init() {
  DWREngine.setReverseAjax(true);
}

function notifyTyping(ele) {
  var id = ele.id;
  var value = DWRUtil.getValue(ele);
  LiveHelp.notifyTyping(id, value);
}

function notifyFocus(ele) {
  var id = ele.id;
  LiveHelp.notifyFocus(id);
}

function notifyBlur(ele) {
  var id = ele.id;
  var value = DWRUtil.getValue(ele);

  LiveHelp.notifyBlur(id);

  if (id == "helpName") {
    var valid = value.length > 3;
    DWRUtil.setValue("helpNameError", valid ? "" : "Please enter your name");
    $("helpName").className = valid ? "valid" : "invalid";
  }
  else if (id == "helpEmail") {
    EmailValidator.isValid(value, function(valid) {
      DWRUtil.setValue("helpEmailError", valid ? "" : "Please enter a valid email address");
      $("helpEmail").className = valid ? "valid" : "invalid";
    });
  }
  else if (id == "helpAcct") {
    var valid = value.match(/[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]/);
    DWRUtil.setValue("helpAcctError", valid ? "" : "Please enter a valid account number");
    $("helpAcct").className = valid ? "valid" : "invalid";
  }
  else if (id == "helpSort") {
    var valid = value.match(/[0-9][0-9]-[0-9][0-9]-[0-9][0-9]/);
    DWRUtil.setValue("helpSortError", valid ? "" : "Please enter a valid sort code");
    $("helpSort").className = valid ? "valid" : "invalid";
  }
}
