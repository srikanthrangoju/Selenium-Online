package com.google.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.google.common.Validate;
//import static com.google.homepage.Abstractpage;

public class Homepage extends Abstractpage {
	
	// public Homepage(){
		 //super();
	 //}
	
	@FindBy(how=How.ID, id="lst-ib")
	 WebElement textBox;
	 
	 @FindBy(how=How.NAME, name="btnG")
	 WebElement button;
	 
	 @FindBy(how=How.LINK_TEXT, using="Downloads - Selenium")
	 WebElement link;
	 
	 @FindBy(how=How.ID, id="q")
	 WebElement mouse;
	 
	 @FindBy(how=How.XPATH, using="//div/h3[contains(.,'Donate to Selenium')]")
	 WebElement atext;
	 
	
	 public void googleHomepage(String text){
		 Homepage hp = new Homepage();
		 hp.typetextBox(textBox,text);
		 hp.clickButton(button);
		 hp.clickLink(link);
		 hp.mouseAction(mouse);
		 hp.assertText(atext);
		 Validate.validateStringEquals("Selenium",text,true);
		 Homepage.assertInPage();
		 //Abstractpage.elementPresent();
		//elementEnabled();
		 getAttribute(text);
		 getPageTitle(text);
		 
	 }

	 
		 
	 }

