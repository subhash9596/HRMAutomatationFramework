package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class Modules {

	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Configuration")
	public WebElement configuration;
	@FindBy(linkText = "Modules")
	public WebElement modules;
	// Text
	@FindBy(xpath = "//input[@id='moduleConfig_leave']")
	public WebElement enableleavemodule;
	@FindBy(xpath = "//input[@id='moduleConfig_time']")
	public WebElement enabletimemodule;
	@FindBy(xpath = "//select[@id='moduleConfig_recruitment']")
	public WebElement enablerecruitmentmodule;
	@FindBy(xpath = "//input[@id='moduleConfig_performance']")
	public WebElement enableperformancemodule;
	@FindBy(xpath = "//input[@id='moduleConfig_directory']")
	public WebElement enabledirectorymodule;
	@FindBy(xpath = "//input[@id='moduleConfig_maintenance']")
	public WebElement enablemaintenancemodule;
	@FindBy(xpath = "//input[@id='moduleConfig_mobile']")
	public WebElement enablemobile;
	// Buttons

	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebeditbtn;

	public Modules() {
		PageFactory.initElements(Base.driver, this);
	}

}
