@EditTraineesPage
Feature: AS A user I WANT to edit trainees SO THAT they can be updated

  Background:
    Given I am working with dummy data
    And I am starting the process
    And I am logged in
    And I go to the trainees page
    And I click the Edit Trainee Button for the first trainee on the Trainees page

    Scenario: I want to edit a trainee successfully on the Edit Trainee page
      Then I can submit edits on the Edit Trainee page and have them save correctly

    Scenario: I want to be stopped from accidentally updating a blank first name on the Edit Trainee Page
      Then I will be stopped from submitting a blank first name on the Edit Trainee page

    Scenario: I want to be stopped from accidentally updating a blank second name on the Edit Trainee Page
      Then I will be stopped from submitting a blank last name on the Edit Trainee page

    Scenario: I want to be stopped from adding invalid characters to the first name field on the Edit Trainee Page
      Then I will be stopped from submitting an invalid first name on the Edit Trainee page

    Scenario: I want to be stopped from adding invalid characters to the last name field on the Edit Trainee Page
      Then I wil lbe stopped from submitting an invalid last name on the Edit Trainee page