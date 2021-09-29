package com.spartaglobal.finalweek.pages;

import com.spartaglobal.finalweek.interfaces.URLable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends NavTemplate implements URLable {

    @FindBy(id = "username")
    WebElement UserName;
    @FindBy(id = "password")
    WebElement PassWord;
    @FindBy(id = "submit")
    WebElement LoginButton;

    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getUsernameElement() {
        return this.UserName;
    }

    public WebElement getPasswordElement() {
        return this.PassWord;
    }

    public String getUsername() {
        return this.UserName.getAttribute("value");
    }

    public String getPassword() {
        return this.PassWord.getAttribute("value");
    }

    public void enterUsername(String userName) {
        UserName.sendKeys(userName);
    }
    public void enterPassword(String password) {
        PassWord.sendKeys(password);
    }

    public void enterAllFields(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
    }

    public SchedulerPage login(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        return this.goToSchedulerPage();
    }

    public SchedulerPage goToSchedulerPage() {
        LoginButton.click();
        return new SchedulerPage();
    }

    public boolean isLoginSuccessful() {
        if(!this.getURL().contains("login")) {
            return true;
        } else {
            return false;
        }
    }

    public WebElement getErrorMessage() {
        return webDriver.findElement(By.id("invalid-credentials-msg"));
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
