package com.spartaglobal.finalweek.pages.trainersPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTrainersPage extends NavTemplate implements URLable {

    @FindBy(id = "username") WebElement usernameInputField;
    @FindBy(id = "password") WebElement passwordInputField;
    @FindBy(className = "btn-primary") WebElement submitButton;


    public AddTrainersPage() {
        PageFactory.initElements(webDriver, this);
    }

//    public WebElement getUsernameElement() {
//
//    }

//    public WebElement getPasswordElement() {
//
//    }

//    public String getUsername() {
//
//    }

//    public String getPassword() {
//
//    }

//    public void enterUsername(String username) {
//
//    }

//    public void enterPassword(String password) {
//
//    }

//    public SchedulerPage login(String username, String password) {
//
//    }

//    public SchedulerPage clickLoginButton() {
//
//    }

//    public WebElement getErrorMessage() {
//
//    }

//    public boolean isUsernameFieldEmpty() {
//
//    }

//    public boolean isPasswordFieldEmpty() {
//
//    }

//    public boolean areAllFieldsEmpty() {
//
//    }

//    public boolean isUsernameValid() {
//
//    }

//    public boolean isPasswordValid() {
//
//    }

//    public boolean areAllFieldsEmpty() {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
