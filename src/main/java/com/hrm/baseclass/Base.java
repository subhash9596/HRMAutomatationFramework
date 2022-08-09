package com.hrm.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrm.utilities.ConfigReader;
import com.hrm.utilities.Constants;
import com.hrm.utilities.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
public static WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public static WebDriver setUp() {
		    ConfigReader.readProperties(Constants.CONFIGS_FILE_PATH);
		   switch (ConfigReader.getProperty("browser").toLowerCase()) {
		      case "chrome":
				//System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		    	  WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "firefox":
					System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
					driver = new FirefoxDriver();
					break;
				default:
					throw new RuntimeException("Browser is not supported");
				}

				// driver.manage().window().fullscreen();
				driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
				driver.get(ConfigReader.getProperty("URL"));
				// initialize all page objects as part of setup
				//PageInitializer.initialize();

				return driver;

			}

			
		@AfterMethod(alwaysRun = true) // to make this method to run after every @Test method
			public static void tearDown(ITestResult result) {
			if (result.getStatus() == ITestResult.FAILURE) {
				Screenshot.captureScreenshot(
						result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
			}
					driver.quit();
				
			}

}
