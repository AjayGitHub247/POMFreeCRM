Feature: Free CRM Deal Creation 

@Reg
Scenario: Create a new deal scenario with Map

Given Map: User is on Login page
When Map: Login Page is Dispalyed
Then User Enter UserName and Password fields with Map
| UserName | Password |
| ajay24789@gmail.com | Ajay4444 |
Then Map: User Clicks on login button
And Map: User is on Home page
Then Map: User Mouse Hover and Clicks on Deal Tab
Then Map: Verify the Deal page is loaded
Then Map: User Clicks on Create New Button Deal
Then Enter Title and Description and Probability and Amount with Map
| Title | Description | Probability | Amount |
| Test Deal two | Description for Test Deal two | 40 | 3500 |
Then Map: Click on Save Deal Button
Then Map: User Mouse Hover and Clicks on Deal Tab
Then Verify the New Deal created with Title and Amount with Map
| Title | Amount |
| Test Deal two | 3500 |
And Map: User Logout from the application
