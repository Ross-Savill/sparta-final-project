package com.spartaglobal.finalweek.cucumber.stepDefs.traineeStepDefs;

import com.spartaglobal.finalweek.pages.traineePages.AddTraineesPage;
import com.spartaglobal.finalweek.pages.traineePages.EditTraineesPage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class EditTraineeStepDefs {

    private TraineesPage traineesPage = new TraineesPage();
    private EditTraineesPage editTraineesPage;

    @And("I click the Edit Trainee Button for the first trainee on the Trainees page")
    public void iClickTheEditTraineeButtonForTheFirstTraineeOnTheTraineesPage() {
        editTraineesPage = traineesPage.clickEditTrainee("0row");
    }

    @Then("I can submit edits on the Edit Trainee page and have them save correctly")
    public void iCanSubmitEditsOnTheEditTraineePageAndHaveThemSaveCorrectly() {
        Assertions.assertTrue(editTraineesPage.isSubmitSuccessful("StepDef", "TestingMethod"));
    }

    @Then("I will be stopped from submitting a blank first name on the Edit Trainee page")
    public void iWillBeStoppedFromSubmittingABlankFirstNameOnTheEditTraineePage() {
        Assertions.assertFalse(editTraineesPage.isSubmitSuccessful("", "TestingMethod"));
    }

    @Then("I will be stopped from submitting a blank last name on the Edit Trainee page")
    public void iWillBeStoppedFromSubmittingABlankLastNameOnTheEditTraineePage() {
        Assertions.assertFalse(editTraineesPage.isSubmitSuccessful("StepDef", ""));
    }

    @Then("I will be stopped from submitting an invalid first name on the Edit Trainee page")
    public void iWillBeStoppedFromSubmittingAnInvalidFirstNameOnTheEditTraineePage() {
        Assertions.assertFalse(editTraineesPage.isSubmitSuccessful("StepDef%&", "TestingMethod"));
    }

    @Then("I will be stopped from submitting an invalid last name on the Edit Trainee page")
    public void iWilLbeStoppedFromSubmittingAnInvalidLastNameOnTheEditTraineePage() {
        Assertions.assertFalse(editTraineesPage.isSubmitSuccessful("StepDef", "TestingMethod%&"));
    }

    @After("@EditTraineesPage")
    public void tearDown(){
        webDriver.quit();
    }
}
