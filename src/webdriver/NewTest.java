package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	  @BeforeTest
	  public void setUP() {
		  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		  capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
		  driver = new FirefoxDriver();
		  driver.get("http://www.google.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	  }
  @Test
  public void doSearch() {
	  driver.findElement(By.id("gs_htif0")).sendKeys("Cricket");
	  driver.findElement(By.xpath("//*[@id='sblsbb']/button")).click();  
  }

  @AfterTest
  public void afterTest() {
  }

}
