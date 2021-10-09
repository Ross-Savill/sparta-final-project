package com.spartaglobal.finalweek.cucumber.stepDefs;

import com.spartaglobal.finalweek.pages.trainersPages.EditTrainersPage;
import com.spartaglobal.finalweek.pages.trainersPages.TrainersPage;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class TrainersStepDefs {

    TrainersPage trainersPage = new TrainersPage();
    private EditTrainersPage editTrainersPage;
    private String trainerName;
    String editTrainerName;



    @After("@TrainersPage")
    public void tearDown() {
        webDriver.quit();
    }


    @Then("get Url")
    public void getUrl() {
        Assertions.assertEquals("http://localhost:8080/trainerPage", trainersPage.getURL());
    }

    @Then("get all the trainers firstName\\(elements)")
    public void getAllTheTrainersFirstNameElements() {
        Assertions.assertEquals(14, trainersPage.getAllTrainersFirstNameElements().size());
    }

    @Then("get all the trainers lastName\\(elements)")
    public void getAllTheTrainersLastNameElements() {        Assertions.assertEquals(14, trainersPage.getAllTrainersLastNameElements().size());


    }

    @Then("get all the trainers\\(elements)")
    public void getAllTheTrainersElements() {
        Assertions.assertEquals(15, trainersPage.getAllTrainerElements().size());

    }

    @Then("get all trainers colours\\(elements)")
    public void getAllTrainersColoursElements() {
        Assertions.assertEquals(14, trainersPage.getAllTrainerColourElements().size());

    }

    @Then("get all trainers firstName")
    public void getAllTrainersFirstName() {
        Assertions.assertEquals(14, trainersPage.getAllTrainersFirstName().size());

    }

    @Then("get all trainers lastName")
    public void getAllTrainersLastName() {
        Assertions.assertEquals(14, trainersPage.getAllTrainersLastName().size());

    }

    @Then("get all trainers colours")
    public void getAllTrainersColours() {
        Assertions.assertEquals(14, trainersPage.getAllTrainerColour().size());

    }

    @Then("get trainer firstName\\(elements)")
    public void getTrainerFirstNameElements() {
        Assertions.assertEquals("Aayla", trainersPage.getTrainerFirstNameElement(0).getText());
    }

    @Then("get trainer lastName\\(elements)")
    public void getTrainerLastNameElements() {
        Assertions.assertEquals("Secura", trainersPage.getTrainerLastNameElement(0).getText());

    }

    @Then("get trainer firstName")
    public void getTrainerFirstName() {
        Assertions.assertEquals("Aayla", trainersPage.getTrainerFirstName(0));

    }

    @Then("get trainer lastName")
    public void getTrainerLastName() {
        Assertions.assertEquals("Secura", trainersPage.getTrainerLastName(0));
    }

    @Then("get add trainer Url")
    public void getAddTrainerUrl() {
        Assertions.assertEquals("http://localhost:8080/addTrainer", trainersPage.clickAddTrainer().getURL());

    }

    @Then("get edit trainer Url")
    public void getEditTrainerUrl() {
        String url = trainersPage.clickEditTrainer().getURL();
        Assertions.assertEquals("http://localhost:8080/editTrainer", url.substring(0, url.length() - 2));
    }

    @Then("get delete trainer Url")
    public void getDeleteTrainerUrl() {
        trainersPage.getAllTrainersFirstName().clear();
        trainersPage.deleteTrainer();
        Assertions.assertEquals(12, trainersPage.getAllTrainersFirstName().size() - 1);
    }

    @Then("check validity of first name")
    public void checkValidityOfFirstName() {
        Assertions.assertTrue(trainersPage.isTrainerFirstNameValid(0));

    }

    @Then("check validity of last name")
    public void checkValidityOfLastName() {
        Assertions.assertTrue(trainersPage.isTrainerLastNameValid(0));

    }

    @Then("check validity of all first names")
    public void checkValidityOfAllFirstNames() {
        Assertions.assertTrue(trainersPage.areAllTrainersFirstNamesValid("trainer-firstname"));

    }

    @Then("check validity of all last names")
    public void checkValidityOfAllLastNames() {
        Assertions.assertTrue(trainersPage.areAllTrainersLastNamesValid("trainer-lastname"));
    }

    @Then("check if all colours are unique")
    public void checkIfAllColoursAreUnique() {
        Assertions.assertTrue(trainersPage.areAllColoursUnique());
    }

    @Then("check trainer name is found")
    public void checkTrainerNameIsFound() {
        Assertions.assertEquals(1, trainersPage.findByTrainerName("Mike", "Wazowski") - 1);

    }

    @Then("check fields are passed")
    public void checkFieldsArePassed() {
        Assertions.assertTrue(trainersPage.areAllFieldsPassedOnToEditTrainersPage());
    }

    @Given("I am on the trainer page")
    public void iAmOnTheTrainerPage() {
         trainerName = trainersPage.getTrainerFirstName(0) + " + " + trainersPage.getTrainerLastName(0);
    }

    @When("edit is clicked")
    public void editIsClicked() {
        editTrainersPage = trainersPage.submitTrainerByRow(1);
         editTrainerName = editTrainersPage.getFirstName() + " + " + editTrainersPage.getLastName();
    }

    @Then("check if trainer data is passed to the new page")
    public void checkIfTrainerDataIsPassedToTheNewPage() {
        Assertions.assertEquals(trainerName, editTrainerName);

    }

    @Then("check deletion popup")
    public void checkDeletionPopup() {
        Assertions.assertTrue(trainersPage.doesConfirmationBoxAppearOnDelete());

    }

    @Then("check deletion popup is clicked")
    public void checkDeletionPopupIsClicked() {
        Assertions.assertTrue(trainersPage.confirmDelete());

    }

    @Then("check cancellation popup")
    public void checkCancellationPopup() {
        Assertions.assertTrue(trainersPage.cancelDelete());

    }

    @Given("I Want To reset the database")
    public void iWantToResetTheDatabase() {
        ResetData.resetData();
    }
}
