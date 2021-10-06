package com.spartaglobal.finalweek.tests.traineeTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class TraineesTests extends NavTemplate {

    private static String username = PropertiesLoader.getProperties().getProperty("Username");
    private static String password = PropertiesLoader.getProperties().getProperty("Password");
    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private TraineesPage traineesPage;
    private CoursePage coursePage;
    private NavTemplate navTemplate;

    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        PageFactory.initElements(webDriver, this);
        loginPage = new LoginPage();
        schedulerPage = new SchedulerPage();
        traineesPage = new TraineesPage();
        loginPage.login(username, password);
        PageFactory.initElements(webDriver, schedulerPage);
        NavTemplate navTemplate = new NavTemplate();
        traineesPage = navTemplate.goToTraineesPage();
    }

    @Nested
    @DisplayName("Get Multiple Trainee Elements Tests")
    class getMultipleTraineeElementsTests {

        @Test
        @DisplayName("getAllTraineesElementsTest")
        public void getAllTraineesElementsTest() {
            boolean found = false;
            List<WebElement> traineeElements = traineesPage.getAllTraineesElements();
            for (WebElement rowElement : traineeElements) {
                if (rowElement != null && rowElement.getAttribute("id").contains("row")) {
                    found = true;
                }
            }
            Assertions.assertTrue(found);
        }

        @Test
        @DisplayName("getAllTraineesFirstNameElementsTest")
        void getAllTraineesFirstNameElementsTest() {
            boolean rowElementsPresent = true;
            List<WebElement> firstNameElements = traineesPage.getAllTraineesFirstNameElements();
            int count = 0;
            for (WebElement element : firstNameElements) {
                if (!element.getAttribute("id").equals(count + "name")) {
                    rowElementsPresent = false;
                    break;
                }
                count++;
            }
            Assertions.assertTrue(rowElementsPresent);
        }

        @Test
        @DisplayName("getAllTraineesLastNameElements")
        void getAllTraineesLastNameElements() {
            boolean rowElementsPresent = true;
            List<WebElement> surnameElements = traineesPage.getAllTraineesLastNameElements();
            int count = 0;
            for (WebElement element : surnameElements) {
                if (!element.getAttribute("id").equals(count + "surname")) {
                    rowElementsPresent = false;
                    break;
                }
                count++;
            }
            Assertions.assertTrue(rowElementsPresent);
        }

        @Test
        @DisplayName("getAllTraineesQualityGateStatusElementsTest")
        void getAllTraineesQualityGateStatusElementsTest() {
            boolean rowElementsPresent = true;
            List<WebElement> qualityGateStatusElements = traineesPage.getAllTraineesQualityGateStatusElements();
            int count = 0;
            for (WebElement element : qualityGateStatusElements) {
                if (!element.getAttribute("id").equals(count + "qgs")) {
                    rowElementsPresent = false;
                    break;
                }
                count++;
            }
            Assertions.assertTrue(rowElementsPresent);
        }
    }

    @Nested
    @DisplayName("Get Multiple Trainee Strings Tests")
    class getMultipleTraineeStringsTests {

        @Test
        @DisplayName("getAllTraineesFirstNamesTest")
        void getAllTraineesFirstNamesTest() {
            boolean allFirstNamesPresent = true;
            List<String> allFirstNames = traineesPage.getAllTraineesFirstNames();
            Pattern regex = Pattern.compile("^[a-zA-Z0-9'-,.]+$");
            for (String firstName : allFirstNames) {
                if (!regex.matcher(firstName).find()) {
                    allFirstNamesPresent = false;
                }
            }
            Assertions.assertTrue(allFirstNamesPresent);
        }

        @Test
        @DisplayName("getAllTraineesLastNamesTest")
        void getAllTraineesLastNamesTest() {
            boolean allLastNamesPresent = true;
            List<String> allLastNames = traineesPage.getAllTraineesLastNames();
            Pattern regex = Pattern.compile("^[a-zA-Z0-9'-,.]+$");
            for (String lastName : allLastNames) {
                if (!regex.matcher(lastName).find()) {
                    allLastNamesPresent = false;
                }
            }
            Assertions.assertTrue(allLastNamesPresent);
        }

        @Test
        @DisplayName("getAllTraineesQualityGateStatusStringsTest")
        void getAllTraineesQualityGateStatusStringsTest() {
            boolean allQualityGateStatusPresent = true;
            List<String> allQGSStrings = traineesPage.getAllTraineesQualityGateStatusStrings();
            String[] possibleQualityGateStatus = {"Passed", "Pending", "Failed-Needs Help", "Failed"};
            for (String qgs : allQGSStrings) {
                if (!Arrays.stream(possibleQualityGateStatus).anyMatch(qgs::equals)) {
                    allQualityGateStatusPresent = false;
                }
            }
            Assertions.assertTrue(allQualityGateStatusPresent);
        }
    }

    @Nested
    @DisplayName("Get Single Trainee Elements Tests")
    class getSingleTraineeElementsTests {

        @Test
        @DisplayName("getTraineeElementTest")
        void getTraineeElementTest() {
            int rowNumber = 0;
            WebElement returnedRow = traineesPage.getTraineeElement(rowNumber + "row");
            Assertions.assertEquals(rowNumber + "row", returnedRow.getAttribute("id"));
        }

        @Test
        @DisplayName("getTraineeFirstNameElementTest")
        void getTraineeFirstNameElementTest() {
            int rowNumber = 0;
            WebElement firstNameElement = traineesPage.getTraineeFirstNameElement(rowNumber + "row");
            Assertions.assertEquals(rowNumber + "name", firstNameElement.getAttribute("id"));
        }

        @Test
        @DisplayName("getTraineeLastNameElementTest")
        void getTraineeLastNameElementTest() {
            int rowNumber = 0;
            WebElement lastNameElement = traineesPage.getTraineeLastNameElement(rowNumber + "row");
            Assertions.assertEquals(rowNumber + "surname", lastNameElement.getAttribute("id"));
        }

        @Test
        @DisplayName("getTraineeQualityGateStatusElementTest")
        void getTraineeQualityGateStatusElementTest() {
            int rowNumber = 0;
            WebElement qgsElement = traineesPage.getTraineeQualityGateStatusElement(rowNumber + "row");
            Assertions.assertEquals(rowNumber + "qgs", qgsElement.getAttribute("id"));
        }
    }

    @Nested
    @DisplayName("Get Single Trainee Strings Tests")
    class getSingleTraineeStringsTests {

        @Test
        @DisplayName("getTraineeFirstNameTest")
        void getTraineeFirstNameTest() {
            int rowNumber = 0;
            String firstNameString = traineesPage.getTraineeFirstName(rowNumber + "row");
            Assertions.assertEquals(String.class, firstNameString.getClass());
        }

        @Test
        @DisplayName("getTraineeLastNameTest")
        void getTraineeLastNameTest() {
            int rowNumber = 0;
            String lastNameString = traineesPage.getTraineeLastName(rowNumber + "row");
            Assertions.assertEquals(String.class, lastNameString.getClass());
        }

        @Test
        @DisplayName("getTraineeQualityGateStatusTest")
        void getTraineeQualityGateStatusTest() {
            int rowNumber = 0;
            String[] possibleQualityGateStatus = {"Passed", "Pending", "Failed-Needs Help", "Failed"};
            String qualityGateStatusString = traineesPage.getTraineeQualityGateStatus(rowNumber + "row");
            Assertions.assertTrue(Arrays.stream(possibleQualityGateStatus).anyMatch(qualityGateStatusString::equals));
        }
    }

    @Nested
    @DisplayName("Get Quality Gate Table Info Tests")
    class getQualityGateTableInfoTests {

        @Test
        @DisplayName("getQualityGateHistoryDetailsElementsTest")
        void getQualityGateHistoryDetailsElementsTest() {
            boolean areElementsCorrect = true;
            int rowNumber = 0;
            List<WebElement> qgsElements = traineesPage.getQualityGateHistoryDetailsElements(rowNumber + "row");
            if (qgsElements.size() > 0) {
                for (WebElement element : qgsElements) {
                    if (!element.getText().contains("Feedback 1") || !element.getText().contains("Feedback 2")) {
                        areElementsCorrect = false;
                    }
                }
            }
            Assertions.assertTrue(areElementsCorrect);
        }

        @Test
        @DisplayName("getQualityGateHistoryDetailsTest")
        void getQualityGateHistoryDetailsTest() {
            boolean areStringsCorrect = true;
            int rowNumber = 0;
            List<String> qgsStrings = traineesPage.getQualityGateHistoryDetails(rowNumber + "row");
            if (qgsStrings.size() > 0) {
                for (String element : qgsStrings) {
                    if (!element.contains("Feedback 1") || !element.contains("Feedback 2")) {
                        areStringsCorrect = false;
                    }
                }
            }
            Assertions.assertTrue(areStringsCorrect);
        }
    }

    @Nested
    @DisplayName("Trainee Course Filter Tests")
    class traineeCourseFilterTests {

        @Test
        @DisplayName("getCoursesElementsTest")
        void getCoursesElementsTest() {
            boolean allCoursesPresent = true;
            navTemplate = new NavTemplate();
            coursePage = new CoursePage();
            List<WebElement> traineePageCourses = traineesPage.getCoursesElements();
            List<String> traineePageCourseStrings = new ArrayList<>();
            for (WebElement traineeCourseCopy : traineePageCourses) {
                traineePageCourseStrings.add(traineeCourseCopy.getText());
            }
            List<String> coursesPageCourses = new ArrayList<>();
            navTemplate.goToCoursesPage();
            PageFactory.initElements(webDriver, coursePage);

            WebElement courseTableBody = webDriver.findElement(By.tagName("tbody"));
            List<WebElement> courseTableRows = courseTableBody.findElements(By.tagName("tr"));
            int index = 0;
            for (WebElement row : courseTableRows) {
                coursesPageCourses.add(row.findElement(By.id(index + "course")).getText());
                index++;
            }
            for (String traineeCourse : traineePageCourseStrings) {
                if (!coursesPageCourses.contains(traineeCourse)) {
                    allCoursesPresent = false;
                }
            }
            Assertions.assertTrue(allCoursesPresent && coursesPageCourses.size() == traineePageCourses.size());
        }

        @Test
        @DisplayName("getCoursesStringsTest")
        void getCoursesStringsTest() {
            boolean allCoursesPresent = true;
            navTemplate = new NavTemplate();
            coursePage = new CoursePage();
            List<String> traineePageCourseStrings = traineesPage.getCoursesStrings();
            List<String> coursesPageCourses = new ArrayList<>();
            navTemplate.goToCoursesPage();
            PageFactory.initElements(webDriver, coursePage);

            WebElement courseTableBody = webDriver.findElement(By.tagName("tbody"));
            List<WebElement> courseTableRows = courseTableBody.findElements(By.tagName("tr"));
            int index = 0;
            for (WebElement row : courseTableRows) {
                coursesPageCourses.add(row.findElement(By.id(index + "course")).getText());
                index++;
            }
            for (String traineeCourse : traineePageCourseStrings) {
                if (!coursesPageCourses.contains(traineeCourse)) {
                    allCoursesPresent = false;
                }
            }
            Assertions.assertTrue(allCoursesPresent && coursesPageCourses.size() == traineePageCourseStrings.size());
        }

        @Test
        @DisplayName("applyCourseFilterTest")
        void applyCourseFilterTest() {
            String courseName = "Engineering 87";
            String courseNameNoSpaces = courseName.replaceAll("\\s+", "");
            traineesPage.applyCourseFilter(courseName);
            Assertions.assertEquals("http://localhost:8080/traineePage/" + courseNameNoSpaces, traineesPage.filterAppliedURL);
        }

        @Test
        @DisplayName("areCoursesUniqueTest")
        void areCoursesUniqueTest() {
            Assertions.assertTrue(traineesPage.areCoursesUnique());
        }
    }

    @Nested
    @DisplayName("Trainee Page Button Tests")
    class traineePageButtonTests {

        @Test
        @DisplayName("clickAddTraineeTest")
        void clickAddTraineeTest() {
            traineesPage.clickAddTrainee();
            Assertions.assertEquals("http://localhost:8080/addTrainee", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("clickEditTraineeTest")
        void clickEditTraineeTest() {
            int rowNumber = 0;
            String firstName = traineesPage.getTraineeFirstName(rowNumber + "row");
            String lastName = traineesPage.getTraineeLastName(rowNumber + "row");
            traineesPage.clickEditTrainee(rowNumber + "row");
            WebElement firstNameField = webDriver.findElement(By.id("edit-trainee-first-name"));
            WebElement lastNameField = webDriver.findElement(By.id("edit-trainee-last-name"));
            Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/editTrainee/") &&
                    firstName.equals(firstNameField.getAttribute("value")) &&
                    lastName.equals(lastNameField.getAttribute("value")));
        }

        @Test
        @DisplayName("clickDeleteTraineeTest")
        void clickDeleteTraineeTest() {
            int rowNumber = 0;
            String firstName = traineesPage.getTraineeFirstName(rowNumber + "row");
            String lastName = traineesPage.getTraineeLastName(rowNumber + "row");
            String qualityStatus = traineesPage.getTraineeQualityGateStatus(rowNumber + "row");
            traineesPage.clickDeleteTrainee(rowNumber + "row");
            List<String> allFirstNames = traineesPage.getAllTraineesFirstNames();
            List<String> allLastNames = traineesPage.getAllTraineesLastNames();
            List<String> allQualityStatus = traineesPage.getAllTraineesQualityGateStatusStrings();
            Assertions.assertFalse(allFirstNames.contains(firstName)
                    && allLastNames.contains(lastName)
                    && allQualityStatus.contains(qualityStatus));

        }

        @Test
        @DisplayName("clickAddQualityGateTest")
        void clickAddQualityGateTest() {
            int rowNumber = 0;
            traineesPage.clickAddQualityGate(rowNumber + "row");
            Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/addQualityGate/"));
        }
    }

    @Nested
    @DisplayName("Quality Gate Status Confirmation Tests")
    class qualityGateStatusConfirmationTests {

        @ParameterizedTest
        @ValueSource(strings = {"Passed"})
        @DisplayName("isQualityGateStatusPassedTest")
        void isQualityGateStatusPassedTest(String qgStatus) {
            Assertions.assertTrue(traineesPage.isQualityGateStatusPassed(qgStatus));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Pending", "Failed-Needs Help", "Failed"})
        @DisplayName("isQualityGateStatusNotPassedTest")
        void isQualityGateStatusNotPassedTest(String qgStatus) {
            Assertions.assertFalse(traineesPage.isQualityGateStatusPassed(qgStatus));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Pending"})
        @DisplayName("isQualityGateStatusPendingTest")
        void isQualityGateStatusPendingTest(String qgStatus) {
            Assertions.assertTrue(traineesPage.isQualityGateStatusPending(qgStatus));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Passed", "Failed-Needs Help", "Failed"})
        @DisplayName("isQualityGateStatusNotPendingTest")
        void isQualityGateStatusNotPendingTest(String qgStatus) {
            Assertions.assertFalse(traineesPage.isQualityGateStatusPending(qgStatus));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Failed"})
        @DisplayName("isQualityGateStatusFailedTest")
        void isQualityGateStatusFailedTest(String qgStatus) {
            Assertions.assertTrue(traineesPage.isQualityGateStatusFailed(qgStatus));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Passed", "Failed-Needs Help", "Pending"})
        @DisplayName("isQualityGateStatusNotFailedTest")
        void isQualityGateStatusNotFailedTest(String qgStatus) {
            Assertions.assertFalse(traineesPage.isQualityGateStatusFailed(qgStatus));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Failed-Needs Help"})
        @DisplayName("isQualityGateStatusFailedNeedsHelpTest")
        void isQualityGateStatusFailedNeedsHelpTest(String qgStatus) {
            Assertions.assertTrue(traineesPage.isQualityGateStatusFailedNeedsHelp(qgStatus));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Passed", "Failed", "Pending"})
        @DisplayName("isQualityGateStatusNotFailedNeedsHelpTest")
        void isQualityGateStatusNotFailedNeedsHelpTest(String qgStatus) {
            Assertions.assertFalse(traineesPage.isQualityGateStatusFailedNeedsHelp(qgStatus));
        }
    }

    @Nested
    @DisplayName("Trainee Page Valid Data Tests")
    class traineePageValidDataTests {

        @Test
        @DisplayName("isTraineeFirstNameValidTest")
        void isTraineeFirstNameValidTest() {
            int rowNumber = 0;
            Assertions.assertTrue(traineesPage.isTraineeFirstNameValid(rowNumber + "row"));
        }

        @Test
        @DisplayName("isTraineeLastNameValidTest")
        void isTraineeLastNameValidTest() {
            int rowNumber = 0;
            Assertions.assertTrue(traineesPage.isTraineeLastNameValid(rowNumber + "row"));
        }

        @Test
        @DisplayName("areAllTraineesFirstNamesValidTest")
        void areAllTraineesFirstNamesValidTest() {
            Assertions.assertTrue(traineesPage.areAllTraineesFirstNamesValid());
        }

        @Test
        @DisplayName("areAllTraineesLastNamesValidTest")
        void areAllTraineesLastNamesValidTest() {
            Assertions.assertTrue(traineesPage.areAllTraineesLastNamesValid());
        }

        @Test
        @DisplayName("isTraineeQualityGateStatusValidTest")
        void isTraineeQualityGateStatusValidTest() {
            int rowNumber = 0;
            Assertions.assertTrue(traineesPage.isTraineeQualityGateStatusValid(rowNumber + "row"));
        }
    }
    
    @Test
    @DisplayName("areAllFieldsPassedOnToEditTraineesPageTest")
    void areAllFieldsPassedOnToEditTraineesPageTest() {
        Assertions.assertTrue(traineesPage.areAllFieldsPassedOnToEditTraineesPage());
    }

    @Nested
    @DisplayName("Trainee Page Delete Tests")
    class traineePageDeleteTests {

        @Test
        @DisplayName("does Confirmation Box Appear On Delete Test")
        void doesConfirmationBoxAppearOnDeleteTest() {
            Assertions.assertTrue(traineesPage.doesConfirmationBoxAppearOnDelete());
        }

        @Test
        @DisplayName("confirm Delete Test")
        void confirmDeleteTest() {
            Assertions.assertTrue(traineesPage.confirmDelete());
        }

        @Test
        @DisplayName("cancel Delete Test")
        void cancelDeleteTest() {
            Assertions.assertTrue(traineesPage.cancelDelete());
        }
    }
    
    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
