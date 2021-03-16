package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages.HomePage;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages.ProductDetailPage;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.pages.SearchPage;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities.ExcelFileReader;
import com.relevantcodes.extentreports.LogStatus;

public class SearchPageTest extends BasePage{
	
	@Test(dataProvider = "searchADress")
	public void searchADress(String search) {		
		SoftAssert softAssert = new SoftAssert();
		SearchPage searchPage = new SearchPage();
		HomePage homePage = new HomePage();
		
		homePage.setSearchTextfield(search);
		test.log(LogStatus.INFO, "Searching products");
		softAssert.assertEquals(searchPage.getSearchHeaderLabelText(), ExpectedResults.get("SearchPageTest_searchADress_Expected_1"));
		
		for(int i = 0; i < searchPage.getSearchResultsText().size(); i++) {
			softAssert.assertEquals(searchPage.getSearchResultsText().get(i), ExpectedResults.get("SearchPageTest_searchADress_Expected_2"));
		softAssert.assertAll();
		}
	}
	
	@Test(dataProvider = "searchADress")
	public void validateProductPrize(String search) {
		ProductDetailPage productDetailPage = new ProductDetailPage();
		SoftAssert softAssert = new SoftAssert();
		SearchPage searchPage = new SearchPage();
		HomePage homePage = new HomePage();
		
		homePage.setSearchTextfield(search);
		test.log(LogStatus.INFO, "Searching products");
		softAssert.assertEquals(searchPage.getSearchHeaderLabelText(), ExpectedResults.get("SearchPageTest_validateProductPrize_Expected_1"));
				
		String expectedPrice = searchPage.getPriceTag();
		test.log(LogStatus.INFO, "Verifying product pricing on display with inside product details");
		searchPage.navigateToProductDetailPage();
		test.log(LogStatus.INFO, "Navigate to product details screen");
		
		softAssert.assertEquals(productDetailPage.getDisplayedPrice(), expectedPrice);
		softAssert.assertAll();
	}
	
	@DataProvider(name = "searchADress")
	public Object[] getSearchData(Method testcase) throws IOException {
		String result = null;
		
		switch(testcase.getName()) {
		case "searchADress":
			result =  ExcelFileReader.getDataFromExcel("SearchData", "searchADress");
			break;
		case "validateProductPrize":
			result =  ExcelFileReader.getDataFromExcel("SearchData", "validateProductPrize");
			break;
		}
		List<String> temp = new ArrayList<String>();
		temp.add(result);
		return temp.toArray();
	}
}
