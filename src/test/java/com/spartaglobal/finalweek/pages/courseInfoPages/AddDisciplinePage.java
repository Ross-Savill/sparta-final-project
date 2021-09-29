package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDisciplinePage extends NavTemplate implements URLable {

    @FindBy(id = "discipline-name") WebElement disciplineName;
    @FindBy(id = "discipline-duration") WebElement duration;
    @FindBy(id = "btn-primary") WebElement submitButton;

    public AddDisciplinePage() {
        PageFactory.initElements(webDriver, this);
    }

//    public void enterDisciplineName(String name) {
//
//    }

//    public void enterDuration(int duration) {
//
//    }

//    public boolean submitSuccessful() {
//
//    }

//    public CourseInfoPage goToCourseInfoPage() {
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
