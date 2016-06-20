package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class handlingTables {
	WebDriver driver;
	 @BeforeTest
	  public void beforeTest() {
		  driver = new FirefoxDriver();
		  driver.get("http://www.thatscricket.com/india/players/ms-dhoni.html");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void handleTables() {
	  List<String> ls = TableHandlers.getColumnNames(driver,By.xpath("html/body/div[2]/div[1]/section/div[1]/div[5]/table[1]/tbody/tr[1]"));
	  System.out.println(ls);
	  
	  String str = TableHandlers.getColumnData(driver,By.xpath("//tr[2]/td[9]"));
	  System.out.println("ODI centuries of MS Dhoni:"+str);
  }
 
  @AfterTest
  public void afterTest() {
  }

}
