package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class AddDisciplinePage extends NavTemplate implements URLable {

    @FindBy(id = "discipline-name") WebElement disciplineNameTextField;
    @FindBy(id = "discipline-duration") WebElement durationTextField;
    @FindBy(id = "btn-primary") WebElement submitButton;

    public AddDisciplinePage() {
        PageFactory.initElements(webDriver, this);
    }

    public String getDisciplineNameTextField() {
        return webDriver.findElement(By.id("disciplineNameTextField")).getAttribute("value");
    }

    public String getDurationTextField() {
        return webDriver.findElement(By.id("durationTextField")).getAttribute("value");
    }

    public void enterDisciplineName(String name) {
        disciplineNameTextField.sendKeys(name);
    }

    public void enterDuration(String duration) {
        durationTextField.sendKeys(duration);
    }

    public boolean submitSuccessful() {
        submitButton.click();
        return submitButton.isEnabled();
    }

    public CourseInfoPage goToCourseInfoPage() {
        courseInfoPageLink.click();
        return new CourseInfoPage();
    }

    public boolean isDisciplineNameValid() {
        String durationTextFieldAttribute = durationTextField.getAttribute("value");
        String durationReg = "[AZ]{20}";
        return (durationTextFieldAttribute.matches(durationReg));
    }

    public boolean isDisciplineDurationValid() {
        int maxDuration = 1000;
        String durationTextFieldAttribute = durationTextField.getAttribute("value");
        int durationInt = Integer.parseInt(durationTextFieldAttribute);
        return (durationInt<=maxDuration);
    }

    public boolean areAllFieldsValid() {
        return (isDisciplineDurationValid()&&isDisciplineNameValid());
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
