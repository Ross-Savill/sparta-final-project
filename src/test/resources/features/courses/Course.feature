@course @transfer
Feature: AS A user I WANT to be able to edit a new course SO THAT we can organise new courses for trainees
  Transfer course info to edit course page

  Background:
    Given I am working with dummy data
    And I am starting the process
    And I am logged in
    And I go to the course page

  Scenario: User checks if the correct course information is transferred to the edit course page
    Then Course information from the correct course in row one should be transferred to the edit course page
