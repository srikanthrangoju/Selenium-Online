package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class SearchGoogle {
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	  }
  @Test
  public void f() {
	  //doSearch("New Zealand");
	 /* Point p = (point)driver.findElement(By.xpath("//*[@id='yt-masthead-signin']/div/button"));
	  System.out.println(element.getLocation());
	  element.click();*/
  }
  
  @AfterTest
  public void afterTest() {
  }
  
  public void doSearch(String searchText){
	  //WebElement element = driver.findElement(By.id("idlst-ib"));
	  //element.sendKeys(searchText);
  }

}
