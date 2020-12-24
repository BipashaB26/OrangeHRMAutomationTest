#Author : Bipasha Bhattacharjee
Feature: Check Configure PIM functionality

  Background: User is on the Configure PIM Page
    Given user has logged in
    And user reaches Configure PIM Page from Home Page

  ###  Test for saving all the mentioned fields together ###
  Scenario: User can save all the fields together
    When user clicks on Edit button
    Then all the disabled checkboxes get enabled
    And Save button appears
    When user clicks on Save button
    Then all the fields are successfully saved

  ###  Test for saving the mentioned fields as per wish ###
  Scenario: User can save fields as per wish
    When user clicks on Edit button
    Then all the disabled checkboxes get enabled
    And Save button appears
    When user deselects any of the selected fields and selects accoring to wish
    And clicks on Save button
    Then selected fields are successfully saved

  ###  Test for checking save property if no fields are chosen  [Neg]  ###
  Scenario: No fields can be saved none of the checkboxes are selected
    When user clicks on Edit button
    Then all the disabled checkboxes get enabled
    And Save button appears
    When user deselects all the checkboxes
    And clicks on Save button
    Then error message is displayed or user is prompted that no field is chosen
