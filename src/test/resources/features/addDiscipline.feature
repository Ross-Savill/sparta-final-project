Feature: Add discipline
  Scenario: User provides valid inputs and adds a discipline
    When I am on the Add discipline page
    And Fill out the form with valid entries
    Then I should be directed to the courseinfo page
    And I should see the new discipline displayed

  Scenario: User provides no inputs
    When I do not fill out the form
    And I click on the Submit button
    Then I should get a warning message

  Scenario: User provides no Discipline name but provides the duration
    When I fill in the Discipline name field
    And I try and submit the only Discipline Name
    Then I should get a warning message

  Scenario: User provides no duration input but provides the Discipline name
    When I fill in the duration field
    And I try and submit duration
    Then I should get a warning message
