package com.spartaglobal.finalweek.tests.courseInfoTests;

import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CourseInfoTests extends NavTemplate {
    private CourseInfoPage courseInfoPage;

    @BeforeEach
    public void setup() {
        initialisation(); //initialise the web driver
        LoginPage loginPage = new LoginPage();
        SchedulerPage schedulerPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password"));
        PageFactory.initElements(webDriver, schedulerPage);
        NavTemplate navTemplate = new NavTemplate();
        courseInfoPage = navTemplate.goToCourseInfoPage();
    }

    @Test
    @DisplayName("getCourseTypeElements Test")
    void getCourseTypeElementsTest() {
        boolean found = false;
        List<WebElement> testWebElements = courseInfoPage.getCourseTypeElements();
        for (WebElement testWebElement: testWebElements) {
            if (testWebElement != null && testWebElement.getText().contains("Course Type")) {
                found = true;
            }
        }
        Assertions.assertTrue(found);
    }

    @Test
    @DisplayName("getCourseTypesNames Test")
    void getCourseTypesNamesTest() {
        List<String> names = Arrays.asList("Business", "Technology");
        Assertions.assertEquals(names, courseInfoPage.getCourseTypesNames());
    }

    @Test
    @DisplayName("getCourseTypeWebElement Test")
    void getCourseTypeWebElementTest() {
        WebElement testWebElement = courseInfoPage.getCourseTypeWebElement("Business");
        Assertions.assertTrue(testWebElement != null && testWebElement.getText().contains("Business"));
    }

    @Test
    @DisplayName("getCourseTypeName Test")
    void getCourseTypeNameTest() {
        Assertions.assertEquals("Business", courseInfoPage.getCourseTypeName(0));
    }

    @Test
    @DisplayName("getCourseTypeCount Test")
    void getCourseTypeCountTest() {
        Assertions.assertEquals(2, courseInfoPage.getCourseTypeCount());
    }

    @Test
    @DisplayName("getDisciplineElements Test")
    void getDisciplineElementsTest() {
        boolean found = false;
        List<WebElement> testWebElements = courseInfoPage.getDisciplinesElements();
        for (WebElement testWebElement: testWebElements) {
            if (testWebElement != null && testWebElement.getText().contains("Discipline")) {
                found = true;
            }
        }
        Assertions.assertTrue(found);
    }

    @Test
    @DisplayName("getDisciplineNames Test")
    void getDisciplineNamesTest() {
        List<String> names = Arrays.asList("Java", "C#", "DevOps", "JavaSDET", "C#SDET");
        Assertions.assertEquals(names, courseInfoPage.getDisciplineNames());
    }

    @Test
    @DisplayName("getDisciplineCount Test")
    void getDisciplineCountTest() {
        Assertions.assertEquals(5, courseInfoPage.getDisciplineCount());
    }

    @Test
    @DisplayName("getDisciplineElement rowID Test")
    void getDisciplineElementRowIDTest() {
        WebElement testWebElement = courseInfoPage.getDisciplineElement(0);
        Assertions.assertTrue(testWebElement != null && testWebElement.getText().contains("Java"));
    }

    @Test
    @DisplayName("getDisciplineElement Name Test")
    void getDisciplineElementNameTest() {
        WebElement testWebElement = courseInfoPage.getDisciplineElement("Java");
        Assertions.assertTrue(testWebElement != null && testWebElement.getText().contains("Java"));
    }

    @Test
    @DisplayName("getDisciplineName Test")
    void getDisciplineNameTest() {
        Assertions.assertEquals("Java", courseInfoPage.getDisciplineName(0));
    }

    @Test
    @DisplayName("getDisciplineElementsWithDuration Test")
    void getDisciplineElementsWithDurationTest() {
        Assertions.assertEquals(5, courseInfoPage.getDisciplinesElementsWithDuration(12).size());
    }

    @Test
    @DisplayName("getDisciplineNamesWithDuration Test")
    void getDisciplineNamesWithDurationTest() {
        List<String> names = Arrays.asList("Java", "C#", "DevOps", "JavaSDET", "C#SDET");
        Assertions.assertEquals(names, courseInfoPage.getDisciplinesNamesWithDuration(12));
    }

    @Test
    @DisplayName("getDisciplinesElementsBetweenDurations Test")
    void getDisciplinesElementsBetweenDurationsTest() {
        Assertions.assertEquals(5, courseInfoPage.getDisciplinesElementsBetweenDurations(10,15).size());
    }

    @Test
    @DisplayName("getDisciplineNamesBetweenDurations Test")
    void getDisciplineNamesBetweenDurationsTest() {
        List<String> names = Arrays.asList("Java", "C#", "DevOps", "JavaSDET", "C#SDET");
        Assertions.assertEquals(names, courseInfoPage.getDisciplineNamesBetweenDurations(10,15));
    }

    @Test
    @DisplayName("clickAddDisciplineButton Test")
    void clickAddDisciplineButtonTest() {
        courseInfoPage.clickAddDisciplineButton();
        Assertions.assertEquals("http://localhost:8080/addDiscipline", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("clickAddCourseTypeButton Test")
    void clickAddCourseTypeButtonTest() {
        courseInfoPage.clickAddCourseTypeButton();
        Assertions.assertEquals("http://localhost:8080/addCourseType", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("clickEditCourseTypeButton Test")
    void clickEditCourseTypeButtonTest() {
        courseInfoPage.clickEditCourseTypeButton("Technology");
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/editCourseType/"));
    }

    @Test
    @DisplayName("clickEditDisciplineButton Test")
    void clickEditDisciplineButtonTest() {
        courseInfoPage.clickEditCourseTypeButton("Technology");
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/editCourseType/"));
    }

    @Test
    @DisplayName("clickDeleteCourseTypeButton Test")
    void clickDeleteCourseTypeButtonTest() {
        courseInfoPage.clickDeleteCourseTypeButton("Business");
        Assertions.assertTrue(courseInfoPage.isCourseTypeDeleted("Business"));
    }

    @Test
    @DisplayName("isCourseTypeDeleted Test")
    void isCourseTypeDeletedTest() {
        //Tests that an item is not present
        courseInfoPage.isCourseTypeDeleted("TESTCOURSE");
    }

    @Test
    @DisplayName("clickDeleteDisciplineButton Test")
    void clickDeleteDisciplineButtonTest() {
        courseInfoPage.clickDeleteDisciplineButton("Java");
        Assertions.assertTrue(courseInfoPage.isDisciplineDeleted("Java"));
    }

    @Test
    @DisplayName("isDisciplineDeleted Test")
    void isDisciplineDeletedTest() {
        //Tests that an item is not present
        courseInfoPage.isDisciplineDeleted("TESTCOURSE");
    }

    @Test
    @DisplayName("areCourseTypesUnique Valid Test")
    void areCourseTypesUniqueValidTest() {
        Assertions.assertTrue(courseInfoPage.areCourseTypesUnique());
    }

    @Test
    @DisplayName("areCourseTypesUnique Invalid Test")
    void areCourseTypesUniqueInvalidTest() {
        // TODO: 30/09/2021 Implement Test
        // Need AddCourseTypePage to be implemented
    }

    @Test
    @DisplayName("areDisciplinesUnique Valid Test")
    void areDisciplinesUniqueValidTest() {
        Assertions.assertTrue(courseInfoPage.areDisciplinesUnique());
    }

    @Test
    @DisplayName("areDisciplinesUnique Invalid Test")
    void areDisciplinesUniqueInvalidTest() {
        // TODO: 30/09/2021 Implement Test
        // Need AddCourseTypePage to be implemented
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "C#", "Programming & Testing", "Objective-C"})
    @DisplayName("isNameValidForCourseType Valid Test")
    void isNameValidForCourseTypeValidTest(String name) {
        Assertions.assertTrue(courseInfoPage.isNameValidForCourseType(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"!!!", "C!", "???", "abc^"})
    @DisplayName("isNameValidForCourseType Valid Test")
    void isNameValidForCourseTypeInvalidTest(String name) {
        Assertions.assertFalse(courseInfoPage.isNameValidForCourseType(name));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,12,24,1000})
    @DisplayName("isDurationValidForDiscipline Valid Test")
    void isDurationValidForDisciplineValidTest(int duration) {
        Assertions.assertTrue(courseInfoPage.isDurationValidForDiscipline(duration));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000,-1,0})
    @DisplayName("isDurationValidForDiscipline Invalid Test")
    void isNameDurationForDisciplineInvalidTest(int duration) {
        Assertions.assertFalse(courseInfoPage.isDurationValidForDiscipline(duration));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Data", "Technology", "Business"})
    @DisplayName("isNameValidForDiscipline Valid Test")
    void isNameValidForDisciplineValidTest(String name) {
        Assertions.assertTrue(courseInfoPage.isNameValidForDiscipline(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"!!!", "AB ! CD!", "?^C"})
    @DisplayName("isNameValidForDiscipline Invalid Test")
    void isNameValidForDisciplineInvalidTest(String name) {
        Assertions.assertFalse(courseInfoPage.isNameValidForDiscipline(name));
    }

    @Test
    @DisplayName("areAllFieldsPassedOnToEditCourseTypePage Test")
    void areAllFieldsPassedOnToEditCourseTypePageTest() {
        // TODO: 01/10/2021 Implement Test
        //Need Edit Course Type Page to be implemented
    }

    @Test
    @DisplayName("areAllFieldsPassedOnToEditDisciplinePage Test")
    void areAllFieldsPassedOnToEditDisciplinePageTest() {
        // TODO: 01/10/2021 Implement Test
        //Need Edit Discipline Page to be implemented
    }
    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
