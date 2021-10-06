@courseType
Feature: AS A user, I WANT to be able to see Disciplines SO THAT I have all the required information
  Background:
    Given I am using dummy data
    And I am starting the process
    And I am logged in
    And I go to the course info page

  Scenario: User wants to see a specific discipline
    When I want to find a specific discipline
    And I look at the discipline table
    Then I should see that discipline in the table
