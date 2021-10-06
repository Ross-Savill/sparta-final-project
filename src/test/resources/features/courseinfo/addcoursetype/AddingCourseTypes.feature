Feature: AS A User, I WANT be able to add a new course type successfully SO THAT I can update add/update the website
  Background:
    Given I am using dummy data
    And I am starting the process
    And I am logged in
    And I go to the course info page
    And I click the Add Course Type Button

    Scenario: User wants to add a valid course type name
      When I enter a valid name into the course type name field
      And I click the submit button on the Add Course Type page
      Then I should be returned to the course type page and The new course type should be added

    Scenario: User does not input a course type name
      When I enter no data into the course type name field
      And I click the submit button on the Add Course Type page
      Then I should be stopped from adding an empty course type name.

    Scenario: User attempts to add a duplicate course type
      When I enter a duplicate name into the course type name field
      And I click the submit button on the Add Course Type page
      Then I should be stopped from adding a duplicate course name.
