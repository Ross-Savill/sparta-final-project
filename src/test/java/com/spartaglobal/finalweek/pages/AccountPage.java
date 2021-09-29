package com.spartaglobal.finalweek.pages;

import com.spartaglobal.finalweek.interfaces.URLable;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends NavTemplate implements URLable {

    public AccountPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
