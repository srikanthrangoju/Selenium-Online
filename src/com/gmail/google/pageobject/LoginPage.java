package com.gmail.google.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	@FindBy(how=How.ID,id="Email")
	WebElement emailID;
	
	@FindBy(how=How.ID,id="next")
	WebElement nextButton;
	
	@FindBy(how=How.ID,id="email-display")
	WebElement existingAccount;
	
	@FindBy(how=How.ID,id="Passwd")
	WebElement pwd;
	
	@FindBy(how=How.ID,id="signIn")
	WebElement signInButton;
	
	@FindBy(how=How.XPATH, xpath="//div[contains(text(),'COMPOSE')]")
	WebElement composeButton;
	
	@FindBy(how=How.XPATH, xpath="//textarea[@id=':mv']")
	WebElement totext;
	
	@FindBy(how=How.ID, id=":mv")
	WebElement subj;
	
	@FindBy(how=How.ID, id=":nk")
	WebElement mbody;
	
	public boolean loginwithExistingAccount(String username, String password,String to,String subject,String msgbody){
			emailID.sendKeys(username);
			nextButton.click();
			if(existingAccount.getText().trim().equalsIgnoreCase(username.trim())){
			pwd.clear();
			pwd.sendKeys(password);
			signInButton.click();
			totext.sendKeys(to);
			subj.sendKeys(subject);
			mbody.sendKeys(msgbody);
			
			return true;
		}
		else
		{
			System.out.println("Unable to match given user account:"+username+"with existing account"+existingAccount.getText());
			return false;
		}
	}
}