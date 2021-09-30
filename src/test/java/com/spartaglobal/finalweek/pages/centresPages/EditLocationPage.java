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

    public void enterNumOfRooms(int numOfRooms) {
        locationNumRoomsTextField.clear();
        locationNumRoomsTextField.sendKeys(Integer.toString(numOfRooms));
    }

    public boolean isUpdateSuccessful() {
        return false;
    }

    public CentresPage goToCentresPage(int xOffset, int yOffset) {
        clickButton(getUpdateButton(), xOffset, yOffset);
        getUpdateButton().click();
        return new CentresPage();
    }

    public CentresPage goToCentresPage() {
        getUpdateButton().click();
        return new CentresPage();
    }

    private void clickButton(WebElement button, int xOffset, int yOffset) {
        Actions build = new Actions(webDriver);
        build.moveToElement(button, xOffset, yOffset).click().build().perform();
    }

    private WebElement getUpdateButton() {
        List<WebElement> buttons =  webDriver.findElements(By.className("btn-primary"));
        return buttons.get(0);
    }

    public boolean isDeleteSuccessful() {
        return false;
    }

    public boolean hasUpdatedFieldsTransferred() {

        List<WebElement> centres = webDriver.findElements(By.id("locationTable"));
        for (WebElement centre:centres) {
            WebElement nameTextField = webDriver.findElement(By.id(centres.indexOf(centre)+"location_name"));
            WebElement numRoomsTextField = webDriver.findElement(By.id(centres.indexOf(centre)+"number_of_rooms"));

            if(getLocationName().equals(nameTextField.getAttribute("value"))
                    && getNumOfRooms() == Integer.parseInt(numRoomsTextField.getAttribute("value"))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
