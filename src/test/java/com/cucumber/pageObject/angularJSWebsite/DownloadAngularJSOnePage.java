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
	
	//extras
	public WebElement getExtras() {
		return driver.findElement(By.linkText("Browse additional modules"));
	}
	
	//previousVersions
	public WebElement getPreviousVersions() {
		return driver.findElement(By.linkText("Previous Versions"));
	}
	
	public WebElement getDownloadButton(){
		return getLinkByAttributeValue("angular.min.js");
	}
	
	//Return the link element filtered by value
	private WebElement getLinkByAttributeValue(String value){
		WebElement webElementReturned=null;
		List<WebElement> webElements = driver.findElements(By.cssSelector(".btn.btn-primary.btn-large"));
		for(WebElement webElement : webElements){
			System.out.println("-----> " + webElement.getAttribute("href"));
			if(webElement.getAttribute("href").contains(value)){
				webElementReturned = webElement;
			}
		}
		return webElementReturned;
	};
	
	
	//getDownloadButton
	//getCloseButton
	
	
}
