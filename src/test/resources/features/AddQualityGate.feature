@AddQualityGate
Feature: As A User I WANT to Add a new Quality to a trainee Gate Page SO THAT I Know they are client ready

  Background:
    Given I am starting the process
    And I am logged in
    And I go to the trainees page
    And I click the add Quality Gate button



  Scenario: get trainee id
    When user has entered trainee id
    Then check id has been entered


  Scenario: get Quality Gate Status(Failed)
    When user has entered Quality Gate Status(Failed)
    Then check Quality Gate Status has been entered(Failed)

#?????????????????????????????????????
  Scenario: get Quality Gate Status(Failed Needs help)
    When user has entered Quality Gate Status(Failed Needs help)
    Then check Quality Gate Status has been entered(Failed Needs help)
#?????????????????????????????????????

  Scenario: get Quality Gate Status(Passed)
    When user has entered Quality Gate Status(Passed)
    Then check Quality Gate Status has been entered(Passed)

  Scenario:get Trainer One Id
    When trainer id has been entered
    Then check trainer one's id has been entered correctly

  Scenario:get Trainer One Feedback
    When trainer one's Feedback has been entered
    Then check trainer one's Feedback has been entered correctly

  Scenario:get Trainer Two Id
    When trainer id has been entered
    Then check trainer two's id has been entered correctly

  Scenario:get Trainer Two Feedback
    When trainer two's Feedback has been entered
    Then check trainer two's Feedback has been entered correctly

  Scenario:get the Date
    When the date is added
    Then get the Date
#?????????????????????????????????????
  Scenario:is Trainer One Feedback Empty
    Then check trainer one's Feedback has been entered correctly
#?????????????????????????????????????


  Scenario:is Trainer Two Feedback Empty
    Then check trainer two's Feedback has been entered correctly
#?????????????????????????????????????


  Scenario:is Date Valid
    When the date is added
    Then check if Date is valid

  Scenario:is Date Empty
    When the date is added
    Then check if Date is empty

  Scenario:are All Fields Valid
    Then check the validity of all fields

  Scenario:are All Fields Empty
    Then check all fields are empty


  Scenario: Test click on Quality Gate button
    Then navigate to Quality Gate Page


