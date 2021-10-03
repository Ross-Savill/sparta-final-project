package com.spartaglobal.finalweek.tests.trainersTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.trainersPages.AddTrainersPage;
import com.spartaglobal.finalweek.pages.trainersPages.TrainersPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

public class AddTrainersTests extends NavTemplate {

    private TrainersPage trainersPage;
    private AddTrainersPage addTrainersPage;

    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();
        trainersPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToTrainersPage();
        addTrainersPage = trainersPage.clickAddTrainer();
    }

    @Test
    @DisplayName("Check First and Last name is clear")
    void checkNameIsEmpty() {
        Assertions.assertTrue(addTrainersPage.areAllFieldsEmpty());
    }

    @Test
    @DisplayName("Check if Name is Valid")
    void checkNameIsValid() {
        addTrainersPage.enterFirstName("FirstExample");
        addTrainersPage.enterLastName("LastExample");
        Assertions.assertTrue(addTrainersPage.areAllFieldsValid());
    }

//    @Test
//    @DisplayName("Has the colour been entered?")
//    void checkColourHasChanged()
//    {
//        int rowID;
//        String oldColour = addTrainersPage.getColour();
//        addTrainersPage.enterFirstName("FirstExample");
//        addTrainersPage.enterLastName("LastExample");
//        addTrainersPage.setColour();
//        addTrainersPage.submitTrainer();
//        rowID = trainersPage.findMyTrainerName("FirstExample","LastExample");
//        System.err.println(trainersPage.getTrainerColour(rowID));
//
//        Assertions.assertNotEquals(addTrainersPage.getColour(),oldColour);
//    }


    @Test
    @DisplayName("Check if submit is successful")
    void checkSubmitSuccessful() {
        addTrainersPage.enterFirstName("FirstExample");
        addTrainersPage.enterLastName("LastExample");
        Assertions.assertTrue(addTrainersPage.isSubmitSuccessful());
    }

    @Test
    @DisplayName("Check if Trainer was created")
    void checkIfNewTrainerEntered() {
        addTrainersPage.enterFirstName("FirstExample");
        addTrainersPage.enterLastName("LastExample");
        addTrainersPage.submitTrainer();
        Assertions.assertNotEquals(-1,trainersPage.findMyTrainerName("FirstExample","LastExample"));
    }

    @Test
    @DisplayName("Check submit button does not work if first name isn't entered")
    void checkIfSubmitIsNotSuccessfulWOFirstName() {
        addTrainersPage.enterLastName("LastExample");
        Assertions.assertFalse(addTrainersPage.isSubmitSuccessful());
    }

    @Test
    @DisplayName("Check submit button does not work if last name isn't entered")
    void checkIfSubmitIsNotSuccessfulWOLastName() {
        addTrainersPage.enterFirstName("FirstExample");
        Assertions.assertFalse(addTrainersPage.isSubmitSuccessful());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
