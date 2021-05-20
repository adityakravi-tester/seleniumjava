Feature: Edit a lead in leaftaps

Background: Login as a valid user
#Given the user opens the chrome browser and loads the url 'http://leaftaps.com/opentaps/control/login'
Given the user enters the credentials and logs in
    | DemoSalesManager| crmsfa |
And the user is on home page

@regression
Scenario Outline: As a valid user I want to duplicate a lead with valid details
Given the user is on leads page
And the user navigates to find leads page
And the user finds the lead by 'emailAddress'
    |<emailAddress>|
And the user selects a lead if it is found
And the user is on view leads page
When the user clicks on duplicate lead
And the user clicks on the submit button
Then the user is redirected to view leads page
And the user has duplicated the lead

Examples:
|emailAddress  |
|ravi@gmail.com|
|amit@gmail.com|