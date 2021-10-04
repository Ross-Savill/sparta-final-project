package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;

public class AddTraineesPage extends NavTemplate implements URLable {

    @FindBy(id = "trainee-course-name")
    WebElement courseNameDropDown;
    @FindBy(id = "trainee-first-name")
    WebElement firstNameTextBox;
    @FindBy(id = "trainee-last-name")
    WebElement lastNameTextBox;
    @FindBy(id = "btn-primary")
    WebElement submitButton;

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


    //======================================================================
    public void enterTraineeId(int traineeId) {
    }

    public WebElement getTraineeIdElement() {
        return null;
    }

    public int getTraineeId() {
        return 0;
    }

    public void setQualityGateStatus(String qualityGateStatus) {
    }

    public WebElement getQualityGateStatusElement() {
        return null;
    }

    public String getQualityGateStatus() {
        return null;
    }

    public void setTrainerOneId(WebElement traineeOneId) {
    }

    public WebElement getTrainerOneId() {
        return null;
    }

    public void enterTrainerOneFeedback(String traineeOneFeedback) {
    }

    public WebElement getTrainerOneFeedback() {
        return null;
    }

    public void setTrainerTwoId(WebElement traineeTwoId) {
    }

    public WebElement getTrainerTwoId() {
        return null;
    }

    public void setDate(LocalDate date) {
    }

    public WebElement getDate() {
        return null;
    }

    public TraineesPage goToTraineesPage() {
        return null;
    }

    public boolean isSubmitSuccessful() {
        return false;
    }

    public boolean isTrainerOneFeedbackEmpty() {
        return false;

    }

    public boolean isTrainerTwoFeedbackEmpty() {
        return false;

    }

    public boolean isDateValid() {
        return false;

    }

    public boolean isDateEmpty() {
        return false;

    }

    public boolean areAllFieldsValid() {
        return false;

    }

    public boolean areAllFieldsEmpty() {
        return false;

    }


    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
