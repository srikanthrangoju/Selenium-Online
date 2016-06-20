package webdriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class commandsTest {
	WebDriver driver;

 @BeforeTest
 public void setUp() 
 {
	 driver = new FirefoxDriver();
	 driver.get("https://www.youtube.com");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void testCommands() {
	  
	 
	 /* String parentHandle = driver.getWindowHandle(); // get the current window handle
	  driver.findElement(By.id("masthead-search-term")).sendKeys("MS Dhoni");
	  driver.findElement(By.id("search-btn")).click();
	  driver.navigate().back();
	  driver.navigate().forward();
	  driver.findElement(By.id("masthead-search-term")).clear();
	  driver.switchTo().window(parentHandle); // switch back to the original window
	  String s = driver.getTitle();
	  System.out.println(s);*/
	  
	  /*System.out.println(s);
	  String s1 = driver.getCurrentUrl();
	  System.out.println(s1);
	  String s2 = driver.getPageSource();
	  System.out.println(s2);*/

      //List<WebElement> elements = driver.findElements(By.xpath("//style"));    
        //  System.out.println("number of elements: " + elements.size());

          //for(WebElement ele : elements){
              //ele.sendKeys("hexbyes");
              //System.out.println(ele.getText());
            //  System.out.println(ele.getAttribute("style"));
              //System.out.println(ele.getTagName());}
          String actual = driver.getCurrentUrl();
          System.out.println(actual);
          Assert.assertEquals("https://www.youtube.com", actual);
      }

	  
	    

  @AfterTest
  public void terminate() {
	  //driver.close();
  }

}
