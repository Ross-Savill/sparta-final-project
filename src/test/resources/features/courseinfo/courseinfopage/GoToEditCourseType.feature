@courseType
Feature: AS A User I WANT to be able to edit course types SO THAT I can keep course types up to date
  Background:
    Given I am using dummy data
    And I am starting the process
    And I am logged in
    And I go to the course info page

  Scenario: User clicks the Edit Course Type Button for any Course Type
    Given There is a course type present
    When I click the Edit Course Type Button for any course type
    Then I should be on the Edit Course Type Page for that course type