package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDisciplinePage extends NavTemplate implements URLable {

    @FindBy(id = "discipline-name") WebElement disciplineNameTextBox;
    @FindBy(id = "discipline-duration") WebElement durationTextBox;
    @FindBy(css = "div.mb-3:nth-child(4) > input:nth-child(1)") WebElement submitButton;
    @FindBy(css = "#remove-discipline-form > div:nth-child(2) > input:nth-child(1)") WebElement removeButton;
    // Increment Duration Button + Decrement Duration Button appear to be the same < Built in to field

    public EditDisciplinePage() {
        PageFactory.initElements(webDriver, this);
    }

//    public void enterDisciplineName(String disciplineName) {
//
//    }

//    public void enterDuration(int duration) {
//
//    }

//    public void submitSuccessful() {
//
//    }

//    public CourseInfoPage goToCourseInfoPage() {
//
//    }

//    public void clickRemove() {
//
//    }

//    public boolean isDisciplineNameValid() {
//
//    }

//    public boolean isDisciplineDurationValid() {
//
//    }

//    public boolean areAllFieldsValid() {
//
//    }

//    public boolean isDisciplineNameEmpty() {
//
//    }

//    public boolean isDisciplineDurationEmpty() {
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
