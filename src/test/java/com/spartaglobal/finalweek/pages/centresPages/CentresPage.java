package com.spartaglobal.finalweek.pages.centresPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import io.cucumber.java.bs.A;
import io.cucumber.java.sl.Ce;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CentresPage extends NavTemplate implements URLable {

    @FindBy(id = "locationTable")
    WebElement centreTable;
    @FindBy(className = "btn-primary")
    WebElement addLocationButton;

    private List<WebElement> centres;
    private List<WebElement> locationNames;
    private List<WebElement> numberOfRooms;

    public CentresPage(){
        PageFactory.initElements(webDriver, this);

        this.getCentres();

        locationNames = new ArrayList<>();
        locationNames = this.getAllLocationNames();

        numberOfRooms = new ArrayList<>();
    }

    public List<WebElement> getAllCentres() {
        return this.getCentres();
    }

    private List<WebElement> getCentres() {
        centres = centreTable.findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));
        return centres;
    }

    public List<WebElement> getAllLocationNames() {

        for (WebElement centre:centres) {
            locationNames.add(
                    centre.findElement(By.id(Integer.toString(centres.indexOf(centre))+"location_name"))
            );
        }
        return locationNames;
    }

    public List<WebElement> getCentresByLocationName(String locationName) {
        List<WebElement> foundCentres = new ArrayList<>();

        for (WebElement centre:centres) {
            if(centre.findElement(By.id(Integer.toString(centres.indexOf(centre))+"location_name")).getText().equals(locationName)){
                foundCentres.add(centre);
            }
        }
        return foundCentres;
    }

    public List<WebElement> getCentresByNumberOfRooms(int roomNumber) {
        List<WebElement> foundCentres = new ArrayList<>();

        for (WebElement centre:centres) {
            if(centre.findElement(By.id(centres.indexOf(centre)+"number_of_rooms")).getText().equals(Integer.toString(roomNumber))) {
                foundCentres.add(centre);
            }
        }
        return  foundCentres;
    }

    public List<WebElement> getCentresByNumberOfRooms(int lowerBound, int higherBound) {

        if(lowerBound > higherBound) {
            int temp = higherBound;
            higherBound = lowerBound;
            lowerBound = temp;
        }
        if(lowerBound < 0) {
            lowerBound = 0;
        }
        if (higherBound < 0) {
            higherBound = 0;
        }

        List<WebElement> foundCentres = new ArrayList<>();

        for (WebElement centre:centres) {
            int roomNumber = Integer.parseInt(centre.findElement(By.id(Integer.toString(centres.indexOf(centre))+"number_of_rooms")).getText());
            if(roomNumber >= lowerBound && roomNumber <= higherBound) {
                foundCentres.add(centre);
            }
        }
        return foundCentres;
    }

    public int getNumberOfRooms(String centreName) {
        List<WebElement> foundCentres;

        foundCentres = this.getCentresByLocationName(centreName);
        try{
        WebElement centre = foundCentres.get(0);
        WebElement numberOfRooms = centre.findElement(
                By.id(Integer.toString(centres.indexOf(centre))+"number_of_rooms"));

        return Integer.parseInt(numberOfRooms.getText());
        }catch(IndexOutOfBoundsException iOOB){
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    public AddLocationPage clickAddCentreButton(int xOffset, int yOffset) {
        clickButton(xOffset, yOffset, addLocationButton);
        return new AddLocationPage();
    }

    public AddLocationPage clickAddCentreButton() {
        addLocationButton.click();
        return new AddLocationPage();
    }

    public EditLocationPage clickEditCentreButton(int xOffset, int yOffset, String centreName) {
        clickButton(xOffset, yOffset, getEditButton(centreName));
        return new EditLocationPage();
    }

    public EditLocationPage clickEditCentreButton(String centreName) {
        getEditButton(centreName).click();
        return new EditLocationPage();
    }

    public void clickDeleteCentreButton(String centreName) {
        this.getDeleteButton(centreName).click();
    }

    public void clickDeleteCentreButton(int xOffset, int yOffset, String centreName) {
        WebElement deleteButton = this.getDeleteButton(centreName);
        this.clickButton(xOffset, yOffset, deleteButton);
    }

    public boolean doesConfirmationBoxAppearOnDelete() {
        //this.clickDeleteCentreButton(locationName);

        try{
            webDriver.switchTo().alert();
            return true;
        }catch(Exception e){
            return false;
        }

    }

    public boolean isCentreDeleted(String locationName) {
        int numberOfCentresBefore = getAllCentres().size();
        this.clickDeleteCentreButton(locationName);
        this.confirmDelete();
        int numberOfCentresAfter = getAllCentres().size();
        return numberOfCentresBefore > numberOfCentresAfter;
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    private void clickButton(int xOffset, int yOffset, WebElement button) {
        Actions build = new Actions(webDriver);
        build.moveToElement(button, xOffset, yOffset).click().build().perform();
    }

    private WebElement getEditButton(String centreName) {
        WebElement button;
        button = getCentresByLocationName(centreName).get(0).findElement(By.className("btn"));
        return button;
    }
    private WebElement getDeleteButton(String centreName) {
        WebElement centre = this.getCentresByLocationName(centreName).get(0);
        WebElement deleteButton = centre.findElements(By.className("btn")).get(1);
        return deleteButton;
    }

    public boolean confirmDelete() {
        webDriver.switchTo().alert().accept();
        return true;

    }

    private boolean isSuccessful(String locationName, String numberOfRooms, boolean update) {
        WebElement table = webDriver.findElement(By.id("locationTable"));
        List<WebElement> centres = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        for (WebElement centre:centres) {
            WebElement nameTextField = webDriver.findElement(By.id(centres.indexOf(centre)+"location_name"));
            WebElement numRoomsTextField = webDriver.findElement(By.id(centres.indexOf(centre)+"number_of_rooms"));

            if(locationName.equals(nameTextField.getText())
                    && numberOfRooms.equals(numRoomsTextField.getText())) {
                return update;
            }
        }
        return !update;
    }

    public boolean isDeleteSuccessful(String locationName, String numberOfRooms) {
        return isSuccessful(locationName, numberOfRooms, false);
    }

    public boolean isUpdateSuccessful(String updatedLocationName, String updatedLocationNumOfRooms) {
        return isSuccessful(updatedLocationName, updatedLocationNumOfRooms, true);
    }

    public boolean areAllFieldsPassedOnToEditCentrePage(String locationName) {
        int numberOfRooms = this.getNumberOfRooms(locationName);

        this.clickEditCentreButton(locationName);

        WebElement nameTextField = webDriver.findElement(By.id("location-location"));
        WebElement numRoomsTextField = webDriver.findElement(By.id("location-no-of-rooms"));

        if(locationName.equals(nameTextField.getAttribute("value"))
            && numberOfRooms == Integer.parseInt(numRoomsTextField.getAttribute("value"))) {
            return true;
        }
        return false;
    }

    public boolean areAllCentresUnique() {
        HashSet<String> locations = new HashSet<>();

        for (WebElement centre:centres) {
            if(!locations.add(centre.findElement(By.id(centres.indexOf(centre)+"location_name")).getText())) {
                return false;
            }
        }
        return true;

    }

    public boolean cancelDelete() {
        webDriver.switchTo().alert().dismiss();
        return true;
    }

    private List<WebElement> getButtonsByName(String locationName){
        List<WebElement> foundButtons = new ArrayList<>();

        for (WebElement centre:centres) {
            if(centre.findElement(By.id(Integer.toString(centres.indexOf(centre))+"location_name")).getText().equals(locationName)) {
                foundButtons.addAll(centre.findElements(By.className("btn")));
                return foundButtons;
            }

        }
        return foundButtons;
    }

    public WebElement clickSpecificButton(String locationName, String buttonType){
        List<WebElement> buttons = getButtonsByName(locationName);
        if(buttonType.equals("edit")){
            return buttons.get(0);
        }
        else if(buttonType.equals("delete")){
            return buttons.get(1);
        }
        else return null;
    }

}

