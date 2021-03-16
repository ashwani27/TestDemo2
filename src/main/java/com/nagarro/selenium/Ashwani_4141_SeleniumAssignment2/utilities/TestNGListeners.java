package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;

public class TestNGListeners extends BasePage implements ITestListener {

	@Override
	public void onStart(ITestContext arg0) {
		File sourceFile = new File(System.getProperty("user.dir") + "\\Reports\\ExtentReports.html");
		if(sourceFile.exists()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
			Date date = new Date();
			String foldername = "TestResults" + dateFormat.format(date);
			
			File dir = new File(System.getProperty("user.dir") + "\\ReportsArchive\\" + foldername);
			dir.mkdir();
			File destFile = new File(System.getProperty("user.dir") + "\\ReportsArchive\\" + foldername + "\\ExtentReports.html");
			 
			if (sourceFile.renameTo(destFile)) {
			    System.out.println("File moved successfully");
			} else {
			    System.out.println("Failed to move file");
			}
		}
	}
	
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
}
