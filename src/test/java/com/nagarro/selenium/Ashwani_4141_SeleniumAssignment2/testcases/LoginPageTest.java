package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages.ForgotPasswordPage;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages.HomePage;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages.LoginPage;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities.ExcelFileReader;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends BasePage{
	
	@Test(dataProvider = "LoginDetailsProvider", priority = 3)
	public void loginUsingValidEmailAndPassword(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
				
		homePage.navigateToLoginPage();
		test.log(LogStatus.INFO, "Navigate to the Login screen");
		test.log(LogStatus.INFO, "Try to Login into application");
		loginPage.login(username, password);		
		
		Assert.assertEquals(homePage.getSignOutLinkText(), ExpectedResults.get("LoginPageTest_loginUsingValidEmailAndPassword_Expected_1"));		
	}
	
	@Test(dataProvider = "LoginDetailsProvider", priority = 2)
	public void loginUsingInvalidEmailAndPassword(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		
		homePage.navigateToLoginPage();
		test.log(LogStatus.INFO, "Navigate to the Login screen");
		test.log(LogStatus.INFO, "Try to Login into application");
		loginPage.login(username, password);
		
		Assert.assertEquals(loginPage.getAuthFailedText(), ExpectedResults.get("LoginPageTest_loginUsingInvalidEmailAndPassword_Expected_1"));		
	}
	
	@Test(priority = 1)
	public void navigateToForgotPasswordPage() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(); 
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();		
		
		homePage.navigateToLoginPage();
		test.log(LogStatus.INFO, "Navigate to the Login screen");
		softAssert.assertEquals(loginPage.getForgotPasswordLinkText(), ExpectedResults.get("LoginPageTest_navigateToForgotPasswordPage_Expected_1").toUpperCase());
		loginPage.navigateToForgotPasswordPage();
		test.log(LogStatus.INFO, "Navigate to the Forgot Password screen");
		
		softAssert.assertEquals(forgotPasswordPage.getForgotPasswordHeadingText(), ExpectedResults.get("LoginPageTest_navigateToForgotPasswordPage_Expected_2").toUpperCase());
		softAssert.assertAll();
	}
	
	@DataProvider(name = "LoginDetailsProvider")
	public Object[][] getLoginData(Method testcase) throws IOException {
		Object[][] resultSet = null;
		HashMap<String, String> temp = null;
		
		switch(testcase.getName()) {
		case "loginUsingValidEmailAndPassword":
			temp =  ExcelFileReader.getDataFromExcel("LoginDetails");
			break;
		case "loginUsingInvalidEmailAndPassword":
			temp =  ExcelFileReader.getDataFromExcel("InvalidLoginDetails");
			break;
		}
		
		resultSet = new String[temp.size()][2];
		Set entries = temp.entrySet();
		Iterator entriesIterator = entries.iterator();
		
		int i = 0;
		while(entriesIterator.hasNext()) {
			Map.Entry mapping = (Map.Entry) entriesIterator.next();
			resultSet[i][0] = mapping.getKey().toString();
			resultSet[i][1] = mapping.getValue().toString();
		    i++;
		}
		
		return resultSet;		
	}
}
