@courseType
Feature: AS A User I WANT to be able to add course types SO THAT I can keep course types up to date
  Background:
    Given I am using dummy data
    And I go to the course info page

    Scenario: User clicks the Add Course Type Button
      When I click the Add Course Type Button
      Then I should be on the Add Course Type Page

