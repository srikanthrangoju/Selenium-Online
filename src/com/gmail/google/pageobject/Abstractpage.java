package com.gmail.google.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.testlisteners.WebEventListener;

public class Abstractpage {
	protected static WebDriver driver;
	protected static EventFiringWebDriver event_webdriver;
	public Abstractpage(){
		if(driver==null){
			driver = new FirefoxDriver();
			event_webdriver = new EventFiringWebDriver(driver);
			event_webdriver.register(new WebEventListener());
			driver = event_webdriver;
			driver.get("http://www.gmail.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		PageFactory.initElements(driver, this);
	}
	public static WebDriver driver(){
		return driver;
	}

}
