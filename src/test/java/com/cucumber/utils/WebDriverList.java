package com.cucumber.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.cucumber.propertyManager.PropertyManager;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public enum WebDriverList {
	FirefoxDriver("FirefoxDriver"),HtmlUnitDriver("HtmlUnitDriver"),ChromeDriver("ChromeDriver"),PhantomJSDriver("PhantomJSDriver");
	
	private String driverDescription;
	
	WebDriverList(String description){
		this.driverDescription = description;
	}
	
	public String driverDescription(){
		return driverDescription;
	}

	public WebDriver driverType(){
		switch(this){
			case FirefoxDriver:
				return new FirefoxDriver();
			case HtmlUnitDriver:
				//webdriver = new HtmlUnitDriver(BrowserVersion.BEST_SUPPORTED,true); //FIREFOX_38			
				//return new HtmlUnitDriver(BrowserVersion.FIREFOX_45,true);
				return new HtmlUnitDriver(BrowserVersion.CHROME,true);
				//return new HtmlUnitDriver();
			case ChromeDriver:
				return new ChromeDriver();
			case PhantomJSDriver:
				PropertyManager propertyManager = new PropertyManager();
				propertyManager.generateProperty();
				File src = new File(propertyManager.getPhantomJSDriver());
			    System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
			    return new PhantomJSDriver();
			default:
				return new FirefoxDriver();
		}
	}
}
