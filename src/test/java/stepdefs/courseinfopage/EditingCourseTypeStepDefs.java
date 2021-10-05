package stepdefs.courseinfopage;

import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.EditCourseTypePage;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class EditingCourseTypeStepDefs {
    private final CourseInfoPage courseInfoPage = new CourseInfoPage();
    private final EditCourseTypePage editCourseTypePage =  new EditCourseTypePage();

    @Given("I am using dummy data")
    public void iAmUsingDummyData() {
        ResetData.resetData();
    }

    @And("I click the Edit Course Type Button for any course type")
    public void iClickTheEditCourseTypeButtonForAnyCourseType() {
        courseInfoPage.clickDeleteDisciplineButton("Java");
    }

    @When("I  enter a valid name into the course type name field")
    public void iEnterAValidNameIntoTheCourseTypeNameField() {
        editCourseTypePage.enterCourseTypeName("Data");
    }

    @And("I click the submit button on the Edit Course Type page")
    public void iClickTheSubmitButtonOnTheEditCourseTypePage() {
        editCourseTypePage.goToCourseInfoPage();
    }

    @Given("There is a course type present")
    public void thereIsACourseTypePresent() {
        if (courseInfoPage.getCourseTypesNames().isEmpty()) {
            System.out.println("No Disciplines in List, please use default data");
            Assertions.fail();
        }
    }

    @Then("I should be on the Edit Course Type Page for that course type")
    public void iShouldBeOnTheEditCourseTypePageForThatCourseType() {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/editCourseType/") && editCourseTypePage.getCourseTypeName().getAttribute("value").equals("Java"));
    }

    @Then("I should be returned to the course info page and The new course type name should be present")
    public void iShouldBeReturnedToTheCourseInfoPageAndTheNewCourseTypeNameShouldBePresent() {
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("http://localhost:8080/extraCourseInfoPage") && courseInfoPage.getCourseTypesNames().contains("Data"));
    }
}
