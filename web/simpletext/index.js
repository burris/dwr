
function update() {
  Demo.getServerInfo(function(data) {
    DWRUtil.setValue("reply", data);
  });
}

function forward() {
  Demo.getInclude(function(data) {
    DWRUtil.setValue("forward", data);
  });
}
