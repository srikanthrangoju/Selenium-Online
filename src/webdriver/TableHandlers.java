package webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableHandlers {
	
	public static List<String> getColumnNames(WebDriver driver, By tableHeaderIdendifier){
		waitAndMoveToElement(driver, tableHeaderIdendifier);
		List <WebElement> lsHeaders = driver.findElements(tableHeaderIdendifier);
		List<String> ls = new ArrayList<String>();
		for(WebElement header: lsHeaders){
			ls.add(header.getText().trim());
		}
		
		return ls;
		
	}
	public static String getColumnData(WebDriver driver,By columnIdentifier){
		waitAndMoveToElement(driver, columnIdentifier);
		return driver.findElement(columnIdentifier).getText();
		
		
	}
	public static void waitAndMoveToElement(WebDriver driver, By elementIdentifier){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(elementIdentifier));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(elementIdentifier));
	}

}
