package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class EmailSubscriptions {
	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Configuration")
	public WebElement configuration;
	@FindBy(linkText = "Email Subscriptions")
	public WebElement emailsubscriptions;

	// Text
	@FindBy(xpath = "//input[@id='ohrmList_chkSelectRecord_1']")
	public WebElement leaveapplications;
	@FindBy(xpath = "//input[@id='ohrmList_chkSelectRecord_2']")
	public WebElement leaveassignments;
	@FindBy(xpath = "//input[@id='ohrmList_chkSelectRecord_3']")
	public WebElement leaveapproval;
	@FindBy(xpath = "//input[@id='ohrmList_chkSelectRecord_4']")
	public WebElement leavecancelation;
	@FindBy(xpath = "//input[@id='ohrmList_chkSelectRecord_5']")
	public WebElement leaverejections;

	// Buttons
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnEdit']")
	public WebElement editbtn;

	public EmailSubscriptions() {
		PageFactory.initElements(Base.driver, this);
	}
}
