package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class EditCoursesPage extends ModifyCoursePage implements URLable {

    private @FindBy(xpath = "//*[@id=\"edit-course-form\"]/div[2]/span[1]/button")
    WebElement numberOfTrainersIncrement;
    private @FindBy (xpath = "//*[@id=\"edit-course-form\"]/div[2]/span[2]/button/span")
    WebElement numberOfTrainersDecrement;

    public void incrementNumberOfTrainers(){
        numberOfTrainersIncrement.click();
    }

    public void decrementNumberOfTrainers(){
        numberOfTrainersDecrement.click();
    }
}
