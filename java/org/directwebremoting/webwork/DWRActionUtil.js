/* WW-DWR */
var DWRActionUtil = {
  execute : function(action, values, callbackObjOrName) {
    var params = {};
    if (DWRActionUtil.isElement(values)) {
      var element = $(values);
      var elementName= element.nodeName.toLowerCase();
      if (elementName == 'form') {
        for (var i = 0; i < element.elements.length; i=i+1) {
          var e = element.elements[i];
          if(e.name != null && e.name != '') params[e.name] = DWRUtil.getValue(e);
        }
      }
      else {
        params[element.name] = DWRUtil.getValue(element);
      }
    }
    else {
      for (var prop in values) {
        params[prop]= values[prop];
      }
    }
    
    // prepare action invocation object
    var actionObj = {};
    if(typeof action == 'string') {
      var lastIdx= action.lastIndexOf('/');
      actionObj.executeResult = 'true';
      if(lastIdx != -1) {
        actionObj.namespace = action.substring(0, lastIdx);
        actionObj.action = action.substring(lastIdx + 1);
      }
      else {
        actionObj.namespace= '';
        actionObj.action = action;
      }
    }
    else {
      actionObj= action;
    }

    // prepare the DWR callback object
    var callbackObj = {};
    var mustCall= false;
    if(typeof callbackObjOrName == 'string') {
      callbackObj.callback = function(dt) { DWRActionUtil.callback(dt, eval(callbackObjOrName)); };
      mustCall= true;
    }
    else if(typeof callbackObjOrName == 'function') {
      callbackObj.callback = function(dt) { DWRActionUtil.callback(dt, callbackObjOrName); };
      mustCall= true;
    } 
    else if(typeof callbackObjOrName == 'object' && typeof callbackObjOrName.callback == 'function') {
      for (var prop in callbackObjOrName) {
        callbackObj[prop] = callbackObjOrName[prop];
      }
      callbackObj.callback = function(dt) { DWRActionUtil.callback(dt, callbackObjOrName.callback); };
      mustCall= true;
    }
    if (mustCall) {
      DWRAction.execute(actionObj, params, callbackObj);
    }
  },

  callback : function(dt, originalCallback) {
    if (dt.data) originalCallback(dt.data);
    else if (dt.text) originalCallback(dt.text);
    else originalCallback(dt);
  },

  isElement : function(elementOrId) {
    if (typeof elementOrId == "string") {
      return true;
    }
    if ( elementOrId.nodeName ) {
      var name= elementOrId.nodeName.toLowerCase();
      if(name == 'input' || name == 'form') {
        return true;
      }
    }
    
    return false;
  }
};
