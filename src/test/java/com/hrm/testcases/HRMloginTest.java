package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.HomePage;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ConfigReader;

public class HRMloginTest extends Base {

	@Test(testName = "validAdminLoign",groups = {"Regresssion"})
	public void validAdminLogin() {

		HomePage homepage = new HomePage();
		CommanMethods.sendText(homepage.userid, ConfigReader.getProperty("username"));
		CommanMethods.sendText(homepage.password, ConfigReader.getProperty("password"));
		CommanMethods.click(homepage.Login);
		String actualTitle = driver.getTitle();
		System.out.println("Title of page" + actualTitle);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("OrangeHRM", actualTitle, "titles are not matching");
		sa.assertAll();
	}

	@Test(testName = "invlidUsername",groups = {"Regresssion"})
	public void invalidUsername() {

		HomePage homepage = new HomePage();
		CommanMethods.sendText(homepage.userid, ConfigReader.getProperty("invalidusername"));
		CommanMethods.sendText(homepage.password, ConfigReader.getProperty("password"));
		CommanMethods.click(homepage.Login);
		String actualerrormessage = homepage.LoginFalureMessage.getText();
		System.out.println(actualerrormessage);
		String expectedErrorMessage = "Invalid credentials";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(expectedErrorMessage, actualerrormessage, "titles are not matching");
		sa.assertAll();
	}

	@Test
	public void invalidpassword() {

		HomePage homepage = new HomePage();
		CommanMethods.sendText(homepage.userid, ConfigReader.getProperty("username"));
		CommanMethods.sendText(homepage.password, ConfigReader.getProperty("invalidpassword"));
		CommanMethods.click(homepage.Login);
		String actualerrormessage = homepage.LoginFalureMessage.getText();
		System.out.println(actualerrormessage);
		String expectedErrorMessage = "Invalid credentials";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(expectedErrorMessage, actualerrormessage, "titles are not matching");
		sa.assertAll();

	}

	@Test(testName = "HRMLoginAdmin",groups = {"Regresssion"},dataProviderClass = StaticDataProvider.class, dataProvider = "Login_Data")
	public void loginHRMAdmin(String Username, String Password) {

		HomePage homepage = new HomePage();
		CommanMethods.sendText(homepage.userid, Username);
		CommanMethods.sendText(homepage.password, Password);
		CommanMethods.click(homepage.Login);
		// Login Validatioan
		String actResuelt = driver.findElement(By.xpath("//div/h1")).getText();
		String expResult = "Dashboard";// Text in under Dashboard tab
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResuelt, expResult);
		softassert.assertAll();
	}

}
