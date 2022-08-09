package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class DashBoard {

	WebDriver driver;

	@FindBy(linkText = "Dashboard")
	public WebElement dashboardhyperlink;

	@FindBy(linkText = "Assign Leave")
	public WebElement assignleavelink;

	@FindBy(linkText = "Timesheets")
	public WebElement leavelist;

	@FindBy(linkText = "Apply Leave")
	public WebElement timesheets;

	@FindBy(linkText = "My Leave")
	public WebElement applyleave;

	@FindBy(linkText = "My Timesheet")
	public WebElement myleave;

	public DashBoard() {
		PageFactory.initElements(Base.driver, this);
	}
}
