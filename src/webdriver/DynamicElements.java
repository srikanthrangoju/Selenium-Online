package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class DynamicElements {
	WebDriver driver;
	
	@BeforeTest
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://www.studyinnewzealand.govt.nz/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

  @Test
  public void Test() {
	  	  driver.findElement(By.xpath("//a[contains(text(),'Engineering')]")).click(); 
  }
  
  @AfterTest
  public void afterMethod() {
  }

}
