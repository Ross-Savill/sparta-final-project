package com.spartaglobal.finalweek.pages.centresPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.support.PageFactory;

public class CentresPage extends NavTemplate implements URLable {

    public CentresPage(){
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
