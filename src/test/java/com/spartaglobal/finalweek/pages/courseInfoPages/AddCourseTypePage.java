package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCourseTypePage extends NavTemplate implements URLable {

    @FindBy(id = "course-type-name") WebElement courseTypeName;
    @FindBy(id = "btn-primary") WebElement submitButton;

    public AddCourseTypePage() {
        PageFactory.initElements(webDriver, this);
    }

//    public void enterCourseTypeName(String courseName) {
//
//    }

//    public boolean isCourseTypeNameValid() {
//
//    }

//    public boolean isCourseTypeNameEmpty() {
//
//    }

//    public boolean isTraineeGenerated() {
//
//    }

//    public boolean submitSuccessful() {
//
//    }

//    public CourseInfoPage goToCourseInfoPage() {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
