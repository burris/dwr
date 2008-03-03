
Jaxer.dwr = {};

Jaxer.dwr.pathToDwrServlet = null;

Jaxer.dwr.require = function(sources) {
  if (!Jaxer.dwr.pathToDwrServlet) {
    Jaxer.dwr._error();
  }
  if (!Jaxer.dwr._haveEngine) {
    Jaxer.dwr._requireSingle("engine");
    Jaxer.dwr._haveEngine = true;
  }
  for (var i = 0; i < arguments.length; i++) {
    Jaxer.dwr._requireSingle(arguments[i]);
  }
}

Jaxer.dwr._requireSingle = function(required) {
  var url = Jaxer.dwr.pathToDwrServlet + "/" + required + ".js";
  Jaxer.Log.info("importing: " + url);
  document.writeln("<scr" + "ipt type='text/javascript' src='" + url + "' runat='server'></scr" + "ipt>");
};
  
Jaxer.dwr._error = function(message) {
  document.writeln("<!-" + "-" + message + "-" + "->");
  Jaxer.Log.error(message);
};
