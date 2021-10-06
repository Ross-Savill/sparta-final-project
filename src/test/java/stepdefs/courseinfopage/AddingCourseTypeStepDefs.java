package stepdefs;

import com.spartaglobal.finalweek.pages.courseInfoPages.AddCourseTypePage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddingCourseTypeStepDefs {
    private final CourseInfoPage courseInfoPage = new CourseInfoPage();
    private final AddCourseTypePage addCourseTypePage = new AddCourseTypePage();
    @And("I click the Add Course Type Button")
    public void iClickTheAddCourseTypeButton() {
        courseInfoPage.clickAddCourseTypeButton();
    }

    @When("I enter a valid name into the course type name field")
    public void iEnterAValidNameIntoTheCourseTypeNameField() {
        addCourseTypePage.enterCourseTypeName("Data");
    }

    @And("I click the submit button on the Add Course Type page")
    public void iClickTheSubmitButtonOnTheAddCourseTypePage() {
        addCourseTypePage.goToCourseInfoPage();
    }

    @When("I enter no data into the course type name field")
    public void iEnterNoDataIntoTheCourseTypeNameField() {
        addCourseTypePage.enterCourseTypeName("");
    }

    @Then("I should be stopped from adding an empty course type name.")
    public void IShouldBeStoppedFromAddingAnEmptyCourseTypeName() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assertions.assertNotEquals("http://localhost:8080/extraCourseInfoPage", webDriver.getCurrentUrl());
    }

    @When("I enter a duplicate name into the course type name field")
    public void iEnterADuplicateNameIntoTheCourseTypeNameField() {
        addCourseTypePage.enterCourseTypeName("Business");
    }

    @Then("I should be stopped from adding a duplicate course name.")
    public void IShouldBeStoppedFromAddingADuplicateCourseName() {
        Assertions.assertTrue(courseInfoPage.areCourseTypesUnique());
    }

    @Then("I should be on the Add Course Type Page")
    public void iShouldBeOnTheAddCourseTypePage() {
        Assertions.assertEquals("http://localhost:8080/addCourseType", webDriver.getCurrentUrl());
    }

    @Then("I should be returned to the course type page and The new course type should be added")
    public void iShouldBeReturnedToTheCourseTypePageAndTheNewCourseTypeShouldBeAdded() {
        Assertions.assertTrue((Objects.equals(webDriver.getCurrentUrl(), "http://localhost:8080/extraCourseInfoPage") && courseInfoPage.getCourseTypesNames().contains("Data")));
    }
}
