package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.support.PageFactory;

public class AddCoursePage extends NavTemplate implements URLable {

    public AddCoursePage() {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
