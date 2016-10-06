package com.cucumber.pageObject.angularJSWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.utils.WebDriverUtils;

public class TheBasicsPage extends AbstractPage {
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
	private WebElement name;
	
	public TheBasicsPage(WebDriver driver){
		super(driver);
	}

	public WebElement getName() {
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("input"),"placeholder","Enter a name here");
	}
}
