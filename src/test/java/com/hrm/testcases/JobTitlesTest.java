package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.AdminUserManagement;
import com.hrm.pages.JobTitles;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ExcelUtility;

public class JobTitlesTest extends Base {

	@BeforeMethod
	public void login() {
		HRMloginTest login = new HRMloginTest();
		login.loginHRMAdmin("Admin", "admin123");
	}

	@Test(dataProviderClass = StaticDataProvider.class, dataProvider = "JobTitle_Data")
	public void addJobTitles(String Jobtitle, String JobDescription, String Note) throws InterruptedException {

		JobTitles jobtitles = new JobTitles();
		Thread.sleep(5000);
		CommanMethods.click(jobtitles.admin);
		CommanMethods.click(jobtitles.job);
		Thread.sleep(5000);
		CommanMethods.click(jobtitles.jobtitles);
		CommanMethods.click(jobtitles.addbtn);

		CommanMethods.sendText(jobtitles.jobtitle, Jobtitle);
		CommanMethods.sendText(jobtitles.jobdescription, JobDescription);
		CommanMethods.sendText(jobtitles.note, Note);
		CommanMethods.click(jobtitles.savebtn);

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
