package com.hrm.baseclass;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.hrm.utilities.ConfigReader;
import com.hrm.utilities.Constants;
import com.hrm.utilities.ExtendReport;

import com.hrm.utilities.Screenshot;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;


	@BeforeTest
	public static void startExtedReport() {
		ExtendReport.startTest();
	}

	@AfterTest
	public static void endExtedReport() {
		ExtendReport.endReport();
	}

	@BeforeMethod(alwaysRun = true)
	public static WebDriver setUp() {
		ConfigReader.readProperties(Constants.CONFIGS_FILE_PATH);
		switch (ConfigReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			// System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}

		// driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigReader.getProperty("URL"));

		return driver;

	}

	@AfterMethod(alwaysRun = true) // to make this method to run after every @Test method
	public static void tearDown(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			ExtendReport.extendTest.log(Status.FAIL ,"TEST CASE FAILED IS "+result.getName());
			ExtendReport.extendTest.log(Status.FAIL ,"TEST CASE FAILED IS "+result.getThrowable());
			String screenshotpath=Screenshot.captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
			ExtendReport.extendTest.addScreenCaptureFromPath(screenshotpath);
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				ExtendReport.extendTest.log(Status.SKIP ,"TEST CASE SKIPPED IS "+result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS) {
				ExtendReport.extendTest.log(Status.PASS ,"TEST CASE PASSED IS "+result.getName());
			}
		driver.quit();
}
	
}
