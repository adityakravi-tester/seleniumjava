Feature: Create Lead in leaftaps

Background: Login as a valid user
#Given the user opens the chrome browser and loads the url 'http://leaftaps.com/opentaps/control/login'
Given the user enters the credentials and logs in
	| DemoSalesManager| crmsfa |
And the user is on home page

@regression
Scenario Outline: As a valid user I want to create a lead with valid details
Given the user is on leads page
And the user navigates to create lead page
And the user enters the required details
	|<company>|<firstName>|<lastName>|<phoneNo>|<emailAddress>|
When the user click on create lead button
Then the user is redirected to view leads page
And the user has created a lead

Examples:
| company |firstName|lastName|  phoneNo   |  emailAddress  |
|   TCS   | Aditya  |Ravi    |  9003746012| ravi@gmail.com |
| Infosys | Amit    |Kumar   |  8957653112| amit@gmail.com |
