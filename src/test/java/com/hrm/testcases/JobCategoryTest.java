package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.JobCategory;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ExcelUtility;

public class JobCategoryTest extends Base {
	@BeforeMethod
	public void login() {
		HRMloginTest login = new HRMloginTest();
		login.loginHRMAdmin("Admin", "admin123");
	}

	@Test(dataProviderClass = StaticDataProvider.class, dataProvider = "JobCategory_Data")
	public void addJobCategory(String Name) throws InterruptedException {
		JobCategory jobcategory = new JobCategory();
		Thread.sleep(5000);
		CommanMethods.click(jobcategory.admin);
		CommanMethods.click(jobcategory.job);
		Thread.sleep(5000);
		CommanMethods.click(jobcategory.jobcategories);
		CommanMethods.click(jobcategory.addbtn);
		CommanMethods.sendText(jobcategory.name, Name);
		CommanMethods.click(jobcategory.savebtn);

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
