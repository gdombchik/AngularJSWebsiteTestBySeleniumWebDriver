$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("zooTest.feature");
formatter.feature({
  "line": 1,
  "name": "To test the high level functionality of the Zoo site",
  "description": "",
  "id": "to-test-the-high-level-functionality-of-the-zoo-site",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1641384662,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I am on the zoo site",
  "keyword": "Given "
});
formatter.match({
  "location": "ZooTestCucumberAndJunit.iAmOnTheZooSite()"
});
formatter.result({
  "duration": 1191553122,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "To populate the contact form",
  "description": "",
  "id": "to-test-the-high-level-functionality-of-the-zoo-site;to-populate-the-contact-form",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@tagForZoo"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I click on \"Contact\"",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 9,
      "value": "#And I enter \"Name test\" into the name field"
    },
    {
      "line": 10,
      "value": "#And I enter \"Address test\" into the address field"
    },
    {
      "line": 11,
      "value": "#And I enter \"Postcode test\" into the postcode field"
    },
    {
      "line": 12,
      "value": "#And I enter \"Email test\"  into the email field"
    }
  ],
  "line": 13,
  "name": "I populate the form",
  "rows": [
    {
      "cells": [
        "Field",
        "Value"
      ],
      "line": 14
    },
    {
      "cells": [
        "name",
        "Name test"
      ],
      "line": 15
    },
    {
      "cells": [
        "address",
        "Address test"
      ],
      "line": 16
    },
    {
      "cells": [
        "postcode",
        "Postcode test"
      ],
      "line": 17
    },
    {
      "cells": [
        "email",
        "Email test"
      ],
      "line": 18
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I submit the contact form",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I check I am on the confirmation page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Contact",
      "offset": 12
    }
  ],
  "location": "ZooTestCucumberAndJunit.iClickOn(String)"
});
formatter.result({
  "duration": 1184984911,
  "status": "passed"
});
formatter.match({
  "location": "ZooTestCucumberAndJunit.iPopulateTheForm(DataTable)"
});
formatter.result({
  "duration": 209820373,
  "status": "passed"
});
formatter.match({
  "location": "ZooTestCucumberAndJunit.iSubmitTheContactForm()"
});
formatter.result({
  "duration": 156769990,
  "status": "passed"
});
formatter.match({
  "location": "ZooTestCucumberAndJunit.iCheckIAmOnTheConfirmationPage()"
});
formatter.result({
  "duration": 72270152,
  "status": "passed"
});
formatter.match({
  "location": "ZooTestCucumberAndJunit.iCloseTheBrowser()"
});
formatter.result({
  "duration": 561195309,
  "status": "passed"
});
formatter.after({
  "duration": 117908,
  "status": "passed"
});
});