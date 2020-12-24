#Author : Bipasha Bhattacharjee
Feature: Check addition of a new Reporting Method

  Background: User is on the Reporting Methods Page
    Given user has logged in
    And user reaches Reporting Methods Page from Home Page

  ###  Test for addition of a new Reporting Method ###
  Scenario: User can add a new Reporting Method
    When user clicks on Add button
    And enters a Name
    And clicks on Save
    Then a new Reporting Method is added as message is displayed
