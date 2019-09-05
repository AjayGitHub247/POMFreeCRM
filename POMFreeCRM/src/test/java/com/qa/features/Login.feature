Feature: Free CRM Login Test

@Reg
Scenario: Verify the Login and Logout Functionality 

Given User is on Login page
When Login Page is Dispalyed
Then User Enters UserName Password and Clicks SignIn
Then User Navigates to Home Page
Then User Logout from the application