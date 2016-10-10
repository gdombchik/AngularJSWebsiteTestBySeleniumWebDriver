package com.cucumber;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cucumber.configuration.AppConfig;
import com.cucumber.service.FileService;

public class AppMain {
	
	public static void main(String args[]){
		AbstractApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		FileService service = (FileService) context.getBean("fileService");
		
		service.readValues();
		context.close();
	}
	
}
