package webdriver;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class MultipleWindowsHandling {
	WebDriver driver;

  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("https://inet.idbibank.co.in");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  }
  @Test
  public void handlingMultiplewindows() {
	  driver.findElement(By.xpath("//img[@border='0']")).click();
	  String parentWindow = driver.getWindowHandle();
	  System.out.println(driver.getTitle());
	  driver.findElement(By.linkText("Know more")).click();
	  driver.findElement(By.linkText("Safe Internet Banking (Do’s & Dont’s)... click here")).click();
	  //driver.findElement(By.linkText("Register")).click();
	  //driver.findElement(By.xpath("//a//img")).click();
	  Set<String> s = driver.getWindowHandles();
	  for(String windowHandles: s){
				System.out.println(windowHandles);
				driver.switchTo().window(windowHandles);
				System.out.println(driver.getTitle());
				//driver.findElement(By.linkText("Funds Transfer")).click();
			}
	 // WebElement str = driver.findElement(By.xpath("//tr/td/div/p/b"));
	  //Assert.assertEquals("Keep your password top secret and change them often." , str.getText());
	 // System.out.println(str);
	  		
	
			driver.switchTo().window(parentWindow);
			System.out.println(driver.getTitle());
		}

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }

}

