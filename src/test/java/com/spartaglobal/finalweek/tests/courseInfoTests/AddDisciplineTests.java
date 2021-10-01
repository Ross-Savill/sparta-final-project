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

public class AddDisciplineTests extends NavTemplate {

    private static final String userName = PropertiesLoader.getProperties().getProperty("Username");
    private static final String password =PropertiesLoader.getProperties().getProperty("Password");

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
        NavTemplate navTemplate = new NavTemplate();

        courseInfoPage = schedulerPage.goToCourseInfoPage();
        courseInfoPage = new CourseInfoPage();

        addDisciplinePage = courseInfoPage.goToAddDisciplinePage();
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
        String duration = "13";
        addDisciplinePage.enterDuration(duration);
        Assertions.assertEquals(duration,addDisciplinePage.getDurationTextField());
    }

    @Test
    @DisplayName("Check Submission Button is Clickable.")
    void testSubmissionIsClicked(){
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
    @ValueSource (strings = {"200", "1", "999", "1000"})
    @DisplayName("Duration Field must be numbers only.")
    void testFieldIsNumbersOnly(){
        Assertions.assertTrue(addDisciplinePage.submitSuccessful());
    }

    @Test
    @ParameterizedTest
    @ValueSource (strings = {"-1", "0", "1", "1000", "1001"})
    @DisplayName("Duration Field must less than or equal to 1000.")
    void testFieldIsLessThanOneThousand(){

    }

    @Test
    @DisplayName("Duration Field must less than or equal to 1000.")
    void testFieldAreEmpty(){
        addDisciplinePage.enterDuration("");
        addDisciplinePage.enterDisciplineName("");
        Assertions.assertTrue(addDisciplinePage.areAllFieldsEmpty());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
