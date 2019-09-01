/**
 * 
 */
package com.automation.utils;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import org.openqa.selenium.Platform;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static Platform platform;
	static String reportFileName =  "newTimeReport.html";
	private static String macPath = System.getProperty("user.dir");
	private static String windowsPath = System.getProperty("user.dir");
	private static String macReportFileLoc = macPath;
	private static String winReportFileLoc = windowsPath;
	public static String fileName = null;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		platform = getCurrentPlatform();
		String newTime = getNewTime();
		reportFileName = reportFileName.replace("newTime", newTime);
		fileName = getReportFileLocation(platform) + reportFileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name").toLowerCase());
		return extent;
	}

	// Select the extent report file location based on platform
	private static String getReportFileLocation(Platform platform) {
		String reportFileLocation = null;
		String newTime = getNewTime();
		System.out.println(newTime);
		switch (platform) {
		case MAC:
			reportFileLocation = macReportFileLoc;
				reportFileLocation = reportFileLocation + "/ExtentReport/";
				macPath = macPath + "/ExtentReport/" ;
			createReportPath(macPath);
			System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
			break;
		case WINDOWS:
			reportFileLocation = winReportFileLoc;
				reportFileLocation = reportFileLocation + "\\ExtentReport\\";
				windowsPath = windowsPath + "\\ExtentReport\\" ;
			createReportPath(windowsPath);
			System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
			break;
		default:
			System.out.println("ExtentReport path has not been set! There is a problem!\n");
			break;
		}
		return reportFileLocation;
	}

	// Create the report path if it does not exist
	private static void createReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdirs()) {
				System.out.println("Directory: " + path + " is created!");
			} else {
				System.out.println("Failed to create directory: " + path);
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
	}

	// Get current platform
	private static Platform getCurrentPlatform() {
		if (platform == null) {
			String operSys = System.getProperty("os.name").toLowerCase();
			if (operSys.contains("win")) {
				platform = Platform.WINDOWS;
			} else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
				platform = Platform.LINUX;
			} else if (operSys.contains("mac")) {
				platform = Platform.MAC;
			}
		}
		return platform;
	}

	public static String getNewTime() {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		String newTime = ts.toString().replace(" ", "_").replace(":", ".").split("\\.")[0] + "_" + ts.toString().replace(" ", "_").replace(":", ".").split("\\.")[1] + "_" + ts.toString().replace(" ", "_").replace(":", ".").split("\\.")[2];
		return newTime;
	}



}
