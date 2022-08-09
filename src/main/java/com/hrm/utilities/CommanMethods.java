package com.hrm.utilities;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommanMethods {
	
public static WebDriver driver;
	
	/**
	 * Method that clears and sends keys
	 * 
	 * @param element
	 * @param value
	 */
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public static void click(WebElement element) {
		element.click();
    }
	public static void getText(WebElement element) {
		element.getText();
	}
	
	/**
	 * All method from select class
	 */
	//Select value from visible text
	public static void selectValueByVisibleText(WebElement wb, String value) {
		new Select(wb).selectByVisibleText(value);
	}
	//Select value from index
	public static void selectValueByIndex(WebElement wb, int index) {
		new Select(wb).selectByIndex(index);
	}
	//Select by value by value
	public static void selectByValueByValue(WebElement wb, String value) {
		new Select(wb).selectByValue(value);
	}
	//get selected value
	public static String getSelectedValue(WebElement wb) {
		return new Select(wb).getFirstSelectedOption().getText();
	}
	//Print all value
	public static void printAllValue(WebElement wb) {
		List<WebElement> ls = new Select(wb).getOptions();

		for (WebElement abc : ls) {
			System.out.println(abc.getText());
		}
	}
	//count totalDP list
	public static int countTotalDPList(WebElement wb) {
		return new Select(wb).getOptions().size();

	}

	public static void checkSpecificValuePresent(WebElement wb, String value) {
		List<WebElement> ls = new Select(wb).getOptions();

		for (WebElement abc : ls) {
			if (abc.getText().contains(value)) {
				System.out.println("Value is Present " + abc.getText());
			}
		}
	}
	/**
	 * Alert Method
	 */
	
	    // it will click on Ok Button
		public static void clickOnOkButton() {
			driver.switchTo().alert().accept();
		}

		// it will click on Cancel Button
		public static void clickOnCancel() {
			driver.switchTo().alert().dismiss();
		}

		// it will enter data on alert Box
		public static void enterData(String value) {
			driver.switchTo().alert().sendKeys(value);
		}

		// it will capture alert text
		public static String captureText() {
			return driver.switchTo().alert().getText();
		}
		
		/**
		 * All methods from actions class
		 * 
		 * 
		 */
		public static void clickOnElement(WebElement wb) {
			new Actions(driver).click(wb).build().perform();
		}

		public static void doubleClickOnElement(WebElement wb) {
			new Actions(driver).doubleClick(wb).build().perform();
		}

		public static void rightClickOnElement(WebElement wb) {
			new Actions(driver).contextClick(wb).build().perform();
		}

		public static void dragAndDrop(WebElement src, WebElement trg) {

			new Actions(driver).dragAndDrop(src, trg).build().perform();
		}

		public static void mouseOver(WebElement wb) {
			new Actions(driver).moveToElement(wb).build().perform();
		}

		public static void clickOnHold(WebElement wb) {
			new Actions(driver).clickAndHold(wb).build().perform();
		}

		public static void releaseElement(WebElement wb) {
			new Actions(driver).release(wb).build().perform();
		}

		public static void enterCapitalData(WebElement wb, String value) {
			new Actions(driver).keyDown(Keys.SHIFT).sendKeys(wb, value).build().perform();
		}

		public static void moveEndOfPage() {
			new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		}

		public static void moveHomePage() {
			new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
		}


		
	/**
	 * Frame Methods 
	 */
		// switch to child frame by using frame nameorid
		public static WebDriver switchToChildFrameUsingName(String nameid) {
			return driver.switchTo().frame(nameid);
		}

		// switch to child frame by using frame index
		public static WebDriver switchToChildFrameUsingIndex(int index) {
			return driver.switchTo().frame(index);
		}

		// switch to child frame by using frame index
		public static WebDriver switchToChildFrameUsingWebElement(WebElement wb) {
			return driver.switchTo().frame(wb);
		}

		// switch to parent frame
		public static WebDriver switchToParentFrame() {
			return driver.switchTo().parentFrame();
		}

		// switch to top frame
		public static WebDriver switchToTopFrame() {
			return driver.switchTo().defaultContent();
		}
		/**
		 * JAVA SCRIPT 
		 * open a browser,click, sendKeys,title, url , scroll down up to element,
	       alert , border , change bg color DIT, SIT, UAT,Pre Production, post Production
		 */
		public static void openBrowser(String url) {
			((JavascriptExecutor) driver).executeScript("window.location='" + url + "';");
		}

		public static void clickOnElementById(WebElement wb, String id) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('" + id + "').click();", wb);
		}

		public static void clickonElement(WebElement wb) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wb);
		}

		public static void sendDataToTextBox(WebElement wb, String value) {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", wb);
		}

		public static String getTitle() {
			return ((JavascriptExecutor) driver).executeScript("return document.title").toString();
		}

		public static String getUrl() {
			return ((JavascriptExecutor) driver).executeScript("return document.URL").toString();
		}

		public static void scrollUptoElement(WebElement wb) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wb);
		}

		public static void borderOnElement(WebElement wb) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red';", wb);
		}

		public static void flashElement(WebElement wb, String color) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + color + "'", wb);
		}

		public static void generatePopUp(String value) {

			((JavascriptExecutor) driver).executeScript("alert('" + value + "')");
		}

		public static void refreshBrowser() {
			((JavascriptExecutor) driver).executeScript("history.go(0)");
		}

		public static void forwardBrowser() {
			((JavascriptExecutor) driver).executeScript("history.go(1)");
		}

		public static void backBrowser() {
			((JavascriptExecutor) driver).executeScript("history.go(-1)");
		}

		

}