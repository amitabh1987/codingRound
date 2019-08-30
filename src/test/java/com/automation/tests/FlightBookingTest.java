package com.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTest{

    @Test
    public void testThatResultsAppearForAOneWayJourney() throws Exception {
    	flightBooking.selectLocationsForOneWayJourney();
    	flightBooking.selectCurrentDateAsDepartDate();
    	flightResultPage=flightBooking.clickSearchBtn();
    	flightResultPage.waitForFlightResultPage();
    	 //verify that result appears for the provided journey search
    	Assert.assertTrue(flightResultPage.verifyresultsAppearForAOneWayJourney());
    }
}
