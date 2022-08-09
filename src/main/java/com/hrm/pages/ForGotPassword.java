package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class ForGotPassword {

	WebDriver driver;
	@FindBy(xpath = "//input[@id='securityAuthentication_userName']")
	public WebElement orangehrmusername;
	@FindBy(xpath = "//input[@id='btnSearchValues']")
	public WebElement resetpassword;
	@FindBy(xpath = "//*[contains(text(),'Please contact HR admin in order to reset the password')]")
	public WebElement sucesmessage;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbutton;

	public ForGotPassword() {
		PageFactory.initElements(Base.driver, this);
	}
}
