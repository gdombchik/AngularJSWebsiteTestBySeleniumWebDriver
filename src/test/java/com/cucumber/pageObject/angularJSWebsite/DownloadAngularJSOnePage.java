package com.cucumber.pageObject.angularJSWebsite;

import java.util.List;

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
		return getInputBoxByAttributeValue("bower");
	}
	
	//getNpm
	public WebElement getNpm() {
		return getInputBoxByAttributeValue("npm");
	}
	
	//Return the input element filtered by value
	private WebElement getInputBoxByAttributeValue(String value){
		WebElement webElementReturned=null;
		List<WebElement> webElements = driver.findElements(By.tagName("input"));
		for(WebElement webElement : webElements){
			if(webElement.getAttribute("value").contains(value)){
				webElementReturned = webElement;
			}
			//System.out.println("-----> " + webElement.getAttribute("value"));
		}
		return webElementReturned;
	};
	
	
	//
	//extras
	//previousVersions
	//getDownloadButton
	//getCloseButton
	
	
}
