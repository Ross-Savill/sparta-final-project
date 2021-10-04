package stepdefs;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLocationStepDefs {

    @When("I click on an Edit Location button for the \\{string} location")
    public void iClickOnAnEditLocationButtonForTheStringLocation() {
    }

    @Then("I am navigated to a form with the information from the Location already filled in")
    public void iAmNavigatedToAFormWithTheInformationFromTheLocationAlreadyFilledIn() {
    }

    @And("I change information about the location")
    public void iChangeInformationAboutTheLocation() {
    }

    @And("I click the Update button on the Edit Location page")
    public void iClickTheUpdateButtonOnTheEditLocationPage() {
    }

    @Then("The information on the table should be updated to reflect the information I entered")
    public void theInformationOnTheTableShouldBeUpdatedToReflectTheInformationIEntered() {
    }

    @When("I remove the locations name")
    public void iRemoveTheLocationsName() {
    }

    @Then("I should receive an error on the Edit Location page")
    public void iShouldReceiveAnErrorOnTheEditLocationPage() {
    }

    @And("The list of locations should not update")
    public void theListOfLocationsShouldNotUpdate() {
    }

    @When("I remove the number of rooms")
    public void iRemoveTheNumberOfRooms() {
    }

    @When("I enter a non numeric value in the rooms field")
    public void iEnterANonNumericValueInTheRoomsField() {
    }

    @Then("I should receive an error about the value being non numeric on the edit page")
    public void iShouldReceiveAnErrorAboutTheValueBeingNonNumericOnTheEditPage() {
    }

    @When("I click delete on the Delete button on the edit page")
    public void iClickDeleteOnTheDeleteButtonOnTheEditPage() {
    }

    @Then("I should be returned to the centres page")
    public void iShouldBeReturnedToTheCentresPage() {
    }

    @And("The list of locations should no longer have the centre I want to delete")
    public void theListOfLocationsShouldNoLongerHaveTheCentreIWantToDelete() {
    }
}
