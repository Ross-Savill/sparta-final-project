package stepdefs.courseinfopage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteCourseTypeStepDefs {
    @Given("there is a course type in the course types table")
    public void thereIsACourseTypeInTheCourseTypesTable() {
    }

    @When("I click the delete button for the course type on the course info page")
    public void iClickTheDeleteButtonForTheCourseTypeOnTheCourseInfoPage() {
    }

    @Then("There should be a dialogue box confirming that you want to delete the course type")
    public void thereShouldBeADialogueBoxConfirmingThatYouWantToDeleteTheCourseType() {
    }

    @And("Nothing should be removed from the course type table")
    public void nothingShouldBeRemovedFromTheCourseTypeTable() {
    }

    @Then("The course type should no long be present in the course type table")
    public void theCourseTypeShouldNoLongBePresentInTheCourseTypeTable() {
    }
}
