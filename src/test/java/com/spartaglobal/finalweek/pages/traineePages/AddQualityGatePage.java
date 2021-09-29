package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;

public class AddQualityGatePage extends NavTemplate implements URLable {

    @FindBy(id = "traineeId") WebElement traineeId;
    @FindBy(id = "qualityGateStatus") WebElement qualityGateStatus;
    @FindBy(id = "trainerId1") WebElement trainerOneId;
    @FindBy(id = "feedback1") WebElement trainerOneFeedback;
    @FindBy(id = "trainerId2") WebElement trainerTwoId;
    @FindBy(id = "feedback2") WebElement trainerTwoFeedback;
    @FindBy(id = "date") LocalDate date;
    @FindBy(id = "btn-primary") LocalDate submitButton;

    public AddQualityGatePage() {
        PageFactory.initElements(webDriver, this);
    }

//    public void enterTraineeId(int traineeId) {
//
//    }

//    public WebElement getTraineeIdElement() {
//
//    }

//    public int getTraineeId() {
//
//    }

//    public void setQualityGateStatus(String qualityGateStatus) {
//
//    }

//    public WebElement getQualityGateStatusElement() {
//
//    }

//    public String getQualityGateStatus() {
//
//    }

//    public void setTrainerOneId(WebElement traineeOneId) {
//
//    }

//    public WebElement getTrainerOneId() {
//
//    }

//    public void enterTrainerOneFeedback(String traineeOneFeedback) {
//
//    }

//    public WebElement getTrainerOneFeedback() {
//
//    }

//    public void setTrainerTwoId(WebElement traineeTwoId) {
//
//    }

//    public WebElement getTrainerTwoId() {
//
//    }

//    public void setDate(LocalDate date) {
//
//    }

//    public WebElement getDate() {
//
//    }

//    public boolean submitSuccessful() {
//
//    }

//    public TraineesPage goToTraineesPage() {
//
//    }

//    public boolean isTrainerOneFeedbackEmpty() {
//
//    }

//    public boolean isTrainerTwoFeedbackEmpty() {
//
//    }

//    public boolean isDateValid() {
//
//    }

//    public boolean isDateEmpty() {
//
//    }

//    public boolean areAllFieldsValid() {
//
//    }

//    public boolean areAllFieldsEmpty() {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
