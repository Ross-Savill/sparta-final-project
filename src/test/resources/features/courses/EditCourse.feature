@course @editCourse
Feature:  AS A user I WANT to be able to edit a new course SO THAT we can organise new courses for trainees

  Background:
    Given I am starting the process
    And I am logged in
    And I go to the course page
    And I go to the edit course page

    Scenario: User wants to edit the information for a course on the edit course page
        When I edit the information about a course on the edit course page
        And I click submit button on the edit course page
        Then The course information should be updated

    @ignore
    Scenario: User enters a start date before the current date on the edit course page
      When I try to set the start date before the current date on the edit course page
      Then I should not be navigated back to the course page from the edit course page
    @ignore
    Scenario: User selects a trainer ID on the edit course page
      When I select the Trainer ID drop-down menu on the edit course page
      Then I should only be able to choose trainers that exist within the trainers drop-down menu on the edit course page

    Scenario: User sets a trainers start week and end week on the edit course page
      When I select the time a trainer is teaching a course on the edit course page
      Then the difference between the start week and the end week should not exceed the length of the course on the edit course page

    Scenario: User selects a course type on the edit course page
      When I select a course type on the edit course page
      Then I should only be allowed to choose a course type that exists within the course type drop-down menu on the edit course page

    Scenario: User selects a location on the edit course page
      When I select a location on the edit course page
      Then I should only be allowed to choose a location that exists within the location drop-down menu on the edit course page

  Scenario Outline: User enters a number more than 10 or less than 0 for the number of trainers on the edit course page
    When I enter the <numOfTrainers> of trainers for a course on the edit course page
    Then I should get an alert saying <errorMsg> on the edit course page
    Examples:
      |errorMsg                              | |numOfTrainers|
      |"Sorry, the maximum value was reached"| |11|
      |"Sorry, the minimum value was reached"| |0|

  @ignore
  Scenario Outline: User adds more than 1 trainers with the same ID on the edit course page
    # TODO: Error, duplicate trainer ids when there is more than 1 trainer id already when entering the edit course page
    When I select the same <trainerID> on the edit course page twice
    And I fill the <courseName> on course name field on the edit course page
    And I fill the start date with today's date on the edit course page
    Then I should be prevented from submitting the form on the edit course page
      #TODO: Feature not implemented
      #And I should receive a message alerting me that the same trainer has been selected more than once

    Examples:
      |trainerID     |courseName   |
      |"JarJar Binks"|"Test Course"|

  Scenario: User leaves the course name blank on the edit course page
    Then I should be prevented from submitting the form on the edit course page
      #TODO: Unable to get warning message from course name text field.
      #And I should receive a message warning me that the Course Name Text Field has been left blank