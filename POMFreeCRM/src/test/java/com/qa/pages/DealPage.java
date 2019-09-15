package com.qa.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestBase;

import cucumber.api.DataTable;
import junit.framework.Assert;

public class DealPage extends TestBase {
	
	// Page Factory
	
	@FindBy(xpath = "//a[@href='/deals']")
	WebElement dealTab;
	
	@FindBy(id = "dashboard-toolbar")
	WebElement toolBar;
	
	@FindBy(xpath = "//a[@href='/deals/new']")
	WebElement newDeal;
	
	@FindBy(name = "title")
	WebElement titleTxt;
	
	@FindBy(name = "description")
	WebElement descriptionTxt;
	
	@FindBy(name = "probability")
	WebElement probabilityTxt;
	
	@FindBy(name = "amount")
	WebElement amountTxt;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveDeal;
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	WebElement title;
	
	@FindBy(xpath = "//tbody/tr/td[5]")
	WebElement amount;
	
	@FindBy(xpath = "//button/i[@class='trash icon']")
	WebElement deleteIcon;
	
	@FindBy(xpath = "//div[text()='Move to the bin']")
	WebElement deletePopUpTitle;
	
	@FindBy(xpath = "//div/button[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//div/button[text()='Delete']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//span/p[text()='No records found']")
	WebElement emptyDealListMsg;
	
	//Initializing the Page Objects 
	
	public DealPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void MouseHoverAndClickDealTab(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new  WebDriverWait(driver, 20);
    	dealTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/deals']")));
    	boolean status = dealTab.isDisplayed();
    	Assert.assertEquals(true, status);   			 
    	Actions action = new Actions(driver);
    	action.moveToElement(dealTab).build().perform();
    	Thread.sleep(3000);
    	dealTab.click();  
	}
	
	public boolean toolbarDispalyed() {
		return toolBar.isDisplayed();
	}
	
	public boolean newDealDispalyed() {
		return newDeal.isDisplayed();
	}
	
	public void clickNewDealButton() {
		newDeal.click();
	}
	
	public void enterDealDetails(DataTable detials) throws InterruptedException {
	
		for(Map<String, String> data : detials.asMaps(String.class, String.class)) {	 
				titleTxt.sendKeys(data.get("Title"));
				Thread.sleep(2000);
				descriptionTxt.sendKeys(data.get("Description"));
				Thread.sleep(2000);
				probabilityTxt.sendKeys(data.get("Probability"));
				Thread.sleep(2000);
				amountTxt.sendKeys(data.get("Amount")); 
		 	} 	
	}
	
	public void clickSaveDealButton() throws InterruptedException {
		Thread.sleep(5000);
        boolean saveButton = saveDeal.isDisplayed();
        Assert.assertEquals(saveButton, true);
        Thread.sleep(3000);
        saveDeal.click();
	}
	
	public void verifyDealCreated(WebDriver driver, DataTable details) throws InterruptedException {
		
		for(Map<String, String> data : details.asMaps(String.class, String.class)) {
			 
		 	Thread.sleep(5000);
		 	
		 	WebDriverWait wait1 = new  WebDriverWait(driver, 20);
	    	title = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[2]")));
	    	boolean status1 = title.isDisplayed();
	    	Assert.assertEquals(true, status1); 
	    	
		 	String Title = title.getText();
		 	System.out.println(Title);
	    	Assert.assertEquals(data.get("Title"), Title);
	    	
	    	WebDriverWait wait2 = new  WebDriverWait(driver, 20);
	    	amount = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[5]")));
	    	boolean status2 = amount.isDisplayed();
	    	Assert.assertEquals(true, status2);
	    	
	    	String Amount = amount.getText();
	    	System.out.println(Amount);
	    	Assert.assertEquals(data.get("Amount"), Amount);
	 	} 
	}
	
	public void clickOnDeleteIcon() throws InterruptedException {
		Thread.sleep(2000);
		deleteIcon.equals(driver.switchTo().activeElement());
		Thread.sleep(1000);
		deleteIcon.click();
		Thread.sleep(3000);
	}
	
	public void verifyMoveToTheBinPopupDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		boolean falg1 = deletePopUpTitle.isDisplayed();
		Assert.assertTrue(falg1);
		Thread.sleep(1000);
		boolean falg2 = cancelButton.isDisplayed();
		Assert.assertTrue(falg2);
		Thread.sleep(1000);
		boolean falg3 = deleteButton.isDisplayed();
		Assert.assertTrue(falg3);
		Thread.sleep(1000);	
	}
	
	public void clickDeletebutton() throws InterruptedException {
		Thread.sleep(1000);
		deleteButton.equals(driver.switchTo().activeElement());
		Thread.sleep(1000);
		deleteButton.click();
		Thread.sleep(1000);
	}
	
	public void verifyDealIsDeleted() throws InterruptedException {
		Thread.sleep(3000);
		boolean falg1 = emptyDealListMsg.isDisplayed();
		Assert.assertTrue(falg1);
		Thread.sleep(1000);
	}
}	
