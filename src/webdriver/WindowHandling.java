package webdriver;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class WindowHandling {
	WebDriver driver;

	  @BeforeMethod
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "D:\\Testing (Selenium)\\Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://inet.idbibank.co.in/");
		  //driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
	  }
  @Test
  public void windowHandlingTest() {
	  
	  driver.findElement(By.xpath("//img[starts-with(@src,'web/L001/images/Phishing_12.jpg')]")).click();
	  String parentWindow = driver.getWindowHandle();
	  driver.findElement(By.linkText("Know more")).click();
	  
	  Set<String> setWindowHandles = driver.getWindowHandles();
	  for(String s:setWindowHandles){
		  if(s.equalsIgnoreCase(parentWindow))
			 continue;
			 driver.switchTo().window(s);
			 break;
		  }
	  driver.manage().window().maximize();
	  driver.findElement(By.linkText("How to Apply")).click();
	  WebElement howToApplyHeader = driver.findElement(By.cssSelector(".subject-org"));
	  Assert.assertEquals("How to Apply",howToApplyHeader.getText());
	  System.out.println(howToApplyHeader);
	 
	  driver.switchTo().window(parentWindow);	
	  driver.findElement(By.name("CorporateSignonCorpId")).sendKeys("2234");
  }
  @Test(enabled = false)
  public void rediffMailLoginiAlertText(){
	  driver.findElement(By.name("proceed")).click();
	  
	  Alert a = driver.switchTo().alert();
	  a.accept();
  }
  	  
  @AfterTest
  public void end() {
	  driver.quit();
	 
  }

}
