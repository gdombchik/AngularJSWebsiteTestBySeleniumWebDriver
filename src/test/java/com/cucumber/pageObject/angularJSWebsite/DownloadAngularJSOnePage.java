package com.cucumber.pageObject.angularJSWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadAngularJSOnePage extends AbstractPage {
	public DownloadAngularJSOnePage(WebDriver driver){
		super(driver);
	}

	public WebElement getTitleLabel() {
		return driver.findElement(By.id("downloadLabel"));
	}

	//branch
	public WebElement getBranch() {
		//System.out.println("------>" + driver.findElements(By.tagName("button")).size());
		return driver.findElement(By.cssSelector(".btn.branch-1-5-x"));
	}
	
	//buildMinified
	//buildZip
	//buildUncompressed
	//cdn
	//getBower
	//getNpm
	//extras
	//previousVersions
	//getDownloadButton
	//getCloseButton
	
	
}
