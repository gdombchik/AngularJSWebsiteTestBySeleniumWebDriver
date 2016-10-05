package com.cucumber.propertyManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

	private String contactFormNameField;
	private String contactFormNameValue;
	private String phantomJSDriver;
	private String screenShot;

	public void generateProperty(){
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = this.getClass().getClassLoader().getResourceAsStream("com/cucumber/propertyManager/parameters.properties");
			prop.load(input);
			
			setContactFormNameField(prop.get("name_field").toString());
			setContactFormNameValue(prop.get("name_value").toString());
			setPhantomJSDriver(prop.get("phantomJSDriver").toString());
			setScreenShot(prop.get("screenShot").toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getContactFormNameField() {
		return contactFormNameField;
	}

	public void setContactFormNameField(String contactFormNameField) {
		this.contactFormNameField = contactFormNameField;
	}

	public String getContactFormNameValue() {
		return contactFormNameValue;
	}

	public void setContactFormNameValue(String contactFormNameValue) {
		this.contactFormNameValue = contactFormNameValue;
	}
	
	public String getPhantomJSDriver() {
		return phantomJSDriver;
	}

	public void setPhantomJSDriver(String phantomJSDriver) {
		this.phantomJSDriver = phantomJSDriver;
	}
	
	public String getScreenShot() {
		return screenShot;
	}

	public void setScreenShot(String screenShot) {
		this.screenShot = screenShot;
	}
}
