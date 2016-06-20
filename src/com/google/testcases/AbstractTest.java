package com.google.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.homepage.Abstractpage;

public class AbstractTest {
	WebDriver driver;
	WebDriverWait wait;
	
	public void setUp(){
		driver = Abstractpage.getDriver();
		wait = new WebDriverWait(driver,30);
	}
		
}
