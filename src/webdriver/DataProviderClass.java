package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class DataProviderClass {
	WebDriver driver;
	
	 @BeforeTest
	  public void beforeTest() {
		  driver = new FirefoxDriver();
		  driver.get("https://www.facebook.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test(dataProvider = "dp")
  public void gmailLogin(String userName, String passWord) {
	  driver.findElement(By.id("email")).sendKeys(userName);
	  driver.findElement(By.id("pass")).sendKeys(passWord);
	  driver.findElement(By.id("u_0_w")).click();
	  
  }

  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  @DataProvider
  public Object[][] dp() {
	  Object[][] data = new Object[3][2];
	  data[0][0]="957361681";
	  data[0][1]="95736168132";
	  
	  data[1][0]="9573616813";
	  data[1][1]="9573616813";
	  
	  data[2][0]="95736168132";
	  data[2][1]="95736168";
	  
    return data;
      
  }

}
