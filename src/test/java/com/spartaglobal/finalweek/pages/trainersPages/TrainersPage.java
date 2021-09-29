package com.spartaglobal.finalweek.pages.trainersPages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrainersPage extends NavTemplate implements URLable {

    public TrainersPage() {
        TestBase.initialisation();
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public List<WebElement> getAllTrainersFirstNameElements() {
        return null;
    }

    public List<WebElement> getAllTrainersLastNameElements() {

        return null;

    }

    public List<WebElement> getAllTrainerElements() {
        return null;

    }

    public List<WebElement> getAllTrainerColourElements() {
        return null;

    }

    public List<String> getAllTrainersFirstName() {
        return null;

    }

    public List<String> getAllTrainersLastName() {
        return null;

    }

    public List<String> getAllTrainerColour() {
        return null;

    }

    public List<WebElement> getTrainerFirstNameElement(int id) {
        return null;

    }

    public List<WebElement> getTrainerLastNameElement(int id) {
        return null;

    }

    public List<WebElement> getTrainerColourElement(int id) {
        return null;

    }

    public String getTrainerFirstName(int rowID) {
        return null;

    }

    public String getTrainerLastName(int rowID) {
        return null;

    }
    public String getTrainerColour(int rowID) {
        return null;

    }

    public AddTrainersPage clickAddTrainer() {
        return null;

    }

    public EditTrainersPage clickEditTrainer() {
        return null;

    }

    public void clickDeleteTrainer() {


    }

    public boolean isTrainerDeleted() {
        return false;

    }

    public boolean isTrainerFirstNameValid() {
        return false;

    }

    public boolean isTrainerLastNameValid() {
        return false;

    }

    public boolean areAllTrainersFirstNamesValid() {
        return false;

    }

    public boolean areAllTrainersLastNamesValid() {
        return false;

    }

    public boolean areAllColoursUnique() {
        return false;

    }

    public boolean areAllFieldsPassedOnToEditTrainersPage() {
        return false;

    }


}
