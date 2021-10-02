package com.spartaglobal.finalweek.tests.traineeTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TraineesTests extends NavTemplate {

    private static String username = PropertiesLoader.getProperties().getProperty("Username");
    private static String password = PropertiesLoader.getProperties().getProperty("Password");
    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private TraineesPage traineesPage;

    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        PageFactory.initElements(webDriver, this);
        loginPage = new LoginPage();
        schedulerPage = new SchedulerPage();
        traineesPage = new TraineesPage();
        loginPage.login(username, password);
        PageFactory.initElements(webDriver, schedulerPage);
        schedulerPage.goToTraineesPage();
        PageFactory.initElements(webDriver, traineesPage);
    }

    @Test
    public void clickDeleteTrainee() {
        System.out.println(traineesPage.areCoursesUnique());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
