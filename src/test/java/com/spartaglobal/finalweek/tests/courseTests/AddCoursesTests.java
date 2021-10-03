package com.spartaglobal.finalweek.tests.courseTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.coursePages.AddCoursePage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePageObject;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

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

        //TODO: Delete all courses on courses page.

        addCoursePage = coursePage.clickAddCourseButton();
        addCoursePage = new AddCoursePage();
    }

    @Nested
    @DisplayName("Testing Enter and Getter methods for course name field")
    class GettingAndEnteringCourseNameFields {

        @Test
        @DisplayName("Test get course name returns Sentinel value")
        void testEnterSentinelCourseNameField() {
            addCoursePage.enterCourseName("Sentinel");
            Assertions.assertEquals("Sentinel", addCoursePage.getCourseName());
        }

        @Test
        @DisplayName("Test getting empty course name returns an empty course name")
        void testEmptyEnterCourseNameField() {
            addCoursePage.enterCourseName("");
            Assertions.assertEquals("", addCoursePage.getCourseName());
        }
    }

    @Nested
    @DisplayName("Testing increment, decrement, Enter and Getter methods for number of trainers field")
    class GettingAndEnteringNumberOfTrainersFields {

        @Test
        @DisplayName("Test getting default number of trainers is 1")
        void testDefaultNumberOfTrainersField() {
            Assertions.assertEquals(1, Integer.parseInt(addCoursePage.getNumberOfTrainers()));
        }

        @Test
        @DisplayName("Test increment  number of trainers")
        void testIncrementNumberOfTrainerValue() {
            addCoursePage.incrementNumberOfTrainers();
            Assertions.assertEquals(2, Integer.parseInt(addCoursePage.getNumberOfTrainers()));
        }

        @Test
        @DisplayName("Test decrement number of trainers")
        void testDecrementNumberOfTrainerValue() {
            addCoursePage.incrementNumberOfTrainers();
            addCoursePage.decrementNumberOfTrainers();
            Assertions.assertEquals(1, Integer.parseInt(addCoursePage.getNumberOfTrainers()));
        }

        @Test
        @DisplayName("Test enter number of trainers")
        void testEnterNumberOfTrainers() {
            addCoursePage.enterNumberOfTrainers(6);
            Assertions.assertEquals(6, Integer.parseInt(addCoursePage.getNumberOfTrainers()));
        }
    }

    @Nested
    @DisplayName("Testing select and getter methods for trainer ID")
    class GettingAndSelectingTrainerID {

        @Test
        @DisplayName("Test getting 1st trainer id returns default value 'Mike Wazowski'")
        void testGettingTrainerIdReturnsDefaultValueMikeWazowski() {
            Assertions.assertEquals("Aayla Secura", addCoursePage.getTrainerID(1));
        }

        @Test
        @DisplayName("Test selecting 'Mace Windu' trainer id return 'Mace Windu'")
        void testSelectingMaceWinduTrainerIdReturnMaceWindu() {
            addCoursePage.selectTrainerID(1, "Mace Windu");
            Assertions.assertEquals("Mace Windu", addCoursePage.getTrainerID(1));
        }

        @ParameterizedTest
        @CsvSource(value = {"1, Mike Wazowski", "2, Mace Windu", "3, Obi-Wan Kenobi"})
        @DisplayName("Test adding multiple trainers and getting trainer id")
        void testMultipleTrainerIds(String row, String trainerId) {
            int numberOfTrainers = Integer.parseInt(row);
            for (int i = 1; i < numberOfTrainers; i++){
                addCoursePage.incrementNumberOfTrainers();
            }
            addCoursePage.selectTrainerID(numberOfTrainers, trainerId);
            Assertions.assertEquals(trainerId, addCoursePage.getTrainerID(numberOfTrainers));
        }

        @Test
        @DisplayName("Test getting trainer start week returns default value one")
        void testGettingTrainerStartWeekReturnsDefaultValueOne() {
            Assertions.assertEquals(1, Integer.parseInt(addCoursePage.getTrainerStartWeek(1)));
        }

        @Test
        @DisplayName("Test enter start week")
        void testEnterStartWeek() {
            addCoursePage.enterTrainerStartWeek(1, 12);
            Assertions.assertEquals(12, Integer.parseInt(addCoursePage.getTrainerStartWeek(1)));
        }

        @ParameterizedTest
        @CsvSource(value = {"1, 12", "2, 6", "3, 52"})
        @DisplayName("Test adding multiple trainers and getting trainer id")
        void testMultipleTrainerStarWeeks(String row, String trainerStartWeek) {
            int numberOfTrainers = Integer.parseInt(row);
            int trainerStartWeekNum = Integer.parseInt(trainerStartWeek);

            for (int i = 1; i < numberOfTrainers; i++){
                addCoursePage.incrementNumberOfTrainers();
            }
            addCoursePage.enterTrainerStartWeek(numberOfTrainers, trainerStartWeekNum);
            Assertions.assertEquals(trainerStartWeekNum, Integer.parseInt(addCoursePage.getTrainerStartWeek(numberOfTrainers)));
        }

        @Test
        @DisplayName("Test enter end week")
        void testEnterEndWeek() {
            addCoursePage.enterTrainerEndWeek(1, 12);
            Assertions.assertEquals(12, Integer.parseInt(addCoursePage.getTrainerEndWeek(1)));
        }

        @ParameterizedTest
        @CsvSource(value = {"1, 12", "2, 6", "3, 52"})
        @DisplayName("Test adding multiple trainers and getting trainer id")
        void testMultipleTrainerEndWeeks(String row, String trainerEndWeek) {
            int numberOfTrainers = Integer.parseInt(row);
            int trainerEndWeekNum = Integer.parseInt(trainerEndWeek);

            for (int i = 1; i < numberOfTrainers; i++){
                addCoursePage.incrementNumberOfTrainers();
            }
            addCoursePage.enterTrainerEndWeek(numberOfTrainers, trainerEndWeekNum);
            Assertions.assertEquals(trainerEndWeekNum, Integer.parseInt(addCoursePage.getTrainerEndWeek(numberOfTrainers)));
        }
    }

    @Nested
    @DisplayName("Testing Getters and Selectors for Discipline Field")
    class GettingAndSelectingDiscipline {

        @Test
        @DisplayName("Testing getting discipline returns default value C#")
        void testingGettingDisciplineReturnsDefaultValueC() {
            Assertions.assertEquals("Java",  addCoursePage.getDiscipline());
        }

        @Test
        @DisplayName("Testing select methods.")
        void testingSelectMethods() {
            addCoursePage.selectDiscipline("DevOps");
            System.out.println(addCoursePage.getDiscipline());
            Assertions.assertEquals("DevOps",  addCoursePage.getDiscipline());
        }
    }

    @Nested
    @DisplayName("Testing Getters and Selectors for CourseType Field")
    class GettingAndSelectingCourseType {

        @Test
        @DisplayName("Testing getting CourseType returns default value Business")
        void testingGettingCourseTypeReturnsDefaultValueC() {
            Assertions.assertEquals("Business",  addCoursePage.getCourseType());
        }

        @Test
        @DisplayName("Testing select methods.")
        void testingSelectMethods() {
            addCoursePage.selectCourseType("Technology");
            Assertions.assertEquals("Technology",  addCoursePage.getCourseType());
        }
    }

    @Nested
    @DisplayName("Testing Getters and Selectors for Location Field")
    class GettingAndSelectingLocation {

        @Test
        @DisplayName("Testing getting Location returns default value Business")
        void testingGettingLocationReturnsDefaultValueC() {
            Assertions.assertEquals("Hoth",  addCoursePage.getLocation());
        }

        @Test
        @DisplayName("Testing select methods.")
        void testingSelectMethods() {
            addCoursePage.selectLocation("Coruscant");
            Assertions.assertEquals("Coruscant",  addCoursePage.getLocation());
        }
    }

    @Nested
    @DisplayName("Testing Getters and Enter methods for Start Date Field")
    class GettingAndSelectingStartDate {

        @Test
        @DisplayName("GetStartDate returns todays date")
        void getStartDateReturnsDateNow() {
            LocalDate startDate = LocalDate.now();
            addCoursePage.enterStartDate(startDate);
            Assertions.assertEquals(startDate.toString(), addCoursePage.getStartDate());
        }

        @ParameterizedTest
        @CsvSource(value = {"1997, 9, 22", "2021, 10, 2", "2021, 10, 26"})
        @DisplayName("Test EnterStartDate() method returns 22/09/1997")
        public void testEnterStartDate(int year, int month, int day) {
            LocalDate startDate = LocalDate.of(year, month, day);
            addCoursePage.enterStartDate(startDate);
            Assertions.assertEquals(startDate.toString(), addCoursePage.getStartDate());
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

        @Test
        @DisplayName("empty trainer start week returns true")
        void emptyTrainerStartWeekReturnsTrue() {
            addCoursePage.getTrainerStartWeekElement(1).clear();
            Assertions.assertTrue(addCoursePage.isTrainerStartWeekEmpty(1));
        }

        @Test
        @DisplayName("empty trainer start week returns false")
        void emptyTrainerStartWeekReturnsFalse() {
            Assertions.assertFalse(addCoursePage.isTrainerStartWeekEmpty(1));
        }

        @Test
        @DisplayName("empty trainer end week returns true")
        void emptyTrainerEndWeekReturnsTrue() {
            addCoursePage.getTrainerEndWeekElement(1).clear();
            Assertions.assertTrue(addCoursePage.isTrainerEndWeekEmpty(1));
        }

        @Test
        @DisplayName("empty trainer end week returns false")
        void emptyTrainerEndWeekReturnsFalse() {
            Assertions.assertFalse(addCoursePage.isTrainerEndWeekEmpty(1));
        }

        @Test
        @DisplayName("empty Start Date returns true")
        void emptyStartDateReturnsTrue() {
            Assertions.assertTrue(addCoursePage.isStartDateEmpty());
        }

        @Test
        @DisplayName("empty Start Date returns false")
        void emptyStartDateReturnsFalse() {
            addCoursePage.enterStartDate(LocalDate.now());
            Assertions.assertFalse(addCoursePage.isStartDateEmpty());
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

    @Nested
    @DisplayName("Valid entries test")
    class ValidTests {

        @Test
        @DisplayName("Valid number of trainers returns true")
        void validNumberOfTrainersReturnsTrue() {
            addCoursePage.enterNumberOfTrainers(5);
            Assertions.assertTrue(addCoursePage.isNumberOfTrainersValid());
        }

        @Test
        @DisplayName("invalid low number of trainers returns false")
        void invalidLowNumberOfTrainersReturnsFalse() {
            addCoursePage.enterNumberOfTrainers(0);
            Assertions.assertFalse(addCoursePage.isNumberOfTrainersValid());
        }

        @Test
        @DisplayName("invalid high number of trainers returns false")
        void invalidHighNumberOfTrainersReturnsFalse() {
            addCoursePage.enterNumberOfTrainers(11);
            Assertions.assertFalse(addCoursePage.isNumberOfTrainersValid());
        }

        @Test
        @DisplayName("Valid number of Trainer Start Week returns true")
        void validNumberOfTrainerStartWeekReturnsTrue() {
            addCoursePage.enterTrainerStartWeek(1, 12);
            Assertions.assertTrue(addCoursePage.isTrainerStartWeekValid(1));
        }

        @Test
        @DisplayName("Invalid low number of Trainer Start Week returns false")
        void InvalidLowNumberOfTrainerStartWeekReturnsFalse() {
            addCoursePage.enterTrainerStartWeek(1, 0);
            Assertions.assertFalse(addCoursePage.isTrainerStartWeekValid(1));
        }

        @Test
        @DisplayName("Invalid high number of Trainer Start Week returns false")
        void InvalidHighNumberOfTrainerEndWeekReturnsFalse() {
            addCoursePage.enterTrainerStartWeek(1, 53);
            Assertions.assertFalse(addCoursePage.isTrainerStartWeekValid(1));
        }

        @Test
        @DisplayName("Valid number of Trainer End Week returns true")
        void validNumberOfTrainerEndWeekReturnsTrue() {
            addCoursePage.enterTrainerEndWeek(1, 12);
            Assertions.assertTrue(addCoursePage.isTrainerEndWeekValid(1));
        }

        @Test
        @DisplayName("Invalid low number of Trainer End Week returns false")
        void InvalidLowNumberOfTrainerEndWeekReturnsFalse() {
            addCoursePage.enterTrainerEndWeek(1, 0);
            Assertions.assertFalse(addCoursePage.isTrainerEndWeekValid(1));
        }

        @Test
        @DisplayName("Invalid high number of Trainer End Week returns false")
        void InvalidHighNumberOfTrainerStartWeekReturnsFalse() {
            addCoursePage.enterTrainerEndWeek(1, 53);
            Assertions.assertFalse(addCoursePage.isTrainerEndWeekValid(1));
        }
    }

    //TODO(2): Dependant on database having maximum of 1 course.
    /*@Nested
    @DisplayName("EmptyErrorMessage warning test")
    class EmptyWarningTests {

        @Test
        @DisplayName("empty course name gives warning")
        void emptyCourseNameGivesWarning() {
            addCoursePage.enterCourseName("");
            addCoursePage.clickSubmit();
            System.out.println(addCoursePage.getEmptyErrorMessage());
            Assertions.assertEquals("Please fill in this field.", addCoursePage.getEmptyErrorMessage());
        }

        @Test
        @DisplayName("non-empty course name does not give a warning")
        void nonEmptyCourseNameNoWarning() {
            addCoursePage.enterCourseName("Eng-92");
            Assertions.assertEquals("Please fill in this field.", addCoursePage.getEmptyErrorMessage());
        }

        @Test
        @DisplayName("Blank course name gives warning")
        void blankCourseNameGivesWarning() {
            addCoursePage.enterCourseName("   ");
            Assertions.assertEquals("true", addCoursePage.getEmptyErrorMessage());
        }
    }*/

    @Nested
    @DisplayName("Alert test for number of trainers entries")
    class ValidEntriesTest {

        @Test
        @DisplayName("Max value reached alert for above max number of trainers entry")
        void isAlertForMaxNumber() {
            addCoursePage.enterNumberOfTrainers(11);
            addCoursePage.clickSubmit();
            Assertions.assertTrue(addCoursePage.isAlertDisplayed());
        }

        @Test
        @DisplayName("Min value reached alert for above max number of trainers entry")
        void isAlertForMinNumber() {
            addCoursePage.enterNumberOfTrainers(0);
            addCoursePage.clickSubmit();
            Assertions.assertTrue(addCoursePage.isAlertDisplayed());
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
            addCoursePage.enterAllFields(defaultCoursePageObject);
            coursePage = addCoursePage.submitReturnsCoursePage();
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
            addCoursePage.enterAllFields(coursePageObject);
            Assertions.assertTrue(addCoursePage.isSubmissionSuccessful());
        }
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
