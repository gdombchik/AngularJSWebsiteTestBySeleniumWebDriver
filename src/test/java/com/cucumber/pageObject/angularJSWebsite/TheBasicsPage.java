package com.cucumber.pageObject.angularJSWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheBasicsPage extends AbstractPage {
	private WebElement name;
	
	public TheBasicsPage(WebDriver driver){
		super(driver);
	}

	public WebElement getName() {
		return name;
	}

	public void setName(WebElement name) {
		this.name = name;
	}
}
