package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddingCourseTypeStepDefs {
    @And("I click the Add Course Type Button")
    public void iClickTheAddCourseTypeButton() {
    }

    @When("I enter a valid name into the course type name field")
    public void iEnterAValidNameIntoTheCourseTypeNameField() {
    }

    @And("I click the submit button on the Add Course Type page")
    public void iClickTheSubmitButtonOnTheAddCourseTypePage() {
    }

    @And("The new course type should be added")
    public void theNewCourseTypeShouldBeAdded() {
    }

    @When("I enter no data into the course type name field")
    public void iEnterNoDataIntoTheCourseTypeNameField() {
    }

    @Then("When I click the submit button I should be stopped from adding an empty course type name.")
    public void whenIClickTheSubmitButtonIShouldBeStoppedFromAddingAnEmptyCourseTypeName() {
    }

    @When("I enter a duplicate name into the course type name field")
    public void iEnterADuplicateNameIntoTheCourseTypeNameField() {
    }

    @Then("When I click the Submit button I should be stopped from adding a duplicate course name.")
    public void whenIClickTheSubmitButtonIShouldBeStoppedFromAddingADuplicateCourseName() {
    }

    @Then("I should be on the Add Course Type Page")
    public void iShouldBeOnTheAddCourseTypePage() {

    }
}
