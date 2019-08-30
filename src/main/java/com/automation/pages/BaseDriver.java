package com.automation.pages;

import org.openqa.selenium.WebDriver;

public class BaseDriver {
public static WebDriver driver;
	
	public BaseDriver(WebDriver driver){
		this.driver=driver; 
	}
	
	 public static WebDriver getDriver() {
	        return driver;
	  }
}
