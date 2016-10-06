package com.cucumber.MavenCucumberSeleniumWebDriverJUnitPractice;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.pageObject.angularJSWebsite.DownloadAngularJSOnePage;
import com.cucumber.pageObject.angularJSWebsite.LandingPage;
import com.cucumber.pageObject.angularJSWebsite.TheBasicsPage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AngularJSWebsite extends AbstractPageStepDefinition{
	private WebDriver driver = getWebdriver();
	private LandingPage landingPage;
	private DownloadAngularJSOnePage downloadAngularJSOnePage;
	private WebElement downloadAngularJSOnePageCloseButton;
	private WebElement theBasicsName;
	
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
	public void iConfirmIAmOnTheAngularJSWebsiteHomePage(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		WebElement downLoadAngularJSOneButton = landingPage.getDownLoadAngularJSOneButton(); 
		Assert.assertTrue(downLoadAngularJSOneButton.getText().equals(tableList.get(1).get(1))); //Download AngularJS 1\n\n(1.5.8 / 1.2.30
	}

	@Then("^I click on the Download AngularJS One button\\.$")
	public void iClickOnTheDownloadAngularJSOneButton() throws Throwable {
		downloadAngularJSOnePage = landingPage.navigateToDownloadAngularJSOnePage();
	}

	@Then("^I check the properties of the Download AngularJS One page\\.$")
	public void iCheckThePropertiesOfTheDownloadAngularJSOnePage(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		
		Assert.assertTrue(downloadAngularJSOnePage.getTitleLabel().getText().equals(tableList.get(1).get(1))); //Download AngularJS
		Assert.assertTrue(downloadAngularJSOnePage.getBranch().getText().equals(tableList.get(2).get(1)));  //1.5.x (stable)
		Assert.assertTrue(downloadAngularJSOnePage.getBuildMinified().getText().equals(tableList.get(3).get(1))); //Minified
		Assert.assertTrue(downloadAngularJSOnePage.getBuildZip().getText().equals(tableList.get(4).get(1))); //Zip		
		Assert.assertTrue(downloadAngularJSOnePage.getBuildUncompressed().getText().equals(tableList.get(5).get(1))); //Uncompressed
		Assert.assertTrue(downloadAngularJSOnePage.getCdn().getAttribute("value").contains(tableList.get(6).get(1))); //angular.min.js	
		Assert.assertTrue(downloadAngularJSOnePage.getBower().getAttribute("value").contains(tableList.get(7).get(1))); //bower
		Assert.assertTrue(downloadAngularJSOnePage.getNpm().getAttribute("value").contains(tableList.get(8).get(1))); //npm
		Assert.assertTrue(downloadAngularJSOnePage.getExtras().getText().equals(tableList.get(9).get(1))); //Browse additional modules
		Assert.assertTrue(downloadAngularJSOnePage.getPreviousVersions().getText().equals(tableList.get(10).get(1))); //Previous Versions
		Assert.assertTrue(downloadAngularJSOnePage.getDownloadButton().getAttribute("href").contains(tableList.get(11).get(1)));  //angular.min.js
		downloadAngularJSOnePageCloseButton = downloadAngularJSOnePage.getCloseButton();
		Assert.assertTrue(downloadAngularJSOnePageCloseButton.getText().equals(tableList.get(12).get(1))); //×
	}

	@Then("^I click on the Close button of the Download AngularJS One page\\.$")
	public void iClickOnTheCloseButtonOfTheDownloadAngularJSOnePage() throws Throwable {
		downloadAngularJSOnePageCloseButton.click();
	}

	@When("^I fill in the name\\.$")
	public void iFillInTheName(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		
		TheBasicsPage theBasicsPage = landingPage.navigateToTheBasicsPage();
		theBasicsName = theBasicsPage.getName();
		theBasicsName.sendKeys((tableList.get(1).get(1)));
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
