package com.cucumber.pageObject.angularJSWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateComponentsPage extends AbstractPage {

	public CreateComponentsPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getCurrentLocales() {
		return driver.findElements(By.tagName("h4"));
	}
}
