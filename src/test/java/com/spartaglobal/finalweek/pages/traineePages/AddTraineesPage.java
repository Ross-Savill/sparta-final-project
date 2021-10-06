package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddTraineesPage extends NavTemplate implements URLable {

    @FindBy(id = "trainee-course-name") WebElement courseNameDropDown;
    @FindBy(id = "trainee-first-name") WebElement firstNameTextBox;
    @FindBy(id = "trainee-last-name") WebElement lastNameTextBox;
    @FindBy(className = "btn-primary") WebElement submitButton;

    private Select addTraineesCourseDropdown = new Select(webDriver.findElement(By.id("trainee-course-name")));

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
        if(getFirstName().isBlank() && getLastName().isBlank()) {
            return true;
        }
        return false;
    }

    public TraineesPage goToTraineesPage() {
        NavTemplate navTemplate = new NavTemplate();
        return navTemplate.goToTraineesPage();
    }

    public boolean isFirstNameEmpty(){
        if(getFirstName().equals("")) {
            return true;
        }
        System.out.println(getFirstName());
        return false;
    }

    public boolean isLastNameEmpty(){
        if(getLastName().equals("")) {
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

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
