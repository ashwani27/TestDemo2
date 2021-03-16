package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities.ExcelFileReader;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities.ExtentManager;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities.PropertiesFile;
import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities.Screenshots;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriverWait wait = null;
	public static HashMap<String, String> ExpectedResults = null;
	
	private static PropertiesFile prop = new PropertiesFile();
	private static String resourcePath = System.getProperty("user.dir") + "\\Resources\\";
	
	@BeforeClass
	public static void initializeBrowser() throws IOException {

		switch (prop.getProperty("browser")) {
		case "chrome":	
			System.setProperty("webdriver.chrome.driver", resourcePath + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", resourcePath + "geckodriver.exe");
			driver= new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", resourcePath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;			
		}
		wait = new WebDriverWait(driver,30);
		ExpectedResults = ExcelFileReader.getDataFromExcel("ExpectedStrings");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("globalWaitTime")) , TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		extent = ExtentManager.getInstance("Reports\\ExtentReports.html");
	}

	@BeforeMethod
	public static void navigateToUrl(Method testcase) {
		// naviagting to application
		driver.get(prop.getProperty("applicationURL"));
		test = extent.startTest(testcase.getName());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS)
			test.log(LogStatus.PASS, "Test case got passed");
		else if(result.getStatus()==ITestResult.FAILURE) {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
			Date date = new Date();
			String foldername = dateFormat.format(date);
	    	String capturePath = Screenshots.takeScreenShot(result.getName().toString().trim(), foldername, driver);
	    	test.log(LogStatus.FAIL, result.getThrowable());
	    	test.log(LogStatus.FAIL, "Screenshot Below : " + test.addScreenCapture(capturePath));
		}			
		else if(result.getStatus()==ITestResult.SKIP)
			test.log(LogStatus.SKIP, result.getThrowable());
		
		extent.flush();		
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
