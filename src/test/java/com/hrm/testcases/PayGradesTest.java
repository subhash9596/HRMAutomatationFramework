package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.PayGrades;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ExtendReport;

public class PayGradesTest extends Base {

	@BeforeMethod
	public void login() {
		HRMloginTest login = new HRMloginTest();
		login.loginHRMAdmin("Admin", "admin123");
	}

	@Test(dataProviderClass = StaticDataProvider.class, dataProvider = "PayGrade_Data")
	public void addPayGrades(String Name) throws InterruptedException {
		ExtendReport.extendTest = ExtendReport.extentReports.createTest("Add Pay Grades");

		PayGrades paygrades = new PayGrades();
		Thread.sleep(5000);
		CommanMethods.click(paygrades.admin);
		CommanMethods.click(paygrades.job);
		Thread.sleep(5000);
		CommanMethods.click(paygrades.paygrades);
		CommanMethods.click(paygrades.addbtn);
		CommanMethods.sendText(paygrades.name, Name);
		CommanMethods.click(paygrades.savebtn);

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
