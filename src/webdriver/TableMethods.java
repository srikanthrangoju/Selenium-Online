package webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableMethods {
	
	public static List<String> getRowData(WebDriver driver, By columnIdentifier){
		List<WebElement> lsCount = driver.findElements(columnIdentifier);
		List<String> list = new ArrayList<String>();
		for(WebElement we : lsCount){
			list.add(we.getText().trim());
		}
		return list;
	}
	/*public static List<String> getColumnCount(WebDriver driver, By columnCount){
		List<WebElement> count = driver.findElements(columnCount);
		List<Integer> l = new ArrayList<Integer>();{
			for(WebElement w:count){
				}
		}
						
	}*/
}
		
	

