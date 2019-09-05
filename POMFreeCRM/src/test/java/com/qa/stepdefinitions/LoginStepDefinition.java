package com.qa.stepdefinitions;

import junit.framework.Assert;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Given("^User is on Login page$")
	public void user_is_on_Login_page() throws Throwable {
		TestBase.initialization();
		
		loginpage = new LoginPage();
		String titleLP = loginpage.validateLoginPageTitle();
		Assert.assertEquals("CRM", titleLP);		
	}

	@When("^Login Page is Dispalyed$")
	public void login_Page_is_Dispalyed() throws Throwable {
			
		boolean flag1 = loginpage.controlDisplayed();
		Assert.assertTrue(flag1);
	}

	@Then("^User Enters UserName Password and Clicks SignIn$")
	public void user_Enters_UserName_Password_and_Clicks_SignIn() throws Throwable {
		
		homepage = loginpage.loginToFreeCRMapp(prop.getProperty("username"), prop.getProperty("password"));
	    
	}

	@Then("^User Navigates to Home Page$")
	public void user_Navigates_to_Home_Page() throws InterruptedException {
		
		Thread.sleep(4000);
		
		String titleHP = homepage.validateHomePageTitle();
		Assert.assertEquals("CRM", titleHP);
		
		Thread.sleep(1000);
		
		boolean flag2 = homepage.verifyUserNameDispalyed();
		Assert.assertTrue(flag2);
	    
	}

	@Then("^User Logout from the application$")
	public void user_Logout_from_the_application() throws InterruptedException {
		
		Thread.sleep(1000);
		
		loginpage = homepage.logoutFromFreeCMR();
		
		Thread.sleep(4000);
		
		boolean flag3 = loginpage.controlDisplayed();
		Assert.assertTrue(flag3);
		
		driver.quit();	    
	}

}


