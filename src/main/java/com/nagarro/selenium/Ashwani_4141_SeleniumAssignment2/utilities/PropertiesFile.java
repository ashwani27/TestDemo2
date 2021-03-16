package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	private Properties prop = null;
	private File file = null;
	private FileInputStream fis = null;

	public PropertiesFile() {
		{
			file = new File(System.getProperty("user.dir") + "\\Resources\\config.properties");
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
