package com.spartaglobal.finalweek.tests.trainersTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.trainersPages.TrainersPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.naming.InitialContext;
import java.util.Arrays;

public class TrainersTests extends NavTemplate {

    private TrainersPage trainersPage;

    @BeforeEach
    public void setup() {

        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();

        trainersPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToTrainersPage();
    }

    @Test
    @DisplayName("getUrl")
    void getUrl() {
        Assertions.assertEquals(trainersPage.getURL(), "http://localhost:8080/trainerPage");
    }


    @Test
    @DisplayName("get All Trainers First Name Elements")
    void getAllTrainersFirstNameElements() {
        Assertions.assertEquals(12, trainersPage.getAllTrainersFirstNameElements().size());
    }

    @Test
    @DisplayName("get All Trainers Last Name Elements")
    void getAllTrainersLastNameElements() {
        Assertions.assertEquals(12, trainersPage.getAllTrainersLastNameElements().size());
    }

    @Test
    @DisplayName("get All Trainer Elements")
    void getAllTrainerElements() {

        for (WebElement we:trainersPage.getAllTrainerElements()) {
            System.out.println(we.getText());
        }

        Assertions.assertEquals(12, trainersPage.getAllTrainerElements().size());
    }

    @Test
    @DisplayName("get All Trainer Colour Elements")
    void getAllTrainerColourElements() {
        Assertions.assertEquals(12, trainersPage.getAllTrainerColourElements().size());
    }

    @Test
    @DisplayName("get All Trainers First Name")
    void getAllTrainersFirstName() {
        Assertions.assertEquals(12, trainersPage.getAllTrainersFirstName().size());

    }

    @Test
    @DisplayName("get All Trainers Last Name")
    void getAllTrainersLastName() {
        Assertions.assertEquals(12, trainersPage.getAllTrainersLastName().size());
    }

    @Test
    @DisplayName("get All Trainer Colour")
    void getAllTrainerColour() {
        Assertions.assertEquals(12, trainersPage.getAllTrainerColour().size());
    }

    @Test
    @DisplayName("get Trainer First Name Element")
    void getTrainerFirstNameElement() {
        Assertions.assertEquals("Mike", trainersPage.getTrainerFirstNameElement(0).getText());
    }

    @Test
    @DisplayName("get Trainer Last Name Element")
    void getTrainerLastNameElement() {
        Assertions.assertEquals("Wazowski", trainersPage.getTrainerLastNameElement(0).getText());
    }

    @Test
    @DisplayName("get Trainer Colour Element")
    void getTrainerColourElement() {
        Assertions.assertEquals("background: rgb(80, 0, 102);", trainersPage.getTrainerColourElement(0).getAttribute("style"));
    }

    @Test
    @DisplayName("get Trainer First Name")
    void getTrainerFirstName() {
        Assertions.assertEquals("Mike", trainersPage.getTrainerFirstName(0));
    }

    @Test
    @DisplayName("get Trainer Last Name")
    void getTrainerLastName() {
        Assertions.assertEquals("Wazowski", trainersPage.getTrainerLastName(0));
    }

    @Test
    @DisplayName("get Trainer Colour")
    void getTrainerColour() {
        Assertions.assertEquals("background: rgb(80, 0, 102);", trainersPage.getTrainerColour(0));
    }

    @Test
    @DisplayName("click Add Trainer")
    void clickAddTrainer() {
        Assertions.assertEquals("http://localhost:8080/addTrainer", trainersPage.clickAddTrainer().getURL());

    }

    @Test
    @DisplayName("click Edit Trainer")
    void clickEditTrainer() {
        String url = trainersPage.clickEditTrainer().getURL();
        Assertions.assertEquals("http://localhost:8080/editTrainer", url.substring(0, url.length() - 2));
    }


//    @Test
//    @DisplayName("click Delete Trainer")
//    void clickDeleteTrainer() {
//        System.out.println("");
//    }
//
//    @Test
//    @DisplayName("click Delete Trainer")
//    void clickDeleteTrainer() {
//
//    }


    @Test
    @DisplayName("is Trainer First Name Valid")
    void isTrainerFirstNameValid() {
        Assertions.assertTrue(trainersPage.isTrainerFirstNameValid(0));
    }

    @Test
    @DisplayName("is Trainer Last Name Valid")
    void isTrainerLastNameValid() {
        Assertions.assertTrue(trainersPage.isTrainerLastNameValid(0));
    }

    @Test
    @DisplayName("are All Trainers First Names Valid")
    void areAllTrainersFirstNamesValid() {
        Assertions.assertTrue(trainersPage.areAllTrainersFirstNamesValid("trainer-firstname"));
    }


    @Test
    @DisplayName("are All Trainers Last Names Valid")
    void areAllTrainersLastNamesValid() {
        Assertions.assertTrue(trainersPage.areAllTrainersLastNamesValid("trainer-lastname"));
    }


    @Test
    @DisplayName("are All Colours Unique")
    void areAllColoursUnique() {
        Assertions.assertTrue(trainersPage.areAllColoursUnique());
    }

    @Test
    @DisplayName("find My Trainer Name")
    void findMyTrainerName() {

        Assertions.assertEquals(0, trainersPage.findMyTrainerName("Mike", "Wazowski") - 1);
    }


    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

}
