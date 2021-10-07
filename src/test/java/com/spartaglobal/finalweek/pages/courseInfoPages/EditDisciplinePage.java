package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EditDisciplinePage extends NavTemplate implements URLable {

    @FindBy(id = "discipline-name") WebElement disciplineNameTextBox;
    @FindBy(id = "discipline-duration") WebElement durationTextBox;
    @FindBy(css = "div.mb-3:nth-child(4) > input:nth-child(1)") WebElement submitButton;
    @FindBy(css = "#remove-discipline-form > div:nth-child(2) > input:nth-child(1)") WebElement removeButton;
    // Increment Duration Button + Decrement Duration Button appear to be the same < Built in to field

    public EditDisciplinePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void enterDisciplineName(String disciplineName) {
        disciplineNameTextBox.clear();
        disciplineNameTextBox.sendKeys(disciplineName);

    }

    public void enterDuration(int duration) {
        durationTextBox.clear();
        String strDuration = String.valueOf(duration);
        durationTextBox.sendKeys(strDuration);
    }

    public boolean isSubmitSuccessful(){
        submitButton.click();
        return webDriver.getCurrentUrl().equals(PropertiesLoader.getProperties().getProperty("courseInfoPageURL"));
    }

    public CourseInfoPage goToCourseInfoPage() {
        return new CourseInfoPage();
    }

    public void clickRemove() {
        removeButton.click();
    }

    public boolean isDisciplineNameValid() {
        String disciplineNameTextFieldAttribute = disciplineNameTextBox.getAttribute("value");
        String durationReg = "[a-zA-Z]+";
        return (disciplineNameTextFieldAttribute.matches(durationReg));
    }

    public boolean isDisciplineDurationValid() {
        webDriver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);
        String durationText = durationTextBox.getAttribute("value");
        String regex = "[0-9]+";

        if(durationText.matches(regex)){
            int maxDuration = 1000;
            int minDuration = 0;
            int durationTextInt= Integer.parseInt(durationTextBox.getAttribute("value"));

            return durationTextInt >= minDuration && durationTextInt<= maxDuration;
        }
        return false;

    }

    public boolean areAllFieldsValid() {
        return(isDisciplineNameValid()&&isDisciplineDurationValid());
    }

    public boolean isDisciplineNameEmpty() {
        return disciplineNameTextBox.getText().isEmpty();
    }

    public boolean isDisciplineDurationEmpty() {
        return durationTextBox.getText().isEmpty();
    }

    public boolean areAllFieldsEmpty() {
        return isDisciplineNameEmpty()&&isDisciplineDurationEmpty();
    }

    public String getDisciplineNameTextField() {
        return disciplineNameTextBox.getAttribute("value");
    }

    public int getDurationTextField() {
        return Integer.parseInt(durationTextBox.getAttribute("value"));
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }


}
