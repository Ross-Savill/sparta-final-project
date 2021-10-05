package com.spartaglobal.finalweek.cucumber.stepDefs;

import com.spartaglobal.finalweek.pages.centresPages.CentresPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.nio.file.ClosedWatchServiceException;

public class DeleteLocationDtepDefs {

    private CentresPage centresPage = new CentresPage();

    @When("I click the delete location button for {word}")
    public void iClickTheDeleteLocationButton(String location) {
        centresPage.clickDeleteCentreButton(location);
    }

    @Then("A dialog box should pop up asking if you are sure that you want to remove the Location")
    public void aDialogBoxShouldPopUpAskingIfYouAreSureThatYouWantToRemoveTheLocation() {
        Assertions.assertTrue(centresPage.doesConfirmationBoxAppearOnDelete());
    }

    @And("I confirm I want to delete the location")
    public void iConfirmIWantToDeleteTheLocation() {
        centresPage.confirmDelete();
    }

    @Then("The {word} location is deleted")
    public void theLocationIsDeleted(String locationName) {
        Assertions.assertTrue(centresPage.isCentreDeleted(locationName));
    }

    @And("I decline deleting the location")
    public void iDeclineDeletingTheLocation() {
        centresPage.cancelDelete();
    }

    @Then("The {word} location is not deleted")
    public void theLocationIsNotDeleted(String locationName) {
        Assertions.assertFalse(centresPage.isCentreDeleted(locationName));
    }
}
