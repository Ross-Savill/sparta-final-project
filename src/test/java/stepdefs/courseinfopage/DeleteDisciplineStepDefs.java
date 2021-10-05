package stepdefs.courseinfopage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteDisciplineStepDefs {
    @Given("there is a discipline in the discipline table")
    public void thereIsADisciplineInTheDisciplineTable() {
    }

    @When("I click the delete button for the discipline on the course info page")
    public void iClickTheDeleteButtonForTheDisciplineOnTheCourseInfoPage() {
    }

    @Then("There should be a dialogue box confirming that you want to delete the discipline")
    public void thereShouldBeADialogueBoxConfirmingThatYouWantToDeleteTheDiscipline() {
    }

    @And("Nothing should be removed from the discipline table")
    public void nothingShouldBeRemovedFromTheDisciplineTable() {
    }

    @When("I click NO on the dialogue box")
    public void iClickNOOnTheDialogueBox() {
    }

    @When("I click YES on the dialogue box")
    public void iClickYESOnTheDialogueBox() {
    }

    @Then("The discipline should no long be present in the discipline table")
    public void theDisciplineShouldNoLongBePresentInTheDisciplineTable() {
    }
}
