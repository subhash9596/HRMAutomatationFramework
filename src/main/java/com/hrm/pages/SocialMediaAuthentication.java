package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class SocialMediaAuthentication {

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Configuration")
	public WebElement configuration;
	@FindBy(linkText = "Social Media Authentication")
	public WebElement socialmediaauthentication;
	// Text
	@FindBy(xpath = "//select[@id='openIdProvider_type']")
	public WebElement type;
	@FindBy(xpath = "//input[@id='openIdProvider_name']")
	public WebElement name;
	@FindBy(xpath = "//input[@id='openIdProvider_url']")
	public WebElement redirecturl;
	@FindBy(xpath = "//input[@id='openIdProvider_clientId']")
	public WebElement clientid;
	@FindBy(xpath = "//input[@id='openIdProvider_clientSecret']")
	public WebElement clientsecret;
	@FindBy(xpath = "//input[@id='openIdProvider_developerKey']")
	public WebElement developerkey;
	@FindBy(xpath = "//input[@id='moduleConfig_mobile']")
	public WebElement enablemobile;
	// Buttons
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addbtn;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement deletebtn;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbtn;

	public SocialMediaAuthentication() {
		PageFactory.initElements(Base.driver, this);
	}

}
