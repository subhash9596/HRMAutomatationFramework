package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class Skills {

	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Qualifications")
	public WebElement qualifications;
	@FindBy(linkText = "Skills")
	public WebElement skills;

	// Text
	@FindBy(xpath = "//input[@id='skill_name']")
	public WebElement name;
	@FindBy(xpath = "//textarea[@id='skill_description']")
	public WebElement description;

	// Buttons
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addbtn;
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement deletebtn;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbtn;

	public Skills() {
		PageFactory.initElements(Base.driver, this);
	}

}
