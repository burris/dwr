
function verifyName() {
  var name = DWRUtil.getValue("name");
  if (name == null) {
    DWRUtil.setValue("nameError", "Please enter a name.");
    $("output").display = "none";
  }
  else {
    DWRUtil.setValue("nameError", "");
  }
}

function verifyAddress() {
  var address = DWRUtil.getValue("address");
  EmailValidator.isValid(DWRUtil.getValue("email"), function(valid) {
    DWRUtil.setValue("addressError", valid);
    $("output").display = (valid == null) ? "block" : "none";
  });
}

function process() {
  var address = DWRUtil.getValue("address");
  var name = DWRUtil.getValue("name");
  Generator.generateAntiSpamMailto(address, function(contents) {
    DWRUtil.setValue("outputExample", contents);
    DWRUtil.setValue("outputFull", contents);
    $("output").display = "block";
  });
}
