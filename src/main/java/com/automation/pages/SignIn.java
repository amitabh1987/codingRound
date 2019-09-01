package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.utils.DriverManager;

public class SignIn extends BasePage{
	private By yourTrips=By.linkText("Your trips");
	private By SignIn=By.id("SignIn");
	private By signInButton=By.id("signInButton");
	private By errors1=By.id("errors1");
	private By SignInFrame=By.id("modal_window");

	Logs logger= new Logs(SignIn.class);
	
	 public SignIn(DriverManager driver){
		 super(driver);
    }
	 
    public void clickYourTrips() throws Exception {
    		logger.info("Click on YourTrips");
    		driver.	waitForPageLoad();
	    	driver.waitForLocatorToBePresent(yourTrips);
	    	driver.waitForLocatorToBeClickable(yourTrips);
	    	driver.click(yourTrips);
    }
	
    public void clickSignIn() throws Exception {
    		logger.info("Click on Sign In");
	    	driver.waitForLocatorToBeClickable(SignIn);
	    	driver.click(SignIn);
    }
    
    public void clickSignInButton() throws Exception {
    		logger.info("Click on Sign In Button");
    		driver.switchToFrame(SignInFrame);
	    	driver.waitForLocatorToBeClickable(signInButton);
	    	driver.click(signInButton);
    }
    
	public String getErrorIfSignInDetailsAreMissing() {
		logger.info("Reading Error message If Sign In Details Are Missing");
         String errorMessage=driver.getText(errors1);
         driver.switchToDefault();
         return errorMessage;
    }



}
