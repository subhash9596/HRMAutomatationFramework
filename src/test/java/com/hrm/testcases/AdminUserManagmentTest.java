package com.hrm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.AdminUserManagement;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ConfigReader;
import com.hrm.utilities.ExtendReport;

public class AdminUserManagmentTest extends Base {
	@BeforeMethod
	public void login() {
		HRMloginTest login = new HRMloginTest();
		login.loginHRMAdmin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	}

	@Test(dataProviderClass = StaticDataProvider.class, dataProvider = "Adduser_Data")
	public void addUserInformation(String UserRole, String EmployeeName, String Username, String Status,
			String Password, String ConfirmPassword) throws InterruptedException {
		ExtendReport.extendTest = ExtendReport.extentReports.createTest("Add User Information");
		AdminUserManagement adminusermanagment = new AdminUserManagement();
		// MouseOver the admin link
		Thread.sleep(5000);
		CommanMethods.click(adminusermanagment.admin);
		// User Management
		CommanMethods.click(adminusermanagment.usermanagement);
		// Click on Add User
		Thread.sleep(5000);
		CommanMethods.click(adminusermanagment.users);
		// click on Add button
		CommanMethods.click(adminusermanagment.addbutton);
		// Select role from dropdown
		CommanMethods.selectValueByVisibleText(adminusermanagment.userrole, UserRole);
		// Enter Employee Name
		CommanMethods.sendText(adminusermanagment.employeename, EmployeeName);
		// Enter username
		CommanMethods.sendText(adminusermanagment.username, Username);
		// Select status
		Thread.sleep(3000);
		CommanMethods.selectValueByVisibleText(adminusermanagment.satus, Status);
		// Enter Password
		CommanMethods.sendText(adminusermanagment.password, Password);
		// Enter conform password
		CommanMethods.sendText(adminusermanagment.conformpassword, ConfirmPassword);
		// Click on save button
		Thread.sleep(2000);
		CommanMethods.click(adminusermanagment.savebutton);

		String actResult = driver
				.findElement(
						By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]"))
				.getText();
		String expResult = "Successfully Saved";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actResult, expResult);
	}

	@Test(dataProviderClass = StaticDataProvider.class, dataProvider = "Searchuser_Data")
	public void searchSystemUser(String SearchUsername) throws InterruptedException {
		ExtendReport.extendTest = ExtendReport.extentReports.createTest("Search User Inforamtion");
		AdminUserManagement adminusermanagment = new AdminUserManagement();
		Thread.sleep(5000);
		CommanMethods.click(adminusermanagment.admin);
		CommanMethods.click(adminusermanagment.usermanagement);
		Thread.sleep(5000);
		CommanMethods.click(adminusermanagment.users);
		CommanMethods.sendText(adminusermanagment.usernaemsearch,SearchUsername);
		CommanMethods.click(adminusermanagment.searchbutton);
	}

}
