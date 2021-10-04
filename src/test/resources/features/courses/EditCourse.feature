@course @editCourse
Feature:  AS A user I WANT to be able to edit a new course SO THAT we can organise new courses for trainees

  Background:
    Given I am logged in
    And I go to the course page
    And I go to the edit course page

    Scenario: User checks if the correct course information is transferred on the edit course page
      When I check the course information
      Then Course information should be transferred

    Scenario: User wants to edits the information for a course on the edit course page
      When I edit the information about a course
      And I click submit button on the edit course page
      And I go to the course page
      Then The course information should be updated

    Scenario: User enters a start date before the current date on the edit course page
      When I try to set the start date before the current date on the edit course page
      Then I should not be navigated back to the course page

    Scenario: User selects a trainer ID on the edit course page
      When I click the Trainer ID drop-down menu on the edit course page
      Then I should only be able to choose trainers that exist within the trainers drop-down menu on the edit course page
  
    Scenario: User sets a trainers start week and end week on the edit course page
      When I select the time a trainer is teaching a course on the edit course page
      Then the difference between the start week and the end week should not exceed the length of the course
  
    Scenario: User selects a course type on the edit course page
      When I select a course type on the edit course page
      Then I should only be allowed to choose a course type that exists within the course type drop-down menu on the edit course page

    Scenario: User selects a location on the edit course page
      When I select a location
      Then I should only be allowed to choose a location that exists within the location drop-down menu on the edit course page

    Scenario: User selects a discipline on the edit course page
      When I select a discipline on the edit course page
      Then I should only be allowed to choose a discipline that exists within the discipline drop-down menu on the edit course page

    Scenario: User enters a number less than 1 for the number of trainers on the edit course page
      When I enter the number of trainers for a course on the edit course page
      Then I should get an alert saying "Sorry, the minimum value was reached" on the edit course page

    Scenario: User enters a number more than 10 for the number of trainers on the edit course page
      When I enter the number of trainers for a course on the edit course page
      Then I should get an alert saying "Sorry, the maximum value was reached" on the edit course page

    @Disable
    Scenario: User adds more than 1 trainers with the same ID on the edit course page
      When I select a course to have more than 1 trainers on the edit course page
      And I add the same Trainer ID more than once to the course on the edit course page
      And I click the Submit Button on the edit course page
      Then I should receive a message alerting me that the same trainer has been selected more than once and I should be prevented from submitting the form on the edit course page