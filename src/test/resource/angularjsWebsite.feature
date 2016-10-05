Feature:  To test the AngularJS website home page.

Background:  
	Given I am on the AngularJS website home page.

@angularJSWebsite
Scenario:  Test basic components on the AngularJS home page.
	When I confirm I am on the AngularJS website home page.
	Then I click on the Download AngularJS One button.
	And I check the properties of the Download AngularJS One page.
	Then I click on the Close button of the Download AngularJS One page.

@angularJSWebsiteTestTheBasics
	Scenario:  Test The Basics.
	When I fill in the name.
	Then I confirm the message.

@angularJSWebsiteTestAddSomeControl
Scenario:  Test Add Some Control.
	When I confirm the values of the current todo items.
	Then I add a new todo item.
	And I check the values of the todo items.
	Then I select the check box of the new todo item.
	And I recheck the value of the todo items.
	Then I close the AngularJS website.