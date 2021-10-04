package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddCoursePage extends ModifyCoursePage implements URLable {

    private @FindBy (xpath = "//*[@id=\"add_course_form\"]/div[2]/span[2]/button")
    WebElement numberOfTrainersIncrement;
    private @FindBy (xpath = "//*[@id=\"add_course_form\"]/div[2]/span[1]/button")
    WebElement numberOfTrainersDecrement;

    public void incrementNumberOfTrainers(){
        numberOfTrainersIncrement.click();
    }

    public void decrementNumberOfTrainers(){
        numberOfTrainersDecrement.click();
    }
}
