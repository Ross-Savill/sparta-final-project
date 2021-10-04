package com.spartaglobal.finalweek.tests.courseInfoTests;

import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.EditCourseTypePage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class EditCourseTypeTests extends NavTemplate {
    EditCourseTypePage editCourseTypePage;
    private String courseTypeName = "Technology";

    @BeforeEach
    public void setup() {
        initialisation(); //initialise the web driver
        LoginPage loginPage = new LoginPage();
        SchedulerPage schedulerPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password"));
        PageFactory.initElements(webDriver, schedulerPage);
        NavTemplate navTemplate = new NavTemplate();
        CourseInfoPage courseInfoPage = navTemplate.goToCourseInfoPage();
        editCourseTypePage = courseInfoPage.clickEditCourseTypeButton(courseInfoPage.getCourseTypeName(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Business", "Technology", "Data & Security"})
    @DisplayName("enterCourseTypeName Test")
    void enterCourseTypeNameTest(String typeName) {
        editCourseTypePage.enterCourseTypeName(typeName);
        Assertions.assertEquals(typeName, webDriver.findElement(new By.ById("course-type-name")).getAttribute("value"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Business", "Technology", "Data & Security"})
    @DisplayName("isCourseTypeNameValid Valid Test")
    void isCourseTypeNameValidValidTest(String typeName) {
        editCourseTypePage.enterCourseTypeName(typeName);
        Assertions.assertTrue(editCourseTypePage.isCourseTypeNameValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"!!!", "C!", "???", "abc^"})
    @DisplayName("isCourseTypeNameValid Invalid Test")
    void isCourseTypeNameValidInvalidTest(String typeName) {
        editCourseTypePage.enterCourseTypeName(typeName);
        Assertions.assertFalse(editCourseTypePage.isCourseTypeNameValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("isCourseTypeNameEmpty Yes Test")
    void isCourseTypeNameEmptyYesTest(String typeName) {
        editCourseTypePage.enterCourseTypeName(typeName);
        Assertions.assertTrue(editCourseTypePage.isCourseTypeNameEmpty());
    }

    @Test
    @DisplayName("isCourseTypeNameEmpty No Test")
    void isCourseTypeNameEmptyNoTest() {
        editCourseTypePage.enterCourseTypeName("abc");
        Assertions.assertFalse(editCourseTypePage.isCourseTypeNameEmpty());
    }

    @Test
    @DisplayName("Submittion Testing")
    void submissionTesting() {
        String typeName = "Test Course Type";
        editCourseTypePage.enterCourseTypeName(typeName);
        editCourseTypePage.goToCourseInfoPage();

        Assertions.assertTrue(editCourseTypePage.submitSuccessful(typeName));
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
