package com.spartaglobal.finalweek.pages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;



public class AccountPage extends NavTemplate implements URLable {

    @FindBy(id = "newPassword")
    WebElement newPasswordTextField;
    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordTextField;
    @FindBy(id = "submitPassword")
    WebElement submitButton;

    public AccountPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void enterNewPassword(String password){
        newPasswordTextField.sendKeys(password);
    }

    public void enterConfirmPassword(String password){
        confirmPasswordTextField.sendKeys(password);
    }

    public String getNewPasswordTextField() {
        return webDriver.findElement(By.id("newPassword")).getAttribute("value");
    }

    public String getConfirmPasswordTextField() {
        return webDriver.findElement(By.id("confirmPassword")).getAttribute("value");
    }

    public boolean submitSuccessful(){
        submitButton.click();
        return submitButton.isEnabled();
    }

    public boolean isErrorMessageDisplayed(String password, String differentPassword){
        enterNewPassword(password);
        enterConfirmPassword(differentPassword);
        WebElement errorMessage = webDriver.findElement(By.id("message"));

        return errorMessage.isDisplayed();
    }

    public boolean isMatchingPassword(){
        String newPasswordTextFieldAttribute = newPasswordTextField.getAttribute("value");
        String confirmPasswordTextFieldAttribute = confirmPasswordTextField.getAttribute("value");

        return (newPasswordTextFieldAttribute.equals(confirmPasswordTextFieldAttribute));
    }

    public boolean areBothFieldsFilled(){
        String newPasswordTextFieldAttribute = newPasswordTextField.getAttribute("value");
        String confirmPasswordTextFieldAttribute = confirmPasswordTextField.getAttribute("value");

        return (!newPasswordTextFieldAttribute.isEmpty()&&!confirmPasswordTextFieldAttribute.isEmpty());
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
