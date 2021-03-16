package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;

public class ForgotPasswordPage extends BasePage{

	@FindBy(xpath = "//h1[@class = 'page-subheading']")
	private WebElement labelForgotPassword;
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getForgotPasswordHeadingText() {
		return labelForgotPassword.getText().trim();
	}
}
