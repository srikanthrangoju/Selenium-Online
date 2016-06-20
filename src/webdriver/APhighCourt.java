package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class APhighCourt {
	WebDriver driver;
  @Test
  public void Case() {
	  driver.findElement(By.linkText("Case Status Information")).click();
	  driver.findElement(By.xpath("//table/tbody/tr[13]/td/font/a/strong")).click();
	  driver.findElement(By.name("mtype")).sendKeys("WP");
	  driver.findElement(By.name("mno")).sendKeys("22118");
	  Select s = new Select(driver.findElement(By.name("year")));
	  s.selectByVisibleText("2015");
	  driver.findElement(By.xpath("html/body/form/font[2]/font/table[2]//tbody/tr/td[1]/input")).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://hc.ap.nic.in/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
