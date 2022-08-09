package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class EmailConfiguration {
	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Configuration")
	public WebElement configuration;
	@FindBy(linkText = "Email Configuration")
	public WebElement emailconfiguration;

	// Text
	@FindBy(xpath = "//input[@id='emailConfigurationForm_txtMailAddress']")
	public WebElement emailsendas;
	@FindBy(xpath = "//select[@id='emailConfigurationForm_cmbMailSendingMethod']")
	public WebElement sendingmethods;
	@FindBy(xpath = "//input[@id='emailConfigurationForm_chkSendTestEmail']")
	public WebElement sendtestemail;
	@FindBy(xpath = "//input[@id='emailConfigurationForm_txtTestEmail']")
	public WebElement sendtestemailaddress;

	// Buttons

	@FindBy(xpath = "//input[@id='editBtn']")
	public WebElement saveadneditbtn;
	@FindBy(xpath = "//input[@id='resetBtn']")
	public WebElement resetbtn;

	public EmailConfiguration() {
		PageFactory.initElements(Base.driver, this);
	}

}
