package com.automation.tests;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseTest{

    @Test
    public void shouldBeAbleToSearchForHotels() throws Exception {
    		hotelBooking.searchForHotels();
    }

}
