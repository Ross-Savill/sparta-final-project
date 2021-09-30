package com.spartaglobal.finalweek.tests.courseTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CourseTests  {
    private NavTemplate navTemplate;
    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private CoursePage coursePage;

    @BeforeEach
    public void setup() {
        TestBase.initialisation(); //initialise the web driver
        loginPage = new LoginPage();
        schedulerPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        );

        PageFactory.initElements(webDriver, schedulerPage);

        navTemplate = new NavTemplate();
        coursePage = navTemplate.goToCoursesPage();
        coursePage = new CoursePage();
    }

    @Test
    @DisplayName("Test AddCourseButton()")
    public void testClickAddCourseButton(){
        Assertions.assertEquals("http://localhost:8080/addCourse", coursePage.clickAddCourseButton().getURL());
    }

    @Test
    @Disabled //needs work
    @DisplayName("Test EditCourseButton()")
    public void testClickEditCourseButton(){
        String courseName = "Engineering 87";
        Assertions.assertEquals("http://localhost:8080/editCourse/1", coursePage.clickEditCourseButton(courseName).getURL());
    }

    @Test
    @Disabled
    @DisplayName("Testing getAllCourses() returns all courses")
    public void testGetAllCourses(){
        for(int i = 0; i < coursePage.getAllCourses().size(); i++){
            System.out.println(coursePage.getAllCourses().get(i).getText());
        }
    }

    @Test
    @DisplayName("Testing getAllCourseNames() returns all course names")
    public void testGetAllCourseNames(){
        for(int i = 0; i < coursePage.getAllCoursesNames().size(); i++) {
            System.out.println(coursePage.getAllCoursesNames().get(i).getText());
        }
    }

    @Test
    @DisplayName("Testing getCoursesByDiscipline() returns only courses with matching discipline")
    public void testGetCoursesByDiscipline(){
        String discipline =  "DevOps";
        for(int i = 0; i < coursePage.getCoursesByDiscipline(discipline).size(); i++) {
            System.out.println(coursePage.getCoursesByDiscipline(discipline).get(i).getText());
        }
    }

    @Test
    @DisplayName("Testing getCoursesByType() returns only courses with matching course types")
    public void testGetCoursesByType(){
        String courseType = "Business";
        for(int i = 0; i < coursePage.getCoursesByCourseType(courseType).size(); i++) {
            System.out.println(coursePage.getCoursesByCourseType(courseType).get(i).getText());
        }
    }

    @Test
    @DisplayName("Testing getCoursesByLocation() returns only courses with matching locations")
    public void testGetCoursesByLocation(){
        String location = "Naboo";
        for(int i = 0; i < coursePage.getCoursesByLocation(location).size(); i++) {
            System.out.println(coursePage.getCoursesByLocation(location).get(i).getText());
        }
    }

    @Test
    @DisplayName("Testing getCoursesByTrainer() returns only courses with matching trainer names")
    public void testGetCoursesByTrainer(){
        String trainerName = "Kit Fisto";
        for(int i = 0; i < coursePage.getCoursesByTrainer(trainerName).size(); i++) {
            System.out.println(coursePage.getCoursesByTrainer(trainerName).get(i).getText());
        }
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
