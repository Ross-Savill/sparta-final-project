package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.courseInfoPages.EditCourseTypePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TraineesPage extends NavTemplate implements URLable {

    @FindBy(id = "traineePageLink") WebElement addTraineeButton;
    @FindBy(id = "accordion-button") WebElement courseFilterDropDownButton;
    @FindBy(id = "course") List<WebElement> coursesWithinFilter;
    @FindBy() List<WebElement> allTrainees; // How to get a list of all Trainees? Just different row IDs
    @FindBy(css = "#\30 row > td:nth-child(4) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement editTraineeButton;
    @FindBy(css = "#\\30 row > td:nth-child(5) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement deleteTraineeButton;
    @FindBy(css = "#\\30 row > td:nth-child(6) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement addQualityGateButton;
    @FindBy() WebElement qualityGateHistory; // Not sure how/what to grab here

    public TraineesPage() {
        PageFactory.initElements(webDriver, this);
    }

//    public List<WebElement> getAllTraineesElements() {
//
//    }

//    public List<WebElement> getAllTraineesFirstNameElements() {
//
//    }

//    public List<WebElement> getAllTraineesLastNameElements() {
//
//    }

//    public List<WebElement> getAllTraineesQualityGateStatusElements() {
//
//    }

//    public List<WebElement> getAllTraineesFirstNames() {
//
//    }

//    public List<WebElement> getAllTraineesLastNames() {
//
//    }

//    public List<WebElement> getAllTraineesQualityGateStatus() {
//
//    }

//    public WebElement getTraineeElement(int rowID) {
//
//    }

//    public WebElement getTraineeFirstNameElement(int rowID) {
//
//    }

//    public WebElement getTraineeLastNameElement(int rowID) {
//
//    }

//    public String getTraineeFirstName(int rowID) {
//
//    }

//    public String getTraineeLastName(int rowID) {
//
//    }

//    public WebElement getTraineeQualityGateStatusElement(int rowID) {
//
//    }

//    public String getTraineeQualityGateStatus(int rowID) {
//
//    }

//    public WebElement getQualityGateHistoryDetailsElement(int rowID) {
//
//    }

//    public String getQualityGateHistoryDetails(int rowID) {
//
//    }

//    public List<WebElement> getCoursesElements() {
//
//    }

//    public List<String> getCoursesWithinFilter() {
//
//    }

//    public void applyCourseFilter(String courseName) {
//
//    }

//    public AddTraineesPage clickAddTrainee() {
//
//    }

//    public EditTraineesPage clickEditTrainee(int rowID) {
//
//    }

//    public void clickDeleteTrainee(int rowID) {
//
//    }

//    public AddQualityGatePage clickAddQualityGate(int rowID) {
//
//    }

//    public boolean isQualityGateStatusPassed() {
//
//    }

//    public boolean isQualityGateStatusPending() {
//
//    }

//    public boolean isQualityGateStatusFailed() {
//
//    }

//    public boolean isQualityGateStatusFailedNeedsHelp() {
//
//    }

//    public boolean isTraineeFirstNameValid() {
//
//    }

//    public boolean isTraineeLastNameValid() {
//
//    }

//    public boolean areAllTraineesFirstNamesValid() {
//
//    }

//    public boolean areAllTraineesLastNamesValid() {
//
//    }

//    public boolean isTraineeQualityGateStatusValid() {
//
//    }

//    public boolean areCoursesUnique() {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
