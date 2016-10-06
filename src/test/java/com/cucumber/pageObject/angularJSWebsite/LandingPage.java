package com.cucumber.pageObject.angularJSWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends AbstractPage{	
	public LandingPage(WebDriver driver){
		super(driver);
	}

	public WebElement getDownLoadAngularJSOneButton() {
		return driver.findElement(By.cssSelector(".btn.btn-large.btn-primary.download-btn"));
	}
	
	public DownloadAngularJSOnePage navigateToDownloadAngularJSOnePage(){
		getDownLoadAngularJSOneButton().click();
		return new DownloadAngularJSOnePage(driver);
	}
	
	public TheBasicsPage navigateToTheBasicsPage(){
		return new TheBasicsPage(driver);
	}
	
}
