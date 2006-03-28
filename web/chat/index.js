
function init() {
  DWREngine.setPolling(true);
}

function sendMessage() {
  var text = DWRUtil.getValue("text");
  DWRUtil.setValue("text", "");
  Chat.addMessage(text);
}

function receiveMessages(messages) {
  var chatlog = "";
  for (var data in messages) {
    chatlog = "<div>" + messages[data].text + "</div>" + chatlog;
  }
  DWRUtil.setValue("chatlog", chatlog);
}
