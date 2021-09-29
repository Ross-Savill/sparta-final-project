package com.spartaglobal.finalweek.pages.trainersPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.support.PageFactory;

public class TrainersPage extends NavTemplate implements URLable {

    public TrainersPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
