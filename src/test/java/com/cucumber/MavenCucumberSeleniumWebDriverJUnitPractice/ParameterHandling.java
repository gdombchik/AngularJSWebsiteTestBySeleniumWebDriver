package com.cucumber.MavenCucumberSeleniumWebDriverJUnitPractice;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ParameterHandling extends AbstractPageStepDefinition {
	WebDriver driver;
	
	@Before
	public void setUpTest(){
		driver = getWebdriver();
	}
	
	@After
	public void afterTest(){
		driver.quit();
	}
	
	@Given("^I navigate to TheTestRoom\\.com$")
	public void iNavigateToTheTestRoom() throws Throwable {
		driver.navigate().to("http://www.thetestroom.com/");
	}

	/*
	#Scenario:  To check that the Java WebDriver Tutorial main page has loaded
	#Given I navigate to TheTestRoom.com
	#When I navigate to Java WebDriver Tutorial page
	#Then The "Java WebDriver Tutorial - The Test Room" title should be visible

	#Scenario:  To check that the Java Cucumber Tutorial main page has loaded
	#Given I navigate to TheTestRoom.com
	#When I navigate to Java Cucumber Tutorial page
	#Then The "Java Cucumber Tutorial - The Test Room" title should be visible
	*/
	
	/*@When("^I navigate to Java WebDriver Tutorial page$")
	public void iNavigateToJavaCucumberTutorialPage() throws Throwable {
		driver.findElement(By.linkText("Java WebDriver Tutorial")).click();
	}

	@When("^I navigate to Java Cucumber Tutorial page$")
	public void iNavigateToJavaWebDriverTutorialpage() throws Throwable {
		driver.findElement(By.linkText("Java Cucumber Tutorial")).click();
	}*/
	
	/*@Then("^The Java WebDriver Tutorial title should be visible$")
	public void thePageTitleShouldBeVisible() throws Throwable {
		//WebElement title = driver.findElement(By.tagName("title"));
		///System.out.println("1");
		//System.out.println(title.getText() + " asdfasdf");
		//System.out.println("2");
		//Asssert.(driver.getTitle());
		Assert.assertEquals("Java WebDriver Tutorial - The Test Room", driver.getTitle());
		//System.out.println(driver.getTitle());
		
		//Java Cucumber Tutorial - The Test Room
	}*/
	
	@Then("^The \"([^\"]*)\" title should be visible$")
	public void theTitleShouldBeVisible(String arg1) throws Throwable {
		if(arg1.equals("Java WebDriver Tutorial - The Test Room")){
			Assert.assertEquals("Java WebDriver Tutorial - The Test Room", driver.getTitle());
		}else if(arg1.equals("Java Cucumber Tutorial - The Test Room")){
			Assert.assertEquals("Java Cucumber Tutorial - The Test Room", driver.getTitle());
		}
		
	}
	
	/*@Then("^I navigate to <link> page$")
	public void iNavigateToPage(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		
		//List 1 == "row"
		//List 2 == "column"
		
		System.out.println(tableList.get(1).get(0)); //Java WebDriver Tutorial
		System.out.println(tableList.get(2).get(0)); //Java Cucumber Tutorial
		
		driver.findElement(By.linkText(tableList.get(1).get(0))).click();
	}
	
	@Then("^The <title> should be visible$")
	public void thteTitleShouldBeVisible(DataTable table) throws Throwable {
		List<List<String>> tableList = table.raw();
		
		//List 1 == "row"
		//List 2 == "column"
		
		System.out.println(tableList.get(1).get(0)); //Java WebDriver Tutorial - The Test Room
		System.out.println(tableList.get(2).get(0)); //Java Cucumber Tutorial - The Test Room
		
		Assert.assertEquals(tableList.get(1).get(0), driver.getTitle());
	}*/
	
	@Then("^I navigate to ([^\"]*) page$")
	public void iNavigateToPage(String link) throws Throwable {
		System.out.println(link);
		driver.findElement(By.linkText(link)).click();
	}
	
	@Then("^The ([^\"]*) should be visible$")
	public void thteTitleShouldBeVisible(String title) throws Throwable {
		Assert.assertEquals(title, driver.getTitle());
	}
	
	@Then("^Display random data$")
	public void display_random_data(DataTable arg1) throws Throwable {
		List<List<String>> tableList = arg1.raw();
		
		//List 1 == "row"
		//List 2 == "column"
		System.out.println(tableList.get(0).get(0)); //first column title (v1)
		System.out.println(tableList.get(0).get(1)); //second column title (v2)
		System.out.println(tableList.get(1).get(1)); //first column value (John)
		System.out.println(tableList.get(2).get(1)); //second column value (Doe)
	}
}
