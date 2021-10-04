package com.spartaglobal.finalweek.tests.courseInfoTests;

import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.AddCourseTypePage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AddCourseTypeTests extends NavTemplate {
    AddCourseTypePage addCourseTypePage;
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
        addCourseTypePage = courseInfoPage.clickAddCourseTypeButton();

    }

    @ParameterizedTest
    @ValueSource(strings = {"Business", "Technology", "Data & Security"})
    @DisplayName("enterCourseTypeName Test")
    void enterCourseTypeNameTest(String typeName) {
        addCourseTypePage.enterCourseTypeName(typeName);
        Assertions.assertEquals(typeName, webDriver.findElement(new By.ById("course-type-name")).getAttribute("value"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Business", "Technology", "Data & Security"})
    @DisplayName("isCourseTypeNameValid Valid Test")
    void isCourseTypeNameValidValidTest(String typeName) {
        addCourseTypePage.enterCourseTypeName(typeName);
        Assertions.assertTrue(addCourseTypePage.isCourseTypeNameValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"!!!", "C!", "???", "abc^"})
    @DisplayName("isCourseTypeNameValid Invalid Test")
    void isCourseTypeNameValidInvalidTest(String typeName) {
        addCourseTypePage.enterCourseTypeName(typeName);
        Assertions.assertFalse(addCourseTypePage.isCourseTypeNameValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("isCourseTypeNameEmpty Yes Test")
    void isCourseTypeNameEmptyYesTest(String typeName) {
        addCourseTypePage.enterCourseTypeName(typeName);
        Assertions.assertTrue(addCourseTypePage.isCourseTypeNameEmpty());
    }

    @Test
    @DisplayName("isCourseTypeNameEmpty No Test")
    void isCourseTypeNameEmptyNoTest() {
        addCourseTypePage.enterCourseTypeName("abc");
        Assertions.assertFalse(addCourseTypePage.isCourseTypeNameEmpty());
    }

    @Test
    @DisplayName("Submittion Testing")
    void submissionTesting() {
        String typeName = "Test Course Type";
        addCourseTypePage.enterCourseTypeName(typeName);
        addCourseTypePage.goToCourseInfoPage();

        Assertions.assertTrue(addCourseTypePage.submitSuccessful(typeName));
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }
}
