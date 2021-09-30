package com.spartaglobal.finalweek.tests.courseTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.coursePages.AddCoursePage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddCoursesTests{
    private LoginPage loginPage;
    private NavTemplate navTemplate;
    private CoursePage coursePage;
    private AddCoursePage addCoursePage;

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

        addCoursePage = coursePage.clickAddCourseButton();
        addCoursePage = new AddCoursePage();
    }

    @Nested
    @DisplayName("Testing Enter and Getter methods for course name fields")
    class GettingAndEnteringCourseNameFields {

        @Test
        @DisplayName("Test get course name returns Sentinel value")
        void testEnterCourseNameField() {
            addCoursePage.enterCourseName("Sentinel");
            Assertions.assertEquals("Sentinel", addCoursePage.getCourseName());
        }

        @Test
        @DisplayName("Test getting empty course name returns an empty course name")
        void testEmptyEnterCourseNameField() {
            addCoursePage.enterCourseName("");
            Assertions.assertEquals("", addCoursePage.getCourseName());
        }

        @Test
        @DisplayName("Test entering no course name returns empty course name")
        void testNoEntryCourseNameField() {
            Assertions.assertEquals("", addCoursePage.getCourseName());
        }
    }

    @Nested
    @DisplayName("Empty entries test")
    class EmptyTests {

        @Test
        @DisplayName("empty course name returns true")
        void emptyCourseNameReturnsTrue() {
            Assertions.assertTrue(addCoursePage.isCourseNameEmpty());
        }

        @Test
        @DisplayName("non-empty course name returns false")
        void nonEmptyCourseNameReturnsFalse() {
            addCoursePage.enterCourseName("Eng-92");
            Assertions.assertFalse(addCoursePage.isCourseNameEmpty());
        }
    }

    @Nested
    @DisplayName("Blank entries test")
    class BlankTests {

        @Test
        @DisplayName("blank course name returns true")
        void blankCourseNameReturnsTrue() {
            addCoursePage.enterCourseName("   ");
            Assertions.assertTrue(addCoursePage.isCourseNameBlank());
        }

        @Test
        @DisplayName("non-blank course name returns false")
        void nonBlankCourseNameReturnsFalse() {
            addCoursePage.enterCourseName("Eng-92");
            Assertions.assertFalse(addCoursePage.isCourseNameBlank());
        }
    }

 /*   @Nested
    @DisplayName("EmptyErrorMessage warning test")
    class EmptyWarningTests {

        @Test
        @DisplayName("empty course name gives warning")
        void emptyCourseNameGivesWarning() {
            addCoursePage.enterCourseName("");
            addCoursePage.clickSubmit();
            Assertions.assertTrue(addCoursePage.getEmptyErrorMessage());
        }

        @Test
        @DisplayName("non-empty course name does not give a warning")
        void nonEmptyCourseNameNoWarning() {
            addCoursePage.enterCourseName("Eng-92");
            addCoursePage.clickSubmit();
            Assertions.assertFalse(addCoursePage.getEmptyErrorMessage());
        }

        @Test
        @DisplayName("Blank course name gives warning")
        void blankCourseNameGivesWarning() {
            addCoursePage.enterCourseName("   ");
            addCoursePage.clickSubmit();
            Assertions.assertTrue(addCoursePage.getEmptyErrorMessage());
        }
    }*/

    @Nested
    @DisplayName("Valid Entries test")
    class ValidEntriesTest {


    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
