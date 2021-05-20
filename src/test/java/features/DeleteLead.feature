Feature: Delete a lead in leaftaps

Background: Login as a valid user
#Given the user opens the chrome browser and loads the url 'http://leaftaps.com/opentaps/control/login'
Given the user enters the credentials and logs in
    | DemoSalesManager| crmsfa |
And the user is on home page

@regression
Scenario Outline: As a valid user I want to delete a lead with valid details
Given the user is on leads page
And the user navigates to find leads page
And the user finds the lead by 'phoneNumber'
    |<phoneNumber>|
And the user selects a lead if it is found
When the user click on delete lead button
And the user tries to find the deleted lead
Then the user should get 'No records to display' message

Examples:
|phoneNumber|
|9003746012 |
|8939465567 |
|8979466578 |