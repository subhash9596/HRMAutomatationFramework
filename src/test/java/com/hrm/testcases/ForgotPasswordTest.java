package com.hrm.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.baseclass.Base;
import com.hrm.dataProvider.StaticDataProvider;
import com.hrm.pages.ForGotPassword;
import com.hrm.pages.HomePage;
import com.hrm.utilities.CommanMethods;
import com.hrm.utilities.ExtendReport;

public class ForgotPasswordTest extends Base {

	@Test(dataProviderClass = StaticDataProvider.class, dataProvider = "Forgot_Password")
	public void passWordRest(String OrangeHRMUsername) {
		ExtendReport.extendTest = ExtendReport.extentReports.createTest("This is the Forgot Psswrod test");
		HomePage homepage = new HomePage();
		ForGotPassword forgotpassword = new ForGotPassword();
		// Click on Forgot Password Link
		CommanMethods.click(homepage.forgotpasswordlink);
		// Enter Username
		CommanMethods.sendText(forgotpassword.orangehrmusername, OrangeHRMUsername);
		// Click on ResetPassword button
		CommanMethods.click(forgotpassword.resetpassword);
		// Get Text
		String actResuelt = forgotpassword.sucesmessage.getText();
		String expResult = "Please contact HR admin in order to reset the password";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResuelt, expResult);
		softassert.assertAll();
	}

}
