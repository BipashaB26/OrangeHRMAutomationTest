#Author : Bipasha Bhattacharjee
Feature: Check login functionality

  Background: System setting is proper
    Given browser is open
    And user is on login page

  ###  Login test for valid credentials ###
  Scenario Outline: User can login with valid credentials
    When user has entered <userName> and <passWord> which are valid
    And Login button is clicked
    Then navigation to Dashboard in the Home Page takes place

    Examples: 
      | userName | passWord |
      | Admin    | admin123 |

  ### Login test for invalid credentials [Neg] ###
  Scenario Outline: User cannot login with invalid credentials
    When invalid credentials are entered as <invalidUsername> and <invalidPassword>
    And Login button is clicked
    Then error message is displayed on the same screen

    Examples: 
      | invalidUsername | invalidPassword |
      | Admin           | admin1234       |
      | Adminn          | admin123        |
      | Adminn          | admin1234       |
      | Admin           |                 |
      |                 | admin123        |
      |                 |                 |
