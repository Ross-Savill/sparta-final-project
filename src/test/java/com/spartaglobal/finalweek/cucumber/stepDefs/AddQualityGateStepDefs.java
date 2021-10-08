


package com.spartaglobal.finalweek.cucumber.stepDefs;

import com.spartaglobal.finalweek.pages.traineePages.AddQualityGatePage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddQualityGateStepDefs {
    TraineesPage traineesPage = new TraineesPage();
    AddQualityGatePage addQualityGatePage;
    String[] arr;
    ArrayList<String> trainerIds;

    @After("@AddQualityGate")
    public void tearDown() {
        webDriver.quit();
    }

    @And("I click the add Quality Gate button")
    public void iClickTheAddQualityGateButton() {
        addQualityGatePage = traineesPage.clickAddQualityGate("0row");
    }


    @Then("navigate to Quality Gate Page")
    public void navigateToQualityGatePage() {
        Assertions.assertTrue(addQualityGatePage.getURL().contains("http://localhost:8080/addQualityGate"));
    }


    @When("user has entered trainee id")
    public void userHasEnteredTraineeId() {
        addQualityGatePage.enterTraineeId(1);

    }

    @Then("check id has been entered")
    public void checkIdHasBeenEntered() {
        Assertions.assertEquals(1, addQualityGatePage.getTraineeId());
    }


    @When("trainer id has been entered")
    public void trainerOneSIdHasBeenEntered() {
        arr = new String[]{"Aayla Secura", "Mike Wazowski", "JarJar Binks"
                , "Kit Fisto", "Mace Windu", "Ki-adi Mundi", "Luminara Unduli", "Plo Koon", "Eeth Koth", "Adi Gallia"
                , "Ima-gun Di", "Qui-gon Jinn", "Obi-Wan Kenobi", "Sheev Palpatine"};
        trainerIds = new ArrayList<>(Arrays.asList(arr));

    }

    @Then("check trainer one's id has been entered correctly")
    public void checkTrainerOneSIdHasBeenEnteredCorrectly() {
        Assertions.assertTrue(trainerIds.contains(addQualityGatePage.getTrainerOneId().getText()));

    }

    @When("trainer one's Feedback has been entered")
    public void trainerOneSFeedbackHasBeenEntered() {
        addQualityGatePage.enterTrainerOneFeedback("feedback123");

    }

    @Then("check trainer one's Feedback has been entered correctly")
    public void checkTrainerOneSFeedbackHasBeenEnteredCorrectly() {

        Assertions.assertEquals("feedback123", addQualityGatePage.getTrainerOneFeedback().getAttribute("value"));

    }

    @Then("check trainer one's Feedback is empty")
    public void checkTrainerOneSFeedbackIsEmpty() {

        Assertions.assertEquals("", addQualityGatePage.getTrainerOneFeedback().getAttribute("value"));

    }
    @Then("check trainer two's Feedback is empty")
    public void checkTrainerTwoSFeedbackIsEmpty() {

        Assertions.assertEquals("", addQualityGatePage.getTrainerOneFeedback().getAttribute("value"));

    }


    @Then("check trainer two's id has been entered correctly")
    public void checkTrainerTwoSIdHasBeenEnteredCorrectly() {
        Assertions.assertTrue(trainerIds.contains(addQualityGatePage.getTrainerOneId().getText()));

    }

    @When("trainer two's Feedback has been entered")
    public void trainerTwoSFeedbackHasBeenEntered() {
        addQualityGatePage.enterTrainerTwoFeedback("feedback123");

    }

    @Then("check trainer two's Feedback has been entered correctly")
    public void checkTrainerTwoSFeedbackHasBeenEnteredCorrectly() {
        Assertions.assertEquals("feedback123", addQualityGatePage.getTrainerTwoFeedback().getAttribute("value"));
    }

    @When("the date is added")
    public void theDateIsAdded() {
        addQualityGatePage.setDate(LocalDate.now());

    }

    @Then("get the Date")
    public void getTheDate() {
        Assertions.assertNotNull(addQualityGatePage.getDate());
    }

    @Then("check if Date is valid")
    public void checkIfDateIsValid() {
        Assertions.assertFalse(addQualityGatePage.isDateValid(addQualityGatePage.getDate().getAttribute("value")));
    }

    @Then("check if Date is empty")
    public void checkIfDateIsEmpty() {
        Assertions.assertTrue(addQualityGatePage.isDateEmpty());
    }

    @Then("check the validity of all fields")
    public void checkTheValidityOfAllFields() {
        Assertions.assertFalse(addQualityGatePage.areAllFieldsValid());

    }

    @Then("check all fields are empty")
    public void checkAllFieldsAreEmpty() {
        Assertions.assertFalse(addQualityGatePage.areAllFieldsEmpty());
    }

    @When("user has entered Quality Gate Status\\(Failed)")
    public void userHasEnteredQualityGateStatusFailed() {
        addQualityGatePage.setQualityGateStatus("Failed");


    }

    @Then("check Quality Gate Status has been entered\\(Failed)")
    public void checkQualityGateStatusHasBeenEnteredFailed() {
        Assertions.assertEquals("Failed", addQualityGatePage.getQualityGateStatus());

    }

    @When("user has entered Quality Gate Status\\(Failed Needs help)")
    public void userHasEnteredQualityGateStatusFailedNeedsHelp() {
        addQualityGatePage.setQualityGateStatus("Failed needs help");

    }

    @Then("check Quality Gate Status has been entered\\(Failed Needs help)")
    public void checkQualityGateStatusHasBeenEnteredFailedNeedsHelp() {
        Assertions.assertEquals("Failed needs help", addQualityGatePage.getQualityGateStatus());
    }

    @When("user has entered Quality Gate Status\\(Passed)")
    public void userHasEnteredQualityGateStatusPassed() {
        addQualityGatePage.setQualityGateStatus("Passed");

    }

    @Then("check Quality Gate Status has been entered\\(Passed)")
    public void checkQualityGateStatusHasBeenEnteredPassed() {
        Assertions.assertEquals("Passed", addQualityGatePage.getQualityGateStatus());

    }
}

