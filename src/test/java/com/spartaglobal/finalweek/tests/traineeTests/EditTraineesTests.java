package com.spartaglobal.finalweek.tests.traineeTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.traineePages.EditTraineesPage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditTraineesTests extends NavTemplate {

    private static String username = PropertiesLoader.getProperties().getProperty("Username");
    private static String password = PropertiesLoader.getProperties().getProperty("Password");
    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private TraineesPage traineesPage;
    private EditTraineesPage editTraineesPage;

    @BeforeEach
    public void setup() {
        ResetData.resetData();
        TestBase.initialisation();
        PageFactory.initElements(webDriver, this);
        loginPage = new LoginPage();
        schedulerPage = new SchedulerPage();
        traineesPage = new TraineesPage();
        loginPage.login(username, password);
        PageFactory.initElements(webDriver, schedulerPage);
        NavTemplate navTemplate = new NavTemplate();
        traineesPage = navTemplate.goToTraineesPage();
        editTraineesPage = traineesPage.clickEditTrainee("0row");
    }

    @Nested
    @DisplayName("Test Entering Data Into Edit Trainee Fields")
    class testEnteringDataIntoEditTraineeFields {

        @Test
        @DisplayName("courseNameTest")
        void courseNameTest() {
            editTraineesPage.selectCourseName("Hacking 4");
            Select editTraineesCourseDropdown = new Select(webDriver.findElement(By.id("edit-trainee-course-name")));
            Assertions.assertEquals("Hacking 4", editTraineesCourseDropdown.getFirstSelectedOption().getText());
        }

        @Test
        @DisplayName("enterFirstNameTest")
        void enterFirstNameTest() {
            editTraineesPage.enterFirstName("TestName");
            WebElement firstNameTextBox = webDriver.findElement(By.id("edit-trainee-first-name"));
            Assertions.assertEquals("TestName", firstNameTextBox.getAttribute("value"));
        }

        @Test
        @DisplayName("enterLastNameTest")
        void enterLastNameTest() {
            editTraineesPage.enterLastName("TestSurname");
            WebElement lastNameTextBox = webDriver.findElement(By.id("edit-trainee-last-name"));
            Assertions.assertEquals("TestSurname", lastNameTextBox.getAttribute("value"));
        }
    }

    @Nested
    @DisplayName("Test Edit Trainee Empty And Valid Fields")
    class testEditTraineeEmptyAndValidFields {

        @Test
        @DisplayName("isSubmitSuccessfulTest")
        void isSubmitSuccessfulTest() {
            Assertions.assertTrue(editTraineesPage.isSubmitSuccessful("TestFirstName", "TestLastName"));
        }

        @Test
        @DisplayName("isFirstNameEmptyTest")
        void isFirstNameEmptyTest() {
            Assertions.assertFalse(editTraineesPage.isFirstNameEmpty());
        }

        @Test
        @DisplayName("isLastNameEmptyTest")
        void isLastNameEmptyTest() {
            Assertions.assertFalse(editTraineesPage.isLastNameEmpty());
        }

        @Test
        @DisplayName("areFirstNameAndLastNameEmptyTest")
        void areFirstNameAndLastNameEmptyTest() {
            Assertions.assertFalse(editTraineesPage.areFirstNameAndLastNameEmpty());
        }

        @Test
        @DisplayName("isFirstNameValidTest")
        void isFirstNameValidTest() {
            Assertions.assertTrue(editTraineesPage.isFirstNameValid());
        }

        @Test
        @DisplayName("isLastNameValidTest")
        void isLastNameValidTest() {
            Assertions.assertTrue(editTraineesPage.isLastNameValid());
        }

    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
