Feature: Create Lead in leaftaps

Background: Login as a valid user
Given the user opens the chrome browser and loads the url 'http://leaftaps.com/opentaps/control/login'
And the user enters the credentials and logs in
	| DemoSalesManager| crmsfa |
And the user is on home page

Scenario Outline: As a valid user I want to create a lead with valid details
Given the user is on create lead page
And the user enters the required details
	|<company>|<firstName>|<lastName>|<phoneNo>|
When the user click on create lead button
Then the user is redirected to view leads page
And the user has created a lead

Examples:
| company |firstName|lastName|  phoneNo   |
|   TCS   | Aditya  |Ravi    |  9003746012|
| Infosys | Amit    |Kumar   |  8957653112|
