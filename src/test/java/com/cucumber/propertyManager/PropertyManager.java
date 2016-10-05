package com.cucumber.propertyManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	private String phantomJSDriver;
	private String screenShot;

	public void generateProperty(){
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = this.getClass().getClassLoader().getResourceAsStream("com/cucumber/propertyManager/parameters.properties");
			prop.load(input);
			setPhantomJSDriver(prop.get("phantomJSDriver").toString());
			setScreenShot(prop.get("screenShot").toString());
		}catch(IOException e){
			e.printStackTrace();
		}
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
