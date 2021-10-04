@course @addCourse
Feature:  AS A user I WANT to be able to add a new course SO THAT we can organise new courses for trainees

  Background:
    Given I am logged in
    And I go to the course page
    And I go to the add course page

    Scenario: User wants to add a course
      When I fill out the add Course form
      And I click the submit button on the add course page
      Then a new course with the information I entered should be added to the database on the course page

    @Disable
    Scenario: User sets a start date before the current date on the add course page
      When I try to set the start date before the current date on the add course page
      Then I should not be navigated back to the course page

    Scenario: User selects trainer ID on the add course page
      When I click the Trainer ID drop-down menu on the add course page
      Then I should only be able to choose trainers that exist within the trainers drop-down menu on the add course page

    @Disable
    Scenario: User enters a trainers start week and end week on the add course page
      When I select the time a trainer is teaching a course on the add course page
      Then the difference between the start week and the end week should not exceed the length of the course

    Scenario: User selects a course type on the add course page
      When I select a course type on the add course page
      Then I should only be allowed to choose a course type that exists within the course type drop-down menu on the add course page

    Scenario: User selects a location on the add course page
      When I select a location on the add course page
      Then I should only be allowed to choose a location that exists within the location drop-down menu on the add course page

    Scenario: User selects a discipline on the add course page
      When I select a discipline on the add course page
      Then I should only be allowed to choose a discipline that exists within the discipline drop-down menu on the add course page

    Scenario: User enters a number less than 1 for the number of trainers on the add course page
      When I enter the number of trainers for a course on the add course page
      Then I should get an alert saying "Sorry, the minimum value was reached" on the add course page

    Scenario: User enters a number more than 10 for the number of trainers on the add course page
      When I enter the number of trainers for a course on the add course page
      Then I should get an alert saying "Sorry, the maximum value was reached" on the add course page

    @Disable
    Scenario: User adds more than 1 trainers with the same ID on the add course page
      When I select a course to have more than 1 trainers on the add course page
      And I add the same Trainer ID more than once to the course on the add course page
      And I click the Submit Button on the add course page
      Then I should receive a message alerting me that the same trainer has been selected more than once and I should be prevented from submitting the form on the add course page

    #Scenario: User leaves the course name blank on the add course page
      #When I leave the Course Name Text Field blank on the add course page
      #And I click the Submit Button on the add course page
      #Then I should receive a message alerting me that the Course Name Text Field has been left blank and I should be prevented from submitting the form on the add course page