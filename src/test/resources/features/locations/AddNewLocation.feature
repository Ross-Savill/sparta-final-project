Feature: AS A user I WANT to add new locations SO THAT we can expand the business

  Background:
    Given I am logged in
    And I click on the locations page
    And I click on the Add Location button

  Scenario: I want to add a new location
    When I fill in the location form
    And I click the Submit button on the Add Location page
    Then A new location with the information I added should be added

  Scenario: I enter a value in the Rooms field
    When I enter a value the number of rooms
    Then that value must be numeric

  Scenario: I have not entered a location name
    When I have only entered a room number
    And I click the Submit button on the Add Location page
    Then The submission on the add page should fail

  Scenario: I have not entered a number of rooms
    When I have only entered a location name
    And I click the Submit button on the Add Location page
    Then The submission on the add page should fail

    Scenario: I have not entered information in either field
      When I click the Submit button on the Add Location page
      Then The submission on the add page should fail

    Scenario: I enter a location name that already exists
      When I enter a location name that already exists
      And I enter a value the number of rooms
      Then The submission on the add page should fail