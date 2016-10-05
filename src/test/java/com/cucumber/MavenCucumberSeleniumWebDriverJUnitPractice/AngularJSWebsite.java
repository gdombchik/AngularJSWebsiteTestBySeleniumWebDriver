package com.cucumber.MavenCucumberSeleniumWebDriverJUnitPractice;

import org.openqa.selenium.WebDriver;

import com.cucumber.pageObject.angularJSWebsite.LandingPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AngularJSWebsite extends AbstractPageStepDefinition{
	
	WebDriver driver = getWebdriver();
	LandingPage landingPage;
	
	@Given("^I am on the AngularJS website home page\\.$")
	public void iAmOnTheAngularJSWebsiteHomePage() throws Throwable {
		landingPage = new LandingPage(driver).navigateToWebApp();
	}
	
	@When("^I confirm I am on the AngularJS website home page\\.$")
	public void i_confirm_I_am_on_the_AngularJS_website_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^I click on the Download AngularJS One button\\.$")
	public void i_click_on_the_Download_AngularJS_One_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^I check the properties of the Download AngularJS One page\\.$")
	public void i_check_the_properties_of_the_Download_AngularJS_One_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^I click on the Close button of the Download AngularJS One page\\.$")
	public void i_click_on_the_Close_button_of_the_Download_AngularJS_One_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^I fill in the name\\.$")
	public void i_fill_in_the_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^I confirm the message\\.$")
	public void i_confirm_the_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^I confirm the values of the current todo items\\.$")
	public void i_confirm_the_values_of_the_current_todo_items() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^I add a new todo item\\.$")
	public void i_add_a_new_todo_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^I check the values of the todo items\\.$")
	public void i_check_the_values_of_the_todo_items() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^I select the check box of the new todo item\\.$")
	public void i_select_the_check_box_of_the_new_todo_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^I recheck the value of the todo items\\.$")
	public void i_recheck_the_value_of_the_todo_items() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@And("^I close the AngularJS website\\.$")
	public void iCloseTheAngularJSWebsite() throws Throwable {
		landingPage.closeDriver();
	}
}
