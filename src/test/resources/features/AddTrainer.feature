@AddTrainersPage
Feature: AS A user I WANT to add trainers SO THAT they can train trainees

  Background:
    Given I am working with dummy data
    And I am starting the process
    And I am logged in
    And I go to the trainers page
    And I click on the Add Trainer Button

  Scenario: User wants to add a trainer and the information provided is correct
    When I enter a trainer first name, last name and colour on the Add Trainer page
    And I click the submit button on the Add Trainer page
    Then I should find my trainer present on the Trainer Page

  Scenario: User wants to add a trainer but the first name is missing
    When I forget to enter a first name but enter a last name on the Add Trainer page
    And I click the submit button on the Add Trainer page
    Then I should be stopped from submitting the Add Trainer page

  Scenario: User wants to add a trainer but the last name is missing
    When I forget to enter a last name but enter a first name on the Add Trainer page
    And I click the submit button on the Add Trainer page
    Then I should be stopped from submitting the Add Trainer page

  Scenario: User wants to add a trainer but the first name is invalid
    When I enter an invalid first name and correct last name on the Add Trainer page
    And I click the submit button on the Add Trainer page
    Then I should be stopped from submitting the Add Trainer page

  Scenario: User wants to add a trainer but the last name is invalid
    When I enter a correct first name and an invalid last name on the Add Trainer page
    And I click the submit button on the Add Trainer page
    Then I should be stopped from submitting the Add Trainer page

  Scenario: User wants to change the colour using the colour picker
    When I click the color picker and input a new colour
    And I click the submit button on the Add Trainer page
    Then I should be stopped from submitting the Add Trainer page



