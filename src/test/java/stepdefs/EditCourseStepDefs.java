package stepdefs;

import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePageObject;
import com.spartaglobal.finalweek.pages.coursePages.EditCoursesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;

import java.time.LocalDate;
import java.util.Arrays;

public class EditCourseStepDefs {
    CoursePage coursePage = new CoursePage();
    EditCoursesPage editCoursesPage;

    WebElement trainerID;
    WebElement courseType;

    @After("@editCourse")
    public void tearDown(){
        webDriver.quit();
    }

    @And("I go to the edit course page")
    public void iGoToTheEditCoursePage() {
        try {
            editCoursesPage = coursePage.clickEditCourseHyperlink("Jedi Training");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I edit the information about a course on the edit course page")
    public void iEditTheInformationAboutACourseOnTheEditCoursePage() {
        CoursePageObject emptyCourse = new CoursePageObject();
        CoursePageObject defaultCourse = new CoursePageObject(emptyCourse);

        editCoursesPage.getCourseNameElement().clear();
        editCoursesPage.getStartDateElement().clear();
        editCoursesPage.decrementNumberOfTrainers();
        editCoursesPage.enterAllFields(defaultCourse);
    }

    @And("I click submit button on the edit course page")
    public void iClickSubmitButtonOnTheEditCoursePage() {
        coursePage = editCoursesPage.submitReturnsCoursePage();
    }

    @Then("The course information should be updated")
    public void theCourseInformationShouldBeUpdated() {
        Assertions.assertTrue(coursePage.getCoursesByCourseName("Course Name")
                .get(0).getText().contains("Course Name Java Technology Coruscant 2021-10-06 JarJar Binks"));
    }

    @When("I try to set the start date before the current date on the edit course page")
    public void iTryToSetTheStartDateBeforeTheCurrentDateOnTheEditCoursePage() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        editCoursesPage.enterStartDate(yesterday);
    }

    @Then("I should not be navigated back to the course page from the edit course page")
    public void iShouldNotBeNavigatedBackToTheCoursePageFromTheEditCoursePage() {
        Assertions.assertFalse(editCoursesPage.isSubmissionSuccessful());
    }

    // Disabled due to multiple empty trainer ID returns error
    @When("I select the Trainer ID drop-down menu on the edit course page")
    public void iClickTheTrainerIDDropDownMenuOnTheEditCoursePage() {
        editCoursesPage.decrementNumberOfTrainers();
        trainerID = editCoursesPage.getTrainerIDElement(1);
    }

    @Then("I should only be able to choose trainers that exist within the trainers drop-down menu on the edit course page")
    public void iShouldOnlyBeAbleToChooseTrainersThatExistWithinTheTrainersDropDownMenuOnTheEditCoursePage() {
        String[] trainerIDs = editCoursesPage.getAllTrainerIDStrings();
        String[] defaultTrainerIDs = {"JarJar Binks", "Aayla Secura", "Mike Wazowski", "Kit Fisto",
                "Mace Windu", "Ki-adi Mundi", "Luminara Unduli", "Plo Koon", "Eeth Koth", "Adi Gallia",
                "Ima-gun Di", "Qui-gon Jinn", "Obi-Wan Kenobi", "Sheev Palpatine"};
        Assertions.assertEquals(Arrays.toString(defaultTrainerIDs), Arrays.toString(trainerIDs));
    }

    @When("I select the time a trainer is teaching a course on the edit course page")
    public void iSelectTheTimeATrainerIsTeachingACourseOnTheEditCoursePage() {
        editCoursesPage.decrementNumberOfTrainers();
        editCoursesPage.selectDiscipline("Java");
        editCoursesPage.enterTrainerStartWeek(1, 1);
        editCoursesPage.enterTrainerEndWeek(1, 12);
    }

    @Then("the difference between the start week and the end week should not exceed the length of the course on the edit course page")
    public void theDifferenceBetweenTheStartWeekAndTheEndWeekShouldNotExceedTheLengthOfTheCourse() {
        NavTemplate navTemplate = new NavTemplate();

        String disciplineName = editCoursesPage.getDiscipline();
        int endWeek = Integer.parseInt(editCoursesPage.getTrainerEndWeek(1));
        int startWeek = Integer.parseInt(editCoursesPage.getTrainerStartWeek(1));
        int lengthOfCourse = endWeek - startWeek + 1;

        CourseInfoPage courseInfoPage = navTemplate.goToCourseInfoPage();
        int id = courseInfoPage.getDisciplineNames().indexOf(disciplineName);
        String durationString = courseInfoPage.getDisciplineElement(disciplineName).findElement(By.id(id+"duration")).getText();
        int duration = Integer.parseInt(durationString.replace(" Weeks", ""));

        Assertions.assertTrue(lengthOfCourse <= duration);
    }


    @When("I select a course type on the edit course page")
    public void iSelectACourseTypeOnTheEditCoursePage() {
        courseType = editCoursesPage.getCourseTypeElement();
    }

    @Then("I should only be allowed to choose a course type that exists within the course type drop-down menu on the edit course page")
    public void iShouldOnlyBeAllowedToChooseACourseTypeThatExistsWithinTheCourseTypeDropDownMenuOnTheEditCoursePage() {
        String[] courseTypes = editCoursesPage.getAllCourseTypes();
        String[] defaultCourseTypes = {"Business", "Technology"};
        Assertions.assertEquals(Arrays.toString(defaultCourseTypes), Arrays.toString(courseTypes));
    }

    @When("I select a location on the edit course page")
    public void iSelectALocationOnTheEditCoursePage() {
        courseType = editCoursesPage.getLocationElement();
    }

    @Then("I should only be allowed to choose a location that exists within the location drop-down menu on the edit course page")
    public void iShouldOnlyBeAllowedToChooseALocationThatExistsWithinTheLocationDropDownMenuOnTheEditCoursePage() {
        String[] locations = editCoursesPage.getAllLocations();
        String[] defaultLocations = {"Hoth", "Naboo", "Geonosis", "Kashyyyk", "Coruscant", "Mustafar"};
        Assertions.assertEquals(Arrays.toString(defaultLocations), Arrays.toString(locations));
    }

    @When("I select a discipline on the edit course page")
    public void iSelectADisciplineOnTheEditCoursePage() {
        courseType = editCoursesPage.getDisciplineElement();
    }

    @Then("I should only be allowed to choose a discipline that exists within the discipline drop-down menu on the edit course page")
    public void iShouldOnlyBeAllowedToChooseADisciplineThatExistsWithinTheDisciplineDropDownMenuOnTheEditCoursePage() {
        String[] disciplines = editCoursesPage.getAllDisciplines();
        String[] defaultDisciplines = {"Java", "C#", "DevOps", "JavaSDET", "C#SDET"};
        Assertions.assertEquals(Arrays.toString(defaultDisciplines), Arrays.toString(disciplines));
    }

    @When("I enter the {int} of trainers for a course on the edit course page")
    public void iEnterTheNumberOfTrainersForACourseOnTheEditCoursePage(int numTrainers) {
        editCoursesPage.enterNumberOfTrainers(numTrainers);
    }

    @Then("I should get an alert saying {string} on the edit course page")
    public void iShouldGetAnAlertSayingOnTheEditCoursePage(String errorMsg) {
        editCoursesPage.clickSubmit();
        Assertions.assertEquals(errorMsg, editCoursesPage.getMaxOrMinValueReachedAlertMessage());
    }

    @When("I select the same {string} on the edit course page twice")
    public void iAddTheSameTrainerIDMoreThanOnceToTheCourseOnTheAddCoursePage(String trainerID) {
        editCoursesPage.selectTrainerID(1, trainerID);
        editCoursesPage.selectTrainerID(2, trainerID);
    }

    @Then("I should be prevented from submitting the form on the edit course page")
    public void iShouldBePreventedFromSubmittingTheFormOnTheAddCoursePage() {
        Assertions.assertFalse(editCoursesPage.isSubmissionSuccessful());
    }

    @And("I fill the {string} on course name field on the edit course page")
    public void iFillTheCourseName(String courseName) {
        editCoursesPage.enterCourseName(courseName);
    }

    @And("I fill the start date with today's date on the edit course page")
    public void iFillTheStartDate() {
        editCoursesPage.enterStartDate(LocalDate.now());
    }

    @When("I clear the course name text field")
    public void iClearTheCourseNameTextField() {
        editCoursesPage.getCourseNameElement().clear();
    }
}
