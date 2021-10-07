@TrainersPage
Feature: AS A User I WANT be able to view Edit Add and delete my trainers

  Background:
    Given I am starting the process
    Given I Want To reset the database

    And I am logged in
    And I go to the trainers page


  Scenario: getUrl
    Then get Url

  Scenario: get All Trainers First Name Elements
    Then get all the trainers firstName(elements)

  Scenario: get All Trainers Last Name Elements
    Then get all the trainers lastName(elements)


  Scenario: get All Trainer Elements
    Then get all the trainers(elements)

  Scenario: get All Trainer Colour Elements
    Then get all trainers colours(elements)


  Scenario: get All Trainers First Name
    Then get all trainers firstName

  Scenario: get All Trainers Last Name
    Then get all trainers lastName


  Scenario: get All Trainer Colour
    Then get all trainers colours


  Scenario:get Trainer First Name Element
    Then get trainer firstName(elements)


  Scenario:get Trainer Last Name Element
    Then get trainer lastName(elements)


  Scenario:get Trainer Colour Element
    Then get all trainers colours(elements)


  Scenario: get Trainer First Name
    Then get trainer firstName

  Scenario:  get Trainer Last Name
    Then get trainer lastName

  Scenario: get Trainer Colour
    Then get all trainers colours

  Scenario: click Add Trainer
    Then get add trainer Url


  Scenario: click Edit Trainer
    Then get edit trainer Url


  Scenario: click Delete Trainer
    Then get delete trainer Url

  Scenario: is Trainer First Name Valid
    Then check validity of first name

  Scenario:  is Trainer Last Name Valid
    Then check validity of last name


  Scenario:  are All Trainers First Names Valid
    Then check validity of all first names


  Scenario:  are All Trainers Last Names Valid
    Then check validity of all last names


  Scenario:  are All Colours Unique
    Then check if all colours are unique


  Scenario: find by Trainer Name
    Then check trainer name is found


  Scenario:  are All Fields Passed On To Edit Trainers Page
    Then check fields are passed

  Scenario:  submitTrainerByRow
    Given  I am on the trainer page
    When edit is clicked
    Then check if trainer data is passed to the new page

  Scenario: does Confirmation Box Appear On Delete
    Then check deletion popup

  Scenario: confirm Delete
    Then check deletion popup is clicked

  Scenario: cancel Delete
    Then check cancellation popup


