
function update() {
  var name = DWRUtil.getValue("demoName");
  Demo.sayHello(name, function(data) {
    DWRUtil.setValue("demoReply", data);
  });
}

function forward() {
  Demo.getInclude(function(data) {
    DWRUtil.setValue("forward", data);
  });
}
