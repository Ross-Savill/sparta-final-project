package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    private Select addTraineesCourseDropdown = new Select(webDriver.findElement(By.id("edit-trainee-course-name")));

    public AddTraineesPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void setCourseName(String courseName) {
        courseNameDropDown.click();
        addTraineesCourseDropdown.selectByVisibleText(courseName);
    }

    public String getCourseName() {
        return addTraineesCourseDropdown.getFirstSelectedOption().getText();
    }

    public void enterFirstName(String firstName) {
        firstNameTextBox.clear();
        firstNameTextBox.sendKeys(firstName);
    }

    public String getFirstName() {
        return firstNameTextBox.getAttribute("value");
    }

    public String getLastName(){
        return lastNameTextBox.getAttribute("value");
    }

    public void enterLastName(String lastName){
        lastNameTextBox.sendKeys(lastName);
    }

    public void submitTrainee()
    {
        submitButton.click();
    }

    public boolean isSubmitSuccessful(){
        submitTrainee();
        if(getURL().contains("http://localhost:8080/traineePage")) {
            return true;
        }
        return false;
    }

    public TraineesPage goToTraineesPage() {
        return new TraineesPage();
    }

    public boolean isFirstNameEmpty(){
        if(getFirstName() == "") {
            return true;
        }
        return false;
    }

    public boolean isLastNameEmpty(){
        if(getLastName() == "") {
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
        if(getFirstName().matches("^[a-z A-Z 0-9 ,.'-]+$")) {
            return true;
        }
        return false;
    }

    public boolean isLastNameValid(){
        if(getLastName().matches("^[a-z A-Z 0-9 ,.'-]+$")) {
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
