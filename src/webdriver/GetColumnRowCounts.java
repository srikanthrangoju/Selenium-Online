package webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetColumnRowCounts {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.redbus.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='txtOnwardCalendar']")).click();
		
		int columnCount = driver.findElements(By.xpath("//div[@id='rbcal_txtOnwardCalendar']/table[1]/tbody/tr/td")).size();
		System.out.println("ColumnCount"+columnCount);
		
		int rowCount = driver.findElements(By.xpath("//div[@id='rbcal_txtOnwardCalendar']/table[1]/tbody/tr")).size();
		System.out.println("RowCount"+rowCount);
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='rbcal_txtOnwardCalendar']/table[1]/tbody/tr"));
		List<String> ls = new ArrayList<String>();	
		for(WebElement we:list){
			ls.add(we.getText().trim());
			System.out.println(ls);
		}
		/*int rows = rowCount;
		for(int i=0;i<rowCount;i++){
			System.out.println(i);*/
				}
			}
		
		
		
		
		

