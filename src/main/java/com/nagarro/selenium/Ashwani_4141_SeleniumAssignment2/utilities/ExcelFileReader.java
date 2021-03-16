package com.nagarro.selenium.Ashwani_4141_SeleniumAssignment2.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFileReader {
	
	private static String excelResourcePath = System.getProperty("user.dir") + "\\Resources\\";
	
	@SuppressWarnings("resource")
	public static HashMap<String, String> getDataFromExcel(String sheetName) throws IOException {		
		HashMap<String, String> resultSet = new HashMap<String, String>();
		FileInputStream fis = new FileInputStream(excelResourcePath + "DataProvider.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		switch (sheetName) {
		case "LoginDetails":
			XSSFSheet sheet = workbook.getSheet(sheetName);
			for (int i = 1; i < 2; i++) {	
				resultSet.put(sheet.getRow(i).getCell(0).toString(), sheet.getRow(i).getCell(1).toString());
			}
			break;
		case "InvalidLoginDetails":
			XSSFSheet sheet2 = workbook.getSheet(sheetName);
			for (int i = 1; i < sheet2.getPhysicalNumberOfRows(); i++) {	
				resultSet.put(sheet2.getRow(i).getCell(0).toString(), sheet2.getRow(i).getCell(1).toString());
			}
			break;
		case "ExpectedStrings":
			XSSFSheet sheet3 = workbook.getSheet(sheetName);
			for (int i = 0; i < sheet3.getPhysicalNumberOfRows(); i++) {	
				resultSet.put(sheet3.getRow(i).getCell(0).toString(), sheet3.getRow(i).getCell(1).toString());
			}
			break;
		}
		return resultSet;
	}
	
	@SuppressWarnings("resource")
	public static String getDataFromExcel(String sheetName, String key) throws IOException {
		HashMap<String, String> resultSet = new HashMap<String, String>();
		FileInputStream fis = new FileInputStream(excelResourcePath + "DataProvider.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		switch (sheetName) {
		case "SearchData":
			XSSFSheet sheet = workbook.getSheet(sheetName);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {	
				resultSet.put(sheet.getRow(i).getCell(0).toString(), sheet.getRow(i).getCell(1).toString());
			}
			break;
		}
		return resultSet.get(key);
	}
}
