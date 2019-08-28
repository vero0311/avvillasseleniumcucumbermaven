$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/avvillas_search.feature");
formatter.feature({
  "name": "liberty credit simulator",
  "description": "AS a Avvillas user\nI want to complete the form\nTo calculate the liberty credit",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Form with data not allowed",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "That I am in Avvillas home page",
  "keyword": "Given "
});
formatter.match({
  "location": "AvvillasFormStepDefinition.java:33"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I write in amount field  \"43243\" AND in term in month \"34\" AND in credit destination \"Gastos Personales\" and I do not choose any option in liberty agreement field",
  "keyword": "When "
});
formatter.match({
  "location": "AvvillasFormStepDefinition.java:39"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I hope to see warning messages, \"El monto mínimo permitido es $500.000\" and \"Campo Obligatorio\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AvvillasFormStepDefinition.java:48"
});
formatter.result({
  "status": "passed"
});
});