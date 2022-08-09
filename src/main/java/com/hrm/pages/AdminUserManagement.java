package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;

public class AdminUserManagement {

	WebDriver driver;
	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "User Management")
	public WebElement usermanagement;
	@FindBy(linkText = "Users")
	public WebElement users;

	// Add User
	@FindBy(xpath = "//select[@id='systemUser_userType']")
	public WebElement userrole;
	@FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
	public WebElement employeename;
	@FindBy(xpath = "//input[@id='systemUser_userName']")
	public WebElement username;
	@FindBy(xpath = "//select[@id='systemUser_status']")
	public WebElement satus;
	@FindBy(xpath = "//input[@id='systemUser_password']")
	public WebElement password;
	@FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
	public WebElement conformpassword;

	// Search Users
	@FindBy(xpath = "//input[@id='searchSystemUser_userName']")
	public WebElement usernaemsearch;
	@FindBy(xpath = "//select[@id='searchSystemUser_userType']")
	public WebElement userrolessearch;
	@FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
	public WebElement employeenamesearch;
	@FindBy(xpath = "//select[@id='searchSystemUser_status']")
	public WebElement statussearch;
	// buttons
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addbutton;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebutton;
	@FindBy(xpath = "//input[@id='searchBtn']")
	public WebElement searchbutton;
	@FindBy(xpath = "//input[@id='resetBtn']")
	public WebElement resetbutton;
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement deletebutton;

	public AdminUserManagement() {
		PageFactory.initElements(Base.driver, this);
	}

}