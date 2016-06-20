package com.google.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.common.Validate;
import com.google.homepage.Homepage;

public class HomepageTest extends AbstractTest {
	WebDriver driver;
	
	@Test
	public void homepageTest(){
		String text = "selenium";
		Homepage home = new Homepage();
		home.googleHomepage(text);	
		
	super.setUp();
	//Validate.validateStringEquals("Selenium",text,true);
	}
	
}

