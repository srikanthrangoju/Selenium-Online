package com.gmail.google.tests;

import org.openqa.selenium.WebDriver;

import com.google.homepage.Abstractpage;

public class BaseTest {
	WebDriver driver;
	public void setup(){
	driver = Abstractpage.getDriver();
	}
}
