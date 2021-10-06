Feature: AS A User, I WANT to be able to delete course types SO THAT I can remove unwanted course types
  Background:
    Given I am using dummy data
    And I am starting the process
    And I am logged in
    And I go to the course info page

    Scenario: User wants to delete a course type
      Given there is a course type in the course types table
      When I click the delete button for the course type on the course info page
      Then There should be a dialogue box confirming that you want to delete the course type and Nothing should be removed from the course type table

    Scenario: User wants to cancel deleting a course type
      Given there is a course type in the course types table
      And I click the delete button for the course type on the course info page
      When I click NO on the dialogue box
      Then Nothing should be removed from the course type table

    Scenario: User wants to confirm deleting a course type
      Given there is a course type in the course types table
      And I click the delete button for the course type on the course info page
      When I click YES on the dialogue box
      Then The course type should no long be present in the course type table
