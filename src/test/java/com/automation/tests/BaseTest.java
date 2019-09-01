package com.automation.tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.automation.pages.FlightBooking;
import com.automation.pages.FlightResultPage;
import com.automation.pages.HotelBooking;
import com.automation.pages.Logs;
import com.automation.pages.SignIn;
import com.automation.utils.Config;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentManager;
import com.automation.utils.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
	Logs logger;
	public DriverManager driver=new DriverManager();;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	protected Config config=new Config();
	protected static String url;
	protected static FlightBooking flightBooking;
	protected static HotelBooking hotelBooking;
	protected static SignIn signIn;
	protected  static FlightResultPage flightResultPage ;
	
	@BeforeSuite(alwaysRun=true)
	public void setUp() {
		flightBooking=new FlightBooking(driver);
		hotelBooking=new HotelBooking(driver);
		flightResultPage=new FlightResultPage(driver);
		signIn=new SignIn(driver);
		config.loadProps("config.properties");
		url=config.getProperty("URL");
		extent=ExtentManager.getInstance();
	}

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(Method method) {
		Test t;
		t=method.getAnnotation(Test.class);
		extentTest= extent.createTest(method.getName(),t.description());
		config.setExtentTest(extentTest);
		logger=new Logs(BaseTest.class,config);
		logger.info("Stating test method : "+method.getName());
		driver.launchBrowser();
		driver.navigateTo(url);
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod(Method method) {
		logger.info("End test method : "+method.getName());
		driver.quitBrowser();
	}
	
	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		extent.flush();
	}

}
