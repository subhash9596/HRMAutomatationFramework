package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class HomePage {
	WebDriver driver;

	// User Name
	@FindBy(name = "txtUsername")
	public WebElement userid;
	@FindBy(name = "txtPassword")
	public WebElement password;
	@FindBy(name = "Submit")
	public WebElement Login;
	// @FindBy(linkText="Admin")
	// WebElement adminTab;

	@FindBy(id = "spanMessage")
	public WebElement LoginFalureMessage;

	@FindBy(linkText = "Forgot your password?")
	public WebElement forgotpasswordlink;

	public HomePage() {
		PageFactory.initElements(Base.driver, this);
	}

}
