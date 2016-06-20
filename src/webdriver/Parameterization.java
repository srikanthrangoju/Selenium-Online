package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void crossBrowser(String browserName)throws Exception{
		
		if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Testing (Selenium)\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver","D:\\Testing (Selenium)\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{System.out.println("Browser Doesnot exist");}
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();	
			
		String name = driver.getTitle();
		System.out.println(name);
	}
}
		
	
	

