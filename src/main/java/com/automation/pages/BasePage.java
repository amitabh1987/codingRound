package com.automation.pages;

import com.automation.utils.DriverManager;

public class BasePage extends BaseDriver{
	public static DriverManager driver;
	
	 public BasePage(DriverManager driver){
		 super(driver);
		 this.driver=driver;
    }
}
