Feature: AS A user I WANT to remove locations SO THAT I can delete locations from the database that are no longer used by the company

  Background:

    Given I am starting the process
    And I am working with dummy data
    And I am logged in
    And I go to the locations page
    When I click the delete location button for Naboo

   Scenario: I click on a delete location button
    Then A dialog box should pop up asking if you are sure that you want to remove the Location

   Scenario: I confirm a deletion on the dialogue box
     And I confirm I want to delete the location
     Then The Naboo location is deleted

   Scenario: I decline a deletion on the dialogue box
     And I decline deleting the location
     Then The Naboo location is not deleted