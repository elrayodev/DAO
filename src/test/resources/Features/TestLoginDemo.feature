@Login
Feature: Test user login

  Scenario Outline: User logins successfully with credentials
    Given browser is open
    And user is in login page
    When user enters <username> and <password>
    And user clicks login button
    Then website shows main page

#  Scenario: User logins with wrong password
#  		Given browser is open
#   	And user is in login page
#   	When user enters username and wrong password
#   	And user clicks login button
#   	Then password is invalid error
 
#  Scenario: User logins successfully with credentials
# 		Given browser is open
#			And user is in login page
#   	When user enters username and password
#   	And user clicks login button
#   	Then website shows main page
  
Examples:
|username|password|
|Jorge|12345|
|Eloy|12345|


