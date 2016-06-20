package project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://www.newzealand.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	@Test
  public void holidayWithUs() {
		driver.findElement(By.xpath("//a/h3[@id='blockHeading1']")).click();
		//driver.findElement(By.cssSelector(".logo")).click();
		
		WebElement wb = driver.findElement(By.xpath("//a[@class='current']"));
		Actions action = new Actions(driver);
		action.moveToElement(wb);
		action.build().perform();
		
		/*driver.findElement(By.xpath("//a[@class='wishlist--link']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(alert.getText());*/
		
		WebElement w = driver.findElement(By.xpath("//a[contains(text(),'Destinations')]"));
		Actions a = new Actions(driver);
		a.moveToElement(w).build().perform();
		
		WebElement w1 = driver.findElement(By.linkText("Things to do"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(w1).build().perform();
		
		WebElement w2 = driver.findElement(By.linkText("Facts"));
		Actions a2 = new Actions(driver);
		a2.moveToElement(w2).build().perform();
		
		driver.findElement(By.linkText("History")).click();
		driver.navigate().back();
		
		
		/*WebElement w3 = driver.findElement(By.xpath("//select[@id='ddCity1']"));
		Actions actionn = new Actions(driver);
		actionn.moveToElement(w3).build().perform();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='ddCity1']")));
		s.selectByVisibleText("Hyderabad - HYD");*/

  }
	public void doBusinessWithUs(){
		driver.findElement(By.xpath("//a/h3[@id='blockHeading2']"));
		
	}
  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }
 
}
