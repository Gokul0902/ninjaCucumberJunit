Feature: Login Functionality 

Scenario Outline: Login With Valid Credentials 
Given  User has to navigate to login page 
When User has enter valid email Adress <username> in the email field 
And User has enter valid password <password> in the password field 
And user has to click on Login button
Then user should successfully logged in
Examples:
|username	|password|
|gokula.chander11@gmail.com|12345|
|gokula.chander111@gmail.com|12345|

Scenario: Login with invalid credentials 
Given User has to navigate to login page 
When User has enter valid email Adress in the email field
And User has enter invalid password in the password field 
And user has to click on Login button
Then user should get warning message if credentials doesnt match

Scenario:Login with invalid email and valid password 
Given User has to navigate to login page 
When User has enter invalid email Adress in the email field 
And User has enter valid password in the password field
And user has to click on Login button
Then user should get warning message if credentials doesnt match

Scenario:Login with valid email and invalid password 
Given User has to navigate to login page 
When User has enter invalid email Adress in the email field 
And User has enter valid password in the password field
And user has to click on Login button
Then user should get warning message if credentials doesnt match

Scenario:Login without any credentials 
Given User has to navigate to login page 
When User doesnt enter in the email field 
And User doesnt not enter in the password filed 
And user has to click on Login button
Then user should get warning message if credentials doesnt match