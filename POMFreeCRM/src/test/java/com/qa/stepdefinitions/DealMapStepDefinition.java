package com.qa.stepdefinitions;

import com.qa.pages.DealPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DealMapStepDefinition extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	DealPage dealpage;
	
	@Given("^Map: User is on Login page$")
	public void user_is_on_Login_page() throws Throwable {
		TestBase.initialization();
		
		loginpage = new LoginPage();
		String titleLP = loginpage.validateLoginPageTitle();
		Assert.assertEquals("CRM", titleLP);		
	}

	@When("^Map: Login Page is Dispalyed$")
	public void login_Page_is_Dispalyed() throws Throwable {
			
		boolean flag1 = loginpage.controlDisplayed();
		Assert.assertTrue(flag1);
	}
	
	@Then("^User Enter UserName and Password fields with Map$")
    public void user_enter_username_and_password_fields_with_map(DataTable Credential) throws InterruptedException {
		
		loginpage.EnterUserNameandPassword(Credential);
        
    }
	
	@Then("^Map: User Clicks on login button$")
    public void user_clicks_on_login_button() throws InterruptedException {
		homepage = loginpage.ClickOnLoginButton(); 
    }

    @And("^Map: User is on Home page$")
    public void user_is_on_home_page() {
    	
    	String title = homepage.validateHomePageTitle();
    	Assert.assertEquals("CRM", title);
    	boolean flag =  homepage.verifyUserNameDispalyed();
    	Assert.assertTrue(flag);  
    }

    @Then("^Map: User Mouse Hover and Clicks on Deal Tab$")
    public void user_mouse_hover_and_clicks_on_deal_tab() throws InterruptedException {
    	dealpage = homepage.returnObject();
    	dealpage.MouseHoverAndClickDealTab(driver);
    }
    

    @Then("^Map: Verify the Deal page is loaded$")
    public void verify_the_deal_page_is_loaded() throws InterruptedException {
    	Thread.sleep(5000);
    	boolean element1 = dealpage.toolbarDispalyed();
    	Assert.assertTrue(element1);
    	boolean element2 = dealpage.newDealDispalyed();
    	Assert.assertTrue(element2);
    }

    @Then("^Map: User Clicks on Create New Button Deal$")
    public void user_clicks_on_create_new_button_deal() throws InterruptedException {
    	Thread.sleep(3000);
    	dealpage.clickNewDealButton(); 
    }
    
    @Then("^Enter Title and Description and Probability and Amount with Map$")
    public void enter_title_and_description_and_probability_and_amount_with_map(DataTable detials) throws InterruptedException {
    	
    	dealpage.enterDealDetails(detials);
        
    }

    @Then("^Map: Click on Save Deal Button$")
    public void map_click_on_save_deal_button() throws InterruptedException {
    	
    	dealpage.clickSaveDealButton();
         
    }

    @Then("^Verify the New Deal created with Title and Amount with Map$")
    public void verify_the_new_deal_created_with_title_and_amount_with_map(DataTable details) throws InterruptedException {
    	dealpage.verifyDealCreated(driver, details);     
    }
    
    @Then("^Map: User Logout from the application$")
	public void user_Logout_from_the_application() throws InterruptedException {
		
		Thread.sleep(1000);
		
		loginpage = homepage.logoutFromFreeCMR();
		
		Thread.sleep(4000);
		
		boolean flag3 = loginpage.controlDisplayed();
		Assert.assertTrue(flag3);
		
		driver.quit();	    
	}
    

    @When("^Map: User Clicks on Delete icon$")
    public void map_user_clicks_on_delete_icon() throws Throwable {
    	dealpage.clickOnDeleteIcon();  	
    }

    @Then("^Map: User Clicks on Delete button$")
    public void map_user_clicks_on_delete_button() throws Throwable {
        dealpage.clickDeletebutton();
    }

    @And("^Map: Verify the Move to the bin popup is displayed$")
    public void map_verify_the_move_to_the_bin_popup_is_displayed() throws Throwable {
    	dealpage.verifyMoveToTheBinPopupDisplayed();
    }

    @And("^Map: Verify the Deal is deleted from the list$")
    public void map_verify_the_deal_is_deleted_from_the_list() throws Throwable {
    	dealpage.verifyDealIsDeleted();      
    }


}
