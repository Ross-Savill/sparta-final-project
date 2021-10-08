package com.spartaglobal.finalweek.cucumber.stepDefs.courseinfopage;

import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.EditCourseTypePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class EditingCourseTypeStepDefs {
    private final CourseInfoPage courseInfoPage = new CourseInfoPage();
    private final EditCourseTypePage editCourseTypePage = new EditCourseTypePage();

    @And("I click the submit button on the Edit Course Type page")
    public void iClickTheSubmitButtonOnTheEditCourseTypePage() {
        editCourseTypePage.goToCourseInfoPage();
    }

    @Then("I should be returned to the course info page and The new course type name should be present")
    public void iShouldBeReturnedToTheCourseInfoPageAndTheNewCourseTypeNameShouldBePresent() {
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("http://localhost:8080/extraCourseInfoPage") && courseInfoPage.getCourseTypesNames().contains("Data"));
    }

    @When("I enter a duplicate name into the course type name field on the edit page")
    public void iEnterADuplicateNameIntoTheCourseTypeNameFieldOnTheEditPage() {
        editCourseTypePage.enterCourseTypeName("Technology");
    }

    @When("I enter a valid name into the course type name field on the edit course type page")
    public void iEnterAValidNameIntoTheCourseTypeNameFieldOnTheEditCourseTypePage() {
        editCourseTypePage.enterCourseTypeName("Data");
    }

    @When("I enter no data into the course type name field on the edit course type page")
    public void iEnterNoDataIntoTheCourseTypeNameFieldOnTheEditCourseTypePage() {
        editCourseTypePage.enterCourseTypeName("");
    }
}
