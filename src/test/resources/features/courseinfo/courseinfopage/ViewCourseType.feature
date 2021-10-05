Feature: AS A user, I WANT to be able to see Course Types SO THAT I have all the required information
  Background:
    Given I am using dummy data
    And I go to the course info page

    Scenario: User wants to see a specific course type
      When I want to find the following course type: {word}
      And I look at the course type table
      Then I should see the course type: {word}