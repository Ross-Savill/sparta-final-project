package com.spartaglobal.finalweek.cucumber.stepDefs;
import com.spartaglobal.finalweek.pages.trainersPages.AddTrainersPage;
import com.spartaglobal.finalweek.pages.trainersPages.TrainersPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddTrainerStepDef {

    private TrainersPage trainersPage = new TrainersPage();
    private AddTrainersPage addTrainersPage;


    @And("I click on the Add Trainer Button")
    public void iClickOnTheAddTrainerButton() {
        addTrainersPage = trainersPage.clickAddTrainer();
    }

    @When("I enter a trainer first name, last name and course on the Add Trainer page")
    public void iEnterATraineeFirstNameLastNameAndCourseOnTheAddTrainerPage() {
        addTrainersPage.enterFirstName("StepDef");
        addTrainersPage.enterLastName("FeatureTest");
    }

    @And("I click the submit button on the Add Trainer page")
    public void iClickTheSubmitButtonOnTheAddTrainerPage() {
        addTrainersPage.submitTrainer();
    }

    @Then("I should find my trainer present on the Trainer Page")
    public void iShouldFindMyTrainerPresentOnTheTraineePage() {
        trainersPage = addTrainersPage.goToTrainersPage();
        Assertions.assertNotEquals(-1,trainersPage.findByTrainerName("StepDef", "FeatureTest"));
    }

    @When("I forget to enter a first name but enter a last name on the Add Trainer page")
    public void iForgetToEnterAFirstNameButEnterALastNameOnTheAddTrainerPage() {
        addTrainersPage.enterFirstName("");
        addTrainersPage.enterLastName("FeatureTest");
    }

    @When("I forget to enter a last name but enter a first name on the Add Trainer page")
    public void iForgetToEnterALastNameButEnterAFirstNameOnTheAddTrainerPage() {
        addTrainersPage.enterFirstName("StepDef");
        addTrainersPage.enterLastName("");
    }

    @When("I enter an invalid first name and correct last name on the Add Trainer page")
    public void iEnterAnInvalidFirstNameAndCorrectLastNameOnTheAddTrainerPage() {
        addTrainersPage.enterFirstName("StepDef%&");
        addTrainersPage.enterLastName("FeatureTest");
    }

    @When("I enter a correct first name and an invalid last name on the Add Trainer page")
    public void iEnterACorrectFirstNameAndAnInvalidLastNameOnTheAddTrainerPage() {
        addTrainersPage.enterFirstName("StepDef");
        addTrainersPage.enterLastName("FeatureTest%&");
    }

    @When("I click the color picker and input a new colour")
    public void iChangeTheColourOfTheTrainerOnTheAddTrainerPage() {
        addTrainersPage.enterFirstName("StepDef");
        addTrainersPage.enterLastName("FeatureTest");
        addTrainersPage.setColour();
    }
    @Then("I should be stopped from submitting the Add Trainer page")
    public void iShouldBeStoppedFromSubmittingTheAddTrainerPage() {
        Assertions.assertFalse(addTrainersPage.isSubmitSuccessful());
    }

    @After("@AddTrainersPage")
    public void tearDown(){
        webDriver.quit();
    }


}
