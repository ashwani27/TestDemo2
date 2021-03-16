package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;

public class ProductDetailPage extends BasePage {
	
	@FindBy(xpath = "//span[@id = 'our_price_display']")
	private WebElement labelDisplayedPrice;
	
	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getDisplayedPrice() {
		return labelDisplayedPrice.getText().trim();
	}
}
