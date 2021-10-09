@scheduler
Feature: AS A user after I sign in I WANT to see the scheduled courses SO THAT I can plan accordingly

  Background:
    Given I am starting the process
    And I am logged in

    Scenario: User logs in and is directed to Scheduler Page to see its information
      Then I should see all the scheduled courses that are on the scheduler page

    Scenario: User goes to Scheduler Page from different page to see Gantt Chart
      And I go to the course page
      When I go to the scheduler page
      Then I should see all the scheduled courses that are on the scheduler page

    Scenario: User goes to a page other than the Scheduler Page, shouldn't see any schedule information
      And I go to the account page
      Then I should NOT see all the scheduled courses that are on the scheduler page

    Scenario: User goes to scheduler page, check if required information is next to course name
      When I go to the scheduler page
      Then The schedule page should load with the visual representation with the correct data


