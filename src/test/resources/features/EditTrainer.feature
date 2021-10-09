@EditTrainersPage
Feature: AS A user I WANT to edit trainers SO THAT they can be updated

  Background:
    Given I am working with dummy data
    And I am starting the process
    And I am logged in
    And I go to the trainers page
    And I click on the Edit Trainer Button

  Scenario: User wants to Edit a trainer and the information provided is correct
    When I enter a trainer first name, last name and colour on the Edit Trainer page
    And I click the submit button on the Edit Trainer page
    Then I should find my trainer present on the Trainer Page

  Scenario: User wants to Edit a trainer but the first name is missing
    When I forget to enter a first name but enter a last name on the Edit Trainer page
    And I click the submit button on the Edit Trainer page
    Then I should be stopped from submitting the Edit Trainer page

  Scenario: User wants to Edit a trainer but the last name is missing
    When I forget to enter a last name but enter a first name on the Edit Trainer page
    And I click the submit button on the Edit Trainer page
    Then I should be stopped from submitting the Edit Trainer page

  Scenario: User wants to Edit a trainer but the first name is invalid
    When I enter an invalid first name and correct last name on the Edit Trainer page
    And I click the submit button on the Edit Trainer page
    Then I should be stopped from submitting the Edit Trainer page

  Scenario: User wants to Edit a trainer but the last name is invalid
    When I enter a correct first name and an invalid last name on the Edit Trainer page
    And I click the submit button on the Edit Trainer page
    Then I should be stopped from submitting the Edit Trainer page