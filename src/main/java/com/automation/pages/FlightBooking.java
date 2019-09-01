package com.automation.pages;
import org.openqa.selenium.By;
import com.automation.utils.DriverManager;

public class FlightBooking extends BasePage{
	Logs logger= new Logs(FlightBooking.class);
	private By OneWay=By.id("OneWay");
	private By FromTag=By.id("FromTag");
	private By ToTag=By.id("ToTag");
	private By originOptions=By.xpath("//ul[@id='ui-id-1']//li//a");
	private By SearchBtn=By.id("SearchBtn");
	private By DepartPicker=By.id("DepartDate");
	private By DatePickerBody=By.xpath("//div[contains(@class,'first')]//table[@class='calendar']");
    
    public FlightBooking(DriverManager driver){
    	 super(driver);
    }
    
    /**
     * Select Locations for Journey
     * @throws Exception
     */
    public void selectLocationsJourney(String source, String destination) throws Exception {
    		logger.info("Select Locations For Journey");
		driver.waitForLocatorToBeClickable(OneWay);
		driver.click(OneWay);
		driver.clear(FromTag);
		driver.sendKey(FromTag, source);
		driver.selectFromList(originOptions);
        driver.clear(ToTag); 
        driver.sendKey(ToTag,destination);
    }
   
    /**
     * click Search Btn
     * @return
     * @throws Exception
     */
   public FlightResultPage clickSearchBtn() throws Exception{
	   logger.info("Click on Search Button");
        driver.click(SearchBtn);
        return new FlightResultPage(driver);
    }
    
   /**
    * select Current Date As DepartDate
    */
    public void selectCurrentDateAsDepartDate() {
    	logger.info("Open the datepickers and Select Current date");
        try {
			driver.click(DepartPicker);
			driver.selectCurrentDateFromDatePicker(DatePickerBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
}
