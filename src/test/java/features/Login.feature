Feature: Login into Application

Scenario: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList" Site
When User enters "Username" and "Password" and clicks on login button
Then Verify that user is successfully logged in