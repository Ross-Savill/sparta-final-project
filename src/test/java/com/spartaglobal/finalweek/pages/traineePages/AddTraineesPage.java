package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTraineesPage extends NavTemplate implements URLable {

    @FindBy(id = "trainee-course-name") WebElement courseNameDropDown;
    @FindBy(id = "trainee-first-name") WebElement firstNameTextBox;
    @FindBy(id = "trainee-last-name") WebElement lastNameTextBox;
    @FindBy(id = "btn-primary") WebElement submitButton;

    public AddTraineesPage() {
        PageFactory.initElements(webDriver, this);
    }

//    public void setCourseName() {
//
//    }

//    public WebElement getCourseName() {
//
//    }

//    public void enterFirstName(String firstName) {
//
//    }

//    public WebElement getFirstName() {
//
//    }

//    public void enterLastName(String lastName) {
//
//    }

//    public WebElement getLastName() {
//
//    }

//    public boolean submitSuccessful() {
//
//    }

//    public TraineesPage goToTraineesPage() {
//
//    }

//    public boolean isFirstNameEmpty() {
//
//    }

//    public boolean isLastNameEmpty() {
//
//    }

//    public boolean areFieldsEmpty() {
//
//    }

//    public boolean isFirstNameValid() {
//
//    }

//    public boolean isLastNameValid() {
//
//    }

//    public boolean areFieldsEmpty() {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
