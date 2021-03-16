package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;

public class SearchPage extends BasePage {
	
	@FindBy(xpath = "//span[@class = 'lighter']")
	private WebElement labelSearchHeader;
	
	@FindBy(xpath = "//h5[@itemprop = 'name']/a[@class = 'product-name']")
	private List<WebElement> linkSearchResults;
		
	@FindBy(xpath = "//h5[@itemprop = 'name']/parent::div//span[@itemprop = 'price']")
	private List<WebElement> labelSearchResultPrice;
	
	@FindBy(xpath = "//p[contains(@class ,'lost_password')]/a")
	private WebElement linkForgotPassword;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchHeaderLabelText() {
		return labelSearchHeader.getText();
	}
	
	public List<String> getSearchResultsText() {
		List<String> resultSet = new ArrayList<String>();
		
		for(WebElement element : linkSearchResults) {
			resultSet.add(element.getText());
		}
		return resultSet;
	}
	
	public void navigateToProductDetailPage() {
		linkSearchResults.get(0).click();
	}
	
	public String getPriceTag() {
		return labelSearchResultPrice.get(0).getText().trim();
	}

}
