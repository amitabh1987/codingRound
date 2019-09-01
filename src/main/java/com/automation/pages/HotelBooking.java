package com.automation.pages;
import org.openqa.selenium.By;

import com.automation.utils.DriverManager;

public class HotelBooking extends BasePage{
	private By hotelLink=By.linkText("Hotels");
	private By localityTextBox=By.id("Tags");
	private By searchButton=By.id("SearchHotelsButton");
	private By travellerSelection=By.id("travellersOnhome");
	private By categoryOptions=By.xpath("//ul[@id='ui-id-1']//li[@class='list']");
	private By subTitle=By.xpath("//h2[@class='subTitle']");
	
	Logs logger= new Logs(HotelBooking.class);
	
	 public HotelBooking(DriverManager driver){
	 super(driver);
   }

	 /**
	  * search For Hotels
	  * @throws Exception
	  */
    public void searchForHotels(String location,String travellers) throws Exception {
    		logger.info("Search for hotels");
        driver.click(hotelLink);
        driver.sendKeys(localityTextBox,location);
        driver.selectFromList(categoryOptions,location);
        driver.click(subTitle);
        driver.selectOptionByVisibleText(travellerSelection,travellers);
        driver.click(searchButton);
    }

}
