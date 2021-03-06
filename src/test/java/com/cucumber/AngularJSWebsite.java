package com.cucumber;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.cucumber.pageobject.angularjswebsite.AddSomeControlPage;
import com.cucumber.pageobject.angularjswebsite.CreateComponentsPage;
import com.cucumber.pageobject.angularjswebsite.DownloadAngularJSOnePage;
import com.cucumber.pageobject.angularjswebsite.LandingPage;
import com.cucumber.pageobject.angularjswebsite.TheBasicsPage;
import com.cucumber.pageobject.angularjswebsite.WireUpABackendPage;
import com.cucumber.utils.WebDriverUtils;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AngularJSWebsite extends AbstractPageStepDefinition{
	private static final Logger logger = LogManager.getLogger(AngularJSWebsite.class.getName());
	private WebDriver driver = getWebdriver();
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
	private LandingPage landingPage;
	private DownloadAngularJSOnePage downloadAngularJSOnePage;
	private WebElement downloadAngularJSOnePageCloseButton;
	private TheBasicsPage theBasicsPage;
	private AddSomeControlPage addSomeControlPage;
	private WireUpABackendPage wireUpABackendPage;
	private CreateComponentsPage createComponentsPage;
	
	@After() //Cucumber Scenario Hooks.  Close driver after each scenario.
	public void afterTest(Scenario scenario){
		if (scenario.isFailed()) {
			webDriverUtils.takeStreenShot(scenario);
		}
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
		WebElement downLoadAngularJSOneButton = landingPage.getDownLoadAngularJSOneButton(); 
		Map<String,String> data = table.asMap(String.class,String.class);
		Assert.assertTrue(downLoadAngularJSOneButton.getText().equals(data.get("DownLoad Angular JS One Button"))); //Download AngularJS 1\n\n(1.6.0 / 1.2.32)
	}

	@Then("^I click on the Download AngularJS One button\\.$")
	public void iClickOnTheDownloadAngularJSOneButton() throws Throwable {
		downloadAngularJSOnePage = landingPage.navigateToDownloadAngularJSOnePage();
	}

	@And("^I check the properties of the Download AngularJS One page\\.$")
	public void iCheckThePropertiesOfTheDownloadAngularJSOnePage(DataTable table) throws Throwable {
		Map<String,String> data = table.asMap(String.class,String.class);
		
		logger.trace("iCheckThePropertiesOfTheDownloadAngularJSOnePage-----> " + downloadAngularJSOnePage.getTitleLabel().getText());
		Assert.assertTrue(downloadAngularJSOnePage.getTitleLabel().getText().equals(data.get("Title Label"))); //Download AngularJS
		Assert.assertTrue(downloadAngularJSOnePage.getBranch().getText().equals(data.get("Branch")));  //1.5.x (stable)
		Assert.assertTrue(downloadAngularJSOnePage.getBuildMinified().getText().equals(data.get("Build Minified"))); //Minified
		Assert.assertTrue(downloadAngularJSOnePage.getBuildZip().getText().equals(data.get("Build Zip"))); //Zip		
		Assert.assertTrue(downloadAngularJSOnePage.getBuildUncompressed().getText().equals(data.get("Build Uncompressed"))); //Uncompressed
		Assert.assertTrue(downloadAngularJSOnePage.getCdn().getAttribute("value").contains(data.get("Cdn"))); //angular.min.js	
		Assert.assertTrue(downloadAngularJSOnePage.getBower().getAttribute("value").contains(data.get("Bower"))); //bower
		Assert.assertTrue(downloadAngularJSOnePage.getNpm().getAttribute("value").contains(data.get("Npm"))); //npm
		Assert.assertTrue(downloadAngularJSOnePage.getExtras().getText().equals(data.get("Extras"))); //Browse additional modules
		Assert.assertTrue(downloadAngularJSOnePage.getPreviousVersions().getText().equals(data.get("Previous Versions"))); //Previous Versions
		Assert.assertTrue(downloadAngularJSOnePage.getDownloadButton().getAttribute("href").contains(data.get("Download Button")));  //angular.min.js
		downloadAngularJSOnePageCloseButton = downloadAngularJSOnePage.getCloseButton();
		Assert.assertTrue(downloadAngularJSOnePageCloseButton.getText().equals(data.get("Close Button"))); //×
	}

	@Then("^I click on the Close button of the Download AngularJS One page\\.$")
	public void iClickOnTheCloseButtonOfTheDownloadAngularJSOnePage() throws Throwable {
		downloadAngularJSOnePageCloseButton.click();
	}

	@When("^I fill in the name\\.$")
	public void iFillInTheName(DataTable table) throws Throwable {
		Map<String,String> data = table.asMap(String.class,String.class);
		
		theBasicsPage = landingPage.navigateToTheBasicsPage();
		WebElement theBasicsName = theBasicsPage.getNameInputTag();
		theBasicsName.sendKeys((data.get("Name"))); //Greg
	}

	@Then("^I confirm the message\\.$")
	public void iConfirmTheMessage(DataTable table) throws Throwable {
		Map<String,String> data = table.asMap(String.class,String.class);
		
		Assert.assertTrue(theBasicsPage.getNameMessage().getText().equals(data.get("Name Message")));  //Hello Greg!
	}

	@When("^I confirm the labels of the current todo items\\.$")
	public void iConfirmToLabelOfTheCurrentTodoItems(DataTable table) throws Throwable {
		addSomeControlPage = landingPage.navigateToAddSomeControlPage();
		
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),addSomeControlPage.getTodoCheckBoxesOrLabels(AddSomeControlPage.TODO_ITEM_LABEL));
	}
	
	@Then("^I confirm the todo checkboxes that are selected\\.$")
	public void iConfirmTheTodoCheckboxesThatAreSelected(DataTable table) throws Throwable {
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),addSomeControlPage.getTodoCheckBoxesSelectedOrNotSelectedTodo(true));
	}

	@And("^I confirm the todo checkboxes that are not selected\\.$")
	public void iConfirmTheTodoCheckboxesThatAreNotSelected(DataTable table) throws Throwable {		
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),addSomeControlPage.getTodoCheckBoxesSelectedOrNotSelectedTodo(false));
	}

	@Then("^I add a new todo item\\.$")
	public void iAddANewTodoItem(DataTable table) throws Throwable {
		Map<String,String> data = table.asMap(String.class,String.class);
		
		addSomeControlPage.addNewTodoText().sendKeys(data.get("New Todo List Item"));  //Go to the dentist
		addSomeControlPage.addNewTodoButton().click();
	}

	@And("^I check the values of the todo items\\.$")
	public void iCheckTheValuesOfTheTodoItems(DataTable table) throws Throwable {
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),addSomeControlPage.getTodoCheckBoxesOrLabels(AddSomeControlPage.TODO_ITEM_LABEL));
	}

	@Then("^I select the check box of the new todo item\\.$")
	public void iSelectTheCheckBoxOfTheNewTodoItem(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		addSomeControlPage.selectTotoCheckBoxes(tableList);
	}

	@And("^I recheck the value of the todo items\\.$")
	public void iRecheckTheValueOfTheTodoItems(DataTable table) throws Throwable {
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),addSomeControlPage.getTodoCheckBoxesSelectedOrNotSelectedTodo(true));
	}
	
	@When("^I confirm the labels of the current JavaScript Projects\\.$")
	public void iConfirmTheLabelsOfTheCurrentJavaScriptProjects(DataTable table) throws Throwable {
		wireUpABackendPage = landingPage.navigateToWireUpABackendPage();
		
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),wireUpABackendPage.getJavaScriptProjectLinks());
	}
	
	@Then("^I confirm the labels of the current JavaScript Project Descriptions\\.$")
	public void iConfirmTheLabelsOfTheCurrentJavaScriptProjectDescriptions(DataTable table) throws Throwable {
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),wireUpABackendPage.getJavaScriptProjectDescriptions());
	}
	
	@And("^Search for, update, and confirm a project values\\.$")
	public void searchForUpdateAndConfirmAProjectValues(DataTable table) throws Throwable {
		//Enter GWT in the Search Input Box
		wireUpABackendPage.getSearchInputTag().sendKeys(table.asMap(String.class, String.class).get("GWT_Current_Name"));
		
		//Click the GWT Edit link
		wireUpABackendPage.getJavaScriptProjectEditLinks().get(0).click();
		
		//Clear and Update the Project Name, Website, and Description Input Boxes
		wireUpABackendPage.getJavaScriptProjectsEditName().clear();
		wireUpABackendPage.getJavaScriptProjectsEditWebsite().clear();
		wireUpABackendPage.getJavaScriptProjectsEditDescription().clear();
		
		String gwtUpdatedName = table.asMap(String.class, String.class).get("GWT_Updated_Name");
		String gwtUpdatedWebsite = table.asMap(String.class, String.class).get("GWT_Updated_Website");
		String gwtUpdatedDescription = table.asMap(String.class, String.class).get("GWT_Updated_Description");
		
		wireUpABackendPage.getJavaScriptProjectsEditName().sendKeys(gwtUpdatedName);
		wireUpABackendPage.getJavaScriptProjectsEditWebsite().sendKeys(gwtUpdatedWebsite);
		wireUpABackendPage.getJavaScriptProjectsEditDescription().sendKeys(gwtUpdatedDescription);
		
		//Click the Save Button
		wireUpABackendPage.getJavaScriptProjectsEditSaveButton().click();
		
		//Search for Updated GWT Project Name
		wireUpABackendPage.getSearchInputTag().sendKeys(gwtUpdatedName);
		
		//Confirm JavaScript Project labels has been updated
		Assert.assertTrue(wireUpABackendPage.getJavaScriptProjectLinks().get(0).getText().equals(gwtUpdatedName)); //Project Link
		Assert.assertTrue(wireUpABackendPage.getJavaScriptProjectLinks().get(0).getAttribute("href").equals(gwtUpdatedWebsite)); //href value of the Project Link
		Assert.assertTrue(wireUpABackendPage.getJavaScriptProjectDescriptions().get(0).getText().equals(gwtUpdatedDescription)); //Project Description
	}
	
	@When("^I confirm the locales\\.$")
	public void iConfirmTheLocales(DataTable table) throws Throwable {
		createComponentsPage = landingPage.navigateToCreateComponentsPage();		
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),createComponentsPage.getLocales());
	}

	@Then("^I confirm the localization values for United States\\.$")
	public void iConfirmTheLocalizationValuesForUnitedStates(DataTable table) throws Throwable {
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),createComponentsPage.getUnitedStatesLocalization());
	}
	
	@And("^I confirm the pluralization values for United States\\.$")
	public void iConfirmThePluralizationValuesForUnitedStates(DataTable table) throws Throwable {
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),createComponentsPage.getUnitedStatesPluralization());
	}
	
	@Then("^I confirm the localization values for Slovakia\\.$")
	public void iConfirmTheLocalizationValuesForSlovakia(DataTable table) throws Throwable {
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),createComponentsPage.getSlovakiaLocalization());
	}
	
	@Then("^I confirm the pluralization values for Slovakia\\.$")
	public void i_confirm_the_pluralization_values_for_Slovakia(DataTable table) throws Throwable {
		webDriverUtils.checkConfirmTheValuesOfTheCurrentTodoItemsByMap(table.asMap(String.class, String.class).values(),createComponentsPage.getSlovakiaPluralization());
	}
}
