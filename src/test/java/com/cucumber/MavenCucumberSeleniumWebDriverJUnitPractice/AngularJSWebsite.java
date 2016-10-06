package com.cucumber.MavenCucumberSeleniumWebDriverJUnitPractice;

import org.openqa.selenium.WebDriver;

import com.cucumber.pageObject.angularJSWebsite.LandingPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AngularJSWebsite extends AbstractPageStepDefinition{
	
	WebDriver driver = getWebdriver();
	LandingPage landingPage;
	
	@After //Cucumber Scenario Hooks.  Close driver after each scenario.
	public void afterTest(){
		landingPage.closeDriver();
	}
	
	//Cucumber Background Script:
	//The background script is ran before each of the scenarios, but after any of the Cucumber Scenario Before Hooks
	@Given("^I am on the AngularJS website home page\\.$")
	public void iAmOnTheAngularJSWebsiteHomePage() throws Throwable {
		landingPage = new LandingPage(driver).navigateToWebApp();
	}
	
	@When("^I confirm I am on the AngularJS website home page\\.$")
	public void iConfirmIAmOnTheAngularJSWebsiteHomePage() throws Throwable {
		
	}

	@Then("^I click on the Download AngularJS One button\\.$")
	public void iClickOnTheDownloadAngularJSOneButton() throws Throwable {

	}

	@Then("^I check the properties of the Download AngularJS One page\\.$")
	public void iCheckThePropertiesOfTheDownloadAngularJSOnePage() throws Throwable {
	
	}

	@Then("^I click on the Close button of the Download AngularJS One page\\.$")
	public void iClickOnTheCloseButtonOfTheDownloadAngularJSOnePage() throws Throwable {
	
	}

	@When("^I fill in the name\\.$")
	public void iFillInTheName() throws Throwable {
	
	}

	@Then("^I confirm the message\\.$")
	public void iConfirmTheMessage() throws Throwable {
	
	}

	@When("^I confirm the values of the current todo items\\.$")
	public void iConfirmTheValuesOfTheCurrentTodoItems() throws Throwable {
	
	}

	@Then("^I add a new todo item\\.$")
	public void iAddANewTodoItem() throws Throwable {
	
	}

	@Then("^I check the values of the todo items\\.$")
	public void iCheckTheValuesOfTheTodoItems() throws Throwable {
	
	}

	@Then("^I select the check box of the new todo item\\.$")
	public void iSelectTheCheckBoxOfTheNewTodoItem() throws Throwable {
	
	}

	@Then("^I recheck the value of the todo items\\.$")
	public void iRecheckTheValueOfTheTodoItems() throws Throwable {
	
	}
}
