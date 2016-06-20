/*package com.keyworddriven.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractpage{
	protected static WebDriver driver;
	//protected static WebDriverWait wait;
	
	public Abstractpage(){
		if(driver==null){
		driver = new FirefoxDriver();
		driver.get("http:\\www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver,30);
	}
	PageFactory.initElements(driver,this);
}
	public static WebDriver getDriver(){
		return driver;
	}
}
*/