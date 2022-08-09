package com.hrm.testcases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.baseclass.Base;
import com.hrm.pages.DashBoard;
import com.hrm.utilities.CommanMethods;

public class DashboardTest extends Base {
	
	@BeforeMethod
	public void beforeClass() {
		HRMloginTest login = new HRMloginTest();
		login.loginHRMAdmin("Admin", "admin123");
		
	}
	@Test
	public void AssignLeavsLink() {
		DashBoard dashboard = new DashBoard();
		CommanMethods.click(dashboard.assignleavelink);
		
	}
	@Test
	public void LeaveList() {
		DashBoard dashboard = new DashBoard();
		CommanMethods.click(dashboard.leavelist);
		
	}
}
