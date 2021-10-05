package com.spartaglobal.finalweek.tests.traineeTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.traineePages.AddQualityGatePage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
        addQualityGatePage = traineesPage.clickAddQualityGate("1");

    }


    @Test
    @DisplayName("enter Trainee Id")
    void enterTraineeId() {

        addQualityGatePage.enterTraineeId(1);
    }

    @Test
    @DisplayName("get Trainee Id Element")
    void getTraineeIdElement() {
        System.out.println(addQualityGatePage.getURL());git s
        Assertions.assertEquals(1,addQualityGatePage.getTraineeIdElement() );
    }

    @Test
    @DisplayName("get Trainee Id")
    void getTraineeId() {
        addQualityGatePage.getTraineeId();

    }


    @Test
    @DisplayName("set Quality Gate Status")
    void setQualityGateStatus() {
//        addQualityGatePage.setQualityGateStatus();

    }

    @Test
    @DisplayName("click Quality Gate Drop Down")
    void clickQualityGateDropDown() {
//        addQualityGatePage.clickQualityGateDropDown();
    }

    @Test
    @DisplayName("get Quality Gate Status Element")
    void getQualityGateStatusElement() {
        addQualityGatePage.getQualityGateStatusElement();

    }
//
//    @Test
//    @DisplayName("get Quality Gate Status Element")
//    void getQualityGateStatusElement() {
//
//    }

    @Test
    @DisplayName("get Quality Gate Status")
    void getQualityGateStatus() {
        addQualityGatePage.getQualityGateStatus();

    }

    @Test
    @DisplayName("set Trainer One Id")
    void setTrainerOneId() {
//        addQualityGatePage.setTrainerOneId();
    }

    @Test
    @DisplayName("get Trainer One Id")
    void getTrainerOneId() {
        addQualityGatePage.getTrainerOneId();
    }


    @Test
    @DisplayName("enter Trainer One Feedback")
    void enterTrainerOneFeedback() {
//        addQualityGatePage.enterTrainerOneFeedback();
    }

    @Test
    @DisplayName("get Trainer One Feedback")
    void getTrainerOneFeedback() {
        addQualityGatePage.getTrainerOneFeedback();
    }

    @Test
    @DisplayName("set Trainer Two Id")
    void setTrainerTwoId() {
//        addQualityGatePage.setTrainerTwoId();

    }

    @Test
    @DisplayName("enter Trainer Two Feedback")
    void enterTrainerTwoFeedback() {
//        addQualityGatePage.enterTrainerTwoFeedback();

    }

    @Test
    @DisplayName("get Trainer Two Feedback")
    void getTrainerTwoFeedback() {
        addQualityGatePage.getTrainerTwoFeedback();
    }


    @Test
    @DisplayName("get Trainer Two Id")
    void getTrainerTwoId() {
        addQualityGatePage.getTrainerTwoId();
    }


    @Test
    @DisplayName("set Date")
    void setDate() {
//        addQualityGatePage.setDate();
    }

    @Test
    @DisplayName("get Date")
    void getDate() {
        addQualityGatePage.getDate();
    }


//    @Test
//    @DisplayName("go To Trainees Page")
//    void goToTraineesPage() {
//        addQualityGatePage.goToTraineesPage();
//    }


    @Test
    @DisplayName("is Submit Successful")
    void isSubmitSuccessful() {
        addQualityGatePage.isSubmitSuccessful();
    }

    @Test
    @DisplayName("is Trainer One Feedback Empty")
    void isTrainerOneFeedbackEmpty() {
        addQualityGatePage.isTrainerOneFeedbackEmpty();
    }


    @Test
    @DisplayName("is Trainer Two Feedback Empty")
    void isTrainerTwoFeedbackEmpty() {
        addQualityGatePage.isTrainerTwoFeedbackEmpty();
    }

    @Test
    @DisplayName("Is Valid")
    void isValid() {
//        addQualityGatePage.is
    }

    @Test
    @DisplayName("is Date Valid")
    void isDateValid() {
        addQualityGatePage.isDateValid();

    }

    @Test
    @DisplayName("is Date Empty")
    void isDateEmpty() {
        addQualityGatePage.isDateEmpty();
    }


    @Test
    @DisplayName("areAllFieldsValid")
    void areAllFieldsValid() {
        addQualityGatePage.areAllFieldsValid();
    }

    @Test
    @DisplayName("are All Fields Empty")
    void areAllFieldsEmpty() {
        addQualityGatePage.areAllFieldsEmpty();
    }


    @Test
    @DisplayName("get Url")
    void getUrl() {
        addQualityGatePage.getURL();
    }


//    @AfterEach
//    public void tearDown() {
//        webDriver.quit();
//    }

}
