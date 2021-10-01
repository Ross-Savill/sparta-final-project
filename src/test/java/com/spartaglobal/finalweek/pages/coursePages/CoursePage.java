package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CoursePage implements URLable {

    @FindBy(className = "btn-primary")
    WebElement addCourseButton;

    public CoursePage() {

        PageFactory.initElements(webDriver, this);
    }

    public AddCoursePage clickAddCourseButton(){
        addCourseButton.click();
        return new AddCoursePage();
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
