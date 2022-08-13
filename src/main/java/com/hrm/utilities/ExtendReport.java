package com.hrm.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrm.baseclass.Base;

public class ExtendReport extends Base {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extendTest;
	public static ITestResult result;

	public static void startTest() {
		String dateMonth = new SimpleDateFormat("dd-MM-yyyy_HHmmss").format(new Date());
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//HRMreport"+ dateMonth + ".html");
		sparkReporter.config().setDocumentTitle("orangeHRM");
		sparkReporter.config().setReportName("Subhahs");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("hostname", "Localhost");
		extentReports.setSystemInfo("Tester Name", "Subhash");
		extentReports.setSystemInfo("Browser Name", "Chrome");
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public static void endReport() {
		extentReports.flush();
	}

	public static void checkStatusExtedReport() {

		if (result.getStatus() == ITestResult.FAILURE) {
			extendTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			extendTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			String screenshotpath = Screenshot.captureScreenshot(
					result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
			extendTest.addScreenCaptureFromPath(screenshotpath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			extendTest.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extendTest.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());
		}
	}

}
