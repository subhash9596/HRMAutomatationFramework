package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.EmploymentStatus;
import com.hrm.pages.PayGrades;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ExcelUtility;

public class EmploymentStatusTest extends Base {

	@BeforeMethod
	public void login() {
		HRMloginTest login = new HRMloginTest();
		login.loginHRMAdmin("Admin", "admin123");
	}

	@Test(dataProviderClass = StaticDataProvider.class, dataProvider = "EmpStatus_Data")
	public void addEmploymentStatus(String EmploymetStatus) throws InterruptedException {
		EmploymentStatus employmentstatus = new EmploymentStatus();
		Thread.sleep(5000);
		CommanMethods.click(employmentstatus.admin);
		CommanMethods.click(employmentstatus.job);
		Thread.sleep(5000);
		CommanMethods.click(employmentstatus.employmentstatus);
		CommanMethods.click(employmentstatus.addbtn);
		CommanMethods.sendText(employmentstatus.name, EmploymetStatus);
		CommanMethods.click(employmentstatus.savebtn);

		String actResult = driver
				.findElement(
						By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]"))
				.getText();
		String expResult = "Successfully Saved";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actResult, expResult);
		System.out.println("Test CASE RUN SUCESSFULLY");
	}

}
