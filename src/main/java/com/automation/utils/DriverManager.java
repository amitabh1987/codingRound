/**
 * 
 */
package com.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.pages.Logs;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager implements WebDriver{
	Logs logger= new Logs(DriverManager.class);
	public  static WebDriver driver;
	private  FluentWait<WebDriver> wait;
	private WebElement element;
	private  int DEFAULT_TIMEOUT=60;
	private int POLLING_TIME=10;

	public DriverManager(){
	}
	
	 public static WebDriver getDriver() {
	        return driver;
	    }

	public void launchBrowser(){
		logger.debug("Launching browser  :: ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void closeBrowser(){
		logger.debug("Closing browser");
		driver.close();
	}

	public void quitBrowser(){
		logger.debug("Quiting browser");
		driver.quit();
	}

	public void navigateTo(String url){
		logger.debug("Navigating to url :: "+url);
		driver.navigate().to(url);
	}


	public WebElement findElement(By by){
		try {
			element=driver.findElement(by);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}

	public List<WebElement> findElements(By by){
		List<WebElement> list;
		list=driver.findElements(by);
		return list;
	}

	public void waitForLocatorToBeClickable(By locator) {
		logger.debug("Waiting for locator to be clickable :: "+locator,true);
		long startTime = System.currentTimeMillis();
		wait = new WebDriverWait(driver, DEFAULT_TIMEOUT,POLLING_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		logger.debug("Finished waiting for locator to be clickable after " + totalTime + " milliseconds.",true);
	} 

	public void waitForLocatorToBeClickable(By locator, int timeOut) {
		logger.debug("Waiting for locator to be clickable :: "+locator,true);
		wait = new WebDriverWait(driver, timeOut,POLLING_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.debug("Waited for locator to be clickable: "+locator,true);
	} 

	public void waitForElementoBeClickable(WebElement webElement) {
		logger.debug("Waiting for element to be clickable :: "+webElement,true);
		long startTime = System.currentTimeMillis();
		wait = new WebDriverWait(driver, DEFAULT_TIMEOUT,POLLING_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		logger.debug("Finished waiting for locator to be clickable after " + totalTime + " milliseconds.",true);
	} 

	public void waitForElementToBeClickable(WebElement webElement, int timeOut) {
		logger.debug("Waiting for Element to be clickable :: "+webElement,true);
		wait = new WebDriverWait(driver, timeOut,POLLING_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		logger.debug("Waited for locator to be clickable: "+webElement,true);
	} 

	public void waitForLocatorToBePresent(By by){
		logger.debug("Waiting for locator to be Present :: "+by,true);
		wait=new WebDriverWait(driver, DEFAULT_TIMEOUT,POLLING_TIME);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		logger.debug("Waited for locator to be present: "+by);
	}

	public boolean isLocatorToBePresent(By by) throws Exception{
		return driver.findElement(by).isDisplayed();
	}

	public void waitForLocatorToBeVisible(final By by){
		logger.debug("Waiting for locator to be visible: "+by);
		long startTime = System.currentTimeMillis();
		wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		logger.debug("Finished waiting for locator to be visible after " + totalTime + " milliseconds.");
	}

	public void waitForLocatorToBeVisible(final By by,int timeOut){
		logger.debug("Waiting for locator to be visible: "+by);
		long startTime = System.currentTimeMillis();
		wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		logger.debug("Finished waiting for locator to be visible after " + totalTime + " milliseconds.");
	}

	public boolean waitForPageLoad() {
		logger.debug("Waiting for Page to load",true);
		boolean isLoaded = false;
		long startTime = System.currentTimeMillis();
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		wait = new WebDriverWait(driver, DEFAULT_TIMEOUT,POLLING_TIME);
		wait.until(pageLoadCondition);
		isLoaded = true;
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		logger.debug("Finished waiting for page to load after " + totalTime + " milliseconds.",true);
		return isLoaded;
	}


	public boolean waitForAjax(){
		logger.debug("Waiting for AJAX to load");
		boolean isLoaded = false;
		long startTime = System.currentTimeMillis();
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return (window.jQuery != null) && (jQuery.active === 0);").equals("true");
			}
		};
		wait = new WebDriverWait(driver, DEFAULT_TIMEOUT,POLLING_TIME).ignoring(TimeoutException.class);
		wait.until(pageLoadCondition);
		isLoaded = true;
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		logger.debug("Finished waiting for page to load after " + totalTime + " milliseconds.",true);
		return isLoaded;
	}

	public boolean waitForAjax(int timeOutInSeconds){
		logger.debug("Waiting for AJAX to load");
		boolean isLoaded = false;
		long startTime = System.currentTimeMillis();
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return (window.jQuery != null) && (jQuery.active === 0);").equals("true");
			}
		};
		wait = new WebDriverWait(driver, timeOutInSeconds,POLLING_TIME);
		wait.until(pageLoadCondition);
		isLoaded = true;
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		logger.debug("Finished waiting for page to load after " + totalTime + " milliseconds.",true);
		return isLoaded;
	}

	public boolean waitForPageLoad(int timeout) {
		logger.debug("Waiting for Page to load",true);
		boolean isLoaded = false;
		long startTime = System.currentTimeMillis();
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		wait = new WebDriverWait(driver, timeout,POLLING_TIME);
		wait.until(pageLoadCondition);
		isLoaded = true;
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		logger.debug("Finished waiting for page to load after " + totalTime + " milliseconds.",true);
		return isLoaded;
	}

	public void pauseExecutionFor(long lTimeInMilliSeconds) throws InterruptedException {
		logger.debug("Waiting for "+lTimeInMilliSeconds+" millseconds",true);
		Thread.sleep(lTimeInMilliSeconds);
	}


	public void clickLocatorByJS(By by) throws Exception {
		WebElement element = findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		logger.debug("Clicking Locator by using JScript "+ by.toString(),true);
		executor.executeScript("arguments[0].click();", element);
	}

	public String getTextByJS(WebElement element){
		String text="";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		logger.debug("Clicking Locator by using JScript "+ element);
		text=(String) executor.executeScript("return arguments[0].innerHTML;", element); 
		return text;
	}

	public void click(By by) throws Exception{
		element=findElement(by);
		waitForLocatorToBeClickable(by);
		logger.debug("Clicking Locator :: "+by.toString());
		element.click();
		logger.debug("Locator is clicked :: "+by.toString());
	}
	
	public void click(WebElement element) throws Exception{
		logger.debug("Clicking Element ::");
		element.click();
		logger.debug("Locator is Element :: ");
	}


	public void submitLocator(By by) throws Exception{
		element=findElement(by);
		logger.debug("Clicking Locator :: "+by.toString());
		element.submit();
		logger.debug("Locator is clicked :: "+by.toString());
	}
	
	public void sendKeys(By by,String value) throws Exception{
		waitForLocatorToBeVisible(by);
		element=this.findElement(by);
		logger.debug("Typing input :: "+value);
		element.sendKeys(value);
	}

	public void sendKey(By by,String value){
	    String val = value; 
	    waitForLocatorToBeVisible(by);
		element=this.findElement(by);
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        logger.debug("Typing input :: "+s);
	        element.sendKeys(s);
	    }       
	}
	
	public void sendKeysElementByJS(WebElement eElement,String text){
		logger.debug("Typing text by JS :: "+text);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		logger.debug("Clicking Locator by using JScript "+ eElement);
		executor.executeScript("arguments[0].value=arguments[1];", eElement,text);
		logger.debug("Element is clicked by JS :: "+element.toString());
	}

	public void sendKeys(By by,Keys key) throws Exception{
		waitForLocatorToBeVisible(by);
		element=this.findElement(by);
		logger.debug("Sending keyboard input :: "+key);
		element.sendKeys(key);
	}

	public void sendKeys(WebElement element,Keys key){
		logger.debug("Sending keyboard input :: "+key);
		element.sendKeys(key);
	}

	public void clear(By by) throws Exception{
		element=findElement(by);
		logger.debug("Clearing input field :: "+by.toString(),true);
		element.clear();
	}

	public String getText(By by){
		long startTime = System.currentTimeMillis();
		String text="";
		try {
			text=this.findElement(by).getText();
			logger.debug("Text from "+ by+" is "+text);
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			logger.debug("Finished getting text from locator in " + totalTime + " milliseconds.",true);
		} catch (Exception e) {
			logger.debug("Issue in finding element "+e.getMessage());
		}
		return text; 
	}

	public String getText(WebElement element){
		return element.getText(); 
	}

	public void selectOptionByVisibleText(By selectionOption, String option) {
		logger.debug("Select option :"+option);
		new Select(driver.findElement(selectionOption)).selectByVisibleText(option);
	}
	
	public String getScreenshot() throws IOException{
		String FullSnapShotFilePath = "";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String sFilename = "";
		sFilename = "Screenshot-" + getDateTime() + ".png";
		FullSnapShotFilePath = System.getProperty("user.dir")+ "\\Output\\ScreenShots\\" + sFilename;
		FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
		return FullSnapShotFilePath;
	}

	public String getDateTime() {
		String sDateTime = "";
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Date now = new Date();
			String strDate = sdfDate.format(now);
			String strTime = sdfTime.format(now);
			strTime = strTime.replace(":", "-");
			sDateTime = "D" + strDate + "_T" + strTime;
		} catch (Exception e) {
			System.err.println(e);
		}
		return sDateTime;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void get(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}
	
	public void switchToFrame(By by) throws Exception{
		logger.debug("Switiching to frame :: "+by.toString(),true);
		driver.switchTo().frame(findElement(by));
	}

	public void switchToDefault(){
		logger.debug("Switching to parent window");
		driver.switchTo().defaultContent();
		logger.debug("Switched succesfully to defaul");
	}

	public void selectFromList(By by) throws Exception {
		waitForLocatorToBeVisible(by,100);
		List<WebElement> elements=findElements(by);
		elements.get(0).click();
	}
	
	public void selectFromList(By by,String sValueToBeSelected) throws Exception {
		waitForLocatorToBeVisible(by,200);
		List<WebElement> elements=findElements(by);
		String text="";
		boolean flag = false;
		for (WebElement e : elements) {
			text=e.getText().toUpperCase();
			logger.debug("Found :: "+text+" . Selecting value :: "+sValueToBeSelected,true);
			if (text.contains(sValueToBeSelected.toUpperCase())) {
				logger.debug("Match Found !!! Clicking value :: "+sValueToBeSelected,true);
				click(e);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new Exception("No match found in the list for value->"+ sValueToBeSelected);
		}
	}
	
    public void selectCurrentDateFromDatePicker(By by){
        //Get Today's number
    		String today = getCurrentDay();
        logger.debug("Today's number: " + today + "\n");
        //This is from date picker table
        WebElement dateWidgetFrom = findElement(by);
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            //Select Today's Date
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
    }
	
    private String getCurrentDay (){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        logger.debug("Today Int: " + todayInt +"\n");
        String todayStr = Integer.toString(todayInt);
        logger.debug("Today Str: " + todayStr);
        return todayStr;
    }
    
	
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}
}
