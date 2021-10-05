package stepdefs;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.centresPages.AddLocationPage;
import com.spartaglobal.finalweek.pages.centresPages.CentresPage;
import com.spartaglobal.finalweek.pages.centresPages.EditLocationPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

public class EditLocationStepDefs {

    private CentresPage centresPage = new CentresPage();
    private EditLocationPage editLocationPage;
    private AddLocationPage addLocationPage;
    private String changedName = "changedName";
    private String changedNumOfRooms = "25";
    private String testRooms = "101";

    @When("I click on an Edit Location button for the {word} location")
    public void iClickOnAnEditLocationButtonForTheStringLocation(String locationName) {
        addLocationPage = centresPage.clickAddCentreButton();
        addLocationPage.isSubmitSuccessful(locationName, testRooms);
        centresPage = addLocationPage.goToCentresPage();

        editLocationPage = centresPage.clickEditCentreButton(locationName);
    }

    @Then("I am navigated to a form with the information from the Location already filled in")
    public void iAmNavigatedToAFormWithTheInformationFromTheLocationAlreadyFilledIn() {
        String locationName = editLocationPage.getLocationName();
        Assertions.assertFalse(Matchers.emptyOrNullString().matches(locationName));
    }

    @And("I change information about the location")
    public void iChangeInformationAboutTheLocation() {
        editLocationPage.enterLocationName(changedName);
        editLocationPage.enterNumOfRooms(changedNumOfRooms);
    }

    @And("I click the Update button on the Edit Location page")
    public void iClickTheUpdateButtonOnTheEditLocationPage() {
        centresPage = editLocationPage.goToCentresPage();
    }

    @Then("The information on the table should be updated to reflect the information I entered")
    public void theInformationOnTheTableShouldBeUpdatedToReflectTheInformationIEntered() {
        Assertions.assertTrue(editLocationPage.isUpdateSuccessful(changedName, changedNumOfRooms));
    }

    @When("I remove the locations name")
    public void iRemoveTheLocationsName() {
        changedName = "";
        editLocationPage.clearLocationNameTextFieldContents();
    }

    @Then("I should receive an error on the Edit Location page")
    public void iShouldReceiveAnErrorOnTheEditLocationPage() {

    }

    @And("The list of locations should not update")
    public void theListOfLocationsShouldNotUpdate() {
        Assertions.assertFalse(editLocationPage.isUpdateSuccessful(changedName, changedNumOfRooms));
    }

    @When("I remove the number of rooms")
    public void iRemoveTheNumberOfRooms() {
        editLocationPage.clearNumOfRoomsFieldContents();
    }

    @When("I enter a non numeric value in the rooms field")
    public void iEnterANonNumericValueInTheRoomsField() {
        //editLocationPage.enterNumOfRooms("invalid");
    }

    @Then("I should receive an error about the value being non numeric on the edit page")
    public void iShouldReceiveAnErrorAboutTheValueBeingNonNumericOnTheEditPage() {

    }

    @When("I click delete on the Delete button on the edit page")
    public void iClickDeleteOnTheDeleteButtonOnTheEditPage() {
        editLocationPage.clickDeleteButton();
    }

    @Then("I should be returned to the centres page")
    public void iShouldBeReturnedToTheCentresPage() {
        Assertions.assertEquals("http://localhost:8080/centres", centresPage.getURL());
    }

    @And("The list of locations should no longer have the centre I want to delete")
    public void theListOfLocationsShouldNoLongerHaveTheCentreIWantToDelete(String name, String rooms) {
        editLocationPage.isDeleteSuccessful(name, rooms);
    }

}
