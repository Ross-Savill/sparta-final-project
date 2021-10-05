package stepdefs;

import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.coursePages.AddCoursePage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePageObject;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddCourseStepDefs {
    CoursePage coursePage = new CoursePage();
    AddCoursePage addCoursePage;

    WebElement trainerID;
    WebElement courseType;

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @And("I go to the add course page")
    public void iGoToTheAddCoursePage(){
        addCoursePage = coursePage.clickAddCourseButton();
    }

    @When("I fill out the add Course form")
    public void iFillOutTheAddCourseForm() {
        CoursePageObject emptyCourseObj = new CoursePageObject();
        CoursePageObject defaultCourseObj = new CoursePageObject(emptyCourseObj);
        addCoursePage.enterAllFields(defaultCourseObj);
    }

    @And("I click the submit button on the add course page")
    public void iClickTheSubmitButtonOnTheAddCoursePage() {
        coursePage = addCoursePage.submitReturnsCoursePage();
    }

    @Then("A new course with the information I entered should be added to the database on the course page")
    public void aNewCourseWithTheInformationIEnteredShouldBeAddedToTheDatabaseOnTheCoursePage() {
        //TODO: Waiting for Implementation.
        List<WebElement> coursesWebElements = coursePage.getAllCoursesNames();
    }

    @When("I try to set the start date before the current date on the add course page")
    public void iTryToSetTheStartDateBeforeTheCurrentDateOnTheAddCoursePage() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        addCoursePage.enterStartDate(yesterday);
    }

    //Should Fail therefore disable and provide reason.
    @Then("I should not be navigated back to the course page")
    public void iShouldNotBeNavigatedBackToTheCoursePage() {
        Assertions.assertFalse(addCoursePage.isSubmissionSuccessful());
    }

    @When("I select the Trainer ID drop-down menu on the add course page")
    public void iClickTheTrainerIDDropDownMenuOnTheAddCoursePage() {
        trainerID = addCoursePage.getTrainerIDElement(1);
    }

    @Then("I should only be able to choose trainers that exist within the trainers drop-down menu on the add course page")
    public void iShouldOnlyBeAbleToChooseTrainersThatExistWithinTheTrainersDropDownMenuOnTheAddCoursePage() {
        String[] trainerIDs = addCoursePage.getAllTrainerIDStrings();
        String[] defaultTrainerIDs = {"Aayla Secura", "Mike Wazowski", "JarJar Binks", "Kit Fisto",
                "Mace Windu", "Ki-adi Mundi", "Luminara Unduli", "Plo Koon", "Eeth Koth", "Adi Gallia",
                "Ima-gun Di", "Qui-gon Jinn", "Obi-Wan Kenobi", "Sheev Palpatine"};
        Assertions.assertEquals(Arrays.toString(defaultTrainerIDs), Arrays.toString(trainerIDs));
    }

    @When("I select the time a trainer is teaching a course on the add course page")
    public void iSelectTheTimeATrainerIsTeachingACourseOnTheAddCoursePage() {
        addCoursePage.selectDiscipline("Java");
        addCoursePage.enterTrainerStartWeek(1, 1);
        addCoursePage.enterTrainerEndWeek(1, 12);
    }

    @Then("the difference between the start week and the end week should not exceed the length of the course")
    public void theDifferenceBetweenTheStartWeekAndTheEndWeekShouldNotExceedTheLengthOfTheCourse() {
        NavTemplate navTemplate = new NavTemplate();

        String disciplineName = addCoursePage.getDiscipline();
        int endWeek = Integer.parseInt(addCoursePage.getTrainerEndWeek(1));
        int startWeek = Integer.parseInt(addCoursePage.getTrainerStartWeek(1));
        int lengthOfCourse = endWeek - startWeek + 1;

        CourseInfoPage courseInfoPage = navTemplate.goToCourseInfoPage();
        int id = courseInfoPage.getDisciplineNames().indexOf(disciplineName);
        String durationString = courseInfoPage.getDisciplineElement(disciplineName).findElement(By.id(id+"duration")).getText();
        int duration = Integer.parseInt(durationString.replace(" Weeks", ""));

        Assertions.assertTrue(lengthOfCourse <= duration);
    }

    @When("I select a course type on the add course page")
    public void iSelectACourseTypeOnTheAddCoursePage() {
        courseType = addCoursePage.getCourseTypeElement();
    }

    @Then("I should only be allowed to choose a course type that exists within the course type drop-down menu on the add course page")
    public void iShouldOnlyBeAllowedToChooseACourseTypeThatExistsWithinTheCourseTypeDropDownMenuOnTheAddCoursePage() {
        String[] courseTypes = addCoursePage.getAllCourseTypes();
        String[] defaultCourseTypes = {"Business", "Technology"};
        Assertions.assertEquals(Arrays.toString(defaultCourseTypes), Arrays.toString(courseTypes));
    }

    @When("I select a location on the add course page")
    public void iSelectALocationOnTheAddCoursePage() {
        courseType = addCoursePage.getLocationElement();
    }

    @Then("I should only be allowed to choose a location that exists within the location drop-down menu on the add course page")
    public void iShouldOnlyBeAllowedToChooseALocationThatExistsWithinTheLocationDropDownMenuOnTheAddCoursePage() {
        String[] locations = addCoursePage.getAllLocations();
        String[] defaultLocations = {"Hoth", "Naboo", "Geonosis", "Kashyyyk", "Coruscant", "Mustafar"};
        Assertions.assertEquals(Arrays.toString(defaultLocations), Arrays.toString(locations));
    }

    @When("I select a discipline on the add course page")
    public void iSelectADisciplineOnTheAddCoursePage() {
        courseType = addCoursePage.getDisciplineElement();
    }

    @Then("I should only be allowed to choose a discipline that exists within the discipline drop-down menu on the add course page")
    public void iShouldOnlyBeAllowedToChooseADisciplineThatExistsWithinTheDisciplineDropDownMenuOnTheAddCoursePage() {
        String[] disciplines = addCoursePage.getAllDisciplines();
        String[] defaultDisciplines = {"Java", "C#", "DevOps", "JavaSDET", "C#SDET"};
        Assertions.assertEquals(Arrays.toString(defaultDisciplines), Arrays.toString(disciplines));
    }

    @When("I enter the {int} of trainers for a course on the add course page")
    public void iEnterTheNumberOfTrainersForACourseOnTheAddCoursePage(int numTrainers) {
        addCoursePage.enterNumberOfTrainers(numTrainers);
    }

    @Then("I should get an alert saying {string} on the add course page")
    public void iShouldGetAnAlertSayingOnTheAddCoursePage(String errorMsg) {
        addCoursePage.clickSubmit();
        Assertions.assertEquals(errorMsg, addCoursePage.getMaxOrMinValueReachedAlertMessage());
    }

    @When("I increment the number of trainers on the add course page")
    public void iSelectACourseToHaveMoreThanTrainersOnTheAddCoursePage() {
        addCoursePage.incrementNumberOfTrainers();
    }

    @And("I select the same {string} on the add course page twice")
    public void iAddTheSameTrainerIDMoreThanOnceToTheCourseOnTheAddCoursePage(String trainerID) {
        addCoursePage.selectTrainerID(1, trainerID);
        addCoursePage.selectTrainerID(2, trainerID);
    }

    @And("I should receive a message alerting me that the same trainer has been selected more than once")
    public void iShouldReceiveAMessageAlertingMeThatTheSameTrainerHasBeenSelectedMoreThanOnceAndIShouldBePreventedFromSubmittingTheFormOnTheAddCoursePage() {
        //TODO: Developers haven't developed feature yet.
        Assertions.assertTrue(false);
    }

    @Then("I should be prevented from submitting the form on the add course page")
    public void iShouldBePreventedFromSubmittingTheFormOnTheAddCoursePage() {
        Assertions.assertFalse(addCoursePage.isSubmissionSuccessful());
    }

    @And("I fill the {string} on course name field on the add course page")
    public void iFillTheCourseName(String courseName) {
        addCoursePage.enterCourseName(courseName);
    }

    @And("I fill the start date with today's date on the add course page")
    public void iFillTheStartDate() {
        addCoursePage.enterStartDate(LocalDate.now());
    }
}
