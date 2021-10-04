Feature: AS A user I WANT to remove locations SO THAT I can delete locations from the database that are no longer used by the company

  Background:

    Given I am logged in
    And I go to the centres page
    And there is dummy to delete
    When I click the delete location button

   Scenario: I click on a delete location button
    Then A dialog box should pop up asking if you are sure that you want to remove the Location

   Scenario: I confirm a deletion on the dialogue box
     And I confirm I want to delete the location
     Then The location is deleted

   Scenario: I decline a deletion on the dialogue box
     And I decline deleting the location
     Then The location is not deleted