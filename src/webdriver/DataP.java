package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;


public class DataP {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String uname, String pwd) {
	 
	driver.findElement(By.id("")).sendKeys(uname);
	driver.findElement(By.id("")).sendKeys(pwd);
	driver.findElement(By.id("")).click();
  }

  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.facebook.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  
  @AfterTest
  public void afterTest() {
  }
  
  @DataProvider
  public Object[][] dp() {
	  Object[][] data = new Object[3][2];
	  data[0][0] = "957361681";
	  data[0][1] = "957361618132";
			  
			  data[1][0] = "9573616813";
			  data[1][1] = "95736161813";
					  
			  data[2][0] = "95736168131";
			  data[2][1] = "957361618132";
			  return data;
    }
  
}
