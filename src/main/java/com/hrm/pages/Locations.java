package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class Locations {
	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Organization")
	public WebElement organization;
	@FindBy(linkText = "Locations")
	public WebElement locations;

	// Text
	@FindBy(xpath = "//input[@id='location_name']")
	public WebElement name;
	@FindBy(xpath = "//select[@id='location_country']")
	public WebElement country;
	@FindBy(xpath = "//input[@id='location_province']")
	public WebElement state;
	@FindBy(xpath = "//input[@id='location_city']")
	public WebElement city;
	@FindBy(xpath = "//textarea[@id='location_address']")
	public WebElement address;
	@FindBy(xpath = "//input[@id='location_zipCode']")
	public WebElement zippostalcode;
	@FindBy(xpath = "//input[@id='location_phone']")
	public WebElement phone;
	@FindBy(xpath = "//input[@id='location_fax']")
	public WebElement fax;
	@FindBy(xpath = "//textarea[@id='location_notes']")
	public WebElement notes;

	// Buttons
	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addbtn;
	@FindBy(xpath = "//input[@id='btnDelete']")
	public WebElement deletebtn;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement savebtn;
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement cancelbtn;
	@FindBy(xpath = "//input[@id='btnSearch']")
	public WebElement searchbtn;
	@FindBy(xpath = "//input[@id='btnReset']")
	public WebElement resetbtn;

	public Locations() {
		PageFactory.initElements(Base.driver, this);
	}

}
