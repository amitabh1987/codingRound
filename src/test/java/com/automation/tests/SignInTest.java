package com.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws Exception {
    		signIn.clickYourTrips();
    		signIn.clickSignIn();
    		signIn.clickSignInButton();
    		Assert.assertTrue(signIn.getErrorIfSignInDetailsAreMissing().contains("There were errors in your submission"));
    }
}
