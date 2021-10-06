Feature: AS A User, I WANT to be able to update existing course types SO THAT I can update an existing course.
  Background:
    Given I am using dummy data
    And I go to the course info page
    And I click the Edit Course Type Button for any course type

    Scenario: User wants to edit with a valid course type name
      When I  enter a valid name into the course type name field
      And I click the submit button on the Edit Course Type page
      Then I should be returned to the course info page and The new course type name should be present
