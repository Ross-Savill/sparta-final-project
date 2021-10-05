Feature: AS A User, I WANT to be able to delete disciplines SO THAT I can remove unwanted disciplines
  Background:
  Background:
    Given I am using dummy data
    And I go to the course info page

  Scenario: User wants to delete a discipline
    Given there is a discipline in the discipline table
    When I click the delete button for the discipline on the course info page
    Then There should be a dialogue box confirming that you want to delete the discipline and Nothing should be removed from the discipline table

  Scenario: User wants to cancel deleting a discipline
    Given there is a discipline in the discipline table
    And I click the delete button for the discipline on the course info page
    When I click NO on the dialogue box
    Then Nothing should be removed from the discipline table

  Scenario: User wants to confirm deleting a discipline
    Given there is a discipline in the discipline table
    And I click the delete button for the discipline on the course info page
    When I click YES on the dialogue box
    Then The discipline should no long be present in the discipline table
