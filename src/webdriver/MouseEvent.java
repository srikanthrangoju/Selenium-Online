package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class MouseEvent {
	WebDriver driver;
	@BeforeTest
	  public void setUp() {
		driver = new FirefoxDriver();
		//driver.get("http://www.cartoonnetworkindia.com/");
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void moveToElement() {
	  WebDriverWait wait = new WebDriverWait(driver,60);
	  
	  WebElement ele = driver.findElement(By.id("lst-ib"));
	  ele.sendKeys("Apple");

		wait.until(ExpectedConditions.elementToBeClickable(By.name("btnG")));
		WebElement elem = driver.findElement(By.name("btnG"));
		elem.click();  

	  /*WebElement elem = driver.findElement(By.linkText("//a[@title='Privacy Policy']"));
	  elem.click();*/
	 
	  Actions action = new Actions(driver);
	  action.moveToElement(elem);
	  action.build().perform();
  }
  
  @AfterTest
  public void terminate() {
	  //driver.close();
  }

}
