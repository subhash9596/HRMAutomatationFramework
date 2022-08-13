package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.HomePage;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ConfigReader;
import com.hrm.utilities.ExtendReport;

public class HRMloginTest extends Base {
	@Test(testName = "HRMLoginAdmin",groups = {"Regresssion"},dataProviderClass = StaticDataProvider.class, dataProvider = "Login_Data")
	public void loginHRMAdmin(String Username, String Password) {
		//ExtendReport.extendTest = ExtendReport.extentReports.createTest("HRM Admin Login");
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
