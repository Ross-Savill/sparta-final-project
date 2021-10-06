@TraineePage
  Feature: AS A User I WANT to be able to view trainee data on the Trainees Page SO THAT I can make decisions based on that

  Background:
  Given I am working with dummy data
  And I am starting the process
  And I am logged in
  And I go to the trainees page

  Scenario: User wants to see trainee information listed on the Trainees Page
  Then I can see relevant valid information relating to trainees on the Trainee Page

    Scenario: I initially want to delete a trainee from the system but then cancel my choice
      When I click the delete button next to the trainee I want to delete on the Trainee page
      And I am shown a dialogue box to delete or cancel my choice on the Trainee Page
      And I chose to cancel my deletion of a trainee on the Trainee Page
      Then The trainee will not be deleted from the Trainee Page

    Scenario: I want to delete a trainee from the system and choose to delete them
      When I click the delete button next to the trainee I want to delete on the Trainee page
      And I am shown a dialogue box to delete or cancel my choice on the Trainee Page
      And I choose to confirm that I want to delete my trainee from the Trainee Page
      Then The trainee will be deleted when I return to the Trainee Page

    Scenario: I want to be taken to an edit Trainee page so that I can edit a particular trainee
      When I click the edit button next to a particular trainee on the Trainee Page
      Then I will be taken to the Edit Trainee Page and see the data has carried across ready to edit

    Scenario: I want to be taken to an Add Trainee page so that I can add a new trainee
      When I click the add button at the top of the Trainee Page
      Then I will be taken to the Add Trainee Page from the Trainee Page

    Scenario: I want to filter the list of trainees on the Trainees page by course
      When I click a course via the course filter on the Trainee Page
      Then The course name will be appended to the Trainee Page URL
      And The Trainee Page will have filtered results

