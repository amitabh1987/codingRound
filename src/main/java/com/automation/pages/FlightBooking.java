package com.automation.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.utils.DriverManager;

public class FlightBooking extends BasePage{
	private By OneWay=By.id("OneWay");
	private By FromTag=By.id("FromTag");
	private By ToTag=By.id("ToTag");
	private By originOptions=By.xpath("//ul[@id='ui-id-1']//li//a");
	private By SearchBtn=By.id("SearchBtn");
	private By SearchSummary=By.className("searchSummary");
	
	private By DepartPicker=By.id("DepartDate");
	private By DatePickerBody=By.xpath("//div[contains(@class,'first')]//table[@class='calendar']");
    
    public FlightBooking(DriverManager driver){
    	 super(driver);
    }
    
    /**
     * Select Locations For One Way Journey
     * @throws Exception
     */
    public void selectLocationsForOneWayJourney() throws Exception {
		driver.waitForLocatorToBeClickable(OneWay);
		driver.click(OneWay);
		driver.clear(FromTag);
		driver.sendKey(FromTag, "Bangalore");
		driver.selectFromList(originOptions);
        driver.clear(ToTag); 
        driver.sendKey(ToTag,"Delhi");
    }
    
   public FlightResultPage clickSearchBtn() throws Exception{
        driver.click(SearchBtn);
        return new FlightResultPage(driver);
    }
    
    public void selectCurrentDateAsDepartDate() {
    	 //Click and open the datepickers
        try {
			driver.click(DepartPicker);
			driver.selectCurrentDateFromDatePicker(DatePickerBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
}
