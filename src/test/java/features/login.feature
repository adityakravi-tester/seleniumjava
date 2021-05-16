Feature: Leaftaps Login

#Background:
#Given Open the chrome browser
#And Load the leaftaps url
@smoke
Scenario Outline: Login with valid credentials
And Enter the username as <username>
And Enter the password as <password>
When Click on Login button
Then HomePage should be displayed

Examples:
|username|password|
|'DemoSalesManager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|
@regression
Scenario Outline: Login with invalid credentials
And Enter the username as <username>
And Enter the password as <username>
When Click on Login button
But Error message 'User not found' should be displayed

Examples:
|username|password|
|'DemoCSR'|'testleaf'|
|'leaftaps'|'crmsfa'|