package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.utils.DriverManager;

public class HotelBooking extends BasePage{
	private By hotelLink=By.linkText("Hotels");
	private By localityTextBox=By.id("Tags");
	private By searchButton=By.id("SearchHotelsButton");
	private By travellerSelection=By.id("travellersOnhome");
	private By categoryOptions=By.xpath("//ul[@id='ui-id-1']//li[@class='list']");
	private By subTitle=By.xpath("//h2[@class='subTitle']");
	
	
	String location="Indiranagar, Bangalore";
	
	 public HotelBooking(DriverManager driver){
	 super(driver);
   }

	 /**
	  * search For Hotels
	  * @throws Exception
	  */
    public void searchForHotels() throws Exception {
        driver.click(hotelLink);
        driver.sendKeys(localityTextBox,location);
        driver.selectFromList(categoryOptions,location);
        driver.click(subTitle);
        driver.selectOptionByVisibleText(travellerSelection,"1 room, 2 adults");
        driver.click(searchButton);

    }

}
