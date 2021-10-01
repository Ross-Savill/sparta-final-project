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
private LoginPage loginPage;
private SchedulerPage schedulerPage;
private TrainersPage trainersPage;
private AddTrainersPage addTrainersPage;

    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        PageFactory.initElements(webDriver,this);
        loginPage = new LoginPage();
        schedulerPage = new SchedulerPage();
        trainersPage = new TrainersPage();
        addTrainersPage = new AddTrainersPage();

        PropertiesLoader.getProperties.getProperty();
        loginPage.login(username,password);
        PageFactory.initElements(webDriver,schedulerPage);
        schedulerPage.goToTrainersPage();
        PageFactory.initElements(webDriver,trainersPage);
        trainersPage.goToAddNewTrainersPage();
        PageFactory.initElements(webDriver,addTrainersPage);
    }

    @Test
    @DisplayName("Check First and Last name is clear")
    void checkNameIsEmpty() {
        Assertions.assertTrue(addTrainersPage.areAllFieldsEmpty());
    }

    @Test
    @DisplayName("Check if Name is Valid")
    void checkNameIsValid() {
        Assertions.assertTrue(addTrainersPage.areAllFieldsValid());
    }

    @Test
    @DisplayName("Has the colour been entered?")
    void checkColourHasChanged()
    {
        String oldColour = addTrainersPage.getColour();
        Assertions.assertNotEquals(addTrainersPage.getColour(),oldColour);
    }


    @Test
    @DisplayName("Check if submit is successful")
    void checkSubmitSuccessful() {
        addTrainersPage.enterFirstName("FirstExample");
        addTrainersPage.enterLastName("LastExample");
        addTrainersPage.setColour();
        Assertions.assertTrue(addTrainersPage.isSubmitSuccessful());
    }

    @Test
    @DisplayName("Check if Trainer was created")
    void checkIfNewTrainerMade() {
        Assertions.assertEquals(trainersPage.getFirstName())
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
