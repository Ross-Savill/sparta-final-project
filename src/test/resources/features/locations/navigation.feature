Feature: I am testing the nav stepdefs

  Scenario: test
    Given I am starting the process
    And I am logged in
    And I go to the trainees page
    And I go to the locations page
    And I log out
    When I am logged in
    Then I go to the scheduler page