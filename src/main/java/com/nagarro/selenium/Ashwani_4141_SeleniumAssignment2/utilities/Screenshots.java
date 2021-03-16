package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.basepage.BasePage;

public class Screenshots extends BasePage {
	
	public static String takeScreenShot(String methodName, String error, WebDriver driver) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotFileName = System.getProperty("user.dir") + "\\screenshots\\";
		try {
			FileUtils.copyFile(scrFile, new File(screenshotFileName + methodName + "_" + error + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotFileName + methodName + "_" + error + ".jpg";
	}
}
