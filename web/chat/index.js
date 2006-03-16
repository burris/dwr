
function init() {
  DWRUtil.useLoadingMessage();
}

function sendMessage() {
  var text = DWRUtil.getValue("text");
  DWRUtil.setValue("text", "");
  Chat.addMessage(text, function(messages) {
    var chatlog = "";
    for (var data in messages) {
      chatlog = "<div>" + messages[data].text + "</div>" + chatlog;
    }
    DWRUtil.setValue("chatlog", chatlog);
  });
}
