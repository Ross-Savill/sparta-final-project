package com.spartaglobal.finalweek.cucumber.stepDefs.traineeStepDefs;

import com.spartaglobal.finalweek.pages.traineePages.AddTraineesPage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddTraineeStepDef {

    private TraineesPage traineesPage = new TraineesPage();
    private AddTraineesPage addTraineesPage;


    @And("I click on the Add Trainee Button")
    public void iClickOnTheAddTraineeButton() {
        addTraineesPage = traineesPage.clickAddTrainee();
    }

    @When("I enter a trainee first name, last name and course on the Add Trainee page")
    public void iEnterATraineeFirstNameLastNameAndCourseOnTheAddTraineePage() {
        addTraineesPage.enterFirstName("StepDef");
        addTraineesPage.enterLastName("FeatureTest");
    }

    @And("I click the submit button on the Add Trainee page")
    public void iClickTheSubmitButtonOnTheAddTraineePage() {
        addTraineesPage.submitTrainee();
    }

    @Then("I should find my trainee present on the Trainee Page")
    public void iShouldFindMyTraineePresentOnTheTraineePage() {
        traineesPage = addTraineesPage.goToTraineesPage();
        Assert.assertTrue(traineesPage.isTraineePresent("StepDef", "FeatureTest"));
    }

    @When("I forget to enter a first name but enter a last name on the Add Trainee page")
    public void iForgetToEnterAFirstNameButEnterALastNameOnTheAddTraineePage() {
        addTraineesPage.enterFirstName("");
        addTraineesPage.enterLastName("FeatureTest");
    }

    @When("I forget to enter a last name but enter a first name on the Add Trainee page")
    public void iForgetToEnterALastNameButEnterAFirstNameOnTheAddTraineePage() {
        addTraineesPage.enterFirstName("StepDef");
        addTraineesPage.enterLastName("");
    }

    @When("I enter an invalid first name and correct last name on the Add Trainee page")
    public void iEnterAnInvalidFirstNameAndCorrectLastNameOnTheAddTraineePage() {
        addTraineesPage.enterFirstName("StepDef%&");
        addTraineesPage.enterLastName("FeatureTest");
    }

    @When("I enter a correct first name and an invalid last name on the Add Trainee page")
    public void iEnterACorrectFirstNameAndAnInvalidLastNameOnTheAddTraineePage() {
        addTraineesPage.enterFirstName("StepDef");
        addTraineesPage.enterLastName("FeatureTest%&");
    }

    @Then("I should be stopped from submitting the Add Trainee page")
    public void iShouldBeStoppedFromSubmittingTheAddTraineePage() {
        Assert.assertTrue(!addTraineesPage.getFirstName().equals("") || !addTraineesPage.getLastName().equals(""));
    }

    @After("@AddTraineesPage")
    public void tearDown(){
        webDriver.quit();
    }
}
