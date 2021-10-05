package com.spartaglobal.finalweek.pages.centresPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditLocationPage extends NavTemplate implements URLable {

    public EditLocationPage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "location-location")
    private WebElement locationNameTextField;
    @FindBy(id = "location-no-of-rooms")
    private WebElement locationNumRoomsTextField;

    public String getLocationName() {
        return locationNameTextField.getAttribute("value");
    }

    public void enterLocationName(String locationName) {
        locationNameTextField.clear();
        locationNameTextField.sendKeys(locationName);
    }

    public int getNumOfRooms() {
        return Integer.parseInt(locationNumRoomsTextField.getText());
    }

    public void enterNumOfRooms(String numOfRooms) {
        locationNumRoomsTextField.clear();
        locationNumRoomsTextField.sendKeys(numOfRooms);
    }

    public void clearLocationNameTextFieldContents() {
        this.clearBox(locationNameTextField);
    }

    public void clearNumOfRoomsFieldContents() {
        this.clearBox(locationNumRoomsTextField);
    }

    private void clearBox(WebElement box) {
       box.clear();
    }

    public CentresPage goToCentresPage(int xOffset, int yOffset) {
        clickButton(getUpdateButton(), xOffset, yOffset);
        return new CentresPage();
    }

    public CentresPage goToCentresPage() {
        getUpdateButton().click();
        return new CentresPage();
    }

    public CentresPage clickDeleteButton() {
        getDeleteButton().click();
        return new CentresPage();
    }

    public CentresPage clickDeleteButton(int xOffset, int yOffset) {
        getDeleteButton().click();
        return new CentresPage();
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

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    private void clickButton(WebElement button, int xOffset, int yOffset) {
        Actions build = new Actions(webDriver);
        build.moveToElement(button, xOffset, yOffset).click().build().perform();
    }

    private WebElement getUpdateButton() {
        List<WebElement> buttons =  webDriver.findElements(By.className("btn-primary"));
        return buttons.get(0);
    }

    private WebElement getDeleteButton() {
        List<WebElement> buttons =  webDriver.findElements(By.className("btn-primary"));
        return buttons.get(1);
    }
}
