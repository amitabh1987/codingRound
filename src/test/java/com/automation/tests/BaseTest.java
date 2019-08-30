package com.automation.tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.automation.pages.BasePage;
import com.automation.pages.FlightBooking;
import com.automation.pages.FlightResultPage;
import com.automation.pages.HotelBooking;
import com.automation.pages.SignIn;
import com.automation.utils.Config;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentManager;
import com.automation.utils.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
	public DriverManager driver=new DriverManager();;
	protected ExtentReports extent;
	protected ExtentTest test;
	protected Config config=new Config();
	protected SoftAssert s_Assert;
	protected String url;
	protected String ssoUN;
	protected String ssoPWD;
	protected String corrigoProUN;
	protected String corrigoProPWD;
	protected FlightBooking flightBooking;
	protected HotelBooking hotelBooking;
	protected SignIn signIn;
	protected  FlightResultPage flightResultPage ;
	
	@BeforeSuite
	public void setUp() {
		flightBooking=new FlightBooking(driver);
		hotelBooking=new HotelBooking(driver);
		flightResultPage=new FlightResultPage(driver);
		signIn=new SignIn(driver);
		config.loadProps("config.properties");
		ssoUN=config.getProperty("USERNAME");
		ssoPWD=config.getProperty("PASSWORD");
		url=config.getProperty("URL");
		extent=ExtentManager.getInstance();
	}


	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(Method method) {
		Test t;
		t=method.getAnnotation(Test.class);
		System.out.println(t.description());
		test= extent.createTest(method.getName(),t.description());
		driver.launchBrowser();
		driver.navigateTo(url);
		s_Assert= new SoftAssert(driver,test);
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod(Method m) {
		driver.quitBrowser();
	}
	
	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		extent.flush();
	}

}
