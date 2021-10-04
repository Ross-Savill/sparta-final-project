package com.spartaglobal.finalweek.tests.courseTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.pages.coursePages.EditCoursesPage;
import com.spartaglobal.finalweek.pages.coursePages.ModifyCoursePage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class EditCoursesTests extends NavTemplate {
    private LoginPage loginPage;
    private NavTemplate navTemplate;
    private CoursePage coursePage;
    private EditCoursesPage editCoursePage;

    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        loginPage = new LoginPage();

        loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        );

        navTemplate = new NavTemplate();

        coursePage = navTemplate.goToCoursesPage();
        coursePage = new CoursePage();

        //TODO: Delete all courses on courses page.

        /*editCoursePage = coursePage.clickEditCourseButton();
        editCoursePage = new ModifyCoursePage();*/
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
