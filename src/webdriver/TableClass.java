package webdriver;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TableClass {
	WebDriver driver;
	@BeforeTest
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("C:\\Users\\SRIKANTH\\Desktop\\Table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
  @Test
  public void tableMethod() {

	 
	 
	 
  }
  
}
