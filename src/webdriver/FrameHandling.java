package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FrameHandling {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.out.println("Inside Setup method");
		driver = new FirefoxDriver();
		driver.get("file:///C:/Users/SRIKANTH/AppData/Roaming/Skype/My%20Skype%20Received%20Files/SeleniumTest/SeleniumTest/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	@Test
	public void Test(){
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("tree")).click(); 
	}
	@Test
	public void handlingFrames() {
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("tree")).click(); 
		/* driver.findElement(By.linkText("Handle Alert")).click();
	  Alert a = driver.switchTo().alert();
	  a.accept();
	  System.out.println(a.getText());*/
		driver.switchTo().defaultContent();
		driver.switchTo().frame("detail");
		driver.findElement(By.id("myInputText")).sendKeys("Dhoni");
		//driver.findElement(By.id("myBtn")).click();
		driver.findElement(By.id("myInputTextArea")).sendKeys("Hi my name is MS Dhoni");
		driver.findElement(By.linkText("click me to show content")).click();
		driver.findElement(By.id("myCheckbox")).click();
		String pwd = driver.getWindowHandle();
		driver.findElement(By.linkText("click me to open a new window")).click();
		Set<String> setWindowHandles = driver.getWindowHandles();
		for(String s:setWindowHandles){
			if(s.equalsIgnoreCase(pwd))
				continue;
			driver.switchTo().window(s);
			break;
		}

		driver.manage().window().maximize();

		WebElement win = driver.findElement(By.xpath("//div[1]"));
		Assert.assertEquals("I am a new window",win.getText());
		System.out.println(win);
		driver.findElement(By.id("newInputText")).sendKeys("AAAA");
		driver.close();
		driver.switchTo().window(pwd);


		driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
		driver.switchTo().frame("frameDetail");
		driver.findElement(By.id("myBtn2")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
		driver.switchTo().frame("frameHeader");
		String title = driver.getTitle();
		System.out.println(title);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);

		driver.findElement(By.id("myCheckbox")).click();
		driver.findElement(By.linkText("click me to show content")).click();


		Select s=new Select(driver.findElement(By.id("mySelect")));
		s.selectByIndex(2);

		driver.findElement(By.id("myBtn")).click();
		Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);

		driver.findElement(By.linkText("Handle Alert")).click();
		Alert al = driver.switchTo().alert();
		al.accept();
		System.out.println(al);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		String sss = driver.getTitle();
		int i = sss.length();
		System.out.println(i);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		WebElement ee = driver.findElement(By.id("myInputText"));
		Actions action = new Actions(driver);
		action.moveToElement(ee).doubleClick().contextClick().click();
		action.build().perform();

	}

	@AfterTest
	public void stop() {
	}

}
