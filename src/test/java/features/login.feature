Feature: Leaftaps Login

Background:
Given Open the chrome browser
And Load the leaftaps url

Scenario Outline: Login with valid credentials
And Enter the username as <username>
And Enter the password as <password>
When Click on Login button
Then HomePage should be displayed

Examples:
|username|password|
|'DemoSalesManager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|

Scenario: Login with invalid credentials
And Enter the username as 'leaftaps'
And Enter the password as 'leaftaps@123'
When Click on Login button
But Error message 'User not found' should be displayed 