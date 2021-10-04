Feature: AS A user I WANT to edit locations SO THAT we can expand the business

  Background:
    Given I am logged in
    And I click on the locations page

    Scenario: I click on edit for a location
      When I click on an Edit Location button for the {string} location
      Then I am navigated to a form with the information from the Location already filled in

    Scenario: I edit the details of a location
      When I click on an Edit Location button for the {string} location
      And I change information about the location
      And I click the Update button on the Edit Location page
      Then The information on the table should be updated to reflect the information I entered

    Scenario: I try to remove a location name
      When I remove the locations name
      And I click the Update button on the Edit Location page
      Then I should receive an error on the Edit Location page
      And The list of locations should not update

    Scenario: I try to remove a locations rooms
      When I remove the number of rooms
      And I click the Update button on the Edit Location page
      Then I should receive an error on the Edit Location page
      And The list of locations should not update

    Scenario: I enter a non numeric value in the rooms field
      When I enter a non numeric value in the rooms field
      And I click the Update button on the Edit Location page
      Then I should receive an error about the value being non numeric on the edit page
      And The list of locations should not update

      Scenario: I delete a location from the edit location page
        When I click delete on the Delete button on the edit page
        Then I should be returned to the centres page
        And The list of locations should no longer have the centre I want to delete