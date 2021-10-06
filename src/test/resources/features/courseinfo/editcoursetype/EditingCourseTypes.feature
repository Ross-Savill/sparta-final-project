Feature: AS A User, I WANT to be able to update existing course types SO THAT I can update an existing course.
  Background:
    Given I am using dummy data
    And I am starting the process
    And I am logged in
    And I go to the course info page
    And I click the Edit Course Type Button for any course type

    Scenario: User wants to edit with a valid course type name
      When I enter a valid name into the course type name field on the edit course type page
      And I click the submit button on the Edit Course Type page
      Then I should be returned to the course info page and The new course type name should be present

    Scenario: User attempts to edit to an empty course type name
      When I enter no data into the course type name field on the edit course type page
      And I click the submit button on the Edit Course Type page
      Then I should be stopped from adding an empty course type name.

    Scenario: User attempts to edit to a duplicate course type
      When I enter a duplicate name into the course type name field on the edit page
      And I click the submit button on the Edit Course Type page
      Then I should be stopped from adding a duplicate course name.
