package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.WorkShift;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ExtendReport;

public class WorkShiftTest extends Base {
	@BeforeMethod
	public void login() {
		HRMloginTest login = new HRMloginTest();
		login.loginHRMAdmin("Admin", "admin123");
	}

	@Test(dataProviderClass = StaticDataProvider.class, dataProvider = "Workshift_Data")
	public void addWorkShift(String ShiftName, String EmployeeName) throws InterruptedException {
		ExtendReport.extendTest = ExtendReport.extentReports.createTest("Add Work Shift");

		WorkShift workshift = new WorkShift();

		Thread.sleep(5000);
		CommanMethods.click(workshift.admin);
		CommanMethods.click(workshift.job);
		Thread.sleep(5000);
		CommanMethods.click(workshift.workshift);
		CommanMethods.click(workshift.addbtn);
		CommanMethods.sendText(workshift.shiftname, ShiftName);
		//CommanMethods.selectValueByVisibleText(workshift.fromworkhours, "15:45");

		CommanMethods.selectValueByVisibleText(workshift.toworkhours, "23:45");
		CommanMethods.selectValueByVisibleText(workshift.avilableemployee, EmployeeName);
		CommanMethods.click(workshift.addemp);
		CommanMethods.click(workshift.savebtn);

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
