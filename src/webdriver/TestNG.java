package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG {
	WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.id("https://www.google.co.in/"));
  }
  public void Test(){
	  driver.findElement(By.id("https://www.google.co.in/"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.google.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }
/*
  @BeforeClass
  public void beforeClass() {
	  System.out.println(3);
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(4);
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println(5);
  }

  @AfterTest
  public void afterTest() {
	  System.out.println(6);
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println(7);
  }

  @AfterSuite
  public void afterSuite() {

	  System.out.println(8);}*/
}
