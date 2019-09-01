package com.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTest{
	@Parameters({"sourceFlightLocation","destinationFlightLocation"})
    @Test()
    public void testThatResultsAppearForAOneWayJourney(String source,String destination) throws Exception {
    	flightBooking.selectLocationsJourney(source,destination);
    	flightBooking.selectCurrentDateAsDepartDate();
    	flightResultPage=flightBooking.clickSearchBtn();
    	flightResultPage.waitForFlightResultPage();
    	 //verify that result appears for the provided journey search
    	Assert.assertTrue(flightResultPage.verifyresultsAppearForAOneWayJourney());
    }
}
