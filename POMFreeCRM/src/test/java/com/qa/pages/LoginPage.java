package com.qa.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

import cucumber.api.DataTable;
import junit.framework.Assert;

public class LoginPage extends TestBase{
	
	// Page Factory
	
		@FindBy(name = "email")
		WebElement usernameTxt;
		
		@FindBy(name = "password")
		WebElement passwordTxt;
		
		@FindBy(xpath = "//div[text()='Login']")
		WebElement loginBtn;
		
	//Initializing the Page Objects 
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
	// Actions 
		
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public HomePage loginToFreeCRMapp(String Un, String Pwd) throws InterruptedException {
			
			Thread.sleep(2000);
			usernameTxt.sendKeys(Un);
			Thread.sleep(2000);
			passwordTxt.sendKeys(Pwd);
			Thread.sleep(2000);
			loginBtn.click();
			
			return new HomePage();
		}
		
		public boolean controlDisplayed() throws InterruptedException {
			
			Thread.sleep(1000);
			boolean UN = usernameTxt.isDisplayed();
			Assert.assertTrue(UN);
			
			Thread.sleep(1000);
			boolean PW = passwordTxt.isDisplayed();
			Assert.assertTrue(PW);
			
			Thread.sleep(1000);
			boolean LB = loginBtn.isDisplayed();
			Assert.assertTrue(LB);
			
			if(UN==PW==LB) {
				System.out.println("All Webelement Displayed");
			}
			
			return LB;
		}
		
		public void EnterUserNameandPassword(DataTable Credential) throws InterruptedException {		
			for(Map<String, String> data : Credential.asMaps(String.class, String.class)) {	 
				Thread.sleep(2000);
				usernameTxt.sendKeys(data.get("UserName"));
				Thread.sleep(2000);
				passwordTxt.sendKeys(data.get("Password"));
		 	} 	
		}
		
		public HomePage ClickOnLoginButton() throws InterruptedException {	
			Thread.sleep(2000);
			loginBtn.click();	
			return new HomePage();
		}
		
}
