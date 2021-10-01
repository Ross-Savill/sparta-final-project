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
        // TODO: 30/09/2021 Implement Test

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
        // TODO: 30/09/2021 Implement Test
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
        // TODO: 30/09/2021 Implement Test
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
        // TODO: 30/09/2021 Implement Test
        System.out.println(courseInfoPage.getDisciplinesElementsBetweenDurations(10, 15));
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
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("isCourseTypeDeleted Test")
    void isCourseTypeDeletedTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("clickDeleteDisciplineButton Test")
    void clickDeleteDisciplineButtonTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("isDisciplineDeleted Test")
    void isDisciplineDeletedTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @ParameterizedTest
    @ValueSource(strings = "")
    @DisplayName("areCourseTypesUnique Valid Test")
    void areCourseTypesUniqueValidTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("areCourseTypesUnique Invalid Test")
    void areCourseTypesUniqueInvalidTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("areDisciplinesUnique Valid Test")
    void areDisciplinesUniqueValidTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("areDisciplinesUnique Invalid Test")
    void areDisciplinesUniqueInvalidTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("isNameValidForCourseType Valid Test")
    void isNameValidForCourseTypeValidTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("isNameValidForCourseType Invalid Test")
    void isNameValidForCourseTypeInvalidTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("isDurationValidForDiscipline Valid Test")
    void isDurationValidForDisciplineValidTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("isDurationValidForDiscipline Invalid Test")
    void isNameDurationForDisciplineInvalidTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("isNameValidForDiscipline Valid Test")
    void isNameValidForDisciplineValidTest() {

    }

    @Test
    @DisplayName("isNameValidForDiscipline Invalid Test")
    void isNameValidForDisciplineInvalidTest() {

    }

    @Test
    @DisplayName("areAllFieldsPassedOnToEditCourseTypePage Test")
    void areAllFieldsPassedOnToEditCourseTypePageTest() {

    }

    @Test
    @DisplayName("areAllFieldsPassedOnToEditDisciplinePage Test")
    void areAllFieldsPassedOnToEditDisciplinePageTest() {


    }
    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
