package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class WorkShift {

	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Job")
	public WebElement job;
	@FindBy(linkText = "Work Shifts")
	public WebElement workshift;

	// Text
	@FindBy(xpath = "//input[@id='workShift_name']")
	public WebElement shiftname;
	@FindBy(xpath = "//select[@id='workShift_workHours_from']")
	public WebElement fromworkhours;
	@FindBy(xpath = "//select[@id='workShift_workHours_to']")
	public WebElement toworkhours;
	@FindBy(xpath = "//select[@id='workShift_availableEmp']")
	public WebElement avilableemployee;
	@FindBy(xpath = "//a[@id='btnAssignEmployee']")
	public WebElement addemp;
	@FindBy(xpath = "//a[@id='btnRemoveEmployee']")
	public WebElement removeemp;

	// Buttons
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addbtn;
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement deletebtn;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbtn;

	public WorkShift() {
		PageFactory.initElements(Base.driver, this);
	}

}
