package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class RegisterOAuthClient {

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Configuration")
	public WebElement configuration;
	@FindBy(linkText = "Register OAuth Client")
	public WebElement registerouthclient;

	// Text
	@FindBy(xpath = "//input[@id='oauth_client_id']")
	public WebElement id;
	@FindBy(xpath = "//input[@id='oauth_client_secret']")
	public WebElement secret;
	@FindBy(xpath = "//input[@id='oauth_redirect_uri']")
	public WebElement redirecturl;

	// Buttons
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement deletebtn;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbtn;

	public RegisterOAuthClient() {
		PageFactory.initElements(Base.driver, this);
	}

}
