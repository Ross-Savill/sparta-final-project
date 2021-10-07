package stepdefs;

import com.spartaglobal.finalweek.pages.centresPages.AddLocationPage;
import com.spartaglobal.finalweek.pages.centresPages.CentresPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AddLocationStepDefs {

    private CentresPage centresPage = new CentresPage();
    private AddLocationPage addLocationPage;
    private final String name = "New Location";
    private final String rooms = "9";
    private final String roomsOfDuplicateName = "1";
    private WebDriver webDriver;

    @Given("I click on the Add Location button")
    public void clickOnAdd(){
        addLocationPage = centresPage.clickAddCentreButton();
    }

    @When("I fill in the location form")
    public void fillLocationForm(){
        addLocationPage.enterLocationName(name);
        addLocationPage.enterNumberOfRooms(rooms);
    }

    @When("I click the Submit button on the Add Location page")
    public void clickSubmit(){
        addLocationPage.clickSubmit();
        centresPage = addLocationPage.goToCentresPage();
    }

    @Then("A new location with the information I added should be added")
    public void newLocationShouldBeAdded(){
        Assertions.assertTrue(centresPage.isUpdateSuccessful(name,rooms));
    }

    @When("I enter a value for the number of rooms")
    public void enterNumberOfRooms(){
        addLocationPage.enterNumberOfRooms(rooms);
    }

    @Then("that value must be numeric")
    public void valueMustBeNumeric(){
        Assertions.assertTrue(addLocationPage.getNumberOfRooms().matches("\\d"));
    }

    @When("I have only entered a location name")
    public void enterLocationName(){
        addLocationPage.enterLocationName(name);
    }

    @Then("The submission on the add page should fail")
    public void submissionFails(){
        Assertions.assertFalse(centresPage.isUpdateSuccessful(name,rooms));
    }

    @When("I enter a location name that already exists")
    public void addNameThatAlreadyExists(){
        addLocationPage.enterLocationName(name);
        addLocationPage.enterNumberOfRooms(rooms);
        addLocationPage.clickSubmit();
        centresPage = addLocationPage.goToCentresPage();

        addLocationPage = centresPage.clickAddCentreButton();
        addLocationPage.enterLocationName(name);

    }

    @And("a different number of rooms")
    public void differentNumberOfRooms(){
        addLocationPage.enterNumberOfRooms(roomsOfDuplicateName);
    }

    @Then("The the database should not accept a duplicate")
    public void databaseShouldNotAcceptDuplicates(){
        Assertions.assertFalse(centresPage.isUpdateSuccessful(name,roomsOfDuplicateName));
    }

}
