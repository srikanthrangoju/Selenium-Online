package com.google.common;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class SeleniumDriver {
	public void runTestSteps(WebDriver driver,List<TestStep> lsTestSteps){

		for(TestStep step: lsTestSteps){
			if(step.keyword.equalsIgnoreCase("openbrowser")){
				driver.get(step.value);
			}

			String elementlocator = step.getElementlocator();
			String identifier = elementlocator.substring(elementlocator.indexOf("=")+1);
			By locator=null;
			if(elementlocator.startsWith("id"))
				locator = By.id(identifier);
			if(elementlocator.startsWith("name"))
				locator = By.name(identifier);
			if(elementlocator.startsWith("css"))
				locator = By.cssSelector(identifier);
			if(elementlocator.startsWith("xpath"))
				locator = By.xpath(identifier);
			if(elementlocator.startsWith("link"))
				locator = By.linkText(identifier);

			if(step.getKeyword().equalsIgnoreCase("type")){
				WebElement textElement = waitForElement(locator, driver);
				textElement.sendKeys(step.getValue());
				//driver.findElement(locator).sendKeys(step.getValue());
			}
			if(step.getKeyword().equalsIgnoreCase("click")){
				WebElement btnClick = waitForElement(locator,driver);
				btnClick.click();
				//driver.findElement(locator).click();
			}
		}
	}
	public WebElement waitForElement(final By locator,WebDriver driver1){//FLUENT WAIT
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver1).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement webelement = wait.until(new Function<WebDriver,WebElement>(){

			@Override
			public WebElement apply(WebDriver driver1) {
				return driver1.findElement(locator);
			}

		});//Anonymous inner class
		return webelement;
	}
	
		/*public void waiForCondition(final String expectedTitle, WebDriver driver){
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
			
		//	wait.until(new Predicate<WebDriver>(){

				@Override
				public boolean test(WebDriver driver) {
					String currentPageTitle = driver.getTitle();
					return currentPageTitle.equalsIgnoreCase(expectedTitle);
				}
				
			});
*/					}
