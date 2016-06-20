package com.keyworddriven.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.TestStep;
import com.google.homepage.Abstractpage;

import jxl.read.biff.BiffException;

public class BaseTest{
	WebDriver driver;
		Map<String, List<TestStep>> mapTestSteps = new HashMap<String, List<TestStep>>();
		protected String filename;
	   
		public BaseTest(String filename, String drivertype){
			this.filename = filename;
			if(drivertype.equalsIgnoreCase("firefox"))
				driver = new FirefoxDriver();
			
			if(drivertype.equalsIgnoreCase("chrome")){
				System.setProperty("wedriver.chrome.driver", "D:\\Testing (Selenium)\\Drivers\\chromedriver.exe");
				driver = new InternetExplorerDriver();
			}
			driver.get("http://www.gmail.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		/*public void setup(){
			driver = AbstractPageObject.getDriver();
			wait = new WebDriverWait(driver,30);
		}*/
		
		@BeforeClass
		public void readTestCases() throws BiffException, FileNotFoundException, IOException, InvalidFormatException{
			File file = new File(filename);
			if(file.exists()){
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
				XSSFRow row = sheet.getRow(1);
				
				int rows = sheet.getLastRowNum();
				System.out.println("Number of rows in Excel sheet:" +rows);
				List<TestStep> lsTestStep = new ArrayList<TestStep>();
				String prevmethodname=null;//creating reference and initializing
				for(int i=1;i<rows;i++){
					row = sheet.getRow(i);
					String methodname = row.getCell(0).getStringCellValue();//Retrieving methodname

					if(prevmethodname!=null && !methodname.equalsIgnoreCase(prevmethodname)){
						mapTestSteps.put(prevmethodname, lsTestStep);
						lsTestStep = new ArrayList<TestStep>();
					}
					String keyword = row.getCell(1).getStringCellValue();	
					System.out.println("Keyword is"+keyword);
					String elementlocator = row.getCell(2).getStringCellValue();
					System.out.println("elementlocator is:" +elementlocator);
					String value= row.getCell(3).getStringCellValue();
					System.out.println("Value is:" +value);

					/*String value = "";
					if(row.getLastCellNum()>=3){
						System.out.println("Last cell of row: "+i+" is " +row.getLastCellNum());
						XSSFCell c = row.getCell(3);
						//if(c.getCellType()==org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
						value = c.getStringCellValue();
						if(c.getCellType()==org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC);
						value = String.valueOf(c.getNumericCellValue());
					} without dummy value
*/
					TestStep teststep = new TestStep();
					teststep.setKeyword(keyword);
					teststep.setElementlocator(elementlocator);
					teststep.setValue(value);

					lsTestStep.add(teststep);

					prevmethodname = methodname;
				}
				System.out.println("Map");
				mapTestSteps.put(prevmethodname, lsTestStep);
			}
		}
		
		/*@AfterClass
		public void teardown(){
			driver.quit();
		}*/
	}
