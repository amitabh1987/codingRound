/**
 * 
 */
package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

public class ExtentManager {
	
	
	private static ExtentReports extent;
	public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            //extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\OLR_AutomationReport.html",true);
        	ExtentAventReporter reporter = new ExtentAventReporter(System.getProperty("user.dir")+"\\test-output\\HLOL_AutomationReport.html");
        	extent =new ExtentReports();
        	extent.attachReporter(reporter);
        }
        return extent;
    }

}
