package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class Memberships {
	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Qualifications")
	public WebElement qualifications;
	@FindBy(linkText = "Languages")
	public WebElement languages;

	// Text
	@FindBy(xpath = "//input[@id='membership_name']")
	public WebElement name;

	// Buttons
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addbtn;
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement deletebtn;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbtn;

	public Memberships() {
		PageFactory.initElements(Base.driver, this);
	}

}
