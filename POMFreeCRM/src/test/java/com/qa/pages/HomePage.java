package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase{
	
	// Page Factory
	
	@FindBy(xpath = "//span[text()='Ajay Kumar']")
	WebElement userTitle;
	
	@FindBy(xpath = "(//i[@class='settings icon'])[1]")
	WebElement settingIcon;
	
	@FindBy(xpath = "//a/span[text()='Log Out']")
	WebElement logoutOption;
	
	
	//Initializing the Page Objects 
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions 
	
	public boolean verifyUserNameDispalyed() {
		return userTitle.isDisplayed();
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage logoutFromFreeCMR() throws InterruptedException {
		
		Thread.sleep(2000);
		settingIcon.click();
		Thread.sleep(2000);
		logoutOption.click();
		Thread.sleep(5000);
		
		return new LoginPage();
	}
	
	public DealPage returnObject() {
		return new DealPage();
	}
	
	
}
