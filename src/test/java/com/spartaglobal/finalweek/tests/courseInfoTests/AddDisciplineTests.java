package com.spartaglobal.finalweek.tests.courseInfoTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.AddDisciplinePage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.URL;

public class AddDisciplineTests extends NavTemplate {

    private static final String userName = PropertiesLoader.getProperties().getProperty("Username");
    private static final String password =PropertiesLoader.getProperties().getProperty("Password");
    private static final String courseInfoPageURL = PropertiesLoader.getProperties().getProperty("courseInfoPageURL");

    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private CourseInfoPage courseInfoPage;
    private AddDisciplinePage addDisciplinePage;

    @BeforeEach
    public void setup() {
        TestBase.initialisation();

        loginPage = new LoginPage();
        schedulerPage = loginPage.login(userName,password);
        schedulerPage = new SchedulerPage();

        courseInfoPage = schedulerPage.goToCourseInfoPage();
        courseInfoPage = new CourseInfoPage();

        addDisciplinePage = courseInfoPage.clickAddDisciplineButton();
        addDisciplinePage = new AddDisciplinePage();
    }

    @Test
    @DisplayName("Check if discipline field can be passed a value.")
    void testDisciplineField(){
        String newDiscipline = "Ruby";
        addDisciplinePage.enterDisciplineName(newDiscipline);
        Assertions.assertEquals(newDiscipline,addDisciplinePage.getDisciplineNameTextField());
    }

    @Test
    @DisplayName("Check if duration field can be passed a value.")
    void testDurationField(){
        int duration = 13;
        addDisciplinePage.enterDuration(duration);
        Assertions.assertEquals(duration,addDisciplinePage.getDurationTextField());
    }


    @Test
    @DisplayName("Check Submission Button is Clickable.")
    void testSubmissionIsClicked(){
        addDisciplinePage.enterDisciplineName("Ruby");
        addDisciplinePage.enterDuration(13);
        Assertions.assertTrue(addDisciplinePage.submitSuccessful());
    }

    @ParameterizedTest
    @ValueSource (strings = {"Ruby", "Python12", "Java", "R2 D2"})
    @DisplayName("Discipline name must be letters only.")
    void testFieldIsLettersOnly(String names){
        addDisciplinePage.enterDisciplineName(names);
        Assertions.assertTrue(addDisciplinePage.isDisciplineNameValid());
    }

    @ParameterizedTest
    @ValueSource (ints = {200,1000, 1})
    @DisplayName("Duration Field must be numbers only.")
    void testFieldIsNumbersOnly(){
        Assertions.assertTrue(addDisciplinePage.isDisciplineDurationValid());
    }

    @Test
    @ParameterizedTest
    @ValueSource (ints = {-1, 0, 1, 1000, 1001})
    @DisplayName("Duration Field must between 0 and 1000.")
    void testDurationBounds(int values){
        addDisciplinePage.enterDuration(values);
        Assertions.assertTrue(addDisciplinePage.isDisciplineDurationValid());
    }

    @ParameterizedTest
    @ValueSource (strings = {"", "Python12"})
    @DisplayName("Check Discipline name is empty.")
    void testDisciplineNameIsEmpty(String names){
        addDisciplinePage.enterDisciplineName(names);
        Assertions.assertTrue(addDisciplinePage.isDisciplineNameEmpty());
    }

    @ParameterizedTest
    @ValueSource (ints = { 1,2,3,5,1000 })
    @DisplayName("Check Discipline Duration is empty.")
    void testDisciplineDurationIsEmpty(int durations){
        addDisciplinePage.enterDuration(durations);
        Assertions.assertFalse(addDisciplinePage.isDisciplineDurationEmpty());
    }

    @Test
    @DisplayName("Test if Name and Duration are Empty.")
    void testFieldAreEmpty(){
        addDisciplinePage.enterDisciplineName("");
        Assertions.assertTrue(addDisciplinePage.areAllFieldsEmpty());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
