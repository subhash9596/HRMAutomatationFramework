package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.baseclass.Base;

public class GeneralInforamtion {
	WebDriver driver;

	// Navigation
	@FindBy(linkText = "Admin")
	public WebElement admin;
	@FindBy(linkText = "Organization")
	public WebElement organization;
	@FindBy(linkText = "General Information")
	public WebElement generalinforamtion;

	// Text
	@FindBy(xpath = "//input[@id='organization_name']")
	public WebElement organizationname;
	@FindBy(xpath = "//input[@id='organization_taxId']")
	public WebElement taxid;
	@FindBy(xpath = "//input[@id='organization_phone']")
	public WebElement phone;
	@FindBy(xpath = "//input[@id='organization_email']")
	public WebElement email;
	@FindBy(xpath = "//input[@id='organization_street1']")
	public WebElement street1;
	@FindBy(xpath = "//input[@id='organization_city']")
	public WebElement city;
	@FindBy(xpath = "//input[@id='organization_zipCode']")
	public WebElement zippostcode;
	@FindBy(xpath = "//textarea[@id='organization_note']")
	public WebElement note;
	@FindBy(xpath = "//input[@id='organization_registraionNumber']")
	public WebElement resigtrationnumber;
	@FindBy(xpath = "//input[@id='organization_fax']")
	public WebElement fax;
	@FindBy(xpath = "//input[@id='organization_street2']")
	public WebElement street2;
	@FindBy(xpath = "//input[@id='organization_province']")
	public WebElement state;
	@FindBy(xpath = "//select[@id='organization_country']")
	public WebElement country;
	// Buttons
	@FindBy(xpath = "//input[@id='btnSaveGenInfo']")
	public WebElement editandsavebtn;

	public GeneralInforamtion() {
		PageFactory.initElements(Base.driver, this);
	}

}
