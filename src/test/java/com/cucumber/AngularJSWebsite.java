package com.cucumber;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.pageObject.angularJSWebsite.AddSomeControlPage;
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
	private TheBasicsPage theBasicsPage;
	private AddSomeControlPage addSomeControlPage;
	
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
		
		/*Assert.assertTrue(downloadAngularJSOnePage.getTitleLabel().getText().equals(tableList.get(1).get(1))); //Download AngularJS
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
*/	}

	@Then("^I click on the Close button of the Download AngularJS One page\\.$")
	public void iClickOnTheCloseButtonOfTheDownloadAngularJSOnePage() throws Throwable {
		//downloadAngularJSOnePageCloseButton.click();
	}

	@When("^I fill in the name\\.$")
	public void iFillInTheName(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		
		theBasicsPage = landingPage.navigateToTheBasicsPage();
		WebElement theBasicsName = theBasicsPage.getNameInputTag();
		theBasicsName.sendKeys((tableList.get(1).get(1)));
	}

	@Then("^I confirm the message\\.$")
	public void iConfirmTheMessage(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		
		Assert.assertTrue(theBasicsPage.getNameMessage().getText().equals(tableList.get(1).get(1)));
	}

	@When("^I confirm the labels of the current todo items\\.$")
	public void iConfirmToLabelOfTheCurrentTodoItems(DataTable table) throws Throwable {
		addSomeControlPage = landingPage.navigateToAddSomeControlPage();
		
		checkConfirmTheValuesOfTheCurrentTodoItems(table.raw(),addSomeControlPage.getTodoCheckBoxesOrLabels(AddSomeControlPage.TODO_ITEM_LABEL));
	}
	
	@Then("^I confirm the todo checkboxes that are selected\\.$")
	public void iConfirmTheTodoCheckboxesThatAreSelected(DataTable table) throws Throwable {
		checkConfirmTheValuesOfTheCurrentTodoItems(table.raw(),addSomeControlPage.getTodoCheckBoxesSelectedOrNotSelectedTodo(true));
	}

	@Then("^I confirm the todo checkboxes that are not selected\\.$")
	public void iConfirmTheTodoCheckboxesThatAreNotSelected(DataTable table) throws Throwable {		
		checkConfirmTheValuesOfTheCurrentTodoItems(table.raw(),addSomeControlPage.getTodoCheckBoxesSelectedOrNotSelectedTodo(false));
	}

	@Then("^I add a new todo item\\.$")
	public void iAddANewTodoItem(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		
		addSomeControlPage.addNewTodoText().sendKeys(tableList.get(1).get(1));;
		addSomeControlPage.addNewTodoButton().click();
	}

	@Then("^I check the values of the todo items\\.$")
	public void iCheckTheValuesOfTheTodoItems(DataTable table) throws Throwable {
		checkConfirmTheValuesOfTheCurrentTodoItems(table.raw(),addSomeControlPage.getTodoCheckBoxesOrLabels(AddSomeControlPage.TODO_ITEM_LABEL));
	}

	@Then("^I select the check box of the new todo item\\.$")
	public void iSelectTheCheckBoxOfTheNewTodoItem(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		addSomeControlPage.selectTotoCheckBoxes(tableList);
	}

	@Then("^I recheck the value of the todo items\\.$")
	public void iRecheckTheValueOfTheTodoItems(DataTable table) throws Throwable {
		checkConfirmTheValuesOfTheCurrentTodoItems(table.raw(),addSomeControlPage.getTodoCheckBoxesSelectedOrNotSelectedTodo(true));
	}
	
	private void checkConfirmTheValuesOfTheCurrentTodoItems(List<List<String>> tableList,List<WebElement> todoLabels){
		int i = 1;
		for(WebElement webElement : todoLabels){
			Assert.assertTrue(webElement.getText().equals(tableList.get((i)).get(1)));
			i++;
		}		
	}
}
