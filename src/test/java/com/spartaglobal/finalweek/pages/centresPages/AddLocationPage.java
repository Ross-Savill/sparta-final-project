package com.spartaglobal.finalweek.pages.centresPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddLocationPage extends NavTemplate implements URLable {

    @FindBy(id = "location-location")
    WebElement nameTextField;

    @FindBy(id = "location-no-of-rooms")
    WebElement numRoomsTextField;

    @FindBy(className = "btn-primary")
    WebElement submitButton;

    //Check if this is allowed
    @FindBy(id = "locationTable")
    WebElement centreTable;

    private int getLastIndexFromTable(){
        List<WebElement> centres = centreTable.findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));
        return centres.size() - 1;
    }

    public AddLocationPage(){
        PageFactory.initElements(webDriver, this);
    }

    public void enterLocationName(String locationName){
        nameTextField.sendKeys(locationName);
    }

    public void enterNumberOfRooms(String enterNumberOfRooms){
        numRoomsTextField.sendKeys(enterNumberOfRooms);
    }

    public String getLocationName(){
        return nameTextField.getAttribute("value");
    }

    public int getNumberOfRooms(){
        return Integer.parseInt(numRoomsTextField.getAttribute("value"));
    }

    public boolean isSubmitSuccessful(String locationName, String locationRooms){

        enterLocationName(locationName);
        enterNumberOfRooms(locationRooms);
        submitButton.click();

        int lastIndexFromTable = getLastIndexFromTable();
        String newCentreName = webDriver.findElement(By.id( lastIndexFromTable+"location_name")).getText();
        String newCentreRooms = webDriver.findElement(By.id(lastIndexFromTable+"number_of_rooms")).getText();

        return newCentreName.equals(locationName) && newCentreRooms.equals(locationRooms);

    }

    public boolean isLocationNameEmpty(){
        return nameTextField.getAttribute("value").equals("");
    }

    public boolean isNumberOfRoomsEmpty(){
        return numRoomsTextField.getAttribute("value").equals("");
    }

    public boolean areAllFieldsEmpty(){
        return isLocationNameEmpty() && isNumberOfRoomsEmpty();
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
