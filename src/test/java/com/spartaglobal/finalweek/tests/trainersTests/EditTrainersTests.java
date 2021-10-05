package com.spartaglobal.finalweek.tests.trainersTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.trainersPages.AddTrainersPage;
import com.spartaglobal.finalweek.pages.trainersPages.EditTrainersPage;
import com.spartaglobal.finalweek.pages.trainersPages.TrainersPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

public class EditTrainersTests extends NavTemplate {

    private TrainersPage trainersPage;
    private EditTrainersPage editTrainersPage;
    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();

        trainersPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToTrainersPage();
        editTrainersPage = trainersPage.clickEditTrainer();
    }

    @Test
    @DisplayName("Check First and Last name is populated")
    void checkNameIsEmpty() {
        Assertions.assertFalse(editTrainersPage.areAllFieldsEmpty());
    }

    @Test
    @DisplayName("Check if Name is Valid")
    void checkNameIsValid() {
        editTrainersPage.enterFirstName("FirstExampleValid");
        editTrainersPage.enterLastName("LastExampleValid");
        Assertions.assertTrue(editTrainersPage.areAllFieldsValid());
    }

    @Test
    @DisplayName("Has the colour been entered?")
    void checkColourHasChanged()
    {
        String oldColour = editTrainersPage.getColour();
        editTrainersPage.setColour();

        Assertions.assertNotEquals(editTrainersPage.getColour(),oldColour);
    }



    @Test
    @DisplayName("Check if submit is successful")
    void checkSubmitSuccessful() {
        Assertions.assertTrue(editTrainersPage.isSubmitSuccessful());
    }

    @Test
    @DisplayName("Check submit button does not work if first name isn't entered")
    void checkIfSubmitIsNotSuccessfulWOFirstName() {
        editTrainersPage.enterFirstName("");
        editTrainersPage.enterLastName("LastExample");
        Assertions.assertFalse(editTrainersPage.isSubmitSuccessful());
    }

    @Test
    @DisplayName("Check submit button does not work if last name isn't entered")
    void checkIfSubmitIsNotSuccessfulWOLastName() {
        editTrainersPage.enterFirstName("FirstExample");
        editTrainersPage.enterLastName("");
        Assertions.assertFalse(editTrainersPage.isSubmitSuccessful());
    }

    @Test
    @DisplayName("Check submit button does not work if last name isn't entered")
    void checkIfSubmitIsNotSuccessfulAllFields() {
        editTrainersPage.enterFirstName("");
        editTrainersPage.enterLastName("");
        Assertions.assertFalse(editTrainersPage.isSubmitSuccessful());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
