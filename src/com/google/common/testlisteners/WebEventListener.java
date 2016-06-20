package com.google.common.testlisteners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {
	WebDriver driver;
	String url = "http://www.google.com";

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
				
	}

	@Override
	public void afterClickOn(WebElement button, WebDriver driver) {
		System.out.println("Button Clicked");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		
	}

	@Override
	public void beforeClickOn(WebElement button, WebDriver driver) {
		System.out.println("Please Click on this button!!!!");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		
	}

	@Override
	public void onException(Throwable exception, WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try{
		File destFile = new File("Screenshot"+System.currentTimeMillis()+".jpg");
		FileUtils.copyFile(srcFile, destFile);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
		}
		
