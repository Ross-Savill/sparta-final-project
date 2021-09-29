package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCourseTypePage extends NavTemplate implements URLable {

    @FindBy(id = "course-type-name") WebElement courseTypeName;
    @FindBy(id = "btn-primary") WebElement submitButton;

    public EditCourseTypePage() {
        PageFactory.initElements(webDriver, this);
    }

//    public void editCourseTypeName(String courseTypeName) {
//
//    }

//    public boolean submitSuccessful() {
//
//    }

//    public CourseInfoPage goToCourseInfoPage() {
//
//    }

//    public boolean isCourseTypeNameValid() {
//
//    }

//    public boolean isCourseTypeNameEmpty() {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
