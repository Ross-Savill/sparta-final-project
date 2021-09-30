package com.spartaglobal.finalweek.tests.courseInfoTests;

import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class CourseInfoTests extends NavTemplate {
    private NavTemplate navTemplate;
    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private CourseInfoPage courseInfoPage;

    @BeforeEach
    public void setup() {
        initialisation(); //initialise the web driver
        loginPage = new LoginPage();
        schedulerPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password"));
        PageFactory.initElements(webDriver, schedulerPage);
        navTemplate = new NavTemplate();
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
        // TODO: 30/09/2021 Implement Test
        System.out.println(courseInfoPage.getCourseTypesNames());
    }

    @Test
    @DisplayName("getCourseTypeWebElement Test")
    void getCourseTypeWebElementTest() {
        // TODO: 30/09/2021 Implement Test
        System.out.println(courseInfoPage.getCourseTypeWebElement("Business"));
    }

    @Test
    @DisplayName("getCourseTypeCount Test")
    void getCourseTypeCountTest() {
        // TODO: 30/09/2021 Implement Test

    }

    @Test
    @DisplayName("getDisciplineElements Test")
    void getDisciplineElementsTest() {
        // TODO: 30/09/2021 Implement Test

    }

    @Test
    @DisplayName("getDisciplineNames Test")
    void getDisciplineNamesTest() {
        System.out.println(courseInfoPage.getDisciplineNames());
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("getDisciplineCount Test")
    void getDisciplineCountTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("getDisciplineElement ID Test")
    void getDisciplineElementIDTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("getDisciplineElement Name Test")
    void getDisciplineElementNameTest() {
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("getDisciplineName Test")
    void getDisciplineNameTest() {
        System.out.println(courseInfoPage.getDisciplineName(0));
        // TODO: 30/09/2021 Implement Test
    }

    @Test
    @DisplayName("getDisciplineElementsWithDuration Test")
    void getDisciplineElementsWithDurationTest() {
        // TODO: 30/09/2021 Implement Test
        System.out.println(courseInfoPage.getDisciplinesElementsWithDuration(12));
    }

    @Test
    @DisplayName("getDisciplineNamesWithDuration Test")
    void getDisciplineNamesWithDurationTest() {
        // TODO: 30/09/2021 Implement Test
        System.out.println(courseInfoPage.getDisciplinesNamesWithDuration(12));
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
        // TODO: 30/09/2021 Implement Test
        System.out.println(courseInfoPage.getDisciplineNamesBetweenDurations(10, 15));
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
