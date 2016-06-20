package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyPress {
	WebDriver driver;
	
	@BeforeTest
public void setUp(){
		/*System.setProperty("webdriver.ie.driver","C://IEDriverServer.exe");
		driver = new InternetExplorerDriver();*/
		System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
  @Test
  public void keyPressTest() {
	  WebElement element = driver.findElement(By.name("email"));
	 
	  Actions action = new Actions(driver);
	  Actions seriesOfActions = action.moveToElement(element).keyDown(element,Keys.SHIFT).sendKeys("srikanth").keyUp(element,Keys.SHIFT).doubleClick().contextClick();
	  seriesOfActions.build().perform();
  }
  @AfterTest
  public void end(){
  }
  }

