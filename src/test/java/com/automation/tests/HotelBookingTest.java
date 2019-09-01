package com.automation.tests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseTest{
	@Parameters({"location","travellers"})
    @Test()
    public void shouldBeAbleToSearchForHotels(String location,String travellers) throws Exception {
    		hotelBooking.searchForHotels(location,travellers);
    }

}
