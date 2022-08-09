package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class JobTitles {

	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Job")
	public WebElement job;
	@FindBy(linkText = "Job Titles")
	public WebElement jobtitles;

	// Text
	@FindBy(xpath = "//input[@id='jobTitle_jobTitle']")
	public WebElement jobtitle;
	@FindBy(xpath = "//textarea[@id='jobTitle_jobDescription']")
	public WebElement jobdescription;
	@FindBy(xpath = "//textarea[@id='jobTitle_note']")
	public WebElement note;

	// Buttons
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addbtn;
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement deletebtn;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbtn;

	public JobTitles() {
		PageFactory.initElements(Base.driver, this);
	}
}
