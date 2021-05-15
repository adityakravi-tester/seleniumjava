Feature: Leaftaps Login

Background:
Given Open the chrome browser
And Load the leaftaps url

Scenario: Login with valid credentials
And Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When Click on Login button
Then HomePage should be displayed

Scenario: Login with invalid credentials
And Enter the username as 'leaftaps'
And Enter the password as 'leaftaps@123'
When Click on Login button
But Error message 'User not found' should be displayed 