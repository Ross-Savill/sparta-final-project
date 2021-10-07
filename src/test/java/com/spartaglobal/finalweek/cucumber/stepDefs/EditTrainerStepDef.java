package com.spartaglobal.finalweek.cucumber.stepDefs;

import com.spartaglobal.finalweek.pages.trainersPages.EditTrainersPage;
import com.spartaglobal.finalweek.pages.trainersPages.TrainersPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class EditTrainerStepDef {
    private TrainersPage trainersPage = new TrainersPage();
    private EditTrainersPage editTrainersPage;

    @And("I click on the Edit Trainer Button")
    public void iClickOnTheEditTrainerButton() {
        editTrainersPage = trainersPage.clickEditTrainer();
    }

    @When("I enter a trainer first name, last name and course on the Edit Trainer page")
    public void iEnterATraineeFirstNameLastNameAndCourseOnTheEditTrainerPage() {
        editTrainersPage.enterFirstName("StepDef");
        editTrainersPage.enterLastName("FeatureTest");
    }

    @And("I click the submit button on the Edit Trainer page")
    public void iClickTheSubmitButtonOnTheEditTrainerPage() {
        editTrainersPage.submitTrainer();
    }

    @When("I forget to enter a first name but enter a last name on the Edit Trainer page")
    public void iForgetToEnterAFirstNameButEnterALastNameOnTheEditTrainerPage() {
        editTrainersPage.enterFirstName("");
        editTrainersPage.enterLastName("FeatureTest");
    }

    @When("I forget to enter a last name but enter a first name on the Edit Trainer page")
    public void iForgetToEnterALastNameButEnterAFirstNameOnTheEditTrainerPage() {
        editTrainersPage.enterFirstName("StepDef");
        editTrainersPage.enterLastName("");
    }

    @When("I enter an invalid first name and correct last name on the Edit Trainer page")
    public void iEnterAnInvalidFirstNameAndCorrectLastNameOnTheEditTrainerPage() {
        editTrainersPage.enterFirstName("StepDef%&");
        editTrainersPage.enterLastName("FeatureTest");
    }

    @When("I enter a correct first name and an invalid last name on the Edit Trainer page")
    public void iEnterACorrectFirstNameAndAnInvalidLastNameOnTheEditTrainerPage() {
        editTrainersPage.enterFirstName("StepDef");
        editTrainersPage.enterLastName("FeatureTest%&");
    }
    @When("I enter a trainer first name, last name and colour on the Edit Trainer page")
    public void iEnterATrainerFirstNameLastNameAndColourOnTheEditTrainerPage() {
        editTrainersPage.enterFirstName("StepDef");
        editTrainersPage.enterLastName("FeatureTest");
        editTrainersPage.setColour();
    }

    @Then("I should be stopped from submitting the Edit Trainer page")
    public void iShouldBeStoppedFromSubmittingTheEditTrainerPage() {
        Assertions.assertFalse(editTrainersPage.isSubmitSuccessful());
    }

    @After("@AddTrainersPage")
    public void tearDown(){
        webDriver.quit();
    }
}
