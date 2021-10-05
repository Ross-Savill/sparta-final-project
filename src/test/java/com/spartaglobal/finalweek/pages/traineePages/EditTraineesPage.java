package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Pattern;

public class EditTraineesPage extends NavTemplate implements URLable {

    @FindBy(id = "edit-trainee-first-name") WebElement firstNameTextBox;
    @FindBy(id = "edit-trainee-last-name") WebElement lastNameTextBox;
    @FindBy(className = "btn-primary") WebElement submitButton;
    private Select editTraineesCourseDropdown = new Select(webDriver.findElement(By.id("edit-trainee-course-name")));

    public EditTraineesPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void selectCourseName(String courseName) {
        editTraineesCourseDropdown.selectByVisibleText(courseName);
    }

    public void enterFirstName(String firstName) {
        firstNameTextBox.clear();
        firstNameTextBox.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameTextBox.clear();
        lastNameTextBox.sendKeys(lastName);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isSubmitSuccessful(String firstName, String lastName) {
        enterFirstName(firstName);
        enterLastName(lastName);
        submitButton.click();
        TraineesPage traineesPage = new TraineesPage();
        PageFactory.initElements(webDriver, traineesPage);
        List<WebElement> allTraineeElements = traineesPage.getAllTraineesElements();
        for(WebElement rowElement : allTraineeElements) {
            int rowNumber = 0;
            String tableFirstName = rowElement.findElement(By.id(rowNumber+"name")).getText();
            String tableLastName = rowElement.findElement(By.id(rowNumber+"surname")).getText();
            if(firstName.equals(tableFirstName) && (lastName.equals(tableLastName))) {
                return true;
            }
        }
        return false;
    }

    public boolean isFirstNameEmpty() {
        if(firstNameTextBox.getAttribute("value").equals("") || firstNameTextBox.getAttribute("value") == null) {
            return true;
        }
        return false;
    }

    public boolean isLastNameEmpty() {
        if(lastNameTextBox.getAttribute("value").equals("") || lastNameTextBox.getAttribute("value") == null) {
            return true;
        }
        return false;
    }

    public boolean areFirstNameAndLastNameEmpty() {
        if(isFirstNameEmpty() && isLastNameEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isFirstNameValid() {
        String firstName = firstNameTextBox.getAttribute("value");
        Pattern regex = Pattern.compile("^[a-zA-Z0-9'-,.]+$");
        return regex.matcher(firstName).find();
    }

    public boolean isLastNameValid() {
        String lastName = lastNameTextBox.getAttribute("value");
        Pattern regex = Pattern.compile("^[a-zA-Z0-9'-,.]+$");
        return regex.matcher(lastName).find();
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
