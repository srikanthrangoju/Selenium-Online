package com.wordpress.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wordpress.abstractclass.ParentClass;

public class LoginPage extends ParentClass {
	WebDriver driver;
	
	By userName = By.id("user_login");
	By passWord = By.xpath("//*[@id='user_pass']");
	By loginButton = By.name("wp-submit");
	
	public LoginPage(WebDriver driver){
		super(driver);
		
	}
	public void typeUserName(String uid){
		driver.findElement(userName).sendKeys(uid);
	}
	
	public void typepassWord(String pass){
	driver.findElement(passWord).sendKeys(pass);
	}
	public void clickLoginButton(){
		driver.findElement(loginButton).click();
	}
}
