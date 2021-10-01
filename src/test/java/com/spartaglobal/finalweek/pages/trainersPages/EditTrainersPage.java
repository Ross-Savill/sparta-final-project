package com.spartaglobal.finalweek.pages.trainersPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class EditTrainersPage extends NavTemplate implements URLable {
    @FindBy(id = "edit-trainer-first-name")
    WebElement firstNameTextBox;
    @FindBy(id = "edit-trainer-last-name")
    WebElement lastNameTextBox;
    @FindBy(id = "trainer-hex")
    WebElement colourPicker;
    @FindBy(className = "btn btn-primary")
    WebElement submitButton;
    @FindBy(id = "trainerPageLink")
    WebElement trainersPageButton;

    public EditTrainersPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    private String getFirstName(){
       return firstNameTextBox.getAttribute("value");
    }

    private void enterFirstName(String firstName){
        firstNameTextBox.sendKeys(firstName);
    }

    private String getLastName(){
        return lastNameTextBox.getAttribute("value");
    }

    private void enterLastName(String lastName){
        lastNameTextBox.sendKeys(lastName);
    }

    private String getColour(){
        return colourPicker.getAttribute("value");
    }

    private void setColour(){
        JavascriptExecutor jse=(JavascriptExecutor)webDriver;
        jse.executeScript("document.getElementByid('EditorColorPicker1').value='#FFEEXX'");
    }

    private void submitTrainer()
    {
        submitButton.click();
    }

    public TrainersPage goToTrainersPage(){
        trainersPageButton.click();
        return new TrainersPage();
    }

    private boolean isSubmitSuccessful(){
        submitTrainer();
        if(getURL() == "http://localhost:8080/trainerPage")
        {
            return true;
        }
        return false;
    }

    private boolean isFirstNameEmpty(){
        if(getFirstName() == null)
        {
            return true;
        }
        return false;
    }

    private boolean isLastNameEmpty(){
        if(getLastName() == null)
        {
            return true;
        }
        return false;
    }

    private boolean areAllFieldsEmpty(){
        if(isFirstNameEmpty() == true && isLastNameEmpty() == true )
        {
            return true;
        }
        return false;
    }

    private boolean isFirstNameValid(){
        if(getFirstName().matches("/^[a-z 0-9 ,.'-]+$/i"))
        {
            return true;
        }
        return false;
    }

    private boolean isLastNameValid(){
        if(getLastName().matches("/^[a-z 0-9 ,.'-]+$/i"))
        {
            return true;
        }
        return false;
    }

    private boolean areAllFieldsValid(){
        if(isFirstNameValid() == true && isLastNameValid() == true )
        {
            return true;
        }
        return false;
    }


}
