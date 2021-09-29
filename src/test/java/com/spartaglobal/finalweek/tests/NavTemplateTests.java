package com.spartaglobal.finalweek.tests;

import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

public class NavTemplateTests extends NavTemplate {
    private NavTemplate navTemplate;
    private LoginPage loginPage;
    private SchedulerPage schedulerPage;

    @BeforeEach
    public void setup() {
        initialisation(); //initialise the web driver
        loginPage = new LoginPage();
        //TODO: Get properties for username and password
        schedulerPage = loginPage.login("Alex", "password");
        PageFactory.initElements(webDriver, schedulerPage);
        navTemplate = new NavTemplate();
    }

    @Test
    @DisplayName("Is scheduler page accessible")
    void isSchedulerPageAccessible() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("schedulerPageURL"),
                navTemplate.goToSchedulerPage().getURL());
    }

    @Test
    @DisplayName("Is scheduler page accessible via logo")
    void isSchedulerPageAccessibleViaLogo() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("schedulerPageURL"),
                navTemplate.logoToSchedulerPage().getURL());
    }

    @Test
    @DisplayName("Is trainees page accessible")
    void isTraineesPageAccessible() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("traineesPageURL"),
                navTemplate.goToTraineesPage().getURL());
    }

    @Test
    @DisplayName("Is trainers page accessible")
    void isTrainersPageAccessible() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("trainersPageURL"),
                navTemplate.goToTrainersPage().getURL());
    }

    @Test
    @DisplayName("Is courses page accessible")
    void isCoursesPageAccessible() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("coursesPageURL"),
                navTemplate.goToCoursesPage().getURL());
    }

    @Test
    @DisplayName("Is courseInfo page accessible")
    void isCourseInfoPageAccessible() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("courseInfoPageURL"),
                navTemplate.goToCourseInfoPage().getURL());
    }

    @Test
    @DisplayName("Is centres page accessible")
    void isCentresPageAccessible() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("centresPageURL"),
                navTemplate.goToCentresPage().getURL());
    }

    @Test
    @DisplayName("Is account page accessible")
    void isAccountPageAccessible() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("accountPageURL"),
                navTemplate.goToAccountPage().getURL());
    }

    @Test
    @DisplayName("Is login page accessible via logout")
    void isLoginPageAccessibleViaLogout() {
        Assertions.assertEquals(
                PropertiesLoader.getProperties().getProperty("URL"),
                navTemplate.logOutOfSite().getURL());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
