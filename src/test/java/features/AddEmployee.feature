Feature: AddEmployee feature 

Scenario Outline: user should be able to add employee with valid details 
	Given Initialize the browser with chrome 
	And Navigate to "url" Site 
	And User enters "username" and "password" and clicks on login button 
	And Navigate to add employee page 
	When User enters following details 
	And user clicks on save button 
	Then Verify that employee with id "100" saved successfully 

	Examples:
		|FirstName	| isha|
		|MiddleName	| pritam|
		|LastName	|t	|
		 |Id	| 201	|
	
	
	
	
	#Scenario: User should be able to add credit login details 
	#Given Initialize the browser with chrome 
	#	And Navigate to "url" Site 
	#	And User enters "username" and "password" and clicks on login button 
	#	And Navigate to add employee page 
	#	And User enters following details 
	#		|FirstName	|MiddleName	|LastName	| Id	|
	#		|pritam		|s		|takale		| 103	|		
	#	When User enters following details for creditlogin page
	#		|UserName	|Password	|ConfirmPassword	|
	#		|pritamt	    |pritam0507 |pritam0507	        |
	#	And user clicks on save button 
	#	Then Verify that employee with id "103" saved successfully