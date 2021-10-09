package com.spartaglobal.finalweek.tests.traineeTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.traineePages.AddTraineesPage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import org.junit.jupiter.api.*;

public class AddTraineesTests extends NavTemplate {

    private TraineesPage traineesPage;
    private AddTraineesPage addTraineesPage;

    @BeforeEach
    public void setup()
    {
        ResetData.resetData();
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();
        traineesPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToTraineesPage();
        addTraineesPage = traineesPage.clickAddTrainee();
    }

    @Test
    @DisplayName("Check First and Last name is clear")
    void checkNameIsEmpty() {
        Assertions.assertTrue(addTraineesPage.areAllFieldsEmpty());
    }

    @Test
    @DisplayName("Check if Name is Valid")
    void checkNameIsValid() {
        addTraineesPage.enterFirstName("FirstExample");
        addTraineesPage.enterLastName("LastExample");
        Assertions.assertTrue(addTraineesPage.areAllFieldsValid());
    }

    @Test
    @DisplayName("Has the colour been entered?")
    void checkCourseHasChanged()
    {
        String oldCourseName = addTraineesPage.getCourseName();
        addTraineesPage.setCourseName("SDET 34");
        Assertions.assertNotEquals(addTraineesPage.getCourseName(),oldCourseName);
    }


    @Test
    @DisplayName("Check if submit is successful")
    void checkSubmitSuccessful() {
        addTraineesPage.enterFirstName("FirstExample");
        addTraineesPage.enterLastName("LastExample");
        Assertions.assertTrue(addTraineesPage.isSubmitSuccessful());
    }

    @Test
    @DisplayName("Check if Trainer was created")
    void checkIfNewTrainerEntered() {
        addTraineesPage.enterFirstName("FirstExample");
        addTraineesPage.enterLastName("LastExample");
        addTraineesPage.submitTrainee();
        NavTemplate navTemplate = new NavTemplate();
        traineesPage = navTemplate.goToTraineesPage();
        Assertions.assertTrue(traineesPage.isTraineePresent("FirstExample","LastExample"));
    }

    @Test
    @DisplayName("Check submit button does not work if first name isn't entered")
    void checkIfSubmitIsNotSuccessfulWOFirstName() {
        addTraineesPage.enterLastName("LastExample");
        Assertions.assertFalse(addTraineesPage.isSubmitSuccessful());
    }

    @Test
    @DisplayName("Check submit button does not work if last name isn't entered")
    void checkIfSubmitIsNotSuccessfulWOLastName() {
        addTraineesPage.enterFirstName("FirstExample");
        Assertions.assertFalse(addTraineesPage.isSubmitSuccessful());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
