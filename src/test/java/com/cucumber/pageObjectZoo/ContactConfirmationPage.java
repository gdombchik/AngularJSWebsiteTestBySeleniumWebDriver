package com.cucumber.pageObjectZoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactConfirmationPage extends AbstractPage{
	
	public ContactConfirmationPage(WebDriver driver){
		super(driver);
	}
	
	public String getPageTitle(){
		return driver.findElement(By.cssSelector(".content h1")).getText();
	}
}
