package com.spartaglobal.finalweek.tests.courseTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePageObject;
import com.spartaglobal.finalweek.pages.coursePages.EditCoursesPage;
import com.spartaglobal.finalweek.pages.coursePages.ModifyCoursePage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

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

        WebElement firstCourseName = coursePage.getAllCoursesNames().get(0);


        try {
            editCoursePage = coursePage.clickEditCourseButton(firstCourseName.getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        editCoursePage = new EditCoursesPage();
    }

    @Nested
    @DisplayName("Testing Enter and Getter methods for course name field")
    class GettingAndEnteringCourseNameFields {

        @Test
        @DisplayName("Test get course name returns Sentinel value")
        void testEnterSentinelCourseNameField() {
            editCoursePage.getCourseNameElement().clear();
            editCoursePage.enterCourseName("Sentinel");
            Assertions.assertEquals("Sentinel", editCoursePage.getCourseName());
        }

        @Test
        @DisplayName("Test course name returns default course name Jedi Training")
        void testEmptyEnterCourseNameField() {
            editCoursePage.getCourseNameElement().clear();
            editCoursePage.enterCourseName("");
            Assertions.assertEquals("", editCoursePage.getCourseName());
        }
    }

    @Nested
    @DisplayName("Testing increment, decrement, Enter and Getter methods for number of trainers field")
    class GettingAndEnteringNumberOfTrainersFields {

        @Test
        @DisplayName("Test getting default number of trainers is 2")
        void testDefaultNumberOfTrainersField() {
            Assertions.assertEquals(2, Integer.parseInt(editCoursePage.getNumberOfTrainers()));
        }

        @Test
        @DisplayName("Test increment  number of trainers")
        void testIncrementNumberOfTrainerValue() {
            editCoursePage.incrementNumberOfTrainers();
            Assertions.assertEquals(3, Integer.parseInt(editCoursePage.getNumberOfTrainers()));
        }

        @Test
        @DisplayName("Test decrement number of trainers")
        void testDecrementNumberOfTrainerValue() {
            editCoursePage.decrementNumberOfTrainers();
            Assertions.assertEquals(1, Integer.parseInt(editCoursePage.getNumberOfTrainers()));
        }

        @Test
        @DisplayName("Test enter number of trainers")
        void testEnterNumberOfTrainers() {
            editCoursePage.enterNumberOfTrainers(6);
            Assertions.assertEquals(6, Integer.parseInt(editCoursePage.getNumberOfTrainers()));
        }
    }

    @Nested
    @DisplayName("Testing select and getter methods for trainer ID")
    class GettingAndSelectingTrainerID {

        @BeforeEach
        void setUp() {
            editCoursePage.decrementNumberOfTrainers();
        }

        @Test
        @DisplayName("Test getting 1st trainer id returns default value 'JarJar Binks'")
        void testGettingTrainerIdReturnsDefaultValueMikeWazowski() {
            Assertions.assertEquals("JarJar Binks", editCoursePage.getTrainerID(1));
        }

        @Test
        @DisplayName("Test selecting 'Mace Windu' trainer id return 'Mace Windu'")
        void testSelectingMaceWinduTrainerIdReturnMaceWindu() {
            editCoursePage.selectTrainerID(1, "Mace Windu");
            Assertions.assertEquals("Mace Windu", editCoursePage.getTrainerID(1));
        }

        @ParameterizedTest
        @CsvSource(value = {"1, Mike Wazowski", "2, Mace Windu", "3, Obi-Wan Kenobi"})
        @DisplayName("Test adding multiple trainers and getting trainer id")
        void testMultipleTrainerIds(String row, String trainerId) {
            int numberOfTrainers = Integer.parseInt(row);
            for (int i = 1; i < numberOfTrainers; i++){
                editCoursePage.incrementNumberOfTrainers();
            }
            editCoursePage.selectTrainerID(numberOfTrainers, trainerId);
            Assertions.assertEquals(trainerId, editCoursePage.getTrainerID(numberOfTrainers));
        }

        @Test
        @DisplayName("Test getting trainer start week returns default value one")
        void testGettingTrainerStartWeekReturnsDefaultValueOne() {
            Assertions.assertEquals(1, Integer.parseInt(editCoursePage.getTrainerStartWeek(1)));
        }

        @Test
        @DisplayName("Test enter start week")
        void testEnterStartWeek() {
            editCoursePage.enterTrainerStartWeek(1, 12);
            Assertions.assertEquals(12, Integer.parseInt(editCoursePage.getTrainerStartWeek(1)));
        }

        @ParameterizedTest
        @CsvSource(value = {"1, 12", "2, 6", "3, 52"})
        @DisplayName("Test adding multiple trainers and getting trainer id")
        void testMultipleTrainerStarWeeks(String row, String trainerStartWeek) {
            int numberOfTrainers = Integer.parseInt(row);
            int trainerStartWeekNum = Integer.parseInt(trainerStartWeek);

            for (int i = 1; i < numberOfTrainers; i++){
                editCoursePage.incrementNumberOfTrainers();
            }
            editCoursePage.enterTrainerStartWeek(numberOfTrainers, trainerStartWeekNum);
            Assertions.assertEquals(trainerStartWeekNum, Integer.parseInt(editCoursePage.getTrainerStartWeek(numberOfTrainers)));
        }

        @Test
        @DisplayName("Test enter end week")
        void testEnterEndWeek() {
            editCoursePage.enterTrainerEndWeek(1, 12);
            Assertions.assertEquals(12, Integer.parseInt(editCoursePage.getTrainerEndWeek(1)));
        }

        @ParameterizedTest
        @CsvSource(value = {"1, 12", "2, 6", "3, 52"})
        @DisplayName("Test adding multiple trainers and getting trainer id")
        void testMultipleTrainerEndWeeks(String row, String trainerEndWeek) {
            int numberOfTrainers = Integer.parseInt(row);
            int trainerEndWeekNum = Integer.parseInt(trainerEndWeek);

            for (int i = 1; i < numberOfTrainers; i++){
                editCoursePage.incrementNumberOfTrainers();
            }
            editCoursePage.enterTrainerEndWeek(numberOfTrainers, trainerEndWeekNum);
            Assertions.assertEquals(trainerEndWeekNum, Integer.parseInt(editCoursePage.getTrainerEndWeek(numberOfTrainers)));
        }
    }

    @Nested
    @DisplayName("Testing Getters and Selectors for Discipline Field")
    class GettingAndSelectingDiscipline {

        @Test
        @DisplayName("Testing getting discipline returns default value DevOps")
        void testingGettingDisciplineReturnsDefaultValueC() {
            Assertions.assertEquals("DevOps",  editCoursePage.getDiscipline());
        }

        @Test
        @DisplayName("Testing select methods.")
        void testingSelectMethods() {
            editCoursePage.selectDiscipline("C#");
            System.out.println(editCoursePage.getDiscipline());
            Assertions.assertEquals("C#",  editCoursePage.getDiscipline());
        }
    }

    @Nested
    @DisplayName("Testing Getters and Selectors for CourseType Field")
    class GettingAndSelectingCourseType {

        @Test
        @DisplayName("Testing getting CourseType returns default value Business")
        void testingGettingCourseTypeReturnsDefaultValueC() {
            Assertions.assertEquals("Business",  editCoursePage.getCourseType());
        }

        @Test
        @DisplayName("Testing select methods.")
        void testingSelectMethods() {
            editCoursePage.selectCourseType("Technology");
            Assertions.assertEquals("Technology",  editCoursePage.getCourseType());
        }
    }

    @Nested
    @DisplayName("Testing Getters and Selectors for Location Field")
    class GettingAndSelectingLocation {

        @Test
        @DisplayName("Testing getting Location returns default value Business")
        void testingGettingLocationReturnsDefaultValueC() {
            Assertions.assertEquals("Coruscant",  editCoursePage.getLocation());
        }

        @Test
        @DisplayName("Testing select methods.")
        void testingSelectMethods() {
            editCoursePage.selectLocation("Naboo");
            Assertions.assertEquals("Naboo",  editCoursePage.getLocation());
        }
    }

    @Nested
    @DisplayName("Testing Getters and Enter methods for Start Date Field")
    class GettingAndSelectingStartDate {

        @Test
        @DisplayName("GetStartDate returns 26/04/2021")
        void getStartDateReturnsDateNow() {
            LocalDate startDate = LocalDate.of(2021, 4, 26);
            Assertions.assertEquals(startDate.toString(), editCoursePage.getStartDate());
        }

        @ParameterizedTest
        @CsvSource(value = {"1997, 9, 22", "2021, 10, 2", "2021, 10, 26"})
        @DisplayName("Test EnterStartDate() method returns 22/09/1997")
        public void testEnterStartDate(int year, int month, int day) {
            LocalDate startDate = LocalDate.of(year, month, day);
            editCoursePage.enterStartDate(startDate);
            Assertions.assertEquals(startDate.toString(), editCoursePage.getStartDate());
        }
    }

    @Nested
    @DisplayName("Empty entries test")
    class EmptyTests {
        @BeforeEach
        void setUp() {
            editCoursePage.getCourseNameElement().clear();
            editCoursePage.decrementNumberOfTrainers();
            editCoursePage.getTrainerStartWeekElement(1).clear();
            editCoursePage.getTrainerEndWeekElement(1).clear();
            editCoursePage.getStartDateElement().clear();
        }

        @Test
        @DisplayName("empty course name returns true")
        void emptyCourseNameReturnsTrue() {
            Assertions.assertTrue(editCoursePage.isCourseNameEmpty());
        }

        @Test
        @DisplayName("non-empty course name returns false")
        void nonEmptyCourseNameReturnsFalse() {
            editCoursePage.enterCourseName("Eng-92");
            Assertions.assertFalse(editCoursePage.isCourseNameEmpty());
        }

        @Test
        @DisplayName("empty trainer start week returns true")
        void emptyTrainerStartWeekReturnsTrue() {
            Assertions.assertTrue(editCoursePage.isTrainerStartWeekEmpty(1));
        }

        @Test
        @DisplayName("empty trainer start week returns false")
        void emptyTrainerStartWeekReturnsFalse() {
            editCoursePage.enterTrainerStartWeek(1, 1);
            Assertions.assertFalse(editCoursePage.isTrainerStartWeekEmpty(1));
        }

        @Test
        @DisplayName("empty trainer end week returns true")
        void emptyTrainerEndWeekReturnsTrue() {
            Assertions.assertTrue(editCoursePage.isTrainerEndWeekEmpty(1));
        }

        @Test
        @DisplayName("empty trainer end week returns false")
        void emptyTrainerEndWeekReturnsFalse() {
            editCoursePage.enterTrainerEndWeek(1, 12);
            Assertions.assertFalse(editCoursePage.isTrainerEndWeekEmpty(1));
        }

        @Test
        @DisplayName("empty Start Date returns true")
        void emptyStartDateReturnsTrue() {
            Assertions.assertTrue(editCoursePage.isStartDateEmpty());
        }

        @Test
        @DisplayName("empty Start Date returns false")
        void emptyStartDateReturnsFalse() {
            editCoursePage.enterStartDate(LocalDate.now());
            Assertions.assertFalse(editCoursePage.isStartDateEmpty());
        }
    }

    @Nested
    @DisplayName("Blank entries test")
    class BlankTests {
        @BeforeEach
        void setUp() {
            editCoursePage.getCourseNameElement().clear();
        }

        @Test
        @DisplayName("blank course name returns true")
        void blankCourseNameReturnsTrue() {
            editCoursePage.enterCourseName("   ");
            Assertions.assertTrue(editCoursePage.isCourseNameBlank());
        }

        @Test
        @DisplayName("non-blank course name returns false")
        void nonBlankCourseNameReturnsFalse() {
            editCoursePage.enterCourseName("Eng-92");
            Assertions.assertFalse(editCoursePage.isCourseNameBlank());
        }
    }

    @Nested
    @DisplayName("Valid entries test")
    class ValidTests {

        @BeforeEach
        void setUp() {
            editCoursePage.decrementNumberOfTrainers();
        }

        @Test
        @DisplayName("Valid number of trainers returns true")
        void validNumberOfTrainersReturnsTrue() {
            editCoursePage.enterNumberOfTrainers(5);
            Assertions.assertTrue(editCoursePage.isNumberOfTrainersValid());
        }

        @Test
        @DisplayName("invalid low number of trainers returns false")
        void invalidLowNumberOfTrainersReturnsFalse() {
            editCoursePage.enterNumberOfTrainers(0);
            Assertions.assertFalse(editCoursePage.isNumberOfTrainersValid());
        }

        @Test
        @DisplayName("invalid high number of trainers returns false")
        void invalidHighNumberOfTrainersReturnsFalse() {
            editCoursePage.enterNumberOfTrainers(11);
            Assertions.assertFalse(editCoursePage.isNumberOfTrainersValid());
        }

        @Test
        @DisplayName("Valid number of Trainer Start Week returns true")
        void validNumberOfTrainerStartWeekReturnsTrue() {
            editCoursePage.enterTrainerStartWeek(1, 12);
            Assertions.assertTrue(editCoursePage.isTrainerStartWeekValid(1));
        }

        @Test
        @DisplayName("Invalid low number of Trainer Start Week returns false")
        void InvalidLowNumberOfTrainerStartWeekReturnsFalse() {
            editCoursePage.enterTrainerStartWeek(1, 0);
            Assertions.assertFalse(editCoursePage.isTrainerStartWeekValid(1));
        }

        @Test
        @DisplayName("Invalid high number of Trainer Start Week returns false")
        void InvalidHighNumberOfTrainerEndWeekReturnsFalse() {
            editCoursePage.enterTrainerStartWeek(1, 53);
            Assertions.assertFalse(editCoursePage.isTrainerStartWeekValid(1));
        }

        @Test
        @DisplayName("Valid number of Trainer End Week returns true")
        void validNumberOfTrainerEndWeekReturnsTrue() {
            editCoursePage.enterTrainerEndWeek(1, 12);
            Assertions.assertTrue(editCoursePage.isTrainerEndWeekValid(1));
        }

        @Test
        @DisplayName("Invalid low number of Trainer End Week returns false")
        void InvalidLowNumberOfTrainerEndWeekReturnsFalse() {
            editCoursePage.enterTrainerEndWeek(1, 0);
            Assertions.assertFalse(editCoursePage.isTrainerEndWeekValid(1));
        }

        @Test
        @DisplayName("Invalid high number of Trainer End Week returns false")
        void InvalidHighNumberOfTrainerStartWeekReturnsFalse() {
            editCoursePage.enterTrainerEndWeek(1, 53);
            Assertions.assertFalse(editCoursePage.isTrainerEndWeekValid(1));
        }
    }

    @Nested
    @DisplayName("Alert test for number of trainers entries")
    class ValidEntriesTest {

        @Test
        @DisplayName("Max value reached alert for above max number of trainers entry")
        void isAlertForMaxNumber() {
            editCoursePage.enterNumberOfTrainers(11);
            editCoursePage.clickSubmit();
            Assertions.assertTrue(editCoursePage.isAlertDisplayed());
        }

        @Test
        @DisplayName("Min value reached alert for above max number of trainers entry")
        void isAlertForMinNumber() {
            editCoursePage.enterNumberOfTrainers(0);
            editCoursePage.clickSubmit();
            Assertions.assertTrue(editCoursePage.isAlertDisplayed());
        }
    }

    @Nested
    @DisplayName("Testing submission")
    class SubmissionTest {

        @Test
        @DisplayName("Test submit button navigates to courses page.")
        void testSubmitButtonNavigatesToCoursesPage() {
            CoursePageObject emptyCoursePageObject = new CoursePageObject();
            CoursePageObject defaultCoursePageObject = new CoursePageObject(emptyCoursePageObject);
            editCoursePage.enterAllFields(defaultCoursePageObject);
            coursePage = editCoursePage.submitReturnsCoursePage();
            coursePage = new CoursePage();
            Assertions.assertEquals(
                    PropertiesLoader.getProperties().getProperty("coursesPageURL"),
                    coursePage.getURL());
        }

        @Test
        @DisplayName("Test is submission successful")
        void testIsSubmissionSuccessful() {
            CoursePageObject coursePageObject = new CoursePageObject();
            coursePageObject.setCourseName("Eng 92");
            coursePageObject.setNumberOfTrainers(1);
            coursePageObject.setRow(1);
            coursePageObject.setTrainerID("Sheev Palpatine");
            coursePageObject.setTrainerStartWeek(1);
            coursePageObject.setTrainerEndWeek(7);
            coursePageObject.setDiscipline("JavaSDET");
            coursePageObject.setTypeOfCourse("Technology");
            coursePageObject.setLocation("Naboo");
            coursePageObject.setStartDate(LocalDate.of(2021, 9, 22));
            editCoursePage.enterAllFields(coursePageObject);
            Assertions.assertTrue(editCoursePage.isSubmissionSuccessful());
        }
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
