package com.cucumber.MavenCucumberSeleniumWebDriverJUnitPractice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.utils.WebDriverList;

public abstract class AbstractPageStepDefinition {
	protected static WebDriver webdriver;

	public WebDriver getWebdriver() {
		//web driver is null or webdriver.quit (not webdriver.close)
		if(webdriver==null || ((RemoteWebDriver)webdriver).getSessionId() == null){
			webdriver = WebDriverList.PhantomJSDriver.driverType();
		}
		return webdriver;
	}
}
