package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditTraineesPage extends NavTemplate implements URLable {

    @FindBy(id = "edit-trainee-course-name") WebElement courseNameDropDown;
    @FindBy(id = "edit-trainee-first-name") WebElement firstNameTextBox;
    @FindBy(id = "edit-trainee-last-name") WebElement lastNameTextBox;
    @FindBy(id = "btn-primary") WebElement submitButton;


    public EditTraineesPage() {
        PageFactory.initElements(webDriver, this);
    }

//    public void selectCourseName(String courseName) {
//
//    }

//    public void enterFirstName(String firstName) {
//
//    }

//    public void enterLastName(String lastName) {
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

//    public boolean areAllFieldsEmpty() {
//
//    }

//    public boolean isFirstNameValid() {
//
//    }

//    public boolean isLastNameValid() {
//
//    }

//    public boolean areAllFieldsEmpty() {
//
//    }

//    public boolean isFirstNamePopulated() {
//
//    }

//    public boolean isLastNamePopulated() {
//
//    }

//    public boolean areAllFieldsPopulated() {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
