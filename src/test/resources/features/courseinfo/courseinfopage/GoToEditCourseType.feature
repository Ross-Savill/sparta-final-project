@courseType
Feature: AS A User I WANT to be able to edit course types SO THAT I can keep course types up to date
  Background:
    Given I am using dummy data
    And I go to the course info page

  Scenario: User clicks the Edit Course Type Button for a Specific Course
    Given There is a course type present
    When I click the Edit Course Type Button for a specific course type
    Then I should be on the Edit Course Type Page for that course type