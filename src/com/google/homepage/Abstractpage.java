package com.google.homepage;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.testlisteners.WebEventListener;

public class Abstractpage {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static EventFiringWebDriver event_webdriver;
	public Abstractpage(){
		if(driver==null){
			driver = new FirefoxDriver();
			event_webdriver = new EventFiringWebDriver(driver);
			event_webdriver.register(new WebEventListener());
			driver = event_webdriver;
			driver.get("http://www.google.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,30);
			//driver.quit();
		}
		PageFactory.initElements(driver, this);
	}
public static WebDriver getDriver(){
	return driver;
}
public void typetextBox(WebElement textBox, String text){
	textBox.clear();
	textBox.sendKeys(text);
}
public void clickButton(WebElement button){
	if(driver instanceof InternetExplorerDriver){
		Actions actions = new Actions(driver);
		actions.sendKeys(button,Keys.ENTER);
		actions.build().perform();
	}
	else
	{
		button.click();
	}
}
public void clickLink(WebElement link){
	link.click();
}
public void mouseAction(WebElement mouse){
	Actions action = new Actions(driver);
	action.moveToElement(mouse);
	action.build().perform();
}
//validate and verify
public void assertText(WebElement atext){
	Assert.assertEquals("Downloads", driver.getTitle()); 
}
public static void assertInPage(){
	//http://stackoverflow.com/questions/14156656/how-to-verify-element-present-or-visible-in-selenium-2-selenium-webdriver
	driver.navigate().back();
	if(driver.findElement(By.xpath("//a[@id='gb_70']")).isDisplayed())
		System.out.println("Element is visibled");
	else
		System.out.println("Element is not visibled");
}
public static void elementPresent(){
	driver.navigate().back();
	if(driver.findElement(By.xpath("//a[@id='gb_70']"))!=null)
		System.out.println("Element is present");
	else
		System.out.println("Element is not present");	 
}
public static void elementEnabled(){
	if(driver.findElement(By.xpath("//a[@id='gb_70']")).isEnabled())
		System.out.println("Element is enabled");
	else
		System.out.println("Element is disabled");
}
/*To check text present
if(driver.getPageSource().contains("Text to check")){
System.out.println("Text is present");
}else{
System.out.println("Text is absent");*/
public static String getAttribute(String name){
	WebElement googleSearchBtn = driver.findElement(By.name("btnG"));
	System.out.println("Name of the button is:- " +googleSearchBtn.getAttribute("name"));
	return name;

}
public static String getPageTitle(String name){
	String pageTitle = driver.getTitle();
	System.out.println(pageTitle);
	return pageTitle;

}

}

