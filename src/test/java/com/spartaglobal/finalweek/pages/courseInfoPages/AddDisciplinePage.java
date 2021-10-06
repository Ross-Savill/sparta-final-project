package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class AddDisciplinePage extends NavTemplate implements URLable {

    @FindBy(id = "discipline-name") WebElement disciplineNameTextField;
    @FindBy(id = "discipline-duration") WebElement durationTextField;
    @FindBy(xpath="//input[@type='submit' and @class='btn btn-primary']") WebElement submitButton;


    public AddDisciplinePage() {
        PageFactory.initElements(webDriver, this);
    }

    public String getDisciplineNameTextField() {
        return disciplineNameTextField.getAttribute("value");
    }

    public int getDurationTextField() {
        return Integer.parseInt(durationTextField.getAttribute("value"));
    }

    public void enterDisciplineName(String name) {
        disciplineNameTextField.sendKeys(name);
    }

    public void enterDuration(int duration) {
        String strDuration = String.valueOf(duration);
        durationTextField.sendKeys(strDuration);
    }

    public boolean submitSuccessful() {
        submitButton.click();
        return webDriver.getCurrentUrl().equals(PropertiesLoader.getProperties().getProperty("courseInfoPageURL"));
    }

//    public CourseInfoPage goToCourseInfoPage() {
//        courseInfoPageLink.click();
//        return new CourseInfoPage();
//    }

    public boolean isDisciplineNameValid() {
        String disciplineNameTextFieldAttribute = disciplineNameTextField.getAttribute("value");
        String durationReg = "[a-zA-Z]+";
        return (disciplineNameTextFieldAttribute.matches(durationReg));
    }

    public boolean isDisciplineDurationValid() {
        String durationText = durationTextField.getAttribute("value");
        String regex = "[0-9]+";

        if(durationText.matches(regex)){
            int maxDuration = 1000;
            int minDuration = 0;
            int durationTextInt= Integer.parseInt(durationTextField.getAttribute("value"));

            return durationTextInt >= minDuration && durationTextInt<= maxDuration;
        }
        return false;
    }


    public boolean areAllFieldsValid() {
        return ((isDisciplineDurationValid())&&(isDisciplineNameValid()));
    }

    public boolean isDisciplineNameEmpty() {
        String disciplineTextFieldAttribute = disciplineNameTextField.getAttribute("value");
        return (disciplineTextFieldAttribute.isEmpty());
    }

    public boolean isDisciplineDurationEmpty() {
        String durationTextFieldAttribute = durationTextField.getAttribute("value");
        return (durationTextFieldAttribute.isEmpty());
    }

    public boolean areAllFieldsEmpty() {
        String disciplineTextFieldAttribute = disciplineNameTextField.getAttribute("value");
        String durationTextFieldAttribute = durationTextField.getAttribute("value");

        return (disciplineTextFieldAttribute.isEmpty()&&durationTextFieldAttribute.isEmpty());
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
