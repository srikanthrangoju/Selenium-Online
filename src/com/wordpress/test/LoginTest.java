package com.wordpress.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.wordpress.login.LoginPage;

public class LoginTest {
	
	@Test
	public void loginTest(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeUserName("admin");
		loginPage.typepassWord("demo123");
		loginPage.clickLoginButton();
		
		driver.close();
		
		
	}

}
