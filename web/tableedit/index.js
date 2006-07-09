
var peopleCache = { };
var viewed = -1;

function update() {
  People.getAllPeople(function(people) {
    var person;
    for (var i = 0; i < people.length; i++) {
      person = people[i];
      DWRUtil.setValue("tableName", person.name);
      DWRUtil.setValue("tableSalary", person.salary);
      DWRUtil.setValue("tableAddress", person.address);
      DWRUtil.cloneNode("pattern", { idSuffix:"" + i });
      peopleCache[i] = person;
    }
  });
  //$("pattern").style.display = "none";
}

function editClicked(id) {
  // we were passed element.id which includes "edit" so we strip that off
  viewed = id.substring(4);
  var person = peopleCache[viewed];
  DWRUtil.setValues(person);
}

function deletePerson(personid, name) {
  if (confirm("Are you sure you want to delete " + name + "?")) {
    People.deletePerson(update, { id:personid });
  }
}

function writePerson() {
  DWRUtil.getValues(person);
  People.addPerson(update, person);
}

var person = { id:-1, name:null, address:null, salary:null };

function clearPerson() {
  person = { id:-1, name:null, address:null, salary:null };
  DWRUtil.setValues(person);
}

function init() {
  DWRUtil.useLoadingMessage();
  Tabs.init('tabList', 'tabContents');
  update();
}
