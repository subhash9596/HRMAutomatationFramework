package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class Localization {
	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Configuration")
	public WebElement configuration;
	@FindBy(linkText = "Localization")
	public WebElement localization;

	// Text
	@FindBy(xpath = "//select[@id='localization_dafault_language']")
	public WebElement language;
	@FindBy(xpath = "//input[@id='localization_use_browser_language']")
	public WebElement usebrowserlanguageifset;
	@FindBy(xpath = "//select[@id='localization_default_date_format']")
	public WebElement dateforamt;

	// Buttons
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement saveeditbtn;

	public Localization() {
		PageFactory.initElements(Base.driver, this);
	}

}
