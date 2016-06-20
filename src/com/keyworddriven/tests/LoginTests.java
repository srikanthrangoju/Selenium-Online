package com.keyworddriven.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.common.SeleniumDriver;
import com.google.common.TestStep;

public class LoginTests extends BaseTest{
		SeleniumDriver sedriver;
		
		public LoginTests() {
			super("D:\\GmailLogin2.xlsx", "firefox");
			sedriver = new SeleniumDriver();
		}
		@Test
		public void loginTest(){
			List<TestStep> lsTestStep = mapTestSteps.get("loginTest");
			sedriver.runTestSteps(driver, lsTestStep);
		}
		
		/*@Test
		public void registerTest(){
			List<TestStep> lsteststep = mapTestSteps.get("lucidTest");
			sedriver.runTestSteps(driver, lsteststep);
		}*/
	}

	
				
