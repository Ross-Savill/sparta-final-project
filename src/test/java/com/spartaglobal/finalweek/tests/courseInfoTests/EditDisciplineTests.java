package com.spartaglobal.finalweek.tests.courseInfoTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.EditDisciplinePage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EditDisciplineTests extends NavTemplate {
    private static final String userName = PropertiesLoader.getProperties().getProperty("Username");
    private static final String password = PropertiesLoader.getProperties().getProperty("Password");

    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private CourseInfoPage courseInfoPage;
    private EditDisciplinePage editDisciplinePage;
    private static final String discipline = "Java";

    @BeforeEach
    public void setup() {
        ResetData.resetData();
        TestBase.initialisation();

        loginPage = new LoginPage();
        schedulerPage = loginPage.login(userName,password);
        courseInfoPage = schedulerPage.goToCourseInfoPage();
        editDisciplinePage = courseInfoPage.clickEditDisciplineButton(discipline);

    }

    @Test
    @DisplayName("Check if discipline field can be passed a value.")
    void testDisciplineField(){
        String newDiscipline = "Ruby";
        editDisciplinePage.enterDisciplineName(newDiscipline);
        Assertions.assertEquals(newDiscipline, editDisciplinePage.getDisciplineNameTextField());
    }

    @Test
    @DisplayName("Check if duration field can be passed a value.")
    void testDurationField(){
        int duration = 13;
        editDisciplinePage.enterDuration(duration);
        Assertions.assertEquals(duration,editDisciplinePage.getDurationTextField());
    }
    @ParameterizedTest
    @ValueSource(strings = {"Ruby", "Python12", "Java", "R2 D2","SQL"})
    @DisplayName("Discipline name's are valid")
    void testNameIsValid(String names){
        editDisciplinePage.enterDisciplineName(names);
        Assertions.assertTrue(editDisciplinePage.isDisciplineNameValid());
    }

    @Test
    @ParameterizedTest
    @ValueSource (ints = {-1, 0, 1, 1000, 1001})
    @DisplayName("Duration Field must between 0 and 1000.")
    void testDurationIsValid(int values){
        editDisciplinePage.enterDuration(values);
        Assertions.assertTrue(editDisciplinePage.isDisciplineDurationValid());
    }

    @Test
    @DisplayName("Check if discipline name is empty.")
    void testDisciplineNameIsEmpty(){
        String emptyName = " ";
        editDisciplinePage.enterDisciplineName(emptyName);
        Assertions.assertTrue(editDisciplinePage.isDisciplineNameEmpty());
    }

    @Test
    @DisplayName("Check if duration is empty.")
    void testDurationIsEmpty(){
        Assertions.assertTrue(editDisciplinePage.isDisciplineDurationEmpty());
    }

    @Test
    @DisplayName("Test Remove Button works")
    void testRemoveButtonIsFunctional(){
        editDisciplinePage.clickRemove();
        Assertions.assertTrue(!courseInfoPage.getDisciplineNames().contains(discipline));
    }

    @Test
    @DisplayName("Test URL")
    void testURL(){
        Assertions.assertTrue(false);
    }


    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
