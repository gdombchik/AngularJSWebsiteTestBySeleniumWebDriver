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
		return driver.findElement(By.cssSelector(".btn.branch-1-5-x"));
	}
	
	//buildMinified
	public WebElement getBuildMinified() {
		return driver.findElement(By.cssSelector(".btn.minified"));
	}
	
	//buildZip
	public WebElement getBuildZip() {
		return driver.findElement(By.cssSelector(".btn.zip"));
	}
	
	//buildUncompressed
	public WebElement getBuildUncompressed() {
		return driver.findElement(By.cssSelector(".btn.uncompressed"));
	}
	
	//cdn
	public WebElement getCdn() {
		return driver.findElement(By.id("cdnURL"));
	}
	
	//getBower
	public WebElement getBower() {
		return driver.findElement(By.id("cdnURL"));
	}
	
	
	//getNpm
	//extras
	//previousVersions
	//getDownloadButton
	//getCloseButton
	
	
}
