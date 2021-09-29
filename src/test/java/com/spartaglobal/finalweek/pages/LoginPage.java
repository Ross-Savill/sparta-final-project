package com.spartaglobal.finalweek.pages;

import com.spartaglobal.finalweek.interfaces.URLable;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends NavTemplate implements URLable {

    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
