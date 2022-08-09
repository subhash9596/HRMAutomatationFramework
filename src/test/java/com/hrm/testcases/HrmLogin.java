package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.hrm.baseclass.Base;
import com.hrm.pages.HomePage;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ConfigReader;
import com.hrm.utilities.ExcelUtility;

public class HrmLogin extends Base {

	@Test
	public void validAdminLogin() {

		HomePage homepage = new HomePage();
	//	driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		CommanMethods.sendText(homepage.userid, ConfigReader.getProperty("username"));
		CommanMethods.sendText(homepage.password, ConfigReader.getProperty("password"));
		//driver.findElement(By.name("Submit")).click();
		CommanMethods.click(homepage.Login);
		String actualTitle = driver.getTitle();
		System.out.println("Title of page" + actualTitle);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("OrangeHRM", actualTitle, "titles are not matching");
		sa.assertAll();

	}

	@Test
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

	@Test(dataProvider="userdatafromexcel")
	public void dataDrivenTest(String Username, String Password, String ErrorMessage) {

		HomePage homepage = new HomePage();
		CommanMethods.sendText(homepage.userid, Username);
		CommanMethods.sendText(homepage.password, Password);
		CommanMethods.click(homepage.Login);
		String actualerrormessage = homepage.LoginFalureMessage.getText();
		System.out.println(actualerrormessage);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ErrorMessage, actualerrormessage, "error message are not matching");
		sa.assertAll();

	}
  @DataProvider(name="userdatafromexcel")
  public Object[][] getTestData(){
	  return ExcelUtility.excelIntoArray("C:\\Users\\Admin\\Desktop\\TestData.xlsx", "Sheet1");
  }

}
