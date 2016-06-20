package com.wordpress.abstractclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParentClass {
	WebDriver driver = new FirefoxDriver();
	
	public ParentClass(WebDriver driver){
		this.driver = driver;
	}

}
