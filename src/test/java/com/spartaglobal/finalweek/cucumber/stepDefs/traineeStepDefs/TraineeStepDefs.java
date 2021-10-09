package com.spartaglobal.finalweek.cucumber.stepDefs.traineeStepDefs;

import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.traineePages.AddTraineesPage;
import com.spartaglobal.finalweek.pages.traineePages.EditTraineesPage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class TraineeStepDefs {

    private TraineesPage traineesPage = new TraineesPage();
    private NavTemplate navTemplate = new NavTemplate();
    private int numberOfTraineesBeforeDelete;
    private EditTraineesPage editTraineesPage;
    private AddTraineesPage addTraineesPage;
    private String topRowFirstName;
    private String topRowLastName;
    private String courseName;
    private int preFilterTraineeRowsNum;

    @Then("I can see relevant valid information relating to trainees on the Trainee Page")
    public void iCanSeeRelevantValidInformationRelatingToTraineesOnTheTraineePage() {
        Assertions.assertTrue(traineesPage.areAllTraineesFirstNamesValid() &&
                                       traineesPage.areAllTraineesLastNamesValid() &&
                                       traineesPage.areAllQualityGateStatusValid());
    }
    @When("I click the delete button next to the trainee I want to delete on the Trainee page")
    public void iClickTheDeleteButtonNextToTheTraineeIWantToDeleteOnTheTraineePage() {
        numberOfTraineesBeforeDelete = traineesPage.getAllTraineesFirstNames().size();
        traineesPage.clickDeleteTrainee("0row");
    }

    @And("I am shown a dialogue box to delete or cancel my choice on the Trainee Page")
    public void iAmShownADialogueBoxToDeleteOrCancelMyChoiceOnTheTraineePage() {
        Assertions.assertTrue(traineesPage.doesConfirmationBoxAppearOnDelete());
    }

    @And("I chose to cancel my deletion of a trainee on the Trainee Page")
    public void iChoseToCancelMyDeletionOfATraineeOnTheTraineePage() {
        Assertions.assertTrue(traineesPage.cancelDelete());
    }

    @Then("The trainee will not be deleted from the Trainee Page")
    public void theTraineeWillNotBeDeletedFromTheTraineePage() {
        traineesPage = navTemplate.goToTraineesPage();
        int numberOfTraineesAfterDelete = traineesPage.getAllTraineesFirstNames().size();
        Assertions.assertTrue(numberOfTraineesBeforeDelete == numberOfTraineesAfterDelete);
    }

    @And("I choose to confirm that I want to delete my trainee from the Trainee Page")
    public void iChooseToConfirmThatIWantToDeleteMyTraineeFromTheTraineePage() {
        Assertions.assertTrue(traineesPage.confirmDelete());
    }

    @Then("The trainee will be deleted when I return to the Trainee Page")
    public void theTraineeWillBeDeletedWhenIReturnToTheTraineePage() {
        traineesPage = navTemplate.goToTraineesPage();
        int numberOfTraineesAfterDelete = traineesPage.getAllTraineesFirstNames().size();
        Assertions.assertTrue(numberOfTraineesBeforeDelete == (numberOfTraineesAfterDelete - 1));
    }

    @When("I click the edit button next to a particular trainee on the Trainee Page")
    public void iClickTheEditButtonNextToAParticularTraineeOnTheTraineePage() {
        topRowFirstName = traineesPage.getTraineeFirstName("0row");
        topRowLastName = traineesPage.getTraineeLastName("0row");
        traineesPage.getTraineeLastName("0row");
        editTraineesPage = traineesPage.clickEditTrainee("0row");
    }

    @Then("I will be taken to the Edit Trainee Page and see the data has carried across ready to edit")
    public void iWillBeTakenToTheEditTraineePageAndSeeTheDataHasCarriedAcrossReadyToEdit() {
        Assertions.assertTrue(editTraineesPage.getFirstName().equals(topRowFirstName) &&
                                       editTraineesPage.getLastName().equals(topRowLastName));
    }

    @When("I click the add button at the top of the Trainee Page")
    public void iClickTheAddButtonAtTheTopOfTheTraineePage() {
        addTraineesPage = traineesPage.clickAddTrainee();
    }

    @Then("I will be taken to the Add Trainee Page from the Trainee Page")
    public void iWillBeTakenToTheAddTraineePageFromTheTraineePage() {
        Assertions.assertEquals("http://localhost:8080/addTrainee", webDriver.getCurrentUrl());
    }

    @When("I click a course via the course filter on the Trainee Page")
    public void iClickACourseViaTheCourseFilterOnTheTraineePage() {
        preFilterTraineeRowsNum = traineesPage.getAllTraineesFirstNames().size();
        courseName = "Engineering 87";
        traineesPage.applyCourseFilter(courseName);
    }

    @Then("The course name will be appended to the Trainee Page URL")
    public void theCourseNameWillBeAppendedToTheTraineePageURL() {
        Assertions.assertEquals(webDriver.getCurrentUrl().replaceAll("%20",""), traineesPage.filterAppliedURL);
    }

    @And("The Trainee Page will have filtered results")
    public void theTraineePageWillHaveFilteredResults() {
        Assertions.assertTrue(traineesPage.getAllTraineesFirstNames().size() < preFilterTraineeRowsNum);
    }

    @After("@TraineePage")
    public void tearDown(){
        webDriver.quit();
    }

}
