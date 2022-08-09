package com.hrm.dataProvider;

import org.testng.annotations.DataProvider;

import com.hrm.baseclass.Base;
import com.hrm.utilities.ExcelUtility;

public class StaticDataProvider extends Base {

	static String excle_path = "Testdata/TestData.xlsx";

	@DataProvider(name = "Login_Data")
	public Object[][] getloginTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "Login");
	}

	@DataProvider(name = "Forgot_Password")
	public Object[][] getforgotPasswordTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "ForGotPassword");
	}

	@DataProvider(name = "Adduser_Data")
	public Object[][] getAddUserTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "AddUser");
	}

	@DataProvider(name = "Searchuser_Data")
	public Object[][] getTestDataSearch() {
		return ExcelUtility.excelIntoArray(excle_path, "SearchUser");
	}

	@DataProvider(name = "EmpStatus_Data")
	public Object[][] getEmpStatusTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "EmpStatus");
	}

	@DataProvider(name = "JobCategory_Data")
	public Object[][] getJobCategoryTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "JobCategory");
	}

	@DataProvider(name = "JobTitle_Data")
	public Object[][] getJobTitleTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "JobTitles");
	}

	@DataProvider(name = "PayGrade_Data")
	public Object[][] getPayGradeTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "PayGrade");
	}

	@DataProvider(name = "Workshift_Data")
	public Object[][] getTestData() {
		return ExcelUtility.excelIntoArray(excle_path, "WorkShift");
	}

}
