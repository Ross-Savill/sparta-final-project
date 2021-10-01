package com.spartaglobal.finalweek.tests.courseTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.coursePages.AddCoursePage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CourseTests  {
    private NavTemplate navTemplate;
    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private CoursePage coursePage;
    private AddCoursePage addCoursePage;

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
//        addCoursePage = coursePage.clickAddCourseButton();
//        addCoursePage = new AddCoursePage();
    }

    @Nested
    @DisplayName("Button Tests")
    class buttonTests {

        @Test
        @DisplayName("Test AddCourseButton()")
        public void testClickAddCourseButton() {
            Assertions.assertEquals("http://localhost:8080/addCourse", coursePage.clickAddCourseButton().getURL());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Jedi Training", "Engineering 87", "Engineering 90", "SDET 34",
                "Engineering 51", "Sith Training", "Business 31", "Maintenance 12", "Padawan Training",
                "SDET 54", "Business 65", "Engineering 62", "Business 12", "Hacking 4"}
        )
        @DisplayName("Test EditCourseButton()")
        public void testClickEditCourseButton(String courseName) throws InterruptedException {
            Assertions.assertTrue(coursePage.clickEditCourseButton(courseName).getURL().startsWith("http://localhost:8080/editCourse/"));
        }

        @ParameterizedTest
        @Disabled //needs methods from AddCoursePage()
        @ValueSource(strings = {"Engineering 101", "Data 100", "SDET Stream"})
        @DisplayName("Test DeleteCourse()")
        public void testDeleteCourse(String courseName) {
            //String courseName = "Engineering 101";
            LocalDate courseStartDate = LocalDate.now();
//            addCoursePage.enterCourseName(courseName);
//            addCoursePage.enterStartDate(courseStartDate);
//            addCoursePage.clickSubmit();
            coursePage.deleteCourse(courseName);
        }
    }

    @Nested
    @DisplayName("Hyperlink tests")
    class hyperlinkTests{

        @Test
        @DisplayName("Test the addCourseHyperlink")
        public void testClickAddCourseHyperlink(){
            Assertions.assertEquals("http://localhost:8080/addCourse", coursePage.clickAddCourseHyperlink().getURL());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Jedi Training", "Engineering 87", "Engineering 90", "SDET 34",
                "Engineering 51", "Sith Training", "Business 31", "Maintenance 12", "Padawan Training",
                "SDET 54", "Business 65", "Engineering 62", "Business 12", "Hacking 4"}
        )
        @DisplayName("Test the clickEditCourseHyperlink()")
        public void testClickEditCourseHyperlink(String courseName) throws InterruptedException {
            Assertions.assertTrue(coursePage.clickEditCourseHyperlink(courseName).getURL().startsWith("http://localhost:8080/editCourse/"));
        }
    }

    @Nested
    @DisplayName("Getter Tests")
    class getterTests {

        @Test
        @DisplayName("Testing getAllCourses() returns all courses")
        public void testGetAllCourses() {
            for (int i = 0; i < coursePage.getAllCourses().size(); i++) {
                System.out.println(coursePage.getAllCourses().get(i).getText());
            }
            Assertions.assertEquals(14, coursePage.getAllCourses().size());
        }

        @Test
        @DisplayName("Testing getAllCourseNames() returns all course names")
        public void testGetAllCourseNames() {
            for (int i = 0; i < coursePage.getAllCoursesNames().size(); i++) {
                System.out.println(coursePage.getAllCoursesNames().get(i).getText());
            }
            Assertions.assertEquals(14, coursePage.getAllCoursesNames().size());
        }

        @Test
        @DisplayName("Testing getCoursesByCourseName() returns only courses with matching names")
        public void testGetCoursesByCourseName() {
            String courseName = "Jedi Training";
            for (int i = 0; i < coursePage.getCoursesByCourseName(courseName).size(); i++) {
                System.out.println(coursePage.getCoursesByCourseName(courseName).get(i).getText());
            }
            Assertions.assertEquals(1, coursePage.getCoursesByCourseName(courseName).size());
        }

        @Test
        @DisplayName("Testing getCourseIndexByCourseName() returns the correct index")
        public void testGetCourseIndexByCourseName(){
            String courseName = "Sith Training";
            Assertions.assertEquals(5, coursePage.getCourseIndexByCourseName(courseName));
        }

        @Test
        @DisplayName("Testing getCoursesByDiscipline() returns only courses with matching discipline")
        public void testGetCoursesByDiscipline() {
            String discipline = "DevOps";
            for (int i = 0; i < coursePage.getCoursesByDiscipline(discipline).size(); i++) {
                System.out.println(coursePage.getCoursesByDiscipline(discipline).get(i).getText());
            }
            Assertions.assertEquals(6, coursePage.getCoursesByDiscipline(discipline).size());
        }

        @Test
        @DisplayName("Testing getCoursesByType() returns only courses with matching course types")
        public void testGetCoursesByType() {
            String courseType = "Business";
            for (int i = 0; i < coursePage.getCoursesByCourseType(courseType).size(); i++) {
                System.out.println(coursePage.getCoursesByCourseType(courseType).get(i).getText());
            }
            Assertions.assertEquals(7, coursePage.getCoursesByCourseType(courseType).size());
        }

        @Test
        @DisplayName("Testing getCoursesByLocation() returns only courses with matching locations")
        public void testGetCoursesByLocation() {
            String location = "Naboo";
            for (int i = 0; i < coursePage.getCoursesByLocation(location).size(); i++) {
                System.out.println(coursePage.getCoursesByLocation(location).get(i).getText());
            }
            Assertions.assertEquals(2, coursePage.getCoursesByLocation(location).size());
        }

        @Test
        @DisplayName("Testing getCoursesByTrainer() returns only courses with matching trainer names")
        public void testGetCoursesByTrainer() {
            String trainerName = "Kit Fisto";
            for (int i = 0; i < coursePage.getCoursesByTrainer(trainerName).size(); i++) {
                System.out.println(coursePage.getCoursesByTrainer(trainerName).get(i).getText());
            }
            Assertions.assertEquals(2, coursePage.getCoursesByTrainer(trainerName).size());
        }
    }

    @Test
    @DisplayName("Testing if all courses are unique")
    public void testAreCoursesUnique(){
        Assertions.assertTrue(coursePage.areCourseNamesUnique());
    }

    @ParameterizedTest
    @Disabled //needs methods from AddCoursePage()
    @ValueSource(strings = {"Engineering 101", "Data 100", "SDET Stream"})
    @DisplayName("Testing if I can tell when a course has been deleted")
    public void testIsCourseDeleted(String courseToDelete){
        //String courseToDelete = "Engineering 101";
        LocalDate courseStartDate = LocalDate.now();
//        addCoursePage.enterCourseName(courseToDelete);
//        addCoursePage.enterStartDate(courseStartDate);
//        addCoursePage.clickSubmit();

        boolean firstAttempt = coursePage.isCourseDeleted(courseToDelete);
        coursePage.deleteCourse(courseToDelete);
        boolean secondAttempt = coursePage.isCourseDeleted(courseToDelete);
        //Assertions.assertTrue(coursePage.isCourseDeleted(courseToDelete));
        Assertions.assertTrue(!firstAttempt && secondAttempt);
    }

    @Nested
    @Disabled
    @DisplayName("Confirmation Box Tests")
    class confirmationBoxTests {

        @Test
        @DisplayName("Testing if a confirmation box appears before deleting a course")
        public void testDoesConfirmationBoxAppearOnDelete() {
            String courseToDelete = "Engineering 87";
            Assertions.assertTrue(coursePage.doesConfirmationBoxAppearOnDelete(courseToDelete));
        }

        @Test
        @DisplayName("Testing if I can confirm before deleting a course")
        public void testConfirmDelete() {
            Assertions.assertTrue(coursePage.confirmDelete());
        }

        @Test
        @DisplayName("Testing if I can cancel before deleting a course")
        public void testCancelDelete() {
            Assertions.assertTrue(coursePage.cancelDelete());
        }
    }


    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
