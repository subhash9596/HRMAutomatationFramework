package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class LanguagePackages {
	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Configuration")
	public WebElement configuration;
	@FindBy(linkText = "Language Packages")
	public WebElement languagepackages;

	// Text
	@FindBy(xpath = "//select[@id='addLanguagePackage_name']")
	public WebElement name;
	@FindBy(xpath = "//input[@id='localization_use_browser_language']")
	public WebElement usebrowserlanguageifset;
	@FindBy(xpath = "//select[@id='localization_default_date_format']")
	public WebElement dateforamt;

	// Buttons
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addbtn;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbtn;
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement resetbtn;

	public LanguagePackages() {
		PageFactory.initElements(Base.driver, this);
	}

}
