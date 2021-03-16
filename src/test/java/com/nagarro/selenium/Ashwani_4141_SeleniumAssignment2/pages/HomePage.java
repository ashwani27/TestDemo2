package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(xpath = "//div[@class = 'header_user_info']/a")
	private WebElement linkSignIn;
	
	@FindBy(xpath = "//a[@class = 'logout']")
	private WebElement linkSignOut;
	
	@FindBy(xpath = "//input[@name = 'search_query']")
	private WebElement textfieldSearch;
	
	@FindBy(xpath = "//button[@name = 'submit_search']")
	private WebElement buttonSubmitSearch;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToLoginPage() {
		linkSignIn.click();
	}
	
	public String getSignOutLinkText() {
		return linkSignOut.getText().trim();
	}
	
	public void setSearchTextfield(String search) {
		textfieldSearch.sendKeys(search);
		buttonSubmitSearch.click();
	}
}
