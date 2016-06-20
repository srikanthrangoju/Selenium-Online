package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(webdriver.testNGListeners.class)
public class GoogleVerify {
	
	@Test
	public void googleVerifyTest(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
