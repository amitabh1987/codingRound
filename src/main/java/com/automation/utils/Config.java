/**
 * 
 */
package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;

public class Config {
	public static String path="src/test/resources/config/";
	private static final Properties props=new Properties();
	public static ExtentTest extentTest;
	public void loadProps(String fileName){
		try{
			FileInputStream input= new FileInputStream(path+fileName);
			props.load(input);
		}catch(FileNotFoundException file){
			file.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public String getProperty(String key){
		return props.getProperty(key);
	}


	 public ExtentTest getExtentTest() {
			return extentTest;
		}
	public void setExtentTest(ExtentTest extentTest) {
		this.extentTest = extentTest;
	}
	 
}
