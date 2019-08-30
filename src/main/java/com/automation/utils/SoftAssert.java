package com.automation.utils;

import java.io.IOException;
import java.util.Map;

import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class SoftAssert extends org.testng.asserts.SoftAssert
{
	private final Map<AssertionError, IAssert>	m_errors	= Maps.newHashMap();
	private  DriverManager					driver;
	// private static UISoftAssert objSoftAssert;
	private ExtentTest test;
	public SoftAssert(DriverManager driver) {
		this.driver = driver;
	}

	public SoftAssert(DriverManager driver, ExtentTest test ) {
		this.driver = driver;
		this.test=test;
	}


	protected void doAssert(IAssert assertCommand) {
		onBeforeAssert(assertCommand);
		try {
			executeAssert(assertCommand);
			onAssertSuccess(assertCommand);
		} catch(AssertionError ex) {
			m_errors.put(ex, assertCommand);
			onAssertFailure(assertCommand, ex);
			//  throw ex;
		} finally {
			onAfterAssert(assertCommand);
		}
	}

	@Override
	public void executeAssert(IAssert a)
	{
		try {
			a.doAssert();
		} catch (AssertionError ex) {
			m_errors.put(ex, a);
			//onAssertFailure(a, ex);
			throw ex;
		}
	}

	@Override
	public void assertAll()
	{
		if (!m_errors.isEmpty()) {
			StringBuilder sb = new StringBuilder("The following asserts failed:\n");
			boolean first = true;
			for (Map.Entry<AssertionError, IAssert> ae : m_errors.entrySet()) {
				if (first) {
					first = false;
				} else {
					sb.append(", ");
				}
				sb.append(ae.getValue().getMessage());
			}
			throw new AssertionError(sb.toString());
		}
	}

	@Override
	public void onAfterAssert(IAssert a)
	{
		//super.onAfterAssert(a);
	}

	@Override
	public void onBeforeAssert(IAssert a)
	{
		//		Reporter.log("");
		//		Reporter.log("ASSERT DESCRIPTION: " + a.getMessage());

	}

	@Override
	public void onAssertFailure(IAssert a, AssertionError ex)
	{
		try {
			String sScreenshotPath= driver.getScreenshot();
			test.log(Status.FAIL, "<pre><b><font color='red'>" +"FUNCTIONAL FAILURE ::"+ex.getMessage()+"."+ "</font></b></pre>"+ test.addScreenCaptureFromPath(sScreenshotPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onAssertSuccess(IAssert a){
		try{
			test.log(Status.PASS,"<b><font color='green'>"+a.getMessage()+"</font></b>");
		}catch(Exception e){

		}
	}

	public void onAutomationFailure(Exception e) throws IOException {
		String sScreenshotPath = null;
		try {
			sScreenshotPath = driver.getScreenshot();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		test.log(Status.FATAL, "<pre><b><font color='red'>" +"AUTOMATION FAILURE ::"+e.getMessage()+"."+ "</font></b></pre>"+ test.addScreenCaptureFromPath(sScreenshotPath));
		throw new AssertionError(e.getMessage());
	}


}
