package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class EditCoursesPage extends ModifyCoursePage implements URLable {

    private @FindBy(xpath = "//*[@id=\"edit-course-form\"]/div[2]/span[2]/button/span")
    WebElement numberOfTrainersIncrement;
    private @FindBy (xpath = "//*[@id=\"edit-course-form\"]/div[2]/span[1]/button")
    WebElement numberOfTrainersDecrement;
    private @FindBy (className = "btn-primary")
    WebElement submitButton;

    public void incrementNumberOfTrainers(){
        numberOfTrainersIncrement.click();
    }

    public void decrementNumberOfTrainers(){
        numberOfTrainersDecrement.click();
    }

    public boolean isSubmissionSuccessful(){
        return submitReturnsCoursePage()
                .getURL()
                .equals(PropertiesLoader.getProperties().getProperty("coursesPageURL"));
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public CoursePage submitReturnsCoursePage(){
        clickSubmit();
        return new CoursePage();
    }
}
