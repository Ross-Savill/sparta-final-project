package com.spartaglobal.finalweek.tests.traineeTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.traineePages.AddQualityGatePage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class AddQualityGateTests extends NavTemplate {
    private TraineesPage traineesPage;
    private AddQualityGatePage addQualityGatePage;

    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();

        traineesPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToTraineesPage();
        addQualityGatePage = traineesPage.clickAddQualityGate("1row");

    }


    @Test
    @DisplayName("enter Trainee Id")
    void enterTraineeId() {

        addQualityGatePage.enterTraineeId(1);
        Assertions.assertEquals("1", addQualityGatePage.getTraineeIdElement().getAttribute("value"));

    }

    @Test
    @DisplayName("get Trainee Id Element")
    void getTraineeIdElement() {


        Assertions.assertEquals("18", addQualityGatePage.getTraineeIdElement().getAttribute("value"));
    }

    @Test
    @DisplayName("get Trainee Id")
    void getTraineeId() {
        Assertions.assertEquals(18, addQualityGatePage.getTraineeId());

    }


    @ParameterizedTest
    @DisplayName("set Quality Gate Status")
    @ValueSource(strings = {"Failed", "Failed Needs help", "Passed"})
    void setQualityGateStatus(String string) {
        addQualityGatePage.setQualityGateStatus(string);

        Assertions.assertEquals(string, addQualityGatePage.getQualityGateStatus());

    }

//    @Test
//    @DisplayName("click Quality Gate Drop Down")
//    void clickQualityGateDropDown() {
////        addQualityGatePage.clickQualityGateDropDown();
//    }

    @Test
    @DisplayName("get Quality Gate Status Element")
    void getQualityGateStatusElement() {
        Assertions.assertEquals("Failed", addQualityGatePage.getQualityGateStatusElement().getAttribute("value"));

    }
//


    @Test
    @DisplayName("get Quality Gate Status")
    void getQualityGateStatus() {
        Assertions.assertEquals("Failed", addQualityGatePage.getQualityGateStatus());

    }

//    @Test
//    @DisplayName("set Trainer One Id")
//    void setTrainerOneId() {
//
//
//        addQualityGatePage.setTrainerOneId(addQualityGatePage.getTrainerOneId());
//        Assertions.assertEquals("",addQualityGatePage.getTrainerOneId());

//    }

    @Test
    @DisplayName("get Trainer One Id")
    void getTrainerOneId() {
        String[] arr = {"Aayla Secura", "Mike Wazowski", "JarJar Binks"
                , "Kit Fisto", "Mace Windu", "Ki-adi Mundi", "Luminara Unduli", "Plo Koon", "Eeth Koth", "Adi Gallia"
                , "Ima-gun Di", "Qui-gon Jinn", "Obi-Wan Kenobi", "Sheev Palpatine"};
        ArrayList<String> trainerIds = new ArrayList<>(Arrays.asList(arr));
        Assertions.assertTrue(trainerIds.contains(addQualityGatePage.getTrainerOneId().getText()));
    }


//    @Test
//    @DisplayName("enter Trainer One Feedback")
//    void enterTrainerOneFeedback() {
//        addQualityGatePage.enterTrainerOneFeedback();
//    }

    @Test
    @DisplayName("get Trainer One Feedback")
    void getTrainerOneFeedback() {
        addQualityGatePage.enterTrainerOneFeedback("feedback123");
        Assertions.assertEquals("feedback123", addQualityGatePage.getTrainerOneFeedback().getAttribute("value"));
    }


//    @ParameterizedTest
//    @DisplayName("set Trainer Two Id")
//    @ValueSource(strings = {})
//    void setTrainerTwoId(String s) {
////        addQualityGatePage.setTrainerTwoId();
//
//    }


    @Test
    @DisplayName("get Trainer Two Feedback")
    void getTrainerTwoFeedback() {
        addQualityGatePage.enterTrainerTwoFeedback("feedback123");
        Assertions.assertEquals("feedback123", addQualityGatePage.getTrainerTwoFeedback().getAttribute("value"));
    }


    @Test
    @DisplayName("get Trainer Two Id")
    void getTrainerTwoId() {
        String[] arr = {"Aayla Secura", "Mike Wazowski", "JarJar Binks"
                , "Kit Fisto", "Mace Windu", "Ki-adi Mundi", "Luminara Unduli", "Plo Koon", "Eeth Koth", "Adi Gallia"
                , "Ima-gun Di", "Qui-gon Jinn", "Obi-Wan Kenobi", "Sheev Palpatine"};
        ArrayList<String> trainerIds = new ArrayList<>(Arrays.asList(arr));
        Assertions.assertTrue(trainerIds.contains(addQualityGatePage.getTrainerTwoId().getText()));
    }


    @Test
    @DisplayName("set Date")
    void setDate() {
//        addQualityGatePage.setDate();
    }

    @Test
    @DisplayName("get Date")
    void getDate() {
        Assertions.assertNotNull(addQualityGatePage.getDate());
    }


//    @Test
//    @DisplayName("go To Trainees Page")
//    void goToTraineesPage() {
//        addQualityGatePage.goToTraineesPage();
//    }


//    @Test
//    @DisplayName("is Submit Successful")
//    void isSubmitSuccessful() {
//        addQualityGatePage.isSubmitSuccessful();
//        Assertions.assertFalse(addQualityGatePage.isSubmitSuccessful());
//    }

    @Test
    @DisplayName("is Trainer One Feedback Empty")
    void isTrainerOneFeedbackEmpty() {
        Assertions.assertFalse(addQualityGatePage.isTrainerOneFeedbackEmpty());
    }


    @Test
    @DisplayName("is Trainer Two Feedback Empty")
    void isTrainerTwoFeedbackEmpty() {
        Assertions.assertTrue(addQualityGatePage.isTrainerTwoFeedbackEmpty());
    }


    @Test
    @DisplayName("is Date Valid")
    void isDateValid() {
        addQualityGatePage.setDate(LocalDate.now());
        Assertions.assertTrue(addQualityGatePage.isDateValid());

    }

    @Test
    @DisplayName("is Date Empty")
    void isDateEmpty() {
        Assertions.assertTrue(addQualityGatePage.isDateEmpty());
    }


    @Test
    @DisplayName("areAllFieldsValid")
    void areAllFieldsValid() {
        Assertions.assertFalse(addQualityGatePage.areAllFieldsValid());
    }

    @Test
    @DisplayName("are All Fields Empty")
    void areAllFieldsEmpty() {
        Assertions.assertFalse(addQualityGatePage.areAllFieldsEmpty());
    }


    @Test
    @DisplayName("get Url")
    void getUrl() {
        Assertions.assertTrue(addQualityGatePage.getURL().contains("http://localhost:8080/addQualityGate"));
    }


    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

}
