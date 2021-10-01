package com.spartaglobal.finalweek.pages.trainersPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class AddTrainersPage extends NavTemplate implements URLable {

    @FindBy(id = "trainer-first-name")
    WebElement firstNameTextBox;
    @FindBy(id = "trainer-last-name")
    WebElement lastNameTextBox;
    @FindBy(id = "trainer-hex")
    WebElement colourPicker;
    @FindBy(className = "btn btn-primary")
    WebElement submitButton;
    @FindBy(id = "trainerPageLink")
    WebElement trainersPageButton;


    public AddTrainersPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public String getFirstName(){
        return firstNameTextBox.getAttribute("value");
    }

    public void enterFirstName(String firstName){
        firstNameTextBox.sendKeys(firstName);
    }

    public String getLastName(){
        return lastNameTextBox.getAttribute("value");
    }

    public void enterLastName(String lastName){
        lastNameTextBox.sendKeys(lastName);
    }

    public String getColour(){
        return colourPicker.getAttribute("value");
    }

    public void setColour(){
        JavascriptExecutor jse=(JavascriptExecutor)webDriver;
        jse.executeScript("document.getElementByid('EditorColorPicker1').value='#FFEEXX'");
    }

    public void submitTrainer()
    {
        submitButton.click();
    }

    public TrainersPage goToTrainersPage(){
        trainersPageButton.click();
        return new TrainersPage();
    }

    public boolean isSubmitSuccessful(){
        submitTrainer();
        if(getURL() == trainersPageURL ) {
            return true;
        }
        return false;
    }

    public boolean isFirstNameEmpty(){
        if(getFirstName() == null) {
            return true;
        }
        return false;
    }

    public boolean isLastNameEmpty(){
        if(getLastName() == null) {
            return true;
        }
        return false;
    }

    public boolean areAllFieldsEmpty(){
        if(isFirstNameEmpty() == true && isLastNameEmpty() == true ) {
            return true;
        }
        return false;
    }

    public boolean isFirstNameValid(){
        if(getFirstName().matches("/^[a-z 0-9 ,.'-]+$/i")) {
            return true;
        }
        return false;
    }

    public boolean isLastNameValid(){
        if(getLastName().matches("/^[a-z 0-9 ,.'-]+$/i")) {
            return true;
        }
        return false;
    }

    public boolean areAllFieldsValid(){
        if(isFirstNameValid() == true && isLastNameValid() == true ) {
            return true;
        }
        return false;
    }


}
