Feature: Login into Application

Scenario: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "url" Site
When User enters "username" and "password" and clicks on login button
Then Verify that user is successfully logged in