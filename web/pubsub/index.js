
function init() {
  Tabs.init('tabList', 'tabContents');
  dwr.engine.setActiveReverseAjax(true);
  dwr.hub.subscribe("pubsub.topicText", function(published) {
    inform(published);
  });
  dwr.hub.subscribe("pubsub.topicPeople", function(person) {
    inform(person.name);
  });
}

function clientPublishText() {
  dwr.hub.publish("pubsub.topicText", dwr.util.byId("clientText"));
}

function clientPublishObject() {
  dwr.hub.publish("pubsub.topicPeople", {
    name:dwr.util.byId("clientPersonName"),
    address:"a made up address",
    phoneNumber:"000-000-0000"
  });
}

function serverPublishText() {
  HubTest.publishText(dwr.util.byId("serverText"));
}

function serverPublishObject() {
  HubTest.publishPerson({
    name:dwr.util.byId("serverPersonName"),
    address:"a made up address",
    phoneNumber:"000-000-0000"
  });
}

function inform(message) {
  console.log(message);
}
