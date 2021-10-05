Feature: AS A user, I WANT to be able to see Disciplines SO THAT I have all the required information
  Background:
    Given I am using dummy data
    And I go to the course info page

  Scenario: User wants to see a specific discipline
    When I want to find the following discipline: {word}
    And I look at the discipline table
    Then I should see the discipline: {word}

