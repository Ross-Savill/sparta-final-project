package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddCoursePage implements URLable {
    private @FindBy (id = "course_name")
    WebElement courseName;
    private @FindBy (id = "inputButton")
    WebElement submitButton;

    public AddCoursePage() {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public WebElement getCourseNameElement(){
        return this.courseName;
    }

    public String getCourseName(){
        return getCourseNameElement().getAttribute("value");
    }

    public void enterCourseName(String courseName){
        getCourseNameElement().click();
        getCourseNameElement().sendKeys(courseName);
    }

    public boolean isCourseNameEmpty(){
        return getCourseName().isEmpty();
    }

    public boolean isCourseNameBlank(){
        return getCourseName().isBlank();
    }

    public boolean getEmptyErrorMessage(){
        return Boolean.getBoolean(getCourseNameElement().getAttribute("required"));
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
