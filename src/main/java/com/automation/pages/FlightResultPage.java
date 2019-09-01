package com.automation.pages;
import org.openqa.selenium.By;
import com.automation.utils.DriverManager;

public class FlightResultPage extends BasePage{
	Logs logger= new Logs(FlightResultPage.class);
	private By SearchSummary=By.className("searchSummary");
    public FlightResultPage(DriverManager driver){
    	 super(driver);
    }
    
   /**
    *  Wait For Flight Result Page
    */
   public void waitForFlightResultPage() {
	   logger.info("Wait For Flight Result Page");
	   driver.waitForPageLoad();
   }
    /**
     * verify that result appears for the journey search
     * @return
     * @throws Exception 
     */
    public boolean verifyresultsAppearForAOneWayJourney() throws Exception {
    		logger.info("Verifying results Appear For OneWay Journey");
	    	driver.waitForLocatorToBeVisible(SearchSummary);
	    return driver.isLocatorToBePresent(SearchSummary);
    }
}
