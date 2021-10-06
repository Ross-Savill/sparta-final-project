@AddTraineesPage
Feature: AS A user I WANT to add trainees SO THAT they can be in a course

  Background:
    Given I am working with dummy data
    And I am starting the process
    And I am logged in
    And I go to the trainees page
    And I click on the Add Trainee Button

    Scenario: User wants to add a trainee and the information provided is correct
      When I enter a trainee first name, last name and course on the Add Trainee page
      And I click the submit button on the Add Trainee page
      Then I should find my trainee present on the Trainee Page

    Scenario: User wants to add a trainee but the first name is missing
      When I forget to enter a first name but enter a last name on the Add Trainee page
      And I click the submit button on the Add Trainee page
      Then I should be stopped from submitting the Add Trainee page

    Scenario: User wants to add a trainee but the last name is missing
      When I forget to enter a last name but enter a first name on the Add Trainee page
      And I click the submit button on the Add Trainee page
      Then I should be stopped from submitting the Add Trainee page

    Scenario: User wants to add a trainee but the first name is invalid
      When I enter an invalid first name and correct last name on the Add Trainee page
      And I click the submit button on the Add Trainee page
      Then I should be stopped from submitting the Add Trainee page

    Scenario: User wants to add a trainee but the last name is invalid
      When I enter a correct first name and an invalid last name on the Add Trainee page
      And I click the submit button on the Add Trainee page
      Then I should be stopped from submitting the Add Trainee page



