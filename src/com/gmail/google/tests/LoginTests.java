package com.gmail.google.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmail.google.pageobject.LoginPage;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginTests extends BaseTest{
	WebDriver driver;
	
	@Test(dataProvider="logindata")
	public void gmailLoginTest(String username, String password,String to,String subject,String msgbody) {
		/*Properties props = new Properties();
		props.load(new FileReader("LoginTestData.properties"));
		 *//*String username= "srikantrangoju@gmail.com";
		String password = "testingtesting";
		  */
		LoginPage loginPage = new LoginPage();
		loginPage.loginwithExistingAccount(username,password,to,subject,msgbody);
		//super.setup();
	}
	
	@DataProvider(name="logindata")
	public Object[][] loginTestData(String username, String password,String to,String subject,String msgbody)throws FileNotFoundException, IOException, BiffException{
		/*Properties props = new Properties();
			props.load(new FileReader("LoginTestData.properties"));
			String username = props.getProperty("username");
			String password = props.getProperty("password");*/

		File file = new File("D:\\composemail.xlsx");
		/*Workbook workbook = Workbook.getWorkbook(new FileInputStream(file));
		Sheet sheet = workbook.getSheet(0);
		Cell[] cell = sheet.getRow(1);
		username = cell[0].getContents();
		password = cell[1].getContents();
		to=cell[2].getContents();
		subject = cell[3].getContents();
		msgbody=cell[4].getContents();
*/		
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell1 = row.getCell(0);
		XSSFCell cell2 = row.getCell(1);
		XSSFCell cell3 = row.getCell(2);
		XSSFCell cell4 = row.getCell(3);
		XSSFCell cell5 = row.getCell(4);
		
		username = cell1.getStringCellValue();
		password = cell2.getStringCellValue();
		to = cell3.getStringCellValue();
		subject = cell4.getStringCellValue();
		msgbody = cell5.getStringCellValue();
		
		String [][] str1 = new String[1][2];
		str1[0][0]=username;
		str1[0][1]=password;
		str1[0][2]=to;
		str1[0][3]=subject;
		str1[0][4]=msgbody;

		return str1;
	}
}
