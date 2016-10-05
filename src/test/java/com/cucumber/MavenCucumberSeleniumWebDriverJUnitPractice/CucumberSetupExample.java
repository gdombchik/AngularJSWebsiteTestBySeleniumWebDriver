package com.cucumber.MavenCucumberSeleniumWebDriverJUnitPractice;

import cucumber.api.java.en.Given;

public class CucumberSetupExample {
	@Given("^I have (\\d+) cukes in my belly$")
	public void iHaveCukesInMyBelly(int arg1) throws Throwable {
	    System.out.println("cukes in my belly " + arg1);
	}
}
