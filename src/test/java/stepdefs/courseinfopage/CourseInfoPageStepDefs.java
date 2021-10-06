package stepdefs.courseinfopage;

import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.EditCourseTypePage;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CourseInfoPageStepDefs {
    private CourseInfoPage courseInfoPage;
    private EditCourseTypePage editCourseTypePage;
    private String courseTypeName;
    private List<String> courseTypeNamesList;
    private String disciplineName;
    private List<String> disciplineNamesList;

    @Before("@courseType")
    public void setup() {
        editCourseTypePage = new EditCourseTypePage();
        courseInfoPage = new CourseInfoPage();
    }

    @Given("I am using dummy data")
    public void iAmUsingDummyData() {
        ResetData.resetData();
    }

    @When("I want to find a specific course type")
    public void iWantToFindASpecificCourseType() {
        courseTypeName = "Business";
    }

    @And("I look at the course type table")
    public void iLookAtTheCourseTypeTable() {
        courseTypeNamesList = courseInfoPage.getCourseTypesNames();
    }

    @Then("I should see that course type in the table")
    public void iShouldSeeThatCourseTypeInTheTable() {
        Assertions.assertTrue(courseTypeNamesList.contains(courseTypeName));
    }

    @When("I want to find a specific discipline")
    public void iWantToFindASpecificDiscipline() {
        disciplineName = "Java";
    }

    @And("I look at the discipline table")
    public void iLookAtTheDisciplineTable() {
        disciplineNamesList = courseInfoPage.getDisciplineNames();
    }

    @Then("I should see that discipline in the table")
    public void iShouldSeeThatDisciplineInTheTable() {
        Assertions.assertTrue(disciplineNamesList.contains(disciplineName));
    }

    @Given("there is a course type in the course types table")
    public void thereIsACourseTypeInTheCourseTypesTable() {
        if (courseInfoPage.getCourseTypesNames().isEmpty()) {
            System.out.println("No Course Types in List, please use default data");
            Assertions.fail();
        }
    }

    @When("I click the delete button for the course type on the course info page")
    public void iClickTheDeleteButtonForTheCourseTypeOnTheCourseInfoPage() {
        courseInfoPage.clickDeleteCourseTypeButton("Business");
    }

    @Then("The course type should no long be present in the course type table")
    public void theCourseTypeShouldNoLongBePresentInTheCourseTypeTable() {
        Assertions.assertTrue(courseInfoPage.isCourseTypeDeleted("Business"));
    }

    @Then("There should be a dialogue box confirming that you want to delete the course type and Nothing should be removed from the course type table")
    public void thereShouldBeADialogueBoxConfirmingThatYouWantToDeleteTheCourseTypeAndNothingShouldBeRemovedFromTheCourseTypeTable() {
        boolean hasDialogueBox = false;
        try {
            webDriver.switchTo().alert();
            hasDialogueBox = true;
        }
        catch (NoAlertPresentException ignored) {
        }
        Assertions.assertTrue(hasDialogueBox && !courseInfoPage.isDisciplineDeleted("Business"));
    }

    @Then("Nothing should be removed from the course type table")
    public void nothingShouldBeRemovedFromTheCourseTypeTable() {
        Assertions.assertFalse(courseInfoPage.isCourseTypeDeleted("Business"));
    }

    @Given("there is a discipline in the discipline table")
    public void thereIsADisciplineInTheDisciplineTable() {
        if (courseInfoPage.getDisciplineNames().isEmpty()) {
            System.out.println("No Disciplines in List, please use default data");
            Assertions.fail();
        }
    }

    @When("I click the delete button for the discipline on the course info page")
    public void iClickTheDeleteButtonForTheDisciplineOnTheCourseInfoPage() {
        courseInfoPage.clickDeleteDisciplineButton("Java");
    }

    @And("Nothing should be removed from the discipline table")
    public void nothingShouldBeRemovedFromTheDisciplineTable() {
        Assertions.assertFalse(courseInfoPage.isDisciplineDeleted("Java"));
    }

    @When("I click NO on the dialogue box")
    public void iClickNOOnTheDialogueBox() {
        try {
            webDriver.findElement(new By.ByLinkText("No")).click();
        } catch (NoSuchElementException e) {
            Assertions.fail();
        }
    }

    @When("I click YES on the dialogue box")
    public void iClickYESOnTheDialogueBox() {
        try {
            webDriver.findElement(new By.ByLinkText("Yes")).click();
        } catch (NoSuchElementException e) {
            Assertions.fail();
        }
    }

    @Then("The discipline should no long be present in the discipline table")
    public void theDisciplineShouldNoLongBePresentInTheDisciplineTable() {
        Assertions.assertTrue(courseInfoPage.isDisciplineDeleted("Java"));
    }

    @Then("There should be a dialogue box confirming that you want to delete the discipline and Nothing should be removed from the discipline table")
    public void thereShouldBeADialogueBoxConfirmingThatYouWantToDeleteTheDisciplineAndNothingShouldBeRemovedFromTheDisciplineTable() {
        boolean hasDialogueBox = false;
        try {
            webDriver.switchTo().alert();
            hasDialogueBox = true;
        }
        catch (NoAlertPresentException ignored) {
        }
        Assertions.assertTrue(hasDialogueBox && !courseInfoPage.isDisciplineDeleted("Java"));
    }

    @And("I click the Add Course Type Button")
    public void iClickTheAddCourseTypeButton() {
        PageFactory.initElements(webDriver, courseInfoPage);
        courseInfoPage.clickAddCourseTypeButton();
    }
    @Then("I should be on the Add Course Type Page")
    public void iShouldBeOnTheAddCourseTypePage() {
        Assertions.assertEquals("http://localhost:8080/addCourseType", webDriver.getCurrentUrl());
    }

    @Given("There is a course type present")
    public void thereIsACourseTypePresent() {
        if (courseInfoPage.getCourseTypesNames().isEmpty()) {
            System.out.println("No Disciplines in List, please use default data");
            Assertions.fail();
        }
    }

    @And("I click the Edit Course Type Button for any course type")
    public void iClickTheEditCourseTypeButtonForAnyCourseType() {
        courseInfoPage.clickEditCourseTypeButton("Business");
    }

    @Then("I should be on the Edit Course Type Page for that course type")
    public void iShouldBeOnTheEditCourseTypePageForThatCourseType() {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/editCourseType/") && editCourseTypePage.getCourseTypeName().getAttribute("value").equals("Business"));
    }

    @After("@courseType")
    public void tearDown(){
        webDriver.quit();
    }
}
