package com.spartaglobal.finalweek.tests.courseTests;

import com.spartaglobal.finalweek.pages.NavTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CourseTests extends NavTemplate {

    @BeforeEach
    public void setup() {

    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
