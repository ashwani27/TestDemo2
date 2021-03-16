package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(xpath = "//input[@id = 'email']")
	private WebElement textfieldEmail;
	
	@FindBy(xpath = "//input[@id = 'passwd']")
	private WebElement textfieldPassword;
	
	@FindBy(xpath = "//button[@id = 'SubmitLogin']")
	private WebElement buttonSubmitLogin;
	
	@FindBy(xpath = "//div[@class = 'alert alert-danger']/ol/li")
	private WebElement labelAuthFailed;
	
	@FindBy(xpath = "//p[contains(@class ,'lost_password')]/a")
	private WebElement linkForgotPassword;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		textfieldEmail.sendKeys(username);
		textfieldPassword.sendKeys(password);
		buttonSubmitLogin.click();
	}
	
	public void navigateToForgotPasswordPage() {
		linkForgotPassword.click();
	}
	
	public String getAuthFailedText() {
		return labelAuthFailed.getText();
	}
	
	public String getForgotPasswordLinkText() {
		return linkForgotPassword.getText();
	}
}
